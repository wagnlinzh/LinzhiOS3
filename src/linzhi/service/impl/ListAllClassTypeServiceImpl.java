package linzhi.service.impl;

import linzhi.DAO.ScoreManagerDAO;
import linzhi.DAO.impl.ScoreManagerDAOImpl;
import linzhi.service.ListAllClassTypeService;

import java.util.List;

/**
 * Created by wanglinzhizhi on 15-4-19.
 */
public class ListAllClassTypeServiceImpl implements ListAllClassTypeService{
    @Override
    public List<Integer> listAllClassType(String email) {
        ScoreManagerDAO scoreManagerDAO =new ScoreManagerDAOImpl();

        return scoreManagerDAO.listAllClassType(email);
    }
}
