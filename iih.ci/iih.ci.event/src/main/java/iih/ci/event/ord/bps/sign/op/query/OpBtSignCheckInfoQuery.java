package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpBtSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * BS008-备血 门诊签署 检验项目信息
 * 
 * @author F
 *
 * @date 2019年8月22日上午10:55:42
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpBtSignCheckInfoQuery
 */
public class OpBtSignCheckInfoQuery implements ITransQry {

	private String _id_apbtobsindex;

	public OpBtSignCheckInfoQuery(String id_apbtobsindex) {
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
		String formatsql = new OpBtSignSql().getOpBtSignCheckInfoSql(id_abpt);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS008-备血 门诊签署 检验项目信息 sql:" + formatsql);
		return formatsql;
	}

}
