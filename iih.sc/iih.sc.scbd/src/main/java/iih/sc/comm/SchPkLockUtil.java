package iih.sc.comm;

import iih.sc.sch.scsch.d.ScSchDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;

/**
 * Sc_Sch加锁帮助类
 * 
 * @author liubin
 *
 */
public class SchPkLockUtil {
	private static final String Key_Lock = "KEY_SC_SCH_";
	
	private static final String Key_Lock_Appl = "KEY_SC_APT_APPL_";
	
	private static final long Default_Timeout_Ms= 5000;
	
	private static final String Key_Ctx_Lock_type = "Key_Ctx_Lock_type";
	
	private static final String Key_Ctx_Timeout_Ms = "Key_Ctx_Timeout_Ms";
	
	/**
	 * 添加动态锁
	 * 
	 * @param schId
	 * @return
	 */
	public static boolean lock(String schId) throws BizException {
		if(isDistributedLock())
			return addDynamicLock(schId);
		return databaseRowLock(schId);
	}
	/**
	 * 加锁，必须调用releaseLock释放锁
	 * 
	 * @param schId
	 * @return
	 * @throws BizException
	 */
	public static boolean acquireLock(String schId) throws BizException {
		if(isDistributedLock())
			return PKLock.getInstance().acquireLock(getLockKey(schId), getTimeoutMS());
		return databaseRowLock(schId);
	}
	
	public static void releaseLock(String schId){
		PKLock.getInstance().releaseLock(getLockKey(schId));
	}
	/**
	 * 添加动态锁
	 * 
	 * @param schId
	 * @return
	 */
	private static boolean addDynamicLock(String schId){
		return PKLock.getInstance().addDynamicLock(getLockKey(schId), getTimeoutMS());
	}
	/**
	 * 数据库行锁
	 * 
	 * @param schId
	 * @return
	 * @throws BizException
	 */
	private static boolean databaseRowLock(String schId) throws BizException {
		String sql = "select * from sc_sch where id_sch = ? for update";
		SqlParam param = new SqlParam();
		param.addParam(schId);
		new DAFacade().execQuery(sql, param, new BeanListHandler(ScSchDO.class));
		return true;
	}
	
	/**
	 * 获取锁id
	 * 
	 * @param schId
	 * @return
	 */
	private static String getLockKey(String schId){
		return Key_Lock + schId;
	}
	/**
	 * 获取超时时间
	 * 
	 * @return
	 */
	private static long getTimeoutMS(){
		if(Context.get().getAttribute(Key_Ctx_Timeout_Ms) != null)
			return (long)Context.get().getAttribute(Key_Ctx_Timeout_Ms);
		int timeout = ScParamUtils.getScLockDistributedTime();
		long timeoutms = timeout < 0 ? Default_Timeout_Ms : timeout;
		Context.get().setAttribute(Key_Ctx_Timeout_Ms, timeoutms);
		return timeoutms;
	}
	/**
	 * 是否使用分布式锁
	 * 
	 * @return
	 */
	private static boolean isDistributedLock(){
		if(Context.get().getAttribute(Key_Ctx_Lock_type) != null)
			return (boolean)Context.get().getAttribute(Key_Ctx_Lock_type);
		String type = ScParamUtils.getScLockType();
		boolean isDistributedLock = "0".equals(type);
		Context.get().setAttribute(Key_Ctx_Lock_type, isDistributedLock);
		return isDistributedLock;
	}
}
