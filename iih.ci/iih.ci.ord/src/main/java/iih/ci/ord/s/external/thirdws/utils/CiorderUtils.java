package iih.ci.ord.s.external.thirdws.utils;

import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class CiorderUtils {
	
	/**
	   *    根据传的字段 和字段值 查询医嘱(该方法经测试只反一条  库里多条时也是一条 不适用反多条该方法)
	 * @param column
	 * @param columnValue
	 * @return
	 * @throws BizException
	 */
	public static CiOrderDO getCiOrderDO(String column,String columnValue) throws BizException {

		if (StringUtil.isEmpty(columnValue))
			return null;

		String sql = "select * from ci_order where "+ column +" = ? ";

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(columnValue);

		CiOrderDO ordDO = (CiOrderDO) new DAFacade().execQuery(sql, sqlParam, new BeanHandler(CiOrderDO.class));
		System.out.println("ordDo:"+(ordDO==null?"null":ordDO.toString()));
		return ordDO;
	}
}
