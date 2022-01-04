package dao;

import dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        if (daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case STUDENT:
                return new StudentDAOImpl();
            case PROGRAM:
                return new ProgramDAOImpl();
            case REGISTRATION_DETAIL:
                return new RegistrationDAOImpl();
            case QUERYDAO:
               return new QueryDAOImpl();
            default:
                return null;
        }
    }
    public enum DAOTypes{
        STUDENT,PROGRAM,REGISTRATION_DETAIL,QUERYDAO
    }
}
