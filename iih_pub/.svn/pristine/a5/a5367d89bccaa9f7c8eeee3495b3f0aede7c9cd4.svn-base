package iih.en.pv.inpatient.refs;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 住院患者参照模型
 * @author ly
 *
 */
public class InpatientPatiRefModel extends RefGridModel {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		
		return new String[] { "code_bed", "code_amr_ip", "name_pat", "code_pat" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		
		return new String[] { "id_pat","id_ent" };
	}

	@Override
	public String[] getShowFieldName() {
		
		return new String[] { "床号", "住院号", "患者姓名", "患者编号" };
	}

	@Override
	public String getPkFieldCode() {
		return "id_pat";
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
		return "patbed";
	}
	
	@Override
	public String getRefSql() {
		
		String depId = (String) this.getExtendAttributeValue("depId");
		
		String sql = "select * from (select ip.name_bed as code_bed,ip.code_amr_ip,ent.name_pat,pat.code as code_pat,ent.id_pat,ent.id_ent,pat.pycode,pat.wbcode,ent.id_dep_nur "
				+ "from en_ent_ip ip "
				+ "inner join en_ent ent "
				+ "on ip.id_ent = ent.id_ent "
				+ "inner join pi_pat pat "
				+ "on ent.id_pat = pat.id_pat "
				+ "where ent.fg_ip = 'Y' and ent.fg_acptvalid = 'Y' and ent.fg_st = 'N' order by ip.name_bed,pat.code ) patbed  where 1=1 ";
		
		if(!StringUtil.isEmpty(depId)){
			sql += " and patbed.id_dep_nur = '"+depId+"'";
		}
		
		StringBuilder sb = new StringBuilder(sql);
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}

		return sb.toString();		
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[]{"name_pat","code_pat","pycode","wbcode","code_bed","code_amr_ip" };
	}
}
