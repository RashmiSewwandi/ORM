package dao.custom;

import dto.CustomDTO;

import java.util.ArrayList;

public interface QueryDAO extends StudentDAO{
    ArrayList<CustomDTO> get_all_data()throws Exception;
}
