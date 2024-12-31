package iih.bl.pay.refs;

import java.util.List;

import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.Context;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 住院患者信息，主要是病区检索时使用
 * 
 * @author yangyang
 * @Date 2017-11-25
 */
public class PatiVisitIpSimpleRefModel extends RefGridModel {

	// 住院就诊参照模型，主要用于病区检索病人使用
	@Override
	public String[] getShowFieldCode() {
		return new String[] { "NAME_BED", PatiVisitDO.NAME_PAT, PatiVisitDO.CODE, "CODE_AMR_IP" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PatiVisitDO.ID_ENT, PatiVisitDO.ID_PAT, PatiVisitDO.FG_IP, PatiVisitDO.ID_DEP_NUR,
				PatiVisitDO.ID_DEP_PHY, PatiVisitDO.ID_EMP_PHY, PatiVisitDO.DT_ACPT, "Times_Ip", PatiVisitDO.DS };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "床号", "姓名", "就诊编号", "住院号" };
	}

	@Override
	public String getPkFieldCode() {
		return PatiVisitDO.ID_ENT;
	}

	@Override
	public String getRefCodeField() {
		return PatiVisitDO.NAME_PAT;
	}

	@Override
	public String getRefNameField() {
		return PatiVisitDO.NAME_PAT;
	}

	@Override
	public String getTableName() {
		return "patent";
	}

	@Override
	public void addWherePart(String wherePart) {
		getWherePart().add(wherePart);
	}

	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "NAME_BED", "NAME_PAT", "CODE_PAT", "CODE_ENT", "CODE_AMR_IP", "PYCODE", "wbcode" };
	}

	@Override
	public String getRefSql() {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from (");
		sb.append(
				" SELECT  EN_ENT_IP.NAME_BED AS NAME_BED,PI_PAT.NAME AS NAME_PAT,PI_PAT.CODE AS CODE_PAT,EN_ENT.CODE CODE_ENT,PI_PAT.CODE_AMR_IP,EN_ENT.ID_ENT,");
		sb.append("PI_PAT.PYCODE,PI_PAT.wbcode as wbcode,pi_pat.id_org,pi_pat.id_grp,");
		sb.append(
				" PI_PAT.ID_PAT,EN_ENT.FG_IP,EN_ENT.ID_DEP_NUR,EN_ENT.ID_DEP_PHY,EN_ENT.ID_EMP_PHY,EN_ENT.DT_ACPT,EN_ENT_IP.TIMES_IP,en_ent.FG_CANC,");
		sb.append(" EN_ENT.DS");
		sb.append(" FROM EN_ENT");
		sb.append(" INNER JOIN EN_ENT_IP ON EN_ENT.ID_ENT=EN_ENT_IP.ID_ENT");
		sb.append(" INNER JOIN PI_PAT ON EN_ENT.ID_PAT=PI_PAT.ID_PAT");
		sb.append(") patent");
		sb.append(" WHERE patent.FG_CANC='N'");
		sb.append(" AND patent.ID_DEP_NUR='").append(Context.get().getDeptId()).append("'");
		sb.append(" and patent.id_org = '" + Context.get().getOrgId() + "' ");
		sb.append(" and patent.id_grp = '" + Context.get().getGroupId() + "' ");
		String wherePart = "";
		// 语法的问题，带不带and，其实这里写没必要，暂时留存吧，yangyang
		boolean IsWithAnd = true;
		// 这个是原有的条件语句
		List<String> oldWherepartArr = this.getWherePart();
		for (String strWhere : oldWherepartArr) {
			sb = sb.append(" and ").append(strWhere);
		}
		sb = sb.append(wherePart).append(" ORDER BY patent.NAME_BED");

		return sb.toString();
	}
}
