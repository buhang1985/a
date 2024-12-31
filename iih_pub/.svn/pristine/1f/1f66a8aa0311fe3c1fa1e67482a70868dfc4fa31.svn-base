package iih.bl.cg.service.i;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.bdcpnca.d.BdcpncaAggDO;
import iih.bl.cg.api.d.OpPayParam;
import iih.bl.cg.api.d.OpPayReturn;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.dto.d.RePrintInvoiceInfoDTO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.ci.ord.dto.orsrvguide.d.OrSrvGuideDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.mi.biz.dto.d.OepSettleRtnValDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 费用结算 门诊结算调用方法： 1.划价，得出应收费用： BlcgoepAggDO[]
 * SetCiOrderToPricing(BlOrderAppendBillParamDTO[]
 * appendBillParamDTOs,BlStOepDO[] blStOepDO,BlincoepAggDO[]
 * blincoepAggDO,FBoolean PrintOnlyOneInvoice) 2.收款： FBoolean
 * SettlementPayment(BlcgoepAggDO[] blcgoepAggDO,BlpaypatoepAggDO
 * blpaypatoepAggDO,FBoolean IsDrugApplication,FBoolean PrintOnlyOneInvoice)
 * 住院结算调用方法：
 * 
 * @author tcy
 *
 */
public interface IBLCiOrderToBlCgService {
	// /**
	// * 返回 <就诊，发票号>
	// * @param appendBillParamDTO
	// * @return
	// * @throws BizException
	// */
	// public abstract Map<String,String>
	// GetCiOrderToIncMap(BlOrderAppendBillParamDTO[] appendBillParamDTO) throws
	// BizException;
	// /**
	// * 1.门诊新划价
	// * @param appendBillParamDTOs：待划价的明细信息
	// * @param blStOepDO:结算信息，除了不填写金额，其他内容需填写
	// * @param blincoepAggDO：在PrintInvocie=FBoolean.TRUE时，可以设置为null
	// * @param PrintInvocie
	// 是否需要打印发票，FBoolean.TRUE：打印发票，FBoolean.Fasle:不打印发票，不保存发票相关数据
	// * @return
	// * @throws BizException
	// */
	// public abstract BlcgoepAggDO[] SetCiOrderToPricing(
	// BlOrderAppendBillParamDTO[] appendBillParamDTOs,BlStOepDO
	// blStOepDO,BlincoepAggDO blincoepAggDO, FBoolean PrintInvocie) throws
	// BizException ;

	/**
	 * 用于患者离院未结算的情况下自动结算。 目前仅支持商保记账结算。
	 *
	 * @param days
	 *            结算距今天的头几个自然日的费用信息
	 * @throws BizException
	 */
	public abstract FBoolean PriceAndSettlementPayment_hpcg_background(int days, OperatorInfoDTO operatorInfoDTO) throws BizException;
	/**
	 * 仅仅计算价格，如果是物品，不走预留
	 * 
	 * @param appendBillParamDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract BlOrderAppendBillParamDTO[] computePrice(BlOrderAppendBillParamDTO[] appendBillParamDTOs) throws BizException;
	/**
	 * 供就诊领域分诊台挂号使用（划价，扣预交金）
	 * 
	 * @param appendBillParamDTOs
	 *            待处理的费用明细
	 * @param operatorInfoDTO
	 *            操作人员信息
	 * @param PrintInvocie
	 *            是否打印发票
	 * @return 划价结果（划价后的BlCgOepAgg，处方RecipeDTO）
	 * @throws BizException
	 */
	public abstract BlCgOepAggDTO pricingFromPrepay(BlOrderAppendBillParamDTO[] appendBillParamDTOs, OperatorInfoDTO operatorInfoDTO, FBoolean PrintInvocie) throws BizException;

	public abstract BlCgOepAggDTO SetCiOrderToPrice(BlOrderAppendBillParamDTO[] appendBillParamDTOs, OperatorInfoDTO operatorInfoDTO, FBoolean PrintInvocie) throws BizException;

	/**
	 * 重打发票
	 * 
	 * @param strCodest
	 *            结算号
	 * @param operatorInfo
	 *            操作人员信息
	 * @return 发票信息
	 * @throws BizException
	 */ 
	public abstract BlIncItmVsTypeDTO[] doRePrintInc(String strCodest, OperatorInfoDTO operatorInfo) throws BizException;

