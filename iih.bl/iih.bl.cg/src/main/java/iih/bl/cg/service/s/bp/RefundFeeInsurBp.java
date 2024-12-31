package iih.bl.cg.service.s.bp;

import iih.bl.cg.service.d.BlRefundItmDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.IBlFlowKeyConst;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.pay.blrtnreasondto.d.BlRtnReasonDTO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;

public class RefundFeeInsurBp {

	/**
	 * 医保退费（全退和半退都在一起）,前台需要传入分摊数据
	 * 
	 * @param refund_blPropOepDOArr
	 *            退费生成的分摊1
	 * @param refund_blproparoepAggDOArr
	 *            退费生成的分摊2
	 * @param recharge_blPropOepDOArr
	 *            重收生成的分摊1,如果是医保全退，此处传参为NULL
	 * @param recharge_blproparoepAggDOArr
	 *            重收生成的分摊2,如果是医保全退，此处传参为NULL
	 * @param id_stoep
	 *            ：退费结算号
	 * @param id_cgoep_arr
	 *            ：退费的记账主键数组
	 * @param id_cditmoep_arr
	 *            :退费的详细数组（id_cgoep,id_cditmoep,退费数量）
	 * @param operatorInfoDTO
	 *            ：操作员信息
	 * @param blpaypatoepAggDO
	 *            ：收付款信息
	 * @param AllRefund
	 *            ：是否全退
	 * @param rtnReasonDTO 退费原因，没有可传null
	 * @return 需要打印的红冲发票信息和重收发票信息
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] exec(BlPropOepDO[] refund_blPropOepDOArr, 
			BlproparoepAggDO[] refund_blproparoepAggDOArr, 
			BlPropOepDO[] recharge_blPropOepDOArr,
			BlproparoepAggDO[] recharge_blproparoepAggDOArr, 
			String id_stoep, 
			String[] id_cgoep_arr, 
			BlRefundItmDTO[] id_cditmoep_arr, 
			OperatorInfoDTO operatorInfoDTO,
			BlpaypatoepAggDO blpaypatoepAggDO, 
			FBoolean AllRefund,
			BlRtnReasonDTO rtnReasonDTO) throws BizException {

		// 设置终端类型上下文
		if (blpaypatoepAggDO != null) {
			BlPayPatOepDO payPatDo = blpaypatoepAggDO.getParentDO();
			if (payPatDo != null) {
				Context.get().setAttribute(IBlFlowKeyConst.BL_FLOW_KEY_SD_PTTP, payPatDo.getSd_pttp());
			}
		}
		
		RefundFeeBp bp = new RefundFeeBp();
		// 1.做全费的退款操作
		BlIncItmVsTypeDTO[] blIncItmVsTypeDTOs = bp.exec(id_stoep, 
				id_cgoep_arr, 
				id_cditmoep_arr, 
				operatorInfoDTO, 
				blpaypatoepAggDO,
				AllRefund,
				FBoolean.FALSE,
				rtnReasonDTO);

		// 保存医保分摊，含三部分数据：
		// 1.红冲的分摊（即退费的分摊）
		// 2.重收的分摊
		// 3.用分摊数据更新红冲的CG,ST,INC表AMT,AMP_PAT,AMT_HP
		// 4.用分摊数据更新重收的CG,ST,INC表AMT,AMP_PAT,AMT_HP
		RefundAndSettlementInsurToSaveBp saveBp = new RefundAndSettlementInsurToSaveBp();
		saveBp.exec(refund_blPropOepDOArr, 
				refund_blproparoepAggDOArr, 
				recharge_blPropOepDOArr, 
				recharge_blproparoepAggDOArr, 
				id_stoep);

		return blIncItmVsTypeDTOs;
	}
}
