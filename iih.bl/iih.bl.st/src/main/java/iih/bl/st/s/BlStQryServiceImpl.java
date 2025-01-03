package iih.bl.st.s;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.d.BlcgipRelief;
import iih.bl.hp.hptranactoep.d.HpTransactOepDO;
import iih.bl.hp.hptransactah.d.HpTransActAhDO;
import iih.bl.inc.blincquerydto.d.BlincQueryDTO;
import iih.bl.inc.blreinccgitmdto.d.BlReIncCgItmDTO;
import iih.bl.itf.dto.blthirdrefundreturndto.d.BlThirdRefundReturnDTO;
import iih.bl.pay.dto.d.BlBannerDTO;
import iih.bl.st.blauditip.bp.BlAuditIpBp;
import iih.bl.st.blauditip.bp.GetIpChargeAuditInfoBp;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blreinc.bp.GetReIncIpCgItmBeforePayBp;
import iih.bl.st.blreinc.bp.GetReIncIpCgItmByStBp;
import iih.bl.st.blreinc.bp.GetReIncOpCgItmByStBp;
import iih.bl.st.blstip.bp.BlStarIpBp;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.bp.GetUploadExtRePresBP;
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
import iih.bl.st.i.IBlStQryService;
import iih.bl.st.s.bp.FindDiDefInfoBP;
import iih.bl.st.s.bp.GetBlIpChargeChkFeeBP;
import iih.bl.st.s.bp.GetBlIpChargeChkOrdBP;
import iih.bl.st.s.bp.GetBlIpChargeChkPureFeeBP;
import iih.bl.st.s.bp.GetBlStOepVsIncBp;
import iih.bl.st.s.bp.GetBlStOepVsIncByCodeAndincnoBp;
import iih.bl.st.s.bp.GetBlStOepVsIncByIdStoepBp;
import iih.bl.st.s.bp.GetCgIpReliefInfoBP;
import iih.bl.st.s.bp.GetEtSettleInfoBP;
import iih.bl.st.s.bp.GetEtToIpBillItmBP;
import iih.bl.st.s.bp.GetFrozenAndAuditBP;
import iih.bl.st.s.bp.GetHpTransInfoBP;
import iih.bl.st.s.bp.GetHpTransOepInfoBP;
import iih.bl.st.s.bp.GetIpStVsIncMergeBP;
import iih.bl.st.s.bp.GetOepStVsIncMergeBP;
import iih.bl.st.s.bp.GetReconciliationDifferencerDataBP;
import iih.bl.st.s.bp.GetStOepDataBP;
import iih.bl.st.s.bp.GetStSheetInfoBP;
import iih.bl.st.s.bp.GetTransactionDataBP;
import iih.bl.st.s.bp.GetUrgeStPatisBP;
import iih.bl.st.s.bp.HasDebtUnSettledBP;
import iih.bl.st.s.bp.HasUnpaidDataBP;
import iih.bl.st.s.bp.ip.BlIpInfoQryByEntInfoBP;
import iih.bl.st.s.bp.ip.CheckFeeAllUploadBP;
import iih.bl.st.s.bp.oepcharge.GetCustPeChargeCodeBP;
import iih.bl.st.s.bp.oepcharge.GetCustPeChargeInputBP;
import iih.bl.st.s.bp.oepcharge.GetPeChargeInputBP;
import iih.bl.st.s.bp.oepcharge.GetThirdRefundInfoBP;
import iih.bl.st.s.bp.op.CheckBHpCgPatBP;
import iih.bl.st.s.bp.op.GetBlStByIdCgBP;
import iih.bl.st.stsheet.d.StSheetDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.service.constant.Binding;
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
@Service(serviceInterfaces={IBlStQryService.class}, binding=Binding.JSONRPC)
public class BlStQryServiceImpl  implements IBlStQryService{
	/**
	 * 住院结算-调入-（分页查询）
	 * 
	 * @param map
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
//	@Override
//	public PagingRtnData<BlCgIpDO> findCgIpDosPageInfo(FMap map, PaginationInfo pageInfo) throws BizException {
//		BlStarIpBp blStarIpBp = new BlStarIpBp();
//		return blStarIpBp.getBlCgIpPageDos(map, pageInfo);
//	}
	
	
	/**
	 * 根据就诊id获取患者就诊账户封账状态
	 * 
	 * @param id_ent
	 *            急诊id
	 * @return FBoolean
	 * @throws BizException
	 * @author liwq
	 * @throws DAException
	 * */
	public FArrayList2 isFrozenAndAudit(String id_ent) throws BizException {
		GetFrozenAndAuditBP bp = new GetFrozenAndAuditBP();
		return bp.exec(id_ent);
	}
	
