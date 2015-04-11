package linzhi.bean;

/**
 * Created by wanglinzhizhi on 15-4-4.
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateORMappingTest {

    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void beforeClass() {
        //new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    @AfterClass
    public static void afterClass() {
        sessionFactory.close();
    }

    @Test
    public void testSave(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student=new Student ();
        student.setName("alan@me.com");
        student.setPassword("123");
        session.save(student);


        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testLoad(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();



        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testUpdate(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();




        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testDeleteStudent(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();




        session.getTransaction().commit();
        session.close();
    }

}
