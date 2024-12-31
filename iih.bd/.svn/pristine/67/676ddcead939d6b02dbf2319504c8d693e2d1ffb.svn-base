package iih.bd.pp.anhuisrvorca.s.bp;

import iih.bd.pp.anhuisrvorca.s.bp.sql.RefreshIdHpSrvTpSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 刷新通用医保计划目录类型业务类型
 * 
 * @author hao_wu
 *
 */
public class RefreshIdHpSrvTpBp {

	public void exec(Integer hpSrvTp, String hpId, String[] pks) throws BizException {
		RefreshIdHpSrvTpSql sql = new RefreshIdHpSrvTpSql(hpSrvTp, hpId, pks);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql.getQrySQLStr(), sql.getQryParameter(null));
	}
}
