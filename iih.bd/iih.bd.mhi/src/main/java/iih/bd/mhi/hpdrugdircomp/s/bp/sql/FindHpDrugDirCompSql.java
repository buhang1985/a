package iih.bd.mhi.hpdrugdircomp.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.mhi.docenum.d.DirCompState;
import iih.bd.mhi.hpdrug.d.HpDrugDO;
import iih.bd.mhi.hpdrugdircomp.d.HpDrugDirCompDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 查询药品对照SQL
 * 
 * @author hexx
 *
 */
public class FindHpDrugDirCompSql implements ITransQry {
	private String _wherePart;
	private String _hpId;
	private String _refId;

	public FindHpDrugDirCompSql(String hpId, String wherePart) {
		this._wherePart = wherePart;
		this._hpId = hpId;
	}
	
	public FindHpDrugDirCompSql(String refId, String hpId, String wherePart) {
		this._wherePart = wherePart;
		this._hpId = hpId;
		this._refId = refId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(DirCompState.NOT_COMP);
		if(this._refId == null) {
			sqlParam.addParam(this._hpId);
			sqlParam.addParam(this._hpId);
		}else {
			sqlParam.addParam(this._refId);
			sqlParam.addParam(this._refId);
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = GetBaseSql();
		String wherePart = GetWherePart();
		return String.format("%s WHERE %s", sql, wherePart);
	}

	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		if (this._wherePart != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT BD_HP_COMP_DRUG.ID_COMP_DRUG as Id_drugcomp,		 ");
		sqlBuilder.append(" BD_HP_COMP_DRUG.ID_GRP,						 ");
		sqlBuilder.append(" BD_HP_COMP_DRUG.ID_ORG,						 ");
		sqlBuilder.append(" BD_HP_COMP_DRUG.ID_HP,						 ");
		sqlBuilder.append(" BD_HP_COMP_DRUG.CODE,						 ");
		sqlBuilder.append(" DECODE(BD_HP_COMP_DRUG.EU_STATUS,NULL,?,                         	 ");
		sqlBuilder.append(" BD_HP_COMP_DRUG.EU_STATUS) AS EU_STATUS,                         	 ");
		sqlBuilder.append(" BD_HP_COMP_DRUG.DT_APPROVED,					 ");
		sqlBuilder.append(" BD_HP_COMP_DRUG.CREATEDBY,					 ");
		sqlBuilder.append(" BD_HP_COMP_DRUG.CREATEDTIME,					 ");
		sqlBuilder.append(" BD_HP_COMP_DRUG.MODIFIEDBY,					 ");
		sqlBuilder.append(" BD_HP_COMP_DRUG.MODIFIEDTIME,					 ");
		sqlBuilder.append(" BD_HP_COMP_DRUG.DS,						 ");
		sqlBuilder.append(" BD_HP_COMP_DRUG.SV,						 ");

		sqlBuilder.append(" BD_HP_DRUG.NAME AS NAME_GENERIC,                                   ");
		sqlBuilder.append(" BD_HP_DRUG.EU_FEELEVEL AS EU_FEELEVEL,                           	 ");
		sqlBuilder.append(" BD_HP_DRUG.PRI_MAX AS PRI_MAX,                                   	 ");

		sqlBuilder.append(" BD_MM.ID_MM AS ID_DRUG,						 ");
		sqlBuilder.append(" BD_MM.NAME   AS DRUG_NAME,					 ");
		sqlBuilder.append(" BD_MM.CODE   AS DRUG_CODE,					 ");
		sqlBuilder.append(" MEASDOC.NAME  AS DRUG_UNIT,					 ");
		sqlBuilder.append(" BD_MM.PRICE    AS DRUG_PRICE					 ");

		sqlBuilder.append(" FROM BD_MM							 ");
		sqlBuilder.append(" LEFT JOIN BD_HP_COMP_DRUG						 ");
		sqlBuilder.append(" ON BD_MM.ID_MM = BD_HP_COMP_DRUG.ID_DRUG		 ");
		sqlBuilder.append(" AND BD_HP_COMP_DRUG.ID_HP = ?					 ");

		String wherePart = BdEnvContextUtil.processEnvContext(new HpDrugDirCompDO(), "BD_HP_COMP_DRUG");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		sqlBuilder.append(" LEFT JOIN BD_HP_DRUG						 ");
		sqlBuilder.append(" ON BD_HP_COMP_DRUG.CODE = BD_HP_DRUG.CODE				 ");
		sqlBuilder.append(" AND BD_HP_DRUG.ID_HP   = ?					 ");

		wherePart = BdEnvContextUtil.processEnvContext(new HpDrugDO(), "BD_HP_DRUG");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		sqlBuilder.append(" LEFT JOIN BD_MEASDOC MEASDOC					 ");
		sqlBuilder.append(" ON MEASDOC.ID_MEASDOC = BD_MM.ID_UNIT_PKGSP			 ");

		wherePart = BdEnvContextUtil.processEnvContext(new MeasDocDO(), "MEASDOC");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}
		return sqlBuilder.toString();
	}
}
