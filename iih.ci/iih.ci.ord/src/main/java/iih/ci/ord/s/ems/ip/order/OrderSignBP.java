package iih.ci.ord.s.ems.ip.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.service.i.IBLCancelSettlement;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.ord.cior.d.ReactExtOrsAndStopOrsDO;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.d.CijudgeSpecillDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.s.bp.CiOrderUpdateHpCiDiBP;
import iih.ci.ord.s.bp.OrConfirmBP;
import iih.ci.ord.s.bp.UseBtOrNumMarginBuUpdateBP;
import iih.ci.ord.s.bp.UseBtOrNumMarginBuValidateBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppBtDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppBuDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppPathgyDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppRisDataBP;
import iih.ci.ord.s.bp.order.stop.CiOrValidFgLongOrStopBP;
import iih.ci.ord.s.bp.validate.OrDoctorCheckValidateBP;
import iih.ci.ord.s.bp.validate.OrMutexValidateBP;
import iih.ci.ord.s.bp.validate.PathgySampValidateBP;
import iih.ci.ord.s.bp.validate.SkinTestOrSignBP;
import iih.ci.ord.s.bp.validate.SrvMutexValidateBP;
import iih.ci.ord.s.bp.validate.gj.OrSrvDoctorRtValidateBP;
import iih.ci.ord.s.ems.define.ICiDoctorStationTypeConst;
import iih.ci.ord.s.ems.itf.bp.IOrderSignBP;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.ems.utils.OrderUtils;
import iih.ci.ord.s.ems.utils.SysParamUtils;
import iih.en.pv.entdi.d.EntDiDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 医嘱签署
 * 
 * @author Young
 *
 */
public class OrderSignBP implements IOrderSignBP {

