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
    public void testSave() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
//
        Student stu = (Student) session.createQuery("from Student s where s.email = ?")
                .setString(0, "alan@me.com")
                .uniqueResult();

//        Student stu = new Student();
//        stu.setName("alan");
//        stu.setEmail("alan@me.com");
//        stu.setPassword("alan");

        Course c = new Course();
        c.setName("计算机网络");

        Score score = new Score();
        score.setStudent(stu);
        score.setCourse(c);
        score.setScore(145);

        score.setClassTimeNum(10);           /*虽然不互斥，但是也不要一样*/
        score.setClassType(1);/*1:必修            0 ：选修*/


        session.save(stu);
        session.save(c);
        session.save(score);
        /*Note：stu，c可以不用调用save，因为score和stu以及c是级联的，所以调用不调用都会保存它们*/

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testSelect() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        Student stu = (Student) session.createQuery("from Student stu where stu.email = ?")
                .setString(0, "alan@me.com")
                .list()
                .get(0);

        /*两者等价*/

        /*
        Student stu1 = (Student)session.createQuery("from Student stu where stu.email = ?")
                .setString(0,"alan@me.com")
                .uniqueResult();
        */
        System.out.println("==========================================================");
        List list = session.createQuery("from Course ").list();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Set set = stu.getCourses();
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("===========================stu.getName()===============================");
        System.out.println(stu.getName());


        System.out.println("============================course.getName()==============================");
        for (Course course : stu.getCourses()) {
            System.out.println(course.getName());
        }


        System.out.println("=============================score.getScore()=============================");
        for (Score score : stu.getScores()) {
            System.out.println(score.getScore());
        }

        System.out.println("=============================score.getClassType()=============================");
        for (Score score : stu.getScores()) {
            System.out.println(score.getClassType());
        }


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

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<Integer> list1 = null;
        list1 = session.createQuery("select score from linzhi.bean.Score").list();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(">>>>>>>>>>>>>>linzhi.Score : " + list1.get(i));
        }


        System.out.println("===========================2015/4/21 before update===============================");
        List<Integer> classTimeNumLists2 = session.createQuery("select classTimeNum from linzhi.bean.Score").list();
        for (int i = 0; i < classTimeNumLists2.size(); i++) {
            System.out.println(">>>>>>>>>>>classTimeNum : " + classTimeNumLists2.get(i));
        }


        String className = "English";
        int classTimeNum = 10;
        int classType = 0;
        Course c = new Course();
        c.setName(className);

        Score score = new Score();
        score.setStudent(stu);
        score.setCourse(c);
        score.setClassTimeNum(classTimeNum);            /*虽然不互斥，但是也不要一样*/
        score.setClassType(classType);                  /*1:必修          0 ：选修   not null*/


            /*在save之前需要先检测一下，是否该选择的课程是在原有的classTimeNum上已经有的，
            * 若有，则先删除原来对应的classTimeNum的记录，更新新的记录
            * 若没有则直接添加*/

        List<Integer> classTimeNumLists = session.createQuery("select classTimeNum from linzhi.bean.Score").list();

        for (int i = 0; i < classTimeNumLists.size(); i++) {
            if (classTimeNum == classTimeNumLists.get(i)) {

                List<Score> list2 = (List<Score>) session.createQuery("from Score").list();
                Score score2 = list2.get(i);
                session.delete(score2);

//  删除的时候把stu表，course表中对应的项目都级联删除了。
//                List<Course> list3=(List<Course>) session.createQuery("from Course").list();
//                Course course3 =list3.get(i);
//                session.delete(course3);

            }
        }

//        session.save(stu);
//        session.save(c);
        session.save(score);

        System.out.println("===========================2015/4/21 after update===============================");
        List<Integer> classTimeNumLists3 = session.createQuery("select classTimeNum from linzhi.bean.Score").list();
        for (int i = 0; i < classTimeNumLists3.size(); i++) {
            System.out.println(">>>>>>>>>>>classTimeNum : " + classTimeNumLists3.get(i));
        }


        session.getTransaction().commit();

        session.close();
    }


    @Test
    public void testUpdate() {
        Session s = sessionFactory.openSession();
        s.beginTransaction();
        Student stu = (Student) s.get(Student.class, "ff8080814c84ccb2014c84ccb4bb0000");
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
    public void testDeleteStudent() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student stu = (Student) session.createQuery("from Student s where s.email = ?")
                .setString(0, "alan@me.com")
                .uniqueResult();

        //test 参数
        String className = "操作系统";
        int classTimeNum = 10;
        int classType = 0;



        Course c=null;
        List<Course> courseList=(List<Course>) session.createQuery("from Course ").list();
        for (int i=0;i<courseList.size();i++){
            String className2=courseList.get(i).getName();
            if(className2.equals(className)){/*若原有的Course表中有相应的课程 直接将这门课程对应的cid，cname放入到sc表中，即下文的score的set中*/
                System.out.println("className2    >>>>>>>>>>>>>>>   "+className2);
                session.delete(courseList.get(i));
            }else{              /*若没有，则new出这门课程，出现这种情况是，选修课新加了别的课程*/
                c = new Course();
                c.setName(className);
            }
        }


        Score score = new Score();
        score.setStudent(stu);
        score.setCourse(c);
        score.setClassTimeNum(classTimeNum);            /*虽然不互斥，但是也不要一样*/
        score.setClassType(classType);                  /*1:必修          0 ：选修   not null*/

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List scoreList1 =  session.createQuery("select score from linzhi.bean.Score").list();
        for (int i = 0; i < scoreList1.size(); i++) {
            System.out.println(">>>>>>>>>>>>>>linzhi.Score : " + scoreList1.get(i));
        }



        System.out.println("===========================2015/4/21 before update===============================");
        List classTimeNumLists2;
        classTimeNumLists2 = session.createQuery("select classTimeNum from linzhi.bean.Score").list();
        for (int i = 0; i < classTimeNumLists2.size(); i++) {
            System.out.println(">>>>>>>>>>>classTimeNum : " + classTimeNumLists2.get(i));
        }




            /*在save之前需要先检测一下，是否该选择的课程是在原有的classTimeNum上已经有的，
            * 若有，则先删除原来对应的classTimeNum的记录，更新新的记录
            * 若没有则直接添加*/

        List listClassTimeNum = session.createQuery("select classTimeNum from Score").list();
        boolean flag = false;         //false表示没有相同的classTimeNum
        int hover=-1;                 //位置点
        for (int i = 0; i < listClassTimeNum.size(); i++) {
            if (classTimeNum == (int)listClassTimeNum.get(i)) {
                flag = true;          //表明存在相同的classTimeNum
                hover=i;
            }
        }

        System.out.println("flag        >>>>>>>>>>>>>       "+flag);

        if (flag) {/*有相同的classTimeNum，删除对应的SC表中的那一条记录，并在最后新增加一条*/

            List<Score> scoreList = (List<Score>) session.createQuery("from Score ").list();

            Score score1 = scoreList.get(hover);

            session.delete(score1);


        }
        /*没有相同的记录则直接更新，或删除之后都需要增加这条记录*/
        session.save(score);




        session.getTransaction().commit();
        session.close();
    }

}
