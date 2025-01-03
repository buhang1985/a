package iih.bl.cg.service.s;

import java.util.List;

import iih.bl.cg.blcgoep.bp.BlCgOepQueryBp;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.service.d.BL_Register_RefundDTO;
import iih.bl.cg.service.d.BlRefundItmDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCancelSettlement;
import iih.bl.cg.service.s.bp.BLCancelSettlementImplBp;
import iih.bl.cg.service.s.bp.GetBlCgItmsBp;
import iih.bl.cg.service.s.bp.GetBlStOepAndCodeHpDTOBp;
import iih.bl.cg.service.s.bp.GetBlStOepAndCodeHpDTOBySelDtosBp;
import iih.bl.cg.service.s.bp.GetBlStOepPayInfoBp;
import iih.bl.cg.service.s.bp.GetBlStOepRtnVsIncBp;
import iih.bl.cg.service.s.bp.GetBlStOepVsIncBp;
import iih.bl.cg.service.s.bp.GetBlStOepVsIncByCodeAndincnoBp;
import iih.bl.cg.service.s.bp.GetBlStOepVsIncByIdStoepBp;
import iih.bl.cg.service.s.bp.GetBlStReFundBillAndPayItmDTOBp;
import iih.bl.cg.service.s.bp.JudgeSpecillFlagBP;
import iih.bl.cg.service.s.bp.RedBackBillBp;
import iih.bl.cg.service.s.bp.RefundAndSettlementBp;
import iih.bl.cg.service.s.bp.RefundBillOnHisChargingAndRegisterBp;
import iih.bl.cg.service.s.bp.RefundFeeBp;
import iih.bl.cg.service.s.bp.RefundFeeInsurBp;
import iih.bl.cg.service.s.bp.RefundInsurBp;
import iih.bl.cg.service.s.bp.RegisterRefundAndSettlementBp;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.pay.blrtnreasondto.d.BlRtnReasonDTO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.dto.d.BlStOepAndCodeHpDTO;
import iih.bl.st.dto.d.BlStOepVsIncDTO;
import iih.bl.st.dto.d.BlStReFundBillAndPayItmDTO;
import iih.bl.st.dto.d.BlStReFundBillDTO;
import iih.ci.ord.d.CijudgeSpecillDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 门诊退费
 * 
 * @author tcy
 * @author yang.lu 2017年6月26日
 * 
 */
@Service(serviceInterfaces = { IBLCancelSettlement.class }, binding = Binding.JSONRPC)
public class IBLCancelSettlementImpl implements IBLCancelSettlement {

	/**
	 * 医保查询及回退，根据条件获取医保交易数据
	 * 
	 * @param sDate
	 *            交易区间开始日期
	 * @param eDate
	 *            交易区间结束日期
	 * @param code_hp
	 *            交易流水号
	 * @param id_hp
	 *            医保编号
	 * @return
	 * @throws BizException
	 */
	public BlStOepAndCodeHpDTO[] getBlStOepAndCodeHpDTO_BySelDtos(String sDate, String eDate, String code_hp, String id_hp) throws BizException {
		GetBlStOepAndCodeHpDTOBySelDtosBp bp = new GetBlStOepAndCodeHpDTOBySelDtosBp();
		return bp.exec(sDate, eDate, code_hp, id_hp);
	}

