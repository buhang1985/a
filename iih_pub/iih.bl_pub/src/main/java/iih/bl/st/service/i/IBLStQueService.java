package iih.bl.st.service.i;

import java.util.Map;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.et.auditresultdto.d.AuditResultDTO;
import iih.bl.inc.dto.d.RePrintInvoiceInfoDTO;
import iih.bl.pay.dto.d.BlBannerDTO;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blcgipdto.d.BlCgIpDTO;
import iih.bl.st.blcgipdto.d.BlStBaseInfo;
import iih.bl.st.blipauditouthospcheck.d.BlIpAuditOutHospCheckDTO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.dto.d.BlAuditIncInfoDTO;
import iih.bl.st.dto.d.BlAuditLogIpDTO;
import iih.bl.st.dto.d.BlEntInfoDTO;
import iih.bl.st.dto.d.BlIpAuditCiDTO;
import iih.bl.st.dto.d.BlIpAuditFeeDTO;
import iih.bl.st.dto.d.BlIpAuditStPayInfoDTO;
import iih.bl.st.dto.d.BlIpChargeAuditDTO;
import iih.bl.st.dto.d.BlOpFeeOutDTO;
import iih.bl.st.dto.d.BlStIpBadDebtDTO;
import iih.bl.st.dto.d.BlStIpBillDTO;
import iih.bl.st.dto.d.BlStIpCardInfoDTO;
import iih.bl.st.dto.d.BlStIpInccaInfoDTO;
import iih.bl.st.dto.d.BlStIpInccanoDTO;
import iih.bl.st.dto.d.BlStOepVsIncDTO;
import iih.bl.st.dto.d.DebtPayBackDTO;
import iih.bl.st.dto.d.InsurUnitDepFreqDoseDTO;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDO;
import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDiDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.xbd.measdoc.d.MeasDocDO;

public interface IBLStQueService {
	/**
	 * 检查是否有门诊、住院的欠费记录，若有，则给予提示
	 * @param id_pat 患者ID
	 * @return 若有欠费，则返回提示信息，否则返回“”
	 * @throws BizException
	 */
	public abstract String doValidateArrearage(String id_pat) throws BizException;
	
	/**
	 * 根据患者id获取医嘱费用信息,按id_pres排序，适合用于门诊收费“调入”
	 * @param id_pat 患者id
	 * @param defaultDaysLoadOep 调入医嘱天数
	 * */
	public abstract BlOrderAppendBillParamDTO[] getOrderSrvPrinceInfoByIdpres_load(String id_pat,int defaultDaysLoadOep) 
			throws BizException;
	
	/**
	 * 根据患者id获取医嘱费用信息,按id_pres排序，适合用于门诊收费“调入” 不删除挂起数据
	 * @param id_pat 患者id
	 * @param defaultDaysLoadOep 调入医嘱天数
	 * */
	public abstract BlOrderAppendBillParamDTO[] getOrderSrvPrinceInfoByIdpres_load_NoDel(String id_pat,int DefaultDaysLoadOep) 
			throws BizException;
	
	/**
	 * 按就诊id，医嘱费用状态， 离今天几个自然日,提取对应状态的已签署医嘱和未结算的商保记账信息
	 * @param id_ent 就诊id
	 * @param sd_su_bl 医嘱费用状态。0：未记账；1：已记账；2：已退费；
	 * @param id_pat 患者ID
	 * @param days  离今天几个自然日
	 * @return 对应状态的已签署医嘱和未结算的商保记账信息
	 * @throws BizException
	 */
	public abstract BlOrderAppendBillParamDTO[] getNoSettlementSrvPriceInfoByIdent(String id_ent, String[] sd_su_bl,String id_pat,int days) throws BizException;

	
	/**
	 * 按就诊id和医嘱费用状态，提取对应状态的已签署医嘱
	 * @param id_ent 就诊id
	 * @param sd_su_bl 医嘱费用状态。0：未记账；1：已记账；2：已退费；
	 * @return
	 * @throws BizException
	 */
	public abstract BlOrderAppendBillParamDTO[] getOrderSrvPrinceInfoByIdent(String id_ent, String[] sd_su_bl) throws BizException; 

	
	/**
	 * 根据患者id获取医嘱费用信息,按id_pres排序，适合用于门诊收费显示banner调入今天未结算信息
	 * @param id_pat 患者id
	 * @param id_org 所属组织id
	 * */
	public BlOrderAppendBillParamDTO[] getOrderSrvPrinceInfoByIdpres_1(String id_pat,String id_org,int DefaultDaysStOep) 
			throws BizException;
	
