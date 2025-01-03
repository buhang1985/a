package iih.ci.ord.s.bp.validate.skintest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.fc.wf.d.OrRecurTypeEnum;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.ems.i.IEmsManagementService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.medusage.i.IMedusageRService;
import iih.bd.utils.BdMmParamUtils;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.hp.gj.HpService;
import iih.ci.ord.hp.gj.HpService.MedSrvHpParam;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.save.op.CiOrSkinTestRsPreSaveBP;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.ci.ord.s.ems.cache.BDMmDoseUnitInfoCache;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.third.base.OrderPakageInfo;
import iih.ci.ord.s.ems.third.def.DefaultDrugsCreateOrderInfo;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.utils.OrderSrvRefUtils;
import iih.ci.ord.s.ems.utils.OrderUtils;
import iih.ci.ord.s.ems.utils.meta.DrugOrContentParam;
import iih.ci.ord.s.ems.utils.meta.OrContentDTO;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 药品皮试医嘱保存
 * 
 * @author zhangwq
 *
 */
public class SaveDrugSkinBP {
	private IMeterialMDORService mmRService;
	private IMedsrvMDORService medSrvMDORService;
	private CiEnContextDTO ciEnContextDTO;
	// 原液皮试的默认用法
	private String mmSkinDefaultRoute;
	// 原液皮试的默认剂量
	private FDouble mmSkinDefaultMedu;

	public SaveDrugSkinBP() {
		ciEnContextDTO = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
	}

	public CiOrderDO save(CiOrderDO orderDO, OrdSrvDO[] srvdos,MeterialDO skinMMDO) throws BizException {
		String id_mmskin = skinMMDO.getId_mmskin();
		MeterialDO skinDrugMMDO = null;
		if (id_mmskin.equals(skinMMDO.getId_mm())) {
			skinDrugMMDO = skinMMDO;
		} else {
			skinDrugMMDO = getMeterialMDORService().findById(id_mmskin);
		}
		MedSrvDO skinSrvDO = getMedSrvDO(skinDrugMMDO.getId_srv());
		DefaultDrugsCreateOrderInfo defaultDrug = new DefaultDrugsCreateOrderInfo();
		DefaultCreateParam defaultParma = new DefaultCreateParam(skinSrvDO, skinDrugMMDO, null);
		OrderPakageInfo[] szOrderPakageInfo = defaultDrug.createOrdeAggInfo(ciEnContextDTO,
				new DefaultCreateParam[] { defaultParma });
		OrderPakageInfo opInfo = szOrderPakageInfo[0];
		// 稀释液信息
		skinDilutionDrug(opInfo);
		handleData(opInfo);
		CiorderAggDO orderAggDO = opInfo.getOrderAggInfo();
		CiOrderDO mmOrderDO = orderAggDO.getParentDO();
		if (orderDO.getFg_pres_outp()!=null&&FBoolean.TRUE.equals(orderDO.getFg_pres_outp())) {
			mmOrderDO.setFg_pres_outp(FBoolean.TRUE);
			mmOrderDO.setId_drugdeliverymethod("@@@@Z8100000000UF5XZ");
			mmOrderDO.setSd_drugdeliverymethod("2");
			mmOrderDO.setName_drugdeliverymethod("出院带药");
		}
		// 用法关联费用
		UsageRelFeeSrv(opInfo);
		checkStock(opInfo.getOrderAggInfo(), opInfo.getOrderSrvMmList());
		// 保存医嘱
		CiorderAggDO[] szRstOrderAggInfo = CiOrdAppUtils.getOrAggService()
				.save(new CiorderAggDO[] { opInfo.getOrderAggInfo() });
		// 保存物品信息
		if (opInfo.getOrderSrvMmList() != null && opInfo.getOrderSrvMmList().size() > 0) {
			CiOrdAppUtils.getOrsrvmmService().save(opInfo.getOrderSrvMmList().toArray(new OrdSrvMmDO[0]));
		}
		// 保存皮试医嘱结果
		CiOrSkinTestRsPreSaveBP bp = new CiOrSkinTestRsPreSaveBP();
		bp.exec(szRstOrderAggInfo[0]);
		// 如果用药医嘱和皮试医嘱是相同物品，用药医嘱的数量-1
		if (id_mmskin.equals(skinMMDO.getId_mm())) {
			// 控制原液皮试用药医嘱和皮试医嘱是相同物品，用药医嘱的数量是否-1 0为默认-1
			String skinTestDosage = ParamsetQryUtil.getParaString(Context.get().getOrgId(),
					ICiOrdNSysParamConst.SYS_PARAM_SkinTestDosage);
			if (!StringUtils.isNullOrEmpty(skinTestDosage)) {
				if ("0".equals(skinTestDosage)) {
					OrdSrvMmDO srvMmDO=handelDrugOrQuanCur(srvdos,skinMMDO.getId_mm(), orderDO.getId_or());
					//重新设置医嘱拼接内容
					//0184620: 【验证版】门急诊医生站，开立原液皮试，签署皮试剂后，原液皮试医嘱拼接的数量没-1，但是实际数量已经-1了
					setContentOr(srvMmDO,skinDrugMMDO,srvdos,orderDO);
				}
			}

		}
		return szRstOrderAggInfo[0].getParentDO();
	}
	/**
	 * 重新设置医嘱内容拼接
	 * @param srvMmDO
	 * @param skinDrugMMDO
	 * @param srvdos
	 * @param orderDO
	 * @throws BizException
	 */
	private void setContentOr(OrdSrvMmDO srvMmDO,MeterialDO skinDrugMMDO,OrdSrvDO[] srvdos,CiOrderDO orderDO)throws BizException{
		srvMmDO.setSpec(skinDrugMMDO.getSpec());
		Map<String, OrdSrvMmDO> mapTeamSrvDOs = getOrSrvMmDOMap(srvdos);
		List<OrdSrvDO> ordSrvList=new ArrayList<OrdSrvDO>();
		if(srvdos!=null){
			for(OrdSrvDO srvdo : srvdos){
				if(!CiOrdUtils.isEmpty(srvdo.getId_orsrv()) && srvdo.getId_orsrv().equals(srvMmDO.getId_orsrv())){
					ordSrvList.add(srvdo);
				}
			}
		}
		if(ordSrvList!=null && ordSrvList.size()>0) {
			CiorderAggDO aggDO =new CiorderAggDO();
			aggDO.setParentDO(orderDO);
			aggDO.setOrdSrvDO(ordSrvList.toArray(new OrdSrvDO[0]));
			DrugOrContentParam drugOrContentParam = new DrugOrContentParam(aggDO,getOrContentDTOs(srvdos, mapTeamSrvDOs));
			CiOrContentDO contentdo=new CiOrContentDO();
			Object[] params = new Object[]{contentdo,drugOrContentParam};
			BDCommonEvent event = new BDCommonEvent(SourceIdConst.COPY_CONTENTOR_DRUG_SOURCEID, IEventType.TYPE_UPDATE_AFTER, params);
			EventDispatcher.fireEvent(event);
			orderDO.setContent_or(contentdo==null?"":contentdo.toString());
			orderDO.setStatus(DOStatus.UPDATED);
			CiorderAggDO newaggDO =new CiorderAggDO();//只保存ciorderdo别的不管 不然会出问题
			newaggDO.setParent(aggDO.getParentDO());
			CiOrdAppUtils.getOrAggService().update(new CiorderAggDO[] { newaggDO });
		}
	}
	private Map<String, OrdSrvMmDO> getOrSrvMmDOMap(OrdSrvDO[] srvdos) throws BizException{
		IOrdsrvmmRService mmRService = ServiceFinder.find(IOrdsrvmmRService.class);
		List<String> idorsrvs = new ArrayList<String>();
		for (OrdSrvDO ordSrvDO : srvdos) {
			idorsrvs.add(ordSrvDO.getId_orsrv());
		}
		OrdSrvMmDO[] ordSrvMMDos = mmRService.findByAttrValStrings(OrdSrvMmDO.ID_ORSRV, idorsrvs.toArray(new String[0]));
		Map<String,OrdSrvMmDO> map = new HashMap<String,OrdSrvMmDO>();
		if(ordSrvMMDos!=null &&ordSrvMMDos.length >0){
			for (OrdSrvMmDO ordSrvMmDO : ordSrvMMDos) {
				map.put(ordSrvMmDO.getId_orsrv(), ordSrvMmDO);
			}
		}
		return map;
	}
	/**
	 * 处理用法关联费用，用于诊疗费用
	 * 
	 * @param opInfo
	 * @throws BizException
	 */
	private void UsageRelFeeSrv(OrderPakageInfo opInfo) throws BizException {
		OrdSrvDO[] routeRelFeeSrvs = OrderSrvRefUtils.RouteRelFeeSrvs(this.ciEnContextDTO,
				opInfo.getOrderAggInfo().getParentDO());
		if (routeRelFeeSrvs == null || routeRelFeeSrvs.length == 0) {
			return;
		}
		// 将用法关联的费用添加到agg中
		CiorderAggDO aggdo = opInfo.getOrderAggInfo();
		OrdSrvDO[] ordSrvs = aggdo.getOrdSrvDO();
		int ordSrvslength = ordSrvs.length;
		ordSrvs = Arrays.copyOf(ordSrvs, ordSrvs.length + routeRelFeeSrvs.length);
		System.arraycopy(routeRelFeeSrvs, 0, ordSrvs, ordSrvslength, routeRelFeeSrvs.length);
		aggdo.setOrdSrvDO(ordSrvs);
	}

