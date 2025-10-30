package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;
import model.TeacherAccount;

public class TeacherDAO {

	private final String JDBC_URL="jdbc:h2:tcp://localhost/~/GradeManagement";
	private final String DB_USER="sa";
	private final String DB_PASS="";

	public TeacherAccount findLogin(Login login) {
		TeacherAccount teacheraccount=null;
//		JDBC_ドライバーを読み込む
		try {
			Class.forName("org.h2.Driver");

		}
		catch(ClassNotFoundException e) {
			throw new IllegalStateException ("JDBCドライバーを読み込めませんでした");
		}

//		データベースを接続
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="select TEACHER_ID,PASS,MAIL,NAME,SUBJECT from TEACHER where TEACHER_ID=? and PASS=?";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			pStmt.setString(1,login.getTeacher_Id());
			pStmt.setString(2,login.getPass());
			ResultSet rs=pStmt.executeQuery();

			if(rs.next()) {
				String teacher_Id=rs.getString("TEACHER_ID");
				String pass=rs.getString("PASS");
				String mail=rs.getString("MAIL");
				String name=rs.getString("NAME");
				String subject=rs.getString("SUBJECT");
				teacheraccount=new TeacherAccount(teacher_Id,pass,mail,name,subject);

			}

			}catch(SQLException e) {
				e.printStackTrace();
				return null;

		}

		return teacheraccount;




	}

	public boolean create(TeacherAccount teacheraccount) {
//		ドライバーの読み込み
		try {
			Class.forName("org.h2.Driver");
		}
		catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバーを読み込めませんでした");
		}

//		データベースへの接続
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
	//sql文の準備

		String sql="insert into Teacher(TEACHER_ID,PASS,MAIL,NAME,SUBJECT) values(?,?,?,?,?)";
			PreparedStatement pStmt=conn.prepareStatement(sql);

		pStmt.setString(1,teacheraccount.getTeacher_Id());
		pStmt.setString(2,teacheraccount.getPass());
		pStmt.setString(3,teacheraccount.getMail());
		pStmt.setString(4,teacheraccount.getName());
		pStmt.setString(5,teacheraccount.getSubject());

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

}
