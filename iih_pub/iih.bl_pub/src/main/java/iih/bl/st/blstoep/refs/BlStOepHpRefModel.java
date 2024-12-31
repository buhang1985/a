package iih.bl.st.blstoep.refs;

import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 门诊医保结算结算参照模型
 * @author HanJQ
 *
 */
public class BlStOepHpRefModel extends RefGridModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String[] getShowFieldCode() {
		return new String[] { "name_pat", "code_st", "dt_st", "name_st" };
	}
	/**
	 * 显示名称
	 */
	@Override
	public String[] getShowFieldName() {
		
		return new String[] { "患者", "结算号", "结算时间", "操作员" };
	}
	/**
	 * 隐藏字段
	 */
	@Override
	public String[] getHiddenFieldCode() {
		 
		return new String[] { "id_stoep", "code_hp"};
	}
	
	@Override
	public String getPkFieldCode() {
		return "id_stoep";
	}

	@Override
	public String getRefNameField() {		
		return "code_st";
	}
	
	@Override
	public String getRefCodeField() {
		return "code_st";
	}
	
	@Override
	public String getTableName(){
		return "stpat";
	}
	
	/**
	 * 默认查询条件
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { "name_pat", "code_st", "name_st"};
	}
	
	@Override
	public String getRefSql() {		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("SELECT ");
		sqlSb.append("	PAT.NAME name_pat,	st.code_st,	st.dt_st,	psn.name name_st,");
		sqlSb.append("	ST.id_stoep ,HP.code code_hp ");
		sqlSb.append("FROM bl_st_oep st ");
		sqlSb.append("INNER JOIN BL_PROP_OEP PROP  ON PROP.ID_STOEP = st.ID_STOEP ");
		sqlSb.append("INNER JOIN BL_PROP_AR_OEP AR  ON AR.id_propoep = PROP.id_propoep ");
		sqlSb.append("INNER JOIN BD_HP HP ON HP.id_hp = AR.id_hp ");
		sqlSb.append("LEFT JOIN PI_PAT pat ON st.ID_PAT = PAT.ID_PAT ");
		sqlSb.append("LEFT JOIN bd_psndoc psn ON psn.id_psndoc = st.id_emp_st ");
		sqlSb.append("WHERE	ST.FG_CANC = 'N' AND ST.EU_DIRECT = 1 ");
		sqlSb.append("ORDER BY NLSSORT(PAT.NAME,'NLS_SORT = SCHINESE_PINYIN_M') ");
		String sql = "select * from (" + sqlSb.toString() + ") stpat where 1=1 ";
		sqlSb = new StringBuilder(sql);
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sqlSb.append(" And (").append(where).append(") ");
			}
		}

		return sqlSb.toString();		
	}
}
