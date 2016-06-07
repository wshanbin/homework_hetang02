package com.sdu.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.sdu.po.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User getUserById(Integer id) {
		String sql = "select id,name, user_type,create_time,state,last_login_time,remark from user where id =?";

		final User user = new User();
		jdbcTemplate.query(sql, new Object[] { id }, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setLastLoginTime(rs.getString("last_login_time"));
				user.setCreateTime(rs.getString("create_time"));
				user.setRemark(rs.getString("remark"));
				user.setState(rs.getString("state"));
				user.setUserType(rs.getString("user_type"));
			}

		});
		return user;
	}

	public List<Map<String, Object>> getUsers() {
		String sql = "select id,name,user_type,create_time,state,last_login_time,remark from user";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}

	}

	public void updatePo(final User user, final Integer id) {
		jdbcTemplate
				.update("update user set name=?,user_type=?,create_time=?,state=?,last_login_time=?,remark=? where id = ?",
						new PreparedStatementSetter() {
							public void setValues(PreparedStatement ps)
									throws SQLException {
								ps.setString(1, user.getName());
								ps.setString(2, user.getUserType());
								ps.setString(3, user.getCreateTime());
								ps.setString(5, user.getLastLoginTime());
								// TODO Auto-generated catch block
								ps.setString(4, user.getState());

								ps.setString(6, user.getRemark());
								ps.setInt(7, id);
							}
						});
	}

	public void savePo(final User user) {

		jdbcTemplate
				.update("insert into user(name,user_type,create_time,state,last_login_time,remark) values(?,?,?,?,?,?)",
						new PreparedStatementSetter() {

							public void setValues(PreparedStatement ps)
									throws SQLException {
								ps.setString(1, user.getName());
								ps.setString(2, user.getUserType());
								ps.setString(3, user.getCreateTime());
								ps.setString(4, user.getState());
								ps.setString(5, user.getLastLoginTime());
								ps.setString(6, user.getRemark());
							}
						});
	}

	public void deletePo(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from user where id=" + id;
		int temp = this.jdbcTemplate.update(sql);
		if (temp > 0) {
			System.out.println("删除成功！");
		} else {
			System.out.println("删除失败！");
		}
	}

}
