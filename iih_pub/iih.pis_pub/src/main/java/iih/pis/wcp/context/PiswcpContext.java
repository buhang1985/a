package iih.pis.wcp.context;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ymer.core.cache.SessionCacheMgr;
import com.ymer.core.util.CookieUtil;


/**
 * 上下文
 * @author guo.xiao
 *
 */
public class PiswcpContext {
	
//	public static final ConcurrentHashMap<String,String> userTokenMap = new ConcurrentHashMap<String,String>();

	/**
	 * 存放 反馈信息通知 
	 */
	private final static Map<String, Object> lruMap ;
	
	static{
		
		lruMap =  Collections.synchronizedMap(new LinkedHashMap<String, Object>(1000,(float) 0.75,false){
			/**
			 *序列号
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<String, Object> eldest) {
				return size() > 700;
			}
		});
	}

	/**
	 * 添加数据
	 * @param key
	 * @param value
	 */
	public static void addData(String key,Object value) {
		if (key == null) return;
		lruMap.put(key, value);
	}
	
	/**
	 * 查询数据
	 * @param key
	 * @return
	 */
	public static Object getData(String key){
		 Object value = lruMap.get(key);
		 return value;
	}
	
	/**
	 * token失效,异常码
	 */
	public static final int token_failure_code = 12;
	
	/**
	 * 获取上下文用户id
	 * @return  userId 用户id
	 */
	public static String getContextUserId(){
		String userId = (String)SessionCacheMgr.getSessionCache().get(CookieUtil.getSessionId());
		return userId;
	}
	
	
	/**
	 * 设置上下文用户id
	 * @param id_user  用户id
	 */
	public static void setContextUserId(String id_user){
		String sessid = CookieUtil.getSessionId();
		SessionCacheMgr.getSessionCache().put(sessid, id_user);
		
	}
}
