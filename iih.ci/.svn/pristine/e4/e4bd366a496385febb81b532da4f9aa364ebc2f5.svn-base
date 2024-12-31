package iih.ci.ord.s.ems.op.orderv1.bp.ope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.service.d.CgTypeEnum;
import iih.bl.cg.service.i.IBLCancelSettlement;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckFailResultEnum;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.bl.hp.dto.d.ItmChkRstDTO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.d.CijudgeSpecillDTO;
import iih.ci.ord.dto.d.MedicalSharingDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.hp.gj.HpDetailedRuleBP;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.s.bp.CiOrEventsSaveBP;
import iih.ci.ord.s.bp.CiOrOpSessionInsertBP;
import iih.ci.ord.s.bp.CiOrderUpdateHpCiDiBP;
import iih.ci.ord.s.bp.UseBtOrNumMarginBuUpdateBP;
import iih.ci.ord.s.bp.UseBtOrNumMarginBuValidateBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppBtDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppBuDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppPathgyDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppRisDataBP;
import iih.ci.ord.s.bp.orsms.lis.CiLisOrSmsHandlerBP;
import iih.ci.ord.s.bp.splitpres.CiOrPresSplitHandleBP;
import iih.ci.ord.s.bp.validate.PathgySampValidateBP;
import iih.ci.ord.s.bp.validate.SkinTestOrSignBP;
import iih.ci.ord.s.bp.validate.gj.OrSrvDoctorRtValidateBP;
import iih.ci.ord.s.ems.itf.bp.IOrderOperateBP;
import iih.en.pv.entdi.d.EntDiDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医嘱签署逻辑
 * @author Young
 *
 */
public class OrderSignOperateBP implements IOrderOperateBP {

