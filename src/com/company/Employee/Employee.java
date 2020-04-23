//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.Employee;

import com.company.DBconnection;
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

public class Employee implements Initializable {
    @FXML
    private Label alertLabel;
    @FXML
    private TableView<EmployeeTable> empTable;
    @FXML
    private TableColumn<EmployeeTable, String> empIDCol;
    @FXML
    private TableColumn<EmployeeTable, String> empFNameCol;
    @FXML
    private TableColumn<EmployeeTable, String> empLNameCol;
    @FXML
    private TableColumn<EmployeeTable, String> empPassCol;
    @FXML
    private TableColumn<EmployeeTable, String> empStreetCol;
    @FXML
    private TableColumn<EmployeeTable, String> empCityCol;
    @FXML
    private TableColumn<EmployeeTable, String> empStateCol;
    @FXML
    private TableColumn<EmployeeTable, String> empZipCol;
    @FXML
    private TableColumn empPhoneCol;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField empFName;
    @FXML
    private JFXTextField empLName;
    @FXML
    private JFXTextField empPass;
    @FXML
    private JFXTextField empStreet;
    @FXML
    private JFXTextField empCity;
    @FXML
    private JFXTextField empState;
    @FXML
    private JFXTextField empZip;
    @FXML
    private JFXTextField Phone;
    ObservableList<EmployeeTable> empData = FXCollections.observableArrayList();