	/**
	 * 皮试稀释药品
	 * 
	 * @param opInfo
	 * @throws BizException
	 */
	private void skinDilutionDrug(OrderPakageInfo opInfo) throws BizException {
		String dilutionParam = null;
		try {
			dilutionParam = ParamsetQryUtil.getParaString(Context.get().getOrgId(),
					ICiOrdCustomSysParamConst.ZB_SKIN_DILUTION_MM);
		} catch (BizException e) {
			OrdBizLogger.info(this.ciEnContextDTO, "参数：ZB_CIOR0001，获取异常");
			return;
		}
		if (StringUtils.isNullOrEmpty(dilutionParam)) {
			return;
		}
		// 长度为2，index：0为物品编码，index:1为剂量
		String[] params = dilutionParam.split(":|：");
		if (params.length != 2) {
			OrdBizLogger.info(this.ciEnContextDTO, "参数：ZB_CIOR0001参数格式【商品编码：单次剂量】，格式维护错误，");
			return;
		}
		String mmCode = params[0];
		String mmQuanMedu = params[1];
		String regex = "([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])";
		if (mmQuanMedu.matches(regex)) {
			// 找到物品
			MeterialDO mm = getMeterialDO(mmCode);
			if (mm == null) {
				return;
			}
			MedSrvDO medsrv = getMedSrvDO(mm.getId_srv());
			String[] ids = new DBUtil().getOIDs(1);
			OrdSrvDO ordsrv = createOrdSrvDO(medsrv, mm, new FDouble(mmQuanMedu));
			ordsrv.setId_orsrv(ids[0]);
			OrdSrvMmDO ordsrvmm = createOrdSrvMMDO(mm, new FDouble(mmQuanMedu));
			ordsrvmm.setId_orsrv(ids[0]);
			List<OrdSrvDO> srvList = new ArrayList<OrdSrvDO>();
			List<OrdSrvDO> srvs = Arrays.asList(opInfo.getOrderAggInfo().getOrdSrvDO());
			srvList.addAll(srvs);
			srvList.add(ordsrv);
			opInfo.getOrderAggInfo().setOrdSrvDO(srvList.toArray(new OrdSrvDO[0]));
			opInfo.getOrderSrvMmList().add(ordsrvmm);
		} else {
			OrdBizLogger.info(this.ciEnContextDTO, "参数：ZB_CIOR0001参数格式【商品编码：单次剂量】，剂量维护是数字");
		}
	}