	/**
	 * 2.门诊新收款：返回打印发票的结构
	 * 
	 * @param sum_amt_acc
	 *            :结算中采用预付款已经锁定的金额，若没有，设置为 null
	 * @param blcgoepAggDO
	 *            ：记账信息
	 * @param blpaypatoepAggDO
	 *            ： 收付款信息
	 * @param IsDrugApplication
	 *            : 是否需要药品请领
	 * @param PrintInvocie
	 *            是否需要打印发票，FBoolean.TRUE：打印发票，FBoolean.Fasle:不打印发票，不保存发票相关数据
	 * @param IsTransferPrepay
	 *            是否结存，即找零数据结转到门诊预交金账户
	 * @return
	 * @throws BizException
	 */
	public abstract BlIncItmVsTypeDTO[] SettlementPayment(BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO, FBoolean IsDrugApplication, FBoolean PrintInvoice, FBoolean IsTransferPrepay)
			throws BizException;

	// /**
	// * 2.门诊新收款：返回打印发票的结构
	// * @param sum_amt_acc:结算中采用预付款已经锁定的金额，若没有，设置为 null
	// * @param blcgoepAggDO：记账信息
	// * @param blpaypatoepAggDO： 收付款信息
	// * @param IsDrugApplication: 是否需要药品请领
	// * @param PrintInvocie
	// 是否需要打印发票，FBoolean.TRUE：打印发票，FBoolean.Fasle:不打印发票，不保存发票相关数据
	// * @param IsTransferPrepay 是否结存，即找零数据结转到门诊预交金账户
	// * @return
	// * @throws BizException
	// */
	// public abstract BlIncItmVsTypeDTO SettlementPayment_test(BlcgoepAggDO[]
	// blcgoepAggDO,BlpaypatoepAggDO blpaypatoepAggDO, FBoolean
	// PrintInvoice,FBoolean IsTransferPrepay) throws BizException ;

	/**
	 * 2.1.门诊挂号新收款(先回写划价的id_ent,在保存收款信息)：返回打印发票的结构
	 * 
	 * @param id_ent
	 *            ：挂号生成的id_ent
	 * @param blcgoepAggDO
	 *            ：记账信息
	 * @param blpaypatoepAggDO
	 *            ： 收付款信息
	 * @param IsDrugApplication
	 *            : 是否需要药品请领
	 * @param PrintInvocie
	 *            是否需要打印发票，FBoolean.TRUE：打印发票，FBoolean.Fasle:不打印发票，不保存发票相关数据
	 * @return
	 * @throws BizException
	 */
	public abstract BlIncItmVsTypeDTO[] SettlementPayment_Register(String id_ent, BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO, FBoolean IsDrugApplication, FBoolean PrintInvoice)
			throws BizException;

	/**
	 * 3.门诊医保新收款：返回打印发票的结构
	 * 
	 * @param blPropOepDOArr
	 *            门诊分摊
	 * @param blproparoepAggDOArr
	 *            门诊分摊明细模型
	 * @param blcgoepAggDO
	 *            ：记账信息
	 * @param blpaypatoepAggDO
	 *            ： 收付款信息
	 * @param IsDrugApplication
	 *            : 是否需要药品请领
	 * @param PrintInvocie
	 *            是否需要打印发票，FBoolean.TRUE：打印发票，FBoolean.Fasle:不打印发票，不保存发票相关数据
	 * @param IsTransferPrepay
	 *            是否结转，即找零的费用转存到门诊预交金账户
	 * @return 返回打印发票的结构,其中，第一个数组中的BIncSumAmtInfoDTO代表本次发票的总金额
	 * @throws BizException
	 */
	public abstract BlIncItmVsTypeDTO[] SettlementInsurPayment(OepSettleRtnValDTO oepSettleRtnValDto,BlPropOepDO[] blPropOepDOArr, BlproparoepAggDO[] blproparoepAggDOArr, BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO,
			FBoolean IsDrugApplication, FBoolean PrintInvoice, FBoolean IsTransferPrepay) throws BizException;

