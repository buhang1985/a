package iih.ei.std.viewhigh.v1.s.bp.qry;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据耗材条码获取医疗服务主键查询
 * 
 * @author hao_wu 2018-11-23
 *
 */
public class FindSrvIdByCodeQry implements ITransQry {

	private String _srvCode;

	public FindSrvIdByCodeQry(String srvCode) {
		this._srvCode = srvCode;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._srvCode);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select id_srv from bd_srv where code = ?");

		String wherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), false);
		sqlBuilder.append(" and ");
		sqlBuilder.append(wherePart);
		return sqlBuilder.toString();
	}

}
