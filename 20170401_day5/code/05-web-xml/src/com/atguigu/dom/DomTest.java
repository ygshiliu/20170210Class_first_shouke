package com.atguigu.dom;

import static org.junit.Assert.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.atguigu.bean.Student;

public class DomTest {

	@Test
	public void testAll() throws Exception {
		//创建解析器工厂类实例
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//通过解析器工厂类实例获取解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		//通过解析器解析xml文档
		Document document = builder.parse("students.xml");
		
		//由于xml是自定义标签，在这里id属性没有任何意义
		//所以getElementById("01")在这里不能使用
		/*Element ele = document.getElementById("01");*/
		NodeList list = document.getElementsByTagName("student");
		
		//遍历
		for(int i=0;i<list.getLength();i++){
			//获取具体的某一个节点
			Element	item = (Element) list.item(i);
			
			//获取id属性值 
			String id = item.getAttribute("id");
			
			//获取具体元素下的name元素
			NodeList nameList = item.getElementsByTagName("name");
			Element nameEle = (Element) nameList.item(0);
			//获取文本值 
			String name = nameEle.getTextContent();
			
			//获取age文本
			String age = item.getElementsByTagName("age").item(0).getTextContent();
			//获取gender
			String gender = item.getElementsByTagName("gender").item(0).getTextContent();
			//获取desc
			String desc = item.getElementsByTagName("desc").item(0).getTextContent();
			
			//创建studnet
			Student student = new Student(id,name, Integer.parseInt(age), gender, desc);
			System.out.println(student);
		}
	}

}
