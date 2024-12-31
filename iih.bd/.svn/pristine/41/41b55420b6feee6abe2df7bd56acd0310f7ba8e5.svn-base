package iih.bd.mm.warehouseinfo.s.bp;

import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.bd.mm.warehouseinfo.i.IWarehouseinfoRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 在所有仓库中停开指定物品业务逻辑
 * 
 * @author hao_wu
 *
 */
public class CloseWarehouseInfoByMaterialIdsBp {

	public void exec(String[] materialIds) throws BizException {
		if (materialIds == null || materialIds.length <= 0) {
			return;
		}

		CloseWarehouseInfoByMaterialIds(materialIds);
	}

	/**
	 * 在所有仓库中停开指定物品
	 * 
	 * @param materialIds
	 * @throws BizException
	 */
	private void CloseWarehouseInfoByMaterialIds(String[] materialIds) throws BizException {
		WarehouseInfoDO[] result = GetWarehouseInfoByMaterialIds(materialIds);
		CloseWarehouseInfo(result);
	}

	/**
	 * 停开物品与仓库关系
	 * 
	 * @param result
	 * @throws BizException
	 */
	private void CloseWarehouseInfo(WarehouseInfoDO[] result) throws BizException {
		CloseWarehouseInfoBp bp = new CloseWarehouseInfoBp();
		bp.exec(result);
	}

	/**
	 * 根据物品主键集合获取物品与仓库关系
	 * 
	 * @param materialIds
	 * @return
	 * @throws BizException
	 */
	private WarehouseInfoDO[] GetWarehouseInfoByMaterialIds(String[] materialIds) throws BizException {
		IWarehouseinfoRService warehouseinfoRService = ServiceFinder.find(IWarehouseinfoRService.class);
		WarehouseInfoDO[] result = warehouseinfoRService.findByAttrValStrings(WarehouseInfoDO.ID_MM, materialIds);
		return result;
	}

}