	/**
	 * 查询患者是否存在未完成收付款的结算数据
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public FBoolean hasUnpaidData (String id_ent) throws BizException {
		HasUnpaidDataBP bp = new HasUnpaidDataBP();
		return bp.exec(id_ent);
	}
	
	/**
	 * 判断是否存在欠款未结清的结算数据
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public FBoolean HasDebtUnSettled(String id_ent) throws BizException {
		HasDebtUnSettledBP bp = new HasDebtUnSettledBP();
		return bp.exec(id_ent);
	}
	

	/**
	 * 医保退费时查询医保结算对应的交易信息
	 * @param id_stoep
	 * @return
	 * @author liwq
	 * @throws BizException
	 */
	public HpTransActAhDO getHpTransInfo(String id_stoep) throws BizException {
		GetHpTransInfoBP bp = new GetHpTransInfoBP();
		return bp.exec(id_stoep);
	}
	
	/**
	 * 医保退费时查询医保结算对应的交易信息 医保平台
	 * @param id_stoep
	 * @return
	 * @author liwq
	 * @throws BizException
	 */
	public HpTransactOepDO getHpTransOepInfo(String id_stoep) throws BizException {
		GetHpTransOepInfoBP bp = new GetHpTransOepInfoBP();
		return bp.exec(id_stoep);
	}
	
	/**
	 * 获取门诊结算信息和发票信息关系汇总
	 * @param id_pat
	 * @param dt_b
	 * @param dt_e
	 * @return
	 * @throws BizException
	 * @author liwq
	 */
	public BlStOepVsIncDTO[] getMergeSettledIncDTO (String id_pat, String dt_b, String dt_e) throws BizException {
		GetOepStVsIncMergeBP bp = new GetOepStVsIncMergeBP();
		return bp.exec(id_pat, dt_b, dt_e);
	}
	
	/**
	 * 获得患者指定时间段内的的结算与发票信息 （汇总）
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
	public BlStOepVsIncDTO[] getMergeStIncByDate(String id_pat, String dt_b, String dt_e) throws BizException {
		GetBlStOepVsIncBp bp = new GetBlStOepVsIncBp();
		return bp.exec(id_pat, dt_b, dt_e);
	}
	
	/**
	 * 获得患者指定流水号与发票号的结算与发票信息 （汇总）
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
	public BlStOepVsIncDTO[] getMergeStIncByCodeIncno(String id_pat, String codest, String incno) throws BizException {
		GetBlStOepVsIncByCodeAndincnoBp bp = new GetBlStOepVsIncByCodeAndincnoBp();
		return bp.exec(id_pat, codest, incno);
	}

	/**
	 * 根据结算编号 获取 结算与发票信息（明细）
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
	
	//===住院费用审核Begin===//
	
	/**
     * 根据Banner输入值查找对应就诊信息（住院费用审核只检索未结算患者）
     * liwq
     * */
	public BlBannerDTO[] findStIpBannerEntInfo(String inputValue, String[] selectCondition) throws BizException {
		BlStarIpBp blStarIpBp = new BlStarIpBp();
		return blStarIpBp.getStIpBannerEntInfo(inputValue, selectCondition);
	}
	 /**
     * 根据id_ent 查询 已结算费用的状态、是否付款 及结算日期
     * @author liwq
     * @param id_ent
     */
	public BlIpChargeAuditDTO[] findFeeStateByIdent(String id_ent) throws BizException {
		GetIpChargeAuditInfoBp getIpChargeAuditInfo = new GetIpChargeAuditInfoBp();
		return getIpChargeAuditInfo.findFeeStateByIdent(id_ent);
	}

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
	 * */
	public BlStIpInccaInfoDTO[] getInccaInfoByIdEnt(String id_ent, String fgSt) throws BizException {
		BlStarIpBp blStarIpBp = new BlStarIpBp();
		return blStarIpBp.getInccaInfoByIdEnt(id_ent, fgSt);
	}
	
