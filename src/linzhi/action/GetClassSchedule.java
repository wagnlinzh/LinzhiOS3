package linzhi.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import linzhi.bean.ClassDetail;
import linzhi.bean.Course;
import linzhi.bean.Student;
import linzhi.service.ListAllClassTimeService;
import linzhi.service.ListAllClassTypeService;
import linzhi.service.ListAllCourseService;
import linzhi.service.impl.ListAllClassTimeServiceImpl;
import linzhi.service.impl.ListAllClassTypeServiceImpl;
import linzhi.service.impl.ListAllCourseServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanglinzhizhi on 15-4-19.
 */
public class GetClassSchedule extends ActionSupport {



    @Override
    public String execute() throws Exception {

        Student student = (Student) ActionContext.getContext().getSession().get("userInfo");//登录的时候写入的session的

        String email = student.getEmail();



//      课程名称
        ListAllCourseService listAllCourseService = new ListAllCourseServiceImpl();
        List<Course> courseList = listAllCourseService.listAllCourseService(email);

//      上课时间
        ListAllClassTimeService listAllClassTimeService=new ListAllClassTimeServiceImpl();
        List<Integer> classTimeNumList=listAllClassTimeService.listAllClassTime(email);

//      课程类型
        ListAllClassTypeService listAllClassTypeService=new ListAllClassTypeServiceImpl();
        List<Integer> classTypeList=listAllClassTypeService.listAllClassType(email);


        List<ClassDetail> classInfoList=new ArrayList<ClassDetail>();

        for (int i = 0; i < classTimeNumList.size(); i++) {

            String courseName = courseList.get(i).getName();
            int course_classTimeNum = classTimeNumList.get(i);
            int classType=classTypeList.get(i);

            ClassDetail classDetail=new ClassDetail();
            classDetail.setClassName(courseName);
            classDetail.setClassTimeNum(course_classTimeNum);
            classDetail.setClassType(classType);

            classInfoList.add(classDetail);


        }

//        HttpServletRequest request = ServletActionContext.getRequest();


        ActionContext.getContext().getSession().put("classInfoList",classInfoList);




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


        ListAllClassTypeService listAllClassTypeService=new ListAllClassTypeServiceImpl();
        List<Integer> classTypeList=listAllClassTypeService.listAllClassType(email);


        Map classTimeMap = new HashMap();
        List<ClassDetail> classInfoList=new ArrayList<ClassDetail>();

        for (int i = 0; i < classTimeList.size(); i++) {

            String courseName = courseList.get(i).getName();
            int course_classTimeNum = classTimeList.get(i);
            int classType=classTypeList.get(i);


//            System.out.println(course_classTimeNum);
//            System.out.println(courseName);

//            classTimeMap.put(course_classTimeNum,courseName);
            ClassDetail classDetail=new ClassDetail();
            classDetail.setClassName(courseName);
            classDetail.setClassTimeNum(course_classTimeNum);
            classDetail.setClassType(classType);

            classInfoList.add(classDetail);


        }



        for (int i = 0; i < classInfoList.size(); i++) {

//            String className = (String) classTimeMap.get(classTimeList.get(i));
            ClassDetail classDetail=classInfoList.get(i);
            System.out.println("classTimeNum: " +classDetail.getClassTimeNum()+ " >>>>>>>>>>"
                              +"couserName: " + classDetail.getClassName()+">>>>>>>>>>>>>>>"
                                +"classType:" +classDetail.getClassType());



        }


    }

}
