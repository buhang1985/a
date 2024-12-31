package iih.ci.event.ord.bps.revert.op.query;

import iih.ci.event.ord.bps.revert.op.sql.OpBtRevertSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS008-备血 门诊撤回 检验项目信息
 * @author F
 *
 * @date 2019年10月10日上午11:08:46
 *
 * @classpath iih.ci.event.ord.bps.revert.op.query.OpBtRevertCheckInfoQuery
 */
public class OpBtRevertCheckInfoQuery implements ITransQry{

	private String _id_apbtobsindex;

	public OpBtRevertCheckInfoQuery(String id_apbtobsindex) {
		this._id_apbtobsindex = id_apbtobsindex;
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
	private String getSql() {// 【IEOpBtCdLisItmDTO】
		String id_abpt = OrdEventUtil.getSqlInOrEqualStrs(_id_apbtobsindex);
		String formatsql = new OpBtRevertSql().getOpBtRevertCheckInfoSql(id_abpt);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS008-备血 门诊撤回 检验项目信息 sql:" + formatsql);
		return formatsql;
	}
}
