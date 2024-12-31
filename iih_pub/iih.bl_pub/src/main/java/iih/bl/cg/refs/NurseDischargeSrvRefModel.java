package iih.bl.cg.refs;

import iih.bd.srv.medsrv.d.MedSrvDO;



import java.util.List;

import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

public class NurseDischargeSrvRefModel extends RefGridModel{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{MedSrvDO.NAME,MedSrvDO.CODE,MedSrvDO.PYCODE,MedSrvDO.WBCODE,MedSrvDO.MNECODE};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{MedSrvDO.ID_SRV,"ID_ENT","ID_MM","NAME_MM","ID_DEP_OR","ID_DEP_NUR","ID_DEP_MP","CD_BATCH","SPEC","PRICE"};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"服务名称","服务编码","拼音码","五笔码","助记码"};
	}
	
	@Override
	public String getPkFieldCode() {
		return MedSrvDO.ID_SRV;
	}
	@Override
	public String getRefCodeField() {
		return MedSrvDO.CODE;
	}
	@Override
	public String getRefNameField() {
		return MedSrvDO.NAME;
	}

	@Override
	public String getTableName() {
		return new MedSrvDO().getTableName();
	}

	@Override
	public void addWherePart(String wherePart) {	
		getWherePart().add(wherePart);
	}

	@Override
	public String afterBuilderSql(String sql){
		return super.afterBuilderSql(sql);
	}
	
	@Override
	public String getRefSql(){
		StringBuffer  sb=new StringBuffer();
	sb.append(" select A.*  from (                                                            ");
		sb.append("select distinct BD_SRV.name ,BD_SRV.code,Bd_srv.pycode,BD_SRV.wbcode,BD_SRV.mnecode,BD_SRV.ID_SRV , BL_CG_IP.ID_ENT,BL_CG_IP.ID_MM,BL_CG_IP.name_mm,BL_CG_IP.id_dep_or,BL_CG_IP.ID_DEP_NUR, BL_CG_IP.ID_DEP_MP, BL_CG_IP.CD_BATCH,BL_CG_IP.SPEC,BL_CG_IP.PRICE ");
		sb.append("  ,SUM(BL_CG_IP.quan*BL_CG_IP.Eu_Direct) quan                ");
		sb.append("   from    BD_SRV                                           ");
		sb.append("    INNER JOIN BL_CG_IP                                     ");
		sb.append("   ON BD_SRV.ID_SRV = BL_CG_IP.ID_SRV                       ");
		sb.append("  WHERE BD_SRV.FG_ACTIVE='Y' AND BD_SRV.FG_BL='Y' AND BD_SRV.DS=0   ");
		sb.append("     group by BD_SRV.name,                                  ");
		sb.append("         BD_SRV.code,                                       ");
		sb.append("         BD_SRV.ID_SRV,                                     ");
		sb.append("         Bd_srv.pycode,                                     ");
		sb.append("         Bd_srv.wbcode,                                     ");
		sb.append("         Bd_srv.mnecode,                                    ");
		sb.append("         BL_CG_IP.ID_ENT,                                   ");
		sb.append("         BL_CG_IP.ID_MM,                                    ");
		sb.append("         BL_CG_IP.name_mm,                                  ");
		sb.append("         BL_CG_IP.id_dep_or,                                ");
		sb.append("         BL_CG_IP.ID_DEP_NUR,                               ");
		sb.append("         BL_CG_IP.ID_DEP_MP,                                ");
		sb.append("         BL_CG_IP.CD_BATCH,                                 ");
		sb.append("         BL_CG_IP.SPEC,                                     ");
		sb.append("         BL_CG_IP.PRICE                                     ");    
     	sb.append("     )A  where A.quan>0                                       ");
        //sb.append("                                                            ");
		
		//String wherePart = "";
		boolean IsWithAnd = true;		
		//这个是原有的条件语句
		List<String>  oldWherepartArr = this.getWherePart();
		for(String strWhere :oldWherepartArr )
		{
			if(strWhere.contains("id_ent")){  //此时是用户在参照控件中输入了检索文字时
				String[] ss=strWhere.split("=");  //此时strWhere为“bl_cg_ip.id_ent=‘xxx’”字符串，此时应该查询的别名为t，所以需要将其解析出来自己拼条件为“A.id_ent='xxx'”
				String str1=ss[0];
				String str2=ss[1];  //str2解析出来的内容为等号后边的“xxx”内容
				sb=sb.append(" and A.id_ent=").append(str2);
			}
			
			if(strWhere.contains("BD_SRV.pycode") || strWhere.contains("BD_SRV.wbcode") || strWhere.contains("BD_SRV.mnecode")){  //此时是用户在参照控件中输入了检索文字时
				 //此时strWhere为“bd_srv.pycode like ‘xxx’”字符串，此时应该查询的别名为t，所以需要将其解析出来自己拼条件为“A.pycode like 'xxx'”
				 //str2解析出来的内容为 点 后边的“pycode like 'xxx'”内容
				String strs= strWhere.replace("BD_SRV", "A");
				sb=sb.append(" and ").append(strs);
			}
			

		}	
		
        sb.append("        order by    A.pycode  asc                        ");
		return sb.toString();
	}
	
	@Override
	public String[] getBlurFields(){
		return new String[]{"BD_SRV.pycode","bd_srv.wbcode","bd_srv.mnecode"};  //用户可能在参照控件中输入的字段内容
		
	}
	
	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) 
	{	//重写该方法，该方法是模糊字段检索的处理
		String[] fields = this.getBlurFields();
		if (fields == null)
			// 当搜索字段没有定义时，默认使用显示字段来过滤
			fields = this.getShowFieldCode();
		
		StringBuilder buf = new StringBuilder();
		buf.append(" ( BD_SRV.pycode  like '%").append(blurValue.toUpperCase()).append("%' ");
		buf.append("  or  BD_SRV.wbcode  like '%").append(blurValue.toUpperCase()).append("%' ");
		buf.append("  or  BD_SRV.mnecode  like '%").append(blurValue.toUpperCase()).append("%' ) ");
		
		String str = buf.toString();
		
		this.addWherePart(str);
		
		try 
		{	if(pg == null)
		    {	
			  return this.getRefData();
		   }else{
			      return this.getRefData(pg);
			   }
		} finally {
			this.removeWherePart(str);
		}
    }

}