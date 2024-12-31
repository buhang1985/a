package iih.bl.st.blstaroep.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import iih.bd.base.utils.SqlUtils;
//import MdWfCaDO;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.hp.d.BdHpKindDO;
import iih.bd.pp.hp.d.BdHpPrestpDO;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.d.HpDepDO;
import iih.bd.pp.hp.d.HpDosageDO;
import iih.bd.pp.hp.d.HpFreqDO;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendOutpBillParamDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.bl.comm.BlBizUtil;
//import iih.bl.cg.service.d.RecipeDTO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.bl.st.dto.d.BlEntVsCodeHp;
import iih.bl.st.dto.d.InsurUnitDepFreqDoseDTO;
//import iih.bl.st.dto.d.OrdSrvSettlementDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;
import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.pv.dto.d.OpBasicDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.i.IEnOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.EmpPhyDO;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IEmpPhyDORService;
import xap.sys.bdfw.bbd.i.IPsndocRService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

//import iih.bl.inc.blinciss.Service.i.IBLInvoiceService;
/**
 * 门诊结算：提取数据业务逻辑
 * 
 * @author tcy
 *
 */
public class BlStarOepBp {

	/**
	 * 按到处方收费：获取患者在本组织下的某个时间段内的医嘱信息和医嘱对应服务的价格信息
	 * 
	 * @param id_pat
	 * @param id_org
	 * @param DefaultDaysStOep
	 *            默认提取天数，如果为0，则默认调入当天费用信息，按自然日计算
	 * @return
	 * @throws BizException
	 */
	public List<BlOrderAppendBillParamDTO> getOrderSrvPrinceInfoByIdpres_1(String id_pat, String id_org, int DefaultDaysStOep) throws BizException {
		FDateTime dtSignB;
		FDateTime dtSignE;

		TimeService timeService = new TimeServiceImpl();
		dtSignE = timeService.getUFDateTime();
		if (DefaultDaysStOep == 0) {
			dtSignB = new FDateTime(dtSignE.getDate().toString() + " 00:00:00");
		} else {
			dtSignB = new FDateTime(dtSignE.getDateTimeBefore(DefaultDaysStOep - 1).getDate().toString() + " 00:00:00"); // 自然日，含当日
		}
		return getOrderSrvPrinceInfoByIdpres(id_pat, dtSignB, dtSignE, id_org);
	}

	/**
	 * 按到处方收费：获取患者在本组织下的某个时间段内的医嘱信息和医嘱对应服务的价格信息
	 * 
	 * @param id_pat
	 * @param id_org
	 * @param DefaultDaysStOep
	 *            点击“调入”菜单，默认提取的天数，按自然日计算
	 * @return
	 * @throws BizException
	 */
	public List<BlOrderAppendBillParamDTO> getOrderSrvPrinceInfoByIdpres_load(String id_pat, String id_org, int DefaultDaysLoadOep) throws BizException {
		FDateTime dtSignB;
		FDateTime dtSignE;
		// 先取200天之内的未结算医嘱
		TimeService timeService = new TimeServiceImpl();
		dtSignE = timeService.getUFDateTime();
		dtSignB = new FDateTime(dtSignE.getDateTimeBefore(DefaultDaysLoadOep - 1).getDate().toString() + " 00:00:00");// 自然日，含当日

		return getOrderSrvPrinceInfoByIdpres(id_pat, dtSignB, dtSignE, id_org);
	}

