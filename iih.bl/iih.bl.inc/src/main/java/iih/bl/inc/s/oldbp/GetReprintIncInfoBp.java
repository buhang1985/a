package iih.bl.inc.s.oldbp;

import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.i.IBlincipMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取住院患者可重打的发票信息BP
 * 
 * @date 2018年6月21日
 * @author wq.li
 */
public class GetReprintIncInfoBp {
	/**
	 * @throws BizException
	 * 
	 * @Title: exec @Description: 获取住院患者可重打的发票信息 @param entId @return @return:
	 * BlStIpPayInvoceInfoDTO @author: wq.li @throws
	 */
	public BlIncIpDO exec(String stIpId) throws BizException {
		if (StringUtil.isEmpty(stIpId)) {
			throw new BizException("患者结算ID为空");
		}

		// 查询该患者可重打的发票信息
		IBlincipMDORService incIpService = ServiceFinder.find(IBlincipMDORService.class);
		BlIncIpDO[] incIpDos = incIpService.find("id_stip='" + stIpId + "'", "", FBoolean.FALSE);
		
		if (incIpDos == null || incIpDos.length == 0) {
			throw new BizException("该患者本次就诊发票信息为空，请确认是否有已打印发票");
		}
		return incIpDos[0];
	}

}
