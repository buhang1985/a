package iih.bd.pp.baseprisrv.s.bp;

import java.util.List;

import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.pp.baseprisrv.s.bp.qry.FindPriSrvQry;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 查询价表服务
 * 
 * @author hao_wu 2019-8-20
 *
 */
public class FindPriSrvBp {

	@SuppressWarnings("unchecked")
	public PriSrvDO[] exec(String whereStr, String orderStr) throws BizException {

		FindPriSrvQry qry = new FindPriSrvQry(whereStr, null, orderStr);

		DAFacade daFacade = new DAFacade();
		List<PriSrvDO> priSrvDoList = (List<PriSrvDO>) daFacade.execQuery(qry.getQrySQLStr(), qry.getQryParameter(null),
				new BeanListHandler(PriSrvDO.class));

		setChargeBasis(priSrvDoList);

		return priSrvDoList.toArray(new PriSrvDO[0]);
	}

	/**
	 * 设置收费依据
	 * 
	 * @param priSrvDoList
	 * @throws BizException
	 */
	private void setChargeBasis(List<PriSrvDO> priSrvDoList) throws BizException {
		SetChargeBasisBp bp = new SetChargeBasisBp();
		bp.exec(priSrvDoList.toArray(new PriSrvDO[0]));
	}
}
