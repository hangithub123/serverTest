package com.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static Configuration cfg=null;
	private static SessionFactory sessionFactory=null;
	
	//��̬�����
	static{
	  //���غ��������ļ�
		cfg=new Configuration();
		cfg.configure();
		sessionFactory=cfg.buildSessionFactory();
	}
	//�ṩ��������sessionFactory
	public static SessionFactory getSessionFacory(){
		return sessionFactory;
	}
	
}
