package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.stx.bean.User;

/**
 * 持久层
 * 
 * @author 17476
 * 
 */
public class UserDao {
	// 添加用户
	public void addUser(User user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "insert into user (zh,pass,realname,mobile,type) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getZh());
			pstmt.setString(2, user.getPass());
			pstmt.setString(3, user.getRealname());
			pstmt.setString(4, user.getMobile());
			pstmt.setString(5, user.getType());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public User login(String zh, String pass) {
		User user = null;
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 创建连接
			connection = JdbcUtils.getConnection();
			// 创建执行者
			stmt = connection
					.prepareStatement("select * from user where zh=? and pass=?");
			stmt.setString(1, zh);
			stmt.setString(2, pass);
			// 执行查询，将查询结果放入结果集
			rs = stmt.executeQuery();
			// 输出

			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("zh"),
						rs.getString("pass"), rs.getString("realname"),
						rs.getString("mobile"), rs.getString("type"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			// 关闭资源
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

}
