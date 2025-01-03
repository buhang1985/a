package iih.bl.st.i;

import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.d.BlcgipRelief;
import iih.bl.hp.hptranactoep.d.HpTransactOepDO;
import iih.bl.hp.hptransactah.d.HpTransActAhDO;
import iih.bl.inc.blincquerydto.d.BlincQueryDTO;
import iih.bl.inc.blreinccgitmdto.d.BlReIncCgItmDTO;
import iih.bl.itf.dto.blthirdrefundreturndto.d.BlThirdRefundReturnDTO;
import iih.bl.pay.dto.d.BlBannerDTO;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.dto.blipchargechk.d.BlIpChargeChkFeeDTO;
import iih.bl.st.dto.blipchargechk.d.BlIpChargeChkOrdDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;
import iih.bl.st.dto.bloeppecustcharge.d.BlOepPeCustInputDTO;
import iih.bl.st.dto.d.BlAuditIncInfoDTO;
import iih.bl.st.dto.d.BlDiDefInfoDTO;
import iih.bl.st.dto.d.BlIpAuditCiDTO;
import iih.bl.st.dto.d.BlIpAuditFeeDTO;
import iih.bl.st.dto.d.BlIpAuditStPayInfoDTO;
import iih.bl.st.dto.d.BlIpChargeAuditDTO;
import iih.bl.st.dto.d.BlReconciliationDifferencerDTO;
import iih.bl.st.dto.d.BlReconciliationQryCondDTO;
import iih.bl.st.dto.d.BlReconciliationShowDataDTO;
import iih.bl.st.dto.d.BlStIpInccaInfoDTO;
import iih.bl.st.dto.d.BlStOepVsIncDTO;
import iih.bl.st.dto.d.BlUrgeStPatEntDTO;
import iih.bl.st.dto.d.IncDataInfoOepDTO;
import iih.bl.st.dto.ettoipsettlecancel.d.EtToIpLoadInDTO;
import iih.bl.st.ettoipbill.d.EtToIpBillDTO;
import iih.bl.st.stsheet.d.StSheetDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;

/**
 * 结算查询服务
 * @author yankan
 * @since 2017-06-15
 *
 */
public interface IBlStQryService {

	/**
	 * 医保退费时查询医保结算对应交易信息
	 * @param id_stoep
	 * @return
	 * @author liwq
	 * @throws BizException
	 */
	public HpTransActAhDO getHpTransInfo (String id_stoep) throws BizException;
	
	
	/**
	 * 医保退费时查询医保结算对应交易信息 医保平台
	 * @param id_stoep
	 * @return
	 * @author liwq
	 * @throws BizException
	 */
	public HpTransactOepDO getHpTransOepInfo (String id_stoep) throws BizException;

	/**
	/**
	 * 获取门诊结算信息和发票信息关系汇总
	 * @param id_pat
	 * @param dt_b
	 * @param dt_e
	 * @return
	 * @throws BizException
	 * @author liwq
	 */
	public BlStOepVsIncDTO[] getMergeSettledIncDTO (String id_pat, String dt_b, String dt_e) throws BizException;
	
	///=====================================
	/**
	 * 获得患者指定时间段内的的结算与发票信息（汇总）
	 * 
	 * @param id_pat
	 * @param dt_b
	 *            开始时间
	 * @param dt_e
	 *            结算时间
	 * @return
	 * @throws BizException
	 */
	public BlStOepVsIncDTO[] getMergeStIncByDate(String id_pat, String dt_b, String dt_e) throws BizException;

	/**
	 * 获得患者指定流水号与发票号的结算与发票信息(汇总)
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
	public BlStOepVsIncDTO[] getMergeStIncByCodeIncno(String id_pat, String codest, String incno) throws BizException;
	
	/**
	 * 根据结算编号 获取 结算与发票明细信息（明细）
	 * 
	 * @param idstoep
	 *            结算编号
	 * @return
	 * @throws BizException
	 */
	public abstract BlStOepVsIncDTO[] getBlStOepVsIncByIdStoep(String idstoep) throws BizException;
	
