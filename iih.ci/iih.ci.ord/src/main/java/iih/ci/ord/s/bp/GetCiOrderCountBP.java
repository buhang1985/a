package iih.ci.ord.s.bp;

import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @ClassName:  GetCiOrderCountBP   
 * @description 获取医嘱数量
 * @author      chenxiang
 * @date        2019年12月27日 
 * @version:    1.0
 */
public class GetCiOrderCountBP {

	/**
	 * 根据医嘱id集合获得医嘱数量
	 * 
	 * @param idOrList	医嘱id集合
	 * @return
	 * @throws DAException 
	 */
	public int getCountByIds(String[] idOrArr) throws DAException {
		if (idOrArr == null || idOrArr.length == 0) {
			return 0;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("select count(1) from ci_order where id_or in (");
		StringBuilder inSql = new StringBuilder();
		SqlParam params = new SqlParam();
		for (String idOr : idOrArr) {
			inSql.append(",?");
			params.addParam(idOr);
		}
		sb.append(inSql.substring(1))
		  .append(")");
		return (int) new DAFacade().execQuery(sb.toString(), params, new ColumnHandler());
	}
}
