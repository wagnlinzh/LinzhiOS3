package linzhi.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by wanglinzhizhi on 15-4-15.
 */
public class CourseTips extends ActionSupport {
    private String classTime;

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    @Override
    public String execute() throws Exception {

        System.out.println("classTime_CourseTips : "+classTime);

        return SUCCESS;
    }
}
