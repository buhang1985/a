package iih.mi.inst.bizbase.qry;

import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class AutoCompTreatByCodeSql implements ITransQry {

	private String _hpId;

	public AutoCompTreatByCodeSql(String hpId) {
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
		sqlParam.addParam(HpStatusEnum.CONTRAST);
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(HpSrvTpEnum.ZL);// 医保项目类别
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append("SELECT 			   ");
		sqlBuilder.append("  ?                                            AS ID_GRP,			   ");// 集团
		sqlBuilder.append("  ?                                            AS ID_ORG,			   ");// 组织
		sqlBuilder.append("  ?                      AS ID_HP,			   ");// 医保计划主键
		sqlBuilder.append("  TREAT_ORGINAL.CODE                       AS CODE,			   ");// 医保诊断编码
		sqlBuilder.append("  TREAT_ORGINAL.NAME                       AS NAME,			   ");// 医保诊断名称
		sqlBuilder.append("  SRV.ID_SRV                                  AS ID_SRV,			   ");// 项目id
		sqlBuilder.append("  ?                                           AS EU_HPSRVTP,			   ");// 医保项目类别
		sqlBuilder.append("  DECODE(TREAT_ORGINAL.CODE,NULL,?,?) AS EU_STATUS			   ");// 所属状态
		sqlBuilder.append("FROM BD_SRV SRV									   ");
		sqlBuilder.append("LEFT JOIN BD_HP_ZL_ORGINAL TREAT_ORGINAL							   ");
		sqlBuilder.append("ON (SRV.CODE = TREAT_ORGINAL.CODE AND　TREAT_ORGINAL.ID_HP = ? AND TREAT_ORGINAL.ID_GRP = ? AND TREAT_ORGINAL.ID_ORG = ?)	   ");
		sqlBuilder.append(
				"WHERE SRV.ID_GRP = ? AND SRV.ID_ORG = ? AND SRV.DS = 0 AND SRV.FG_BL = 'Y' AND SRV.FG_MM = 'N' AND SRV.ID_SRV NOT IN (SELECT ID_SRV FROM BD_HP_SRVORCA WHERE BD_HP_SRVORCA.EU_HPSRVTP = ? AND BD_HP_SRVORCA.ID_HP = ? AND BD_HP_SRVORCA.ID_GRP = ? AND BD_HP_SRVORCA.ID_ORG = ?)	");

		return sqlBuilder.toString();
	}

}
