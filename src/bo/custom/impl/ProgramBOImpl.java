package bo.custom.impl;

import bo.custom.ProgramBO;
import dao.DAOFactory;
import dao.custom.impl.ProgramDAOImpl;
import dto.ProgramDTO;

import entity.program;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import views.tm.ProgramTM;

import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {
    ProgramDAOImpl programDAO=(ProgramDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PROGRAM);

    @Override
    public boolean add(ProgramDTO programDTO) {
        return programDAO.add(new program(
            programDTO.getProgramId(),
                programDTO.getProgramName(),
                programDTO.getDuration(),
                programDTO.getProgramFee()
        ));
    }

    @Override
    public ObservableList<ProgramTM> find() {
        List<program>list=programDAO.find();
        ObservableList<ProgramTM> dtoArrayList = FXCollections.observableArrayList();



        for (program program : list
        ){dtoArrayList.add(new ProgramTM(
                program.getProgramId(),
                program.getProgramName(),
                program.getDuration(),
                program.getProgramFee()
        ));

        }
        return dtoArrayList;
    }


    @Override
    public boolean delete(String id) {
        return programDAO.delete(id);
    }

   @Override
    public boolean update(ProgramDTO programDTO) {
        return programDAO.update(new program(
                programDTO.getProgramId(),
                programDTO.getProgramName(),
                programDTO.getDuration(),
                programDTO.getProgramFee()
        ));
    }

    @Override
    public ArrayList<String> getAllProgramIde() throws Exception {
        return programDAO.getProgramId();
    }


    public ObservableList<ProgramTM> search(String value) {
        List<program> list = programDAO.searchPrograms(value);
        ObservableList<ProgramTM> dtoArrayList = FXCollections.observableArrayList();
        for (program program : list
        ) {
            dtoArrayList.add(new ProgramTM(
                    program.getProgramId(),
                    program.getProgramName(),
                    program.getDuration(),
                    program.getProgramFee()));
        }
        return dtoArrayList;
    }

    @Override
    public program getProgram(String id){
        return programDAO.get(id);
    }



    public String getpId() throws Exception {
        return programDAO.getpId();
    }
}
