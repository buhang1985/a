package iih.ci.diag.dto.s.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiDiagQueryServiceQry implements ITransQry {
	
    public String _id_ent;
    
    public CiDiagQueryServiceQry(String id_ent){
    	this._id_ent = id_ent;
    }
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(this._id_ent);
		rtnParam.addParam(this._id_ent);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}
  
	private String getSql(){
		/*return "  select c.code as di_code,c.name as di_name from bd_di_cd c, bd_di_def f "+
               "  where c.id_di = f.id_di  ";*/
		return "  select def.name di_name ,def.code di_code, cidi.id_ent,  item.id_di ,"+
		        "  cidi.id_pat ,cidi.code_entp,cidi.id_emp_phy,"+
			   "    item.fg_flupci  ,item.fg_majdi, item.fg_suspdi fg_suspdi,"+
			   "    item.des_di ,item.fg_ur, cidi.dt_di di_date, us.name doctor_name  ,dep.name dept_name,"+
			   "   item.eu_diopertp ,"+
			   "   doc.name id_eu_diproctp ,"+
			   "     item.des_di supply, "+
			   "   doc1.name  id_ditp , "+
			   "   doc2.name  id_disunjtp "+
			 "    from "+
			 "  ci_di_itm item"+
			 "  left outer join  ci_di cidi on item.id_cidi = cidi.id_cidi"+
			 "  left outer join bd_di_def def  on item.id_di = def.id_di"+
			 "  left outer join bd_udidoc doc  on doc.id_udidoc = cidi.id_eu_diproctp"+
			 "  left outer join bd_udidoc doc1  on doc1.id_udidoc = cidi.id_ditp"+
			 "  left outer join bd_udidoc doc2  on doc2.id_udidoc = cidi.id_disunjtp"+
			 "  left outer join sys_user   us  on us.id_user =  cidi.id_emp_phy"+
			 "  left outer join bd_dep  dep on   dep.id_dep = cidi.id_dep"+
			 "  where  cidi.id_ent =?"+
			 "  and   cidi.dt_di = (select max(dt_di) from ci_di  where id_ent = ?)";
	}
	
	
/*	select def.name di_name ,def.code di_code,
    item.fg_flupci fg_check , item.fg_suspdi fg_suspdi,
    item.des_di , cidi.dt_di, us.name doctor_name  ,dep.name dept_name
from
ci_di_itm item
left outer join  ci_di cidi on item.id_cidi = cidi.id_cidi
left outer join bd_di_def def  on item.id_di = def.id_di
left outer join bd_udidoc doc  on doc.id_udidoc = cidi.id_eu_diproctp
left outer join bd_udidoc doc1  on doc1.id_udidoc = cidi.id_ditp
left outer join bd_udidoc doc2  on doc2.id_udidoc = cidi.id_disunjtp
left outer join sys_user   us  on us.id_user =  cidi.id_emp_phy
left outer join bd_dep  dep on   dep.id_dep = cidi.id_dep
where  cidi.id_ent =''
and   cidi.dt_di = (select max(dt_di) from ci_di  where id_ent ='' )*/
}
