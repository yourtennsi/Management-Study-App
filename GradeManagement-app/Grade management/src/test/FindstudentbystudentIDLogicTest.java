package test;
import model.FindstudentbystudentIDLogic;
import model.Studentscore;
public class FindstudentbystudentIDLogicTest {

	public static void main(String[]args) {
		FindstudentbystudentIDLogicTestOK();
		FindstudentbystudentIDLogicTestNG();
	}


public static void FindstudentbystudentIDLogicTestOK() {
	FindstudentbystudentIDLogic logic=new FindstudentbystudentIDLogic();
	 Studentscore studentscore =logic.execute(3);

	 if(studentscore!=null) {
		System.out.println("FindstudentbystudentIDLogicTestOK:成功です");

	}

	else {System.out.println("FindstudentbystudentIDLogicTestOK:失敗です");}
}

public static void FindstudentbystudentIDLogicTestNG() {

	FindstudentbystudentIDLogic logic=new FindstudentbystudentIDLogic();
	Studentscore studentscore=logic.execute(234);
	if(studentscore==null) {
		System.out.println("FindstudentbystudentIDLogicTestOK:成功です");

	}

	else {System.out.println("FindstudentbystudentIDLogicTestOK:失敗です");}
}

}

