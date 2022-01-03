package controller;

import bo.BOFactory;
import bo.custom.ProgramBO;
import bo.custom.StudentDetailsBO;
import bo.custom.impl.ProgramBOImpl;
import bo.custom.impl.StudentDetailsBOImpl;
import com.jfoenix.controls.JFXButton;
import entity.Student;
import entity.program;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import views.tm.RegistrationTM;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistrationFormController {
    public TableView <RegistrationTM>tblRegistration;
    public TableColumn colsId;
    public TableColumn colstudentName;
    public TableColumn colprogramId;
    public TableColumn colprogramName;
    public TableColumn colDuration;
    public TableColumn colDate;

    public TextField txtstudentName;
    public TextField txtcontactNumber;
    public TextField txtAddress;
    public ComboBox<String> cmbsId;
    public ComboBox <String>cmbpId;
    public TextField txtprogramName;
    public TextField txtduration;
    public TextField txtFee;
    public JFXButton btnAdd;
    public JFXButton btnDelete;
    public Label lblDate;


    StudentDetailsBO studentDetailsBO = (StudentDetailsBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.STUDENT);
    ProgramBO programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.PROGRAM);


    public void initialize() {




        showRegistrationOnTable();
        loadDate();
        try {
            ProgramId();
            StudentId();
        } catch (Exception e) {
            e.printStackTrace();
        }


                cmbpId.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    try {
                        setProgramData(newValue);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });

                cmbsId.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    try {
                        setStudentData(newValue);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });
    }

    private void setStudentData(String newValue) throws SQLException, ClassNotFoundException {
        try {
            Student temStudent = studentDetailsBO.getStudent(newValue);
            txtstudentName.setText(temStudent.getStudentName());
            txtcontactNumber.setText(temStudent.getContactNumber());
            txtAddress.setText(temStudent.getAddress());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setProgramData(String newValue) throws SQLException, ClassNotFoundException {
        try {
            program temProgram = programBO.getProgram(newValue);
            txtprogramName.setText(temProgram.getProgramName());
            txtduration.setText(temProgram.getDuration());
            txtFee.setText(String.valueOf(temProgram.getProgramFee()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ProgramId() throws Exception {
        ArrayList<String> allProgramName = programBO.getAllProgramIde();
        cmbpId.setItems(FXCollections.observableArrayList(allProgramName));

    }
    private void StudentId() throws Exception {
        ArrayList<String> allStudentName = studentDetailsBO.getAllStudentIde();
        System.out.println(allStudentName.get(0));
        cmbsId.setItems(FXCollections.observableArrayList(allStudentName));
    }

    private void showRegistrationOnTable() {


        colsId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colstudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colprogramId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colprogramName.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));


    }

    public void add_On_Action(ActionEvent actionEvent) {
    }

    public void delete_On_Action(ActionEvent actionEvent) {
    }


    private void loadDate() {

        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));

    }
}
