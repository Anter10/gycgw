package com.hskj.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class ConstFunction {
    public static void sendDataToClient(String data,HttpServletResponse response, boolean suc) throws IOException {
    	 response.setHeader("Access-Control-Allow-Origin", "*");
    	 JSONObject obj = new JSONObject();
    	 if(suc) {
    	    obj.put("suc", true);
    	 }else {
    	    obj.put("suc", false); 
    	 }
    	 obj.put("data", data);
    	 response.getWriter().write(obj.toString());
    	 response.getWriter().flush();
    }
    
   
}
