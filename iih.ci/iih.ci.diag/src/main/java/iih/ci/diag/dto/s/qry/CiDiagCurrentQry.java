package iih.ci.diag.dto.s.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiDiagCurrentQry implements ITransQry {
	
    public String id;
    public CiDiagCurrentQry(String id){
    	this.id = id;
    }
    
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(id);
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
		
		return "  select def.name di_name ,def.code di_code, cidi.id_ent, item.id_di,"+
		   "  cidi.id_pat ,cidi.code_entp,cidi.id_emp_phy,"+
		   "    item.fg_flupci, item.fg_majdi,item.fg_suspdi fg_suspdi,"+
		   "    item.des_di , cidi.dt_di di_date, us.name doctor_name  ,dep.name dept_name,"+
		   "   item.eu_diopertp ,"+
		   "   item.des_di supply, "+
		   "   doc.name id_eu_diproctp ,"+
		   "   doc1.name  id_ditp, "+
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
	/*	return "select f.name as Di_name,f.code as Di_code, "+
				"  case ci.eu_diproctp  "+
				"  when '0' then '签署' "+
				"  when '1' then '初步诊断' "+
				"  when '2' then '入院诊断' "+
				"  when '3' then '出院诊断' "+
				"  when '4' then '死亡诊断' "+
				"  end Di_type,ci.id_grp as Di_grp, "+
				// "ci.eu_diproctp as Di_type,"
				 "ci.id_grp as Di_grp,   it.fg_majdi as Fg_majdi, it.fg_suspdi as Fg_check"+
                "  from ci_di ci,ci_di_itm it,bd_di_def f where ci.id_cidi = it.id_cidi and  it.id_di = f.id_di and ci.id_en =?"+
               "and ci.sv  =  (select max(sv) from ci_di where id_en ="
               + "?)";*/
	}
}
