package iih.bd.res.warehouse.s.bp;

import java.util.List;

import iih.bd.res.warehouse.d.WarehouseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 检查是否有下级仓库
 * 
 * @author hao_wu
 *
 */
public class CheckChildWhBp {

	public Boolean Exec(WarehouseDO wareHouseDO) throws BizException {
		DAFacade dao = new DAFacade();

		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select a.* from BD_WH a ");
		sqlStr.append(" where ");
		sqlStr.append("  a.ds=0 ");
		sqlStr.append(String.format(" and a.id_grp = '%s' and a.id_org = '%s'", Context.get().getGroupId(),
				Context.get().getOrgId()));
		sqlStr.append("  and a.innercode like '" + wareHouseDO.getInnercode() + "%' ");

		@SuppressWarnings("unchecked")
		List<WarehouseDO> wareHouseList = (List<WarehouseDO>) dao.execQuery(sqlStr.toString(),
				new BeanListHandler(WarehouseDO.class));

		if (wareHouseList != null && wareHouseList.size() > 1) {
			return true;
		}

		return false;
	}
}
