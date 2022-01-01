
package dao.custom;


import dao.SuperDAO;
import dto.ProgramDTO;
import entity.program;


import java.util.ArrayList;
import java.util.List;

public interface ProgramDAO extends SuperDAO<program,String> {
     ArrayList<String> getProgramId() throws Exception;




    List<program> searchPrograms(String value);


   // ArrayList<String> getAllProgramsName()throws Exception;

}