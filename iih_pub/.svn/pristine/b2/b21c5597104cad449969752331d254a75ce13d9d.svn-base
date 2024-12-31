package iih.mp.dg.ipdgapp.refs;

import xap.sys.appfw.refinfo.RefGridModel;

public class DepRefModelSend extends RefGridModel{
	
	private static final long serialVersionUID = 1L;
	

	@Override
	public String[] getShowFieldCode() {
		
		return new String[] { "code_dep", "name_dep" };
	}
	
	
	@Override
	public String[] getHiddenFieldCode() {
		
		return new String[] { "id_pat", "id_dep" };
	}

	@Override
	public String[] getShowFieldName() {
		
		return new String[] { "病区编码", "病区名称" };
	}
	
	@Override
	public String getPkFieldCode() {
		return "id_dep";
	}

	@Override
	public String getRefCodeField() {
		
		return "code_dep";
	}

	@Override
	public String getRefNameField() {
		
		return "name_dep";
	}
	
	
	@Override
	public String getRefSql(){
		
		
		
		String sql = "select distinct b.code,b.name,a.id_pat,b.id_dep "
		             +"from MP_DG_IP_APDE_DT a,bd_dep b "
				     +"where a.id_dep_wh=b.id_dep "
		             +"and a.eu_su_mp=0 "
				     +"and b.ds=0 ";
		
		
		
		StringBuilder sb = new StringBuilder(sql);
//		List<String> whereList = this.getWherePart();
//		if (whereList.size() > 0) {
//			//sb.append(" Where 1=1 ");
//			for (String where : this.getWherePart()) {
//				sb.append(" And (").append(where).append(") ");
//			}
//		}

		return sb.toString();
		
	}
	//模糊查询
	@Override
	public String[] getBlurFields() {
		return new String[]{"code","name","id_pat","id_dep"};
}
}