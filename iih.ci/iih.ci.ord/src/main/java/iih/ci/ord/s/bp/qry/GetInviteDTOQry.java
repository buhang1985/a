package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetInviteDTOQry implements ITransQry {
	private String _id_dep;
	private String _cons_su;

	public GetInviteDTOQry(String id_dep,String str){
		_id_dep=id_dep;
		_cons_su=str;
	}
	

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(_id_dep);
		rtnParam.addParam(_cons_su);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {

		String wherestr="select distinct "+
				"       t2.id_apcons,\n" + 
				"       t112.name name_dep_or,\n"+
				"       t2.fg_urgent,\n" + 
				"       t2.dt_plan,\n" + 
				"       t2.sd_su_cons,\n" + 
				"       t3.dt_entry,\n" + 
				"       t3.id_en,\n" + 
				"       PAT.code code_pat,\n" + 
				"       t4.name_pat,\n" + 
				"       t4.code    code_en,\n" + 
				"       t5.name          name_su_cons,\n" + 
			/*	"       t6.name          name_dep_or,\n" + */
                "       t8.NAME as Emp_name," + //应答医生
				"       t12.name_bed       pat_bedno,\n" + 
				"       t13.fg_emptitlelimit,\n" +
				"       t13.id_emptitle,\n" +
				"       t13.sd_emptitle,\n" +
				"       t13.fg_inorg\n" + 
				"  from ci_invite_cons t1\n" + 
				"  left outer join ci_ap_cons t2\n" + 
				"    on t1.id_apcons = t2.id_apcons\n" + 
				"  left outer join ci_order t3\n" + 
				"    on t2.id_or = t3.id_or\n" + 
				"  left outer join en_ent t4\n" + 
				"    on t3.id_en = t4.id_ent\n" + 
				"  left outer join pi_pat PAT\n" + 
				"    on PAT.id_pat = t4.id_pat\n" + 
				"  left outer join bd_udidoc t5\n" + 
				"    on t2.id_su_cons = t5.id_udidoc\n" + 
				"  left outer join bd_dep t6\n" + 
				"    on t3.id_dep_or = t6.id_dep\n" + 
				"  left join bd_dep t112 on t3.id_dep_or=t112.id_dep\n "+
				"  left outer join en_ent_ip t11\n" + 
				"    on t3.id_en = t11.id_ent\n" + 
				"  left outer join en_ent_bed t12\n" + 
				"    on t11.id_bed = t12.id_bed\n" + 
				"  left outer join bd_srv_cons t13\n" + 
				"    on t3.id_srv = t13.id_srv\n" + 
			    " left outer join bd_psndoc t8 " +
			    " on t8.ID_PSNDOC = t1.ID_EMP"+
				" where \n" + 
				" t3.sd_su_or in ('"+ICiDictCodeConst.SD_SU_SIGN+"','"+ICiDictCodeConst.SD_SU_CHECKTHROUGH+"','"+ICiDictCodeConst.SD_SU_FINISH+"')\n" + 
				"   and t3.ds = '0'\n"+
				" and t3.fg_canc='N' AND t3.fg_sign='Y'\n"

				;  
		if(!_cons_su.equals("")){
			wherestr+=_cons_su;
		} 
		wherestr+=" order by t3.dt_entry desc";
		
		return wherestr;
	}

}
