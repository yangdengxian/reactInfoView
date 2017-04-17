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
	 * 锟斤拷取锟斤拷锟斤拷锟斤拷锟�
	 * @param request
	 * @param response
	 * @param type 锟斤拷锟斤拷锟斤拷锟斤拷
	 * @param key 锟杰筹拷
	 * @param count 锟斤拷示锟斤拷锟斤拷
	 * @return
	 */
	@RequestMapping("/getNewsData.do")
	@ResponseBody
	public List<Object> getNewsData(HttpServletRequest request,HttpServletResponse response,String type,int count) {
		setCorsResponse(response);
        if (null == type) {
        	return null;
        }
		List<Object> listData = SearchNewsUtil.queryList(type,count);
		return listData;
	}
	
	/**
	 * 锟斤拷取锟斤拷细锟斤拷息
	 * @param request
	 * @param response
	 * @param uniquekey 唯一值
	 * @return
	 */
	@RequestMapping("/getNewsDetails.do")
	@ResponseBody
	public List<Object> getNewsDetails(HttpServletRequest request,HttpServletResponse response,String uniquekey) {
		setCorsResponse(response);
        if (null == uniquekey) {
        	return null;
        }
		List<Object> listData = SearchNewsUtil.queryDetails(uniquekey);
        return listData;
	}
	
	
	
	/**
	 * 锟斤拷锟矫匡拷锟斤拷
	 * @param response
	 */
	private void setCorsResponse(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");  
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");  
        response.setHeader("Access-Control-Allow-Headers", "token,Access-Control-Allow-Origin,Access-Control-Allow-Methods,Access-Control-Max-Age,authorization");	
        
	}
}
