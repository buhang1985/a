package iih.bd.mhi.hptreatdircomp.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.mhi.hptreat.d.HpTreatDO;
import iih.bd.mhi.hptreatdircomp.d.HpTreatDirCompDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class AutoCompTreatByNameSql implements ITransQry {

	private String _hpId;

	public AutoCompTreatByNameSql(String hpId) {
		this._hpId = hpId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(this._hpId);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder baseSQL = new StringBuilder();
		baseSQL.append(" SELECT BDSRV.ID_SRV AS ID_TREAT ,     ");
		baseSQL.append("   MITREAT.CODE			       ");
		baseSQL.append(" FROM				       ");
		baseSQL.append("   (SELECT ID_SRV,		       ");
		baseSQL.append("     CODE,			       ");
		baseSQL.append("     NAME			       ");
		baseSQL.append("   FROM BD_SRV			       ");
		baseSQL.append("   WHERE SD_SRVTP NOT LIKE '01%'    ");

		String wherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), "BD_SRV");
		if (StringUtils.isNotEmpty(wherePart)) {
			baseSQL.append(" AND ");
			baseSQL.append(wherePart);
		}

		baseSQL.append("   AND ID_SRV NOT IN		       ");
		baseSQL.append("     (SELECT ID_TREAT FROM BD_HP_COMP_TREAT WHERE ID_HP = ?   ");
		
		wherePart = BdEnvContextUtil.processEnvContext(new HpTreatDirCompDO(), "BD_HP_COMP_TREAT");
		if (StringUtils.isNotEmpty(wherePart)) {
			baseSQL.append(" AND ");
			baseSQL.append(wherePart);
		}
		
		baseSQL.append("     )				       ");
		baseSQL.append("   ) BDSRV			       ");
		baseSQL.append(" INNER JOIN			       ");
		baseSQL.append("   (SELECT MIN(BD_HP_TREAT.CODE) AS CODE,	       ");
		baseSQL.append("     BD_HP_TREAT.NAME		       ");
		baseSQL.append("   FROM BD_HP_TREAT WHERE ID_HP = ?		       ");
		
		wherePart = BdEnvContextUtil.processEnvContext(new HpTreatDO(), "BD_HP_TREAT");
		if (StringUtils.isNotEmpty(wherePart)) {
			baseSQL.append(" AND ");
			baseSQL.append(wherePart);
		}
		
		baseSQL.append("   GROUP BY BD_HP_TREAT.NAME	       ");
		baseSQL.append("   ) MITREAT			       ");
		baseSQL.append(" ON MITREAT.NAME = BDSRV.NAME 	       ");

		return baseSQL.toString();
	}

}
