package iih.bd.pp.hpdiexpenseself.s.bp;

import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.StringUtils;

import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.bd.pp.hpdiexpenseself.s.bp.sql.FindBdHpDiExpenseSelfSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;

/**
 * 根据主键值查找医保计划自费诊断数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindByIdBp {

	public BdHpDiExpenseSelfDO exec(String id) throws BizException {
		if (StringUtils.isEmpty(id)) {
			throw new NullArgumentException("医保计划自费诊断主键");
		}
		BdHpDiExpenseSelfDO result = FindById(id);
		return result;
	}

	/**
	 * 根据主键值查找医保计划自费诊断数据
	 * 
	 * @param id
	 * @return
	 * @throws BizException
	 */
	private BdHpDiExpenseSelfDO FindById(String id) throws BizException {
		FindBdHpDiExpenseSelfSql sql = new FindBdHpDiExpenseSelfSql(id);
		DAFacade daFacade = new DAFacade();
		BdHpDiExpenseSelfDO result = (BdHpDiExpenseSelfDO) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanHandler(BdHpDiExpenseSelfDO.class));
		return result;
	}
}
