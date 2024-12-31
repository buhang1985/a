package iih.ci.ord.s.ems.ip.ems.commondrugs;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.define.MmDoseUnitMap;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dws.ip.ems.d.EmsDrugsViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsLoadBP;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.cache.BDDosageInfoCache;
import iih.ci.ord.s.ems.cache.BDMmDoseUnitInfoCache;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 加载医疗单
 * 
 * @author wangqingzhu
 *
 */
public class EmsCommonDrugsLoadBP extends BaseIpEmsLoadBP {
	@SuppressWarnings("unchecked")
	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) 
			throws BizException {
		EmsRstDTO[] rsts = super.load(ctx, args);
		EmsRstDTO rst = rsts[0];
		EmsLoadDTO arg = args[0];
		// 错误信息集合
		FArrayList errorlist = new FArrayList();
		// 获取医疗单 DTO对象结构
		OrderPackageInfo[] szOrderPackageInfo = orderPakageInfoArrayFrom(new String[] { arg.getId_or() });
		if (CiOrdUtils.isEmpty(szOrderPackageInfo)) {
			errorlist.append("获取医疗单信息失败");
			OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
			return rsts;
		}
		OrderPackageInfo opInfo = szOrderPackageInfo[0];
		List<OrderListViewDTO> emsdruglist = emsViewModelFrom(ctx, opInfo, arg.getDriverInfo());

		if (CiOrdUtils.isEmpty(emsdruglist)) {
			errorlist.append("获取医疗单信息失败");
			OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
			return rsts;
		}

		// 医疗单模型文档
		rst.setDocument(new FArrayList());
		rst.getDocument().addAll(emsdruglist);
		
		return rsts;
	}

	/**
	 * 构建药品主信息 -- 同 药品
	 * 
	 * @param emsdrugsviewdto
	 * @param dto
	 * @throws BizException
	 */
	protected List<OrderListViewDTO> emsViewModelFrom(CiEnContextDTO ctx, OrderPackageInfo opInfo, EmsDriverInfo driverInfo)
			throws BizException {
		List<OrderListViewDTO> emsdruglist = new ArrayList<OrderListViewDTO>();
		if (!CiOrdUtils.isEmpty(opInfo.getOrderSrvMmList())) {
			for (Object obj : opInfo.getOrderSrvMmList()) {
				OrdSrvDO ordSrvDO = ((OrderSrvMmInfo) obj).getOrderSrvInfo();
				// 临床项目
				if (CiOrdUtils.isTrue(ordSrvDO.getFg_or()) && OrSrvSourceFromEnum.PHYSIAN.equals(ordSrvDO.getEu_sourcemd())) {
					EmsDrugsViewDTO drug = new EmsDrugsViewDTO();
					this.emsViewInfoFrom(drug, ctx, opInfo, (OrderSrvMmInfo) obj, driverInfo);
					emsdruglist.add(drug);
				}
			}
		}

		return emsdruglist;
	}

	protected void emsViewInfoFrom(EmsDrugsViewDTO drug, CiEnContextDTO ctx, OrderPackageInfo opInfo, OrderSrvMmInfo ordSrvMmInfo, EmsDriverInfo driverInfo) 
			throws BizException{
		OrdSrvDO ordSrvDO = ordSrvMmInfo.getOrderSrvInfo();
		OrdSrvMmDO srvMmDO = ordSrvMmInfo.getOrderSrvMmInfo();
		
		drug.setId_mm(srvMmDO.getId_mm());
		
		super.orderListViewInfoFrom(ctx, opInfo.getMainBdSrvInfo(), opInfo.getOrderInfo(), ordSrvDO, drug);
		
		drug.setDes_or(opInfo.getOrderInfo().getDes_or());// 医嘱描述
		
		if(!CiOrdUtils.isEmpty(srvMmDO)){
			drug.setSpec_mm(srvMmDO.getSpec());
			drug.setName_mm(ordSrvDO.getName_srv());
			drug.setQuan_cur(srvMmDO.getQuan_cur());
			drug.setId_unit_cur(srvMmDO.getId_pgku_cur());
			if(StringUtils.isNotEmpty(drug.getId_mm())){
				// 包装单位集合
				MmDoseUnitMap materUnitMap = BDMmDoseUnitInfoCache.GetMmDoseUnitMap(ctx, new String[] { drug.getId_mm() });
				if (materUnitMap.size() != 0) {
					FArrayList medunitlist = new FArrayList();
					List<MaterialUnitDTO> tmpUnitList = materUnitMap.get(drug.getId_mm());
					medunitlist.addAll(tmpUnitList);
					drug.setTotalUnitList(medunitlist);
					for (MaterialUnitDTO medunit : tmpUnitList) {
						if(medunit.getId_measdoc().equals(drug.getId_unit_cur())){
							drug.setName_unit_cur(medunit.getMeasdoc_name());
						}
					}
					
				}
			}
			
			drug.setFactor_cb(srvMmDO.getFactor());
			drug.setFactor_mb(srvMmDO.getFactor_mb());
			drug.setId_unit_base(srvMmDO.getId_pgku_base());
			drug.setName_unit_base(srvMmDO.getName_pgku_base());
			drug.setId_medu_cur(srvMmDO.getId_medu_cur());
			drug.setName_medu_cur(srvMmDO.getName_unit_cur());
			drug.setQuan_medu_cur(srvMmDO.getQuan_medu_cur());	
			drug.setId_anti(srvMmDO.getId_anti());//抗菌药分类ID
			drug.setSd_anti(srvMmDO.getSd_anti());//抗菌药分类
			drug.setFg_anti(new FBoolean(!IBdSrvDictCodeConst.SD_ANTI_NONANTIBACTERIAL.equals(srvMmDO.getSd_anti())));//抗菌药标识
			drug.setId_antipurpose(ordSrvDO.getId_antipurpose());//用药目的ID
			drug.setSd_antipurpose(ordSrvDO.getSd_antipurpose());//用药目的编码
			drug.setName_antipurpose(ordSrvDO.getName_antipurpose());//用药目的
			drug.setId_prepurpose(ordSrvDO.getId_prepurpose());//预防用药目的ID
			drug.setSd_prepurpose(ordSrvDO.getSd_prepurpose());//预防用药目的编码
			drug.setName_prepurpose(ordSrvDO.getName_prepurpose());//预防用药目的
			drug.setId_preincitp(ordSrvDO.getId_preincitp());//手术预防用切口等级ID
			drug.setSd_preincitp(ordSrvDO.getSd_preincitp());//手术预防用切口等级编码
			drug.setName_preincitp(ordSrvDO.getName_preincitp());//手术预防用切口等级
			drug.setId_predrugreason(ordSrvDO.getId_predrugreason());//用药原因ID
			drug.setSd_predrugreason(ordSrvDO.getSd_predrugreason());//用药原因编码
			drug.setName_predrugreason(ordSrvDO.getName_predrugreason());//用药原因
			drug.setId_pois(srvMmDO.getId_pois());
			drug.setSd_pois(srvMmDO.getSd_pois());
			drug.setFg_pois(new FBoolean(!StringUtils.isEmpty(srvMmDO.getSd_pois())));
			drug.setSd_mupkgutp(srvMmDO.getSd_mupkgutp());
			drug.setFg_deliveryroom_use(opInfo.getOrderInfo().getFg_deliveryroom_use());//产房用药
			drug.setIdsrvIdmm(ordSrvDO.getId_srv()+srvMmDO.getId_mm()+drug.getId_unit_cur());
			
			
		}
		// 医疗单驱动
		this.setEmsDriverInfo(driverInfo, drug);
	}
}
