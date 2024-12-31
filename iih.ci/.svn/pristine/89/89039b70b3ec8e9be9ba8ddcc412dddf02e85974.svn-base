package iih.ci.ord.s.bp;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class CertifyPsnPresAuthorityBP {

	public boolean exec(String id_psn) throws BizException {

		return getQueryResult(id_psn);
	}

	/**
	 * 查询
	 * @param id_psn
	 * @return
	 * @throws BizException
	 */
	private boolean getQueryResult(String id_psn) throws BizException {

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_psn);
		
		String sqlStr = "select fg_presrt,drid from bd_emp_phy where ds<1 and id_psndoc = ?  ";

		List<Map<String, Object>> sqlRst = (List<Map<String, Object>>) (new DAFacade().execQuery(sqlStr, sqlParam, new MapListHandler()));

		if (sqlRst == null || sqlRst.size() <= 0)
			return false;
		String fg_presrt = (String) sqlRst.get(0).get("fg_presrt");
		String drid = (String) sqlRst.get(0).get("drid");

		return fg_presrt != null && fg_presrt.equals("Y") && drid != null;
	}
}
