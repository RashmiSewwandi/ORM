package controller;

import bo.BOFactory;
import bo.custom.impl.ProgramBOImpl;
import com.jfoenix.controls.JFXButton;
import dto.ProgramDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import views.tm.ProgramTM;

public class ProgramFormController {
    public TableView<ProgramTM> tblprogram;
    public TextField txtprogramName;
    public TextField txtduration;

    public TextField txtFee;

    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;

    public TableColumn colpId;
    public TableColumn colpName;
    public TableColumn colduration;
    public TableColumn colfee;
    public Label lblpId;

    ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.PROGRAM);

    public void initialize(){
        genarateNewpId();
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

    private void genarateNewpId() {
        try {
            lblpId.setText(programBO.getpId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void clearField() {

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
            new Alert(Alert.AlertType.CONFIRMATION, "Saved .....").show();
            genarateNewpId();
            showProgramsOnTable();
            clearField();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again .....").show();
        }
    }



    public void update_On_Action(ActionEvent actionEvent)  {
               ProgramDTO programDTO = new ProgramDTO(
                lblpId.getText(),
                txtprogramName.getText(),
                txtduration.getText(),
                Double.parseDouble(txtFee.getText())
                );
        if (programBO.update(programDTO)){
            new Alert(Alert.AlertType.CONFIRMATION, "Updated ......").show();
            showProgramsOnTable();
            clearField();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again ......").show();
        }
    }


    public void delete_On_Action(ActionEvent actionEvent)  {
        ProgramTM program = tblprogram.getSelectionModel().getSelectedItem();
        String id = program.getProgramId();
        if (programBO.delete(id)) {
            new Alert(Alert.AlertType.INFORMATION, "Delete Complete ....").show();
            showProgramsOnTable();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again .....").show();
        }
        clearField();
    }

    public void table_Click_OnAction(MouseEvent mouseEvent) {
        ProgramTM program = null;
        program = tblprogram.getSelectionModel().getSelectedItem();
        lblpId.setText(program.getProgramId());
        txtprogramName.setText(program.getProgramName());
        txtduration.setText(program.getDuration());
        txtFee.setText(String.valueOf(program.getProgramFee()));
    }


}
