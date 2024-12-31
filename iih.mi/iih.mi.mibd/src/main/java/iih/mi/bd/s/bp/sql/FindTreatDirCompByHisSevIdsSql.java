package iih.mi.bd.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.mhi.hptreat.d.HpTreatDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author dj.zhang
 *
 */
public class FindTreatDirCompByHisSevIdsSql implements ITransQry {

	private String _hpId;
	private String _srvWherePart;

	public FindTreatDirCompByHisSevIdsSql(String hpId, String srvWherePart) {
		this._hpId = hpId;
		this._srvWherePart = srvWherePart;
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

		if (StringUtils.isNotEmpty(this._srvWherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._srvWherePart);
		}
		return wherePartBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT BD_HP_SRVORCA.ID_HPSRVORCA AS ID_DIRCOMP, 	  ");
		sqlBuilder.append(" BD_HP_SRVORCA.ID_GRP,				  ");
		sqlBuilder.append(" BD_HP_SRVORCA.ID_ORG,				  ");
		sqlBuilder.append(" BD_HP_SRVORCA.ID_HP,				  ");
		sqlBuilder.append(" BD_HP_SRVORCA.ID_SRV,		 	");
		sqlBuilder.append(" BD_HP_SRVORCA.CODE,		 	");
		sqlBuilder.append(" BD_HP_SRVORCA.NAME,		 	");
		sqlBuilder.append(" BD_HP_SRVORCA.CODE_CA,		 	");
		sqlBuilder.append(" BD_HP_SRVORCA.EU_HPSRVTP,		 	");
		sqlBuilder.append(" BD_HP_TREAT.NAME AS HISNAME,					  ");
		sqlBuilder.append(" BD_HP_TREAT.CODE AS HISCODE					  ");
		sqlBuilder.append(" FROM BD_HP_SRVORCA				 	  ");
		sqlBuilder.append(" LEFT JOIN BD_HP_TREAT				  ");
		sqlBuilder.append(" ON BD_HP_SRVORCA.ID_SRV = BD_HP_TREAT.ID_TREAT  ");

		sqlBuilder.append(" AND BD_HP_SRVORCA.ID_HP   = ?			 ");

		String wherePart = BdEnvContextUtil.processEnvContext(new HpTreatDO(), "BD_HP_TREAT");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		return sqlBuilder.toString();
	}

}
