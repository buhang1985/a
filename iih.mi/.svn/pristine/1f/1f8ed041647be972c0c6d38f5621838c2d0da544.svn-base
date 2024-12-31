package iih.mi.mibd.treatdircomp.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.mi.mibd.treat.d.TreatDO;
import iih.mi.mibd.treatdircomp.d.TreatdircompDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class AutoCompTreatByCodeSql implements ITransQry {
	private String _misId;

	public AutoCompTreatByCodeSql(String misId) {
		this._misId = misId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._misId);
		sqlParam.addParam(this._misId);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder baseSQL = new StringBuilder();
		baseSQL.append(" SELECT BDSRV.ID_SRV AS ID_TREAT ,     ");
		baseSQL.append("   MITREAT.CODE			       ");
		baseSQL.append(" FROM				       ");
		baseSQL.append("   (SELECT ID_SRV,		       ");
		baseSQL.append("     CODE			       ");
		baseSQL.append("   FROM BD_SRV			       ");
		baseSQL.append("   WHERE SD_SRVTP NOT LIKE '01%'    ");
		
		String wherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), "BD_SRV");
		if (StringUtils.isNotEmpty(wherePart)) {
			baseSQL.append(" AND ");
			baseSQL.append(wherePart);
		}
		
		baseSQL.append("   AND ID_SRV NOT IN		       ");
		baseSQL.append("     (SELECT ID_TREAT FROM MI_BD_COMP_TREAT WHERE ID_MIS = ?");
		
		wherePart = BdEnvContextUtil.processEnvContext(new TreatdircompDO(), "MI_BD_COMP_TREAT");
		if (StringUtils.isNotEmpty(wherePart)) {
			baseSQL.append(" AND ");
			baseSQL.append(wherePart);
		}
		
		baseSQL.append("     )				       ");
		baseSQL.append("   ) BDSRV			       ");
		baseSQL.append(" INNER JOIN			       ");
		baseSQL.append("   (SELECT MI_BD_TREAT.CODE	       ");
		baseSQL.append("   FROM MI_BD_TREAT WHERE ID_MIS = ?");
		
		wherePart = BdEnvContextUtil.processEnvContext(new TreatDO(), "MI_BD_TREAT");
		if (StringUtils.isNotEmpty(wherePart)) {
			baseSQL.append(" AND ");
			baseSQL.append(wherePart);
		}
		
		baseSQL.append("   GROUP BY MI_BD_TREAT.CODE	       ");
		baseSQL.append("   ) MITREAT			       ");
		baseSQL.append(" ON MITREAT.CODE  = BDSRV.CODE	       ");

		return baseSQL.toString();
	}

}
