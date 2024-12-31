package iih.bl.pay.refs;
import java.util.List;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;
import xap.sys.appfw.refinfo.AbstractRefModel;

public class PatiVisitOepRefModel  extends RefGridModel {

	// 门诊就诊参照模型，用于门诊费用清单节点的参照模型
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Override
		public String[] getShowFieldCode() {
			return new String[]{PatiVisitDO.NAME_PAT,"code_pat",PatiVisitDO.CODE,"pycode_namepat",PatiVisitDO.DT_ENTRY,"name_dept"};
		}

		@Override
		public String[] getHiddenFieldCode() {
			return new String[]{PatiVisitDO.ID_DEP_PHY,PatiVisitDO.ID_ENT,PatiVisitDO.DT_ACPT,PatiVisitDO.DT_INSERT,PatiVisitDO.CODE_ENTP,PatiVisitDO.FG_IP,PatiVisitDO.DS,PatiVisitDO.SV,PatiVisitDO.ID_PAT};
		}
		@Override
		public String[] getShowFieldName() {
			return new String[]{"患者姓名","患者编号","就诊编号","拼音码","就诊日期","就诊科室"};
		}
		
		@Override
		public String getPkFieldCode() {
			return PatiVisitDO.ID_ENT;
		}
		@Override
		public String getRefCodeField() {
			return PatiVisitDO.CODE;
		}
		@Override
		public String getRefNameField() {
			return PatiVisitDO.NAME_PAT;
		}

		@Override
		public String getTableName() {
			return new PatiVisitDO().getTableName();
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
			sb.append("select t.name_pat,t.code_pat,t.code,t.pycode_namepat,t.dt_entry ,t.name_dept,t.id_dep_phy,t.id_ent,t.dt_acpt,t.dt_insert,t.code_entp,t.fg_ip,t.ds,t.sv,t.id_pat  ");
			sb.append(" from (select distinct en_ent.name_pat,          ");
			sb.append("                 pi_pat.code    code_pat,        ");
			sb.append("                 en_ent.code,                    ");
			sb.append("                 pi_pat.pycode  pycode_namepat,  ");
			sb.append("                 en_ent.dt_entry,                 ");
			sb.append("                 bd_dep.name    name_dept,       ");
			sb.append("                 en_ent.id_dep_phy,              ");
			sb.append("                 en_ent.id_ent,                  ");
			sb.append("                 en_ent.dt_acpt,     ");
			sb.append("                 en_ent.dt_insert,     ");
			sb.append("                 en_ent.code_entp,               ");
			sb.append("                 en_ent.fg_ip,                   ");
			sb.append("                 en_ent.ds,                      ");
			sb.append("                 en_ent.sv,                      ");
			sb.append("                 en_ent.id_pat                   ");
			sb.append("          from  en_ent                                    ");
			sb.append("           inner join pi_pat                  ");
			sb.append("           on pi_pat.id_pat = en_ent.id_pat      ");
			sb.append("           left outer join bd_dep                  ");
			sb.append("           on en_ent.id_dep_phy=bd_dep.id_dep    ");
			sb.append("          where (en_ent.code_entp = 00  or en_ent.code_entp=01) ");
			sb.append("           and en_ent.fg_canc = 'N'               ");
			sb.append("           and en_ent.ds=0                  ");
	        sb.append("  union all                                 ");
			sb.append("     select distinct pi_pat.name name_pat,  ");
			sb.append("       pi_pat.code    code_pat,             ");
			sb.append("       '不限就诊编码'           code,           ");
			sb.append("       pi_pat.pycode  pycode_namepat,       ");
			sb.append("       pi_pat.sv  dt_entry,                 ");
			sb.append("       '不限科室'  name_dept,                  ");
			sb.append("       null  id_dep_phy,                    ");
			sb.append("       null  id_ent,                        ");
			sb.append("       null    dt_acpt,                     ");
			sb.append("       null  dt_insert,                     ");
			sb.append("       null  code_entp,                        ");
			sb.append("       null  fg_ip,                            ");
			sb.append("       0    ds,                                ");
			sb.append("       null sv,                               ");
			sb.append("       pi_pat.id_pat                               ");
			sb.append("       from   pi_pat           ");
			sb.append("        left join en_ent  on  pi_pat.id_pat=en_ent.id_pat ");
	        sb.append(" )t"); 
			sb.append("   where 1=1  ");
			
		
			String wherePart = "";
			boolean IsWithAnd = true;		
			//这个是原有的条件语句
			List<String>  oldWherepartArr = this.getWherePart();
			for(String strWhere :oldWherepartArr )
			{
				if(strWhere.contains("=")){  //此时是用户在参照控件中输入了检索文字时
					String[] ss=strWhere.split("=");  //此时strWhere为“en_ent.id_ent=‘xxx’”字符串，此时应该查询的别名为t，所以需要将其解析出来自己拼条件为“t.id_ent='xxx'”
					String str1=ss[0];
					String str2=ss[1];
					//sb=sb.append(" and ").append(strWhere);
					sb=sb.append(" and t.id_ent=").append(str2);	
				}else{
					sb=sb.append(" and ").append(strWhere);
				}
			}	
			sb=sb.append(wherePart).append(" order by case when dt_entry is not null then 1 else 0 end, dt_entry desc ,name_pat desc ");
			System.out.println("测试门诊费用清单自定义参照模型"+sb);
			return sb.toString();
		}
		
		@Override
		public String[] getBlurFields(){
			return new String[]{"EN_ENT.NAME_PAT","EN_ENT.CODE","PI_PAT.CODE","PI_PAT.PYCODE"};  //用户可能在参照控件中输入的字段内容
			
		}
		
		@Override
		public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg)
		{	
			//重写该方法，该方法是模糊字段检索的处理
			String[] fields = this.getBlurFields();
			if (fields == null)
				// 当搜索字段没有定义时，默认使用显示字段来过滤
				fields = this.getShowFieldCode();
			
			StringBuilder buf = new StringBuilder();
			//buf.append("  (t.NAME_PAT like '"+ blurValue.toLowerCase()+"%'  or lower(t.code) like '"+blurValue.toLowerCase()+"%' or lower(t.Code_pat) like '"+blurValue.toLowerCase()+"%' or  lower(t.pycode_namepat) like '"+blurValue+"%')");
	 
			buf.append("  (t.NAME_PAT like ");
			buf.append(" ? ");
			this.getParam().addParam(blurValue.toLowerCase()+"%");
			buf.append(" or lower(t.code) like ");
			buf.append(" ? ");
			this.getParam().addParam(blurValue.toLowerCase()+"%");
			buf.append(" or lower(t.Code_pat) like ");
			buf.append(" ? ");
			this.getParam().addParam(blurValue.toLowerCase()+"%");
			buf.append(" or lower(t.pycode_namepat) like ");
			buf.append(" ? ");
			this.getParam().addParam(blurValue.toLowerCase()+"%");
			
			buf.append(")");
			
			String str = buf.toString();
			this.addWherePart(str);
			
			try 
			{	if(pg == null)
			    {	
				  //RefResultSet  rrs=(RefResultSet)this.getRefData()   ;
				  return this.getRefData();
			   }else{
				      return this.getRefData(pg);
				   }
			} finally {
				this.removeWherePart(str);
			}
        }
 
}