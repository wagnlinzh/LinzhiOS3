package linzhi.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import linzhi.bean.ClassDetail;
import linzhi.bean.Course;
import linzhi.bean.Student;
import linzhi.service.ListAllClassTimeService;
import linzhi.service.ListAllClassTypeService;
import linzhi.service.ListAllCourseService;
import linzhi.service.UpdateSCInfo;
import linzhi.service.impl.ListAllClassTimeServiceImpl;
import linzhi.service.impl.ListAllClassTypeServiceImpl;
import linzhi.service.impl.ListAllCourseServiceImpl;
import linzhi.service.impl.UpdateSCInfoImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanglinzhizhi on 15-4-15.
 */
public class ClassName extends ActionSupport {

    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String execute() throws Exception {

//        System.out.println("classNameAction: className = "+className);


        List<ClassDetail> classInfoList=(List<ClassDetail>) ActionContext.getContext()
                .getSession().get("classInfoList");

        //Student email
        Student student = (Student) ActionContext.getContext().getSession().get("userInfo");
        String email = student.getEmail();

        //classTimeNum
        String classTimeNum2=(String)ActionContext.getContext()
                .getSession().get("classTimeNum");
        System.out.println("classTimeNum2 >>>>>>>>>>>>>> "+classTimeNum2);
        int classTimeNum=Integer.parseInt(classTimeNum2) ;

        //classType 1：必修 0：选修
        int classType=0;

        UpdateSCInfo updateSCInfo=new UpdateSCInfoImpl();
        updateSCInfo.updateSCInfo(email,className,classTimeNum,classType);




        ClassDetail classDetail=new ClassDetail();
        classDetail.setClassName(className);
        classDetail.setClassTimeNum(classTimeNum);
        classDetail.setClassType(classType);



        /*
        先遍历一遍，检查在classInfo列表中有没有对应的classInfo.classDetails.classTimeNum == classTime，
        有的话，先删除，然后在在添加，或者用set方法替代掉
        没有的话直接添加对象classDetail
        */

        for(int i=0;i<classInfoList.size();i++){
            int classTimeNumBuf=classInfoList.get(i).getClassTimeNum();
            if(classTimeNum==classTimeNumBuf){
                classInfoList.remove(i);
            }
        }

        classInfoList.add(classDetail);


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



        List<ClassDetail> classInfoList=new ArrayList<>();

        for (int i = 0; i < classTimeList.size(); i++) {

            String courseName = courseList.get(i).getName();
            int course_classTimeNum = classTimeList.get(i);
            int classType=classTypeList.get(i);

            ClassDetail classDetail=new ClassDetail();
            classDetail.setClassName(courseName);
            classDetail.setClassTimeNum(course_classTimeNum);
            classDetail.setClassType(classType);

            classInfoList.add(classDetail);


        }


        for (int i=0;i<classInfoList.size();i++) {

            ClassDetail classDetail=classInfoList.get(i);
            System.out.println("classTimeNum: " +classDetail.getClassTimeNum()+ " >>>>>>>>>>"
                    +"couserName: " + classDetail.getClassName()+">>>>>>>>>>>>>>>"
                    +"classType:" +classDetail.getClassType());
        }
    }
}
