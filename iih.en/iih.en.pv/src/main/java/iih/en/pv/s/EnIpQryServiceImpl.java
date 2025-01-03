package iih.en.pv.s;

import iih.en.comm.IEnConst;
import iih.en.comm.IEnRuleConst;
import iih.en.comm.custom.EnIpCustomServiceUtils;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.EntDiEP;
import iih.en.comm.ep.PsnDocEP;
import iih.en.comm.util.EnContextUtils;
import iih.en.pv.custom.d.EnHpPatCaInParamsDTO;
import iih.en.pv.dto.d.DeptCountInfoDTO;
import iih.en.pv.dto.d.DischargeDTO;
import iih.en.pv.dto.d.EnAuthListDTO;
import iih.en.pv.dto.d.EnAuthQryDTO;
import iih.en.pv.dto.d.EnDepDTO;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.en.pv.dto.d.EntInfo4RentDTO;
import iih.en.pv.dto.d.EntQryModDTO;
import iih.en.pv.dto.d.HosRecallDTO;
import iih.en.pv.dto.d.HosRecallQryDTO;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.dto.d.IpInfoDTO;
import iih.en.pv.dto.d.LvHosAppDTO;
import iih.en.pv.dto.d.MainStateDTO;
import iih.en.pv.dto.d.MsgInfoCardDTO;
import iih.en.pv.dto.d.OutpatientQryDTO;
import iih.en.pv.dto.d.PativisitensonDTO;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.enfee.d.EnFixedFeeItemDO;
import iih.en.pv.enfee.d.EntAccActDO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.enfee.dto.d.EnAccDTO;
import iih.en.pv.enfee.dto.d.PatiFixedFeeLeftDTO;
import iih.en.pv.enres.d.EnBedDO;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.hpdto.d.IpHpRegistDTO;
import iih.en.pv.i.IEnIpQryService;
import iih.en.pv.inpatient.d.EnIppreDO;
import iih.en.pv.inpatient.d.EnPeCmpyItmDO;
import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import iih.en.pv.inpatient.dto.d.BedCardDetailDTO;
import iih.en.pv.inpatient.dto.d.BedQryModDTO;
import iih.en.pv.inpatient.dto.d.DepEntStateDTO;
import iih.en.pv.inpatient.dto.d.EnHosDTO;
import iih.en.pv.inpatient.dto.d.EnHosPatDTO;
import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;
import iih.en.pv.inpatient.dto.d.EnIppreTransHosDTO;
import iih.en.pv.inpatient.dto.d.EnPeCmpyDTO;
import iih.en.pv.inpatient.dto.d.EnPePatInfoDTO;
import iih.en.pv.inpatient.dto.d.IpRegInfoDTO;
import iih.en.pv.inpatient.dto.d.IpRegQrySchmDTO;
import iih.en.pv.inpatient.dto.d.IppreQryConditionsDTO;
import iih.en.pv.inpatient.dto.d.NewbornDTO;
import iih.en.pv.s.bp.EmpQryBP;
import iih.en.pv.s.bp.GetFixedFeeInfoBP;
import iih.en.pv.s.bp.GetMsgInfoCardDTOBp;
import iih.en.pv.s.bp.GetNewborninfoBP;
import iih.en.pv.s.bp.GetScPrtTmplBp;
import iih.en.pv.s.bp.ip.CancelRegisterBP;
import iih.en.pv.s.bp.ip.CardPrintByDayBP;
import iih.en.pv.s.bp.ip.CardPrintByDeptBP;
import iih.en.pv.s.bp.ip.CardPrintByNurBP;
import iih.en.pv.s.bp.ip.CardPrintByWardBP;
import iih.en.pv.s.bp.ip.CreateNewTurnOverInfoBP;
import iih.en.pv.s.bp.ip.GetAppliedTransPatsBP;
import iih.en.pv.s.bp.ip.GetBalanceBP;
import iih.en.pv.s.bp.ip.GetBedCardDetailBP;
import iih.en.pv.s.bp.ip.GetDepEntStateStatsBP;
import iih.en.pv.s.bp.ip.GetDepListByDepLineBP;
import iih.en.pv.s.bp.ip.GetDepStatsBP;
import iih.en.pv.s.bp.ip.GetEnAccBP;
import iih.en.pv.s.bp.ip.GetEntInfo4RentBP;
import iih.en.pv.s.bp.ip.GetEntPatTpBP;
import iih.en.pv.s.bp.ip.GetIpBasicInfosBP;
import iih.en.pv.s.bp.ip.GetIpDOListBP;
import iih.en.pv.s.bp.ip.GetIpInfoBP;
import iih.en.pv.s.bp.ip.GetIpListInfoBP;
import iih.en.pv.s.bp.ip.GetMainEntStateBP;
import iih.en.pv.s.bp.ip.LvHosCheckBP;
import iih.en.pv.s.bp.ip.OutDepCheckBP;
import iih.en.pv.s.bp.ip.ValidateCombineBP;
import iih.en.pv.s.bp.ip.ValidateDischargeInfoBP;
import iih.en.pv.s.bp.ip.ValidateIPDataBP;
import iih.en.pv.s.bp.ip.qry.CheckIsObsDeptBP;
import iih.en.pv.s.bp.ip.qry.GetBedBP;
import iih.en.pv.s.bp.ip.qry.GetDisChargeBP;
import iih.en.pv.s.bp.ip.qry.GetEnAuthBP;
import iih.en.pv.s.bp.ip.qry.GetEnDeptInfoBP;
import iih.en.pv.s.bp.ip.qry.GetEnHosBP;
import iih.en.pv.s.bp.ip.qry.GetEnHosPatInfoBP;
import iih.en.pv.s.bp.ip.qry.GetEnHosRegInfoBP;
import iih.en.pv.s.bp.ip.qry.GetEnPeComyInfoBP;
import iih.en.pv.s.bp.ip.qry.GetEnPePatInfosBP;
import iih.en.pv.s.bp.ip.qry.GetEnPsnBP;
import iih.en.pv.s.bp.ip.qry.GetEntid;
import iih.en.pv.s.bp.ip.qry.GetImageByPatIdBP;
import iih.en.pv.s.bp.ip.qry.GetIpBasicDTOBP;
import iih.en.pv.s.bp.ip.qry.GetIpDiQryListBP;
import iih.en.pv.s.bp.ip.qry.GetIpHpRegistBP;
import iih.en.pv.s.bp.ip.qry.GetIpLeaveListBp;
import iih.en.pv.s.bp.ip.qry.GetIpOutDeptListBP;
import iih.en.pv.s.bp.ip.qry.GetIpPatientsBP;
import iih.en.pv.s.bp.ip.qry.GetIpRegInfoBP;
import iih.en.pv.s.bp.ip.qry.GetIpRegListBP;
import iih.en.pv.s.bp.ip.qry.GetLvDtoForRecallBP;
import iih.en.pv.s.bp.ip.qry.GetLvDtoForRecallByQryDTOBP;
import iih.en.pv.s.bp.ip.qry.GetLvHosCheckDetailsBP;
import iih.en.pv.s.bp.ip.qry.GetLvHosDTOArrayBP;
import iih.en.pv.s.bp.ip.qry.GetLvHosListBP;
import iih.en.pv.s.bp.ip.qry.GetLvHosListByQryDTOBP;
import iih.en.pv.s.bp.ip.qry.GetMatchNbBP;
import iih.en.pv.s.bp.ip.qry.GetNoOrTransPatsByEntBP;
import iih.en.pv.s.bp.ip.qry.GetPatInfoBP;
import iih.en.pv.s.bp.ip.qry.GetPricByBedIdBP;
import iih.en.pv.s.bp.ip.qry.GetPrintWristCardTypeBp;
import iih.en.pv.s.bp.ip.qry.GetTransDocInfoBP;
import iih.en.pv.s.bp.ip.qry.GetTransInCountBP;
import iih.en.pv.s.bp.ip.qry.GetTransInDepBP;
import iih.en.pv.s.bp.ip.qry.GetTransOutCountBP;
import iih.en.pv.s.bp.ip.qry.GetTransOutDepBP;
import iih.en.pv.s.bp.ip.qry.GetTransOutDepNoCheckBP;
import iih.en.pv.s.bp.ip.qry.GetTransOutFinishBP;
import iih.en.pv.s.bp.ip.qry.GetTrausOutCheckDetailsBP;
import iih.en.pv.s.bp.ip.qry.GetWillEnDepCountBP;
import iih.en.pv.s.bp.ippre.IppreLvHosCheckBP;
import iih.en.pv.s.bp.ippre.qry.GetAcceptEnippreListBp;
import iih.en.pv.s.bp.ippre.qry.GetEnDepBP;
import iih.en.pv.s.bp.ippre.qry.GetIpLvHosBP;
import iih.en.pv.s.bp.ippre.qry.GetIpPrePatListBP;
import iih.en.pv.s.bp.ippre.qry.GetIppreConterListBP;
import iih.en.pv.s.bp.ippre.qry.GetIppreEnDeptInfoBP;
import iih.en.pv.s.bp.ippre.qry.GetIpprePatientsBP;
import iih.en.pv.s.bp.ippre.qry.GetIppreQryPatInfoBP;
import iih.en.pv.s.bp.ippre.qry.GetIppreTransHosBP;
import iih.en.pv.s.bp.ippre.qry.GetIppreTransHosCheckBP;
import iih.en.pv.s.bp.ippre.qry.GetSuspendHosPatListBP;
import iih.en.pv.s.bp.op.GetEnIpntBP;
import iih.en.pv.s.bp.op.GetEntInfo4BannerBP;
import iih.en.pv.s.rule.CheckIpRegitsRuleBP;
import iih.en.pv.shiftturnover.d.ShiftturnoverAggDO;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.BedQrySchmDTO;
import iih.sc.scbd.dto.d.PrtQry4EnDTO;
import iih.sc.scbd.dto.d.ScPrtTmplDTO;

