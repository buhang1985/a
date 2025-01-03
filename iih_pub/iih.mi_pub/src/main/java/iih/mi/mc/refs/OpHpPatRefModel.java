package iih.mi.mc.refs;

import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;
/**
 * 门诊医保患者参照
 * @author liming06
 *
 */
public class OpHpPatRefModel extends RefGridModel{

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "code_pat", "name_pat","no_hp","name_hp","mob"};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_pat","id_hp","id_pat_hp"};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "患者编号", "患者姓名","医保卡号","医保计划","联系方式"};
	}

	@Override
	public String getPkFieldCode() {
		return "id_pat_hp";
	}

	@Override
	public String getRefCodeField() {
		
		return "code_pat";
	}

	@Override
	public String getRefNameField() {
		
		return "name_pat";
	}
	
	@Override
	public String getTableName(){
		return "oppat";
	}
	
	@Override
	public String getRefSql() {
		
		String sql = " select *"
				   + "   from (select distinct pat.code    code_pat,"
				   + "                         pat.name    name_pat,"
				   + "                         pathp.no_hp,"
				   + "                         hp.name     as name_hp,"
				   + "                         pat.mob,"
				   + "                         pat.id_pat,"
				   + "                         pathp.id_hp,"
				   + "                         pat.id_pat || pathp.id_hp as id_pat_hp,"
				   + "                         pat.pycode,"
				   + "                         pat.wbcode"
				   + "           from pi_pat pat"
				   + "          inner join pi_pat_hp pathp"
				   + "             on pat.id_pat = pathp.id_pat"
				   + "          inner join bd_hp hp"
				   + "             on pathp.id_hp = hp.id_hp and nvl(pathp.no_hp,'~')<>'~'"
				   + "         ) oppat"
				   + "  where 1 = 1";
		
		StringBuilder sb = new StringBuilder(sql);
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}
		sb.append(" order by code_pat ");
		return sb.toString();		
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[]{"name_pat","code_pat","pycode","wbcode" };
	}
	
}