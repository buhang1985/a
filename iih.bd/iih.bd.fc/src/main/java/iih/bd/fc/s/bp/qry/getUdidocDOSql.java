package iih.bd.fc.s.bp.qry;

import iih.bd.bc.udi.pub.IMpNsDictCodeTypeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getUdidocDOSql implements ITransQry {

	private String[] Codes;

	public getUdidocDOSql(String[] codes) {
		Codes = codes;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();

		param.addParam(IMpNsDictCodeTypeConst.SD_SRVTP_CODE);

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

		SqlStr.append(" select doc.* from bd_udidoc doc ");
		SqlStr.append(" inner join bd_udidoclist doclist on doc.id_udidoclist=doclist.id_udidoclist ");
		SqlStr.append(" where doclist.code=? ");

		if (Codes != null && Codes.length > 0) {

			String whereStr = "";

			for (int i = 0; i < Codes.length; i++) {

				whereStr += (whereStr.length() == 0 ? "" : ",") + "?";
			}

			SqlStr.append(" and doc.code in(" + whereStr + ") ");

		} else {

			//SqlStr.append(" and 1=2 ");
		}

		return SqlStr.toString();
	}

}
