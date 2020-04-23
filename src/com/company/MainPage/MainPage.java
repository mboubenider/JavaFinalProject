//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.MainPage;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainPage {
    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton newCust;
    @FXML
    private JFXButton newOrder;
    @FXML
    private JFXButton invoice;
    @FXML
    private JFXButton employee;

    public MainPage() {
    }

    public void custWindow() throws IOException {
        Parent nextWindow = (Parent)FXMLLoader.load(this.getClass().getResource("..//Customer/Customer.fxml"));
        Stage newstage = (Stage)this.root.getScene().getWindow();
        Scene newscene = new Scene(nextWindow);
        newstage.setScene(newscene);
        newstage.show();
    }

    public void orderWindow() throws IOException {
        Parent nextWindow = (Parent)FXMLLoader.load(this.getClass().getResource("..//Order/Order.fxml"));
        Stage newstage = (Stage)this.root.getScene().getWindow();
        Scene newscene = new Scene(nextWindow);
        newstage.setScene(newscene);
        newstage.show();
    }

    public void invoiceWindow() throws IOException {
        Parent nextWindow = (Parent)FXMLLoader.load(this.getClass().getResource("..//Invoice/Invoice.fxml"));
        Stage newstage = new Stage();
        Scene newscene = new Scene(nextWindow);
        newstage.setScene(newscene);
        newstage.show();
    }

    public void employeeWindow() throws IOException {
        Parent nextWindow = (Parent)FXMLLoader.load(this.getClass().getResource("..//Employee/Employee.fxml"));
        Stage newstage = (Stage)this.root.getScene().getWindow();
        Scene newscene = new Scene(nextWindow);
        newstage.setScene(newscene);
        newstage.show();
    }
}
