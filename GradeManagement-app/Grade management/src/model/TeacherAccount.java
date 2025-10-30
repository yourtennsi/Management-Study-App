package model;

public class TeacherAccount {
	private String teacher_Id;
	private String pass;
	private String mail;
	private String name;
	private String subject;

	public TeacherAccount(String teacher_Id,String pass,String mail,String name,String subject) {
		this.teacher_Id=teacher_Id;
		this.pass=pass;
		this.mail=mail;
		this.name=name;
		this.subject=subject;
	}

	public String getTeacher_Id() {return teacher_Id;}
	public String getPass() {return pass;}
	public String getMail() {return mail;}
	public String getName() {return name;}
	public String getSubject() {return subject;}




}
