package iih.bl.cg.service.i;

import java.util.List;

import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.service.d.BL_Register_RefundDTO;
import iih.bl.cg.service.d.BlRefundItmDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
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
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 门诊退费接口
 * 
 * @author tcy
 * 
 */
public interface IBLCancelSettlement {

	/**
	 * 查询患者的就诊对应医保计划下，是否需要打印红冲票
	 * 
	 * @param id_ent
	 *            就诊ID
	 * @return FBoolean.TRUE:打印红冲票；FBoolean.FALSE:不打印红冲票
	 * @throws BizException
	 * TODO提供EN域调用 2017年6月26日 当前方法迁入到 IBlIncOutQryService 中的 isPrintRedInc中 需要 整体调整 yang.lu
	 */
	public abstract FBoolean getFPrintRedInc(String id_ent) throws BizException;

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
	 * TODO 此方法为【医保查询及回退】中的方法 
	 */
	public abstract BlStOepAndCodeHpDTO[] getBlStOepAndCodeHpDTO_BySelDtos(String sDate, String eDate, String code_hp, String id_hp) throws BizException;

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
	 *            ：收付款信息（重收的收付款信息） 数据来源于挂号的重收：原收费信息（正向） 数据来源于挂号的退号：null
	 *            数据来源于门诊结算的退费：退费的信息（负向） 数据来源于门诊结算的重划重收：新收费信息（正向）
	 * @param AllRefund
	 *            ：是否全退。FBoolean.TRUE:全退；FBoolean.FALSE:不全退
	 * @param reasonDTO:退款原因
	 * @return 需要重打的发票信息
	 * @throws BizException
	 */
	public abstract BlIncItmVsTypeDTO[] RefundFee(String orgin_idstoep, 
			String[] id_cgoep_arr, 
			BlRefundItmDTO[] refundItemDtoArr, 
			OperatorInfoDTO operatorInfoDTO, 
			BlpaypatoepAggDO blpaypatoepAggDO,
			FBoolean AllRefund,
			BlRtnReasonDTO reasonDTO) throws BizException;

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
	 */
	public abstract BlIncItmVsTypeDTO[] RefundAndSettlement_Insur_new(BlPropOepDO[] refund_blPropOepDOArr, BlproparoepAggDO[] refund_blproparoepAggDOArr, BlPropOepDO[] recharge_blPropOepDOArr,
			BlproparoepAggDO[] recharge_blproparoepAggDOArr, String id_stoep, String[] id_cgoep_arr, BlRefundItmDTO[] id_cditmoep_arr, OperatorInfoDTO operatorInfoDTO,
			BlpaypatoepAggDO blpaypatoepAggDO) throws BizException;

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
	 *            ：收付款信息（重收的收付款信息） 数据来源于挂号的重收：原收费信息（正向） 数据来源于挂号的退号：null
	 *            数据来源于门诊结算的退费：退费的信息（负向） 数据来源于门诊结算的重划重收：新收费信息（正向）
	 * @return 需要重打的发票信息
	 * @throws BizException
	 */
	public abstract BlIncItmVsTypeDTO[] RefundAndSettlement_new(String orgin_idstoep, String[] id_cgoep_arr, BlRefundItmDTO[] refundItemDtoArr, OperatorInfoDTO operatorInfoDTO,
			BlpaypatoepAggDO blpaypatoepAggDO) throws BizException;

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
	public abstract BlStOepAndCodeHpDTO getBlStOepAndCodeHpDTO(String id_ent, String id_cgoep) throws BizException;

	// public abstract BlIncItmVsTypeDTO[] refundBill(String strIdStOep,
	// BlRefundItmDTO[] refundItemDtos, BlpaypatoepAggDO blpaypatoepAggDO)
	// throws BizException;

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
	public abstract BlStOepVsIncDTO[] getBlStOepVsInc(String id_pat, String dt_b, String dt_e) throws BizException;

	
	/**
	 * 获取患者指定时间段内指定结算id的发票信息
	 * @param id_pat
	 * @param dt_b
	 * @param dt_e
	 * @param idStOeps
	 * @return
	 * @throws BizException
	 */
	public abstract BlStOepVsIncDTO[] getBlStOepVsIncByIdStOeps(String id_pat, String[] idStOeps, String dt_b, String dt_e,String fg_canc) throws BizException;

	/**
	 * 获取患者指定时间段内的的非合并产生的结算与发票信息
	 * @param id_pat
	 * @param dt_b
	 * @param dt_e
	 * @return
	 * @throws BizException
	 */
	public abstract BlStOepVsIncDTO[] getNotMergedBlStOepVsInc(String id_pat, String dt_b, String dt_e,FBoolean isMerged) throws BizException;

	/**
	 * 获得指定结算号下的费用信息和支付方式
	 * 
	 * @param id_stoep
	 * @return
	 * @throws BizException
	 */
	public abstract BlStReFundBillAndPayItmDTO getBlStReFundBillAndPayItmDTO(String id_stoep) throws BizException;

