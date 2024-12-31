package iih.bd.srv.s.bp;

import iih.bd.srv.d.MrtplvtDTO;
import iih.bd.srv.s.bp.qry.GetMrtplvtDTObpSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class GetMrtplvtDTObp {

	public MrtplvtDTO[] exec(String Id_mtplvt) throws BizException {

		GetMrtplvtDTObpSql Sql = new GetMrtplvtDTObpSql(Id_mtplvt);

		return (MrtplvtDTO[]) AppFwUtil.getDORstWithDao(Sql, MrtplvtDTO.class);
	}
}