	//===住院费用审核Begin===//
	 /**
     * 根据Banner输入值查找对应就诊信息（住院费用审核只检索未结算患者）
     * liwq
     * */
    public abstract BlBannerDTO[] findStIpBannerEntInfo(String inputValue,String[] selectCondition) throws BizException;
	

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
	 * 获取就诊审核状态
	 * */
	public FBoolean findAuditIpStatus(String id_ent) throws BizException;
	
	
    //===住院费用审核End===//
	
	//****** ly 2017/10/10 住院费用核对相关查询  ******//
	
	/**
	 * 住院费用核对查询医嘱信息
	 * @param qryRootNodeDTO 查询方案
	 * @param entId 就诊id
	 * @return 医嘱信息
	 * @throws BizException
	 */
	public BlIpChargeChkOrdDTO[] getIpChargeChkOrdInfo(QryRootNodeDTO qryRootNodeDTO, String entId) throws BizException;
	
	/**
	 * 住院费用核对查询费用信息
	 * @param ordId 医嘱id
	 * @return 费用信息
	 * @throws BizException
	 */
	public BlIpChargeChkFeeDTO[] getIpChargeChkFeeInfo(String ordId) throws BizException;
	
	/**
	 * 住院费用核对查询纯费用信息
	 * @param entId 就诊id
	 * @return 费用信息
	 * @throws BizException
	 */
	public BlIpChargeChkFeeDTO[] getIpChargeChkPureFeeInfo(String entId) throws BizException;
	
	//****** 住院费用核对相关查询  end ******//
	
	/**
	 * 获取需上传的外配处方信息
	 * @param patId 患者ID
	 * @param entpCode 就诊类型
	 * @param beginSignTime 签署开始时间
	 * @param endSignTime 签署结束时间
	 * @return 外配处方信息集合
	 * @throws BizException
	 * @author yankan
	 * @author liwenqiang
	 */
	public abstract BlOrderAppendBillParamDTO[] getUploadExtRePres(String patId,String entpCode,FDateTime beginSignTime,FDateTime endSignTime) throws BizException;

	/***
	 * 查询患者的结算单信息
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public abstract StSheetDTO[] getStSheetInfo(String patId) throws BizException;

	/**
	 * 查询患者医保诊断信息
	 * @param entId
	 * @return
	 * @throws BizException
	 * @author liwenqiang
	 */
	public BlDiDefInfoDTO[] findDiDefInfo(String entId) throws BizException;
	//*****************体检收费开始************//
	/**
	 * 根据患者id 获取体检费用信息
	 * 
	 * @param id_pat
	 * @return BlOepChargeInputDTO
	 * @throws BizException
	 */
	public BlOepChargeInputDTO[] findPeSrvInfoByIdPatAndPecode(String id_pat,String pe_code) throws BizException;
	/**
	 * 根据客户编码获取团检结算流水号
	 * 
	 * @param cust_code
	 * @return BlOepPeCustInputDTO
	 * @throws BizException
	 */
	public BlOepPeCustInputDTO[] fingPeCustCodeInfoByCust(String id_cust) throws BizException;

	/**
	 * 根据团检结算流水号获取体检收费信息
	 * 
	 * @param cust_pecode
	 * @return BlOepChargeInputDTO
	 * @throws BizException
	 */
	public BlOepChargeInputDTO[] findPeCustSrvInfo(BlOepPeCustInputDTO[] blOepPeCustInputDTOs) throws BizException;
	//*****************体检收费结束************//

	/**
	 * 查询本次结算分费用是否全部上传
	 * @param id_stip
	 * @return
	 * @throws BizException
	 */
	public FBoolean checkFeeAllUpload(String stId,String hpId) throws BizException;
	
	/**
	 * 根据患者分类查询是否为高端商保患者
	 * @param id_patca  患者分类id
	 * @return
	 * @throws BizException
	 */
	public FBoolean checkBHpCgPat(String id_patca) throws BizException;
	
