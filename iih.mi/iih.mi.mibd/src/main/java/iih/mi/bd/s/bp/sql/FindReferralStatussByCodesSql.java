package iih.mi.bd.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.mi.mibd.mis.d.MisDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据转诊状态编码集合查询转诊状态基础信息集合sql语句
 * 
 * @author hexx
 *
 */
public class FindReferralStatussByCodesSql implements ITransQry {
	
	private String _wherePart;
	
	public FindReferralStatussByCodesSql(String misId,String wherePart){
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return null;
	}

	@Override
	public String getQrySQLStr() {
		String sql = GetBaseSql();
		String wherePart = GetWherePart();
		return String.format("%s WHERE %s", sql, wherePart);
	}

	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = BdEnvContextUtil.processEnvContext(new MisDO(), "MI_BD_MIS");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotEmpty(this._wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}

		return wherePartBuilder.toString();
	}
	

	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ID_medpaytp,  ");
		sqlBuilder.append("  ID_GRP,	   ");
		sqlBuilder.append("  ID_ORG,	   ");
		sqlBuilder.append("  CODE,	   ");
		sqlBuilder.append("  NAME,	   ");
		sqlBuilder.append("  ID_MIS,	   ");
		sqlBuilder.append(" FROM MI_BD_MEDPAYTP  ");
		sqlBuilder.append(" WHERE ID_MIS = ?  ");
		return sqlBuilder.toString();
	}
}
