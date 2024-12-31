package iih.bd.pp.accountsubject.s.rule;

import java.util.ArrayList;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.accountsrv.d.AccountSrvDO;
import iih.bd.pp.accountsubject.d.AccountSubjectDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.jdbc.facade.DAFacade;
/**
 * 删除核算分类前删除核算科目与收费项目的关联关系
 * 
 * @author shao_yuan
 *
 */
public class DelAccountSrvBeforeDelAccountSubjectDORule  implements IRule<AccountSubjectDO>{

	@Override
	public void process(AccountSubjectDO... paramVarArgs) throws BizException {
		String[] accIdArray = GetSrvIdArray(paramVarArgs);
		if (accIdArray == null || accIdArray.length <= 0) {
			return;
		}
		String wherePart = GetWherePart(accIdArray);
		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(AccountSrvDO.class, wherePart);
		
	}

	private String GetWherePart(String[] accIdArray) {
		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("1 = 1");

		String BDModeSql = BdEnvContextUtil.processEnvContext(new AccountSrvDO(), false);
		if (BDModeSql != null && !BDModeSql.isEmpty()) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(BDModeSql);
		}

		String wherePart = SqlUtils.getInSqlByIds(AccountSrvDO.ID_ACCOUNTCA, accIdArray);
		if (wherePart != null && !wherePart.isEmpty()) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}

	private String[] GetSrvIdArray(AccountSubjectDO[] paramVarArgs) {
		if (paramVarArgs == null || paramVarArgs.length <= 0) {
			return null;
		}
		ArrayList<String> accIdList = new ArrayList<String>();
		for (AccountSubjectDO accDO : paramVarArgs) {
			if (accDO != null && !StringUtils.isNullOrEmpty(accDO.getId_accountca())) {
				accIdList.add(accDO.getId_accountca());
			}
		}
		return accIdList.toArray(new String[0]);
	}

}
