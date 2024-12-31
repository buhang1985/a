package iih.bd.pp.anhuisrvorca.s.bp;

import iih.bd.pp.anhuisrvorca.s.bp.sql.ClearCompDataSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 清空医保三大目录对照业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ClearCompDataBp {

	public void exec() throws BizException {
		ClearCompData();
		ClearSrvctr();
	}

	private void ClearCompData() throws BizException {
		ClearCompDataSql sql = new ClearCompDataSql();
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql.getQrySQLStr(), sql.getQryParameter(null));
	}

	private void ClearSrvctr() throws BizException {
		ClearSrvctrBp bp = new ClearSrvctrBp();
		bp.exec();
	}
}
