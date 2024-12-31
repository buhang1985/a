package iih.bd.fc.orderloopseqno.s.bp.qry;

import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getTreeListSql implements ITransQry {

	public getTreeListSql() {

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

	public String getSqlStr() {

		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append("select temtable.id,temtable.name,temtable.id_parent from ( ");
		SqlStr.append("( ");
		SqlStr.append("  select  ");
		SqlStr.append("  orpltp.id_orpltp as id, ");
		SqlStr.append("  orpltp.name, ");
		SqlStr.append("  '~' as id_parent, ");
		SqlStr.append("  orpltp.sortno ");
		SqlStr.append("  from bd_orpltp orpltp ");
		SqlStr.append("  and " + new BdFcEnvContextUtil().getWherePart(new OrpltpDO(), "orpltp"));
		SqlStr.append(") ");
		SqlStr.append("union all ");
		SqlStr.append("( ");
		SqlStr.append("  select ");
		SqlStr.append("  orpltpsta.id_orpltpsta as id, ");
		SqlStr.append("  orpltpsta.name, ");
		SqlStr.append("  case nvl(id_par,'~') when  '~' then id_orpltp else orpltpsta.id_par  end as id_parent, ");
		SqlStr.append("  orpltpsta.sortno ");
		SqlStr.append("  from bd_orpltpsta orpltpsta");
		SqlStr.append("  and " + new BdFcEnvContextUtil().getWherePart(new OrpltpStaDO(), "orpltpsta"));
		SqlStr.append(") ");
		SqlStr.append(")temtable  order by temtable.sortno asc");

		return SqlStr.toString();

	}

}
