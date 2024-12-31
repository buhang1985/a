package iih.bd.pp.anhuisrvorca.s.bp;

import iih.bd.pp.anhuisrvorca.s.bp.sql.CompletionDtbSql;
import iih.bd.pp.anhuisrvorca.s.bp.sql.CompletionDteSql;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 补全对照表的dt_b,dt_e字段业务逻辑
 * 
 * @author guoyang
 *
 */
public class CompletionDtbAndDteBp {

	public void exec(Integer hpSrvTp, String hpId, String[] pks) throws DAException {
		CompletionDtb(hpSrvTp, hpId, pks);
		CompletionDte(hpSrvTp, hpId, pks);
	}

	/**
	 * 补全dt_e字段
	 * 
	 * @param hpId
	 * @param pks
	 * @throws DAException
	 */
	private void CompletionDte(Integer hpSrvTp, String hpId, String[] pks) throws DAException {
		CompletionDteSql completionDteSql = new CompletionDteSql(hpSrvTp, hpId, pks);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(completionDteSql.getQrySQLStr(), completionDteSql.getQryParameter(null));
	}

	/**
	 * 补全dt_b字段
	 * 
	 * @param hpId
	 * @param pks
	 * @throws DAException
	 */
	private void CompletionDtb(Integer hpSrvTp, String hpId, String[] pks) throws DAException {
		CompletionDtbSql completionDtbSql = new CompletionDtbSql(hpSrvTp, hpId, pks);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(completionDtbSql.getQrySQLStr(), completionDtbSql.getQryParameter(null));
	}
}
