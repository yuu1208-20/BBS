package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.User;

public class UserDao {

	//DB接続情報
	private final String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost/BBSdb";
	private final String USER = "root";
	private final String PASS = "root";
	
	//DB接続メソッド
	public Connection getConnection() throws SQLException{
		try {
			Class.forName(RDB_DRIVE);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("接続失敗");
		}
		return DriverManager.getConnection(URL,USER,PASS);
	}
	
	//投稿データ登録メソッド
	public void insert(String username,String title,String comments) {
		User user = new User();
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into bbsinfo(username,title,comments,date) values(?,?,?,CURRENT_TIMESTAMP)";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			
			//セッター呼び出し
			user.setUsername(username);
			user.setTitle(title);
			user.setComments(comments);
			
			//ゲッターを介して格納
			ps.setString(1,user.getUsername());
			ps.setString(2, user.getTitle());
			ps.setString(3, user.getComments());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//DB表示メソッド
	public ArrayList<User> select() {
		ArrayList<User> list = new ArrayList<User>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from bbsinfo";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//ArrayListにSQLのデータを格納
			while(rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setTitle(rs.getString("title"));
				user.setComments(rs.getString("comments"));
				user.setDate(rs.getTimestamp("date"));
				list.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//DB新しい順並べ替えメソッド
	public ArrayList<User> selectSortByNew(){
		ArrayList<User> list = new ArrayList<User>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from bbsinfo order by date desc";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//ArrayListにSQLのデータ格納
			while(rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setTitle(rs.getString("title"));
				user.setComments(rs.getString("comments"));
				user.setDate(rs.getTimestamp("date"));
				list.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//DB古い順並べ替えメソッド
	public ArrayList<User> selectSortByOld(){
		ArrayList<User> list = new ArrayList<User>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from bbsinfo order by date asc";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//ArrayListにSQLのデータを格納
			while(rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setTitle(rs.getString("title"));
				user.setComments(rs.getString("comments"));
				user.setDate(rs.getTimestamp("date"));
				list.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