	/**
	 * 根据患者id获取医嘱费用信息,按id_pres排序
	 * @param id_pat 患者id
	 * @param dtSignB 医嘱开立日期 （开始时间）
	 * @param dtSignE 医嘱开立日期 （结束时间）
	 * @param id_org 所属组织id
	 * */
	public  abstract BlOrderAppendBillParamDTO[] findOrderByIdPres(String id_pat,FDateTime dtSignB,FDateTime dtSignE,String id_org)
			throws BizException;

//	/**
//	 * 根据患者id获取医嘱费用信息
//	 * @param id_pat 患者id
//	 * @param dtSignB 医嘱开立日期 （开始时间）
//	 * @param dtSignE 医嘱开立日期 （结束时间）
//	 * @param id_org 所属组织id
//	 * */
//	public abstract BlOrderAppendBillParamDTO[] findByIdPat(String id_pat,FDateTime dtSignB,FDateTime dtSignE,String id_org) throws BizException;
//	
//	/**
//	 * 根据患者id获取医嘱信息
//	 * @param id_pat 患者id
//	 * @param id_org 所属组织id
//	 * */
//	public abstract BlOrderAppendBillParamDTO[] findOrderByIdPat(String id_pat,String id_org) throws BizException;
//	
//	/**
//	 * 根据医嘱id获取医嘱信息
//	 * @param id_pat 患者id
//	 * @param id_org 所属组织id
//	 * @param orderArr 医嘱信息DTO列表
//	 * */
//	public abstract BlOrderAppendBillParamDTO[] findByIdOr(String id_pat, String id_org,BlOrderAppendBillParamDTO[] orderArr) throws BizException;
//	
//	/**
//	 * 根据患者id获取全部医嘱费用信息
//	 * @param id_pat 患者id
//	 * @param id_org 所属组织id
//	 * */
//	public abstract BlOrderAppendBillParamDTO[] findOrByIdPat(String id_pat,String id_org) throws BizException;
//	
//	/**
//	 * 测试接口（有挂起数据测试）
//	 * */
//	public abstract BlOrderAppendBillParamDTO[] findByIdPatSuspTest(String id_pat,String id_org) throws BizException;
//
//	/**
//	 * 测试接口（已记账  + 未记账）
//	 * */
//	public abstract BlOrderAppendBillParamDTO[] findByIdPatTest(String id_pat,String id_org) throws BizException;
//
//	/**
//	 * 测试接口（全记账数据测试）
//	 * */
//	public abstract BlOrderAppendBillParamDTO[] findByIdPatOepTest(String id_pat,String id_org) throws BizException;
//
//	/**
//	 * 测试接口（全未记账数据测试）
//	 * */
//	public abstract BlOrderAppendBillParamDTO[] findByIdPatNoepTest(String id_pat,String id_org) throws BizException;
	
	/**
	 * 获取患者住院结算未付款的结算数
	 * */
	public abstract Integer findNoPayBlstipCountByIdEnt(String id_ent) throws BizException;
	
	/**
	 * 住院结算获取患者预交金信息
	 * @param id_ent 就诊id
	 * @return FDouble[] 第一个值是患者预交金总额，第二个值是患者预交金账户总额
	 * */
	public abstract BlStIpCardInfoDTO findPayInfoByIdPat(String id_ent) throws BizException;
	
	/**
	 * 根据诊断id、科室id和结束时间获取结账信息
	 * @param id_ent 就诊id
	 * @param id_dep 科室id
	 * @param dt_ent 结束时间
	 * @return BlCgIpDO[] 住院记账信息
	 * */
	public abstract BlCgIpDO[] findBlCgIpItemByQuery(String id_ent, String id_dep, FDateTime dt_end) throws BizException;
	
