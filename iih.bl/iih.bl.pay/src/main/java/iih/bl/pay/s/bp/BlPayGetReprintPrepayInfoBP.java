package iih.bl.pay.s.bp;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取重打预交金患者信息
 * 
 * @author
 *
 */
public class BlPayGetReprintPrepayInfoBP {

	/**
	 * 获取重打预交金患者信息 校验传入id与收据编号是否匹配
	 * 
	 * @param patId
	 *            患者id
	 * @param repCode
	 *            预交金收据编号
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO exec(String patId, String repCode, String paypatId) throws BizException {

		if (StringUtil.isEmpty(repCode)) {
			throw new BizException("票据号为空");
		}
		if (StringUtil.isEmpty(patId) && StringUtil.isEmpty(paypatId)) {
			throw new BizException("患者编码或支付记录编码为空");
		}
		// 1根据patID和repCode查询需要重打的票据信息
		IBlpaypatRService service = ServiceFinder.find(IBlpaypatRService.class);
		String strWhere = "a0.CODE_REP='" + repCode + "'";
		if (!StringUtil.isEmpty(patId)) {
			strWhere += " AND a0.id_pat='" + patId + "'";
		}
		if (!StringUtil.isEmpty(paypatId)) {
			strWhere += " AND a0.id_paypat='" + paypatId + "'";
		}
		
		strWhere += " AND a0.fg_canc = 'N' ";
		
		BlPrePayPatDO[] prePayPats = service.find(strWhere, "", FBoolean.FALSE);
		
		if (prePayPats == null || prePayPats.length <= 0) {
			throw new BizException("人员和发票信息不一致");
		}
		if (prePayPats == null || prePayPats.length > 1) {
			throw new BizException("该患者拥有多条票据号为" + repCode + "记录,请联系管理员");
		}
		return prePayPats[0];
	}
}
