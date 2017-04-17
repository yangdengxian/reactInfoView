package com.ydx.search.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
public class DbUtils {
	/**
	 * 系统注册
	 * @param jdbctemplate
	 * @param username
	 * @param password
	 * @return
	 */
	public HashMap<String,String> insertData(JdbcTemplate jdbctemplate,String username,String password) {
		HashMap<String, String> map = new HashMap<String,String>();
		String sql="insert into user (username,password) values (?,?)";
		int count= jdbctemplate.update(sql, new Object[]{username,password});
		if (count > 0) {
			map.put("username", username);
			map.put("password", password);
		}
		return map;
	}
	
	/**
	 * 修改密码
	 * @param jdbctemplate
	 * @param username
	 * @param password
	 * @return
	 */
	public int updateData(JdbcTemplate jdbctemplate,String username,String password) {
		String sql="update user set password=? where username=?";
		int count= jdbctemplate.update(sql, new Object[]{password,username});
		return count;
	}
	
	/**
	 * 系统登录
	 * @param jdbctemplate
	 * @param userName
	 * @param password
	 * @return
	 */
	public Map<String,Object> queryData(JdbcTemplate jdbctemplate, String userName,
			String password) {
		String sql="select * from user where username=?";
		List<Map<String, Object>> list = jdbctemplate.queryForList(sql, new Object[]{userName});
		if (list.size() == 1 && password.equals(list.get(0).get("password"))) {
			return list.get(0);
		}
		return null;
	}

	
}
