package iih.bl.st.service.s;

import java.util.List;
import java.util.Map;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.et.auditresultdto.d.AuditResultDTO;
import iih.bl.inc.dto.d.RePrintInvoiceInfoDTO;
import iih.bl.pay.dto.d.BlBannerDTO;
import iih.bl.st.blauditip.bp.BlAuditAndStLogicETBP;
import iih.bl.st.blauditip.bp.BlAuditIpBp;
import iih.bl.st.blauditip.bp.GetIpChargeAuditInfoBp;
import iih.bl.st.blauditip.bp.GetIpOutAuditPatsBP;
import iih.bl.st.blauditip.bp.GetOutPatListByQryBP;import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blcgipdto.d.BlCgIpDTO;
import iih.bl.st.blcgipdto.d.BlStBaseInfo;
import iih.bl.st.blhpspecillpi.bp.BlHpSpecificIllPiBp;
import iih.bl.st.blipauditouthospcheck.d.BlIpAuditOutHospCheckDTO;
import iih.bl.st.blpaypatip.bp.BlPayPatIpBp;
import iih.bl.st.blstaroep.bp.BlStarOepBp;
import iih.bl.st.blstip.bp.BlStarIpBp;
import iih.bl.st.blstip.bp.BlStarIpReFormBp;
import iih.bl.st.blstip.bp.GetBlCgIpInfoBp;
import iih.bl.st.blstip.bp.GetBlCgIpItemByIdStBp;
import iih.bl.st.blstip.bp.OepChargeQryBP;
import iih.bl.st.blstip.bp.GetHistoryStBp;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.bl.st.blstiparrears.bp.BlStIpArrearsBp;
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
import iih.bl.st.ep.IpStEP;
import iih.bl.st.hppireginfoimport.bp.BlEntInfoBp;
import iih.bl.st.ipbaddebt.bp.BlStIpBadPayBp;
import iih.bl.st.opfeeout.bp.BlOpFeeOutBp;
import iih.bl.st.opfeeout.bp.qry.QryLastedFeeOutDate;
import iih.bl.st.s.bp.GetChargingItemsBp;
import iih.bl.st.s.bp.QryLastStInfoBp;
import iih.bl.st.s.bp.op.LoadInForRechargeBp;
import iih.bl.st.service.i.IBLStQueService;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDO;
import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDiDO;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IAccountMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.xbd.measdoc.d.MeasDocDO;

@Service(serviceInterfaces = { IBLStQueService.class }, binding = Binding.JSONRPC)
public class IBLStQueServiceImpl implements IBLStQueService {

	/**
	 * 检查是否有门诊、住院的欠费记录，若有，则给予提示
	 * 
	 * @param id_pat
	 *            患者ID
	 * @return 若有欠费，则返回提示信息，否则返回“”
	 * @throws BizException
	 */
	public String doValidateArrearage(String id_pat) throws BizException {
		String tip = "";
		// 1.查看预交金是否欠费
		IAccountMDORService iAccountMDORService = ServiceFinder.find(IAccountMDORService.class);
		PiPatAccDO[] piPatAccDO = iAccountMDORService.find(" id_pat='" + id_pat + "'", "", FBoolean.FALSE);
		if (piPatAccDO != null && piPatAccDO[0].getAcc_lock().compareTo(piPatAccDO[0].getPrepay()) > 0) {
			tip = "当前患者门诊预交金有欠费，欠费金额：" + piPatAccDO[0].getAcc_lock().sub(piPatAccDO[0].getPrepay());
		}

		// 2.查看是否有住院的欠费记录
		IBlstipRService iBlstipRService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO[] blStIpDOs = iBlstipRService.find(" id_pat='" + id_pat + "' and fg_arclear='N'", "", FBoolean.FALSE);
		if (blStIpDOs != null && blStIpDOs.length > 0) {
			tip = tip + "\r\n当前患者有住院的欠费记录！";
		}
		return tip;
	}

	/**
	 * 根据患者id获取医嘱费用信息,按id_pres排序
	 * 
	 * @param id_pat
	 *            患者id
	 * @param defaultDaysLoadOep
	 *            默认调入医嘱天数
	 * */
	@Override
	public BlOrderAppendBillParamDTO[] getOrderSrvPrinceInfoByIdpres_load(String id_pat, int defaultDaysLoadOep) throws BizException {
		GetChargingItemsBp handlerBp = new GetChargingItemsBp();
		return handlerBp.exec(id_pat, defaultDaysLoadOep, true);
	}

