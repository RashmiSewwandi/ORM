package bo.custom.impl;

import bo.custom.StudentDetailsBO;
import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dao.custom.impl.ProgramDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import views.tm.StudentTM;


import java.util.ArrayList;
import java.util.List;

public class StudentDetailsBOImpl implements StudentDetailsBO {

    StudentDAOImpl studentDAO=(StudentDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    ProgramDAO programDAO = new ProgramDAOImpl();

    @Override
    public boolean add(StudentDTO studentDTO) {
        return studentDAO.add(new Student(
                studentDTO.getStudentId(),
                studentDTO.getStudentName(),
                studentDTO.getAge(),
                studentDTO.getGender(),
                studentDTO.getContactNumber(),
                studentDTO.getAddress(),
                studentDTO.geteMail()
        ));
    }



    @Override
    public boolean delete(String id) {

        return studentDAO.delete(id);
    }

    @Override
    public boolean update(StudentDTO studentDTO) {
        return studentDAO.update(new Student(
                studentDTO.getStudentId(),
                studentDTO.getStudentName(),
                studentDTO.getAge(),
                studentDTO.getGender(),
                studentDTO.getContactNumber(),
                studentDTO.getAddress(),
                studentDTO.geteMail()
        ));
    }

    @Override
    public String getsId() throws Exception {
        return studentDAO.getsId();
    }


    public ArrayList<String> getAllProgramIde() throws Exception {
        return programDAO.getProgramId();

    }

    @Override
    public ObservableList<StudentTM> find() {
        List<Student>list=studentDAO.find();
        ObservableList<StudentTM> dtoArrayList = FXCollections.observableArrayList();

      //  StudentDTO studentDTO=null;

        for (Student student : list
        ){dtoArrayList.add(new StudentTM(
                student.getStudentId(),
                student.getStudentName(),
                student.getAge(),
                student.getGender(),
                student.getContactNumber(),
                student.getAddress(),
                student.geteMail()

        ));

        }
        return dtoArrayList;
    }

    @Override
    public ArrayList<String> getAllStudentIde() throws Exception {
        return null;
    }

    /*@Override
    public ArrayList<String> getAllStudentIde() throws Exception {
        return studentDAO.getsId();
    }*/


    public Student getStudent(String id) {
        return studentDAO.get(id);
    }
}
