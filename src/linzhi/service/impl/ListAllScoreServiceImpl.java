package linzhi.service.impl;

import linzhi.DAO.ScoreManagerDAO;
import linzhi.DAO.impl.ScoreManagerDAOImpl;
import linzhi.bean.Score;
import linzhi.service.ListAllScoreService;

import java.util.List;

/**
 * Created by wanglinzhizhi on 15-4-8.
 */
public class ListAllScoreServiceImpl implements ListAllScoreService {
    @Override
    public List<Score> listAllScore(String email) {
        ScoreManagerDAO scoreManagerDAO =new ScoreManagerDAOImpl();

        return scoreManagerDAO.listAllScore(email);

    }
}