	/**
	 * 按就诊id，医嘱费用状态， 离今天几个自然日,提取对应状态的已签署医嘱和未结算的商保记账信息
	 * 
	 * @param id_ent
	 *            就诊id
	 * @param sd_su_bl
	 *            医嘱费用状态。0：未记账；1：已记账；2：已退费；
	 * @param id_pat
	 *            患者ID
	 * @param days
	 *            离今天几个自然日
	 * @return 对应状态的已签署医嘱和未结算的商保记账信息
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] getNoSettlementSrvPriceInfoByIdent(String id_ent, String[] sd_su_bl, String id_pat, int days) throws BizException {
		BlStarOepBp blStarOepBp = new BlStarOepBp();
		List<BlOrderAppendBillParamDTO> orgSrvList = blStarOepBp.getNoSettlementSrvPriceInfoByIdent(id_ent, sd_su_bl, id_pat, days);
		if (orgSrvList == null) {
			return null;
		}
		return orgSrvList.toArray(new BlOrderAppendBillParamDTO[0]);
	}

	/**
	 * 按就诊id和医嘱费用状态，提取对应状态的已签署医嘱
	 * 
	 * @param id_ent
	 *            就诊id
	 * @param sd_su_bl
	 *            医嘱费用状态。0：未记账；1：已记账；2：已退费；
	 * @return
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] getOrderSrvPrinceInfoByIdent(String id_ent, String[] sd_su_bl) throws BizException {
		BlStarOepBp blStarOepBp = new BlStarOepBp();
		List<BlOrderAppendBillParamDTO> orgSrvList = blStarOepBp.getOrderSrvPrinceInfoByIdent(id_ent, sd_su_bl);
		if (orgSrvList == null) {
			return null;
		}
		return orgSrvList.toArray(new BlOrderAppendBillParamDTO[0]);
	}

	/**
	 * 根据患者id获取医嘱费用信息,按id_pres排序
	 * 
	 * @param id_pat
	 *            患者id
	 * @param dtSignB
	 *            医嘱开立日期 （开始时间）
	 * @param dtSignE
	 *            医嘱开立日期 （结束时间）
	 * @param id_org
	 *            所属组织id
	 * */
	@Override
	public BlOrderAppendBillParamDTO[] getOrderSrvPrinceInfoByIdpres_1(String id_pat, String id_org, int DefaultDaysStOep) throws BizException {
		// 用医嘱信息和物品信息构造新的DTO模板
		BlStarOepBp blStarOepBp = new BlStarOepBp();
		// 组装DTO数据，发送到前台客户端
		List<BlOrderAppendBillParamDTO> orgSrvList = blStarOepBp.getOrderSrvPrinceInfoByIdpres_1(id_pat, id_org, DefaultDaysStOep);
		if (orgSrvList == null) {
			return null;
		}
		return orgSrvList.toArray(new BlOrderAppendBillParamDTO[] {});
	}

	/**
	 * 根据患者id获取医嘱费用信息,按id_pres排序
	 * 
	 * @param id_pat
	 *            患者id
	 * @param dtSignB
	 *            医嘱开立日期 （开始时间）
	 * @param dtSignE
	 *            医嘱开立日期 （结束时间）
	 * @param id_org
	 *            所属组织id
	 * */
	@Override
	public BlOrderAppendBillParamDTO[] findOrderByIdPres(String id_pat, FDateTime dtSignB, FDateTime dtSignE, String id_org) throws BizException {
		// 用医嘱信息和物品信息构造新的DTO模板
		BlStarOepBp blStarOepBp = new BlStarOepBp();
		List<BlOrderAppendBillParamDTO> orgSrvList = blStarOepBp.getOrderSrvPrinceInfoByIdpres(id_pat, dtSignB, dtSignE, id_org);
		if (orgSrvList == null) {
			return null;
		}
		return orgSrvList.toArray(new BlOrderAppendBillParamDTO[] {});
	}

