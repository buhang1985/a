package iih.ci.event.ord.bps.revert.op.query;

import iih.ci.event.ord.bps.revert.op.sql.OpRisRevertSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS002门诊检查撤回 联系人
 * @author F
 *
 * @date 2019年9月11日上午11:58:59
 *
 * @classpath iih.ci.event.ord.bps.revert.op.query.OpRisRevertContacterQuery
 */
public class OpRisRevertContacterQuery implements ITransQry{

	private String _id_ors;
	
	public OpRisRevertContacterQuery(String id_ors) {
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
		 String formatsql=new OpRisRevertSql().getOpRisWithDrawContacterInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS002门诊检查撤回 联系人sql:"+formatsql);
		 return formatsql;
	}

}
