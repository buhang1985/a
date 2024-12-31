package iih.bd.srv.ortpl.utils;

import java.util.List;

import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class OrtmplUtils {

	/**
	 * 查询DO集合泛型类
	 * 
	 * @param classtype
	 * @param sqlQry
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> GetQueryResulte(@SuppressWarnings("rawtypes") Class classtype, String sqlQry) throws Exception {

		SqlParam sqlParam = new SqlParam();
		
		DAFacade dAFacade = new DAFacade();
		return (List<T>) dAFacade.execQuery(sqlQry.toString(), sqlParam, new BeanListHandler(classtype));
	}
}