	/**
	 * 4.门诊结算（特殊病）：含分摊的付款，但是没有分摊明细，返回打印发票的结构
	 * 
	 * @param blPropOepDOArr
	 *            门诊分摊
	 * @param blproparoepAggDOArr
	 *            门诊分摊明细模型
	 * @param blcgoepAggDO
	 *            ：记账信息
	 * @param blpaypatoepAggDO
	 *            ： 收付款信息
	 * @param IsDrugApplication
	 *            : 是否需要药品请领
	 * @param PrintOnlyOneInvoice
	 *            ：在PrintInvocie=FBoolean.TRUE时起作用。
	 *            记账信息包含多次就诊信息时，如果该参数是FBoolean.TRUE，则打印一张发票，否则，打印多张发票
	 * @param PrintInvocie
	 *            是否需要打印发票，FBoolean.TRUE：打印发票，FBoolean.Fasle:不打印发票，不保存发票相关数据
	 * @param IsTransferPrepay
	 *            是否结转，即找零的费用转存到门诊预交金账户
	 * @return 返回打印发票的结构,其中，第一个数组中的BIncSumAmtInfoDTO代表本次发票的总金额
	 * @throws BizException
	 */
	public abstract BlIncItmVsTypeDTO[] SettlementInsurPaymentNoItmProp(BlPropOepDO[] blPropOepDOArr, BlproparoepAggDO[] blproparoepAggDOArr, BlcgoepAggDO[] blcgoepAggDO,
			BlpaypatoepAggDO blpaypatoepAggDO, FBoolean IsDrugApplication, FBoolean PrintInvoice, FBoolean IsTransferPrepay) throws BizException;

	/**
	 * 重新打印门诊发票，将原发票信息放在空白作废票中，新发票号替换原发票号 只能重新打印当前票号的上一张号
	 * 
	 * @param id_stoep
	 *            欲重打发票的结算号
	 * @param operatorInfo
	 *            操作员信息
	 * @param code_incpkg
	 *            票据包
	 * @return
	 * @throws BizException
	 */
	public abstract BlIncItmVsTypeDTO[] doRepeatPrintOepInvoice(String id_stoep, OperatorInfoDTO operatorInfo, String code_incpkg) throws BizException;

	/**
	 * 门诊新收款：从DTO中获得：就诊，发票号1|就诊，发票号2
	 * 
	 * @param appendBillParamDTOs
	 * @param Id_emp_inc
	 *            开票人ID
	 * @param code_incca
	 *            票据种类代码
	 * @param PrintOnlyOneInvoice
	 *            TRUE:多次就诊打印一张发票. FALSE:若是多次就诊打印多张发票，则
	 * @param code_incpkg
	 *            :票据包 一次遍历获得(多次就诊打多张发票): 就诊，发票号1|就诊，发票号2|...| 否则（多次就诊打一张发票）：
	 *            病人ID，发票号|
	 * @return
	 * @throws BizException
	 */
	public abstract String GetEntInvoicenoFromDTO(BlOrderAppendBillParamDTO[] appendBillParamDTOs, String Id_emp_inc, String code_incca, String code_incpkg) throws BizException;

	/**
	 * 回写划价产生数据所缺失的id_ent
	 * 
	 * @param id_ent
	 *            回写的id_ent
	 * @param blcgoepAggDO
	 *            划价后的数据
	 * @throws BizException
	 */
	public abstract void UpdateBlOepPriceIdent(String id_ent, BlcgoepAggDO[] blcgoepAggDO) throws BizException;

	/**
	 * 通过 id_or 获取医嘱信息判断当前是否有重复医嘱
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract String CiOrderById_or_validate(String[] id_ors) throws BizException;

	// /**,
	// * 1.存入门诊记账主表和明细表
	// * @param appendBillParamDTO 需要的参数
	// * @param
	// PrintOnlyOneInvoice:FBoolean.True:多次就诊打印一张发票；FBoolean.False:多次就诊打印多张发票
	// * @return 返回记账AGG:一次结算，产生一条记账主表，若干记账明细
	// * @throws BizException
	// */
	// public abstract BlcgoepAggDO[]
	// SetCiOrderToBlCgOEP(BlOrderAppendBillParamDTO[]
	// appendBillParamDTO,FBoolean PrintOnlyOneInvoice) throws BizException;

	// /**
	// * 2.用结算主键更新门急诊记账表的标志
	// * @param blcgoepAggDO
	// * @return
	// * @throws BizException
	// */
	// public abstract FBoolean UpdateBlCgOEPStIp(BlcgoepAggDO[]
	// blcgoepAggDO,BlStOepDO blStOepDO) throws BizException;
	// /**
	// * 用结算主键更新住院记账表的标志
	// * @param blCgItmOepDO
	// * @return
	// * @throws BizException
	// */
	// public abstract FBoolean UpdateBlCgIPStIp(BlCgIpDO[] blCgItmOepDO) throws
	// BizException;