import java.lang.reflect.InvocationTargetException;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 住院查询服务
 * 
 * @author yank
 * @author renying
 * @author liubin
 *
 */
@Service(serviceInterfaces = { IEnIpQryService.class }, binding = Binding.JSONRPC)
public class EnIpQryServiceImpl  implements IEnIpQryService {

	/**
	 * 获取banner信息
	 * 
	 * @param sqlStr 查询语句
	 * @param whereStr 查询条件
	 * @param svName 服务名称，多个逗号隔开
	 * @return
	 * @throws BizException
	 */
	@Override
	public Ent4BannerDTO[] getEntInfo4Banner(String sqlStr, String whereStr, String svName) throws BizException {
		GetEntInfo4BannerBP getBP = new GetEntInfo4BannerBP();
		return getBP.exec(sqlStr, whereStr, svName, null, null);
	}

	/***
	 * 通过床位id查询床位费用
	 * @param bedId
	 * @return
	 * @throws BizException
	 */
	@Override
	public BedQrySchmDTO getPricByBedId(String bedId) throws BizException{
		GetPricByBedIdBP bp = new GetPricByBedIdBP();
		return bp.exec(bedId);
	}
	/**
	 * EntipntDTO[] getIpntByEntId(String entId)
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public AptIpDTO[] getIpntByEntId(String patId, String entId) throws BizException {
		GetEnIpntBP enipntBP = new GetEnIpntBP();
		return enipntBP.exec(patId, entId);
	}

	/**
	 * 根据患者id加载入院登记信息(old method: find)
	 * 
	 * @param patId 患者ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnHosRegDTO[] getHosRegInfo(String patId) throws BizException {
		GetEnHosRegInfoBP enhosBP = new GetEnHosRegInfoBP();
		return enhosBP.exec(patId);
	}
	/**
	 * 根据就诊id加载入院登记信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnHosRegDTO getHosRegInfoByEntId(String entId, FBoolean fg_st)throws BizException {
		GetEnHosRegInfoBP bp = new GetEnHosRegInfoBP();
		return bp.getEnHosRegByEntId(entId, fg_st);
	}
	/**
	 * 入院登记(含注册)患者信息查询
	 * @param cond 模糊查询条件
	 * @return EnHosPatDTO 
	 * @throws BizException
	 */
	@Override
	public EnHosPatDTO getPatInfo(PiPatFuzyyQueryCondDTO cond, String entId, FBoolean isChild, FBoolean fgBb) throws BizException {
		GetPatInfoBP bp = new GetPatInfoBP();
		return bp.exec(cond, entId, isChild, fgBb);
	}	
	
