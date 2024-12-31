package iih.mi.bd.s.bp;

import iih.bd.base.utils.FMapUtils;
import iih.mi.bd.d.DischargedStatusCompDTO;
import iih.mi.bd.s.bp.sql.FindDischargedStatusCompMapByHisCodesSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据HIS出院状态编码集合查询出院状态对照字典业务逻辑
 * 
 * @author hao_wu 2018-6-21
 *
 */
public class FindDischargedStatusCompMapByHisCodesBp {

	public FMap2 exec(String hpId, String[] dischargedStatusCodes) throws BizException {
		DischargedStatusCompDTO[] dischargedStatusCompDTOs = findDischargedStatusCompByHisCodes(hpId,
				dischargedStatusCodes);
		FMap2 result = FMapUtils.getFMap2("Code_leveldise", dischargedStatusCompDTOs);
		return result;
	}

	private DischargedStatusCompDTO[] findDischargedStatusCompByHisCodes(String hpId, String[] dischargedStatusCodes) throws BizException {

		FindDischargedStatusCompMapByHisCodesSql qry = new FindDischargedStatusCompMapByHisCodesSql(hpId,
				dischargedStatusCodes);
		DischargedStatusCompDTO[] result = (DischargedStatusCompDTO[]) AppFwUtil.getDORstWithDao(qry,
				DischargedStatusCompDTO.class);
		return result;
	
	}

}
