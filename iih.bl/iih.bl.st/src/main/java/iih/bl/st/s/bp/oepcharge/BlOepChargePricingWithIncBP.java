package iih.bl.st.s.bp.oepcharge;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.comm.IBlFlowKeyConst;
import iih.bl.comm.log.BLTimeLogger;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingRltDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingRltHdDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeSetDTO;

import java.util.Arrays;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * 门诊划价(含发票预拆信息)
 * @author ly 2019/05/07
 *
 */
public class BlOepChargePricingWithIncBP {

	/**
	 * 门诊划价(含发票预拆信息)
	 * @param dtos 明细信息
	 * @param chargeSet 门诊收费配置信息
	 * @return 划价结果
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlOepChargePricingRltHdDTO exec(BlOepChargePricingDTO[] dtos, BlOepChargeSetDTO chargeSet) throws BizException{
		
		BLTimeLogger timeLogger = new BLTimeLogger();
		timeLogger.begin("门诊划价");
		//原划价逻辑
		BlOepChargePricingBP pricingBp = new BlOepChargePricingBP();
		BlOepChargePricingRltDTO[] detail = pricingBp.exec(dtos, chargeSet);
		timeLogger.end("门诊划价");
		
		//获取上下文数据
		List<BlCgItmOepDO> cgItmList = (List<BlCgItmOepDO>)Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_PRICING_CG);
		BlStOepDO stDO = (BlStOepDO)Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_PRICING_ST);
		
		BlOepChargePricingRltHdDTO rlt = new BlOepChargePricingRltHdDTO();
		rlt.setId_stoep(stDO.getId_stoep());
		rlt.setCode_st(stDO.getCode_st());
		
		FArrayList cgFList = new FArrayList();
		cgFList.addAll(Arrays.asList(detail));
		rlt.setCgdetail(cgFList);
		
		//发票预分票
		IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
		BlincoepAggDO[] incAggDos = incService.preSplitInvoice(cgItmList.toArray(new BlCgItmOepDO[0]));
		
		rlt.setQuan_inc(incAggDos.length);
		return rlt;
	}
}
