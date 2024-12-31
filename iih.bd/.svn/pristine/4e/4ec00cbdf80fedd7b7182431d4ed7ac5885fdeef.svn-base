package iih.bd.pp.baseprisrv.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.prisrv.d.PriSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class FindBaseSrvPriQry implements ITransQry {

	private String _whereStr;
	private String _orderStr;

	public FindBaseSrvPriQry(String whereStr, String orderStr) {
		this._whereStr = whereStr;
		this._orderStr = orderStr;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		String baseSql = getBaseSql();
		sqlBuilder.append(baseSql);

		String wherePart = getWherePart();
		sqlBuilder.append(" where ");
		sqlBuilder.append(wherePart);

		if (StringUtils.isNotBlank(this._orderStr)) {
			sqlBuilder.append(" order by ");
			sqlBuilder.append(this._orderStr);
		}
		return sqlBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT BD_PRI_SRV.ID_PRISRV AS ID_SRVPRI,");
		sqlBuilder.append("BD_PRI_SRV.ID_GRP,");
		sqlBuilder.append("BD_PRI_SRV.ID_ORG,");
		sqlBuilder.append("BD_PRI_SRV.ID_SRV,");
		sqlBuilder.append("BD_PRI_SRV.PRICE,");
		sqlBuilder.append("BD_PRI_SRV.DT_B,");
		sqlBuilder.append("BD_PRI_SRV.DT_E,");
		sqlBuilder.append("BD_PRI_SRV.DES,");
		sqlBuilder.append("BD_PRI_SRV.CREATEDBY,");
		sqlBuilder.append("BD_PRI_SRV.CREATEDTIME,");
		sqlBuilder.append("BD_PRI_SRV.MODIFIEDBY,");
		sqlBuilder.append("BD_PRI_SRV.MODIFIEDTIME,");
		sqlBuilder.append("BD_PRI_SRV.DS,");
		sqlBuilder.append("BD_PRI_SRV.SV ");
		sqlBuilder.append("FROM BD_PRI_SRV ");
		return sqlBuilder.toString();
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("ds = 0");

		String bdModeWherePart = BdEnvContextUtil.processEnvContext(new PriSrvDO(), false);
		if (StringUtils.isNotBlank(bdModeWherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(bdModeWherePart);
		}

		if (StringUtils.isNotBlank(this._whereStr)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(this._whereStr);
		}

		return wherePartBuilder.toString();
	}
}
