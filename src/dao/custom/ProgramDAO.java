
package dao.custom;


import dao.SuperDAO;
import entity.program;


import java.util.List;

public interface ProgramDAO extends SuperDAO<program,String> {
    List<program> searchPrograms(String value);



}