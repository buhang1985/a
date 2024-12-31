package iih.bd.fc.mdwfcfg.s.bp.qry;

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
		SqlStr.append("from ");
		SqlStr.append("	(");
		SqlStr.append("	   select ID_WFCA as id,");
		SqlStr.append("			  code || ' ' || name as NAME,");
		SqlStr.append("			  id_parent,");
		SqlStr.append("			  'Y' as Fg_parent");
		SqlStr.append("	   from md_wfca");
		SqlStr.append("	   where md_wfca.ds = 0");
		SqlStr.append("	   union all ");
		SqlStr.append("	   (select ID_WF as id,");
		SqlStr.append("			   code || ' ' || Name as NAME,");
		SqlStr.append("			   ID_WFCA as id_parent,");
		SqlStr.append("			   'N' as Fg_parent");
		SqlStr.append("		from md_wf");
		SqlStr.append("		where md_wf.ds = 0 ");
		SqlStr.append("		)");
		SqlStr.append("	 )");
		SqlStr.append("order by NAME ASC");

		return SqlStr.toString();
	}

}
