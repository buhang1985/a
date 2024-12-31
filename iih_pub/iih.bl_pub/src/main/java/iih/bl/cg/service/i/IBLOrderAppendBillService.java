package iih.bl.cg.service.i;

import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
//import iih.bl.cg.service.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.BlOrderRefundBillParamDTO;
import iih.bl.cg.service.d.Bl_BatchAppendBillDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱补费、退费接口
 * @author tcy
 *
 */
public interface IBLOrderAppendBillService{
	
	/**
	 * 指定就诊下未缴费的医嘱进行缴费
	 * @param id_ent 就诊
	 * @param code_enttp 就诊类型
	 * @param cgType 记账类型
	 * @param id_emp 操作人员ID
	 * @return 成功返回缴费后的信息，失败抛出异常
	 * @throws BizException
	 */
	public abstract BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByItms_ci_kljz_new(String id_ent,String code_enttp,String cgType,String id_emp) throws BizException ;

	
	/**
	 * CI的开立记账调用
	 * @param appendBillParamDTO1 待记账明细
	 * @param code_enttp 就诊类型
	 * @return
	 * @throws BizException
	 */
	public abstract BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByItms_ci_kljz(
			BlOrderAppendBillParamDTO[] appendBillParamDTO1,String code_enttp)
			throws BizException;
	/**
	 * 医嘱取消记账且取消物品预留，必填：id_pat,id_org,id_or,id_orsrv,id_emp_cg
	 * @param refundBillParamDTO
	 * @param code_enttp
	 * @return
	 * @throws BizException
	 */
	public abstract String SetOrderRefundBill_ByIdor_cancelReserve(
			BlOrderAppendBillParamDTO[] refundBillParamDTO,String code_enttp) throws BizException ;
	
	/**
	 * 患者已经出院结算、患者的费用已经封账或患者的费用正在审核结算流程中，禁止执行与费用有关的操作
	 * （适用于住院）	 
	 * @param id_ent 就诊id_ent
	 * @throws BizException
	 */
	public abstract void validateFreezeAccAndAuditStatus(String id_ent) throws BizException;
	
	/**
	 * 单患者补费：根据id_ent,id_or,id_orsrv补费。其中，id_ent保持一致
	 * @param appendBillParamDTO1 补费信息（可只包含id_ent,id_or,id_orsrv）
	 * @param operatorInfoDTO 操作人员信息
	 * @return
	 * @throws BizException
	 */
	public abstract BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByIdEntIdOrIdOrsrv(
			BlOrderAppendBillParamDTO[] appendBillParamDTO1,OperatorInfoDTO operatorInfoDTO) throws BizException ;
	
	/**
	 * 单患者：按医嘱号(id_or,id_orsrv)补费，由本接口负责将医嘱转换成对应的费用明细存入费用明细表
	 * @param appendBillParamDTO1 补费的医嘱信息，需要录入id_pat,id_ent,code_enttp,id_enttp,id_or,supportAppendBill(预交金不足时，是否允许欠费记账）等
	 * @param code_enttp 就诊类型代码
	 * @return 计费成功后的费用明细
	 * @throws BizException
	 */
	public abstract BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByIdorsrv(
			BlOrderAppendBillParamDTO[] appendBillParamDTO1,String code_enttp)
			throws BizException ;
	/**
	 * 单患者：按医嘱号（id_or)补费，由本接口负责将医嘱转换成对应的费用明细存入费用明细表
	 * @param id_or 需要记费的医嘱号数组
	 * @param operatorInfoDTO 操作人员信息
	 * @param srcfunc_des 费用来源执行点
	 * @return
	 * @throws BizException
	 */
	public abstract BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByIdor(
			String id_or,OperatorInfoDTO operatorInfoDTO,String srcfunc_des)
			throws BizException ;
	