	/**
	 * 入院登记(含注册)(新)信息查询
	 * @param cond 模糊查询条件
	 * @return EnHosPatDTO 
	 * @throws BizException
	 */
	@Override
	public EnHosDTO[] getEnHosInfo(PiPatFuzyyQueryCondDTO cond, FBoolean fgBb) throws BizException {
		GetEnHosBP bp = new GetEnHosBP();
		return bp.exec(cond, fgBb);
	}	
	/**
	 * 获取住院登记患者信息 TODO DELETE (old method: getPatInfo)
	 * 
	 * @param patId
	 *            患者id
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnHosPatDTO getEnHosPatInfo(String patId) throws BizException {
		GetEnHosPatInfoBP getEnHosPatInfo = new GetEnHosPatInfoBP();
		return getEnHosPatInfo.exec(patId);
	}
	
	

	/**
	 * 根据病区获取病区申请入科列表 
	 * 
	 * @param nurId
	 *            当前登录病区
	 * @return EnDepDTO[] 当前病区待入科的患者列表
	 * @throws BizException
	 */
	@Override
	public EnDepDTO[] getEnDepList(String nurId) throws BizException {
		GetEnDeptInfoBP endepBp = new GetEnDeptInfoBP();
		return endepBp.exec(nurId);
	}

	/**
	 * 获取待入科病人总数
	 * 
	 * @param nurId 病区id
	 * @return
	 * @throws BizException
	 */
	@Override
	public Integer getWillEnDepCount(String nurId) throws BizException {
		GetWillEnDepCountBP getCountBP = new GetWillEnDepCountBP();
		return getCountBP.getWillEnDepCount(nurId);
	}

	/**
	 * 获取病区或科室统计信息
	 * 
	 * @param deptId  病区或科室id
	 * @return
	 * @throws BizException
	 */
	@Override
	public DeptCountInfoDTO getDepStatsInfo(String depId) throws BizException {
		GetDepStatsBP getStatBP = new GetDepStatsBP();
		return getStatBP.exec(depId);
	}

	/**
	 * 获取科室就诊状况统计信息
	 * 
	 * @param depId   病区或科室ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public DepEntStateDTO[] getDepEntStateStats(String depId) throws BizException {
		GetDepEntStateStatsBP getStatsBP = new GetDepEntStateStatsBP();
		return getStatsBP.exec(depId);
	}

	/**
	 * 获取患者主要就诊状况 （包含病情、护理、营养）
	 * 
	 * @param entId   就诊ID
	 * @return 主要就诊状况DTO
	 * @throws BizException
	 * @author renying
	 */
	public MainStateDTO getMainEntState(String entId) throws BizException {
		GetMainEntStateBP getMainStateBP = new GetMainEntStateBP();
		return getMainStateBP.exec(entId);
	}

	/**
	 * 获取医护人员
	 * 
	 * @param entId  就诊id
	 * @throws BizException
	 */
	@Override
	public PativisitensonDTO getMedPsn(String entId) throws BizException {
		GetEnPsnBP getEnPsnQry = new GetEnPsnBP();
		return getEnPsnQry.exec(entId);
	}

	/**
	 * 获取住院信息
	 * 
	 * @param entId  就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public IpInfoDTO getIpInfo(String entId) throws BizException {
		GetIpInfoBP getBP = new GetIpInfoBP();
		return getBP.exec(entId);
	}

	/**
	 * 获取就诊账户信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public BalanceDTO getBalanceDTO(String entId) throws BizException {
		
		GetEnAccBP getAccBP = new GetEnAccBP();
		getAccBP.exec(entId);
		
		
		GetBalanceBP getBlBP = new GetBalanceBP();
		return getBlBP.exec(entId);
	}
	/**
	 * 获取就诊账户信息
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public EnAccDTO getEnAcc(String entId) throws BizException{
		GetEnAccBP getAccBP = new GetEnAccBP();
		return getAccBP.exec(entId);
	}
	 /**
     * 规则引擎：入院登记患者信息规则
     * @author fanlq
     * @param id_pat
     * @return
     */
	@Override
	public ResultDTO ipPatRuleValidate(String id_pat) throws BizException{
		EnContextUtils.setCtxAttribute(IEnConst.KEYCTX_RULE_DEALTIPS, true);
		CheckIpRegitsRuleBP bd = new CheckIpRegitsRuleBP();
    	return bd.exec2(IEnRuleConst.EN_IP_PATQRY_RULEPKG_CONST, id_pat);
    }
	/**
	 * 规则引擎：入院登记规则
     * @author zhangpp
     * @param id_pat
     * @return
     * @throws BizException
	 */
	@Override
	public ResultDTO validateIpRule(EnHosPatDTO enHosPat, EnHosRegDTO EnHostReg) throws BizException{
		EnContextUtils.setCtxAttribute(IEnConst.KEYCTX_RULE_DEALTIPS, true);
    	return new CheckIpRegitsRuleBP().check2(enHosPat, EnHostReg);
    }
	/**
	 * 校验合并患者能否入院登记
     * @author zhangpp
     * @param idPat
     * @return
     * @throws BizException
	 */
	@Override
	public ResultDTO validateCombine(String idPat) throws BizException{
		return new ValidateCombineBP().exec(idPat);
	}
	
	/* =====================转科=========================== */
	/**
	 * 获取可申请转科的病人列表
	 * 
	 * @param nurId
	 *            病区id
	 * @return
	 * @throws BizException
	 */
	@Override
	public TransDepPatDTO[] getCanTransOutPats(String nurId) throws BizException {
		GetTransOutDepBP transDepBp = new GetTransOutDepBP();
		return transDepBp.exec(nurId);
	}
	/**
	 * 转科核查
	 * 
	 * @param transDepPats
	 * @return
	 * @throws BizException
	 */
	@Override
	public TransDepPatDTO[] transOutDepCheck(TransDepPatDTO[] transDepPats)
			throws BizException {
		OutDepCheckBP bp = new OutDepCheckBP();
		bp.exec(transDepPats);
		return transDepPats;
	}
	/**
	 * 获取转科核查明细
	 * 
	 * @param transDepPat 转科记录
	 * @param enLvDepCheckTps 核查类型：EnLvDepCheckTpEnum
	 * @return
	 */
	@Override
	public FMap getTrausOutCheckDetails(TransDepPatDTO transDepPat, String[] enLvDepCheckTps) throws BizException{
		GetTrausOutCheckDetailsBP bp = new GetTrausOutCheckDetailsBP();
		return bp.exec(transDepPat, enLvDepCheckTps);
	}
	/**
	 * 获取无转科医嘱患者的转科记录
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public TransDepPatDTO[] getNoOrTransPatsByEnt(String entId) throws BizException {
		GetNoOrTransPatsByEntBP bp = new GetNoOrTransPatsByEntBP();
		return bp.exec(entId);
	}
	/**
	 * 获取可申请转科的病人列表(不核对医嘱、药品等)
	 * @param nurId
	 * @return
	 * @throws BizException
	 */
	@Override
	public TransDepPatDTO[] getCanTransOutPatsNoCheck(String nurId) throws BizException {
		GetTransOutDepNoCheckBP bp = new GetTransOutDepNoCheckBP();
		return bp.exec(nurId);
	}
	
