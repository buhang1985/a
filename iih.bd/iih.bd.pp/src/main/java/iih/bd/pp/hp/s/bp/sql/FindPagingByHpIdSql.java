package iih.bd.pp.hp.s.bp.sql;

import iih.bd.bc.udi.pub.IBdMmDictCodeTypeConst;
import iih.bd.pp.hp.d.HpDosageDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author dj.zhang
 *
 */
public class FindPagingByHpIdSql implements ITransQry {

	private String _hpId;
	private String _wherePart;

	public FindPagingByHpIdSql(String hpId) {
		this._hpId = hpId;
	}

	public FindPagingByHpIdSql(String hpId, String wherePart) {
		this._hpId = hpId;
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(IBdMmDictCodeTypeConst.SD_DOSAGETYPE);
		sqlParam.addParam(ActiveStateEnum.ACTIVE);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = getBaseSql();
		String wherePart = getWherePart();
		return String.format("%s WHERE %s", sql, wherePart);
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		wherePartBuilder.append("AND DOSAGE.ID_UDIDOCLIST IN ");
		wherePartBuilder.append("(SELECT ID_UDIDOCLIST FROM BD_UDIDOCLIST WHERE CODE = ?)");
		wherePartBuilder.append("AND DOSAGE.DS = 0 ");
		wherePartBuilder.append("AND DOSAGE.ACTIVESTATE = ? ");

		if (this._wherePart != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}

		return wherePartBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT DOSAGE.NAME,");
		sqlBuilder.append("DOSAGE.CODE,");
		sqlBuilder.append("DOSAGE.ID_UDIDOC AS ID_DOSAGE,");
		sqlBuilder.append("HPDOSAGE.ID_HP AS ID_HP,");
		sqlBuilder.append("HPDOSAGE.ID_DOSAGE AS ID_HPDOSAGE,");
		sqlBuilder.append("HPDOSAGE.NAME AS NAME_HP,");
		sqlBuilder.append("HPDOSAGE.CODE AS CODE_HP,");
		sqlBuilder.append("HPDOSAGE.PYCODE,");
		sqlBuilder.append("HPDOSAGE.WBCODE,");
		sqlBuilder.append("HPDOSAGE.MNECODE,");
		sqlBuilder.append("DOSAGECOMP.CREATEDBY,");
		sqlBuilder.append("DOSAGECOMP.CREATEDTIME,");
		sqlBuilder.append("DOSAGECOMP.MODIFIEDBY,");
		sqlBuilder.append("DOSAGECOMP.MODIFIEDTIME,");
		sqlBuilder.append("DOSAGECOMP.SV,");
		sqlBuilder.append("DOSAGECOMP.DS,");
		sqlBuilder.append("DOSAGECOMP.ID_HP_DOSAGE AS ID_HP_DOSAGE ");
		sqlBuilder.append("FROM BD_UDIDOC DOSAGE ");
		sqlBuilder.append("LEFT JOIN BD_HP_DOSAGE DOSAGECOMP ");
		sqlBuilder.append("ON DOSAGE.ID_UDIDOC = DOSAGECOMP.ID_DOSAGE ");
		sqlBuilder.append("AND DOSAGECOMP.ID_HP = ? ");

		String bdModeWherePart = BdEnvContextUtil.processEnvContext(new HpDosageDO(), "DOSAGECOMP");
		sqlBuilder.append("AND ");
		sqlBuilder.append(bdModeWherePart);

		sqlBuilder.append("LEFT JOIN BD_MHI_DOSAGE HPDOSAGE ");
		sqlBuilder.append("ON HPDOSAGE.ID_DOSAGE = DOSAGECOMP.ID_HPDOSAGE ");
		sqlBuilder.append("AND HPDOSAGE.ID_HP = ? ");

		bdModeWherePart = BdEnvContextUtil.processEnvContext(new iih.bd.mhi.hpdosage.d.HpDosageDO(), "HPDOSAGE");
		sqlBuilder.append("AND ");
		sqlBuilder.append(bdModeWherePart);

		return sqlBuilder.toString();
	}

}
