package iih.en.pv.s.bp.ip;

import xap.mw.core.data.BizException;

/**
 * 床位卡打印 - 当前科室规则
 * 
 * @author zhengcm
 * @date 2016-07-28 14:35:01
 *
 */

public class CardPrintByDeptBP {

	/**
	 * 查询条件
	 * 
	 * @author zhengcm
	 * @param wardId
	 *            当前病区
	 * @param depId
	 *            当前科室
	 * @return
	 * @throws BizException
	 */
	public String getSqlCond(String wardId, String depId) throws BizException {
		return "ent.id_dep_nur = '" + wardId + "' and ent.id_dep_phy = '" + depId + "'";
	}

}
