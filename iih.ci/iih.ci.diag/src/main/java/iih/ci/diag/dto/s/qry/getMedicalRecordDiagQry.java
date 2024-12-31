package iih.ci.diag.dto.s.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 病案首页显示诊断
 * @author li_zheng
 *
 */
public class getMedicalRecordDiagQry implements ITransQry {

	private String _id_ent;
	
	public getMedicalRecordDiagQry(String id_ent){
		this._id_ent = id_ent;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		 sqlparam.addParam(this._id_ent);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}
  
	 private String getSql(){
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
				 "   and cidi.sd_eu_diproctp in ('3','4','5')";
	 }
}