	/**
	 * 根据就诊id获取已结算发票信息
	 * 
	 * @param id_ent
	 *            就诊id
	 * @param id_stip
	 *            结算id
	 * @return BlAuditIncInfoDTO[] 费用审核-发票信息
	 * @throws BizException
	 * @author liwq
	 * */
	public BlAuditIncInfoDTO[] getBlAuditIncInfoByIdEnt(String id_ent, String id_stip) throws BizException {
		GetIpChargeAuditInfoBp getIpChargeAuditInfo = new GetIpChargeAuditInfoBp();
		return getIpChargeAuditInfo.getBlAuditIncInfoByIdEnt(id_ent, id_stip);
	}

	/**
	 * 根据就诊id_ent id_stip fg_st获取费用信息
	 * 
	 * @param BlIpChargeAuditDTO
	 *            树形节点模型
	 * @param id_ent
	 *            就诊id
	 * @return BlIpAuditFeeDTO[] 费用审核-费用信息
	 * @throws BizException
	 * @author liwq
	 * @throws DAException
	 * */
	public BlIpAuditFeeDTO[] getBlIpAuditFeeInfo(BlIpChargeAuditDTO treeAuditDTO) throws BizException {
		GetIpChargeAuditInfoBp getIpChargeAuditInfo = new GetIpChargeAuditInfoBp();
		return getIpChargeAuditInfo.getBlIpAuditFeeInfo(treeAuditDTO);
	}
	/**
	 * 根据就诊id和id_srv fg_st 获取费用明细 BlIpAuditFeeDTO 费用信息模型
	 * 
	 * @param id_ent
	 *            就诊id id_srv 服务id
	 * @param fg_st
	 *            是否结算 id_stip 结算id
	 * @param PaginationInfo
	 *            分页信息
	 * @return BlIpAuditFeeDTO[] 费用审核-费用信息
	 * @throws BizException
	 * @author liwq
	 * @throws DAException
	 * */
	public PagingRtnData<BlIpAuditFeeDTO> getBlIpAuditFeeItemInfo(BlIpAuditFeeDTO auditFeeDto, String fg_st, String id_stip, PaginationInfo pageInfo) throws BizException {
		GetIpChargeAuditInfoBp getIpChargeAuditInfo = new GetIpChargeAuditInfoBp();
		return getIpChargeAuditInfo.getBlIpAuditFeeItemInfo(auditFeeDto, fg_st, id_stip, pageInfo);
	}

	/**
	 * 根据结算id_stip获取已结算费用收付款信息
	 * 
	 * @param id_stip
	 *            结算id
	 * @return BlIpAuditStPayInfoDTO[] 费用审核-已结算收款信息
	 * @throws BizException
	 * @author liwq
	 * @throws DAException
	 * */
	public BlIpAuditStPayInfoDTO[] getBlIpAuditStPayInfo(String id_stip) throws BizException {
		GetIpChargeAuditInfoBp getIpChargeAuditInfo = new GetIpChargeAuditInfoBp();
		return getIpChargeAuditInfo.getBlIpAuditStPayInfo(id_stip);
	}
	
