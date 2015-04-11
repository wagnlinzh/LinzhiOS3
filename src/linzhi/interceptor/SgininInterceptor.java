package linzhi.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import linzhi.action.SigninAction;

import java.util.Map;

/**
 * Created by wanglinzhizhi on 15-3-20.
 */
public class SgininInterceptor extends AbstractInterceptor {

    @Override

    public String intercept(ActionInvocation actionInvocation) throws Exception {
        //如果是登录页面，就不用执行拦截作用，不想对LoginAction进行拦截，因而struts提供了获取action的方法，就提供了获取invocation.getAction（）
        if(SigninAction.class == actionInvocation.getAction().getClass())
        {
            return actionInvocation.invoke();
        }

        Map map = actionInvocation.getInvocationContext().getSession();

        if(null == map.get("userInfo"))
        {
            return Action.LOGIN;
        }

        return actionInvocation.invoke();
    }

}
