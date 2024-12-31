package iih.mi.inst.bizbase.qry;

import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import iih.mi.biz.dto.d.MiSrvTp;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 自动生成药品对照SQL
 * 
 * @author hao_wu
 *
 */
public class AutoCompDrugSql implements ITransQry {

	private String _hpId;

	public AutoCompDrugSql(String hpId) {
		this._hpId = hpId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(MiSrvTp.DRUG);// 医保项目类别
		sqlParam.addParam(HpStatusEnum.NOT_MATCHED);
		sqlParam.addParam(HpStatusEnum.CONTRAST);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(MiSrvTp.DRUG);// 医保项目类别
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT 			   ");
		sqlBuilder.append("  ? AS ID_GRP,			   ");// 集团
		sqlBuilder.append("  ? AS ID_ORG,			   ");// 组织
		sqlBuilder.append("  ? AS ID_HP,			   ");// 医保计划主键
		sqlBuilder.append("  BD_HP_DRUG_ORGINAL.CODE                       AS CODE,			   ");// 医保诊断编码
		sqlBuilder.append("  BD_HP_DRUG_ORGINAL.NAME                       AS NAME,			   ");// 医保诊断名称
		sqlBuilder.append("  BD_HP_DRUG_ORGINAL.DOSAGE                       AS CODE_DOSAGE,			   ");// 医保剂型编码
		sqlBuilder.append("  MM.ID_MM                                   AS ID_MM,			   ");// 药品id
		sqlBuilder.append("  MM.ID_SRV                                  AS ID_SRV,			   ");// 通用名id
		sqlBuilder.append("  ?                                           AS EU_HPSRVTP,			   ");// 医保项目类别
		sqlBuilder.append("  DECODE(BD_HP_DRUG_ORGINAL.NAME,NULL,?,?) AS EU_STATUS			   ");// 所属状态
		sqlBuilder.append("FROM BD_MM MM									   ");
		sqlBuilder.append("LEFT JOIN									   ");
		sqlBuilder.append("  (SELECT NAME, MIN(CODE) ONLYCODE FROM BD_HP_DRUG_ORGINAL WHERE ID_GRP = ? AND ID_ORG = ? AND ID_HP = ? GROUP BY NAME	   ");
		sqlBuilder.append("  ) A									   ");
		sqlBuilder.append("ON A.NAME = MM.NAME							   ");
		sqlBuilder.append("LEFT JOIN BD_HP_DRUG_ORGINAL							   ");
		sqlBuilder.append("ON A.ONLYCODE = BD_HP_DRUG_ORGINAL.CODE AND BD_HP_DRUG_ORGINAL.ID_HP = ? ");
		sqlBuilder.append(
				"WHERE MM.ID_GRP = ? AND MM.ID_ORG = ? AND MM.DS = 0 AND MM.ID_MM NOT IN (SELECT ID_MM FROM BD_HP_SRVORCA  WHERE BD_HP_SRVORCA.EU_HPSRVTP = ? AND BD_HP_SRVORCA.ID_HP = ? AND BD_HP_SRVORCA.ID_GRP = ? AND BD_HP_SRVORCA.ID_ORG = ?) ");
		return sqlBuilder.toString();
	}

}
