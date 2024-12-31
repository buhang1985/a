package iih.ci.mr.s.bp;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.ci.mr.cimrpatsigns.d.VitalSignsDTO;
import iih.ci.mr.s.bp.qry.VitalSignsSql;

public class VitalSignsbp {

	public VitalSignsDTO[] exec(String id_ent, String beginDate, String endDate)
			throws BizException {
		
		VitalSignsSql Sql = new VitalSignsSql(id_ent, beginDate, endDate);
		
		return (VitalSignsDTO[]) AppFwUtil.getDORstWithDao(Sql,
				VitalSignsDTO.class);

	}
}
