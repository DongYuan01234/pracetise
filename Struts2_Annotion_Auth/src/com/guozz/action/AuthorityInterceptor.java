package com.guozz.action;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/** 
 * 用于拦截请求判断是否拥有权限的拦截器 
 *  
 * @author Administrator 
 * 
 */  
@SuppressWarnings("serial")
public class AuthorityInterceptor implements Interceptor {

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@SuppressWarnings("unused")
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		String methodName=actionInvocation.getProxy().getMethod();  
        Method currentMethod=actionInvocation.getAction()  
                   .getClass().getMethod(methodName, null);  
        //1、判断客户是否登陆  
        
        //从session获取当前客户信息 
        Employee employee=(Employee)ServletActionContext  
                    .getRequest().getSession().getAttribute("employee");  
        
        if(employee==null){  
        	 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");     
             System.out.println("客户还没登陆或登陆已超时！！！");     
             System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");  
             System.out.println();   
            return "index";  
        }  
      //2、进行权限控制判断  
        
        //如果该请求方法是需要进行验证的则需执行以下逻辑  
        if(currentMethod.isAnnotationPresent(Auth.class)){  
        	 //获取权限校验的注解  
        	Auth authority=currentMethod.getAnnotation(Auth.class);  
        	  //获取当前请求的注解的actionName     
            String actionName=authority.actionName();  
            //获取当前请求需要的权限     
            String privilege=authority.privilege();  
              
          //可以在此判断当前客户是否拥有对应的权限，如果没有可以跳到指定的无权限提示页面，如果拥有则可以继续往下执行。    
            
            //if(拥有对应的权限){  
            //    return actionInvocation.invoke();    
            //}else{  
            //    return "无权限";    
            //}  
              
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");     
            System.out.println("客户" + employee.getUserName() + "在" + new Date() + "执行了" + actionName+"方法，拥有"+privilege+"权限！！");     
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");  
            System.out.println();              
            return actionInvocation.invoke();  
        }  
          
        //3、进行非权限控制判断  
          
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");     
        System.out.println("我执行了没有？？");      
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++"); 
        return "index";  
	}

}
