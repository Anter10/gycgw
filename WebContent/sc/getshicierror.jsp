<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.hskj.common.*" %>
<%@ page import = "com.hskj.models.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "net.sf.json.*" %>
  
 
  
<%
   JSONObject obj = new JSONObject();
   obj.put("show", "参数错误");
   ConstFunction.sendDataToClient(obj.toString(), response, false);
%>



