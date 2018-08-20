<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.hskj.common.*" %>
<%@ page import = "com.hskj.models.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "net.sf.json.*" %>
  
 
  
<%
   int pagenum = request.getParameter("page") != null?Integer.valueOf(request.getParameter("page").toString()) : 1;
   int num = request.getParameter("num") != null?Integer.valueOf(request.getParameter("num").toString()) : 20;
   List<gycuser> us = HibernateDatabase.getInstance().queryLimitData("from gycuser", (pagenum - 1) * num, pagenum * num);
   ConstFunction.sendDataToClient(JSONArray.fromObject(us).toString(), response, true);
%>



