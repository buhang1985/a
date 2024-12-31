package iih.mi.mibd.srvfacdircomp.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.mi.mibd.srvfac.d.SrvfacDO;
import iih.mi.mibd.srvfacdircomp.d.SrvFacDirCompDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 通过编码查询sql
 *
 *@author hexx
 */
public class AutoCompSrvfacByCodeSql implements ITransQry {

	private String _misId;

	public AutoCompSrvfacByCodeSql(String misId) {
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
		baseSQL.append(" SELECT BDSRV.ID_SRV AS ID_SRV,     ");
		baseSQL.append("   MISRVFAC.CODE			       ");
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
		baseSQL.append("     (SELECT ID_SRV FROM MI_BD_COMP_SRVFAC WHERE ID_MIS = ?");

		wherePart = BdEnvContextUtil.processEnvContext(new SrvFacDirCompDO(), "MI_BD_COMP_SRVFAC");
		if (StringUtils.isNotEmpty(wherePart)) {
			baseSQL.append(" AND ");
			baseSQL.append(wherePart);
		}

		baseSQL.append("     )				       ");
		baseSQL.append("   ) BDSRV			       ");
		baseSQL.append(" INNER JOIN			       ");
		baseSQL.append("   (SELECT MI_BD_SRVFAC.CODE	       ");
		baseSQL.append("   FROM MI_BD_SRVFAC WHERE ID_MIS = ?");

		wherePart = BdEnvContextUtil.processEnvContext(new SrvfacDO(), "MI_BD_SRVFAC");
		if (StringUtils.isNotEmpty(wherePart)) {
			baseSQL.append(" AND ");
			baseSQL.append(wherePart);
		}

		baseSQL.append("   GROUP BY MI_BD_SRVFAC.CODE	       ");
		baseSQL.append("   ) MISRVFAC			       ");
		baseSQL.append(" ON MISRVFAC.CODE  = BDSRV.CODE	       ");

		return baseSQL.toString();
	}

}
