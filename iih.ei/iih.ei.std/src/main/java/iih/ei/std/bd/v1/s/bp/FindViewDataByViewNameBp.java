package iih.ei.std.bd.v1.s.bp;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 查询视图数据业务逻辑
 * 
 * @author hao_wu 2019-2-26
 *
 */
public class FindViewDataByViewNameBp {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> exec(String viewName) throws BizException {

		DAFacade daFacade = new DAFacade();
		String envWherePart = String.format("id_org in ('GLOBLE00000000000000','%s','%s')", Context.get().getGroupId(),
				Context.get().getOrgId());
		String sql = String.format("select * from %s where %s", viewName, envWherePart);
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) daFacade.execQuery(sql, new MapListHandler());

		return dataList;
	}
}
