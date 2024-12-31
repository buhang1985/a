package iih.bl.pay.s.bp.ip;

import iih.bd.utils.CommDAFacade;
import iih.bl.pay.s.bp.ip.qry.CanUsePrepayForIpPayNewQry;
import iih.bl.st.payment.d.BlIpPrePayPatDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 获取可用预交金记录
 * 
 * @author wq.li
 * @date 2018年8月10日
 */
public class GetCanUsePrepayForIpPayNewBP {
	/**
	 * 获取可用预交金记录
	 * @param entId
	 * @return
	 * @throws BizException
	 * @date 2018年8月10日
	 * @author wq.li
	 */
	public BlIpPrePayPatDTO[] exec(String entId) throws BizException {

		if (StringUtil.isEmpty(entId)) {
			return null;
		}

		BlIpPrePayPatDTO[] dtos = (BlIpPrePayPatDTO[]) CommDAFacade.execQuery(new CanUsePrepayForIpPayNewQry(entId),
				BlIpPrePayPatDTO.class);

		return dtos;
	}
}
