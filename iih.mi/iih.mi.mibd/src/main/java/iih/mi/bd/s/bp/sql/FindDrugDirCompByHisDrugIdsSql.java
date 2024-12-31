package iih.mi.bd.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据HIS医疗服务主键集合和药品主键集合查询三大目录对照信息集合业务逻辑
 * 
 * @author dj.zhang
 *
 */
public class FindDrugDirCompByHisDrugIdsSql implements ITransQry {

	private String _hpId;
	private String _drugWherePart;

	public FindDrugDirCompByHisDrugIdsSql(String hpId, String drugWherePart) {
		this._hpId = hpId;
		this._drugWherePart = drugWherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._hpId);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = getBaseSql();
		String wherePart = getWherePart();
		return String.format(" %s WHERE %s ", sql, wherePart);
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), "BD_HP_SRVORCA");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotEmpty(this._drugWherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._drugWherePart);
		}
		return wherePartBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append(" SELECT BD_HP_SRVORCA.ID_HPSRVORCA AS ID_DIRCOMP,");
		sqlBuilder.append(" BD_HP_SRVORCA.ID_GRP,				");
		sqlBuilder.append(" BD_HP_SRVORCA.ID_ORG,				");
		sqlBuilder.append(" BD_HP_SRVORCA.ID_HP,				");
		sqlBuilder.append(" BD_HP_SRVORCA.ID_MM ID_DRUG,		 	     ");
		sqlBuilder.append(" BD_HP_SRVORCA.CODE,		 	");
		sqlBuilder.append(" BD_HP_SRVORCA.NAME,		 	");
		sqlBuilder.append(" BD_HP_SRVORCA.CODE_CA,		 	");
		sqlBuilder.append(" BD_HP_SRVORCA.PRI_MAX,		 	");
		sqlBuilder.append(" BD_HP_SRVORCA.RATE_SELF_OEP AS RATIO_SELF_OEP,		 	");
		sqlBuilder.append(" BD_HP_SRVORCA.RATE_SELF_IP AS RATIO_SELF_IP,		 	");
		sqlBuilder.append(" BD_HP_SRVORCA.EU_HPSRVTP,		 	");
		sqlBuilder.append(" BD_HP_SRVORCA.EU_STATUS,		 	");
		sqlBuilder.append(" BD_HP_SRVORCA.SD_HPSRVTP,                        ");
		sqlBuilder.append(" BD_HP_SRVORCA.DES,		 	");
		sqlBuilder.append(" BD_MM.NAME AS HISNAME,				     ");
		sqlBuilder.append(" BD_MM.CODE AS HISCODE					     ");
		sqlBuilder.append(" FROM BD_HP_SRVORCA				     ");
		sqlBuilder.append(" INNER JOIN BD_MM				     ");
		sqlBuilder.append(" ON BD_HP_SRVORCA.ID_MM = BD_MM.ID_MM 	     ");
		sqlBuilder.append(" AND BD_HP_SRVORCA.ID_HP   = ?			 ");

		String wherePart = BdEnvContextUtil.processEnvContext(new MeterialDO(), "BD_MM");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		return sqlBuilder.toString();
	}

}
