package iih.bd.mm.warehouseinfo.bp;

import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import org.apache.commons.lang.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class WhmmDeBeforBp {

	public void exec(WarehouseInfoDO[] dos) throws BizException {
		
		if(dos == null || dos.length <= 0) {
			
			return;
		}
		
		// 判断仓库下物品是否有结存
		this.checkBlData(dos);
	}

	private void checkBlData(WarehouseInfoDO[] dos) throws BizException {
		
		IMeterialService mmSrv = ServiceFinder.find(IMeterialService.class);
		
		for(WarehouseInfoDO mmWhDO : dos) {
			
			if(!StringUtils.isEmpty(mmWhDO.getId_wh()) && mmSrv.isStockExistByWh(mmWhDO.getId_wh(), mmWhDO.getId_mm())) {
				
				throw new BizException("物品在该仓库下存在结存数据，不允许删除。");
			}
		}
	}
}