    public Employee() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.empTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                String fName = ((EmployeeTable)Employee.this.empTable.getItems().get(Employee.this.empTable.getSelectionModel().getSelectedIndex())).getEmpFNameCol();
                Employee.this.empFName.setText(fName);
                String lName = ((EmployeeTable)Employee.this.empTable.getItems().get(Employee.this.empTable.getSelectionModel().getSelectedIndex())).getEmpLNameCol();
                Employee.this.empLName.setText(lName);
                String pass = ((EmployeeTable)Employee.this.empTable.getItems().get(Employee.this.empTable.getSelectionModel().getSelectedIndex())).getEmpPassCol();
                Employee.this.empPass.setText(pass);
                String street = ((EmployeeTable)Employee.this.empTable.getItems().get(Employee.this.empTable.getSelectionModel().getSelectedIndex())).getEmpStreetCol();
                Employee.this.empStreet.setText(street);
                String city = ((EmployeeTable)Employee.this.empTable.getItems().get(Employee.this.empTable.getSelectionModel().getSelectedIndex())).getEmpCityCol();
                Employee.this.empCity.setText(city);
                String state = ((EmployeeTable)Employee.this.empTable.getItems().get(Employee.this.empTable.getSelectionModel().getSelectedIndex())).getEmpStateCol();
                Employee.this.empState.setText(state);
                String zip = ((EmployeeTable)Employee.this.empTable.getItems().get(Employee.this.empTable.getSelectionModel().getSelectedIndex())).getEmpZipCol();
                Employee.this.empZip.setText(zip);
                String phone = ((EmployeeTable)Employee.this.empTable.getItems().get(Employee.this.empTable.getSelectionModel().getSelectedIndex())).getEmpPhoneCol();
                Employee.this.Phone.setText(phone);
            }
        });
    }

    public void loadInfo(ActionEvent actionEvent) throws IOException {
        this.empData.clear();
        this.empIDCol.setCellValueFactory(new PropertyValueFactory("empIDCol"));
        this.empFNameCol.setCellValueFactory(new PropertyValueFactory("empFNameCol"));
        this.empLNameCol.setCellValueFactory(new PropertyValueFactory("empLNameCol"));
        this.empPassCol.setCellValueFactory(new PropertyValueFactory("empPassCol"));
        this.empStreetCol.setCellValueFactory(new PropertyValueFactory("empStreetCol"));
        this.empCityCol.setCellValueFactory(new PropertyValueFactory("empCityCol"));
        this.empStateCol.setCellValueFactory(new PropertyValueFactory("empStateCol"));
        this.empZipCol.setCellValueFactory(new PropertyValueFactory("empZipCol"));
        this.empPhoneCol.setCellValueFactory(new PropertyValueFactory("empPhoneCol"));

        try {
            DBconnection conn = new DBconnection();
            Connection conn1 = DBconnection.DBcon();
            String sql = "SELECT * FROM Employee";
            Statement statement = conn1.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                this.empData.add(new EmployeeTable(resultSet.getString("EmpID"), resultSet.getString("EmpFName"), resultSet.getString("EmpLName"), resultSet.getString("EmpPass"), resultSet.getString("EmpStreet"), resultSet.getString("EmpCity"), resultSet.getString("EmpState"), resultSet.getString("EmpZip"), resultSet.getString("Phone")));
            }

            this.empTable.setItems(this.empData);
            statement.close();
            conn1.close();
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }

    String uuid = UUID.randomUUID().toString();

    public void empAddAction(ActionEvent actionEvent) throws SQLException {
        DBconnection conn = new DBconnection();
        Connection conn1 = DBconnection.DBcon();
        String sql = "INSERT INTO Employee (EmpID, EmpFname, EmpLName, EmpPass, EmpStreet, EmpCity, EmpState, EmpZip, Phone) VALUES (?,?,?,?,?,?,?,?,?)";
        String cusID = uuid;
        String fName = this.empFName.getText();
        String lName = this.empLName.getText();
        String pass = this.empPass.getText();
        String street = this.empStreet.getText();
        String city = this.empCity.getText();
        String state = this.empState.getText();
        String zip = this.empZip.getText();
        String phone = this.Phone.getText();
        PreparedStatement statement = conn1.prepareStatement(sql);
        statement.setString(1, cusID);
        statement.setString(2, fName);
        statement.setString(3, lName);
        statement.setString(4, pass);
        statement.setString(5, street);
        statement.setString(6, city);
        statement.setString(7, state);
        statement.setString(8, zip);
        statement.setString(9,phone);
        statement.executeUpdate();
        this.alertLabel.setText("Sucessfully Added!");
        statement.close();
        conn1.close();
        String empty = "";
        this.empFName.setText(empty);
        this.empLName.setText(empty);
        this.empPass.setText(empty);
        this.empStreet.setText(empty);
        this.empCity.setText(empty);
        this.empState.setText(empty);
        this.empZip.setText(empty);
        this.Phone.setText(empty);
    }

    public void empSubmitAction(ActionEvent actionEvent) throws SQLException {
        DBconnection conn = new DBconnection();
        Connection conn1 = DBconnection.DBcon();
        String sql = "UPDATE Employee SET EmpFName=?, EmpLName=?, EmpPass=?, EmpStreet=?, EmpCity=?, EmpState=?, EmpZip=?, Phone=? WHERE EmpID=?";
        String id = ((EmployeeTable)this.empTable.getItems().get(this.empTable.getSelectionModel().getSelectedIndex())).getEmpIDCol();
        String fName = this.empFName.getText();
        String lName = this.empLName.getText();
        String pass = this.empPass.getText();
        String street = this.empStreet.getText();
        String city = this.empCity.getText();
        String state = this.empState.getText();
        String zip = this.empZip.getText();
        String phone = this.Phone.getText();
        PreparedStatement statement = conn1.prepareStatement(sql);
        statement.setString(1, fName);
        statement.setString(2, lName);
        statement.setString(3, pass);
        statement.setString(4, street);
        statement.setString(5, city);
        statement.setString(6, state);
        statement.setString(7, zip);
        statement.setString(8, phone);
        statement.setString(9, id);
        statement.executeUpdate();
        this.alertLabel.setText("Sucessfully Editted!");
        statement.close();
        conn1.close();
        String empty = "";
        this.empFName.setText(empty);
        this.empLName.setText(empty);
        this.empPass.setText(empty);
        this.empStreet.setText(empty);
        this.empCity.setText(empty);
        this.empState.setText(empty);
        this.empZip.setText(empty);
        this.Phone.setText(empty);
    }

    public void loadPastEmp(ActionEvent actionEvent) {
        this.empData.clear();
        this.empIDCol.setCellValueFactory(new PropertyValueFactory("empIDCol"));
        this.empFNameCol.setCellValueFactory(new PropertyValueFactory("empFNameCol"));
        this.empLNameCol.setCellValueFactory(new PropertyValueFactory("empLNameCol"));
        this.empPassCol.setCellValueFactory(new PropertyValueFactory("empPassCol"));
        this.empStreetCol.setCellValueFactory(new PropertyValueFactory("empStreetCol"));
        this.empCityCol.setCellValueFactory(new PropertyValueFactory("empCityCol"));
        this.empStateCol.setCellValueFactory(new PropertyValueFactory("empStateCol"));
        this.empZipCol.setCellValueFactory(new PropertyValueFactory("empZipCol"));
        this.empPhoneCol.setCellValueFactory(new PropertyValueFactory("empPhoneCol"));

        try {
            DBconnection conn = new DBconnection();
            Connection conn1 = DBconnection.DBcon();
            String sql = "SELECT * FROM Archive";
            Statement statement = conn1.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                this.empData.add(new EmployeeTable(resultSet.getString("EmpID"), resultSet.getString("EmpFName"), resultSet.getString("EmpLName"), resultSet.getString("EmpPass"), resultSet.getString("EmpStreet"), resultSet.getString("EmpCity"), resultSet.getString("EmpState"), resultSet.getString("EmpZip"), resultSet.getString("Phone")));
            }

            this.empTable.setItems(this.empData);
            statement.close();
            conn1.close();
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }


    public void archiveEmployee(ActionEvent actionEvent) throws SQLException {

        EmployeeTable obj = empTable.getSelectionModel().getSelectedItem();
        DBconnection conn = new DBconnection();
        Connection conn1 = DBconnection.DBcon();
        String sql =
                "INSERT INTO Archive (EmpID, EmpFname, EmpLName, EmpPass, EmpStreet, EmpCity, EmpState, EmpZip, Phone) SELECT EmpID, EmpFname, EmpLName, EmpPass, EmpStreet, EmpCity, EmpState, EmpZip, Phone FROM Employee WHERE empID ='";
        sql = sql + obj.empIDCol + "'";
        System.out.print(sql);
        String cusID = uuid;
        PreparedStatement statement = conn1.prepareStatement(sql);
        this.alertLabel.setText("Sucessfully Moved!");
        statement.executeUpdate();
        statement.close();
        String id = ((EmployeeTable)this.empTable.getItems().get(this.empTable.getSelectionModel().getSelectedIndex())).getEmpIDCol();
        String sql2 = "DELETE FROM Employee WHERE EmpID=?";
        PreparedStatement s = conn1.prepareStatement(sql2);
        s.setString(1, cusID);
        s.executeUpdate();
        s.close();
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

    public void goOrder(ActionEvent actionEvent) throws IOException {
        Parent nextWindow = (Parent)FXMLLoader.load(this.getClass().getResource("..//Order/Order.fxml"));
        Stage newstage = (Stage)this.root.getScene().getWindow();
        Scene newscene = new Scene(nextWindow);
        newstage.setScene(newscene);
        newstage.show();
    }
}
