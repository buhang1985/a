package iih.bd.mm.warehouseinfo.bp;

import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class WhmmReAfterBp {
	
	public void exec(WarehouseInfoDO[] dos) throws BizException {
		
		if(dos == null || dos.length <= 0) {
			
			return;
		}
		
		// 库存数量转换
		this.convertNumberToUI(dos);
	}

	private void convertNumberToUI(WarehouseInfoDO[] dos) throws BizException {
		
        IMeterialService mmSrv = ServiceFinder.find(IMeterialService.class);
		
		for (WarehouseInfoDO warehouseInfoDO : dos) {
			FDouble baseMaxStock = warehouseInfoDO.getMaxstnum();
			FDouble baseLowStock = warehouseInfoDO.getLowstnum();
			
			//单位换算
			MMPackageUnitDO uiPkgDO = mmSrv.findPackageUnitById(warehouseInfoDO.getId_mmpkgu_ui());
			if(uiPkgDO==null)
				throw new BizException(String.format("获取物品包装单位失败，物品包装单位主键:%s。", warehouseInfoDO.getId_mmpkgu_ui()));
			warehouseInfoDO.setMaxuinum(baseMaxStock.div(uiPkgDO.getFactor(), -16));
			warehouseInfoDO.setLowuinum(baseLowStock.div(uiPkgDO.getFactor(), -16));
		}		
	}
}
