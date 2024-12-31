package iih.bd.srv.emrtpl.s.bp;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.s.bp.sql.GetNewOrderIdSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 获取新序号业务逻辑
 * 
 * @author hao_wu
 *
 */
public class GetNewOrderIdBp {

	public int exec(EmrTplDO emrTplDo) throws BizException {
		if (emrTplDo == null) {
			return 0;
		}

		if (emrTplDo.getId_mrtp() == null) {
			throw new BizException("Id_mrtp不允许为空");
		}

		if (emrTplDo.getSd_owtp() == null) {
			throw new BizException("Sd_owtp不允许为空");
		}

		int maxOrderId = GetMaxOrderId(emrTplDo);
		return maxOrderId + 1;
	}

	/**
	 * 获取最大序号
	 * 
	 * @param mrCaCtmItmDo
	 * @return
	 * @throws BizException
	 */
	private int GetMaxOrderId(EmrTplDO emrTplDo) throws BizException {
		GetNewOrderIdSql sql = new GetNewOrderIdSql(emrTplDo);
		DAFacade daFacade = new DAFacade();
		int maxOrderId = (int) daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new ColumnHandler());
		return maxOrderId;
	}

}