	@Override
	public OrderRstDTO sign(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		//
		
		Context.get().setAttribute("CiEnContextDTO", ctx);
		FArrayList paramList = arg.getDocument();
		if (paramList == null || paramList.size() <= 0) {
			OrderRstDTO rstDTO = new OrderRstDTO();
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		StringList lstIdors = new StringList(paramList);
		if (lstIdors.size() == 0) {
			OrderRstDTO rstDTO = new OrderRstDTO();
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		// 获得医嘱聚集数据集合
		CiorderAggDO[] aggDOs = CiOrdAppUtils.getOrAggQryService().findByIds(lstIdors.asArray(), FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(aggDOs)) {
			return this.getOrderRstDTO(OrderUtils.KYE_MESSAGE, "医嘱状态已经发生变化，请刷新列表！");
		}

		CiOrderDO[] ciorderDOs = new CiOrderDO[aggDOs.length];
		int i = 0;
		for (CiorderAggDO aggDO : aggDOs) {
			if (aggDO.getParentDO().getFg_sign().isValue()) {
				return this.getOrderRstDTO(OrderUtils.KYE_MESSAGE, "医嘱状态已经发生变化，请刷新列表！");
			}
			OrdSrvDO[] ordSrvs = aggDO.getOrdSrvDO();
			//检查价格
			for(OrdSrvDO ordSrvDO : ordSrvs){
				if(FBoolean.TRUE.equals(ordSrvDO.getFg_bl())&&(ordSrvDO.getPri()==null||FDouble.ZERO_DBL.compareTo(ordSrvDO.getPri())>=0)){
					return this.getOrderRstDTO(OrderUtils.KYE_MESSAGE,String.format("【%s】价格为0异常！", ordSrvDO.getName_srv()));
				}
			}
			ciorderDOs[i] = aggDO.getParentDO();
			i++;
		}

		FMap2 extension = arg.getExtension();
		FBoolean isRecurs = (FBoolean) extension.get(OrderUtils.IsRecurs);
		if (isRecurs == null || !isRecurs.isValue()) {
			OrderRstDTO rstDTO = this.validate4OrderSign(aggDOs);
			if (rstDTO != null) {
				return rstDTO;
			}
		}

		// 签署时进行医保校验
		// TODO：合并国际代码
//		OrderHpInfoValidateBP orderHpInfoValidateBP = new OrderHpInfoValidateBP();
//		FArrayList idOrList = orderHpInfoValidateBP.exec(aggDOs);
//		if (!CiOrdUtils.isEmpty(idOrList)) {
//			return this.getOrderRstDTO(OrderUtils.OrderHpInfo4Sign, idOrList);
//		}

		// 如果医嘱是医保类医嘱或临床路径待判断的医嘱，判断医生是否已经判断过。如果存在医生未判断，则将数据传送到前台，让医生判断
		if(!ICiDoctorStationTypeConst.Type_Ip_NurDoctor_Station.equals(ctx.getStationType())||this.getNursHpCheck(ctx.getId_org())){
			OrDoctorCheckValidateBP docvalidatebp = new OrDoctorCheckValidateBP();
			FArrayList willCheckIdOrs = docvalidatebp.exec(aggDOs);
			if (!CiOrdUtils.isEmpty(willCheckIdOrs)) {
				return this.getOrderRstDTO(OrderUtils.IDors4HpOrClinpath, willCheckIdOrs);
			}
		}

		if (!extension.containsKey(OrderUtils.SpecilDrugs_Checked)) {
			// 判断特殊病，用户干预后 点击 否 签署 不是特殊病药，不在进行判断
			String specilInfo = judgeSpecillFlag(aggDOs, ctx);
			if (!CiOrdUtils.isEmpty(specilInfo)) {
				return this.getOrderRstDTO(OrderUtils.SpecilDrugs4Sign, specilInfo);
			}
		}

		// 根据系统参数IsEntryPoisAgent4Ip判断在毒麻药签署时是否需要提醒医生录入代办人信息（true：提醒，false：不提醒）
		if ("true".equals(SysParamUtils.getSysParam().getSYS_PARAM_IsEntryPoisAgent4Ip().getOrgParam())) {
			// 药品毒麻信息审核
			if (extension.get(OrderUtils.PoisInfo_Checked) == null) {
				FArrayList checkPoisInfoSrvs = srvPoisInfoCheck(aggDOs);
				if (checkPoisInfoSrvs.size() > 0) {
					FMap2 scene = new FMap2();
					scene.put(OrderUtils.PoisInfoCheck4Sign, checkPoisInfoSrvs);
					OrderRstDTO dto = new OrderRstDTO();
					dto.setExtension(scene);
					return dto;
				}
			}
		}

		// TODO 签署逻辑需要调整，将校验调整与处理分开，最终调用同一个签署方法
		// 本次就诊为医保就诊时，判断是否存在保外诊断，如果存在保外诊断更新医嘱中的保外诊断属性
		if (CiOrdUtils.isHpUsing(ctx)) {
			// 查询保外诊断
			CiDiagItemDO[] ciDiagItems = ServiceFinder.find(ICidiagQryService.class)
					.getHpjudgetpCiDiagItems(ctx.getId_en());
			if (ciDiagItems != null && ciDiagItems.length > 0) {
				CiEnContextUtil.SetHpCiDiagItem(ctx, ciDiagItems);
				for (CiorderAggDO aggDO : aggDOs) {
					aggDO.getParentDO().setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);// 医保适应症判断标识枚举
					aggDO.getParentDO().setBhpjudgerst(ctx.getBhpjudgerst()); // 基本医保判断结果数据信息
					aggDO.getParentDO().setDes_bhpjudgerst(ctx.getDes_bhpjudgerst()); // 基本医保判断结果数据信息描述，保外诊断id串
				}
				CiOrderUpdateHpCiDiBP ciOrderUpdateHpCiDiBP = new CiOrderUpdateHpCiDiBP(ctx);
				ciOrderUpdateHpCiDiBP.execUpdateOrdSrvs(lstIdors.asArray());
			}
		}

		// 进行互斥检查校验 仅对住院流程起作用
		// 被排斥医嘱的停止时间应为全排医嘱的开立时间
		OrMutexValidateBP bp = new OrMutexValidateBP();
		List<ReactExtOrsAndStopOrsDO> reactExtOrsAndStopOrsDO = bp.exec4Ip(aggDOs, CiOrdAppUtils.getServerDateTime());

		return saveSignData(ctx,ciorderDOs, reactExtOrsAndStopOrsDO);
	}

	/**
	 * 签署前的校验
	 * 
	 * @param aggDOs
	 * @return
	 * @throws BizException
	 */
	private OrderRstDTO validate4OrderSign(CiorderAggDO[] aggDOs) throws BizException {
		// 医嘱中服务互斥检查与处理
		SrvMutexValidateBP srvmutexbp = new SrvMutexValidateBP();
		String rstsrvmutex = srvmutexbp.exec4Ip(aggDOs);
		if (!StringUtils.isNullOrEmpty(rstsrvmutex)) {
			return getOrderRstDTO(OrderUtils.KYE_MESSAGE, rstsrvmutex);
		}

		// 皮试医嘱保存校验
		SkinTestOrSignBP skintestbp = new SkinTestOrSignBP();
		String rstskintest = skintestbp.exec(aggDOs);
		if (!StringUtils.isNullOrEmpty(rstskintest)) {
			return getOrderRstDTO(OrderUtils.KYE_MESSAGE, rstskintest);
		}

		// 病理标本项目非空检查
		PathgySampValidateBP pathgysampbp = new PathgySampValidateBP();
		String rstpathgysamp = pathgysampbp.exec(aggDOs);
		if (!StringUtils.isNullOrEmpty(rstpathgysamp)) {
			return getOrderRstDTO(OrderUtils.KYE_MESSAGE, rstpathgysamp);
		}

		// 用血医嘱可用血余量的校验
		UseBtOrNumMarginBuValidateBP usebtbp = new UseBtOrNumMarginBuValidateBP();
		String rstbtrst = usebtbp.exe(aggDOs);
		if (!StringUtils.isNullOrEmpty(rstbtrst)) {
			return getOrderRstDTO(OrderUtils.KYE_MESSAGE, rstbtrst);
		}

		// 医嘱服务签署权限判断
		OrSrvDoctorRtValidateBP srvdocrtbp = new OrSrvDoctorRtValidateBP();
		String orsrvrtchk = srvdocrtbp.exec4Ip(aggDOs);
		if (!StringUtils.isNullOrEmpty(orsrvrtchk)) {
			return getOrderRstDTO(OrderUtils.KYE_MESSAGE, orsrvrtchk);
		}
		return null;
	}

	/**
	 * 获取返回结果
	 * 
	 * @param messageinfo
	 * @return
	 */
	private OrderRstDTO getOrderRstDTO(String messagekey, Object messageinfo) {
		OrderRstDTO rstDTO = new OrderRstDTO();
		FMap2 scene = new FMap2();
		scene.put(messagekey, messageinfo);
		rstDTO.setExtension(scene);
		return rstDTO;
	}

	/**
	 * 特殊病判断，返回需要校验特殊病的服务集合
	 * 
	 * @param aggs
	 * @param ctx
	 * @param mapIdOrsrv
	 * @return
	 * @throws BizException
	 */
	private String judgeSpecillFlag(CiorderAggDO[] aggs, CiEnContextDTO ctx) throws BizException {
		// Ent4BannerDTO banner = ctx.getEnt4BannerDTO();
		// return "西药，中药";
		// 非医保或患者非特病返回false
		if (CiOrdUtils.isEmpty(ctx.getId_hp()) || ctx.getFg_hpspcl() == null || !ctx.getFg_hpspcl().booleanValue())
			return null;
		FArrayList idOrsrvs = new FArrayList();
		Map<String, OrdSrvDO> ordsrvMap = new HashMap<String, OrdSrvDO>();
		for (CiorderAggDO agg : aggs) {
			OrdSrvDO[] ordsrvs = agg.getOrdSrvDO();
			for (OrdSrvDO srv : ordsrvs) {
				if (FBoolean.FALSE.equals(srv.getFg_self()) && FBoolean.FALSE.equals(srv.getFg_selfpay())
						&& srv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)) {
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
			EntDiDO[] entdis = CiOrdAppUtils.getCiOrdQryService().getEntDiDOList(ctx.getId_en());
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
							specilDrugs.append(name_srv + "[" + mmMap.get(specill.getId_mm()).getName_mm()
									+ "] 是特殊病药品，未录入其对应特殊病的诊断: " + getMapName(diagmap) + System.lineSeparator());
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
			StringBuffer str = new StringBuffer();
			for (Object info : specilDrugs) {
				str.append(info.toString());
			}
			return str.append("是否录入?").toString();
		} else {
			return null;
		}
	}

	/**
	 * 特殊病诊断集合
	 * 
	 * @param diagmap
	 *            特殊病诊断集合
	 * @return
	 */
	private String getMapName(FMap2 diagmap) {
		StringBuffer sb = new StringBuffer();
		if (diagmap == null || diagmap.isEmpty()) {
			return "";
		}

		for (Object key : diagmap.keySet()) {
			sb.append("，" + key + " " + diagmap.get(key));
		}

		return sb.substring(1);
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
		FBoolean poisinfocheck = CiOrdUtils.Poisinfocheck(Context.get().getOrgId(),"10");
		if(poisinfocheck==FBoolean.FALSE){
			return ordsrvPois;
		}
		
		FMap orsrvMap = new FMap();
		for (CiorderAggDO agg : aggors) {
			if (!agg.getParentDO().getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG))
				continue;
			OrdSrvDO[] ordSrvdos = agg.getOrdSrvDO();
			for (OrdSrvDO srvdo : ordSrvdos) {
				idorsrvs.append(srvdo.getId_orsrv());
				orsrvMap.put(srvdo.getId_orsrv(), srvdo);
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
				OrSrvAgentInfoDO[] orsrvAgentInfoDOs = CiOrdAppUtils.getCiorsrvagentRService()
						.findByAttrValList("Id_orsrv", idorsrvs);
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
	 * 执行签署数据更新
	 * 
	 * @param ciors
	 * @throws BizException
	 */
	private OrderRstDTO saveSignData(CiEnContextDTO ctx, CiOrderDO[] ciors, List<ReactExtOrsAndStopOrsDO> reactExtOrsAndStopOrsDO)
			throws BizException {

		OrderRstDTO dto = new OrderRstDTO();
		FMap2 scene = new FMap2();
		// 更新医嘱状态为签署
		updateOrderStatus(ctx, ciors);

		// 排斥时，排斥的有效医嘱停止处理逻辑 仅住院
		handleReactExtOrsAndStopOrs(reactExtOrsAndStopOrsDO,scene);

		// 备血可用血余量更新
		UseBtOrNumMarginBuUpdateBP bpBuUpdate = new UseBtOrNumMarginBuUpdateBP();
		bpBuUpdate.exec(ciors, true);

		// 签署时，按规则自动分方 仅门急诊使用 新接口 可配置第三方插件
		// TODO: 合并国际代码
//		CiOrIpPresSplitHandleBP bpPresSplit = new CiOrIpPresSplitHandleBP();
//		bpPresSplit.exec(ctx, ciors, null);

		// 检验合单
		// CiLisOrSmsHandlerBP bpLis = new CiLisOrSmsHandlerBP();
		// bpLis.exec(ctx, ciors, null);

		// 保存检查打印数据
		CiprnSaveAppRisDataBP bpRis = new CiprnSaveAppRisDataBP();
		bpRis.exec(ctx, ciors, null);

		// 保存病理打印数据
		CiprnSaveAppPathgyDataBP bpPathgy = new CiprnSaveAppPathgyDataBP();
		bpPathgy.exec(ciors, null);

		// 保存备血打印数据
		CiprnSaveAppBtDataBP bpBt = new CiprnSaveAppBtDataBP();
		bpBt.exec(ctx, ciors, null);

		// 保存取血打印数据
		CiprnSaveAppBuDataBP bpBu = new CiprnSaveAppBuDataBP();
		bpBu.exec(ctx, ciors, null);

		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciors);

		// // 医嘱记账（科研记账）
		// ServiceFinder.find(ICiOrdBlService.class).keepAccounts(context,
		// Arrays.asList(ciors));
		
		// 判断是否为医技补录医嘱签署逻辑
		handleMtOrderSignInfo(ctx,ciors);
		//判断是否为护嘱医嘱签署逻辑
		handleNurOrderSignInfo(ctx,ciors);

		scene.put("ciors", CiOrdUtils.array2FArrayList(ciors));
		dto.setExtension(scene);
		dto.setIsSuccess(FBoolean.TRUE);
		return dto;
	}
	
	/**
	 * 排斥时，排斥的有效医嘱停止处理逻辑 仅住院
	 * @param reactExtOrsAndStopOrsDO
	 * @param scene
	 * @throws BizException
	 */
	private void handleReactExtOrsAndStopOrs(List<ReactExtOrsAndStopOrsDO> reactExtOrsAndStopOrsDO,FMap2 scene) throws BizException{
		if (reactExtOrsAndStopOrsDO != null && reactExtOrsAndStopOrsDO.size() > 0) {
			StringBuffer strbf = new StringBuffer();
			for (ReactExtOrsAndStopOrsDO reactStopDTO : reactExtOrsAndStopOrsDO) {
				CiOrValidFgLongOrStopBP bp2 = new CiOrValidFgLongOrStopBP();
				ArrayList<CiOrderDO> reactstopors = bp2.exec4Ip(reactStopDTO);
				if (CiOrdUtils.isEmpty(reactstopors))
					continue;
				String names = "";
				for (CiOrderDO ciord : reactstopors) {
					names += "、" + ciord.getName_or();
				}

				if (names.length() > 0) {
					strbf.append(IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL.equals(reactStopDTO.getSd_reacttp())
							? "全排提示信息：\n" : "组排提示信息：\n").append("1.")
							.append(reactStopDTO.getReactextdo().getParentDO().getName_or())
							.append(IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL.equals(reactStopDTO.getSd_reacttp())
									? "是全排医嘱，会对活动的长期医嘱进行排斥处理。\n" : "是组排医嘱，会对同组的活动长期医嘱进行排斥处理。\n")
							.append("2.被排斥的医嘱如下:\n").append(names.substring(1, names.length()));
				}
			}
			if (strbf.length() > 0) {
				scene.put(OrderUtils.ReactMsg, strbf.toString());
			}

		}
	}

	/**
	 * 【医技医生站】医技医嘱签署后，自动化流程触发
	 * @param ctx
	 * @param ciors
	 * @throws BizException
	 */
	private void handleMtOrderSignInfo(CiEnContextDTO ctx,CiOrderDO[] ciors) throws BizException{
		if(ICiDoctorStationTypeConst.Type_Ip_MtDoctor_Station.equals(ctx.getStationType())){
			// 过滤当前医嘱的执行科室必须为本科室(是否需要 限定服务类型？？)
			List<CiOrderDO> orderInfoList = new ArrayList<CiOrderDO>();
			for(CiOrderDO orderInfo : ciors){
				if(orderInfo.getId_dep_mp()!=null && orderInfo.getId_dep_mp().equals(ctx.getId_dep_or())){
					orderInfoList.add(orderInfo);
				}
			}
			
			if(orderInfoList.size() > 0){
				// 医技医嘱确认
				OrConfirmBP confirmBP = new OrConfirmBP();
				String errorMsg = confirmBP.runMtOrderSignConfirm(orderInfoList.toArray(new CiOrderDO[orderInfoList.size()]));
				if(!StringUtils.isNullOrEmpty(errorMsg)){
					throw new BizException (errorMsg); 
				}
			}
			
		}
	}
	/**
	 * 【护嘱医生站】医技医嘱签署后，自动化流程触发
	 * @param ctx
	 * @param ciors
	 * @throws BizException
	 */
	private void handleNurOrderSignInfo(CiEnContextDTO ctx,CiOrderDO[] ciors) throws BizException{
		if(ICiDoctorStationTypeConst.Type_Ip_NurDoctor_Station.equals(ctx.getStationType())){
			// 过滤当前医嘱的执行科室必须为本科室(是否需要 限定服务类型？？)
			List<CiOrderDO> orderInfoList = new ArrayList<CiOrderDO>();
			for(CiOrderDO orderInfo : ciors){
				if(orderInfo.getId_dep_mp()!=null && orderInfo.getId_dep_mp().equals(ctx.getId_dep_or())){
					orderInfoList.add(orderInfo);
				}else if(orderInfo.getId_dep_mp()!=null && !orderInfo.getId_dep_mp().equals(ctx.getId_dep_or())){
					throw new BizException(String.format("【%s】开单科室和执行科室不一致，执行科室必须为本科室执行", orderInfo.getName_or()));
				}
			}
			
			if(orderInfoList.size() > 0){
				// 护嘱确认
				OrConfirmBP confirmBP = new OrConfirmBP();
				String errorMsg = confirmBP.runNurOrderSignConfirm(orderInfoList.toArray(new CiOrderDO[orderInfoList.size()]));
				if(!StringUtils.isNullOrEmpty(errorMsg)){
					throw new BizException (errorMsg); 
				}
				List<String> stopIdOrs = new ArrayList<String>();
				//存在结束时间，进行停止确认
				OrderStopBP stopBP = new OrderStopBP();
				for (CiOrderDO orderInfo : orderInfoList) {
					if (orderInfo.getDt_end() != null && orderInfo.getDt_end().before(new FDateTime("2089-01-01 00:00:01"))&&FBoolean.TRUE.equals(orderInfo.getFg_long())) {
						OrderOperateDTO operateDTO = new OrderOperateDTO();
						operateDTO.setExtension(new FMap2());
						operateDTO.getExtension().put("OrderStopTime", orderInfo.getDt_end());
						operateDTO.setDocument(new FArrayList());
						operateDTO.getDocument().append(orderInfo.getId_or());
						stopBP.stop(ctx, operateDTO);
						stopIdOrs.add(orderInfo.getId_or());
					}
				}
				if(stopIdOrs.size()>0){
					//执行域响应停止操作
					CiOrdAppUtils.getIResponseOrderHandelService().responseOrStop(stopIdOrs.toArray(new String[0]));
				}
			}
			
		}
	}
	/**
	 * 护嘱签署时，校验执行科室
	 * @param ciors
	 */
	private void validaeNurOrderSign(CiOrderDO[] ciors){
		for(CiOrderDO cior : ciors){
			//开单科室和执行科室必须一致
		}
	}
	/**
	 * 更新医嘱签署状态
	 * 
	 * @param orders
	 * @throws BizException
	 */
	private void updateOrderStatus(CiEnContextDTO enContext, CiOrderDO[] orders) throws BizException {
		String[] arrayFieldNames = new String[] { CiOrderDO.ID_SU_OR, CiOrderDO.SD_SU_OR, 
				CiOrderDO.FG_SIGN, CiOrderDO.DT_SIGN, 
				CiOrderDO.ID_DEP_SIGN, CiOrderDO.ID_EMP_SIGN };
		FDateTime dtNow = CiOrdAppUtils.getServerDateTime();
		String id_dep = enContext.getId_dep_or();
		String id_emp = enContext.getId_emp_or();
		List<CiOrderDO> origindos = new ArrayList<CiOrderDO>();
		for (CiOrderDO order : orders) {
			origindos.add(order);

			order.setId_su_or(ICiDictCodeConst.SD_SU_ID_SIGN);
			order.setSd_su_or(ICiDictCodeConst.SD_SU_SIGN);
			order.setFg_sign(FBoolean.TRUE);
			order.setDt_sign(dtNow);
			order.setId_dep_sign(id_dep);
			order.setId_emp_sign(id_emp);
		}
		new DAFacade().updateDOArray(orders, arrayFieldNames);
	}
	/**
	 * 护嘱是否启用路径审核是否启用
	 * @param id_org
	 * @return
	 */
	private boolean getNursHpCheck(String id_org){
		try{
			return ParamsetQryUtil.getParaBoolean(id_org,
				ICiOrdCustomSysParamConst.LL_NURS_HP_CHECK).booleanValue();
		}catch(Exception ex){
			return false;
		}
	}
}
