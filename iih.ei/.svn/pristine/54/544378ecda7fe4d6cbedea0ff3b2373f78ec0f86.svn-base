package iih.ei.std.consis.v1.task.bp.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询药房窗口字典
 * 
 * @author hao_wu 2018-12-14
 *
 */
public class FindWinDicQry implements ITransQry {

	/**
	 * 药房主键
	 */
	private String _pharmacyId;

	public FindWinDicQry(String pharmacyId) {
		this._pharmacyId = pharmacyId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._pharmacyId);
		sqlParam.addParam(IBdFcDictCodeConst.SD_QUESITETP_SENDM);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT QUESITE.CODE AS OPWINID_CODE,");
		sql.append("QUESITE.NAME AS OPWINID_NAME,");
		sql.append("BDDEP.CODE  AS DISPENSARY ");
		sql.append("FROM BD_QUE_SITE QUESITE ");
		sql.append("INNER JOIN BD_DEP BDDEP ");
		sql.append("ON QUESITE.ID_DEP = BDDEP.ID_DEP ");
		sql.append("WHERE BDDEP.ID_DEP = ? ");
		sql.append("AND QUESITE.SD_QUESITETP = ? ");
		sql.append("AND QUESITE.CODE IS NOT NULL ");
		return sql.toString();
	}

}
