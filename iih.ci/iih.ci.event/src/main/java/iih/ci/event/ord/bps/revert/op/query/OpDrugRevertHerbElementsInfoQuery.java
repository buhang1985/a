package iih.ci.event.ord.bps.revert.op.query;

import iih.ci.event.ord.bps.revert.op.sql.OpDrugRevertSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * BS302 门诊 处方撤回 草药明细
 * @author F
 *
 * @date 2019年9月11日下午12:00:50
 *
 * @classpath iih.ci.event.ord.bps.revert.op.query.OpDrugRevertHerbElementsInfoQuery
 */
public class OpDrugRevertHerbElementsInfoQuery implements ITransQry {

	private String _id_preses;

	public OpDrugRevertHerbElementsInfoQuery(String id_preses) {
		this._id_preses = id_preses;
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
	private String getSql() {// 【IEOpPharmOrMmDTO】
		String formatsql = new OpDrugRevertSql().getOpDrugWithDrawHerbElementsInfoSql();
		String id_or4sql = OrdEventUtil.getSqlInOrEqualStrs(_id_preses) + getFilterSql();
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS302 门诊 处方撤回 草药明细sql:"+ String.format(formatsql, "A1.Id_Pres" + id_or4sql));
		return String.format(formatsql, "A1.Id_Pres" + id_or4sql);
	}

	private String getFilterSql() {
		return " and (A1.sd_srvtp like '0103%' )";
	}

}
