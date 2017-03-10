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
			//��������
		sessionFactory=HibernateUtils.getSessionFacory();
		session=sessionFactory.getCurrentSession();//��ȡ���ذ󶨵�Session
		 tx=session.beginTransaction();
	   //ҵ���߼�
		User user=new User();		
		user.setUser_password(password);
		user.setPhone(phone);
		session.save(user);
		 //�ύ����
		 tx.commit();

		 isSuccessful=true;
		 System.out.println("�ɹ���������");
		}
		
		catch(Exception e){
			//�ع�����
			tx.rollback();
		}
		return isSuccessful;
		
	}
	public static boolean query(String phone,String password){//��ѯ�û��Ƿ����
		
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		boolean queryOK=true;
		
		try{
			//��������
		sessionFactory=HibernateUtils.getSessionFacory();
		session=sessionFactory.getCurrentSession();//��ȡ���ذ󶨵�Session
		 tx=session.beginTransaction();
	   //ҵ���߼�
		Query query=session.createQuery("from User where phone=? and User_password=?");
		query.setParameter(0, phone);
		query.setParameter(1,password);
		
		List<User> list=query.list(); 
		for (User user : list) {
			if(!user.getPhone().equals("") && !user.getUser_password().equals("")){
				System.out.println("�����ݿ����ѯ����"+user.getPhone()+"::"+user.getUser_password());
				
				return queryOK;
			}else{
				System.out.println("�����ݿ��в鲻��");
				queryOK=false;
			}
		}
		
		
		 //�ύ����
		 tx.commit();

		 System.out.println("��ѯ�ɹ�"+queryOK);
		}
		
		catch(Exception e){
			//�ع�����
			tx.rollback();
		}
		
		
		return queryOK;
	}
	
}
