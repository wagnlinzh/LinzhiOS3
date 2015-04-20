package linzhi.DAO;

import linzhi.bean.Course;

import java.util.List;

/**
 * Created by wanglinzhizhi on 15-4-9.
 */
public interface ScoreManagerDAO {

    public List<Integer> listAllScore(String email);

    public List<Integer> listAllClassTime(String email);

    public List<Course> listAllCourse(String email);

}
