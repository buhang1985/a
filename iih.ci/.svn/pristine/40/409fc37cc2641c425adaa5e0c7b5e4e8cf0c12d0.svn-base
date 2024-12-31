package iih.ci.ord.s.ems.ip.ems.commondrugs;

import java.util.List;
import java.util.UUID;

import iih.bd.base.define.MmDoseUnitMap;
import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.utils.BdMmParamUtils;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsDrugsViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsCreateBP;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.utils.OrderEmsDtUtils;
import iih.ci.ord.s.ems.utils.SysParamUtils;
import iih.ci.ord.s.ems.cache.BDFreqInfoCache;
import iih.ci.ord.s.ems.cache.BDMeasInfoCache;
import iih.ci.ord.s.ems.cache.BDMeterialInfoCache;
import iih.ci.ord.s.ems.cache.BDMmDoseUnitInfoCache;
import iih.ci.ord.s.ems.cache.BDSrvInfoCache;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 创建医疗单
 * 
 * @author wangqingzhu
 *
 */
public class EmsCommonDrugsCreateBP extends BaseIpEmsCreateBP {

	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] emsArray) throws BizException {
		EmsCrtDTO emsCrtDTO = emsArray[0];

		EmsDrugsViewDTO emsViewDTO = new EmsDrugsViewDTO();
		ErrorEmsDTO err = assembleEmsViewInfo(ctx, emsCrtDTO.getId_srv(), emsCrtDTO.getId_mm(), emsViewDTO);

		// 成组要字段信息处理
		if (emsCrtDTO.getDocument() != null && emsCrtDTO.getDocument().size() > 0
				&& emsCrtDTO.getDocument().get(0) instanceof OrderListViewDTO) {
			mergeOrderGroupInfo((OrderListViewDTO) emsCrtDTO.getDocument().get(0), emsViewDTO);
		}
		// 获取主服务信息
		MedSrvDO medSrvInfo = BDSrvInfoCache.GetBdSrvInfo(ctx, emsCrtDTO.getId_srv());
		this.calcOrderWfDeptInfo(ctx, medSrvInfo, emsViewDTO);
		
		//处理前台传入的默认值数据
		handleDefaultInfo(emsCrtDTO,emsViewDTO);
		// 主键
		emsViewDTO.setIdsrvIdmm(medSrvInfo.getId_srv() + emsViewDTO.getId_mm()+emsViewDTO.getId_unit_cur());
		// 计算价格
		emsViewDTO.setPri(BDMmDoseUnitInfoCache.GetPkgPriceOfMaterialStockInfo(emsViewDTO.getId_dep_wh(),emsViewDTO.getId_mm(), emsViewDTO.getId_unit_cur()));// 单价

		// 返回值处理
		setEmsDriverInfo(emsCrtDTO.getDriverInfo(), emsViewDTO);

		EmsRstDTO rst = new EmsRstDTO();
		rst.setDocument(this.handleReturnDocument(emsViewDTO));

		return new EmsRstDTO[] { rst };
	}

	/**
	 * 构建西成药医疗单模型数据对象
	 * 
	 * @param ctx,
	 *            临床就诊上下文
	 * @param id_srv,
	 *            药品服务id
	 * @param id_mm,
	 *            物品id
	 * @return 医疗单模型数据对象
	 * @throws BizException
	 */
	protected ErrorEmsDTO assembleEmsViewInfo(CiEnContextDTO ctx, String id_srv, String id_mm,
			EmsDrugsViewDTO emsViewDTO) throws BizException {
		ErrorEmsDTO err = new ErrorEmsDTO();
		// 获取主服务信息
		MedSrvDO medSrvInfo = BDSrvInfoCache.GetBdSrvInfo(ctx, id_srv);
		// 获取药品属性信息
		MedSrvDrugDO[] srvDrug = ServiceFinder.find(IMedSrvDrugDORService.class)
				.findByAttrValString(MedSrvDrugDO.ID_SRV, id_srv);
		// 获取物品定义信息
		MeterialDO mmInfo = BDMeterialInfoCache.GetMeterialInfo(ctx, id_mm);

		super.orderListViewInfoFrom(ctx, medSrvInfo, null, emsViewDTO);
		emsViewDTO.setDt_effe(OrderEmsDtUtils.GetEffeDateTime(ctx.getId_en(), ctx.getDt_open()));//开始时间赋值
		emsViewDTO.setFg_mm(medSrvInfo.getFg_mm()); // 物品标识
		emsViewDTO.setId_mm(mmInfo.getId_mm());
		emsViewDTO.setName_mm(mmInfo.getName());
		emsViewDTO.setSpec_mm(mmInfo.getSpec());// 规格
		
//		emsViewDTO.setCode_or(
//				CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME));
		emsViewDTO.setCode_or(CiOrdAppUtils.getCiOrdQryService().getCodeOr());
		emsViewDTO.setDes_or(medSrvInfo.getDes()); // 备注
		emsViewDTO.setId_anti(srvDrug[0].getId_anti());// 抗菌药分类ID
		emsViewDTO.setSd_anti(srvDrug[0].getSd_anti());// 抗菌药分类
		emsViewDTO.setFg_anti(srvDrug[0].getFg_anti());// 抗菌药标识
		if (FBoolean.TRUE.equals(srvDrug[0].getFg_anti())) {
			emsViewDTO.setId_antipurpose(ICiDictCodeConst.ID_ANTIPURPOSE_TREATE);// 用药目的:治疗
			emsViewDTO.setSd_antipurpose(ICiDictCodeConst.SD_ANTIPURPOSE_TREATE);// 用药目的:治疗
			emsViewDTO.setName_antipurpose(ICiDictCodeConst.NAME_ANTIPURPOSE_TREATE);// 用药目的:治疗
		}
		emsViewDTO.setId_orsrv(UUID.randomUUID().toString());

		emsViewDTO.setExtend(String.format("%s(%s)", mmInfo.getName(), mmInfo.getSpec()));
		emsViewDTO.setId_mmtp(mmInfo.getId_mmtp());// 物品类型
		

		// 商品名称和通用名称的处理
		String drugMgrMode = BdMmParamUtils.GetDrugMCPropMM();
		if (IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(drugMgrMode)) {
			// 频次赋值，（基础数据配置的频次被停用）
			FreqDefDO freqDefDO = BDFreqInfoCache.GetFreqInfo(mmInfo.getId_freq());
			if (freqDefDO == null) {
				emsViewDTO.setId_freq(null);
				emsViewDTO.setName_freq(null);
				emsViewDTO.setSd_frequnitct(null);
				emsViewDTO.setFreqct(null);
				emsViewDTO.setFg_long(null);
				emsViewDTO.setFg_long_edit(null);
			} else {
				emsViewDTO.setId_freq(freqDefDO.getId_freq());
				emsViewDTO.setName_freq(freqDefDO.getCode());
				emsViewDTO.setSd_frequnitct(freqDefDO.getSd_frequnitct());
				emsViewDTO.setFreqct(freqDefDO.getFreqct());
				emsViewDTO.setFg_long(freqDefDO.getFg_long());// 长临标识
				emsViewDTO.setFg_long_edit(freqDefDO.getFg_long_edit());// 长临标识可编辑标识
			}

			// 剂量
			emsViewDTO.setQuan_med(mmInfo.getQuan_med());
			emsViewDTO.setId_unit_med(mmInfo.getId_unit_med());
			emsViewDTO.setName_unit_med(mmInfo.getUnit_med_name());
			emsViewDTO.setId_medu_cur(emsViewDTO.getId_unit_med());
			emsViewDTO.setName_medu_cur(emsViewDTO.getName_unit_med());
			emsViewDTO.setQuan_medu_cur(emsViewDTO.getQuan_med());
			// 用法
			emsViewDTO.setId_route(mmInfo.getId_route());
			emsViewDTO.setName_route(mmInfo.getRoute_name());

			// 用法要求
			emsViewDTO.setId_routedes(mmInfo.getId_routedes());
			emsViewDTO.setName_routedes(mmInfo.getRoutedes_name());
		}
		
		// 处理特殊场景的频次数据
		handleMtOrderInfo(ctx, emsViewDTO);

		// 计算物品单价
		// emsViewDTO.setPri(OrderEmsPriceUtils.getMaterialPrice(mmInfo.getId_mm(),
		// mmInfo.getId_unit_pkgsp()));
		// emsViewDTO.setFactor_cb(mmInfo.getFactor_sb());
		emsViewDTO.setFactor_mb(mmInfo.getFactor_mb());
		// 当前用户选择剂量初始化
		emsViewDTO.setFactor_cur(mmInfo.getFactor_mb());
		emsViewDTO.setQuan_medu_cur(emsViewDTO.getQuan_med());

		emsViewDTO.setId_unit_base(mmInfo.getId_unit_pkgbase());
		emsViewDTO.setName_unit_base(mmInfo.getName_unit_pkgbase());

		emsViewDTO.setSd_mupkgutp(mmInfo.getSd_mupkgutp());// 取整模式
		emsViewDTO.setSortno_srv(1);//压力测试时，必须有sortno，所以给了1
		
		// 
		
		// 剂量单位集合
		MmDoseUnitMap materUnitMap = BDMmDoseUnitInfoCache.GetMmDoseUnitMap(ctx, new String[] { id_mm });
		if (materUnitMap.size() != 0) {
			FArrayList medunitlist = new FArrayList();
			List<MaterialUnitDTO> tmpUnitList = materUnitMap.get(id_mm);
			medunitlist.addAll(tmpUnitList);
			emsViewDTO.setTotalUnitList(medunitlist);// 包装单位集合
			
		}

		return err;
	}

	@Override
	protected void calcOrderWfDeptInfo(CiEnContextDTO ctx, MedSrvDO medSrv, OrderListViewDTO orderListViewDTO)
			throws BizException {
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, medSrv.getId_srv(), orderListViewDTO.getId_mm(), orderListViewDTO.getId_route(),null,
				orderListViewDTO.getFg_long(),ctx.getFg_pres_outp(),orderListViewDTO.getDt_effe());
		if (!CiOrdUtils.isEmpty(wf)) {

			orderListViewDTO.setId_dep_wh(wf.getId_dept_wh());// 物资仓库ID
			orderListViewDTO.setName_dep_wh(wf.getName_dept_wh());// 物资仓库
			orderListViewDTO.setFilter_dep_wh(wf.getId_dept_whs());// 物资仓库过滤条件

			orderListViewDTO.setId_dep_mp(wf.getFirstid_mp_dept());// 执行科室ID
			orderListViewDTO.setName_dep_mp(wf.getFirstname_mp_dept());// 执行科室
			orderListViewDTO.setFilter_dep_mp("1".equals(wf.getMp_source()) ? null : wf.getId_mp_depts());// 执行科室过滤条件
		}
	}

	/**
	 * 成组药信息合并逻辑
	 * 
	 * @param mainDrugInfo
	 * @param drug
	 */
	protected void mergeOrderGroupInfo(OrderListViewDTO mainDrugInfo, OrderListViewDTO drug) {
		drug.setCode_or(mainDrugInfo.getCode_or());
		drug.setId_or(mainDrugInfo.getId_or());
		drug.setSd_srvtp(mainDrugInfo.getSd_srvtp());
		drug.setId_freq(mainDrugInfo.getId_freq());
		drug.setName_freq(mainDrugInfo.getName_freq());
		drug.setFreqct(mainDrugInfo.getFreqct());
		drug.setSd_frequnitct(mainDrugInfo.getSd_frequnitct());
		drug.setFg_long(mainDrugInfo.getFg_long());
		drug.setFg_long_edit(mainDrugInfo.getFg_long_edit());
		drug.setId_route(mainDrugInfo.getId_route());
		drug.setName_route(mainDrugInfo.getName_route());
		drug.setFilter_route(mainDrugInfo.getFilter_route());
		drug.setSd_su_or(mainDrugInfo.getSd_su_or());
		drug.setDt_effe(mainDrugInfo.getDt_effe());
		drug.setId_emp_or(mainDrugInfo.getId_emp_or());
		drug.setDt_end(mainDrugInfo.getDt_end());
		drug.setName_emp_or(mainDrugInfo.getName_emp_or());
		drug.setId_emp_stop(mainDrugInfo.getId_emp_stop());
		drug.setName_emp_stop(mainDrugInfo.getName_emp_stop());
		drug.setFg_research(mainDrugInfo.getFg_research());
		drug.setId_researchproject(mainDrugInfo.getId_researchproject());
		drug.setCode_researchproject(mainDrugInfo.getCode_researchproject());
		drug.setPassword(mainDrugInfo.getPassword());
		drug.setId_routedes(mainDrugInfo.getId_routedes());
		drug.setName_routedes(mainDrugInfo.getName_routedes());
		drug.setResult(mainDrugInfo.getResult());
		drug.setId_su_or(mainDrugInfo.getId_su_or());
		drug.setName_srvtp(mainDrugInfo.getName_srvtp());
		drug.setId_srvtp(mainDrugInfo.getId_srvtp());
		drug.setId_dep_mp(mainDrugInfo.getId_dep_mp());
		drug.setName_dep_mp(mainDrugInfo.getName_dep_mp());
		drug.setFilter_dep_mp(mainDrugInfo.getFilter_dep_mp());
//		drug.setFg_urgent(mainDrugInfo.getFg_urgent());
//		drug.setFg_urgent_edit(mainDrugInfo.getFg_urgent_edit());
		drug.setFg_pres_outp(mainDrugInfo.getFg_pres_outp());
		drug.setQuan_firday_mp(mainDrugInfo.getQuan_firday_mp());
	}
}
