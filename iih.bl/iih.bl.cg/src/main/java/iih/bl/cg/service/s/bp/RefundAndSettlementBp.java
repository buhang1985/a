package iih.bl.cg.service.s.bp;

import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.dto.d.BlCgoepAggAndPrintRedIncItmDTO;
import iih.bl.cg.service.d.BlRefundItmDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.params.BlParams;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class RefundAndSettlementBp {

	/**
	 * 重划重收按钮调用
	 * 
	 * @param id_stoep
	 *            ：退费结算号
	 * @param id_cgoep_arr
	 *            ：退费的记账主键数组
	 * @param refundItemDtoArr
	 *            :退费的详细数组（id_cgoep,id_cditmoep,退费数量）
	 * @param operatorInfoDTO
	 *            ：操作员信息
	 * @param blpaypatoepAggDO
	 *            ：收付款信息（重收的收付款信息）重构后，前台传入的数据方向都1 数据来源于挂号的重收：原收费信息（正向）
	 *            数据来源于挂号的退号：null 数据来源于门诊结算的退费：退费的信息（负向）
	 *            数据来源于门诊结算的重划重收：新收费信息（正向）
	 * @return 需要重打的发票信息
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] exec(String orgin_idstoep, String[] id_cgoep_arr, BlRefundItmDTO[] refundItemDtoArr, OperatorInfoDTO operatorInfoDTO, BlpaypatoepAggDO blpaypatoepAggDO)
			throws BizException {
		BLCancelSettlementImplBp bLCancelSettlementImplBp = new BLCancelSettlementImplBp();
		FBoolean PrintOnlyOneInvoice = BlParams.BLSTOEP0003();
		FBoolean AllRefundAndAllCharge = FBoolean.TRUE; // 是否重划重收标志，重划重收时，红冲的支付明细fg_realpay='N'
		FBoolean AllRefund = FBoolean.FALSE; // 是否全退标志,全退时，红冲的支付明细fg_realpay='Y'

		TimeService timeService = new TimeServiceImpl();
		FDateTime fDateTime = timeService.getUFDateTime();

		// 1.红冲原记账，结算信息，发票信息，收付款信息，修改医嘱记账标志2，发事件 。返回结果为需要重新结算的记账明细
		BlCgoepAggAndPrintRedIncItmDTO blCgoepAggAndPrintRedIncItmDTO = bLCancelSettlementImplBp.redBackBill_withoutProp(orgin_idstoep, id_cgoep_arr, refundItemDtoArr, operatorInfoDTO,
				PrintOnlyOneInvoice, AllRefundAndAllCharge, AllRefund, fDateTime, FBoolean.FALSE, blpaypatoepAggDO);// 重划重收不打红冲票
		BlcgoepAggDO[] blcgoepAggDO_recharge = (BlcgoepAggDO[]) blCgoepAggAndPrintRedIncItmDTO.getBlCgoepAggDO().toArray(new BlcgoepAggDO[0]);
		// 2.处理物品预留
		bLCancelSettlementImplBp.RelieveMMReserved(refundItemDtoArr, AllRefundAndAllCharge);

		FArrayList redIncItmLst = blCgoepAggAndPrintRedIncItmDTO.getBlIncItmVsTypeDTO();
		FArrayList blIncItmVsTypeDTO_Lst = new FArrayList();
		// 红冲对应的发票项目
		if (redIncItmLst != null && redIncItmLst.size() > 0) {
			BlIncItmVsTypeDTO[] redIncItms = (BlIncItmVsTypeDTO[]) redIncItmLst.toArray(new BlIncItmVsTypeDTO[0]);
			for (BlIncItmVsTypeDTO blIncItmVsTypeDTO : redIncItms) {
				blIncItmVsTypeDTO_Lst.add(blIncItmVsTypeDTO);
			}
		}

		// 3.若全退，则返回NULL
		if (AllRefund.booleanValue()) {
			if (blIncItmVsTypeDTO_Lst != null && blIncItmVsTypeDTO_Lst.size() > 0) // 如果需要打印红冲票
			{
				return (BlIncItmVsTypeDTO[]) blIncItmVsTypeDTO_Lst.toArray(new BlIncItmVsTypeDTO[0]);
			} else {
				return null;
			}
		}

		// *******************下面是重收部分**********************

		IBLCiOrderToBlCgService iBLCiOrderToBlCgService = ServiceFinder.find(IBLCiOrderToBlCgService.class);
		BlIncItmVsTypeDTO[] new_blIncItmVsTypeDTO_arr = iBLCiOrderToBlCgService.settlementAfterRedBill(blcgoepAggDO_recharge, orgin_idstoep, operatorInfoDTO, blpaypatoepAggDO, AllRefundAndAllCharge,
				fDateTime);

		// 重收对应的发票项目
		if (new_blIncItmVsTypeDTO_arr != null && new_blIncItmVsTypeDTO_arr.length > 0) {
			for (BlIncItmVsTypeDTO blIncItmVsTypeDTO1 : new_blIncItmVsTypeDTO_arr) {
				blIncItmVsTypeDTO_Lst.add(blIncItmVsTypeDTO1);
			}
		}
		BlIncItmVsTypeDTO[] blIncItmVsTypeDTO_arr = (BlIncItmVsTypeDTO[]) blIncItmVsTypeDTO_Lst.toArray(new BlIncItmVsTypeDTO[0]);

		return blIncItmVsTypeDTO_arr;
	}
}
