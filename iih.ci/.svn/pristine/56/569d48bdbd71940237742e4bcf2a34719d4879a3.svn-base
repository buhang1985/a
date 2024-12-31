package iih.ci.mr.s.bp;

import iih.ci.mr.s.bp.qry.HisSignsDataSql;
import iih.mp.nr.getnewtem.d.HisSignDataDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class HisSignDataBp {

	
	/**
	 * 获取患者某天历史体温数据
	 * @param id_ents
	 * @param id_mrtplvt
	 * @param dt_vt
	 * @param id_srvvt
	 * @return
	 * @throws BizException
	 */
	public HisSignDataDTO[] exec(String id_ents, String id_mrtplvt, String dt_vt,String id_srvvt) throws BizException {

		HisSignsDataSql Sql = new HisSignsDataSql(id_ents, id_mrtplvt, dt_vt, id_srvvt);
		
		HisSignDataDTO[] rtn = (HisSignDataDTO[]) AppFwUtil.getDORstWithDao(Sql, HisSignDataDTO.class);
		
		return rtn;
	}

}
