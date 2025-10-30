package model;

public class Login {
	private String teacher_Id;
	private String pass;

	public Login(String teacher_Id,String pass) {
		this.teacher_Id=teacher_Id;
		this.pass=pass;
	}

	public String getTeacher_Id() {return teacher_Id;}
	public String getPass() {return pass;}



}
