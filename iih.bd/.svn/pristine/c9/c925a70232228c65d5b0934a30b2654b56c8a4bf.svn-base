package iih.bd.mm.iemsg;

import iih.bd.mm.iemsg.d.WarehouseDTO;
import iih.bd.mm.iemsg.qry.WarehouseSql;
import iih.bd.res.warehouse.d.WarehouseDO;
import xap.mw.core.data.BizException;

/**
 * 获取仓库修改后数据。
 * @author shao_yuan
 *
 */
public  class WarehouseBp{

	public WarehouseDTO[] setWareDTO(WarehouseDO[] waredolist,String eventtype) throws BizException {
			
		//获得仓库字典数据信息
		WarehouseSql sql = new WarehouseSql();
		WarehouseDTO[] ors=sql.setByStatu(waredolist,eventtype);
		
		return ors;
	}

}
