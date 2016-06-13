package com.guozz.junit.test;

import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

public class testListInEasyMock {

	@Test  
	public void testListInEasyMock() {  
	    List list = EasyMock.createMock(List.class);  
	    // ¼�ƹ���  
	   
	    // ��������list.set(0,1)ִ��2�Σ�����null�����׳��쳣  
	    expect1: EasyMock.expect(list.set(0, 1)).andReturn(null).times(2);  
	    // ��������list.set(0,1)ִ��1�Σ�����null�����׳��쳣  
	    expect2: EasyMock.expect(list.set(0, 1)).andReturn(1);  
	   
	    // ִ�в��Դ���  
	    EasyMock.replay(list);  
	        // ִ��list.set(0,1)��ƥ��expect1�������᷵��null  
	    Assert.assertNull(list.set(0, 1));  
	        // ִ��list.set(0,1)��ƥ��expect1����Ϊexpect1����ִ�д˷���2�Σ����᷵��null  
	    Assert.assertNull(list.set(0, 1));  
	        // ִ��list.set(0,1)��ƥ��expect2���᷵��1  
	    Assert.assertEquals(1, list.set(0, 1));  
	   
	    // ��֤����  
	    EasyMock.verify(list);  
	}  
}
