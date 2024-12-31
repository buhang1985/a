package iih.bl.pay.refs;

import java.util.List;

import iih.bl.pub.BlGroupControlUtils;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

public class PatiVisitEtRefModel extends RefGridModel {
	// 留观就诊参照模型，用于留观费用清单节点的参照模型

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PatiVisitDO.NAME_PAT, "pat_code", PatiVisitDO.DT_ENTRY, "IsIn", PatiVisitDO.CODE,
				"times_ip", "CODE_AMR_IP" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PatiVisitDO.ID_ENT, PatiVisitDO.ID_PAT, PatiVisitDO.CODE_ENTP, PatiVisitDO.FG_IP,
				PatiVisitDO.ID_DEP_NUR, PatiVisitDO.ID_DEP_PHY, PatiVisitDO.ID_EMP_PHY, PatiVisitDO.DT_ACPT,
				PatiVisitDO.DT_END, PatiVisitDO.DS, PatiVisitDO.SV };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "患者姓名", "患者编号", "入院时间", "是否在院", "就诊编号", "住院次数", "住院号" };
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
		return new PatiVisitDO().getTableName();
	}

	@Override
	public void addWherePart(String wherePart) {
		getWherePart().add(wherePart);
	}

	@Override
	public String getRefSql() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT en_ent.name_pat,            ");
		sb.append("		PI_PAT.code  as  pat_code,     ");
		// 入科时间，DT_ACPT是登记时间
		sb.append("     en_ent.DT_Entry,               ");
		sb.append("     (CASE EN_ENT.FG_IP WHEN 'Y' THEN '是' ELSE '否' END) IsIn,");
		sb.append("     en_ent.code,                   ");
		sb.append("     EN_ENT_IP.TIMES_IP  times_ip,  ");
		sb.append("     EN_ENT_IP.Code_Amr_Ip,         ");
		sb.append("     en_ent.Id_ent,                 ");
		sb.append("     en_ent.id_pat,                 ");
		sb.append("     en_ent.code_entp,              ");
		sb.append("     en_ent.fg_ip,                  ");
		sb.append("     en_ent.ID_dep_nur,             ");
		sb.append("     en_ent.ID_dep_phy,             ");
		sb.append("     en_ent.ID_emp_phy,             ");
		sb.append("     en_ent.DT_ACPT,                ");
		// 出院时间
		sb.append("     en_ent.DT_End,                 ");
		sb.append("     en_ent.ds,                     ");
		sb.append("     en_ent.sv                      ");
		sb.append(" FROM  en_ent                       ");
		sb.append(" INNER JOIN pi_pat ON EN_ENT.ID_PAT = PI_PAT.ID_PAT  ");
		sb.append(" LEFT JOIN EN_ENT_IP ON EN_ENT.ID_ENT = EN_ENT_IP.ID_ENT  ");
		sb.append(" INNER JOIN bd_pri_pat on  en_ent.id_pripat = bd_pri_pat.id_pripat  ");
		sb.append(" LEFT JOIN  bd_dep on  en_ent.id_dep_nur = bd_dep.id_dep ");
		sb.append(" WHERE 1 = 1 AND en_ent.code_entp='0103' AND EN_ENT.FG_CANC='N' ");
		sb.append(" and ").append(BlGroupControlUtils.getGroupControlFitler(new PatDODesc(), "en_ent"));

		String wherePart = "";
		// 语法的问题，带不带and，其实这里写没必要，暂时留存吧，yangyang
		boolean IsWithAnd = true;
		// 这个是原有的条件语句
		List<String> oldWherepartArr = this.getWherePart();
		for (String strWhere : oldWherepartArr) {
			sb = sb.append(" and ").append(strWhere);
		}
		sb = sb.append(wherePart).append(" order by  en_ent.dt_entry desc,en_ent_ip.times_ip desc ");
		return sb.toString();
	}

	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "EN_ENT.NAME_PAT", "EN_ENT.CODE", "PI_PAT.CODE", "EN_ENT_IP.CODE_AMR_IP", "PI_PAT.PYCODE",
				"PI_PAT.WBCODE" };
	}

	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		// 重写该方法，该方法是模糊字段检索的处理
		String[] fields = this.getBlurFields();
		if (fields == null)
			// yangyang 2016-06-22 当搜索字段没有定义时，默认使用显示字段来过滤
			fields = this.getShowFieldCode();

		StringBuilder buf = new StringBuilder();
		buf.append("(");
		for (int i = 0; i < fields.length; i++) {
			String field = fields[i];
			buf.append("lower(");
			buf.append(field);
			buf.append(")");
			buf.append(" like '%");
			buf.append(blurValue.toLowerCase());
			buf.append("%'");
			if (i != fields.length - 1)
				buf.append(" or ");
		}
		buf.append(")");
		String str = buf.toString();
		this.addWherePart(str);
		try {
			if (pg == null)
				return this.getRefData();
			else
				return this.getRefData(pg);
		} finally {
			this.removeWherePart(str);
		}
	}
}
