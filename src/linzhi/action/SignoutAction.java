package linzhi.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by wanglinzhizhi on 15-4-7.
 */
public class SignoutAction extends ActionSupport {
    public String execute() throws Exception {

        ActionContext.getContext().getSession().clear();

        this.addActionError("已 sign out，请重新登录");

        return Action.SUCCESS;
    }
}