	/**
	 * 根据诊断id、科室id和结束时间获取结账信息 (改造)
	 * @param id_ent 就诊id
	 * @param id_dep 科室id
	 * @param dt_ent 结束时间
	 * @return BlCgIpDO[] 住院记账信息
	 * @author liwenqiang
	 * */
	public abstract BlCgIpDTO[] findBlCgIpItemByQueryReform(String id_ent, String id_dep, FDateTime dt_end) throws BizException;
	
	
	/**
	 * 住院结算-调入-（分页查询）
	 * @param map
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BlCgIpDO> findBlCgIpPageInfoDos(FMap map, PaginationInfo pageInfo) throws BizException;
	
	/**
	 * 住院结算-调入-（分页查询）改造
	 * @param map
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 * @author liwenqiang
	 */
	public PagingRtnData<BlCgIpDTO> findBlCgIpPageInfoDosReform(FMap map, PaginationInfo pageInfo) throws BizException;
	/**
	 * 根据结算获取账单信息
	 * @param id_stip 结算id
	 * */
	public BlStIpBillDTO findBlStIpBillInfoByIdStIp(String id_stip) throws BizException;
	
	/**
	 * 根据结算获取账单表格中信息
	 * @param id_stip 结算id
	 * @return BlStIpInccaInfoDTO[] 账单信息
	 * */
	public abstract BlStIpInccaInfoDTO[] findBdInccaInfoByIdStIp(String id_stip) throws BizException;
	
	/**
	 * 根据就诊获取结算账单信息
	 * @param id_ent 就诊id
	 * @return BlStIpInccaInfoDTO[] 账单信息
	 * */
	public abstract BlStIpInccaInfoDTO[] findBdInccaInfoByIdEnt(String id_ent) throws BizException;
	
	/**
	 * 根据结算获取对应的账单细目
	 * @param id_stip 结算id
	 * */
	public abstract BlCgIpDO[] findBlCgIpItemByIdStIp(String id_stip) throws BizException;
	
	/**
	 * 根据用户获取住院发票号和住院押金条票据号
	 * @param id_psndoc 操作员id
	 * */
	public abstract BlStIpInccanoDTO findBlStIpNoByIdUser(String id_psndoc) throws BizException;
	
	/**
	 * 获取就诊对应的未付款结算信息
	 * */
	public abstract BlStIpDO findBlStIpInfoByIdEnt(String id_ent) throws BizException;
	
	/**
	 * 获取就诊对应的价格系数
	 * */
	public abstract FDouble findPatRateByIdEnt(String id_ent) throws BizException;

	/**
	 * 获取就诊欠款结算信息
	 * */
	public DebtPayBackDTO[] findArrearsBlStIpByIdEnt(String id_ent) throws BizException;
	
	/**
	 * 获得包装单位：包装单位ID，包装单位名称
	 * @return
	 * @throws BizException
	 */
	public MeasDocDO[] getMeasDocDOArr() throws BizException;
	
	/**
	 * 获得分摊的医保计划，包装单位，医保科别，医保剂型，医保频率
	 * @return
	 * @throws BizException
	 */
	public InsurUnitDepFreqDoseDTO getInsurUnitDepFreqDoseDTO() throws BizException;
	
	/**
	 * 住院收付款节点Banner对应的就诊信息
	 * */
	public PatiVisitDO[] findBlStIpPayBanner(String id_pat) throws BizException;
	
	/**
	 * 住院结算退费节点Banner对应的就诊信息
	 * */
	public PatiVisitDO[] findBlStIpPayRefundBanner(String id_pat) throws BizException;
	
	/**
	 * 欠款补交结算节点Banner对应的就诊信息
	 * */
	public PatiVisitDO[] findBlStIpArrearsBanner(String id_pat) throws BizException;
	
	/**
	 * 获取欠款结算信息或坏账信息
	 * */
	public BlStIpBadDebtDTO[] findBlStIpBadPayInfo(FBoolean fg_baddebt) throws BizException;
	
	/**
     * 根据Banner输入值查找对应就诊信息（住院结算）
     * */
    public abstract BlBannerDTO[] findStIpBannerDtoInfo(String inputValue,String[] selectCondition) throws BizException;
    
