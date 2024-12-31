package iih.bd.pp.srvctrdi.s.bp;

import java.util.ArrayList;

import iih.bd.pp.srvctrdi.d.BdHpSrvCtrDiDO;
import iih.bd.pp.srvctrdi.s.bp.sql.FindSrvCtrDiSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 使用主键查询业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindByIdBp {

	public BdHpSrvCtrDiDO exec(String id) throws BizException {
		String wherePart = "ID_SRVCTR_ID = ?";
		FindSrvCtrDiSql sql = new FindSrvCtrDiSql(wherePart);

		SqlParam sqlParam = sql.getQryParameter(null);
		sqlParam.addParam(id);

		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<BdHpSrvCtrDiDO> dataList = (ArrayList<BdHpSrvCtrDiDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sqlParam, new BeanListHandler(BdHpSrvCtrDiDO.class));
		if (dataList != null && dataList.size() > 0) {
			return dataList.get(0);
		}
		return null;
	}

}
