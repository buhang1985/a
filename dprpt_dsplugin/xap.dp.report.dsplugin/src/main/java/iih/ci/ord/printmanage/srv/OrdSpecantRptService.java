package iih.ci.ord.printmanage.srv;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.printmanage.dto.SpecantionApplyDTO;

/**
 * 特殊级抗菌药 会诊记录服务
 * @author GH  =transDateFormat($.dt_cons_app,"yyyy-MM-dd HH:mm:ss","yyyy年MM月dd日HH时mm分")
 *
 */
public class OrdSpecantRptService {

	public List<SpecantionApplyDTO> exec(String ids) throws Exception{
		if(StringUtils.isNullOrEmpty(ids))return null;
		String sql = getSql(ids); 
		List<SpecantionApplyDTO> result = CiorderPrintUtils.GetQueryResulte(SpecantionApplyDTO.class, sql);
		if(result!=null&&result.size()>0){
			return result;
		}
		return null;
	}
	private String getSql(String ids){
		StringBuffer sql  = new StringBuffer();
		sql.append(" select cons.id_apspecanticons    id_apspecanticons,          ");
		sql.append(" 		invites.name_emp          name_invited_emp,           ");
		sql.append(" 		invites.name_dep          name_dep,                   ");
		sql.append(" 		cons.dt_cons_app          dt_cons_app,                ");
		sql.append(" 		ci_di_itm.id_didef_name       str_name_diitm,             ");
		sql.append(" 		pi_pat.name               name_pat,                   ");
		sql.append(" 		bd_dep.name               name_dep_phy,               ");
		sql.append(" 		en_ent_ip.name_bed        bed_no,                     ");
		sql.append(" 		en_ent_ip.code_amr_ip     code_amr_ip,                ");
		sql.append(" 		cons.dt_cons_app          dt_cons_app,                ");
		sql.append(" 		cons.fg_microbeinspection fg_microbeinspection,       "); //微生物檢查 
		sql.append(" 		cons.microbeinspection    microbeinspection,          ");
		sql.append(" 		ci_or_srv.name            type_apspe,                 ");
		sql.append("        ci_or_srv.fg_propc        des_feasons,                ");//用药目的 
		sql.append(" 		cons.des_sympsign         des_sympsign,               ");
		sql.append(" 		cons.des_pps              des_pps,                    ");
		sql.append(" 		bd_psndoc.name            name_emp,                   ");
		sql.append(" 		bd_psndoc.id_emptitle     id_emp_title,               ");
		sql.append(" 		emp_title.name            name_emp_title,             ");
		sql.append(" 		cons.advice               advice,                     ");
		sql.append(" 		cons.dt_cons              dt_cons,                    ");
		sql.append(" 		cons.dt_record            dt_record,                  ");
		sql.append(" 		cons.id_approve_meddep    id_approve_meddep,          ");
		sql.append(" 		cons.sd_approve_meddep    sd_approve_meddep,          ");
		sql.append(" 		cons.id_su_speccons       id_su_speccons,             ");
		sql.append(" 		cons.id_consmd            id_consmd,                  ");
		sql.append(" 		cons.sd_consmd            sd_consmd                   ");
		sql.append(" 	from ci_ap_spec_anti_cons cons                            ");
		sql.append(" 	left join ci_order ci_order                               ");
		sql.append(" 	  on ci_order.id_or = cons.id_or                          ");
		sql.append(" 	left join ci_ap_spec_anti_invites invites                 ");
		sql.append(" 	  on invites.id_apspecanticons = cons.id_apspecanticons   ");
		sql.append(" 	left join ci_or_srv ci_or_srv                             ");
		sql.append(" 	  on ci_or_srv.id_or = ci_order.id_or                     ");
		sql.append(" 	left join pi_pat pi_pat                                   ");
		sql.append(" 	  on pi_pat.id_pat = cons.id_pat                          ");
		 // BUG：0140018  诊断需从住院诊断里去
		sql.append(" 	left join ci_di ci_di                                     ");
		sql.append(" 	  on ci_di.id_en = ci_order.id_en                         ");
		sql.append(" 	left join ci_di_itm ci_di_itm                             ");
		sql.append(" 	  on ci_di_itm.id_di = ci_di.id_di                        ");
		sql.append(" 	left join en_ent en_ent                                   ");
		sql.append(" 	  on ci_order.id_en = en_ent.id_ent                       ");
		sql.append(" 	left join en_ent_ip en_ent_ip                             ");
		sql.append(" 	  on ci_order.id_en = en_ent_ip.id_ent                    ");
		sql.append(" 	left join bd_dep bd_dep                                   ");
		sql.append(" 	  on bd_dep.id_dep = en_ent.id_dep_phy                    ");
		sql.append(" 	left join bd_psndoc bd_psndoc                             ");
		sql.append(" 	  on ci_order.id_emp_or = bd_psndoc.id_psndoc             ");
		sql.append(" 	left join bd_udidoc emp_title                             ");
		sql.append(" 	  on emp_title.id_udidoc = bd_psndoc.id_emptitle          ");
		sql.append("    left join ci_or_srv_mm mm on mm.id_orsrv=ci_or_srv.id_orsrv ");
		
		if(!StringUtils.isNullOrEmpty(ids)){
			sql.append(" 	where cons.id_apspecanticons = "+ids+"  and mm.sd_anti='3' ");
		}
		return sql.toString();
	}
}