	/**
	 * 获得指定结算号下的费用信息
	 * 
	 * @param id_stoep
	 *            结算号
	 * @return
	 * @throws BizException
	 * @author yang.lu
	 */
	@Deprecated
	public abstract BlStReFundBillDTO[] getBlCgItms(String id_stoep) throws BizException;

	/**
	 * 医保退费（全退）
	 * 
	 * @param blPropOepDOArr
	 *            ：退费医保分摊1
	 * @param blproparoepAggDOArr
	 *            ：退费医保分摊2
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
	 * @return 退票的发票信息
	 * @throws BizException
	 */
	public abstract BlIncItmVsTypeDTO[] Refund_Insur(BlPropOepDO[] blPropOepDOArr, BlproparoepAggDO[] blproparoepAggDOArr, String id_stoep, String[] id_cgoep_arr, BlRefundItmDTO[] id_cditmoep_arr,
			OperatorInfoDTO operatorInfoDTO, BlpaypatoepAggDO blpaypatoepAggDO) throws BizException;

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
	public abstract BlIncItmVsTypeDTO[] RefundFee_Insur(BlPropOepDO[] refund_blPropOepDOArr, 
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
			BlRtnReasonDTO rtnReasonDTO) throws BizException;
	
	/**
	 * 医保异常退费的处理
	 * @param strCodest 结算流水号
	 * @param operatorInfoDTO 操作人员信息
	 * @return 发票信息
	 */
	public BlIncItmVsTypeDTO[] refundInsureFee(String strCodest,OperatorInfoDTO operatorInfoDTO) throws BizException;
	
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
	 * 此方法为【医保查询及回退】中异常处理调用方法 
	 */
	public abstract BlIncItmVsTypeDTO[] refundBillOnHis_ChargingAndRegister(String id_stoep, String id_ent, Integer eu_direct, Integer eu_srctp, OperatorInfoDTO operatorInfo,
			BlpaypatoepAggDO paypatOepAggDo) throws BizException;

	/**
	 * 红冲
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
	 * @param AllRefundAndAllCharge
	 *            ：是否全退重收。FBoolean.TRUE:全退重收;FBoolean.FALSE:退费
	 * @throws BizException
	 */
	public abstract BlcgoepAggDO[] redBackBill(BlpaypatoepAggDO blpaypatoepAggDO, String id_stoep, String[] id_cgoep, BlRefundItmDTO[] id_cditmoep, OperatorInfoDTO operatorInfoDTO, String id_hp,
			FBoolean AllRefundAndAllCharge) throws BizException;

	
	/**
	 * 挂号：退费重收(将id_cgoep下所有明细都退掉)
	 * 
	 * @param id_cgoep
	 *            ：需要退的就诊
	 * @param operatorInfoDTO
	 *            ：操作员信息
	 * @param blpaypatoepAggDO
	 *            :退费支付方式
	 * @return 退费成功返回发票信息
	 * @throws BizException
	 * TODO 该方法需要规范到 对外接口中
	 */
	public abstract BlIncItmVsTypeDTO[] Register_RefundAndSettlement_new(BL_Register_RefundDTO id_cgoep_and_ent, OperatorInfoDTO operatorInfoDTO, BlpaypatoepAggDO blpaypatoepAggDO)
			throws BizException;


	/**
	 * 挂号：退费重收(该号下由挂号产生的收费明细全退）
	 * 
	 * @param id_cgoep_and_ent
	 *            ：需要退的就诊
	 * @param operatorInfoDTO
	 *            ：操作员信息
	 * @param fgRealpay
	 *            ：是否虚交易（虚交易为N否则为Y）
	 * @return 退费成功返回发票信息
	 * @throws BizException
	 *             TODO 该方法需要规范到 对外接口中
	 */
	public abstract BlIncItmVsTypeDTO[] Register_RefundAndSettlement(BL_Register_RefundDTO id_cgoep_and_ent, OperatorInfoDTO operatorInfoDTO,FBoolean fgRealpay) throws BizException;

	/**
	 * 挂号：根据记账主键显示对应的发票号
	 * 
	 * @param id_cgoep
	 *            记账主键
	 * @return 记账对应的发票号
	 * @throws BizException
	 * TODO 该方法需要规范到 对外接口中
	 */
	public abstract String GetInvoicenoById_CgOep(String id_cgoep) throws BizException;

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
	public abstract List<CijudgeSpecillDTO> JudgeSpecillFlag(String No_hp, String id_hp, String[] id_mm) throws BizException;

	BlStOepVsIncDTO[] getBlStOepVsIncByCodeAndincno(String id_pat,
			String codest, String incno) throws BizException;
	
	/**
	 * 获取当前结算的支付信息
	 * @param stOepId
	 * @author wq.li
	 * @return
	 */
	public abstract BlStOepVsIncDTO[] GetBlStOepPayInfo(String stOepId)throws BizException;
	
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
	public abstract BlStOepVsIncDTO[] getBlStOepRtnVsInc(String id_pat, String dt_b, String dt_e) throws BizException;
}
