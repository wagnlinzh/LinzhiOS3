package linzhi.DAO.impl;

import linzhi.DAO.HibernateUtil.HibernateUtil;
import linzhi.DAO.ScoreManagerDAO;
import linzhi.bean.Course;
import linzhi.bean.Score;
import linzhi.bean.Student;
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

        List<Integer> list = null;
        try {
            transaction = session.beginTransaction();

            list = session.createQuery("select score from linzhi.bean.Score").list();


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
        List<Integer> list = null;
        try {
            transaction = session.beginTransaction();

            list = session.createQuery("select classTimeNum from linzhi.bean.Score").list();


            transaction.commit();
        } catch (HibernateException e) {
            HibernateUtil.rollback(transaction);
        } finally {
            HibernateUtil.closeSession();
        }
        return list;
    }

    @Override
    public List<Integer> listAllClassType(String email) {
        List<Integer> list = null;
        try {
            transaction = session.beginTransaction();

            list = session.createQuery("select classType from linzhi.bean.Score").list();


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
        List<Course> list = null;

        try {
            transaction = session.beginTransaction();

            list = session.createQuery("from Course ").list();

            transaction.commit();
        } catch (HibernateException e) {
            HibernateUtil.rollback(transaction);
        } finally {
            HibernateUtil.closeSession();
        }
        return list;
    }


    @Override
    public void updateSCInfo(String email, String className, int classTimeNum, int classType) {
        try {
            transaction = session.beginTransaction();

            Student stu = (Student) session.createQuery("from Student s where s.email = ?")
                    .setString(0, email)
                    .uniqueResult();


            Course c = null;
            List<Course> courseList = (List<Course>) session.createQuery("from Course ").list();
            for (int i = 0; i < courseList.size(); i++) {
                String className2 = courseList.get(i).getName();
                if (className2.equals(className)) {/*若原有的Course表中有相应的课程 直接删除中*/
                    session.delete(courseList.get(i));
                } else {              /*若没有，则new出这门课程，出现这种情况是，选修课新加了别的课程*/
                    c = new Course();
                    c.setName(className);
                }
            }


            Score score = new Score();
            score.setStudent(stu);
            score.setCourse(c);
            score.setClassTimeNum(classTimeNum);            /*虽然不互斥，但是也不要一样*/
            score.setClassType(classType);                  /*1:必修          0 ：选修   not null*/
            score.setScore(-1);

            /*在save之前需要先检测一下，是否该选择的课程是在原有的classTimeNum上已经有的，
            * 若有，则先删除原来对应的classTimeNum的记录，更新新的记录
            * 若没有则直接添加*/


            List listClassTimeNum = session.createQuery("select classTimeNum from Score").list();
            boolean flag = false;         //false表示没有相同的classTimeNum
            int hover = -1;                 //位置点
            for (int i = 0; i < listClassTimeNum.size(); i++) {
                if (classTimeNum == (int) listClassTimeNum.get(i)) {
                    flag = true;          //表明存在相同的classTimeNum
                    hover = i;
                }
            }


            if (flag) {/*有相同的classTimeNum，删除对应的SC表中的那一条记录，并在最后新增加一条*/

                List<Score> scoreList = (List<Score>) session.createQuery("from Score ").list();

                Score score1 = scoreList.get(hover);

                session.delete(score1);


            }
            /*没有相同的记录则直接更新，或删除之后都需要增加这条记录*/
            session.save(score);


            transaction.commit();
        } catch (HibernateException e) {
            HibernateUtil.rollback(transaction);
        } finally {
            HibernateUtil.closeSession();
        }
    }
}
