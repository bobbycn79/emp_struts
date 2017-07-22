package intercepter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * login�����������ص�½����
 * ��user �Ƿ����null�����
 * 
 *
 */
public class LoginIntercepter extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//1.��session��ȡ���û���
		Object obj = ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		//2.�ж�obj�Ƿ�Ϊnull
		if(obj !=null){
			//����¼״̬��ִ��action����������
			return invocation.invoke();
		}else{
			//��½״̬ 
			//д�������Ƽ��ɣ����ص�½����
			return "login";
		}
		
	}

	

}
