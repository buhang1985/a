package iih.bd.pp.s.external.provide.bp.qry;

import org.apache.commons.lang.StringUtils;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据拼音码查询诊疗价格列表SQL
 * 
 * @author hao_wu 2018-6-12
 *
 */
public class FindTreatPriListByPycodeQry implements ITransQry {

	/**
	 * 拼音码
	 */
	private String _pyCode;

	public FindTreatPriListByPycodeQry(String pyCode) {
		this._pyCode = pyCode;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();

		if (StringUtils.isNotBlank(this._pyCode)) {
			sqlParam.addParam(String.format("%%%s%%", this._pyCode));
			sqlParam.addParam(this._pyCode.toUpperCase());
		}

		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		String baseSql = GetBaseSql();
		sqlBuilder.append(baseSql);
		String wherePart = GetWherePart();
		sqlBuilder.append(" WHERE ");
		sqlBuilder.append(wherePart);
		String orderPart = getOrderPart();
		if (StringUtils.isNotEmpty(orderPart)) {
			sqlBuilder.append(" ORDER BY ");
			sqlBuilder.append(orderPart);
		}

		return sqlBuilder.toString();
	}

	/**
	 * 获取基础SQL
	 * 
	 * @return
	 */
	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT SRV.CODE,");
		sqlBuilder.append("SRV.NAME || '(' || PAT.NAME || ')' AS NAME,");
		sqlBuilder.append("SRVORCA.CODE AS HP_CODE,");
		sqlBuilder.append("SRVORCA.DES,");
		sqlBuilder.append("UNIT.NAME UNIT_NAME,");
		sqlBuilder.append("SRV.PYCODE,");
		sqlBuilder.append("PRISRV.PRICE_RATIO AS PRICE,");
		sqlBuilder.append("SRV.DES_PRI PRI_DES,");
		sqlBuilder.append("SANI.SUP_NAME AS FACTORY_NAME,");
		sqlBuilder.append("SANI.APPRNO,");
		sqlBuilder.append("PAT.NAME AS PRI_PAT ");
		sqlBuilder.append("FROM VIEW_PRICE_RP PRISRV ");
		sqlBuilder.append("INNER JOIN BD_SRV SRV ");
		sqlBuilder.append("ON PRISRV.ID_SRV = SRV.ID_SRV ");
		sqlBuilder.append("INNER JOIN BD_PRI_SRV PRISRV1 ");
		sqlBuilder.append("ON PRISRV.ID_SRV = PRISRV1.ID_SRV ");
		sqlBuilder.append("INNER JOIN BD_PRI_PAT PAT ");
		sqlBuilder.append("ON PRISRV.ID_PRIPAT = PAT.ID_PRIPAT ");
		sqlBuilder.append("LEFT JOIN BD_SRV_SANI SANI ");
		sqlBuilder.append("ON PRISRV.ID_SRV=SANI.ID_SRV ");
		sqlBuilder.append("LEFT JOIN BD_HP_SRVORCA SRVORCA ");
		sqlBuilder.append("ON PRISRV.ID_SRV = SRVORCA.ID_SRV ");
		sqlBuilder.append("LEFT JOIN BD_MEASDOC UNIT ");
		sqlBuilder.append("ON SRV.ID_UNIT_MED = UNIT.ID_MEASDOC ");

		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder();
		String wherePart = "PRISRV1.DT_E = '2099-12-31 23:59:59' AND SRV.FG_MM　=　'N'";
		wherePartBuilder.append(wherePart);

		if (StringUtils.isNotBlank(this._pyCode)) {
			wherePartBuilder.append(" AND UPPER(SRV.PYCODE) like ?");
		}

		return wherePartBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String getOrderPart() {
		StringBuilder orderPartBuilder = new StringBuilder();

		if (StringUtils.isNotBlank(this._pyCode)) {
			orderPartBuilder.append("DECODE(INSTR(UPPER(SRV.PYCODE),?),1, 1, 2 )");
		} else {
			orderPartBuilder.append("SRV.PYCODE");
		}
		return orderPartBuilder.toString();
	}

}
