package iih.en.pv.s.bp.op.st;

import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 挂号结算BP 与费用相关都处理在这里
 * 
 * @author yankan
 * @since 2015-12-08
 */
public class SettleBP {

	/**
	 * 结算收款
	 * 
	 * @param patId 患者id
	 * @param blList 账单集合
	 * @param payInfoDTO 支付信息
	 * @param oprId 操作员id
	 * @return
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] settle(String patId, RegInfoDTO regInfo, PayInfoDTO payInfoDTO,
			String oprId) throws BizException {
		// 1、获取划价信息
		FArrayList pricedArray = regInfo.getPricedinfo();
		BlcgoepAggDO blcgAggDO = (BlcgoepAggDO) (pricedArray.get(0));

		// 创建患者付款信息
		CreatePayOepBP createPayBP = new CreatePayOepBP();
		BlpaypatoepAggDO blpaypatoepAggDO = createPayBP.exec(patId, payInfoDTO,regInfo);

		// 2、结算
		IBLCiOrderToBlCgService blcgservice = ServiceFinder.find(IBLCiOrderToBlCgService.class);
		BlIncItmVsTypeDTO[] incTypeDTOs = blcgservice.SettlementPayment_Register(
				regInfo.getId_ent(), new BlcgoepAggDO[] { blcgAggDO }, blpaypatoepAggDO,
				FBoolean.TRUE, payInfoDTO.getFg_print());

		return incTypeDTOs;
	}
}
