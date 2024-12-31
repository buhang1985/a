package iih.bd.srv.emrtpl.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取新序号Sql
 * 
 * @author hao_wu
 *
 */
public class GetNewOrderIdSql implements ITransQry {

	private EmrTplDO _emrTplDo;

	public GetNewOrderIdSql(EmrTplDO emrTplDo) {
		this._emrTplDo = emrTplDo;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._emrTplDo.getId_mrtp());
		sqlParam.addParam(this._emrTplDo.getSd_owtp());
		
		if (this._emrTplDo != null && this._emrTplDo.getId_dept() != null) {
			sqlParam.addParam(this._emrTplDo.getId_dept());
		}

		if (this._emrTplDo != null && this._emrTplDo.getId_emp() != null) {
			sqlParam.addParam(this._emrTplDo.getId_emp());
		}
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
	 * 获取主sql
	 * 
	 * @return
	 */
	private String getBaseSql() {
		return " SELECT NVL(MAX(ORDERID),0) FROM BD_MRTPL ";
	}

	/**
	 * 获取sql的where条件
	 * 
	 * @return
	 */
	private String getWherePart() {
		StringBuilder sb = new StringBuilder(" 1 = 1 ");
		
		sb.append(" AND  " + BdEnvContextUtil.processEnvContext(new EmrTplDO(), false));
		sb.append(" AND ID_MRTP = ? AND SD_OWTP = ? ");

		if (this._emrTplDo != null && this._emrTplDo.getId_dept() != null) {
			sb.append(" AND ID_DEPT = ? ");
		}

		if (this._emrTplDo != null && this._emrTplDo.getId_emp() != null) {
			sb.append(" AND ID_EMP = ? ");
		}

		return sb.toString();
	}

}
