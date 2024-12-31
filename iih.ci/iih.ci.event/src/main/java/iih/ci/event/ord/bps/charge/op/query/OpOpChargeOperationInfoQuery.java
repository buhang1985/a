package iih.ci.event.ord.bps.charge.op.query;

import iih.ci.event.ord.bps.charge.op.sql.OpOpChargeSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS007 门诊收费手术 医嘱信息
 * @author F
 *
 * @date 2019年9月12日下午5:11:26
 *
 * @classpath iih.ci.event.ord.bps.charge.op.query.OpOpChargeOperationInfoQuery
 */
public class OpOpChargeOperationInfoQuery implements ITransQry{

	private String id_ors;

	public OpOpChargeOperationInfoQuery(String id_ors) {
		this.id_ors = id_ors;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}
	
	/**
	 * 获取手术医嘱
	 * @return
	 */
	public String getSql() {//【IEOperationInfoDTO】
		String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(id_ors);
		String formatsql=new OpOpChargeSql().getOpOpChargeOperationInfoSql(id_or4sql);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS007 门诊收费手术 医嘱信息sql:"+formatsql);
		return formatsql;
	}
}
