package iih.bd.srv.medsrv.s.rule.bp;

import java.util.ArrayList;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.accountsrv.d.AccountSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 删除医疗服务前删除核算科目与收费项目的关联关系
 * 
 * @author shao_yuan
 *
 */
public class DelIncCaItmRelBeforeDelAccSubRuleBp {

	public void exec(MedsrvAggDO[] arg0) throws DAException {
		String[] srvIdArray = GetSrvIdArray(arg0);
		if (srvIdArray == null || srvIdArray.length <= 0) {
			return;
		}
		String wherePart = GetWherePart(srvIdArray);
		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(AccountSrvDO.class, wherePart);	
	}

	private String GetWherePart(String[] srvIdArray) {
		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("1 = 1");

		String BDModeSql = BdEnvContextUtil.processEnvContext(new AccountSrvDO(), false);
		if (BDModeSql != null && !BDModeSql.isEmpty()) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(BDModeSql);
		}

		String wherePart = SqlUtils.getInSqlByIds(AccountSrvDO.ID_SRV, srvIdArray);
		if (wherePart != null && !wherePart.isEmpty()) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String[] GetSrvIdArray(MedsrvAggDO[] arg0) {
		if (arg0 == null || arg0.length <= 0) {
			return null;
		}
		ArrayList<String> srvIdList = new ArrayList<String>();
		for (MedsrvAggDO medSrvaggDO : arg0) {
			if (medSrvaggDO != null && medSrvaggDO.getParentDO()!=null&&!StringUtils.isNullOrEmpty(medSrvaggDO.getParentDO().getId_srv())) {
				srvIdList.add(medSrvaggDO.getParentDO().getId_srv());
			}
		}
		return srvIdList.toArray(new String[0]);
	}

}
