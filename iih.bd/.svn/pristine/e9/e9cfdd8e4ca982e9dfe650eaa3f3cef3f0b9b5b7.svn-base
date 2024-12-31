package iih.bd.res.warehouse.s.bp;

import java.util.List;

import iih.bd.res.warehouse.d.WarehouseDO;
import iih.mm.mc.stockperinit.d.StockPerInitDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 检查是否有期初数据
 * 
 * @author hao_wu
 *
 */
public class CheckStockPerInitBp {
	public Boolean Exec(WarehouseDO wareHouseDO) throws BizException {
		DAFacade dao = new DAFacade();

		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select a.* from MM_INI a ");
		sqlStr.append(" inner join MM_INI_ITM b ");
		sqlStr.append(" on a.id_ini = b.id_ini ");
		sqlStr.append(" where ");
		sqlStr.append("  a.ds=0 ");
		sqlStr.append("  and a.id_wh='" + wareHouseDO.getId_wh() + "' ");

		@SuppressWarnings("unchecked")
		List<StockPerInitDO> stockPerInitDOList = (List<StockPerInitDO>) dao.execQuery(sqlStr.toString(),
				new BeanListHandler(StockPerInitDO.class));

		if (stockPerInitDOList != null && stockPerInitDOList.size() > 0) {
			return true;
		}
		return false;
	}
}
