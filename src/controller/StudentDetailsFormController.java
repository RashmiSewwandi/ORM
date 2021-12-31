package controller;

import bo.BOFactory;
import bo.custom.StudentBO;
import bo.custom.impl.ProgramBOImpl;
import bo.custom.impl.StudentBOImpl;
import com.jfoenix.controls.JFXButton;
import dao.custom.impl.ProgramDAOImpl;
import dto.ProgramDTO;
import dto.StudentDTO;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class StudentDetailsFormController {
    public TextField lblSid;
    public Label lblDate;
    public Label lblTime;
    public TextField studentName;
    public TextField txtage;

    public ComboBox <String>gender;
    public ComboBox <String>cmbprogramIde;

    public TextField txtcontactNumber;
    public TextField txtAddress;
    public TextField txtEmail;
    public TextField txtprogramName;
    public TextField txtDuration;
    public TextField txtprogramFee;
    public JFXButton btnAdd;
    public JFXButton btnClear;



    StudentBOImpl StudentBO = (StudentBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.STUDENT);
    ProgramBOImpl ProgramBO = (ProgramBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.PROGRAM);



    public void initialize() throws SQLException {
        loadDateAndTime();
        gender();
    }

    private void loadDateAndTime() {

        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));


        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(
                    currentTime.getHour() + " : " + currentTime.getMinute() +
                            " : " + currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void add_On_Action(ActionEvent actionEvent) {
        StudentDTO studentDTO = new StudentDTO(
                lblSid.getText(),
                studentName.getText(),
                txtage.getText(),
                gender.getValue(),
                txtcontactNumber.getText(),
                txtAddress.getText(),
                txtEmail.getText()
        );

        if (StudentBO.add(studentDTO)){
            new Alert(Alert.AlertType.CONFIRMATION,"Programme Added").show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again").show();
        }
    }

    public void clear_On_Action(ActionEvent actionEvent) {


    }

    private void gender() {
        gender.getItems().addAll("Male", "Female");
        gender.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
        }));
    }


}