	/**
	 * 获取已转出未转入患者列表（撤销转出）
	 * 
	 * @param idNur
	 * @return
	 * @throws DAException
	 */
	@Override
	public TransDepPatDTO[] getTransOutFinishPats(String idNur) throws BizException {
		GetTransOutFinishBP bp = new GetTransOutFinishBP();
		return bp.exec(idNur);
	}

	/**
	 * 获取已申请转科的病人列表
	 * 
	 * @param nurId
	 *            病区id
	 * @return
	 * @throws BizException
	 */
	@Override
	public TransDepPatDTO[] getAppliedTransPats(String nurId) throws BizException {
		GetAppliedTransPatsBP getBP = new GetAppliedTransPatsBP();
		return getBP.exec(nurId);
	}

	/**
	 * 获取申请转科转入的患者列表
	 * 
	 * @param nurId
	 *            病区id
	 * @return
	 * @throws BizException
	 */
	@Override
	public TransDepPatDTO[] getTransDepAppPats(String nurId) throws BizException {
		GetTransInDepBP getTransInBP = new GetTransInDepBP();
		return getTransInBP.exec(nurId);
	}

	/**
	 * 转科医护人员查询
	 * 
	 * @param id_ent
	 * @return EnDepDTO
	 * @throws BizException
	 */
	@Override
	public EnDepDTO getEnDepInfo(String id_ent) throws BizException {
		GetTransDocInfoBP getTranDocInfoBp = new GetTransDocInfoBP();
		return getTranDocInfoBp.exec(id_ent);
	}

	/**
	 * 获取转科患者的诊断
	 * 
	 * @param id_ent
	 * @return EntDiDO 获取转科人员诊断
	 * @throws BizException
	 */
	@Override
	public EntDiDO getTransDepDi(String entId) throws BizException {
		EntDiEP enttDiBp = new EntDiEP();
		return enttDiBp.getMainDi(entId);
	}

	/**
	 * 获取转科转出病人总数
	 * 
	 * @param nurId
	 *            病区id
	 * @return
	 * @throws BizException
	 */
	@Override
	public Integer getTransOutCount(String nurId) throws BizException {
		GetTransOutCountBP getTransOutCountBP = new GetTransOutCountBP();
		return getTransOutCountBP.exec(nurId);
	}

	/**
	 * 获取转科转入病人总数
	 * 
	 * @param nurId
	 *            病区id
	 * @return
	 * @throws BizException
	 */
	@Override
	public Integer getTransInCount(String nurId) throws BizException {
		GetTransInCountBP getTransInCountBP = new GetTransInCountBP();
		return getTransInCountBP.exec(nurId);
	}

	/* =====================转科=========================== */

	/* =====================出院=========================== */
	/**
	 * 获取出院申请列表
	 * 
	 * @param nurId
	 *            病区id
	 * @return
	 * @throws BizException
	 */
	@Override
	public LvHosAppDTO[] getLvHosApps(String nurId) throws BizException {
		GetLvHosListBP getLvHosListBP = new GetLvHosListBP();
		return getLvHosListBP.exec(nurId);
	}

	/***
	 * 住院处出院 - 获取出院申请列表通过查询DTO
	 * @author fanlq 2017年12月21日
	 * @param recallQryDTO 查询方案
	 * @return
	 * @throws BizException
	 */
	@Override
	public LvHosAppDTO[] getLvHosAppsByQryDTO(HosRecallQryDTO recallQryDTO) throws BizException{
		GetLvHosListByQryDTOBP bp = new GetLvHosListByQryDTOBP();
		return bp.exec(recallQryDTO);
	}
    /**
     * 出院核查
     * 
     * @param lvAppsDtos 出院记录
     * @return
     */
	@Override
	public LvHosAppDTO[] lvHosCheck(LvHosAppDTO[] lvAppsDtos)
			throws BizException {
		LvHosCheckBP bp = new LvHosCheckBP();
		bp.exec(lvAppsDtos);
		return lvAppsDtos;
	}
	/**
     * 获取出院核查明细
     * 
     * @param lvAppsDto 出院记录
     * @param enLvDepCheckTps 核查类型：EnLvDepCheckTpEnum
     * @return
     */
	@Override
	public FMap getLvHosCheckDetails(LvHosAppDTO lvAppsDto, String[] enLvDepCheckTps) throws BizException{
		GetLvHosCheckDetailsBP bp = new GetLvHosCheckDetailsBP();
		return bp.exec(lvAppsDto, enLvDepCheckTps);
	}
	
	/**
	 * 通过idEnts获取LvHosAppDTO（查询所有，不区分是否待出院）
	 * @author lilei
	 * @date 2019年12月24日
	 */
	@Override
	public LvHosAppDTO[] getLvHosAppAllEnt(String[] idEnts) throws BizException{
		GetLvHosDTOArrayBP bp = new GetLvHosDTOArrayBP();
		return bp.getLvHosAppsAllEnt(idEnts);
	}
	/**
	 * 获取待出院病人总数
	 * 
	 * @param nurId
	 *            病区id
	 * @return
	 * @throws BizException
	 */
	@Override
	public Integer getLvHosAppCount(String nurId) throws BizException {
		GetTransOutCountBP getTransOuntCountBP = new GetTransOutCountBP();
		return getTransOuntCountBP.exec(nurId);
	}

	/* =====================出院=========================== */

	/* =====================出院召回=========================== */
	/**
	 * 查询出院记录
	 * 
	 * @param querySchema
	 *            查询模板
	 * @return
	 */
	@Override
	public HosRecallDTO[] getLeaveHosDTOs(QryRootNodeDTO querySchema) throws BizException {
		GetLvDtoForRecallBP recallBP = new GetLvDtoForRecallBP();
		return recallBP.exec(querySchema);
	}
	/**
	 * 出院召回（分页查询）-zhangpp 2018.12.6
	 * @param querySchema
     * @param pageInfo
     * @return
     * @throws BizException
	 */
	@Override
	public PagingRtnData<HosRecallDTO> getPageLeaveHosDTOs(QryRootNodeDTO queryNode, PaginationInfo pageInfo)
			throws BizException {
		GetLvDtoForRecallBP recallBP = new GetLvDtoForRecallBP();
		return recallBP.exec(queryNode,pageInfo);
	}
	

