package iih.bd.res.goodslocation.s.bp;

import iih.bd.res.goodslocation.d.GoodslocationDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;

/**
 * 设置货位集团和组织信息
 * 
 * @author hao_wu
 *
 */
public class SetGoodslocationDOGrpOrgBp {

	public void Exec(GoodslocationDO goodslocationDO) throws BizException {
		if (goodslocationDO == null)
			return;

		goodslocationDO.setId_grp(Context.get().getGroupId());
		goodslocationDO.setId_org(Context.get().getOrgId());

		// String whId = goodslocationDO.getId_wh();
		// IWarehouseRService warehouseRService =
		// ServiceFinder.find(IWarehouseRService.class);
		// WarehouseDO warehouseDO = warehouseRService.findById(whId);
		// if (warehouseDO != null) {
		// // TODO:这里逻辑是否正确？集团仓库下挂载组织货位的情况下逻辑是错的
		// goodslocationDO.setId_grp(warehouseDO.getId_grp());
		// goodslocationDO.setId_org(warehouseDO.getId_org());
		// }
	}
}
