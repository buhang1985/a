package iih.bl.cg.oep.s;

import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.oep.i.IOepSettlementService;
import iih.bl.cg.oep.s.bp.IncDataPrintNoIncnoBP;
import iih.bl.cg.oep.s.bp.IncDataUsedPrintBp;
import iih.bl.cg.oep.s.bp.PricingBp;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.s.bp.SettlementPayBp;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

@Service(serviceInterfaces = { IOepSettlementService.class }, binding = Binding.JSONRPC)
public class OepSettlementImpl implements IOepSettlementService {
	/** 门诊收费划价接口
	 * @param appendBillParamDTOs 记账明细信息
	 * @param operatorInfoDTO 操作人员信息
	 * @param PrintInvocie 是否打印发票
	 * @return 记账后明细信息
	 * @throws BizException
	 * 
	 * @Author yangyang
	 */
	@Override
	public BlCgOepAggDTO chargeFee(
			BlOrderAppendBillParamDTO[] appendBillParamDTOs,
			OperatorInfoDTO operatorInfoDTO, FBoolean PrintInvocie)
			throws BizException {
		PricingBp handlerBp = new PricingBp();
		return handlerBp.exec(appendBillParamDTOs, operatorInfoDTO, PrintInvocie);
	}

	/**自费场景下的付费接口
	 * @return
	 * @throws BizException
	 * 
	 * @Author yangyang
	 */
	@Override
	public BlIncItmVsTypeDTO[] paySelf(BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO, FBoolean IsDrugApplication, FBoolean PrintInvoice, FBoolean IsTransferPrepay) throws BizException {
		SettlementPayBp settlementBp=new SettlementPayBp();
		return settlementBp.exec(blcgoepAggDO, blpaypatoepAggDO, IsDrugApplication, PrintInvoice, IsTransferPrepay);
	}
	
	/**
	 * 打印发票（发票数据已经存在）
	 * @param strCodeSt
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlIncItmVsTypeDTO[] doPrintUsedInc(String strStKey) throws BizException {
		IncDataUsedPrintBp handlerBp=new IncDataUsedPrintBp();
		return handlerBp.exec(strStKey);
	}
	/**
	 * 获取门诊发票信息,已存在的发票信息 不跳号
	 * @param stIds 结算id数组
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlIncItmVsTypeDTO[] printOpInvoiceNoIncno(String stIds) throws BizException {
		IncDataPrintNoIncnoBP bp =new IncDataPrintNoIncnoBP();
		return bp.exec(stIds);
	}
}
