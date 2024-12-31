package iih.bd.srv.s.bp;

import iih.bd.srv.s.bp.qry.GetSrvDescCfgInfoSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetSrvDescCfgInfoBP {

	public int execMaxSeq(String formId, String srvcaCode) throws BizException {

		GetSrvDescCfgInfoSql cfgSql = new GetSrvDescCfgInfoSql();
		String sql = cfgSql.getQueryMaxSeqSql();
		
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(formId);
		sqlParam.addParam(srvcaCode);
		
		Object result = new DAFacade().execQuery(sql.toString(),sqlParam,new ColumnHandler());
		if(result == null){
			return 0;
		}
		return (int) result;
	}
}
