package com.hskj.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ConstFunction {
    public static void sendDataToClient(String data,HttpServletResponse response ) throws IOException {
    	 response.setHeader("Access-Control-Allow-Origin", "*");
    	 response.getWriter().write(data);
    	 response.getWriter().flush();
    }
}
