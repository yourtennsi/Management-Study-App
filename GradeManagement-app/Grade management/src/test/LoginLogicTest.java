package test;
import model.Login;
import model.LoginLogic;

public class LoginLogicTest {
	public static void main(String[]args) {
		testExecuteOK();
		testExecuteNG();
	}

	public static void testExecuteOK() {
		Login login=new Login("yamada","yama12");
		LoginLogic bo=new LoginLogic();
		boolean isloginlogic=bo.execute(login);
		if(isloginlogic) {
			System.out.println("testExecuteOK：成功しました");

		}
		else {System.out.println("testExecuteOK:失敗しました");

		}
	}

	public static void testExecuteNG() {
		Login login=new Login("oohasi","oo34");
		LoginLogic bo=new LoginLogic();
		boolean isloginlogic=bo.execute(login);
		if(!isloginlogic) {
			System.out.println("testExecuteNG:成功しました");

		}
		else {System.out.println("testExecuteNg:失敗しました");
	}
}
}
