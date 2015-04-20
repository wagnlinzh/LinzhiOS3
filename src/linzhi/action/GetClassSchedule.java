package linzhi.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import linzhi.bean.Course;
import linzhi.bean.Student;
import linzhi.service.ListAllClassTimeService;
import linzhi.service.ListAllCourseService;
import linzhi.service.impl.ListAllClassTimeServiceImpl;
import linzhi.service.impl.ListAllCourseServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanglinzhizhi on 15-4-19.
 */
public class GetClassSchedule extends ActionSupport {



    @Override
    public String execute() throws Exception {

//        System.out.println("===============3==================");
        Student student = (Student) ActionContext.getContext().getSession().get("userInfo");
//        System.out.println("email is " + student.getEmail());

        String email = student.getEmail();



//      课程名称
        ListAllCourseService listAllCourseService = new ListAllCourseServiceImpl();
        List<Course> courseList = listAllCourseService.listAllCourseService(email);

//      上课时间
        ListAllClassTimeService listAllClassTimeService=new ListAllClassTimeServiceImpl();
        List<Integer> classTimeList=listAllClassTimeService.listAllClassTime(email);

        Map classTimeMap = new HashMap();

        for (int i = 0; i < classTimeList.size(); i++) {

            int course_classTimeNum = (int) classTimeList.get(i);
            String courseName = courseList.get(i).getName();
            System.out.println(courseName);
            System.out.println(course_classTimeNum);
            classTimeMap.put(course_classTimeNum,courseName);

        }

        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("classTime_courseMap", classTimeMap);

        request.setAttribute("classTimeList",classTimeList);


        return SUCCESS;
    }

    public static void main(String[] args) {

        String email = "alan@me.com";
//      课程名称
        ListAllCourseService listAllCourseService = new ListAllCourseServiceImpl();
        List<Course> courseList = listAllCourseService.listAllCourseService(email);

//      上课时间
        ListAllClassTimeService listAllClassTimeService=new ListAllClassTimeServiceImpl();
        List<Integer> classTimeList=listAllClassTimeService.listAllClassTime(email);


        Map classTimeMap = new HashMap();

        for (int i = 0; i < classTimeList.size(); i++) {

            int course_classTimeNum = classTimeList.get(i);
            String courseName = courseList.get(i).getName();

            System.out.println(course_classTimeNum);
            System.out.println(courseName);

            classTimeMap.put(course_classTimeNum,courseName);
        }

        for (int i = 0; i < classTimeMap.size(); i++) {

            String className = (String) classTimeMap.get(classTimeList.get(i));

            System.out.println("classTimeNum: " +classTimeList.get(i)+ " >>>>>>>>>>"
                              +"couserName: " + className);
        }
    }

}
