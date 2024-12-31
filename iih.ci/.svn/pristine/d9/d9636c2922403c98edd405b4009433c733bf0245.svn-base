package iih.ci.event.ord.bps.charge.op.query;

import iih.ci.event.ord.bps.charge.op.sql.OpRisChargeSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS002 门诊检查收费 联系人信息
 * @author F
 *
 * @date 2019年9月11日下午4:41:42
 *
 * @classpath iih.ci.event.ord.bps.charge.op.query.OpRisChargeContacterQuery
 */
public class OpRisChargeContacterQuery implements ITransQry{

	private String _id_ors;
	
	public OpRisChargeContacterQuery(String id_ors) {
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
	
	private String getSql() {//【IEOpRisOrContacterDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 String formatsql=new OpRisChargeSql().getOpRisChargeContacterInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS002 门诊检查收费 联系人信息sql:"+formatsql);
		 return formatsql;
	}
}
