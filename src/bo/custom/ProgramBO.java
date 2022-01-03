package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;
import javafx.collections.ObservableList;

import views.tm.ProgramTM;

import java.util.ArrayList;


public interface ProgramBO extends SuperBO {

     boolean add(ProgramDTO programDTO);

     ObservableList<ProgramTM> find();

     boolean delete(String id);

    boolean update(ProgramDTO programDTO);


    ArrayList<String> getAllProgramIde()throws Exception;
}
