package dao.custom.impl;

import dao.custom.RegistrationDAO;
import entity.registration_detail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;


import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {


    @Override
    public boolean add(registration_detail entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(registration_detail entity) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<registration_detail> find() {
        return null;
    }
}
