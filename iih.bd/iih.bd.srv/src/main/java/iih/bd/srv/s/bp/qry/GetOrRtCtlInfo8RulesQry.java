package iih.bd.srv.s.bp.qry;

import iih.bd.srv.pub.BdSrvUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOrRtCtlInfo8RulesQry implements ITransQry {
	private String _id_srvs;
	private String[] _rules;
	
	public GetOrRtCtlInfo8RulesQry(String id_srvs, String[] rules) {
		_id_srvs = id_srvs;
		_rules = rules;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (isSingleIdV()) {
			for(String _rule : _rules) {
				param.addParam(_id_srvs);
			}
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		for(String _rule : _rules) {
			if (sb.length() > 0) {
				sb.append(" union all ");
			}
			sb.append("select id_srv as id_biz," + _rule + " as v1 ")
			.append("from bd_srv a0 ")
			.append("where a0.id_srv" + getIdSrvSqlStr());
		}
		
		return sb.toString();
	}
	
	private String getIdSrvSqlStr() {
		if (isSingleIdV())
			return BdSrvUtils.EQUAL_STR + BdSrvUtils.QUESTION_STR;
		return BdSrvUtils.getIdsSqlStrWithInStr(_id_srvs);
	}

	/**
	 * 是否单ID值
	 * @return
	 */
	private boolean isSingleIdV() {
		return BdSrvUtils.isEmpty(_id_srvs) || !BdSrvUtils.isInStr(_id_srvs, BdSrvUtils.COMMA_STR);
	}
}
