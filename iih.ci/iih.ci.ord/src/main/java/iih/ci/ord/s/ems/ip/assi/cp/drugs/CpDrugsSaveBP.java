package iih.ci.ord.s.ems.ip.assi.cp.drugs;

import java.util.List;
import java.util.UUID;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.define.MmDoseUnitMap;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.bd.srv.freqdef.d.desc.FreqTimeDODesc;
import iih.bd.srv.freqdef.i.IFreqTimeDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.core.utils.ObjectUtils;
import iih.ci.ord.dws.ip.ems.d.EmsDrugsViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.base.BaseCpSaveBP;
import iih.ci.ord.s.ems.cache.BDMeterialInfoCache;
import iih.ci.ord.s.ems.cache.BDMmDoseUnitInfoCache;
import iih.ci.ord.s.ems.cache.BDSrvInfoCache;
import iih.ci.ord.s.ems.ip.ems.commondrugs.EmsCommonDrugsDriver;
import iih.ci.ord.s.ems.ip.ems.commondrugs.EmsCommonDrugsSaveBP;
import iih.hp.cp.docinfodto.d.DocSrvinfoDTO;
import iih.hp.cp.docinfodto.d.DocinfoDTO;
import iih.hp.cp.ele.d.HpCpElemOrderDO;
import iih.hp.cp.ele.i.IHpCpElemOrderDORService;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 临床路径药品保存逻辑
 *
 *
 */
