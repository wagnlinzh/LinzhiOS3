package linzhi.DAO.impl;

import linzhi.DAO.HibernateUtil.HibernateUtil;
import linzhi.DAO.ScoreManagerDAO;
import linzhi.bean.Course;
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
//    @SuppressWarnings("unchecked")
    public List<Integer> listAllScore(String email) {

        List<Integer> list=null;
        try {
            transaction = session.beginTransaction();

            list=session.createQuery("select score from linzhi.bean.Score").list();


            transaction.commit();
        } catch (HibernateException e) {
            HibernateUtil.rollback(transaction);
        } finally {
            HibernateUtil.closeSession();
        }
        return list;
    }

    @Override
    public List<Integer> listAllClassTime(String email) {
        List<Integer> list=null;
        try {
            transaction = session.beginTransaction();

            list=session.createQuery("select classTimeNum from linzhi.bean.Score").list();


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
