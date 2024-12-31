package iih.bd.mm.warehouseinfo.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.bd.mm.stockvaluecaldto.d.StockValueCalDTO;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.bd.mm.warehouseinfo.i.IWarehouseinfoCudService;
import iih.bd.mm.warehouseinfo.i.IWarehouseinfoRService;
import iih.mm.common.MMParams;
import iih.mm.common.qry.GetStockNumValueSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class CalStockNumValueBp {
	
	public void exec(String[] id_whs, String[] id_mms) throws BizException {
		//最低储值计算
		Map<String, Map<String, StockValueCalDTO>> stockLowValueMap = this.getNumValueMap(id_whs, id_mms, MMParams.MMDG0004());
		if(stockLowValueMap.size() <= 0)
			return;
		//最高储值计算
		Map<String, Map<String, StockValueCalDTO>> stockHighValueMap = this.getNumValueMap(id_whs, id_mms, MMParams.MMDG0005());
	    //仓库物品关系获取
		IWarehouseinfoRService wareHouseSrv = ServiceFinder.find(IWarehouseinfoRService.class);
		IWarehouseinfoCudService wareHouseCudSrv = ServiceFinder.find(IWarehouseinfoCudService.class);
		WarehouseInfoDO[] wareHouseDOS = null;
		if(id_mms == null || id_mms.length <= 0) {
			wareHouseDOS = wareHouseSrv.findByAttrValStrings(WarehouseInfoDO.ID_WH, id_whs);
		} else {
			String whrStr = String.format("id_wh = '%s' and %s", id_whs[0], SqlUtils.getInSqlByIds(WarehouseInfoDO.ID_MM, id_mms));
			wareHouseDOS = wareHouseSrv.find(whrStr, "", FBoolean.TRUE);
		}
		if(wareHouseDOS == null || wareHouseDOS.length <= 0) 
			return;
		//更新仓库物品关系高低储值
		List<WarehouseInfoDO> updateList = new ArrayList<WarehouseInfoDO>();
		for(WarehouseInfoDO wareHouseDO : wareHouseDOS) {
			//最低储值设置
			this.setNumValue(wareHouseDO, stockLowValueMap, FBoolean.FALSE, updateList);
			//最高储值设置
			this.setNumValue(wareHouseDO, stockHighValueMap, FBoolean.TRUE, updateList);
		}
		if(updateList.size() <= 0)
			return;
		wareHouseCudSrv.save(updateList.toArray(new WarehouseInfoDO[0]));
	}

	private Map<String, Map<String, StockValueCalDTO>> getNumValueMap(String[] id_whs, String[] id_mms, Integer day) throws BizException {
		//最高低储值计算
		GetStockNumValueSql Sql = new GetStockNumValueSql(id_whs, id_mms, day);
		StockValueCalDTO[] stockLowValueDTOS = (StockValueCalDTO[])AppFwUtil.getDORstWithDao(Sql, StockValueCalDTO.class);
		Map<String, Map<String, StockValueCalDTO>> stockValueMap = new HashMap<String, Map<String, StockValueCalDTO>>();
		if(stockLowValueDTOS == null || stockLowValueDTOS.length <= 0)
			return stockValueMap;
		for(StockValueCalDTO stockValueDTO : stockLowValueDTOS) {
			if(stockValueMap.containsKey(stockValueDTO.getId_wh())) {
				Map<String, StockValueCalDTO> numMap = stockValueMap.get(stockValueDTO.getId_wh());
				numMap.put(stockValueDTO.getId_mm(), stockValueDTO);
			} else {
				Map<String, StockValueCalDTO> numMap = new HashMap<String, StockValueCalDTO>();
				numMap.put(stockValueDTO.getId_mm(), stockValueDTO);
				stockValueMap.put(stockValueDTO.getId_wh(), numMap);
			}
		}
		return stockValueMap;
	}
	
	private void setNumValue(WarehouseInfoDO wareHouseDO, Map<String, Map<String, StockValueCalDTO>> stockValueMap,
			FBoolean fg_high, List<WarehouseInfoDO> updateList) throws BizException {
		IMeterialService mmSrv = ServiceFinder.find(IMeterialService.class);
		if(stockValueMap.containsKey(wareHouseDO.getId_wh())) {
			Map<String, StockValueCalDTO> numMap = stockValueMap.get(wareHouseDO.getId_wh());
			if(numMap.containsKey(wareHouseDO.getId_mm())) {
				StockValueCalDTO numDTO = numMap.get(wareHouseDO.getId_mm());
				FDouble num = mmSrv.packageUnitConversion(IMeterialService.TYPE_NUM, numDTO.getQuan_actual(), 
						numDTO.getId_mmpkgu_actual(), numDTO.getId_mmpkgu_base());
				if(num.compareTo(FDouble.ZERO_DBL) <= 0)
					return;
				wareHouseDO.setStatus(DOStatus.UPDATED);
				if(fg_high.booleanValue()) {
					wareHouseDO.setMaxuinum(num);
				} else {
					wareHouseDO.setLowuinum(num);
				}
				if(wareHouseDO.getMaxuinum().compareTo(wareHouseDO.getLowuinum()) < 0)
					wareHouseDO.setLowuinum(wareHouseDO.getMaxuinum());
				if(!updateList.contains(wareHouseDO))
					updateList.add(wareHouseDO);
			}
		}
	}
}
