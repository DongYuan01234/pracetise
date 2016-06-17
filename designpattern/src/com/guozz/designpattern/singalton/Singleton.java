package com.guozz.designpattern.singalton;

public class Singleton {

	private static Singleton singleton=null;
	
	private Singleton(){
		System.out.println("--------����Singleton--------");
	}
	
	public synchronized static Singleton getInstance(){
		if(singleton==null){
			singleton= new Singleton();
		}
		return singleton;
	}
}