	/* =====================出院召回=========================== */
	/**
	 * 住院处出院召回-查询出院记录
	 * @author fanlq
	 * @param recallQryDTO
	 *            查询dto
	 * @return
	 */
	@Override
	public HosRecallDTO[] getLeaveHosDTOByQryDTOs(HosRecallQryDTO recallQryDTO) throws BizException {
		GetLvDtoForRecallByQryDTOBP recallBP = new GetLvDtoForRecallByQryDTOBP();
		return recallBP.exec(recallQryDTO);
	}

	/**
	 * 获取可退院列表
	 * 
	 * @param patId
	 *            患者id
	 * @throws BizException
	 *             异常
	 * @return
	 */
	@Override
	public DischargeDTO[] getDischarge(String patId) throws BizException {
		GetDisChargeBP dischargeBP = new GetDisChargeBP();
		return dischargeBP.exec(patId);
	}

	/**
	 * 获取病区的护士id集合
	 * 
	 * @param depId
	 *            病区id
	 * @return
	 * @throws BizException
	 */
	@Override
	public String[] getNurseIds(String depId) throws BizException {
		EmpQryBP qryBP = new EmpQryBP();
		return qryBP.getNurseIds(depId);
	}

	/**
	 * 根据业务线，查询病区的科室集合 业务线暂时没有，临时放在这里，后续迁移
	 * 
	 * @param depId
	 *            科室或病区id
	 * @return
	 * @throws BizException
	 */
	@Override
	public DeptDO[] getDepListByDepl(String depId, String deplrole) throws BizException {
		GetDepListByDepLineBP getBP = new GetDepListByDepLineBP();
		return getBP.exec(depId, deplrole);
	}

	/* =====================床位大卡============================== */
	/**
	 * 查询床位列表
	 * 
	 * @param qryMod
	 *            查询模板
	 * @return
	 * @throws BizException
	 */
	@Override
	public BedBigCardDTO[] getBedList(BedQryModDTO qryMod) throws BizException {
		GetBedBP getBedBP = new GetBedBP();
		return getBedBP.exec(qryMod);
	}
	/**
	 * 获取床位卡详细信息
	 * @param entId 就诊ID
	 * @return 床位卡详细信息
	 * @throws BizException
	 * @author renying
	 */
	@Override
	public BedCardDetailDTO getBedCardDetail(String entId, String idBltpl) throws BizException{
		GetBedCardDetailBP getDetailBP = new GetBedCardDetailBP();
		return getDetailBP.exec(entId, idBltpl);
	}
	/**
	 * 获取包床的就诊信息
	 * 
	 * @param entId
	 *            就诊ID
	 * @return 包床信息DTO
	 * @throws BizException
	 */
	@Override
	public EntInfo4RentDTO getEntInfo4Rent(String entId) throws BizException {
		GetEntInfo4RentBP getEntBP = new GetEntInfo4RentBP();
		return getEntBP.exec(entId);
	}

	/**
	 * 获取包床列表
	 * 
	 * @param entId
	 *            就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnBedDO[] getRentedBedList(String entId) throws BizException {
		EntBedEP enBedEP = new EntBedEP();
		return enBedEP.getRentingBedList(entId);
	}

	/**
	 * 获取床位使用记录
	 * 
	 * @param entId
	 *            就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnBedDO[] getUsedBedList(String entId) throws BizException {
		EntBedEP enBedEP = new EntBedEP();
		return enBedEP.getUsedBedList(entId);
	}

	/* =====================住院医生站患者列表============================== */

	/**
	 * 查询住院医生站患者列表信息
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 */
	@Override
	public FMap getIpPatients(FMap map) throws BizException {
		GetIpPatientsBP bp = new GetIpPatientsBP();
		return bp.exec(map);
	}

	/**
	 * 查询住院信息
	 * 
	 * @param qryModDTO
	 *            查询模型
	 * @return 就诊DO集合
	 * @throws BizException
	 */
	@Override
	public OutpatientQryDTO[] getIpList(EntQryModDTO qryModDTO) throws BizException {
		GetIpDOListBP getBP = new GetIpDOListBP();
		return getBP.exec(qryModDTO);
	}
	/***
	 * 住院就诊查询-获取住院信息集合-（分页）-fanlq-2018-10-30
	 * @param qryModDTO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<OutpatientQryDTO> getIpListPage(EntQryModDTO qryModDTO, PaginationInfo pg) throws BizException{
		GetIpDOListBP getBP = new GetIpDOListBP();
		return getBP.exec(qryModDTO,pg);
	}	
	/**
	 * 获取就诊患者所属类别
	 * 
	 * @param entId
	 *            就诊id
	 * @param depId
	 *            科室id
	 * @param empId
	 *            医生id
	 * @return 返回枚举值EntPatListTp
	 * @throws BizException
	 */
	@Override
	public String getEntPatTp(String entId, String depId, String empId) throws BizException {
		GetEntPatTpBP getBP = new GetEntPatTpBP();
		return getBP.exec(entId, depId, empId);
	}

	/**
	 * 获取账户操作明细
	 * 
	 * @param qryRootNodeDTO
	 *            查询方案
	 * @param pg
	 *            分页信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<EntAccActDO> getEntAccActByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo pg) throws BizException {
		return null;
	}

	/**
	 * 获取护士管理的住院患者信息
	 * 
	 * @param wardId
	 *            病区ID
	 * @param nursId
	 *            护士ID
	 * @return 住院基本信息
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public IpBasicDTO[] getIpListByNurs(String wardId, String nursId) throws BizException {
		return new GetIpListInfoBP().getIpListByCond(new CardPrintByNurBP().getSqlCond(wardId,
				nursId));
	}

	/**
	 * 获取病区的住院患者信息
	 * 
	 * @param wardId
	 *            病区ID
	 * @return 住院基本信息
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public IpBasicDTO[] getIpListByWard(String wardId) throws BizException {
		return new GetIpListInfoBP().getIpListByCond(new CardPrintByWardBP().getSqlCond(wardId));
	}

	/**
	 * 获取病区科室的住院患者信息
	 * 
	 * @param wardId
	 *            病区ID
	 * @param depId
	 *            科室ID
	 * @return 住院基本信息
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public IpBasicDTO[] getIpListByDep(String wardId, String depId) throws BizException {
		return new GetIpListInfoBP().getIpListByCond(new CardPrintByDeptBP().getSqlCond(wardId,
				depId));
	}

	/**
	 * 获取病区新入院患者信息
	 * 
	 * @param wardId
	 *            病区ID
	 * @return 住院基本信息
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public IpBasicDTO[] getNewIpList(String wardId) throws BizException {
		return new GetIpListInfoBP().getIpListByCond(new CardPrintByDayBP().getSqlCond(wardId));
	}

	/**
	 * 获取患者的新生儿记录
	 * 
	 * @param momEntId
	 *            母亲就诊ID
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Override
	public NewbornDTO[] getNbListByMomEnt(String momEntId) throws BizException {
		GetNewborninfoBP bp = new GetNewborninfoBP();
		return bp.exec(momEntId);
	}
	/**
	 * 患者是否在院
	 * @param patId 患者ID
	 * @return FBoolean类型
	 * @throws BizException
	 * @author renying
	 */
	@Override
	public FBoolean isPatInHos(String patId) throws BizException{
		return FBoolean.FALSE;
	}
	
