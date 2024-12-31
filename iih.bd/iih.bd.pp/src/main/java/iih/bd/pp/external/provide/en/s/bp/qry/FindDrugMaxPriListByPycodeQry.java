package iih.bd.pp.external.provide.en.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据拼音码查询药品价格列表SQL
 * 
 * @author hao_wu 2018-11-28
 *
 */
public class FindDrugMaxPriListByPycodeQry implements ITransQry {

	/**
	 * 拼音码
	 */
	private String _pyCode;

	public FindDrugMaxPriListByPycodeQry(String pyCode) {
		this._pyCode = pyCode;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();

		if (StringUtils.isNotBlank(this._pyCode)) {
			sqlParam.addParam(String.format("%%%s%%", this._pyCode.toUpperCase()));
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
		sqlBuilder.append("SELECT MM.ID_MM,");
		sqlBuilder.append("MM.CODE,");
		sqlBuilder.append("MM.NAME,");
		sqlBuilder.append("SRV.CODE AS APPROVEDCODE,");
		sqlBuilder.append("SRV.NAME AS APPROVEDNAME,");
		sqlBuilder.append("SRVORCA.CODE AS HP_CODE,");
		sqlBuilder.append("MM.PYCODE,");
		sqlBuilder.append("MM.SPEC,");
		sqlBuilder.append("MEASDOC.ID_MEASDOC ID_UNIT,");
		sqlBuilder.append("MEASDOC.NAME NAME_UNIT,");
		sqlBuilder.append("SRVTPDOC.NAME NAME_HPSRVTP,");
		sqlBuilder.append("MM.PRICE,");
		sqlBuilder.append("DOSAGEDOC.NAME NAME_DOSAGE,");
		sqlBuilder.append("SUP.NAME NAME_SUP,");
		sqlBuilder.append("NULL GRADE,");
		sqlBuilder.append("MM.PLACE ");
		sqlBuilder.append("FROM BD_MM MM ");
		sqlBuilder.append("INNER JOIN BD_SRV SRV ");
		sqlBuilder.append("ON SRV.ID_SRV = MM.ID_SRV ");
		sqlBuilder.append("INNER JOIN BD_SRV_DRUG SRVDRUG ");
		sqlBuilder.append("ON SRV.ID_SRV = SRVDRUG.ID_SRV ");
		sqlBuilder.append("INNER JOIN BD_MEASDOC MEASDOC ");
		sqlBuilder.append("ON MM.ID_UNIT_PKGSP = MEASDOC.ID_MEASDOC ");
		sqlBuilder.append("LEFT JOIN BD_HP_SRVORCA SRVORCA ");
		sqlBuilder.append("ON SRV.ID_SRV = SRVORCA.ID_SRV ");
		sqlBuilder.append("AND MM.ID_MM = SRVORCA.ID_MM ");
		sqlBuilder.append("INNER JOIN BD_SUP SUP ");
		sqlBuilder.append("ON MM.ID_SUP = SUP.ID_SUP ");
		sqlBuilder.append("LEFT JOIN BD_UDIDOC SRVTPDOC ");
		sqlBuilder.append("ON SRVORCA.ID_HPSRVTP = SRVTPDOC.ID_UDIDOC ");
		sqlBuilder.append("LEFT JOIN BD_UDIDOC DOSAGEDOC ");
		sqlBuilder.append("ON SRVDRUG.ID_DOSAGE = DOSAGEDOC.ID_UDIDOC ");

		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		if (StringUtils.isNotBlank(this._pyCode)) {
			wherePartBuilder.append(" AND UPPER(MM.PYCODE) like ?");
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
			orderPartBuilder.append("DECODE(INSTR(UPPER(MM.PYCODE),?),1, 1, 2 ),");
		}

		orderPartBuilder.append("LENGTH(MM.PYCODE),SRV.CODE,MM.CODE");
		return orderPartBuilder.toString();
	}
}
