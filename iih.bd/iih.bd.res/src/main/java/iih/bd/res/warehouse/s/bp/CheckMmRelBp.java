package iih.bd.res.warehouse.s.bp;

import java.util.List;

import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.bd.res.warehouse.d.WarehouseDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 检查是否有仓库物品关系
 * 
 * @author hao_wu
 *
 */
public class CheckMmRelBp {

	public Boolean Exec(WarehouseDO wareHouseDO) throws BizException {
		DAFacade dao = new DAFacade();

		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select a.* from BD_MM_WH a ");
		sqlStr.append(" where ");
		sqlStr.append("  a.ds=0 ");
		sqlStr.append("  and a.id_wh='" + wareHouseDO.getId_wh() + "' ");

		@SuppressWarnings("unchecked")
		List<WarehouseInfoDO> warehouseList = (List<WarehouseInfoDO>) dao.execQuery(sqlStr.toString(),
				new BeanListHandler(WarehouseInfoDO.class));

		if (warehouseList != null && warehouseList.size() > 0) {
			return true;
		}
		return false;
	}
}