    /**
     * 根据Banner输入值查找对应就诊信息（住院费用审核只检索未结算患者）
     * liwq
     * */
    public abstract BlBannerDTO[] findStIpBannerEntInfo(String inputValue,String[] selectCondition) throws BizException;
    /**
     * 根据Banner输入值查找对应就诊信息（住院结算收付款）
     * */
    public abstract BlBannerDTO[] findStPayBannerDtoInfo(String inputValue,String[] selectCondition) throws BizException;
    
    /**
     * 根据Banner输入值查找对应就诊信息（住院退费）
     * */
    public abstract BlBannerDTO[] findStRefundBannerDtoInfo(String inputValue,String[] selectCondition) throws BizException;
    
    /**
     * 根据Banner输入值查找对应就诊信息（欠款补交结算）
     * */
    public abstract BlBannerDTO[] findStArrearsBannerDtoInfo(String inputValue,String[] selectCondition) throws BizException;
    
    
    /**
     * 根据id_ent 查询 已结算费用的状态、是否付款 及结算日期
     * @author liwq
     * @param id_ent
     */
    public BlIpChargeAuditDTO[] findFeeStateByIdent(String id_ent) throws BizException;
    
    /**
	 * 根据就诊id获取未结算账单信息
	 * @param id_ent 就诊id
	 * @param fgSt  结算标志  Y-> 查询已结算  N->查询未结算  null->查询所有费用
	 * @return BlStIpInccaInfoDTO[] 账单信息
	 * @throws BizException
	 * @author liwq 
	 * */
	public BlStIpInccaInfoDTO[] getInccaInfoByIdEnt(String id_ent,String fgSt) throws BizException ;
	
	/**
	 * 根据就诊id获取已结算发票信息
	 * @param id_ent 就诊id
	 * @param id_stip 结算id
	 * @return BlAuditIncInfoDTO[] 费用审核-发票信息
	 * @throws BizException
	 * @author liwq 
	 * */
	public BlAuditIncInfoDTO[] getBlAuditIncInfoByIdEnt(String id_ent,String id_stip) throws BizException;
	
	/**
	 * 根据就诊id_ent id_stip fg_st获取费用信息 
	 * @param BlIpChargeAuditDTO 树形节点模型
	 * @param id_ent      就诊id
	 * @return BlIpAuditFeeDTO[] 费用审核-费用信息
	 * @throws BizException
	 * @author liwq
	 * @throws DAException
	 * */
	public BlIpAuditFeeDTO[] getBlIpAuditFeeInfo(BlIpChargeAuditDTO treeAuditDTO) throws BizException;
	
	/**
	 * 根据就诊id和id_srv fg_st 获取费用明细
	 * BlIpAuditFeeDTO 费用信息模型
	 * @param id_ent 就诊id id_srv 服务id
	 * @param fg_st 是否结算 id_stip 结算id
	 * @param PaginationInfo 分页信息
	 * @return BlIpAuditFeeDTO[] 费用审核-费用信息
	 * @throws BizException
	 * @author liwq
	 * @throws DAException
	 * */
	public PagingRtnData<BlIpAuditFeeDTO> getBlIpAuditFeeItemInfo(BlIpAuditFeeDTO auditFeeDto, String fg_st,String id_stip, PaginationInfo pageInfo) throws BizException;
	
	/**
	 * 根据结算id_stip获取已结算费用收付款信息
	 * @param id_stip 结算id
	 * @return BlIpAuditStPayInfoDTO[] 费用审核-已结算收款信息
	 * @throws BizException
	 * @author liwq 
	 * @throws DAException 
	 * */
	public BlIpAuditStPayInfoDTO[] getBlIpAuditStPayInfo(String id_stip) throws BizException;
	
	/**
	 * 根据就诊id获取患者就诊账户封账状态
	 * @param id_ent 急诊id
	 * @return FBoolean
	 * @throws BizException
	 * @author liwq 
	 * @throws DAException 
	 * */
	public FBoolean getPatiEntAccStatusInfo(String id_ent) throws BizException;
	
	/**
	 * 根据就诊id获取住院费用审核是否有启用审核记录
	 * @param id_ent 就诊id
	 * @return BlAuditIp[]
	 * @throws BizException
	 * @author liwq 
	 * @throws DAException 
	 * */
	public BlAuditIp[] getPatiIpAuditInfo(String id_ent) throws BizException;
	
