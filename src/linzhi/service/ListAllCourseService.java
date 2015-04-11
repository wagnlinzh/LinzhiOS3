package linzhi.service;

import linzhi.bean.Course;

import java.util.List;

/**
 * Created by wanglinzhizhi on 15-4-10.
 */
public interface ListAllCourseService {
    public List<Course> listAllCourseService(String email);
}
