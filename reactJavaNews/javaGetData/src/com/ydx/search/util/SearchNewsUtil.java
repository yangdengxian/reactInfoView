package com.ydx.search.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 鎶撳彇鍥剧墖
 * 
 * @author ydx
 * 
 */

public class SearchNewsUtil {
	private static Map<String, String> urls = new HashMap<String, String>();
	static {
		urls.put("top", "http://v.juhe.cn/toutiao/index"); // 鎵�湁		
	}

	/**
	 * 鏍规嵁鍥剧墖绫诲瀷鍜屽浘鐗囨樉绀洪〉鐮佹煡璇㈠浘鐗�
	 * 
	 * @param category
	 *            鍥剧墖绫诲瀷
	 * @param pageNum
	 *            鍥剧墖鏄剧ず椤电爜
	 */
	public static List<Object> queryList(String type,String key) {
		String url = urls.get(type);
		List<Object> list = null;
		try {
			HashMap<String,String> map = new HashMap<String,String>();
			map.put("type", type);
			map.put("key", key);
			Document doc = Jsoup.connect(url).ignoreContentType(true).data(map).timeout(10000).get();
			Element body = doc.body();
			JSONObject jsonAll = JSONObject.parseObject(body.text());
			JSONObject jsonData = JSONObject.parseObject(String.valueOf(jsonAll.get("result")));
			list = JSONArray.parseArray(String.valueOf(jsonData.get("data")));			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
}
