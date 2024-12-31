package iih.bd.pp.anhuisrvorca.s.bp.sql;

import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 刷新药品对照SQL
 * 
 * @author hao_wu
 *
 */
public class RefreshDrugCompSql implements ITransQry {

	private String _hpId;

	public RefreshDrugCompSql(String hpId) {
		this._hpId = hpId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(HpSrvTpEnum.DRUG);// 医保项目类别
		sqlParam.addParam(HpStatusEnum.NOT_MATCHED);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT 			   ");
		sqlBuilder.append("  ?                                            AS ID_GRP,			   ");// 集团
		sqlBuilder.append("  ?                                            AS ID_ORG,			   ");// 组织
		sqlBuilder.append("  ?                                            AS ID_HP,			   ");// 医保计划
		sqlBuilder.append("  MM.ID_MM                                   AS ID_MM,			   ");// 药品id
		sqlBuilder.append("  MM.ID_SRV                                  AS ID_SRV,			   ");// 通用名id
		sqlBuilder.append("  ?                                           AS EU_HPSRVTP,			   ");// 医保项目类别
		sqlBuilder.append("  ? AS EU_STATUS			   ");// 所属状态
		sqlBuilder.append("FROM BD_MM MM									   ");
		sqlBuilder.append(
				"WHERE MM.DS = 0 AND MM.ID_MM NOT IN (SELECT ID_MM FROM BD_HP_SRVORCA  WHERE BD_HP_SRVORCA.EU_HPSRVTP = '1') ");
		return sqlBuilder.toString();
	}
}
