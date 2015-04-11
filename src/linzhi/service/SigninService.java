package linzhi.service;

import linzhi.bean.Student;

/**
 * Created by wanglinzhizhi on 15-3-20.
 */
public interface SigninService {
    public boolean isSignin(Student student);
    public boolean isSignin(String email,String password);
}
