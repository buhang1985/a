package iih.bd.srv.medsrv.s.rule.bp;

import iih.bd.srv.medsrv.s.rule.bp.sql.CalMedSrvSetItmChkNumSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 计算医疗服务套临床必选项目数量业务逻辑
 * 
 * @author hao_wu
 *
 */
public class CalMedSrvSetItmChkNumBp {
	public void exec(String[] medSrvIds) throws BizException {
		if (medSrvIds == null || medSrvIds.length <= 0) {
			return;
		}

		CalMedSrvSetItmChkNum(medSrvIds);
	}

	/**
	 * 计算医疗服务套临床必选项目数量
	 * 
	 * @param medSrvIds
	 * @throws BizException
	 */
	private void CalMedSrvSetItmChkNum(String[] medSrvIds) throws BizException {
		CalMedSrvSetItmChkNumSql sql = new CalMedSrvSetItmChkNumSql(medSrvIds);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql.getQrySQLStr(), sql.getQryParameter(null));
	}
}
