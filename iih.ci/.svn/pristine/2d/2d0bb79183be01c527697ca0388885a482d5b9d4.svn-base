package iih.ci.mr.cimrpatsigns.s.bp;

import iih.ci.mr.cimrpatsigns.d.PatDTO;
import iih.ci.mr.cimrpatsigns.s.bp.qry.CimrpatSignsSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class CimrpatSignsbp {
	public PatDTO[] ExecuteQuery(String code_entp, String sd_status, String id_dep_nur,
			String whereStr) throws BizException {

		CimrpatSignsSql sql = new CimrpatSignsSql(code_entp, sd_status,
				id_dep_nur, whereStr);

		PatDTO[] rtn = (PatDTO[]) AppFwUtil.getDORstWithDao(sql, PatDTO.class);
		return rtn;
	}
}
