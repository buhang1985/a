package iih.ci.event.ord.bps.revert.op.query;

import iih.ci.event.ord.bps.revert.op.sql.OpDrugRevertSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS302 门诊 处方撤回 处方信息
 * @author F
 *
 * @date 2019年9月11日下午12:00:15
 *
 * @classpath iih.ci.event.ord.bps.revert.op.query.OpDrugRevertPressInfoQuery
 */
public class OpDrugRevertPressInfoQuery implements ITransQry {

	private String _iden;

	public OpDrugRevertPressInfoQuery(String id_en) {
		this._iden = id_en;
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
	private String getSql() {// 【IEOpPharmPresDTO】
		String sql = new OpDrugRevertSql().getOpDrugWithDrawPressInfoSql();
		sql = String.format(sql,
				" p.id_or in (select id_or from ci_order where id_en = '" + _iden+ "'  and fg_sign='Y' and fg_canc='N' and sd_srvtp like '01%') " 
						+ " and p.id_su_bl in('"+ OrdEventUtil.ID_SU_BL_1 + "','" + OrdEventUtil.ID_SU_BL_0 + "')");
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS302 门诊 处方撤回 处方信息sql:" + sql);
		return sql;
	}

}
