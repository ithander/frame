package org.ithang.test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

public class YaoCodeTest {
	private static Random r = new Random(System.currentTimeMillis());
	@Test
	public void test(){
		Set<String> set=new HashSet<>();
		for(int i=0;i<1000000;i++){
			String code=getCode(i);
			set.add(code);
			System.out.println("code="+code);
		}
		System.out.println(set.size());
	}
	
	//生成十位数奖品兑换码
	public static String getCode(int c) {
	    int count = 6;
	    String str="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    //str="0123456789";
	    StringBuilder sb = new StringBuilder();
	    
	    r = new Random(c);
	    for (int i = 0; i < count; i++) {
	        int d =r.nextInt(10);
	        sb.append(str.charAt(d));
	    }
	    return sb.toString();
	}
	
	
}
