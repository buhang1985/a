package iih.ci.mr.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.ci.mr.s.bp.qry.GetHisDataSql;
import iih.mp.nr.getnewtem.d.HisDataDTO;

public class GetHisDataBp {
	/**
	 * 查询三天内体温是否正常
	 * @param id_ents
	 * @param id_mrtplvt
	 * @param threedays
	 * @param dt_vt
	 * @return
	 * @throws BizException
	 */
	public HisDataDTO[] exc(String id_ents,String id_mrtplvt,FDateTime threedays,FDateTime dt_vt) throws BizException{
		GetHisDataSql sql = new GetHisDataSql(id_ents, id_mrtplvt, threedays, dt_vt);
		HisDataDTO[] rtn = (HisDataDTO[]) AppFwUtil.getDORstWithDao(sql, HisDataDTO.class); 
		return rtn;
		
	}
}
