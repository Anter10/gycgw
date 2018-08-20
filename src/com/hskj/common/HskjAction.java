package com.hskj.common;
 
import com.opensymphony.xwork2.ActionSupport;

public class HskjAction extends ActionSupport {
    public String securecode = "";
    public String linkroleid = "";
    
	public String getLinkroleid() {
		return linkroleid;
	}

	public void setLinkroleid(String linkroleid) {
		this.linkroleid = linkroleid;
	}

	public String getSecurecode() {
		return securecode;
	}

	public void setSecurecode(String securecode) {
		this.securecode = securecode;
	}
 
	
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
			 return "ABOUT";
		 }catch(Exception  ex){
			 return "CANCEL";
		 }
	}
	
    
}
