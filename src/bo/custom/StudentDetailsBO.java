package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public interface StudentDetailsBO extends SuperBO {
    boolean add(StudentDTO studentDTO);

    List<StudentDTO>find();

    boolean delete(String id);

    boolean update(StudentDTO studentDTO);

    String getsId() throws Exception;

    ArrayList<String> getAllProgramIde()throws Exception;

    // ArrayList<String> getAllProgramIde()throws Exception;
}
