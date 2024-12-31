package iih.bd.res.warehouse.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IMmDictCodeConst;
import iih.bd.res.warehouse.d.WarehouseDO;
import iih.mm.mc.stockperinit.d.StockPerInitDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 检查是否已期初记账
 * 
 * @author hao_wu
 *
 */
public class CheckStockPerAccBp {

	public Boolean Exec(WarehouseDO wareHouseDO) throws BizException {
		DAFacade dao = new DAFacade();

		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select a.* from MM_INI a ");
		sqlStr.append(" where ");
		sqlStr.append("  a.ds=0 ");
		sqlStr.append("  and a.id_wh='" + wareHouseDO.getId_wh() + "' ");
		sqlStr.append("  and a.sd_su_st='" + IMmDictCodeConst.SD_INI_CHARGED + "' ");

		@SuppressWarnings("unchecked")
		List<StockPerInitDO> stockPerList = (List<StockPerInitDO>) dao.execQuery(sqlStr.toString(),
				new BeanListHandler(StockPerInitDO.class));

		if (stockPerList != null && stockPerList.size() > 0) {
			return true;
		}

		return false;
	}
}
