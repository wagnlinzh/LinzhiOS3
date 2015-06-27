package linzhi.service.impl;

import linzhi.DAO.ScoreManagerDAO;
import linzhi.bean.Course;
import linzhi.service.ManagerService;

import java.util.List;

/**
 * Created by wanglinzhizhi on 2015/5/4.
 */
public class ManagerServiceImpl implements ManagerService {
    private ScoreManagerDAO scoreManagerDAO;

    public ScoreManagerDAO getScoreManagerDAO() {
        return scoreManagerDAO;
    }

    public void setScoreManagerDAO(ScoreManagerDAO scoreManagerDAO) {
        this.scoreManagerDAO = scoreManagerDAO;
    }

    @Override
    public void updateSCInfo(String email, String className, int classTimeNum, int classType) {
        scoreManagerDAO.updateSCInfo(email,className, classTimeNum, classType);
    }

    @Override
    public List<Integer> listAllScore(String email) {

        return scoreManagerDAO.listAllScore(email);
    }

    @Override
    public List<Course> listAllCourseService(String email) {
        return (List<Course>)scoreManagerDAO.listAllCourse(email);

    }

    @Override
    public List<Integer> listAllClassType(String email) {
        return scoreManagerDAO.listAllClassType(email);

    }

    @Override
    public List<Integer> listAllClassTime(String email) {
        return scoreManagerDAO.listAllClassTime(email);

    }
}