	@Override
	public OrderRstDTO exec(String[] idors, CiEnContextDTO ciEnContextDTO, FMap2 extension) 
			throws BizException {
		// TODO Auto-generated method stub
		OrderRstDTO rstDTO = new OrderRstDTO();
		if (idors == null || idors.length <= 0 || ciEnContextDTO == null) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		// 获得医嘱数据集合
		CiorderAggDO[] aggors = CiOrdAppUtils.getOrAggQryService().findByIds(idors, FBoolean.FALSE);
		
		String id_ent = ciEnContextDTO.getId_en();
		String code_entp = ciEnContextDTO.getCode_entp();
		String id_hp = ciEnContextDTO.getId_hp();
		String sd_hptp = ciEnContextDTO.getSd_hptp();
		String id_psndoc = ciEnContextDTO.getId_emp_or();
		
		FBoolean isRecurs = (FBoolean) extension.get("IsRecurs");
		if (isRecurs == null || !isRecurs.isValue()) {
			// 皮试医嘱保存校验
			SkinTestOrSignBP skintestbp = new SkinTestOrSignBP();
			String skintestrst = skintestbp.exec(aggors);
			if (!StringUtils.isNullOrEmpty(skintestrst)) {
				OrderRstDTO dto = new OrderRstDTO();
				FMap2 scene = new FMap2();
				scene.put("checkResult", skintestrst);
				dto.setExtension(scene);
				return dto;
			}

			// 病理标本项目非空检查
			PathgySampValidateBP pathgysamptestbp = new PathgySampValidateBP();
			String pathgyrst = pathgysamptestbp.exec(aggors);
			if(!StringUtils.isNullOrEmpty(pathgyrst)){
				OrderRstDTO dto = new OrderRstDTO();
				FMap2 scene = new FMap2();
				scene.put("checkResult", pathgyrst);
				dto.setExtension(scene);
				return dto;
			}

			// 用血医嘱可用血余量的校验
			UseBtOrNumMarginBuValidateBP usebtbp = new UseBtOrNumMarginBuValidateBP();
			String btrst = usebtbp.exe(aggors);
			if(!StringUtils.isNullOrEmpty(btrst)){
				OrderRstDTO dto = new OrderRstDTO();
				FMap2 scene = new FMap2();
				scene.put("checkResult", btrst);
				dto.setExtension(scene);
				return dto;
			}
		}

		//如果是医保类医嘱或临床路径待判断的医嘱，校验医生是否已经判断过。如果存在医生未判断，则将数据传送到前台，让医生判断
		if (extension.get("HpOrClinpath_Checked") == null) {
			FArrayList idors4HpOrClinpath = checkHpOrClinpath(aggors);
			if (!CiOrdUtils.isEmpty(idors4HpOrClinpath)) {
				OrderRstDTO dto = new OrderRstDTO();
				FMap2 scene = new FMap2();
				scene.put("IDors4HpOrClinpath", idors4HpOrClinpath);
				dto.setExtension(scene);
				return dto;
			}
		}
		
		//验证当前为医保数据进行医保规则校验
		if (extension.get("HpRule4Sign_Checked") == null 
				&& (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp) 
						|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp)
						|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp))
				&& sd_hptp != null && sd_hptp.startsWith("1")) {
			// 医保规则
			OrderRstDTO checkRstDTO = checkHPRule4Sign(aggors);
			if (checkRstDTO != null) {
				return checkRstDTO;
			}
		}

		//医嘱服务权限判断逻辑
		if (extension.get("DoctorAuthor_Checked") == null) {
			OrSrvDoctorRtValidateBP doctorRtbp = new OrSrvDoctorRtValidateBP();
			FMap2 orsrvrtchk = doctorRtbp.exec(aggors);
			if (orsrvrtchk != null && orsrvrtchk.size() > 0) {
				OrderRstDTO dto = new OrderRstDTO();
				dto.setExtension(orsrvrtchk);
				return dto;
			}
		}

		// 判断特殊病，用户干预后 点击 否 签署 不是特殊病药，不在进行判断
		if (extension.get("SpecilDrugs_Checked") == null) {
			String specilInfo = judgeSpecillFlag(aggors, ciEnContextDTO);
			if (!CiOrdUtils.isEmpty(specilInfo)) {
				FMap2 scene = new FMap2();
				scene.put("SpecilDrugs4Sign", specilInfo);
				OrderRstDTO dto = new OrderRstDTO();
				dto.setExtension(scene);
				return dto;
			}
		}
		
		//药品毒麻信息审核
		if (extension.get("PoisInfo_Checked") == null) {
			FArrayList checkPoisInfoSrvs = srvPoisInfoCheck(aggors);
			if (checkPoisInfoSrvs.size() > 0) {
				FMap2 scene = new FMap2();
				scene.put("PoisInfoCheck4Sign", checkPoisInfoSrvs);
				OrderRstDTO dto = new OrderRstDTO();
				dto.setExtension(scene);
				return dto;
			}
		}
		

		CiOrderDO[] ciors = getCiOrderDOs(aggors);
		FDateTime dt_cur = CiOrdAppUtils.getServerDateTime();
		//本次就诊为医保就诊时，判断是否存在保外诊断，如果存在保外诊断更新医嘱中的保外诊断属性
		if (CiOrdUtils.isHpUsing(ciEnContextDTO)) {
			// 查询保外诊断
			ICidiagQryService icidiagQryService = (ICidiagQryService) ServiceFinder.find(ICidiagQryService.class);
			CiDiagItemDO[] ciDiagItems = icidiagQryService.getHpjudgetpCiDiagItems(id_ent);

			if (!CiOrdUtils.isEmpty(ciDiagItems)) {

				CiEnContextUtil.SetHpCiDiagItem(ciEnContextDTO, ciDiagItems);
				for (CiOrderDO ciOrderDO : ciors) {
					ciOrderDO.setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);// 医保适应症判断标识枚举
					ciOrderDO.setBhpjudgerst(ciEnContextDTO.getBhpjudgerst()); // 基本医保判断结果数据信息
					ciOrderDO.setDes_bhpjudgerst(ciEnContextDTO.getDes_bhpjudgerst()); // 基本医保判断结果数据信息描述，保外诊断id串
				}

				CiOrderUpdateHpCiDiBP ciOrderUpdateHpCiDiBP = new CiOrderUpdateHpCiDiBP(ciEnContextDTO);
				ciOrderUpdateHpCiDiBP.execUpdateOrdSrvs(idors);
			}
		}
		
		// 医保医嘱签署时，选择了自费的服务，自费标识设置true
		List<OrdSrvDO> lstOrdSrvDOsSelfpay4HP = new ArrayList<OrdSrvDO>();// 自费服务集合
		if (extension != null && extension.containsKey("IDorsrvs4HPSelfpay")) {
			String id_orsrvs = (String) extension.get("IDorsrvs4HPSelfpay");
			setFg_selfpay4HP(id_orsrvs, aggors, lstOrdSrvDOsSelfpay4HP);
		}
		
		return saveSignData(ciors, lstOrdSrvDOsSelfpay4HP.toArray(new OrdSrvDO[] {}), 
				dt_cur, id_ent, code_entp, id_hp, sd_hptp, id_psndoc);
	}

	/**
	 * 医保医嘱签署时，选择了自费的服务，自费标识设置true
	 * @param id_orsrv
	 * @param aggors
	 */
	private void setFg_selfpay4HP(String id_orsrvs, CiorderAggDO[] aggors, List<OrdSrvDO> ordSrvDOs) {
		if (id_orsrvs != null && id_orsrvs.length() > 0 && aggors != null && aggors.length > 0) {
			for (CiorderAggDO aggDO : aggors) {
				for (OrdSrvDO srvdo : aggDO.getOrdSrvDO()) {
					if (id_orsrvs.contains(srvdo.getId_orsrv())) {
						srvdo.setFg_selfpay(FBoolean.TRUE);
						ordSrvDOs.add(srvdo);
					}
				}
			}
		}
	}

	/**
	 * 获取需要进行医保或临床路径判断的医嘱ID
	 * @param aggors
	 * @return
	 */
	public FArrayList checkHpOrClinpath(CiorderAggDO[] aggors) {
		if (CiOrdUtils.isEmpty(aggors))
			return null;
		FArrayList list = new FArrayList();
		for (CiorderAggDO agg : aggors) {
			CiOrderDO order = agg.getParentDO();
			// 只要有医保或临床路径未判断，都会打开医嘱审核界面
			if (HpIndicJudgeEnum.WAITINGJUDGE.equals(order.getEu_hpindicjudge())
					|| HpIndicJudgeEnum.WAITINGJUDGE.equals(order.getEu_uncporjudge())) {
				list.append(order.getId_or());
			}
		}
		return list;
	}
	
	/**
	  * 签署验证医保规则
	  * @param aggors
	  * @return
	  * @throws BizException
	  */
	private OrderRstDTO checkHPRule4Sign(CiorderAggDO[] aggors) throws BizException {
		//为医保验证弹窗中的服务名称拼装物品名称:服务名称(物品名称) by yzh 2017-10-23 13:39:40 BUG:0109371
		if (!CiOrdUtils.isEmpty(aggors)) {
			for (CiorderAggDO aggDO : aggors) {
				String MM_name = getOrderMMName(aggDO);
				if (MM_name != null)
					aggDO.getParentDO().setName_or(aggDO.getParentDO().getName_or() + "(" + MM_name + ")");
			}
		}
		
		CiHpCheckResultDTO result = HpDetailedRuleBP.getInstance().getHpOrderSigndRule(aggors);
		if (result != null && !result.getCheckflag().booleanValue()) {
			FMap2 hpmessageMap = new FMap2();
			FArrayList2 hplist = new FArrayList2();
			FArrayList rstlist = result.getErroritm_list();
			if (rstlist != null) {
				for (int i = 0; i < rstlist.size(); i++) {
					ItmChkRstDTO chkRstDTO = (ItmChkRstDTO) rstlist.get(i);
					MedicalSharingDTO medicalSahringDTO = new MedicalSharingDTO();
					medicalSahringDTO.setCode_or(chkRstDTO.getCode_or());
					medicalSahringDTO.setName_srv(chkRstDTO.getName_or());
					FMap map = chkRstDTO.getError_map();
					List<String> mapKeyList = new ArrayList<String>(map.keySet());
					String keys = "";
					String values = "";
					for (String key : mapKeyList) {
						keys += "," + key;
						values += map.get(key) + "\n";
					}
					if (FBoolean.TRUE.equals(WarningAndStop(keys))) {
						medicalSahringDTO.setCode("Stop");
					}
					medicalSahringDTO.setReason(values);
					hplist.append(medicalSahringDTO);
				}
			}
			hpmessageMap.put("HpRule4Sign", hplist);
			OrderRstDTO dto = new OrderRstDTO();
			dto.setExtension(hpmessageMap);
			return dto;
		}
		return null;
	}
	
	/**
	 * 获取物品名称
	 * @param aggor
	 * @return
	 */
	private String getOrderMMName(CiorderAggDO aggor) {
		if (CiOrdUtils.isEmpty(aggor)) {
			return null;
		}

		OrdSrvDO[] ordSrvDOs = aggor.getOrdSrvDO();
		if (CiOrdUtils.isEmpty(ordSrvDOs)) {
			return null;
		}

		String name = null;
		for (OrdSrvDO ordSrvDO : ordSrvDOs) {
			if (CiOrdUtils.isEmpty(ordSrvDO)) {
				continue;
			}
			if (FBoolean.TRUE.equals(ordSrvDO.getFg_mm())) {
				name = ordSrvDO.getName();
			}
		}
		return name;
	}

	/**
	 * 保存时 提示信息还是终止保存；
	 * 
	 * @param keys
	 * @return
	 */
	private FBoolean WarningAndStop(String keys) {
		if (keys != "") {
			if (keys.contains(CiHpCheckFailResultEnum.REPEAT_PRES_DRUG)) {
				return FBoolean.TRUE;
			}
			if (keys.contains(CiHpCheckFailResultEnum.GREATER_THAN_ONE_TIME)) {
				return FBoolean.TRUE;
			}
			if (keys.contains(CiHpCheckFailResultEnum.GREATER_THAN_GET_OEP)) {
				return FBoolean.TRUE;
			}
			if (keys.contains(CiHpCheckFailResultEnum.GREATER_THAN_OWN_OEP)) {
				return FBoolean.TRUE;
			}
			if (keys.contains(CiHpCheckFailResultEnum.GREATER_THAN_GET_ER)) {
				return FBoolean.TRUE;
			}
			return FBoolean.FALSE;
		}

		return FBoolean.FALSE;
	}
	/**
	 * 获得医嘱主DO数组
	 * 
	 * @param aggors
	 * @return
	 */
	private CiOrderDO[] getCiOrderDOs(CiorderAggDO[] aggors) {
		List<CiOrderDO> ciOrderDOs = new ArrayList<CiOrderDO>();
		for (int i = 0; i < aggors.length; i++) {
			ciOrderDOs.add(aggors[i].getParentDO());
		}
		return ciOrderDOs.toArray(new CiOrderDO[] {});
	}

	/**
	 * 药品毒麻信息审核
	 * 
	 * @param aggors
	 * @return
	 */
	private FArrayList srvPoisInfoCheck(CiorderAggDO[] aggors) {
		FArrayList idorsrvs = new FArrayList();
		FArrayList ordsrvPois = new FArrayList();
		FMap orsrvMap = new FMap();
		for (CiorderAggDO agg : aggors) {
			if (!agg.getParentDO().getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG))
				continue;
			OrdSrvDO[] ordSrvdos = agg.getOrdSrvDO();
			for (OrdSrvDO srvdo : ordSrvdos) {
				idorsrvs.append(srvdo.getId_orsrv());
				orsrvMap.put(srvdo.getId_orsrv(),
						new String[] { srvdo.getId_orsrv(), srvdo.getId_or(), srvdo.getName_srv() });
			}
		}
		try {
			OrdSrvMmDO[] srvmms = CiOrdAppUtils.getOrSrvMmQryService().findByAttrValList("Id_orsrv", idorsrvs);
			idorsrvs.clear();
			if (srvmms == null)
				return ordsrvPois;
			for (OrdSrvMmDO srvmm : srvmms) {
				if (CiOrdUtils.isEmpty(srvmm.getSd_pois()))
					continue;
				if (CiOrdUtils.isNeedCheckPatInfo(srvmm.getSd_pois()).booleanValue()) {
					idorsrvs.append(srvmm.getId_orsrv());
				}
			}
			if (idorsrvs.size() > 0) {
				OrSrvAgentInfoDO[] orsrvAgentInfoDOs = CiOrdAppUtils.getCiorsrvagentRService().findByAttrValList(
						"Id_orsrv", idorsrvs);
				if (!CiOrdUtils.isEmpty(orsrvAgentInfoDOs)) {
					for (OrSrvAgentInfoDO srvagent : orsrvAgentInfoDOs) {
						idorsrvs.remove(srvagent.getId_orsrv());
					}
				}

				if (idorsrvs.size() > 0) {
					for (Object id_orsrv : idorsrvs) {
						ordsrvPois.append(orsrvMap.get(id_orsrv.toString()));
					}
				}
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
		return ordsrvPois;
	}

	/**
	 * 特殊判断，返回需要校验特殊病的服务集合
	 * @param aggs
	 * @param ctx
	 * @param mapIdOrsrv
	 * @return
	 * @throws BizException
	 */
	private String judgeSpecillFlag(CiorderAggDO[] aggs, CiEnContextDTO ctx) throws BizException {
//		Ent4BannerDTO banner = ctx.getEnt4BannerDTO();
		//return "西药，中药";
		//非医保或患者非特病返回false
		if (CiOrdUtils.isEmpty(ctx.getId_hp()) || ctx.getFg_hpspcl() == null
				|| !ctx.getFg_hpspcl().booleanValue())
			return null;
		FArrayList idOrsrvs = new FArrayList();
		Map<String, OrdSrvDO> ordsrvMap = new HashMap<String, OrdSrvDO>();
		for (CiorderAggDO agg : aggs) {
			OrdSrvDO[] ordsrvs = agg.getOrdSrvDO();
			for (OrdSrvDO srv : ordsrvs) {
				if (FBoolean.FALSE.equals(srv.getFg_self()) && FBoolean.FALSE.equals( srv.getFg_selfpay()) && srv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)) {
					idOrsrvs.append(srv.getId_orsrv());
					ordsrvMap.put(srv.getId_orsrv(), srv);
				}
			}
		}

		if (idOrsrvs.size() == 0)
			return null;
		OrdSrvMmDO[] srvmmdos = CiOrdAppUtils.getOrSrvMmQryService().findByAttrValList("Id_orsrv", idOrsrvs);
		List<String> idMMs = new ArrayList<String>();
		Map<String, OrdSrvMmDO> mmMap = new HashMap<String, OrdSrvMmDO>();
		if (!CiOrdUtils.isEmpty(srvmmdos)) {
			for (OrdSrvMmDO srvmm : srvmmdos) {
				if (!CiOrdUtils.isEmpty(srvmm.getId_mm())) {
					if (!idMMs.contains(srvmm.getId_mm())) {
						idMMs.add(srvmm.getId_mm());
						mmMap.put(srvmm.getId_mm(), srvmm);
					}
				}
			}
		} else {
			return null;
		}

		List<OrdSrvDO> updSpecilSrvs = new ArrayList<OrdSrvDO>();
		FArrayList2 specilDrugs = new FArrayList2();
		IBLCancelSettlement blservice = CiOrdAppUtils.getIBLCancelSettlement();
		List<CijudgeSpecillDTO> specils = blservice.JudgeSpecillFlag(ctx.getNo_hp(), ctx.getId_hp(),
				idMMs.toArray(new String[idMMs.size()]));
		if (!CiOrdUtils.isEmpty(specils) && specils.size() > 0) {
			ICiOrdQryService ciordqryservice = CiOrdAppUtils.getCiOrdQryService();
			EntDiDO[] entdis = ciordqryservice.getEntDiDOList(ctx.getId_en());
			for (CijudgeSpecillDTO specill : specils) {
				FMap2 diagmap = specill.getDiagmap();
				if (!CiOrdUtils.isEmpty(specill.getFg_mmspecill()) && specill.getFg_mmspecill().booleanValue()
						&& !CiOrdUtils.isEmpty(diagmap)) {
					if (!CiOrdUtils.isEmpty(entdis)) {
						boolean flag = true;
						for (EntDiDO entdi : entdis) {
							String code_di = entdi.getCode_didef_dis();
							if (diagmap.containsKey(code_di)) {
								flag = false;
								break;
							}
						}
						if (flag) {
							String name_srv = ordsrvMap.get(mmMap.get(specill.getId_mm()).getId_orsrv()).getName();
							specilDrugs.append(name_srv+"["+mmMap.get(specill.getId_mm()).getName_mm() +"] 是特殊病药品，未录入其对应特殊病的诊断: "+getMapName(diagmap)+System.lineSeparator());
						} else {
							OrdSrvDO srvdo = ordsrvMap.get(mmMap.get(specill.getId_mm()).getId_orsrv());
							srvdo.setFg_specill(FBoolean.TRUE);
							updSpecilSrvs.add(srvdo);
						}
					}
				}
			}
		}
		if (updSpecilSrvs.size() > 0) {
			CiOrdAppUtils.getICiorderSrvDOCudService()
					.update(updSpecilSrvs.toArray(new OrdSrvDO[updSpecilSrvs.size()]));
		}
		if (specilDrugs.size() > 0) {
			StringBuffer str =  new StringBuffer();
            for(Object info :specilDrugs){
            	str.append(info.toString());
            }
			return str.append("是否录入?").toString();
		} else {
			return null;
		}
	}
   
	
	/**
	 * 特殊病诊断集合
	 * @param diagmap 特殊病诊断集合
	 * @return
	 */
	private String getMapName(FMap2 diagmap) {
		if (diagmap == null || diagmap.size() <= 0) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		for (Object key : diagmap.keySet()) {
			sb.append("，" + key + " " + diagmap.get(key));
		}

		return sb.substring(1);
	}
	
	/**
	 * 执行签署数据更新
	 * 
	 * @param ciors
	 * @throws BizException
	 */
	private OrderRstDTO saveSignData(CiOrderDO[] ciors, OrdSrvDO[] ordSrvDOs, FDateTime dt_cur, String id_ent, String code_entp, String id_hp, String sd_hptp, String id_psndoc) throws BizException {

		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		
		//更新医嘱服务自费标识
		updateOrdSrvFg_selfpay4HP(ordSrvDOs);
		
		//更新医嘱状态为签署
		updateOrderStatus(ciors);

		//临床事件保存
		ciEventInfoSave(ciors);

		//创建门诊医嘱会话区间
		CiOrOpSessionInsertBP bpSession = new CiOrOpSessionInsertBP();
		CiOrSessionDO sessiondo = bpSession.exec(ciors, dt_cur);
		
		//备血可用血余量更新
		UseBtOrNumMarginBuUpdateBP bpBuUpdate = new UseBtOrNumMarginBuUpdateBP();
		bpBuUpdate.exec(ciors, true);

		//签署时，按规则自动分方  仅门急诊使用  新接口 可配置第三方插件
		CiOrPresSplitHandleBP bpPresSplit = new CiOrPresSplitHandleBP();
		bpPresSplit.exec(context,ciors, sessiondo);

		//检验合单
		CiLisOrSmsHandlerBP bpLis = new CiLisOrSmsHandlerBP();
		bpLis.exec(context,ciors, sessiondo);

		// 保存检查打印数据 仅门急诊使用
		CiprnSaveAppRisDataBP bpRis = new CiprnSaveAppRisDataBP();
		bpRis.exec(context, ciors, sessiondo);

		// 保存病理打印数据 仅门急诊使用
		CiprnSaveAppPathgyDataBP bpPathgy = new CiprnSaveAppPathgyDataBP();
		bpPathgy.exec(ciors, sessiondo);

		// 保存备血打印数据 仅门急诊使用
		CiprnSaveAppBtDataBP bpBt = new CiprnSaveAppBtDataBP();
		bpBt.exec(context, ciors, sessiondo);

		// 保存取血打印数据 仅门急诊使用
		CiprnSaveAppBuDataBP bpBu = new CiprnSaveAppBuDataBP();
		bpBu.exec(context, ciors, sessiondo);

		//生成门诊费用清单打印数据
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp) 
				|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp)
				|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp)) {
			//生成保存门诊费用清单打印数据 
			String[] id_ors = new String[ciors.length];
			int i = 0;
			for (CiOrderDO ciorder : ciors) {
				id_ors[i] = ciorder.getId_or();
				i++;
			}
			CiOrdAppUtils.getICiprintExtService().SaveFeeBillsData(id_ors, id_hp, sd_hptp);
			//签署未记账时发送IE签署事件 by yzh 2017-08-17 10:43:15
			CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciors);

			//高端商保记账
			//高端商保判断是每条医嘱的金额 不能超过限制的 金额
			if (sd_hptp != null && sd_hptp.startsWith("2")) {
				CiOrdAppUtils.getIBLOrderAppendBillService().SetOrderAppendBill_ByItms_ci_kljz_new(
						id_ent, code_entp, CgTypeEnum.CG_HPCG, id_psndoc);
			}
		}

		//		Runnable r = new OrderSignSaveDataRunnable(ciors, sessiondo, (CiEnContextDTO) Context.get().getAttribute(
		//				"CiEnContextDTO"));
		//		ExecutorUtil.startRunnable(r);

		OrderRstDTO dto = new OrderRstDTO();
		FMap2 scene = new FMap2();
		scene.put("ciors", CiOrdUtils.array2FArrayList(ciors));
		dto.setExtension(scene);
		dto.setIsSuccess(FBoolean.TRUE);

		//CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciors);
		return dto;
	}
	
	/**
	 * 更新医嘱服务自费标识
	 * @param ordSrvDOs
	 * @throws DAException
	 */
	private void updateOrdSrvFg_selfpay4HP(OrdSrvDO[] ordSrvDOs) throws DAException{
		String[] arrayFieldNames = new String[] { OrdSrvDO.FG_SELFPAY };
		new DAFacade().updateDOArray(ordSrvDOs, arrayFieldNames);
	}

	/**
	 * 更新医嘱签署状态
	 * 
	 * @param orders
	 * @throws BizException
	 */
	private void updateOrderStatus(CiOrderDO[] orders) throws BizException {
		String[] arrayFieldNames = new String[] { CiOrderDO.ID_SU_OR, CiOrderDO.SD_SU_OR, CiOrderDO.FG_SIGN,
				CiOrderDO.DT_SIGN, CiOrderDO.ID_DEP_SIGN, CiOrderDO.ID_EMP_SIGN };
		FDateTime dtNow = CiOrdAppUtils.getServerDateTime();
		String id_dep = CiOrdAppUtils.getEnvContext().getDeptId();
		String id_emp = CiOrdUtils.getPsnDocID(CiOrdAppUtils.getEnvContext().getUserId());
		List<CiOrderDO> origindos = new ArrayList<CiOrderDO>();
		for (CiOrderDO order : orders) {
			origindos.add(order);

			order.setId_su_or(ICiDictCodeConst.SD_SU_ID_SIGN);
			order.setSd_su_or(ICiDictCodeConst.SD_SU_SIGN);
			order.setFg_sign(new FBoolean(true));
			order.setDt_sign(dtNow);
			order.setId_dep_sign(id_dep);
			order.setId_emp_sign(id_emp);
		}
		new DAFacade().updateDOArray(orders, arrayFieldNames);
	}

	/**
	 * 临床事件保存
	 * 
	 * @param ors
	 * @param sd_su_or
	 * @throws BizException
	 */
	private void ciEventInfoSave(CiOrderDO[] orders) throws BizException {
		//有效性校验
		if (orders == null || orders.length <= 0)
			return;
		//医嘱事件创建保存 时机应该选择为 签署阶段
		CiOrEventsSaveBP bp = new CiOrEventsSaveBP();
		bp.exec(orders);
	}
}
