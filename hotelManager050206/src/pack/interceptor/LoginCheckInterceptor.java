package pack.interceptor;

import pack.beans.Admin;

import java.util.Map;

import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//Ȩ�޼�������������ڵ�¼��֤
public class LoginCheckInterceptor 
	extends AbstractInterceptor{
	public String intercept(ActionInvocation invocation)
		throws Exception{
		ActionContext ctx=invocation.getInvocationContext();
		Map session=ctx.getSession();
		Admin admin=(Admin)session.get("admin");
		if(admin!=null){
			return invocation.invoke();
		}
		return Action.LOGIN;
	}
}
