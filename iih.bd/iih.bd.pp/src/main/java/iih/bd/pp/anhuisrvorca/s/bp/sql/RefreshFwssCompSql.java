package iih.bd.pp.anhuisrvorca.s.bp.sql;

import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 刷新服务设施对照SQL
 * 
 * @author hao_wu
 *
 */
public class RefreshFwssCompSql implements ITransQry {

	private String _hpId;

	public RefreshFwssCompSql(String hpId) {
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
		sqlParam.addParam(this._hpId);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append("SELECT 			   ");
		sqlBuilder.append("  ?                                            AS ID_GRP,		");// 集团
		sqlBuilder.append("  ?                                            AS ID_ORG,		");// 组织
		sqlBuilder.append("  ? AS ID_HP,						 					");// 医保计划
		sqlBuilder.append("  FWSS_ORGINAL.CODE AS CODE,						 				");
		sqlBuilder.append("  FWSS_ORGINAL.NAME AS NAME,						 				");
		sqlBuilder.append("  ?               AS EU_HPSRVTP,					 				");
		sqlBuilder.append("  ? AS EU_STATUS			 			");
		sqlBuilder.append("FROM BD_HP_FWSS_ORGINAL FWSS_ORGINAL					 			");
		sqlBuilder.append(
				"WHERE FWSS_ORGINAL.CODE NOT IN (SELECT ID_SRV FROM BD_HP_SRVORCA  WHERE BD_HP_SRVORCA.EU_HPSRVTP = '3') ");
		sqlBuilder.append(" AND　FWSS_ORGINAL.ID_HP = ?					 			");

		return sqlBuilder.toString();
	}
}
