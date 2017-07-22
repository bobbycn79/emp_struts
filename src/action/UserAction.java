package action;

import javax.servlet.http.HttpSession;

import dao.IUser;
import entity.User;
import utils.Factory;

public class UserAction extends BaseAction{
	private String username;
	private String password;
	private String number;
	private String errorMsg;

	public String login() {
		//ȡ��session�е���֤��
		String imageCode=(String) session.get("imageCode");
		//System.out.println("ϵͳ���ص���֤��"+imageCode);
		//System.out.println("�û��������֤��"+number);
		//System.out.println(username);
		if(!number.equalsIgnoreCase(imageCode)){
			errorMsg="��֤�벻��ȷ";
			return "fail";
		}
		IUser dao=(IUser) Factory.getInstance("IUser");
		User user=null;
		try {
			user=dao.findByUserName(username);
			if (user==null) {
				errorMsg="�û���������";
				return "fail";
			}else if(!user.getPassword().equals(password)){
				errorMsg="�������";
				return "fail";
			}else{
				session.put("user", user);
				//HttpSession session = request.getSession();
				//session.setAttribute("username", username);//�����û���
				return "ok";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "null";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
