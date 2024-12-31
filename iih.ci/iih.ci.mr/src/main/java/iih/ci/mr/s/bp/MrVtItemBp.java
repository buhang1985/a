package iih.ci.mr.s.bp;

import iih.bd.srv.mrtplvt.d.MrtplVtItmDO;
import iih.ci.mr.s.bp.qry.MrVtItemSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class MrVtItemBp {

	/**
	 * 获取生命体征模板先全部项目(xuxing_2016-05-03)
	 * @param id_mrtplvt
	 * @return
	 * @throws BizException
	 */
	public MrtplVtItmDO[] exec(String id_mrtplvt) throws BizException {
		
		MrVtItemSql SqlPara = new MrVtItemSql(id_mrtplvt);
		
		MrtplVtItmDO[] rtn = (MrtplVtItmDO[]) AppFwUtil.getDORstWithDao(SqlPara, MrtplVtItmDO.class);
		
		return rtn;
	}
}
