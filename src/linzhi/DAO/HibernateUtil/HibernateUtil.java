package linzhi.DAO.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by wanglinzhizhi on 15-4-7.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private static final ThreadLocal<Session> session=new ThreadLocal<Session>();

    static {

        try{
            sessionFactory=new Configuration().configure().buildSessionFactory();
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("它这里是throwable new ExceptionInInitializerError（ex）");
        }
    }


    /*获取当前session*/
    public static Session getSession() throws HibernateException{
        Session session1=(Session)session.get();

        if ( session1==null || !session1.isOpen() ) {

            session1=sessionFactory.openSession();
            session.set(session1);

        }
        return session1;
    }


    /* 回滚 */
    public static void rollback(Transaction transaction){
        try{
            if (transaction != null){
                transaction.rollback();
            }
        }catch (HibernateException e){
            System.out.println("rollback faild."+ e);
        }
    }



    /*关闭session*/
    public static void closeSession() throws HibernateException{
        Session session1= session.get();
        session.set(null);
        if (session1 !=null) {
            session1.close();
        }
    }
}
