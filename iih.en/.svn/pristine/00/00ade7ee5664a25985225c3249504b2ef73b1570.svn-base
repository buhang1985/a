package iih.en.pv.s.bp.ip;

import xap.mw.core.data.BizException;

/**
 * 床位卡打印 - 今日规则
 * 
 * @author zhengcm
 * @date 2016-07-28 14:34:44
 *
 */

public class CardPrintByDayBP {

	/**
	 * 查询条件
	 * 
	 * @author zhengcm
	 * @param wardId
	 *            当前病区
	 * @return
	 * @throws BizException
	 */
	public String getSqlCond(String wardId) throws BizException {
		return "ent.id_dep_nur = '" + wardId + "' and (substr(ent.dt_entry,0,10) = to_char(sysdate,'yyyy-MM-dd'))";
	}

}
