//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.Login;

import com.company.DBconnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXSnackbar.SnackbarEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login implements Initializable {
    @FXML
    private JFXPasswordField passwordField;
    @FXML
    private JFXTextField usernameField;
    @FXML
    private JFXButton loginButton;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private JFXSnackbar notification;
    @FXML
    private AnchorPane root;
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public Login() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.loginButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                try {
                    Login.this.login();
                } catch (SQLException var3) {
                    var3.printStackTrace();
                }

            }
        });
    }

    @FXML
    private void login() throws SQLException {
        String userLogin = this.usernameField.getText();
        String pwLogin = this.passwordField.getText();
        this.notification = new JFXSnackbar(this.root);
        Label label = new Label("Username or Password is incorrect, Please try again!");
        this.con = DBconnection.DBcon();
        String loginSQL = "SELECT * FROM Employee WHERE EmpFName = ? and EmpPass = ?";

        try {
            this.preparedStatement = this.con.prepareStatement(loginSQL);
            this.preparedStatement.setString(1, userLogin);
            this.preparedStatement.setString(2, pwLogin);
            this.resultSet = this.preparedStatement.executeQuery();
            if (!this.resultSet.next()) {
                this.notification.enqueue(new SnackbarEvent(label));
            } else {
                System.out.println("Success");
                Parent nextwindow = (Parent)FXMLLoader.load(this.getClass().getResource("..//MainPage/MainPage.fxml"));
                Scene newscene = new Scene(nextwindow);
                Stage newstage = (Stage)this.root.getScene().getWindow();
                newstage.setScene(newscene);
                newstage.show();
            }
        } catch (IOException | SQLException var11) {
            var11.printStackTrace();
        } finally {
            this.preparedStatement.close();
            this.resultSet.close();
            this.con.close();
        }

    }
}