	// /**
	// * 2.门急诊结算：写结算表和发票表(门诊业务逻辑：一次结算，打印一张或多张发票）
	// * @param
	// blStOepDO：按就诊ID和就诊类型的产生的结算数组，一次就诊产生一次DO，多次就诊产生多次DO（就诊=id_pat+" "+id_org+" "+id_ent+" "+id_enttp）
	// * @param
	// blincoepAggDO：发票AGG数组，一个blStOepDO，对应一个发票AGG；多个blStOepDO，对应多个发票AGG
	// * @param BlcgoepAggDO：结账AGG(来自于”划价”接口返回结果)
	// * @param blpaypatoepAggDO:收付款AGG
	// * @param
	// PrintOnlyOneInvoice:FBoolean.True:多次就诊打印一张发票；FBoolean.False:多次就诊打印多张发票
	// * @return
	// * @throws BizException
	// */
	// public abstract BlIncItmVsTypeDTO[] SettlementVsInvoiceOep(BlStOepDO[]
	// blStOepDO,BlincoepAggDO[] blincoepAggDO,BlcgoepAggDO[]
	// blcgoepAggDO,BlpaypatoepAggDO blpaypatoepAggDO,FBoolean
	// PrintOnlyOneInvoice) throws BizException;

	// /**
	// * 2.门急诊退费结算（不含划价部分）：供红冲后再划价使用
	// * @param
	// blStOepDO：按就诊ID和就诊类型的产生的结算数组，一次就诊产生一次DO，多次就诊产生多次DO（就诊=id_pat+" "+id_org+" "+id_ent+" "+id_enttp）
	// * @param
	// blincoepAggDO：发票AGG数组，一个blStOepDO，对应一个发票AGG；多个blStOepDO，对应多个发票AGG
	// * @param BlcgoepAggDO：记账AGG，红冲后返回的待解算AGG
	// * @param blpaypatoepAggDO:收付款AGG
	// * @param opDgRtnAmountDTOs:退药品信息：《所属记账明细主键，退费数量》
	// * @return
	// * @throws BizException
	// */
	// public abstract BlIncItmVsTypeDTO[] SettlementAfterRedBill(BlStOepDO[]
	// blStOepDO,BlincoepAggDO[] blincoepAggDO,BlcgoepAggDO[]
	// blcgoepAggDO,BlpaypatoepAggDO blpaypatoepAggDO,OpDgRtnAmountDTO[]
	// opDgRtnAmountDTOs) throws BizException;

	/**
	 * 2.门急诊退费结算（不含划价部分）：供红冲后再划价使用。settlementAfterRedBill稳定后，删除该接口
	 * 
	 * @param blStOepDO
	 *            ：按就诊ID和就诊类型的产生的结算数组，一次就诊产生一次DO，多次就诊产生多次DO（就诊=id_pat+" "+id_org
	 *            +" "+id_ent+" "+id_enttp）
	 * @param blincoepAggDO
	 *            ：发票AGG数组，一个blStOepDO，对应一个发票AGG；多个blStOepDO，对应多个发票AGG
	 * @param BlcgoepAggDO
	 *            ：记账AGG，红冲后返回的待解算AGG
	 * @param blpaypatoepAggDO
	 *            :收付款AGG
	 * @return
	 * @throws BizException
	 */
	public abstract BlIncItmVsTypeDTO[] SettlementAfterRedBill_new_discard(BlStOepDO[] blStOepDO, BlincoepAggDO[] blincoepAggDO, BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO)
			throws BizException;

	/**
	 * 红冲后，重收结算代码。（最新版，2017-2-9）
	 * 
	 * @param blcgoepAggDO_recharge
	 *            需要重新收费的记账信息
	 * @param orgin_idstoep
	 *            原始结算ID
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @param blpaypatoepAggDO
	 *            退费的收付款记录
	 * @param AllRefundAndAllCharge
	 *            是否重划重收标志，重划重收时，红冲的支付明细fg_realpay='N'
	 * @param fDateTime
	 *            服务器时间
	 * @return 待打印的发票DTO
	 * @throws BizException
	 */
	public abstract BlIncItmVsTypeDTO[] settlementAfterRedBill(BlcgoepAggDO[] blcgoepAggDO_recharge, String orgin_idstoep, OperatorInfoDTO operatorInfoDTO, BlpaypatoepAggDO blpaypatoepAggDO,
			FBoolean AllRefundAndAllCharge, FDateTime fDateTime) throws BizException;

