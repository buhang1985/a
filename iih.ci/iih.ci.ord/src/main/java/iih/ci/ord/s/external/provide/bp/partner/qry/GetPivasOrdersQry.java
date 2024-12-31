package iih.ci.ord.s.external.provide.bp.partner.qry;

import java.util.List;

import xap.sys.jdbc.kernel.SqlParam;

public class GetPivasOrdersQry extends GetIpOrdersQry {
	private List<String> code_ors;

	public GetPivasOrdersQry(List<String> code_ors,String drugManagementModel) {
		this.code_ors = code_ors;
		this.drugManagementModel = drugManagementModel;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		if (null != code_ors && code_ors.size() > 0) {
			for (String code_or : code_ors) {
				sqlParam.addParam(code_or);
			}
		}
		return sqlParam;
	}

	@Override
	protected String getWherePart() {
		StringBuilder sb = new StringBuilder();
		if (null != code_ors && code_ors.size() > 0) {
			sb.append("where orsrv.sd_srvtp like '01%' and ( ");
			for (int i = 0; i < code_ors.size(); i++) {
				if (i == code_ors.size() - 1) {
					sb.append("ci.code_or= ? ");
				} else {
					sb.append("ci.code_or= ? or ");
				}
			}
		}
		sb.append(") ");
		return sb.toString();
	}

}
