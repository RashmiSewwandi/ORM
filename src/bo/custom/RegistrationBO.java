package bo.custom;

import bo.SuperBO;
import dto.CustomDTO;
import dto.RegistrationDTO;
import entity.registration_detail;
import javafx.collections.ObservableList;
import views.tm.RegistrationTM;

import java.util.ArrayList;

public interface RegistrationBO extends SuperBO {
    boolean saveReg(RegistrationDTO reg);

    ArrayList<CustomDTO> get_all_student()throws Exception;
}