	/**
	 * 根据病区id 查询该病区内所有患者得收费模式信息
	 * 收费模式 sd_dcg_mode=0表示继承科室模式 sdsd_dcg_mode=1表示患者专有模式
	 ** @param wardId 患者所在病区id
	 * @return 就诊信息
	 * @throws BizException
	 * @author liwq
	 */
	@Override
	public PatiFixedFeeLeftDTO[] getPatiFixedFeeModeInfo(String wardId,String dicKey ,String cond) throws BizException {
		GetFixedFeeInfoBP fixedMode = new GetFixedFeeInfoBP();
		return fixedMode.getFixedFeeModeInfo(wardId,dicKey,cond);
	}

	/**
	 * 根据患者就诊Id 和收费模式  查询固定费用信息
	 * 收费模式 sd_dcg_mode=0表示继承科室模式 sdsd_dcg_mode=1表示患者专有模式
	 * @param idEnt 患者就诊id  isMode 收费模式
	 * @return 固定费用明细
	 * @throws BizException
	 * @author liwq
	 */
	public EnFixedFeeItemDO[] getFixedFeeInfo(String idEnt, FBoolean isMode,String idDepNur) throws BizException{
		GetFixedFeeInfoBP fixedMode = new GetFixedFeeInfoBP();
		return fixedMode.getFixedFeeItmInfo(idEnt,isMode,idDepNur);
	}
	
	/**
	 * 根据患者就诊id  将科室固定费用改为患者固定费用模式
	 * @param idEnt
	 * @return FBoolean
	 * @author liwq
	 * @throws BizException
	 */
	public String changedPatiFixedFee(String idEnt,String idDepNur) throws BizException {
		GetFixedFeeInfoBP fixedMode = new GetFixedFeeInfoBP();
		return fixedMode.changedPati(idEnt,idDepNur);
	}
	
	/**
	 * 根据患者就诊id  将科室固定费用改为患者固定费用模式
	 * @param idEnt
	 * @return FBoolean
	 * @author liwq
	 * @throws BizException
	 */
	public String changedDepFixedFee(String idEnt) throws BizException {
		GetFixedFeeInfoBP fixedMode = new GetFixedFeeInfoBP();
		return fixedMode.changedDep(idEnt);
	}
	
	/**
	 * 根据服务id_srv 判断是否是物品
	 * @param id_srv
	 * @return FBoolean
	 * @author liwq
	 * @throws BizException
	 */
	public FBoolean isSrvOrMm(String id_srv) throws BizException {
		GetFixedFeeInfoBP fixedMode = new GetFixedFeeInfoBP();
		return fixedMode.isSrvOrMm(id_srv);
	}
	
	/**
	 *  返回服务id和单位名称
	 * @param 
	 * @return EnFixedFeeItemDO[]
	 * @author liwq
	 * @throws BizException
	 */
	public EnFixedFeeItemDO[] returnSrvUnitMap() throws BizException {
		GetFixedFeeInfoBP fixedMode = new GetFixedFeeInfoBP();
		return fixedMode.returnSrvUnitMap();
	}
	/**
	 * 是否是产科
	 * 根据产科业务线判定
	 * @param deptId 科室ID
	 * @return 
	 * @throws BizException
	 */
	@Override
	public FBoolean isObsDept(String deptId) throws BizException{
		CheckIsObsDeptBP checkBP = new CheckIsObsDeptBP();
		return checkBP.exec(deptId);
	}
	/**
	 * 获取匹配的新生儿记录
	 * @param birthDate 出生日期
	 * @param sd_sex 性别
	 * @param momName 母亲姓名
	 * @return
	 * @throws BizException
	 */
	@Override
	public PatiAggDO[] getMatchNb(FDate birthDate,String sd_sex,String momName) throws BizException{
		GetMatchNbBP matchBP = new GetMatchNbBP();
		return matchBP.exec(birthDate, sd_sex, momName);
	}
	/**
	 * 查询住院登记信息
	 * @param qrySchm 查询模板
	 * @return
	 * @throws BizException
	 * @author renying
	 */
	@Override
	public PagingRtnData<IpRegInfoDTO> getIpRegList(IpRegQrySchmDTO qrySchm, PaginationInfo pageInfo) throws BizException{
		GetIpRegListBP getBP = new GetIpRegListBP();
		return getBP.exec(qrySchm,pageInfo);
	}
	/**
	 * 查询住院出院信息列表信息
	 * @param qrySchm 查询模板
	 * @return
	 * @throws BizException
	 * @author renying
	 */
	@Override
	public PagingRtnData<IpRegInfoDTO> getIpLeaveList(IpRegQrySchmDTO qrySchm, PaginationInfo pageInfo) throws BizException{
		GetIpLeaveListBp getBP = new GetIpLeaveListBp();
		return getBP.exec(qrySchm,pageInfo);
	}
	/**
	 * 查询住院出科列表信息信息
	 * @param qrySchm 查询模板
	 * @return
	 * @throws BizException
	 * @author renying
	 */
	@Override
	public PagingRtnData<IpRegInfoDTO> getIpOutDeptList(IpRegQrySchmDTO qrySchm, PaginationInfo pageInfo)throws BizException {
		GetIpOutDeptListBP bp = new GetIpOutDeptListBP();
		return bp.exec(qrySchm, pageInfo);
	}
	/**
	 * 住院诊断查询   zhangpp-2018-11-24
	 * @param qrySchm
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<IpRegInfoDTO> getIpDiQryList(IpRegQrySchmDTO qrySchm, PaginationInfo pageInfo)throws BizException {
		GetIpDiQryListBP bp = new GetIpDiQryListBP();
		return bp.exec(qrySchm, pageInfo);
	}
	/**
	 * 保存登记前的验证
	 * 
	 * @param patDTO
	 * @param enHosRegDTO
	 * @param isReg 是否含患者注册功能
	 * @throws BizException
	 */
	public void validateHosInfo(EnHosPatDTO patDTO, EnHosRegDTO enHosRegDTO, FBoolean isReg) throws BizException {
		ValidateIPDataBP vbp = new ValidateIPDataBP();
		vbp.exec(patDTO, enHosRegDTO, isReg);
	}
	
