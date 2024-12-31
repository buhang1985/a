package iih.ci.ord.refs;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.sys.appfw.refinfo.RefGridModel;

public class CiApHvRefModel extends RefGridModel{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		
		return new String[]{"Name_or","Dt_plan","No_applyform"};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{"Id_or","Id_dep_mp","Name_dep_loc","Id_dep_ap","Name_dep_ap","Content_or","Id_en","Code_entp","Fg_sign","Name_sign"};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"医嘱名称","手术时间","申请单号"};
	}
	
	@Override
	public String getPkFieldCode() {
		return "Id_or"; 
	}
	
	@Override
	public String getRefCodeField() {
		return "No_applyform";
	}
	
	@Override
	public String getRefNameField() {
		return "Name_or";
	}
	
		
	@Override
	public String getRefSql() {
		
		StringBuffer refSql=new StringBuffer();	
		refSql.append("select * from ");
		refSql.append("( ");
		refSql.append("  select  ");
		refSql.append("  ci.name_or, ");
		refSql.append("  sug.dt_plan, ");
		refSql.append("  sug.no_applyform, ");
		refSql.append("  ci.id_or, ");
		refSql.append("  ci.id_dep_mp, ");
		refSql.append("  dep.name as name_dep_loc, ");
		refSql.append("  ci.id_dep_or as id_dep_ap, ");
		refSql.append("  (select name from bd_dep dep where dep.id_dep = ci.id_dep_or) as name_dep_ap, ");
		refSql.append("  ci.content_or, ");
		refSql.append("  ci.id_en, ");
		refSql.append("  ci.code_entp, ");
		refSql.append("  ci.fg_sign, ");
		refSql.append("  (select e.name from bd_psndoc e where e.id_psndoc = ci.id_emp_sign) as name_sign ");
		refSql.append("  from ci_ap_sug sug ");
		refSql.append("  inner join ci_order ci ");
		refSql.append("  on sug.id_or = ci.id_or ");
		refSql.append("  inner join bd_dep dep on dep.id_dep = ci.id_dep_mp ");
		refSql.append("  where  ci.fg_sign = 'Y' ");
		
		refSql.append(") ci_ap_hv where 1=1 ");
		
		String wherePart = BuildWherePart();

		if (StringUtils.isNotEmpty(wherePart)) {
			this.getWherePart().add(wherePart);
		}
			
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				refSql.append(" And (").append(where).append(") ");
			}
		}
		     	
		return refSql.toString();
	}
	
	@Override
	public String getTableName() {
		return "ci_ap_hv";	
	}
	
	//模糊查询
	@Override
	public String[] getBlurFields() {
		
		return new String[]{"no_applyform","name_or"};
    }
	
	/**
	 * 构建条件语句
	 * 
	 * @return
	 * @throws BizException 
	 */
	private String BuildWherePart(){
		StringBuilder stringBuilder = new StringBuilder("1 = 1");

		String idEnt = (String) this.getExtendAttributeValue("id_ent");
		

		if (StringUtils.isNotEmpty(idEnt)) {
			// 过滤为指定仓库
			String wherePart = String.format(" and id_en = '%s'", idEnt);
			stringBuilder.append(wherePart);
		}else{
			stringBuilder.append(" and 1=2 ");
		}
		
		return stringBuilder.toString();
	}
	
}
