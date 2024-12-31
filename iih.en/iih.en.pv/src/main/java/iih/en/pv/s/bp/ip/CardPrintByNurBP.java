package iih.en.pv.s.bp.ip;

import xap.mw.core.data.BizException;

/**
 * 床位卡打印 - 我的病人规则
 * 
 * @author zhengcm
 * @date 2016-07-28 14:35:34
 *
 */

public class CardPrintByNurBP {

	/**
	 * 查询条件
	 * 
	 * @author zhengcm
	 * @param wardId
	 *            当前病区
	 * @param nursId
	 *            当前人员
	 * @return
	 * @throws BizException
	 */
	public String getSqlCond(String wardId, String nursId) throws BizException {
		String cond = "ent.id_dep_nur = '" + wardId + "' and ent.id_emp_nur = '" + nursId + "'";
		return cond;
	}

}
