package iih.pmp.pay.web.pay.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WXPayLock {
	Map locks = new HashMap();  
	private List lockKeys = new ArrayList();  
	
	public Object  getLockkeys(String uid){
		 Object lockKey = lockKeys.get(uid.hashCode() % lockKeys.size());  
		   Object lock = locks.get(lockKey);		   
		   return lock;
	}
	
	private WXPayLock(){
		for(int i=1;i<=10000;i++) {  
			   Object lockKey = new Object();  
			   lockKeys.add(lockKey);  
			    locks.put(lockKey, new Object());  
			}  
	}
	
	private static WXPayLock _instance;
	
	public static WXPayLock getInstance(){
		if(_instance==null)_instance=new WXPayLock();
		return _instance;
	}

}
