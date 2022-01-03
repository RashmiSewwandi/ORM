package controller;

import bo.BOFactory;
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
import java.util.ArrayList;

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
    public TextField txtprogramName;
    public TextField txtduration;
    public TextField txtFee;
    public ComboBox <String>cmbpId;
    public JFXButton btnAdd;
    public JFXButton btnDelete;
    public Label lblDate;

    StudentDetailsBOImpl studentDetailsBO = (StudentDetailsBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.STUDENT);
    ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.PROGRAM);


    public void initialize() {
        showRegistrationOnTable();
        try {
            initializeCmbBox();
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
    }

    private void setStudentData(String newValue) {
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

    private void initializeCmbBox() throws Exception {
        ArrayList<String> allProgramName = programBO.getAllProgramIde();
        cmbpId.setItems(FXCollections.observableArrayList(allProgramName));

        ArrayList<String> allStudentName = studentDetailsBO.getAllStudentIde();
        cmbpId.setItems(FXCollections.observableArrayList(allProgramName));
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
}
