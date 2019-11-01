package org.ithang.tools.sender;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 发送短信
 * @author zyt
 *
 */
public class SmsSender {

	 public static String sendMsg(String phone, String content) {
	        String result = "0";
	        String username = "yinhu"; //在短信宝注册的用户名
	        String password = "327486405yinhu"; //在短信宝注册的密码
	        String httpUrl = "http://api.smsbao.com/sms";

	        String s = encodeUrlString("【银光链客】" + content, "UTF-8");
	        StringBuffer httpArg = new StringBuffer();
	        httpArg.append("u=").append(username).append("&");
	        httpArg.append("p=").append(md5(password)).append("&");
	        httpArg.append("m=").append(phone).append("&");

	        httpArg.append("c=").append(s);
	        result = request(httpUrl, httpArg.toString());
	        return result;
	    }
	 
	 public static String getSmsTemplate(int type, String code) {
		  String str = null;
		   switch(type){
			   case 1:{
				   str = "您的注册验证码是" + code + "，请不要把验证码泄漏给其他人，如非本人请勿操作。";
			   }break;
			   case 2:{
				   str = "您正在重置登录密码，验证码" + code + "，请不要把验证码泄漏给其他人，如非本人请勿操作。";
			   }break;
			   case 3:{
				   str = "您正在设置交易密码，验证码" + code + "，请不要把验证码泄漏给其他人，如非本人请勿操作。";
			   }
			   default : {
				   str = "您的验证码是" + code + "若非本人操作请忽略此消息。";
			   }break;
		   }
		 
	        return str;
	 }

	 
	 private static String md5(String plainText) {
	        StringBuffer buf = null;
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            md.update(plainText.getBytes());
	            byte b[] = md.digest();
	            int i;
	            buf = new StringBuffer("");
	            for (int offset = 0; offset < b.length; offset++) {
	                i = b[offset];
	                if (i < 0)
	                    i += 256;
	                if (i < 16)
	                    buf.append("0");
	                buf.append(Integer.toHexString(i));
	            }
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return buf.toString();
	 }
	 
	 private static String encodeUrlString(String str, String charset) {
	        String strret = null;
	        if (str == null)
	            return str;
	        try {
	            strret = java.net.URLEncoder.encode(str, charset);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	        return strret;
	  }
	 
	 private static String request(String httpUrl, String httpArg) {
	        BufferedReader reader = null;
	        String result = null;
	        StringBuffer sbf = new StringBuffer();
	        httpUrl = httpUrl + "?" + httpArg;

	        try {
	            URL url = new URL(httpUrl);
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");
	            connection.connect();
	            InputStream is = connection.getInputStream();
	            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	            String strRead = reader.readLine();
	            if (strRead != null) {
	                sbf.append(strRead);
	                while ((strRead = reader.readLine()) != null) {
	                    sbf.append("\n");
	                    sbf.append(strRead);
	                }
	            }
	            reader.close();
	            result = sbf.toString();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }

	
	
}
