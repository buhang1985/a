package iih.ci.ord.refs;

import java.util.List;

import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

public class CiordPrintPatRefModeNew extends RefGridModel {

	/**
	 * 参照显示的字段
	 * 
	 * @return
	 */
	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub   
		return new String[] { "name_bed", "name_pat", "code_amr_ip", "times_ip", "code", "name_dep_nur" };
	}

	/**
	 * 参照隐藏的字段
	 * 
	 * @return
	 */
	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { "id_pat", "id_ent", "id_entp", "code_entp", "id_dep_phy", "name_dep_phy", "id_dep_nur" };
	}

	/**
	 * 显示字段的显示名称
	 * 
	 * @return
	 */
	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[] { "床号", "姓名", "住院号", "住院就诊次数", "就诊号", "病区"};
	}

	/**
	 * 主键
	 * 
	 * @return
	 */
	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return "id_ent";
	}

	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return "code";
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return "name_pat";
	}
	
	/**
	 * 按输入内容查询时，查询条件字段
	 * 
	 * @return
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { "name_pat", "code" };
	}

	/**
	 * 按输入内容查询时，自定义查询条件字段
	 * 
	 * @return
	 */
	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		String[] fields = this.getBlurFields();
		if (fields == null)
			fields = this.getShowFieldCode();
		
		StringBuilder buf = new StringBuilder();
		buf.append("( 1<>1");
		for(String field : fields) {
			buf.append(" or lower(" + this.getTableName() + "." + field + ") like lower('%" + blurValue + "%')");
		}
		buf.append(" or lower(ENTIP.name_bed) like lower('%" + blurValue + "%')");
		buf.append(" or lower(ENTIP.code_amr_ip) like lower('%" + blurValue + "%')");
		buf.append(" or lower(PAT.pycode) like lower('%" + blurValue + "%'))");
		
		String str = buf.toString();
		this.addWherePart(str);
		try {
			if (pg == null)
				return this.getRefData();
			else
				return this.getRefData(pg);
		} finally {
			this.removeWherePart(str);
		}
	}

	/**
	 * 查询sql语句
	 * 
	 * @return
	 */
	@Override
	public String getRefSql() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("select ENTIP.name_bed,ENT.name_pat,ENTIP.code_amr_ip,ENTIP.times_ip,ENT.code,NUR.name as name_dep_nur,")
		.append("ENT.id_pat,ENT.id_ent,ENT.id_entp,ENT.code_entp,")
		.append("ENT.id_dep_phy,PHY.name as name_dep_phy,ENT.id_dep_nur ")
		.append(" from en_ent ENT ")
		.append(" left join en_ent_ip ENTIP on ENTIP.id_ent=ENT.id_ent")
		.append(" left join bd_dep PHY on PHY.id_dep=ENT.id_dep_phy")
		.append(" left join bd_dep NUR on NUR.id_dep=ENT.id_dep_nur")
		.append(" left join pi_pat PAT on PAT.id_pat=ENT.id_pat")
		.append(" where ENT.code_entp in ('10','0103')");
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" and ").append(where);
			}
		}
		sb.append(" order by ENTIP.name_bed");
		return sb.toString();
	}

	/**
	 * 主表
	 * @return
	 */
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "ENT";
	}
}
