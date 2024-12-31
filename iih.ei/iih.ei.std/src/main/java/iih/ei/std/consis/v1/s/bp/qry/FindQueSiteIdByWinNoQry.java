package iih.ei.std.consis.v1.s.bp.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据窗口号查询窗口主键
 * 
 * @author hao_wu 2018-11-23
 *
 */
public class FindQueSiteIdByWinNoQry implements ITransQry {

	private String _winNo;
	private String _depId;

	public FindQueSiteIdByWinNoQry(String winNo, String depId) {
		this._winNo = winNo;
		this._depId = depId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._winNo);
		sqlParam.addParam(this._depId);
		sqlParam.addParam(IBdFcDictCodeConst.SD_QUESITETP_SENDM);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select id_quesite from bd_que_site where code = ? and id_dep = ?");
		sqlBuilder.append(" and sd_quesitetp = ?");

		String wherePart = BdEnvContextUtil.processEnvContext(new QueSiteDO(), false);
		sqlBuilder.append(" and ");
		sqlBuilder.append(wherePart);

		return sqlBuilder.toString();
	}

}
