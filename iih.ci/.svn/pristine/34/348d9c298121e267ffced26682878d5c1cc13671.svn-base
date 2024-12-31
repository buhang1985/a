package iih.ci.event.ord.bps.refund.query;

import iih.ci.event.ord.bps.refund.sql.OpDrugRefundSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS302门诊退费 处方收费+未收费所有信息
 * @author F
 *
 * @date 2019年11月18日下午1:26:54
 *
 * @classpath iih.ci.event.ord.bps.refund.query.OpDrugRefundPressAllInfoQuery
 */
public class OpDrugRefundPressAllInfoQuery implements ITransQry{

	private String _press;
	
	public OpDrugRefundPressAllInfoQuery(String press){
		this._press = press;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}

	private String getSql() {//【IEOpPharmPresDTO】
		String press = OrdEventUtil.getSqlInOrEqualStrs(_press);
		String sqlString = new OpDrugRefundSql().getOpDrugRefundPressAllInfoSql(press);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS302门诊退费 处方收费+未收费所有信息sql:"+sqlString+" param:"+press);
		return sqlString;
	}
}
