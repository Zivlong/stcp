package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stx.bean.Type;

public class TypeDao {
	// 查询所有分类
	public List selectType() {
		List list = new ArrayList();
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 创建连接
			connection = JdbcUtils.getConnection();
			// 创建执行者
			stmt = connection.prepareStatement("select * from type");
			// 执行查询，将查询结果放入结果集
			rs = stmt.executeQuery();
			// 输出

			while (rs.next()) {
				Type t = new Type(rs.getInt("id"), rs.getString("name"));
				list.add(t);
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

	// 新增类型
	// 增加数据方法
	public void addType(Type type) {
		// 获取连接
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = JdbcUtils.getConnection();
			// 获取执行者
			// stmt=connection.prepareStatement("insert into tb_user(name,java,db,html) values(?,?,?,?)");
			stmt = connection
					.prepareStatement("insert into type(name) values(?)");
			stmt.setString(1, type.getName());
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

	// 删除数据方法
	public void deleteType(int id) {
		// 获取连接
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = JdbcUtils.getConnection();
			// 获取执行者
			stmt = connection.prepareStatement("delete from type where id=?");
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

	public Type selectTypeById(int id) {
		Type type = null;
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 创建连接
			connection = JdbcUtils.getConnection();
			// 创建执行者
			stmt = connection.prepareStatement("select * from type where id=?");
			stmt.setInt(1, id);
			// 执行查询，将查询结果放入结果集
			rs = stmt.executeQuery();
			// 输出

			if (rs.next()) {
				type = new Type(rs.getInt("id"), rs.getString("name"));
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
		return type;
	}

	// 增加数据方法
	public void updateType(Type type) {
		// 获取连接
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = JdbcUtils.getConnection();
			// 获取执行者
			stmt = connection
					.prepareStatement("update type set name=? where id=?");
			stmt.setString(1, type.getName());
			stmt.setInt(2, type.getId());
			// 执行语句
			stmt.executeUpdate();

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
}
