package iih.ei.std.consis.v1.task.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询科室字典
 * 
 * @author hao_wu 2018-12-14
 *
 */
public class FindDeptDicQry implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT T.CODE AS DEPTCODE, ");
		sql.append("T.NAME AS DEPTNAME, ");
		sql.append("(CASE WHEN T.FG_OP='Y' THEN 1 ");
		sql.append("WHEN T.FG_IP='Y' THEN 2 ELSE 0 END) OUTP_OR_INP  ");
		sql.append("FROM BD_DEP T  ");
		sql.append("WHERE ((T.FG_OP='Y' AND T.FG_IP='N') OR (T.FG_OP='N' AND T.FG_IP='Y')) ");
		sql.append("AND T.CODE IS NOT NULL AND T.NAME IS NOT NULL ");
		return sql.toString();
	}
}
