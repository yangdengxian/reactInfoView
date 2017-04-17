package com.ydx.search.util;

public class StringUtils {
	public static boolean IsNullOrSpace(String value) {
		if ((value == null) || ("".equals(value))) {
			return true;
		}
		if (value.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean HasLength(String value) {
		if ((value == null) || ("".equals(value.trim()))) {
			return false;
		}
		return true;
	}

	public static int objectToInt(Object obj) {
		int result = 0;
		if ((obj == null) || ("".equals(obj)))
			return 0;
		try {
			result = Integer.parseInt(obj.toString());
		} catch (Exception localException) {
		}
		return result;
	}

	public static boolean getBool(String strBool) {
		if (IsNullOrSpace(strBool)) {
			return false;
		}

		strBool = strBool.trim().toUpperCase();
		if ((strBool.equals("1")) || (strBool.equals("TRUE"))
				|| (strBool.equals("ÊÇ")) || (strBool.equals("YES"))) {
			return true;
		}
		return false;
	}

	public static boolean IsNullOrEmpty(String value) {
		if ((value == null) || ("".equals(value))) {
			return true;
		}
		return false;
	}

	public static boolean IsNullOrEmpty(Object value) {
		if ((value == null) || ("".equals(value.toString()))) {
			return true;
		}
		return false;
	}

	public static String PadLeft(String str, int padLength, char padLeftStr) {
		if (str.length() < padLength) {
			int padLengthIng = padLength - str.length();
			for (int i = 0; i < padLengthIng; i++) {
				str = padLeftStr + str;
			}
		}
		return str;
	}

	public static String PadRight(String str, int padLength, char padLeftStr) {
		if (str.length() < padLength) {
			int padLengthIng = padLength - str.length();
			for (int i = 0; i < padLengthIng; i++) {
				str = str + padLeftStr;
			}
		}
		return str;
	}

	public static String handelUrl(String url) {
		if (url == null) {
			return null;
		}
		url = url.trim();
		if ((url.equals("")) || (url.startsWith("http://"))
				|| (url.startsWith("https://"))) {
			return url;
		}
		return "http://" + url.trim();
	}

}