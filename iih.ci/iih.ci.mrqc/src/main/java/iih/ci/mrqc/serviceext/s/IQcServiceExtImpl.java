package iih.ci.mrqc.serviceext.s;

import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.d.Cidiagdto;
import iih.ci.mrqc.dto.rfmnotice.d.QaNoticeDTO;
import iih.ci.mrqc.qaflt.d.QaFltDO;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.qaflt.i.IQafltRService;
import iih.ci.mrqc.serviceext.i.IQcServiceExt;
import iih.ci.mrqc.serviceext.s.bp.MrQcGetFltDtoBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

/**
* 病历缺陷扩展服务操作方法服务实现
*/
@Service(serviceInterfaces={IQcServiceExt.class}, binding=Binding.JSONRPC)
public class IQcServiceExtImpl implements IQcServiceExt{

	
    /**
	*  获取环节质控缺陷DTO 通过就诊号 和当前缺陷的提出人 只能看到自己所提的缺陷
	*/
    public  QaFltDTO[] getIntermediateQcfltDtos( String id_ent, String cqf_submit_user ) throws BizException{
     /**
	 *  实现代码
	 */
    	DAFacade daf = new DAFacade();  	
    	StringBuilder sql = new StringBuilder();
				sql.append("SELECT cqt.id_flt_sta,\n");
				sql.append("       cqt.sd_flt_sta,\n");
				sql.append("	   cqif.id_fst          as id_fst,\n");
				sql.append("       cqif.name            as fst_name,\n");
				sql.append("       cqif.score           as score_fstmax,\n");
				sql.append("       bu.name           flt_sta_name,\n"); 
				sql.append("       cm.name           id_mr_name,\n"); 
				sql.append("       cqi.id_qa_itm,\n"); 
				sql.append("       cqi.once_drp_scr  once_drp_scr,\n"); 
				sql.append("       cqi.id_qa_drp_scr_tp   id_qa_drp_scr_tp,\n"); 
				sql.append("       cqi.max_drp_scr   max_drp_scr,\n");
				sql.append("       cqi.req           res,\n"); 
				sql.append("       cqi.deduct_des,\n"); 
				sql.append("       cqt.deduct_scr_times  deduct_scr_times,\n"); 
				sql.append("       cqt.id_qa_flt,\n"); 
				sql.append("       cqt.dt_sbmt,\n"); 
				sql.append("       cqt.id_sbmt_user,\n"); 
				sql.append("       su.name           sbmt_user_name,\n"); 
				sql.append("       cqt.rfm_des       rfm_req,\n"); 
				sql.append("       cm.id_emp_submit,\n"); 
				sql.append("       su3.name           emp_submit_name,\n"); 
				sql.append("       cm.id_submit_dept,\n"); 
				sql.append("       su2.name          submit_dept_name,\n"); 
				sql.append("       cqt.id_qa_flt     id_qaflt\n"); 
				sql.append("  FROM ci_qa_flt cqt\n"); 
				sql.append("  LEFT JOIN ci_qa_itm cqi\n"); 
				sql.append("    ON cqt.id_qa_itm = cqi.id_qa_itm\n"); 
				sql.append("  left JOIN ci_mr cm\n"); 
				sql.append("    ON cqt.id_mr = cm.id_mr\n"); 
				sql.append("  LEFT JOIN sys_user su\n"); 
				sql.append("    ON cqt.id_sbmt_user = su.id_user\n"); 
				sql.append("    LEFT JOIN sys_user su3\n"); 
				sql.append("    ON cm.id_emp_submit=su3.id_user\n"); 
				sql.append("  LEFT JOIN bd_dep su2\n"); 
				sql.append("    ON cm.id_submit_dept = su2.id_dep\n"); 
				sql.append("  LEFT JOIN bd_udidoc bu\n"); 
				sql.append("    ON bu.id_udidoc = cqt.id_flt_sta");
				sql.append("  left join ci_qa_itm_fst cqif\n");
				sql.append("    on cqif.id_fst = cqi.id_fst\n");
				sql.append(" WHERE id_flt_sta = '"+ICiMrDictCodeConst.ID_REFORM+"'\n"); 
				sql.append("   and id_revision = '~'\n"); 
				sql.append("   and id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_SEGMENT+"'\n"); 
				sql.append("   AND cqt.id_ent LIKE '%"+ id_ent + "%'\n"); 
				sql.append("   AND cqt.ds = '0'\n"); 
				sql.append("   and cqt.id_sbmt_user='"+ cqf_submit_user + "'\n"); 
				sql.append("   order by cqt.dt_sbmt desc"); 
				String sqlStr=sql.toString();
       @SuppressWarnings("unchecked")
       List<QaFltDTO> listMr = (List<QaFltDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaFltDTO.class));
       for(QaFltDTO  qa: listMr){
    	   if(qa.getId_mr_name() ==null){
    		   qa.setId_mr_name("病案首页");
    	   }
       }   
       return (QaFltDTO[]) listMr.toArray(new QaFltDTO[0]);
    }
    /**
	*  获取科室质控缺陷DTO 通过就诊号
	*/
	public QaFltDTO[] getDeptQcfltDtos(String id_ent, String cqf_submit_user) throws BizException {
		DAFacade daf = new DAFacade();
    	StringBuilder sql = new StringBuilder();
					
				sql.append("SELECT\n");
				sql.append("	   cqif.id_fst          as id_fst,\n");
				sql.append("       cqif.name            as fst_name,\n");
				sql.append("       cqif.score           as score_fstmax,\n");
				sql.append("  cqt.id_flt_sta,\n"); 
				sql.append("       cqt.sd_flt_sta,\n");
				sql.append("  bu.name flt_sta_name,\n"); 
				sql.append("  cm.name id_mr_name,\n"); 
				sql.append("       cqi.id_qa_itm,\n"); 
				sql.append("       cqi.once_drp_scr  once_drp_scr,\n"); 
				sql.append("       cqi.id_qa_drp_scr_tp   id_qa_drp_scr_tp,\n"); 
				sql.append("       cqi.max_drp_scr   max_drp_scr,\n");
				sql.append("  cqi.req res,\n"); 
				sql.append("  cqi.deduct_des,\n"); 
				sql.append("  cqt.deduct_scr_times  deduct_scr_times,\n"); 
				sql.append("  cqt.id_qa_flt,\n"); 
				sql.append("  cqt.dt_sbmt,\n"); 
				sql.append("  cqt.id_sbmt_user,\n"); 
				sql.append("  su.name sbmt_user_name,\n"); 
				sql.append("cqt.rfm_des       rfm_req,\n"); 
				sql.append("  cm.id_emp_submit,\n"); 
				sql.append("  su2.name emp_submit_name,\n"); 
				sql.append("       cm.id_submit_dept,\n"); 
				sql.append("       su3.name          submit_dept_name,\n"); 
				sql.append("  cqt.id_qa_flt id_qaflt\n"); 
				sql.append("FROM\n"); 
				sql.append("  ci_qa_flt cqt\n"); 
				sql.append("  LEFT JOIN ci_qa_itm cqi\n"); 
				sql.append("    ON   cqt.id_qa_itm = cqi.id_qa_itm\n"); 
				sql.append("  left JOIN ci_mr cm\n"); 
				sql.append("    ON   cqt.id_mr = cm.id_mr\n"); 
				sql.append("  LEFT JOIN sys_user su\n"); 
				sql.append("    ON   cqt.id_sbmt_user = su.id_user\n"); 
				sql.append("  LEFT JOIN sys_user su2\n"); 
				sql.append("    ON   cm.id_emp_submit = su2.id_user\n"); 
				sql.append("  LEFT JOIN bd_dep su3\n"); 
				sql.append("    ON cm.id_submit_dept = su3.id_dep\n"); 
				sql.append("  LEFT JOIN bd_udidoc bu\n"); 
				sql.append("    ON   bu.id_udidoc = cqt.id_flt_sta\n"); 
				sql.append("  left join ci_qa_itm_fst cqif\n");
				sql.append("    on cqif.id_fst = cqi.id_fst\n");
				sql.append("WHERE\n"); 
				sql.append("id_flt_sta='"+ICiMrDictCodeConst.ID_REFORM+"' and id_revision='~'"); 
				sql.append("and id_qa_ty='"+ICiMrDictCodeConst.ID_EXEC_DEPARTMENT+"'"); 
				sql.append("\tAND cqt.id_ent LIKE '%" + id_ent + "%'\n"); 
				sql.append("   AND cqt.ds = '0'\n"); 
				sql.append("   and cqt.id_sbmt_user='"+ cqf_submit_user + "'\n"); 
				sql.append("   order by cqt.dt_sbmt"); 
			    
				String sqlStr=sql.toString();
       @SuppressWarnings("unchecked")
       List<QaFltDTO> listMr = (List<QaFltDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaFltDTO.class));
       for(QaFltDTO  qa: listMr){
    	   if(qa.getId_mr_name() ==null){
    		   qa.setId_mr_name("病案首页");
    	   }
       }   
       return (QaFltDTO[]) listMr.toArray(new QaFltDTO[0]);
	}
	/**
	*  获取终末质控缺陷DTO 通过就诊号
	*/
	public QaFltDTO[] getTerminalQcfltDtos(String id_ent, String cqf_submit_user) throws BizException {
		DAFacade daf = new DAFacade();    	
    	StringBuilder sql = new StringBuilder();
					
    	sql.append("SELECT   ");
    	sql.append("     cqif.id_fst          as id_fst,   ");
    	sql.append("     cqif.name            as fst_name,   ");
    	sql.append("     cqif.score           as score_fstmax,   ");
    	sql.append("     cqt.id_flt_sta,   ");
    	sql.append("     cqt.sd_flt_sta,   ");
    	sql.append("     bu.name flt_sta_name,   ");
    	sql.append("     cm.name id_mr_name,   ");
    	sql.append("     cqi.id_qa_itm,   ");
    	sql.append("     cqi.once_drp_scr  once_drp_scr,   ");
    	sql.append("     cqi.id_qa_drp_scr_tp   id_qa_drp_scr_tp,   ");
    	sql.append("     cqi.max_drp_scr   max_drp_scr,   ");
    	sql.append("     cqi.req res,   ");
    	sql.append("     cqi.deduct_des,   ");
    	sql.append("     cqt.deduct_scr_times  deduct_scr_times,   ");
    	sql.append("     cqt.id_qa_flt,   ");
    	sql.append("     cqt.dt_sbmt,   ");
    	sql.append("     cqt.id_sbmt_user,   ");
    	sql.append("     su.name sbmt_user_name,   ");
    	sql.append("     cqt.rfm_des       rfm_req,   ");
    	sql.append("     cqt.Id_rfm_user as id_treat_doctor,   ");
    	sql.append("     su2.name as treat_doctor_name,   "); // ----整改人   
    	sql.append("     cqt.Id_rfm_user as id_emp_submit,   ");
    	sql.append("     su2.name as emp_submit_name,      "); // ----接收人
    	sql.append("     cqt.Id_rfm_dept as id_dep_pat,    ");
    	sql.append("     su3.name as dep_pat,   "); // ----整改科室 
    	sql.append("     cqt.Id_rfm_dept as id_submit_dept,    ");
    	sql.append("     su3.name as submit_dept_name,    "); // ----接收科室
    	sql.append("     cqt.id_qa_flt id_qaflt   ");
    	sql.append(" FROM ci_qa_flt cqt   ");
    	sql.append("  LEFT JOIN ci_qa_itm cqi   ");
    	sql.append("    ON   cqt.id_qa_itm = cqi.id_qa_itm   ");
    	sql.append("  left JOIN ci_mr cm   ");
    	sql.append("    ON   cqt.id_mr = cm.id_mr   ");
    	sql.append("  LEFT JOIN sys_user su   ");
    	sql.append("    ON   cqt.id_sbmt_user = su.id_user   ");
    	sql.append("  LEFT JOIN sys_user su2        ");
    	sql.append("    ON   cqt.Id_rfm_user = su2.id_user   ");
    	sql.append("  LEFT JOIN bd_dep su3   ");
    	sql.append("    ON cqt.Id_rfm_dept = su3.id_dep   ");
    	sql.append("  LEFT JOIN bd_udidoc bu   ");
    	sql.append("    ON   bu.id_udidoc = cqt.id_flt_sta   ");
    	sql.append("  left join ci_qa_itm_fst cqif   ");
    	sql.append("    on cqif.id_fst = cqi.id_fst   ");
		sql.append("WHERE\n"); 
		sql.append("id_flt_sta='"+ICiMrDictCodeConst.ID_REFORM+"' and id_revision='~'");
		sql.append("and id_qa_ty='"+ICiMrDictCodeConst.ID_EXEC_END+"'");
		sql.append("\tAND cqt.id_ent LIKE '%"+ id_ent + "%'\n"); 
		sql.append("   AND cqt.ds = '0'\n"); 
		sql.append("   and cqt.id_sbmt_user='"+ cqf_submit_user + "'\n"); 
		sql.append("   order by cqt.dt_sbmt");
	    
		String sqlStr=sql.toString();
       @SuppressWarnings("unchecked")
       List<QaFltDTO> listMr = (List<QaFltDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaFltDTO.class));
       for(QaFltDTO  qa: listMr){
    	   if(qa.getId_mr_name() ==null){
    		   qa.setId_mr_name("病案首页");
    	   }
       }   
       return (QaFltDTO[]) listMr.toArray(new QaFltDTO[0]);
	}
       
    
    /**
   	*  获取环节质控整改通知DTO
   	*/
	@Override
	public QaNoticeDTO[] getIntermediateQcCorrectNoticeDtos(String id_rfm_user,String id_rfm_dept)
			throws BizException {
		 /**
		 *  质控整改实现代码
		 */
	    	DAFacade daf = new DAFacade();
	
	    	StringBuilder sql = new StringBuilder();

				sql.append("select bu.name id_status,\n");
				sql.append("       cqrn.dt_send,\n"); 
				sql.append("       cqrn.id_exec_doctor,\n"); 
				sql.append("       su.name exec_doctor_name,\n"); 
				sql.append("       cqrn.id_exec_dept,\n"); 
				sql.append("       bd.name exec_dept_name,\n"); 
				sql.append("       cqrn.id_ent,\n"); 
				sql.append("       cqrn.id_revision,\n"); 
				sql.append("       ee.name_pat,\n"); 
				sql.append("       (select count(1)\n"); 
				sql.append("          from ci_qa_flt cqf\n"); 
				sql.append("         where cqf.id_revision = cqrn.id_revision\n"); 
				sql.append("           and cqf.id_rfm_user = '"+ id_rfm_user + "'\n"); 
				sql.append("           and cqf.id_rfm_dept = '"+id_rfm_dept + "') deduct_times,\n"); 
				sql.append("       cqrn.rfm_deadline,\n"); 
				sql.append("       cqrn.dt_deadline,\n"); 
				sql.append("       cqrn.des\n"); 
				sql.append("  from ci_qa_revision_notice cqrn\n"); 
				sql.append("  left join bd_dep bd\n"); 
				sql.append("    on bd.id_dep = cqrn.id_exec_dept\n"); 
				sql.append("  left join sys_user su\n"); 
				sql.append("    on cqrn.id_exec_doctor = su.id_user\n"); 
				sql.append("  left join bd_udidoc bu\n"); 
				sql.append("    on bu.id_udidoc = cqrn.id_status\n"); 
				sql.append("  left join en_ent ee\n"); 
				sql.append("    on ee.id_ent = cqrn.id_ent\n"); 
				sql.append(" where exists\n"); 
				sql.append(" (select *\n"); 
				sql.append("          from ci_qa_flt cqf\n"); 
				sql.append("         where cqf.id_revision = cqrn.id_revision\n"); 
				sql.append("           and cqf.id_rfm_user = '"+ id_rfm_user + "'\n"); 
				sql.append("           and cqf.id_rfm_dept = '"+id_rfm_dept + "'\n"); 
				sql.append("           and cqf.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_SEGMENT+"'\n"); 
				sql.append("           AND cqf.ds = '0')\n"); 
				sql.append("   and cqrn.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_SEGMENT+"'\n"); 
				sql.append("   and (cqrn.id_status = '"+ICiMrDictCodeConst.ID_TO_REFORM+"' or\n"); 
				sql.append("       cqrn.id_status = '"+ICiMrDictCodeConst.ID_RECTIFICATION+"')");
				sql.append("   order by cqrn.sv desc");
	    
				String sqlStr=sql.toString();
	       @SuppressWarnings("unchecked")
	       List<QaNoticeDTO> listMr = (List<QaNoticeDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaNoticeDTO.class));
	      
	       return (QaNoticeDTO[]) listMr.toArray(new QaNoticeDTO[0]);
	}
	
	/**
   	*  获取科室质控整改通知DTO
   	*/
	@Override
	public QaNoticeDTO[] getDeptQcCorrectNoticeDtos(String id_rfm_user,String id_rfm_dept) throws BizException {
		 /**
		 *  科室整改实现代码
		 */
	    	DAFacade daf = new DAFacade();
	    	
	    	StringBuilder sql = new StringBuilder();
				sql.append("select bu.name id_status,\n");
				sql.append("       cqrn.dt_send,\n"); 
				sql.append("       cqrn.id_exec_doctor,\n"); 
				sql.append("       su.name exec_doctor_name,\n"); 
				sql.append("       cqrn.id_exec_dept,\n"); 
				sql.append("       bd.name exec_dept_name,\n"); 
				sql.append("       cqrn.id_ent,\n"); 
				sql.append("       cqrn.id_revision,\n"); 
				sql.append("       ee.name_pat,\n"); 
				sql.append("       (select count(1)\n"); 
				sql.append("          from ci_qa_flt cqf\n"); 
				sql.append("         where cqf.id_revision = cqrn.id_revision\n"); 
				sql.append("           and cqf.id_rfm_user = '"+ id_rfm_user + "'\n"); 
				sql.append("           and cqf.id_rfm_dept = '"+id_rfm_dept + "') deduct_times,\n"); 
				sql.append("       cqrn.rfm_deadline,\n"); 
				sql.append("       cqrn.dt_deadline,\n"); 
				sql.append("       cqrn.des\n"); 
				sql.append("  from ci_qa_revision_notice cqrn\n"); 
				sql.append("  left join bd_dep bd\n"); 
				sql.append("    on bd.id_dep = cqrn.id_exec_dept\n"); 
				sql.append("  left join sys_user su\n"); 
				sql.append("    on cqrn.id_exec_doctor = su.id_user\n"); 
				sql.append("  left join bd_udidoc bu\n"); 
				sql.append("    on bu.id_udidoc = cqrn.id_status\n"); 
				sql.append("  left join en_ent ee\n"); 
				sql.append("    on ee.id_ent = cqrn.id_ent\n"); 
				sql.append(" where exists\n"); 
				sql.append(" (select *\n"); 
				sql.append("          from ci_qa_flt cqf\n"); 
				sql.append("         where cqf.id_revision = cqrn.id_revision\n"); 
				sql.append("           and cqf.id_rfm_user = '"+ id_rfm_user + "'\n"); 
				sql.append("           and cqf.id_rfm_dept = '"+id_rfm_dept + "'\n"); 
				sql.append("           and cqf.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_DEPARTMENT+"'\n"); 
				sql.append("           AND cqf.ds = '0')\n"); 
				sql.append("   and cqrn.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_DEPARTMENT+"'\n"); 
				sql.append("   and (cqrn.id_status = '"+ICiMrDictCodeConst.ID_TO_REFORM+"' or\n"); 
				sql.append("       cqrn.id_status = '"+ICiMrDictCodeConst.ID_RECTIFICATION+"')");
				sql.append("   order by cqrn.sv desc");
				String sqlStr=sql.toString();
	       @SuppressWarnings("unchecked")
	       List<QaNoticeDTO> listMr = (List<QaNoticeDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaNoticeDTO.class));
	      
	       return (QaNoticeDTO[]) listMr.toArray(new QaNoticeDTO[0]);
	}

	/**
   	*  获取终末质控整改通知DTO
   	*/
	@Override
	public QaNoticeDTO[] getTerminalQcCorrectNoticeDtos(String id_rfm_user,String id_rfm_dept) throws BizException {
		 /**
		 *  终末质控实现代码
		 */
	    	DAFacade daf = new DAFacade();
	    	
	    	StringBuilder sql = new StringBuilder();
				sql.append("select bu.name id_status,\n");
				sql.append("       cqrn.dt_send,\n"); 
				sql.append("       cqrn.id_exec_doctor,\n"); 
				sql.append("       su.name exec_doctor_name,\n"); 
				sql.append("       cqrn.id_exec_dept,\n"); 
				sql.append("       bd.name exec_dept_name,\n"); 
				sql.append("       cqrn.id_revision,\n"); 
				sql.append("       cqrn.id_ent,\n"); 
				sql.append("       ee.name_pat,\n"); 
				sql.append("       (select count(1)\n"); 
				sql.append("          from ci_qa_flt cqf\n"); 
				sql.append("         where cqf.id_revision = cqrn.id_revision\n"); 
				sql.append("           and cqf.id_rfm_user = '"+ id_rfm_user + "'\n"); 
				sql.append("           and cqf.id_rfm_dept = '"+id_rfm_dept + "') deduct_times,\n"); 
				sql.append("       cqrn.rfm_deadline,\n"); 
				sql.append("       cqrn.dt_deadline,\n"); 
				sql.append("       cqrn.des\n"); 
				sql.append("  from ci_qa_revision_notice cqrn\n"); 
				sql.append("  left join bd_dep bd\n"); 
				sql.append("    on bd.id_dep = cqrn.id_exec_dept\n"); 
				sql.append("  left join sys_user su\n"); 
				sql.append("    on cqrn.id_exec_doctor = su.id_user\n"); 
				sql.append("  left join bd_udidoc bu\n"); 
				sql.append("    on bu.id_udidoc = cqrn.id_status\n"); 
				sql.append("  left join en_ent ee\n"); 
				sql.append("    on ee.id_ent = cqrn.id_ent\n"); 
				sql.append(" where exists\n"); 
				sql.append(" (select *\n"); 
				sql.append("          from ci_qa_flt cqf\n"); 
				sql.append("         where cqf.id_revision = cqrn.id_revision\n"); 
				sql.append("           and cqf.id_rfm_user = '"+id_rfm_user + "'\n"); 
				sql.append("           and cqf.id_rfm_dept = '"+id_rfm_dept + "' \n"); 
				sql.append("           and cqf.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_END+"'\n"); 
				sql.append("           AND cqf.ds = '0')\n"); 
				sql.append("   and cqrn.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_END+"'\n"); 
				sql.append("   and (cqrn.id_status = '"+ICiMrDictCodeConst.ID_TO_REFORM+"' or\n"); 
				sql.append("       cqrn.id_status = '"+ICiMrDictCodeConst.ID_RECTIFICATION+"')");
				sql.append("   order by cqrn.sv desc");

				String sqlStr=sql.toString();
	       @SuppressWarnings("unchecked")
	       List<QaNoticeDTO> listMr = (List<QaNoticeDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaNoticeDTO.class));
	      
	       return (QaNoticeDTO[]) listMr.toArray(new QaNoticeDTO[0]);
	}
	
	
	/**
   	*  获取环节质控追踪审核通知书列表DTO
   	*/
	@Override
	public QaNoticeDTO[] getIntermediateQcTraceDtos(String id_exec_doctor)
			throws BizException {
		
			DAFacade daf = new DAFacade();

			StringBuilder sql = new StringBuilder();
			sql.append("select t.id_status as id_status,\n");
			sql.append("       w.name as status_name,\n"); 
			sql.append("       t.dt_send,\n"); 
			sql.append("       u.name as rfm_doctor_name,\n"); 
			sql.append("       n.name as rfm_dept_name,\n"); 
			sql.append("       t.id_revision,\n"); 
			sql.append("       t.rfm_deadline,\n"); 
			sql.append("       (select count(*) from ci_qa_flt e where t.id_revision = e.id_revision) as deduct_times,\n"); 
			sql.append("       t.dt_deadline,\n"); 
			sql.append("       t.des,\n"); 
			sql.append("       t.id_ent,\n"); 
			sql.append("       a.name_pat\n"); 
			sql.append("  from  CI_QA_REVISION_NOTICE t\n"); 
			sql.append("  left join bd_udidoc w\n"); 
			sql.append("  on w.id_udidoc = t.id_status\n"); 
			sql.append("  left join EN_ENT a\n"); 
			sql.append("  on t.id_ent = a.id_ent\n"); 
			sql.append("  left join sys_user u\n"); 
			sql.append("  on t.id_rfm_doctor = u.id_psn\n"); 
			sql.append("  left join  bd_dep n\n"); 
			sql.append("  on  t.id_rfm_dept = n.id_dep\n"); 
			sql.append("   where t.id_exec_doctor = '"+ id_exec_doctor + "'");
			sql.append("   and t.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_SEGMENT+"'\n");
			sql.append("   AND t.ds = '0'\n"); 
			sql.append("   order by t.sv desc");

			String sqlStr=sql.toString();
	       @SuppressWarnings("unchecked")
	       List<QaNoticeDTO> listMr1 = (List<QaNoticeDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaNoticeDTO.class));
	      
	       return (QaNoticeDTO[]) listMr1.toArray(new QaNoticeDTO[0]);
	}
	/**
   	*  获取部门质控追踪通知书列表DTO
   	*/
	@Override
	public QaNoticeDTO[] getDeptQcTraceDtos(String id_exec_doctor)
			throws BizException {
		// TODO Auto-generated method stub
		DAFacade daf = new DAFacade();

		StringBuilder sql = new StringBuilder();
			sql.append("select t.id_status as id_status,\n");
			sql.append("       w.name as status_name,\n"); 
			sql.append("       t.dt_send,\n"); 
			sql.append("       u.name as rfm_doctor_name,\n"); 
			sql.append("       n.name as rfm_dept_name,\n"); 
			sql.append("       t.id_revision,\n"); 
			sql.append("       t.rfm_deadline,\n"); 
			sql.append("       (select count(*) from ci_qa_flt e where t.id_revision = e.id_revision) as deduct_times,\n"); 
			sql.append("       t.dt_deadline,\n"); 
			sql.append("       t.des,\n"); 
			sql.append("       t.id_ent,\n"); 
			sql.append("       a.name_pat\n"); 
			sql.append("  from  CI_QA_REVISION_NOTICE t\n"); 
			sql.append("  left join bd_udidoc w\n"); 
			sql.append("  on w.id_udidoc = t.id_status\n"); 
			sql.append("  left join EN_ENT a\n"); 
			sql.append("  on t.id_ent = a.id_ent\n"); 
			sql.append("  left join sys_user u\n"); 
			sql.append("  on t.id_rfm_doctor = u.id_psn\n"); 
			sql.append("  left join  bd_dep n\n"); 
			sql.append("  on  t.id_rfm_dept = n.id_dep\n"); 
			sql.append("   where t.id_exec_doctor = '"+ id_exec_doctor + "'"); 
			sql.append("   and t.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_DEPARTMENT+"'\n"); 
			sql.append("   AND t.ds = '0'\n"); 
			sql.append("   order by t.sv desc"); 

			String sqlStr=sql.toString();
       @SuppressWarnings("unchecked")
       List<QaNoticeDTO> listMr1 = (List<QaNoticeDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaNoticeDTO.class));
      
       return (QaNoticeDTO[]) listMr1.toArray(new QaNoticeDTO[0]);	
	}
	/**
   	*  获取终末质控追踪通知书列表DTO
   	*/
	@Override
	public QaNoticeDTO[] getTerminalQcTraceDtos(String id_exec_doctor)
			throws BizException {
		DAFacade daf = new DAFacade();

		StringBuilder sql = new StringBuilder();
			sql.append("select t.id_status as id_status,\n");
			sql.append("       w.name as status_name,\n"); 
			sql.append("       t.dt_send,\n"); 
			sql.append("       u.name as rfm_doctor_name,\n"); 
			sql.append("       n.name as rfm_dept_name,\n"); 
			sql.append("       t.id_revision,\n"); 
			sql.append("       t.rfm_deadline,\n"); 
			sql.append("       (select count(*) from ci_qa_flt e where t.id_revision = e.id_revision) as deduct_times,\n"); 
			sql.append("       t.dt_deadline,\n"); 
			sql.append("       t.des,\n"); 
			sql.append("       t.id_ent,\n"); 
			sql.append("       a.name_pat\n"); 
			sql.append("  from  CI_QA_REVISION_NOTICE t\n"); 
			sql.append("  left join bd_udidoc w\n"); 
			sql.append("  on w.id_udidoc = t.id_status\n"); 
			sql.append("  left join EN_ENT a\n"); 
			sql.append("  on t.id_ent = a.id_ent\n"); 
			sql.append("  left join sys_user u\n"); 
			sql.append("  on t.id_rfm_doctor = u.id_psn\n"); 
			sql.append("  left join  bd_dep n\n"); 
			sql.append("  on  t.id_rfm_dept = n.id_dep\n"); 
			sql.append("   where t.id_exec_doctor = '"+ id_exec_doctor + "'"); 
			sql.append("   and t.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_END+"'\n"); 
			sql.append("   AND t.ds = '0'\n"); 
			sql.append("   order by t.sv desc"); 
			
			String sqlStr=sql.toString();
       @SuppressWarnings("unchecked")
       List<QaNoticeDTO> listMr1 = (List<QaNoticeDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaNoticeDTO.class));
      
       return (QaNoticeDTO[]) listMr1.toArray(new QaNoticeDTO[0]);	
	
	}
	/**
	 *  审核追踪根据通知 查询缺陷 弹框发送通知查询缺陷
	 */
	@Override
	public QaFltDTO[] getMrQcfltDto(String id_revision,String id_flt_sta) throws BizException {
		/**
		 *  实现代码
		 */
	    	DAFacade daf = new DAFacade();
	    	
	    	String sqlWhere ="where 1=1 and cqt.id_revision = '"+id_revision+"'and cqt.ds = '0'";
	    	if(!StringUtil.isEmptyWithTrim(id_flt_sta)){
	    		sqlWhere +=" and cqt.id_flt_sta='"+id_flt_sta+"' ";
	    	}
	    	
	    	StringBuilder sql = new StringBuilder();
	    	sql.append("SELECT cqt.id_flt_sta, \n");
	    	sql.append("       cqt.sd_flt_sta,\n");
	    	sql.append("       cqif.id_fst      as id_fst,\n");
	    	sql.append("       cqif.name        as fst_name,\n");
	    	sql.append("       cqif.score       as score_fstmax,\n");
	    	sql.append("       bu.name          as flt_sta_name,\n");
	    	sql.append("       cm.name          id_mr_name,\n");
	    	sql.append("       cqt.id_mr        id_mr,\n");
	    	sql.append("       cqt.id_revision,\n");
	    	sql.append("       cqi.id_qa_itm,\n");
	    	sql.append("       cqi.once_drp_scr  once_drp_scr,\n");
	    	sql.append("       cqi.id_qa_drp_scr_tp   id_qa_drp_scr_tp,\n");
	    	sql.append("       cqi.max_drp_scr   max_drp_scr,\n");
	    	sql.append("       cqi.req           res,\n");
	    	sql.append("       cqi.deduct_des,\n");
	    	sql.append("       cqi.FG_SERIOUS as fg_serious, \n");
	    	sql.append("       cqt.deduct_scr_times  deduct_scr_times,\n");
	    	sql.append("       cqt.dt_sbmt,\n");
	    	sql.append("       cqt.id_sbmt_user,\n");
	    	sql.append("       su.name           sbmt_user_name,\n");
	    	sql.append("       cqt.rfm_des       rfm_req,\n");
	    	sql.append("       cqt.id_rfm_user  as id_emp_submit,\n");
	    	sql.append("       su3.name           emp_submit_name,\n");
	    	sql.append("       cqt.id_rfm_dept as id_submit_dept,\n");
	    	sql.append("       dep.name          submit_dept_name ,\n");
	    	sql.append("       cqi.fg_repair as fg_repair ,\n");
	    	sql.append("       cqt.id_qa_flt id_qaflt\n");
	    	sql.append("  FROM ci_qa_flt cqt\n");
	    	sql.append("  LEFT JOIN ci_qa_itm cqi\n");
	    	sql.append("    ON   cqt.id_qa_itm = cqi.id_qa_itm\n");
	    	sql.append("  left JOIN ci_mr cm\n");
	    	sql.append("    ON   cqt.id_mr = cm.id_mr\n");
	    	sql.append("  LEFT JOIN sys_user su\n");
	    	sql.append("    ON   cqt.id_sbmt_user = su.id_user\n");
	    	sql.append("  LEFT JOIN sys_user su3\n");
	    	sql.append("    ON   cqt.id_rfm_user = su3.id_user\n");
	    	sql.append("  LEFT JOIN bd_dep dep\n");
	    	sql.append("    ON    cqt.id_rfm_dept = dep.id_dep\n");
	    	sql.append("  LEFT JOIN bd_udidoc bu\n");
	    	sql.append("    ON   bu.id_udidoc = cqt.id_flt_sta\n");
	    	sql.append("  left join ci_qa_itm_fst cqif\n");
	    	sql.append("    on cqif.id_fst = cqi.id_fst\n");
	    	sql.append(sqlWhere);
			sql.append("   order by cqt.dt_sbmt desc"); 
				
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
 * 添加条件作废标识（后期需要医嘱提供服务，整合前后台）
 */
	@Override
	public Cidiagdto[] getCidiagdto(String id_en,String[] sd_disys) throws BizException {
		DAFacade daf = new DAFacade();
		StringBuilder sql = new StringBuilder();
    		sql.append("select tt.id_en, mm.di_standard_name as id_disys, sf.name as id_ditp, mm.id_didef_name||(decode(mm.fg_suspdi,'Y','?',''))||(decode(mm.fg_flupci,'Y','(待查)','')) as name,\n"); 
    		sql.append("aa.code as code ,mm.supplement as des,tt.dt_di,mm.id_didef_syn_name as Name_symptom  from ci_di_itm mm\n"); 
    		sql.append("left outer join  ci_di tt  on tt.id_di = mm.id_di\n"); 
    		sql.append("left outer join bd_udidoc sf on tt.id_ditp = sf.id_udidoc\n"); 
    		sql.append("left outer join  bd_di_def aa   on mm.id_didef = aa.id_didef\n"); 
    		sql.append("where tt.fg_cancel='N' and tt.id_en ='"+id_en+"'"); 
    		
    		if(sd_disys!=null)
    		{
    			String sd ="";
    			for(int i=0;i<sd_disys.length;i++)
    			{
    				
    				if(i==sd_disys.length-1)
    					sd += "'"+sd_disys[i]+"'";
    				else
    					sd += "'"+sd_disys[i]+"' ,";
    			}
    			
    			String strWhere = " and mm.sd_disys in ("+sd+")";
    			sql.append(strWhere);
    		}
    		
     		String sqlStr=sql.toString();
       @SuppressWarnings("unchecked")
       List<Cidiagdto> listMr1 = (List<Cidiagdto>) daf.execQuery(sqlStr, new BeanListHandler(Cidiagdto.class));
      
       return (Cidiagdto[]) listMr1.toArray(new Cidiagdto[0]);	
	}
	@Override
	public QaNoticeDTO[] getNoticeDtosByIdent(String id_ent)
			throws BizException {
		DAFacade daf = new DAFacade();
		StringBuilder sql = new StringBuilder();

		sql.append("select cqrn.id_status id_status,\n");
		sql.append("bu.name status_name,\n");
		sql.append("       cqrn.dt_send,\n"); 
		sql.append("       cqrn.id_exec_doctor,\n"); 
		sql.append("       su.name exec_doctor_name,\n"); 
		sql.append("       cqrn.id_exec_dept,\n"); 
		sql.append("       bd.name exec_dept_name,\n"); 
		sql.append("       cqrn.id_qa_ty,\n"); 
		sql.append("       bu2.name qa_ty_name,\n"); 
		sql.append("       cqrn.id_ent,\n"); 
		sql.append("       cqrn.id_revision,\n"); 
		sql.append("       ee.name_pat,\n"); 
		sql.append("       (select count(1)\n"); 
		sql.append("          from ci_qa_flt cqf\n"); 
		sql.append("         where cqf.id_revision = cqrn.id_revision\n"); 
		sql.append("           and cqf.id_rfm_user = '"+ Context.get().getUserId() + "'\n"); 
		sql.append("           and cqf.id_rfm_dept = '"+Context.get().getDeptId()+ "') deduct_times,\n"); 
		sql.append("       cqrn.rfm_deadline,\n"); 
		sql.append("       cqrn.dt_deadline,\n"); 
		sql.append("       cqrn.des_feedback,\n"); 
		sql.append("       cqrn.des\n"); 
		sql.append("  from ci_qa_revision_notice cqrn\n"); 
		sql.append("  left join bd_dep bd\n"); 
		sql.append("    on bd.id_dep = cqrn.id_exec_dept\n"); 
		sql.append("  left join sys_user su\n"); 
		sql.append("    on cqrn.id_exec_doctor = su.id_user\n"); 
		sql.append("  left join bd_udidoc bu\n"); 
		sql.append("    on bu.id_udidoc = cqrn.id_status\n"); 
		sql.append("  left join en_ent ee\n"); 
		sql.append("    on ee.id_ent = cqrn.id_ent\n"); 
		sql.append("  left join bd_udidoc bu2\n"); 
		sql.append("    on bu2.id_udidoc = cqrn.id_qa_ty\n"); 
		sql.append("  left join ci_amr amr\n"); 
		sql.append("    on amr.id_ent = cqrn.id_ent\n"); 
		sql.append(" where cqrn.id_ent='"+id_ent+"'  and exists\n"); 
		sql.append(" (select *\n"); 
		sql.append("          from ci_qa_flt cqf\n"); 
		sql.append("         where cqf.id_revision = cqrn.id_revision and amr.fg_seal = 'N'  \n"); 
		sql.append("           and cqf.id_rfm_user = '"+ Context.get().getUserId() + "'\n"); 
		sql.append("           AND cqf.id_ent='"+id_ent+"'"); 
		sql.append("           AND cqf.ds = '0')\n"); 
		sql.append("   order by cqrn.dt_send DESC");
		String sqlStr=sql.toString();
    	@SuppressWarnings("unchecked")
        List<QaNoticeDTO> listMr = (List<QaNoticeDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaNoticeDTO.class));
       
        return (QaNoticeDTO[]) listMr.toArray(new QaNoticeDTO[0]);
	}
	@Override
	public QaFltDTO[] getOutQcfltDtos(String id_ent, String cqf_submit_user)
			throws BizException {
		 /**
		 *  实现代码
		 */
	    	DAFacade daf = new DAFacade();
	    	StringBuilder sql = new StringBuilder();
					sql.append("SELECT cqt.id_flt_sta,\n");
					sql.append("       cqt.sd_flt_sta,\n");
					sql.append("	   cqif.id_fst          as id_fst,\n");
					sql.append("       cqif.name            as fst_name,\n");
					sql.append("       cqif.score           as score_fstmax,\n");
					sql.append("       bu.name           flt_sta_name,\n"); 
					sql.append("       cm.name           id_mr_name,\n"); 
					sql.append("       cqi.id_qa_itm,\n"); 
					sql.append("       cqi.once_drp_scr  once_drp_scr,\n"); 
					sql.append("       cqi.id_qa_drp_scr_tp   id_qa_drp_scr_tp,\n"); 
					sql.append("       cqi.max_drp_scr   max_drp_scr,\n");
					sql.append("       cqi.req           res,\n"); 
					sql.append("       cqi.deduct_des,\n"); 
					sql.append("       cqi.FG_SERIOUS as fg_serious,");
					sql.append("       cqt.deduct_scr_times  deduct_scr_times,\n"); 
					sql.append("       cqt.id_qa_flt,\n"); 
					sql.append("       cqt.dt_sbmt,\n"); 
					sql.append("       cqt.id_sbmt_user,\n"); 
					sql.append("       su.name           sbmt_user_name,\n"); 
					sql.append("       cqt.rfm_des       rfm_req,\n"); 
					sql.append("       cm.id_emp_submit,\n"); 
					sql.append("       su3.name           emp_submit_name,\n"); 
					sql.append("       cm.id_submit_dept,\n"); 
					sql.append("       su2.name          submit_dept_name,\n"); 
					sql.append("       cqt.id_qa_flt     id_qaflt\n"); 
					sql.append("  FROM ci_qa_flt cqt\n"); 
					sql.append("  LEFT JOIN ci_qa_itm cqi\n"); 
					sql.append("    ON cqt.id_qa_itm = cqi.id_qa_itm\n"); 
					sql.append("  left JOIN ci_mr cm\n"); 
					sql.append("    ON cqt.id_mr = cm.id_mr\n"); 
					sql.append("  LEFT JOIN sys_user su\n"); 
					sql.append("    ON cqt.id_sbmt_user = su.id_user\n"); 
					sql.append("    LEFT JOIN sys_user su3\n"); 
					sql.append("    ON cm.id_emp_submit=su3.id_user\n"); 
					sql.append("  LEFT JOIN bd_dep su2\n"); 
					sql.append("    ON cm.id_submit_dept = su2.id_dep\n"); 
					sql.append("  LEFT JOIN bd_udidoc bu\n"); 
					sql.append("    ON bu.id_udidoc = cqt.id_flt_sta");
					sql.append("  left join ci_qa_itm_fst cqif\n");
					sql.append("    on cqif.id_fst = cqi.id_fst\n");
					sql.append(" WHERE id_flt_sta = '"+ICiMrDictCodeConst.ID_REFORM+"'\n"); 
					//sql.append("   and id_revision = '~'\n"); 
					sql.append("   and id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_OUTQC+"'\n"); 
					sql.append("   AND cqt.id_ent LIKE '%"+ id_ent + "%'\n"); 
					sql.append("   AND cqt.ds = '0'\n"); 
					sql.append("   and cqt.id_sbmt_user='"+ cqf_submit_user + "'\n"); 
					sql.append("   order by cqt.dt_sbmt"); 
					String sqlStr=sql.toString();
	       @SuppressWarnings("unchecked")
	       List<QaFltDTO> listMr = (List<QaFltDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaFltDTO.class));
	      
	       return (QaFltDTO[]) listMr.toArray(new QaFltDTO[0]);
	}
    /**
	*  再整改根据通知获取待整改的缺陷DTO
	*/
	@Override
	public QaFltDTO[] getNeedToDoQcfltDtoAgainByRevision(String id_revision) throws BizException {
    	DAFacade daf = new DAFacade();
    	
    	StringBuilder sql = new StringBuilder();
			sql.append("SELECT cqt.id_flt_sta,\n");
			sql.append("       cqt.sd_flt_sta,\n");
			sql.append("       bu.name           as flt_sta_name,\n"); 
			sql.append("	   cqif.id_fst          as id_fst,\n");
			sql.append("       cqif.name            as fst_name,\n");
			sql.append("       cqif.score           as score_fstmax,\n");
			sql.append("      (case when cqt.id_mr='病案首页' ");
			sql.append("            then '病案首页' ");
			sql.append("            when cqt.id_mr !='病案首页'");
			sql.append("            then cm.id_mr");
			sql.append("      end)  as id_mr,");
			sql.append("      (case when cqt.id_mr='病案首页'");
			sql.append("            then '病案首页' ");
			sql.append("            when cqt.id_mr !='病案首页'");
			sql.append("            then  cm.name");
			sql.append("       end) as id_mr_name,");
			sql.append("       cqt.id_revision,\n"); 
			sql.append("       cqi.id_qa_itm,\n"); 
			sql.append("       cqi.once_drp_scr  once_drp_scr,\n"); 
			sql.append("       cqi.id_qa_drp_scr_tp   id_qa_drp_scr_tp,\n"); 
			sql.append("       cqi.max_drp_scr   max_drp_scr,\n");
			sql.append("       cqi.req           res,\n"); 
			sql.append("       cqi.deduct_des,\n"); 
			sql.append("       cqi.FG_SERIOUS as fg_serious,");
			sql.append("       cqt.deduct_scr_times  deduct_scr_times,\n"); 
			sql.append("       cqt.dt_sbmt,\n"); 
			sql.append("       cqt.id_sbmt_user,\n");  // 提出人
			sql.append("       su.name           sbmt_user_name,\n"); 
			sql.append("       cqt.rfm_des       rfm_req,\n"); 
			sql.append("       cqt.id_rfm_user,\n");  // 接收人
			sql.append("       su3.name           emp_submit_name,\n"); 
			sql.append("       cqt.id_rfm_dept,\n");  // 接收科室
			sql.append("       su2.name          submit_dept_name ,\n"); 
			sql.append("       cqt.id_qa_flt id_qaflt\n"); 
			sql.append("  FROM ci_qa_flt cqt\n"); 
			sql.append("  LEFT JOIN ci_qa_itm cqi\n"); 
			sql.append("    ON   cqt.id_qa_itm = cqi.id_qa_itm\n"); 
			sql.append("  left JOIN ci_mr cm\n"); 
			sql.append("    ON   cqt.id_mr = cm.id_mr\n"); 
			sql.append("  LEFT JOIN sys_user su\n"); 
			sql.append("    ON   cqt.id_sbmt_user = su.id_user\n"); 
			sql.append("  LEFT JOIN sys_user su3\n"); 
			sql.append("    ON   cqt.id_rfm_user = su3.id_user\n"); 
			sql.append("  LEFT JOIN bd_dep su2\n"); 
			sql.append("    ON   cqt.id_rfm_dept = su2.id_dep\n"); 
			sql.append("  LEFT JOIN bd_udidoc bu\n"); 
			sql.append("    ON   bu.id_udidoc = cqt.id_flt_sta\n"); 
			sql.append("  left join ci_qa_itm_fst cqif\n");
			sql.append("    on cqif.id_fst = cqi.id_fst\n");
			sql.append(" WHERE (1 = 1)\n"); 
			sql.append("   AND cqt.ds = '0'\n"); 
			sql.append("   AND cqt.id_revision = '"+id_revision+"'"); 
			sql.append("   AND cqt.id_flt_sta = '"+ICiMrDictCodeConst.ID_REFORM+"'\n"); 
			String sqlStr=sql.toString();
    	@SuppressWarnings("unchecked")
        List<QaFltDTO> listMr = (List<QaFltDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaFltDTO.class));
    	IQafltRService qafltRService=ServiceFinder.find(IQafltRService.class);
    	IUserRService userRService=ServiceFinder.find(IUserRService.class);
    	IDeptRService deptRService=ServiceFinder.find(IDeptRService.class); 
        for(QaFltDTO qafltdto:listMr){
        	if("病案首页".equals(qafltdto.getId_mr())){
        		QaFltDO qafltdo=qafltRService.findById(qafltdto.getId_qaflt());
        		qafltdto.setId_emp_submit(qafltdo.getId_rfm_user());
        		qafltdto.setId_submit_dept(qafltdo.getId_rfm_dept());
        		UserDO userDo=userRService.findById(qafltdo.getId_rfm_user());
        		DeptDO deptDo=deptRService.findById(qafltdo.getId_rfm_dept());
        		qafltdto.setEmp_submit_name(userDo.getName());      		
        		qafltdto.setSubmit_dept_name(deptDo.getName());
        	}
        }
        return (QaFltDTO[]) listMr.toArray(new QaFltDTO[0]);
	}
    /**
     * 获取对应类型以及自动质控的缺陷详情 包括各个状态
     * @param id_ent
     * @param sd_qctype
     * @return
     * @throws BizException
     */
	@Override
	public QaFltDTO[] getQcfltAndAutoFltDtos(String id_ent, String sd_qctype)
			throws BizException {
		MrQcGetFltDtoBP fltbp=new MrQcGetFltDtoBP();
		return fltbp.getQcfltAndAutoFltDtos(id_ent, sd_qctype);
	}
}