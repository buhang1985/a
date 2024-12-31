package iih.mr.mrm;

import java.util.List;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class MrScoreResultService {
	
	@SuppressWarnings("unchecked")
	public  List<MrScoreResultDTO>  getMrScoreResult(String dt_begin,String dt_end,String id_dep,String name_emp_nur,
			String name_zy_doc,String name_pat,String code_amr_ip) throws BizException{
		
		DAFacade daf = new DAFacade();
		StringBuilder sql = new StringBuilder();
		sql.append("select pat.code_amr_ip, pat.name_pat as name ,dep.name as leave_hospital_dep, ");
		sql.append("pat.name_emp_nur as charge_nurse ,pat.name_zy_doc as resident ,amr.score_terminal_qa as total_score, ");
		sql.append("other.name_qom_record as name_qom_record,other.name_qcp_doc as rater,other.qc_date as score_time,amr.id_enhr as id_enhr ");
		sql.append("from ci_mr_fp_pat pat ");
		sql.append("left join ci_mr_fp_other other ");
		sql.append("on pat.id_ent=other.id_ent ");
		sql.append("left join ci_amr amr ");
		sql.append("on amr.id_ent=pat.id_ent ");
		sql.append("left join bd_dep dep ");
		sql.append("on dep.id_dep=pat.id_dep_phydisc ");
		sql.append("left join en_ent ent ");
		sql.append("on pat.id_ent=ent.id_ent ");
		sql.append("where amr.fg_complete='Y'and ent.fg_ip='N' ");
		
		SqlParam sq=new SqlParam();
		if(!StringUtil.isEmptyWithTrim(dt_begin) && !StringUtil.isEmptyWithTrim(dt_end)){
			sql.append(" and ent.dt_acpt>=? ");
			sql.append(" and ent.dt_end<=? ");
			sq.addParam(dt_begin);sq.addParam(dt_end);
		}else if(!StringUtil.isEmptyWithTrim(dt_begin)){
			sql.append(" and ent.dt_acpt>=? ");
			sq.addParam(dt_begin);
		}else if(!StringUtil.isEmptyWithTrim(dt_end)){
			sql.append(" and ent.dt_end<=? ");
			sq.addParam(dt_end);
		}	
		if(!StringUtil.isEmptyWithTrim(id_dep)){
			sql.append(" and dep.id_dep=? ");
			sq.addParam(id_dep);
		}
		if(!StringUtil.isEmptyWithTrim(name_emp_nur)){
			sql.append(" and pat.id_emp_nur =? ");
			sq.addParam(name_emp_nur);
		}
		if(!StringUtil.isEmptyWithTrim(name_zy_doc)){
			sql.append(" and pat.id_zy_doc =? ");
			sq.addParam(name_zy_doc);
		}
		if(!StringUtil.isEmptyWithTrim(name_pat)){
			sql.append(" and pat.name_pat like'%?%' ");
			sq.addParam(name_pat);
		}
		if(!StringUtil.isEmptyWithTrim(code_amr_ip)){
			sql.append(" and pat.code_amr_ip like '%?%' ");
			sq.addParam(code_amr_ip);
		}	
		sql.append(" order by ent.dt_end ");
		List<MrScoreResultDTO> list = (List<MrScoreResultDTO>) daf.execQuery(sql.toString(),sq,new BeanListHandler(MrScoreResultDTO.class));
		if(list!=null && list.size()>0)
			getReturnNumber(list);
		return list;
	}
	
	public void getReturnNumber(List<MrScoreResultDTO> list) throws BizException{
		DAFacade daf = new DAFacade();	
		for(MrScoreResultDTO dto:list){
			StringBuilder sql = new StringBuilder();
			sql.append("select count(1) from ci_mrm_op op ");
			sql.append("left join ci_amr amr ");
			sql.append("on op.id_amr=amr.id_enhr ");
			sql.append("where op.sd_optp='03' and amr.id_enhr='"+dto.getId_enhr()+"' ");
			int count=(int)daf.execQuery(sql.toString(),new ColumnHandler());
			dto.setReturn_modify_count(String.valueOf(count));
		}
	}
}
