package iih.bl.st.s.bp.oepcharge;

import iih.bl.st.dto.bloepregrefund.d.BlOepRegRefundDTO;
import iih.bl.st.dto.bloepregrefund.d.BlOepRegRefundRltDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import xap.mw.core.data.BizException;

/**
 * 门诊退号
 * @author ly 2019/07/16
 *
 */
public class BlOepRegRefundBP {

	/**
	 * 门诊退号
	 * @param refundDto 退号数据
	 * @param payOepPmDtos 支付方式信息
	 * @return 收费结果
	 * @throws BizException
	 */
	public BlOepRegRefundRltDTO exec(BlOepRegRefundDTO refundDto, BlPayOepPmDTO[] payOepPmDtos) throws BizException{
		
		return null;
	}
}
