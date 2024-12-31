package iih.bd.pp.baseprisrv.s.bp;

import java.util.List;

import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.pp.baseprisrv.s.bp.qry.FindPriSrvQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class FindPriSrvBySqlParamBp {

	@SuppressWarnings("unchecked")
	public PriSrvDO[] exec(String whereStr, SqlParamDTO sqlParamDTO, String orderStr) throws BizException {

		FindPriSrvQry qry = new FindPriSrvQry(whereStr, sqlParamDTO, orderStr);
		DAFacade daFacade = new DAFacade();
		List<PriSrvDO> priSrvList = (List<PriSrvDO>) daFacade.execQuery(qry.getQrySQLStr(), qry.getQryParameter(null),
				new BeanListHandler(PriSrvDO.class));
		if (priSrvList == null) {
			return null;
		}

		return priSrvList.toArray(new PriSrvDO[0]);
	}

}
