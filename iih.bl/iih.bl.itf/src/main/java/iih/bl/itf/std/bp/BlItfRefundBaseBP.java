package iih.bl.itf.std.bp;

import iih.bl.itf.custom.thirdpay.d.BlThirdPayRefundDTO;
import iih.bl.itf.custom.thirdpay.d.BlThirdPayReturnDTO;
import xap.mw.core.data.BizException;
/**
 * 第三方非窗口退费基类
 * @author zhangxin
 * @date 2019年9月18日
 */
public  class BlItfRefundBaseBP {
	/**
	 * 第三方窗口退费
	 * @param refundDto
	 * @return
	 * @throws BizException
	 */
    public  BlThirdPayReturnDTO refund(BlThirdPayRefundDTO refundDto) throws BizException {
		return null;
	}
  
}