	private OrdSrvDO createOrdSrvDO(MedSrvDO medsrv, MeterialDO mm, FDouble quan_medu) throws BizException {
		OrdSrvDO srvdo = new OrdSrvDO();
		srvdo.setId_grp(this.ciEnContextDTO.getId_grp());
		srvdo.setId_org(this.ciEnContextDTO.getId_org());
		srvdo.setId_pat(this.ciEnContextDTO.getId_pat());
		srvdo.setId_entp(this.ciEnContextDTO.getId_entp());
		srvdo.setCode_entp(this.ciEnContextDTO.getCode_entp());
		srvdo.setId_en(this.ciEnContextDTO.getId_en());
		srvdo.setSortno(0);
		srvdo.setId_srvtp(medsrv.getId_srvtp());
		srvdo.setSd_srvtp(medsrv.getSd_srvtp());
		srvdo.setId_srv(medsrv.getId_srv());
		srvdo.setName(medsrv.getName());
		srvdo.setFg_dose_anoma(null);
		//srvdo.setMedu_name(medsrv.getMed_name());
		srvdo.setQuan_medu(quan_medu);
		String drugManagementModel = BdMmParamUtils.GetDrugMCPropMM();
		if (IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(drugManagementModel)) {
			srvdo.setId_medu(mm.getId_unit_med());
			srvdo.setMedu_name(mm.getUnit_med_name());
		} else {
			srvdo.setId_medu(medsrv.getId_unit_med());
			srvdo.setMedu_name(medsrv.getMed_name());
		}
		srvdo.setId_route(medsrv.getId_route());
		srvdo.setId_routedes(medsrv.getId_routedes());
		srvdo.setId_boil(medsrv.getId_boil());
		srvdo.setId_boildes(medsrv.getId_boildes());
		srvdo.setId_freq(medsrv.getId_freq());
		srvdo.setId_org_srv(this.ciEnContextDTO.getId_org());
		srvdo.setId_dep_srv(this.ciEnContextDTO.getId_dep_or());
		srvdo.setId_wg_or(this.ciEnContextDTO.getId_wg_or());
		srvdo.setId_emp_srv(this.ciEnContextDTO.getId_emp_or());
		srvdo.setDt_create(CiOrdAppUtils.getServerDateTime());

		// srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvInfo.getId_mp_dep()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		srvdo.setFg_or(medsrv.getFg_or());
		srvdo.setEu_blmd(medsrv.getEu_blmd());
		srvdo.setFg_mm(CiOrdUtils.nullHandle(medsrv.getFg_mm()));
		srvdo.setId_mm(mm.getId_mm());
		CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(this.ciEnContextDTO.getCode_entp(), medsrv.getId_srv(),
				medsrv.getId_primd(), srvdo);
		srvdo.setFg_set(CiOrdUtils.nullHandle(medsrv.getFg_set()));
		srvdo.setNote_srv(medsrv.getDes());
		srvdo.setId_srvca(medsrv.getId_srvca());
		srvdo.setFg_bl(CiOrdUtils.nullHandle(medsrv.getFg_bl()));
		srvdo.setCode_srv(medsrv.getCode());
		srvdo.setId_primd(medsrv.getId_primd());

		srvdo.setFg_selfsrv(medsrv.getFg_ctm());
		srvdo.setId_hp(this.ciEnContextDTO.getId_hp());// 2016-07-12新增医保相关信息

		srvdo.setFg_feertnable(FBoolean.TRUE); // 可退费标识
		srvdo.setStatus(DOStatus.NEW);
		return srvdo;
	}

