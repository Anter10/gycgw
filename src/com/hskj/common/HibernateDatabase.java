package com.hskj.common;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.hskj.models.*;

import org.hibernate.boot.registry.*;
import java.util.*;

import javax.persistence.EntityManager;


public class HibernateDatabase {
   static HibernateDatabase hibernatedastabase = null;
   private EntityManager entityManager;
   private Session session;
   private StandardServiceRegistry registry;
   private Configuration configs;
   private Transaction transaction = null;
   SessionFactory sessions;
   //  得到 
   public static HibernateDatabase getInstance(){
	   if (hibernatedastabase == null){
		   hibernatedastabase = new HibernateDatabase();
	   }
	   return hibernatedastabase;
   }
   
   // 构造函数 
   public HibernateDatabase(){
 
	   
	   configs       = new Configuration().configure("hibernate.cfg.xml");
	   registry      = new StandardServiceRegistryBuilder().applySettings(configs.getProperties()).build();
	   sessions      = configs.buildSessionFactory();
	   session       = sessions.openSession();
       entityManager = sessions.createEntityManager();
	   
   }
   
   // 开始事物处理
   public void beginTransaction(){

	   transaction   = session.beginTransaction();
   }
   
   // 得到事务处理
   public Transaction getTransaction(){
	   return transaction;
   }
   
   
   // 查询数据
   public List queryData(String sql){
	   Session ssession       = sessions.openSession();
	   try{
		  
	       List list = ssession.createQuery(sql).list();
	       return list;
	   }catch(HibernateException e){
		   ssession.close();
		   return null;
	   }
   }
   
   // 查询数据
   public List queryLimitData(String sql,int start, int max){
	   Session ssession       = sessions.openSession();
	   try{
		   Query query = ssession.createQuery(sql);
		   query.setFirstResult(start);
		   query.setMaxResults(max);
	       List list = query.list();
	       return list;
	   }catch(HibernateException e){
		   ssession.close();
		   return null;
	   }
   }
   
   // 更新数据
   public boolean updateData(ModelData md){
	   Session ssession = sessions.openSession();
	   try{
		   Transaction ts = ssession.beginTransaction();
		   ssession.update(md.getData());
 		   ts.commit();
// 		   session.close();
		   return true;
	   }catch(HibernateException e){
		   ssession.close();
		   return false;
	   }
   }
   
   // 添加新的数据
   public boolean addData(ModelData md){
	   System.out.print("\naaaaddddddddata = "+md.getId());
	   Session ssession = sessions.openSession(); 
	   try {
		 Transaction ts = ssession.beginTransaction();
		 ssession.persist(md.getData());
		 ts.commit();
//		 session.close();
		 return true;
       } catch (RuntimeException e) {
    	     ssession.close();
         return false;
       }
	}

   // 删除数据
   public <T> boolean deleteData(ModelData md){
	   Session ssession = sessions.openSession(); 
	   try {
		     Transaction ts = ssession.beginTransaction();
		     ssession.delete(md.getData());
			 ts.commit();
			 ts.commit();
//			 session.close();
			 return true;
	       } catch (RuntimeException e) {
	    	     ssession.close();
	         return false;
	       }
   }
   
   public Session getSession(){
	   return this.session;
   }
   
   public void closeAll(){
	
//		 session.flush();
//	     entityManager.close();
//		 session.close();
   }
   
   public List queryNumberData(int min, int max, ModelData data) {
	   Criteria cr = session.createCriteria(data.getClass());
	   cr.setMaxResults(10);
	   cr.setFirstResult(1);
	   return cr.list();
   }

   
   public long getCount(String sql) {
	   Session ssession = sessions.openSession(); 
	   Long count = (Long)ssession.createQuery(sql)
               .uniqueResult();
	   return count;
   }
   
}















 