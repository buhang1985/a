package iih.mp.dg.ipdgapp.refs;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class DgDispCodeRefModel extends RefGridModel {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode(){
		
		return new String[] { "code_dgipap", "name_aptype" };
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		
		return null;
	}

	@Override
	public String[] getShowFieldName() {
		
		return new String[] { "摆药单号", "药单类型" };
	}
	
	@Override
	public String getPkFieldCode() {
		return "code_dgipap";
	}

	@Override
	public String getRefCodeField() {
		
		return "code_dgipap";
	}

	@Override
	public String getRefNameField() {
		
		return "code_dgipap";
	}
	
	@Override
	public String getTableName() {
		return "t";
	}
	
	@Override
	public String getRefSql(){
		
		String id_dep_ap=(String)this.getExtendAttributeValue("id_dep_ap");//请领部门
		String id_aptype = (String)this.getExtendAttributeValue("id_aptype");//药单类型
		String dt_begin = (String)this.getExtendAttributeValue("dt_begin");//开始时间
		String dt_end = (String)this.getExtendAttributeValue("dt_end");//结束时间
		
		String sql = "select distinct de.code_dgipap, "
				+ this.getShetNameStr()
				+ " from mp_dg_ip_de de "
				+ " inner join mp_dg_ip_apde_dt dt "
				+ " on de.id_dgipde = dt.id_dgipde "
				+ " left join mp_dg_ip_ap ap "
				+ " on de.id_dgipap  = ap.id_dgipap "
				+ " left join mp_dg_shetp shet "
				+ " on ap.id_aptype = shet.id_dgshetp "
				+ "where 1=1 ";
		
		if(!StringUtil.isEmpty(id_dep_ap)) {
			sql += " and ap.id_dep_ap='" + id_dep_ap + "' ";
		}
		if(!StringUtil.isEmpty(id_aptype)){
			sql += " and ap.id_aptype='" + id_aptype + "' ";
		}
		if(!StringUtil.isEmpty(dt_begin)){
			sql += " and de.dt_dp >='" + dt_begin + "' ";
		}
		if(!StringUtil.isEmpty(dt_end)){
			sql += " and de.dt_dp <='" + dt_end + "' ";
		}
		
		//批量摆药摆药单
		sql +="union all ";
		sql += "select distinct de.code_dgipap, "
				+ " '批量发药单' as name_aptype"
				+ " from mp_dg_ip_debat de "
				+ " inner join mp_dg_ip_apde_dt dt "
				+ " on de.id_dgipdebat = dt.id_dgipde "
				+ " left join mp_dg_ip_ap ap "
				+ " on dt.id_dgipap  = ap.id_dgipap "
				+ "where 1=1 "
				+ "and de.code_dgipap is not null ";
		
		if(!StringUtil.isEmpty(id_dep_ap)) {
			sql += " and ap.id_dep_ap='" + id_dep_ap + "' ";
		}
		if(!StringUtil.isEmpty(id_aptype)){
			sql += " and ap.id_aptype='" + id_aptype + "' ";
		}
		if(!StringUtil.isEmpty(dt_begin)){
			sql += " and de.dt_dp >='" + dt_begin + "' ";
		}
		if(!StringUtil.isEmpty(dt_end)){
			sql += " and de.dt_dp <='" + dt_end + "' ";
		}
		
		//模糊查询字段表名不同,包一层sql
		sql = "select * from (" + sql + ") t where 1 = 1";
		
		StringBuilder sb = new StringBuilder(sql);
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}
		
		sb.append("order by t.code_dgipap");

		return sb.toString();
		
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { "code_dgipap", "name_aptype" };
	}
	
	private String getShetNameStr(){
		
		return " nvl(shet.name,case de.sd_dgtp when '21' then '发药单' when '22' then '退药单' when '23' then '出院带药单' end) as name_aptype";
	}
}