	/**
	 * 单患者：按费用明细进行补费,由调用方负责组装需要计费的明细，如果调用方将明细价格price设置为null，则由本接口计算明细的
	 *  price,amt,amt_hp,amt_std,amt_pat，否则，完全有调用方设置
	 * @param appendBillParamDTO1 补费的医嘱信息，需要录入id_pat,id_ent,code_enttp,id_enttp,id_or,supportAppendBill(预交金不足时，是否允许欠费记账）、费用项目信息等
	 * @param code_enttp 就诊类型代码
	 * @return 计费成功后的费用明细
	 * @throws BizException
	 */
	public abstract BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByItms(
			BlOrderAppendBillParamDTO[] appendBillParamDTO1,String code_enttp)
			throws BizException ;
	
	/**
	 * 补费接口，供CI领域调用
	 * @param appendBillParamDTOArr CI领域补录的费用明细：
	 *                               1.id_pat,id_enttp,code_enttp,id_srv,quan,eu_direct(Ci填0),id_org_mp,id_dep_mp,id_or,id_orsrv必填,其他字段可省;
	 *                               2.如果需要支持后付费，则需要设置BlOrderAppendBillParamDTO.setOutpBillDTO(OutpBillDTO.fg_acc=FBoolean.true)
	 * @param operatorInfoDTO 操作员信息
	 * @param code_enttp 就诊分类代码
	 * @param id_pripat 患者价格分类
	 * @return 计费成功后的费用明细
	 * @throws BizException
	 */
	public abstract BlOrderAppendBillParamDTO[]  SetOrderAppendBill_ByCi(
			BlOrderAppendBillParamDTO[] appendBillParamDTO1,OperatorInfoDTO operatorInfoDTO,String code_enttp,String id_pripat)
					throws BizException;
//	public abstract BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByCi(
//			BlOrderAppendBillParamDTO[] appendBillParamDTO1,OperatorInfoDTO operatorInfoDTO,String code_enttp,String id_pripat)
//			throws BizException;
	
	/**
	 * 多患者：按费用明细进行补费,由调用方负责组装需要计费的明细，如果调用方将明细价格price设置为null，则由本接口计算明细的
	 *  price,amt,amt_hp,amt_std,amt_pat，否则，完全有调用方设置
	 * @param appendBillParamDTO1 补费的医嘱信息，需要录入id_pat,id_ent,code_enttp,id_enttp,id_or,supportAppendBill(预交金不足时，是否允许欠费记账）、费用项目信息等
	 * @param code_enttp 就诊类型代码
	 * @return 计费成功后的费用明细
	 * @throws BizException
	 */
	public abstract BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByItms_MultiPat(
			BlOrderAppendBillParamDTO[] appendBillParamDTO1,String code_enttp)
			throws BizException ;
	

	/**
	 * 多患者：按费用明细进行补费,由调用方负责组装需要计费的明细，如果调用方将明细价格price设置为null，则由本接口计算明细的
	 *  price,amt,amt_hp,amt_std,amt_pat，否则，完全有调用方设置
	 * @param appendBillParamDTO1 补费的医嘱信息，需要录入id_pat,id_ent,code_enttp,id_enttp,id_or,supportAppendBill(预交金不足时，是否允许欠费记账）、费用项目信息等
	 * @param code_enttp 就诊类型代码
	 * @return Bl_BatchAppendBillDTO  计费成功后的费用明细DTO；<id_ent, 记费失败原因>;成功计费的id_ent
	 * @throws BizException
	 */
	public Bl_BatchAppendBillDTO SetOrderAppendBill_ByItms_MultiPat_new(
			BlOrderAppendBillParamDTO[] appendBillParamDTO1,String code_enttp)
			throws BizException;
	
	
	/**
	 * 护士站执行退费
	 * @param blOrderRefundBillParamDTO 退费条件
	 * @param code_enttp就诊类型
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean SetOrderRefundBill_ByPlan(
			BlOrderRefundBillParamDTO[]  blOrderRefundBillParamDTO,String code_enttp) throws BizException ;
	
	/**
	 * 按明细退费：由调用方拼好所有信息，包括价格，标准费用等信息
	 * 门诊退记账信息，必须录入id_or,id_orsrv,code_ent,id_pat,id_org,id_org_cg,id_dep_cg,id_emp_cg
	 * 住院退记账信息，在BlOrderAppendBillParamDTO中必须生成RefundBillParamDTO，必须录入id_org_cg,id_dep_cg,id_emp_cg,id_ent,id_or,id_orsrv,id_pat,id_org,code_ent
	 * @param refundBillParamDTO 由调用方拼好所有退费信息。
	 *        住院退费，支持两种模式：1.按明细直接退；2.按收费的主键进行退费，需要设置RefundBillParamDTO
	 * @param code_enttp 就诊类型代码
	 * @return 退费成功，返回FBoolean.True
	 * @throws BizException
	 */
	public abstract FBoolean SetOrderRefundBill_ByIdor(
			BlOrderAppendBillParamDTO[] refundBillParamDTO,String code_enttp) throws BizException ;
	
