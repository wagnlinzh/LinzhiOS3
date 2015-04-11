package linzhi.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import linzhi.bean.Course;
import linzhi.bean.Score;
import linzhi.bean.Student;
import linzhi.service.ListAllCourseService;
import linzhi.service.ListAllScoreService;
import linzhi.service.impl.ListAllCourseServiceImpl;
import linzhi.service.impl.ListAllScoreServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanglinzhizhi on 15-4-8.
 */
public class checkGradeJspAction extends ActionSupport {

//    private String courseName;
//    private int scoreGet;
//
//    public String getCourseName() {
//        return courseName;
//    }
//
//    public void setCourseName(String courseName) {
//        this.courseName = courseName;
//    }
//
//    public int getScoreGet() {
//        return scoreGet;
//    }
//
//    public void setScoreGet(int scoreGet) {
//        this.scoreGet = scoreGet;
//    }

    @Override
    public String execute() throws Exception {

        System.out.println("===============3==================");
        Student student= (Student)ActionContext.getContext().getSession().get("userInfo");
        System.out.println("email is "+ student.getEmail());

        String email= student.getEmail();



//        课程名称
        ListAllCourseService listAllCourseService=new ListAllCourseServiceImpl();

        List<Course> courseList=listAllCourseService.listAllCourseService(email);

//分数
        ListAllScoreService listAllScoreService=new ListAllScoreServiceImpl();

        List<Score> scoreList= listAllScoreService.listAllScore(email);


        Map map=new HashMap<>();
        List list=new ArrayList<>();
        for (int i=0;i<scoreList.size();i++){

            String courseName=courseList.get(i).getName();
            int course_score=scoreList.get(i).getScore();

            map.put(courseName,course_score);

            list.add(map);
        }

        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("list",list);

        request.setAttribute("CourseList",courseList);

        request.setAttribute("ScoreList",scoreList);


        return SUCCESS;
    }
}
