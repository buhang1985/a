package iih.bd.mm.warehouseinfo.s.bp;

import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.bd.mm.warehouseinfo.i.IWarehouseinfoCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 开放物品与仓库关系业务逻辑
 * 
 * @author hao_wu
 *
 */
public class OpenWarehouseInfoBp {

	public WarehouseInfoDO[] exec(WarehouseInfoDO[] warehouseInfos) throws BizException {
		if (warehouseInfos == null || warehouseInfos.length <= 0) {
			return warehouseInfos;
		}

		WarehouseInfoDO[] result = OpenWarehouseInfo(warehouseInfos);
		return result;
	}

	/**
	 * 开放物品与仓库关系
	 * 
	 * @param warehouseInfos
	 * @return
	 * @throws BizException
	 */
	private WarehouseInfoDO[] OpenWarehouseInfo(WarehouseInfoDO[] warehouseInfos) throws BizException {
		for (WarehouseInfoDO warehouseInfoDO : warehouseInfos) {
			if(!warehouseInfoDO.getFg_st_out().booleanValue()) {
				warehouseInfoDO.setFg_out(FBoolean.FALSE);
				warehouseInfoDO.setPsnout(null);
				warehouseInfoDO.setOuttime(null);
				warehouseInfoDO.setStatus(DOStatus.UPDATED);
			}
		}
		WarehouseInfoDO[] result = SaveWarehouseInfo(warehouseInfos);
		return result;
	}

	/**
	 * 保存物品与仓库关系
	 * 
	 * @param warehouseInfos
	 * @return
	 * @throws BizException
	 */
	private WarehouseInfoDO[] SaveWarehouseInfo(WarehouseInfoDO[] warehouseInfos) throws BizException {
		IWarehouseinfoCudService warehouseinfoCudService = ServiceFinder.find(IWarehouseinfoCudService.class);
		WarehouseInfoDO[] result = warehouseinfoCudService.save(warehouseInfos);
		return result;
	}
}
