package iih.bd.srv.basemrtplfs.s.bp;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 更新纸张类型业务逻辑
 * 
 * @author hao_wu
 *
 */
public class UpdatePaperTypeBp {

	public void exec(String id_basemrtpl, String paperTp) throws BizException {
		if (id_basemrtpl == null) {
			return;
		}

		updatePaperType(id_basemrtpl, paperTp);
	}

	/**
	 * 更新纸张类型
	 * 
	 * @param id_basemrtpl
	 * @param paperTp
	 * @throws BizException
	 */
	private void updatePaperType(String id_basemrtpl, String paperTp) throws BizException {
		DAFacade daFacade = new DAFacade();
		String sql = "UPDATE BD_BASE_MRTPL SET ID_PAPER_TP = ? WHERE ID_BASEMRTPL = ?";
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(paperTp);
		sqlParam.addParam(id_basemrtpl);
		daFacade.execUpdate(sql, sqlParam);
	}

}
