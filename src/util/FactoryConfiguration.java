package util;

import entity.program;
import entity.Student;
import entity.registration_detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Properties properties =new Properties();
        try {
            properties.load(new FileInputStream("src/hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        org.hibernate.cfg.Configuration configuration=new Configuration().
                addAnnotatedClass(Student.class).addAnnotatedClass(program.class).addAnnotatedClass(registration_detail.class);
        configuration.setProperties(properties);
        sessionFactory=configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
        return(factoryConfiguration==null) ? factoryConfiguration=new FactoryConfiguration() : factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
