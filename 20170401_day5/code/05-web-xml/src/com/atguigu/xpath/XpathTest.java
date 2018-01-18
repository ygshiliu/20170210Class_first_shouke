package com.atguigu.xpath;

import static org.junit.Assert.*;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.atguigu.bean.Student;

public class XpathTest {

	@Test
	public void test() throws Exception {
		//获取解析器
		SAXReader reader = new SAXReader();
		//通过解析器加载xml文档
		Document document = reader.read("students.xml");
		
		Element ele = (Element) document.selectSingleNode("/students/student[@id='03']");
		
		System.out.println(ele);
		if(ele != null){
			
			//获取id\name\age\gender\desc
			String id = ele.attributeValue("id");
			String name = ele.elementText("name");
			String age = ele.elementText("age");
			String gender = ele.elementText("gender");
			String desc = ele.elementText("desc");
			
			//创建student
			Student student = new Student(id, name, Integer.parseInt(age), gender, desc);
			System.out.println(student);
		}
		
	}

}
