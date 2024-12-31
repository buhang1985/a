package iih.bd.mm.wahouseunittype.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.mm.common.MmSQLHelper;
import iih.bd.mm.wahouseunittype.d.WahouseUnitTypeDO;
import iih.bd.mm.wahouseunittype.i.IWahouseunittypeRService;
import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.i.IWarehouseService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class WhUnitTypeBp {
	
	public WahouseUnitTypeDO[] initWhUnitType() throws BizException {
		
		//获取权限仓库
		IWarehouseService whSrv = ServiceFinder.find(IWarehouseService.class);
		WarehouseDO[] whDOList = whSrv.getLimitsWarehouse();
		if(whDOList == null || whDOList.length <= 0) {
			
			return null;
		}
		
		List<WahouseUnitTypeDO> whUnitTypeList = new ArrayList<WahouseUnitTypeDO>();
		for(WarehouseDO whDO : whDOList) {
			
			WahouseUnitTypeDO whUnitTypeDO = new WahouseUnitTypeDO();
			whUnitTypeDO.setStatus(DOStatus.NEW);
			//集团
			whUnitTypeDO.setId_grp(Context.get().getGroupId());
			//机构
			whUnitTypeDO.setId_org(Context.get().getOrgId());
			//仓库
			whUnitTypeDO.setId_wh(whDO.getId_wh());
			whUnitTypeDO.setWh_name(whDO.getWh_name());
			
			whUnitTypeList.add(whUnitTypeDO);
		}
		
		return whUnitTypeList.toArray(new WahouseUnitTypeDO[whUnitTypeList.size()]);
	}
	
    public void checkBeforeSave(WahouseUnitTypeDO[] whUnitTypeDOS) throws BizException {
		
		// ■ 参数校验
		this.validaPara(whUnitTypeDOS);
		
		// ■ 校验是否有仓库没有设定包装单位类型
		this.check(whUnitTypeDOS);
	}

	private void validaPara(WahouseUnitTypeDO[] whUnitTypeDOS) throws BizException {
		
		if(whUnitTypeDOS == null || whUnitTypeDOS.length <= 0) {
			
			throw new BizException("传入数据为空。");
		}
	}
	
	private void check(WahouseUnitTypeDO[] whUnitTypeDOS) throws BizException {
		
		//获取权限仓库
		IWarehouseService whSrv = ServiceFinder.find(IWarehouseService.class);
		WarehouseDO[] whDOList = whSrv.getLimitsWarehouse();
		
		Map<String, WahouseUnitTypeDO> whUnitMap = new HashMap<String, WahouseUnitTypeDO>();
		for(WahouseUnitTypeDO whUnitTypeDO : whUnitTypeDOS) {
			
			if(whUnitTypeDO.getStatus() == DOStatus.DELETED) {
				
				continue;
			}
			
			whUnitMap.put(whUnitTypeDO.getId_wh(), whUnitTypeDO);
		}
		
		for(WarehouseDO whDO : whDOList) {
			
			if(!whUnitMap.containsKey(whDO.getId_wh())) {
				
				throw new BizException(String.format("仓库【%s】没有设置包装单位类型。", whDO.getName()));
			}
		}
	}
	
	public Map<String, WahouseUnitTypeDO> getWhDefPkgUnitTp(String[] id_whs) throws BizException {
		
		Map<String, WahouseUnitTypeDO> result = new HashMap<String, WahouseUnitTypeDO>();
		
		IWahouseunittypeRService unitTypeSrv = ServiceFinder.find(IWahouseunittypeRService.class);
		String whCondition = MmSQLHelper.initInCondition(WahouseUnitTypeDO.ID_WH, id_whs);
		String whrStr = String.format("%s and fg_def = 'Y'", whCondition);
		WahouseUnitTypeDO[] whUnitTps = unitTypeSrv.find(whrStr, "", FBoolean.TRUE);
		if(whUnitTps == null || whUnitTps.length <= 0) {
			
			throw new BizException("仓库未设置默认包装单位类型。");
		}
		
		for(WahouseUnitTypeDO whUnitTpDO : whUnitTps) {
			
			result.put(whUnitTpDO.getId_wh(), whUnitTpDO);
		}
		
		for(String id_wh : id_whs) {
			
			if(!result.containsKey(id_wh)) {
				
				throw new BizException("仓库未设置默认包装单位类型。");
			}
		}
		
		return result;
	}
}
