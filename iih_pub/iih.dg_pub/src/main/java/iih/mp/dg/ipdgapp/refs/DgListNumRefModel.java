package iih.mp.dg.ipdgapp.refs;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class DgListNumRefModel extends RefGridModel {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode(){
		
		return new String[] { "code_dgipap", "name_aptype" };
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		
		return new String[] { "id_dgipap" };//id_dgipap：住院药品请领主键 id_dep_ap:请领部门
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
		
		Boolean fg_herb=(Boolean)this.getExtendAttributeValue("fg_herb");//草药标志
		String id_dep_ap=(String)this.getExtendAttributeValue("id_dep_ap");//请领部门
		String id_dep_wh = (String)this.getExtendAttributeValue("id_dep_wh");//库房
		String id_aptype = (String)this.getExtendAttributeValue("id_aptype");//药单类型
		String dt_begin = (String)this.getExtendAttributeValue("dt_begin");//开始时间
		String dt_end = (String)this.getExtendAttributeValue("dt_end");//结束时间
		String onlyOt = (String)this.getExtendAttributeValue("only_ot");//显示医技药单 Y:只显示医技药单 N:过滤掉医技药单
		
		String sql = "select distinct ap.code_dgipap,stp.name as name_aptype,ap.id_dgipap "
		             + "from mp_dg_ip_ap ap "
		             + "inner join mp_dg_ip_apde_dt dt "
		             + "on ap.id_dgipap = dt.id_dgipap "
		             + "and ap.sd_dgap in ('1','2','3') "
		             + "left join mp_dg_shetp stp "
		             + "on ap.id_aptype = stp.id_dgshetp "
				     + "where 1=1 ";
		if (fg_herb != null) {
			sql += " and dt.sd_srvtp " + (fg_herb ? "" : "not") + " like '0103%'";
		}
		if(!StringUtil.isEmpty(id_dep_ap)) {
			sql += " and ap.id_dep_ap='" + id_dep_ap + "' ";
		}
		if(!StringUtil.isEmpty(id_dep_wh)){
			sql += " and ap.id_dep_wh='" + id_dep_wh + "' ";
		}
		if(!StringUtil.isEmpty(id_aptype)){
			sql += " and ap.id_aptype='" + id_aptype + "' ";
		}
		if(!StringUtil.isEmpty(dt_begin)){
			sql += " and ap.disp_time >='" + dt_begin + "' ";
		}
		if(!StringUtil.isEmpty(dt_end)){
			sql += " and ap.disp_time <='" + dt_end + "' ";
		}
		if("Y".equals(onlyOt)){
			sql += " and id_dgshetp in " + this.getAutoSheetSql();
		}else if("N".equals(onlyOt)){
			sql += " and id_dgshetp not in " + this.getAutoSheetSql();
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
	
	/**
	 * 过滤医技药单sql
	 * @return
	 */
	private String getAutoSheetSql(){
		return "(select id_dgshetp from mp_dg_shetpauto where sd_spauto in ('1','2')) ";
	}
}
