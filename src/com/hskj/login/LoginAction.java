package com.hskj.login;
 
import com.hskj.common.HskjAction;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends HskjAction {
    
 
	public boolean issecure(){
		System.out.print("安全码 = "+this.getSecurecode()+ "  关联ID = "+this.getLinkroleid());
		if (this.getSecurecode().isEmpty() == false && this.getLinkroleid().isEmpty() == false){
			return true;
		}
		return false;
	}
	
	
	@Override 
	public void validate(){
		
	}
	
	@Override 
	 public String execute() throws Exception{
		try{
			System.out.println("安全码 - "+ this.getSecurecode());
			 return "suc";
		 }catch(Exception  ex){
			 return "CANCEL";
		 }
	}
	
    
}
