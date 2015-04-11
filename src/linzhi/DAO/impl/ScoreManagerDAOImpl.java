package linzhi.DAO.impl;

import linzhi.DAO.HibernateUtil.HibernateUtil;
import linzhi.DAO.ScoreManagerDAO;
import linzhi.bean.Course;
import linzhi.bean.Score;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by wanglinzhizhi on 15-4-9.
 */
public class ScoreManagerDAOImpl implements ScoreManagerDAO {
    private Session session;
    private Transaction transaction;

    public ScoreManagerDAOImpl() {
        session = HibernateUtil.getSession();
    }

    @Override
    public List<Score> listAllScore(String email) {

        List<Score> list=null;
        try {
            transaction = session.beginTransaction();

            list= (List<Score>)session.createQuery("from Score ").list();



            transaction.commit();
        } catch (HibernateException e) {
            HibernateUtil.rollback(transaction);
        } finally {
            HibernateUtil.closeSession();
        }
        return list;
    }


    @Override
    public List<Course> listAllCourse(String email) {
        List<Course> list=null;

        try {
            transaction = session.beginTransaction();
//
//            Student stu = (Student)session.createQuery("from Student s where s.email = ?")
//                    .setString(0, email)
//                    .uniqueResult();
//
            list= session.createQuery("from Course ").list();

            transaction.commit();
        } catch (HibernateException e) {
            HibernateUtil.rollback(transaction);
        } finally {
            HibernateUtil.closeSession();
        }
        return list;
    }
}