	// @Override
	// public BlOrderAppendBillParamDTO[] findByIdPat(String id_pat,FDateTime
	// dtSignB,FDateTime dtSignE,String id_org)
	// throws BizException {
	//
	// //用医嘱信息和物品信息构造新的DTO模板
	// BlStarOepBp blStarOepBp = new BlStarOepBp();
	// List<BlOrderAppendBillParamDTO> orgSrvList =
	// blStarOepBp.getOrderSrvPrinceInfo(id_pat, dtSignB, dtSignE, id_org);
	// if(orgSrvList==null)
	// {
	// return null;
	// }
	// return orgSrvList.toArray(new BlOrderAppendBillParamDTO[]{});
	// }
	//
	// @Override
	// public BlOrderAppendBillParamDTO[] findOrByIdPat(String id_pat, String
	// id_org)
	// throws BizException {
	// //用医嘱信息和物品信息构造新的DTO模板
	// BlStarOepBp blStarOepBp = new BlStarOepBp();
	// List<BlOrderAppendBillParamDTO> orgSrvList =
	// blStarOepBp.getOrderSrvPrinceInfo(id_pat, id_org);
	//
	// return orgSrvList.toArray(new BlOrderAppendBillParamDTO[]{});
	// }
	//
	// @Override
	// public BlOrderAppendBillParamDTO[] findOrderByIdPat(String id_pat, String
	// id_org)
	// throws BizException {
	//
	// //所有医嘱信息
	// BlStarOepBp blStarOepBp = new BlStarOepBp();
	// List<BlOrderAppendBillParamDTO> orgSrvList =
	// blStarOepBp.getOrderSrvInfo(id_pat, id_org);
	// return orgSrvList.toArray(new BlOrderAppendBillParamDTO[]{});
	// }
	//
	// @Override
	// public BlOrderAppendBillParamDTO[] findByIdOr(String id_pat, String
	// id_org,
	// BlOrderAppendBillParamDTO[] orderArr) throws BizException {
	// //用医嘱信息和物品信息构造新的DTO模板
	// BlStarOepBp blStarOepBp = new BlStarOepBp();
	// List<BlOrderAppendBillParamDTO> orgSrvList =
	// blStarOepBp.getOrderSrvPrinceInfo(id_pat,id_org,orderArr);
	//
	// return orgSrvList.toArray(new BlOrderAppendBillParamDTO[]{});
	// }

	// @Override
	// public BlOrderAppendBillParamDTO[] findByIdPatTest(String id_pat,
	// String id_org) throws BizException {
	// BlStarOepBp blStarOepBp = new BlStarOepBp();
	// List<BlOrderAppendBillParamDTO> orgSrvList =
	// blStarOepBp.blOrSrvNoepTest(id_pat, id_org);
	// return orgSrvList.toArray(new BlOrderAppendBillParamDTO[]{});
	// }
	//
	// @Override
	// public BlOrderAppendBillParamDTO[] findByIdPatSuspTest(String id_pat,
	// String id_org) throws BizException {
	// BlStarOepBp blStarOepBp = new BlStarOepBp();
	// List<BlOrderAppendBillParamDTO> orgSrvList =
	// blStarOepBp.blOrSrvSuspTest(id_pat, id_org);
	// return orgSrvList.toArray(new BlOrderAppendBillParamDTO[]{});
	// }
	//
	// @Override
	// public BlOrderAppendBillParamDTO[] findByIdPatOepTest(String id_pat,
	// String id_org) throws BizException {
	// BlStarOepBp blStarOepBp = new BlStarOepBp();
	// List<BlOrderAppendBillParamDTO> orgSrvList =
	// blStarOepBp.blOrSrvOepTest(id_pat, id_org);
	// return orgSrvList.toArray(new BlOrderAppendBillParamDTO[]{});
	// }
	//
	// @Override
	// public BlOrderAppendBillParamDTO[] findByIdPatNoepTest(String id_pat,
	// String id_org) throws BizException {
	// BlStarOepBp blStarOepBp = new BlStarOepBp();
	// List<BlOrderAppendBillParamDTO> orgSrvList =
	// blStarOepBp.blOrSrvOrTest(id_pat, id_org);
	// return orgSrvList.toArray(new BlOrderAppendBillParamDTO[]{});
	// }

	@Override
	public BlStIpCardInfoDTO findPayInfoByIdPat(String id_ent) throws BizException {
		BlStarIpBp blStarIpBp = new BlStarIpBp();
		return blStarIpBp.getBlStPayInfoByIdPat(id_ent);
	}

	@Override
	public BlCgIpDO[] findBlCgIpItemByQuery(String id_ent, String id_dep, FDateTime dt_end) throws BizException {
		BlStarIpBp blStarIpBp = new BlStarIpBp();
		return blStarIpBp.getBlCgIpInfo(id_ent, id_dep, dt_end);
	}

	/**
	 * 住院结算-调入-（分页查询）
	 * 
	 * @param map
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<BlCgIpDO> findBlCgIpPageInfoDos(FMap map, PaginationInfo pageInfo) throws BizException {
		BlStarIpBp blStarIpBp = new BlStarIpBp();
		return blStarIpBp.getBlCgIpPageDos(map, pageInfo);
	}
	
	/**
	 * 住院结算-调入-（分页查询）改造
	 * @param map
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 * @author liwenqiang
	 */
	public PagingRtnData<BlCgIpDTO> findBlCgIpPageInfoDosReform(FMap map, PaginationInfo pageInfo) throws BizException{
		BlStarIpReFormBp bp=new BlStarIpReFormBp();
		return bp.exec(map, pageInfo);
	}
	