	// /**
	// * 2.门急诊新结算：写收付款表
	// * @param BlcgoepAggDO：结账AGG(来自于”划价”接口返回结果)
	// * @param blpaypatoepAggDO:收付款AGG
	// * @param
	// PrintOnlyOneInvoice:FBoolean.True:多次就诊打印一张发票；FBoolean.False:多次就诊打印多张发票
	// * @return
	// * @throws BizException
	// */
	// public abstract BlIncItmVsTypeDTO[] SettlementOep(BlcgoepAggDO[]
	// blcgoepAggDO,BlpaypatoepAggDO blpaypatoepAggDO,FBoolean
	// PrintOnlyOneInvoice) throws BizException;

	// /**
	// * 取消存入门诊记账主表和明细表，供取消划价使用(删除，修改医嘱标志)
	// * @param blcgoepAggDOs 取消划价的数组
	// * @return
	// * @throws BizException
	// */
	// public abstract FBoolean RollbackSetCiOrderToBlCgOEP(BlcgoepAggDO[]
	// blcgoepAggDOs) throws BizException;

	/**
	 * 3.门诊新结算：取消划价（删除cg,st,inc,prop)
	 * 
	 * @param blcgoepAggDOs
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean DeletePricingInfo(BlcgoepAggDO[] blcgoepAggDOs) throws BizException;

	/**
	 * 3.门诊新结算：取消指定结账主键的划价（删除cg,st,inc,prop)
	 * 
	 * @param id_cgoepArr
	 *            取消指定结账的主键数组
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean DeleteOepPricingInfo(String[] id_cgoepArr) throws BizException;

	/**
	 * 通过子表条件，查询出未结算BlcgoepAggDO数组 a1.id_pat = '" + id_pat +
	 * "' and a1.id_org = '" + id_org + "' and a1.eu_direct = '" + eu_direct +
	 * "'
	 */
	public abstract BlcgoepAggDO[] FindByItmsCondition(String id_pat, String id_org, String eu_direct) throws BizException;

	/**
	 * 查询未结算的记账信息，并在第一个主表中根据就诊返回就诊发票号
	 * 
	 * @param condStr
	 *            查询条件
	 * @param Id_emp_inc
	 *            发票人员ID
	 * @param Code_incca
	 *            票据类型
	 * @param code_incpkg
	 *            :如果要打发票，则是该发票所属票据包
	 * @return
	 * @throws BizException
	 */
	public abstract BlCgOepAggDTO FindNoSettlementBlcgoepAggDOWithNewInvocie(String condStr, OperatorInfoDTO operatorInfoDTO, String Code_incca, String code_incpkg) throws BizException;

	/**
	 * 查询该患者未收款信息下的最小发票号
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public abstract String GetMinInvoicenoFromStOepWithoutPay(String id_pat) throws BizException;

	/**
	 * 获得需要持卡结算的医保计划
	 * 
	 * @param xx
	 *            无意义，但框架要求需要参数
	 * @return
	 * @throws BizException
	 */
	public abstract String[] GetHpByCardSettlement(String xx) throws BizException;

	/**
	 * 根据id_ent获得EntHpDO[]
	 * 
	 * @param id_ent
	 * @return
	 */
	public abstract EntHpDO[] getEntHpDOArr(String id_ent) throws BizException;

	public abstract OrSrvGuideDTO[] getOrSrvGuideDTO(String[] arrIdOrSrv) throws BizException;

	/**
	 * 如果患者采用预交金支付，则统计预交金支付金额，且修改门诊预交金账户
	 * 
	 * @param blpaypatoepAggDOs
	 *            支付方式
	 * @throws BizException
	 */
	public abstract void doPayByPrepay(BlpaypatoepAggDO[] blpaypatoepAggDOs) throws BizException;

	public abstract BdcpncaAggDO GetCouponcaAggDOByCode(String couponCode, String strIdPat, FBoolean isCouponCa) throws BizException;

	/**
	 * 获得门诊结算码（门诊结算业务流水号）
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract String GetBlOepCodeSt() throws BizException;

	/**
	 * 打印门诊挂号发票
	 * 
	 * @param strIdPat
	 *            患者id
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @return 发票信息
	 * @throws BizException
	 * @author Liwq 添加参数解决挂号发票选择性打印
	 */
	public abstract BlIncItmVsTypeDTO[] printRegisterInvoice(String strIdPat, OperatorInfoDTO operatorInfoDTO, String[] strArr) throws BizException;

