package bo;

import bo.custom.impl.ProgramBOImpl;
import bo.custom.impl.RegistrationBOImpl;
import bo.custom.impl.StudentDetailsBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        if (boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }
    public SuperBO getBo(BOTypes boTypes){
        switch (boTypes){
            case STUDENT:
                return new StudentDetailsBOImpl();
            case PROGRAM:
                return new ProgramBOImpl();
            case REGISTRATION_DETAIL:
                return new RegistrationBOImpl();
            default:
                return null;
        }
    }
    public enum BOTypes{
        STUDENT,PROGRAM,REGISTRATION_DETAIL
    }
}
