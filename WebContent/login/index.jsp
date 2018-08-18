<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.hskj.common.*" %>
<%@ page import = "com.hskj.models.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "net.sf.json.*" %>
  
 
  
<%
   gycuser user = new gycuser();
   user.setId(0);
   user.setName("GYC");
   
   ModelData<gycuser> md = new ModelData<gycuser>();
   md.setData(user);
   HibernateDatabase.getInstance().addData(md); 
  
   List<gycuser> us = HibernateDatabase.getInstance().queryData("from gycuser where id > 1");
   
   ConstFunction.sendDataToClient(JSONArray.fromObject(us).toString(), response);
%>