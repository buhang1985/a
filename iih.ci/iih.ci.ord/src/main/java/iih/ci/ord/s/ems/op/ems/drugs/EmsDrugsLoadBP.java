package iih.ci.ord.s.ems.op.ems.drugs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.bd.srv.medsrv.refs.sql.op.DrugCheckDisplayMd4OP;
import iih.bd.srv.routedosage.d.RouteDosageRefDO;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.hp.gj.HpService;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.CiorderDrugQry;
import iih.ci.ord.s.ems.cache.BDMmDoseUnitInfoCache;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import iih.ci.ord.s.ems.op.base.OpBaseEmsLoadBP;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
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
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 药品医疗单加载逻辑
 * 
 * @author wangqingzhu
 *
 */
public class EmsDrugsLoadBP extends OpBaseEmsLoadBP {

	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException {
		EmsRstDTO[] rsts = super.load(ctx, args);
		EmsRstDTO rst = rsts[0];
		EmsLoadDTO arg = args[0];
		// 获取医疗单 DTO对象结构
		CiEmsDTO ciEmsInfo = ciEmsInfoFrom(arg.getId_or());
		if (null == ciEmsInfo) {
			throw new BizException("获取医疗单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_ORDER_ISNULL);
		}
		CiEmsSrvDTO mainSrvInfo = this.mainSrvInfoFrom(ctx, ciEmsInfo);
		MedsrvAggDO medSrvAggInfo = ServiceFinder.find(IMedsrvRService.class).findById(ciEmsInfo.getId_srv());

		EmsDrugItemDO ems = modelFrom(ctx, ciEmsInfo);

		// 医疗单对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, ciEmsInfo);
		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, medSrvAggInfo.getParentDO());

		// 添加剂型，用于前台根据剂型过滤成组药品
		String id_dosages = this.getDrugRouteOfDoSages(medSrvAggInfo.getParentDO().getId_route());
		setId_dosages(rst, id_dosages);

		// 获取执行科室 -- 是否有必要再去查询一次执行科室（有可能执行科室已经变化了）
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx.getCode_entp(), medSrvAggInfo.getParentDO().getSd_srvtp(), mainSrvInfo.getId_srvca(),mainSrvInfo.getId_srv(),
				mainSrvInfo.getId_route(),mainSrvInfo.getId_mm(),mainSrvInfo.getId_dep_srv(),ciEmsInfo.getId_dept_ns(),ciEmsInfo.getId_dept_en(),mainSrvInfo.getId_dep(),
				ciEmsInfo.getFg_long(),mainSrvInfo.getSd_herbpreparationtp(),mainSrvInfo.getId_dosage(),mainSrvInfo.getSd_pois(),ctx.getDt_birth());
		if (!CiOrdUtils.isEmpty(wf)) {
		// 保存执行科室过滤条件
			if ("1".equals(wf.getMp_source())) {
				OrderEmsExtInfoUtils.SetMpDepFilter(rst, null);
			}else{
				OrderEmsExtInfoUtils.SetMpDepFilter(rst, CiOrdUtils.isEmpty(wf.getId_mp_depts())?null:wf.getId_mp_depts());
			}
		// 保存物资流向
			OrderEmsExtInfoUtils.SetWhDepFilter(rst, CiOrdUtils.isEmpty(wf.getId_dept_whs())?null:wf.getId_dept_whs());
		}
		//设置库存
		//setFact_count(mainSrvInfo);
	
