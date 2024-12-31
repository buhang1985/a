package iih.bd.res.warehouse.s.bp;

import java.util.List;

import iih.bd.res.goodslocation.d.GoodslocationDO;
import iih.bd.res.warehouse.d.WarehouseDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 检查是否有仓库货位
 * 
 * @author hao_wu
 *
 */
public class CheckLocRelBp {

	public Boolean Exec(WarehouseDO wareHouseDO) throws BizException {
		DAFacade dao = new DAFacade();

		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select a.* from BD_LOCATION a ");
		sqlStr.append(" where ");
		sqlStr.append("  a.ds=0 ");
		sqlStr.append("  and a.id_wh='" + wareHouseDO.getId_wh() + "' ");

		@SuppressWarnings("unchecked")
		List<GoodslocationDO> goodsLocList = (List<GoodslocationDO>) dao.execQuery(sqlStr.toString(),
				new BeanListHandler(GoodslocationDO.class));

		if (goodsLocList != null && goodsLocList.size() > 0) {
			return true;
		}
		return false;
	}
}
