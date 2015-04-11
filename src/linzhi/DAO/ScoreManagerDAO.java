package linzhi.DAO;

import linzhi.bean.Course;
import linzhi.bean.Score;

import java.util.List;

/**
 * Created by wanglinzhizhi on 15-4-9.
 */
public interface ScoreManagerDAO {

    public List<Score> listAllScore(String email);

    public List<Course> listAllCourse(String email);
}
