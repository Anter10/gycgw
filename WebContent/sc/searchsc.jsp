<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.hskj.common.*" %>
<%@ page import = "com.hskj.models.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "net.sf.json.*" %>
 
 
<%
   int pagenum = request.getParameter("page") != null?Integer.valueOf(request.getParameter("page").toString()) : 1;
   int num = request.getParameter("num") != null?Integer.valueOf(request.getParameter("num").toString()) : 20;

   String search = request.getParameter("search") != null?request.getParameter("search").toString() : "李清照";
   List<gycuser> us = HibernateDatabase.getInstance().queryLimitData("from shici where shiren LIKE '%"+search+"%' or title LIKE '%"+search+"%'",(pagenum - 1) * num, pagenum * num);;
   ConstFunction.sendDataToClient(JSONArray.fromObject(us).toString(), response, true);
%>