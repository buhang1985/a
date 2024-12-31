package iih.bl.cg.blcgoeptf.s.bp;

import java.util.ArrayList;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class QueryIpStAmtBp {
	public BlCgIpDO[] exec(String ident) throws BizException{
		QueryIpStAmtSql sql = new QueryIpStAmtSql(ident);
		DAFacade daFacade = new DAFacade();
		ArrayList<BlCgIpDO> list = (ArrayList<BlCgIpDO>)daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(BlCgIpDO.class));
		if (list.size()==0) {
			return null;
		}
		return list.toArray(new BlCgIpDO[list.size()]);
	}
}