	/**
	 * 调入待结算的费用信息、调入未记账的医嘱信息 1.查看是否有挂起的费用，若有，则优先处理 1.1.挂号费必须优先结算 1.2.预付费必须优先结算
	 * 1.3.如果既有挂号费又有预付款，则优先结算挂号费 1.4.其他属于（挂起费用&&非挂号费&&非预付费）必须删除（处理划价后就断电这个非正常数据）
	 * 如果没有1，则继续第2步 2.以下数据包括两部分：2.1.补费接口产生的数据（如果有挂号产出的数据，需要单独结算）;
	 * 2.2.未结账的门急诊医嘱信息
	 * 
	 * @param id_pat
	 * @param dtSignB
	 * @param dtSignE
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public List<BlOrderAppendBillParamDTO> getOrderSrvPrinceInfoByIdpres(String id_pat, FDateTime dtSignB, FDateTime dtSignE, String id_org) throws BizException {

		List<BlOrderAppendBillParamDTO> orgSrvList = new ArrayList<BlOrderAppendBillParamDTO>();// 展示数据列表

		// 获取计量单位列表
		Map<String, MeasDocDO> measMap = new HashMap<String, MeasDocDO>();// 计量单位字典
		measMap = this.setMeasDocDOMap();

		// 1.查看是否有挂起的费用，若有，则优先处理
		// 根据患者id和组织id，获取已记账医嘱信息
		List<BlCgItmOepDO> blCgItmOrpList = this.getBlCgOepOrder(id_pat, id_org, BookRtnDirectEnum.CHARGE);
		List<BlCgItmOepDO> blCgItmOrpList_register_disp = new ArrayList<BlCgItmOepDO>(); // 优先结算的挂号费
		List<BlCgItmOepDO> blCgItmOrpList_ci_disp = new ArrayList<BlCgItmOepDO>(); // 排除挂号费的必须结算的其他费用
		// 检查是否有挂起的数据
		// FBoolean fg_deletePricing=FBoolean.FALSE;
		//
		List<String> delete_id_cgoepLst = new ArrayList<String>();
		// 1.挂号费必须结算
		// 2.预付费必须结算
		// 3.如果既有挂号费又有预付款，则优先结算挂号费
		// 4.其他属于（挂起费用&&非挂号费&&非预付费）必须删除
		if (blCgItmOrpList != null && blCgItmOrpList.size() > 0) {
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOrpList) // 已记账，未收款的费用信息
			{
				// 1.挂号费必须结算，且优先结算,不管有没有预付款（满足条件1,3）
				if (blCgItmOepDO.getEu_srctp() != null && blCgItmOepDO.getEu_srctp() == FeeOriginEnum.ENCOUNTER_FEE) {
					blCgItmOrpList_register_disp.add(blCgItmOepDO);
					continue;
				}
				// 2.预付费与高端商保必须结算
				if ((blCgItmOepDO.getFg_acc() != null && blCgItmOepDO.getFg_acc().booleanValue()) || (blCgItmOepDO.getFg_hpcg() != null && blCgItmOepDO.getFg_hpcg().booleanValue())) {
					blCgItmOrpList_ci_disp.add(blCgItmOepDO);
					continue;
				}
				// 4.其他属于（挂起费用&&非挂号费&&非预付费）必须删除
				if (blCgItmOepDO.getFg_susp() != null && blCgItmOepDO.getFg_susp().booleanValue()) {
					if (!delete_id_cgoepLst.contains(blCgItmOepDO.getId_cgoep())) {
						delete_id_cgoepLst.add(blCgItmOepDO.getId_cgoep());
					}
				}
			}
			// 如果可以取消划价，则取消划价
			if (delete_id_cgoepLst.size() > 0) {
				IBLCiOrderToBlCgService iBLCiOrderToBlCgService = ServiceFinder.find(IBLCiOrderToBlCgService.class);
				if (iBLCiOrderToBlCgService.DeleteOepPricingInfo(delete_id_cgoepLst.toArray(new String[0])).booleanValue()) {
					return orgSrvList;
				}
			}
		}

		// 返回挂起的医嘱和当天未结算的医嘱信息
		// 1.挂号费
		if (blCgItmOrpList_register_disp != null && blCgItmOrpList_register_disp.size() > 0) {
			Boolean flag = this.setBlCgItemOepShow(blCgItmOrpList_register_disp, orgSrvList, measMap);
			if (flag) {
				return getBlOrderAppendBillParamDTOWithReciptDTOs(orgSrvList);
			}
		}
		// 2.已记账费用，预交金费用和高端商保记账费用
		if (blCgItmOrpList_ci_disp != null && blCgItmOrpList_ci_disp.size() > 0) {
			Boolean flag = this.setBlCgItemOepShow(blCgItmOrpList_ci_disp, orgSrvList, measMap);
			if (flag) {
				return getBlOrderAppendBillParamDTOWithReciptDTOs(orgSrvList);
			}
		}

		// 2.以下数据包括两部分：2.1.补费接口产生的数据（如果有挂号产出的数据，需要单独结算）; 2.2.未结账的医嘱信息

		// 2.1.补费产生的数据,如果是挂号费，则优先
		FArrayList recipeDTOLst = new FArrayList();
		List<BlOrderAppendBillParamDTO> append_orgSrvList = new ArrayList<BlOrderAppendBillParamDTO>();// 展示数据列表
		List<BlCgItmOepDO> append_BlCgItmOrpList = this.get_Append_BlCgOep(id_pat, id_org, BookRtnDirectEnum.CHARGE);
		List<BlOrderAppendBillParamDTO> append_orgSrvList_register = new ArrayList<BlOrderAppendBillParamDTO>();// 展示数据列表

		List<String> id_presLst = new ArrayList<String>();
		// 结构转换
		if (append_BlCgItmOrpList != null && append_BlCgItmOrpList.size() > 0) {
			this.setBlCgItemOepShow(append_BlCgItmOrpList, append_orgSrvList, measMap);
			// 检查是否有挂号费，挂号费优先
			for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO1 : append_orgSrvList) {
				if (blOrderAppendBillParamDTO1.getEu_srctp() != null && blOrderAppendBillParamDTO1.getEu_srctp() == FeeOriginEnum.ENCOUNTER_FEE)// 来源于挂号
				{
					append_orgSrvList_register.add(blOrderAppendBillParamDTO1);
				}
			}
			if (append_orgSrvList_register != null && append_orgSrvList_register.size() > 0) {
				// 若有挂号费，优先处理挂号费
				return getBlOrderAppendBillParamDTOWithReciptDTOs(append_orgSrvList_register);
			}
		}

		// 2.2根据患者id和组织id，分别获取门诊未结账医嘱信息
		ICiOrdQryService service = (ICiOrdQryService) ServiceFinder.find(ICiOrdQryService.class);
		PrescriptionConstBaseDto prescriptionConstBaseDto = service.getPrescriptionConstBaseDto(id_pat, dtSignB, dtSignE, IBdFcDictCodeConst.SD_CODE_ENTP_OP, id_org);
		if (prescriptionConstBaseDto != null) {
			// 未结账的医嘱信息
			FArrayList PrescriptionCostDtoLst = prescriptionConstBaseDto.getPrescriptionCostDto();
			if (PrescriptionCostDtoLst != null && PrescriptionCostDtoLst.size() > 0) {
				
				//查询就诊医保计划
				List<String> entIdList = new ArrayList<String>();
				for (int i = 0; i < PrescriptionCostDtoLst.size(); i++) {
					PrescriptionCostDto presDto = (PrescriptionCostDto) PrescriptionCostDtoLst.get(i);
					if(!StringUtil.isEmpty(presDto.getId_en()) && !entIdList.contains(presDto.getId_en())){
						entIdList.add(presDto.getId_en());
					}
				}
				
				Map<String,String> entHpMap = new HashMap<String,String>();
				if(entIdList.size() > 0){
					IEnthpRService entHpService = ServiceFinder.find(IEnthpRService.class);
					EntHpDO[] hpDos = entHpService.find(SqlUtils.getInSqlByIds("a0.id_ent", entIdList)  + " and fg_maj = 'Y' ", null, FBoolean.FALSE);
					
					if(!ArrayUtil.isEmpty(hpDos)){
						for (EntHpDO entHpDO : hpDos) {
							entHpMap.put(entHpDO.getId_ent(), entHpDO.getId_hp());
						}
					}
				}
				
				for (int i = 0; i < PrescriptionCostDtoLst.size(); i++) {
					BlOrderAppendBillParamDTO blOrderAppendBillParamDTO = new BlOrderAppendBillParamDTO();
					PrescriptionCostDto presDto = (PrescriptionCostDto) PrescriptionCostDtoLst.get(i);
					
					String hpId = null;
					if(!StringUtil.isEmpty(presDto.getId_en())){
						hpId = entHpMap.get(presDto.getId_en());
					}
					
					blOrderAppendBillParamDTO = setBlOrderShow_Idpres(presDto, measMap, hpId);
					orgSrvList.add(blOrderAppendBillParamDTO);
				}
				FArrayList recipeDTOLstMz = prescriptionConstBaseDto.getRecipeDTO();
				recipeDTOLst.addAll(recipeDTOLstMz);
				// 挂号交易流水号
				Map<String, List<BlEntVsCodeHp>> id_entMap = new HashMap<String, List<BlEntVsCodeHp>>();// 从效率考虑
				List<BlEntVsCodeHp> blEntVsCodeHpLst = null;
				RecipeDTO[] recipeDTOArr = (RecipeDTO[]) recipeDTOLstMz.toArray(new RecipeDTO[0]);
				for (RecipeDTO recipeDTO : recipeDTOArr) {
					if (!id_entMap.containsKey(recipeDTO.getId_en())) {
						StringBuffer sqlb = new StringBuffer();
						sqlb.append("select distinct a.id_ent, d.code_hp ");
						sqlb.append("   from bl_cg_itm_oep a, bl_st_oep b, bl_prop_oep c, BL_PROP_AR_OEP d ");
						sqlb.append("  where a.id_stoep = b.id_stoep ");
						sqlb.append("    and b.id_stoep = c.id_stoep ");
						sqlb.append("    AND C.ID_PROPOEP=D.ID_PROPOEP ");
						sqlb.append("    and a.id_ent = ? ");
						sqlb.append("    and a.eu_srctp = 1 and b.eu_direct=1 and a.fg_refund='N'");
						SqlParam sqlp = new SqlParam();
						sqlp.addParam(recipeDTO.getId_en());
						DAFacade dafacade = new DAFacade();
						blEntVsCodeHpLst = (List<BlEntVsCodeHp>) dafacade.execQuery(sqlb.toString(), sqlp, new BeanListHandler(BlEntVsCodeHp.class));
						id_entMap.put(recipeDTO.getId_en(), blEntVsCodeHpLst);
					} else {
						blEntVsCodeHpLst = id_entMap.get(recipeDTO.getId_en());
					}
					if (blEntVsCodeHpLst != null && blEntVsCodeHpLst.size() > 0) {
						recipeDTO.setRegistertradeno(blEntVsCodeHpLst.toArray(new BlEntVsCodeHp[0])[0].getCode_hp());
					}
				}
			}
		}

		// /急诊的情况，暂时这样处理
		PrescriptionConstBaseDto prescriptionConstBaseDto1 = service.getPrescriptionConstBaseDto(id_pat, dtSignB, dtSignE, IBdFcDictCodeConst.SD_CODE_ENTP_ET, id_org);
		if (prescriptionConstBaseDto1 != null) {
			// 未结账的医嘱信息
			FArrayList PrescriptionCostDtoLst = prescriptionConstBaseDto1.getPrescriptionCostDto();
			if (PrescriptionCostDtoLst != null && PrescriptionCostDtoLst.size() > 0) {
				for (int i = 0; i < PrescriptionCostDtoLst.size(); i++) {
					BlOrderAppendBillParamDTO blOrderAppendBillParamDTO = new BlOrderAppendBillParamDTO();
					blOrderAppendBillParamDTO = setBlOrderShow_Idpres((PrescriptionCostDto) PrescriptionCostDtoLst.get(i), measMap, null);
					orgSrvList.add(blOrderAppendBillParamDTO);
				}
				FArrayList recipeDTOLstJZ = prescriptionConstBaseDto1.getRecipeDTO();
				recipeDTOLst.addAll(recipeDTOLstJZ);
				// 挂号交易流水号
				Map<String, List<BlEntVsCodeHp>> id_entMap = new HashMap<String, List<BlEntVsCodeHp>>();// 从效率考虑
				List<BlEntVsCodeHp> blEntVsCodeHpLst = null;
				RecipeDTO[] recipeDTOArr = (RecipeDTO[]) recipeDTOLstJZ.toArray(new RecipeDTO[0]);
				for (RecipeDTO recipeDTO : recipeDTOArr) {
					if (!id_entMap.containsKey(recipeDTO.getId_en())) {
						StringBuffer sqlb = new StringBuffer();
						sqlb.append("select distinct a.id_ent, d.code_hp ");
						sqlb.append("   from bl_cg_itm_oep a, bl_st_oep b, bl_prop_oep c, BL_PROP_AR_OEP d ");
						sqlb.append("  where a.id_stoep = b.id_stoep ");
						sqlb.append("    and b.id_stoep = c.id_stoep ");
						sqlb.append("    AND C.ID_PROPOEP=D.ID_PROPOEP ");
						sqlb.append("    and a.id_ent = ? ");
						sqlb.append("    and a.eu_srctp = 1 and b.eu_direct=1 and a.fg_refund='N'");
						SqlParam sqlp = new SqlParam();
						sqlp.addParam(recipeDTO.getId_en());
						DAFacade dafacade = new DAFacade();
						blEntVsCodeHpLst = (List<BlEntVsCodeHp>) dafacade.execQuery(sqlb.toString(), sqlp, new BeanListHandler(BlEntVsCodeHp.class));
						id_entMap.put(recipeDTO.getId_en(), blEntVsCodeHpLst);
					} else {
						blEntVsCodeHpLst = id_entMap.get(recipeDTO.getId_en());
					}
					if (blEntVsCodeHpLst != null && blEntVsCodeHpLst.size() > 0) {
						recipeDTO.setRegistertradeno(blEntVsCodeHpLst.toArray(new BlEntVsCodeHp[0])[0].getCode_hp());
					}
				}
			}
		}
		// 2.3增加处方DTO
		if (orgSrvList.size() > 0) {
			if (recipeDTOLst == null) {
				orgSrvList.toArray(new BlOrderAppendBillParamDTO[0])[0].setRecipeDTO(null);
			} else {
				orgSrvList.toArray(new BlOrderAppendBillParamDTO[0])[0].setRecipeDTO(recipeDTOLst);
			}
			// 2.4.校验，看看是不是无卡的医保病人,同时设置：就诊科室名称，价格分类名称，患者分类名称
			orgSrvList = doSetDTOFg_insurWithoutCard(orgSrvList);
		}
		return orgSrvList;
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
	 * @return
	 * @throws BizException
	 */
	public List<BlOrderAppendBillParamDTO> getNoSettlementSrvPriceInfoByIdent(String id_ent, String[] sd_su_bl, String id_pat, int days) throws BizException {
		// 获取计量单位列表
		Map<String, MeasDocDO> measMap = new HashMap<String, MeasDocDO>();// 计量单位字典
		measMap = this.setMeasDocDOMap();
		List<BlOrderAppendBillParamDTO> orgSrvList = new ArrayList<BlOrderAppendBillParamDTO>();// 展示数据列表

		// 1.数据来源于CI
		List<BlOrderAppendBillParamDTO> orgSrvList1 = new ArrayList<BlOrderAppendBillParamDTO>();// 展示数据列表
		orgSrvList1 = getOrderSrvPrinceInfoByIdent(id_ent, sd_su_bl);

		// 2.数据来源于CG
		List<BlOrderAppendBillParamDTO> orgSrvList2 = new ArrayList<BlOrderAppendBillParamDTO>();
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().getDateTimeBefore(days).toLocalString();
		List<BlCgItmOepDO> blCgItmOrpList = this.getBlCgOepOrderByIdPat_hpcg(id_pat, new FDateTime(strDateTime), BookRtnDirectEnum.CHARGE);
		if (blCgItmOrpList != null && blCgItmOrpList.size() > 0) {
			setBlCgItemOepShow(blCgItmOrpList, orgSrvList2, measMap);
		}

		// 3.组合1，2的数据
		if (orgSrvList1 != null && orgSrvList1.size() > 0) {
			orgSrvList.addAll(orgSrvList1);
		}
		if (orgSrvList2 != null && orgSrvList2.size() > 0) {
			orgSrvList.addAll(orgSrvList2);
		}

		return orgSrvList;
	}

