package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.student;


import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

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
}