	/**
	 * 退费医保交易、退号医保交易异常处理。医保交易成功，HIS交易失败，需要单独处理HIS 针对退费医保异常处理，目前只考虑全退，没有考虑全退重收
	 * 
	 * @param id_stoep
	 *            原始结算ID
	 * @param id_ent
	 *            就诊id_ent(退费可以为null)
	 * @param eu_direct
	 *            原始收费方向：收费or退费
	 * @param eu_srctp
	 *            交易类型：医嘱收费的交易 or 就诊的交易
	 * @param operatorInfo
	 *            操作人员信息
	 * @param paypatOepAggDo
	 *            目前，只考虑全退，传参null。如果未来考虑退费重收后，为重收的收费
	 * @return BlIncItmVsTypeDTO
	 *         就诊异常处理后，返回的是null；退费异常处理后，返回的是BlIncItmVsTypeDTO[]
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] refundBillOnHis_ChargingAndRegister(String id_stoep, String id_ent, Integer eu_direct, Integer eu_srctp, OperatorInfoDTO operatorInfo, BlpaypatoepAggDO paypatOepAggDo) throws BizException {
		RefundBillOnHisChargingAndRegisterBp bp = new RefundBillOnHisChargingAndRegisterBp();
		return bp.exec(id_stoep, id_ent, eu_direct, eu_srctp, operatorInfo, paypatOepAggDo);
	}

	/**
	 * 查询患者的就诊对应医保计划下，是否需要打印红冲票 提供EN域调用 2017年6月26日 当前方法迁入到 IBlIncOutQryService
	 * 中的 isPrintRedInc中 需要 整体调整 yang.lu
	 * 
	 * @param id_ent
	 *            就诊ID
	 * @return
	 * @throws BizException
	 */
	public FBoolean getFPrintRedInc(String id_ent) throws BizException {
		BLCancelSettlementImplBp bLCancelSettlementImplBp = new BLCancelSettlementImplBp();
		return bLCancelSettlementImplBp.getFPrintRedInc(id_ent);
	}

	/**
	 * 供就诊使用：根据id_ent,id_cgoep，查对应的结算主键和医保交易流水号
	 * 
	 * @param id_ent
	 *            就诊ID
	 * @param id_cgoep
	 *            记账主表ID
	 * @return 结算主键和医保交易流水号DTO
	 * @throws BizException
	 */
	@Override
	public BlStOepAndCodeHpDTO getBlStOepAndCodeHpDTO(String id_ent, String id_cgoep) throws BizException {
		// TODO 此方法属于外部调用方法 日后需要统计摆放
		GetBlStOepAndCodeHpDTOBp bp = new GetBlStOepAndCodeHpDTOBp();
		return bp.exec(id_ent, id_cgoep);
	}

	/**
	 * 退费提取明细数据和支付方式
	 * 
	 * @param id_stoep
	 * @return
	 * @throws BizException
	 */
	public BlStReFundBillAndPayItmDTO getBlStReFundBillAndPayItmDTO(String id_stoep) throws BizException {
		GetBlStReFundBillAndPayItmDTOBp bp = new GetBlStReFundBillAndPayItmDTOBp();
		return bp.exec(id_stoep);
	}

	/**
	 * 获得患者指定时间段内的的结算与发票信息
	 * 
	 * @param id_pat
	 * @param dt_b
	 *            开始时间
	 * @param dt_e
	 *            结算时间
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlStOepVsIncDTO[] getBlStOepVsInc(String id_pat, String dt_b, String dt_e) throws BizException {
		GetBlStOepVsIncBp bp = new GetBlStOepVsIncBp();
		return bp.exec(id_pat, dt_b, dt_e);
	}
	
	/**
	 * 获得患者指定时间段内的的结算与发票信息(+电子票)
	 * 
	 * @param id_pat
	 * @param dt_b
	 *            开始时间
	 * @param dt_e
	 *            结算时间
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlStOepVsIncDTO[] getBlStOepRtnVsInc(String id_pat, String dt_b, String dt_e) throws BizException {
		GetBlStOepRtnVsIncBp bp = new GetBlStOepRtnVsIncBp();
		return bp.exec(id_pat, dt_b, dt_e);
	}
	
	/**
	 * 获取患者指定时间段内的的非合并产生的结算与发票信息
	 */
	@Override
	public BlStOepVsIncDTO[] getNotMergedBlStOepVsInc(String id_pat, String dt_b, String dt_e,FBoolean isMerged) throws BizException {
		GetBlStOepVsIncBp bp = new GetBlStOepVsIncBp();		
		return bp.exec(id_pat, dt_b, dt_e,isMerged);
	}
	