	/**
	 * 第三方接口：根据id_pres+id_ent找到对应的待收费明细信息
	 * 
	 * @param id_pres_app
	 *            给app的处方号
	 * @param id_ent
	 *            就诊id
	 * @return
	 * @throws BizException
	 */
	public List<BlOrderAppendBillParamDTO> getOrderSrvPrinceInfoByIdpres_ws(String id_pres_app, String id_ent) throws BizException {
		List<BlOrderAppendBillParamDTO> orgSrvList = new ArrayList<BlOrderAppendBillParamDTO>();// 展示数据列表
		ICiOrdQryService service = (ICiOrdQryService) ServiceFinder.find(ICiOrdQryService.class);
		// PrescriptionConstBaseDto prescriptionConstBaseDto =
		// service.??(id_pres, id_ent); //问李政，找到新接口后，打开以下注释
		// if (prescriptionConstBaseDto != null)
		// {
		// //未结账的医嘱信息
		// FArrayList PrescriptionCostDtoLst =
		// prescriptionConstBaseDto.getPrescriptionCostDto();
		// for (int i = 0; i < PrescriptionCostDtoLst.size(); i++)
		// {
		// BlOrderAppendBillParamDTO blOrderAppendBillParamDTO = new
		// BlOrderAppendBillParamDTO();
		// blOrderAppendBillParamDTO =
		// setBlOrderShow_Idpres((PrescriptionCostDto)
		// PrescriptionCostDtoLst.get(i), measMap);
		// orgSrvList.add(blOrderAppendBillParamDTO);
		// }
		// }
		return orgSrvList;
	}

	/**
	 * 按就诊id，医嘱费用状态，提取对应状态的已签署医嘱
	 * 
	 * @param id_ent
	 *            就诊id
	 * @param sd_su_bl
	 *            医嘱费用状态。0：未记账；1：已记账；2：已退费；
	 * @return Liwq 临时方案
	 * @throws BizException
	 */
	public List<BlOrderAppendBillParamDTO> getOrderSrvPrinceInfoByIdent(String id_ent, String[] sd_su_bl) throws BizException {
		List<BlOrderAppendBillParamDTO> orgSrvList = new ArrayList<BlOrderAppendBillParamDTO>();// 展示数据列表
		// 获取计量单位列表
		Map<String, MeasDocDO> measMap = new HashMap<String, MeasDocDO>();// 计量单位字典
		measMap = this.setMeasDocDOMap();
		
		//查询就诊医保计划
		IEnthpRService entHpService = ServiceFinder.find(IEnthpRService.class);
		EntHpDO[] hpDos = entHpService.find("a0.id_ent = '" +id_ent+"' and fg_maj = 'Y' ", null, FBoolean.FALSE);
		String hpId = null;
		if(!ArrayUtil.isEmpty(hpDos)){
			hpId = hpDos[0].getId_hp();
		}
		
		// 2.2根据患者id和组织id，分别获取门诊未结账医嘱信息
		ICiOrdQryService service = (ICiOrdQryService) ServiceFinder.find(ICiOrdQryService.class);
		PrescriptionConstBaseDto prescriptionConstBaseDto = service.getPrescriptionConstAccounting(id_ent, sd_su_bl);
		if (prescriptionConstBaseDto != null) {
			// 2.2.1 未结账的医嘱信息
			FArrayList PrescriptionCostDtoLst = prescriptionConstBaseDto.getPrescriptionCostDto();
			for (int i = 0; i < PrescriptionCostDtoLst.size(); i++) {
				BlOrderAppendBillParamDTO blOrderAppendBillParamDTO = new BlOrderAppendBillParamDTO();
				blOrderAppendBillParamDTO = setBlOrderShow_Idpres((PrescriptionCostDto) PrescriptionCostDtoLst.get(i), measMap, hpId);
				//当前数据不是外配处方时进行返回
				if(!FBoolean.TRUE.equals(blOrderAppendBillParamDTO.getFg_extdispense()))
					orgSrvList.add(blOrderAppendBillParamDTO);
			}
			for (BlOrderAppendBillParamDTO dto : orgSrvList) {
				dto.setSupportAppendBill(FBoolean.FALSE);// 强制不允许后付费
				dto.setEu_direct(1);
			}
			// 2.2.2计价
			// TODO:因为不显示价格
			// if(sd_su_bl[0].equals("0")) 因为不展示价格 todo
			// {
			// IBLCiOrderToBlCgService
			// iBLCiOrderToBlCgService=ServiceFinder.find(IBLCiOrderToBlCgService.class);
			// orgSrvList=
			// iBLCiOrderToBlCgService.computePrice(orgSrvList.toArray(new
			// BlOrderAppendBillParamDTO[0]));
			// }

		}
		return orgSrvList;

	}

	/**
	 * 校验，看看是不是无卡的医保病人
	 * 
	 * @param orgSrvList
	 * @return
	 * @throws BizException
	 */
	private List<BlOrderAppendBillParamDTO> doSetDTOFg_insurWithoutCard(List<BlOrderAppendBillParamDTO> orgSrvList) throws BizException {
		// 就诊主键集合
		List<String> strIdEntLst = new ArrayList<String>();
		Map<String, OpBasicDTO> entOpBasicDtoMp = new HashMap<String, OpBasicDTO>();
		Map<String, EntHpDO[]> entHpMp = new HashMap<String, EntHpDO[]>();
		// 医保计划查询服务
		IEnthpRService iEnthpRService = ServiceFinder.find(IEnthpRService.class);
		for (BlOrderAppendBillParamDTO dto : orgSrvList) {
			dto.setFg_insurWithoutCard(FBoolean.FALSE);// 默认不是无卡的医保患者
			dto.setFg_cardregister(FBoolean.FALSE);// 持卡挂号
			// 初始化医保计划
			EntHpDO[] entHpDOs = new EntHpDO[0];
			OpBasicDTO opBasicDto = null;
			if (!strIdEntLst.contains(dto.getId_ent())) {
				strIdEntLst.add(dto.getId_ent());
				// 查询就诊对应的医保计划
				entHpDOs = iEnthpRService.find(" id_ent='" + dto.getId_ent() + "'", "", FBoolean.FALSE);
				// 就诊和就诊的医保计划对应关系是1对1
				entHpMp.put(dto.getId_ent(), entHpDOs);
				IEnOutQryService entOutService = ServiceFinder.find(IEnOutQryService.class);
				// 获取就诊门诊属性信息
				opBasicDto = entOutService.getOpBasicInfo(dto.getId_ent());
				entOpBasicDtoMp.put(dto.getId_ent(), opBasicDto);
			} else {
				entHpDOs = entHpMp.get(dto.getId_ent());
				opBasicDto = entOpBasicDtoMp.get(dto.getId_ent());
			}
			// 如果医保计划有值，代表选用了医保计划
			if (entHpDOs.length > 0) {
				if (entHpDOs[0].getFg_hp_card().booleanValue()) {
					dto.setFg_cardregister(FBoolean.TRUE);
				}

				// 医保计划+基金支付+不持卡，是无卡医保患者
				if (entHpDOs[0].getId_hp() != null && (entHpDOs[0].getFg_fundpay() != null && entHpDOs[0].getFg_fundpay().booleanValue())
						&& (entHpDOs[0].getFg_hp_card() != null && !entHpDOs[0].getFg_hp_card().booleanValue())) {
					dto.setFg_insurWithoutCard(FBoolean.TRUE);// 是无卡的医保患者
				}
			}
			if (!dto.getId_pripat().equals(opBasicDto.getId_pripat())) {
				throw new BizException("患者价格分类信息有更改，请确认！当前患者价格分类为" + opBasicDto.getName_pripat());
			}
			dto.setId_pripat(opBasicDto.getId_pripat());
			// 患者价格分类
			dto.setId_pripat_name(opBasicDto.getName_pripat());
			// 患者分类
			dto.setId_paticate_name(opBasicDto.getName_patca());
			// 就诊科室名称
			dto.setId_dep_phy_name(opBasicDto.getName_dep_phy());
			// 就诊次数
			dto.setEnt_times(opBasicDto.getTimes_op());
		}
		return orgSrvList;
	}

