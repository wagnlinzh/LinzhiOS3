package linzhi.service;

import linzhi.bean.Course;

import java.util.List;

/**
 * Created by wanglinzhizhi on 2015/5/4.
 */
public interface ManagerService {
    void updateSCInfo(String email, String className, int classTimeNum, int classType);
    List<Integer> listAllScore(String email);
    List<Course> listAllCourseService(String email);
    List<Integer> listAllClassType(String email);
    List<Integer> listAllClassTime(String email);

}
