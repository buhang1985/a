package iih.bd.fc.orderexesigndict.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getListSql implements ITransQry {

	public getListSql() {

	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam Param = new SqlParam();
		return Param;
	}

	@Override
	public String getQrySQLStr() {
		return getSqlStr();
	}

	private String getSqlStr() {

		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append("select *");
		SqlStr.append(" from bd_orpltpsta");
		SqlStr.append(" where ID_ORPLTPSTA not in");
		SqlStr.append(" (");
		SqlStr.append("  select distinct ID_PAR");
		SqlStr.append("  from bd_orpltpsta");
		SqlStr.append("  where nvl(id_par, '~') <> '~'");
		SqlStr.append(" )");
		SqlStr.append(" order by sortno asc");

		return SqlStr.toString();
	}

}