	/**
	 * 返回带处方信息数组的未记账信息
	 * 
	 * @param orgSrvList
	 *            未记账信息
	 * @return 带处方信息数组的未记账信息
	 * @throws BizException
	 */
	private List<BlOrderAppendBillParamDTO> getBlOrderAppendBillParamDTOWithReciptDTOs(List<BlOrderAppendBillParamDTO> orgSrvList) throws BizException {
		FArrayList recipeDTOLst = getRecipeDTO_BlOrderAppendBillParamDTO(orgSrvList);
		if (orgSrvList.size() > 0) {
			// 根据id_ent查询id_pripat
			List<String> strIdEntLst = new ArrayList<String>();
			Map<String, OpBasicDTO> entOpMap = new HashMap<String, OpBasicDTO>();
			Map<String, List<EntHpDO>> entHpDoMap = new HashMap<String, List<EntHpDO>>();
			DAFacade dafacade = new DAFacade();
			String id_hp = "";
			String id_hpkind = "";
			FBoolean fg_hpspcl = null;

			Map<String, String> ent_pripat = new HashMap<String, String>();
			Map<String, String> ent_pripat_name = new HashMap<String, String>();
			Map<String, String> ent_paticate = new HashMap<String, String>();
			Map<String, String> ent_dep = new HashMap<String, String>();
			Map<String, String> ent_hp = new HashMap<String, String>();
			Map<String, String> ent_hpkind = new HashMap<String, String>();
			Map<String, FBoolean> ent_fg_hpspcl = new HashMap<String, FBoolean>();
			for (BlOrderAppendBillParamDTO dto : orgSrvList) {
				// review by yangyang 2017-06-08 尽量避免在循环里了调用查询，字段补充调用查询越少越好
				List<EntHpDO> entHpDOL = new ArrayList<EntHpDO>();
				OpBasicDTO opBasicDto = null;
				if (!strIdEntLst.contains(dto.getId_ent())) {
					strIdEntLst.add(dto.getId_ent());
					// 查询医保计划
					entHpDOL = (List<EntHpDO>) dafacade.findByCond(EntHpDO.class, " id_ent='" + dto.getId_ent() + "' and fg_maj='Y'");
					entHpDoMap.put(dto.getId_ent(), entHpDOL);

					// 获取就诊门诊属性信息
					IEnOutQryService entOutService = ServiceFinder.find(IEnOutQryService.class);
					opBasicDto = entOutService.getOpBasicInfo(dto.getId_ent());
					// 把就诊信息的门诊属性放入map里
					entOpMap.put(dto.getId_ent(), opBasicDto);

				} else {
					opBasicDto = entOpMap.get(dto.getId_ent());
					entHpDOL = entHpDoMap.get(dto.getId_ent());
				}
				if (opBasicDto == null)
					throw new BizException("未查询到患者就诊对应的门诊属性");
				if (!dto.getId_pripat().equals(opBasicDto.getId_pripat())) {
					throw new BizException("患者价格分类信息有更改，请确认！当前患者价格分类为" + opBasicDto.getName_pripat());
				}
				dto.setId_pripat(opBasicDto.getId_pripat());
				// 患者价格分类
				dto.setId_pripat_name(opBasicDto.getName_pripat());
				// 患者分类
				dto.setId_paticate_name(opBasicDto.getName_patca());
				// 就诊科室名称
				dto.setId_dep_phy_name(opBasicDto.getName_dep_phy());
				// 就诊次数
				dto.setEnt_times(opBasicDto.getTimes_op());
				// 外配处方，肯定是药品，切必须从医嘱过来，这里不用重新查询一遍，后期迭代掉
				if (dto.getSd_srvtp().startsWith("01") && dto.getId_hp() != null) // 药品
				{
					List<OrdSrvDO> ordSrvDOL = (List<OrdSrvDO>) dafacade.findByCond(OrdSrvDO.class, " id_orsrv='" + dto.getId_orsrv() + "' ");
					if (ordSrvDOL != null && ordSrvDOL.size() > 0) {
						dto.setFg_extdispense(ordSrvDOL.toArray(new OrdSrvDO[0])[0].getFg_extdispense()); // 是否外配处方
					}
				}
			}
			if (recipeDTOLst != null && recipeDTOLst.size() > 0) {
				orgSrvList.toArray(new BlOrderAppendBillParamDTO[0])[0].setRecipeDTO(recipeDTOLst);

			} else {
				orgSrvList.toArray(new BlOrderAppendBillParamDTO[0])[0].setRecipeDTO(null);
			}
		}
		return orgSrvList;
	}

	/**
	 * 根据处方号数组，获得该数组下的处方信息（药品）
	 * 
	 * @param id_presArr处方号数组
	 * @return 处方信息
	 * @throws BizException
	 */
	private RecipeDTO[] getRecipeDTOByIdPres_drug(String[] id_presArr) throws BizException {
		ICiOrdQryService iCiOrdQryService = ServiceFinder.find(ICiOrdQryService.class);
		return iCiOrdQryService.getRecipeDTOByIdPres(id_presArr);
	}

	/**
	 * 根据bl_cg_itm_oep中检查检验对应的处方号数组，获得该数组下的处方信息（检查检验）
	 * 
	 * @param id_presArr处方号数组
	 * @return 处方信息
	 * @throws BizException
	 */
	private RecipeDTO[] getRecipeDTOByIdPres_exam(String[] id_presArr) throws BizException {
		ICiOrdQryService iCiOrdQryService = ServiceFinder.find(ICiOrdQryService.class);
		return iCiOrdQryService.getRecipeDTOByCodeOr(id_presArr);
	}

	/**
	 * 返回未结算记账表中的处方信息
	 * 
	 * @param blOrderAppendBillParamDTOLst
	 *            未结算的记账表
	 * @return 处方信息数组
	 * @throws BizException
	 */
	private FArrayList getRecipeDTO_BlOrderAppendBillParamDTO(List<BlOrderAppendBillParamDTO> blOrderAppendBillParamDTOLst) throws BizException {
		FArrayList recipeDTOLst = new FArrayList();
		List<String> id_pres_drug_Lst = new ArrayList<String>();
		List<String> id_pres_exam_Lst = new ArrayList<String>();
		if (blOrderAppendBillParamDTOLst != null && blOrderAppendBillParamDTOLst.size() > 0) {
			// 若有挂号费，优先处理挂号费
			for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO1 : blOrderAppendBillParamDTOLst) {
				if (blOrderAppendBillParamDTO1.getEu_srctp() != null && !blOrderAppendBillParamDTO1.getEu_srctp().equals(FeeOriginEnum.ENCOUNTER_FEE)) // 排除挂号费
				{
					if (blOrderAppendBillParamDTO1.getSd_srvtp().indexOf("01") == 0) // 药品处方
					{
						if (!id_pres_drug_Lst.contains(blOrderAppendBillParamDTO1.getId_pres())) {
							id_pres_drug_Lst.add(blOrderAppendBillParamDTO1.getId_pres());
						}
					} else// 检查检验
					{
						if (!id_pres_exam_Lst.contains(blOrderAppendBillParamDTO1.getId_pres())) {
							id_pres_exam_Lst.add(blOrderAppendBillParamDTO1.getId_pres());
						}
					}
				}
			}
			if (id_pres_drug_Lst != null && id_pres_drug_Lst.size() > 0) {
				RecipeDTO[] RecipeDTO_drug = this.getRecipeDTOByIdPres_drug(id_pres_drug_Lst.toArray(new String[0]));
				for (RecipeDTO recipeDTO : RecipeDTO_drug) {
					recipeDTOLst.add(recipeDTO);
				}
			}
			if (id_pres_exam_Lst != null && id_pres_exam_Lst.size() > 0) {
				RecipeDTO[] RecipeDTO_exam = this.getRecipeDTOByIdPres_exam(id_pres_exam_Lst.toArray(new String[0]));
				for (RecipeDTO recipeDTO : RecipeDTO_exam) {
					recipeDTOLst.add(recipeDTO);
				}
			}
		}

