package iih.bl.st.blstip.refs;

import java.util.List;

import iih.bl.st.blstip.d.BlStIpDO;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

public class BlStIpRefModel extends RefGridModel {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{BlStIpDO.CODE_ST,BlStIpDO.DT_ST};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{BlStIpDO.ID_STIP,BlStIpDO.ID_ENT};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"结算号","结算时间"};
	}
	
	
	@Override
	public String getPkFieldCode() {
		return BlStIpDO.ID_STIP;
	}
	
	@Override
	public String getRefNameField() {
		return BlStIpDO.CODE_ST;
	};
	
	@Override
	public String getRefCodeField() {
		return BlStIpDO.CODE_ST;
	}
	
	@Override
	public String getTableName() {
		return new BlStIpDO().getTableName();
	}
	
	@Override
	public String afterBuilderSql(String sql){
		return super.afterBuilderSql(sql);
	}
	
	@Override
	public String getRefSql(){
		StringBuffer  sb = new StringBuffer();
		sb.append("  select distinct bl_st_ip.code_st, bl_st_ip.dt_st, bl_st_ip.id_stip, bl_st_ip.id_ent ");	
		sb.append("  from (select distinct cg.id_ent, st.id_stip, st.fg_canc, st.eu_direct, st.dt_st, st.code_st ");
		sb.append("        from bl_st_ip st ");
		sb.append("        inner join bl_cg_ip cg on cg.id_stip = st.id_stip) bl_st_ip ");
		sb.append("  where 1=1 ");
		
		String wherePart = "";
		boolean IsWithAnd = true;		
		//这个是原有的条件语句
		List<String> oldWherepartArr = this.getWherePart();
		if (oldWherepartArr.size() > 0) {
			for (String strWhere : oldWherepartArr) {
				sb = sb.append(" and ").append(strWhere);
			}
		}
		sb = sb.append(wherePart).append(" order by dt_st desc, code_st desc ");
		System.out.println("测试门诊费用清单自定义参照模型"+sb);
		return sb.toString();
	}
	
	@Override
	public String[] getBlurFields(){
		return new String[]{"code_st"};  //用户可能在参照控件中输入的字段内容
		
	}
	
	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg)
	{	
		String[] fields = this.getBlurFields();
		if (fields == null) {
			fields = this.getShowFieldCode();
		}

		StringBuilder buf = new StringBuilder();
		buf.append("(");
		for (int i = 0; i < fields.length; i++) {
			String field = fields[i];
			buf.append("lower(");
			buf.append(field);
			buf.append(")");
			buf.append(" like '%");
			buf.append(blurValue.toLowerCase());
			buf.append("%'");
			if (i != fields.length - 1)
				buf.append(" or ");
		}
		buf.append(")");
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

}
