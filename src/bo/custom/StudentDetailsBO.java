package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;
import entity.Student;
import javafx.collections.ObservableList;
import views.tm.StudentTM;

import java.util.ArrayList;

public interface StudentDetailsBO extends SuperBO {
    boolean add(StudentDTO studentDTO);

    boolean delete(String id);

    boolean update(StudentDTO studentDTO);

    String getsId() throws Exception;

    ObservableList<StudentTM> find();

     Student getStudent(String id);


    ArrayList<String> getAllStudentIde()throws Exception;
}