	/**
	 * 根据诊断id、科室id和结束时间获取结账信息 (改造)
	 * @param id_ent 就诊id
	 * @param id_dep 科室id
	 * @param dt_ent 结束时间
	 * @return BlCgIpDO[] 住院记账信息
	 * @author liwenqiang
	 * */
	public BlCgIpDTO[] findBlCgIpItemByQueryReform(String id_ent, String id_dep, FDateTime dt_end) throws BizException{
		GetBlCgIpInfoBp bp=new GetBlCgIpInfoBp();
		return bp.exec(id_ent, id_dep, dt_end);
	}
	

	@Override
	public BlStIpBillDTO findBlStIpBillInfoByIdStIp(String id_stip) throws BizException {
		BlStarIpBp blStarIpBp = new BlStarIpBp();
		return blStarIpBp.getBlStIpBillDTOByIdStIp(id_stip);
	}

	@Override
	public BlStIpInccaInfoDTO[] findBdInccaInfoByIdStIp(String id_stip) throws BizException {
		BlStarIpBp blStarIpBp = new BlStarIpBp();
		return blStarIpBp.getBdInccaInfoByIdStIp(id_stip);
	}

	@Override
	public BlStIpInccaInfoDTO[] findBLIncInfoByIdStIp(String id_stip) throws BizException {
		BlStarIpBp blStarIpBp = new BlStarIpBp();
		return blStarIpBp.getBLIncInfoByIdStIp(id_stip);
	}

	@Override
	public BlCgIpDO[] findBlCgIpItemByIdStIp(String id_stip) throws BizException {
		BlStarIpBp blStarIpBp = new BlStarIpBp();
		return blStarIpBp.getBlStIpCgIpInfo(id_stip);
	}

	@Override
	public BlStIpInccaInfoDTO[] findBdInccaInfoByIdEnt(String id_ent) throws BizException {
		BlPayPatIpBp blPayPatIpBp = new BlPayPatIpBp();
		return blPayPatIpBp.getBdInccaInfoByIdEnt(id_ent);
	}

	@Override
	public BlStIpInccanoDTO findBlStIpNoByIdUser(String id_psndoc) throws BizException {
		BlPayPatIpBp blPayPatIpBp = new BlPayPatIpBp();
		return blPayPatIpBp.getBlStIpInccaNos(id_psndoc);
	}

	@Override
	public Integer findNoPayBlstipCountByIdEnt(String id_ent) throws BizException {
		BlStarIpBp blStarIpBp = new BlStarIpBp();
		return blStarIpBp.getNoPayBlstipCountByIdEnt(id_ent);
	}

	@Override
	public BlStIpDO findBlStIpInfoByIdEnt(String id_ent) throws BizException {
		BlPayPatIpBp blPayPatIpBp = new BlPayPatIpBp();
		return blPayPatIpBp.getBlStIpByIdEnt(id_ent);
	}

	// @Override
	// // public BlStIpInccaInfoDTO[] findBdInccaInfoByIdStip(String id_stip)
	// // throws BizException {
	// // BlPayPatIpBp blPayPatIpBp = new BlPayPatIpBp();
	// // return blPayPatIpBp.getBdInccaInfoByIdStIp(id_stip);
	// // }

	@Override
	public FDouble findPatRateByIdEnt(String id_ent) throws BizException {
		BlPayPatIpBp blPayPatIpBp = new BlPayPatIpBp();
		return blPayPatIpBp.getPatRateByIdEnt(id_ent);
	}

	@Override
	public DebtPayBackDTO[] findArrearsBlStIpByIdEnt(String id_ent) throws BizException {
		BlStIpArrearsBp BlStIpArrearsBp = new BlStIpArrearsBp();
		return BlStIpArrearsBp.getBlStIpArrearsByIdEnt(id_ent);
	}

	/**
	 * 获得包装单位：包装单位ID，包装单位名称
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public MeasDocDO[] getMeasDocDOArr() throws BizException {
		BlStarOepBp blStarOepBp = new BlStarOepBp();
		return blStarOepBp.getMeasDocDOArr();
	}

	@Override
	public PatiVisitDO[] findBlStIpPayBanner(String id_pat) throws BizException {
		BlPayPatIpBp blPayPatIpBp = new BlPayPatIpBp();
		return blPayPatIpBp.getBlStIpPayBanner(id_pat);
	}

	@Override
	public PatiVisitDO[] findBlStIpPayRefundBanner(String id_pat) throws BizException {
		BlPayPatIpBp blPayPatIpBp = new BlPayPatIpBp();
		return blPayPatIpBp.getBlStIpPayRefundBanner(id_pat);
	}

	@Override
	public PatiVisitDO[] findBlStIpArrearsBanner(String id_pat) throws BizException {
		BlStIpArrearsBp blStIpArrearsBp = new BlStIpArrearsBp();
		return blStIpArrearsBp.getBlStIpArrearsBanner(id_pat);
	}

	/**
	 * 获得医保计划，包装单位，医保科别，医保剂量，医保频率
	 * 
	 * @param id_hps
	 *            提取该医保ID下到医保科别，医保剂量，医保频率
	 */
	@Override
	public InsurUnitDepFreqDoseDTO getInsurUnitDepFreqDoseDTO() throws BizException {
		BlStarOepBp blStarOepBp = new BlStarOepBp();
		return blStarOepBp.getInsurUnitDepFreqDoseDTO();
	}

