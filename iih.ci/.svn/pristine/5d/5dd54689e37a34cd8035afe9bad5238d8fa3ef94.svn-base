package iih.ci.mrqc.mrterminalqc.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.itmdto.d.ItmDTO;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import iih.ci.mrqc.qarecorddto.d.QaRecordDTO;
import iih.ci.mrqc.qared.d.QaRecordDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.pub.EnvContextUtil;

public class MrTerminalQcQryBP {
	/**
	 * 获取终末评分项目列表
	 * @param sd_qctype
	 * @return
	 * @throws BizException
	 */
	public ItmDTO[] getMrQcTerminalScoreItmList(QaPatListDTO qaPatDto) throws BizException {
		// TODO Auto-generated method stub
		DAFacade daf = new DAFacade();  	
    	StringBuilder sql = new StringBuilder();
				sql.append("select ci_qa_itm_fst.id_fst as id_fst_itm,");
				sql.append("       ci_qa_itm_fst.name as name_fst_itm,");
				sql.append("	   ci_qa_itm.req as req,");
				sql.append("	   ci_qa_itm.Id_qa_drp_scr_tp,");
				sql.append("	   ci_qa_itm.sd_qa_drp_scr_tp,");
				sql.append("	   ci_qa_itm.id_qa_itm as id_qa_itm,");
				sql.append("       ci_qa_itm.fg_serious as fg_serious,");
				sql.append("       ci_qa_itm.deduct_des as deduct_des,");
				sql.append("       ci_qa_itm.Once_drp_scr as Once_drp_scr,");
				sql.append("       ci_qa_itm.fg_repair as fg_repair,");
				sql.append("       ci_qa_itm.sortno as sortno,"); 
				if(qaPatDto.getId_qa_flt() == null || "".equals(qaPatDto.getId_qa_flt())){
					sql.append("       (select count(*) from ci_qa_divide  ci_qa_divide where ci_qa_divide.id_qa_itm=ci_qa_itm.id_qa_itm and ci_qa_divide.id_ent='"+qaPatDto.getId_ent()+"' and ci_qa_divide.id_sbmt_user='"+Context.get().getUserId()+"' and ci_qa_divide.id_qa is null) as deduct_scr_times,");
				}else{
					sql.append("       (select  ci_qa_divide.deduct_scr_times  from ci_qa_divide  ci_qa_divide where ci_qa_divide.id_qa_itm=ci_qa_itm.id_qa_itm and ci_qa_divide.id_ent='"+qaPatDto.getId_ent()+"' and ci_qa_divide.id_sbmt_user='"+Context.get().getUserId()+"' and ci_qa_divide.id_qa ='"+ qaPatDto.getId_qa_flt() +"') as deduct_scr_times,");
					sql.append("       (select  ci_qa_divide.drp_des  from ci_qa_divide  ci_qa_divide where ci_qa_divide.id_qa_itm=ci_qa_itm.id_qa_itm and ci_qa_divide.id_ent='"+qaPatDto.getId_ent()+"' and ci_qa_divide.id_sbmt_user='"+Context.get().getUserId()+"' and ci_qa_divide.id_qa ='"+ qaPatDto.getId_qa_flt() +"') as drp_des,");
				}
				sql.append("       ci_qa_itm.fg_auto_qa as fg_auto_qa"); 
				sql.append("    from ci_qa_itm ci_qa_itm"); 
				sql.append("    inner join ci_qa_itm_fst ci_qa_itm_fst"); 
				sql.append("       on ci_qa_itm_fst.id_fst = ci_qa_itm.id_fst");
				sql.append("    where ci_qa_itm.sd_qa like '%"+ICiMrDictCodeConst.SD_EXEC_END+"%'"); 
				sql.append("    AND ci_qa_itm.fg_active = 'Y'"); 
				sql.append("    AND ci_qa_itm_fst.id_entp = '"+ IBdFcDictCodeConst.ID_CODE_ENTP_IP+"'");
				sql.append("       order by ci_qa_itm.sortno ");
				String sqlStr=sql.toString();
       @SuppressWarnings("unchecked")
       List<ItmDTO> listMr = (List<ItmDTO>) daf.execQuery(sqlStr, new BeanListHandler(ItmDTO.class));
       return (ItmDTO[]) listMr.toArray(new ItmDTO[0]);
	}
	/**
     * 获取患者终末待整改缺陷列表
     * @param id_ent
     * @param cqf_submit_user
     * @return
     * @throws BizException
     */
	public QaFltDTO[] getMrTerminalQcNeedDefectFltList(String id_ent, String cqf_submit_user) throws BizException {
		DAFacade daf = new DAFacade();  	
		StringBuilder sql = new StringBuilder();
				sql.append("SELECT ci_qa_flt.id_flt_sta,");
				sql.append("       ci_qa_flt.sd_flt_sta,");
				sql.append("	   ci_qa_itm_fst.id_fst          as id_fst,");
				sql.append("       ci_qa_itm_fst.name            as fst_name,");
				sql.append("       ci_qa_itm_fst.score           as score_fstmax,");
				sql.append("       bu.name           flt_sta_name,"); 
				sql.append("       ci_mr.name           id_mr_name,"); 
				sql.append("       ci_qa_flt.id_mr           id_mr,"); 
				sql.append("       ci_qa_itm.id_qa_itm,"); 
				sql.append("       ci_qa_itm.once_drp_scr  once_drp_scr,"); 
				sql.append("       ci_qa_itm.id_qa_drp_scr_tp   id_qa_drp_scr_tp,"); 
				sql.append("       ci_qa_itm.sd_qa_drp_scr_tp   sd_qa_drp_scr_tp,"); 
				sql.append("       ci_qa_itm.max_drp_scr   max_drp_scr,");
				sql.append("       ci_qa_itm.req           res,"); 
				sql.append("       ci_qa_itm.deduct_des,"); 
				sql.append("       ci_qa_itm.fg_repair as fg_repair,");
				sql.append("       ci_qa_itm.FG_SERIOUS as fg_serious,");
				sql.append("       ci_qa_flt.deduct_scr_times  deduct_scr_times,"); 
				sql.append("       ci_qa_flt.id_qa_flt,"); 
				sql.append("       ci_qa_flt.dt_sbmt,"); 
				sql.append("       ci_qa_flt.real_score   real_score,");
				sql.append("       ci_qa_flt.id_sbmt_user,"); 
				sql.append("       su.name           sbmt_user_name,"); 
				sql.append("       ci_qa_flt.rfm_des       rfm_req,"); 
				sql.append("       ci_qa_flt.id_rfm_user as id_treat_doctor,"); 
				sql.append("       su2.name           treat_doctor_name,"); 
				sql.append("       ci_qa_flt.Id_rfm_dept       id_dep_pat,"); 
				sql.append("       bd_dep.name       dep_pat,"); 
				sql.append("       ci_qa_flt.id_qa_flt     id_qaflt"); 
				sql.append("  FROM ci_qa_flt ci_qa_flt"); 
				sql.append("  LEFT JOIN ci_qa_itm ci_qa_itm"); 
				sql.append("    ON ci_qa_flt.id_qa_itm = ci_qa_itm.id_qa_itm"); 
				sql.append("  left JOIN ci_mr ci_mr"); 
				sql.append("    ON ci_qa_flt.id_mr = ci_mr.id_mr"); 
				sql.append("  LEFT JOIN sys_user su"); 
				sql.append("    ON ci_qa_flt.id_sbmt_user = su.id_user"); 
				sql.append("    LEFT JOIN sys_user su2"); 
				sql.append("    ON ci_qa_flt.id_rfm_user=su2.id_user"); 
				sql.append("    LEFT JOIN bd_dep bd_dep"); 
				sql.append("    ON bd_dep.id_dep=ci_qa_flt.Id_rfm_dept"); 
				sql.append("  LEFT JOIN bd_udidoc bu"); 
				sql.append("    ON bu.id_udidoc = ci_qa_flt.id_flt_sta");
				sql.append("  left join ci_qa_itm_fst ci_qa_itm_fst");
				sql.append("    on ci_qa_itm_fst.id_fst = ci_qa_itm.id_fst");
				sql.append(" WHERE ci_qa_flt.id_flt_sta = '"+ICiMrDictCodeConst.ID_REFORM+"'"); 
				sql.append("   and ci_qa_flt.id_revision = '~'"); 
				sql.append("   and ((ci_qa_flt.sd_qa_ty = '"+ICiMrDictCodeConst.SD_EXEC_END+"' and ci_qa_flt.id_sbmt_user='"+ cqf_submit_user + "') or ci_qa_flt.sd_qa_ty = '"+ICiMrDictCodeConst.SD_EXEC_AUTOMATIC+"')"); 
				sql.append("   AND ci_qa_flt.id_ent = '"+ id_ent + "'"); 
				sql.append("   AND ci_qa_flt.ds = '0'"); 
				//sql.append("   and ci_qa_flt.id_sbmt_user='"+ cqf_submit_user + "'"); 
				sql.append("   order by ci_qa_flt.ID_QA_FLT desc"); 
				String sqlStr=sql.toString();
	   @SuppressWarnings("unchecked")
	   List<QaFltDTO> listMr = (List<QaFltDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaFltDTO.class));
	   for(int i = 0 ; i < listMr.size() ; i++){
		   if(null == listMr.get(i).getId_mr_name()){
			   listMr.get(i).setId_mr_name(listMr.get(i).getId_mr());
		   }
	   }
	   return (QaFltDTO[]) listMr.toArray(new QaFltDTO[0]);
	}
	/**
	 * 根据通知获取已有的缺陷
	 * @param id_revision
	 * @return
	 * @throws BizException
	 */
	public QaFltDTO[] getMrTerminalQcDefectFltListByIdRevision(String id_revision) throws BizException {
		DAFacade daf = new DAFacade();  	
		StringBuilder sql = new StringBuilder();
				sql.append("SELECT ci_qa_flt.id_flt_sta,");
				sql.append("       ci_qa_flt.sd_flt_sta,");
				sql.append("	   ci_qa_itm_fst.id_fst          as id_fst,");
				sql.append("       ci_qa_itm_fst.name            as fst_name,");
				sql.append("       ci_qa_itm_fst.score           as score_fstmax,");
				sql.append("       bu.name           flt_sta_name,"); 
				sql.append("       ci_mr.name           id_mr_name,"); 
				sql.append("       ci_qa_itm.id_qa_itm,"); 
				sql.append("       ci_qa_itm.once_drp_scr  once_drp_scr,"); 
				sql.append("       ci_qa_itm.id_qa_drp_scr_tp   id_qa_drp_scr_tp,"); 
				sql.append("       ci_qa_itm.sd_qa_drp_scr_tp   sd_qa_drp_scr_tp,"); 
				sql.append("       ci_qa_itm.max_drp_scr   max_drp_scr,");
				sql.append("       ci_qa_itm.req           res,"); 
				sql.append("       ci_qa_itm.deduct_des,"); 
				sql.append("       ci_qa_itm.fg_repair as fg_repair,");
				sql.append("       ci_qa_itm.FG_SERIOUS as fg_serious,");
				sql.append("       ci_qa_flt.deduct_scr_times  deduct_scr_times,"); 
				sql.append("       ci_qa_flt.id_qa_flt,"); 
				sql.append("       ci_qa_flt.dt_sbmt,"); 
				sql.append("       ci_qa_flt.id_sbmt_user,");
				sql.append("       ci_qa_flt.real_score,");
				sql.append("       su.name           sbmt_user_name,"); 
				sql.append("       ci_qa_flt.rfm_des       rfm_req,"); 
				sql.append("       ci_qa_flt.id_rfm_user as id_treat_doctor,"); 
				sql.append("       su2.name           treat_doctor_name,"); 
				sql.append("       ci_qa_flt.Id_rfm_dept       id_dep_pat,"); 
				sql.append("       bd_dep.name       dep_pat,"); 
				sql.append("       ci_qa_flt.id_revision       id_revision,"); 
				sql.append("       ci_qa_flt.id_qa_flt     id_qaflt"); 
				sql.append("  FROM ci_qa_flt ci_qa_flt"); 
				sql.append("  LEFT JOIN ci_qa_itm ci_qa_itm"); 
				sql.append("    ON ci_qa_flt.id_qa_itm = ci_qa_itm.id_qa_itm"); 
				sql.append("  left JOIN ci_mr ci_mr"); 
				sql.append("    ON ci_qa_flt.id_mr = ci_mr.id_mr"); 
				sql.append("  LEFT JOIN sys_user su"); 
				sql.append("    ON ci_qa_flt.id_sbmt_user = su.id_user"); 
				sql.append("    LEFT JOIN sys_user su2"); 
				sql.append("    ON ci_qa_flt.id_rfm_user=su2.id_user"); 
				sql.append("    LEFT JOIN bd_dep bd_dep"); 
				sql.append("    ON bd_dep.id_dep=ci_qa_flt.Id_rfm_dept"); 
				sql.append("  LEFT JOIN bd_udidoc bu"); 
				sql.append("    ON bu.id_udidoc = ci_qa_flt.id_flt_sta");
				sql.append("  left join ci_qa_itm_fst ci_qa_itm_fst");
				sql.append("    on ci_qa_itm_fst.id_fst = ci_qa_itm.id_fst");
				sql.append(" WHERE "); 
				sql.append("    ci_qa_flt.id_revision = '"+id_revision+"'"); 
				sql.append("   and ci_qa_flt.sd_qa_ty in ('"+ICiMrDictCodeConst.SD_EXEC_END+"','"+ICiMrDictCodeConst.SD_EXEC_AUTOMATIC+"')"); 
				sql.append("   AND ci_qa_flt.ds = '0'");  
				sql.append("   order by ci_qa_flt.ID_QA_FLT desc"); 
				String sqlStr=sql.toString();
	   @SuppressWarnings("unchecked")
	   List<QaFltDTO> listMr = (List<QaFltDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaFltDTO.class));
	   for(int i = 0 ; i < listMr.size() ; i++){
		   if(null == listMr.get(i).getId_mr_name()){
			   listMr.get(i).setId_mr_name(listMr.get(i).getId_mr());
		   }
	   }
	   return (QaFltDTO[]) listMr.toArray(new QaFltDTO[0]);
	}
    /**
     * 获取终末质控记录
     * @param qaPatListDto
     * @return
     * @throws BizException
     */
	public QaRecordDTO[] getMrTerminalQcQryRecordList(QaPatListDTO qaPatListDto) throws BizException {
		DAFacade daf = new DAFacade();  	
    	StringBuilder sql = new StringBuilder();
			sql.append("       select ci_qa_record.dt_plan as dt_plan,\n" );
			sql.append("       ci_amr.code_amr_ip as code_hospital,\n" );
			sql.append("       ee.name_pat as name_pat,\n" );
			sql.append("       eed.name_didef_dis as name_di,\n");
			sql.append("       cqrn.id_revision as id_revision,\n");
			sql.append("       cqrn.id_status as id_status,\n" );
			sql.append("       cqrn.des as res,\n"); 
			sql.append("       bu.name as status_name,\n" );
			sql.append("       (select count(*) from ci_qa_flt cqt where cqt.id_revision = cqrn.id_revision ) as deduct_times,\n" );
			sql.append("       ci_qa_record.id_exec_user as id_exec_user,\n" );
			sql.append("       su.name as exec_user_name,\n");
			sql.append("       ci_amr.id_pat as id_pat,\n");
			sql.append("       ci_amr.id_ent as id_ent,\n");
			sql.append("       ci_amr.code_entp as code_entp,\n");
			sql.append("       ci_qa_record.id_exec_dept as id_exec_dept,\n" );
			sql.append("       bd.name as exec_dept_name\n" ); 
			sql.append("       from ci_qa_record ci_qa_record\n");
			sql.append("       inner join ci_amr ci_amr\n" );
			sql.append("       on ci_qa_record.id_ent=ci_amr.id_ent\n");
			sql.append("       left join ci_qa_revision_notice cqrn\n" );
			sql.append(" on ci_qa_record.id_qa=cqrn.id_qa_record   ");
			//sql.append("       on ci_qa_record.id_revision=cqrn.id_revision\n");
			sql.append("       left join en_ent ee\n" );
			sql.append("       on ci_qa_record.id_ent = ee.id_ent\n" );
			sql.append("       left join en_ent_di eed\n" );
			sql.append("       on ci_qa_record.id_ent = eed.id_ent\n" );
			sql.append("       AND eed.fg_maj = 'Y'\n" );
			sql.append("       left join sys_user su\n" );
			sql.append("       on su.id_user=ci_qa_record.id_exec_user\n" );
			sql.append("       left join bd_dep bd\n" );
			sql.append("       on bd.id_dep=ci_qa_record.id_exec_dept\n" );
			sql.append("       left join bd_udidoc bu\n"  );
			sql.append("       on bu.id_udidoc = cqrn.id_status" );
			sql.append("        where ci_qa_record.id_ent= '"+qaPatListDto.getId_ent()+"' and "+EnvContextUtil.processEnvContext("",new QaRecordDO(),false)+" and  ee.code_entp='10'   and ci_qa_record.sd_qa_ty = '"+ICiMrDictCodeConst.SD_EXEC_END+"'  and ci_qa_record.id_revision!='~'  ORDER BY ci_qa_record.dt_plan DESC");
				String sqlStr=sql.toString();
       @SuppressWarnings("unchecked")
       List<QaRecordDTO> listMr = (List<QaRecordDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaRecordDTO.class));
       return (QaRecordDTO[]) listMr.toArray(new QaRecordDTO[0]);
	}
	/**
	 * 获取终末质控项目列表
	 * @param sd_qctype
	 * @return
	 * @throws BizException
	 */
	public ItmDTO[] getMrQcTerminalItmList(QaPatListDTO qaPatDto) throws BizException {
		DAFacade daf = new DAFacade();  	
    	StringBuilder sql = new StringBuilder();
				sql.append("select ci_qa_itm_fst.id_fst as id_fst_itm,");
				sql.append("       ci_qa_itm_fst.name as name_fst_itm,");
				sql.append("	   ci_qa_itm.req as req,");
				sql.append("	   ci_qa_itm.Id_qa_drp_scr_tp,");
				sql.append("	   ci_qa_itm.sd_qa_drp_scr_tp,");
				sql.append("	   ci_qa_itm.id_qa_itm as id_qa_itm,");
				sql.append("       ci_qa_itm.fg_serious as fg_serious,");
				sql.append("       ci_qa_itm.deduct_des as deduct_des,");
				sql.append("       ci_qa_itm.Once_drp_scr as Once_drp_scr,");
				sql.append("       ci_qa_itm.fg_repair as fg_repair,");
				sql.append("       ci_qa_itm.FG_SERIOUS as fg_serious,");
				sql.append("       ci_qa_itm.sortno as sortno,"); 
				if (qaPatDto!=null&&qaPatDto.getId_revision()!=null) {
					sql.append("       (select count(*) from ci_qa_flt  ci_qa_flt where ci_qa_flt.id_qa_itm=ci_qa_itm.id_qa_itm and ci_qa_flt.id_revision='"+qaPatDto.getId_revision()+"' and ci_qa_flt.id_sbmt_user='"+Context.get().getUserId()+"') as deduct_scr_times,");
				} else if(qaPatDto!=null&&qaPatDto.getId_ent()!=null){
					sql.append("       (select count(*) from ci_qa_flt  ci_qa_flt where ci_qa_flt.id_qa_itm=ci_qa_itm.id_qa_itm and ci_qa_flt.id_revision='~' and ci_qa_flt.id_ent='"+qaPatDto.getId_ent()+"' and  ((ci_qa_flt.sd_qa_ty='"+ICiMrDictCodeConst.SD_EXEC_SEGMENT+"' and ci_qa_flt.id_sbmt_user='"+Context.get().getUserId()+"') or ci_qa_flt.sd_qa_ty='"+ICiMrDictCodeConst.SD_EXEC_AUTOMATIC+"')) as deduct_scr_times,");
				}
				sql.append("       ci_qa_itm.fg_auto_qa as fg_auto_qa"); 
				sql.append("    from ci_qa_itm ci_qa_itm"); 
				sql.append("    inner join ci_qa_itm_fst ci_qa_itm_fst"); 
				sql.append("       on ci_qa_itm_fst.id_fst = ci_qa_itm.id_fst");
				sql.append("    where ci_qa_itm.sd_qa like '%"+ICiMrDictCodeConst.SD_EXEC_SEGMENT+"%'"); 
				sql.append("    AND ci_qa_itm.fg_active = 'Y'"); 
				sql.append("    AND ci_qa_itm_fst.id_entp = '"+ IBdFcDictCodeConst.ID_CODE_ENTP_IP+"'");
				sql.append("       order by ci_qa_itm.sortno");
				String sqlStr=sql.toString();
       @SuppressWarnings("unchecked")
       List<ItmDTO> listMr = (List<ItmDTO>) daf.execQuery(sqlStr, new BeanListHandler(ItmDTO.class));
       return (ItmDTO[]) listMr.toArray(new ItmDTO[0]);
	}
}