	/**
	 * 多患者：按医嘱和医嘱下的服务进行退费
	 * 门诊退记账信息，必须录入id_or,id_orsrv,code_ent,id_pat,id_org,id_org_cg,id_dep_cg,id_emp_cg
	 * 住院退记账信息，在BlOrderAppendBillParamDTO中必须生成RefundBillParamDTO，必须录入id_org_cg,id_dep_cg,id_emp_cg,id_ent,id_or,id_orsrv,id_pat,id_org,code_ent
	 * @param refundBillParamDTO 含退费的医嘱和医嘱下的服务的DTO
	 * @param code_enttp 就诊类型代码
	 * @return 退费成功，返回FBoolean.True
	 * @throws BizException
	 */
	public abstract FBoolean SetOrderRefundBill_ByItms_MultiPat(
			BlOrderAppendBillParamDTO[] refundBillParamDTO,String code_enttp) throws BizException ;	
	
	/**
	 * 单患者：按医嘱和医嘱下的服务进行退费
	 * 门诊退记账信息，必须录入id_or,id_orsrv,code_ent,id_pat,id_org,id_org_cg,id_dep_cg,id_emp_cg
	 * 住院退记账信息，在BlOrderAppendBillParamDTO中必须生成RefundBillParamDTO，必须录入id_org_cg,id_dep_cg,id_emp_cg,id_ent,id_or,id_orsrv,id_pat,id_org,code_ent
	 * @param refundBillParamDTO 含退费的医嘱和医嘱下的服务的DTO
	 * @param code_enttp 就诊类型代码
	 * @return 退费成功，返回FBoolean.True
	 * @throws BizException
	 */
	public abstract FBoolean SetOrderRefundBill_ByItms(
			BlOrderAppendBillParamDTO[] refundBillParamDTO,String code_enttp) throws BizException ;
	
	//----------------------------------------------------------------------------------------------
	
	/**
	 * 通用补费接口，返回值为 补费成功后的BlOrderAppendBillParamDTO[]
	 * @param appendBillParamDTO 补费需要的参数
	 * @param appendBillParamDTO 是否是医嘱补费，如果是医嘱补费，则需要验证医嘱及医嘱下服务
	 * @param isCiOrder 是否是医嘱记账，如果是，则由本接口负责将医嘱转换成费用；否则，由调用方直接先将费用等信息组装好再传入本接口。
	 * @throws BizException
	 */
	public abstract BlOrderAppendBillParamDTO[] SetOrderAppendBill(BlOrderAppendBillParamDTO[] appendBillParamDTO,String code_enttp,boolean isCiOrder)  throws BizException;


	
//	/**
//	 * 退费接口，返回值为FBOOLEAN：给刘羽用的
//	 * @param appendBillParamDTO 退费需要的参数:只考虑CG数据，不考虑医嘱数据
//	 * @param appendBillParamDTO 是否是医嘱退费，如果是医嘱退费，则需要验证医嘱及医嘱下服务
//	 * @throws BizException
//	 */
//	public abstract FBoolean RefundOrderAppendBill(BlOrderAppendBillParamDTO[] appendBillParamDTO,boolean isCiOrder)  throws BizException;

	
		
	
//	/**
//	 * 按住院记账主键进行住院记账退费，不更改医嘱信息：供住院医技取消使用
//	 * @param id_cgip 住院记账主键
//	 * @return
//	 * @throws BizException
//	 */
//	public abstract FBoolean RefundInpBlcgById_cgip(String[] Id_cgip)  throws BizException;
	
