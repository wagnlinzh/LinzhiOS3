package linzhi.DAO;

import linzhi.bean.Student;

/**
 * Created by wanglinzhizhi on 15-4-7.
 */
public interface UserDAO {



    public void create(Student student);
    public void delete(Student student);
    public Student find(int id);
    public void update(Student student);
    public boolean check(String email,String password);
    public boolean check(Student student);


}
