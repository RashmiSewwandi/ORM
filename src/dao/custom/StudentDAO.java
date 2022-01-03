package dao.custom;


import dao.SuperDAO;
import entity.Student;

import java.util.ArrayList;

public interface StudentDAO extends SuperDAO<Student,String> {

    String getsId()throws Exception;
    public ArrayList<String> getStudentId() throws Exception;

}