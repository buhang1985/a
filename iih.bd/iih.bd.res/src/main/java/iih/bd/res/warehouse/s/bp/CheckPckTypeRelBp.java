package iih.bd.res.warehouse.s.bp;

import java.util.List;

import iih.bd.mm.wahouseunittype.d.WahouseUnitTypeDO;
import iih.bd.res.warehouse.d.WarehouseDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 检查是否有仓库单位类型
 * 
 * @author hao_wu
 *
 */
public class CheckPckTypeRelBp {

	public Boolean Exec(WarehouseDO wareHouseDO) throws BizException {
		DAFacade dao = new DAFacade();

		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select a.* from BD_WH_PKGUTP a ");
		sqlStr.append(" where ");
		sqlStr.append("  a.ds=0 ");
		sqlStr.append("  and a.id_wh='" + wareHouseDO.getId_wh() + "' ");

		@SuppressWarnings("unchecked")
		List<WahouseUnitTypeDO> whUnitTypeList = (List<WahouseUnitTypeDO>) dao.execQuery(sqlStr.toString(),
				new BeanListHandler(WahouseUnitTypeDO.class));

		if (whUnitTypeList != null && whUnitTypeList.size() > 0) {
			return true;
		}
		return false;
	}

}
