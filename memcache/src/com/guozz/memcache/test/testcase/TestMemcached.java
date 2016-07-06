package com.guozz.memcache.test.testcase;

import org.junit.Test;

import com.guozz.memcache.test.MemCachedManager;
import com.guozz.memcache.test.data.TBean;

import junit.framework.TestCase;

public class TestMemcached extends TestCase{

	private static MemCachedManager cache;  
	  
    @Test  
    public void testCache() {  
          
        TBean tb = new TBean();  
        tb.setName("E�����1");  
        cache.add("bean", tb);  
          
        TBean tb1 = (TBean) cache.get("bean");  
        System.out.println("name=" + tb1.getName());  
        tb1.setName("E�����_�޸ĵ�");  
          
        tb1 = (TBean) cache.get("bean");  
        System.out.println("name=" + tb1.getName());  
        System.out.println("-----------");
    }  
  
    @Override  
    protected void setUp() throws Exception {  
        super.setUp();  
        cache = MemCachedManager.getInstance();  
    }  
  
    @Override  
    protected void tearDown() throws Exception {  
        super.tearDown();  
        cache = null;  
    }  
  
}
