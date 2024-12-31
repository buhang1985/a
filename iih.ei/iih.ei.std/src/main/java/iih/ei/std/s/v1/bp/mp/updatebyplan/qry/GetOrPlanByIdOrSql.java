package iih.ei.std.s.v1.bp.mp.updatebyplan.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description: 查询医嘱计划
 * @author: ma.meng@founder.com.cn
 * @version： 2019年12月9日 上午11:47:05 创建
 */
public class GetOrPlanByIdOrSql implements ITransQry {

	private String[] id_ors;

	public GetOrPlanByIdOrSql(String[] id_ors) {
		this.id_ors = id_ors;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam sqlParam = new SqlParam();
		if (id_ors != null && id_ors.length > 0) {
			for (String string : id_ors) {
				sqlParam.addParam(string);
			}
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append(" select orpr.id_or_pr,									");
		sqlBuffer.append(" cior.id_or,												");
		sqlBuffer.append(" cior.id_en as id_ent,									");
		sqlBuffer.append(" cior.code_entp,											");
		sqlBuffer.append(" orpr.dt_mp_plan,											");
		sqlBuffer.append(" cior.applyno,											");
		sqlBuffer.append(" cior.name_or,											");
		sqlBuffer.append(" cior.fg_canc,											");
		sqlBuffer.append(" pat.name as name_pat										");
		sqlBuffer.append(" from mp_or_pr orpr										");
		sqlBuffer.append(" inner join ci_order cior on cior.id_or=orpr.id_or  		");
		sqlBuffer.append(" inner join pi_pat pat on pat.id_pat=orpr.id_pat      	");
		sqlBuffer.append(" where 											      	");
		if (id_ors != null && id_ors.length > 0) {
			String cond = "";
			for (int i = 0; i < id_ors.length; i++) {
				cond += (cond.length() == 0 ? "?" : ",?");
			}
			sqlBuffer.append(" cior.id_or in (" + cond + ")");
		} else {
			sqlBuffer.append(" 1=2 ");
		}
		return sqlBuffer.toString();
	}
}