	/**
	 * 获取患者指定时间段内指定结算id的发票信息
	 * @param id_pat
	 * @param dt_b
	 * @param dt_e
	 * @param idStOeps
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlStOepVsIncDTO[] getBlStOepVsIncByIdStOeps(String id_pat, String[] idStOeps, String dt_b, String dt_e,String fg_canc)
			throws BizException {
		GetBlStOepVsIncBp bp = new GetBlStOepVsIncBp();
		return bp.exec2(id_pat, dt_b, dt_e,idStOeps,fg_canc);
	}

	/**
	 * 获得患者指定流水号与发票号的结算与发票信息
	 * 
	 * @param id_pat
	 *            患者编号
	 * @param codest
	 *            流水号
	 * @param incno
	 *            发票号
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlStOepVsIncDTO[] getBlStOepVsIncByCodeAndincno(String id_pat, String codest, String incno) throws BizException {
		GetBlStOepVsIncByCodeAndincnoBp bp = new GetBlStOepVsIncByCodeAndincnoBp();
		return bp.exec(id_pat, codest, incno);
	}

	/**
	 * 根据结算编号 获取 结算与发票信息
	 * 
	 * @param idstoep
	 *            结算编号
	 * @return
	 * @throws BizException
	 */
	public BlStOepVsIncDTO[] getBlStOepVsIncByIdStoep(String idstoep) throws BizException {
		GetBlStOepVsIncByIdStoepBp bp = new GetBlStOepVsIncByIdStoepBp();
		return bp.exec(idstoep);
	}

	/**
	 * 退费提取明细数据
	 */
	@Override
	@Deprecated
	public BlStReFundBillDTO[] getBlCgItms(String id_st) throws BizException {
		GetBlCgItmsBp bp = new GetBlCgItmsBp();
		return bp.exec(id_st);
	}

	/**
	 * 红冲(退费重构前的红冲，待程序稳定后，不再使用）
	 * 
	 * @param id_stoep
	 *            退费的结算ID
	 * @param id_cgoep
	 *            退费的记账主键
	 * @param BlRefundItmDTO
	 *            :id_cgoep,id_cditmoep,退费数量
	 * @param id_hp
	 *            :结算对应的医保主计划
	 * @param operatorInfoDTO
	 * @param PrintOnlyOneInvoice
	 *            ：多次就诊一次结算打印一张发票还是多张发票
	 * @param AllRefundAndAllCharge
	 *            是否重退重收
	 * @throws BizException
	 *             无法确认当前方法是否已停用
	 */
	@Override
	@Deprecated
	public BlcgoepAggDO[] redBackBill(BlpaypatoepAggDO blpaypatoepAggDO, String id_stoep, String[] id_cgoep, BlRefundItmDTO[] id_cditmoep, OperatorInfoDTO operatorInfoDTO, String id_hp, FBoolean AllRefundAndAllCharge) throws BizException {
		RedBackBillBp bp = new RedBackBillBp();
		return bp.exec(blpaypatoepAggDO, id_stoep, id_cgoep, id_cditmoep, operatorInfoDTO, id_hp, AllRefundAndAllCharge);
	}

	/**
	 * 医保退费（全退）,前台需要传入分摊数据
	 * 
	 * @param blPropOepDOArr
	 *            退费生成的分摊1
	 * @param blproparoepAggDOArr
	 *            退费生成的分摊2
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
	 * @return 需要打印的红冲发票信息
	 * @throws BizException
	 *             前端退费功能未调用此方法
	 */
	@Override
	@Deprecated
	public BlIncItmVsTypeDTO[] Refund_Insur(BlPropOepDO[] blPropOepDOArr, BlproparoepAggDO[] blproparoepAggDOArr, String id_stoep, String[] id_cgoep_arr, BlRefundItmDTO[] id_cditmoep_arr, OperatorInfoDTO operatorInfoDTO, BlpaypatoepAggDO blpaypatoepAggDO) throws BizException {
		RefundInsurBp bp = new RefundInsurBp();
		return bp.exec(blPropOepDOArr, blproparoepAggDOArr, id_stoep, id_cgoep_arr, id_cditmoep_arr, operatorInfoDTO, blpaypatoepAggDO, null);
	}

