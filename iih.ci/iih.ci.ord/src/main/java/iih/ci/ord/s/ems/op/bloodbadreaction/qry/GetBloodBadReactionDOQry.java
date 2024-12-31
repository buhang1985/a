package iih.ci.ord.s.ems.op.bloodbadreaction.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBloodBadReactionDOQry implements ITransQry{
	private String idor;
	public GetBloodBadReactionDOQry(String idor) {
		this.idor = idor;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sql = new StringBuffer();
		// 患者姓名、性别、年龄、科别、门诊号。...
		sql.append(" select c.id_pat,")
		.append(" c.id_dep_or as id_dep,")
		.append(" p.id_sex,")
		.append(" p.barcode_chis as op_no,")
		.append(" p.dt_birth,")
		.append(" c.id_or_rel as pre_id_or,")
		.append(" dep.name as name_dep,")
		.append(" dep.code as code_dep,")
		.append(" p.name as name_pat,")
		.append(" p.code as code_pat,")
		.append(" u1.code as code_sex,")
		.append(" u1.name as name_sex,")
		.append(" bt.id_bloodtype_ap as Id_bloodtype_sipply,")
		.append(" bt.sd_bloodtype_ap as Sd_bloodtype_sipply,")
		.append(" u3.name as Name_bloodtype_sipply,")
		.append(" bt.id_rhd_ap as id_rh,")
		.append(" bt.sd_rhd_ap as sd_rh,")
		.append(" u4.name as Name_rh,")
		.append(" bt.pregnant_num as Pregnant,")
		.append(" bt.parturition_cnt as  Birth,")
		.append(" def.id_didef as id_disease_diagnosis,")
		.append(" def.code as sd_disease_diagnosis,")
		.append(" def.name as Name_disease_diagnosis,")
		.append(" cbt.id_srv as Id_bloodtype_tran,")
		.append(" srv.code as Sd_bloodtype_tran,")
		.append(" srv.name as Name_bloodtype_tran,")
		.append(" u2.id_udidoc as Id_bloodtype_pat,")
		.append(" u2.code as Sd_bloodtype_pat,")
		.append(" u2.name as Name_bloodtype_pat,case when bt.id_his_bt = '"+ICiDictCodeConst.ID_CI_BT_WSXS+"' then 'N' else 'Y' end as fg_blood_his")
		.append(" from ci_order c")
		.append(" left outer join pi_pat p on c.id_pat = p.id_pat")
		.append(" left outer join bd_dep dep on c.id_dep_or = dep.id_dep")
		.append(" left outer join bd_udidoc u1 on u1.id_udidoc = p.id_sex")
		.append(" left outer join ci_order cbt on cbt.id_or=c.id_or_rel")
		.append(" left outer join ci_ap_bt bt on cbt.id_or = bt.id_or")
		.append(" left outer join bd_udidoc u3 on bt.id_bloodtype_ap = u3.id_udidoc")
		.append(" left outer join bd_udidoc u4 on bt.id_rhd_ap = u4.id_udidoc")
		.append(" left outer join ci_di_itm diitm on bt.id_diitm=diitm.id_diitm")
		.append(" left outer join bd_di_def def on diitm.id_didef=def.id_didef")
		.append(" left outer join bd_srv srv on cbt.id_srv=srv.id_srv")
		.append(" left outer join ci_ap_bt_viewitm itm on bt.id_apbt=itm.id_apbt and itm.sortno='1' ")
		.append(" left outer join bd_udidoc u2 on itm.val_rstrptla=u2.name")
		.append(" where c.id_or ='" + this.idor + "'");
		return sql.toString();
	}

}
