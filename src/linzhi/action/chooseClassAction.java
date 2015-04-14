package linzhi.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by wanglinzhizhi on 15-4-14.
 */
public class chooseClassAction extends ActionSupport {
    private String classTime;

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    @Override
    public String execute() throws Exception {


        System.out.println("classTime: "+classTime);



        return SUCCESS;
    }
}
