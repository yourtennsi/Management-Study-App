package test;
import java.util.ArrayList;
import java.util.List;

import dao.StudentscoreDAO;
import model.Studentscore;
public class StudentscorefindDAOTest {

	public static void main(String[]args) {
		testfindstudentnameOK();
		testfindstudentnameNG();
	}


	public static void testfindstudentnameOK() {
		List<Studentscore> studentscoreList=new ArrayList<>();
		Studentscore studentscore=new Studentscore();
		StudentscoreDAO dao=new StudentscoreDAO();
		studentscoreList=dao.findstudentname("山田美津");

		if(studentscoreList!=null) {


		System.out.println("testfindstudentnameOK:成功です");
		}

		else {System.out.println(studentscoreList);
		System.out.println("testfindstudentnameOk:失敗です");}
	}

	public static void testfindstudentnameNG() {

		List<Studentscore> studentscoreList=new ArrayList<>();
		Studentscore studentscore=new Studentscore();
		StudentscoreDAO dao=new StudentscoreDAO();
		studentscoreList=dao.findstudentname("伊倉山祐輔");

		if(studentscoreList==null) {
			System.out.println("testfindstudentnameNG:成功です");
		}
		else {System.out.println("testfindstudentnameNG:失敗です");}



		}



}
