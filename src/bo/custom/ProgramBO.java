package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;
import javafx.collections.ObservableList;

import views.tm.ProgramTM;



public interface ProgramBO extends SuperBO {

     boolean add(ProgramDTO programDTO);

     ObservableList<ProgramTM> find();

     boolean delete(String id);

    boolean update(ProgramDTO programDTO);

    ObservableList<ProgramTM> search(String value);



}
