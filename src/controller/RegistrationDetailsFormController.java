package controller;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import views.tm.ProgramTM;
import views.tm.RegistrationTM;

public class RegistrationDetailsFormController {
    public TableView <RegistrationTM>tblRegistration;
    public TableColumn colsId;
    public TableColumn colstudentName;
    public TableColumn colprogramId;
    public TableColumn colprogramName;
    public TableColumn colDuration;
    public TableColumn colDate;

    public void initialize(){
        showRegistrationOnTable();
    }

    private void showRegistrationOnTable() {
     //   ObservableList<RegistrationTM> list = programBO.find();

        colsId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colstudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colprogramId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colprogramName.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));

       // tblRegistration.setItems(list);
    }

}
