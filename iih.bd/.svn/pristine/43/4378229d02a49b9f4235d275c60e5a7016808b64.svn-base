package iih.bd.mm.warehouseinfo.bp;

import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.bd.mm.warehouseinfo.i.IWarehouseinfoCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class UpdateWhmmBp {
	
	public WarehouseInfoDO[] Disable(WarehouseInfoDO[] wareHouseInfoList) throws BizException {
		
		// ■ 参数校验
		this.validaPara(wareHouseInfoList);
		
		// ■ 验证数据是否允许停用
		//this.checkCanDisable(wareHouseInfoList);
		
		// ■ 数据停用
		return this.disable(wareHouseInfoList);
	}

	private void validaPara(WarehouseInfoDO[] wareHouseInfoList) throws BizException {
		
		if(wareHouseInfoList == null || wareHouseInfoList.length <= 0) {
			
			throw new BizException("传入仓库物品关系数据为空。");
		}
	}
	
//	private void checkCanDisable(WarehouseInfoDO[] wareHouseInfoList) throws BizException {
//		
//		IStockblRService blRSrv = ServiceFinder.find(IStockblRService.class);
//		
//		Map<String, Map<String, StockBlDO>> blDOMap = new HashMap<String, Map<String, StockBlDO>>();
//		String whCondition = this.getWhCondition(wareHouseInfoList);
//		String mmCondition = this.getMmCondition(wareHouseInfoList);		
//		if(StringUtils.isBlank(whCondition)) {
//			
//			return;
//		}
//		
//		//物品结存数据获取
//		String whrStr = String.format("%s and %s", whCondition, mmCondition);
//		StockBlDO[] blDOS = blRSrv.find(whrStr, "", FBoolean.TRUE);
//		if(blDOS == null || blDOS.length <= 0) {
//			
//			return;
//		}
//		for(StockBlDO blDO : blDOS) {
//			
//			if(blDOMap.containsKey(blDO.getId_wh())) {
//				
//				Map<String, StockBlDO> mmBlMap = blDOMap.get(blDO.getId_wh());
//				mmBlMap.put(blDO.getId_mm(), blDO);
//			} else {
//				
//				Map<String, StockBlDO> mmBlMap = new HashMap<String, StockBlDO>();
//				mmBlMap.put(blDO.getId_mm(), blDO);
//				blDOMap.put(blDO.getId_wh(), mmBlMap);
//			}
//		}
//		
//		for(WarehouseInfoDO whMmDO : wareHouseInfoList) {
//			
//			if(!StringUtils.isBlank(whMmDO.getId_wh()) && blDOMap.containsKey(whMmDO.getId_wh()) && 
//					blDOMap.get(whMmDO.getId_wh()).containsKey(whMmDO.getId_mm())) {
//				
//				throw new BizException(String.format("物品【%s】在仓库【%s】下存在结存数据，不允许停用。", whMmDO.getMm_name(), whMmDO.getWh_name()));
//			}
//		}
//	}

//	private String getWhCondition(WarehouseInfoDO[] wareHouseInfoList) {
//		
//		List<String> whIdList = new ArrayList<String>();
//		for(WarehouseInfoDO whMmDO : wareHouseInfoList) {
//			
//			if(!StringUtils.isBlank(whMmDO.getId_wh())) {
//				
//				whIdList.add(whMmDO.getId_wh());
//			}
//		}
//		
//		return MmSQLHelper.initInCondition(StockBlDO.ID_WH, whIdList.toArray(new String[whIdList.size()]));
//	}
//	
//	private String getMmCondition(WarehouseInfoDO[] wareHouseInfoList) {
//		
//		List<String> mmIdList = new ArrayList<String>();
//		for(WarehouseInfoDO whMmDO : wareHouseInfoList) {
//			
//			mmIdList.add(whMmDO.getId_mm());
//		}
//		
//		return MmSQLHelper.initInCondition(StockBlDO.ID_MM, mmIdList.toArray(new String[mmIdList.size()]));
//	}

	private WarehouseInfoDO[] disable(WarehouseInfoDO[] wareHouseInfoList) throws BizException {
		
		for(WarehouseInfoDO whMmDO : wareHouseInfoList) {
			
			whMmDO.setStatus(DOStatus.UPDATED);
			//停用
			whMmDO.setFg_active(FBoolean.FALSE);
		}
		
		IWarehouseinfoCudService whMmCudSrv = ServiceFinder.find(IWarehouseinfoCudService.class);
		return whMmCudSrv.update(wareHouseInfoList);
	}
}
