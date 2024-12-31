package iih.ci.ord.s.external.common.bp;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取最大排序号
 * @author HUMS
 *
 */
public class GetOrdMaxSortnoBP {

	public Integer exec (String id_en) throws BizException{
		
		SqlParam param = new SqlParam();
		param.addParam(id_en);
		
		String sql = "select max(nvl(sortno,0)) from ci_order where id_en = ?";
		Integer result = (Integer) new DAFacade().execQuery(sql, param, new ColumnHandler());
		if(result==null){
			return 0;
		}
		return result;
	}
}
