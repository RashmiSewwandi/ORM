
package dao.custom.impl;

import dao.custom.ProgramDAO;
import entity.program;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;


public class ProgramDAOImpl implements ProgramDAO {


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
}