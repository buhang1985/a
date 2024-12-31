package iih.mc.common.bp;

import iih.bd.bc.udi.pub.IMmDictCodeConst;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.bd.mm.stockdealtype.d.StockDealTypeDO;
import iih.bd.mm.stockdealtype.i.IStockdealtypeRService;
import iih.bd.mm.wahouseunittype.d.WahouseUnitTypeDO;
import iih.bd.mm.wahouseunittype.i.IWahouseunittypeService;
import iih.mm.comm.i.IUdiHelperService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.xbd.udi.d.UdidocDO;

public class GetCommonInfo {
	
	public static PsnDocDO getPsnDocInfo() throws BizException {
		
		IPsndocMDORService psnRSrv = ServiceFinder.find(IPsndocMDORService.class);
		
		PsnDocDO psndocDO = psnRSrv.findById(Context.get().getStuffId());
		if(psndocDO == null) {
			
			throw new BizException("获取人员信息失败。");
		}
		
		return psndocDO;
	}
	
	public static DeptDO getDeptInfo() throws BizException {
		
		IDeptRService depRSrv = ServiceFinder.find(IDeptRService.class);
		
		DeptDO deptDO = depRSrv.findById(Context.get().getDeptId());
		if(deptDO == null) {
			
			throw new BizException("获取部门信息失败。");
		}
		
		return deptDO;
	}
	
	public static UdidocDO getUdidocInfo(String udi_type, String udi_code) throws BizException {
		
		IUdiHelperService udiHelperService = ServiceFinder.find(IUdiHelperService.class);
		UdidocDO udidocDO = udiHelperService.getUdidocByCode(Context.get().getOrgId(), udi_type, udi_code);
		if(udidocDO == null) {
			
			throw new BizException("获取自定义档案失败。");
		}
		
		return udidocDO;
	}
	
	public static StockDealTypeDO getStockDealType(String code) throws BizException {
		
		IStockdealtypeRService stockDealTypeRService = ServiceFinder.find(IStockdealtypeRService.class);
		StockDealTypeDO[] stockDealTypeDOs = stockDealTypeRService.findByAttrValString(StockDealTypeDO.CODE, code);
		if(stockDealTypeDOs == null || stockDealTypeDOs.length <= 0) {
			
			throw new BizException("获取库存交易分类失败。");
		}
		
		return stockDealTypeDOs[0];
	}
	
	public static MMPackageUnitDO getMmDefpkgByWh(String id_wh, String id_mm) throws BizException {
		
		IMeterialService meterialService = ServiceFinder.find(IMeterialService.class);
		IWahouseunittypeService whpkgtpSrv = ServiceFinder.find(IWahouseunittypeService.class);
		
		WahouseUnitTypeDO pkgTpInfo = whpkgtpSrv.getWhDefPkgUnitTp(new String[] { id_wh }).get(id_wh);
		MMPackageUnitDO unitPkgInfo = meterialService.findPackUnitByType(pkgTpInfo.getId_mmpkgutp(), id_mm);
		if(unitPkgInfo == null) {
			unitPkgInfo = meterialService.findSalePackageUnit(id_mm);
		}
		return unitPkgInfo;
	}
	
	public static <T extends BaseDO> void setMmRelProperties(T baseDO) throws BizException {
		
		IMeterialService meterialService = ServiceFinder.find(IMeterialService.class);
		
		MeterialDO mmDO = meterialService.findMaterialByID(baseDO.getAttrVal("Id_mm").toString());
		MMPackageUnitDO actualPkgDO = meterialService.findPackageUnitById(baseDO.getAttrVal("Id_mmpkgu_actual").toString());
		
		//物品名称
		baseDO.setAttrVal("Mm_name", mmDO.getName());
		//物品编码
		baseDO.setAttrVal("Mm_code", mmDO.getCode());
		//物品规格
		baseDO.setAttrVal("Mm_spec", mmDO.getSpec());
		//生产厂家
		baseDO.setAttrVal("Factory_name", mmDO.getFactory_name());
		//包装单位名称
		baseDO.setAttrVal("Mmpkguname", actualPkgDO.getMmpkguname());
		//批次管理标识
		baseDO.setAttrVal("Fg_batch", mmDO.getFg_batch());
	}
}
