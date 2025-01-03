package iih.bl.cg.s.cglogic.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.bddepcg.d.BdDepCgDO;
import iih.bd.pp.dto.prisrvcompratio.d.BdPriSrvCompRatioDTO;
import iih.bd.pp.i.IBdPpQryService;
import iih.bd.pp.i.IBdPriCalService;
import iih.bd.pp.i.external.provide.IBdPpBlQryService;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.dto.cglogic.d.BlCgAccountBizDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgApplyDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.OepCgModeEnum;
import iih.bl.cg.s.cglogic.other.BlCgAccDataWarehouse;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.comm.IBlConst;
import iih.bl.comm.IBlImplicitParamKeyConst;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blauditip.d.desc.BlAuditIpDesc;
import iih.bl.st.blauditip.i.IBlauditipMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.d.EnPeCmpyACCDO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.enfee.i.IEnaccountMDORService;
import iih.en.pv.enfee.i.IEnpecmpyaccRService;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.out.i.IEn4BlQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mi.bd.d.ThreeDirCompInfoDTO;
import iih.mi.bd.i.IMiBdDirCompQryService;
import iih.pe.papt.pepsnappt.d.PePsnApptDO;
import iih.pe.papt.pepsnappt.i.IPepsnapptRService;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IAccountMDORService;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.d.FTypeManager;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 记账数据处理工具类
 * @author ly 2018/06/25
 * @version ly 2018/11/29 加入流程上下文数据处理
 *
 */
public class BlCgDataUtil {

	//患者表检索列
	private static String[] PI_PAT_FIELD;
	//就诊表检索列
	private static String[] EN_ENT_FIELD;
	//医嘱表检索列
	private static String[] CI_ORDER_FIELD;
	//医嘱服务表检索列
	private static String[] CI_OR_SRV_FIELD;
	//医嘱服务物品表检索列
	private static String[] CI_OR_SRV_MM_FIELD;
	//医疗服务表检索列
	private static String[] BD_SRV_FIELD;
	//医疗物品表检索列
	private static String[] BD_MM_FIELD;
	
	static{

		PI_PAT_FIELD = new String[] { PatDO.ID_PAT, PatDO.CODE, PatDO.NAME, PatDO.ID_PATPRITP };
		
		EN_ENT_FIELD = new String[] { PatiVisitDO.ID_ENT, PatiVisitDO.ID_PAT, PatiVisitDO.ID_PATCA,
				PatiVisitDO.ID_ENTP,PatiVisitDO.CODE_ENTP, PatiVisitDO.NAME_PAT, 
				PatiVisitDO.ID_PRIPAT, PatiVisitDO.ID_DEP_PHY,PatiVisitDO.ID_EMP_PHY, 
				PatiVisitDO.ID_DEP_NUR, PatiVisitDO.FG_ST };
		
		CI_ORDER_FIELD = new String[] { CiOrderDO.ID_OR, CiOrderDO.ID_ORG_OR,
				CiOrderDO.ID_EN, CiOrderDO.ID_PAT, CiOrderDO.DT_ENTRY, CiOrderDO.ID_SRV,
				CiOrderDO.ID_DEP_OR, CiOrderDO.ID_EMP_OR, CiOrderDO.ID_WG_OR,
				CiOrderDO.ID_DEP_NUR_OR, CiOrderDO.APPLYNO, CiOrderDO.FG_PRES_OUTP,CiOrderDO.SD_SRVTP };
		
		CI_OR_SRV_FIELD = new String[] { OrdSrvDO.ID_ORSRV, OrdSrvDO.ID_OR, OrdSrvDO.ID_EN,
				OrdSrvDO.ID_PRES, OrdSrvDO.ID_ORG_MP, OrdSrvDO.ID_DEP_MP, OrdSrvDO.ID_SRV, OrdSrvDO.SD_SRVTP,
				OrdSrvDO.ID_DEP_WH, OrdSrvDO.DT_CREATE, OrdSrvDO.SD_SU_BL,
				OrdSrvDO.PRI, OrdSrvDO.PRI_STD, OrdSrvDO.PRI_RATIO, 
				OrdSrvDO.ID_MEDU, OrdSrvDO.QUAN_MEDU, OrdSrvDO.QUAN_TOTAL_MEDU,
				OrdSrvDO.FG_MM, OrdSrvDO.FG_RESEARCH, OrdSrvDO.ID_RESEARCHPROJECT,// OrdSrvDO.FG_PAY_UNIT,
				OrdSrvDO.FG_BL, OrdSrvDO.FG_OR, OrdSrvDO.FG_SELFPAY };
		
		CI_OR_SRV_MM_FIELD = new String[] { OrdSrvMmDO.ID_ORSRVMM, OrdSrvMmDO.ID_ORSRV, 
				OrdSrvMmDO.ID_MM, OrdSrvMmDO.ID_MMTP, OrdSrvMmDO.SD_MMTP, 
				OrdSrvMmDO.CODE_MM, OrdSrvMmDO.NAME_MM, 
				OrdSrvMmDO.ID_PGKU_CUR, OrdSrvMmDO.ID_PGKU_BASE, OrdSrvMmDO.FACTOR };
		
		BD_SRV_FIELD = new String[] { MedSrvDO.ID_SRV, MedSrvDO.ID_SRVTP,
				MedSrvDO.SD_SRVTP, MedSrvDO.ID_SRVCA, MedSrvDO.CODE,
				MedSrvDO.NAME, MedSrvDO.ID_UNIT_MED, MedSrvDO.EU_BLMD };
		
		BD_MM_FIELD = new String[] { MeterialDO.ID_MM, MeterialDO.ID_SRV,
				MeterialDO.ID_MMTP, MeterialDO.SD_MMTP, MeterialDO.CODE,
				MeterialDO.NAME, MeterialDO.SPEC, MeterialDO.ID_UNIT_PKGBASE };
	}
	
	/**
	 * 转换入参记账数据为业务处理数据
	 * @param accDto
	 * @return
	 */
	public static BlCgAccountBizDTO convertToBizDTO(BlCgAccountDTO accDto) {
		BlCgAccountBizDTO bizDto = new BlCgAccountBizDTO();
		bizDto.setId_ent(accDto.getId_ent());
		bizDto.setId_pat(accDto.getId_pat());
		bizDto.setId_or(accDto.getId_or());
		bizDto.setId_orsrv(accDto.getId_orsrv());
		bizDto.setId_srv(accDto.getId_srv());
		bizDto.setId_or_pr(accDto.getId_or_pr());
		bizDto.setId_or_prsrv(accDto.getId_or_prsrv());
		bizDto.setId_mm(accDto.getId_mm());
		bizDto.setFg_mm(accDto.getFg_mm());
		bizDto.setId_unit_srv(accDto.getId_unit_srv());
		bizDto.setId_pkgu_cur(accDto.getId_pkgu_cur());
		bizDto.setQuan(accDto.getQuan());
		bizDto.setPrice_std(accDto.getPrice_std());
		bizDto.setPrice_ratio(accDto.getPrice_ratio());
		bizDto.setRatio_pripat(accDto.getRatio_pripat());
		bizDto.setOnly_code(accDto.getOnly_code());
		bizDto.setBatch(accDto.getBatch());
		bizDto.setEu_direct(accDto.getEu_direct());
		bizDto.setId_dep_or(accDto.getId_dep_or());
		bizDto.setId_emp_or(accDto.getId_emp_or());
		bizDto.setId_dep_mp(accDto.getId_dep_mp());
		bizDto.setId_dep_wh(accDto.getId_dep_wh());
		bizDto.setFg_addfee(accDto.getFg_addfee() == null ? FBoolean.FALSE : accDto.getFg_addfee() );
		bizDto.setId_entbed((String)accDto.getAttrVal(IBlImplicitParamKeyConst.BL_ID_ENTBED));
		bizDto.setId_entdcg((String)accDto.getAttrVal(IBlImplicitParamKeyConst.BL_ID_ENTDCG));
		bizDto.setPecode((String)accDto.getAttrVal(IBlImplicitParamKeyConst.BL_PECODE));
		bizDto.setDt_cg_detail(accDto.getDt_cg_detail());
		bizDto.setId_emp_cg_detail(accDto.getId_emp_cg_detail());
		bizDto.setId_dep_cg_detail(accDto.getId_dep_cg_detail());
		bizDto.setId_pripat(accDto.getId_pripat());
		bizDto.setNote(accDto.getNote());
		if(accDto.getFg_free() != null){
			bizDto.setFg_free(accDto.getFg_free());
		}else{
			bizDto.setFg_free(FBoolean.FALSE);
		}
		if (StringUtils.isNotEmpty(accDto.getId_hp())) {
			bizDto.setId_hp(accDto.getId_hp());
		}
		return bizDto;
	}
	
	/**
	 * 获取患者数据
	 * @param patIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static List<PatDO> getPatData(String[] patIds) throws BizException{
		DAFacade daf = new DAFacade();
		List<PatDO> rlt = (List<PatDO>) daf.findByPKs(PatDO.class, patIds, PI_PAT_FIELD);
		return rlt;
	}
	
	/**
	 * 获取就诊数据
	 * @param entIds
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<PatiVisitDO> getEnData(String[] entIds) throws BizException{
		
		/*List<PatiVisitDO> contextEntList = (List<PatiVisitDO>)Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_EN_ENT);
		if(!ListUtil.isEmpty(contextEntList)){
			return contextEntList;
		}*/
		
