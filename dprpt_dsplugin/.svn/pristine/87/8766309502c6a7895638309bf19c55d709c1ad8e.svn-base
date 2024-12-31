package iih.nmr.common;

import java.util.List;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;

import com.sun.rowset.CachedRowSetImpl;


public class GetResultbysql {

	/**
	 * 执行报表数据SQL查询
	 * @param strSql
	 * @param classinfo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Object getResultListBySql(String strSql,Class<?> classinfo) throws Exception {
		
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(classinfo);
		List<Object> result = (List<Object>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		
		return result;
	}

	/**
	 * 执行报表数据SQL查询
	 * @param strSql
	 * @param classinfo
	 * @return
	 * @throws Exception
	 */
	public Object getResulttBySql(String strSql,Class<?> classinfo) throws Exception {
		
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanHandler beanlist_handler = new BeanHandler(classinfo);
		Object rtn = beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		
		return rtn;
	}
}
