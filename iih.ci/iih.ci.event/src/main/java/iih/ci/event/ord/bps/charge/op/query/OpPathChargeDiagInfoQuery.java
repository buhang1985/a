package iih.ci.event.ord.bps.charge.op.query;

import iih.ci.event.ord.bps.charge.op.sql.OpPathChargeSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 *  门诊 病理 收费 诊断信息
 * @author F
 *
 * @date 2020年1月20日上午10:34:53
 *
 * @classpath iih.ci.event.ord.bps.charge.op.query.OpPathChargeDiagInfoQuery
 */
public class OpPathChargeDiagInfoQuery implements ITransQry{

	private String id_ors;
	
	public OpPathChargeDiagInfoQuery(String id_ors) {
		this.id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}
	@Override
	public String getQrySQLStr() {
		//门诊 收费 病理诊断信息【IEOpPathDiagDTO】
		String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(id_ors);
		String formatsql=new OpPathChargeSql().getOpPathChargeDiagInfoSql(id_or4sql);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS452-门诊 病理 收费 诊断信息sql:"+formatsql);
		return formatsql;
	}

}