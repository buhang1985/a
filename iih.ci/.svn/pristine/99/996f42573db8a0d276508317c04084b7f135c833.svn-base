package iih.ci.ord.s.bp.specant;


import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.specanti.d.SpecantionApplyDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 特殊级抗菌药申请 编辑查询方法
 * @author gh
 *
 */
public class SpecAntiConsApplyQryBP {

	public SpecantionApplyDTO exec(String id_apspecanticons) throws DAException{
		if(CiOrdUtils.isEmpty(id_apspecanticons))return null;
		String sql = getSql(id_apspecanticons); 
		@SuppressWarnings("unchecked")
		ArrayList<SpecantionApplyDTO> result = (ArrayList<SpecantionApplyDTO>) new DAFacade()
				.execQuery(sql, new BeanListHandler(SpecantionApplyDTO.class));
		if(result!=null&&result.size()>0){
			return result.get(0);
		}
		return null;
	}
	
	private String getSql(String id_apspecanticons){
		StringBuffer sql  = new StringBuffer();
		sql.append(" select cons.Id_apspecanticons    id_apspecanticons,          ");
		sql.append(" 		cons.id_or                id_or,                      ");
		sql.append(" 		ci_order.id_srv           id_orsrv,                   ");
		sql.append(" 		ci_order.Id_en            id_ent,                     ");
		sql.append(" 		invites.id_emp            id_emp,                     ");
		sql.append(" 		invites.code_emp          code_emp,                   ");
		sql.append(" 		invites.name_emp          name_invited_emp,           ");
		sql.append(" 		invites.id_dep            id_dep,                     ");
		sql.append(" 		invites.code_dep          code_dep,                   ");
		sql.append(" 		invites.name_dep          name_dep,                   ");
		sql.append(" 		cons.dt_cons_app          dt_cons_app,                ");
		sql.append(" 		cons.Id_pat               id_pat,                     ");
		sql.append(" 		cons.Id_didef             id_didef,                   ");
		sql.append(" 		cons.Name_didef           name_didef,                 ");
		sql.append(" 		cons.Str_id_diitm         Str_id_diitm,               ");
		sql.append(" 		cons.Str_code_diitm       Str_code_diitm,             ");
		sql.append(" 		cons.Str_name_diitm       Str_name_diitm,             ");
		sql.append(" 		pi_pat.name               Name_pat,                   ");
		sql.append(" 		bd_dep.name               Name_dep_phy,               ");
		sql.append(" 		en_ent_ip.name_bed        Bed_no,                     ");
		sql.append(" 		en_ent_ip.code_amr_ip     Code_amr_ip,                ");
		sql.append(" 		cons.dt_cons_app          dt_cons_app,                ");
		sql.append(" 		cons.Fg_microbeinspection Fg_microbeinspection,       "); //微生物檢查 
		sql.append(" 		cons.Microbeinspection    Microbeinspection,          ");
		sql.append(" 		ci_or_srv.name            Type_apspe,                 ");
		sql.append("        ci_or_srv.fg_propc        Des_feasons,                ");//用药目的 
		sql.append(" 		cons.des_sympsign         Des_sympsign,               ");
		sql.append(" 		cons.Des_pps              Des_pps,                    ");
		sql.append(" 		bd_psndoc.name            Name_emp,                   ");
		sql.append(" 		bd_psndoc.id_emptitle     Id_emp_title,               ");
		sql.append(" 		emp_title.name            Name_emp_title,             ");
		sql.append(" 		cons.advice               advice,                     ");
		sql.append(" 		cons.Dt_cons              Dt_cons,                    ");
		sql.append(" 		cons.Dt_record            Dt_record,                  ");
		sql.append(" 		cons.Id_approve_meddep    Id_approve_meddep,          ");
		sql.append(" 		cons.Sd_approve_meddep    Sd_approve_meddep,          ");
		sql.append(" 		cons.Id_su_speccons       Id_su_speccons,             ");
		sql.append(" 		cons.Id_consmd            Id_consmd,                  ");
		sql.append(" 		cons.Sd_consmd            Sd_consmd,                   ");
		sql.append(" 		cons.Allerhyhistory      Allerhyhistory               ");
		sql.append(" 	from ci_ap_spec_anti_cons cons                            ");
		sql.append(" 	left join ci_order ci_order                               ");
		sql.append(" 	  on ci_order.id_or = cons.id_or                          ");
		sql.append(" 	left join ci_ap_spec_anti_invites invites                 ");
		sql.append(" 	  on invites.id_apspecanticons = cons.id_apspecanticons   ");
		sql.append(" 	left join ci_or_srv ci_or_srv                             ");
		sql.append(" 	  on ci_or_srv.id_or = ci_order.id_or                     ");
		sql.append(" 	left join pi_pat pi_pat                                   ");
		sql.append(" 	  on pi_pat.id_pat = cons.id_pat                          ");
		sql.append(" 	left join en_ent en_ent                                   ");
		sql.append(" 	  on ci_order.id_en = en_ent.id_ent                       ");
		sql.append(" 	left join en_ent_ip en_ent_ip                             ");
		sql.append(" 	  on ci_order.Id_en = en_ent_ip.Id_ent                    ");
		sql.append(" 	left join bd_dep bd_dep                                   ");
		sql.append(" 	  on bd_dep.id_dep = en_ent.id_dep_phy                    ");
		sql.append(" 	left join bd_psndoc bd_psndoc                             ");
		sql.append(" 	  on ci_order.id_emp_or = bd_psndoc.id_psndoc             ");
		sql.append(" 	left join bd_udidoc emp_title                             ");
		sql.append(" 	  on emp_title.id_udidoc = bd_psndoc.id_emptitle          ");
		sql.append(" left join bd_srv_drug drug on drug.id_srv=ci_or_srv.id_srv ");
		if(StringUtils.isNotBlank(id_apspecanticons)){
			sql.append(" 	where cons.id_apspecanticons = '"+id_apspecanticons+"'  and drug.sd_anti='3'   ");
		}
		return sql.toString();
	}
	
}
