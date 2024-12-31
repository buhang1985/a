package iih.mi.bd.s.bp;

import iih.bd.base.utils.FMapUtils;
import iih.mi.bd.d.DischargedStatusCompDTO;
import iih.mi.bd.s.bp.sql.FindDischargedStatusCompMapByHisIdsSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据HIS出院状态主键集合查询出院状态对照字典业务逻辑
 * 
 * @author hao_wu 2018-6-21
 *
 */
public class FindDischargedStatusCompMapByHisIdsBp {

	public FMap2 exec(String hpId, String[] dischargedStatusIds) throws BizException {
		DischargedStatusCompDTO[] dischargedStatusCompDTOs = findDischargedStatusCompByHisIds(hpId,
				dischargedStatusIds);
		FMap2 result = FMapUtils.getFMap2("Id_leveldise", dischargedStatusCompDTOs);
		return result;
	}

	private DischargedStatusCompDTO[] findDischargedStatusCompByHisIds(String hpId, String[] dischargedStatusIds)
			throws BizException {
		FindDischargedStatusCompMapByHisIdsSql qry = new FindDischargedStatusCompMapByHisIdsSql(hpId,
				dischargedStatusIds);
		DischargedStatusCompDTO[] result = (DischargedStatusCompDTO[]) AppFwUtil.getDORstWithDao(qry,
				DischargedStatusCompDTO.class);
		return result;
	}

}
