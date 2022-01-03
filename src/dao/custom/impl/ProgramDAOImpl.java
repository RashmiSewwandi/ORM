
package dao.custom.impl;

import dao.custom.ProgramDAO;

import dto.ProgramDTO;
import entity.program;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;


public class ProgramDAOImpl implements ProgramDAO {



    public ArrayList<String> getProgramId() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT programId FROM program ";
        Query query = session.createQuery(hql);
        ArrayList<String> names = (ArrayList<String>) query.list();

        transaction.commit();
        session.close();
        return names;
    }

    @Override
    public List<program> searchPrograms(String value) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM program p WHERE p.programId LIKE ?1");
        query.setParameter(1, '%' + value + '%');
        List list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

      @Override
    public boolean add(program entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(program entity) {
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

        program program = session.get(program.class, s);
        session.delete(program);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<program> find() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from program");
        List <program>list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    public program get(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction t5 = session.beginTransaction();
        program s1 = session.get(program.class, id);
        t5.commit();
        session.close();
        return s1;
    }

    public String getpId() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT programId FROM program ORDER BY programId DESC";

        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        String id = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        try {
            int nextNumber = Integer.parseInt(id.replace("P-", "")) + 1;
            return String.format("P-%03d", nextNumber);
        } catch (NullPointerException exception) {
            return "P-001";
        }
    }

}