	@Override
	public BlStIpBadDebtDTO[] findBlStIpBadPayInfo(FBoolean fg_baddebt) throws BizException {
		BlStIpBadPayBp blStIpBadPayBp = new BlStIpBadPayBp();
		return blStIpBadPayBp.getBadPayBlStIpInfo(fg_baddebt);
	}

	@Override
	public BlBannerDTO[] findStIpBannerDtoInfo(String inputValue, String[] selectCondition) throws BizException {
		BlStarIpBp blStarIpBp = new BlStarIpBp();
		return blStarIpBp.getStIpBannerEnEntInfo(inputValue, selectCondition);
	}

	@Override
	public BlBannerDTO[] findStPayBannerDtoInfo(String inputValue, String[] selectCondition) throws BizException {
		BlPayPatIpBp blPayPatIpBp = new BlPayPatIpBp();
		return blPayPatIpBp.getStPayBannerEnEntInfo(inputValue, selectCondition);
	}

	@Override
	public BlBannerDTO[] findStRefundBannerDtoInfo(String inputValue, String[] selectCondition) throws BizException {
		BlPayPatIpBp blPayPatIpBp = new BlPayPatIpBp();
		return blPayPatIpBp.getStRefundBannerEnEntInfo(inputValue, selectCondition);
	}

	@Override
	public BlBannerDTO[] findStArrearsBannerDtoInfo(String inputValue, String[] selectCondition) throws BizException {
		BlStIpArrearsBp blStIpArrearsBp = new BlStIpArrearsBp();
		return blStIpArrearsBp.getArrearsIpBannerEnEntInfo(inputValue, selectCondition);
	}

	
	

	
	

	

	

	

	

	

	
	

	/**
	 * 获取门诊就诊列表
	 * 
	 * @author liwq
	 * */
	@Override
	public BlOpFeeOutDTO[] findBlOepEntInfos(String sDate, String eDate, String id_pat) throws BizException {
		BlOpFeeOutBp blOpFeeOutBp = new BlOpFeeOutBp();
		return blOpFeeOutBp.getEntOepInfos(sDate, eDate, id_pat);
	}
	
	/**
	 * 获取最后一次导出时间
	 * @return
	 * @throws BizException
	 */
	public FDateTime getLastedOutDateTime() throws BizException {
		QryLastedFeeOutDate qry = new QryLastedFeeOutDate();
		return qry.exec();
	}

	public FMap getEmpPhyDo(String strIdPsnDoc) throws BizException {
		BlStarOepBp handlerBp = new BlStarOepBp();
		return handlerBp.getEmpPhyDoArr(strIdPsnDoc);
	}

	/**
	 * 获得门诊结算号（就诊领域使用）
	 * 
	 * @param strIdCg
	 *            记账bl_cg_oep主键
	 * @return 门诊结算号
	 * @throws BizException
	 */
	public String getCodeSt(String strIdCg) throws BizException {
		BlStarOepBp handlerBp = new BlStarOepBp();
		return handlerBp.getCodeSt(strIdCg);
	}

	/**
	 * 获取挂号就诊列表
	 * */
	@Override
	public BlEntInfoDTO[] findBlEntInfoList(String dt_begin, String dt_end) throws BizException {
		BlEntInfoBp blEntInfoBp = new BlEntInfoBp();
		return blEntInfoBp.getBlEntInfos(dt_begin, dt_end);
	}

	/**
	 * 住院项目减免，根据id_stip 查询按账单分组明细
	 * 
	 * @param id_stip
	 * @return
	 * @throws BizException
	 * @author Liwq
	 */
	public PagingRtnData<BlCgIpDO> findBlCgIpPageInfoData(FMap map, PaginationInfo pageInfo) throws BizException {
		BlStarIpBp getIpChargeAuditInfo = new BlStarIpBp();
		return getIpChargeAuditInfo.findBlCgIpPageInfoData(map, pageInfo);
	}

	/**
	 * 项目减免-分类服务项目合计
	 * 
	 * @author Liwq
	 */
	public BlCgIpDO[] findBlCgIpDOsByIdStip(String id_stip) throws BizException {
		BlStarIpBp getIpChargeAuditInfo = new BlStarIpBp();
		return getIpChargeAuditInfo.findBlCgIpDOsByIdStip(id_stip);
	}

