package iih.ci.ord.s.ems.op.ems.drugs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.define.MmDoseUnitMap;
import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.bd.srv.medsrv.refs.sql.op.DrugCheckDisplayMd4OP;
import iih.bd.srv.routedosage.d.RouteDosageRefDO;
import iih.bd.utils.BdMmParamUtils;
import iih.bd.utils.ParamUtils;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.ci.mi.common.utils.MiEnContextUtil;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.dto.d.SkinTestParamDTO;
import iih.ci.ord.dto.d.SkinTestRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.hp.gj.HpService;
import iih.ci.ord.hp.gj.HpService.MedSrvHpParam;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.ordext.d.HpJudgeEnum;
import iih.ci.ord.ordext.d.HpJudgeRstEnum;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.common.CiOrParamUtils;
import iih.ci.ord.s.bp.quantum.CalDtEffeBP;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.cache.BDMmDoseUnitInfoCache;
import iih.ci.ord.s.ems.cache.EmsOrDrugInfoCache;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import iih.ci.ord.s.ems.define.EmsConstEnum;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.op.base.OpBaseEmsCreateBP;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.utils.OrderEmsExtInfoUtils;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStatus;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 药品医疗单创建逻辑
 * 
 * @author wangqingzhu
 *
 */
public class EmsDrugsCreateBP extends OpBaseEmsCreateBP {
	//医保共享传入判断
	private FBoolean cusFg_selfpay = null;

	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] emsarray) throws BizException {
		EmsCrtDTO ems = emsarray[0];
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		OrdBizLogger.info(ctx, "EmsDrugsCreateBP.create.ems——" + (CiOrdUtils.isEmpty(ems) ? "" : ems.toString()));
		EmsRstDTO rst = new EmsRstDTO();
		// 获取主服务信息
		MedsrvAggDO aggDO = ServiceFinder.find(IMedsrvRService.class).findById(ems.getId_srv());
		if (aggDO == null) {
			throw new BizException("查询主服务信息失败！", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
		}
		// TODO 自费标识，重构医保共享校验删除根据传入参数fg_selfpay判断逻辑

		String fg_selfpayStr = ems.getExtension() != null && ems.getExtension().containsKey("CustomInfo")
				? ems.getExtension().get("CustomInfo").toString() : null;
		if ("Y".equals(fg_selfpayStr)) {
			cusFg_selfpay = FBoolean.TRUE;
		}

		FArrayList errorlist = new FArrayList();
		// 获取物品信息
		EmsOrDrug drug = null;
		try {
			String id_unit_sale = ems.getExtension() != null && ems.getExtension().containsKey("Id_unit_sale")
					? ems.getExtension().get("Id_unit_sale").toString() : null;
			drug = this.drugInfoFrom(aggDO.getParentDO(), ems.getId_mm(), id_unit_sale,aggDO.getParentDO().getName(), ctx);

			String drugManagementModel = BdMmParamUtils.GetDrugMCPropMM();
			// 1. 商品名模式时，并且服务是开立绑定，判断药品的可使用标识，执行绑定不需要判断商品相关逻辑，停用，停开，可使用标识
			// 2.
			// 通用名模式，开立绑定不需要判断商品的可使用标识，需要判断药品停用，停开。执行绑定不需要判断商品相关逻辑，停用，停开，可使用标识
			// 通用名在查询语句中过滤物品是否可用
			if (IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(drugManagementModel)) {
				if (ICiDictCodeConst.SD_MMBIND_OPEN.equals(drug.getSd_mmbind())
						&& !FBoolean.TRUE.equals(drug.getFg_use())) {
					errorlist.add(String.format("物品【%s】的可使用标识与当前就诊类型不符！", drug.getName_mm()));
				}
			}

		} catch (BizException e) {
			// 封装错误信息
			errorlist.add(e.getMessage());
		}

		if (errorlist.size() > 0) {
			OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
			rsts.add(rst);
			return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
		}

		// 合成主UI模型对象
		//EmsDrugItemDO emsModel = BDEmsInfoCache.GetCache(ctx, ems.getDriverInfo().getId_ems(), ems.getId_srv());
		//Logger.error("计算总量:缓存中缓存中EmsDrugItemDO是否存在："+(emsModel == null));
		//if(emsModel !=null){
			//Logger.error("计算总量:缓存中缓存中EmsDrugItemDO信息："+emsModel.toString());
		//}
		//if (null == emsModel) {
		EmsDrugItemDO emsModel = emsModelFrom(aggDO.getParentDO(), drug, ctx);
		Logger.error("计算总量:查询结果中EmsDrugItemDO信息："+emsModel.toString());
			//BDEmsInfoCache.PutCache(ctx, ems.getDriverInfo().getId_ems(), ems.getId_srv(), emsModel);
//		}else{
//			FDateTime tm = CalDtEffeBP.GetDtEffe(emsModel.getId_freq());
//
//			emsModel.setDt_begin_ui(tm); // SINGLE
//			GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
//			Integer times_cur = totalTimesBP.getTotalTimes(tm,emsModel.getId_freq(), emsModel.getUse_days());
//			emsModel.setTimes_cur(times_cur);
//		}
		// 可变部分赋值
		{
			emsModel.setDt_end_ui(new FDateTime(emsModel.getDt_begin_ui().getBeginDate().getDateAfter(1), emsModel.getDt_begin_ui().getUFTime()));
		}
		// 诊断id
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ctx.getId_en());
		if (diagOutlineInfo != null) {
			emsModel.setId_didef(diagOutlineInfo.getId_didef());// 主诊断的主项目id
			emsModel.setName_didef(diagOutlineInfo.getName_diag());// 主诊断名称
			emsModel.setId_di(diagOutlineInfo.getId_di());
			emsModel.setId_diitm(diagOutlineInfo.getId_diitm());
			
		}
		boolean isWfNull = false;
		OrWfExDeptParamDTO param = new OrWfExDeptParamDTO();
		param.setId_mm(ems.getId_mm());
		param.setSd_herbpreparationtp(drug.getSd_herbpreparationtp());
		param.setId_dosage(drug.getId_dosage());
		param.setSd_pois(drug.getSd_pois());
		param.setId_usage(drug.getId_route());
		// 获取执行科室
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, aggDO.getParentDO(), param, null);
		if (null == wf) {
			isWfNull = true;
			// 封装错误信息
			// errorlist.add(String.format("【%s】获取执行科室失败",
			// aggDO.getParentDO().getName()));
			// OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
			// rsts.add(rst);
			// return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
			// 设置执行科室属性

		}
		if (!isWfNull) {
			// 设置执行科室属性
			if ("1".equals(wf.getMp_source())) {
				emsModel.setStr_mp_dep_ids(null);
			} else {
				emsModel.setStr_mp_dep_ids(CiOrdUtils.isEmpty(wf.getId_mp_depts()) ? null : wf.getId_mp_depts());
			}
			emsModel.setId_dep(wf.getFirstid_mp_dept());
			emsModel.setName_dep(wf.getFirstname_mp_dept());
		}
		//自定义药品初始化勾选自备药 （按自备药 后续不校验库存）
		if(drug.getFg_ctm()!=null && drug.getFg_ctm().booleanValue()){
			drug.setFg_self(FBoolean.TRUE);
		}
		// EmsOrDrug drug = this.drugInfoFrom(ems.getId_srv(), ems.getId_mm(),
		// aggDO.getParentDO().getName(), ems.getEnContext());
		{
			drug.setStatus(DOStatus.NEW);
			// 使用天数
			drug.setUse_days(emsModel.getUse_days());
			if (!isWfNull) {
				// 执行科室
				drug.setId_mp_dep(wf.getFirstid_mp_dept());
				drug.setName_mp_dep(wf.getFirstname_mp_dept());
				drug.setId_dep_wh(wf.getId_dept_wh());
				drug.setName_dep_wh(wf.getName_dept_wh());
				drug.setStr_wh_dep_ids(CiOrdUtils.isEmpty(wf.getId_dept_whs()) ? null : wf.getId_dept_whs());
			}
			// 服务类型
			drug.setId_srvtp(aggDO.getParentDO().getId_srvtp());
			drug.setSd_srvtp(aggDO.getParentDO().getSd_srvtp());
			
			//服务分类
			drug.setId_srvca(aggDO.getParentDO().getId_srvca());

			// 剂量、剂量单位界面展示使用虚拟字段，用于实现前台切换剂量单位
			drug.setQuan_medu_virtual(drug.getQuan_med());
			drug.setName_unit_medu_virtual(drug.getName_unit_med());
			

			// 外配药标识默认为false
			drug.setFg_extdispense(FBoolean.FALSE);
			
			String sd_mutp = "";
			if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ctx.getCode_entp())) {
				sd_mutp = drug.getSd_opmutp();
			} else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(ctx.getCode_entp())) {
				sd_mutp = drug.getSd_ermutp();
			}  else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(ctx.getCode_entp())) {
				sd_mutp = drug.getSd_er1mutp();
			}
			// 计算总量
			CalQuantumBP quantumBP = new CalQuantumBP();
			if(drug.getFg_ctm()!=null&&FBoolean.TRUE.equals(drug.getFg_ctm())) {
				//0182083: 【淮矿】【药品通用名目录】【药品基本信息】药品通用名目录，自定义标识勾上，门诊医生站开立的时候换算错误，自定义勾掉换算就正确   自定义服务项目不进行总量运算的。总量可以为空。
				drug.setQuan_cur(null);
				drug.setTotalprice(null);
			}else {
			// 设置物品总价
			if (!CiOrdUtils.isEmpty(aggDO.getParentDO().getSd_srvtp())
					&& aggDO.getParentDO().getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
				Integer orders = 1;
				try{
					orders = ParamUtils.GetOrgParamIntegerValue(ICiOrdCustomSysParamConst.LL_PARAM_HERB_EFAULT_ORDERS);
				}catch(Exception e){
					orders = Integer.valueOf(EmsConstEnum.HBORDERS);
				}
				emsModel.setOrders(orders );
				// 应该取门诊的取整模式
				FDouble quan_cur = new FDouble(0);
				if (emsModel.getQuan_med() != null) {
					quan_cur = quantumBP.getMMQuantum(sd_mutp, emsModel.getQuan_med().multiply(new FDouble(emsModel.getOrders())),
							new FDouble(drug.getFactor_mb()), drug.getFactor_cb(), 1); // 草药总量= 剂数 * 单次剂量
				}

				drug.setQuan_cur(quan_cur);
				if (drug.getPrice() == null || drug.getQuan_cur() == null) {
					drug.setTotalprice(null);
				} else {
					drug.setTotalprice((drug.getPrice().multiply(drug.getQuan_cur())));
				}
			} else {
				Logger.error("计算总量:物品:"+drug.getId_mm()+"取整模式:"+sd_mutp+"剂量:"+emsModel.getQuan_med()+"医基换算系数:"+drug.getFactor_mb()+"零基换算系数:"+drug.getFactor_cb()+"总次数:"+emsModel.getTimes_cur()+"----"+drug.toString());
				// 应该取门诊的取整模式
				FDouble quan_cur = quantumBP.getMMQuantum(sd_mutp, emsModel.getQuan_med(),
						new FDouble(drug.getFactor_mb()), drug.getFactor_cb(), emsModel.getTimes_cur());
				Logger.error("计算总量:物品:"+drug.getId_mm()+"总量："+quan_cur+"----"+drug.toString());
				drug.setQuan_cur(quan_cur);
				if (drug.getPrice() == null || drug.getQuan_cur() == null) {
					drug.setTotalprice(null);
				} else {
					drug.setTotalprice(drug.getPrice().multiply(drug.getQuan_cur()));
				}
			}
			}
			// 药品里边集合开立时只有一个
			// 抗生素
			if (drug.getFg_anti() != null && FBoolean.TRUE.equals(drug.getFg_anti())) {
				if (CiOrdUtils.isEmpty(drug.getFg_propc())) {
					drug.setFg_propc(FBoolean.FALSE); // emsordrug.Fg_propc可能存在空值
				}
			}
			// 设置联合主键  大小包装拼接单位  商品模式不拼
			if("11".equals(DrugCheckDisplayMd4OP.getInstance().getDrugCheckDisplayMd4OP())) {
				drug.setIdSrvIdMm(drug.getId_srv() + drug.getId_mm() + drug.getId_unit_sale());
			}else {
				drug.setIdSrvIdMm(drug.getId_srv() + drug.getId_mm());
			}
			emsModel.setFactor_mb(String.valueOf(drug.getFactor_mb()));
			if("0".equals(CiOrdUtils.GetDefaultSkinModel(ctx.getId_org()))){
				// 获取皮试结果
				OrderEmsExtInfoUtils.SetSkinTestRstDTO(rst, this.getSkinTestCheckResult(drug, ctx));
			}
		}
		

		// 医嘱列表显示结果
		FArrayList drugList = new FArrayList();
		drugList.add(drug);
		emsModel.setEmsOrDrugListEx(drugList);

		// 添加剂型，用于前台根据剂型过滤成组药品
		OrderEmsExtInfoUtils.SetDosagesFilter(rst, getDrugRouteOfDoSages(aggDO.getParentDO().getId_route()));

		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, aggDO.getParentDO());

		// 保存执行科室过滤条件
		if ("1".equals(wf.getMp_source())) {
			OrderEmsExtInfoUtils.SetMpDepFilter(rst, null);
		} else {
			OrderEmsExtInfoUtils.SetMpDepFilter(rst, wf.getId_mp_depts());
		}

		// 保存物资流向
		OrderEmsExtInfoUtils.SetWhDepFilter(rst, wf.getId_dept_whs());
		OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
		OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());
		// 保存物资流向
		OrderEmsExtInfoUtils.SetWhDepFilter(rst, wf.getId_dept_whs());
		OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
		OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());
		// 返回值处理
		
		//设置库存
		setFact_count(drug);

		// 计算物品价格
		drug.setPrice(getMaterialStocksCount(drug.getId_mm(),drug.getId_unit_sale(),drug.getId_dep_wh()));// 计算单价

		rst.setDocument(this.handleReturnDocument(emsModel));
		rst.getDriverInfo().setEmsBackendDriver(EmsType.COMMONDRUG.toString());
		OrdBizLogger.info(ctx, "EmsDrugsCreateBP.create.rst" + (CiOrdUtils.isEmpty(rst) ? "" : rst.toString()));
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}

	protected EmsDrugItemDO emsModelFrom(MedSrvDO medSrv, EmsOrDrug drug, CiEnContextDTO ctx) throws BizException {

		EmsDrugItemDO emsDrugItem = emsModelFrom(medSrv, ctx);

		// 获取药品用药属性管理模式，根据参数值确定频次、剂量、用法、用法要求、煎法、煎法要求 数据来源
		// 商品名： 数据来源于bd_mm， 通用名：数据来源与bd_srv
		String drugManagementModel = BdMmParamUtils.GetDrugMCPropMM();

		if (IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(drugManagementModel)) {
			IMeterialMDORService meterialservice=ServiceFinder.find(IMeterialMDORService.class);
			MeterialDO meterial=meterialservice.findById(drug.getId_mm());
			emsDrugItem.setId_freq(meterial.getId_freq());// 频次
			emsDrugItem.setName_freq(meterial.getFreq_name());// 频次名称
			emsDrugItem.setFreqct(meterial.getFreqct());// 频次周期下次数
			emsDrugItem.setSd_frequnitct(meterial.getSd_frequnitct());// 频次单位编码
																	// 频次周期类型

			emsDrugItem.setId_route(meterial.getId_route());// 用法
			emsDrugItem.setName_route(meterial.getRoute_name());// 用法名称
			emsDrugItem.setId_routedes(meterial.getId_routedes());// 用法要求
			emsDrugItem.setName_routedes(meterial.getRoutedes_name());

			emsDrugItem.setQuan_med(meterial.getQuan_med()); // 剂量
			emsDrugItem.setName_unit_med(meterial.getUnit_med_name());// 计量单位名称
			emsDrugItem.setId_unit_med(meterial.getId_unit_med());// 医学单位
		} else {
			emsDrugItem.setId_freq(medSrv.getId_freq());// 频次
			emsDrugItem.setName_freq(medSrv.getFreq_name());// 频次名称
			emsDrugItem.setFreqct(medSrv.getFreqct());// 频次周期下次数
			emsDrugItem.setSd_frequnitct(medSrv.getSd_frequnitct());// 频次单位编码
																	// 频次周期类型

			emsDrugItem.setId_route(medSrv.getId_route());// 用法
			emsDrugItem.setName_route(medSrv.getRoute_name());// 用法名称
			emsDrugItem.setId_routedes(medSrv.getId_routedes());// 用法要求
			emsDrugItem.setName_routedes(medSrv.getRoutedes_name());

			emsDrugItem.setQuan_med(medSrv.getQuan_med()); // 剂量
			emsDrugItem.setName_unit_med(medSrv.getMed_name());// 计量单位名称
			emsDrugItem.setId_unit_med(medSrv.getId_unit_med());// 医学单位
			
		}
		
		{
			//保持数据一致
			
			drug.setId_freq(emsDrugItem.getId_freq());// 频次
			drug.setName_freq(emsDrugItem.getName_freq());// 频次名称
			drug.setFreqct(emsDrugItem.getFreqct());// 频次周期下次数
			drug.setSd_frequnitct(emsDrugItem.getSd_frequnitct());// 频次单位编码
																	// 频次周期类型

			drug.setId_route(emsDrugItem.getId_route());// 用法
			drug.setName_route(emsDrugItem.getName_route());// 用法名称
			drug.setId_routedes(emsDrugItem.getId_routedes());// 用法要求
			drug.setName_routedes(emsDrugItem.getName_routedes());

			drug.setQuan_med(emsDrugItem.getQuan_med()); // 剂量
			drug.setName_unit_med(emsDrugItem.getName_unit_med());// 计量单位名称
			drug.setId_unit_med(emsDrugItem.getId_unit_med());// 医学单位
			
			
			drug.setQuan_medu_virtual(emsDrugItem.getQuan_med());
			drug.setName_unit_medu_virtual(emsDrugItem.getName_unit_med());			
			drug.setId_medu_cur(emsDrugItem.getId_unit_med());
			drug.setQuan_medu_cur(emsDrugItem.getQuan_med());
			drug.setFactor_medu_cur(new FDouble("1"));
		}

		FDateTime tm = CalDtEffeBP.GetDtEffe(emsDrugItem.getId_freq());

		emsDrugItem.setDt_begin_ui(tm); // SINGLE
		GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
		Integer times_cur = totalTimesBP.getTotalTimes(tm,emsDrugItem.getId_freq(), emsDrugItem.getUse_days());
		emsDrugItem.setTimes_cur(times_cur);

		return emsDrugItem;

	}

	private EmsDrugItemDO emsModelFrom(MedSrvDO medSrv, CiEnContextDTO ctx) throws BizException {

		EmsDrugItemDO emsDrugItem = new EmsDrugItemDO();
		emsDrugItem.setId_org(ctx.getId_org());
		emsDrugItem.setId_srv(medSrv.getId_srv());// 服务项目id
		emsDrugItem.setName_srv(medSrv.getName());// 服务项目名称
		emsDrugItem.setId_srvtp(medSrv.getId_srvtp());// 服务项目类型id
		emsDrugItem.setSd_srvtp(medSrv.getSd_srvtp());// 服务项目类型sd

		emsDrugItem.setFg_mm(medSrv.getFg_mm()); // 物品标识
		emsDrugItem.setFg_long(medSrv.getFg_long());// 长临标识
		emsDrugItem.setFg_pmor(FBoolean.FALSE);// TODO 备用医嘱标识
		emsDrugItem.setFg_dose_anoma(FBoolean.FALSE);// 变动用药标识
		emsDrugItem.setFg_outp(FBoolean.FALSE);// 出院带药标识
		emsDrugItem.setNote_or(medSrv.getNote()); // 备注
		emsDrugItem.setFg_bl(medSrv.getFg_bl());// 费用标识
		emsDrugItem.setFg_propc(FBoolean.FALSE);// 预防用药标识
		emsDrugItem.setEu_orsrcmdtp(OrSourceFromEnum.IIHSRVREF);
		emsDrugItem.setStatus(DOStatus.NEW);

		// 设置默认医嘱天数
		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK.equals(emsDrugItem.getSd_frequnitct())) { // 如果频次周期类型是星期，返回一个周期的天数
			emsDrugItem.setUse_days(7);
		} else {
			emsDrugItem.setUse_days(1);
		}
		// // 开始时间 --
		// emsDrugItem.setDt_begin_ui(CiOrdAppUtils.getServerDateTime()); //
		// 开始时间
		// // 截止时间
		// emsDrugItem.setDt_end_ui(new
		// FDateTime(emsDrugItem.getDt_begin_ui().getBeginDate().getDateAfter(1),
		// emsDrugItem.getDt_begin_ui().getUFTime()));
		// 计算总次数

		return emsDrugItem;
	}

	protected EmsOrDrug drugInfoFrom(MedSrvDO medSrv, String id_mm, String id_unit_sale, String name_srv,CiEnContextDTO ctx)
			throws BizException {
		String id_srv = medSrv.getId_srv();
		String cacheKey = String.format("EmsOrDrug{%s-%s}", id_srv, id_mm);
		EmsOrDrug drug = EmsOrDrugInfoCache.GetCache(ctx, cacheKey);
		Logger.error("计算总量:缓存中缓存中是否存在物品EmsOrDrug："+(null == drug));
		if(drug != null){
			Logger.error("计算总量:缓存中缓存中EmsOrDrug信息，"+"医基换算系数:"+drug.getFactor_mb()+"零基换算系数:"+drug.getFactor_cb()+"剂量:"+drug.getQuan_med());
		}
		if (null == drug) {
			OrdBizLogger.info(ctx, "EmsDrugsCreateBP.drugInfoFrom:null==drug = true");

			String querySql = this.getQuerySql(medSrv, ctx.getCode_entp());
			SqlParam param = new SqlParam();
			param.addParam(id_srv);
			param.addParam(id_mm);
			DAFacade daf = new DAFacade();
			drug = (EmsOrDrug) daf.execQuery(querySql, param, new BeanHandler(EmsOrDrug.class));
			Logger.error("计算总量:查询结果中EmsOrDrug信息，"+"医基换算系数:"+drug.getFactor_mb()+"零基换算系数:"+drug.getFactor_cb()+"剂量:"+drug.getQuan_med());
			EmsOrDrugInfoCache.PutCache(ctx, cacheKey, drug);
		}
		fillFreqRouteToMedSrv(drug,medSrv);
		// 检验是否绑定物品
		if (CiOrdUtils.isEmpty(drug) || (CiOrdUtils.isTrue(drug.getFg_mm()) && CiOrdUtils.isEmpty(drug.getId_mm()))) {
			throw new BizException(String.format("[%s]没有绑定物品 或者 物品没有启用", name_srv));
		}

		// 拼接参照唯一标志
		drug.setIdSrvIdMm(drug.getId_srv() + drug.getId_mm() + drug.getId_unit_sale());
		
		//医保共享传入判断
		if (FBoolean.TRUE.equals(cusFg_selfpay)) {
			drug.setEu_hpjudge(HpJudgeEnum.SYSTEM_JUDGE);
			drug.setEu_orsrvhp(HpJudgeRstEnum.SELFPAY);
			drug.setFg_allowdedit(FBoolean.FALSE);
		}/* else {
		drug.setEu_hpjudge(HpJudgeRstEnum.WAITING_JUDGE);
		drug.setEu_orsrvhp(HpJudgeRstEnum.WAITING_JUDGE);
		}*/
		
		// 启用医保判断的方法,并将医保计划等信息设置到drug对象中
		if (MiEnContextUtil.isHpPat(ctx) && HpBeyondEnum.HPDIAG.equals(ctx.getEu_hpbeyond()) && !FBoolean.TRUE.equals(cusFg_selfpay)) {
		/*if (CiOrdUtils.isHpUsing(ctx) && !FBoolean.TRUE.equals(cusFg_selfpay)) {
			Map<String, BdHpIndicationDTO> tmpBdHpIndicationDTOCache = HpService.getMedSrvHpService(
					new MedSrvHpParam[] { new MedSrvHpParam(drug.getId_srv(), drug.getId_mm()) }, ctx);
			if (tmpBdHpIndicationDTOCache != null && tmpBdHpIndicationDTOCache.size() > 0) {
				BdHpIndicationDTO hpIndiccation = (BdHpIndicationDTO) tmpBdHpIndicationDTOCache.values().toArray()[0];

				drug.setFg_treat(hpIndiccation.getFg_indic());
				if (hpIndiccation.getId_hpsrvtp() == null
						|| (hpIndiccation.getId_hpsrvtp().equals(IBdPpCodeTypeConst.ID_HP_BJ_THREE)
								&& !CiOrdUtils.isTrue(hpIndiccation.getFg_indic()))) {
					drug.setFg_selfpay(FBoolean.TRUE);
				} else {
					drug.setFg_selfpay(drug.getSd_srvtp() != null && drug.getSd_srvtp().startsWith("0103")
							? FBoolean.FALSE
							: (CiOrdUtils.isTrue(hpIndiccation.getFg_indic()) ? FBoolean.FALSE : FBoolean.TRUE));
				}

				int model = CiOrParamUtils.getMedInsuranceIndicInfoModelSet(ctx.getId_org());
				if (model == 2) {
					drug.setLimit(" 医保限制条件：" + StringUtils.trimToEmpty(hpIndiccation.getDes_hplimit()));

					if (StringUtils.isNotEmpty(hpIndiccation.getDes_hislimit())) {
						drug.setLimit(drug.getLimit() + "\n 院内限制条件："
								+ StringUtils.trimToEmpty(hpIndiccation.getDes_hislimit()));
					}

				} else if (model == 1) {
					drug.setLimit(" 院内限制条件：" + StringUtils.trimToEmpty(hpIndiccation.getDes_hislimit()));
				} else {
					drug.setLimit(" 医保限制条件：" + hpIndiccation.getDes_hplimit());
				}

				drug.setId_hp(ctx.getId_hp());
				drug.setSd_hpsrvtp(hpIndiccation.getSd_hpsrvtp());
				drug.setId_hpsrvtp(!CiOrdUtils.isEmpty(drug.getSd_hpsrvtp())
						? CiOrdUtils.idHpSrvtpFromSdHpSrvtp(drug.getSd_hpsrvtp()) : null);
				drug.setFg_hpindicjudged(CiOrdUtils.getFg_hpindicjudged(hpIndiccation));
				drug.setBdHpIndicationDTO(new FArrayList().append(hpIndiccation));
			}
		*/} else {// 非医保适应症时，自费标识应该为true
			drug.setFg_selfpay(FBoolean.TRUE);
			drug.setFg_hpindicjudged(0);
		}
		
		//drug.setFg_selfpay(FBoolean.FALSE);
		
		{
			MmDoseUnitMap materUnitMap = BDMmDoseUnitInfoCache.GetMmDoseUnitMap(ctx, new String[] { id_mm });
			if (materUnitMap.size() == 0) {
				throw new BizException(" 物品" + drug.getName_mm() + "没有对应的单位");
			}

			// 设置药品单位相关信息
			List<MaterialUnitDTO> tmpMaterialUnitList = materUnitMap.get(drug.getId_mm());
			if(StringUtils.isEmpty(id_unit_sale)){
				MaterialUnitDTO tmpMaterialUnitInfo = tmpMaterialUnitList.get(0);
				drug.setId_unit_sale(tmpMaterialUnitInfo.getId_measdoc());
				drug.setFactor_cb(tmpMaterialUnitInfo.getFactor());// 基本包装单位和总量单位间的换算系数
				drug.setName_unit_sale(tmpMaterialUnitInfo.getMeasdoc_name());
			}else{
				for (MaterialUnitDTO materialUnitDTO : tmpMaterialUnitList) {
					if(id_unit_sale.equals(materialUnitDTO.getId_measdoc())){
						drug.setId_unit_sale(materialUnitDTO.getId_measdoc());
						drug.setFactor_cb(materialUnitDTO.getFactor());// 基本包装单位和总量单位间的换算系数
						drug.setName_unit_sale(materialUnitDTO.getMeasdoc_name());
						break;
					}
				}
			}
			
			// 计算价格放到计算执行科室之后的逻辑中
//			drug.setPrice(getMaterialStocksCount(drug.getId_mm(),drug.getId_unit_sale()));// 计算单价
			// 处理拼接信息
			StringBuilder unitIdSB = new StringBuilder();
			StringBuilder unitNameSB = new StringBuilder();
			StringBuilder unitWhereSB = new StringBuilder();
			StringBuilder factorSB = new StringBuilder();
			for (MaterialUnitDTO materialUnitInfo : tmpMaterialUnitList) {
				unitIdSB.append(",").append(materialUnitInfo.getId_measdoc());
				unitNameSB.append(",").append(materialUnitInfo.getMeasdoc_name());
				unitWhereSB.append(",'").append(materialUnitInfo.getId_measdoc()).append("'");
				factorSB.append(
						CiOrdUtils.isEmpty(materialUnitInfo.getFactor()) ? ",1" : "," + materialUnitInfo.getFactor());
			}
			drug.setStr_unit_pkg_ids(unitWhereSB.substring(1));
			FMap fmap = new FMap();
			if (unitIdSB.length() > 0) {
				fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_ID_MEASDOC, unitIdSB.substring(1));

			}
			if (unitNameSB.length() > 0) {
				fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_MEASDOC_NAME, unitNameSB.substring(1));
			}
			if (factorSB.length() > 0) {
				fmap.put("factor", factorSB.toString().substring(1));
			}
			drug.setRelativefieldmap(fmap);
			drug.setId_medu_cur(drug.getId_unit_med());
			drug.setQuan_medu_cur(drug.getQuan_med());
			drug.setFactor_medu_cur(new FDouble("1"));
		}

		return drug;
	}
	
	private void fillFreqRouteToMedSrv(EmsOrDrug drug, MedSrvDO medSrv) {
		if(drug!=null && medSrv!=null){
			medSrv.setId_freq(drug.getId_freq());
			medSrv.setFreq_name(drug.getName_freq());
			medSrv.setSd_frequnitct(drug.getSd_frequnitct());
			medSrv.setFreqct(drug.getFreqct());
			medSrv.setId_route(drug.getId_route());
			medSrv.setRoute_name(drug.getName_route());
		}
	}

	public FDouble getMaterialStocksCount(String id_mm, String Id_unit_sale,String id_dep_wh) throws BizException
	        {
	            GetStockReqDTO reqDto = new GetStockReqDTO();
	            reqDto.setId_mm ( id_mm);
	            reqDto.setReq_unit_id ( Id_unit_sale);
	            reqDto.setId_dep(id_dep_wh);
	            GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
	            reqDtoArr[0] = reqDto;
	            IMaterialStockService service = ServiceFinder.find(IMaterialStockService.class);
	            MaterialStockDTO[] materials =  service.getMaterialStocks(reqDtoArr);
	            if (materials != null && materials.length > 0)
	            {
	                return materials[0].getPrice_act();
	            }
	            else {
	                return null;
	            }
	        }
	/**
	 * 药房无此药  int 3
	 */
	public static int NORELATION = 3;
	/**
	 * 
	 * @code 设置药品库存
	 * @author LiYue
	 * @date 2019年5月21日,下午8:03:54
	 * @param drug
	 * @param source
	 * @param contextdto
	 * @throws BizException 
	 */
	private void setFact_count(EmsOrDrug drug) throws BizException {
		if (!FBoolean.TRUE.equals( drug.getFg_mm())) {
			return;
		}
		String id_dep_whs = drug.getStr_wh_dep_ids();
		if(StringUtils.isEmpty(id_dep_whs)){
			throw new BizException(drug.getName_srv()+"没有匹配到药房");
		}
		//查询所有的科室
		Map<String,String> deptMap = getNameDepts(id_dep_whs);
		
		String[] whArrays = id_dep_whs.split(",");
		StringBuilder fullCountWhs = new StringBuilder();
		List<GetStockReqDTO> stockDtos = new ArrayList<GetStockReqDTO>();
		for(String id_dep_wh : whArrays){
			String id_dep = id_dep_wh.replaceAll("'", "");
			GetStockReqDTO reqDTO = new GetStockReqDTO();
			reqDTO.setId_mm(drug.getId_mm());
			reqDTO.setId_dep(id_dep);
			reqDTO.setReq_unit_id(drug.getId_unit_sale());
			stockDtos.add(reqDTO);
		}
		String nameDepWhs = "";
		if(stockDtos.size() > 0){
			Map<String,FactOutPricBean> stockMap = getFactCount(stockDtos);
			//先判断优先级最好的仓库是否有库存
			String key = drug.getId_mm() + drug.getId_dep_wh();
			FactOutPricBean factOutPrice = null;
			if(stockMap.containsKey(key)){
				factOutPrice = stockMap.get(key);
				drug.setFact_count(factOutPrice.getFactCount());
				drug.setPrice(factOutPrice.getPrice());
			}
			for(String id_dep_wh : whArrays){
				String id_dep = id_dep_wh.replaceAll("'", "");
				key = drug.getId_mm() + id_dep;
				if(stockMap.containsKey(key)){
					factOutPrice = stockMap.get(key);
					nameDepWhs+=(","+factOutPrice.getDep_name());
					if(factOutPrice.getFactCount().compareTo(FDouble.ZERO_DBL)>0){
						fullCountWhs.append(id_dep_wh+",");
						
						if(drug.getFact_count() == null || drug.getFact_count().compareTo(FDouble.ZERO_DBL) <= 0){
							drug.setFact_count(factOutPrice.getFactCount());
							drug.setPrice(factOutPrice.getPrice());
							drug.setId_dep_wh(id_dep);
							if(deptMap!=null && deptMap.containsKey(id_dep)){
								drug.setName_dep_wh(deptMap.get(id_dep));
							}
						}
					}
				}
			}
			if(fullCountWhs.length()>0)
			{
				fullCountWhs.deleteCharAt(fullCountWhs.length()-1);
			}
			drug.setStr_wh_dep_ids(fullCountWhs.toString());
		}
		//赋值完库存后，判断库存是否有值，如果没有，抛出异常
		if(drug.getFact_count() == null || drug.getFact_count().compareTo(FDouble.ZERO_DBL) <= 0){
			if(nameDepWhs.length()>0){
				nameDepWhs = nameDepWhs.substring(1);
			}
			throw new BizException("仓库【"+nameDepWhs+"】,"+drug.getName_srv()+"库存不足");
		}
	}
	private Map<String,String> getNameDepts(String id_dep_whs) throws DAException{
		String sql = "select id_dep,name from bd_dep where id_dep in ("+id_dep_whs+")";
		List<DeptDO> depts = (List<DeptDO>) new DAFacade().execQuery(sql, new BeanListHandler(DeptDO.class));
		if(depts!=null && depts.size()>0){
			Map<String,String> map = new HashMap<String,String>();
			for(DeptDO dept : depts){
				map.put(dept.getId_dep(), dept.getName());
			}
			return map;
		}
		return null;
	}
	private Map<String,FactOutPricBean> getFactCount(List<GetStockReqDTO> reqDtos) throws BizException{
		MaterialStockDTO[] stockdto = null;
		IMaterialStockService stoctService = CiOrdAppUtils.getMaterialStockQryService();
		stockdto = stoctService.getMaterialStocks(reqDtos.toArray(new GetStockReqDTO[0]));
		Map<String,FactOutPricBean> maps = new HashMap<String,FactOutPricBean>();
		
		if(stockdto != null) {
			for (MaterialStockDTO materialStockDTO : stockdto) {
				int mmStatus = materialStockDTO.getMmstatus();
				FDouble factCount = FDouble.ZERO_DBL;
				if(mmStatus == MaterialStatus.STOP ||mmStatus == MaterialStatus.NORELATION) {
					factCount = FDouble.ZERO_DBL;
				}else {
					factCount = materialStockDTO.getQuan_usable();
				}	
				String key = materialStockDTO.getId_mm()+materialStockDTO.getId_dep();
				FactOutPricBean factOutPrice = new FactOutPricBean();
				factOutPrice.setFactCount(factCount);
				factOutPrice.setPrice(materialStockDTO.getPrice_act());
				factOutPrice.setDep_name(materialStockDTO.getDep_name());
				maps.put(key, factOutPrice);
			}	
		}
		return maps;
	}
	/**
	 * 获取皮试结果
	 * 
	 * @param drug
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	private SkinTestRstDTO getSkinTestCheckResult(EmsOrDrug drug, CiEnContextDTO ctx) throws BizException {

		// 非皮试药品，不获取皮试校验结果
		OrdBizLogger.info(ctx, "drug.getFg_skintest()类型   :" + drug.getFg_skintest().getClass().getName());
		if (!FBoolean.TRUE.equals(drug.getFg_skintest())) {
			return null;
		}

		SkinTestParamDTO param = new SkinTestParamDTO();
		param.setId_mm(drug.getId_mm());
		param.setId_org(ctx.getId_org());
		param.setId_pi(ctx.getId_pat());
		param.setDt_birth(FDate.getDate(ctx.getDt_birth()));
		param.setId_srv(drug.getId_srv());
		param.setId_skinsrv(drug.getId_srvskin());
		return CiOrdAppUtils.getCiOrdQryService().skinTestLogicMainBP(param);
	}

	/**
	 * 拼接用法关联的剂型id字符串
	 * 
	 * @param id_route
	 *            用法id
	 * @return 剂型字符串 结构 'arc','asdff','ffds'
	 * @throws BizException
	 */

	private String getDrugRouteOfDoSages(String id_route) throws BizException {

		// 自定义服务 的用法为空
		if (StringUtils.isBlank(id_route)) {
			return "";
		}
		StringBuffer idDosagesBuffer = null;
		// TODO 可以转换为只查询剂型id集合
		RouteDosageRefDO[] routeDosages = CiOrdAppUtils.getIRoutedosageRService().find("id_route='" + id_route + "'",
				null, FBoolean.FALSE);
		// 加上RouteDosageRefDO[]数组长度为0的判别条件
		if (routeDosages != null && routeDosages.length > 0) {
			idDosagesBuffer = new StringBuffer();
			for (RouteDosageRefDO routeDosageRef : routeDosages) {
				idDosagesBuffer.append(",'" + routeDosageRef.getId_dosage() + "'");
			}
			return idDosagesBuffer.substring(1);
		}
		return "";
	}

	/**
	 * 获取EmsOrDrug查询语句
	 * 
	 * @param medSrv
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	private String getQuerySql(MedSrvDO medSrv, String code_entp) throws BizException {

		StringBuilder sqlSB = new StringBuilder();

		// 获取当前就诊类型对应的可使用标识
		String fg_use = this.getPropertyStr("fg_use", code_entp);
		// 获取当前就诊类型物品的绑定时机
		String id_mmbind_str = this.getPropertyStr4Bd_srv("id_mmbind", code_entp);
		String sd_mmbind_str = this.getPropertyStr4Bd_srv("sd_mmbind", code_entp);

		String drugManagementModel = BdMmParamUtils.GetDrugMCPropMM();
		if (IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(drugManagementModel)) {

			sqlSB.append(
					" SELECT  A.id_srvtp,A.sd_srvtp,A.id_srv,A.code as code_srv, A.name as name_srv,B.id_unit_med,D.name as name_unit_med,A.sd_mmbind_op,A.sd_mmbind_er, A.fg_bl,A.id_primd as id_pri,")
					.append(" A.").append(id_mmbind_str).append(" as id_mmbind,")
					.append("A.").append(sd_mmbind_str).append(" as sd_mmbind,")
					.append(" B.").append(fg_use).append(" as fg_use,")
					.append(" B.id_mm,B.spec as spec_mm,B.name as name_mm,B.price,B.des as des_mm,B.sup_name as name_sup,B.code as code_mm ,")
					.append(" B.id_mupkgutp,B.sd_mupkgutp,B.id_opmutp,B.sd_opmutp,B.id_ermutp,B.sd_ermutp,B.id_er1mutp,B.sd_er1mutp,B.id_er2mutp,B.sd_er2mutp,")
					.append(" B.Factor_mb,B.factor_sb factor_cb,B.id_val,B.sd_val,B.Id_Srvskin,B.Fg_skin fg_skintest,")
					.append(" drug.fg_highrisk,drug.id_dosage ,drug.sd_dosage ,dosage.name as name_dosage,drug.id_pharm ,drug.sd_pharm ,")
					.append(" drug.sd_pois ,drug.id_pois ,drug.id_anti ,drug.sd_anti ,drug.fg_pois ,drug.fg_anti ,B.id_mmtp,B.sd_mmtp,")
					.append(" C.id_measdoc as id_unit_sale,C.name as name_unit_sale , E.id_measdoc as id_unit_base, E.name as name_unit_base, ")
					.append(" B.quan_med,A.fg_mm,A.fg_ctm,A.id_primd id_pri,")
					.append(" B.id_boil, F1.name as name_boil, ")
					.append(" B.id_boildes,F.name as Name_boildes,")
					.append(" B.id_freq,G.name as name_freq,G.freqct,G.SD_FREQUNITCT,")
					.append(" B.id_route as id_route,H.name as name_route, ")
					.append(" B.id_routedes,I.name as name_routedes, ")
					.append(" A.eu_blmd, ")
					.append(" B.fg_skin as fg_skintest_mm,")
					.append(" B.sd_herbpreparationtp, ")//草药制剂类型(0饮片；1配方颗粒)
					.append(" B.id_herbpreparationtp ")//草药制剂类型
					.append(" from bd_srv A left outer join bd_mm B on A.id_srv = B.id_srv  ")
					.append(" left outer join bd_srv_drug  drug on drug.id_srv = A.ID_SRV")
					.append(" left outer join bd_measdoc C on B.id_unit_pkgsp=C.id_measdoc ")
					.append(" left outer join bd_measdoc D on B.id_unit_med=D.id_measdoc")
					.append(" left outer join bd_measdoc E on B.id_unit_pkgbase=E.id_measdoc ")
					.append(" left outer join bd_boil_des F  on B.Id_Boildes = F.Id_Boildes ")
					.append(" left outer join bd_boil F1  on B.Id_Boil = F1.Id_Boil ")
					.append(" left outer join bd_freq G on G.id_freq = B.id_freq")
					.append(" left outer join bd_route H on H.id_route = B.id_route")
					.append(" left outer join bd_route_des I on I.id_routedes = B.id_routedes")
					.append(" left outer join bd_udidoc dosage on dosage.id_udidoc = drug.id_dosage and dosage.id_udidoclist='@@@@ZZ2000000000002R'")	
					.append(" WHERE  A.fg_active='Y' and B.fg_active =  'Y'  and B.ds ='0' and A.id_srv = ? and B.id_mm = ? ");
		} else {
			sqlSB.append(
					" SELECT  A.id_srvtp,A.sd_srvtp,A.id_srv,A.code as code_srv, A.name as name_srv,A.id_unit_med,D.name as name_unit_med,A.sd_mmbind_op,A.sd_mmbind_er, A.fg_bl,A.id_primd as id_pri,")
					.append(" A.").append(id_mmbind_str).append(" as id_mmbind,")
					.append("A.").append(sd_mmbind_str).append(" as sd_mmbind,")
					.append(" A.").append(fg_use).append(" as fg_use,")
					.append(" B.id_mm,B.spec as spec_mm,B.name as name_mm,B.price,B.des as des_mm,B.sup_name as name_sup,B.code as code_mm ,")
					.append(" B.id_mupkgutp,B.sd_mupkgutp,B.id_opmutp,B.sd_opmutp,B.id_ermutp,B.sd_ermutp,B.id_er1mutp,B.sd_er1mutp,B.id_er2mutp,B.sd_er2mutp,")
					.append(" B.Factor_mb,B.factor_sb factor_cb,B.id_val,B.sd_val,B.Id_Srvskin,B.Fg_skin fg_skintest,")
					.append(" drug.fg_highrisk,drug.id_dosage ,drug.sd_dosage ,dosage.name as name_dosage,drug.id_pharm ,drug.sd_pharm ,")
					.append(" drug.sd_pois ,drug.id_pois ,drug.id_anti ,drug.sd_anti ,drug.fg_pois ,drug.fg_anti ,B.id_mmtp,B.sd_mmtp,")
					.append(" C.id_measdoc as id_unit_sale,C.name as name_unit_sale , E.id_measdoc as id_unit_base, E.name as name_unit_base, ")
					.append(" A.quan_med,A.fg_mm,A.fg_ctm,A.id_primd id_pri,")
					.append(" A.id_boil, F1.name as name_boil, ")
					.append(" A.id_boildes,F.name as Name_boildes,")
					.append(" G.id_freq,G.name as name_freq,G.freqct,G.SD_FREQUNITCT,")
					.append(" A.id_route,H.name as name_route, ")
					.append(" A.id_routedes,I.name as name_routedes, ")
					.append(" A.eu_blmd, ")
					.append(" B.fg_skin as fg_skintest_mm,")
					.append(" B.sd_herbpreparationtp, ")//草药制剂类型(0饮片；1配方颗粒)
					.append(" B.id_herbpreparationtp ")//草药制剂类型
					.append(" from bd_srv A left outer join bd_mm B on A.id_srv = B.id_srv  ")
					.append(" left outer join bd_srv_drug  drug on drug.id_srv = A.ID_SRV")
					.append(" left outer join bd_measdoc C on B.id_unit_pkgsp=C.id_measdoc ")
					.append(" left outer join bd_measdoc D on A.id_unit_med=D.id_measdoc")
					.append(" left outer join bd_measdoc E on B.id_unit_pkgbase=E.id_measdoc ")
					.append(" left outer join bd_boil_des F  on A.Id_Boildes = F.Id_Boildes ")
					.append(" left outer join bd_boil F1  on A.Id_Boil = F1.Id_Boil ")
					.append(" left outer join bd_freq G on G.id_freq = A.id_freq")
					.append(" left outer join bd_route H on H.id_route = A.id_route")
					.append(" left outer join bd_route_des I on I.id_routedes = A.id_routedes")
					.append(" left outer join bd_udidoc dosage on dosage.id_udidoc = drug.id_dosage and dosage.id_udidoclist='@@@@ZZ2000000000002R'")
					.append(" WHERE A.fg_active='Y' and B.fg_active =  'Y'  and B.ds ='0' and A.id_srv = ? and B.id_mm = ? ");
		}

		return sqlSB.toString();
	}

	/**
	 * 根据就诊类型获取可使用属性/绑定属性
	 * 
	 * @param preStr
	 *            前缀
	 * @param code_entp
	 * @return
	 */
	private String getPropertyStr(String preStr, String code_entp) {

		String propertyType = null;
		switch (code_entp) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
			propertyType = "_op";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:// 急诊流水和急诊
			propertyType = "_er";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
			propertyType = "_ip";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
			propertyType = "_fm";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
			propertyType = "_pe";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:// 急诊抢救
			propertyType = "_er1";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:// 急诊抢救
			propertyType = "_er2";
			break;
		}

		return preStr + propertyType;
	}
	/**
	 * 根据就诊类型获取可使用属性/绑定属性
	 * 当前就诊类型物品绑定时机_急诊
	 * @param preStr
	 *            前缀
	 * @param code_entp
	 * @return
	 */
	private String getPropertyStr4Bd_srv(String preStr, String code_entp) {

		String propertyType = null;
		switch (code_entp) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
			propertyType = "_op";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:// 急诊流水
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:// 急诊抢救
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:// 急诊抢救
			propertyType = "_er";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
			propertyType = "_ip";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
			propertyType = "_fm";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
			propertyType = "_pe";
			break;
		}

		return preStr + propertyType;
	}
	/**
	 * 包含价格和库存的内部类
	 * @author zhangwq
	 *
	 */
	public class FactOutPricBean{
		private FDouble price;
		private FDouble factCount;
		//仓库名称
		private String Dep_name;
		public FDouble getPrice() {
			return price;
		}
		public void setPrice(FDouble price) {
			this.price = price;
		}
		public FDouble getFactCount() {
			return factCount;
		}
		public void setFactCount(FDouble factCount) {
			this.factCount = factCount;
		}
		public String getDep_name() {
			return Dep_name;
		}
		public void setDep_name(String dep_name) {
			Dep_name = dep_name;
		}
		
	}
}
