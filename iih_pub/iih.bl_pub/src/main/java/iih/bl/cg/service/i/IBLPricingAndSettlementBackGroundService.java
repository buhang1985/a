package iih.bl.cg.service.i;

import iih.bl.cg.service.d.OperatorInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 *  后台程序：用于患者离院未结算的情况下自动结算。
 *  
 * @author tcy
 * @since 2017-5-24
 *
 */
public interface IBLPricingAndSettlementBackGroundService {
	/**
	 * 用于患者离院未结算的情况下自动结算。
	 *	目前仅支持商保记账结算。 
	 *@param days 结算距今天的头几个自然日的费用信息
	 * @throws BizException
	 */
	public abstract FBoolean PriceAndSettlementPayment_hpcg_background()  throws BizException;
	

}
