package iih.ci.ord.s.bp.orsms.ris.mergesheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.fc.wf.d.OrRecurTypeEnum;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDO;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.hp.gj.HpService;
import iih.ci.ord.hp.gj.HpService.MedSrvHpParam;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.common.CiOrParamUtils;
import iih.ci.ord.s.bp.orsms.lis.mergetube.CreateCiEmsDTOBP;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.ems.cache.BDMmDoseUnitInfoCache;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.third.base.OrderPakageInfo;
import iih.ci.ord.s.ems.third.def.DefaultDrugsCreateOrderInfo;
import iih.ci.ord.s.ems.utils.CiOrContentUtils;
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
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 图文报告医嘱生成
 * @author zhangwq
 *
 */
public class ImageTextReportBP {
	private CiEnContextDTO ctx;
	public ImageTextReportBP(CiEnContextDTO ctx){
		this.ctx = ctx;
	}
	/**
	 * 检查图文报告生成
	 * @param relFeeSrvArrays
	 * @param orderdo
	 * @return 新创建的医嘱CiOrderDO集合
	 * @throws BizException
	 */
	public List<CiOrderDO> exec(UsageRelFeeSrvDO[] relFeeSrvArrays, CiOrderDO orderdo) throws BizException{
		if(relFeeSrvArrays==null && relFeeSrvArrays.length==0){
			return null;
		}
		List<String> idsrvs = new ArrayList<String>();
		for (UsageRelFeeSrvDO feeSrvdo : relFeeSrvArrays) {
			idsrvs.add(feeSrvdo.getId_srv());
		}
		Long startTIme = System.currentTimeMillis();
		Map<String,MedSrvDO> medSrvTemp = getMedSrvTemp(idsrvs);
		CiOrdUtils.getlogger()
		.info("CiLisOrSmsHandlerBP 检查生成图文报告, 查询服务耗时 .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		if(medSrvTemp == null){
			return null;
		}
		List<CiOrderDO> orders = new ArrayList<CiOrderDO>();
		for (UsageRelFeeSrvDO feeSrvdo : relFeeSrvArrays) {
			String id_srv = feeSrvdo.getId_srv();
			if(medSrvTemp.containsKey(id_srv)){
				MedSrvDO medSrv = medSrvTemp.get(id_srv);
				//带出的医嘱可能是物品
				if(FBoolean.TRUE.equals(medSrv.getFg_mm())){
					CiOrdUtils.getlogger()
					.info("CiLisOrSmsHandlerBP 检查生成图文报告, 带出的是物品");
					startTIme = System.currentTimeMillis();
					CiOrderDO order = createMmOrder(feeSrvdo,medSrv,orderdo);
					CiOrdUtils.getlogger()
					.info("CiLisOrSmsHandlerBP 检查生成图文报告, 生成物品医嘱耗时 .." + (System.currentTimeMillis() - startTIme) + "毫秒");
					if(order!=null){
						orders.add(order);
					}
				}else{
					CreateCiEmsDTOBP bp = new CreateCiEmsDTOBP(ctx);
					CiOrdUtils.getlogger()
					.info("CiLisOrSmsHandlerBP 检查生成图文报告, 带出的是诊疗");
					startTIme = System.currentTimeMillis();
					CiEmsDTO ciEmsdto = bp.exec(feeSrvdo, medSrv, orderdo);
					ciEmsdto.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_DOC);
					ciEmsdto.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_DOC);
					CiOrdUtils.getlogger()
					.info("CiLisOrSmsHandlerBP 检查生成图文报告, 生成诊疗医嘱，组装CiEmsDTO耗时 .." + (System.currentTimeMillis() - startTIme) + "毫秒");
					startTIme = System.currentTimeMillis();
					ICiOrdMaintainService mainService = ServiceFinder.find(ICiOrdMaintainService.class);
					CiOrderDO order = mainService.SaveCiEmsDTO(ciEmsdto, ctx);
					CiOrdUtils.getlogger()
					.info("CiLisOrSmsHandlerBP 检查生成图文报告, 生成诊疗医嘱，保存耗时 .." + (System.currentTimeMillis() - startTIme) + "毫秒");
					if(order!=null){
						orders.add(order);
					}
				}
			}else{
				OrdBizLogger.info(ctx, "检查合单生成图文报告时，服务："+id_srv+"在bd_srv中检索不到，可能未启用或者已删除");
			}
		}
		return orders;
	}
	private CiOrderDO createMmOrder(UsageRelFeeSrvDO feeSrvdo, MedSrvDO medSrvDO, CiOrderDO orderdo) throws BizException{
		MedSrvRelMmDO relmmdo = CiOrdUtils.getSrvRelDefaultMmDO(feeSrvdo.getId_srv(), orderdo.getId_dep_mp());
		IMeterialMDORService mmRService = ServiceFinder.find(IMeterialMDORService.class);
		MeterialDO mmdo = mmRService.findById(relmmdo.getId_mm());
		DefaultDrugsCreateOrderInfo defaultDrug = new DefaultDrugsCreateOrderInfo();
		DefaultCreateParam defaultParma = new DefaultCreateParam(medSrvDO, mmdo, null);
		OrderPakageInfo[] szOrderPakageInfo = defaultDrug.createOrdeAggInfo(ctx,
				new DefaultCreateParam[] { defaultParma });
		OrderPakageInfo opInfo = szOrderPakageInfo[0];
		handleData(opInfo,feeSrvdo,orderdo);
		// 用法关联费用
		UsageRelFeeSrv(opInfo);
		// 保存医嘱
		CiorderAggDO[] szRstOrderAggInfo = CiOrdAppUtils.getOrAggService()
				.save(new CiorderAggDO[] { opInfo.getOrderAggInfo() });
		// 保存物品信息
		if (opInfo.getOrderSrvMmList() != null && opInfo.getOrderSrvMmList().size() > 0) {
			CiOrdAppUtils.getOrsrvmmService().save(opInfo.getOrderSrvMmList().toArray(new OrdSrvMmDO[0]));
		}
		return szRstOrderAggInfo[0].getParentDO();
	}
	/**
	 * 处理原液皮试医嘱的默认值赋值
	 * 
	 * @param szOrderPakageInfo
	 * @throws BizException
	 */
	private void handleData(OrderPakageInfo opInfo,UsageRelFeeSrvDO feeSrvdo, CiOrderDO orderdo) throws BizException {
		CalQuantumBP calQuantumBP = new CalQuantumBP();
		CiorderAggDO orderAggDO = opInfo.getOrderAggInfo();
		CiOrderDO mmOrderDO = orderAggDO.getParentDO();
		FDateTime dtNow = CiOrdAppUtils.getServerDateTime();
		mmOrderDO.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
		mmOrderDO.setFg_long(FBoolean.FALSE);
		mmOrderDO.setId_unit_med(feeSrvdo.getId_unit());
		mmOrderDO.setQuan_medu(feeSrvdo.getQuan_medu());
		mmOrderDO.setStatus(DOStatus.NEW);
		mmOrderDO.setDt_effe(dtNow);
		mmOrderDO.setDt_end(dtNow);
		mmOrderDO.setDt_last_bl(dtNow);
		mmOrderDO.setEu_orsrcmdtp(OrSourceFromEnum.IIHORRELAUTOGEN);
		mmOrderDO.setId_wg_or(ctx.getId_wg_or());
		mmOrderDO.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_DOC);
		mmOrderDO.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_DOC);
		mmOrderDO.setFg_mp_in(FBoolean.TRUE);
		mmOrderDO.setTimes_mp_in(1);//在院执行次数
		mmOrderDO.setSortno(CiOrdUtils.GetNewCiOrderSortno(mmOrderDO.getId_en()));
		mmOrderDO.setId_orpltp(OrderUtils.getOrCLoopTpId(mmOrderDO));//设置闭环
		//开单病区赋值 0196128: 【邹城】错误数据：医嘱表ci_order中的id_dep_nur_or开立病区字段为空
		mmOrderDO.setId_dep_nur_or(orderdo.getId_dep_nur_or());
		// 匹配申请单
		SrvMatchEmsRstDTO srvMatchEmsRstDTO = CiOrdUtils.GetMedSrvMatchEms(ctx,mmOrderDO.getId_srv(), mmOrderDO.getSd_srvtp());
		if (srvMatchEmsRstDTO != null) {
			mmOrderDO.setId_srvof(srvMatchEmsRstDTO.getId_ems());
			mmOrderDO.setFuncclassstr(srvMatchEmsRstDTO.getFuncclassstr());
		}
		OrdSrvDO[] ordSrvs = orderAggDO.getOrdSrvDO();
		for (OrdSrvDO ordSrvDO : ordSrvs) {
			ordSrvDO.setId_route(mmOrderDO.getId_route());
			ordSrvDO.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
			ordSrvDO.setId_medu(feeSrvdo.getId_unit());
			ordSrvDO.setQuan_medu(feeSrvdo.getQuan_medu());
			ordSrvDO.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
			ordSrvDO.setDt_last_bl(dtNow);
			// 启用医保判断的方法,并将医保计划等信息设置到drug对象中
			if (CiOrdUtils.isHpUsing(ctx)) {
				Map<String, BdHpIndicationDTO> tmpBdHpIndicationDTOCache = HpService.getMedSrvHpService(
						new MedSrvHpParam[] { new MedSrvHpParam(ordSrvDO.getId_srv(), ordSrvDO.getId_mm()) }, ctx);
				if (tmpBdHpIndicationDTOCache != null && tmpBdHpIndicationDTOCache.size() > 0) {
					BdHpIndicationDTO hpIndiccation = (BdHpIndicationDTO) tmpBdHpIndicationDTOCache.values().toArray()[0];

					ordSrvDO.setFg_indic(hpIndiccation.getFg_indic());
					if (hpIndiccation.getId_hpsrvtp() == null
							|| (hpIndiccation.getId_hpsrvtp().equals(IBdPpCodeTypeConst.ID_HP_BJ_THREE)
									&& !CiOrdUtils.isTrue(hpIndiccation.getFg_indic()))) {
						ordSrvDO.setFg_selfpay(FBoolean.TRUE);
					} else {
						ordSrvDO.setFg_selfpay(ordSrvDO.getSd_srvtp() != null && ordSrvDO.getSd_srvtp().startsWith("0103")
								? FBoolean.FALSE
								: (CiOrdUtils.isTrue(hpIndiccation.getFg_indic()) ? FBoolean.FALSE : FBoolean.TRUE));
					}

					int model = CiOrParamUtils.getMedInsuranceIndicInfoModelSet(ctx.getId_org());

					ordSrvDO.setId_hp(ctx.getId_hp());
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
		setDepWhInfo(orderAggDO);
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
						FDouble quan_cur = calQuantumBP.getMMQuantum(ctx.getCode_entp(), FBoolean.FALSE,
								1, ordSrvMM.getId_mm(), ordSrvMM.getId_medu_cur(), ordSrvDO.getQuan_medu());
						ordSrvMM.setQuan_cur(quan_cur);
						ordSrvDO.setQuan_total_medu(quan_cur);
						ordSrvMM.setId_orsrv(ids[index]);
						ordSrvDO.setId_orsrv(ids[index++]);
						int[] numben=OrSrvSplitUtil.getNumDen(ordSrvDO.getQuan_medu(), ordSrvMM.getFactor_mb());
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
					mmOrderDO.getDays_or(), orderAggDO.getParentDO().getRoute_name(), mmOrderDO.getDes_or(),FBoolean.FALSE,FBoolean.FALSE,
					getOrContentDTOs(orderAggDO.getOrdSrvDO(), mapTeamSrvDOs));
			CiOrContentDO contentdo=new CiOrContentDO();
			Object[] params = new Object[]{contentdo,drugOrContentParam};
			BDCommonEvent event = new BDCommonEvent(SourceIdConst.COPY_CONTENTOR_DRUG_SOURCEID, IEventType.TYPE_UPDATE_AFTER, params);
			EventDispatcher.fireEvent(event);
			mmOrderDO.setContent_or(contentdo==null?"":contentdo.toString());//CiOrContentUtils.create(drugOrContentParam).toString()
		}

	}

	/**
	 * 基础服务
	 * @param idsrvs
	 * @return
	 * @throws BizException
	 */
	public Map<String,MedSrvDO> getMedSrvTemp(List<String> idsrvs) throws BizException{
		MedSrvDO[] medSrvs = CiOrdUtils.getMedSrvDOs(idsrvs.toArray(new String[0]));
		if(medSrvs==null || medSrvs.length==0){
			return null;
		}
		Map<String,MedSrvDO> medSrvTemp = new HashMap<String,MedSrvDO>();
		for (MedSrvDO medSrvDO : medSrvs) {
			medSrvTemp.put(medSrvDO.getId_srv(), medSrvDO);
		}
		return medSrvTemp;
	}
	/**
	 * 设置执行科室信息
	 * 
	 * @param mm
	 * @param source
	 * @param contextdto
	 * @throws BizException
	 */
	private void setDepWhInfo(CiorderAggDO orderAggDO) throws BizException {
		ICiOrdQryService ordQryService = ServiceFinder.find(ICiOrdQryService.class);
		CiOrderDO orderdo = orderAggDO.getParentDO();
		OrdSrvDO[] ordsrvs = orderAggDO.getOrdSrvDO();
		// 查询执行科室
		OrWfExDeptParamDTO param = new OrWfExDeptParamDTO();
		param.setEu_wftp(EnumFlow.NULL); // 0执行与物资 1执行科室 2物资流向
		param.setCode_entp(ctx.getCode_entp()); // 就诊类型
		param.setId_dept_ns(ctx.getId_dep_ns()); // 就诊护理病区
		param.setId_dept_or(Context.get().getDeptId());// 开单科室
		param.setId_dept_en(ctx.getId_dep_en()); // 就诊科室
		param.setId_srv(orderdo.getId_srv()); // 服务
		param.setSd_srvtp(orderdo.getSd_srvtp()); // 服务类型sd
		param.setId_srvca(orderdo.getId_srvca()); // 服务分类
		param.setRecurstr(orderdo.getFg_long() == null ? OrRecurTypeEnum.NULL.toString()
				: (orderdo.getFg_long().booleanValue() ? OrRecurTypeEnum.LONG.toString()
						: OrRecurTypeEnum.TEMP.toString()));
		// param.setId_mm(id_mm); // 传物品id_mm没有用
		param.setFg_pres_outp(FBoolean.FALSE);
		if(orderdo.getFg_pres_outp()!=null&&orderdo.getFg_pres_outp().booleanValue()) {
			param.setFg_pres_outp(FBoolean.TRUE);
		}
		param.setId_usage(orderdo.getId_route()); // 用法
		FDateTime fdt = new FDateTime();
		param.setTimestr(fdt.getUFTime());
		param.setWeekno(CiOrdUtils.getDayOfWeek(fdt));
		OrWfDeptInfoDTO orWfDeptInfoDTO = ordQryService.getExeDepts4CiOrSrvN(param);
		if (orWfDeptInfoDTO != null && orWfDeptInfoDTO.getOrwfexedepts() != null
				&& orWfDeptInfoDTO.getOrwfexedepts().size() != 0) {
			String id_dep_wh = ((OrWfExDeptDTO) orWfDeptInfoDTO.getPharmwfwhdepts().get(0)).getId_dept();
			for (OrdSrvDO ordsrv : ordsrvs) {
				ordsrv.setId_dep_mp(orderdo.getId_dep_mp());
				ordsrv.setId_dep_wh(id_dep_wh);
			}
		}
	}
	/**
	 * 获取拼接医嘱内容的参数
	 */
	private List<OrContentDTO> getOrContentDTOs(OrdSrvDO[] ordSrvs, Map<String, OrdSrvMmDO> mapTeamSrvDOs) {
		List<OrContentDTO> list = new ArrayList<OrContentDTO>();
		for (OrdSrvDO ordSrvDO : ordSrvs) {
			ordSrvDO.setName_srv(ordSrvDO.getName());
			OrContentDTO orContentDTO = new OrContentDTO(ordSrvDO,mapTeamSrvDOs.get(ordSrvDO.getId_orsrv()));
			if (mapTeamSrvDOs.containsKey(ordSrvDO.getId_orsrv())) {
				orContentDTO.setSpec(mapTeamSrvDOs.get(ordSrvDO.getId_orsrv()).getSpec());
				orContentDTO.setPrice(ordSrvDO.getPri());
				orContentDTO.setName_srv(ordSrvDO.getName());
				orContentDTO.setName_unit_med(ordSrvDO.getMedu_name());
			}
			list.add(orContentDTO);
		}
		return list;
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
		MaterialUnitDTO[] materUnit = BDMmDoseUnitInfoCache.getMaterialUnitInfos(ctx.getCode_entp(), new String[] {ordsrvmm.getId_mm()});
		 
		if (materUnit != null && materUnit.length > 0) {
			for (MaterialUnitDTO dto : materUnit) {
				if (ordsrvmm.getId_mm().equals(dto.getId_mm())) {
					ordsrvmm.setId_pgku_cur(dto.getId_measdoc());
					ordsrvmm.setId_medu_cur(dto.getId_measdoc());
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
	 * 处理用法关联费用，用于诊疗费用
	 * @param opInfo
	 * @throws BizException
	 */
	private void UsageRelFeeSrv(OrderPakageInfo opInfo) throws BizException {
		OrdSrvDO[] routeRelFeeSrvs = OrderSrvRefUtils.RouteRelFeeSrvs(ctx,
				opInfo.getOrderAggInfo().getParentDO());
		if(routeRelFeeSrvs==null||routeRelFeeSrvs.length==0){
			return;
		}
		// 将用法关联的费用添加到agg中
		CiorderAggDO aggdo = opInfo.getOrderAggInfo();
		OrdSrvDO[] ordSrvs = aggdo.getOrdSrvDO();
		int ordSrvslength = ordSrvs.length;
		ordSrvs = Arrays.copyOf(ordSrvs, ordSrvs.length+routeRelFeeSrvs.length);
		System.arraycopy(routeRelFeeSrvs, 0, ordSrvs, ordSrvslength, routeRelFeeSrvs.length);
		aggdo.setOrdSrvDO(ordSrvs);
	}
}