public class CpDrugsSaveBP extends BaseCpSaveBP {

	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] ems) throws BizException {
		// TODO Auto-generated method stub
		EmsSaveDTO tpl = ems[0];
		FArrayList drugList = tpl.getDocument();
		if (CiOrdUtils.isEmpty(drugList))
			return null;
		DocinfoDTO docinfo = (DocinfoDTO) drugList.get(0);
		FArrayList document = new FArrayList();
		String code_or=CiOrdAppUtils.getCiOrdQryService().getCodeOr();
		FArrayList srvinfoList = docinfo.getRefeleitems();
		int index = 1;
		for (Object object : srvinfoList) {
			DocSrvinfoDTO srv=(DocSrvinfoDTO) object;
			HpCpElemOrderDO[] ords=ServiceFinder.find(IHpCpElemOrderDORService.class).find(" id_ele='"+srv.getId_ele()+"'","",FBoolean.FALSE);
			if(ords!=null&&ords.length>0) {
				// 获取主服务信息
				MedSrvDO medSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(srv.getId_srv());
				// 拼装医疗单ui
				EmsDrugsViewDTO drug = new EmsDrugsViewDTO();
				setEmsViewInfo( ctx,  medSrvInfo, tpl.getDriverInfo(),
						drug,  code_or,  index,  ords[0]);
				drug.setFg_skintest(srv.getFg_skin());
				drug.setDes_or(srv.getDes_or());	
				if(FBoolean.TRUE.equals(drug.getFg_long())){
					drug.setDays_or(docinfo.getDays_or());	
				}
				
				this.setDt_end(ctx, drug);
				document.add(drug);
//				setEmsViewInfo(docinfo, (DocSrvinfoDTO) object, tpl.getDriverInfo(), ctx, document, code_or, index,ords[0]);
				index++;
			}
			
		}
		
		if(document.size()>0) {
			EmsSaveDTO save = super.getEmsSaveDTO(document, tpl.getDriverInfo());
			// 反射调用医疗单加载方法
//		    return ReflClassUtils.ReflCallWith(save.getDriverInfo().getEmsBackendDriver(), "save", ctx, EmsSaveDTO[].class, new EmsSaveDTO[] { save });
			EmsRstDTO[] rst=new EmsCommonDrugsSave4CP().save(ctx, new EmsSaveDTO[] { save });
			return rst;
		}
		
		return null;
		
	}
		
	
	@Override
	protected void setEmsViewInfo(CiEnContextDTO ctx, MedSrvDO medSrvInfo, EmsDriverInfo driverinfo,
			OrderListViewDTO orderListViewDTO, String code_or, int index, HpCpElemOrderDO eleord) throws BizException {
		// TODO Auto-generated method stub
		// 获取药品属性信息
		MedSrvDrugDO[] srvDrug = ServiceFinder.find(IMedSrvDrugDORService.class).findByAttrValString(MedSrvDrugDO.ID_SRV, eleord.getId_srv());
		// 获取物品定义信息
		MeterialDO mmInfo = BDMeterialInfoCache.GetMeterialInfo(ctx, eleord.getId_mm());
		
		EmsDrugsViewDTO drug = (EmsDrugsViewDTO) orderListViewDTO;
		drug.setFg_mm(medSrvInfo.getFg_mm()); // 物品标识
		drug.setId_mm(eleord.getId_mm());

		super.setEmsViewInfo(ctx, medSrvInfo, driverinfo, drug, code_or, index,eleord);

		drug.setDes_or(eleord.getDes_or()); // 备注
		drug.setId_anti(srvDrug[0].getId_anti());// 抗菌药分类ID
		drug.setSd_anti(srvDrug[0].getSd_anti());// 抗菌药分类
		drug.setFg_anti(srvDrug[0].getFg_anti());// 抗菌药标识
		if (FBoolean.TRUE.equals(srvDrug[0].getFg_anti())) {
			drug.setId_antipurpose(ICiDictCodeConst.ID_ANTIPURPOSE_TREATE);
			drug.setSd_antipurpose(ICiDictCodeConst.SD_ANTIPURPOSE_TREATE);
			drug.setName_antipurpose(ICiDictCodeConst.NAME_ANTIPURPOSE_TREATE);
		}
		// 设置高危用药标识
		drug.setFg_highrisk(srvDrug[0].getFg_highrisk());
		drug.setId_orsrv(UUID.randomUUID().toString());
		drug.setName_mm(mmInfo.getName());
		drug.setSpec_mm(mmInfo.getSpec());
		drug.setExtend(String.format("%s(%s)", mmInfo.getName(), mmInfo.getSpec()));
		drug.setId_mmtp(mmInfo.getId_mmtp());// 物品类型

		drug.setFactor_mb(mmInfo.getFactor_mb());
		drug.setFactor_cur(mmInfo.getFactor_mb());

		drug.setId_unit_base(mmInfo.getId_unit_pkgbase());
		drug.setName_unit_base(mmInfo.getName_unit_pkgbase());

		drug.setSd_mupkgutp(mmInfo.getSd_mupkgutp());
		//drug.setFg_skintest(mmInfo.getFg_skin());	
		
		drug.setFg_pres_outp(eleord.getFg_pres_outp());
		drug.setFg_wholepack(eleord.getFg_wholepack());

		drug.setQuan_firday_mp(this.getQuan_firday_mp(drug.getId_freq(), drug.getDt_effe()));
		if(ICiDictCodeConst.SD_DRUG_DELIVERY_METHOD_WHOLE_COLLAR.equals( eleord.getSd_drug_delivery_method())) {
			drug.setFg_long(FBoolean.FALSE);
			
		}else if(ICiDictCodeConst.SD_DRUG_DELIVERY_METHOD_PRES_OUT.equals( eleord.getSd_drug_delivery_method())) {
			drug.setFg_long(FBoolean.FALSE);
			drug.setFg_pres_outp(FBoolean.TRUE);
		}else  if(ICiDictCodeConst.SD_DRUG_DELIVERY_METHOD_PRES_BACK.equals( eleord.getSd_drug_delivery_method())) {
			drug.setFg_long(FBoolean.FALSE);
		}
		if(drug.getFg_pres_outp()!=null&&drug.getFg_pres_outp().booleanValue()) {
			drug.setFg_long(FBoolean.FALSE);
		}
		
		// 计算物资流向科室
		this.setOrWfDeptInfo(ctx, medSrvInfo, drug);
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
		GetStockReqDTO reqDTO = new GetStockReqDTO();
		reqDTO.setId_mm(drug.getId_mm());
		reqDTO.setId_dep(drug.getId_dep_wh());
		reqDTO.setReq_unit_id(drug.getId_unit_cur());
		MaterialStockDTO[] stks= ServiceFinder.find(IMaterialStockService.class).getMaterialStocks(new GetStockReqDTO[] {reqDTO});
		if(stks!=null&&stks.length>0) {
			drug.setPri(stks[0].getPrice_act());
		}
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