	/**
	 * 保存住院审核（insert新记录）
	 * @param 患者就诊id_ent
	 * @param OperatorInfoDTO 个人信息DTO
	 * @author liwq
	 * @return BlAuditIp
	 */
	public BlAuditIp saveIpAudit(String id_ent, OperatorInfoDTO operatorInfoDTO) throws BizException;
	
	/**
	 * 取消住院审核（更新住院审核标志）
	 * @param 费用已审核记录主键id_auditip
	 * @param OperatorInfoDTO 个人信息DTO
	 * @author liwq
	 * @return BlAuditIp
	 */
	public BlAuditIp cancelIpAudit(BlAuditIp auditIp, OperatorInfoDTO operatorInfoDTO) throws BizException;
	
	/**
	 * 医保审核（更新医保审核标志）
	 * @param 费用已审核记录主键id_auditip
	 * @param OperatorInfoDTO 个人信息DTO
	 * @author liwq
	 * @return BlAuditIp
	 */
	public BlAuditIp saveHpAudit(String id_ent, OperatorInfoDTO operatorInfoDTO) throws BizException;
	
	/**
	 * 取消医保审核（更新医保审核标志）
	 * @param id_auditip
	 * @param OperatorInfoDTO 个人信息DTO
	 * @author liwq
	 * @return BlAuditIp
	 */
	public BlAuditIp cancelHpAudit(BlAuditIp auditip, OperatorInfoDTO operatorInfoDTO) throws BizException;
	
	/**
	 * 根据就诊id 获取医嘱内容
	 * @param id_ent
	 * @return BlIpAuditCiDTO[]
	 * @author liwq
	 */
	public BlIpAuditCiDTO[] getBlIpAuditCiInfo(BlIpAuditCiDTO auditCiDto) throws BizException;
	
	/**
	 * 获取医嘱内容对应的记账明细(分页)
	 * @param BlIpAuditCiDTO  合计项dto
	 * @param PaginationInfo
	 * @author liwq
	 * @throws DAException
	 */
	public PagingRtnData<BlIpAuditCiDTO> getIpCiCgFeePageInfo(BlIpAuditCiDTO auditCiDto, PaginationInfo pageInfo) throws BizException;
	
	/**
	 * 根据就诊id对患者就诊账户进行冻结或解封
	 * @param bFlag 真：冻结  假：解封
	 * @param id_ent
	 * @author liwq
	 */
	public FBoolean doFreezeEnAccBoolean(String id_ent,String id_emp, FBoolean bFlag) throws BizException;
	
	/**
	 * 获取就诊审核状态
	 * */
	public FBoolean findAuditIpStatus(String id_ent) throws BizException;
	
	/**
	 * 根据结算获取账单表格中信息
	 * @param id_stip 结算id
	 * @return BlStIpInccaInfoDTO[] 账单信息
	 * */
	public BlStIpInccaInfoDTO[] findBLIncInfoByIdStIp(String id_stip) throws BizException;
	
	/**
	 * 获取门诊就诊列表
	 * */
	public BlOpFeeOutDTO[] findBlOepEntInfos(String sDate, String eDate, String id_pat) throws BizException;
	/**
	 * 获取最后一次导出时间
	 * @return
	 * @throws BizException
	 */
	public FDateTime getLastedOutDateTime() throws BizException;
	
	public FMap getEmpPhyDo(String strIdPsnDoc) throws BizException;
	
    /**
     * 获得门诊结算号（就诊领域使用）
     * @param strIdCg
     * @return
     * @throws BizException
     */
	public String getCodeSt(String strIdCg) throws BizException;
	
	/**
	 * 获取挂号就诊列表
	 * */
	public BlEntInfoDTO[] findBlEntInfoList(String dt_begin,String dt_end) throws BizException;
	
	/**
	 * 住院项目减免，根据id_stip 查询按账单分组明细
	 * @param map
	 * @return
	 * @throws BizException
	 * @author Liwq
	 */	
	public PagingRtnData<BlCgIpDO> findBlCgIpPageInfoData(FMap map,PaginationInfo pageInfo) throws BizException ;
	