		// 医疗单模型文档
		rst.setDocument(this.handleReturnDocument(ems));
		// rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(ems.serializeJson()));
		// 医疗单类型
		rst.getDriverInfo().setEmsBackendDriver(EmsType.COMMONDRUG.toString());
		return rsts;
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
	private void setFact_count(EmsOrDrug[] emsOrDrugs) throws BizException {
		StringBuilder strWhDepIds = new StringBuilder();
		for(EmsOrDrug drug : emsOrDrugs){
			strWhDepIds.append(drug.getStr_wh_dep_ids()+",");
		}
		if(strWhDepIds.length()>0)
		{
			strWhDepIds.deleteCharAt(strWhDepIds.length()-1);
		}
		List<GetStockReqDTO> stockDtos = new ArrayList<GetStockReqDTO>();
		for(EmsOrDrug drug : emsOrDrugs){
			String id_dep_whs = drug.getStr_wh_dep_ids();
			if(StringUtils.isEmpty(id_dep_whs)){
				continue;
			}
			String[] whArrays = id_dep_whs.split(",");
			for(String id_dep_wh : whArrays){
				String id_dep = id_dep_wh.replaceAll("'", "");
				GetStockReqDTO reqDTO = new GetStockReqDTO();
				reqDTO.setId_mm(drug.getId_mm());
				reqDTO.setId_dep(id_dep);
				reqDTO.setReq_unit_id(drug.getId_unit_sale());
				stockDtos.add(reqDTO);
			}
		}	
		if(stockDtos.size() > 0){
			Map<String,FactOutPricBean> stockMap = getFactCount(stockDtos);
			for(EmsOrDrug drug : emsOrDrugs){
				StringBuilder fullCountWhs = new StringBuilder();
				String id_dep_whs = drug.getStr_wh_dep_ids();
				if(StringUtils.isEmpty(id_dep_whs)){
					drug.setStr_wh_dep_ids("");
					drug.setFact_count(FDouble.ZERO_DBL);
					continue;
				}
				String[] whArrays = id_dep_whs.split(",");
				//先判断优先级最好的仓库是否有库存
				String key = drug.getId_mm() + drug.getId_dep_wh();
				FactOutPricBean factOutPrice = null;
				if(stockMap.containsKey(key)){
					factOutPrice = stockMap.get(key);
					if(factOutPrice.getFactCount().compareTo(FDouble.ZERO_DBL)>0){
						drug.setFact_count(factOutPrice.getFactCount());
						drug.setPrice(factOutPrice.getPrice());
					}
				}else{
					drug.setFact_count(FDouble.ZERO_DBL);
				}
				for(String id_dep_wh : whArrays){
					String id_dep = id_dep_wh.replaceAll("'", "");
					key = drug.getId_mm() + id_dep;
					if(stockMap.containsKey(key)){
						factOutPrice = stockMap.get(key);
						if(factOutPrice.getFactCount().compareTo(FDouble.ZERO_DBL)>0){
							fullCountWhs.append(id_dep_wh+",");
						}
					}
				}
				if(fullCountWhs.length()>0)
				{
					fullCountWhs.deleteCharAt(fullCountWhs.length()-1);
				}
				drug.setStr_wh_dep_ids(fullCountWhs.toString());
			}
		}else{
			for(EmsOrDrug drug : emsOrDrugs){
				drug.setStr_wh_dep_ids("");
				drug.setFact_count(FDouble.ZERO_DBL);
			}
		}	
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
				FactOutPricBean factOutPric = new FactOutPricBean();
				factOutPric.setFactCount(factCount);
				factOutPric.setPrice(materialStockDTO.getPrice_act());
				maps.put(key, factOutPric);
			}	
		}
		return maps;
	}
	/**
	 * 包含价格和库存的内部类
	 * @author zhangwq
	 *
	 */
	public class FactOutPricBean{
		private FDouble price;
		private FDouble factCount;
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
	}
	protected void setId_dosages(EmsRstDTO ems, String v) {
		FMap2 emsExtension = ems.getExtension();
		if (null == emsExtension) {
			emsExtension = new FMap2();
			ems.setExtension(emsExtension);
		}
		emsExtension.put("id_dosages", v);
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
	 * 构建药品主信息 -- 同 药品
	 * 
	 * @param emsDrugItemInfo
	 * @param dto
	 * @throws BizException
	 */
	protected EmsDrugItemDO modelFrom(CiEnContextDTO ctx, CiEmsDTO dto) throws BizException {

		EmsDrugItemDO emsDrugItemInfo = new EmsDrugItemDO();
		CiEmsSrvDTO mainSrvInfo = this.mainSrvInfoFrom(ctx, dto);
		emsDrugItemInfo.setEu_orsrcmdtp(dto.getEu_orsrcmdtp());// 医嘱来源方式 by yzh
																// 2017-08-24
																// 10:31:33
		//草药是否院内制剂 by yzh 2018年4月9日 19:47:24
		emsDrugItemInfo.setFg_hospital_herbpres(dto.getFg_hospital_herbpres());
		emsDrugItemInfo.setId_or(dto.getId_or());
		emsDrugItemInfo.setFg_urgent(dto.getFg_urgent()); // 紧急标识 liyue
		//超量原因 BY GH
		emsDrugItemInfo.setId_excessive_reason(dto.getId_excessive_reason());
		emsDrugItemInfo.setSd_excessive_reason(dto.getSd_excessive_reason());
		emsDrugItemInfo.setName_excessive_reason(dto.getName_excessive_reason());
		//滴速  liyue
		emsDrugItemInfo.setId_dripspeed(dto.getId_dripspeed());
		emsDrugItemInfo.setName_dripspeed(dto.getName_dripspeed());
		//超额愿意
		emsDrugItemInfo.setMore_money_reason(dto.getMore_money_reason());
		emsDrugItemInfo.setDt_begin_ui(dto.getDt_begin()); // 开始日期 SINGLE
		emsDrugItemInfo.setDt_end_ui(dto.getDt_end()); // 结束日期 SINGLE FDateTim
		emsDrugItemInfo.setUse_days(dto.getDays_or()); // 医嘱天数 SINGLE Integer
		emsDrugItemInfo.setTimes_cur(dto.getTimes_cur());// 医嘱次数
		emsDrugItemInfo.setTimes_mp_in(dto.getTimes_mp_in());// 在院执行次数
		emsDrugItemInfo.setFg_dose_anoma(mainSrvInfo.getFg_dose_anoma());
		emsDrugItemInfo.setId_unit_med(mainSrvInfo.getId_unit_med());
		emsDrugItemInfo.setName_unit_med(mainSrvInfo.getName_unit_med());
		emsDrugItemInfo.setFg_self(mainSrvInfo.getFg_self());
		emsDrugItemInfo.setFg_outp(mainSrvInfo.getFg_outp());
		emsDrugItemInfo.setFg_propc(mainSrvInfo.getFg_propc());
		emsDrugItemInfo.setFg_treat(mainSrvInfo.getFg_indic());// srvInfo.getFg_treat;
		emsDrugItemInfo.setFg_bl(mainSrvInfo.getFg_bl());
		emsDrugItemInfo.setId_srv(dto.getId_srv());
		emsDrugItemInfo.setName_srv(dto.getName());
		emsDrugItemInfo.setSd_srvtp(dto.getSd_srvtp());
		emsDrugItemInfo.setId_srvtp(dto.getId_srvtp());
		//if (dto.getNote()!=null) {
		//	emsDrugItemInfo.setNote_or(dto.getNote());
		//}else{
			emsDrugItemInfo.setNote_or(dto.getDes_or());
		//}
		
		emsDrugItemInfo.setFg_long(dto.getFg_long());
		// 长临标识
		emsDrugItemInfo.setId_freq(mainSrvInfo.getId_freq()); // 医嘱频次 REF 医嘱频次定义
		emsDrugItemInfo.setName_freq(mainSrvInfo.getName_freq()); // 医嘱频次名称
		emsDrugItemInfo.setFreqct(mainSrvInfo.getFreqct());// zwq 2016-09-06
		emsDrugItemInfo.setSd_frequnitct(mainSrvInfo.getSd_frequnitct());
		emsDrugItemInfo.setId_route(dto.getId_route()); // 用法 REF
		emsDrugItemInfo.setName_route(dto.getName_route()); // 用法名称
		emsDrugItemInfo.setId_routedes(dto.getId_routedes()); // 用法要求 REF 医疗用法要求
		emsDrugItemInfo.setName_routedes(dto.getName_routedes()); // 用法要求描述
		emsDrugItemInfo.setId_didef(dto.getId_didef());
		emsDrugItemInfo.setCode_didef(dto.getCode_didef());
		emsDrugItemInfo.setName_didef(dto.getName_didef());

		//emsDrugItemInfo.setNote_or(dto.getNote()); // 备注 SINGLE 备注 1000
		// emsDrugItemInfo.setid_edto.getId_emp_phy()); //开立医生 REF 人员基本信息
		// dto.getName_emp_phy //开立医生姓名 SINGLE String
		// dto.getId_dep_phy ()); //开立科室 REF 部门 20
		////// dto.getName_dep_phy //开立科室名称 SINGLE String
		// dto.getId_wg_or ()); //医疗组 REF 业务组 20 业务

		if (emsDrugItemInfo.getDt_end_ui() != null && emsDrugItemInfo.getDt_end_ui().getYear() > 2098) // 时间控件仅支持到
																										// 2099年
		{
			emsDrugItemInfo.setDt_end_ui(null);
		}
		emsDrugItemInfo.setDt_fail(dto.getDt_invalid()); // 医嘱过期时间 SINGLE
															// FDateTim
		// dto.getFg_bb //婴儿标识 SINGLE FBoolean
		// dto.getNo_bb //婴儿序号 SINGLE Integer
		emsDrugItemInfo.setFg_pmor(dto.getFg_pmor()); // 备用医嘱标识 SINGLE FBoolean
		emsDrugItemInfo.setBak_des(dto.getDes_pmor()); // 备用医嘱使用条件描述 SINGLE
		// dto.getFg_active_pm= //备用医嘱启用标识 SINGLE FBoo
		// dto.getId_reltp //关联医嘱类型编码 SINGLE Stri
		// dto.getSd_reltp //关联医嘱类型 SINGLE String
		// dto.getId_or_rel //关联医嘱 SINGLE String
		// dto.getFg_ctlcp //临床路径控制标识 SINGLE FBoo
		// dto.getFg_mr //医疗记录联动标识 SINGLE FBoo
		// emsDrugItemInfo.setFg_skintest = dto.getFg_skintest; //需皮试标识 SINGLE
		// FBoolean
		// dto.getId_skintest_skip_reaso //不皮试原因 SINGLE
		// dto.getSd_skintest_skip_reaso //不皮试原因编码 SING
		emsDrugItemInfo.setFg_mp_in(dto.getFg_mp_in()); // 在院执行标识 SINGLE
		emsDrugItemInfo.setUse_days(dto.getDays_or());
		dto.setFg_or_doc(FBoolean.TRUE); // 医生医嘱标识 SINGLE
		emsDrugItemInfo.setQuan_firday_mp(dto.getTimes_firday_mp());
		emsDrugItemInfo.setId_dep(dto.getId_dep_mp());// zwq 2016-08-04
		emsDrugItemInfo.setName_dep(dto.getName_dep_mp());// zwq 2016-08-04
		emsDrugItemInfo.setEmsOrDrugListEx(orderDrugListFrom(ctx, emsDrugItemInfo, dto));
		emsDrugItemInfo.setStatus(DOStatus.UPDATED);

		return emsDrugItemInfo;
	}

	protected FArrayList orderDrugListFrom(CiEnContextDTO ctx, EmsDrugItemDO ems, CiEmsDTO dto) throws BizException {
		// 计算取整模式
		FArrayList drugDoseList = new FArrayList();
		FArrayList drugList = new FArrayList();
		StringBuilder whereSb = new StringBuilder();
		Map<String, MedSrvDO> teamSrvMap = this.getBdSrvInfo(this.getBdSrvIds(dto.getEmssrvs()));
		for (Object p : dto.getEmssrvs()) {
			CiEmsSrvDTO srvInfo = (CiEmsSrvDTO) p;

			if (srvInfo.getEu_sourcemd().equals(OrSrvSourceFromEnum.PHYSIAN)
					|| srvInfo.getEu_sourcemd().equals(OrSrvSourceFromEnum.AGENTFROMPRIMD)
					|| srvInfo.getEu_sourcemd().equals(OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD)) {

				whereSb.append("'").append(srvInfo.getId_mm()).append("'").append(",");
				//
				EmsOrDrug drug = orderDrugInfoFrom(dto, srvInfo);
				if (teamSrvMap.containsKey(drug.getId_srv())) {
					drug.setSd_mmbind_op(teamSrvMap.get(drug.getId_srv()).getSd_mmbind_op());
				}
				// 执行科室和物资流向科室参照过滤条件
				OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, srvInfo.getId_srv(),srvInfo.getId_mm(), srvInfo.getId_route() , ems.getId_dep(),dto.getFg_long(),FBoolean.FALSE,dto.getDt_begin());
				if (null != wf) {
					drug.setStr_mp_dep_ids(wf.getId_mp_depts());
					drug.setStr_wh_dep_ids(wf.getId_dept_whs());
					//drug.setName_dep_wh(wf.getName_dept_wh());
				}
				drug.setOrDoseDrugList(emsOrDoseDrugFrom(ems, srvInfo));
				if (null != drug.getOrDoseDrugList() && 0 != drug.getOrDoseDrugList().size()) {
					drugDoseList.addAll(drug.getOrDoseDrugList());
				}

				// 同步物品基本信息
				// 获得物品信息 -- 门诊不需要获取物品信息
				Map<String, EmsOrDrug> tmpSrvMmCache = getRelateEmsOrDrug(srvInfo.getId_srv(), ctx);
				if (tmpSrvMmCache.containsKey(drug.getId_mm())) {
					EmsOrDrug bdSrvMmInfo = tmpSrvMmCache.get(drug.getId_mm());
					drug.setBdHpIndicationDTO(bdSrvMmInfo.getBdHpIndicationDTO());
					drug.setRelativefieldmap(bdSrvMmInfo.getRelativefieldmap());
					drug.setFg_skintest_mm(bdSrvMmInfo.getFg_skintest_mm());
				}
				//BY gh 加入高危药品标识
				drug.setFg_highrisk(srvInfo.getFg_highrisk());
				//设置当前剂量，当前剂量单位，当前剂量换算系数
				drug.setId_medu_cur(srvInfo.getId_medu_cur());
				drug.setQuan_medu_cur(srvInfo.getQuan_medu_cur());
				drug.setFactor_medu_cur(srvInfo.getFactor_medu_cur());
				drug.setQuan_medu_virtual(drug.getQuan_medu_cur());
				if(drug.getId_medu_cur()!=null) {
					MeasDocDO mea=this.getmeasdocInfo(drug.getId_medu_cur());
					if(mea!=null)
						drug.setName_unit_medu_virtual(mea.getName());
				}
				drugList.add(drug);

			}
		}
		
		// 取整模式 --?? 应该在 ci_or_srv_mm 表中冗余这两个字段
		// {
		// String whereStr = whereSb.deleteCharAt(whereSb.length() -
		// 1).toString();
		// // 查询物品信息
		// MeterialAggDO[] szMeterialAggDO =
		// CiOrdAppUtils.getIMeterialRService()
		// .find(String.format(" id_mm in (%s)", whereStr), "", FBoolean.FALSE);
		// // 构造临时缓存
		// Map<String, MeterialDO> tmpMmCache = new HashMap<String,
		// MeterialDO>();
		// for (MeterialAggDO mm : szMeterialAggDO) {
		// tmpMmCache.put(mm.getParentDO().getId_mm(), mm.getParentDO());
		// }
		// // 设置药品的取整模式
		// for (Object objDrug : drugList) {
		// if (tmpMmCache.containsKey(((EmsOrDrug) objDrug).getId_mm())) {
		// ((EmsOrDrug) objDrug).setSd_opmutp(tmpMmCache.get(((EmsOrDrug)
		// objDrug).getId_mm()).getSd_opmutp());
		// ((EmsOrDrug) objDrug)
		// .setSd_mupkgutp(tmpMmCache.get(((EmsOrDrug)
		// objDrug).getId_mm()).getSd_mupkgutp());
		// }
		// }
		// }
		//库存
		try {
			setFact_count((EmsOrDrug[])drugList.toArray(new EmsOrDrug[]{}));
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		// 外配药逻辑赋值
		CiEmsSrvDTO mainSrvInfo = this.mainSrvInfoFrom(ctx, dto);
		ems.setFg_extdispense(mainSrvInfo.getFg_extdispense());
		return drugList;
	}

	protected EmsOrDrug orderDrugInfoFrom(CiEmsDTO dto, CiEmsSrvDTO srvInfo) {
		EmsOrDrug drug = new EmsOrDrug();
		drug.setStatus(DOStatus.UPDATED);
		drug.setId_srvca(srvInfo.getId_srvca()); //服务分类
		drug.setId_orsrv(srvInfo.getId_orsrv()); // 医疗单项目主键标识
		// drug.setId_or (srvInfo.getId_or()); //医疗单 SINGLE F
		drug.setSortno(srvInfo.getSortno()); // 序号 SINGLE I
		drug.setId_srv(srvInfo.getId_srv()); // 医疗服务 REF
		drug.setName_srv(srvInfo.getName_srv()); // 医疗服务名称 SINGL
		drug.setSd_srvtp(srvInfo.getSd_srvtp());
		drug.setId_unit_med(srvInfo.getId_unit_med()); // 医疗单位 REF
		drug.setName_unit_med(srvInfo.getName_unit_med()); // 医疗单位编码
		drug.setQuan_med(srvInfo.getQuan_med()); // 剂量 SINGLE F
		drug.setName_unit_medu_virtual(srvInfo.getName_unit_med());
		drug.setQuan_medu_virtual(srvInfo.getQuan_med());
		drug.setId_pri(srvInfo.getId_primd());// 定价模式
		drug.setPrice(srvInfo.getPrice()); // 参考价格 SINGL
		drug.setId_freq(srvInfo.getId_freq()); // 医嘱频次 REF
		drug.setName_freq(srvInfo.getName_freq()); // 医嘱频次名称 SINGL
		drug.setSd_frequnitct(srvInfo.getSd_frequnitct());
		drug.setFreqct(srvInfo.getFreqct());
		drug.setId_route(srvInfo.getId_route());
		drug.setName_route(srvInfo.getName_route());
		drug.setId_routedes(srvInfo.getId_routedes());
		drug.setName_routedes(srvInfo.getName_routedes());
		drug.setUse_days(dto.getDays_or());
		drug.setFg_or(srvInfo.getFg_or()); // 医嘱标识 SINGL
		drug.setFg_bl(srvInfo.getFg_bl()); // 费用标识 SINGL
		drug.setFg_selfsrv(srvInfo.getFg_selfsrv());// 自定义服务
		// Id_org_srv //开立机构 SINGL
		// Id_dep_srv //开立科室 SINGL
		// Id_ward_srv //开立病区 SINGL
		// Id_emp_srv //开立人员 SINGL
		// Dt_last_bl //最近生成日期 SINGL
		// Eu_blmd //划价方式 SINGL
		drug.setId_emsordrug(srvInfo.getId_orsrvmm()); // 服务项目物品
		drug.setId_mm(srvInfo.getId_mm()); // 物品
		drug.setCode_mm(srvInfo.getCode_mm()); // 物品编码
		drug.setName_mm(srvInfo.getName_mm()); // 物品名称
		drug.setSpec_mm(srvInfo.getSpec_mm()); // 规格
		drug.setFg_mm(srvInfo.getFg_mm());
		drug.setId_pgku_cur(srvInfo.getId_unit_sale()); // 零售单位
		drug.setName_pgku_cur(srvInfo.getName_unit_sale()); // 零售单位名称
		drug.setId_unit_base(srvInfo.getId_unit_base()); // 基本单位
		drug.setName_unit_base(srvInfo.getName_unit_base()); // 基本单位名称
		drug.setName_unit_sale(srvInfo.getName_unit_sale());
		drug.setId_unit_sale(srvInfo.getId_unit_sale());
		drug.setQuan_cur(srvInfo.getQuan_cur());// 总量
		drug.setQuan_base(srvInfo.getQuan_base()); // 总量_基本
		if (drug.getPrice() != null) {
			drug.setTotalprice(
					drug.getPrice().multiply(drug.getQuan_cur() == null ? FDouble.ZERO_DBL : drug.getQuan_cur())); // 总价计算
		}
		drug.setFactor_cb(srvInfo.getFactor_cb()); // 当前基本换算系数
		drug.setFactor_mb(srvInfo.getFactor_mb()); // 医疗基本换算系数
		drug.setId_dosage(srvInfo.getId_dosage()); // 药品剂型
		drug.setSd_dosage(srvInfo.getSd_dosage()); // 药品剂型编码
		drug.setName_dosage(srvInfo.getName_dosage());//药品剂型
		drug.setId_pharm(srvInfo.getId_pharm()); // 药理分类
		drug.setSd_pharm(srvInfo.getSd_pharm()); // 药理分类编码
		drug.setId_pois(srvInfo.getId_pois()); // 毒麻分类
		drug.setSd_pois(srvInfo.getSd_pois()); // 毒麻分类编码
		drug.setId_anti(srvInfo.getId_anti()); // 抗菌药分类
		drug.setSd_anti(srvInfo.getSd_anti()); // 抗菌药分类编码
		drug.setId_mmtp(srvInfo.getId_mmtp()); // 物品类型
		drug.setSd_mmtp(srvInfo.getSd_mmtp()); // 物品类型编码
		drug.setId_val(srvInfo.getId_val()); // 价值分类
		drug.setSd_val(srvInfo.getSd_val()); // 价值分类编码
		drug.setFg_propc(srvInfo.getFg_propc());// 预防用药标识
		drug.setFg_treat(srvInfo.getFg_indic());// 治疗用药标识
		drug.setNote_or(srvInfo.getDes_srv());// 备注
		drug.setId_mp_dep(srvInfo.getId_dep());// 执行科室id
		drug.setName_mp_dep(srvInfo.getName_dep());// 执行科室
		drug.setFg_self(srvInfo.getFg_self());// 自备药标识
		drug.setFg_dose_anoma(srvInfo.getFg_dose_anoma());// 变动用药标识
		drug.setFg_extdispense(srvInfo.getFg_extdispense());// 外配药标识
		drug.setFg_ctm(srvInfo.getFg_selfsrv());// 自定义服务标志
		drug.setFg_selfpay(srvInfo.getFg_selfpay()); // 自费标志 废弃 20191120
		
		drug.setEu_hpjudge(srvInfo.getEu_hpjudge()); // 医保判断方式
		drug.setEu_orsrvhp(srvInfo.getEu_orsrvhp()); // 医保判断结果
		drug.setId_dsdef(srvInfo.getId_dsdef()); // 病种ID
		drug.setCode_dsdef(srvInfo.getCode_dsdef()); // 病种编码
		drug.setName_dsdef(srvInfo.getName_dsdef()); // 病种名称
		
		drug.setId_opmutp(srvInfo.getId_opmutp());// 门诊取整模式
		drug.setSd_opmutp(srvInfo.getSd_opmutp());// 门诊取整模式
		drug.setSd_mupkgutp(srvInfo.getSd_mupkgutp());// 住院取整模式
		drug.setId_mupkgutp(srvInfo.getId_mupkgutp());// 住院取整模式
		// 皮试信息
		drug.setFg_skintest(srvInfo.getFg_skintest());// 是否皮试
		drug.setId_or_rel(srvInfo.getId_or_rel());// 关联皮试id
		drug.setId_skintest_skip_reason(srvInfo.getId_skintest_skip_reason());// 强制使用原因
		drug.setId_reltp(srvInfo.getId_reltp());// 关联类型id
		drug.setSd_reltp(srvInfo.getSd_reltp());// 关联类型sd
		drug.setId_hp(srvInfo.getId_hp());
		drug.setId_hpsrvtp(srvInfo.getId_hpsrvtp());
		drug.setSd_hpsrvtp(srvInfo.getSd_hpsrvtp());
		drug.setLimit(srvInfo.getLimit());
		drug.setFg_hpindicjudged(srvInfo.getFg_hpindicjudged());

		// 执行科室
		drug.setId_mp_dep(srvInfo.getId_dep());
		drug.setName_mp_dep(srvInfo.getName_dep());
		drug.setId_dep_wh(srvInfo.getId_dep_wh());
		drug.setName_dep_wh(srvInfo.getName_dep_wh());
		// 计价模式
		drug.setEu_blmd(srvInfo.getEu_blmd());
		//与付数无关
		drug.setFg_nothingwithorders(srvInfo.getFg_nothingwithorders());
		// 设置联合主键  大小包装拼接单位  商品模式不拼
		if("11".equals(DrugCheckDisplayMd4OP.getInstance().getDrugCheckDisplayMd4OP())) {
			drug.setIdSrvIdMm(drug.getId_srv() + drug.getId_mm() + drug.getId_unit_sale());
		}else {
			drug.setIdSrvIdMm(drug.getId_srv() + drug.getId_mm());
		}
		drug.setId_herbpreparationtp(srvInfo.getId_herbpreparationtp());
		drug.setSd_herbpreparationtp(srvInfo.getSd_herbpreparationtp());
		return drug;
	}

	private FArrayList emsOrDoseDrugFrom(EmsDrugItemDO ems, CiEmsSrvDTO srv) {
		FArrayList listEmsfreqdose = srv.getEmsfreqdose();
		if (listEmsfreqdose == null)
			return null;

		FArrayList listDrugDoseInfo = new FArrayList();
		for (Object item : listEmsfreqdose) {
			OrdSrvDoseDO ordSrvInfo = (OrdSrvDoseDO) item;
			EmsOrDrug drugDoseInfo = new EmsOrDrug();
			{
				drugDoseInfo.setId_emsordrug(ordSrvInfo.getId_orsrvdose());
				drugDoseInfo.setId_orsrv(ordSrvInfo.getId_orsrv());
				drugDoseInfo.setId_freqtime(ordSrvInfo.getId_freqtime());
				drugDoseInfo.setQuan_med(ordSrvInfo.getQuan_dose());
				drugDoseInfo.setName_freqtime(ordSrvInfo.getId_freqtime());
				drugDoseInfo.setName_unit_med(ordSrvInfo.getName_unit_dose());
				drugDoseInfo.setId_unit_med(ordSrvInfo.getId_unit_dose());

			}
			listDrugDoseInfo.add(drugDoseInfo);
		}

		return listDrugDoseInfo;
	}

	/**
	 * 获取该服务下的物品列表信息
	 * 
	 * @param emsCrt
	 * @param orWfDeptInfo
	 * @return
	 * @throws BizException
	 */
	private Map<String, EmsOrDrug> getRelateEmsOrDrug(String id_srv, CiEnContextDTO ctx) throws BizException {

		Map<String, EmsOrDrug> tmpSrvMmCache = new HashMap<String, EmsOrDrug>();
		if (StringUtils.isBlank(id_srv))
			return tmpSrvMmCache;

		CiorderDrugQry qry = new CiorderDrugQry(new String[]{id_srv}, null);
		DAFacade cade = new DAFacade();
		List<EmsOrDrug> mm = (List<EmsOrDrug>) cade.execQuery(qry.getQrySQLStr(), new BeanListHandler(EmsOrDrug.class));
		String idsrvs = id_srv.replace("'", "");
		BdHpIndicationDTO[] hpIndiccation = null;
		// TODO：医保信息调整后改动

		List<EmsOrDrug> list = new ArrayList<EmsOrDrug>();
		List<String> mmIds = new ArrayList<String>();
		for (EmsOrDrug drug : mm) {
			if (!CiOrdUtils.isEmpty(drug.getId_mm())) {
				mmIds.add(drug.getId_mm());
			}
		}
		MaterialUnitDTO[] materUnit = null;
		if (mmIds.size() > 0) {
			materUnit = BDMmDoseUnitInfoCache.getMaterialUnitInfos(ctx.getCode_entp(), mmIds.toArray(new String[mmIds.size()])); 
		}

		for (EmsOrDrug object : mm) {
			// TODO:单次剂量 =医学单位值/系数 单次数量应该改为 string类型
			// 根据物品和单位类型参数配置 获取物品的单位集合
			// 关于医保信息，一个服务一个一医保信息（多个物品暂时不考虑）
			if (ctx != null && ctx.getId_hp() != null && ctx.getId_hp() != ""
					&& FBoolean.TRUE.equals(ctx.getFg_hpfundpay()) && ctx.getEu_hpbeyond() != null
					&& ctx.getEu_hpbeyond().equals("0")) {
				// hpMap = findHps(id_hp, id_srvArray);
				hpIndiccation = HpService.getMedSrvHpService(id_srv, object.getId_mm(), ctx);

				if (hpIndiccation != null && hpIndiccation.length > 0) {
					object.setFg_treat(hpIndiccation[0].getFg_indic());
					if (!CiOrdUtils.isEmpty(object.getFg_treat()) && !object.getFg_treat().booleanValue()) {
						object.setFg_selfpay(FBoolean.TRUE);
					} else {
						object.setFg_selfpay(FBoolean.FALSE);
					}
					object.setLimit(hpIndiccation[0].getDes_hplimit());
					object.setId_hp(ctx.getId_hp());
					object.setSd_hpsrvtp(hpIndiccation[0].getSd_hpsrvtp());
					if (!CiOrdUtils.isEmpty(object.getSd_hpsrvtp())) {
						object.setId_hpsrvtp(CiOrdUtils.idHpSrvtpFromSdHpSrvtp(object.getSd_hpsrvtp()));
					}
					// object.setId_hpsrvtp(hpIndiccation[0].getId_hpsrvtp());
					// object.setName_hp(hpIndiccation[0].);
					object.setBdHpIndicationDTO(new FArrayList().append(hpIndiccation[0]));
				}
			} else {
				object.setFg_selfpay(FBoolean.TRUE);
			}

			if (object.getFg_mm().booleanValue() && object.getId_mm() == null)
				throw new BizException(object.getName_srv() + " 没有绑定物品 或者 物品没有启用");
			if (object.getFg_mm().booleanValue() && object.getId_mm() != null) {
				if (materUnit != null && materUnit.length > 0) {
					String strUnit = "";
					int i = 0;
					String ids = "", names = "", factors = "";
					for (MaterialUnitDTO dto : materUnit) {
						if (object.getId_mm().equals(dto.getId_mm())) {
							if (i == 0) {
								object.setId_unit_sale(dto.getId_measdoc());
								object.setFactor_cb(dto.getFactor());// 基本包装单位和总量单位间的换算系数
								object.setName_unit_sale(dto.getMeasdoc_name());
								object.setPrice(dto.getPrice());// 单价
							}
							ids += "," + dto.getId_measdoc();
							names += "," + dto.getMeasdoc_name();
							if (CiOrdUtils.isEmpty(dto.getFactor())) {
								factors += ",1";
							} else {
								factors += "," + dto.getFactor();
							}
							i++;
							strUnit += ",'" + dto.getId_measdoc() + "'";
						}
					}

					if (strUnit == "")
						throw new BizException(" 物品" + object.getName_mm() + "没有对应的单位");

					object.setStr_unit_pkg_ids(strUnit.substring(1));
					FMap fmap = new FMap();
					if (!CiOrdUtils.isEmpty(ids)) {
						fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_ID_MEASDOC, ids.substring(1));

					}
					if (!CiOrdUtils.isEmpty(names)) {
						fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_MEASDOC_NAME, names.substring(1));
					}
					if (!CiOrdUtils.isEmpty(factors)) {
						fmap.put("factor", factors.substring(1));
					}

					object.setRelativefieldmap(fmap);
					// object.setName_unit_sale(unitList.get(0).getName_unit_sale());
					// object.setId_unit_sale(unitList.get(0).getId_unit_sale());
					// object.setName_unit_med(unitList.get(0).getName_unit_med());
					// object.setId_unit_med(unitList.get(0).getId_unit_med());
				}
			} else {
				object.setStr_unit_pkg_ids(object.getId_unit_med());
				FMap fmap = new FMap();
				fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_ID_MEASDOC, object.getId_unit_med());
				fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_MEASDOC_NAME, object.getName_unit_med());
				object.setRelativefieldmap(fmap);
			}

			tmpSrvMmCache.put(object.getId_mm(), object);
			list.add(object); // 暂时不返回数组结构
		}

		return tmpSrvMmCache;
	}

	/**
	 * 查询服务的id数组
	 * 
	 * @param emssrvs
	 *            CiEmsSrvDTO 集合
	 * @return
	 */
	private String[] getBdSrvIds(FArrayList emssrvs) {
		if (CiOrdUtils.isEmpty(emssrvs))
			return null;
		List<String> ids = new ArrayList<String>();
		for (Object p : emssrvs) {
			CiEmsSrvDTO srvInfo = (CiEmsSrvDTO) p;
			if (!ids.contains(srvInfo.getId_srv())) {
				ids.add(srvInfo.getId_srv());
			}
		}
		return ids.toArray(new String[0]);
	}

	/**
	 * 查询服务对应的基础数据
	 * 
	 * @param id_srvs
	 * @return
	 */
	private Map<String, MedSrvDO> getBdSrvInfo(String[] id_srvs) {
		Map<String, MedSrvDO> medSrvMap = new HashMap<String, MedSrvDO>();
		if (CiOrdUtils.isEmpty(medSrvMap)) {
			return medSrvMap;
		}
		try {
			List<MedSrvDO> srvs = (List<MedSrvDO>) new DAFacade().findByPKs(MedSrvDO.class, id_srvs,
					new String[] { MedSrvDO.ID_SRV, MedSrvDO.SD_MMBIND_OP });
			if (!CiOrdUtils.isEmpty(srvs)) {
				for (MedSrvDO srv : srvs) {
					medSrvMap.put(srv.getId_srv(), srv);
				}
			}
		} catch (DAException e) {
			e.printStackTrace();
		}
		return medSrvMap;
	}
	
	//
	private MeasDocDO getmeasdocInfo(String id_measdoc) {

		try {
			List<MeasDocDO> meas = (List<MeasDocDO>) new DAFacade().findByPKs(MeasDocDO.class, new String[] {id_measdoc},
					new String[] { MeasDocDO.NAME});
			if (meas!=null&&meas.size()>0) {
				return meas.get(0);
			}
		} catch (DAException e) {
			e.printStackTrace();
		}
		return null;
	}
}
