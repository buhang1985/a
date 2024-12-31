package iih.bd.pp.anhuisrvorca.s.bp.sql;

import iih.bd.pp.hpsrvorca.d.HpIndicationRuleEnum;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 自动生成医保计划控制策略SQL
 * 
 * @author hao_wu
 *
 */
public class AutoGenerateSrvctrSql implements ITransQry {

	private Integer _euHpSrvTp;
	private String _hpId;

	public AutoGenerateSrvctrSql(String hpId, Integer euHpSrvTp) {
		this._hpId = hpId;
		this._euHpSrvTp = euHpSrvTp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(HpIndicationRuleEnum.NO_CONTROL);
		sqlParam.addParam(HpIndicationRuleEnum.DOC_CONFIRM);
		sqlParam.addParam(this._euHpSrvTp);
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(this._euHpSrvTp);
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ? AS ID_GRP,					    ");
		sqlBuilder.append("  ?      AS ID_ORG,					    ");
		sqlBuilder.append("  ? AS ID_HP,					    ");
		sqlBuilder.append("  SRVORCA.CODE,					    ");
		sqlBuilder.append("  SRVORCA.EU_HPSRVTP,				");
		sqlBuilder.append("  DECODE(SRVORCA.DES,NULL,?,?) AS EU_HPSRVCTRTP				    ");
		sqlBuilder.append("FROM (SELECT CODE, EU_HPSRVTP, ID_HP, ID_GRP, ID_ORG, MAX(DES) AS DES FROM BD_HP_SRVORCA GROUP BY CODE, EU_HPSRVTP, ID_HP,ID_GRP,ID_ORG) SRVORCA				    ");
		sqlBuilder.append("WHERE SRVORCA.ID_HP  <> '~'				    ");
		sqlBuilder.append("AND SRVORCA.CODE     IS NOT NULL			    ");
		sqlBuilder.append("AND SRVORCA.CODE NOT IN				    ");
		sqlBuilder.append("  (SELECT CODE FROM BD_HP_SRVCTR SRVCTR WHERE SRVCTR.EU_HPSRVTP = ? AND ID_HP = ? AND SRVCTR.ID_GRP = ? AND SRVCTR.ID_ORG = ? )			    ");
		sqlBuilder.append("AND SRVORCA.EU_HPSRVTP = ?		    ");
		sqlBuilder.append("AND SRVORCA.ID_HP = ?		    ");
		sqlBuilder.append("AND SRVORCA.ID_GRP = ?		    ");
		sqlBuilder.append("AND SRVORCA.ID_ORG = ?		    ");
		return sqlBuilder.toString();
	}

}
