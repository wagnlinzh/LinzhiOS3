package linzhi.service.impl;

import linzhi.DAO.ScoreManagerDAO;
import linzhi.DAO.impl.ScoreManagerDAOImpl;
import linzhi.bean.Course;
import linzhi.service.ListAllCourseService;

import java.util.List;

/**
 * Created by wanglinzhizhi on 15-4-10.
 */
public class ListAllCourseServiceImpl implements ListAllCourseService {
    ScoreManagerDAO scoreManagerDAO =new ScoreManagerDAOImpl();
    @Override
    public List<Course> listAllCourseService(String email) {
        return scoreManagerDAO.listAllCourse(email);
    }
}
