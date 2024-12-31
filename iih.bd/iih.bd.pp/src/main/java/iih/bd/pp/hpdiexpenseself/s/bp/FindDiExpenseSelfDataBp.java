package iih.bd.pp.hpdiexpenseself.s.bp;

import java.util.ArrayList;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.bd.pp.hpdiexpenseself.s.bp.sql.FindBdHpDiExpenseSelfSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取医保计划自费诊断业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindDiExpenseSelfDataBp {

	public BdHpDiExpenseSelfDO[] exec(HPDO hpdo, String orderStr) throws BizException {
		if (hpdo == null) {
			throw new BizException("医保计划不允许为空。");
		}
		BdHpDiExpenseSelfDO[] result = FindDiExpenseSelfData(hpdo, orderStr);
		return result;
	}

	/**
	 * 获取医保计划自费诊断
	 * 
	 * @param hpdo
	 * @param orderStr
	 * @return
	 * @throws BizException
	 */
	private BdHpDiExpenseSelfDO[] FindDiExpenseSelfData(HPDO hpdo, String orderStr) throws BizException {
		FindBdHpDiExpenseSelfSql sql = new FindBdHpDiExpenseSelfSql(hpdo);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<BdHpDiExpenseSelfDO> dataList = (ArrayList<BdHpDiExpenseSelfDO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(BdHpDiExpenseSelfDO.class));
		return dataList == null ? null : dataList.toArray(new BdHpDiExpenseSelfDO[0]);
	}
}