	/**
	 * 根据就诊id获取患者就诊账户封账状态
	 * 
	 * @param id_ent
	 *            急诊id
	 * @return FBoolean
	 * @throws BizException
	 * @author liwq
	 * @throws DAException
	 * */
	public FBoolean getPatiEntAccStatusInfo(String id_ent) throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.getPatiEntAccStatusInfo(id_ent);
	}
	
	/**
	 * 根据就诊id获取住院费用审核是否有启用审核记录
	 * 
	 * @param id_ent
	 *            就诊id
	 * @return BlAuditIp[]
	 * @throws BizException
	 * @author liwq
	 * @throws DAException
	 * */
	public BlAuditIp[] getPatiIpAuditInfo(String id_ent) throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.getPatiIpAuditInfo(id_ent);
	}
	
	/**
	 * 根据就诊id 获取医嘱内容
	 * 
	 * @param id_ent
	 * @return BlIpAuditCiDTO[]
	 * @author liwq
	 */
	public BlIpAuditCiDTO[] getBlIpAuditCiInfo(BlIpAuditCiDTO auditCiDto) throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.getBlIpAuditCiInfo(auditCiDto);
	}
	
	/**
	 * 获取医嘱内容对应的记账明细(分页)
	 * 
	 * @param BlIpAuditCiDTO
	 *            合计项dto
	 * @param PaginationInfo
	 * @author liwq
	 * @throws DAException
	 */
	public PagingRtnData<BlIpAuditCiDTO> getIpCiCgFeePageInfo(BlIpAuditCiDTO auditCiDto, PaginationInfo pageInfo) throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.getIpCiCgFeePageInfo(auditCiDto, pageInfo);
	}
	
	/**
	 * 获取就诊审核状态
	 * */
	public FBoolean findAuditIpStatus(String id_ent) throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.getAuditIpStatus(id_ent);
	}
	//===住院费用审核End===//
	
	//****** ly 2017/10/10 住院费用核对相关查询  ******//
	
	/**
	 * 住院费用核对查询医嘱信息
	 * @param qryRootNodeDTO 查询方案
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlIpChargeChkOrdDTO[] getIpChargeChkOrdInfo(QryRootNodeDTO qryRootNodeDTO, String entId) throws BizException{
		GetBlIpChargeChkOrdBP bp = new GetBlIpChargeChkOrdBP();
		return bp.exec(qryRootNodeDTO, entId);
	}
	
	/**
	 * 住院费用核对查询费用信息
	 * @param ordId 医嘱id
	 * @return 费用信息
	 * @throws BizException
	 */
	@Override
	public BlIpChargeChkFeeDTO[] getIpChargeChkFeeInfo(String ordId) throws BizException{
		GetBlIpChargeChkFeeBP bp = new GetBlIpChargeChkFeeBP();
		return bp.exec(ordId);
	}
	
	/**
	 * 住院费用核对查询纯费用信息
	 * @param entId 就诊id
	 * @return 费用信息
	 * @throws BizException
	 */
	@Override
	public BlIpChargeChkFeeDTO[] getIpChargeChkPureFeeInfo(String entId) throws BizException{
		GetBlIpChargeChkPureFeeBP bp = new GetBlIpChargeChkPureFeeBP();
		return bp.exec(entId);
	}
	
	//****** 住院费用核对相关查询  end ******//
	/**
	 * 获取外配处方信息
	 * @param patId 患者ID
	 * @param entpCode 就诊类型
	 * @param beginSignTime 签署开始时间
	 * @param endSignTime 签署结束时间	 
	 * @return 外配处方信息
	 * @throws BizException
	 * @author yankan
	 * @author liwenqiang
	 */
	@Override
	public BlOrderAppendBillParamDTO[] getUploadExtRePres(String patId,String entpCode,FDateTime beginSignTime,FDateTime endSignTime) throws BizException{
		GetUploadExtRePresBP getExtPresBP = new GetUploadExtRePresBP();
		return getExtPresBP.exec(patId, entpCode,beginSignTime, endSignTime);
	}
	
	/***
	 * 查询患者的结算单信息
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public StSheetDTO[] getStSheetInfo(String patId) throws BizException{
		GetStSheetInfoBP bp=new GetStSheetInfoBP();
		return bp.exec(patId);
	}
	
	/**
	 * 查询患者医保诊断信息
	 * @param entId
	 * @return
	 * @throws BizException
	 * @author liwenqiang
	 */
	@Override
	public BlDiDefInfoDTO[] findDiDefInfo(String entId) throws BizException {
		FindDiDefInfoBP bp=new FindDiDefInfoBP();
		return bp.exec(entId);
	}
	//*****************体检收费开始************//
	/**
	 * 根据团检结算流水号获取体检收费信息
	 * 
	 * @param cust_pecode
	 * @return BlOepChargeInputDTO
	 * @throws BizException
	 */
	@Override
	public BlOepChargeInputDTO[] findPeCustSrvInfo(BlOepPeCustInputDTO[] blOepPeCustInputDTOs) throws BizException {
		GetCustPeChargeInputBP bp = new GetCustPeChargeInputBP();
		return bp.exec(blOepPeCustInputDTOs);
	}
	/**
	 * 根据客户编码获取团检结算流水号
	 * 
	 * @param cust_code
	 * @return BlOepPeCustInputDTO
	 * @throws BizException
	 */
	@Override
	public BlOepPeCustInputDTO[] fingPeCustCodeInfoByCust(String id_cust) throws BizException {
		GetCustPeChargeCodeBP bp = new GetCustPeChargeCodeBP();
		return bp.exec(id_cust);
	}
	/**
	 * 根据患者id 体检流水号 获取体检费用信息
	 * @param id_pat
	 * @param pe_code
	 * @return BlOepChargeInputDTO
	 * @throws BizException 
	 */
	public BlOepChargeInputDTO[] findPeSrvInfoByIdPatAndPecode(String id_pat,String pe_code) throws BizException {
		GetPeChargeInputBP bp = new GetPeChargeInputBP();
		return bp.exec(id_pat,pe_code);
	}
	//*****************体检收费结束************//
	
	/**
	 * 查询本次结算分费用是否全部上传
	 * @param id_stip
	 * @return
	 * @throws BizException
	 */
	public FBoolean checkFeeAllUpload(String stId,String hpId) throws BizException{
		CheckFeeAllUploadBP bp=new CheckFeeAllUploadBP();
		return bp.exec(stId,hpId);
	}
	
	/**
	 * 根据患者分类查询是否为高端商保患者
	 * @param id_patca  患者分类id
	 * @return
	 * @throws BizException
	 */
	public FBoolean checkBHpCgPat(String id_patca) throws BizException{
		CheckBHpCgPatBP bp=new CheckBHpCgPatBP();
		return bp.exec(id_patca);
	}

	/**
	 * 获取交易数据
	 */
	@Override
	public BlReconciliationShowDataDTO[] getTransactionDatas(BlReconciliationQryCondDTO blCondDTO) throws BizException {
		GetTransactionDataBP bp=new GetTransactionDataBP();
		return bp.exec(blCondDTO);
	}
	
	/**
	 * 获取交易汇总数据
	 */
	@Override
	public BlReconciliationDifferencerDTO[] getReconciliationDifferencerData(BlReconciliationQryCondDTO blCondDTO)
			throws BizException {
		GetReconciliationDifferencerDataBP bp=new GetReconciliationDifferencerDataBP();
		return bp.exec(blCondDTO);
	}
	
	/**
	 * 获取记账数据（住院收费项目减免使用）
	 * @author zhang.hw
	 * @date 2019年5月14日
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlcgipRelief[] getCgIpReliefInfo(String stId) throws BizException {
		GetCgIpReliefInfoBP bp =new GetCgIpReliefInfoBP();
		return bp.exec(stId);
	}
	
	/**
	 * 查询急诊转住院费用
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	public EtToIpBillDTO[] getEtToIpBillItm(String[] stIdArr) throws BizException
	{
		GetEtToIpBillItmBP bp=new GetEtToIpBillItmBP();
		return bp.exec(stIdArr);
	}
	
	/**
	 * 查询患者急诊转住院结算信息
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EtToIpLoadInDTO[] getEtSettleInfo(String entId) throws BizException
	{
		GetEtSettleInfoBP bp=new GetEtSettleInfoBP();
		return bp.exec(entId);
	}

	/**
	 * 根据记账id查询结算数据
	 * @param cgId 记账id
	 * @return
	 * @throws BizException
	 * @author ly 2019/07/17
	 */
	@Override
	public BlStOepDO getBlOepStByIdCg(String cgId) throws BizException{
		GetBlStByIdCgBP bp = new GetBlStByIdCgBP();
		return bp.exec(cgId);
	}
    /**
     * 查询第三方退费信息 id_st id_pay
     */
	@Override
	public BlThirdRefundReturnDTO GetThirdRefundInfo(String id_st, String id_pm,String id_pay) throws BizException {
		GetThirdRefundInfoBP bp =new GetThirdRefundInfoBP();
		return bp.exec(id_st, id_pm,id_pay);
	}

	/**
	 * 根据查询方案获取出院未结算患者信息
	 * @param qryNode
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlUrgeStPatEntDTO[] getUrgeStPatis(QryRootNodeDTO qryNode) throws BizException {
		GetUrgeStPatisBP bp=new GetUrgeStPatisBP();
		return bp.exec(qryNode);
	}
	/**
	 * 
     * 根据Banner输入值查找对应就诊信息（住院費用查詢）
     * zhangxin
     * 
	 */
	@Override
	public BlBannerDTO[] findIpInfoBannerEntInfo(String inputValue, String[] selectCondition) throws BizException {
		BlIpInfoQryByEntInfoBP bp = new BlIpInfoQryByEntInfoBP();
		return bp.exec(inputValue, selectCondition);
	}
	
	// -- 拆票所用-begin
	/**
	 * 获取门诊结算信息和发票信息关系汇总
	 * 
	 * @param id_pat
	 * @param id_ent
	 * @param code_entp
	 * @param dt_b
	 * @param dt_e
	 * @return
	 * @throws BizException
	 * @author xuebei
	 */
	@Override
	public BlStOepVsIncDTO[] getMergeSettledInc(String id_pat, String id_ent, String code_entp, String dt_b,
			String dt_e) throws BizException {
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {
			if (id_pat.isEmpty()) {
				throw new BizException("患者ID或不能为空！");
			}
			GetOepStVsIncMergeBP bp = new GetOepStVsIncMergeBP();
			return bp.findByUnCC(id_pat, dt_b, dt_e);
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {
			if (id_pat.isEmpty() || id_ent.isEmpty()) {
				throw new BizException("患者ID或就诊ID不能为空！");
			}
			GetIpStVsIncMergeBP bp = new GetIpStVsIncMergeBP();
			return bp.exec(id_pat, id_ent, dt_b, dt_e);
		}
		BlStOepVsIncDTO[] result = new BlStOepVsIncDTO[0];
		return result;
	}

	/**
 	 * 获取门诊和住院重拆票明细
	 * 
	 * @param strIdSt
	 * @param code_entp
	 * @return
	 * @throws BizException
	 * @author xuebei
	 */
	@Override
	public BlReIncCgItmDTO[] getReIncCgItmsByIdSt(String strIdSt, String code_entp) throws BizException {
		if (strIdSt.isEmpty() || code_entp.isEmpty()) {
			throw new BizException("结算ID或就诊分类不能为空！");
		}

		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {
			GetReIncOpCgItmByStBp bp = new GetReIncOpCgItmByStBp();
			return bp.exec(strIdSt);
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {
			GetReIncIpCgItmByStBp bp = new GetReIncIpCgItmByStBp();
			return bp.exec(strIdSt);
		}
		
		BlReIncCgItmDTO[] result = new BlReIncCgItmDTO[0];
		return result;
	}
	
	/**
 	 * 获取门诊和住院付款前拆票明细
 	 * @param strIdSt
 	 * @param code_entp
 	 * @return
 	 * @throws BizException
 	 * @author xuebei
 	 */
	@Override
	public BlReIncCgItmDTO[] getReIncCgItmsBeforePay(String strIdSt, String code_entp) throws BizException {
		if (strIdSt.isEmpty() || code_entp.isEmpty()) {
			throw new BizException("结算ID或就诊分类不能为空！");
		}

		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {
			return new BlReIncCgItmDTO[0];
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {
			GetReIncIpCgItmBeforePayBp bp = new GetReIncIpCgItmBeforePayBp();
			return bp.exec(strIdSt);
		}
		
		BlReIncCgItmDTO[] result = new BlReIncCgItmDTO[0];
		return result;
	}
	
	/**
 	 * 获取门诊收费信息【打印诊间结算付款凭证用】
 	 * @param pageInfo
 	 * @param QryDto
 	 * @return
 	 * @throws BizException
 	 */
	@Override
	public PagingRtnData<IncDataInfoOepDTO> getStOepData(PaginationInfo pageInfo, BlincQueryDTO QryDto)
			throws BizException {
		GetStOepDataBP bp = new GetStOepDataBP();
		return bp.exec(pageInfo,QryDto);
	}
	
	// -- 拆票所用-end
}
