package bo.custom.impl;

import bo.custom.StudentDetailsBO;
import dao.custom.ProgramDAO;
import dao.custom.StudentDAO;
import dao.custom.impl.ProgramDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;


import java.util.ArrayList;
import java.util.List;

public class StudentDetailsBOImpl implements StudentDetailsBO {

    StudentDAO studentDAO = new StudentDAOImpl();
    ProgramDAO programDAO = new ProgramDAOImpl();

    @Override
    public boolean add(StudentDTO studentDTO) {
        return false;
    }

    @Override
    public List<StudentDTO> find() {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(StudentDTO studentDTO) {
        return false;
    }

    @Override
    public String getsId() throws Exception {
        return studentDAO.getsId();
    }

    @Override
    public ArrayList<String> getAllProgramIde() throws Exception {
        return programDAO.getProgramId();

    }


   /* @Override
    public ArrayList<String> getAllProgramIde() throws Exception {
        return ProgramDAO programDAO = new ProgramDAOImpl();
    }*/


   /* @Override
    public ArrayList<String> getAllProgramsName() throws Exception {
       return ProgramDAO programDAO = new ProgramDAOImpl();
    }*/
}
