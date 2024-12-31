package iih.ci.diag.dto.s.bp;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiDiagQueryService implements ITransQry {
	
    public String id;
    
    public CiDiagQueryService(String id){
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
		return "  select f.name as Di_name,f.code as Di_code, "+
				"  case ci.eu_diproctp  "+
				"  when '0' then '签署' "+
				"  when '1' then '初步诊断' "+
				"  when '2' then '入院诊断' "+
				"  when '3' then '出院诊断' "+
				"  when '4' then '死亡诊断' "+
				"  end Di_type,ci.id_grp as Di_grp, "+
				"  it.fg_majdi as Fg_majdi, it.fg_suspdi as Fg_check ,"+
				"   ci.eu_diproctp as disunjtp, ci.des_di as di_des "+
				"     from ci_di ci,ci_di_itm it,bd_di_def f "+
				"     where ci.id_cidi = it.id_cidi"+
				"       and  it.id_di = f.id_di and ci.id_en =?";
	}
}
