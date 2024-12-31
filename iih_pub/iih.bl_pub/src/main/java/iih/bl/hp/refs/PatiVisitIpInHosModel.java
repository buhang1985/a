package iih.bl.hp.refs;

import java.util.List;

import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

/**
 * 医保住院就诊患者参照模型-用于住院记账明细定时上传
 * @author hanjq 上午9:52:45 *
 */
public class PatiVisitIpInHosModel extends RefGridModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3529084091950704160L;


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PatiVisitDO.NAME_PAT, "pat_code", PatiVisitDO.DT_ENTRY, "IsIn", PatiVisitDO.CODE,
				"times_ip", "CODE_AMR_IP", PatiVisitDO.TELNO_PAT, PatiVisitDO.NAME_DEP_PHY, PatiVisitDO.NAME_DEP_NUR };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PatiVisitDO.ID_ENT, PatiVisitDO.ID_PAT, PatiVisitDO.CODE_ENTP, PatiVisitDO.FG_IP,
				PatiVisitDO.ID_DEP_NUR, PatiVisitDO.ID_DEP_PHY, PatiVisitDO.ID_EMP_PHY, PatiVisitDO.DT_ACPT,
				 PatiVisitDO.DS, PatiVisitDO.SV };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "患者姓名", "患者编号", "入院时间", "是否在院", "就诊编号", "住院次数", "住院号", "联系方式", "入院科室", "入院病区" };
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
		sb.append(" SELECT distinct en_ent.name_pat, ");
		sb.append(" pat.code pat_code, ");
		// 入科时间，DT_ACPT是登记时间
		sb.append(" en_ent.DT_Entry, ");
		sb.append(" (CASE en_ent.FG_IP WHEN 'Y' THEN '是' ELSE '否' END) IsIn,");
		sb.append(" en_ent.code, ");
		sb.append(" eip.TIMES_IP times_ip, ");
		sb.append(" eip.Code_Amr_Ip,");
		sb.append(" en_ent.Telno_pat, ");
		sb.append(" depphy.name Name_dep_phy, ");
		sb.append(" depnur.name Name_dep_nur, ");
		sb.append(" en_ent.Id_ent, ");
		sb.append(" en_ent.id_pat, ");
		sb.append(" en_ent.code_entp, ");
		sb.append(" en_ent.fg_ip, ");
		sb.append(" en_ent.ID_dep_nur, ");
		sb.append(" en_ent.ID_dep_phy, ");
		sb.append(" en_ent.ID_emp_phy, ");
		sb.append(" en_ent.DT_ACPT, ");
		sb.append(" en_ent.ds, ");
		sb.append(" en_ent.sv ");
		sb.append(" FROM en_ent en_ent ");
		sb.append(" INNER JOIN pi_pat pat ON en_ent.ID_PAT = pat.ID_PAT ");
		sb.append(" INNER JOIN bd_hp hp ON hp.ID_HP = en_ent.ID_HP ");
		sb.append(" LEFT OUTER JOIN EN_ENT_IP eip ON en_ent.ID_ENT = eip.ID_ENT ");
		//sb.append(" join bd_pri_pat pripat on en_ent.id_pripat=pripat.id_pripat ");
		sb.append(" left join bd_dep depnur on en_ent.id_dep_nur=depnur.id_dep ");
		sb.append(" left join bd_dep depphy on en_ent.ID_dep_phy=depphy.id_dep ");
		sb.append(" WHERE 1 = 1  ");
//		sb.append(" WHERE 1 = 1 AND en_ent.fg_st = 'N' AND en_ent.FG_CANC='N' ");
//		sb.append(" AND en_ent.FG_IP='N' AND nvl(en_ent.id_hp,'~') != '~' ");
		//sb.append(" and ").append(BlGroupControlUtils.getGroupControlFitler(new PatDODesc(), "en_ent"));

		String wherePart = "";
		// 这个是原有的条件语句
		List<String> oldWherepartArr = this.getWherePart();
		for (String strWhere : oldWherepartArr) {
			sb = sb.append(" and ").append(strWhere);
		}
		sb = sb.append(wherePart).append(" order by en_ent.dt_entry desc,eip.times_ip desc ");
		return sb.toString();
	}

	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "en_ent.NAME_PAT", "en_ent.CODE", "pat.CODE", "eip.CODE_AMR_IP", "pat.PYCODE",
				"pat.WBCODE" };
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