	/**
	 * 挂号划价结算一体化:仅处理单次挂号,成功返回FBoolean.true
	 * 
	 * @param appendBillParamDTOs
	 *            费用明细
	 * @param blpaypatoepAggDO
	 *            支付明细
	 * @param blPropOepDOArr
	 *            医保分摊1，无分摊则为null
	 * @param blproparoepAggDOArr
	 *            医保分摊2，无分摊则为null
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @param tradeNo
	 *            医保交易号
	 * @param code_st
	 *            结算号
	 * @param PrintInvoice
	 *            是否打印发票
	 * @param IsTransferPrepay
	 *            余额是否结转到预交金
	 * @return 发票信息
	 * @throws BizException
	 */
	public abstract BlIncItmVsTypeDTO[] PriceAndSettlementPayment_Register(BlOrderAppendBillParamDTO[] appendBillParamDTOs, BlpaypatoepAggDO blpaypatoepAggDO, BlPropOepDO[] blPropOepDOArr,
			BlproparoepAggDO[] blproparoepAggDOArr, OperatorInfoDTO operatorInfoDTO, String tradeNo, String code_st, FBoolean PrintInvoice, FBoolean IsTransferPrepay,String idCg) throws BizException;

	/**
	 * 挂号划价结算一体化:仅处理单次挂号（含医保）
	 * 
	 * @param appendBillParamDTOs
	 *            费用明细
	 * @param blpaypatoepAggDO
	 *            支付明细
	 * @param blPropOepDOArr
	 *            医保分摊1，无分摊则为null
	 * @param blproparoepAggDOArr
	 *            医保分摊2，无分摊则为null
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @param tradeNo
	 *            医保交易号
	 * @param code_st
	 *            结算号
	 * @param PrintInvoice
	 *            是否打印发票
	 * @param IsTransferPrepay
	 *            余额是否结转到预交金
	 *@param oepSettleRtnValDto
	 *医保结算返回值
	 * @return 发票信息
	 * @throws BizException
	 */
	public abstract BlIncItmVsTypeDTO[] PriceAndSettlementPaymentInsurance_Register(BlOrderAppendBillParamDTO[] appendBillParamDTOs, BlpaypatoepAggDO blpaypatoepAggDO, BlPropOepDO[] blPropOepDOArr,
			BlproparoepAggDO[] blproparoepAggDOArr, OperatorInfoDTO operatorInfoDTO, String tradeNo, String code_st, FBoolean PrintInvoice, FBoolean IsTransferPrepay,String idCg,OepSettleRtnValDTO oepSettleRtnValDto) throws BizException;

	/**
	 * 根据结算号更新未打印发票表的发票号
	 * 
	 * @param id_stoepArr
	 * @param operatorInfoDTO
	 * @param Code_incca
	 * @param code_incpkg
	 * @throws BizException
	 */
	public abstract FBoolean updateBlIncOepIncno(String[] id_stoepArr, OperatorInfoDTO operatorInfoDTO, String Code_incca, String code_incpkg) throws BizException;

	/**
	 * 获取所有商保对应的合同单位(门诊)
	 * 
	 * @author Liwq
	 * @throws BizException
	 */
	public abstract HPDO[] GetAllHpCust() throws BizException;

	/**
	 * 供第三方划价和结算一体化
	 * 
	 * @param orderBillParamDTOs
	 * @param operatorInfoDTO
	 * @return OutpatientPaymentReturn 返回值 1：失败 0：成功
	 * @author liwq
	 * @throws BizException
	 */
	public OpPayReturn PriceAndSettlementPaymentForThirdParty(BlOrderAppendBillParamDTO[] orderBillParamDTOs, OperatorInfoDTO operatorInfoDTO, FDouble money, String id_pat,
			OpPayParam thirdPartyParam) throws BizException;

	/**
	 * 供第三方：根据就诊id和处方号查询未结算费用
	 * 
	 * @param id_pres
	 * @param id_ent
	 * @author Liwq
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] getNoSettledSrvFromCiByIdentIdPres(String id_pres, String id_ent) throws BizException;
	
	public BlIncItmVsTypeDTO[] doRePrintInvoice(String strCodeSt,
			OperatorInfoDTO operatorInfo,
			RePrintInvoiceInfoDTO rePrintInvoiceInfoDTO) throws BizException;
	
	/**
	 * 发票重打新版本
	 * @param stId 结算id
	 * @param incDtos 需重打发票信息
	 * @return
	 * @throws BizException
	 * @author ly 2018/04/16
	 */
	public abstract BlIncItmVsTypeDTO[] doRePrintIncNew(String stId,RePrintInvoiceInfoDTO[] incDtos) throws BizException;

}
