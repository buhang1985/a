package iih.mi.bd.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mhi.hpadmstatusdircomp.d.HpAdmstatusDirCompDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据HIS入院状态主键集合查询医保入院状态字典SQL
 * 
 * @author hao_wu
 *
 */
public class FindAdmStatusMapByHisIdsSql implements ITransQry {

	/**
	 * 医保产品主键
	 */
	private String _hpId;
	/**
	 * HIS入院状态主键集合
	 */
	private String[] _hisAdmStatusIds;

	public FindAdmStatusMapByHisIdsSql(String hpId, String[] hisAdmStatusIds) {
		this._hpId = hpId;
		this._hisAdmStatusIds = hisAdmStatusIds;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._hpId);

		SqlUtils.addParamValue(sqlParam, this._hisAdmStatusIds);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = getBaseSql();
		String wherePart = getWherePart();
		return String.format(" %s WHERE %s ", sql, wherePart);
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = BdEnvContextUtil.processEnvContext(new HpAdmstatusDirCompDO(), "COMP");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		wherePartBuilder.append(" AND COMP.ID_HP = ?");

		wherePart = SqlUtils.getInSqlByParamValues("COMP.ID_LEVELDISE", this._hisAdmStatusIds);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}

	/**
	 * 获取基础SQL
	 * 
	 * @return
	 */
	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT COMP.ID_ADMSTATUSDIRCOMP, ");
		sqlBuilder.append(" COMP.ID_GRP, ");
		sqlBuilder.append(" COMP.ID_ORG, ");
		sqlBuilder.append(" COMP.ID_HP, ");
		sqlBuilder.append(" COMP.CODE, ");
		sqlBuilder.append(" COMP.ID_ADMSTATUS, ");
		sqlBuilder.append(" COMP.NAME, ");
		sqlBuilder.append(" COMP.ID_LEVELDISE, ");
		sqlBuilder.append(" LEVELDISE.CODE AS CODE_LEVELDISE, ");
		sqlBuilder.append(" LEVELDISE.NAME AS NAME_LEVELDISE ");
		sqlBuilder.append(" FROM BD_HP_COMP_ADMSTATUS COMP ");
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC LEVELDISE ");
		sqlBuilder.append(" ON LEVELDISE.ID_UDIDOC = COMP.ID_LEVELDISE ");
		return sqlBuilder.toString();
	}
}
