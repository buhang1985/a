package iih.bd.mhi.hptreatdircomp.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.mhi.docenum.d.DirCompState;
import iih.bd.mhi.hptreat.d.HpTreatDO;
import iih.bd.mhi.hptreatdircomp.d.HpTreatDirCompDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * @author dj.zhang
 *
 */
public class FindHpTreatCompSql implements ITransQry {

	private String _hpId;
	private String _wherePart;
	private String _refId;

	public FindHpTreatCompSql(String hpId, String wherePart) {
		this._hpId = hpId;
		this._wherePart = wherePart;
	}
	
	public FindHpTreatCompSql(String refId, String hpId, String wherePart) {
		this._hpId = hpId;
		this._wherePart = wherePart;
		this._refId = refId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
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
		String sql = getBaseSql();
		String wherePart = getWherePart();
		return String.format("%s WHERE %s", sql, wherePart);
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = String.format(" AND BD_SRV.SD_SRVTP NOT LIKE '%s%%'", IBdSrvDictCodeConst.SD_SRVTP_DRUG);
		wherePartBuilder.append(wherePart);

		wherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), "BD_SRV");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (this._wherePart != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT BD_HP_COMP_TREAT.ID_COMP_TREAT AS ID_TREATCOMP,						      ");
		sqlBuilder.append("   BD_HP_COMP_TREAT.ID_GRP,								      ");
		sqlBuilder.append("   BD_HP_COMP_TREAT.ID_ORG,								      ");
		sqlBuilder.append("   BD_HP_COMP_TREAT.ID_HP,								      ");
		sqlBuilder.append("   BD_HP_COMP_TREAT.CODE,								      ");
		sqlBuilder.append("   DECODE(BD_HP_COMP_TREAT.EU_STATUS,NULL,?, ");
		sqlBuilder.append("   BD_HP_COMP_TREAT.EU_STATUS) AS EU_STATUS,    ");
		sqlBuilder.append("   BD_HP_COMP_TREAT.DT_APPROVED,							      ");
		sqlBuilder.append("   BD_HP_COMP_TREAT.CREATEDBY,							      ");
		sqlBuilder.append("   BD_HP_COMP_TREAT.CREATEDTIME,							      ");
		sqlBuilder.append("   BD_HP_COMP_TREAT.MODIFIEDBY,							      ");
		sqlBuilder.append("   BD_HP_COMP_TREAT.MODIFIEDTIME,							      ");
		sqlBuilder.append("   BD_HP_COMP_TREAT.DS,								      ");
		sqlBuilder.append("   BD_HP_COMP_TREAT.SV,								      ");

		sqlBuilder.append("   BD_HP_TREAT.NAME AS NAME, ");
		sqlBuilder.append("   BD_HP_TREAT.EU_FEELEVEL AS EU_FEELEVEL,  ");
		sqlBuilder.append("   BD_HP_TREAT.PRI_MAX AS PRI_MAX,      ");

		sqlBuilder.append("   BD_SRV.ID_SRV AS ID_TREAT,							      ");
		sqlBuilder.append("   BD_SRV.NAME   AS TREAT_NAME,							      ");
		sqlBuilder.append("   BD_SRV.CODE   AS TREAT_CODE,							      ");
		sqlBuilder.append("   MEASDOC.NAME  AS TREAT_UNIT,							      ");
		sqlBuilder.append("   BD_SRV.PRI    AS TREAT_PRICE						      ");

		sqlBuilder.append(" FROM BD_SRV										      ");
		sqlBuilder.append(" LEFT JOIN BD_HP_COMP_TREAT								      ");
		sqlBuilder.append(" ON BD_SRV.ID_SRV = BD_HP_COMP_TREAT.ID_TREAT				      ");
		sqlBuilder.append(" AND BD_HP_COMP_TREAT.ID_HP = ?							      ");

		String wherePart = BdEnvContextUtil.processEnvContext(new HpTreatDirCompDO(), "BD_HP_COMP_TREAT");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		sqlBuilder.append(" LEFT JOIN BD_HP_TREAT								      ");
		sqlBuilder.append(" ON BD_HP_COMP_TREAT.CODE = BD_HP_TREAT.CODE						      ");
		sqlBuilder.append(" AND BD_HP_TREAT.ID_HP   = ?							      ");

		wherePart = BdEnvContextUtil.processEnvContext(new HpTreatDO(), "BD_HP_TREAT");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		sqlBuilder.append(" LEFT JOIN BD_MEASDOC MEASDOC							      ");
		sqlBuilder.append(" ON MEASDOC.ID_MEASDOC = BD_SRV.ID_UNIT_MED					 ");

		wherePart = BdEnvContextUtil.processEnvContext(new MeasDocDO(), "MEASDOC");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		return sqlBuilder.toString();
	}

}
