package iih.ci.event.ord.bps.revert.op.query;

import iih.ci.event.ord.bps.revert.op.sql.OpDrugRevertSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * BS302门诊 处方撤回 就诊信息
 * @author F
 *
 * @date 2019年9月11日下午12:00:58
 *
 * @classpath iih.ci.event.ord.bps.revert.op.query.OpDrugRevertEntInfoQuery
 */
public class OpDrugRevertEntInfoQuery implements ITransQry {

	private String _id_or;

	public OpDrugRevertEntInfoQuery(String id_or) {
		this._id_or = id_or;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam(this._id_or);
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}

	/**
	 * 获得查询sql串
	 * 
	 * @return
	 */
	private String getSql() {// 【IEOpPharmOrEnDTO】
		String sqlString = new OpDrugRevertSql().getOpDrugWithDrawEntInfoSql();
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS302门诊 处方撤回 就诊信息sql:" + sqlString + " param:" + this._id_or);
		return sqlString;
	}
}
