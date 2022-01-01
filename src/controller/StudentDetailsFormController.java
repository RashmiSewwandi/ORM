package controller;

import bo.BOFactory;
import bo.custom.impl.ProgramBOImpl;
import bo.custom.impl.StudentDetailsBOImpl;
import com.jfoenix.controls.JFXButton;
import dao.custom.impl.ProgramDAOImpl;
import dto.ProgramDTO;
import dto.StudentDTO;
import entity.program;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class StudentDetailsFormController {
    public Label lblDate;
    public Label lblTime;
    public TextField studentName;
    public TextField txtage;
    public ComboBox <String>gender;
    public ComboBox <String>cmbprogramId;

    public TextField txtcontactNumber;
    public TextField txtAddress;
    public TextField txtEmail;

    public TextField txtDuration;
    public TextField txtprogramFee;
    public JFXButton btnAdd;
    public JFXButton btnClear;
    public Label lblsId;

    public TextField txtprogramName;


    StudentDetailsBOImpl studentDetailsBO = (StudentDetailsBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.STUDENT);
    ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.PROGRAM);



    public void initialize() throws SQLException {
        try {
            initializeCmbBox();
        } catch (Exception e) {
            e.printStackTrace();
        }
        genarateNewId();
        loadDateAndTime();
        gender();

        cmbprogramId.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    try {
                        setProgramData(newValue);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });

    }

    private void setProgramData(String newValue) throws SQLException, ClassNotFoundException {
        try {
            program temProgram = programBO.getProgram(newValue);
            txtprogramName.setText(temProgram.getProgramName());
            txtDuration.setText(temProgram.getDuration());
            txtprogramFee.setText(String.valueOf(temProgram.getProgramFee()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeCmbBox() throws Exception {
        ArrayList<String> allProgramName = studentDetailsBO.getAllProgramIde();
        cmbprogramId.setItems(FXCollections.observableArrayList(allProgramName));
    }

    private void loadDateAndTime() {

        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));


        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(
                    currentTime.getHour() + " : " + currentTime.getMinute() +
                            " : " + currentTime.getSecond()); }),
                new KeyFrame(Duration.seconds(1)));

        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void add_On_Action(ActionEvent actionEvent) {
        StudentDTO studentDTO = new StudentDTO(
                lblsId.getText(),
                studentName.getText(),
                txtage.getText(),
                gender.getValue(),
                txtcontactNumber.getText(),
                txtAddress.getText(),
                txtEmail.getText()

        );
        if (studentDetailsBO.add(studentDTO)){
            new Alert(Alert.AlertType.CONFIRMATION,"Programme Added").show();
            genarateNewId();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again").show();
        }
    }

    private void genarateNewId() {
        try {
            lblsId.setText(studentDetailsBO.getsId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear_On_Action(ActionEvent actionEvent) {
        studentName.clear();
        txtage.clear();
        txtcontactNumber.clear();
        txtAddress.clear();
        txtEmail.clear();

    }

    private void gender() {
        gender.getItems().addAll("Male", "Female");
        gender.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
        }));
    }


}
