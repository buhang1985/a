package iih.bd.pp.anhuisrvorca.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 清空医保计划控制策略业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ClearSrvctrBp {

	public void exec() throws BizException {
		String sql = "DELETE FROM BD_HP_SRVCTR WHERE ID_GRP = ? AND ID_ORG = ?";
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql, sqlParam);
	}
}
