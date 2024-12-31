package iih.ei.std.s.v1.bp.pe.updatebyplan.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据医嘱ID和计划执行时间取计划信息
 * @Description:
 * @author: huang_junhao@founder.com.cn
 * @version：2019年9月30日17:30:15
 */
public class QueryPlanSql implements ITransQry{

	private String TableName;

	public QueryPlanSql(String tableName){
		TableName = tableName;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {

		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append(" select orpr.*                       ");
		SqlStr.append(" from mp_or_pr orpr                  ");
		SqlStr.append(" inner join " + TableName + " temp   ");
		SqlStr.append(" on orpr.id_or=temp.id_or            ");
		SqlStr.append(" and orpr.dt_mp_plan=temp.dt_mp_plan ");
		//SqlStr.append(" where " + new MpEnvContextUtil().getWherePart(new MpOrPlanDO(), "orpr"));//2017-06-09_增加管控_xuxing

		return SqlStr.toString();
	}
}
