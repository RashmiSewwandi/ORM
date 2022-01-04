package dao.custom.impl;

import dao.custom.QueryDAO;
import dto.CustomDTO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public boolean add(Student entity) {
        return false;
    }

    @Override
    public boolean update(Student entity) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Student> find() {
        return null;
    }

    @Override
    public String getsId() throws Exception {
        return null;
    }

    @Override
    public ArrayList<String> getStudentId() throws Exception {
        return null;
    }

    @Override
    public ArrayList<CustomDTO> get_all_data() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT s.studentId, s.studentName, p.programId, p.programName,p.duration, sp.registrationDate FROM Student s INNER JOIN registration_detail sp ON s.studentId = sp.student INNER JOIN program p ON p.programId = sp.program";
        Query query = session.createQuery(hql);

        List<Object[]> list = query.list();

        transaction.commit();
        session.close();
        ArrayList<CustomDTO> customDTOS = new ArrayList<>();
        for (Object[] objects : list) {
            customDTOS.add(new CustomDTO((String) objects[0],(String) objects[1],(String) objects[2],(String) objects[3],(String) objects[4],(Date) objects[5]));
        }
        return customDTOS;
    }
}
