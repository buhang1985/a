package iih.mi.inst.bizgrp.tonglingcity.bp.qry;

import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 刷新诊疗和服务设施对照SQL
 * 
 * @author hao_wu
 *
 */
public class RefreshTreatAndFwssCompSql implements ITransQry {

	private String _hpId;

	public RefreshTreatAndFwssCompSql(String hpId) {
		this._hpId = hpId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(HpSrvTpEnum.ZL);// 医保项目类别
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
		sqlBuilder.append("  SRV.ID_SRV                                  AS ID_SRV,			   ");// 项目id
		sqlBuilder.append("  ?                                           AS EU_HPSRVTP,			   ");// 医保项目类别
		sqlBuilder.append("  ? AS EU_STATUS			   ");// 所属状态
		sqlBuilder.append("FROM BD_SRV SRV									   ");
		sqlBuilder.append(
				"WHERE SRV.DS = 0 AND SRV.FG_BL = 'Y' AND SRV.FG_MM = 'N' AND SRV.ID_SRV NOT IN (SELECT ID_SRV FROM BD_HP_SRVORCA )	");
		return sqlBuilder.toString();
	}
}
