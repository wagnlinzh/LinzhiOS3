package linzhi.service.impl;

import linzhi.DAO.ScoreManagerDAO;
import linzhi.DAO.impl.ScoreManagerDAOImpl;
import linzhi.service.ListAllClassTimeService;

import java.util.List;

/**
 * Created by wanglinzhizhi on 15-4-19.
 */
public class ListAllClassTimeServiceImpl implements ListAllClassTimeService {
    @Override
    public List<Integer> listAllClassTime(String email) {
        ScoreManagerDAO scoreManagerDAO =new ScoreManagerDAOImpl();

        return scoreManagerDAO.listAllClassTime(email);
    }
}
