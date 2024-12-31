package iih.bl.st.blstip.refs;

import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;
/**
 * 住院医保结算结算参照模型
 * @author HanJQ
 *
 */
public class BlStIpHpRefModel extends RefGridModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 显示字段
	 */
	@Override
	public String[] getShowFieldCode() {
		
		return new String[] { "name_pat", "code_st", "code_amr_ip", "times_ip" , "dt_st" };
	}
	/**
	 * 显示名称
	 */
	@Override
	public String[] getShowFieldName() {
		
		return new String[] { "患者", "结算号", "住院号", "住院次数","结算时间" };
	}
	/**
	 * 隐藏字段
	 */
	@Override
	public String[] getHiddenFieldCode() {
		 
		return new String[] { "id_stip", "code_hp","code_ca"};
	}
	
	@Override
	public String getPkFieldCode() {
		return "id_stip";
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
		return new String[] { "name_pat", "code_st", "code_amr_ip","code_ca"};
	}
	
	@Override
	public String getRefSql() {		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("SELECT ");
		sqlSb.append("	ENT.name_pat , ST_IP.code_st , ENT_IP.code_amr_ip,	ENT_IP.times_ip,ST_IP.dt_st ,");
		sqlSb.append("	ST_IP.id_stip , HP.CODE code_hp , PPC.CODE code_ca ");
		sqlSb.append("FROM BL_ST_IP ST_IP ");
		sqlSb.append("INNER JOIN BL_PROP_IP PROP_IP ON PROP_IP.ID_STIP = ST_IP.ID_STIP ");
		sqlSb.append("INNER JOIN BL_PROP_AR_IP PROP_AR_IP ON PROP_AR_IP.ID_PROPIP = PROP_IP.ID_PROPIP ");
		sqlSb.append("INNER JOIN BD_HP HP ON HP.ID_HP =PROP_AR_IP.ID_HP ");
		sqlSb.append("LEFT JOIN EN_ENT ENT ON ENT.ID_ENT = ST_IP.ID_ENT ");
		sqlSb.append("LEFT JOIN EN_ENT_IP ENT_IP ON ENT_IP.ID_ENT = ST_IP.ID_ENT ");
		sqlSb.append("LEFT JOIN pi_pat_ca ppc ON ENT.ID_PATCA = PPC.ID_PATCA ");
		sqlSb.append("WHERE ");
		sqlSb.append("	ST_IP.FG_CANC = 'N' ");
		sqlSb.append("	AND ST_IP.EU_DIRECT = 1 ");
		sqlSb.append("ORDER BY NLSSORT(ENT.name_pat,'NLS_SORT = SCHINESE_PINYIN_M') ");
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
