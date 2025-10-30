package test;
import model.Studentscore;
import model.StudentscorecalcLogic;
public class StudentscorecalcTest {

	public static void main(String[]args) {
		testStudentscorecalcLogicOK();


	}

	public static void testStudentscorecalcLogicOK() {
		Studentscore studentscore=new Studentscore(50,50,50,50,50,50,50,50,50,50,50);
		StudentscorecalcLogic studentscorecalclogic=new StudentscorecalcLogic();
		studentscorecalclogic.execute(studentscore);

		if(studentscore.getSumscore()==550 && studentscore.getAvr()==50.0 && studentscore.getRank().equals("D")) {
			System.out.println("testStudentscorecalcLogicOK：成功です");

		}

		else {System.out.println("testStudentscorecalcLogicOK:失敗です");
		System.out.println(studentscore.getSumscore());
		System.out.println(studentscore.getAvr());
		System.out.println(studentscore.getRank());
		}
	}


	}




