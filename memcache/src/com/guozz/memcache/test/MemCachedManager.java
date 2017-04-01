package com.guozz.memcache.test;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class MemCachedManager {

	// ����ȫ�ֵ�Ψһʵ��  
    protected static MemCachedClient mcc = new MemCachedClient();  
    
    protected static MemCachedManager memCachedManager = new MemCachedManager();  	
    
 // �����뻺������������ӳ�  
    static {  
        // �������б�����Ȩ��  
        String[] servers = { "127.0.0.1:11211" };  
        Integer[] weights = {3};  
  
        // ��ȡsocke���ӳص�ʵ������  
        SockIOPool pool = SockIOPool.getInstance();  
  
        // ���÷�������Ϣ  
        pool.setServers(servers);  
        pool.setWeights(weights);  
  
        // ���ó�ʼ����������С������������Լ������ʱ��  
        pool.setInitConn(5);  
        pool.setMinConn(5);  
        pool.setMaxConn(250);  
        pool.setMaxIdle(1000 * 60 * 60 * 6);  
  
        // �������̵߳�˯��ʱ��  
        pool.setMaintSleep(30);  
  
        // ����TCP�Ĳ��������ӳ�ʱ��  
        pool.setNagle(false);  
        pool.setSocketTO(3000);  
        pool.setSocketConnectTO(0);  
  
        // ��ʼ�����ӳ�  
        pool.initialize();  
  
        // ѹ�����ã�����ָ����С����λΪK�������ݶ��ᱻѹ��  
       // mcc.setCompressEnable(true);  
        //mcc.setCompressThreshold(64 * 1024);  
    }  
  
    /** 
     * �����͹��췽����������ʵ������ 
     *  
     */  
    protected MemCachedManager() {  
  
    }  
  
    /** 
     * ��ȡΨһʵ��. 
     *  
     * @return 
     */  
    public static MemCachedManager getInstance() {  
        return memCachedManager;  
    }  
  
    /** 
     * ����һ��ָ����ֵ��������. 
     *  
     * @param key 
     * @param value 
     * @return 
     */  
    public boolean add(String key, Object value) {  
        return mcc.add(key, value);  
    }  
  
    public boolean add(String key, Object value, Date expiry) {  
        return mcc.add(key, value, expiry);  
    }  
  
    public boolean replace(String key, Object value) {  
        return mcc.replace(key, value);  
    }  
  
    public boolean replace(String key, Object value, Date expiry) {  
        return mcc.replace(key, value, expiry);  
    }  
  
    /** 
     * ����ָ���Ĺؼ��ֻ�ȡ����. 
     *  
     * @param key 
     * @return 
     */  
    public Object get(String key) {  
        return mcc.get(key);  
    }  
  
    public static void main(String[] args) {  
        MemCachedManager cache = MemCachedManager.getInstance();  
        cache.add("hello", 234);  
        cache.add("aa", 22);  
        System.out.print("get value : " + cache.get("hello"));  
        System.out.print("get value : " + cache.get("aa"));  
    }  
    
    
    
}