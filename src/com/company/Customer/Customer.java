//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.Customer;

import com.company.DBconnection;
import com.company.Employee.EmployeeTable;
import com.jfoenix.controls.JFXTextField;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Customer implements Initializable {
    @FXML
    private Label alertLabel;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField custFName;
    @FXML
    private JFXTextField custLName;
    @FXML
    private JFXTextField custStreet;
    @FXML
    private JFXTextField custCity;
    @FXML
    private JFXTextField custState;
    @FXML
    private JFXTextField custZip;
    @FXML
    private JFXTextField custPhone;
    @FXML
    private JFXTextField searchcustomers;
    @FXML
    private TableView<CustomerTable> custTable;
    @FXML
    private TableColumn<CustomerTable, String> custIDCol;
    @FXML
    private TableColumn<CustomerTable, String> custFNameCol;
    @FXML
    private TableColumn<CustomerTable, String> custLNameCol;
    @FXML
    private TableColumn<CustomerTable, String> custAddressCol;
    @FXML
    private TableColumn<CustomerTable, String> custPhoneCol;
    @FXML
    private TableColumn<CustomerTable, String> custCityCol;
    @FXML
    private TableColumn<CustomerTable, String> custStateCol;
    @FXML
    private TableColumn custZipCol;
    ObservableList<CustomerTable> custData = FXCollections.observableArrayList();

    public Customer() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.custTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                String fName = ((CustomerTable)Customer.this.custTable.getItems().get(Customer.this.custTable.getSelectionModel().getSelectedIndex())).getCustFNameCol();
                Customer.this.custFName.setText(fName);
                String lName = ((CustomerTable)Customer.this.custTable.getItems().get(Customer.this.custTable.getSelectionModel().getSelectedIndex())).getCustLNameCol();
                Customer.this.custLName.setText(lName);
                String street = ((CustomerTable)Customer.this.custTable.getItems().get(Customer.this.custTable.getSelectionModel().getSelectedIndex())).getCustAddressCol();
                Customer.this.custStreet.setText(street);
                String city = ((CustomerTable)Customer.this.custTable.getItems().get(Customer.this.custTable.getSelectionModel().getSelectedIndex())).getCustCityCol();
                Customer.this.custCity.setText(city);
                String state = ((CustomerTable)Customer.this.custTable.getItems().get(Customer.this.custTable.getSelectionModel().getSelectedIndex())).getCustStateCol();
                Customer.this.custState.setText(state);
                String zip = ((CustomerTable)Customer.this.custTable.getItems().get(Customer.this.custTable.getSelectionModel().getSelectedIndex())).getCustZipCol();
                Customer.this.custZip.setText(zip);
                String phone = ((CustomerTable)Customer.this.custTable.getItems().get(Customer.this.custTable.getSelectionModel().getSelectedIndex())).getCustPhoneCol();
                Customer.this.custPhone.setText(phone);
            }
        });
    }

    public void loadInfo(ActionEvent actionEvent) {
        this.custData.clear();
        this.custIDCol.setCellValueFactory(new PropertyValueFactory("custIDCol"));
        this.custFNameCol.setCellValueFactory(new PropertyValueFactory("custFNameCol"));
        this.custLNameCol.setCellValueFactory(new PropertyValueFactory("custLNameCol"));
        this.custAddressCol.setCellValueFactory(new PropertyValueFactory("custAddressCol"));
        this.custCityCol.setCellValueFactory(new PropertyValueFactory("custCityCol"));
        this.custStateCol.setCellValueFactory(new PropertyValueFactory("custStateCol"));
        this.custZipCol.setCellValueFactory(new PropertyValueFactory("custZipCol"));
        this.custPhoneCol.setCellValueFactory(new PropertyValueFactory("custPhoneCol"));

        try {
            DBconnection conn = new DBconnection();
            Connection conn1 = DBconnection.DBcon();
            String sql = "SELECT * FROM Customer";
            Statement statement = conn1.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                this.custData.add(new CustomerTable(resultSet.getString("CusNo"), resultSet.getString("CustFName"), resultSet.getString("CustLName"), resultSet.getString("CustStreet"), resultSet.getString("CustCity"), resultSet.getString("CustState"), resultSet.getString("CustZip"), resultSet.getString("CustPhone")));
            }

            this.custTable.setItems(this.custData);
            statement.close();
            conn1.close();
        } catch (Exception var7) {
            System.err.println("Error" + var7);
        }

    }

    public void empDeleteAction(ActionEvent actionEvent) throws SQLException {
        DBconnection conn = new DBconnection();
        Connection conn1 = DBconnection.DBcon();
        String sql = "DELETE FROM Customer WHERE CusNo=?";
        String id = (this.custTable.getItems().get(this.custTable.getSelectionModel().getSelectedIndex())).getCustIDCol();
        PreparedStatement statement = conn1.prepareStatement(sql);
        statement.setString(1, id);
        statement.executeUpdate();
        this.alertLabel.setText("Sucessfully Deleted!");
        statement.close();
        conn1.close();
        String empty = "";
    }


    String uuid = UUID.randomUUID().toString();

    public void custAddAction(ActionEvent actionEvent) {
        try {
            DBconnection conn = new DBconnection();
            Connection conn1 = DBconnection.DBcon();
            String sql = "INSERT INTO Customer (CustID, CustFName, CustLName, CustStreet, CustCity, CustState, CustZip, CustPhone) VALUES (?,?,?,?,?,?,?,?)";
            String cusID = uuid;
            String fName = this.custFName.getText();
            String lName = this.custLName.getText();
            String street = this.custStreet.getText();
            String city = this.custCity.getText();
            String state = this.custState.getText();
            String zip = this.custZip.getText();
            String phone = this.custPhone.getText();
            PreparedStatement statement = conn1.prepareStatement(sql);
            statement.setString(1,cusID);
            statement.setString(2, fName);
            statement.setString(3, lName);
            statement.setString(4, street);
            statement.setString(5, city);
            statement.setString(6, state);
            statement.setString(7, zip);
            statement.setString(8, phone);
            statement.executeUpdate();
            this.alertLabel.setText("Sucessfully Added!");
            statement.close();
            conn1.close();
            String empty = "";
            this.custFName.setText(empty);
            this.custLName.setText(empty);
            this.custStreet.setText(empty);
            this.custCity.setText(empty);
            this.custState.setText(empty);
            this.custZip.setText(empty);
            this.custPhone.setText(empty);
        } catch (Exception var14) {
            var14.printStackTrace();
        }

    }

    public void searchCus (ActionEvent actionEvent) throws IOException {
        this.custData.clear();
        this.custIDCol.setCellValueFactory(new PropertyValueFactory("custIDCol"));
        this.custFNameCol.setCellValueFactory(new PropertyValueFactory("custFNameCol"));
        this.custLNameCol.setCellValueFactory(new PropertyValueFactory("custLNameCol"));
        this.custAddressCol.setCellValueFactory(new PropertyValueFactory("custAddressCol"));
        this.custCityCol.setCellValueFactory(new PropertyValueFactory("custCityCol"));
        this.custStateCol.setCellValueFactory(new PropertyValueFactory("custStateCol"));
        this.custZipCol.setCellValueFactory(new PropertyValueFactory("custZipCol"));
        this.custPhoneCol.setCellValueFactory(new PropertyValueFactory("custPhoneCol"));

        try {
            DBconnection conn = new DBconnection();
            Connection conn1 = DBconnection.DBcon();
            String sql = "SELECT * FROM Customer WHERE CustFName ='"+ this.searchcustomers.getText()+"'";
            System.out.println(this.searchcustomers.getText());
            PreparedStatement statement = conn1.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                this.custData.add(new CustomerTable(resultSet.getString("CusNo"), resultSet.getString("CustFName"), resultSet.getString("CustLName"), resultSet.getString("CustStreet"), resultSet.getString("CustCity"), resultSet.getString("CustState"), resultSet.getString("CustZip"), resultSet.getString("CustPhone")));
            }

            this.custTable.setItems(this.custData);
            statement.close();
            conn1.close();
        } catch (Exception var7) {
            var7.printStackTrace();
        }
    }

    public void custSubmitAction(ActionEvent actionEvent) throws SQLException {
        DBconnection conn = new DBconnection();
        Connection conn1 = DBconnection.DBcon();
        String sql = "UPDATE Customer SET CustFName=?, CustLName=?, CustStreet=?, CustCity=?, CustState=?, CustZip=?, CustPhone=? WHERE CusNo=?";
        String id = ((CustomerTable)this.custTable.getItems().get(this.custTable.getSelectionModel().getSelectedIndex())).getCustIDCol();
        String fName = this.custFName.getText();
        String lName = this.custLName.getText();
        String street = this.custStreet.getText();
        String city = this.custCity.getText();
        String state = this.custState.getText();
        String zip = this.custZip.getText();
        String phone = this.custPhone.getText();
        PreparedStatement statement = conn1.prepareStatement(sql);
        statement.setString(1, fName);
        statement.setString(2, lName);
        statement.setString(3, street);
        statement.setString(4, city);
        statement.setString(5, state);
        statement.setString(6, zip);
        statement.setString(7, phone);
        statement.setString(8, id);
        statement.executeUpdate();
        this.alertLabel.setText("Sucessfully Saved!");
        this.alertLabel.setVisible(true);
        statement.close();
        conn1.close();
        String empty = "";
        this.custFName.setText(empty);
        this.custLName.setText(empty);
        this.custStreet.setText(empty);
        this.custCity.setText(empty);
        this.custState.setText(empty);
        this.custZip.setText(empty);
        this.custPhone.setText(empty);
    }

    public void goMain(ActionEvent actionEvent) throws IOException {
        Parent nextWindow = (Parent)FXMLLoader.load(this.getClass().getResource("..//MainPage/MainPage.fxml"));
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

    public void goOrder(ActionEvent actionEvent) throws IOException {
        Parent nextWindow = (Parent)FXMLLoader.load(this.getClass().getResource("..//Order/Order.fxml"));
        Stage newstage = (Stage)this.root.getScene().getWindow();
        Scene newscene = new Scene(nextWindow);
        newstage.setScene(newscene);
        newstage.show();
    }
}
