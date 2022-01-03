package controller;

import bo.BOFactory;
import bo.custom.impl.ProgramBOImpl;
import bo.custom.impl.StudentDetailsBOImpl;
import com.jfoenix.controls.JFXButton;
import dao.custom.impl.ProgramDAOImpl;
import dto.ProgramDTO;
import dto.StudentDTO;
import entity.Student;
import entity.program;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import views.tm.ProgramTM;
import views.tm.StudentTM;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class StudentDetailFormController {
    public Label lblDate;
    public Label lblTime;
    public TextField studentName;
    public TextField txtage;
    public ComboBox <String>cmbprogramId;

    public TextField txtcontactNumber;
    public TextField txtAddress;
    public TextField txtEmail;

    public JFXButton btnAdd;
    public Label lblsId;
    public JFXButton btnUpdate;
    public TableView<StudentTM> tblStudent;
    public TableColumn colsId;
    public TableColumn colgender;
    public TableColumn colContavtNumber;
    public TableColumn colAddress;
    public JFXButton btnDelete;
    public TableColumn colName;
    public TableColumn colDOB;
    public ComboBox <String> cmbgender;
    public TableColumn colemail;


    StudentDetailsBOImpl studentDetailsBO = (StudentDetailsBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.STUDENT);
    ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.PROGRAM);



    public void initialize() throws SQLException {
       /* try {
            initializeCmbBox();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        genarateNewId();
        loadDateAndTime();
        gender();
        showStudentOnTable();

     /*   cmbprogramId.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    try {
                        setProgramData(newValue);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });*/

    }

   /* private void setProgramData(String newValue) throws SQLException, ClassNotFoundException {
        try {
            program temProgram = programBO.getProgram(newValue);
            txtprogramName.setText(temProgram.getProgramName());
            txtDuration.setText(temProgram.getDuration());
            txtprogramFee.setText(String.valueOf(temProgram.getProgramFee()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

  /*  private void initializeCmbBox() throws Exception {
        ArrayList<String> allProgramName = studentDetailsBO.getAllProgramIde();
        cmbprogramId.setItems(FXCollections.observableArrayList(allProgramName));
    }*/

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
                cmbgender.getValue(),
                txtcontactNumber.getText(),
                txtAddress.getText(),
                txtEmail.getText()

        );
        if (studentDetailsBO.add(studentDTO)){
            new Alert(Alert.AlertType.CONFIRMATION,"Programme Added").show();
            showStudentOnTable();
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

    public void clearField() {
        studentName.clear();
        txtage.clear();
        txtcontactNumber.clear();
        txtAddress.clear();
        txtEmail.clear();

    }

    private void gender() {
        cmbgender.getItems().addAll("Male", "Female");
        cmbgender.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
        }));
    }


    public void update_On_Action(ActionEvent actionEvent) {
        StudentDTO studentDTO = new StudentDTO(
                lblsId.getText(),
                studentName.getText(),
                txtage.getText(),
                cmbgender.getValue(),
                txtcontactNumber.getText(),
                txtAddress.getText(),
                txtEmail.getText()

        );
        if (studentDetailsBO.update(studentDTO)){
            new Alert(Alert.AlertType.CONFIRMATION, "Updated ......").show();
            showStudentOnTable();
            clearField();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again ......").show();
        }
    }

    private void showStudentOnTable() {
        ObservableList<StudentTM> list = studentDetailsBO.find();

        colsId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("age"));
        colgender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colContavtNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("eMail"));

        tblStudent.setItems(list);
    }

    public void delete_On_Action(ActionEvent actionEvent) {
        StudentTM student = tblStudent.getSelectionModel().getSelectedItem();
        String id = student.getStudentId();
        if (studentDetailsBO.delete(id)) {
            new Alert(Alert.AlertType.INFORMATION, "Delete Complete ....").show();
            showStudentOnTable();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again .....").show();
        }
        clearField();
    }

    public void table_Click_OnAction(MouseEvent mouseEvent) {
        StudentTM student = null;
        student = tblStudent.getSelectionModel().getSelectedItem();
        lblsId.setText(student.getStudentId());
        studentName.setText(student.getStudentName());
        txtage.setText(student.getAge());
        txtcontactNumber.setText(student.getContactNumber());
        txtAddress.setText(student.getAddress());
        txtEmail.setText(student.geteMail());

    }
}