	/**
	 * 医保：退费重收
	 * 
	 * @param refund_blPropOepDOArr
	 *            ：医保退费的分摊1
	 * @param refund_blproparoepAggDOArr
	 *            ：医保退费的分摊2
	 * @param recharge_blPropOepDOArr
	 *            ：医保重收的分摊1
	 * @param recharge_blproparoepAggDOArr
	 *            ：医保重收的分摊2
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
	 * @return 需要重打的发票信息
	 * @throws BizException
	 * 
	 */
	@Deprecated
	public BlIncItmVsTypeDTO[] RefundAndSettlement_Insur_new(BlPropOepDO[] refund_blPropOepDOArr, BlproparoepAggDO[] refund_blproparoepAggDOArr, BlPropOepDO[] recharge_blPropOepDOArr, BlproparoepAggDO[] recharge_blproparoepAggDOArr, String id_stoep, String[] id_cgoep_arr, BlRefundItmDTO[] id_cditmoep_arr, OperatorInfoDTO operatorInfoDTO, BlpaypatoepAggDO blpaypatoepAggDO) throws BizException {
		// // 先做全费的重退重收
		// BlIncItmVsTypeDTO[] blIncItmVsTypeDTOArr =
		// RefundAndSettlement_new(id_stoep, id_cgoep_arr, id_cditmoep_arr,
		// operatorInfoDTO, blpaypatoepAggDO);
		//
		// // 保存医保分摊，含三部分数据：
		// // 1.红冲的分摊（即退费的分摊）
		// // 2.重收的分摊
		// // 3.用分摊数据更新红冲的CG,ST,INC表AMT,AMP_PAT,AMT_HP
		// // 4.用分摊数据更新重收的CG,ST,INC表AMT,AMP_PAT,AMT_HP
		// RefundAndSettlementInsurToSaveBp saveBp = new
		// RefundAndSettlementInsurToSaveBp();
		// saveBp.exec(refund_blPropOepDOArr, refund_blproparoepAggDOArr,
		// recharge_blPropOepDOArr, recharge_blproparoepAggDOArr, id_stoep);
		//
		// return blIncItmVsTypeDTOArr;

		// /改方法提供为当初医保重划重收功能 暂时无其他方法调用，返回null yang.lu 2017年6月26日
		throw new BizException("此方法已过期，请及时联系开发人员！");
	}

	/**
	 * 退费按钮调用
	 * 
	 * @param id_stoep
	 *            ：退费结算号
	 * @param id_cgoep_arr
	 *            ：退费的记账主键数组
	 * @param id_cditmoep_arr
	 *            :退费的详细数组（id_cgoep,id_cditmoep,退费数量）
	 * @param operatorInfoDTO
	 *            ：操作员信息
	 * @param blpaypatoepAggDO
	 *            ：收付款信息（重收的收付款信息），重构后： 前台不考虑收付款的方向，这个全部由后台考虑
	 *            数据来源于挂号的重收：原收费信息（正向） 数据来源于挂号的退号：null 数据来源于门诊结算的退费：退费的信息（负向）
	 *            数据来源于门诊结算的重划重收：新收费信息（正向）
	 * @param AllRefund
	 *            ：是否全退。FBoolean.TRUE:全退；FBoolean.FALSE:不全退
	 * @param reasonDTO:退款原因
	 * @return 需要重打的发票信息
	 * @throws BizException
	 */
	@Override
	public BlIncItmVsTypeDTO[] RefundFee(String orgin_idstoep, 
			String[] id_cgoep_arr, 
			BlRefundItmDTO[] refundItemDtoArr, 
			OperatorInfoDTO operatorInfoDTO, 
			BlpaypatoepAggDO blpaypatoepAggDO, 
			FBoolean AllRefund,
			BlRtnReasonDTO reasonDTO) throws BizException {
		RefundFeeBp bp = new RefundFeeBp();
		return bp.exec(orgin_idstoep, 
				id_cgoep_arr, 
				refundItemDtoArr, 
				operatorInfoDTO, 
				blpaypatoepAggDO, 
				AllRefund, 
				null,
				reasonDTO);
	}

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
	public BlIncItmVsTypeDTO[] RefundAndSettlement_new(String orgin_idstoep, String[] id_cgoep_arr, BlRefundItmDTO[] refundItemDtoArr, OperatorInfoDTO operatorInfoDTO, BlpaypatoepAggDO blpaypatoepAggDO) throws BizException {
		RefundAndSettlementBp bp = new RefundAndSettlementBp();
		return bp.exec(orgin_idstoep, id_cgoep_arr, refundItemDtoArr, operatorInfoDTO, blpaypatoepAggDO);
	}

