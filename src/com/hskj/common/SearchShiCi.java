package com.hskj.common;
 
import com.hskj.common.HskjAction;
import com.opensymphony.xwork2.ActionSupport;

public class SearchShiCi extends HskjAction {
    private String search;
    
    
 
	public String getSearch() {
		return search;
	}


	public void setSearch(String searchText) {
		this.search = searchText;
	}


	public boolean issecure(){
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
			 if(this.issecure() && this.getSearch() != null) {
				 return "suc";
			 }else {
				 return "err";
			 }
		 }catch(Exception  ex){
			 return "err";
		 }
	}
	
    
}
