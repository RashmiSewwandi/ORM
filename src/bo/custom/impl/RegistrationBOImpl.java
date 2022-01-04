package bo.custom.impl;

import bo.custom.RegistrationBO;
import dao.DAOFactory;
import dao.custom.QueryDAO;
import dao.custom.RegistrationDAO;
import dto.CustomDTO;
import dto.RegistrationDTO;
import entity.Student;
import entity.program;
import entity.registration_detail;

import java.util.ArrayList;


public class RegistrationBOImpl implements RegistrationBO {
    private final RegistrationDAO registerDAO = (RegistrationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.REGISTRATION_DETAIL);
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERYDAO);


    @Override
    public boolean saveReg(RegistrationDTO reg) {
        return registerDAO.add(new registration_detail(new Student(reg.getStudentId()),new program(reg.getProgramId())));
    }

    @Override
    public ArrayList<CustomDTO> get_all_student() throws Exception {
        return queryDAO.get_all_data();
    }
}
