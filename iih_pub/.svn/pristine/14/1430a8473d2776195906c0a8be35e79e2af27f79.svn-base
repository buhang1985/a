package iih.mp.dg.ipdgapp.refs;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class CipresNameRefModel extends RefGridModel {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		
		return new String[] { "name" };
	}
	
	public String[] getShowFieldName() {
		
		return new String[] { "名称" };
	}
	
	@Override
	public String getPkFieldCode() {
		return "name";
	}

	@Override
	public String getRefCodeField() {
		
		return "name";
	}

	@Override
	public String getRefNameField() {
		
		return "name";
	}
	
	@Override
	public String getTableName() {
		return "ci_pres";
	}
	
	@Override
	public String getRefSql(){
		
		String id_dep_ap=(String)this.getExtendAttributeValue("id_dep_ap");//请领部门
		
		String sql = " select distinct name "
				 + " from ci_pres where id_en in (select id_ent from en_ent_ip) and nvl(name, '~') <> '~' ";
		
		if(!StringUtil.isEmpty(id_dep_ap)) {
			sql += " and ci_pres.id_dep_or ='" + id_dep_ap + "' ";
		}
		
		sql += " order by ci_pres.name ";
		
		return sql.toString();
	}
}
