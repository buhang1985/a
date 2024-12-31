package iih.ci.ord.s.ems.ip.assi.tpl.commondrugs;

import java.util.List;
import java.util.UUID;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.define.MmDoseUnitMap;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.bd.srv.freqdef.d.desc.FreqTimeDODesc;
import iih.bd.srv.freqdef.i.IFreqTimeDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.i.IOrtmplMDORService;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsDrugsViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.assi.base.BaseIpTplSaveBP;
import iih.ci.ord.s.ems.cache.BDMeterialInfoCache;
import iih.ci.ord.s.ems.cache.BDMmDoseUnitInfoCache;
import iih.ci.ord.s.ems.cache.BDSrvInfoCache;
import iih.ci.ord.s.ems.utils.ReflClassUtils;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 西成药模板保存
 * @author Young
 *
 */
public class TplDrugsSaveBP extends BaseIpTplSaveBP {
	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] szEms)
			throws BizException {
		EmsSaveDTO tpl = szEms[0];
		FArrayList drugList = tpl.getDocument();
		if (CiOrdUtils.isEmpty(drugList))
			return null;
		OrTplNItmDO ortplnitmdo = (OrTplNItmDO) drugList.get(0);
		OrTmplDO ortmpldo = ServiceFinder.find(IOrtmplMDORService.class).findById(ortplnitmdo.getId_ortmpl());
		FArrayList docmuent = new FArrayList();
//		String code_or = CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME);
		String code_or=CiOrdAppUtils.getCiOrdQryService().getCodeOr();
		if (ortmpldo.getSd_ortmpltp().equals(IBdSrvDictCodeConst.SD_ORTMPLTP_BASE_WEST)) {
			int index = 1;
			for (Object object : drugList) {
				setEmsDrugsInfo(ortmpldo, (OrTplNItmDO) object, tpl.getDriverInfo(), ctx, docmuent, code_or, index);
				index++;
			}
		} else {
			setEmsDrugsInfo(ortmpldo, ortplnitmdo, tpl.getDriverInfo(), ctx, docmuent, code_or, 1);
		}
		EmsSaveDTO save = super.getEmsSaveDTO(docmuent, tpl.getDriverInfo());
		// 反射调用医疗单加载方法
		return ReflClassUtils.ReflCallWith(save.getDriverInfo().getEmsBackendDriver(), "save", ctx, EmsSaveDTO[].class, new EmsSaveDTO[] { save });
	}

	private void setEmsDrugsInfo(OrTmplDO ortmpldo, OrTplNItmDO ortplnitmdo, EmsDriverInfo driverinfo, CiEnContextDTO ctx, FArrayList docmuent, String code_or, int index)
			throws BizException {
		// 获取主服务信息
		MedSrvDO medSrvInfo = BDSrvInfoCache.GetBdSrvInfo(ctx, ortplnitmdo.getId_srv());// ServiceFinder.find(IMedsrvMDORService.class).findById(ortplnitmdo.getId_srv());
		// 拼装医疗单ui
		EmsDrugsViewDTO drug = new EmsDrugsViewDTO();
		this.setEmsViewInfo(ctx, ortmpldo, ortplnitmdo, medSrvInfo, driverinfo, drug, code_or, index);
		docmuent.append(drug);
	}
	
	@Override
	protected void setEmsViewInfo(CiEnContextDTO ctx, OrTmplDO ortmpldo, OrTplNItmDO ortplnitmdo, MedSrvDO medSrvInfo, 
			EmsDriverInfo driverinfo, OrderListViewDTO orderListViewDTO, String code_or, int index) throws BizException {
		// 获取药品属性信息
		MedSrvDrugDO[] srvDrug = ServiceFinder.find(IMedSrvDrugDORService.class).findByAttrValString(MedSrvDrugDO.ID_SRV, ortplnitmdo.getId_srv());
		// 获取物品定义信息
		MeterialDO mmInfo = BDMeterialInfoCache.GetMeterialInfo(ctx, ortplnitmdo.getId_mm());
		
		EmsDrugsViewDTO drug = (EmsDrugsViewDTO) orderListViewDTO;
		drug.setFg_mm(medSrvInfo.getFg_mm()); // 物品标识
		drug.setId_mm(ortplnitmdo.getId_mm());

		super.setEmsViewInfo(ctx, ortmpldo, ortplnitmdo, medSrvInfo, driverinfo, drug, code_or, index);

		drug.setDes_or(ortplnitmdo.getDes_or()); // 备注
		drug.setId_anti(srvDrug[0].getId_anti());// 抗菌药分类ID
		drug.setSd_anti(srvDrug[0].getSd_anti());// 抗菌药分类
		drug.setFg_anti(srvDrug[0].getFg_anti());// 抗菌药标识
		if (FBoolean.TRUE.equals(srvDrug[0].getFg_anti())) {
			drug.setId_antipurpose(ICiDictCodeConst.ID_ANTIPURPOSE_TREATE);
			drug.setSd_antipurpose(ICiDictCodeConst.SD_ANTIPURPOSE_TREATE);
			drug.setName_antipurpose(ICiDictCodeConst.NAME_ANTIPURPOSE_TREATE);
		}
		drug.setId_orsrv(UUID.randomUUID().toString());
		drug.setName_mm(mmInfo.getName());
		drug.setSpec_mm(mmInfo.getSpec());
		drug.setExtend(String.format("%s(%s)", mmInfo.getName(), mmInfo.getSpec()));
		drug.setId_mmtp(mmInfo.getId_mmtp());// 物品类型
		
		// 商品名称和通用名称的处理
//		String drugMgrMode = BdMmParamUtils.GetDrugMCPropMM();
//		if (IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(drugMgrMode)) {
//			// 剂量
//			if (ortplnitmdo.getId_unit_med() == null) {
//				drug.setQuan_med(mmInfo.getQuan_med());
//				drug.setId_unit_med(mmInfo.getId_unit_med());
//				drug.setName_unit_med(mmInfo.getUnit_med_name());
//			}
//
//			// 用法
//			if (ortplnitmdo.getId_route() == null) {
//				drug.setId_route(mmInfo.getId_route());
//				drug.setName_route(mmInfo.getRoute_name());
//			}
//
//			// 用法要求
//			if (ortplnitmdo.getId_routedes() == null) {
//				drug.setId_routedes(mmInfo.getId_routedes());
//				drug.setName_routedes(mmInfo.getRoutedes_name());
//			}
//
//			if (ortplnitmdo.getId_freq() == null) {
//				// 频次赋值，（基础数据配置的频次被停用）
//				FreqDefDO freqDefDO = BDFreqInfoCache.GetFreqInfo(mmInfo.getId_freq());
//				if (freqDefDO == null) {
//					drug.setId_freq(null);
//					drug.setName_freq(null);
//					drug.setSd_frequnitct(null);
//					drug.setFreqct(null);
//					drug.setFg_long(null);
//					drug.setFg_long_edit(null);
//				} else {
//					drug.setId_freq(freqDefDO.getId_freq());
//					drug.setName_freq(freqDefDO.getCode());
//					drug.setSd_frequnitct(freqDefDO.getSd_frequnitct());
//					drug.setFreqct(freqDefDO.getFreqct());
//					drug.setFg_long(freqDefDO.getFg_long());// 长临标识
//					drug.setFg_long_edit(freqDefDO.getFg_long_edit());// 长临标识可编辑标识
//				}
//			}
//		}
		
		drug.setFactor_mb(mmInfo.getFactor_mb());
		drug.setFactor_cur(mmInfo.getFactor_mb());

		drug.setId_unit_base(mmInfo.getId_unit_pkgbase());
		drug.setName_unit_base(mmInfo.getName_unit_pkgbase());

		drug.setSd_mupkgutp(mmInfo.getSd_mupkgutp());
		
		// 剂量单位集合
		MmDoseUnitMap materUnitMap = BDMmDoseUnitInfoCache.GetMmDoseUnitMap(ctx, new String[] { mmInfo.getId_mm() });
		if (materUnitMap.size() != 0) {
			FArrayList medunitlist = new FArrayList();
			List<MaterialUnitDTO> tmpUnitList = materUnitMap.get(mmInfo.getId_mm());
			medunitlist.addAll(tmpUnitList);
			drug.setTotalUnitList(medunitlist);//包装单位集合
			drug.setId_unit_cur(tmpUnitList.get(0).getId_measdoc());//总量单位
			drug.setName_unit_cur(tmpUnitList.get(0).getMeasdoc_name());//总量单位名称
			drug.setFactor_cb(tmpUnitList.get(0).getFactor());//基本包装单位和总量单位的换算系数
			drug.setPri(tmpUnitList.get(0).getPrice());//单价
		}
		drug.setQuan_firday_mp(this.getQuan_firday_mp(drug.getId_freq(), drug.getDt_effe()));
		
		// 计算物资流向科室
		this.setOrWfDeptInfo(ctx, medSrvInfo, drug);
	}

	/**
	 * 获取首日执行次数
	 * 
	 * @param id_freq
	 * @param dt_entry
	 * @return
	 * @throws BizException
	 */
	private Integer getQuan_firday_mp(String id_freq, FDateTime dt_entry)
			throws BizException {
		if (StringUtils.isNullOrEmpty(id_freq) || dt_entry == null) {
			return 0;
		}
		FTime[] exctimes = getFreqTime(id_freq);
		Integer quan = 1;
		for (int i = 0; i < exctimes.length; i++) {
			if (exctimes[i].after(new FTime(dt_entry.getTime()))) {
				quan++;
			}
		}
		return quan;
	}

	/**
	 * 获取频次执行时刻
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	private FTime[] getFreqTime(String id_freq) throws BizException {
		FreqTimeDO[] freqTimeDOs = ServiceFinder.find(IFreqTimeDORService.class).find(
						FreqTimeDODesc.TABLE_ALIAS_NAME + ".Id_freq='" + id_freq + "'",
						FreqTimeDODesc.TABLE_ALIAS_NAME + ".Sortno", FBoolean.FALSE);
		if (freqTimeDOs != null && freqTimeDOs.length > 0) {
			FTime[] times = new FTime[freqTimeDOs.length];
			for (int i = 0; i < freqTimeDOs.length; i++) {
				times[i] = freqTimeDOs[i].getTime_mp();
			}
			return times;
		}
		return new FTime[] {};
	}
}