		return recipeDTOLst;

	}

	// 判断是否包含已挂起的记账，并将记账医嘱加入展示列表
	public Boolean setBlCgItemOepShow(List<BlCgItmOepDO> blCgItmOrpList, List<BlOrderAppendBillParamDTO> orgSrvList, Map<String, MeasDocDO> measMap) throws BizException {
		Boolean flag = false; // 用以判断是否有已挂起的记账医嘱信息
		if (blCgItmOrpList != null && blCgItmOrpList.size() > 0) {
			List<String> idOrList = new ArrayList<String>();
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOrpList) {
				if (blCgItmOepDO.getId_or() != null) {
					if (!idOrList.contains(blCgItmOepDO.getId_or())) {
						idOrList.add(blCgItmOepDO.getId_or());
					}
				}
			}
			Map<String, CiOrderDO> ordMap = new HashMap<String, CiOrderDO>();
			if (idOrList != null && idOrList.size() > 0) {
				CiOrderDO[] orderDOArr = this.getCiOrderSrvOfOep(idOrList);// 获得CI_ORDER表中ID_OR,Name_OR
				if (orderDOArr != null && orderDOArr.length > 0) {
					for (CiOrderDO orderDO : orderDOArr) {
						ordMap.put(orderDO.getId_or(), orderDO);
					}
				}
			}
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOrpList) {
				if (ordMap.size() > 0) {
					CiOrderDO orderDO = ordMap.get(blCgItmOepDO.getId_or()); // 为了获得医嘱信息name_or
					orgSrvList.add(this.setBlOrderShow(orderDO, blCgItmOepDO, measMap));
				} else {
					orgSrvList.add(this.setBlOrderShow(null, blCgItmOepDO, measMap));
				}
				// 记录有挂起的记账医嘱信息
				if (!flag && blCgItmOepDO.getFg_susp().isValue() && !blCgItmOepDO.getFg_acc().booleanValue() && !blCgItmOepDO.getFg_hpcg().booleanValue() && orgSrvList.size() > 0) {
					flag = true;
				}
			}
		}
		return flag;
	}

	/**
	 * 获取计量单位列表
	 * 
	 * @throws BizException
	 * */
	public Map<String, MeasDocDO> setMeasDocDOMap() throws BizException {

		Map<String, MeasDocDO> measMap = new HashMap<String, MeasDocDO>();// 计量单位字典

		// 查询：调用轻量级的服务
		String[] fields = { "Id_measdoc", "Name" }; // 需要查询的列
		DAFacade dAFacade = new DAFacade();
		List<MeasDocDO> measDocDOList = (List<MeasDocDO>) dAFacade.findByCond(MeasDocDO.class, "1=1", "1", fields);
		if (measDocDOList != null && measDocDOList.size() > 0) {
			for (MeasDocDO measDocDO : measDocDOList) {
				if (measMap.get(measDocDO.getId_measdoc()) == null) {
					measMap.put(measDocDO.getId_measdoc(), measDocDO);
				}
			}
		}
		return measMap;
	}

	/**
	 * 获得包装单位：包装单位ID，包装单位名称
	 * 
	 * @return
	 * @throws BizException
	 */
	public MeasDocDO[] getMeasDocDOArr() throws BizException {

		// 查询：调用轻量级的服务
		String[] fields = { "Id_measdoc", "Name" }; // 需要查询的列
		DAFacade dAFacade = new DAFacade();
		List<MeasDocDO> measDocDOList = (List<MeasDocDO>) dAFacade.findByCond(MeasDocDO.class, "1=1", "1", fields);
		if (measDocDOList != null && measDocDOList.size() > 0) {
			return measDocDOList.toArray(new MeasDocDO[0]);
		} else {
			return null;
		}
	}

	/**
	 * 获得:需要分摊的医保计划，包装单位，医保科别，医保剂型，医保频率
	 * 
	 * @return
	 * @throws BizException
	 */
	public InsurUnitDepFreqDoseDTO getInsurUnitDepFreqDoseDTO() throws BizException {
		InsurUnitDepFreqDoseDTO insurUnitDepFreqDoseDTO = new InsurUnitDepFreqDoseDTO();
		FArrayList idHpList = new FArrayList();
		FArrayList unitList = new FArrayList();
		FArrayList depList = new FArrayList();
		FArrayList freqList = new FArrayList();
		FArrayList dosageList = new FArrayList();
		FArrayList presTpLst = new FArrayList();
		FArrayList hpdoList = new FArrayList();
		FArrayList bdhpkinddoList = new FArrayList();
		FArrayList pripatdoList = new FArrayList();

		String cond = "";
		// 3.获得包装单位
		// 查询：调用轻量级的服务
		String[] fields = { "Id_measdoc", "Name" }; // 需要查询的列
		DAFacade dAFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<MeasDocDO> measDocDOList = (List<MeasDocDO>) dAFacade.findByCond(MeasDocDO.class, "1=1", "1", fields);
		if (measDocDOList != null && measDocDOList.size() > 0) {
			for (MeasDocDO measDocDO : measDocDOList) {
				unitList.add(measDocDO);
			}
			insurUnitDepFreqDoseDTO.setMeasdocdo(unitList);
		} else {
			insurUnitDepFreqDoseDTO.setMeasdocdo(null);
		}
		// 4.获得医保科别
		List<HpDepDO> BdDepHpList = (List<HpDepDO>) dAFacade.findByCond(HpDepDO.class, cond, "1");
		if (BdDepHpList != null && BdDepHpList.size() > 0) {
			for (HpDepDO hpDepDO : BdDepHpList) {
				depList.add(hpDepDO);
			}
			insurUnitDepFreqDoseDTO.setHpdepdo(depList);
		}

		// 5.获得医保剂型
		List<HpDosageDO> hpDosageDOList = (List<HpDosageDO>) dAFacade.findByCond(HpDosageDO.class, cond, "1");
		if (hpDosageDOList != null && hpDosageDOList.size() > 0) {
			for (HpDosageDO hpDosageDO : hpDosageDOList) {
				dosageList.add(hpDosageDO);
			}
			insurUnitDepFreqDoseDTO.setHpdosedo(dosageList);
		}

		// 6.获得医保频次
		List<HpFreqDO> hpFreqDOList = (List<HpFreqDO>) dAFacade.findByCond(HpFreqDO.class, cond, "1");
		if (hpFreqDOList != null && hpFreqDOList.size() > 0) {
			for (HpFreqDO hpFreqDO : hpFreqDOList) {
				freqList.add(hpFreqDO);
			}
			insurUnitDepFreqDoseDTO.setHpfreqdo(freqList);
		}

		// 7.获得医保处方类型对照
		List<BdHpPrestpDO> hpPrestpDoLst = (List<BdHpPrestpDO>) dAFacade.findByCond(BdHpPrestpDO.class, cond, "1");
		if (hpPrestpDoLst != null && hpPrestpDoLst.size() > 0) {
			for (BdHpPrestpDO hpPrestpDo : hpPrestpDoLst) {
				presTpLst.add(hpPrestpDo);
			}
			insurUnitDepFreqDoseDTO.setHppresdicarr(presTpLst);
		}
		// 8.医保计划
		List<HPDO> hpdoLst = (List<HPDO>) dAFacade.findByCond(HPDO.class, cond, "1");
		if (hpdoLst != null && hpdoLst.size() > 0) {
			for (HPDO item : hpdoLst) {
				hpdoList.add(item);
			}
			insurUnitDepFreqDoseDTO.setHpdo(hpdoList);
		}
		// 9.医保险种
		List<BdHpKindDO> bdhpkinddoLst = (List<BdHpKindDO>) dAFacade.findByCond(BdHpKindDO.class, cond, "1");
		if (bdhpkinddoLst != null && bdhpkinddoLst.size() > 0) {
			for (BdHpKindDO item : bdhpkinddoLst) {
				bdhpkinddoList.add(item);
			}
			insurUnitDepFreqDoseDTO.setBdhpkinddo(bdhpkinddoList);
		}

		// 10.价格分类
		List<PriPatDO> pripatdoLst = (List<PriPatDO>) dAFacade.findByCond(PriPatDO.class, cond, "1");
		if (pripatdoLst != null && pripatdoLst.size() > 0) {
			for (PriPatDO item : pripatdoLst) {
				pripatdoList.add(item);
			}
			insurUnitDepFreqDoseDTO.setPripatdo(pripatdoList);
		}

		return insurUnitDepFreqDoseDTO;
	}

	/*
	 * 获取患者已记账: 来源于记账的数据；
	 */
	public List<BlCgItmOepDO> get_Append_BlCgOep(String id_pat, String id_org, Integer eu_direct) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select o.eu_srctp,o.fg_acc,o.amt_acc,o.id_or,o.id_cgitmoep,o.id_grp,o.id_org,o.id_pat,o.id_cgoep,o.id_ent,o.id_enttp,o.code_enttp,o.id_pres ");
		sql.append("    ,o.id_orsrv,o.id_srvtp,o.sd_srvtp,o.id_srvca,o.id_srv,o.code_srv,o.name_srv,o.srvu,a.name as srvu_name ");
		sql.append("    ,o.id_or,o.price,o.price_ratio,o.quan,o.amt,o.amt_std,o.amt_pat,o.dt_or,o.id_org_or,o.id_dep_or,o.id_emp_or,o.id_org_mp,o.id_dep_mp,o.dt_srv,o.factor ");
		sql.append("    ,o.fg_mm,o.id_mm,o.id_mmtp,o.sd_mmtp,o.code_mm,o.onlycode,o.name_mm,o.spec,o.cd_batch,o.pgku_base,o.pgku_cur,o.quan_base,o.fg_st,o.fg_susp,o.code_inccaitm,o.name_inccaitm,o.fg_free,o.code_apply,'1900-01-01 00:00:00' ci_sv,o.sd_abrd ,ci.fg_extdispense,ci.fg_specill,o.fg_hpcg,o.fg_pricinginsertcg,o.code_applytp");
		sql.append("     from bl_cg_itm_oep o  ");
		sql.append("        inner join bl_cg_oep t on o.id_cgoep=t.id_cgoep ");
		sql.append("         left join ci_or_srv ci on o.id_orsrv=ci.id_orsrv  ");
		sql.append("        left join bd_measdoc a on o.srvu=a.id_measdoc ");
		sql.append("         ");
		sql.append("      where  length(o.id_stoep)<2 and length(o.id_ent)>2 and ");
		sql.append("    t.id_pat = ? and  ");
		sql.append("    t.id_org = ? and  ");
		sql.append("    t.eu_direct = ?   ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_pat);
		sqlp.addParam(id_org);
		sqlp.addParam(eu_direct);

		@SuppressWarnings("unchecked")
		List<BlCgItmOepDO> list = (List<BlCgItmOepDO>) new DAFacade().execQuery(sql.toString(), sqlp, new BeanListHandler(BlCgItmOepDO.class));
		return list;
	}

	/*
	 * 获取患者已记账、未结算信息: 来源于已划价未付款的数据；
	 */
	public List<BlCgItmOepDO> getBlCgOepOrderByIdPat_hpcg(String id_pat, FDateTime dt, Integer eu_direct) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("     select o.*,'N' fg_extdispense,'N' fg_specill from bl_cg_itm_oep o  ");
		sql.append("        inner join bl_cg_oep t on o.id_cgoep=t.id_cgoep ");
		sql.append("        left join bd_measdoc a on o.srvu=a.id_measdoc ");
		sql.append("        left join bl_st_oep x on o.id_stoep=x.id_stoep ");
		sql.append("      where  ");
		sql.append("    o.id_pat = ? and  o.fg_hpcg='Y'");
		sql.append("    t.dt_cg <? and  ");
		sql.append("    t.eu_direct = ? and  length(o.id_ent)>2 and ");
		sql.append("    x.id_paypatoep is null ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_pat);
		sqlp.addParam(dt);
		sqlp.addParam(eu_direct);

		@SuppressWarnings("unchecked")
		List<BlCgItmOepDO> list = (List<BlCgItmOepDO>) new DAFacade().execQuery(sql.toString(), sqlp, new BeanListHandler(BlCgItmOepDO.class));
		return list;
	}

	/*
	 * 获取患者已记账、未结算信息: 来源于已划价未付款的数据；已经红冲的就不用显示了
	 */
	public List<BlCgItmOepDO> getBlCgOepOrder(String id_pat, String id_org, Integer eu_direct) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select o.*,'N' fg_extdispense,'N' fg_specill,depor.name as depor_name,depmp.name as depmp_name");
		sql.append(" from bl_cg_itm_oep o  ");
		sql.append(" inner join bl_cg_oep t on o.id_cgoep=t.id_cgoep ");
		sql.append(" left join bd_measdoc a on o.srvu=a.id_measdoc ");
		sql.append(" left join bl_st_oep x on o.id_stoep=x.id_stoep");
		sql.append(" left join bd_dep depor on o.id_dep_or=depor.id_dep");
		sql.append(" left join bd_dep depmp on o.id_dep_mp=depmp.id_dep");
		sql.append(" where  ");
		sql.append(" t.id_pat = ? and  ");
		sql.append(" t.id_org = ? and  ");
		sql.append(" t.eu_direct = ? and  length(o.id_ent)>2 and fg_refund='N' and ");
		sql.append(" x.id_paypatoep is null ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_pat);
		sqlp.addParam(id_org);
		sqlp.addParam(eu_direct);

		@SuppressWarnings("unchecked")
		List<BlCgItmOepDO> list = (List<BlCgItmOepDO>) new DAFacade().execQuery(sql.toString(), sqlp, new BeanListHandler(BlCgItmOepDO.class));
		return list;
	}

	/*
	 * 根据医嘱id获取医嘱信息
	 */
	private CiOrderDO[] getCiOrderSrvOfOep(List<String> idOrList) throws BizException {
		// ICiorderMDORService service =
		// (ICiorderMDORService)ServiceFinder.find(ICiorderMDORService.class);
		// CiOrderDO[] orderDOArr =
		// (CiOrderDO[])service.findByBIds(idOrList.toArray(new String[]{}),
		// FBoolean.FALSE);
		// 轻量级查询
		String[] fields = { "id_or,name_or" };
		String conStr = " id_or in(";
		for (String id_or : idOrList) {
			conStr = conStr + "'" + id_or + "',";
		}	
		conStr = conStr.substring(0, conStr.length() - 1) + ") ";

		DAFacade dafacade = new DAFacade();
		List<CiOrderDO> ciOrderDOlist = (List<CiOrderDO>) dafacade.findByCond(CiOrderDO.class, conStr, fields);
		if (ciOrderDOlist == null || ciOrderDOlist.size() == 0) {
			throw new BizException("没有找到医嘱");
		}
		return ciOrderDOlist.toArray(new CiOrderDO[] {});
	}

	// 将已记账医嘱信息转换为可展示DTO
	private BlOrderAppendBillParamDTO setBlOrderShow(CiOrderDO ciOrderDO, BlCgItmOepDO blCgItmOepDO, Map<String, MeasDocDO> measMap) {
		BlOrderAppendBillParamDTO ordShow = new BlOrderAppendBillParamDTO();
		ordShow.setFg_free(blCgItmOepDO.getFg_free()); // 减免标志
		ordShow.setCode_apply(blCgItmOepDO.getCode_apply());// 医疗单号
		ordShow.setCode_applytp(blCgItmOepDO.getCode_applytp());// 医疗类型
		if (blCgItmOepDO.getFg_hpcg() != null && blCgItmOepDO.getFg_hpcg().booleanValue())// 如果是商保记账
		{
			ordShow.setName_applytp(BlBizUtil.getPrntTpName(ordShow.getCode_applytp()) + "[欠款记账]");
		} else if (blCgItmOepDO.getFg_acc() != null && blCgItmOepDO.getFg_acc().booleanValue()) {
			ordShow.setName_applytp(BlBizUtil.getPrntTpName(ordShow.getCode_applytp()) + "[记账]");
		} else if (blCgItmOepDO.getEu_srctp() == 1)// 如果是挂号费
		{
			ordShow.setName_applytp("挂号");
		} else {
			ordShow.setName_applytp(BlBizUtil.getPrntTpName(ordShow.getCode_applytp()));
		}

		ordShow.setCode_inccaitm(blCgItmOepDO.getCode_inccaitm());
		ordShow.setName_inccaitm(blCgItmOepDO.getName_inccaitm());
		ordShow.setId_org(blCgItmOepDO.getId_org());
		ordShow.setId_org_mp(blCgItmOepDO.getId_org_mp());
		ordShow.setId_org_or(blCgItmOepDO.getId_org_or());
		ordShow.setId_dep_mp(blCgItmOepDO.getId_dep_mp());
		// 执行科室
		ordShow.setName_dep_mp(blCgItmOepDO.getDepmp_name());
		ordShow.setId_dep_wh(blCgItmOepDO.getId_dep_wh());
		ordShow.setFg_reserveMaterials(FBoolean.TRUE);// 调用物品预留
		ordShow.setId_dep_or(blCgItmOepDO.getId_dep_or());
		// 执行科室
		ordShow.setName_dep_or(blCgItmOepDO.getDepor_name());
		ordShow.setId_emp_or(blCgItmOepDO.getId_emp_or());
		ordShow.setId_ent(blCgItmOepDO.getId_ent());
		ordShow.setId_enttp(blCgItmOepDO.getId_enttp());
		// 设置医保计划
		ordShow.setId_hp(blCgItmOepDO.getId_hp());
		// 设置服务项目医保类别主键ID
		ordShow.setId_hpsrvtp(blCgItmOepDO.getId_hpsrvtp());
		// 设置服务项目医保类别编码
		ordShow.setSd_hpsrvtp(blCgItmOepDO.getSd_hpsrvtp());
		ordShow.setId_grp(blCgItmOepDO.getId_grp());
		ordShow.setFg_mm(blCgItmOepDO.getFg_mm());
		ordShow.setId_mm(blCgItmOepDO.getId_mm());
		ordShow.setId_pat(blCgItmOepDO.getId_pat());
		ordShow.setId_srv(blCgItmOepDO.getId_srv());
		ordShow.setId_srvca(blCgItmOepDO.getId_srvca());
		ordShow.setId_srvtp(blCgItmOepDO.getId_srvtp());
		ordShow.setSd_srvtp(blCgItmOepDO.getSd_srvtp());
		ordShow.setQuan_base(blCgItmOepDO.getQuan_base());
		ordShow.setPgku_cur(blCgItmOepDO.getPgku_cur());
		ordShow.setPgku_base(blCgItmOepDO.getPgku_base());
		ordShow.setFactor(blCgItmOepDO.getFactor());
		ordShow.setFg_Cgoep(FBoolean.TRUE);
		ordShow.setFg_susp(blCgItmOepDO.getFg_susp());
		ordShow.setId_pres(blCgItmOepDO.getId_pres());
		ordShow.setSrcfunc_des(blCgItmOepDO.getSrcfunc_des());
		ordShow.setId_stoep(blCgItmOepDO.getId_stoep());
		ordShow.setId_or(blCgItmOepDO.getId_or());
		ordShow.setFg_hpspcl(blCgItmOepDO.getFg_hpcg());
		if (ciOrderDO != null) {
			ordShow.setName_or(ciOrderDO.getName_or());
		}
		if (blCgItmOepDO.getFg_mm().booleanValue()) {
			ordShow.setPresrption_name("处方:药品");
		}
		if (blCgItmOepDO.getId_pres() == null && blCgItmOepDO.getId_or() == null) {
			ordShow.setId_pres(blCgItmOepDO.getId_ent());
			ordShow.setId_or(blCgItmOepDO.getId_ent());
			ordShow.setName_or("挂号:后付费");
			ordShow.setPresrption_name("挂号:后付费");
		}
		if (("~").equals(blCgItmOepDO.getId_pres()) && blCgItmOepDO.getId_or() == null) {
			ordShow.setName_or("挂号:后付费");
			ordShow.setPresrption_name("挂号:后付费");
		}
		if ((blCgItmOepDO.getId_pres() == null || ("~").equals(blCgItmOepDO.getId_pres())) && blCgItmOepDO.getId_or() != null) {
			ordShow.setName_or("补费数据");
			ordShow.setPresrption_name("补费数据");
		}
		if (!blCgItmOepDO.getSd_srvtp().startsWith("01")) {
			if (ciOrderDO != null)
				// 诊疗项目
				ordShow.setPresrption_name(ciOrderDO.getName_or());
		}
		ordShow.setFg_hpspcl(blCgItmOepDO.getFg_specill());
		ordShow.setFg_extdispense(blCgItmOepDO.getFg_extdispense());
		if (blCgItmOepDO.getFg_extdispense() != null && blCgItmOepDO.getFg_extdispense().booleanValue()) {
			if (ordShow.getPresrption_name() != null) {
				ordShow.setPresrption_name(ordShow.getPresrption_name().toString() + "[外配处方]");
			} else {
				ordShow.setPresrption_name("[外配处方]");
			}
		}
		if (blCgItmOepDO.getFg_specill() != null && blCgItmOepDO.getFg_specill().booleanValue()) {
			if (ordShow.getPresrption_name() != null) {
				ordShow.setPresrption_name(ordShow.getPresrption_name().toString() + "[特殊病]");
			} else {
				ordShow.setPresrption_name("[特殊病]");
			}
		}
		// TODO:2017-6-7 国际医院认为预付费记账 = [记账]
		if (blCgItmOepDO.getPrice() != null && blCgItmOepDO.getAmt_acc() != null && blCgItmOepDO.getFg_acc().booleanValue() && !blCgItmOepDO.getFg_st().booleanValue()) {
			ordShow.setPresrption_name(ordShow.getPresrption_name() + "[记账]");
		}

		// TODO:2017-6-7 国际医院认为商保记账 = [欠款记账]
		if (blCgItmOepDO.getPrice() != null && blCgItmOepDO.getFg_hpcg().booleanValue() && !blCgItmOepDO.getFg_st().booleanValue()) {
			ordShow.setPresrption_name(ordShow.getPresrption_name() + "[欠款记账]");
		}

		ordShow.setId_orsrv(blCgItmOepDO.getId_orsrv());
		ordShow.setName_srv(blCgItmOepDO.getName_srv());

		ordShow.setDt_or(blCgItmOepDO.getDt_or());

		ordShow.setName_srv(blCgItmOepDO.getName_srv());
		ordShow.setName_mm(blCgItmOepDO.getName_mm());
		ordShow.setPrice(blCgItmOepDO.getPrice());
		ordShow.setPrice_ratio(blCgItmOepDO.getPrice_ratio());
		ordShow.setQuan(blCgItmOepDO.getQuan());
		ordShow.setAmt(blCgItmOepDO.getAmt());

		ordShow.setCode_enttp(blCgItmOepDO.getCode_enttp());// new
		ordShow.setCode_srv(blCgItmOepDO.getCode_srv());// new
		ordShow.setCode_mm(blCgItmOepDO.getCode_mm());// new:物品编码
		ordShow.setSrvu(blCgItmOepDO.getSrvu());// new
		MeasDocDO measDocDO = measMap.get(blCgItmOepDO.getSrvu());
		if (measDocDO != null) {
			ordShow.setSrvu_name(measDocDO.getName());// new 服务项目单位
		}

		// ordShow.setSrvu_name(blCgItmOepDO.getSrvu_name());
		ordShow.setRatio_hp(blCgItmOepDO.getRatio_hp());// new
		ordShow.setRatio_pripat(blCgItmOepDO.getRatio_pripat());// new
		ordShow.setId_pripat(blCgItmOepDO.getId_pripat());
		if (blCgItmOepDO.getAmt_hp() == null) {
			ordShow.setAmt_hp(new FDouble(0));// new
		} else {
			ordShow.setAmt_hp(blCgItmOepDO.getAmt_hp());// new
		}
		ordShow.setAmt_pat(blCgItmOepDO.getAmt_pat());// new
		ordShow.setAmt_std(blCgItmOepDO.getAmt_std());// new
		// 根据标准价格和患者价格分类系数计算出的金额
		ordShow.setAmt_ratio(blCgItmOepDO.getAmt_ratio());
		ordShow.setDt_or(blCgItmOepDO.getDt_or());// new
		ordShow.setNote(blCgItmOepDO.getNote());// new
		ordShow.setPri_ss(blCgItmOepDO.getPri_ss());// new
		ordShow.setCd_batch(blCgItmOepDO.getCd_batch());// new
		ordShow.setCode_mm(blCgItmOepDO.getCode_mm());// new
		ordShow.setId_mmtp(blCgItmOepDO.getId_mmtp());// new
		ordShow.setSd_mmtp(blCgItmOepDO.getSd_mmtp());// new
		// 设置费用来源
		ordShow.setEu_srctp(blCgItmOepDO.getEu_srctp());
		ordShow.setFg_pricinginsertcg(blCgItmOepDO.getFg_pricinginsertcg());
		ordShow.setDt_cg(blCgItmOepDO.getDt_cg());

		BlOrderAppendOutpBillParamDTO outpParamDTO = new BlOrderAppendOutpBillParamDTO();
		outpParamDTO.setId_cgoep(blCgItmOepDO.getId_cgoep());
		outpParamDTO.setId_cgitmoep(blCgItmOepDO.getId_cgitmoep());
		outpParamDTO.setAmt_acc(blCgItmOepDO.getAmt_acc());
		outpParamDTO.setFg_acc(blCgItmOepDO.getFg_acc());
		outpParamDTO.setFg_hpcg(blCgItmOepDO.getFg_hpcg());

		ordShow.setOutpBillDTO(outpParamDTO);
		return ordShow;
	}

	// 将未记账医嘱信息转换为可展示DTO
	public BlOrderAppendBillParamDTO setBlOrderShow_Idpres(PrescriptionCostDto srvDTO, Map<String, MeasDocDO> measMap,String hpId) {
		BlOrderAppendBillParamDTO ordShow = new BlOrderAppendBillParamDTO();

		// ordShow.setId_org(ordDTO.getId_org());
		ordShow.setFg_free(FBoolean.FALSE);// 默认不减免
		// ordShow.setCode_apply(srvDTO.getCode()); 2017-6-9
		// 注释，为保证IIH窗口收费的显示与手机终端显示一致
		ordShow.setCode_apply(srvDTO.getPresno());
		ordShow.setCode_applytp(srvDTO.getPrntype());
		// 打印单类型名称
		ordShow.setName_applytp(BlBizUtil.getPrntTpName(srvDTO.getPrntype()));
		ordShow.setId_org(srvDTO.getId_org());
		ordShow.setId_org_mp(srvDTO.getId_org_mp());
		ordShow.setId_org_or(srvDTO.getId_org_srv());
		ordShow.setName_dep_or(srvDTO.getName_dep_srv());
		ordShow.setId_dep_mp(srvDTO.getId_dep_mp());
		ordShow.setName_dep_mp(srvDTO.getName_dep_mp());
		ordShow.setId_dep_wh(srvDTO.getId_dep_wh());
		ordShow.setEu_blmd(srvDTO.getEu_blmd());
		ordShow.setPri(srvDTO.getPri());
		ordShow.setPri_std(srvDTO.getPri_std());
		ordShow.setPri_ratio(srvDTO.getPri_ratio());
		// 2017年6月22日19:46:39 不能默认预留为true ，导致第三方不能结算 提示物品预留问题
		if (srvDTO.getFg_mm().booleanValue()) {
			ordShow.setFg_reserveMaterials(FBoolean.TRUE);// 调用物品预留
		} else {
			ordShow.setFg_reserveMaterials(FBoolean.FALSE);// 不调用物品预留
		}
		ordShow.setId_dep_or(srvDTO.getId_dep_srv());
		ordShow.setId_emp_or(srvDTO.getId_emp_srv());
		ordShow.setId_ent(srvDTO.getId_en());
		ordShow.setId_enttp(srvDTO.getId_entp());
		// ordShow.setId_grp(ordDTO.getId_grp());
		ordShow.setId_grp(srvDTO.getId_grp());
		ordShow.setId_mm(srvDTO.getId_mm());
		// ordShow.setId_pat(ordDTO.getId_pat());
		ordShow.setId_pat(srvDTO.getId_pat());
		ordShow.setId_srv(srvDTO.getId_srv());
		ordShow.setId_srvca(srvDTO.getId_srvtp());
		// 医保计划
		//ordShow.setId_hp(srvDTO.getId_hp());
		ordShow.setId_hp(hpId);
		// 服务项目医保类别
		ordShow.setId_hpsrvtp(srvDTO.getId_hpsrvtp());
		// 服务项目医保类别
		ordShow.setSd_hpsrvtp(srvDTO.getSd_hpsrvtp());
		ordShow.setId_hpkind(srvDTO.getId_hpkind());
		ordShow.setFg_hpspcl(srvDTO.getFg_specill());
		ordShow.setFg_extdispense(srvDTO.getFg_extdispense());
		ordShow.setEu_direct(1);
		ordShow.setSd_srvtp(srvDTO.getSd_srvtp());
		ordShow.setId_srvtp(srvDTO.getId_srvtp());
		ordShow.setCode_enttp(srvDTO.getCode_entp());
		// tcy:在医嘱领域：物品信息取数为ci_or_srv_mm.quan_cur;非物品为ci_or_srv.quan_total_med(原来取值是ci_or_srv.quan_medu）
		if (!srvDTO.getFg_mm().booleanValue()) {
			ordShow.setQuan(new FDouble(srvDTO.getQuan_med()));
		} else {
			ordShow.setQuan(srvDTO.getQuan_cur());
		}

		ordShow.setQuan_base(srvDTO.getQuan_base());
		ordShow.setPgku_cur(srvDTO.getId_unit_cur());
		ordShow.setPgku_base(srvDTO.getId_unit_cur());
		ordShow.setFactor(srvDTO.getFactor_cb());
		ordShow.setFg_Cgoep(FBoolean.FALSE);

		// ordShow.setId_or(ordDTO.getId_or());
		// ordShow.setName_or(ordDTO.getDes());
		ordShow.setId_or(srvDTO.getId_or());
		ordShow.setName_or(srvDTO.getDes());
		ordShow.setId_orsrv(srvDTO.getId_orsrv());
		ordShow.setName_srv(srvDTO.getName_srv());
		ordShow.setName_mm(srvDTO.getName_mm());
		// tcy:医嘱日期
		ordShow.setDt_or(srvDTO.getDt_sign());

		ordShow.setCode_enttp(srvDTO.getCode_entp());// new
		ordShow.setCode_srv(srvDTO.getCode_srv());// new
		if (srvDTO.getFg_mm().booleanValue()) {
			MeasDocDO measDoc = measMap.get(srvDTO.getId_unit_cur());// 获取在医嘱服务数据中单位的ID值
			if (measDoc != null) {
				ordShow.setSrvu(measDoc.getId_measdoc());
				ordShow.setSrvu_name(measDoc.getName());
			}
		} else {

			MeasDocDO measDocDO = measMap.get(srvDTO.getId_unit_med());
			if (measDocDO != null) {
				// ordShow.setSrvu(measDocDO.getName());//new 服务项目单位
				ordShow.setSrvu(measDocDO.getId_measdoc());// new 服务项目单位
				ordShow.setSrvu_name(measDocDO.getName());// new 服务项目单位
			}
		}
		ordShow.setId_pres(srvDTO.getId_pres());// new 处方
		ordShow.setSrcfunc_des(IBlCgCodeConst.OpFeeCollect);// 来源门诊收费
		if (srvDTO.getId_pres() == null) {
			// ???????
			// ordShow.setId_pres(srvDTO());//new 处方
		}
		// if(!StringUtil.isEmptyWithTrim(srvDTO.getPrestp_name()))
		// {
		// if(true)
		// {
		// ordShow.setPresrption_name("处方："+srvDTO.getPrestp_name());
		// }
		// }
		// else
		// {
		// ordShow.setPresrption_name("处方：诊疗");
		// }

		// 拼接处方名称信息
		if (srvDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
			ordShow.setPresrption_name(srvDTO.getPrestp_name());
		} else {
			ordShow.setPresrption_name(srvDTO.getDes());
		}
		ordShow.setFg_hpspcl(srvDTO.getFg_specill());
		ordShow.setFg_extdispense(srvDTO.getFg_extdispense());
		if (ordShow.getFg_extdispense() != null && ordShow.getFg_extdispense().booleanValue()) {
			if (ordShow.getPresrption_name() != null) {
				ordShow.setPresrption_name(ordShow.getPresrption_name().toString() + "[外配处方]");
			} else {
				ordShow.setPresrption_name("[外配处方]");
			}
		}
		if (ordShow.getFg_hpspcl() != null && ordShow.getFg_hpspcl().booleanValue()) {
			if (ordShow.getPresrption_name() != null) {
				ordShow.setPresrption_name(ordShow.getPresrption_name().toString() + "[特殊病]");
			} else {
				ordShow.setPresrption_name("[特殊病]");
			}
		}
		// ordShow.setAmt_hp(null);//new 金额_医保计划
		// ordShow.setAmt_pat(null);//new 标准金额：数量*标准价格.补费接口调用时，设置为null
		// ordShow.setAmt_std(null);//new 标准金额：数量*标准价格.补费接口调用时，设置为null
		// ordShow.setAmt(null);//new 金额：数量*标准价格*价格比例.补费接口调用时，设置为null

		ordShow.setCode_mm(srvDTO.getCode_mm());// new 物品编码
		ordShow.setId_mmtp(srvDTO.getId_mmtp());// new 物品类型
		ordShow.setSd_mmtp(srvDTO.getSd_mmtp());// new 物品类型编码
		ordShow.setFg_mm(srvDTO.getFg_mm());// new 物品标示
		ordShow.setSrcfunc_des(IBlCgCodeConst.OpFeeCollect);// 来源门诊收费
		ordShow.setId_pripat(srvDTO.getId_pripat());// new 患者价格类型
		// 就诊来源
		ordShow.setEu_srctp(0);
		// FDateTime sv = srvDTO.getCi_sv();
		ordShow.setCi_sv(srvDTO.getCi_sv());
		ordShow.setCode_applytp(srvDTO.getPrntype());
		ordShow.setFg_pricinginsertcg(FBoolean.TRUE); // 划价是插入cg表中的数据
		// ordShow.setRatio_hp(null);//new 医保自付比例 ？？？
		// ordShow.setRatio_pripat(null);//new 价格比例 ？？？
		return ordShow;
	}

	public FMap getEmpPhyDoArr(String strIdPsnDoc) throws BizException {
		// StringBuffer sb=new StringBuffer();
		// sb.append(" SELECT * FROM BD_EMP_HP");
		// sb.append(" WHERE ID_PSNDOC=?");
		// SqlParam param=new SqlParam();
		// param.addParam(strIdPsnDoc);]
		String strSql = String.format(" id_psndoc='%s'", strIdPsnDoc);
		IEmpPhyDORService rSerivce = ServiceFinder.find(IEmpPhyDORService.class);
		EmpPhyDO[] empPhyDoArr = rSerivce.find(strSql, "", FBoolean.FALSE);
		IPsndocRService psnDocRSerivce = ServiceFinder.find(IPsndocRService.class);
		PsnDocDO psnDocDo = psnDocRSerivce.findById(strIdPsnDoc).getParentDO();
		FMap map = new FMap();
		if(psnDocDo!=null){
			if (empPhyDoArr != null) {
				for (EmpPhyDO empPhyDO : empPhyDoArr) {
					if (!map.containsKey(empPhyDO.getId_psndoc())) {
						map.put(empPhyDO.getId_psndoc(), empPhyDO.getDrid() + "," + psnDocDo.getName());
					}
				}
			}
		}
		return map;
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
		IBlcgoepRService cgOepRService = ServiceFinder.find(IBlcgoepRService.class);
		BlcgoepAggDO cgOepAggdo = cgOepRService.findById(strIdCg);
		if (cgOepAggdo == null)
			throw new BizException("未找到该记账信息！");
		// 获取结算主键
		String strIdStOep = cgOepAggdo.getBlCgItmOepDO()[0].getId_stoep();
		IBlstoepRService stOepRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO stOepDo = stOepRService.findById(strIdStOep);
		if (stOepDo == null)
			throw new BizException("该交易还未结算！");
		return stOepDo.getCode_st();
	}
}
