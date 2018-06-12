package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stx.bean.Cp;
import com.stx.bean.Type;

public class CpDao {

	public Type selectCpById(int id) {
		Cp cp = null;
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 创建连接
			connection = JdbcUtils.getConnection();
			// 创建执行者
			stmt = connection.prepareStatement("select * from cp where id=?");
			stmt.setInt(1, id);
			// 执行查询，将查询结果放入结果集
			rs = stmt.executeQuery();
			// 输出

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
		return null;
	}

	// 删除数据方法
	public void deleteCp(int id) {
		// 获取连接
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = JdbcUtils.getConnection();
			// 获取执行者
			stmt = connection.prepareStatement("delete from cp where id=?");
			stmt.setInt(1, id);
			// 执行语句
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 一定要被执行到的代码
			// 关闭通道，释放资源，关闭的顺序：先创建的后关闭，后创建的先关闭
			try {
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
	}

	// 增加数据方法
	public void addCp(Cp cp) {
		// 获取连接
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = JdbcUtils.getConnection();
			// 获取执行者
			// stmt=connection.prepareStatement("insert into tb_user(name,java,db,html) values(?,?,?,?)");
			stmt = connection
					.prepareStatement("insert into cp(uname,tname,title,content,createtime) values(?,?,?,?,?)");
			stmt.setString(1, cp.getUname());
			stmt.setString(2, cp.getTname());
			stmt.setString(3, cp.getTitle());
			stmt.setString(4, cp.getContent());
			stmt.setDate(5, cp.getCreatetime());
			// 执行语句
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 一定要被执行到的代码
			// 关闭通道，释放资源，关闭的顺序：先创建的后关闭，后创建的先关闭
			try {
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
	}

	// 查询方法
	public List selectCpByUser(String uname) {
		List list = new ArrayList();
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 创建连接
			connection = JdbcUtils.getConnection();
			// 创建执行者
			stmt = connection
					.prepareStatement("select * from cp where uname=?");
			stmt.setString(1, uname);
			// 执行查询，将查询结果放入结果集
			rs = stmt.executeQuery();
			// 输出

			while (rs.next()) {
				Cp cp = new Cp(rs.getInt("id"), rs.getString("uname"),
						rs.getString("tname"), rs.getString("title"),
						rs.getString("content"), rs.getDate("createtime"));
				list.add(cp);
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
		return list;
	}

}
