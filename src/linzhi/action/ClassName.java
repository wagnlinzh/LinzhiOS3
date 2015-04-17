package linzhi.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

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

        System.out.println("classNameAction: className = "+className);


        ActionContext.getContext().getSession().put("className",className);

        return SUCCESS;
    }
}
