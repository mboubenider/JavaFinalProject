//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.Invoice;

import com.company.DBconnection;
import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;

public class Invoice implements Initializable {
    @FXML
    private JFXButton closeBUtton;
    @FXML
    private AnchorPane root;
    @FXML
    private TableView invoiceTable;
    @FXML
    private TableColumn invIDCol;
    @FXML
    private TableColumn invDateCol;
    @FXML
    private TableColumn invCustIDCol;
    @FXML
    private TableColumn invEmpIDCol;
    @FXML
    private TableColumn invProdIDCol;
    @FXML
    private TableColumn invReceipt;

    ObservableList invoiceData = FXCollections.observableArrayList();

    public Invoice() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.invoiceData.clear();
        this.invIDCol.setCellValueFactory(new PropertyValueFactory("invIDCol"));
        this.invDateCol.setCellValueFactory(new PropertyValueFactory("invDateCol"));
        this.invCustIDCol.setCellValueFactory(new PropertyValueFactory("invCustIDCol"));
        this.invEmpIDCol.setCellValueFactory(new PropertyValueFactory("invEmpIDCol"));
        this.invProdIDCol.setCellValueFactory(new PropertyValueFactory("invProdIDCol"));
        this.invReceipt.setCellValueFactory(new PropertyValueFactory("invReceipt"));

        try {
            DBconnection conn = new DBconnection();
            Connection conn1 = DBconnection.DBcon();
            String sql = "SELECT * FROM Orders";
            Statement statement = conn1.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                this.invoiceData.add(new InvoiceTable(resultSet.getString("invIDcol"), resultSet.getString("invDateCol"), resultSet.getString("invCustIDCol"), resultSet.getString("invEmpIDcol"), resultSet.getString("invProdIDCol"),resultSet.getString("receiptNo")));
            }

            this.invoiceTable.setItems(this.invoiceData);
            statement.close();
            conn1.close();
        } catch (SQLException var8) {
            System.err.println("error" + var8);
        }

    }

    public void closeScene(ActionEvent actionEvent) {
        Stage stage = (Stage)this.closeBUtton.getScene().getWindow();
        stage.close();
    }
    public void search (ActionEvent actionEvent) throws IOException {

    }
}
