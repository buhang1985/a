package iih.bd.pp.hpsrvorca.bp.sql;

import iih.bd.pp.hpsrvorca.d.HpIndicationRuleEnum;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class HpSrvctrSql implements ITransQry {

	private String hpId;
	private Integer eu_hpsrvtp;

	public HpSrvctrSql(String hpId, Integer eu_hpsrvtp) {
		this.hpId = hpId;
		this.eu_hpsrvtp = eu_hpsrvtp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(HpIndicationRuleEnum.NO_CONTROL);
		sqlParam.addParam(HpIndicationRuleEnum.DOC_CONFIRM);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(this.hpId);
		sqlParam.addParam(this.eu_hpsrvtp);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ");
		sqlBuilder.append("SRVORCA.ID_GRP AS ID_GRP,");// 集团
		sqlBuilder.append("SRVORCA.ID_ORG AS ID_ORG,");// 组织
		sqlBuilder.append("SRVORCA.ID_HP AS ID_HP,");// 医保计划
		sqlBuilder.append("SRVORCA.CODE AS CODE,");// 医保计划下编码
		sqlBuilder.append("SRVORCA.ID_SRV AS ID_SRV,");// 医疗服务主键
		sqlBuilder.append("SRVORCA.EU_HPSRVTP AS EU_HPSRVTP,");// 医保项目类别
		sqlBuilder.append("DECODE(SRVORCA.DES,NULL,?,?) AS EU_HPSRVCTRTP ");// 控制类型
		sqlBuilder.append("FROM BD_HP_SRVORCA SRVORCA ");
		sqlBuilder.append("WHERE ID_GRP = ? AND ID_ORG = ? AND ID_HP =? AND EU_HPSRVTP = ? ");
		sqlBuilder.append(
				"AND NOT EXISTS(SELECT 1 FROM BD_HP_SRVCTR SRVCTR WHERE SRVORCA.ID_HP = SRVCTR.ID_HP AND SRVORCA.ID_SRV = SRVCTR.ID_SRV AND SRVORCA.EU_HPSRVTP = SRVCTR.EU_HPSRVTP) ");
		return sqlBuilder.toString();
	}

}
