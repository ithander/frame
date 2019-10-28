package org.ithang.test.tools.gener;

import java.io.File;

import org.ithang.tools.gener.CodeGener;
import org.junit.Test;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class CodeGenerTest {

	@Test
	public void generTest()throws Exception{
		SimpleDriverDataSource ds=new SimpleDriverDataSource(new com.mysql.jdbc.Driver(), "jdbc:mysql://192.168.0.187:3306/test?useSSL=false", "root", "123456");
		CodeGener codGener=new CodeGener(ds);
		codGener.gener("template");
	}
	
	//@Test
	public void pathTest(){
		System.out.println(CodeGener.class.getResource("/")+"../../");
		System.out.println(CodeGener.class.getResource("ftl").getFile());
		File dir=new File(CodeGener.class.getResource("/")+"../../");
		System.out.println(dir.getAbsolutePath());
	}
	
}
