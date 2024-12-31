package iih.bd.mm.warehouseinfo.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.bd.mm.warehouseinfo.i.IWarehouseinfoCudService;
import iih.bd.mm.warehouseinfo.i.IWarehouseinfoRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class InitWhmmByMmcaBp {
	
	public void exec(MMCategoryDO[] mmCategoryList, WarehouseInfoDO wareHouseInfoDO, String pkgTypeID) throws BizException {
		
		// ■ 参数校验
		this.validaPara(mmCategoryList);
		
		// ■ 根据所选物品基本分类创建仓库物品关系
		this.initWareHouseInfo(mmCategoryList, wareHouseInfoDO, pkgTypeID);
	}

	private void validaPara(MMCategoryDO[] mmCategoryList) throws BizException {
		
		if(mmCategoryList == null || mmCategoryList.length <= 0) {
			
			throw new BizException("传入物品基本分类信息为空。");
		}
	}
	
	private void initWareHouseInfo(MMCategoryDO[] mmCategoryList, WarehouseInfoDO wareHouseInfoDO, 
			String pkgTypeID) throws BizException {
		
		//根据物品基本分类获取物品基本信息
		MeterialDO[] mmDOS = this.getMmDOList(mmCategoryList);
		
		//获取仓库物品关系
		Map<String, WarehouseInfoDO> whMmMap = this.getWhMmMap(wareHouseInfoDO);
		
		//根据所选物品基本分类创建仓库物品关系
		this.initWareHouseInfo(mmDOS, whMmMap, wareHouseInfoDO, pkgTypeID);
	}

	private MeterialDO[] getMmDOList(MMCategoryDO[] mmCategoryList) throws BizException {
		
		IMeterialMDORService mmRSrv = ServiceFinder.find(IMeterialMDORService.class);
		
		String[] mmcaIdList = this.getMmcaIDList(mmCategoryList);
		MeterialDO[] mmDOS = mmRSrv.findByAttrValStrings(MeterialDO.ID_MMCA, mmcaIdList);
		if(mmDOS == null || mmDOS.length <= 0) {
			
			throw new BizException("获取物品基本信息失败。");
		}
		
		return mmDOS;
	}

	private String[] getMmcaIDList(MMCategoryDO[] mmCategoryList) {
		
		List<String> mmcaIdList = new ArrayList<String>();
		for(MMCategoryDO mmcaDO : mmCategoryList) {
			
			mmcaIdList.add(mmcaDO.getId_mmca());
		}
		
		return mmcaIdList.toArray(new String[mmcaIdList.size()]);
	}
	
	private Map<String, WarehouseInfoDO> getWhMmMap(WarehouseInfoDO wareHouseInfoDO) throws BizException {
		
		IWarehouseinfoRService whmmRSrv = ServiceFinder.find(IWarehouseinfoRService.class);
		
		Map<String, WarehouseInfoDO> result = new HashMap<String, WarehouseInfoDO>();
		String whrStr = String.format("id_wh = '%s'", wareHouseInfoDO.getId_wh());
		WarehouseInfoDO[] whMmDOS = whmmRSrv.find(whrStr, "", FBoolean.TRUE);
		if(whMmDOS == null || whMmDOS.length <= 0) {
			
			return result;
		}
		
		for(WarehouseInfoDO whMmDO : whMmDOS) {
			
			result.put(whMmDO.getId_mm(), whMmDO);
		}
		
		return result;
	}
	
	private void initWareHouseInfo(MeterialDO[] mmDOS, Map<String, WarehouseInfoDO> whMmMap,
			WarehouseInfoDO wareHouseInfoDO, String pkgTypeID) throws BizException {
		
		IMeterialService meterialService = ServiceFinder.find(IMeterialService.class);
		
		List<WarehouseInfoDO> wareHouseInfoList = new ArrayList<WarehouseInfoDO>();
		for(MeterialDO mmDO : mmDOS) {
			
			if(whMmMap.containsKey(mmDO.getId_mm())) {
				
				continue;
			}
			
			WarehouseInfoDO whMmDO = new WarehouseInfoDO();
			whMmDO.setStatus(DOStatus.NEW);
			//集团
			whMmDO.setId_grp(Context.get().getGroupId());
			//机构
			whMmDO.setId_org(Context.get().getOrgId());
			//仓库
			whMmDO.setId_wh(wareHouseInfoDO.getId_wh());
			//仓库名称
			whMmDO.setWh_name(wareHouseInfoDO.getWh_name());
			//是否按货位
			whMmDO.setFg_loc(wareHouseInfoDO.getFg_loc());
			//医疗物品
			whMmDO.setId_mm(mmDO.getId_mm());
			//物品编码
			whMmDO.setMm_code(mmDO.getCode());
			//物品名称
			whMmDO.setMm_name(mmDO.getName());
			//物品规格
			whMmDO.setMm_spec(mmDO.getSpec());
			//最高库存_界面包装单位
			whMmDO.setMaxuinum(wareHouseInfoDO.getMaxuinum());
			//最低库存_界面包装单位
			whMmDO.setLowuinum(wareHouseInfoDO.getLowuinum());
			//界面包装单位
			MMPackageUnitDO mmPackageUnitDO = meterialService.findPackUnitByType(pkgTypeID, mmDO.getId_mm());
			whMmDO.setId_mmpkgu_ui(mmPackageUnitDO.getId_mmpkgu());
			//界面包装单位名称
			whMmDO.setMmpkguname(mmPackageUnitDO.getMmpkguname());
			//响应仓库
			whMmDO.setId_wh_srv(wareHouseInfoDO.getId_wh_srv());
			//启用状态
			whMmDO.setFg_active(new FBoolean(true));
			//停发标志
			whMmDO.setFg_out(new FBoolean(false));
			
			wareHouseInfoList.add(whMmDO);
		}
		
		if(wareHouseInfoList != null && wareHouseInfoList.size() > 0) {
			
			IWarehouseinfoCudService whMmCudSrv = ServiceFinder.find(IWarehouseinfoCudService.class);
			whMmCudSrv.insert(wareHouseInfoList.toArray(new WarehouseInfoDO[wareHouseInfoList.size()]));
		}
	}
}
