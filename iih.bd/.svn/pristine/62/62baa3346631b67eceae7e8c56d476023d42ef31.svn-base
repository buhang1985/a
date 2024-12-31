package iih.bd.pp.s.bp.qry;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.accountsubject.d.AccountSubjectDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 核算分类医疗服务关系查询类
 * @author ly 2018/05/14
 *
 */
public class GetAccSrvRelatQry  implements ITransQry {

	private String[] srvIds;//服务id
	private String accId;//核算体系id
	
	public GetAccSrvRelatQry(String[] srvIds,String accId){
		this.srvIds = srvIds;
		this.accId = accId;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {
		
		SqlParam param = new SqlParam();
		sqlSb.append("and acca.id_account = ? ");
		param.addParam(this.accId);
		
		String srvInSql = SqlUtils.getInSqlByParamValues("cavssrv.id_srv", this.srvIds);
		sqlSb.append("and " + srvInSql);
		
		for (String srvId : this.srvIds) {
			param.addParam(srvId);
		}
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ");
		sqlSb.append("cavssrv.id_srv,");
		sqlSb.append("acca.code code_acc,");
		sqlSb.append("acca.name name_acc ");
		sqlSb.append("from bd_account_ca_vs_srv cavssrv ");
		sqlSb.append("inner join bd_account_ca acca ");
		sqlSb.append("on cavssrv.id_accountca = acca.id_accountca ");
		sqlSb.append("where ");
		
		String orgSql = EnvContextUtil.processEnvContext("", new AccountSubjectDO(), "acca");
		sqlSb.append(orgSql + " ");
		return sqlSb.toString();
	}
}
