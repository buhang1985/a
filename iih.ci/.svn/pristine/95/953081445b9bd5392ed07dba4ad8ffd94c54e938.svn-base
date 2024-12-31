package iih.ci.sdk.database;

import java.util.List;
import java.util.Map;

import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.exception.DbException;

/**
 * 数据库访问工具类
 * @author wangqingzhu
 *
 */
public class SqlParamDbUtils {
	/**
	 * 查询数据集合
	 * @param p
	 * @param t
	 * @return
	 * @throws BizException 
	 */
	public static <T> List<T> Q(SqlParamBuilder p, Class<?> c) throws BizException{
		return (List<T>) new DAFacade().execQuery(p.getSql(), p, new BeanListHandler(c));
	}
	
	/**
	 * 单值查询
	 * @param p
	 * @param field
	 * @return
	 * @throws BizException
	 */
	public static <T> List<T> Vs(SqlParamBuilder p,String field) throws BizException{
		return (List<T>) new DAFacade().execQuery(p.getSql(), p, new ColumnListHandler(field));
	}
	
	/**
	 * 单值查询
	 * @param p
	 * @param field
	 * @return
	 * @throws BizException
	 */
	public static <T> T V(SqlParamBuilder p,String field) throws BizException{
		return (T) new DAFacade().execQuery(p.getSql(), p, new ColumnHandler(field));
	}
	
	/**
	 * 单值查询集合
	 * @param p
	 * @param field
	 * @return
	 * @throws BizException
	 */
	public static <T> List<T> Q(SqlParamBuilder p,String field) throws BizException{
		return (List<T>) new DAFacade().execQuery(p.getSql(), p, new ColumnListHandler(field));
	}
	
	/**
	 * 宽松结果集查询
	 * @param p
	 * @return
	 * @throws BizException
	 */
	public static ListMapRecordSet Q(SqlParamBuilder p) throws BizException{
		return new ListMapRecordSet((List<Map<String, Object>>) new DAFacade().execQuery(p.getSql(), p, new MapListHandler()));
	}
	
	public static MapRecordSet Qm(SqlParamBuilder p) throws BizException{
		return new MapRecordSet((Map<String, Object>) new DAFacade().execQuery(p.getSql(), p, new MapHandler()));
	}
	
	/**
	 * 获取拼音码
	 * @param name 名称
	 * @return
	 */
	public static String PyCodeFrom(String name){
		return CnToPy.getPyFirstCode(name);
	}
	/**
	 * 获取五笔码
	 * @param name 名称
	 * @return
	 */
	public static String WbCodeFrom(String name){
		return CnToWB.getWBCode(name);
	}	
	
	/**
	 * 可以执行更新，删除，插入 数据操作，不能执行查询
	 * @param ps
	 * @throws BizException
	 */
	public static void W(SqlParamBuilder[] ps) throws BizException {
		PersistMgr persist = null;
		PersistSession session = null;
		try {
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();
			if (null != ps && ps.length > 0){
				for (SqlParamBuilder p : ps) {
					
					session.addBatch(p.getSql(),p);
				}
			}
			session.execBatch();
		} 
		catch (DbException e) {
			throw new BizException(e.getMessage());
		} finally {
			if (session != null)
				session.closeAll();
			if (persist != null)
				persist.release();
		}

	}
}