	/**
	 * 挂号：退费重收(将id_cgoep下所有明细都退掉)
	 * 
	 * @param id_cgoep_and_ent
	 *            ：需要退的就诊
	 * @param operatorInfoDTO
	 *            ：操作员信息
	 * @param blpaypatoepAggDO
	 *            :如果是退号，则传入退号的支付方式。如果是换号，则传入最后收费的支付方式
	 * @return 退费成功返回发票信息
	 * @throws BizException
	 */
	@Override
	public BlIncItmVsTypeDTO[] Register_RefundAndSettlement_new(BL_Register_RefundDTO id_cgoep_and_ent, OperatorInfoDTO operatorInfoDTO, BlpaypatoepAggDO blpaypatoepAggDO) throws BizException {
		RegisterRefundAndSettlementBp bp = new RegisterRefundAndSettlementBp();
		return bp.exec(id_cgoep_and_ent, operatorInfoDTO, blpaypatoepAggDO, FBoolean.TRUE, null);
	}

	/**
	 * 挂号：退费重收(将id_cgoep下所有明细都退掉)
	 * 
	 * @param id_cgoep
	 *            ：需要退的就诊
	 * @param operatorInfoDTO
	 *            ：操作员信息
	 * @param printRedInc
	 *            :是否打印红冲票
	 * @param fgRealpay
	 *            ：是否虚交易（虚交易为N否则为Y）
	 * @return 退费成功返回发票信息
	 * @throws BizException
	 */
	@Override
	public BlIncItmVsTypeDTO[] Register_RefundAndSettlement(BL_Register_RefundDTO id_cgoep_and_ent, OperatorInfoDTO operatorInfoDTO, FBoolean fgRealpay) throws BizException {
		RegisterRefundAndSettlementBp bp = new RegisterRefundAndSettlementBp();
		return bp.exec(id_cgoep_and_ent, operatorInfoDTO, null, FBoolean.FALSE, fgRealpay);
	}

	/**
	 * 挂号：根据记账主键显示对应的发票号
	 * 
	 * @param id_cgoep
	 *            记账主键
	 * @return 记账对应的发票号
	 * @throws BizException
	 */
	@Override
	public String GetInvoicenoById_CgOep(String id_cgoep) throws BizException {
		BlCgOepQueryBp bp = new BlCgOepQueryBp();
		return bp.GetInvoicenoById_CgOep(id_cgoep);
	}

	/***
	 * 判断特殊病患者
	 * 
	 * @param No_hp
	 * @param id_hp
	 * @param id_mm
	 * @param diag
	 * @return map key ,fg_specill
	 * @throws BizException
	 */
	public List<CijudgeSpecillDTO> JudgeSpecillFlag(String No_hp, String id_hp, String[] id_mm) throws BizException {
		return JudgeSpecillFlagBP.getInstance().exec(No_hp, id_hp, id_mm);
	}

	@Override
	public BlIncItmVsTypeDTO[] RefundFee_Insur(
			BlPropOepDO[] refund_blPropOepDOArr,
			BlproparoepAggDO[] refund_blproparoepAggDOArr,
			BlPropOepDO[] recharge_blPropOepDOArr,
			BlproparoepAggDO[] recharge_blproparoepAggDOArr, 
			String id_stoep,
			String[] id_cgoep_arr, 
			BlRefundItmDTO[] id_cditmoep_arr,
			OperatorInfoDTO operatorInfoDTO, 
			BlpaypatoepAggDO blpaypatoepAggDO,
			FBoolean AllRefund, 
			String strOutHp,
			BlRtnReasonDTO rtnReasonDTO) throws BizException {
		RefundFeeInsurBp bp = new RefundFeeInsurBp();
		return bp.exec(refund_blPropOepDOArr, 
				refund_blproparoepAggDOArr, 
				recharge_blPropOepDOArr, 
				recharge_blproparoepAggDOArr, 
				id_stoep, 
				id_cgoep_arr, 
				id_cditmoep_arr, 
				operatorInfoDTO, 
				blpaypatoepAggDO, 
				AllRefund,
				rtnReasonDTO);
	}

	@Override
	public BlIncItmVsTypeDTO[] refundInsureFee(String strCodest,
			OperatorInfoDTO operatorInfoDTO) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取当前结算的支付信息
	 * @author wq.li
	 * @category
	 */
	@Override
	public BlStOepVsIncDTO[] GetBlStOepPayInfo(String stOepId)throws BizException {
		GetBlStOepPayInfoBp bp=new GetBlStOepPayInfoBp();
		return bp.exec(stOepId);
	}

	

	
}
