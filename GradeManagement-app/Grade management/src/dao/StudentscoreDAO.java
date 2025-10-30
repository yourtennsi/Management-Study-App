package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Studentscore;

public class StudentscoreDAO {
	public final String JDBC_URL="jdbc:h2:tcp://localhost/~/GradeManagement";
	public final String DB_USER="sa";
	public final String DB_PASS="";
//	テーブルにデータを登録する処理
	public boolean testcreate(Studentscore studentscore) {
//		ドライバーを読み込む
		try {Class.forName("org.h2.Driver");}

		catch(ClassNotFoundException e) {throw new IllegalStateException("JDBCドライバーを読み込めませんでした");

		}

//		データベースに接続
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
//			sql文の準備
			String sql="insert into STUDENTSCORE (CLASS,TEST_NAME,STUDENTNAME, JAPANESE, ENGLISH,MATH, SCIENCE,SOCIALSTUDIES,ART,MUSIC,HEALTH,INDUSTRIALART,HOMEECONOMICS, INFO,SUMSCORE,AVR, RANK,ATTENDANCE) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pStmt=conn.prepareStatement(sql);

			pStmt.setString(1, studentscore.getClassnum());
			pStmt.setString(2, studentscore.getTest_name());
			pStmt.setString(3, studentscore.getStudentname());
			pStmt.setInt(4,studentscore.getJapanese() );
			pStmt.setInt(5, studentscore.getEnglish());
			pStmt.setInt(6, studentscore.getMath());
			pStmt.setInt(7, studentscore.getScience());
			pStmt.setInt(8,studentscore.getSocialstudeies());

			if(studentscore.getArt()==null) {
				pStmt.setObject(9, null);
			}
			else {pStmt.setInt(9,studentscore.getArt());

			}

			if(studentscore.getMusic()==null) {
				pStmt.setObject(10,null);
			}
			else {pStmt.setInt(10, studentscore.getMusic());}

			if(studentscore.getHealth()==null) {
				pStmt.setObject(11, null);}
			else {pStmt.setInt(11, studentscore.getHealth());
			}

			if(studentscore.getIndustrialart()==null) {
				pStmt.setObject(12, null);
			}
			else {pStmt.setInt(12, studentscore.getIndustrialart());}

			if(studentscore.getHomeeconomics()==null) {
				pStmt.setObject(13,null);}

			else {pStmt.setInt(13, studentscore.getHomeeconomics());
			}
			if(studentscore.getInfo()==null) {
				pStmt.setObject(14,studentscore.getInfo());
			}
			else {pStmt.setInt(14, studentscore.getInfo());
			}
			pStmt.setInt(15,studentscore.getSumscore());
			pStmt.setDouble(16, studentscore.getAvr());
			pStmt.setString(17, studentscore.getRank());
			pStmt.setBoolean(18,studentscore.getAttendance());


			int result=pStmt.executeUpdate();
			if(result!=1) {
				return false;
			}

		}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		return true;


	}
//テーブルのデータ表示処理
	public List<Studentscore> findstudentname(String studentnoname){
		List<Studentscore>studentscoreList=new ArrayList<>();

//		ドライバーを読み込む
		try {Class.forName("org.h2.Driver");}

		catch(ClassNotFoundException e){throw new IllegalStateException("ドライバーを読み込めませんでした");}
//データベースに接続
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			String sql="select ID,CLASS,TEST_NAME,STUDENTNAME,JAPANESE,ENGLISH,MATH,SCIENCE,SOCIALSTUDIES,ART,MUSIC,HEALTH,INDUSTRIALART,HOMEECONOMICS,INFO,SUMSCORE,AVR,RANK,ATTENDANCE from STUDENTSCORE where STUDENTNAME like ?";

			PreparedStatement pStmt=conn.prepareStatement(sql);

			pStmt.setString(1,"%"+studentnoname+"%");

			ResultSet rs=pStmt.executeQuery();

			while(rs.next()) {
				int id=rs.getInt("ID");
				String classnum=rs.getString("CLASS");
				String test_name=rs.getString("TEST_NAME");
				String studentname=rs.getString("STUDENTNAME");
				int japanese=rs.getInt("JAPANESE");
				int english=rs.getInt("ENGLISH");
				int math=rs.getInt("MATH");
				int science=rs.getInt("SCIENCE");
				int socialstudeis=rs.getInt("SOCIALSTUDIES");
				Integer art=rs.getObject("ART",Integer.class);
				Integer music=rs.getObject("MUSIC",Integer.class);
				Integer health=rs.getObject("HEALTH",Integer.class);
				Integer industrialart=rs.getObject("INDUSTRIALART",Integer.class);
				Integer homeeconomics=rs.getObject("HOMEECONOMICS",Integer.class);
				Integer info=rs.getObject("INFO",Integer.class);
				int sumscore=rs.getInt("SUMSCORE");
				double avr=rs.getDouble("AVR");
				String rank=rs.getString("RANK");
				boolean attendance=rs.getBoolean("ATTENDANCE");
				 Studentscore studentscore=new Studentscore(id,classnum,test_name,studentname,japanese,english,math,science,socialstudeis,art,music,health,industrialart,homeeconomics,info,sumscore,avr,rank,attendance);
				studentscoreList.add(studentscore);
			}

		}	catch(SQLException e) {
				e.printStackTrace();
				return studentscoreList ;
			}
			return studentscoreList;

	}