	/**
	 * 
	* @Title: getTransactionData  
	* @Description: 获取对账用交易数据
	* @param blCondDTO
	* @throws BizException  
	* @return BlReconciliationShowDataDTO[] 
	* @author xy.zhou
	 */
	public abstract BlReconciliationShowDataDTO[] getTransactionDatas(BlReconciliationQryCondDTO blCondDTO) throws BizException;
	
	/**
	 * 
	* @Title: getReconciliationDifferencerData  
	* @Description: 获取对账汇总数据
	* @param blCondDTO
	* @throws BizException  
	* @return BlReconciliationDifferencerDTO[] 
	* @author xy.zhou
	 */
	public abstract BlReconciliationDifferencerDTO [] getReconciliationDifferencerData(BlReconciliationQryCondDTO blCondDTO)throws BizException;

	/**
	 * 获取记账数据（住院收费项目减免使用）
	 * @author zhang.hw
	 * @date 2019年5月14日
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	public abstract BlcgipRelief[] getCgIpReliefInfo(String stId) throws BizException;
	
	/**
	 * 查询急诊转住院费用
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	public abstract EtToIpBillDTO[] getEtToIpBillItm(String[] stIdArr) throws BizException;

	/**
	 * 查询患者急诊转住院结算信息
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public abstract EtToIpLoadInDTO[] getEtSettleInfo(String entId) throws BizException;
	
	/**
	 * 根据记账id查询结算数据
	 * @param cgId 记账id
	 * @return
	 * @throws BizException
	 * @author ly 2019/07/17
	 */
	public abstract BlStOepDO getBlOepStByIdCg(String cgId) throws BizException;
	/**
	 * 查询第三方退费信息 id_st id_pay
	 * @param id_st
	 * @param id_pm
	 * @return
	 * @throws BizException
	 */
	public abstract BlThirdRefundReturnDTO GetThirdRefundInfo(String id_st,String id_pm,String id_pay) throws BizException;
	
	/**
	 * 根据查询方案获取出院未结算患者信息
	 * @param qryNode
	 * @return
	 * @throws BizException
	 */
	public abstract BlUrgeStPatEntDTO [] getUrgeStPatis(QryRootNodeDTO qryNode)throws BizException;
	/**
	 * 
     * 根据Banner输入值查找对应就诊信息（住院費用查詢）
     * zhangxin
     * 
	 */
	public abstract BlBannerDTO[] findIpInfoBannerEntInfo(String inputValue, String[] selectCondition) throws BizException;

    // -- 拆票所用 - begin
 	/**
 	 * 获取门诊结算信息和发票信息关系汇总
 	 * @param id_pat
 	 * @param id_ent
 	 * @param code_entp
 	 * @param dt_b
 	 * @param dt_e
 	 * @return
 	 * @throws BizException
 	 * @author xuebei
 	 */
 	public abstract BlStOepVsIncDTO[] getMergeSettledInc (String id_pat, String id_ent, String code_entp, String dt_b, String dt_e) throws BizException;
 	
 	/**
 	 * 获取门诊和住院重拆票明细
 	 * @param strIdSt
 	 * @param code_entp
 	 * @return
 	 * @throws BizException
 	 * @author xuebei
 	 */
 	public abstract BlReIncCgItmDTO[] getReIncCgItmsByIdSt (String strIdSt, String code_entp) throws BizException;
 	
 	/**
 	 * 获取门诊和住院付款前拆票明细
 	 * @param strIdSt
 	 * @param code_entp
 	 * @return
 	 * @throws BizException
 	 * @author xuebei
 	 */
 	public abstract BlReIncCgItmDTO[] getReIncCgItmsBeforePay (String strIdSt, String code_entp) throws BizException;
 	
 	/**
 	 * 获取门诊收费信息【打印诊间结算付款凭证用】
 	 * @param pageInfo
 	 * @param QryDto
 	 * @return
 	 * @throws BizException
 	 */
	public PagingRtnData<IncDataInfoOepDTO> getStOepData(PaginationInfo pageInfo,BlincQueryDTO QryDto) throws BizException;
	
 	// -- 拆票所用 - end
} 
