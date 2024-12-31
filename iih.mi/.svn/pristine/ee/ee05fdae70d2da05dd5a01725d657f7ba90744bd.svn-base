package iih.mi.inst.bizgrp.tonglingcity.bp;

import iih.mi.inst.bizgrp.tonglingcity.bp.qry.CompletionDtbSql;
import iih.mi.inst.bizgrp.tonglingcity.bp.qry.CompletionDteSql;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 补全对照表的dt_b,dt_e字段业务逻辑
 * 
 * @author guoyang
 *
 */
public class CompletionDtbAndDteBp {

	public void exec(String miSrvTp, String hpId, String[] pks) throws DAException {
		CompletionDtb(miSrvTp, hpId, pks);
		CompletionDte(miSrvTp, hpId, pks);
	}

	/**
	 * 补全dt_e字段
	 * 
	 * @param hpId
	 * @param pks
	 * @throws DAException
	 */
	private void CompletionDte(String miSrvTp, String hpId, String[] pks) throws DAException {
		CompletionDteSql completionDteSql = new CompletionDteSql(miSrvTp, hpId, pks);
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
	private void CompletionDtb(String miSrvTp, String hpId, String[] pks) throws DAException {
		CompletionDtbSql completionDtbSql = new CompletionDtbSql(miSrvTp, hpId, pks);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(completionDtbSql.getQrySQLStr(), completionDtbSql.getQryParameter(null));
	}
}
