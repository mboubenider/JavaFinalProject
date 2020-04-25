//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.Order;

import com.company.DBconnection;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Order implements Initializable {
    @FXML
    private JFXComboBox productBox;
    @FXML
    private JFXComboBox custIDbox;
    @FXML
    private JFXComboBox empIDbox;
    @FXML
    private DatePicker Date;
    @FXML
    private Label alertLabel;
    ObservableList custChoice = FXCollections.observableArrayList();
    ObservableList empChoice = FXCollections.observableArrayList();
    ObservableList prodChoice = FXCollections.observableArrayList();
    ObservableList prodPrice = FXCollections.observableArrayList();
    @FXML
    private AnchorPane root;
    @FXML
    private TableView<CustOrderTable> custTable;
    @FXML
    private TableColumn<CustOrderTable, String> custIDCol;
    @FXML
    private TableColumn<CustOrderTable, String> custFName;
    @FXML
    private TableColumn<CustOrderTable, String> custLName;
    ObservableList<CustOrderTable> custData = FXCollections.observableArrayList();
    @FXML
    private TableView<EmpOrderTable> empTable;
    @FXML
    private TableColumn<EmpOrderTable, String> empIDCol;
    @FXML
    private TableColumn<EmpOrderTable, String> empFName;
    @FXML
    private TableColumn<EmpOrderTable, String> empLName;
    ObservableList<EmpOrderTable> empData = FXCollections.observableArrayList();
    @FXML
    private TableView prodTable;
    @FXML
    private TableColumn prodIDCol;
    @FXML
    private TableColumn prodNameCol;
    @FXML
    private TableColumn prodPriceCol;
    ObservableList<ProductTable> prodData = FXCollections.observableArrayList();

    public Order() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void loadCust(ActionEvent actionEvent) {
        this.custData.clear();
        this.custChoice.clear();
        this.custIDCol.setCellValueFactory(new PropertyValueFactory("custIDCol"));
        this.custFName.setCellValueFactory(new PropertyValueFactory("custFName"));
        this.custLName.setCellValueFactory(new PropertyValueFactory("custLName"));

        try {
            DBconnection conn = new DBconnection();
            Connection conn1 = DBconnection.DBcon();
            String sql = "SELECT * FROM Customer";
            Statement statement = conn1.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                this.custData.add(new CustOrderTable(resultSet.getString("CustID"), resultSet.getString("CustFName"), resultSet.getString("CustLName")));
                this.custChoice.add(resultSet.getString("CustID"));
            }

            this.custTable.setItems(this.custData);
            this.custIDbox.setItems(this.custChoice);
            statement.close();
            conn1.close();
        } catch (Exception var7) {
            System.err.println("error" + var7);
        }

    }

    public void loadEmp(ActionEvent actionEvent) {
        this.empData.clear();
        this.empChoice.clear();
        this.empIDCol.setCellValueFactory(new PropertyValueFactory("empIDCol"));
        this.empFName.setCellValueFactory(new PropertyValueFactory("empFName"));
        this.empLName.setCellValueFactory(new PropertyValueFactory("empLName"));

        try {
            DBconnection conn = new DBconnection();
            Connection conn1 = DBconnection.DBcon();
            String sql = "SELECT * FROM Employee";
            Statement statement = conn1.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                this.empData.add(new EmpOrderTable(resultSet.getString("EmpID"), resultSet.getString("EmpFName"), resultSet.getString("EmpLName")));
                this.empChoice.add(resultSet.getString("EmpID"));
            }

            this.empTable.setItems(this.empData);
            this.empIDbox.setItems(this.empChoice);
            statement.close();
            conn1.close();
        } catch (Exception var7) {
            System.err.println("error" + var7);
        }

    }

    public void loadProduct(ActionEvent actionEvent) throws SQLException {
        this.prodData.clear();
        this.prodChoice.clear();
        this.prodPrice.clear();
        this.prodIDCol.setCellValueFactory(new PropertyValueFactory("prodIDCol"));
        this.prodNameCol.setCellValueFactory(new PropertyValueFactory("prodNameCol"));
        DBconnection conn = new DBconnection();
        Connection conn1 = DBconnection.DBcon();
        String sql = "SELECT * FROM Product";
        Statement statement = conn1.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            this.prodData.add(new ProductTable(resultSet.getString("ProductID"), resultSet.getString("ProductName")));
            this.prodChoice.add(resultSet.getString("productID"));
        }

        this.prodTable.setItems(this.prodData);
        this.productBox.setItems(this.prodChoice);
        statement.close();
        conn1.close();
    }

    String uuid = UUID.randomUUID().toString();

    public void createOrder(ActionEvent actionEvent) throws SQLException {
        DBconnection conn = new DBconnection();
        Connection conn1 = DBconnection.DBcon();
        String orderID = uuid;
        String makeOrder = "INSERT INTO Orders (invIDCol, invDateCol, invCustIDCol, invEmpIDCol, invProdIDCol) VALUES (?,?,?,?,?)";
        Statement st = conn1.createStatement();
        String custIDvalues = this.custIDbox.getSelectionModel().getSelectedItem().toString();
        String empIDvalues = this.empIDbox.getSelectionModel().getSelectedItem().toString();
        String prodValues = this.productBox.getSelectionModel().getSelectedItem().toString(); //gets selected ID
        PreparedStatement statement = conn1.prepareStatement(makeOrder);
        statement.setString(1, uuid);
        statement.setString(2, this.Date.getEditor().getText());
        statement.setString(3, custIDvalues);
        statement.setString(4, empIDvalues);
        statement.setString(5, prodValues);

        statement.executeUpdate();
        this.alertLabel.setText("Sucessfully created the Order!");
        st.close();
        //rs.close();
        statement.close();
        conn1.close();
    }

    public void goMain(ActionEvent actionEvent) throws IOException {
        Parent nextWindow = (Parent)FXMLLoader.load(this.getClass().getResource("..//MainPage/MainPage.fxml"));
        Stage newstage = (Stage)this.root.getScene().getWindow();
        Scene newscene = new Scene(nextWindow);
        newstage.setScene(newscene);
        newstage.show();
    }

    public void goCustomer(ActionEvent actionEvent) throws IOException {
        Parent nextWindow = (Parent)FXMLLoader.load(this.getClass().getResource("..//Customer/Customer.fxml"));
        Stage newstage = (Stage)this.root.getScene().getWindow();
        Scene newscene = new Scene(nextWindow);
        newstage.setScene(newscene);
        newstage.show();
    }

    public void goEmployee(ActionEvent actionEvent) throws IOException {
        Parent nextWindow = (Parent)FXMLLoader.load(this.getClass().getResource("..//Employee/Employee.fxml"));
        Stage newstage = (Stage)this.root.getScene().getWindow();
        Scene newscene = new Scene(nextWindow);
        newstage.setScene(newscene);
        newstage.show();
    }

    public void showInvoice(ActionEvent actionEvent) throws IOException {
        Parent nextWindow = (Parent)FXMLLoader.load(this.getClass().getResource("..//Invoice/Invoice.fxml"));
        Stage newstage = new Stage();
        Scene newscene = new Scene(nextWindow);
        newstage.setScene(newscene);
        newstage.show();
    }
}