	private OrdSrvMmDO createOrdSrvMMDO(MeterialDO mmdo, FDouble quan_med) throws BizException {
		MedSrvDrugDO drugdo = getMedSrvDrugDO(mmdo.getId_srv());
		OrdSrvMmDO srvmmdo = new OrdSrvMmDO();
		srvmmdo.setSpec(mmdo.getSpec());
		srvmmdo.setId_mm(mmdo.getId_mm()); // 医疗物品
		srvmmdo.setCode_mm(mmdo.getCode()); // 物品编码
		srvmmdo.setName_mm(mmdo.getName()); // 物品名称
		srvmmdo.setId_pgku_base(mmdo.getId_unit_pkgbase()); // 基本包装单位
		int[] numben = OrSrvSplitUtil.getNumDen(quan_med, mmdo.getFactor_mb());
		srvmmdo.setQuan_num_base(numben[0]); // 单次数量_分子
		srvmmdo.setQuan_den_base(numben[1]); // 单次数量_分母
		srvmmdo.setFactor_mb(mmdo.getFactor_mb()); // 换算系数_医疗基本
		if (drugdo != null) {
			srvmmdo.setId_dosage(drugdo.getId_dosage()); // 药品剂型
			srvmmdo.setSd_dosage(drugdo.getSd_dosage()); // 药品剂型编码
			srvmmdo.setId_pharm(drugdo.getId_pharm()); // 药理分类
			srvmmdo.setSd_pharm(drugdo.getSd_pharm()); // 药理分类编码
			srvmmdo.setId_pois(drugdo.getId_pois()); // 毒麻分类
			srvmmdo.setSd_pois(drugdo.getSd_pois()); // 毒麻分类编码
			srvmmdo.setId_anti(drugdo.getId_anti()); // 抗菌药分类
			srvmmdo.setSd_anti(drugdo.getSd_anti()); // 抗菌药分类编码
		}
		srvmmdo.setId_mmtp(mmdo.getId_mmtp()); // 物品类型
		srvmmdo.setSd_mmtp(mmdo.getSd_mmtp()); // 物品类型编码
		srvmmdo.setFg_otc(mmdo.getFg_otc()); // OTC标识
		if (this.ciEnContextDTO.getCode_entp() == IBdFcDictCodeConst.SD_CODE_ENTP_OP) {
			srvmmdo.setId_mupkgutp(mmdo.getId_opmutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_opmutp()); // 包装单位取整模式编码
		} else if (this.ciEnContextDTO.getCode_entp() == IBdFcDictCodeConst.SD_CODE_ENTP_IP) {
			srvmmdo.setId_mupkgutp(mmdo.getId_mupkgutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_mupkgutp()); // 包装单位取整模式编码
		} else if (this.ciEnContextDTO.getCode_entp() == IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW) {
			srvmmdo.setId_mupkgutp(mmdo.getId_ermutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_ermutp()); // 包装单位取整模式编码
		}  else if (this.ciEnContextDTO.getCode_entp() == IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID) {
			srvmmdo.setId_mupkgutp(mmdo.getId_er1mutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_er1mutp()); // 包装单位取整模式编码
		}  else if (this.ciEnContextDTO.getCode_entp() == IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS) {
			srvmmdo.setId_mupkgutp(mmdo.getId_er2mutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_er2mutp()); // 包装单位取整模式编码
		} 
		srvmmdo.setId_srv(mmdo.getId_srv()); // 药品服务id
		//0191300: 【验证版】【门急诊医生站】输液带出的皮试医嘱剂量单位不正确
		srvmmdo.setId_medu_cur(mmdo.getId_unit_med());
		return srvmmdo;
	}

	/**
	 * 更新用药医嘱的总量
	 * 
	 * @param id_mm
	 * @param id_or
	 * @throws DAException
	 */
	private OrdSrvMmDO handelDrugOrQuanCur(OrdSrvDO[] srvdos,String id_mm, String id_or) throws DAException {
		String sql = "select mea.name as Name_unit_cur,mm.id_mm,mm.Sd_anti,mm.Id_pgku_cur,mm.id_orsrv,mm.id_orsrvmm,quan_cur "
				+ " from ci_or_srv_mm mm inner join ci_or_srv srv on mm.id_orsrv=srv.id_orsrv "
				+ " inner join ci_order ci on ci.id_or=srv.id_or "
				+ " left join bd_measdoc mea on mm.id_medu_cur=mea.id_measdoc "
				+ " where ci.id_or=? and mm.id_mm=?";
		DAFacade facade = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(id_or);
		param.addParam(id_mm);
		OrdSrvMmDO ordSrvMMDO = (OrdSrvMmDO) facade.execQuery(sql, param, new BeanHandler(OrdSrvMmDO.class));
		if (ordSrvMMDO.getQuan_cur() != null && ordSrvMMDO.getQuan_cur().compareTo(new FDouble(1)) >= 0) {
			ordSrvMMDO.setQuan_cur(ordSrvMMDO.getQuan_cur().sub(new FDouble(1)));
			if(srvdos!=null){
				for(OrdSrvDO srvdo : srvdos){
					if(!CiOrdUtils.isEmpty(srvdo.getId_orsrv()) && srvdo.getId_orsrv().equals(ordSrvMMDO.getId_orsrv()))
					{
						srvdo.setQuan_total_medu(ordSrvMMDO.getQuan_cur());
						if(ordSrvMMDO.getQuan_cur().compareTo(new FDouble(0))==0){
							CiOrdUtils.getlogger()
							.info("原液皮试签署后，将原用药医嘱的药品费用标识设置为N，总量设置为0:id_orsrv----" + ordSrvMMDO.getId_orsrv());
							srvdo.setFg_bl(FBoolean.FALSE);
							
							break;
						}
					}
				}
			}
			facade.updateDO(ordSrvMMDO, new String[] { OrdSrvMmDO.QUAN_CUR });
		}
		return ordSrvMMDO;
	}

