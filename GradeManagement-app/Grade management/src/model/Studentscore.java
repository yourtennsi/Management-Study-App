package model;


public class Studentscore {

	private int id;
	private String classnum; //CLASS
	private String test_name;
	private String studentname;
	private int japanese;
	private int english;
	private int math;
	private int science;
	private int socialstudies;
	private Integer art;   //任意
	private Integer music;  //任意
	private Integer health;//任意
	private Integer industrialart;//任意
	private Integer homeeconomics;//任意
	private Integer info;//任意
	private int sumscore; //計算処理
	private double avr; //計算処理
	private String rank="未設定"; //計算処理
	private boolean attendance;


public Studentscore() {};

public Studentscore(int id,String classnum,String test_name,String studentname,int  japanese ,int english,int math,int science,int socialstudies,
			Integer art,Integer music,Integer health,Integer industrialart,Integer homeeconomics,Integer info,int sumscore,double avr,String rank,boolean attendance ){

			this.id=id;
			this.classnum=classnum;
			this.test_name=test_name;
			this.studentname=studentname;
			this.japanese=japanese;
			this.english=english;
			this.math=math;
			this.science=science;
			this.socialstudies=socialstudies;
			this.art=art;
			this.music=music;
			this.health=health;
			this.industrialart=industrialart;
			this.homeeconomics=homeeconomics;
			this.info=info;
			this.sumscore=sumscore;
			this.avr=avr;
			this.rank=rank;
			this.attendance=attendance;
}
//id なしのコンストラクター
public Studentscore(String classnum,String test_name,String studentname,int  japanese ,int english,int math,int science,int socialstudies,
		Integer art,Integer music,Integer health,Integer industrialart,Integer homeeconomics,Integer info,boolean attendance){

		this.classnum=classnum;
		this.test_name=test_name;
		this.studentname=studentname;
		this.japanese=japanese;
		this.english=english;
		this.math=math;
		this.science=science;
		this.socialstudies=socialstudies;
		this.art=art;
		this.music=music;
		this.health=health;
		this.industrialart=industrialart;
		this.homeeconomics=homeeconomics;
		this.info=info;
		this.attendance=attendance;
}



//計算処理のための


public Studentscore (int japanese,int english,int math,int science,int socialstudies,Integer art,Integer music,Integer health,Integer industrialart,Integer homeeconomics ,Integer info) {

	this.japanese=japanese;
	this.english=english;
	this.math=math;
	this.science=science;
	this.socialstudies=socialstudies;
	this.art=art;
	this.music=music;
	this.health=health;
	this.industrialart=industrialart;
	this.homeeconomics=homeeconomics;
	this.info=info;

}

public int getId() {return id;}
public void setId(int id) {this.id=id;}
public String getClassnum() {return classnum;}
public String getTest_name() {return test_name;}
public String getStudentname() {return studentname;}
public void setStudentname(String studentname) { this.studentname=studentname;}
public int getJapanese() {return japanese;}
public int getEnglish() {return english;}
public int getMath() {return math;}
public int getScience() {return science;}
public int getSocialstudeies() {return socialstudies;}
public Integer getArt() {return art;}
public Integer getMusic() {return music;}
public Integer getHealth() {return health;}
public Integer getIndustrialart() {return industrialart;}
public Integer getHomeeconomics() {return homeeconomics;}
public Integer getInfo() {return info;}
public int getSumscore() {return sumscore;}
public void setSumscore(int sumscore) {this.sumscore=sumscore;}
public double getAvr() {return avr;}
public void setAvr(double avr) {this.avr=avr;}
public String getRank() {return rank;}
public void setRank(String rank) {this.rank=rank;}
public boolean getAttendance() {return attendance;}


}


