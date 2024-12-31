package iih.pi.concern.concern.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class PiRecommendIndQry implements ITransQry {
    String id_pat;
	public PiRecommendIndQry(String id_pat){
		this.id_pat=id_pat;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {

		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(id_pat);
		
		return rtnParam;
		 
	}
	
	public String getQrySQLStr() {
		return getQrySQLStr_();
	}
 
	private String getQrySQLStr_(){
		return "select s.id_srv,u.code code_srv,u.name name_srv from ( "
				+ "select di.id_didef_dis,max(di.dt_diag) "
				+ "from en_ent_di di inner join en_ent ent "
				+ "on di.id_ent = ent.id_ent and ent.id_pat = ? "
				+ "group by di.id_didef_dis "
				+ ") r "
				+ "inner join bd_di_ind s on r.id_didef_dis = s.id_didef "
				+ "left outer join bd_srv u on s.id_srv = u.id_srv";
	}
}
