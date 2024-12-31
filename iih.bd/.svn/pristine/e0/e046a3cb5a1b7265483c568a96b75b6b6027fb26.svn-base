package iih.bd.base.database;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 数据库访问工具类
 * @author wangqingzhu
 *
 */
public class DatabaseUtils {
	/**
	 * 查询数据集合
	 * @param p
	 * @param t
	 * @return
	 * @throws BizException 
	 */
	public static <T> List<T> Q(SqlConditionsParameter p, Class c) throws BizException{
		return (List<T>) new DAFacade().execQuery(p.getSql(), p.getParam(), new BeanListHandler(c));
	}
	/**
	 * 单值查询
	 * @param p
	 * @param field
	 * @return
	 * @throws BizException
	 */
	public static <T> T V(SqlConditionsParameter p,String field) throws BizException{
		return (T) new DAFacade().execQuery(p.getSql(), p.getParam(), new ColumnHandler(field));
	}
	
	/**
	 * 单值查询集合
	 * @param p
	 * @param field
	 * @return
	 * @throws BizException
	 */
	public static <T> List<T> Q(SqlConditionsParameter p,String field) throws BizException{
		return (List<T>) new DAFacade().execQuery(p.getSql(), p.getParam(), new ColumnListHandler(field));
	}
	
	/**
	 * 宽松结果集查询
	 * @param p
	 * @return
	 * @throws BizException
	 */
	public static ListMapRecordSet Q(SqlConditionsParameter p) throws BizException{
		return new ListMapRecordSet((List<Map<String, Object>>) new DAFacade().execQuery(p.getSql(), p.getParam(), new MapListHandler()));
	}
}