	/**
	 * 处理原液皮试医嘱的默认值赋值
	 * 
	 * @param szOrderPakageInfo
	 * @throws BizException
	 */
	private void handleData(OrderPakageInfo opInfo) throws BizException {
		CalQuantumBP calQuantumBP = new CalQuantumBP();
		CiorderAggDO orderAggDO = opInfo.getOrderAggInfo();
		CiOrderDO mmOrderDO = orderAggDO.getParentDO();
		FDateTime dtNow = CiOrdAppUtils.getServerDateTime();
		// 诊断id
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(mmOrderDO.getId_en());
		if (diagOutlineInfo != null) {
			mmOrderDO.setId_didef(diagOutlineInfo.getId_didef());// 主诊断的主项目id
			mmOrderDO.setName_didef(diagOutlineInfo.getName_diag());// 主诊断名称
		}
		mmOrderDO.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
		mmOrderDO.setFg_long(FBoolean.FALSE);
		mmOrderDO.setQuan_medu(this.getDefaultDrugMedu(this.ciEnContextDTO.getId_org()));
		mmOrderDO.setId_route(getDefaultDrugRoute(this.ciEnContextDTO.getId_org()));
		mmOrderDO.setStatus(DOStatus.NEW);
		mmOrderDO.setFg_skintest(FBoolean.TRUE);// 皮试 医嘱
		mmOrderDO.setDt_effe(dtNow);
		mmOrderDO.setDt_end(dtNow);
		mmOrderDO.setDt_last_bl(dtNow);
		mmOrderDO.setEu_orsrcmdtp(OrSourceFromEnum.IIHORRELAUTOGEN);
		mmOrderDO.setId_wg_or(this.ciEnContextDTO.getId_wg_or());
		mmOrderDO.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_DOC);
		mmOrderDO.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_DOC);
		mmOrderDO.setFg_mp_in(FBoolean.TRUE);
		mmOrderDO.setTimes_mp_in(1);// 在院执行次数
		mmOrderDO.setSortno(CiOrdUtils.GetNewCiOrderSortno(mmOrderDO.getId_en()));
		mmOrderDO.setId_orpltp(OrderUtils.getOrCLoopTpId(mmOrderDO));// 设置闭环
		// 匹配申请单
		SrvMatchEmsRstDTO srvMatchEmsRstDTO = this.getMedSrvMatchEms(mmOrderDO.getId_srv(), mmOrderDO.getSd_srvtp());
		if (srvMatchEmsRstDTO != null) {
			mmOrderDO.setId_srvof(srvMatchEmsRstDTO.getId_ems());
			mmOrderDO.setFuncclassstr(srvMatchEmsRstDTO.getFuncclassstr());
		}
		OrdSrvDO[] ordSrvs = orderAggDO.getOrdSrvDO();
		for (OrdSrvDO ordSrvDO : ordSrvs) {
			ordSrvDO.setId_route(mmOrderDO.getId_route());
			ordSrvDO.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
			if (mmOrderDO.getId_srv().equals(ordSrvDO.getId_srv())) {
				ordSrvDO.setQuan_medu(this.getDefaultDrugMedu(this.ciEnContextDTO.getId_org()));
			}
			ordSrvDO.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
			ordSrvDO.setDt_last_bl(dtNow);
			// 启用医保判断的方法,并将医保计划等信息设置到drug对象中
			if (CiOrdUtils.isHpUsing(this.ciEnContextDTO)) {
				Map<String, BdHpIndicationDTO> tmpBdHpIndicationDTOCache = HpService.getMedSrvHpService(
						new MedSrvHpParam[] { new MedSrvHpParam(ordSrvDO.getId_srv(), ordSrvDO.getId_mm()) },
						ciEnContextDTO);
				if (tmpBdHpIndicationDTOCache != null && tmpBdHpIndicationDTOCache.size() > 0) {
					BdHpIndicationDTO hpIndiccation = (BdHpIndicationDTO) tmpBdHpIndicationDTOCache.values()
							.toArray()[0];

					ordSrvDO.setFg_indic(hpIndiccation.getFg_indic());
					if (hpIndiccation.getId_hpsrvtp() == null
							|| (hpIndiccation.getId_hpsrvtp().equals(IBdPpCodeTypeConst.ID_HP_BJ_THREE)
									&& !CiOrdUtils.isTrue(hpIndiccation.getFg_indic()))) {
						ordSrvDO.setFg_selfpay(FBoolean.TRUE);
					} else {
						ordSrvDO.setFg_selfpay(
								ordSrvDO.getSd_srvtp() != null && ordSrvDO.getSd_srvtp().startsWith("0103")
										? FBoolean.FALSE
										: (CiOrdUtils.isTrue(hpIndiccation.getFg_indic()) ? FBoolean.FALSE
												: FBoolean.TRUE));
					}

					ordSrvDO.setId_hp(ciEnContextDTO.getId_hp());
					ordSrvDO.setSd_hpsrvtp(hpIndiccation.getSd_hpsrvtp());
					ordSrvDO.setId_hpsrvtp(!CiOrdUtils.isEmpty(ordSrvDO.getSd_hpsrvtp())
							? CiOrdUtils.idHpSrvtpFromSdHpSrvtp(ordSrvDO.getSd_hpsrvtp()) : null);
					ordSrvDO.setFg_hpindicjudged(CiOrdUtils.getFg_hpindicjudged(hpIndiccation));
				}
			} else {// 非医保适应症时，自费标识应该为true
				ordSrvDO.setFg_selfpay(FBoolean.TRUE);
				ordSrvDO.setFg_hpindicjudged(0);
			}
			ordSrvDO.setStatus(DOStatus.NEW);
		}
		setDepWhInfo(orderAggDO,opInfo.getOrderSrvMmList());
		// 保存物品信息
		if (opInfo.getOrderSrvMmList() != null && opInfo.getOrderSrvMmList().size() > 0) {
			List<OrdSrvMmDO> ordSrvMMs = opInfo.getOrderSrvMmList();
			String[] ids = new DBUtil().getOIDs(ordSrvMMs.size());
			int index = 0;
			M: for (OrdSrvMmDO ordSrvMM : ordSrvMMs) {
				ordSrvMM.setStatus(DOStatus.NEW);
				for (OrdSrvDO ordSrvDO : ordSrvs) {
					if (ordSrvDO.getId_srv().equals(ordSrvMM.getId_srv())) {
						this.setMMInfo(ordSrvDO, ordSrvMM);
						FDouble price = this.getMMPri(ordSrvMM, ordSrvDO.getId_dep_wh());
						ordSrvDO.setPri(price);
						ordSrvMM.setPrice_pgku_cur(price);
						FDouble quan_cur = calQuantumBP.getMMQuantum(this.ciEnContextDTO.getCode_entp(), FBoolean.FALSE,
								1, ordSrvMM.getId_mm(), ordSrvMM.getId_pgku_cur(), ordSrvDO.getQuan_medu());//0191300: 【验证版】【门急诊医生站】输液带出的皮试医嘱剂量单位不正确
						ordSrvMM.setQuan_cur(quan_cur);
						ordSrvDO.setQuan_total_medu(quan_cur);
						ordSrvMM.setId_orsrv(ids[index]);
						ordSrvDO.setId_orsrv(ids[index++]);
						int[] numben = OrSrvSplitUtil.getNumDen(ordSrvDO.getQuan_medu(), ordSrvMM.getFactor_mb());
						ordSrvMM.setQuan_num_base(numben[0]);
						ordSrvMM.setQuan_den_base(numben[1]);
						continue M;
					}
				}

			}
			Map<String, OrdSrvMmDO> mapTeamSrvDOs = new HashMap<String, OrdSrvMmDO>();
			for (OrdSrvMmDO mm : ordSrvMMs) {
				mapTeamSrvDOs.put(mm.getId_orsrv(), mm);
			}
			DrugOrContentParam drugOrContentParam = new DrugOrContentParam(mmOrderDO.getSd_srvtp(), "一次",
					mmOrderDO.getDays_or(), getRouteName(), mmOrderDO.getDes_or(),FBoolean.FALSE,FBoolean.FALSE,
					getOrContentDTOs(orderAggDO.getOrdSrvDO(), mapTeamSrvDOs));
			CiOrContentDO contentdo=new CiOrContentDO();
			Object[] params = new Object[]{contentdo,drugOrContentParam};
			BDCommonEvent event = new BDCommonEvent(SourceIdConst.COPY_CONTENTOR_DRUG_SOURCEID, IEventType.TYPE_UPDATE_AFTER, params);
			EventDispatcher.fireEvent(event);
			mmOrderDO.setContent_or(contentdo==null?"":contentdo.toString());//CiOrContentUtils.create(drugOrContentParam).toString()
		}

	}

	/**
	 * 填充物品发药单位、换算系数
	 * 
	 * @param ordsrv
	 * @param ordsrvmm
	 * @throws BizException
	 */
	private void setMMInfo(OrdSrvDO ordsrv, OrdSrvMmDO ordsrvmm) throws BizException {
		if (ordsrvmm == null) {
			return;
		}
		// 药品的发药单位
		MaterialUnitDTO[] materUnit = BDMmDoseUnitInfoCache.getMaterialUnitInfos(this.ciEnContextDTO.getCode_entp(), new String[] {ordsrvmm.getId_mm()});
		 
		if (materUnit != null && materUnit.length > 0) {
			for (MaterialUnitDTO dto : materUnit) {
				if (ordsrvmm.getId_mm().equals(dto.getId_mm())) {
					ordsrvmm.setId_pgku_cur(dto.getId_measdoc());
					//0191300: 【验证版】【门急诊医生站】输液带出的皮试医嘱剂量单位不正确
					//ordsrvmm.setId_medu_cur(dto.getId_measdoc());
					if (StringUtils.isNullOrEmpty(ordsrvmm.getId_medu_cur())) {
						MeterialDO mm = getMeterialDO(ordsrvmm.getCode_mm());
						ordsrvmm.setId_medu_cur(mm.getId_unit_med());
					}
					ordsrvmm.setFactor(dto.getFactor());// 基本包装单位和总量单位间的换算系数
					break;
				}
			}
		}
	}

	/**
	 * 获取物品价格
	 * 
	 * @param ordsrvmm
	 * @param id_dep_wh
	 * @return
	 * @throws BizException
	 */
	private FDouble getMMPri(OrdSrvMmDO ordsrvmm, String id_dep_wh) throws BizException {
		GetStockReqDTO reqDTO = new GetStockReqDTO();
		reqDTO.setId_mm(ordsrvmm.getId_mm());
		reqDTO.setId_dep(id_dep_wh);
		reqDTO.setReq_unit_id(ordsrvmm.getId_pgku_cur());
		IMaterialStockService stoctService = ServiceFinder.find(IMaterialStockService.class);
		MaterialStockDTO[] materialStocks = stoctService.getMaterialStocks(new GetStockReqDTO[] { reqDTO });
		if (materialStocks != null && materialStocks.length > 0) {
			return materialStocks[0].getPrice_act();
		}
		return null;
	}

	/**
	 * 获得匹配的申请单
	 * 
	 * @param id_srv
	 * @param sd_srvtp
	 * @return
	 * @throws BizException
	 */
	private SrvMatchEmsRstDTO getMedSrvMatchEms(String id_srv, String sd_srvtp) throws BizException {
		IEmsManagementService emsManagementService = ServiceFinder.find(IEmsManagementService.class);
		// 调用匹配医疗单算法服务
		FMap rstMap = emsManagementService
				.medSrvMatchEms(new SrvMatchEmsParamDTO[] { srvMatchEmsParamFrom(id_srv, sd_srvtp) });

		// 进行匹配结果有效性验证
		if (null != rstMap && rstMap.size() > 0) {

			// 根据服务id获取医疗单匹配信息
			SrvMatchEmsRstDTO rstMatchInfo = (SrvMatchEmsRstDTO) rstMap.get(id_srv);
			return rstMatchInfo;
		}
		return null;
	}

	/**
	 * 组建医疗单匹配数据结构
	 * 
	 * @param ctx
	 * @param id_srv
	 * @param sd_srvtp
	 * @return
	 */
	private SrvMatchEmsParamDTO srvMatchEmsParamFrom(String id_srv, String sd_srvtp) {
		SrvMatchEmsParamDTO srvMatchEmsParamDTO = new SrvMatchEmsParamDTO();
		srvMatchEmsParamDTO.setId_srv(id_srv);
		srvMatchEmsParamDTO.setCode_entp(this.ciEnContextDTO.getCode_entp());
		srvMatchEmsParamDTO.setId_emp(this.ciEnContextDTO.getId_emp_or());
		srvMatchEmsParamDTO.setId_dept(this.ciEnContextDTO.getId_dep_or());
		srvMatchEmsParamDTO.setId_org(this.ciEnContextDTO.getId_org());
		srvMatchEmsParamDTO.setId_grp(this.ciEnContextDTO.getId_grp());
		srvMatchEmsParamDTO.setSd_srvtp(sd_srvtp);
		srvMatchEmsParamDTO.setDt_or(CiOrdAppUtils.getServerDateTime());
		srvMatchEmsParamDTO.setEmsappmode(this.ciEnContextDTO.getEmsappmode());
		return srvMatchEmsParamDTO;
	}

	/**
	 * 获取拼接医嘱内容的参数
	 */
	private List<OrContentDTO> getOrContentDTOs(OrdSrvDO[] ordSrvs, Map<String, OrdSrvMmDO> mapTeamSrvDOs) {
		List<OrContentDTO> list = new ArrayList<OrContentDTO>();
		for (OrdSrvDO ordSrvDO : ordSrvs) {
			if(!FBoolean.TRUE.equals(ordSrvDO.getFg_mm())){
				continue;
			}
			ordSrvDO.setName_srv(ordSrvDO.getName());
			OrContentDTO orContentDTO = new OrContentDTO(ordSrvDO,mapTeamSrvDOs.get(ordSrvDO.getId_orsrv()));
			if (mapTeamSrvDOs.containsKey(ordSrvDO.getId_orsrv())) {
				orContentDTO.setSpec(mapTeamSrvDOs.get(ordSrvDO.getId_orsrv()).getSpec());
				orContentDTO.setPrice(ordSrvDO.getPri());
				orContentDTO.setName_srv(ordSrvDO.getName());
				orContentDTO.setName_unit_med(ordSrvDO.getMedu_name());
				orContentDTO.setQuan_cur(mapTeamSrvDOs.get(ordSrvDO.getId_orsrv()).getQuan_cur());
				orContentDTO.setId_pgku_cur(mapTeamSrvDOs.get(ordSrvDO.getId_orsrv()).getId_pgku_cur());
			}
			list.add(orContentDTO);
		}
		return list;
	}

	/**
	 * 设置执行科室信息
	 * 
	 * @param mm
	 * @param source
	 * @param contextdto
	 * @throws BizException
	 */
	private void setDepWhInfo(CiorderAggDO orderAggDO,List<OrdSrvMmDO> ordSrvMMs) throws BizException {
		ICiOrdQryService ordQryService = ServiceFinder.find(ICiOrdQryService.class);
		CiOrderDO orderdo = orderAggDO.getParentDO();
		OrdSrvDO[] ordsrvs = orderAggDO.getOrdSrvDO();
		// 查询执行科室
		OrWfExDeptParamDTO param = new OrWfExDeptParamDTO();
		param.setEu_wftp(EnumFlow.NULL); // 0执行与物资 1执行科室 2物资流向
		param.setCode_entp(this.ciEnContextDTO.getCode_entp()); // 就诊类型
		param.setId_dept_ns(this.ciEnContextDTO.getId_dep_ns()); // 就诊护理病区
		param.setId_dept_or(Context.get().getDeptId());// 开单科室
		param.setId_dept_en(this.ciEnContextDTO.getId_dep_en()); // 就诊科室
		param.setId_srv(orderdo.getId_srv()); // 服务
		param.setSd_srvtp(orderdo.getSd_srvtp()); // 服务类型sd
		param.setId_srvca(orderdo.getId_srvca()); // 服务分类
		param.setRecurstr(orderdo.getFg_long() == null ? OrRecurTypeEnum.NULL.toString()
				: (orderdo.getFg_long().booleanValue() ? OrRecurTypeEnum.LONG.toString()
						: OrRecurTypeEnum.TEMP.toString()));
		param.setId_usage(orderdo.getId_route()); // 用法
		if(ordSrvMMs!=null &&ordSrvMMs.size()>0){
			param.setId_mm(ordSrvMMs.get(0).getId_mm());
			param.setSd_herbpreparationtp(ordSrvMMs.get(0).getSd_herbpreparationtp());
			param.setId_dosage(ordSrvMMs.get(0).getId_dosage());
			param.setSd_pois(ordSrvMMs.get(0).getSd_pois());
		}
		FDateTime fdt = new FDateTime();
		param.setTimestr(fdt.getUFTime());
		param.setWeekno(CiOrdUtils.getDayOfWeek(fdt));
		param.setFg_pres_outp(FBoolean.FALSE);
		if(orderdo.getFg_pres_outp()!=null&&orderdo.getFg_pres_outp().booleanValue()) {
			param.setFg_pres_outp(FBoolean.TRUE);
		}
		OrWfDeptInfoDTO orWfDeptInfoDTO = ordQryService.getExeDepts4CiOrSrvN(param);
		if (orWfDeptInfoDTO != null && orWfDeptInfoDTO.getOrwfexedepts() != null
				&& orWfDeptInfoDTO.getOrwfexedepts().size() != 0) {
			String id_dep_mp = ((OrWfExDeptDTO) orWfDeptInfoDTO.getOrwfexedepts().get(0)).getId_dept();
			orderdo.setId_dep_mp(id_dep_mp);
			for (OrdSrvDO ordsrv : ordsrvs) {
				ordsrv.setId_dep_mp(id_dep_mp);
			}
		}else{
			throw new BizException("医嘱【"+orderdo.getName_or()+"】没有匹配到执行科室");
		}
		if (orWfDeptInfoDTO != null && orWfDeptInfoDTO.getPharmwfwhdepts() != null
				&& orWfDeptInfoDTO.getPharmwfwhdepts().size() != 0) {
			String id_dep_wh = ((OrWfExDeptDTO) orWfDeptInfoDTO.getPharmwfwhdepts().get(0)).getId_dept();
			for (OrdSrvDO ordsrv : ordsrvs) {
				ordsrv.setId_dep_wh(id_dep_wh);
			}
		}else{
			throw new BizException("医嘱【"+orderdo.getName_or()+"】没有匹配到药房");
		}
	}

	private String getRouteName() throws BizException {
		IMedusageRService usageService = ServiceFinder.find(IMedusageRService.class);
		MedUsageDO usage = usageService.findById(this.getDefaultDrugRoute(this.ciEnContextDTO.getId_org()));
		if (usage != null) {
			return usage.getName();
		}
		return null;
	}

	/**
	 * 原液皮试默认用法
	 * 
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	private String getDefaultDrugRoute(String id_org) throws BizException {
		if (!StringUtils.isNullOrEmpty(mmSkinDefaultRoute)) {
			return mmSkinDefaultRoute;
		}
		try {
			mmSkinDefaultRoute = ParamsetQryUtil.getParaString(id_org, ICiOrdNSysParamConst.SYS_PARAM_RoutesSkinTest);
			if (StringUtils.isNullOrEmpty(mmSkinDefaultRoute)) {
				throw new BizException("请在CIOR0440模板参数中设置皮试医嘱的默认用法！");
			}
			return mmSkinDefaultRoute;
		} catch (Exception ex) {
			throw new BizException("请在CIOR0440模板参数中设置皮试医嘱的默认用法！");
		}
	}

	private FDouble getDefaultDrugMedu(String id_org) {
		if (!CiOrdUtils.isEmpty(mmSkinDefaultMedu)) {
			return mmSkinDefaultMedu;
		}
		try {
			mmSkinDefaultMedu = ParamsetQryUtil.getParaDbl(id_org,
					ICiOrdNSysParamConst.SYS_PARAM_SkinTestDrugDefaultMedu);
			return mmSkinDefaultMedu;
		} catch (Exception ex) {
			return new FDouble(0.1, -1);
		}
	}

	private IMeterialMDORService getMeterialMDORService() {
		if (mmRService == null) {
			mmRService = ServiceFinder.find(IMeterialMDORService.class);
		}
		return mmRService;
	}

	private MeterialDO getMeterialDO(String mmCode) throws BizException {
		MeterialDO[] mms = this.getMeterialMDORService().findByAttrValString(MeterialDO.CODE, mmCode);
		if (mms == null || mms.length == 0) {
			return null;
		}
		return mms[0];
	}

	private IMedsrvMDORService getMedSrvMDORService() {
		if (medSrvMDORService == null) {
			medSrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		}
		return medSrvMDORService;
	}

	private MedSrvDO getMedSrvDO(String id_srv) throws BizException {
		return this.getMedSrvMDORService().findById(id_srv);
	}

	private MedSrvDrugDO getMedSrvDrugDO(String id_srv) throws BizException {
		IMedSrvDrugDORService drugService = ServiceFinder.find(IMedSrvDrugDORService.class);
		MedSrvDrugDO[] drugs = drugService.findByAttrValString(MedSrvDrugDO.ID_SRV, id_srv);
		if (drugs != null && drugs.length > 0) {
			return drugs[0];
		}
		return null;
	}

	/**
	 * 校验库存，有异常直接抛出
	 * 
	 * @param ordSrvDOs
	 * @param ordSrvMmDOs
	 * @throws BizException
	 */
	private void checkStock(CiorderAggDO aggdo, List<OrdSrvMmDO> ordSrvMmDOs) throws BizException {
		if (ordSrvMmDOs == null || ordSrvMmDOs.size() == 0) {
			return;
		}
		Map<String, String[]> mapParams = new HashMap<String, String[]>();
		OrdSrvDO[] ordSrvDOs = aggdo.getOrdSrvDO();
		for (OrdSrvDO srvdo : ordSrvDOs) {
			OrdSrvMmDO mmdo = null;
			for (OrdSrvMmDO srvMM : ordSrvMmDOs) {
				if (srvMM.getId_orsrv().equals(srvdo.getId_orsrv())) {
					mmdo = srvMM;
					break;
				}
			}
			if (mmdo == null) {
				continue;
			}
			String[] params = new String[5];
			String keyId = CiOrdUtils.getKeyId(mmdo.getId_mm(), srvdo.getId_dep_wh(), mmdo.getId_pgku_cur());
			if (!CiOrdUtils.isEmpty(keyId)) {
				mapParams.put(keyId, params);
				params[0] = mmdo.getId_mm();
				params[1] = srvdo.getId_dep_wh();
				params[2] = mmdo.getId_pgku_cur();
				params[3] = srvdo.getName();
				params[4] = mmdo.getQuan_cur() == null ? "0" : mmdo.getQuan_cur().toString();
			}
		}
		if (!mapParams.isEmpty()) {
			String refusedMsg = CiOrdUtils.ValidateDrugCount(mapParams);
			if (!CiOrdUtils.isEmpty(refusedMsg)) {
				throw new BizException(refusedMsg);
			}
		}
	}
}