//テーブルのデータ削除処理
	public boolean testdelite(int studentid) {
//		ドライバーの読み込み
		try {Class.forName("org.h2.Driver");}

		catch(ClassNotFoundException e) {
			throw new IllegalStateException("ドライバーを読み込めませんでした");

		}
//		データベースの接続
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="delete from STUDENTSCORE where ID=?";
			PreparedStatement pStmt=conn.prepareStatement(sql);

			pStmt.setInt(1,studentid);

			int result=pStmt.executeUpdate();

			if(result!=1) {
				return false;
			}

		}catch(SQLException e) {
			e.printStackTrace();
			return false;}

		return true;

	}
//id をもとに編集するための処理
	public Studentscore findstudentbystudentID(int studentid){
		Studentscore studentscore=null;
//		ドライバーを読み込む
		try {Class.forName("org.h2.Driver");}
		catch(ClassNotFoundException e) {
			throw new IllegalStateException("ドライバーを読み込めませんでした");
		}
//		データベースの接続
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			String sql="select ID,CLASS,TEST_NAME,STUDENTNAME,JAPANESE,ENGLISH,MATH,SCIENCE,SOCIALSTUDIES,ART,MUSIC,HEALTH,INDUSTRIALART,HOMEECONOMICS,INFO,SUMSCORE,AVR,RANK,ATTENDANCE from STUDENTSCORE where ID=?";//select*form...

			PreparedStatement pStmt=conn.prepareStatement(sql);
			pStmt.setInt(1,studentid);

			ResultSet rs=pStmt.executeQuery();

			if(rs.next()) {
				int id=rs.getInt("ID");
				String classnum=rs.getString("CLASS");
				String test_name=rs.getString("TEST_NAME");
				String studentname=rs.getString("STUDENTNAME");
				int japanese=rs.getInt("JAPANESE");
				int english=rs.getInt("ENGLISH");
				int math=rs.getInt("MATH");
				int science=rs.getInt("SCIENCE");
				int socialstudeis=rs.getInt("SOCIALSTUDIES");
				Integer art=rs.getObject("ART",Integer.class);
				Integer music=rs.getObject("MUSIC",Integer.class);
				Integer health=rs.getObject("HEALTH",Integer.class);
				Integer industrialart=rs.getObject("INDUSTRIALART",Integer.class);
				Integer homeeconomics=rs.getObject("HOMEECONOMICS",Integer.class);
				Integer info=rs.getObject("INFO",Integer.class);
				int sumscore=rs.getInt("SUMSCORE");
				double avr=rs.getDouble("AVR");
				String rank=rs.getString("RANK");
				boolean attendance=rs.getBoolean("ATTENDANCE");
				studentscore=new Studentscore(id,classnum,test_name,studentname,japanese,english,math,science,socialstudeis,art,music,health,industrialart,homeeconomics,info,sumscore,avr,rank,attendance);


			}
		}
			catch(SQLException e) {
				e.printStackTrace();
				return null;
		}

		return studentscore;


	}
//	idをもとに編集を行う処理

	public boolean testupdate(Studentscore studentscore) {
		int studentid=studentscore.getId();
//	ドライバーの読み込み
		try {Class.forName("org.h2.Driver");

		}
		catch(ClassNotFoundException e) {
			throw new IllegalStateException("ドライバーを読み込めませんでした");
		}

//		データベースの接続
		try (Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			String sql="update STUDENTSCORE set CLASS=?,TEST_NAME=?,STUDENTNAME=?,JAPANESE=?,ENGLISH=?,MATH=?,SCIENCE=?,SOCIALSTUDIES=?,ART=?,MUSIC=?,HEALTH=?,INDUSTRIALART=?,HOMEECONOMICS=?,INFO=?,SUMSCORE=?,AVR=?,RANK=?,ATTENDANCE=? where ID=?";
			PreparedStatement pStmt=conn.prepareStatement(sql);

			pStmt.setString(1, studentscore.getClassnum());
			pStmt.setString(2, studentscore.getTest_name());
			pStmt.setString(3, studentscore.getStudentname());
			pStmt.setInt(4,studentscore.getJapanese() );
			pStmt.setInt(5, studentscore.getEnglish());
			pStmt.setInt(6, studentscore.getMath());
			pStmt.setInt(7, studentscore.getScience());
			pStmt.setInt(8,studentscore.getSocialstudeies());

			if(studentscore.getArt()==null) {
				pStmt.setObject(9, null);
			}
			else {pStmt.setInt(9,studentscore.getArt());

			}

			if(studentscore.getMusic()==null) {
				pStmt.setObject(10,null);
			}
			else {pStmt.setInt(10, studentscore.getMusic());}

			if(studentscore.getHealth()==null) {
				pStmt.setObject(11, null);}
			else {pStmt.setInt(11, studentscore.getHealth());
			}

			if(studentscore.getIndustrialart()==null) {
				pStmt.setObject(12, null);
			}
			else {pStmt.setInt(12, studentscore.getIndustrialart());}

			if(studentscore.getHomeeconomics()==null) {
				pStmt.setObject(13,null);}

			else {pStmt.setInt(13, studentscore.getHomeeconomics());
			}
			if(studentscore.getInfo()==null) {
				pStmt.setObject(14,studentscore.getInfo());
			}
			else {pStmt.setInt(14, studentscore.getInfo());
			}
			pStmt.setInt(15,studentscore.getSumscore());
			pStmt.setDouble(16, studentscore.getAvr());
			pStmt.setString(17, studentscore.getRank());
			pStmt.setBoolean(18,studentscore.getAttendance());
			pStmt.setInt(19,studentid);

			int result=pStmt.executeUpdate();
			if(result!=1) {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;

		}
		return true;

	}

//daoのテスト作成から



}
