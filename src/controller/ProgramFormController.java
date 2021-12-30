package controller;

import bo.BOFactory;
import bo.custom.ProgramBO;
import bo.custom.impl.ProgramBOImpl;
import com.jfoenix.controls.JFXButton;
import dto.ProgramDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import views.tm.ProgramTM;

import java.sql.SQLException;

public class ProgramFormController {
    public TableView<ProgramTM> tblprogram;
    public TextField txtprogramName;
    public TextField txtduration;
    public TextField txtFee;
    public TextField lblpId;
    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public TableColumn colpId;
    public TableColumn colpName;
    public TableColumn colduration;
    public TableColumn colfee;

    ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.PROGRAM);

    public void initialize(){
        showProgramsOnTable();
    }

    private void showProgramsOnTable() {
        ObservableList<ProgramTM> list = programBO.find();

        colpId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colpName.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colduration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colfee.setCellValueFactory(new PropertyValueFactory<>("programFee"));

        tblprogram.setItems(list);
    }




    private void clearField() {
        lblpId.clear();
        txtprogramName.clear();
        txtduration.clear();
        txtFee.clear();

    }



    public void add_On_Action(ActionEvent actionEvent) {
        ProgramDTO programDTO = new ProgramDTO(
                lblpId.getText(),
                txtprogramName.getText(),
                txtduration.getText(),
                Double.parseDouble(txtFee.getText())
        );
        if (programBO.add(programDTO)) {
            new Alert(Alert.AlertType.CONFIRMATION, "ProgramDTO Add To Database").show();
            showProgramsOnTable();
            clearField();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }

    }



    public void update_On_Action(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
     /*   ProgramTM program = new ProgramDTO(lblpId.getText(),
                txtprogramName.getText(),
                txtduration.getText(),
                Double.parseDouble(txtFee.getText())
                );
        if (customerBO.update(ProgramDTO)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Updated..").show();
            LoadAllProgram();
            clearField();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }*/

    }

    public void delete_On_Action(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    }

}