	/**
	 * 退号前校验
	 * @param dischargeDTO
	 * @throws BizException
	 */
	public void validateCanRegInfo(EnHosRegDTO enHosRegDTO)throws BizException{
		CancelRegisterBP cancelBP = new CancelRegisterBP();
		cancelBP.exec(enHosRegDTO);
	}
	
	/**
	 * 退院前校验
	 * @param dischargeDTO
	 * @throws BizException 
	 */
	public void validateDischargeInfo(DischargeDTO dischargeDTO) throws BizException{
		ValidateDischargeInfoBP vb = new ValidateDischargeInfoBP();
		vb.exec(dischargeDTO);
	}
    /**
     * 创建新的交班记录
     * 
     * @param depId 科室id
     * @param date 日期
     * @param enumdayslot 白班/夜班
     * @return
     * @throws BizException
     */
	@Override
	public ShiftturnoverAggDO createNewTurnOverInfo(String depId, FDate date,
			String enumdayslot) throws BizException {
		CreateNewTurnOverInfoBP bp = new CreateNewTurnOverInfoBP();
		return bp.exec(depId, date, enumdayslot);
	}	
	
    /**
     * 查询团检单位信息
     * @param qryDTO
     * @return
     * @throws BizException
     */
    public EnPeCmpyDTO[] getEnPeCmpyInfo(EnPeCmpyDTO qryDTO)throws BizException{
        GetEnPeComyInfoBP bp = new GetEnPeComyInfoBP();
        return bp.exec(qryDTO);
    }
    
    /**
     * 查询团检单位信息 分页
     * @param qryDto
     * @param pageInfo
     * @return
     * @throws BizException
     */
    public PagingRtnData<EnPeCmpyDTO> getEnPeCmpyPageInfo(EnPeCmpyDTO qryDto, PaginationInfo pageInfo) throws BizException {
        GetEnPeComyInfoBP bp = new GetEnPeComyInfoBP();
        return bp.pageexec(qryDto,pageInfo);
    }   
    
    
    /**
     * 查询团检单位患者信息
     * @param pecmpyId
     * @return
     * @throws BizException
     */
    public EnPePatInfoDTO[] getEnPePatInfos(String pecmpyId)throws BizException{
        GetEnPePatInfosBP bp = new GetEnPePatInfosBP();
        return  bp.exec(pecmpyId);
    }
    
    /**
     * 查询团检单位患者信息 分页
     * @param pecmyId
     * @param pageInfo
     * @return
     * @throws BizException
     */
    public PagingRtnData<EnPePatInfoDTO> getEnPePatPageInfo(String pecmpyId,PaginationInfo pageInfo) throws BizException{
        GetEnPePatInfosBP bp = new GetEnPePatInfosBP();
        return bp.pageexec(pecmpyId, pageInfo);
    }
    
    /**
     * 查询未关联单位患者信息
     * @param pecmpyId
     * @return
     * @throws BizException
     */
    public EnPePatInfoDTO[] getNoCmpyPatInfos(String pecmpyId)throws BizException{
        GetEnPePatInfosBP bp = new GetEnPePatInfosBP();
        return  bp.exec(pecmpyId);
    }

    /**
     * 查询住院信息
     */
    public IpBasicDTO[] getIpBasicDTOs(EnPeCmpyDTO qryDTO) throws BizException {
        GetIpBasicDTOBP bp = new GetIpBasicDTOBP();
        return bp.exec(qryDTO);
    }
	/**
     * 获取患者住院登记医保信息
     * （医保转换）使用
     * @param entId
     * @return
     * @throws BizException
     */
	@Override
	public IpHpRegistDTO getIpHpRegist(String entId) throws BizException {
		GetIpHpRegistBP bp = new GetIpHpRegistBP();
		return bp.exec(entId);
	}
	/**
     * 获取患者住院登记医保信息--通过患者id
     * （医保转换异常处理）使用
     * @param patId 患者id
     * @return
     * @throws BizException
     */
	@Override
	public IpHpRegistDTO getIpHpRegistByPat(String patId) throws BizException {
		GetIpHpRegistBP bp = new GetIpHpRegistBP();
		return bp.exec2(patId);
	}
    /**
     * 获取就诊Id
     * @param pecmpyId
     * @return
     * @throws BizException
     */
    public EnPeCmpyItmDO[] getEnPeCmpyItmDOS(String Idpecmpy) throws BizException {
        GetEntid bp = new GetEntid();
        return bp.getEnPeCmpyItmDOS(Idpecmpy);
    }
    
    /**
     * 获取住院基本信息
     * 
     * @param entIds 就诊id
     * @return
     * @throws BizException
     */
    @Override
    public IpBasicDTO[] getIpBasicInfos(String idpecmpy) throws BizException {
        GetIpBasicInfosBP bp = new GetIpBasicInfosBP();
        return bp.exec(idpecmpy);
    }     

    /**
     * 根据查询卡条件 
     * 查询出院患者信息
     * @return
     * @throws BizException
     */
    @Override
    public PagingRtnData<IpRegInfoDTO> getIpRegInfos(IpRegInfoDTO qryDto, PaginationInfo pageInfo) throws BizException {
        GetIpRegInfoBP bp = new GetIpRegInfoBP();
        return bp.exec(qryDto,pageInfo);
    }

    /**
     * 患者授权查询
     * @return
     * @throws BizException
     */
    @Override
    public PagingRtnData<EnAuthListDTO> getEnAuthList(EnAuthQryDTO qryDto, PaginationInfo pageInfo) throws BizException {
        GetEnAuthBP bp = new GetEnAuthBP();
        return bp.exec(qryDto,pageInfo);
    }
    
    /**
	 * 根据人员id查询人员
	 * @author lilei
	 * @param id_psndoc
	 * @throws BizException
	 */
	@Override
	public PsnDocDO getPsnById(String id_psndoc) throws BizException {
		PsnDocEP ep = new PsnDocEP();
		return ep.getPsnById(id_psndoc);
	}
	
