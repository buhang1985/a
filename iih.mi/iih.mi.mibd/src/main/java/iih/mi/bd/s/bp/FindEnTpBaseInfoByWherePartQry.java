package iih.mi.bd.s.bp;

import org.apache.commons.lang.StringUtils;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据条件语句查询就诊类型基础数据
 * 
 * @author hao_wu
 *
 */
public class FindEnTpBaseInfoByWherePartQry implements ITransQry {

	/**
	 * 条件语句
	 */
	private String _whereStr;

	public FindEnTpBaseInfoByWherePartQry(String wherePart) {
		this._whereStr = wherePart;
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
		sqlBuilder.append(" WHERE ");
		sqlBuilder.append(wherePart);

		return sqlBuilder.toString();
	}

	/**
	 * 获取基础SQL
	 * 
	 * @return
	 */
	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append(" SELECT ENTPCOMP.ID_GRP,				");
		sqlBuilder.append("   ENTPCOMP.ID_ORG,					");
		sqlBuilder.append("   ENTPCOMP.ID_HP,					");
		sqlBuilder.append("   ENTPCOMP.ID_ENTP,					");
		sqlBuilder.append("   BDENTP.ENTP_CODE,					");
		sqlBuilder.append("   BDENTP.ENTP_NAME,					");
		sqlBuilder.append("   ENTPCOMP.CODE_ENTP AS CODE_HPENTP,		");
		sqlBuilder.append("   HPENTP.NAME        AS NAME_HPENTP			");
		sqlBuilder.append(" FROM BD_MHI_COMP_ENTP ENTPCOMP			");
		sqlBuilder.append(" LEFT JOIN BD_MHI_ENTP HPENTP			");
		sqlBuilder.append(" ON ENTPCOMP.CODE_ENTP = HPENTP.CODE			");
		sqlBuilder.append(" LEFT JOIN BD_ENTP BDENTP				");
		sqlBuilder.append(" ON ENTPCOMP.ID_ENTP     = BDENTP.ID_ENTP		");

		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		if (StringUtils.isNotEmpty(this._whereStr)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._whereStr);
		}

		return wherePartBuilder.toString();
	}

}
