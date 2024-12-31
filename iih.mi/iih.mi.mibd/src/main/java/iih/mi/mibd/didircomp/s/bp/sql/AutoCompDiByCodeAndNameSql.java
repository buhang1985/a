package iih.mi.mibd.didircomp.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.utils.BdEnvContextUtil;
import iih.mi.mibd.di.d.DiDO;
import iih.mi.mibd.didircomp.d.DidircompDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class AutoCompDiByCodeAndNameSql implements ITransQry {

	private String _misId;

	public AutoCompDiByCodeAndNameSql(String misId) {
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
		baseSQL.append("SELECT BDDI.ID_DIDEF AS ID_DI,              	      ");
		baseSQL.append("  MIDI.CODE					      ");
		baseSQL.append("FROM						      ");
		baseSQL.append("  (SELECT ID_DIDEF,				      ");
		baseSQL.append("    CODE,					      ");
		baseSQL.append("    NAME FROM BD_DI_DEF				      ");
		baseSQL.append("  WHERE ID_DIDEF NOT IN				      ");
		baseSQL.append("    (SELECT ID_DI FROM MI_BD_COMP_DI WHERE ID_MIS = ? ");

		String wherePart = BdEnvContextUtil.processEnvContext(new DidircompDO(), "MI_BD_COMP_DI");
		if (StringUtils.isNotEmpty(wherePart)) {
			baseSQL.append(" AND ");
			baseSQL.append(wherePart);
		}

		baseSQL.append("    )						      ");

		wherePart = BdEnvContextUtil.processEnvContext(new DiagDefDO(), "BD_DI_DEF");
		if (StringUtils.isNotEmpty(wherePart)) {
			baseSQL.append(" AND ");
			baseSQL.append(wherePart);
		}

		baseSQL.append("  ) BDDI					      ");
		baseSQL.append("INNER JOIN					      ");
		baseSQL.append("  (SELECT MI_BD_DI.CODE,			      ");
		baseSQL.append("    MI_BD_DI.NAME				      ");
		baseSQL.append("  FROM MI_BD_DI					      ");
		baseSQL.append("  WHERE ID_MIS = ?				      ");
		
		wherePart = BdEnvContextUtil.processEnvContext(new DiDO(), "MI_BD_DI");
		if (StringUtils.isNotEmpty(wherePart)) {
			baseSQL.append(" AND ");
			baseSQL.append(wherePart);
		}
		
		baseSQL.append("  GROUP BY MI_BD_DI.CODE,			      ");
		baseSQL.append("    MI_BD_DI.NAME				      ");
		baseSQL.append("  ) MIDI					      ");
		baseSQL.append("ON MIDI.CODE  = BDDI.CODE			      ");
		baseSQL.append("AND MIDI.NAME = BDDI.NAME;			      ");
		return baseSQL.toString();
	}

}
