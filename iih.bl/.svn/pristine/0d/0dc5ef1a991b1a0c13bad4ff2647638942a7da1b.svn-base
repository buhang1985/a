package iih.bl.pay.s.bp;

import iih.bd.utils.CommDAFacade;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import iih.bl.pay.s.bp.qry.GetPayPatListByIdPatPmQry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 
 * @author yang.lu2018年3月28日
 *
 */
public class GetPayPatListByIdPatPmBP {

	/**
	 * 获取第三方支付记录信息
	 * 
	 * @param patId患者编号
	 * @param pmId支付项目
	 * @return
	 * @throws BizException
	 */
	public BlPayPatItemDTO[] exec(String patId, String pmId) throws BizException {
		if (!StringUtil.isEmpty(patId) && !StringUtil.isEmpty(pmId)) {
			BlPayPatItemDTO[] dtos = (BlPayPatItemDTO[]) CommDAFacade.execQuery(new GetPayPatListByIdPatPmQry(patId, pmId), BlPayPatItemDTO.class);
			return dtos;
		}
		return null;
	}
}
