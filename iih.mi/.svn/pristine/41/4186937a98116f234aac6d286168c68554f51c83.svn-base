package iih.mi.inst.bizbase.qry;

import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 自动生成服务设施对照SQL
 * 
 * @author hao_wu
 *
 */
public class AutoCompSrvfacSql implements ITransQry {
	private String _hpId;

	public AutoCompSrvfacSql(String hpId) {
		this._hpId = hpId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(HpSrvTpEnum.FWSS);// 医保项目类别
		sqlParam.addParam(HpStatusEnum.NOT_MATCHED);
		sqlParam.addParam(HpStatusEnum.CONTRAST);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(HpSrvTpEnum.FWSS);// 医保项目类别
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append("SELECT 			   ");
		sqlBuilder.append("  ? AS ID_GRP,		");// 集团
		sqlBuilder.append("  ? AS ID_ORG,		");// 组织
		sqlBuilder.append("  ? AS ID_HP, ");
		sqlBuilder.append("  FWSS_ORGINAL.CODE AS CODE,						 				");
		sqlBuilder.append("  FWSS_ORGINAL.NAME AS NAME,						 				");
		sqlBuilder.append("  ?               AS EU_HPSRVTP,					 				");
		sqlBuilder.append("  SRV.ID_SRV,							 						");
		sqlBuilder.append("  DECODE(SRV.ID_SRV,NULL,?,?) AS EU_STATUS			 			");
		sqlBuilder.append("FROM BD_HP_FWSS_ORGINAL FWSS_ORGINAL					 			");
		sqlBuilder.append("LEFT JOIN BD_SRV SRV							 					");
		sqlBuilder.append("ON SRV.def8 = FWSS_ORGINAL.CODE					 				");
		sqlBuilder.append("AND SRV.FG_MM = 'N' AND SRV.ID_GRP = ? AND SRV.ID_ORG = ?		");
		sqlBuilder.append(
				"WHERE SRV.DS = 0 AND SRV.FG_BL = 'Y' AND SRV.FG_MM = 'N' AND SRV.ID_SRV NOT IN (SELECT ID_SRV FROM BD_HP_SRVORCA  WHERE BD_HP_SRVORCA.EU_HPSRVTP = ? AND BD_HP_SRVORCA.ID_HP = ? AND BD_HP_SRVORCA.ID_GRP = ? AND BD_HP_SRVORCA.ID_ORG = ? ) ");
		sqlBuilder.append(" AND FWSS_ORGINAL.ID_HP = ?	AND FWSS_ORGINAL.ID_GRP = ? AND FWSS_ORGINAL.ID_ORG = ?	");

		return sqlBuilder.toString();
	}

}
