package com.atguigu.dom4j;

import static org.junit.Assert.*;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.atguigu.bean.Student;

public class Dom4jTest {

	@Test
	public void test() throws Exception {
	  //获取解析器
	  SAXReader reader = new SAXReader();
	  //通过解析器加载xml文档
      Document document = reader.read("students.xml");
      
      //dom4j的一切解析操作都是从根元素开始的
      Element root = document.getRootElement();
      
      //获取student标签 
      List<Element> list = root.elements("student");
      
      //遍历
      for(int i=0;i<list.size();i++){
    	   Element ele = list.get(i);
    	   
    	   //获取id属性值 
    	   String id = ele.attributeValue("id");
    	   
    	   //获取name标签
    	   Element nameEle = ele.element("name");
    	   //获取name文本值
    	   String name = nameEle.getText();
    	   
    	   //获取age
    	   String age = ele.elementText("age");
    	   //获取gender
    	   String gender = ele.elementText("gender");
    	   //获取desc
    	   String desc = ele.elementText("desc");
    	   
    	   //创建student
    	   Student student = new Student(id, name, Integer.parseInt(age), gender, desc);
    	   System.out.println(student);
    	   
    	   
      }
	}

}