	/**
	 * 按住院记账主键进行住院记账退费，不更改医嘱信息：供住院医技取消使用
	 * @param id_cgip 住院记账主键
	 * @param operatorInfoDTO 操作人员信息
	 * @return
	 * @throws BizException
	 */
	public FBoolean RefundInpBlcgById_cgip(String[] Id_cgip,OperatorInfoDTO operatorInfoDTO) throws BizException;
	
//	/**
//	 * 医嘱退费接口
//	 * @param appendBillParamDTO 医嘱退费需要的参数
//	 * @throws BizException
//	 */
//	public abstract FBoolean SetOrderRefundBill(BlOrderRefundBillParamDTO[] appendBillParamDTO,boolean isCiOrder)  throws BizException;
	
	/**
	 * 医嘱退记账接口:
	 * 门诊退记账信息，必须录入id_or,id_orsrv,code_ent,id_pat,id_org,id_org_cg,id_dep_cg,id_emp_cg
	 * 住院退记账信息，在BlOrderAppendBillParamDTO中必须生成RefundBillParamDTO，必须录入id_org_cg,id_dep_cg,id_emp_cg,id_ent,id_or,id_orsrv,id_pat,id_org,code_ent
	 * 当isCiOrder=FBoolean.true时，按医嘱下服务整张退（同时满足这四个条件：id_pat,id_org,id_or,id_orsrv）；
	 * 当isCiOrder=FBoolean.false时,由调用方拼好所有信息，包括价格，标准费用等信息
	 * code_ent：就诊类型代码,门诊还是住院
	 */
	public abstract FBoolean SetOrderRefundBill(
			BlOrderAppendBillParamDTO[] refundBillParamDTOs, boolean isCiOrder,String code_ent) throws BizException ;

	/**
	 * 根据服务ID（非物品），返回完整的BlOrderAppendBillParamDTO数组
	 * @param appendBillParamDTOArr 挂号显示价格调用时：
	 *                               1.id_pat,id_enttp,code_enttp,id_srv,quan,eu_direct(挂号填1),id_org_mp,id_dep_mp必填,其他字段可省;
	 *                               2.如果需要支持后付费，则需要设置BlOrderAppendBillParamDTO.setOutpBillDTO(OutpBillDTO.fg_acc=FBoolean.true)
	 * @param operatorInfoDTO 操作员信息
	 * @param id_pripat 患者价格分类
	 * @return 组装完整的BlOrderAppendBillParamDTO数组
	 * @throws BizException
	 */
	public abstract BlOrderAppendBillParamDTO[] getBlOrderAppendBillParamDTOArr(BlOrderAppendBillParamDTO[] appendBillParamDTOArr,OperatorInfoDTO operatorInfoDTO,String id_pripat) throws BizException;

	/**
	 * 供CI调用，进行销账
	 * @param id_ent
	 * @param code_enttp
	 * @param id_emp 操作人员ID
	 * @return  成功，则提示“销账成功，销账金额：……
	 * @author Liwq
	 * @throws BizException
	 */
	public String setRefundBillForCi_ByIdent(String id_ent, String code_enttp,String id_emp) throws BizException ;
} 
