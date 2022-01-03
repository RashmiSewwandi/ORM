
package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Student;
import entity.program;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;


public class StudentDAOImpl implements StudentDAO {


    @Override
    public boolean add(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, s);
        session.delete(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Student> find() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Student ");
        List <Student>list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String getsId() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT studentId FROM Student ORDER BY studentId DESC";

        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        String id = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        try {
            int nextNumber = Integer.parseInt(id.replace("S-", "")) + 1;
            return String.format("S-%03d", nextNumber);
        } catch (NullPointerException exception) {
            return "S-001";
        }
    }

    public Student get(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction t5 = session.beginTransaction();
        Student s1 = session.get(Student.class, id);
        t5.commit();
        session.close();
        return s1;
    }


    @Override
    public ArrayList<String> getStudentId() throws Exception{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT studentId FROM Student ";
        Query query = session.createQuery(hql);
        ArrayList<String> names = (ArrayList<String>) query.list();

        transaction.commit();
        session.close();
        return names;
    }
}
