package linzhi.bean;

/**
 * Created by wanglinzhizhi on 15-4-4.
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HibernateORMappingTest2 {

    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void beforeClass() {
        //new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
        //sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

        Configuration configuration = new Configuration();
        configuration.configure();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);


    }

    @AfterClass
    public static void afterClass() {
        sessionFactory.close();
    }

    @Test
    public void testSave(){

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student stu= (Student)session.createQuery("from Student s where s.email = ?")
                .setString(0, "alan@me.com")
                .uniqueResult();

//        Student stu = new Student();
//        stu.setName("alan");
//        stu.setEmail("alan@me.com");
//        stu.setPassword("alan");

        Course c = new Course();
        c.setName("数理统计与概率论");

        Score score = new Score();
        score.setStudent(stu);
        score.setCourse(c);
        score.setScore(88);



        session.save(stu);
        session.save(c);
        session.save(score);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testSelect(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        Student stu = (Student)session.createQuery("from Student stu where stu.email = ?")
                .setString(0,"alan@me.com")
                .list()
                .get(0);

        /*两者等价*/

        /*
        Student stu1 = (Student)session.createQuery("from Student stu where stu.email = ?")
                .setString(0,"alan@me.com")
                .uniqueResult();
        */
        System.out.println("==========================================================");
        List list= session.createQuery("from Course ").list();
        for (int i=0;i< list.size();i++){
            System.out.println(list.get(i));
        }

        Set set=stu.getCourses();
        Iterator itr=set.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("===========================stu.getName()===============================");
        System.out.println(stu.getName());


        System.out.println("============================course.getName()==============================");
        for(Course course:stu.getCourses()){
            System.out.println(course.getName());
        }



//      这种方式的操作是对应于set的操作方式
        System.out.println("=============================score.getScore()=============================");
        for (Score score:stu.getScores()) {
            System.out.println(score.getScore());
        }

        session.getTransaction().commit();
        session.close();

        System.out.println("==========================================================");

//        4/10
//        List<Map> list=null;

//        Map<String,Integer> course_score_Map = new HashMap<>();
//        Set<Score> scoreSet=stu.getScores();
//        Set<Course> courseSet=stu.getCourses();
//
//        Iterator courseIterator= courseSet.iterator();
//        Iterator scoreIterator=scoreSet.iterator();
//
//        while (scoreIterator.hasNext()&&courseIterator.hasNext()){
//            Course course=(Course)courseIterator.next();
//            Score score=(Score)scoreIterator.next();
//            course_score_Map.put(course.getName(),score.getScore());
//            list.add(course_score_Map);
//        }
//
//        for (int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }

    }


    @Test
    public void testUpdate(){
        Session s = sessionFactory.openSession();
        s.beginTransaction();
        Student stu = (Student)s.get(Student.class, "ff8080814c84ccb2014c84ccb4bb0000");
        s.getTransaction().commit();
        s.close();

        stu.setName("Tom");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(stu);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testDeleteStudent(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student stu = (Student)session.get(Student.class, "ff8080814c84ccb2014c84ccb4bb0000");
        session.delete(stu);
        session.getTransaction().commit();
        session.close();
    }

}
