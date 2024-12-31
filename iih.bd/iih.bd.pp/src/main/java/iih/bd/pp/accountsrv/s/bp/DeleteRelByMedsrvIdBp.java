package iih.bd.pp.accountsrv.s.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.accountsrv.d.AccountSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 根据医疗服务主键删除医疗服务与核算科目关系业务逻辑
 * 
 * @author hao_wu 2018-10-27
 *
 */
public class DeleteRelByMedsrvIdBp {

	/**
	 * 根据医疗服务主键删除医疗服务与核算科目关系
	 * 
	 * @param medSrvIds 医疗服务主键集合
	 * @throws DAException
	 * @throws BizException
	 */
	public void exec(String[] medSrvIds) throws DAException {
		if (ArrayUtils.isEmpty(medSrvIds)) {
			return;
		}

		StringBuilder wherePartBuilder = new StringBuilder();

		String wherePart = BdEnvContextUtil.processEnvContext(new AccountSrvDO(), false);
		wherePartBuilder.append(wherePart);

		wherePart = SqlUtils.getInSqlByIds(AccountSrvDO.ID_SRV, medSrvIds);
		wherePartBuilder.append(" and ");
		wherePartBuilder.append(wherePart);

		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(AccountSrvDO.class, wherePartBuilder.toString());
	}

}
