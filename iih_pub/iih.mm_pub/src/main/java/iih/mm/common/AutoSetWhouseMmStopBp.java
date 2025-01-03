package iih.mm.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.bd.mm.warehouseinfo.i.IWarehouseinfoRService;
import iih.mm.bl.stockbl.d.StockBlDO;
import iih.mm.common.qry.GetMmStockSumUseableQuanQry;
import iih.mm.itf.material.d.MaterialStockDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;

public class AutoSetWhouseMmStopBp {
	
	public static void exec(StockBlDO[] stockblList) throws BizException {
		if(stockblList == null || stockblList.length <= 0) {
			return;
		}
		if(!MMParams.MMDG0018().booleanValue()) {
			return;
		}
		//获取结存信息
		Map<String, MaterialStockDTO> stockMap = getStockMap(stockblList);
		//停发标志设置
		setStopFlag(stockblList, stockMap);
	}

	private static Map<String, MaterialStockDTO> getStockMap(StockBlDO[] stockblList) throws BizException {
		GetMmStockSumUseableQuanQry Sql = new GetMmStockSumUseableQuanQry(stockblList);
		MaterialStockDTO[] stockInfos = (MaterialStockDTO[])AppFwUtil.getDORstWithDao(Sql, MaterialStockDTO.class);
		Map<String, MaterialStockDTO> stockMap = new HashMap<String, MaterialStockDTO>();
		if(stockInfos != null && stockInfos.length > 0) {
			for(MaterialStockDTO stockInfo : stockInfos) {
				String key = stockInfo.getId_dep() + stockInfo.getId_mm();
				stockMap.put(key, stockInfo);
			}
		}
		return stockMap;
	}
	
	private static void setStopFlag(StockBlDO[] stockblList, Map<String, MaterialStockDTO> stockMap) throws BizException {
		//查询条件
		String whrStr = getWhrStr(stockblList, "a0");
		//仓库物品关系获取
		IWarehouseinfoRService whouseRSrv = ServiceFinder.find(IWarehouseinfoRService.class);
		WarehouseInfoDO[] whouseInfoDOS = whouseRSrv.find(whrStr, "", FBoolean.TRUE);
		if(whouseInfoDOS == null || whouseInfoDOS.length <= 0) {
			return;
		}
		List<WarehouseInfoDO> updateList = new ArrayList<WarehouseInfoDO>();
		for(WarehouseInfoDO whouseInfoDO : whouseInfoDOS) {
			if(whouseInfoDO.getFg_out().booleanValue() && !whouseInfoDO.getFg_st_out().booleanValue()) {
				continue;
			}
			String key = whouseInfoDO.getId_wh() + whouseInfoDO.getId_mm();
			MaterialStockDTO stockInfo = stockMap.get(key);
			if(stockInfo == null) {
				whouseInfoDO.setFg_out(FBoolean.TRUE);
				whouseInfoDO.setFg_st_out(FBoolean.TRUE);
			} else if(stockInfo.getQuan_usable().compareTo(FDouble.ONE_DBL) >= 0) {
				whouseInfoDO.setFg_out(FBoolean.FALSE);
				whouseInfoDO.setFg_st_out(FBoolean.FALSE);
			} else {
				whouseInfoDO.setFg_out(FBoolean.TRUE);
				whouseInfoDO.setFg_st_out(FBoolean.TRUE);
			}
			if(whouseInfoDO.getFg_out().booleanValue()) {
				whouseInfoDO.setPsnout(Context.get().getStuffId());
				whouseInfoDO.setOuttime(new FDateTime());
			} else {
				whouseInfoDO.setPsnout(null);
				whouseInfoDO.setOuttime(null);
			}
			updateList.add(whouseInfoDO);
		}
		if(updateList != null && updateList.size() > 0) {
			new DAFacade().updateDOs(updateList.toArray(new WarehouseInfoDO[0]));
		}
	}

	private static String getWhrStr(StockBlDO[] stockblList, String alisTableName) {
		StringBuffer result = new StringBuffer();
		result.append("(1 <> 1");
		for(StockBlDO stockBlDO : stockblList) {
			result.append(String.format(" or (%s.id_wh = '%s' and %s.id_mm = '%s') ", alisTableName, stockBlDO.getId_wh(), alisTableName, stockBlDO.getId_mm()));
		}
		result.append(")");
		return result.toString();
	}
}
