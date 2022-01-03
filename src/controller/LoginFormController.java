package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {

    public AnchorPane LoginFormContext;
    public TextField txtUserName;
    public PasswordField txtPassword;
    public JFXButton btnlogin;
    public AnchorPane Root;

    public void Login_On_Action(ActionEvent actionEvent) throws IOException {
        if (txtUserName.getText().equals("rashu") & txtPassword.getText().equals("12345")){
            URL resource = getClass().getResource("../views/mainForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) LoginFormContext.getScene().getWindow();
            window.setScene(new Scene(load));
            new Alert(Alert.AlertType.CONFIRMATION, "Save Password..").show();

        }else{
            new Alert(Alert.AlertType.WARNING, "Wrong UserName Or Password..").show();
        }
    }
}
