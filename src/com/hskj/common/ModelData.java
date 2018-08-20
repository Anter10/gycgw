package com.hskj.common;

public class ModelData<T> {
    private T data;
    private int id;
    
    public ModelData(){
    	
    }
 
    public void setId(int id){
    	this.id = id;
    }
    
    public int getId(){
    	return this.id;
    }
    
    public ModelData(T data){
    	this.data = data;
    }
    
    public T getData() {
        return this.data;
    }
    
    public void setData(T data){
    	this.data = data;
    }
}
