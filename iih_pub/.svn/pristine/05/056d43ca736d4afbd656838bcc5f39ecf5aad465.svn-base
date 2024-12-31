package iih.mp.dg.opinfu.refs;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 输液登记患者参照
 * @author ly
 *
 */
public class OpInfuPatRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		
		return new String[] { "code_pat", "name_pat" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		
		return new String[] { "id_pat" };
	}

	@Override
	public String[] getShowFieldName() {
		
		return new String[] { "患者编号", "患者姓名" };
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
		return "infupat";
	}
	
	@Override
	public String getRefSql() {
		
		String depId = (String) this.getExtendAttributeValue("depId");
		
		String sql = "select distinct pat.code code_pat,pat.name name_pat,infu.id_pat,pat.pycode,pat.wbcode  "
				+ "from mp_dg_infu infu inner join pi_pat pat "
				+ "on infu.id_pat = pat.id_pat "
				+ "where 1=1 "
				+ "and infu.eu_su_mp > 0 and pat.id_org = '"+Context.get().getOrgId()+"' and pat.id_grp='"+Context.get().getGroupId()+"' ";
		
		if(!StringUtil.isEmpty(depId)){
			sql += "and infu.id_dep_mp = '"+depId+"' ";
		}
		
		//包装一层
		sql = "select * from (" +sql+ ") infupat where 1=1 ";
		
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
	public List<String> getOrderPart() {
		List<String> orderList = super.getOrderPart();
		if(orderList == null){
			orderList = new ArrayList<String>();
		}
		
		if(orderList.contains("code_pat"))
			return orderList;
		
		orderList.add("code_pat");
		return orderList;
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[]{"name_pat","code_pat","pycode","wbcode" };
	}
}
