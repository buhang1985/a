package iih.bl.cg.oep.i;

import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 门诊收费结算接口
 * @author yangyang
 * @Date 2018-01-03
 */
public interface IOepSettlementService {

	
	/** 门诊收费划价接口
	 * @param appendBillParamDTOs 记账明细信息
	 * @param operatorInfoDTO 操作人员信息
	 * @param PrintInvocie 是否打印发票
	 * @return 记账后明细信息
	 * @throws BizException
	 */
	BlCgOepAggDTO chargeFee(BlOrderAppendBillParamDTO[] appendBillParamDTOs, OperatorInfoDTO operatorInfoDTO, FBoolean PrintInvocie) throws BizException;
	
	/**自费场景下的付费接口
	 * @return
	 * @throws BizException
	 */
	BlIncItmVsTypeDTO[] paySelf(BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO, FBoolean IsDrugApplication, FBoolean PrintInvoice, FBoolean IsTransferPrepay) throws BizException;

	/**
	 * 打印发票（发票数据已经存在）
	 * @param strCodeSt
	 * @return
	 * @throws BizException
	 */
	BlIncItmVsTypeDTO[] doPrintUsedInc(String strStKey) throws BizException;
	
	/**
	 * 获取门诊发票信息,已存在的发票信息 不跳号
	 * @param stIds 结算id数组
	 * @return
	 * @throws BizException
	 */
	BlIncItmVsTypeDTO[] printOpInvoiceNoIncno(String stIds) throws BizException;
}
