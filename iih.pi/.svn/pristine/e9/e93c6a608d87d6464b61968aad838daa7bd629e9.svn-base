package iih.pi.reg.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import iih.bd.utils.BdEnvContextUtil;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pattag.d.PatTagDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者标签个数查询
 * 
 * @author hao_wu
 *
 */
public class FindPatTagCountQry implements ITransQry {

	/**
	 * 患者编码
	 */
	private String _patCode;

	/**
	 * 标签类型编码
	 */
	private String _tagTpCode;

	public FindPatTagCountQry(String patCode, String tagTpCode) {
		this._patCode = patCode;
		this._tagTpCode = tagTpCode;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._tagTpCode);
		sqlParam.addParam(this._patCode);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		String baseSql = getBaseSql();
		sqlBuilder.append(baseSql);

		String wherePart = getWherePart();
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" WHERE ");
			sqlBuilder.append(wherePart);
		}

		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @author hao_wu
	 * @return
	 */
	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		// 标签管控
		String wherePart = BdEnvContextUtil.processEnvContext(new PatTagDO(), "PATTAG");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		// 标签类型编码
		wherePartBuilder.append(" AND PATTAG.SD_PATTAGTP = ?");

		// 根据患者编码确定患者主键范围
		wherePartBuilder.append(" AND PATTAG.ID_PAT IN (SELECT ID_PAT FROM PI_PAT PAT WHERE CODE = ?");

		// 患者管控
		wherePart = BdEnvContextUtil.processEnvContext(new PatDO(), "PAT");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		wherePartBuilder.append(")");

		return wherePartBuilder.toString();
	}

	/**
	 * 获取基础SQL
	 * 
	 * @author hao_wu
	 * @return
	 */
	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT COUNT(*)	AS PATTAGCOUNT ");
		sqlBuilder.append(" FROM PI_PAT_TAG PATTAG ");
		return sqlBuilder.toString();
	}
}
