package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;
import dto.StudentDTO;
import javafx.collections.ObservableList;
import views.tm.ProgramTM;
import views.tm.StudentTM;

import java.util.ArrayList;
import java.util.List;

public interface StudentDetailsBO extends SuperBO {
    boolean add(StudentDTO studentDTO);

    boolean delete(String id);

    boolean update(StudentDTO studentDTO);

    String getsId() throws Exception;

  /*  ArrayList<String> getAllProgramIde()throws Exception;*/



    ObservableList<StudentTM> find();


    ArrayList<String> getAllStudentIde()throws Exception;
}
