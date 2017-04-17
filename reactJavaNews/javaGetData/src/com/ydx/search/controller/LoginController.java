package com.ydx.search.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ydx.search.util.DbUtils;
import com.ydx.search.util.StringUtils;

@Controller
public class LoginController {
	@Autowired
	private JdbcTemplate jdbctemplate;
	private DbUtils dbUtils = new DbUtils();
	/**
	 * ÏµÍ³µÇÂ¼
	 * @param request
	 * @param response
	 * @param userName
	 * @param password
	 */
	@RequestMapping(value="/login.do")
	@ResponseBody
	public String login(HttpServletRequest request,HttpServletResponse response,String username,String password) {
		setCorsResponse(response);
		if (!StringUtils.IsNullOrEmpty(username) && !StringUtils.IsNullOrEmpty(password)) {
			if (null != dbUtils.queryData(jdbctemplate,username, password)) {
				return JSONObject.toJSONString(dbUtils.queryData(jdbctemplate,username, password));
			}
		}
		return null;
	}
	
	/**
	 * ÓÃ»§×¢²á
	 * @param request
	 * @param response
	 * @param userName
	 * @param password
	 */
	@RequestMapping(value="/register.do")
	@ResponseBody
	public String register(HttpServletRequest request,HttpServletResponse response,String username,String password) {
		setCorsResponse(response);
		if (!StringUtils.IsNullOrEmpty(username) && !StringUtils.IsNullOrEmpty(password)) {
			if (null != dbUtils.insertData(jdbctemplate,username, password)) {
				return JSONObject.toJSONString(dbUtils.insertData(jdbctemplate,username, password));
			}
		}
		return null;
	}
	
	/**
	 * ï¿½ï¿½ï¿½Ã¿ï¿½ï¿½ï¿½
	 * @param response
	 */
	private void setCorsResponse(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");  
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");  
        response.setHeader("Access-Control-Allow-Headers", "token,Access-Control-Allow-Origin,Access-Control-Allow-Methods,Access-Control-Max-Age,authorization");	
        
	}
}
