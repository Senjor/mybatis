package com.zhiyou.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zhiyou.mybatis.vo.User;

import junit.framework.TestCase;

/**
* @author 		laosun
* @version 		创建时间：Nov 5, 2018 10:01:29 AM
* @ClassName 	类名称
* @Description 	类描述
*/
public class Test {
	
	

	@org.junit.Test
	public  void testAdd() throws IOException {
		// TODO Auto-generated method stub
		
		InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		
		User user = new User();
		user.setU_id(100);
		user.setU_name("laosun");
		user.setU_sex("nan");
		user.setU_pwd("123");
		
		int exeCount = session.insert("com.zhiyou.mybatis.mapper.User.doCreate",user);

		System.out.println(exeCount);
		session.commit();
		session.close();
		inputStream.close();
	}

	@org.junit.Test
	public void testUpdate() throws IOException {

		InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		
		User user = new User();
		user.setU_id(100);
		user.setU_name("laosun");
		user.setU_sex("nv");
		user.setU_pwd("1234");
		
		int exeCount = session.insert("com.zhiyou.mybatis.mapper.User.doUpdate",user);

//		System.out.println(exeCount);
		TestCase.assertEquals(exeCount, 1);
		session.commit();
		session.close();
		inputStream.close();
	}
	
	
	@org.junit.Test
	public void testFindById() throws IOException {

		InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		
		User user = new User();
		user.setU_id(100);
		user.setU_name("laosun");
		user.setU_sex("nv");
		user.setU_pwd("1234");
		
		User vo = session.selectOne("com.zhiyou.mybatis.mapper.User.findById",100);

//		System.out.println(exeCount);
		TestCase.assertNotNull(vo);
		System.out.println(vo);
		session.commit();
		session.close();
		inputStream.close();
	}
	
	@org.junit.Test
	public void testFindAll() throws IOException {

		InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		
		List<User> list = session.selectList("com.zhiyou.mybatis.mapper.User.findAll",100);
		
		System.out.println(list);
		TestCase.assertTrue(list.size() > 0);

		session.commit();
		session.close();
		inputStream.close();
	}
	@org.junit.Test
	public void findAllCount() throws IOException {

		InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		
		Long exeCount = session.selectOne("com.zhiyou.mybatis.mapper.User.findAllCount");
		
		System.out.println(exeCount);
		TestCase.assertNotNull(exeCount);

		session.commit();
		session.close();
		inputStream.close();
	}
	@org.junit.Test
	public void findAllSplit() throws IOException {

		InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		
		int currentPage = 4;
		int lineSize = 1;
		Map<String, Object> map = new HashMap<>();
		map.put("column", "u_name");
		map.put("keyword", "%五%");
		map.put("start", lineSize);//1
		map.put("lineSize", (currentPage - 1)*lineSize);//3
		
		List<Use> list = session.selectList("com.zhiyou.mybatis.mapper.User.findAllSplit",map);

		
		System.out.println("list------"+list);
		System.out.println("list.size  " + list.size());
		TestCase.assertTrue(list.size() > 0);

		session.commit();
		session.close();
		inputStream.close();
	}
	@org.junit.Test
	public void getAllCountSplit() throws IOException {

		InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		
		Map<String, Object> map = new HashMap<>();
		map.put("column", "u_name");
		map.put("keyword", "%五%");
		
		Long queryCount = session.selectOne("com.zhiyou.mybatis.mapper.User.getAllCountSplit",map);

		System.out.println(queryCount);
		TestCase.assertNotNull(queryCount);

		session.commit();
		session.close();
		inputStream.close();
	}
	
	@org.junit.Test
	public void testRemove() throws IOException {

		InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		
		Map<String, Object> map = new HashMap<>();
		map.put("column", "u_name");
		map.put("keyword", "%五%");
		
		int expected = session.delete("com.zhiyou.mybatis.mapper.User.doRemove","1");

		System.out.println(expected);
		TestCase.assertEquals(expected, 1);

		session.commit();
		session.close();
		inputStream.close();
	}
	
	@org.junit.Test
	public void doRemoveBatch() throws IOException {

		InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		
		Set<String> ids = new HashSet<>();
		ids.add("3");
		ids.add("4");
		
		int expected = session.delete("com.zhiyou.mybatis.mapper.User.doRemoveBatch",ids.toArray());

		System.out.println(expected);
		TestCase.assertEquals(expected, 2);
		
		session.commit();
		session.close();
		inputStream.close();
	}
	
	
}
