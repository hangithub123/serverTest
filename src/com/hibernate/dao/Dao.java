package com.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.hibernate.Entity.User;
import com.hibernate.utils.HibernateUtils;

public class Dao {

	public static boolean save(String phone,String password) {
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		boolean isSuccessful=false;
		
		try{
			//开启事物
		sessionFactory=HibernateUtils.getSessionFacory();
		session=sessionFactory.getCurrentSession();//获取本地绑定的Session
		 tx=session.beginTransaction();
	   //业务逻辑
		User user=new User();		
		user.setUser_password(password);
		user.setPhone(phone);
		session.save(user);
		 //提交事物
		 tx.commit();

		 isSuccessful=true;
		 System.out.println("成功保存数据");
		}
		
		catch(Exception e){
			//回滚事务
			tx.rollback();
		}
		return isSuccessful;
		
	}
	public static boolean query(String phone,String password){//查询用户是否存在
		
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		boolean queryOK=true;
		
		try{
			//开启事物
		sessionFactory=HibernateUtils.getSessionFacory();
		session=sessionFactory.getCurrentSession();//获取本地绑定的Session
		 tx=session.beginTransaction();
	   //业务逻辑
		Query query=session.createQuery("from User where phone=? and User_password=?");
		query.setParameter(0, phone);
		query.setParameter(1,password);
		
		List<User> list=query.list(); 
		for (User user : list) {
			if(!user.getPhone().equals("") && !user.getUser_password().equals("")){
				System.out.println("从数据库里查询到的"+user.getPhone()+"::"+user.getUser_password());
				
				return queryOK;
			}else{
				System.out.println("从数据库中查不到");
				queryOK=false;
			}
		}
		
		
		 //提交事物
		 tx.commit();

		 System.out.println("查询成功"+queryOK);
		}
		
		catch(Exception e){
			//回滚事务
			tx.rollback();
		}
		
		
		return queryOK;
	}
	
}
