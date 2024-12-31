package iih.ci.event.ord.bps.revert.op.query;

import iih.ci.event.ord.bps.revert.op.sql.OpOpRevertSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS005  门诊 手术撤回 所有信息
 * @author F
 *
 * @date 2019年9月11日上午11:59:13
 *
 * @classpath iih.ci.event.ord.bps.revert.op.query.OpOpRevertAllInfoQuery
 */
public class OpOpRevertAllInfoQuery implements ITransQry{

	private String _id_ors;
	public OpOpRevertAllInfoQuery(String id_ors) {
		this._id_ors=id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer var1) {
		SqlParam sqlpram = new SqlParam();
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}

	private String  getSql() {//主1【IEOpOrCancStpEnDTO】子2【IEOpOrCancStpDTO】
		String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		String formatsql=new OpOpRevertSql().getOpOpWithDrawAllInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS005  门诊 手术撤回 所有信息sql:"+formatsql);
		return formatsql;
	}
}
