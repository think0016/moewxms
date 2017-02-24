package me.moe.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通用工具类
 * @author liu
 *
 */
public class CommonTools {
	
	/**
	 * 日期转换字符串
	 * @param pattern eg:yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String dateTostring(String pattern , Date date){
		   SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		   String dateString = formatter.format(date);
		   return dateString;
	}
	
}
