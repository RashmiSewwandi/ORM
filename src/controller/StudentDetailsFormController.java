package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StudentDetailsFormController {
    public TextField lblSid;
    public Label lblDate;
    public Label lblTime;
    public TextField studentName;
    public TextField txtage;
    public ComboBox gender;
    public TextField txtcontactNumber;
    public TextField txtAddress;
    public TextField txtEmail;
    public ComboBox cmbprogramIde;
    public TextField txtprogramName;
    public TextField txtDuration;
    public TextField txtprogramFee;
    public JFXButton btnAdd;
    public JFXButton btnClear;

    public void add_On_Action(ActionEvent actionEvent) {
    }

    public void clear_On_Action(ActionEvent actionEvent) {
    }
}
