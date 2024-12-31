package iih.bl.pay.refs;

import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.List;

import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

public class PatiVisitOpRefModel extends RefGridModel {

	// 门诊就诊参照模型，用于门诊费用清单节点的参照模型
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Override
		public String[] getShowFieldCode() {
			return new String[]{PatiVisitDO.NAME_PAT,PatiVisitDO.CODE,"DT_ENTRY","NAME_DEPT","PYCODE_NAMEPAT","WBCODE","MNECODE"};
		}

		@Override
		public String[] getHiddenFieldCode() {
			return new String[]{PatiVisitDO.ID_ENT,PatiVisitDO.ID_DEP_PHY,PatiVisitDO.DT_ACPT,PatiVisitDO.DT_INSERT,PatiVisitDO.CODE_ENTP,PatiVisitDO.FG_IP,PatiVisitDO.DS,PatiVisitDO.SV,PatiVisitDO.ID_PAT};
		}
		@Override
		public String[] getShowFieldName() {
			return new String[]{"患者姓名","就诊编号","就诊时间","就诊科室","拼音码","五笔码","助记码"};
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
			sb.append("  select distinct en_ent.name_pat,               ");
			sb.append("                 en_ent.code,                    ");
			sb.append("      substr(en_ent.dt_entry,0, instr(en_ent.dt_entry,' ')) as dt_entry              ,                ");   //  en_ent.dt_entry
			sb.append("                 bd_dep.name    name_dept,       ");
			sb.append("                 pi_pat.pycode  pycode_namepat,  ");
			sb.append("                 pi_pat.wbcode  ,                ");
			sb.append("                 pi_pat.mnecode ,                ");
			sb.append("                 en_ent.id_ent,                  ");
			sb.append("                 en_ent.id_dep_phy,              ");
			sb.append("                 en_ent.dt_acpt,                 ");
			sb.append("                 en_ent.dt_insert,               ");
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
			sb.append("           and en_ent.ds=0                    ");
			
			boolean IsWithAnd = true;		
			//这个是原有的条件语句
			List<String>  oldWherepartArr = this.getWherePart();
			
			for(String strWhere :oldWherepartArr )
			{
				sb=sb.append(" and ").append(strWhere);
			}	
			sb=sb.append("  order by case when dt_entry is not null then 1 else 0 end, dt_entry desc ,name_pat desc ");
			//System.out.println("测试门诊费用清单自定义参照模型"+sb);
			String wherePart = " (en_ent.code_entp = 00  or en_ent.code_entp=01)   and en_ent.fg_canc = 'N'  and en_ent.ds=0   " ;
			try{
				return sb.toString();
			}finally{
				getWherePart().remove(wherePart);
			}
		}
		
		@Override
		public String[] getBlurFields(){
			return new String[]{"EN_ENT.NAME_PAT","EN_ENT.CODE","PI_PAT.PYCODE","PI_PAT.WBCODE","PI_PAT.MNECODE"};  //用户可能在参照控件中输入的字段内容
			
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