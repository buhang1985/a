package iih.bd.pp.hpdivshisdto.s.bp;

import iih.bd.pp.hpdivshisdto.s.bp.sql.ClearDiCompDataSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 清空医保病种目录对照业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ClearDiCompBp {

	public void exec() throws BizException {
		ClearDiCompDataSql sql = new ClearDiCompDataSql();
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql.getQrySQLStr(), sql.getQryParameter(null));
	}
}
