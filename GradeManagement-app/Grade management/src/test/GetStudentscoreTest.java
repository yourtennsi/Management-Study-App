package test;

import java.util.List;

import model.GetStudentscoreListLogic;
import model.Studentscore;
public class GetStudentscoreTest {

	public static void main(String[]args) {
		testGetStudentscoreLogicOK();
		testGetstudentscoreLogicNG();

	}

	public static void testGetStudentscoreLogicOK() {
		GetStudentscoreListLogic logic=new GetStudentscoreListLogic();
		Studentscore studentscore=new Studentscore();
		List<Studentscore> studentscoreList=logic.execute("安原幸太郎");
		if(studentscoreList!=null) {
			System.out.println(studentscoreList);
			System.out.println("testGetStudentscoretestLogicOK:成功です");
		}
		else {System.out.println("testGetStudentscoretestLogicOK:失敗です");}
	}

	public static void testGetstudentscoreLogicNG() {
		GetStudentscoreListLogic logic=new GetStudentscoreListLogic();
		Studentscore studentscore=new Studentscore();
		List<Studentscore> studentscoreList=logic.execute("住吉猛");
		if(studentscoreList!=null) {
			System.out.println("testGetStudentscoretestLogicNG:成功です");
		}
		else {System.out.println("testGetStudentscoretestLogicNG:失敗です");}
	}





}