	/**
	 * 根据患者id获取患者真实头像
	 * @param patId
	 * @throws BizException
	 */
	@Override
	public PatDO getImageByPatId(String patId) throws BizException {
		GetImageByPatIdBP bp = new GetImageByPatIdBP();
		return bp.getImageByPatId(patId);
	}

	/**
	 * 查打印腕带的方式
	 */
	@Override
	public String getPrintWristCardType(String idEnt, String funCode) throws BizException {
		GetPrintWristCardTypeBp bp = new GetPrintWristCardTypeBp();
		return bp.getPrintWristCardType(idEnt, funCode);
	}
	
	/**
	 * @see iih.en.pv.i.IEnIpQryService#getMsgInfoCardDTOs(java.lang.String)  
	 * @Description: 获得护士站下的快捷入口的卡信息
	 * @param nurId
	 * @return
	 * @throws BizException
	 * @author: lilei
	 * @date: 2018年9月17日 下午5:23:22 
	*/
	@Override
	public MsgInfoCardDTO[] getMsgInfoCardDTOs(String nurId, String code_entp) throws BizException {
		GetMsgInfoCardDTOBp bp =new GetMsgInfoCardDTOBp();
		return bp.exec(nurId, code_entp);
	}
	/**
	 * 根据医保获取医疗付费方式
	 * 
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
	@Override
	public UdidocDO getPayMethodByHp(EnHpPatCaInParamsDTO inParam)
			throws BizException {
		return EnIpCustomServiceUtils.getPayMethodByHp(inParam);
	}
	
	/**
	 * 根据打印模板项目配置信息查询 打印模板
	 * @author lilei
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScPrtTmplDTO getScPrtTmplDTO(PrtQry4EnDTO qryDTO) throws BizException{
		GetScPrtTmplBp bp = new GetScPrtTmplBp();
		return bp.exec(qryDTO);
	}
	
	/**
     * 查询预住院入院登记患者信息
     * @param str
     * @return
     * @throws BizException
     */
	@Override
	public PagingRtnData<EnIppreInfoDTO> getIpPrePatList(String id_dep, PaginationInfo pageInfo) throws BizException {
		return new GetIpPrePatListBP().exec(id_dep,pageInfo);
	}
	/**
	 * 查询入科患者列表
	 * @throws BizException 
	 */
	@Override
	public PagingRtnData<EnIppreInfoDTO> getIpPreDepEnter(String id_dep, PaginationInfo pageInfo) throws BizException {
		GetEnDepBP bp = new GetEnDepBP();
		return bp.exec(id_dep, pageInfo);
	}

	/**
     * 查询预住院在院患者信息
     * @param str
     * @return
     * @throws BizException
     */
	@Override
	public EnIppreInfoDTO[] getIppreConterList(String str) throws BizException {
		return new GetIppreConterListBP().exec(str);
	}
	/**
     * 查询预住院转住院患者信息
     * @param entId
     * @return
     * @throws BizException
     */
	@Override
	public EnIppreTransHosDTO getIppreTransHos(String entId) throws BizException {
		return new GetIppreTransHosBP().exec(entId);
	}
	/**
	 * 根据人员数组 查询入院患者列表
	 * @author liwm
	 * @param entIds
	 * @throws BizException
	 */

	@Override
	public EnIppreInfoDTO[] getAcceptEnippreList(EnIppreDO enippre) throws BizException {
		GetAcceptEnippreListBp bp = new GetAcceptEnippreListBp();
		return bp.exec(enippre);

	}
	
	/**
	 * 查询出院患者列表
	 */
	@Override
	public PagingRtnData<EnIppreInfoDTO> getIpLvHos(String id_dep, PaginationInfo pageInfo) throws BizException {
		GetIpLvHosBP bp = new GetIpLvHosBP();
		return bp.exec(id_dep, pageInfo);
	}
	
	/**
     * 查询中止住院患者信息
     * @param str
     * @return
     * @throws BizException
     */
	@Override
	public PagingRtnData<EnIppreInfoDTO> getSuspendHosPatList(String id_dep, PaginationInfo pageInfo) throws BizException {
		return new GetSuspendHosPatListBP().exec(id_dep,pageInfo);
	}
	
	/**
     * 查询患者中止住院检查信息
     * @param str
     * @return
     * @throws BizException
     */
	@Override
	public EnIppreInfoDTO[] getIpprePatSuspendHosCheckInfo(EnIppreInfoDTO[] ippreDtos) throws BizException {
		return new IppreLvHosCheckBP().exec(ippreDtos);
	}
	
	/**
     * 查询预住院患者信息(总入口)
     * @param entId
     * @return
     * @throws BizException
     */
	@Override
	public PagingRtnData<EnIppreInfoDTO>  getIpprePatInfoList(FMap map,PaginationInfo pageInfo) throws BizException{
		return new GetIpprePatientsBP().exec(map,pageInfo);
	}
	/**
	 * 根据病区获取预住院病区申请入科列表 
	 * 
	 * @param nurId
	 *            当前登录病区
	 * @return EnDepDTO[] 当前病区待入科的患者列表
	 * @throws BizException
	 */
	@Override
	public EnDepDTO[] getIppreEnDepList(String nurId,String id_ent) throws BizException {
		return new GetIppreEnDeptInfoBP().exec(nurId,id_ent);
	}
	/**
	 * 查询预住院转住院检查信息
	 */
	@Override
	public EnIppreInfoDTO getIppreTransHosCheck(EnIppreInfoDTO ippreInfoDto) throws BizException {
		return new GetIppreTransHosCheckBP().exec(ippreInfoDto);
	}
	
	/**
	 * 预住院查询节点
	 */
	@Override
	public PagingRtnData<EnIppreInfoDTO> ippreQryPatInfo(IppreQryConditionsDTO qrydto, PaginationInfo pageInfo)
			throws BizException {
			GetIppreQryPatInfoBP bp = new GetIppreQryPatInfoBP();
			return 	bp.exec(qrydto, pageInfo);
	}
	/**
	 * 校验是否有费用转到门诊 
	 * @param idEnt
	 * @param isOep
	 * @return FBoolean
	 * @throws BizException
	 */
	@Override
	public FBoolean isPreIpTrans(String idEnt, FBoolean isOep) throws BizException {
		return new GetIppreTransHosCheckBP().isPreIpTrans(idEnt, isOep);
	}
}
