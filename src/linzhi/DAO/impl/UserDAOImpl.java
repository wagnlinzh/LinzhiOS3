package linzhi.DAO.impl;

import linzhi.DAO.HibernateUtil.HibernateUtil;
import linzhi.DAO.UserDAO;
import linzhi.bean.Student;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

/**
 * Created by wanglinzhizhi on 15-4-7.
 */

public class UserDAOImpl implements UserDAO {
    private Session session;
    private Transaction transaction;

    public UserDAOImpl() {
        session = HibernateUtil.getSession();
    }


    /**
     * 将User对象插入到数据库中
     *
     * @param student
     */
    public void create(Student student) {
        try {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (HibernateException e) {
            HibernateUtil.rollback(transaction);
        } finally {
            HibernateUtil.closeSession();
        }
    }


    /**
     * 将User对象删除
     *
     * @param student
     */
    public void delete(Student student) {
        try {
            transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
        } catch (HibernateException e) {
            HibernateUtil.rollback(transaction);
        } finally {
            HibernateUtil.closeSession();
        }

    }


    public Student find(int id) {
        Student student = null;
        try {
            transaction = session.beginTransaction();
            student= (Student ) session.get(Student.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            HibernateUtil.rollback(transaction);
        } finally {
            HibernateUtil.closeSession();
        }
        return student;
    }


    /**
     * 通过id查找用户
     *
     * @param email
     * @param password
     */


//    public User find(String email, String password) {
//        User user = null;
//        try {
//            transaction = session.beginTransaction();
//            String id = (String) session.createQuery("select id from Student student where student.email = email and student.password=password").uniqueResult();
//            user = (User) session.get(User.class, id);
//            transaction.commit();
//        } catch (HibernateException e) {
//            HibernateUtil.rollback(transaction);
//        } finally {
//            HibernateUtil.closeSession();
//        }
//        return user;
//    }





    /**
     * update用户
     *
     * @param student
     */
    public void update(Student student) {
        try {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (HibernateException e) {
            HibernateUtil.rollback(transaction);
        } finally {
            HibernateUtil.closeSession();
        }
    }


//    public boolean check2(Student student){
//        try{
//
//            List list=null;
//
//            transaction = session.beginTransaction();
//
//            list=(List<Student>)getHibernateTemplate().find("from Student stu where stu.email = ? and stu.password=?"
//                            , student.getName() , student.getPassword());
//
//            transaction.commit();
//
//            if (!list.isEmpty()) {
//                return true;
//            }
//
//        }catch (HibernateException e){
//            HibernateUtil.rollback(transaction);
//        }finally {
//            HibernateUtil.closeSession();
//        }
//        return false;
//    }


    @Override
    public boolean check(Student student) {
        try{
            String real_pass=null;
            transaction = session.beginTransaction();
            Query query = session.createQuery("select stu.password from Student stu where stu.email = '" + student.getEmail()+"'");
            real_pass=(String) query.uniqueResult();
            transaction.commit();
            if ((!real_pass.isEmpty()) && real_pass.equals(student.getPassword())){
                return true;
            }

        }
        catch (HibernateException e) {
            HibernateUtil.rollback(transaction);
        } finally {
        HibernateUtil.closeSession();
        }
        return false;
    }

    /**
     *
     *
     * 通过email,password 检查用户登录
     *
     * @param email
     * @param password
     */
    public boolean check(String email, String password) {
        try {

            List list = null;

            transaction = session.beginTransaction();


//            Query query = session.createQuery("select stu.password from Student stu where stu.email =:email");
//            Query query = session.createQuery("select stu.password from Student stu where stu.email ='"+email+"'");
            Query query = session.createQuery("select stu.password from Student stu where stu.email =?").setString(0,email);





            list = query.list();
            transaction.commit();

            if (!list.isEmpty()) {
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    String token_pass = (String) iterator.next();
                    System.out.println(token_pass);

                    if (token_pass.equals(password)) {
                        return true;
                    }

                }
            }

        } catch (HibernateException e) {
            HibernateUtil.rollback(transaction);
        } finally {
            HibernateUtil.closeSession();
        }

        return false;
    }

}