	@Override
	public PagingRtnData<MiMcPatSpecDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg) throws BizException {
		BlHpSpecificIllPiBp bp = new BlHpSpecificIllPiBp();
		return bp.findByQCondAndPageInfo(qryRootNodeDTO, orderStr, pg);
	}

	@Override
	public MiMcPatSpecDiDO[] getBlHpPatSpecDiItmsByIdhppat(MiMcPatSpecDO blhpPatSpecDO) throws BizException {
		BlHpSpecificIllPiBp bp = new BlHpSpecificIllPiBp();
		return bp.getBlHpPatSpecDiItmsByIdhppat(blhpPatSpecDO);
	}

	/**
	 * 获取计量单位列表 (方便第三方使用)
	 * 
	 * @throws BizException
	 * @author Liwq
	 * */
	public Map<String, MeasDocDO> setMeasDocDOMap() throws BizException {
		BlStarOepBp blStarOepBp = new BlStarOepBp();
		return blStarOepBp.setMeasDocDOMap();
	}

	/**
	 * PrescriptionCostDto 转 BlOrderAppendBillParamDTO
	 * 
	 * @param ciDto
	 * @return
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO convertDto(PrescriptionCostDto ciDto) throws BizException {

		BlStarOepBp bp = new BlStarOepBp();
		Map<String, MeasDocDO> measMap = setMeasDocDOMap();
		
		String hpId = null;
		if(!StringUtil.isEmpty(ciDto.getId_en())){
			IEnthpRService entHpService = ServiceFinder.find(IEnthpRService.class);
			EntHpDO[] hpDos = entHpService.find("a0.id_ent = '" +ciDto.getId_en()+"' and fg_maj = 'Y' ", null, FBoolean.FALSE);
			
			if(!ArrayUtil.isEmpty(hpDos)){
				hpId = hpDos[0].getId_hp();
			}
		}
		
		return bp.setBlOrderShow_Idpres(ciDto, measMap, hpId);
	}
	/**
	 * 根据患者id获取医嘱费用信息,按id_pres排序 不删除挂起数据
	 * 
	 * @param id_pat
	 *            患者id
	 * @param defaultDaysLoadOep
	 *            默认调入天数
	 * */
	@Override
	public BlOrderAppendBillParamDTO[] getOrderSrvPrinceInfoByIdpres_load_NoDel(String id_pat, int defaultDaysLoadOep) throws BizException {
		GetChargingItemsBp handlerBp = new GetChargingItemsBp();
		return handlerBp.exec(id_pat, defaultDaysLoadOep, false);
	}

	/**
	 * By Liwq
	 */
	@Override
	public BlBannerDTO[] findStIpBannerEntInfo(String inputValue, String[] selectCondition) throws BizException {
		BlStarIpBp blStarIpBp = new BlStarIpBp();
		return blStarIpBp.getStIpBannerEntInfo(inputValue, selectCondition);
	}

	public BlIpChargeAuditDTO[] findFeeStateByIdent(String id_ent) throws BizException {
		GetIpChargeAuditInfoBp getIpChargeAuditInfo = new GetIpChargeAuditInfoBp();
		return getIpChargeAuditInfo.findFeeStateByIdent(id_ent);
	}

	/**
	 * 根据就诊id获取未结算账单信息
	 * 
	 * @param id_ent 就诊id
	 * @param fgSt 结算标志 Y-> 查询已结算 N->查询未结算 null->查询所有费用
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

	@Override
	public BlAuditIp saveIpAudit(String id_ent, OperatorInfoDTO operatorInfoDTO) throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.saveIpAudit(id_ent, operatorInfoDTO);
	}

	@Override
	public BlAuditIp cancelIpAudit(BlAuditIp auditIp, OperatorInfoDTO operatorInfoDTO) throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.cancelIpAudit(auditIp, operatorInfoDTO);
	}

	@Override
	public BlAuditIp saveHpAudit(String id_ent, OperatorInfoDTO operatorInfoDTO) throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.saveHpAudit(id_ent, operatorInfoDTO);
	}

	@Override
	public BlAuditIp cancelHpAudit(BlAuditIp auditip, OperatorInfoDTO operatorInfoDTO) throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.cancelHpAudit(auditip, operatorInfoDTO);
	}

	@Override
	public BlIpAuditCiDTO[] getBlIpAuditCiInfo(BlIpAuditCiDTO auditCiDto) throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.getBlIpAuditCiInfo(auditCiDto);
	}

	@Override
	public PagingRtnData<BlIpAuditCiDTO> getIpCiCgFeePageInfo(BlIpAuditCiDTO auditCiDto, PaginationInfo pageInfo)
			throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.getIpCiCgFeePageInfo(auditCiDto, pageInfo);
	}

	@Override
	public FBoolean doFreezeEnAccBoolean(String id_ent, String id_emp, FBoolean bFlag) throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.doFreezeEnAccBoolean(id_ent, id_emp, bFlag);
	}

	@Override
	public FBoolean findAuditIpStatus(String id_ent) throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.getAuditIpStatus(id_ent);
	}

	@Override
	public RePrintInvoiceInfoDTO doQryLastStInfo(String id_pat, OperatorInfoDTO operatorInfoDTO, FBoolean fg_reginfo,
			String incno_old, FBoolean fg_hpCard) throws BizException {
		QryLastStInfoBp bp = new QryLastStInfoBp();
		return bp.exec(id_pat, operatorInfoDTO, fg_reginfo, incno_old, fg_hpCard);
	}
	
	/**
	 * 查询历史结算信息
	 * @param stInfo
	 * @return
	 * @author liwenqiang
	 * @throws BizException 
	 */
	public BlStBaseInfo[] findHistorySt(String entId) throws BizException{
		GetHistoryStBp bp=new GetHistoryStBp();
		return bp.exec(entId);
	}
	
	/**
	 * 根据结算Id查询结算明细
	 * @param id_stip
	 * @return
	 * @throws BizException
	 * @author liwenqiang
	 */
	public BlCgIpDTO[] findBlCgIpItemByIdStIpReform(String stipId) throws BizException{
		GetBlCgIpItemByIdStBp bp=new GetBlCgIpItemByIdStBp();
		return bp.exec(stipId);
	}
	/**
	 * 医保特殊病患者，通过医保号查询患者编码
	 */
	@Override
	public MiMcPatSpecDO findCodeByNoHp(String NoHp) throws BizException {
		BlHpSpecificIllPiBp bp = new BlHpSpecificIllPiBp();
		return bp.findCodeByNoHp(NoHp);
		
	}
	/**
	 * 获取住院患者本次住院的最大记账时间
	 * 
	 * @return 如果空值 则返回 1900-01-01 00:00:00
	 * @throws BizException
	 * @author xuebei
	 * @time  2018-10-10
	 */
	public FDateTime getMaxBlcgipTimeUnSettled(String strIdEnt, String fg_st) throws BizException {
		IpStEP ep=new IpStEP();
		FDateTime maxTime = ep.getMaxBlcgipTimeUnSettled(strIdEnt, fg_st);
		return maxTime;
	}
	
	/**
	 * 门诊重划重收调入
	 * @author : hanjq 2019年8月2日 上午10:23:53
	 * @param id_pat
	 * @param dt_b
	 * @param dt_e
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlStOepVsIncDTO[] doLoadInForRecharge(String id_pat, String dt_b, String dt_e) throws BizException {
		LoadInForRechargeBp bp = new LoadInForRechargeBp();
		return bp.exec(id_pat, dt_b, dt_e);
	}
	
	
	/**
	 * 住院医保自费项目审核功能-待预审核信息查询
	 */
	@Override
	public PagingRtnData<BlIpAuditOutHospCheckDTO> getIpOutAuditPats(PaginationInfo pgInfo, String wherePart)
			throws BizException {
		GetIpOutAuditPatsBP bp = new GetIpOutAuditPatsBP();
		return bp.exec(wherePart, pgInfo);








	}
	/**
	 * 根据就诊id_ent id_stip fg_st获取急诊留观费用信息
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
	public BlIpAuditFeeDTO[] getBlETAuditFeeInfo(BlIpChargeAuditDTO treeAuditDTO) throws BizException {
		GetIpChargeAuditInfoBp getIpChargeAuditInfo = new GetIpChargeAuditInfoBp();
		return getIpChargeAuditInfo.getBlETAuditFeeInfo(treeAuditDTO);
	}

	/**
	 * 获取结算账单信息_急诊
	 */
	@Override
	public BlStIpInccaInfoDTO[] findBdInccaInfoByIdStET(String id_stip) throws BizException {
		BlStarIpBp blStarIpBp = new BlStarIpBp();
		return blStarIpBp.getBdInccaInfoByIdStET(id_stip);
	}
	
	/** 急诊留观根据就诊id获取未结算账单信息
	 * 
	 * @param id_ent
	 *            就诊id
	 * @param fgSt
	 *            结算标志 Y-> 查询已结算 N->查询未结算 null->查询所有费用
	 * @return BlStIpInccaInfoDTO[] 账单信息
	 * @throws BizException
	 * @author liwq
	 * */
	public BlStIpInccaInfoDTO[] getInccaInfoByIdEntET(String id_ent, String fgSt) throws BizException {
		BlStarIpBp blStarIpBp = new BlStarIpBp();
		return blStarIpBp.getInccaInfoByIdEntET(id_ent, fgSt);
	}

	
	@Override
	public BlAuditLogIpDTO[] getAuditLogIpDtos(String id_auditIp)throws BizException {
		BlAuditIpBp bp=new BlAuditIpBp();
		return bp.geAuditLogIpDTOs(id_auditIp);
	}
	
	/**
	 * 判断是否已经被审核过，如果有合法审核 true ,没有合法审核false
	 */
	@Override
	public FBoolean HasETHpAudited(String id_ent) throws BizException
	{
		BlAuditAndStLogicETBP bp=new BlAuditAndStLogicETBP();
		return bp.HasETHpAudited(id_ent);
	}

	/**
	 * 保存出观医保审核和取消出观医保审核结果，如果成功 true ,失败false
	 */
	@Override
	public FBoolean SaveHpAuditET(BlAuditIp blAuditIp) throws BizException {
		BlAuditAndStLogicETBP bp=new BlAuditAndStLogicETBP();
		return bp.SaveHpAuditET(blAuditIp);
	}

	/**
	 * 发送审核结果到护士站
	 * @param id_auditip
	 * @author xuebei
	 * @return FBoolean
	 */
	public void SendAuditMsgToNurse(AuditResultDTO auditResultDTO) throws BizException
	{
		BlAuditAndStLogicETBP bp=new BlAuditAndStLogicETBP();
		bp.SendAuditMsgToNurse(auditResultDTO);
	}

	/**
	 * 根据结算id_st获取已结算急诊留观费用收付款信息
	 * @param id_st 结算id
	 * @return BlIpAuditStPayInfoDTO[] 费用审核-已结算收款信息
	 * @throws BizException
	 * @author xuebei
	 * @throws DAException 
	 * */
	public BlIpAuditStPayInfoDTO[] getBlETAuditStPayInfo(String id_st) throws BizException {
		GetIpChargeAuditInfoBp getIpChargeAuditInfo = new GetIpChargeAuditInfoBp();
		return getIpChargeAuditInfo.getBlETAuditStPayInfo(id_st);
	}

	
	/**
	 * 住院费用审核出院查询弹窗查询模板逻辑(通过条件查询获得所需的出院病人列表)
	 */
	public PagingRtnData<BlIpAuditOutHospCheckDTO> getOutPatListByQry(PaginationInfo pgInfo, QryRootNodeDTO qryRoot) throws BizException {
		GetOutPatListByQryBP bp = new GetOutPatListByQryBP();
		return bp.exec(qryRoot, pgInfo);
	}

	/**
	 * 查询急诊留观费用审核分类项目
	 */
	public BlIpChargeAuditDTO[] findFeeStateByIdentET(String id_ent) throws BizException {
		GetIpChargeAuditInfoBp getIpChargeAuditInfo = new GetIpChargeAuditInfoBp();
		return getIpChargeAuditInfo.findFeeStateByIdentET(id_ent);
	}


	
	/**
	 * 留观费用审核出院查询弹窗查询模板逻辑(通过条件查询获得所需的出院病人列表)
	 */
	public PagingRtnData<BlIpAuditOutHospCheckDTO> getOutETListByQry(PaginationInfo pgInfo, QryRootNodeDTO qryRoot) throws BizException {
		GetOutPatListByQryBP bp = new GetOutPatListByQryBP(true);
		return bp.exec(qryRoot, pgInfo);
	}
	
	/**
	 * 根据就诊id和id_srv fg_st 获取急诊留观费用明细 BlIpAuditFeeDTO 费用信息模型
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
	public PagingRtnData<BlIpAuditFeeDTO> getBlETAuditFeeItemInfo(BlIpAuditFeeDTO auditFeeDto, String fg_st, String id_stip, PaginationInfo pageInfo) throws BizException {
		GetIpChargeAuditInfoBp getIpChargeAuditInfo = new GetIpChargeAuditInfoBp();
		return getIpChargeAuditInfo.getBlETAuditFeeItemInfo(auditFeeDto, fg_st, id_stip, pageInfo);
	}
	
	/**
	 * (门诊费用综合查询)查询门诊发票信息
	 */
	@Override
	public BlAuditIncInfoDTO[] getBlCgOepInc(String id_stoep) throws DAException {
		OepChargeQryBP bp = new OepChargeQryBP();
		return bp.getBlCgOepInc(id_stoep);
	}

	/**
	 * (门诊费用综合查询) 查询收付款信息
	 */
	@Override
	public BlIpAuditStPayInfoDTO[] getBlOepStPayInfo(String id_stoep) throws BizException {
		OepChargeQryBP bp = new OepChargeQryBP();
		return bp.getBlOepStPayInfo(id_stoep);
	}


}