	 /**
	  *  项目减免-分类服务项目合计
	  *  @author Liwq
	  */
	 public BlCgIpDO[] findBlCgIpDOsByIdStip(String id_stip) throws BizException;
	 
	 /**
	  * 查询得到医保特殊病患者的分页查询结果
	  * @param qryRootNodeDTO
	  * @param orderStr
	  * @param pg
	  * @return
	  * @throws BizException
	  */
	 public  abstract PagingRtnData<MiMcPatSpecDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg)throws BizException ;
	 
//	 public  abstract BlHpPatSpecDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO) throws BizException;
	 
	 /**
	  * 由一个患者的主键得到该患者的医保特殊病诊断
	  * @param blhpPatSpecDO
	  * @return
	  * @throws BizException
	  */
	 public  abstract MiMcPatSpecDiDO[] getBlHpPatSpecDiItmsByIdhppat(MiMcPatSpecDO blhpPatSpecDO) throws BizException;

	/**
	 * 获取计量单位列表 (方便第三方使用)
	 * 
	 * @throws BizException
	 * @author Liwq
	 * */
	public Map<String, MeasDocDO> setMeasDocDOMap() throws BizException;
	
	/**
	 * PrescriptionCostDto 转 BlOrderAppendBillParamDTO
	 * @param ciDto
	 * @return
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO convertDto(PrescriptionCostDto ciDto) throws BizException;
	/**
	 * 获得该患者的上次门诊结算的结算和发票信息
	 * @param id_pat
	 * @param operatorInfoDTO
	 * @param fg_reginc
	 * @param incno_old
	 * @return
	 * @throws BizException
	 */
	public RePrintInvoiceInfoDTO doQryLastStInfo(String id_pat, OperatorInfoDTO operatorInfoDTO,FBoolean fg_reginfo,String incno_old,FBoolean fg_hpCard)throws BizException;

	/**
	 * 查询历史结算信息
	 * @param stInfo
	 * @return
	 * @author liwenqiang
	 */
	public BlStBaseInfo[] findHistorySt(String entId) throws BizException;
	/**
	 * 根据结算Id查询结算明细
	 * @param id_stip
	 * @return
	 * @throws BizException
	 * @author liwenqiang
	 */
	public BlCgIpDTO[] findBlCgIpItemByIdStIpReform(String stipId) throws BizException;
	public MiMcPatSpecDO findCodeByNoHp(String NoHp) throws BizException ;
	
	/**
	 * 门诊重划重收调入
	 * @author : hanjq 2019年8月2日 上午10:23:53
	 * @param id_pat
	 * @param dt_b
	 * @param dt_e
	 * @return
	 * @throws BizException
	 */
	public BlStOepVsIncDTO[] doLoadInForRecharge(String id_pat, String dt_b, String dt_e) throws BizException;
	/**
	 * 获取住院患者本次住院的最大记账时间
	 * @return 如果空值 则返回 1900-01-01 00:00:00
	 * @throws BizException
	 * @author xuebei
	 * @time  2018-10-10
	 */
	public FDateTime getMaxBlcgipTimeUnSettled(String 	IdEnt, String fg_st) throws BizException;
	/**
	 * 住院医保、自费项目审核功能-待预审核患者信息查询
	 * @param pgInfo
	 * @param qryRoot
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BlIpAuditOutHospCheckDTO> getIpOutAuditPats(PaginationInfo pgInfo, String wherePart) throws BizException;

	
	/**
	 * 住院费用审核出院查询弹窗查询模板逻辑(通过条件查询获得所需的出院病人列表)
	 * @param pgInfo
	 * @param qryRoot
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BlIpAuditOutHospCheckDTO> getOutPatListByQry(PaginationInfo pgInfo, QryRootNodeDTO qryRoot) throws BizException;

	
	/**
	 * 
	 * @Description: 获取审核记录的日志     
	 * @author: xy.zhou     
	 * @throws
	 */
	public abstract BlAuditLogIpDTO [] getAuditLogIpDtos(String id_auditIp)throws BizException;

	
	/**
	 * 判断某次就诊是否有有效的医保审核
	 * @param id_ent
	 * @author xuebei
	 * @return FBoolean
	 */
	public abstract FBoolean HasETHpAudited(String id_ent) throws BizException;
	/**
	 * 急诊医保审核
	 * @param id_auditip
	 * @author xuebei
	 * @return FBoolean
	 */
	public abstract FBoolean SaveHpAuditET(BlAuditIp blAuditIp) throws BizException;

	/**
	 * 发送审核结果到护士站
	 * @param id_auditip
	 * @author xuebei
	 * @return FBoolean
	 */
	public abstract void SendAuditMsgToNurse(AuditResultDTO auditResultDTO) throws BizException;
	
	/**
	 * 获取结算账单信息_急诊
	 * @param id_stip 结算id
	 * @return BlStIpInccaInfoDTO[] 账单信息
	 * */
	public abstract BlStIpInccaInfoDTO[] findBdInccaInfoByIdStET(String id_stip) throws BizException;

	/**
	 * 查询急诊留观费用审核分类项目
	 */
	public abstract BlIpChargeAuditDTO[] findFeeStateByIdentET(String id_ent) throws BizException;

	/**
	 * 根据就诊id获取未结算账单信息
	 * 
	 * @param id_ent
	 *            就诊id
	 * @param fgSt
	 *            结算标志 Y-> 查询已结算 N->查询未结算 null->查询所有费用
	 * @return BlStIpInccaInfoDTO[] 账单信息
	 * @throws BizException
	 * @author liwq
	 */
	public BlStIpInccaInfoDTO[] getInccaInfoByIdEntET(String id_ent, String fgSt) throws BizException;

	/**
		 * 根据就诊id和id_srv fg_st 获取急诊留观费用明细
		 * BlIpAuditFeeDTO 费用信息模型
		 * @param id_ent 就诊id id_srv 服务id
		 * @param fg_st 是否结算 id_stip 结算id
		 * @param PaginationInfo 分页信息
		 * @return BlIpAuditFeeDTO[] 费用审核-费用信息
		 * @throws BizException
		 * @author xuebei
		 * @throws DAException
		 * */
	public BlIpAuditFeeDTO[] getBlETAuditFeeInfo(BlIpChargeAuditDTO treeAuditDTO) throws BizException;

	/**
	 * 根据结算id_st获取已结算急诊留观费用收付款信息
	 * 
	 * @param id_st
	 *            结算id
	 * @return BlIpAuditStPayInfoDTO[] 费用审核-已结算收款信息
	 * @throws BizException
	 * @author xuebei
	 * @throws DAException
	 */
	public BlIpAuditStPayInfoDTO[] getBlETAuditStPayInfo(String id_st) throws BizException;

	
	/**
	 * 急诊留观费用审核出院查询弹窗查询模板逻辑(通过条件查询获得所需的出院病人列表)
	 * @param pgInfo
	 * @param qryRoot
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BlIpAuditOutHospCheckDTO> getOutETListByQry(PaginationInfo pgInfo, QryRootNodeDTO qryRoot) throws BizException;

	/**
	 * 根据就诊id和id_srv fg_st 获取急诊留观费用明细
	 * BlIpAuditFeeDTO 费用信息模型
	 * @param id_ent 就诊id id_srv 服务id
	 * @param fg_st 是否结算 id_stip 结算id
	 * @param PaginationInfo 分页信息
	 * @return BlIpAuditFeeDTO[] 费用审核-费用信息
	 * @throws BizException
	 * @author xuebei
	 * @throws DAException
	 * */
	public PagingRtnData<BlIpAuditFeeDTO> getBlETAuditFeeItemInfo(BlIpAuditFeeDTO auditFeeDto, String fg_st, String id_stip, PaginationInfo pageInfo) throws BizException;

	/**
	 * (门诊费用综合查询)查询门诊发票信息
	 * @description:
	 * @author:hanjq  2020年7月4日
	 * @param id_stoep
	 * @return
	 * @throws DAException
	 */
	public BlAuditIncInfoDTO[] getBlCgOepInc(String id_stoep) throws DAException;
	
	/**
	 * (门诊费用综合查询) 查询收付款信息
	 * @description:
	 * @author:hanjq  2020年7月6日
	 * @param id_stoep
	 * @return
	 * @throws BizException
	 */
	public BlIpAuditStPayInfoDTO[] getBlOepStPayInfo(String id_stoep) throws BizException;
}
