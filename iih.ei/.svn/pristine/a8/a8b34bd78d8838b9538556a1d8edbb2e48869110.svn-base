package iih.ei.std.s.v1.bp.mp.common.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetUdidocListByCodesSql implements ITransQry {

	private String[] Codes;

	public GetUdidocListByCodesSql(String[] codes) {
		Codes = codes;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();

		if (Codes != null && Codes.length > 0) {

			for (String code : Codes) {

				param.addParam(code);
			}
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		return getSqlStr();
	}

	public String getSqlStr() {

		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append(" select doc.*,doclist.code as udi_code,doclist.name as udi_name from bd_udidoc doc ");
		SqlStr.append(" inner join bd_udidoclist doclist on doclist.id_udidoclist=doc.id_udidoclist ");
		if (Codes != null && Codes.length > 0) {
			String whereStr = "";
			for (int i = 0; i < Codes.length; i++) {
				whereStr += (whereStr.length() == 0 ? "" : ",") + "?";
			}
			SqlStr.append(" and doclist.code in(" + whereStr + ") ");
		} else {
			SqlStr.append(" and 1=2 ");
		}
		//SqlStr.append(" where " + new MpNrEnvContextUtil().getWherePart(new UdidocDO(), "doc"));//2017-06-09_增加管控_xuxing
		SqlStr.append(" order by doc.code asc ");
		return SqlStr.toString();

	}
}
