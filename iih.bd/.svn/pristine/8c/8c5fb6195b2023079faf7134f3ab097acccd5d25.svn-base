package iih.bd.fc.wf.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.org.d.desc.OrgDODesc;

public class getOrgSql implements ITransQry {

	private String Id_org;

	public getOrgSql(String id_org) {
		Id_org = id_org;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(Id_org);

		return param;
	}

	@Override
	public String getQrySQLStr() {

		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append("select * from " + OrgDODesc.TABLE_NAME + " where id_org=?");

		return SqlStr.toString();
	}
}
