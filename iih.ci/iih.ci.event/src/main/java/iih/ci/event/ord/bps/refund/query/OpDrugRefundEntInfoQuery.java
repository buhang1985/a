package iih.ci.event.ord.bps.refund.query;

import iih.ci.event.ord.bps.refund.sql.OpDrugRefundSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * BS302 门诊处方退费 就诊信息
 * 
 * @author F
 *
 * @date 2019年9月17日上午10:08:37
 *
 * @classpath iih.ci.event.ord.bps.refund.query.OpDrugRefundEntInfoQuery
 */
public class OpDrugRefundEntInfoQuery implements ITransQry {

	private String _id_or;

	public OpDrugRefundEntInfoQuery(String id_or) {
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
		String sqlString = new OpDrugRefundSql().getOpDrugRefundEntInfoSql();
		OrdEventLogger.info(this.getClass().getSimpleName(),
				"BS302 门诊处方退费 就诊信息sql:" + sqlString + "--param:" + this._id_or);
		return sqlString;
	}
}
