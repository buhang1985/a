package iih.ci.ord.s.ems.third.def;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.utils.BdMmParamUtils;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.ems.cache.BDMeterialInfoCache;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.third.base.OrderPakageInfo;
import iih.ci.ord.s.ems.utils.OrderUtils;
import iih.mm.itf.basematerialdto.d.BaseMaterialDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 默认药品创建医嘱
 * 
 * @author zhangwanqing
 *
 */
public class DefaultDrugsCreateOrderInfo extends DefaultBaseCreateOrderInfo {
	@Override
	public OrderPakageInfo[] createOrdeAggInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) throws BizException {
		// 药品id不能为空
		if (!isValidate(szParam)) {
			return null;
		}

		OrderPakageInfo[] szOrderPakageInfo = super.createOrdeAggInfo(ctx, szParam);
		if (CiOrdUtils.isEmpty(szOrderPakageInfo)) {
			return null;
		}
		// 处理物品信息,建立临时缓存
		Map<String, MeterialDO> tmpMmInfoMap = new HashMap<String, MeterialDO>();
		List<String> id_mm_all = new ArrayList<String>();
		for (DefaultCreateParam param : szParam) {
			String[] id_mms = param.getSzId_mm();
			if(!CiOrdUtils.isEmpty(id_mms)){
				for(String id_mm : id_mms){
					id_mm_all.add(id_mm);
				}
			}
		}
		MeterialDO[] szMmInfo = ServiceFinder.find(IMeterialMDORService.class).findByIds(id_mm_all.toArray(new String[0]),
				FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(szMmInfo)) {
			return null;
		}
		for (MeterialDO mmInfo : szMmInfo) {
			tmpMmInfoMap.put(mmInfo.getId_srv()+mmInfo.getId_mm(), mmInfo);
		}
		// 批量处理物品信息
		for (OrderPakageInfo orderPakageInfo : szOrderPakageInfo) {
			// 获取医嘱和医嘱服务信息
			CiOrderDO orderInfo = orderPakageInfo.getOrderAggInfo().getParentDO();
			OrdSrvDO[] szOrdSrvInfo = orderPakageInfo.getOrderAggInfo().getOrdSrvDO();
			OrdSrvDO mainSrvInfo = szOrdSrvInfo[0];

			// 获取物品信息
			MeterialDO mmInfo = tmpMmInfoMap.get(mainSrvInfo.getId_srv()+mainSrvInfo.getId_mm());
			// 处理医嘱和主服务信息
			handleOrderMainSrvInfo(ctx, orderInfo, mainSrvInfo, mmInfo.getId_mm());
			// 处理成组药共同信息
			handleSrvSameInfo(orderInfo.getId_freq(), orderInfo.getId_route(), szOrdSrvInfo);
			// 处理医嘱服务信息
			handleOrderSrvInfo(ctx, orderInfo.getId_dep_mp(), szOrdSrvInfo, tmpMmInfoMap);

			// 处理医嘱物品
			handleSrvMmInfo(ctx, orderPakageInfo, mmInfo);
		}

		return szOrderPakageInfo;
	}

	private boolean isValidate(DefaultCreateParam[] szParam) {
		for (DefaultCreateParam param : szParam) {
			if (CiOrdUtils.isEmpty(param.getSzId_srv()) || CiOrdUtils.isEmpty(param.getSzId_mm())
					|| param.getSzId_srv().length != param.getSzId_mm().length) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 处理基数药
	 * 
	 * @param ordsrvs
	 * @param tmpMmInfoMap
	 * @throws BizException
	 */
	private void handleOrderSrvInfo(CiEnContextDTO ctx, String id_dep_main, OrdSrvDO[] ordsrvs,
			Map<String, MeterialDO> tmpMmInfoMap) throws BizException {
		List<BaseMaterialDTO> materialList = new ArrayList<BaseMaterialDTO>();

		for (OrdSrvDO srvInfo : ordsrvs) {
			if (tmpMmInfoMap.containsKey(srvInfo.getId_srv())) {
				MeterialDO mmInfo = tmpMmInfoMap.get(srvInfo.getId_srv());

				// 处理执行科室
				handleMpWhDeptInfo(ctx, id_dep_main, srvInfo, mmInfo.getId_mm(),null);
				// 有效性判断
				if (CiOrdUtils.isEmpty(srvInfo.getId_dep_mp()))
					continue;
				// 处理基数药
				BaseMaterialDTO materialDTO = new BaseMaterialDTO();
				materialDTO.setId_srv(srvInfo.getId_srv());
				materialDTO.setId_mm(mmInfo.getId_mm());
				materialDTO.setId_dep(srvInfo.getId_dep_mp());
				materialList.add(materialDTO);

			}
		}
		if (materialList.size() == 0)
			return;
		Map<String, BaseMaterialDTO> map = getBaseDrugMap(
				materialList.toArray(new BaseMaterialDTO[materialList.size()]));
		for (OrdSrvDO srvdo : ordsrvs) {
			if (map.containsKey(srvdo.getId_srv()))
				srvdo.setFg_base(map.get(srvdo.getId_srv()).getFg_base());
		}
	}

	private void handleSrvSameInfo(String id_freq, String id_route, OrdSrvDO[] szSrvInfo) {
		for (OrdSrvDO srvInfo : szSrvInfo) {
			srvInfo.setId_freq(id_freq);
			srvInfo.setId_route(id_route);

		}
	}

	/**
	 * 获取基数药信息
	 * 
	 * @param ctx
	 * @param mmdo
	 * @throws BizException
	 */
	private Map<String, BaseMaterialDTO> getBaseDrugMap(BaseMaterialDTO[] baseMaterials) throws BizException {
		BaseMaterialDTO[] baseMMDTOS = CiOrdAppUtils.getIMaterialBaseInfoService().isBaseMaterial(baseMaterials);
		Map<String, BaseMaterialDTO> map = new HashMap<String, BaseMaterialDTO>();
		if (baseMMDTOS != null) {
			String key = "";
			for (BaseMaterialDTO dto : baseMMDTOS) {
				key = dto.getId_srv();
				map.put(key, dto);
			}
		}
		return map;
	}

	@SuppressWarnings("unused")
	private FBoolean hasSkinTestInfo(CiEnContextDTO ctx, OrdSrvDO[] szOrderSrvInfo,
			Map<String, MeterialDO> tmpMmInfoMap) throws BizException {
		FBoolean hasSkinTest = FBoolean.FALSE;
		for (OrdSrvDO srvInfo : szOrderSrvInfo) {
			if (tmpMmInfoMap.containsKey(srvInfo.getId_srv())) {

				if (FBoolean.FALSE.equals(hasSkinTest)
						&& FBoolean.TRUE.equals(OrderUtils.needFgSkinTest(ctx, tmpMmInfoMap.get(srvInfo.getId_srv())))) {
					hasSkinTest = FBoolean.TRUE;
				}
			}
		}
		return hasSkinTest;
	}

	/**
	 * 处理医嘱物品信息
	 * 
	 * @param ctx
	 * @param orderPakageInfo
	 * @param mmdo
	 * @throws BizException
	 */
	private void handleSrvMmInfo(CiEnContextDTO ctx, OrderPakageInfo orderPakageInfo, MeterialDO mmdo)
			throws BizException {
		OrdSrvDO orderSrvInfo = orderPakageInfo.getOrderAggInfo().getOrdSrvDO()[0];
		MedSrvDrugDO[] szMedSrvDrugDO = ServiceFinder.find(IMedSrvDrugDORService.class)
				.find(String.format(" id_srv = '%s'", orderSrvInfo.getId_srv()), "", FBoolean.FALSE);
		if(szMedSrvDrugDO==null||szMedSrvDrugDO.length==0){
			throw new BizException("服务【"+orderSrvInfo.getName_srv()+"】的药品属性为空! 请联系信息科!");
		}
		OrdSrvMmDO orderSrvMmInfo = createOrderSrvMmInfo(szMedSrvDrugDO[0], mmdo, ctx.getCode_entp(),
				orderSrvInfo.getQuan_medu());
		List<OrdSrvMmDO> srvMmList = new ArrayList<OrdSrvMmDO>();
		srvMmList.add(orderSrvMmInfo);
		orderPakageInfo.setOrderSrvMmList(srvMmList);
	}

	/**
	 * 医嘱物品映射
	 * 
	 * @param medsrvagg
	 * @param mmdo
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	protected OrdSrvMmDO createOrderSrvMmInfo(MedSrvDrugDO drugdo, MeterialDO mmdo, String code_entp, FDouble Quan_med)
			throws BizException {
		OrdSrvMmDO srvmmdo = new OrdSrvMmDO();
		// srvmmdo.setId_orsrvmm //医嘱服务物品主键标识
		// srvmmdo.setId_orsrv //医嘱服务项目
		srvmmdo.setSpec(mmdo.getSpec());
		srvmmdo.setId_mm(mmdo.getId_mm()); // 医疗物品
		srvmmdo.setCode_mm(mmdo.getCode()); // 物品编码
		srvmmdo.setName_mm(mmdo.getName()); // 物品名称
		// MaterialUnitDTO unitdto=getMmUnit(mmdo.getId_mm(), code_entp);
		// if(!CiOrdUtils.isEmpty(unitdto)){
		// srvmmdo.setId_pgku_cur(unitdto.getId_measdoc()); //当前包装单位
		// srvmmdo.setPrice_pgku_cur(CiOrdUtils.getOrSrvMMPrice(mmdo.getId_mm(),srvmmdo.getId_pgku_cur()));//参考价_当前包装
		//// srvmmdo.setQuan_cur(); //总量_当前包装
		// srvmmdo.setFactor(unitdto.getFactor()); //换算系数
		// }
		srvmmdo.setId_pgku_base(mmdo.getId_unit_pkgbase()); // 基本包装单位
		int[] numben = OrSrvSplitUtil.getNumDen(Quan_med, mmdo.getFactor_mb());
		srvmmdo.setQuan_num_base(numben[0]); // 单次数量_分子
		srvmmdo.setQuan_den_base(numben[1]); // 单次数量_分母
		// srvmmdo.setQuan_bed_medu(); //床边剩余量_医学单
		srvmmdo.setFactor_mb(mmdo.getFactor_mb()); // 换算系数_医疗基本
		srvmmdo.setId_dosage(drugdo.getId_dosage()); // 药品剂型
		srvmmdo.setSd_dosage(drugdo.getSd_dosage()); // 药品剂型编码
		srvmmdo.setId_pharm(drugdo.getId_pharm()); // 药理分类
		srvmmdo.setSd_pharm(drugdo.getSd_pharm()); // 药理分类编码
		// srvmmdo.setId_val(drugdo.geti); //价值分类--
		// srvmmdo.setSd_val(); //价值分类编码--
		srvmmdo.setId_pois(drugdo.getId_pois()); // 毒麻分类
		srvmmdo.setSd_pois(drugdo.getSd_pois()); // 毒麻分类编码
		srvmmdo.setId_anti(drugdo.getId_anti()); // 抗菌药分类
		srvmmdo.setSd_anti(drugdo.getSd_anti()); // 抗菌药分类编码
		srvmmdo.setId_mmtp(mmdo.getId_mmtp()); // 物品类型
		srvmmdo.setSd_mmtp(mmdo.getSd_mmtp()); // 物品类型编码
		// srvmmdo.setId_antipsy(drugdo.getid); //抗精神分类编码 --
		// srvmmdo.setSd_antipsy(); //抗精神分类--
		srvmmdo.setFg_otc(mmdo.getFg_otc()); // OTC标识
		// srvmmdo.setQuan_bed_transit();//床边余量_在途
		// srvmmdo.setDays_available(); //领量可用天数（门诊）
		if (code_entp == IBdFcDictCodeConst.SD_CODE_ENTP_OP) {
			srvmmdo.setId_mupkgutp(mmdo.getId_opmutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_opmutp()); // 包装单位取整模式编码
		} else if (code_entp == IBdFcDictCodeConst.SD_CODE_ENTP_IP) {
			srvmmdo.setId_mupkgutp(mmdo.getId_mupkgutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_mupkgutp()); // 包装单位取整模式编码
		} else if (code_entp == IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW) {
			srvmmdo.setId_mupkgutp(mmdo.getId_ermutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_ermutp()); // 包装单位取整模式编码
		} else if (code_entp == IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID) {
			srvmmdo.setId_mupkgutp(mmdo.getId_er1mutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_er1mutp()); // 包装单位取整模式编码
		} else if (code_entp == IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS) {
			srvmmdo.setId_mupkgutp(mmdo.getId_er2mutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_er2mutp()); // 包装单位取整模式编码
		}
		srvmmdo.setId_srv(drugdo.getId_srv()); // 药品服务id
		return srvmmdo;

	}
	// 到此为止的sd_reltp是前台判断医嘱是否进行皮试的标识0需要皮试???计算接口参数不符
	// if(srvInfo.getFg_skintest()==FBoolean.TRUE &&
	// srvInfo.getSd_reltp()!=null &&
	// srvInfo.getSd_reltp().equals(ICiDictCodeConst.CODE_SKIN_SKIN))
	// {
	// //在此重新为sd_reltp和id_reltp重新赋值，赋值为皮试医嘱关联的sd和id
	// srvInfo.setSd_reltp(ICiDictCodeConst.SD_RELTYPE_SKINTEST);
	// srvInfo.setId_reltp(ICiDictCodeConst.SD_RELTYPE_ID_SKINTEST);
	// 需皮试,皮试医嘱相关处理逻辑
	// if(CiOrdUtils.isNeedSkinTest(srvInfo)){
	// CiOrAggAndRelDatum skinagg=getSkinTestOrInfo(ems,srvdto.getId_mm());
	// if(!CiOrdUtils.isEmpty(skinagg)){
	// String[] ids = new DBUtil().getOIDs(1);
	// srvdo.setId_or_rel(ids[0]);
	// skinagg.getOraggdo().getParentDO().setId_or(ids[0]);
	// skinagg.getOraggdo().getParentDO().setFg_skintest(FBoolean.TRUE);
	// rtn.setSkintestagginfo(skinagg);
	// }
	// }
	// }

	//0195799: 医生开立有原液批示的药品的医嘱，自动生成的皮试医嘱，ci_or_srv.id_medu为空
	protected String getObjectUnit(CiEnContextDTO ctx, MedSrvDO medsrv, String id_mm) throws BizException {
		if(id_mm != null){
			String drugMgrMode = BdMmParamUtils.GetDrugMCPropMM();
			if(IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(drugMgrMode)){
				MeterialDO mmInfo = BDMeterialInfoCache.GetMeterialInfo(ctx, id_mm);
				return mmInfo.getId_unit_med();
			}
		}
		return medsrv.getId_unit_med();
	}
}
