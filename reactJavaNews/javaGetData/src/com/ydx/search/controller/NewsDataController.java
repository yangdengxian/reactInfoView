package com.ydx.search.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.ydx.search.util.SearchNewsUtil;

@Controller
@RequestMapping(value = "/newsData")
public class NewsDataController {
	/**
	 * 获取新闻数据
	 * @param request
	 * @param response
	 * @param type 新闻类型
	 * @param key 密匙
	 * @param count 显示数量
	 * @return
	 */
	@RequestMapping("/getNewsData.do")
	@ResponseBody
	public String getNewsData(HttpServletRequest request,HttpServletResponse response,String type,String key,int count) {
		setCorsResponse(response);
        if (null == type && null == key) {
        	return null;
        }
		List<Object> listData = SearchNewsUtil.queryList(type,key,count);
		System.out.println(JSONArray.toJSONString(listData, true));
		response.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
		return JSONArray.toJSONString(listData, true);
	}
	
	/**
	 * 获取详细信息
	 * @param request
	 * @param response
	 * @param uniquekey 唯一值
	 * @return
	 */
	@RequestMapping("/getNewsDetails.do")
	@ResponseBody
	public String getNewsDetails(HttpServletRequest request,HttpServletResponse response,String uniquekey) {
		setCorsResponse(response);
        if (null == uniquekey) {
        	return null;
        }
		/*List<Object> listData = SearchNewsUtil.queryList(type,key,count);
		return JSONArray.toJSONString(listData, true);*/
        return null;
	}
	
	/**
	 * 设置跨域
	 * @param response
	 */
	private void setCorsResponse(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");  
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");  
        response.setHeader("Access-Control-Allow-Headers", "token,Access-Control-Allow-Origin,Access-Control-Allow-Methods,Access-Control-Max-Age,authorization");	
        
	}
}
