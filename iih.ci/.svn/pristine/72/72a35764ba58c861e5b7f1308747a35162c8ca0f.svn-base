package iih.ci.event.ord.bps.refund.query;

import iih.ci.event.ord.bps.refund.sql.OpRisLisRefundSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS005 门诊检查检验退费 主子信息(主 就诊，子  医嘱)
 * @author F
 *
 * @date 2019年9月17日下午3:21:51
 *
 * @classpath iih.ci.event.ord.bps.refund.query.OpRisLisRefundAllInfoQuery
 */
public class OpRisLisRefundAllInfoQuery implements ITransQry{

	private String _id_ors;

	public OpRisLisRefundAllInfoQuery(String id_ors) {
		this._id_ors = id_ors;
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

	/**
	 * 获得查询sql串
	 * 
	 * @return
	 */
	private String getSql() {//就诊1【IEOpOrCancStpEnDTO】医嘱2【IEOpOrCancStpDTO】
		String string=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		String formatsql = new OpRisLisRefundSql().getOpRisLisRefundAllInfoSql();
		String sqlString = String.format(formatsql, string);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS005 门诊检查检验退费 主子信息sql:" + sqlString);
		return sqlString;
	}
}