		DAFacade daf = new DAFacade();
		List<PatiVisitDO> rlt = (List<PatiVisitDO>)daf.findByPKs(PatiVisitDO.class, entIds, EN_ENT_FIELD);
		return rlt;
	}
	
	/**
	 * 获取就诊医保数据
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static List<EntHpDO> getEnHpData(String[] entIds) throws BizException{
		DAFacade daf = new DAFacade();
		List<EntHpDO> rlt = (List<EntHpDO>) daf.findByAttrValStrings(EntHpDO.class, EntHpDO.ID_ENT, entIds, null);
		if (ListUtil.isEmpty(rlt))
			return rlt;

		List<EntHpDO> list = new ArrayList<EntHpDO>();
		for (EntHpDO entHpDO : rlt) {
			if (FBoolean.TRUE.equals(entHpDO.getFg_maj())) {
				list.add(entHpDO);
			}
		}

		return list;
	}
	
	/**
	 * 获取新生儿数据
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static List<NewbornDO> getNbData(String[] entIds) throws BizException{
		DAFacade daf = new DAFacade();
		List<NewbornDO> rlt = (List<NewbornDO>)daf.findByAttrValStrings(NewbornDO.class, NewbornDO.ID_ENT_BB, entIds, null);
		if(ListUtil.isEmpty(rlt))
			return rlt;
		
		//过滤无母亲数据
		List<NewbornDO> effeList = new ArrayList<NewbornDO>();
		for (NewbornDO newbornDO : rlt) {
			if(StringUtil.isEmpty(newbornDO.getId_ent_mom()))
				continue;
			effeList.add(newbornDO);
		}
		
		return effeList;
	}
	
	/**
	 * 患者账户信息
	 * @param patIds
	 * @return
	 * @throws BizException
	 */
	public static List<PiPatAccDO> getPatAccData(String[] patIds) throws BizException{
		IAccountMDORService rService = ServiceFinder.find(IAccountMDORService.class);
		PiPatAccDO[] dos = rService.findByAttrValStrings(PiPatAccDO.ID_PAT, patIds);
		if(ArrayUtil.isEmpty(dos))
			return null;
		
		List<PiPatAccDO> patAccList = new ArrayList<PiPatAccDO>();
		patAccList.addAll(Arrays.asList(dos));
		return patAccList;
	}
	
	/**
	 * 患者账户余额信息
	 * @param patIds
	 * @return
	 * @throws BizException
	 */
	public static List<PatRelAmountInfoDTO> getPatBalanceData(String[] patIds) throws BizException{
		IPatAccServiceExt accService = ServiceFinder.find(IPatAccServiceExt.class);
		PatRelAmountInfoDTO[] dtos = accService.GetPatRelAmountInfos(patIds);
		if(ArrayUtil.isEmpty(dtos))
			return null;
		
		List<PatRelAmountInfoDTO> patBalanceList = new ArrayList<PatRelAmountInfoDTO>();
		patBalanceList.addAll(Arrays.asList(dtos));
		return patBalanceList;
	}
	
	/**
	 * 获取就诊账户数据
	 * @param enIds
	 * @return
	 * @throws BizException
	 */
	public static List<EnAccountDO> getEnAccData(String[] entIds) throws BizException{
		IEnaccountMDORService rService = ServiceFinder.find(IEnaccountMDORService.class);
		EnAccountDO[] dos = rService.findByAttrValStrings(EnAccountDO.ID_ENT, entIds);
		if(ArrayUtil.isEmpty(dos))
			return null;
		
		List<EnAccountDO> enAccList = new ArrayList<EnAccountDO>();
		enAccList.addAll(Arrays.asList(dos));
		return enAccList;
	}
	
	/**
	 * 获取账户余额数据
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public static List<BalanceDTO> getBalanceData(String[] entIds) throws BizException{
		IEnOutQryService rService = ServiceFinder.find(IEnOutQryService.class);
		BalanceDTO[] dos = rService.getBalanceDTOs(entIds);
		if(ArrayUtil.isEmpty(dos))
			return null;
		
		List<BalanceDTO> balanceList = new ArrayList<BalanceDTO>();
		balanceList.addAll(Arrays.asList(dos));
		return balanceList;
	}
	
	/**
	 * 获取团检账户数据
	 * @param peIds
	 * @return
	 * @throws BizException
	 */
	public static List<EnPeCmpyACCDO> getPecmpyAccData(String[] peIds) throws BizException{
		
		if(ArrayUtil.isEmpty(peIds))
			return null;
		
		IEnpecmpyaccRService rService = ServiceFinder.find(IEnpecmpyaccRService.class);
		EnPeCmpyACCDO[] peAccDos = rService.findByAttrValStrings(EnPeCmpyACCDO.ID_PECMPY, peIds);
		
		if(ArrayUtil.isEmpty(peAccDos))
			return null;
		
		List<EnPeCmpyACCDO> peAccList = new ArrayList<EnPeCmpyACCDO>();
		peAccList.addAll(Arrays.asList(peAccDos));
		return peAccList;
	}
	
	/**
	 * 获取团检账户余额数据
	 * @param peIds
	 * @return
	 * @throws BizException
	 */
	public static List<BalanceDTO> getPeBalanceData(String[] peIds) throws BizException{
		
		if(ArrayUtil.isEmpty(peIds))
			return null;
		
		IEn4BlQryService rService = ServiceFinder.find(IEn4BlQryService.class);
		BalanceDTO[] peAccDos = rService.getPeCmpyBalances(peIds);
		
		if(ArrayUtil.isEmpty(peAccDos))
			return null;
		
		List<BalanceDTO> peBalanceList = new ArrayList<BalanceDTO>();
		peBalanceList.addAll(Arrays.asList(peAccDos));
		return peBalanceList;
	}
	
	/**
	 * 获取医疗服务
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static List<MedSrvDO> getSrvData(String[] srvIds) throws BizException{
		DAFacade daf = new DAFacade();
		List<MedSrvDO> rlt = (List<MedSrvDO>)daf.findByPKs(MedSrvDO.class, srvIds, BD_SRV_FIELD);
		return rlt;
	}
	
	/**
	 * 获取医嘱数据
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static List<CiOrderDO> getCiOrderData(String[] orIds) throws BizException{
		
		/*List<CiOrderDO> contextOrdList = (List<CiOrderDO>)Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_CI_ORDER);
		if(!ListUtil.isEmpty(contextOrdList)){
			return contextOrdList;
		}*/
		
		DAFacade daf = new DAFacade();
		List<CiOrderDO> rlt = (List<CiOrderDO>)daf.findByPKs(CiOrderDO.class, orIds, CI_ORDER_FIELD);
		return rlt;
	}
	
	/**
	 * 获取医嘱服务数据(可记账项目)
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static List<OrdSrvDO> getCiOrsrvDataForBl(String[] orIds) throws BizException{
		
		DAFacade daf = new DAFacade();
		List<OrdSrvDO> rlt = (List<OrdSrvDO>)daf.findByAttrValStrings(OrdSrvDO.class, OrdSrvDO.ID_OR, orIds, CI_OR_SRV_FIELD);
		if(ListUtil.isEmpty(rlt))
			return rlt;
		
		List<OrdSrvDO> blRlt = new ArrayList<OrdSrvDO>();
		for (OrdSrvDO ordSrvDO : rlt) {
			if(FBoolean.TRUE.equals(ordSrvDO.getFg_bl())){
				blRlt.add(ordSrvDO);
			}
		}
		
		return blRlt;
	}
	
	/**
	 * 获取医嘱服务数据
	 * @param orsrvIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static List<OrdSrvDO> getCiOrsrvData(String[] orsrvIds) throws BizException{
		
		/*List<OrdSrvDO> contextOrsrvList = (List<OrdSrvDO>)Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_CI_OR_SRV);
		if(!ListUtil.isEmpty(contextOrsrvList)){
			return contextOrsrvList;
		}*/
		
		DAFacade daf = new DAFacade();
		List<OrdSrvDO> rlt = (List<OrdSrvDO>)daf.findByPKs(OrdSrvDO.class, orsrvIds, CI_OR_SRV_FIELD);
		return rlt;
	}
	
	/**
	 * 获取医嘱服务物品数据
	 * @param orsrvIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static List<OrdSrvMmDO> getCiOrsrvmmData(String[] orsrvIds) throws BizException{
		DAFacade daf = new DAFacade();
		List<OrdSrvMmDO> rlt = (List<OrdSrvMmDO>) daf.findByAttrValStrings(
				OrdSrvMmDO.class, OrdSrvMmDO.ID_ORSRV, orsrvIds, CI_OR_SRV_MM_FIELD);
		return rlt;
	}
	
	/**
	 * 获取物品信息
	 * @param mmIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static List<MeterialDO> getMMData(String[] mmIds) throws BizException{
		DAFacade daf = new DAFacade();
		List<MeterialDO> rlt = (List<MeterialDO>)daf.findByPKs(MeterialDO.class, mmIds, BD_MM_FIELD);
		return rlt;
	}
	
	/**
	 * 查询组合计价特殊折扣率数据
	 * @param srvOrIds 服务数组
	 * @return
	 * @throws BizException
	 */
	public static List<BdPriSrvCompRatioDTO> getSpecialCompRatioData(String[] srvOrIds) throws BizException{
		IBdPpQryService ppService = ServiceFinder.find(IBdPpQryService.class);
		BdPriSrvCompRatioDTO[] compDtos = ppService.getSpecialSrvCompRatio(srvOrIds);
		if(ArrayUtil.isEmpty(compDtos))
			return null;
		
		List<BdPriSrvCompRatioDTO> rlt = new ArrayList<BdPriSrvCompRatioDTO>();
		rlt.addAll(Arrays.asList(compDtos));
		return rlt;
	}
	
	/**
	 * 住院费用审核数据
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public static List<BlAuditIp> getAuditData(String[] entIds) throws BizException{
		
		IBlauditipMDORService rService = ServiceFinder.find(IBlauditipMDORService.class);
		String a0 = BlAuditIpDesc.TABLE_ALIAS_NAME;
		String whereSql = SqlUtils.getInSqlByIds(a0 + "." + BlAuditIp.ID_ENT, entIds);
		whereSql += " and %s.fg_active = 'Y'";
		whereSql = String.format(whereSql, a0);
		
		BlAuditIp[] dos = rService.find(whereSql, "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(dos))
			return null;
		
		List<BlAuditIp> auditList = new ArrayList<BlAuditIp>();
		auditList.addAll(Arrays.asList(dos));
		return auditList;
	}

	/**
	 * 获取票据分类对照
	 * @param sdIncca
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	public static List<IncCaItmRelDO> getCaItmRelData(String sdIncca, String[] srvIds) throws BizException{
		
		IBdPpBlQryService rService = ServiceFinder.find(IBdPpBlQryService.class);
		IncCaItmRelDO dos[] = rService.findCaItmRelBySrv(sdIncca, srvIds);
		if(ArrayUtil.isEmpty(dos))
			return null;
		
		List<IncCaItmRelDO> caItmRelList = new ArrayList<IncCaItmRelDO>();
		caItmRelList.addAll(Arrays.asList(dos));
		return caItmRelList;
	}
	
	/**
	 * 查询原记账数据
	 * @param cgIds
	 * @param prsrvIds
	 * @param orsrvIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static List<BlCgIpDO> getBlCgIpData(String[] cgIds, String[] prsrvIds, String[] orsrvIds) throws BizException {
		DAFacade daf = new DAFacade();
		String cond = "";
		if(!ArrayUtil.isEmpty(cgIds)){
			cond += SqlUtils.getInSqlByIds("id_cgip", cgIds);
		}
		
		if(!ArrayUtil.isEmpty(prsrvIds)){
			if(!"".equals(cond)){
				cond += " and ";
			}
			cond += SqlUtils.getInSqlByIds("id_cgip", prsrvIds);
		}
		
		if(!ArrayUtil.isEmpty(orsrvIds)){
			if(!"".equals(cond)){
				cond += " and ";
			}
			cond += SqlUtils.getInSqlByIds("id_cgip", orsrvIds);
		}
		
		List<BlCgIpDO> doList = (List<BlCgIpDO>) daf.findByCond(BlCgIpDO.class, cond, "");
		return doList;
	}
	
	/**
	 * 获取医保目录对照
	 * @param hpId
	 * @param srvIds
	 * @param mmIds
	 * @return
	 * @throws BizException
	 */
	public static ThreeDirCompInfoDTO[] getHpCompInfo(String hpId, String[] srvIds, String[] mmIds) throws BizException {
		IMiBdDirCompQryService miService = ServiceFinder.find(IMiBdDirCompQryService.class);
		return miService.findThreeDirCompByHisSrvIdsAndDrugIds(hpId, srvIds, mmIds);
	}
	
	/**
	 * 获取执行服务记账数量(判断是否记账)
	 * @param prsrvIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,FDouble> getPrsrvCgQuan(String[] prsrvIds) throws BizException {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select bl_cg_ip.id_or_pr_srv,");
		sqlSb.append("sum(bl_cg_ip.eu_direct * bl_cg_ip.quan) quan ");
		sqlSb.append("from bl_cg_ip ");
		sqlSb.append("where " + SqlUtils.getInSqlByIds("bl_cg_ip.id_or_pr_srv", prsrvIds));
		sqlSb.append("group by bl_cg_ip.id_or_pr_srv");

		DAFacade daf = new DAFacade();
		List<Map<String, Object>> rlt = (List<Map<String, Object>>) daf
				.execQuery(sqlSb.toString(), new MapListHandler());
		
		if(ListUtil.isEmpty(rlt))
			return new HashMap<String, FDouble>();
		
		Map<String,FDouble> rtnMap = new HashMap<String,FDouble>();
		for (Map<String, Object> map : rlt) {
			
			String key = (String)map.get("id_or_pr_srv");
			FDouble value = (FDouble)FTypeManager.convert2FType(FType.FDouble, map.get("quan"));
			
			rtnMap.put(key, value);
		}
		
		return rtnMap;
	}
	
	/**
	 * 获取执行服务记账数量(判断是否记账)
	 * @param prsrvIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,FDouble> getPrsrvCgQuanEt(String[] prsrvIds) throws BizException {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select bl_cg_itm_oep.id_or_pr_srv,");
		sqlSb.append("bl_cg_itm_oep.quan quan ");
		sqlSb.append("from bl_cg_itm_oep ");
		sqlSb.append("inner join bl_cg_oep ");
		sqlSb.append("on bl_cg_itm_oep.id_cgoep = bl_cg_oep.id_cgoep ");
		sqlSb.append("where " + SqlUtils.getInSqlByIds("bl_cg_itm_oep.id_or_pr_srv", prsrvIds));
		sqlSb.append(" and bl_cg_itm_oep.fg_refund = 'N' and bl_cg_oep.eu_direct = 1 ");

		DAFacade daf = new DAFacade();
		List<Map<String, Object>> rlt = (List<Map<String, Object>>) daf
				.execQuery(sqlSb.toString(), new MapListHandler());
		
		if(ListUtil.isEmpty(rlt))
			return new HashMap<String, FDouble>();
		
		Map<String,FDouble> rtnMap = new HashMap<String,FDouble>();
		for (Map<String, Object> map : rlt) {
			
			String key = (String)map.get("id_or_pr_srv");
			FDouble value = (FDouble)FTypeManager.convert2FType(FType.FDouble, map.get("quan"));
			
			rtnMap.put(key, value);
		}
		
		return rtnMap;
	}
	
	/**
	 * 查询处方号
	 * @param orsrvIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static BlCgApplyDTO[] getPresCode(String[] orsrvIds) throws BizException {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select orsrv.id_orsrv id_key,pres.code applyno,'01' applytp ");
		sqlSb.append("from ci_pres pres ");
		sqlSb.append("inner join ci_or_srv orsrv ");
		sqlSb.append("on pres.id_pres = orsrv.id_pres ");
		sqlSb.append("where ");
		sqlSb.append(SqlUtils.getInSqlByIds("orsrv.id_orsrv", orsrvIds));
		
		DAFacade daf = new DAFacade();
		List<BlCgApplyDTO> rlt = (List<BlCgApplyDTO>)daf.execQuery(sqlSb.toString(), new BeanListHandler(BlCgApplyDTO.class));
		
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.toArray(new BlCgApplyDTO[0]);
	}
	
	/**
	 * 查询检查申请单号
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static BlCgApplyDTO[] getRisCode(String[] orIds) throws BizException {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select risor.id_or id_key,ris.code_app applyno,'02' applytp ");
		sqlSb.append("from ci_app_ris_or risor ");
		sqlSb.append("inner join ci_app_ris ris  ");
		sqlSb.append("on risor.id_ciapprissheet = ris.id_ciapprissheet ");
		sqlSb.append("where ");
		sqlSb.append(SqlUtils.getInSqlByIds("risor.id_or", orIds));
		
		DAFacade daf = new DAFacade();
		List<BlCgApplyDTO> rlt = (List<BlCgApplyDTO>)daf.execQuery(sqlSb.toString(), new BeanListHandler(BlCgApplyDTO.class));
		
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.toArray(new BlCgApplyDTO[0]);
	}
	
	/**
	 * 查询检验申请单号
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static BlCgApplyDTO[] getLisCode(String[] orIds) throws BizException {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select lisor.id_or id_key,lis.code_app applyno,'03' applytp ");
		sqlSb.append("from ci_app_lis_or lisor ");
		sqlSb.append("inner join ci_app_lis lis  ");
		sqlSb.append("on lisor.id_ciapplissheet = lis.id_ciapplissheet ");
		sqlSb.append("where ");
		sqlSb.append(SqlUtils.getInSqlByIds("lisor.id_or", orIds));
		
		DAFacade daf = new DAFacade();
		List<BlCgApplyDTO> rlt = (List<BlCgApplyDTO>)daf.execQuery(sqlSb.toString(), new BeanListHandler(BlCgApplyDTO.class));
		
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.toArray(new BlCgApplyDTO[0]);
	}
	
	/**
	 * 查询病理申请单号
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static BlCgApplyDTO[] getBingliCode(String[] orIds) throws BizException {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select pathgy.id_or id_key,pathgy.code_app applyno,'04' applytp ");
		sqlSb.append("from ci_app_pathgy pathgy ");
		sqlSb.append("where ");
		sqlSb.append(SqlUtils.getInSqlByIds("pathgy.id_or", orIds));
		
		DAFacade daf = new DAFacade();
		List<BlCgApplyDTO> rlt = (List<BlCgApplyDTO>)daf.execQuery(sqlSb.toString(), new BeanListHandler(BlCgApplyDTO.class));
		
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.toArray(new BlCgApplyDTO[0]);
	}
	
	/**
	 * 查询其他打印单号
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static BlCgApplyDTO[] getOtherPrnCode(String[] orsrvIds) throws BizException {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select prnitm.id_biz id_key,prn.code_prn applyno,'05' applytp ");
		sqlSb.append("from ci_prn_item prnitm ");
		sqlSb.append("inner join ci_prn prn ");
		sqlSb.append("on prnitm.id_ciprn = prn.id_ciprn ");
		sqlSb.append("where ");
		sqlSb.append(SqlUtils.getInSqlByIds("prnitm.id_biz", orsrvIds));
		
		DAFacade daf = new DAFacade();
		List<BlCgApplyDTO> rlt = (List<BlCgApplyDTO>)daf.execQuery(sqlSb.toString(), new BeanListHandler(BlCgApplyDTO.class));
		
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.toArray(new BlCgApplyDTO[0]);
	}
	
	/**
	 * 组装住院记账数据
	 * @param bizDto
	 * @param dataWh
	 * @return BlCgIpDO
	 */
	public static BlCgIpDO buildCgData(BlCgAccountBizDTO bizDto,BlCgAccountSetDTO accSet,BlCgAccDataWarehouse dataWh){
		
		BlCgIpDO cgDO = new BlCgIpDO();
		cgDO.setId_grp(Context.get().getGroupId());
		cgDO.setId_org(Context.get().getOrgId());
		
		//就诊数据
		PatiVisitDO entDO = dataWh.getEnMap().get(bizDto.getId_ent());
		cgDO.setId_pat(entDO.getId_pat());
		cgDO.setId_ent(entDO.getId_ent());
		cgDO.setId_enttp(entDO.getId_entp());
		cgDO.setCode_enttp(entDO.getCode_entp());
		cgDO.setId_pripat(entDO.getId_pripat());
		cgDO.setId_ent_mom(bizDto.getId_ent_mm());
		cgDO.setFg_bb(bizDto.getFg_bb());
		cgDO.setNo_bb(bizDto.getNo_bb());
		cgDO.setId_dep_phy(entDO.getId_dep_phy());
		cgDO.setId_emp_phy(entDO.getId_emp_phy());
		
		//服务信息
		MedSrvDO srvDO = dataWh.getSrvMap().get(bizDto.getId_srv());
		cgDO.setId_srvtp(srvDO.getId_srvtp());
		cgDO.setSd_srvtp(srvDO.getSd_srvtp());
		cgDO.setId_srvca(srvDO.getId_srvca());
		cgDO.setId_srv(srvDO.getId_srv());
		cgDO.setCode_srv(srvDO.getCode());
		cgDO.setName_srv(srvDO.getName());
		if(FBoolean.TRUE.equals(bizDto.getFg_mm())){
			cgDO.setSrvu(bizDto.getId_pkgu_cur());
		}else if(!StringUtil.isEmpty(bizDto.getId_unit_srv())){
			cgDO.setSrvu(bizDto.getId_unit_srv());
		}else{
			cgDO.setSrvu(srvDO.getId_unit_med());
		}
		
		//金额相关信息
		cgDO.setPrice(bizDto.getPrice_std());
		cgDO.setPrice_ratio(bizDto.getPrice_ratio());
		cgDO.setQuan(bizDto.getQuan());
		cgDO.setQuan_ret(FDouble.ZERO_DBL);
		cgDO.setRatio_pripat(bizDto.getRatio_pripat());
		cgDO.setAmt(cgDO.getPrice_ratio().multiply(cgDO.getQuan(),IBlConst.PRECISION_AMOUNT));
		cgDO.setAmt_std(cgDO.getPrice().multiply(cgDO.getQuan(), IBlConst.PRECISION_AMOUNT));
		cgDO.setAmt_ratio(cgDO.getAmt());
		cgDO.setAmt_pat(cgDO.getAmt());
		cgDO.setAmt_hp(FDouble.ZERO_DBL);
		cgDO.setRatio_hp(null);
		
		//医嘱信息
		if(!StringUtil.isEmpty(bizDto.getId_or())){
			CiOrderDO ordDO = dataWh.getOrMap().get(bizDto.getId_or());
			cgDO.setId_or(ordDO.getId_or());
			cgDO.setDt_or(ordDO.getDt_entry());
			cgDO.setId_org_or(ordDO.getId_org_or());
			if(FBoolean.FALSE.equals(accSet.getFg_addfee())){
				cgDO.setId_dep_or(ordDO.getId_dep_or());
				cgDO.setId_emp_or(ordDO.getId_emp_or());
			}else{
				cgDO.setId_dep_or(bizDto.getId_dep_or());
				if(StringUtil.isEmpty(bizDto.getId_emp_or())){
					cgDO.setId_emp_or(Context.get().getStuffId());
				}else{
					cgDO.setId_emp_or(bizDto.getId_emp_or());
				}
			}
			cgDO.setId_wg_or(ordDO.getId_wg_or());
			cgDO.setCode_apply(ordDO.getApplyno());
			cgDO.setFg_pddisc(ordDO.getFg_pres_outp());
			//cgDO.setId_dep_nur(ordDO.getId_dep_nur_or());
			cgDO.setId_dep_nur(entDO.getId_dep_nur());
		}else{
			cgDO.setId_org_or(Context.get().getOrgId());
			if(StringUtil.isEmpty(bizDto.getId_dep_or())){
				cgDO.setId_dep_or(Context.get().getDeptId());
			}else{
				cgDO.setId_dep_or(bizDto.getId_dep_or());
			}
			if(StringUtil.isEmpty(bizDto.getId_emp_or())){
				cgDO.setId_emp_or(Context.get().getStuffId());
			}else{
				cgDO.setId_emp_or(bizDto.getId_emp_or());
			}
			cgDO.setFg_pddisc(FBoolean.FALSE);
			cgDO.setId_dep_nur(entDO.getId_dep_nur());
			cgDO.setDt_or(BlFlowContextUtil.getNowTime());
		}
		
		//医嘱服务信息
		if(!StringUtil.isEmpty(bizDto.getId_orsrv())){
			OrdSrvDO orsrvDO = dataWh.getOrsrvMap().get(bizDto.getId_orsrv());
			cgDO.setId_orsrv(orsrvDO.getId_orsrv());
			cgDO.setDt_srv(orsrvDO.getDt_create());
			cgDO.setId_org_mp(orsrvDO.getId_org_mp());
			cgDO.setId_dep_mp(orsrvDO.getId_dep_mp());
			cgDO.setId_pres(orsrvDO.getId_pres());
			cgDO.setId_dep_wh(orsrvDO.getId_dep_wh());
			cgDO.setFg_research(orsrvDO.getFg_research());
			cgDO.setId_researchproject(orsrvDO.getId_researchproject());
			cgDO.setFg_pay_unit(orsrvDO.getFg_pay_unit());
			cgDO.setFg_selfpay(orsrvDO.getFg_selfpay());
		}else{
			if(!StringUtil.isEmpty(bizDto.getId_or())){
				CiOrderDO ordDO = dataWh.getOrMap().get(bizDto.getId_or());
				cgDO.setFg_research(ordDO.getFg_research());
				cgDO.setId_researchproject(ordDO.getId_researchproject());
				cgDO.setFg_pay_unit(ordDO.getFg_pay_unit());
			}else{
				cgDO.setFg_research(FBoolean.FALSE);
				cgDO.setFg_pay_unit(FBoolean.FALSE);
			}
			
			cgDO.setId_org_mp(Context.get().getOrgId());
			cgDO.setId_dep_mp(bizDto.getId_dep_mp());
			cgDO.setDt_srv(BlFlowContextUtil.getNowTime());
			cgDO.setId_dep_wh(bizDto.getId_dep_wh());
			
			if(!dataWh.getEntHpMap().containsKey(cgDO.getId_ent())){
				cgDO.setFg_selfpay(FBoolean.TRUE);
			}else{
				EntHpDO hpDO = dataWh.getEntHpMap().get(cgDO.getId_ent());
				String key = hpDO.getId_hp() + (StringUtil.isEmpty(bizDto.getId_mm()) ? 
						bizDto.getId_srv() : bizDto.getId_mm());
				
				ThreeDirCompInfoDTO compDto = dataWh.getHpCompMap().get(key);
				if(compDto == null){
					cgDO.setFg_selfpay(FBoolean.TRUE);
				}else{
					if(IBdPpCodeTypeConst.SD_HP_BJ_ONE.equals(compDto.getSd_hpsrvtp()) ||
							IBdPpCodeTypeConst.SD_HP_BJ_TOW.equals(compDto.getSd_hpsrvtp())){
						cgDO.setFg_selfpay(FBoolean.FALSE);
					}else{
						cgDO.setFg_selfpay(FBoolean.TRUE);
					}
				}
			}
		}
		
		//执行信息
		cgDO.setId_or_pr(null);
		cgDO.setId_or_pr_srv(bizDto.getId_or_prsrv());
		
		//医嘱服务品信息
		cgDO.setFg_mm(bizDto.getFg_mm());
		cgDO.setId_mm(bizDto.getId_mm());
		cgDO.setOnlycode(bizDto.getOnly_code());
		cgDO.setCd_batch(bizDto.getBatch());
		if(!StringUtil.isEmpty(bizDto.getId_orsrv()) && 
				!StringUtil.isEmpty(bizDto.getId_mm()) && 
				FBoolean.TRUE.equals(bizDto.getFg_mm())){
			OrdSrvMmDO srvmmDO = dataWh.getOrsrvmmMap().get(bizDto.getId_orsrv());
			MeterialDO mmDO = dataWh.getMmMap().get(bizDto.getId_mm());
			cgDO.setId_mmtp(srvmmDO.getId_mmtp());
			cgDO.setSd_mmtp(srvmmDO.getSd_mmtp());
			cgDO.setCode_mm(srvmmDO.getCode_mm());
			//cgDO.setName_mm(srvmmDO.getName_mm());
			cgDO.setName_mm(mmDO.getName());
			cgDO.setSpec(mmDO.getSpec());
			cgDO.setPgku_base(srvmmDO.getId_pgku_base());
			cgDO.setPgku_cur(srvmmDO.getId_pgku_cur());
			cgDO.setFactor(srvmmDO.getFactor());
		}else if(!StringUtil.isEmpty(bizDto.getId_mm())){
			MeterialDO mmDO = dataWh.getMmMap().get(bizDto.getId_mm());
			cgDO.setId_mmtp(mmDO.getId_mmtp());
			cgDO.setSd_mmtp(mmDO.getSd_mmtp());
			cgDO.setCode_mm(mmDO.getCode());
			cgDO.setName_mm(mmDO.getName());
			cgDO.setSpec(mmDO.getSpec());
			cgDO.setPgku_base(mmDO.getId_unit_pkgbase());
			cgDO.setPgku_cur(cgDO.getSrvu());
		}
		
		//账单信息
		IncCaItmRelDO relDO = dataWh.getCaItmRelMap().get(bizDto.getId_srv());
		if(relDO != null){
			cgDO.setCode_inccaitm(relDO.getInccaitm_code());
			cgDO.setName_inccaitm(relDO.getInccaitm_name());
		}
		
		//记账信息
		cgDO.setCode_cg(null); //-->目前依赖BlCgIpInsertDoRule设值
		cgDO.setId_org_cg(accSet.getId_org_cg());
		if(!StringUtil.isEmpty(bizDto.getId_dep_cg_detail())){
			cgDO.setId_dep_cg(bizDto.getId_dep_cg_detail());
		}else{
			cgDO.setId_dep_cg(accSet.getId_dep_cg());
		}
		if(!StringUtil.isEmpty(bizDto.getId_emp_cg_detail())){
			cgDO.setId_emp_cg(bizDto.getId_emp_cg_detail());
		}else{
			cgDO.setId_emp_cg(accSet.getId_emp_cg());
		}
		if(bizDto.getDt_cg_detail() != null){
			cgDO.setDt_cg(bizDto.getDt_cg_detail());
		}else{
			cgDO.setDt_cg(accSet.getDt_cg());
		}
		
		cgDO.setEu_srctp(accSet.getEu_srctp());
		cgDO.setSrcfunc_des(accSet.getSrcfunc_des());
		cgDO.setDt_oper_cg(BlFlowContextUtil.getNowTime());
		cgDO.setEu_direct(bizDto.getEu_direct());
		
		//其他信息
		cgDO.setFg_st(FBoolean.FALSE);
		cgDO.setFg_hp(FBoolean.FALSE);
		cgDO.setFg_susp(FBoolean.FALSE);
		cgDO.setFg_refund(FBoolean.FALSE);
		cgDO.setFg_recg(FBoolean.FALSE);
		cgDO.setFg_free(bizDto.getFg_free());
		cgDO.setFg_real(FBoolean.TRUE);
		cgDO.setFg_additm(accSet.getFg_addfee());
		cgDO.setId_entbed(bizDto.getId_entbed());
		cgDO.setId_entdcg(bizDto.getId_entdcg());
		cgDO.setNote(null);
		cgDO.setId_stip(null);
		cgDO.setDt_st(null);
		cgDO.setId_par(null);
		cgDO.setId_recg_ip(null);
		
		//值得商榷的信息 TODO
		cgDO.setApprno(null);
		cgDO.setQuan_base(null);
		if (StringUtils.isNotEmpty(bizDto.getId_hp())) {
			cgDO.setId_hp(bizDto.getId_hp());
		}else {
			if(StringUtils.isNotEmpty(entDO.getId_hp())){
				cgDO.setId_hp(entDO.getId_hp());
				bizDto.setId_hp(entDO.getId_hp());
			}else {
				cgDO.setId_hp(null);
			}
		}
		//设置通用医保目录等级
		cgDO.setSd_std_hpsrvtp(getSdStdHpsrvtp(bizDto));
		
		
		cgDO.setStatus(DOStatus.NEW);
		
		return cgDO;
	}

	/**
	 * 组装住院退记账数据
	 * @param rfdDto
	 * @param oldData
	 * @param accSet
	 * @return
	 */
	public static BlCgIpDO buildRfdCgData(BlCgRefundAccountDTO rfdDto,
			BlCgIpDO oldCgDO, BlCgRefundAccountSetDTO accSet,
			BlCgAccDataWarehouse dataWh) {
		
		BlCgIpDO cgDO = (BlCgIpDO)oldCgDO.clone();
		cgDO.setId_cgip(null);
		cgDO.setEu_direct(BookRtnDirectEnum.REFUND);
		if(BlParamValueConst.BLCG0029_NEGATIVE.equals(dataWh.getRefundMode())){
			cgDO.setQuan(rfdDto.getQuan());
		}else{
			cgDO.setQuan(oldCgDO.getQuan());
		}
		cgDO.setQuan_ret(FDouble.ZERO_DBL);
		cgDO.setAmt(cgDO.getPrice_ratio().multiply(cgDO.getQuan(),IBlConst.PRECISION_AMOUNT));
		cgDO.setAmt_std(cgDO.getPrice().multiply(cgDO.getQuan(), IBlConst.PRECISION_AMOUNT));
		cgDO.setAmt_ratio(cgDO.getAmt());
		cgDO.setAmt_pat(cgDO.getAmt());
		cgDO.setAmt_hp(FDouble.ZERO_DBL);
		
		cgDO.setCode_cg(null); //-->目前依赖BlCgIpInsertDoRule设值
		cgDO.setId_org_cg(accSet.getId_org_cg());
		cgDO.setId_dep_cg(accSet.getId_dep_cg());
		cgDO.setId_emp_cg(accSet.getId_emp_cg());
		cgDO.setDt_cg(accSet.getDt_cg());
		cgDO.setSrcfunc_des(accSet.getSrcfunc_des());
		cgDO.setDt_oper_cg(BlFlowContextUtil.getNowTime());
		//cgDO.setOnlycode(null);
		
		cgDO.setNote(null);
		cgDO.setFg_st(FBoolean.FALSE);
		cgDO.setFg_hp(FBoolean.FALSE);
		cgDO.setId_stip(null);
		cgDO.setId_par(oldCgDO.getId_cgip());
		
		cgDO.setStatus(DOStatus.NEW);
		return cgDO;
	}
	
	/**
	 * 组装住院重收数据
	 * @param oldCgDO
	 * @param quan
	 * @param accSet
	 * @param dataWh
	 * @return
	 */
	public static BlCgIpDO buildReCgData(BlCgIpDO oldCgDO,FDouble quan, BlCgRefundAccountSetDTO accSet) {
		
		BlCgIpDO cgDO = (BlCgIpDO)oldCgDO.clone();
		cgDO.setId_cgip(null);
		cgDO.setQuan(quan);
		cgDO.setQuan_ret(FDouble.ZERO_DBL);
		cgDO.setAmt(cgDO.getPrice_ratio().multiply(cgDO.getQuan(),IBlConst.PRECISION_AMOUNT));
		cgDO.setAmt_std(cgDO.getPrice().multiply(cgDO.getQuan(), IBlConst.PRECISION_AMOUNT));
		cgDO.setAmt_ratio(cgDO.getAmt());
		cgDO.setAmt_pat(cgDO.getAmt());
		cgDO.setAmt_hp(FDouble.ZERO_DBL);
		
		cgDO.setCode_cg(null); //-->目前依赖BlCgIpInsertDoRule设值
//		cgDO.setId_org_cg(accSet.getId_org_cg());
//		cgDO.setId_dep_cg(accSet.getId_dep_cg());
//		cgDO.setId_emp_cg(accSet.getId_emp_cg());
//		cgDO.setDt_cg(accSet.getDt_cg());
//		cgDO.setSrcfunc_des(accSet.getSrcfunc_des());-->与原记账一致
		cgDO.setDt_oper_cg(BlFlowContextUtil.getNowTime());
		
		cgDO.setNote(null);
		cgDO.setFg_st(FBoolean.FALSE);
		cgDO.setFg_hp(FBoolean.FALSE);
		cgDO.setId_stip(null);
		
		cgDO.setStatus(DOStatus.NEW);
		return cgDO;
	}

	/**
	 * 组装门诊记账数据
	 * @param bizAccList
	 * @param codeCg
	 * @param accSet
	 * @param dataWh
	 * @return
	 */
	public static BlcgoepAggDO buildCgData(List<BlCgAccountBizDTO> bizAccList, String codeCg, BlCgOpAccountSetDTO accSet,BlCgAccDataWarehouse dataWh) throws BizException {
	
		BlcgoepAggDO aggDO = new BlcgoepAggDO();
		//主do
		BlCgOepDO cgDO = new BlCgOepDO();
		cgDO.setId_grp(Context.get().getGroupId());
		cgDO.setId_org(Context.get().getOrgId());
		cgDO.setCode_cg(codeCg);
		cgDO.setId_pat(bizAccList.get(0).getId_pat());
		cgDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		cgDO.setDt_cg(accSet.getDt_cg());
		cgDO.setId_org_cg(accSet.getId_org_cg());
		cgDO.setId_dep_cg(accSet.getId_dep_cg());
		cgDO.setId_emp_cg(accSet.getId_emp_cg());
		cgDO.setStatus(DOStatus.NEW);
		
		List<BlCgItmOepDO> itmList = new ArrayList<BlCgItmOepDO>();
		for (BlCgAccountBizDTO bizDto : bizAccList) {
			BlCgItmOepDO itmDO = buildCgItmData(bizDto, accSet, dataWh);
			itmList.add(itmDO);
		}
		
		aggDO.setParentDO(cgDO);
		aggDO.setBlCgItmOepDO(itmList.toArray(new BlCgItmOepDO[0]));
		
		return aggDO;
	}
	
	/**
	 * 组装门诊记账数据(单一数据)
	 * @param bizAccList
	 * @param codeCg
	 * @param accSet
	 * @param dataWh
	 * @return
	 * @throws BizException
	 */
	public static BlcgoepAggDO buildCgData(BlCgAccountBizDTO bizDto, String codeCg, BlCgOpAccountSetDTO accSet,BlCgAccDataWarehouse dataWh) throws BizException {
	
		BlcgoepAggDO aggDO = new BlcgoepAggDO();
		//主do
		BlCgOepDO cgDO = new BlCgOepDO();
		cgDO.setId_grp(Context.get().getGroupId());
		cgDO.setId_org(Context.get().getOrgId());
		cgDO.setCode_cg(codeCg);
		cgDO.setId_pat(bizDto.getId_pat());
		cgDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		if(bizDto.getDt_cg_detail() != null){
			cgDO.setDt_cg(bizDto.getDt_cg_detail());
		}else{
			cgDO.setDt_cg(accSet.getDt_cg());
		}
		cgDO.setId_org_cg(accSet.getId_org_cg());
		if(!StringUtil.isEmpty(bizDto.getId_dep_cg_detail())){
			cgDO.setId_dep_cg(bizDto.getId_dep_cg_detail());
		}else{
			cgDO.setId_dep_cg(accSet.getId_dep_cg());
		}
		if(!StringUtil.isEmpty(bizDto.getId_emp_cg_detail())){
			cgDO.setId_emp_cg(bizDto.getId_emp_cg_detail());
		}else{
			cgDO.setId_emp_cg(accSet.getId_emp_cg());
		}
		cgDO.setStatus(DOStatus.NEW);
		
		List<BlCgItmOepDO> itmList = new ArrayList<BlCgItmOepDO>();
		
		BlCgItmOepDO itmDO = buildCgItmData(bizDto, accSet, dataWh);
		itmList.add(itmDO);
		
		aggDO.setParentDO(cgDO);
		aggDO.setBlCgItmOepDO(itmList.toArray(new BlCgItmOepDO[0]));
		
		return aggDO;
	}
	
	/**
	 * 组装门诊记账子表数据
	 * @param bizDto
	 * @param accSet
	 * @param dataWh
	 * @return
	 * @throws BizException 
	 */
	private static BlCgItmOepDO buildCgItmData(BlCgAccountBizDTO bizDto, BlCgOpAccountSetDTO accSet, BlCgAccDataWarehouse dataWh) throws BizException{
		
		//子do
		BlCgItmOepDO itmCgDO = new BlCgItmOepDO();
		itmCgDO.setId_grp(Context.get().getGroupId());
		itmCgDO.setId_org(Context.get().getOrgId());
		itmCgDO.setId_pat(bizDto.getId_pat());
		itmCgDO.setId_ent(bizDto.getId_ent());
		itmCgDO.setId_pripat(bizDto.getId_pripat());
		if(StringUtil.isEmpty(itmCgDO.getId_ent())){
			itmCgDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
			itmCgDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		}else{
			PatiVisitDO enDO = dataWh.getEnMap().get(itmCgDO.getId_ent());
			itmCgDO.setId_enttp(enDO.getId_entp());
			itmCgDO.setCode_enttp(enDO.getCode_entp());
			itmCgDO.setId_dep_phy(enDO.getId_dep_phy());
			itmCgDO.setId_emp_phy(enDO.getId_emp_phy());
		}
		
		//服务信息
		MedSrvDO srvDO = dataWh.getSrvMap().get(bizDto.getId_srv());
		itmCgDO.setId_srv(bizDto.getId_srv());
		itmCgDO.setId_srvtp(srvDO.getId_srvtp());
		itmCgDO.setSd_srvtp(srvDO.getSd_srvtp());
		itmCgDO.setId_srvca(srvDO.getId_srvca());
		itmCgDO.setCode_srv(srvDO.getCode());
		itmCgDO.setName_srv(srvDO.getName());
		if(FBoolean.TRUE.equals(bizDto.getFg_mm())){
			itmCgDO.setSrvu(bizDto.getId_pkgu_cur());
		}else if(!StringUtil.isEmpty(bizDto.getId_unit_srv())){
			itmCgDO.setSrvu(bizDto.getId_unit_srv());
		}else{
			itmCgDO.setSrvu(srvDO.getId_unit_med());
		}

		//金额相关信息
		itmCgDO.setPrice(bizDto.getPrice_std());
		itmCgDO.setPrice_ratio(bizDto.getPrice_ratio());
		itmCgDO.setQuan(bizDto.getQuan());
		itmCgDO.setRatio_pripat(bizDto.getRatio_pripat());
		itmCgDO.setAmt(itmCgDO.getPrice_ratio().multiply(itmCgDO.getQuan(),IBlConst.PRECISION_AMOUNT));
		itmCgDO.setAmt_std(itmCgDO.getPrice().multiply(itmCgDO.getQuan(), IBlConst.PRECISION_AMOUNT));
		itmCgDO.setAmt_ratio(itmCgDO.getAmt());
		itmCgDO.setAmt_pat(itmCgDO.getAmt());
		itmCgDO.setAmt_hp(FDouble.ZERO_DBL);
		itmCgDO.setRatio_hp(null);
		switch (accSet.getEu_oepcgmode()) {
			case OepCgModeEnum.SUSP_CG:
				itmCgDO.setFg_susp(FBoolean.TRUE);
				itmCgDO.setFg_acc(FBoolean.FALSE);
				itmCgDO.setAmt_acc(FDouble.ZERO_DBL);
				itmCgDO.setFg_hpcg(FBoolean.FALSE);
				break;
			case OepCgModeEnum.PREPAY_CG:
				itmCgDO.setFg_susp(FBoolean.FALSE);
				itmCgDO.setFg_acc(FBoolean.TRUE);
				itmCgDO.setAmt_acc(itmCgDO.getAmt());
				itmCgDO.setFg_hpcg(FBoolean.FALSE);
				break;
			case OepCgModeEnum.ARREARS_CG:
				itmCgDO.setFg_susp(FBoolean.FALSE);
				itmCgDO.setFg_acc(FBoolean.FALSE);
				itmCgDO.setAmt_acc(FDouble.ZERO_DBL);
				itmCgDO.setFg_hpcg(FBoolean.FALSE);
				break;
			case OepCgModeEnum.HIGHHP_CG:
				itmCgDO.setFg_susp(FBoolean.FALSE);
				itmCgDO.setFg_acc(FBoolean.FALSE);
				itmCgDO.setAmt_acc(FDouble.ZERO_DBL);
				itmCgDO.setFg_hpcg(FBoolean.TRUE);
				break;
		}
		itmCgDO.setFg_pricinginsertcg(accSet.getFg_pricing());
		
		//医嘱信息
		if(!StringUtil.isEmpty(bizDto.getId_or())){
			FBoolean isCustom = BlParams.BLITF0002();
			if(StringUtil.isEmpty(bizDto.getPecode())){
			CiOrderDO ordDO = dataWh.getOrMap().get(bizDto.getId_or());
			itmCgDO.setId_or(bizDto.getId_or());
			itmCgDO.setDt_or(ordDO.getDt_entry());
			if(FBoolean.FALSE.equals(accSet.getFg_addfee())){
				itmCgDO.setId_org_or(ordDO.getId_org_or());
				itmCgDO.setId_dep_or(ordDO.getId_dep_or());
				itmCgDO.setId_emp_or(ordDO.getId_emp_or());
			}else{
				itmCgDO.setId_org_or(Context.get().getOrgId());
				itmCgDO.setId_dep_or(bizDto.getId_dep_or());
				if(StringUtil.isEmpty(bizDto.getId_emp_or())){
					itmCgDO.setId_emp_or(Context.get().getStuffId());
				}else{
					itmCgDO.setId_emp_or(bizDto.getId_emp_or());
				}
			}
			}else if(!StringUtil.isEmpty(bizDto.getPecode())&& FBoolean.FALSE.equals(isCustom)){
				IPepsnapptRService pepsnapptRService = ServiceFinder.find(IPepsnapptRService.class);
				String whereStr = "pe_code = ?";
				SqlParamDTO sqlParam = new SqlParamDTO();
				sqlParam.addParam(bizDto.getPecode());
				PePsnApptDO[] ordDO = pepsnapptRService.find2(whereStr, sqlParam, "", FBoolean.FALSE);
				itmCgDO.setId_or(bizDto.getId_or());
				itmCgDO.setDt_or(ordDO[0].getDt_appt());
				itmCgDO.setId_org_or(Context.get().getOrgId());
				if(StringUtil.isEmpty(bizDto.getId_dep_or())){
					itmCgDO.setId_dep_or(Context.get().getDeptId());
				}else{
					itmCgDO.setId_dep_or(bizDto.getId_dep_or());
				}
				if(StringUtil.isEmpty(bizDto.getId_emp_or())){
					itmCgDO.setId_emp_or(Context.get().getStuffId());
				}else{
					itmCgDO.setId_emp_or(bizDto.getId_emp_or());
				}
			}
			
		}else{
			itmCgDO.setId_org_or(Context.get().getOrgId());
			if(StringUtil.isEmpty(bizDto.getId_dep_or())){
				itmCgDO.setId_dep_or(Context.get().getDeptId());
			}else{
				itmCgDO.setId_dep_or(bizDto.getId_dep_or());
			}
			if(StringUtil.isEmpty(bizDto.getId_emp_or())){
				itmCgDO.setId_emp_or(Context.get().getStuffId());
			}else{
				itmCgDO.setId_emp_or(bizDto.getId_emp_or());
			}
		}
		
		//医嘱服务信息
		if(!StringUtil.isEmpty(bizDto.getId_orsrv())){
			OrdSrvDO orsrvDO = dataWh.getOrsrvMap().get(bizDto.getId_orsrv());
			itmCgDO.setId_orsrv(orsrvDO.getId_orsrv());
			itmCgDO.setDt_srv(orsrvDO.getDt_create());
			itmCgDO.setId_org_mp(orsrvDO.getId_org_mp());
			itmCgDO.setId_dep_mp(orsrvDO.getId_dep_mp());
			itmCgDO.setId_pres(orsrvDO.getId_pres());
			itmCgDO.setId_dep_wh(orsrvDO.getId_dep_wh());
			
		}else{
			itmCgDO.setId_org_mp(Context.get().getOrgId());
			itmCgDO.setId_dep_mp(bizDto.getId_dep_mp());
			itmCgDO.setDt_srv(BlFlowContextUtil.getNowTime());
			itmCgDO.setId_dep_wh(bizDto.getId_dep_wh());
		}
		
		//医嘱服务物品信息
		itmCgDO.setFg_mm(bizDto.getFg_mm());
		itmCgDO.setId_mm(bizDto.getId_mm());
		itmCgDO.setOnlycode(bizDto.getOnly_code());
		itmCgDO.setCd_batch(bizDto.getBatch());
		if(!StringUtil.isEmpty(bizDto.getId_orsrv()) && 
				!StringUtil.isEmpty(bizDto.getId_mm()) && 
				FBoolean.TRUE.equals(bizDto.getFg_mm())){
			OrdSrvMmDO srvmmDO = dataWh.getOrsrvmmMap().get(bizDto.getId_orsrv());
			MeterialDO mmDO = dataWh.getMmMap().get(bizDto.getId_mm());
			itmCgDO.setId_mmtp(srvmmDO.getId_mmtp());
			itmCgDO.setSd_mmtp(srvmmDO.getSd_mmtp());
			itmCgDO.setCode_mm(srvmmDO.getCode_mm());
			//cgDO.setName_mm(srvmmDO.getName_mm());
			itmCgDO.setName_mm(mmDO.getName());
			itmCgDO.setSpec(mmDO.getSpec());
			itmCgDO.setPgku_base(srvmmDO.getId_pgku_base());
			itmCgDO.setPgku_cur(srvmmDO.getId_pgku_cur());
			itmCgDO.setFactor(srvmmDO.getFactor());
		}else if(!StringUtil.isEmpty(bizDto.getId_mm())){
			MeterialDO mmDO = dataWh.getMmMap().get(bizDto.getId_mm());
			itmCgDO.setId_mmtp(mmDO.getId_mmtp());
			itmCgDO.setSd_mmtp(mmDO.getSd_mmtp());
			itmCgDO.setCode_mm(mmDO.getCode());
			itmCgDO.setName_mm(mmDO.getName());
			itmCgDO.setSpec(mmDO.getSpec());
			itmCgDO.setPgku_base(mmDO.getId_unit_pkgbase());
			itmCgDO.setPgku_cur(itmCgDO.getSrvu());
		}
		
		//执行信息
		itmCgDO.setId_or_pr(bizDto.getId_or_pr());
		itmCgDO.setId_or_pr_srv(bizDto.getId_or_prsrv());
		
		//账单信息
		if(IBdPpCodeTypeConst.SD_OUTREGISTER_INVIOCE.equals(dataWh.getRegInccaCode()) && FeeOriginEnum.ENCOUNTER_FEE.equals(accSet.getEu_srctp())){
			IncCaItmRelDO relDO = dataWh.getCaItmRelRegMap().get(bizDto.getId_srv());
			if(relDO != null){
				itmCgDO.setCode_inccaitm(relDO.getInccaitm_code());
				itmCgDO.setName_inccaitm(relDO.getInccaitm_name());
			}
		}else{
			IncCaItmRelDO relDO = dataWh.getCaItmRelMap().get(bizDto.getId_srv());
			if(relDO != null){
				itmCgDO.setCode_inccaitm(relDO.getInccaitm_code());
				itmCgDO.setName_inccaitm(relDO.getInccaitm_name());
			}
		}
		
		//单据信息
		if(!StringUtil.isEmpty(bizDto.getId_or()) && !StringUtil.isEmpty(bizDto.getId_orsrv())){
			
			//简单处理
			BlCgApplyDTO applyDto = dataWh.getApplyMap().get(bizDto.getId_or());
			if(applyDto == null){
				applyDto = dataWh.getApplyMap().get(bizDto.getId_orsrv());
			}
			
			if(applyDto != null){
				itmCgDO.setCode_apply(applyDto.getApplyno());
				itmCgDO.setCode_applytp(applyDto.getApplytp());
			}
		}
		
		//其他信息
		if (OepCgModeEnum.SUSP_CG.equals(accSet.getEu_oepcgmode())) {
			itmCgDO.setFg_st(FBoolean.TRUE);
			itmCgDO.setId_stoep(accSet.getId_stoep());
			itmCgDO.setDt_st(accSet.getDt_cg());
		}else{
			itmCgDO.setFg_st(FBoolean.FALSE);
			itmCgDO.setId_stoep(null);
			itmCgDO.setDt_st(null);
		}
		itmCgDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		if(bizDto.getDt_cg_detail() != null){
			itmCgDO.setDt_cg(bizDto.getDt_cg_detail());
		}else{
			itmCgDO.setDt_cg(accSet.getDt_cg());
		}
		itmCgDO.setFg_hp(FBoolean.FALSE);
		itmCgDO.setId_par(null);
		itmCgDO.setEu_srctp(accSet.getEu_srctp());
		itmCgDO.setNote(bizDto.getNote());
		itmCgDO.setFg_refund(FBoolean.FALSE);
		itmCgDO.setId_recg_oep(null);
		itmCgDO.setFg_recg(FBoolean.FALSE);
		if(bizDto.getFg_addfee() != null){
			itmCgDO.setFg_additm(bizDto.getFg_addfee());
		}else{
			itmCgDO.setFg_additm(accSet.getFg_addfee());
		}
		
		itmCgDO.setFg_free(bizDto.getFg_free());
		itmCgDO.setSrcfunc_des(accSet.getSrcfunc_des());
		itmCgDO.setPecode(bizDto.getPecode());
		
		//TODO 无用数据
		itmCgDO.setPri_ss(null);
		if (iih.bd.base.utils.StringUtils.isNotEmpty(bizDto.getId_hp())) {
			itmCgDO.setId_hp(bizDto.getId_hp());
		}
		//赋值通用目录等级
		itmCgDO.setSd_std_hpsrvtp(getSdStdHpsrvtp(bizDto));
		
		if (iih.bd.base.utils.StringUtils.isNotEmpty(bizDto.getId_hp()) && (IBdPpCodeTypeConst.SD_HP_BJ_ONE.equals(itmCgDO.getSd_std_hpsrvtp()) || IBdPpCodeTypeConst.SD_HP_BJ_TOW.equals(itmCgDO.getSd_std_hpsrvtp()) )) {
			itmCgDO.setFg_selfpay(FBoolean.FALSE);
		}else{
			itmCgDO.setFg_selfpay(FBoolean.TRUE);
		}
		
		return itmCgDO;
	}

	/**
	 * 获取通用目录等级
	 * @author zhang.hw
	 * @date 2020年6月24日
	 * @param bizDto
	 * @return
	 */
	private static String getSdStdHpsrvtp(BlCgAccountBizDTO bizDto) {
		String id_dep = bizDto.getId_dep_or();
		String id_hp = bizDto.getId_hp();
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct ");
		sb.append(" DECODE(srvtp.sd_hpsrvtp, ");
		sb.append("                                               NULL, ");
		sb.append("                                               srvtp3.sd_hpsrvtp, ");
		sb.append("                                               srvtp.sd_hpsrvtp)  Sd_hpsrvtp ");
		sb.append(" from bd_srv srv1 left join bd_mm on srv1.id_srv = bd_mm.id_srv");
		sb.append(" left join bd_measdoc srvdoc on srv1.id_unit_med = srvdoc.id_measdoc");
		sb.append(" left join bd_measdoc mmdoc on bd_mm.id_unit_pkgsp = mmdoc.id_measdoc");
		sb.append(" left  outer  join  (select  distinct  srvca.id_hpsrvorca, ");
		sb.append("                                       srvca.id_srv, ");
		//如果未对照就取默认的医保目录等级名称，否则取对照的目录等级
		sb.append("                                       DECODE(srvca.sd_hpsrvtp, ");
		sb.append("                                              NULL, ");
		sb.append("                                              srvtp2.sd_hpsrvtp_name, ");
		sb.append("                                              DECODE(srvca.sd_hpsrvtp, ");
		sb.append("                                                     '~', ");
		sb.append("                                                     srvtp2.sd_hpsrvtp_name, ");
		sb.append("                                                     udidoc.name))  sd_hpsrvtp_name, ");
		sb.append("                                       DECODE(srvca.sd_hpsrvtp, ");
		sb.append("                                              NULL, ");
		sb.append("                                              srvtp2.sd_hpsrvtp, ");
		sb.append("                                              DECODE(srvca.sd_hpsrvtp, ");
		sb.append("                                                     '~', ");
		sb.append("                                                     srvtp2.sd_hpsrvtp, ");
		sb.append("                                                     srvca.sd_hpsrvtp))  sd_hpsrvtp ");
		sb.append("                                       from  bd_hp_srvorca  srvca ");
		sb.append("                                     inner  join  bd_hp  hp ");
		if (StringUtils.isNotEmpty(id_hp)) {
			sb.append("                                   on  hp.id_hp  =  '").append(id_hp).append("' ");
		}else {
			sb.append("                                   on  hp.FG_DEFAULT  =  'Y' ");
		}
		sb.append("                                         and  hp.id_hp  =  srvca.id_hp ");
		sb.append("                                     inner  join  mi_hpsrvtp_vs_stdhpsrvtp  srvtp1 ");
		sb.append("                                           on  srvtp1.SD_STD_HPSRVTP  =  srvca.sd_hpsrvtp ");
		sb.append(" inner  join  bd_udidoc  udidoc ");
		sb.append("                                               on  udidoc.code  =  srvca.sd_hpsrvtp ");
		sb.append("                                         inner  join  bd_udidoclist  udlist ");
		sb.append("                                               on  udlist.id_udidoclist  =  udidoc.id_udidoclist ");
		sb.append("                                             and  udlist.code  =  'BD.BL.1020' ");
		//获取未对照的医保目录等级
		sb.append("                                       left  outer  join  (select  srvtp.SD_STD_HPSRVTP as sd_hpsrvtp,srvtp.sd_hpsrvtp as sd_hpsrvtp_name ");
		sb.append("                                                                           from  mi_hpsrvtp_vs_stdhpsrvtp  srvtp ");
		sb.append("                                                                         inner  join  bd_udidoc  udidoc ");
		sb.append("                                                                               on  udidoc.code  = ");
		sb.append("                                                                                     srvtp.SD_STD_HPSRVTP ");
		sb.append("                                                                             and  udidoc.ctrl1  =  'Y' ");
		sb.append("                                                                             and  udidoc.activestate  =  '2' ");
		sb.append("                                                                         inner  join  bd_udidoclist  udlist ");
		sb.append("                                                                               on  udlist.id_udidoclist  = ");
		sb.append("                                                                                     udidoc.id_udidoclist ");
		sb.append("                                                                             and  udlist.code  =  'BD.BL.1020' ");
		sb.append("                                                                         where  rownum  =  1)  srvtp2 ");
		sb.append("                                           on  1  =  1)  srvtp ");
		sb.append("     on  srvtp.id_srv  =  srv1.id_srv ");
		//获取未对照的医保目录等级
		sb.append(" left  outer  join  (select  srvtp.SD_STD_HPSRVTP as sd_hpsrvtp,srvtp.sd_hpsrvtp as sd_hpsrvtp_name ");
		sb.append("                                       from  mi_hpsrvtp_vs_stdhpsrvtp  srvtp ");
		sb.append("                                     inner  join  bd_udidoc  udidoc ");
		sb.append("                                           on  udidoc.code  =  srvtp.SD_STD_HPSRVTP ");
		sb.append("                                         and  udidoc.ctrl1  =  'Y' ");
		sb.append("                                         and  udidoc.activestate  =  '2' ");
		sb.append("                                     inner  join  bd_udidoclist  udlist ");
		sb.append("                                           on  udlist.id_udidoclist  =  udidoc.id_udidoclist ");
		sb.append("                                         and  udlist.code  =  'BD.BL.1020' ");
		sb.append("                                     where  rownum  =  1)  srvtp3 ");
		sb.append("     on  1  =  1 ");
		sb.append(" where 1=1 and srv1.fg_active = 'Y' and srv1.Ds=0 and (bd_mm.fg_active is null or bd_mm.fg_active = 'Y') ");
		String sqlContext = " and " + EnvContextUtil.processEnvContext("", new MedSrvDO(), "srv1");//增加组织隔离
		sb.append(sqlContext);
		
		if (FBoolean.FALSE.equals(bizDto.getFg_mm())) {
			sb.append(" and srv1.id_srv=? ");
		}else {
			sb.append(" and srv1.id_srv=? and bd_mm.id_mm=? ");
		}
		SqlParam sqlParam = new SqlParam();
		if (FBoolean.FALSE.equals(bizDto.getFg_mm())) {
			sqlParam.addParam(bizDto.getId_srv());
		}else {
			sqlParam.addParam(bizDto.getId_srv());
			sqlParam.addParam(bizDto.getId_mm());
		}
		DAFacade daFacade = new DAFacade();
		ArrayList<String> list;
		try {
			list = (ArrayList<String>)daFacade.execQuery(sb.toString(), sqlParam, new ColumnListHandler());
			if (list.size()<=0) {
				return null;
			}
			if (list.size()>1) {
				throw new BizException("门诊记账数据组装错误：通用医保目录等级查询出多条，请检查后重试！");
			}
			return list.get(0);
		} catch (BizException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 组装门诊重收记账数据
	 * @param oldHeadDO
	 * @param accSet
	 * @return
	 * @throws BizException
	 */
	public static BlCgOepDO buildReHeadCgData(BlCgOepDO oldHeadDO, BlCgRefundAccountSetDTO accSet) throws BizException {
		
		BlCgOepDO cgHeadDO = new BlCgOepDO();
		cgHeadDO.setId_grp(Context.get().getGroupId());
		cgHeadDO.setId_org(Context.get().getOrgId());
		cgHeadDO.setCode_cg(new GetCodeByCustomization().GetCodeBlCgOep());
		cgHeadDO.setId_pat(oldHeadDO.getId_pat());
		cgHeadDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		cgHeadDO.setDt_cg(oldHeadDO.getDt_cg());
		cgHeadDO.setId_org_cg(oldHeadDO.getId_org_cg());
		cgHeadDO.setId_dep_cg(oldHeadDO.getId_dep_cg());
		cgHeadDO.setId_emp_cg(oldHeadDO.getId_emp_cg());
		cgHeadDO.setStatus(DOStatus.NEW);
		return cgHeadDO;
	}
	
	/**
	 * 组装门诊重收记账数据
	 * @param oldItmDO
	 * @param quan
	 * @param accSet
	 * @return
	 */
	public static BlCgItmOepDO buildReCgData(BlCgItmOepDO oldItmDO, FDouble quan, BlCgRefundAccountSetDTO accSet){
		
		BlCgItmOepDO cgDO = (BlCgItmOepDO)oldItmDO.clone();
		cgDO.setId_cgoep(null);
		cgDO.setId_cgitmoep(null);
		cgDO.setQuan(quan);
		cgDO.setAmt(cgDO.getPrice_ratio().multiply(cgDO.getQuan(),IBlConst.PRECISION_AMOUNT));
		cgDO.setAmt_std(cgDO.getPrice().multiply(cgDO.getQuan(), IBlConst.PRECISION_AMOUNT));
		cgDO.setAmt_ratio(cgDO.getAmt());
		cgDO.setAmt_pat(cgDO.getAmt());
		cgDO.setAmt_hp(FDouble.ZERO_DBL);
		
		if(FBoolean.TRUE.equals(cgDO.getFg_acc())){
			cgDO.setAmt_acc(cgDO.getAmt_ratio());
		}
		
		cgDO.setFg_refund(FBoolean.FALSE);
		cgDO.setStatus(DOStatus.NEW);
		
		return cgDO;
	}
	
	/**
	 * 组装红冲门诊记账数据
	 * @param blcgoepAggDO
	 * @param accSet
	 * @param dataWh
	 * @return
	 */
	public static BlcgoepAggDO buildRedCgData(BlcgoepAggDO blcgoepAggDO,BlCgRefundAccountSetDTO accSet,
			BlCgAccDataWarehouse dataWh) throws BizException {
		
		BlcgoepAggDO redAgg = new BlcgoepAggDO();
		
		BlCgOepDO redHeadDO = (BlCgOepDO)blcgoepAggDO.getParentDO().clone();
		redHeadDO.setId_cgoep(null);
		redHeadDO.setCode_cg(new GetCodeByCustomization().GetCodeBlCgOep());
		redHeadDO.setDt_cg(BlFlowContextUtil.getNowTime());
		redHeadDO.setId_org_cg(accSet.getId_org_cg());
		redHeadDO.setId_dep_cg(accSet.getId_dep_cg());
		redHeadDO.setId_emp_cg(accSet.getId_emp_cg());
		redHeadDO.setEu_direct(BookRtnDirectEnum.REFUND);
		redHeadDO.setStatus(DOStatus.NEW);
		
		List<BlCgItmOepDO> redItmList = new ArrayList<BlCgItmOepDO>();
		for (BlCgItmOepDO itmDO : blcgoepAggDO.getBlCgItmOepDO()) {
			
			BlCgItmOepDO redItmDO = (BlCgItmOepDO)itmDO.clone();
			redItmDO.setId_cgoep(null);
			redItmDO.setId_cgitmoep(null);
			redItmDO.setId_par(itmDO.getId_cgitmoep());
			redItmDO.setNote("退费，对象：【" + itmDO.getId_cgitmoep() + "】");
			redItmDO.setStatus(DOStatus.NEW);
			
			redItmList.add(redItmDO);
		}
		
		redAgg.setParentDO(redHeadDO);
		redAgg.setBlCgItmOepDO(redItmList.toArray(new BlCgItmOepDO[0]));
		
		return redAgg;
	}
}
