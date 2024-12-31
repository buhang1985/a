package iih.bd.pp.hpdivshisdto.s.bp.sql;

import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 清空医保病种目录对照SQL
 * 
 * @author hao_wu
 *
 */
public class ClearDiCompDataSql implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlbuilder = new StringBuilder();
		sqlbuilder.append("DELETE FROM BD_HP_DI_VS_HIS WHERE ID_GRP = ? AND ID_ORG = ?");
		return sqlbuilder.toString();
	}
}
