
package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class StudentDAOImpl implements StudentDAO {


    @Override
    public boolean add(student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(student entity) {
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

        student student = session.get(student.class, s);
        session.delete(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<student> find() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from student ");
        List <student>list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String getsId() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT studentId FROM student ORDER BY studentId DESC";

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
}
