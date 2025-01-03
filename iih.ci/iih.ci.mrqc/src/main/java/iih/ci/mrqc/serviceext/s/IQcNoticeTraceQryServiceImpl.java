package iih.ci.mrqc.serviceext.s;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.s.bp.common.CiMrParamUtils;
import iih.ci.mrqc.dto.rfmnotice.d.QaNoticeDTO;
import iih.ci.mrqc.qcremindmsgdto.s.bp.QcMsgGetPsnBp;
import iih.ci.mrqc.serviceext.i.IQcNoticeTraceQryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces={IQcNoticeTraceQryService.class}, binding=Binding.JSONRPC)
public class IQcNoticeTraceQryServiceImpl extends PagingServiceImpl<QaNoticeDTO> implements IQcNoticeTraceQryService{

	@Override
	public PagingRtnData<QaNoticeDTO> getIntermediateQcCorrectNoticeDtos(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo,String id_revision)
			throws BizException {
		 /**
		 *  质控整改实现代码
		 */		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		if(id_revision!=null)
 		{
 			sqlwhere += " and cqrn.id_revision ='"+id_revision+"'";
 		}
 		
 		CiMrParamUtils util=new CiMrParamUtils();
 		Boolean isFlag=util.GetSysParamMrQcMsgToPsns(Context.get().getOrgId());
 		String userStr="";
 		//当参数开启时
 		if(isFlag){
 			userStr=getGroupUserIdStr(Context.get().getUserId(),Context.get().getDeptId());
 		}

	    	StringBuilder sql = new StringBuilder();

				sql.append("select cqrn.id_status id_status,\n");
				sql.append("bu.name status_name,\n");
				sql.append("       cqrn.dt_send,\n"); 
				sql.append("       cqrn.id_exec_doctor,\n"); 
				sql.append("       cqrn.id_dead_apply_status,\n");
				sql.append("       cqrn.dead_apply_reason,\n");
				sql.append("       su.name exec_doctor_name,\n"); 
				sql.append("       cqrn.id_exec_dept,\n"); 
				sql.append("       bd.name exec_dept_name,\n"); 
				sql.append("       cqrn.id_ent,\n"); 
				sql.append("       cqrn.id_revision,\n"); 
				sql.append("       ee.name_pat,\n"); 
				sql.append("       (select count(1)\n"); 
				sql.append("          from ci_qa_flt cqf\n"); 
				sql.append("         where cqf.id_revision = cqrn.id_revision\n"); 
				//sql.append("           and cqf.id_rfm_user = '"+ Context.get().getUserId() + "'\n"); 
				//sql.append("           and cqf.id_rfm_dept = '"+Context.get().getDeptId()+ "'\n");
				sql.append("           and cqf.sd_flt_sta='"+ICiMrDictCodeConst.SD_REFORM+"'\n"); 
				sql.append("        ) deduct_times,\n"); 
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
		 		sql.append("  left join sys_user su2\n"); 
		 		sql.append("       on ee.id_emp_phy = su2.id_psn\n");
				sql.append("  left join ci_amr amr\n"); 
				sql.append("    on amr.id_ent = cqrn.id_ent\n"); 
				sql.append(" where "+sqlwhere+"\n"); 
//				sql.append(" and exists (select *\n"); 
//				sql.append("          from ci_qa_flt cqf\n"); 
//				sql.append("         where cqf.id_revision = cqrn.id_revision and amr.fg_seal = 'N'  \n"); 
//				sql.append("           and cqf.id_rfm_user = '"+ Context.get().getUserId() + "'\n"); 
////				sql.append("           and cqf.id_rfm_dept = '"+id_rfm_dept + "'\n"); 
//				sql.append("           and cqf.id_qa_ty in ( '"+ICiMrDictCodeConst.ID_EXEC_SEGMENT+"','"+ICiMrDictCodeConst.ID_EXEC_AUTOMATIC+"')\n"); 
//				sql.append("           AND cqf.ds = '0')\n"); 
				if(isFlag){
					sql.append("   and ( cqrn.id_rfm_doctor in ("+userStr+") \n"); 
		 		}else{
		 			sql.append("   and ( cqrn.id_rfm_doctor = '"+Context.get().getUserId()+"' \n"); 
		 		}
				sql.append("     or  su2.id_user='"+Context.get().getUserId()+"' )\n"); 
				sql.append("   and cqrn.id_qa_ty in ( '"+ICiMrDictCodeConst.ID_EXEC_SEGMENT+"')\n"); 
				sql.append("   and cqrn.id_rfm_dept = '"+Context.get().getDeptId()+"'\n"); 
//				sql.append("   and (cqrn.id_status = '"+ICiDictCodeConst.ID_TO_REFORM+"' or\n"); 
//				sql.append("       cqrn.id_status = '"+ICiDictCodeConst.ID_RECTIFICATION+"')");
				sql.append("   order by cqrn.sd_status,cqrn.dt_send desc");
	    
		 		String sqlStr=sql.toString();
				PagingRtnData<QaNoticeDTO> pagingRtnData = super.findByPageInfo(new QaNoticeDTO(), paginationInfo, sqlStr, "", null);
				
				return pagingRtnData;
	}

	@Override
	public PagingRtnData<QaNoticeDTO> getDeptQcCorrectNoticeDtos(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo,String id_revision) throws BizException {
		 /**
		 *  科室整改实现代码
		 */
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		if(id_revision!=null)
 		{
 			sqlwhere += " and cqrn.id_revision ='"+id_revision+"'";
 		}
 		CiMrParamUtils util=new CiMrParamUtils();
 		Boolean isFlag=util.GetSysParamMrQcMsgToPsns(Context.get().getOrgId());
 		String userStr="";
 		//当参数开启时
 		if(isFlag){
 			userStr=getGroupUserIdStr(Context.get().getUserId(),Context.get().getDeptId());
 		}
 		
	    	StringBuilder sql = new StringBuilder();
	    	sql.append("select cqrn.id_status id_status,\n");
			sql.append("bu.name status_name,\n");
				sql.append("       cqrn.dt_send,\n"); 
				sql.append("       cqrn.id_exec_doctor,\n"); 
				sql.append("       su.name exec_doctor_name,\n"); 
				sql.append("       cqrn.id_exec_dept,\n"); 
				sql.append("       bd.name exec_dept_name,\n"); 
				sql.append("       cqrn.id_ent,\n"); 
				sql.append("       cqrn.id_revision,\n"); 
				sql.append("       cqrn.Id_dead_apply_status,\n"); 
				sql.append("       cqrn.sd_dead_apply_status,\n"); 
				sql.append("       ee.name_pat,\n"); 
				sql.append("       (select count(1)\n"); 
				sql.append("          from ci_qa_flt cqf\n"); 
				sql.append("         where cqf.id_revision = cqrn.id_revision\n"); 
				//sql.append("           and cqf.id_rfm_user = '"+ Context.get().getUserId() + "'\n"); 
				//sql.append("           and cqf.id_rfm_dept = '"+Context.get().getDeptId()+ "'\n");
				sql.append("           and cqf.sd_flt_sta='"+ICiMrDictCodeConst.SD_REFORM+"'\n"); 
				sql.append("        ) deduct_times,\n"); 
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
				sql.append("  left join sys_user su2\n"); 
		 		sql.append("       on ee.id_emp_phy = su2.id_psn\n");
				sql.append("  left join ci_amr amr\n"); 
				sql.append("    on amr.id_ent = cqrn.id_ent\n"); 
				sql.append(" where "+sqlwhere+"\n"); 
//				sql.append(" and exists (select *\n"); 
//				sql.append("          from ci_qa_flt cqf\n"); 
//				sql.append("         where cqf.id_revision = cqrn.id_revision and amr.fg_seal='N' \n"); 
//				sql.append("           and cqf.id_rfm_user = '"+ Context.get().getUserId() + "'\n"); 
////				sql.append("           and cqf.id_rfm_dept = '"+id_rfm_dept + "'\n"); 
//				sql.append("           and cqf.id_qa_ty in ( '"+ICiMrDictCodeConst.ID_EXEC_DEPARTMENT+"','"+ICiMrDictCodeConst.ID_EXEC_AUTOMATIC+"')\n"); 
//				sql.append("           AND cqf.ds = '0')\n"); 
				if(isFlag){
					sql.append("   and ( cqrn.id_rfm_doctor in ("+userStr+") \n"); 
		 		}else{
		 			sql.append("   and ( cqrn.id_rfm_doctor = '"+Context.get().getUserId()+"' \n"); 
		 		}
				sql.append("     or  su2.id_user='"+Context.get().getUserId()+"' )\n"); 
				sql.append("   and cqrn.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_DEPARTMENT+"'\n"); 
				sql.append("   and cqrn.id_rfm_dept = '"+Context.get().getDeptId()+"'\n"); 
//				sql.append("   and (cqrn.id_status = '"+ICiDictCodeConst.ID_TO_REFORM+"' or\n"); 
//				sql.append("       cqrn.id_status = '"+ICiDictCodeConst.ID_RECTIFICATION+"')");
				sql.append("   order by cqrn.sd_status,cqrn.dt_send desc");

		 		String sqlStr=sql.toString();
				PagingRtnData<QaNoticeDTO> pagingRtnData = super.findByPageInfo(new QaNoticeDTO(), paginationInfo, sqlStr, "", null);

				return pagingRtnData;
	}

	@Override
	public PagingRtnData<QaNoticeDTO> getTerminalQcCorrectNoticeDtos(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo,String id_revision) throws BizException {
		 /**
		 *  终末整改实现代码
		 */
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		if(id_revision!=null)
 		{
 			sqlwhere += " and cqrn.id_revision ='"+id_revision+"'";
 		}
 		CiMrParamUtils util=new CiMrParamUtils();
 		Boolean isFlag=util.GetSysParamMrQcMsgToPsns(Context.get().getOrgId());
 		String userStr="";
 		//当参数开启时
 		if(isFlag){
 			userStr=getGroupUserIdStr(Context.get().getUserId(),Context.get().getDeptId());
 		}
 		
	    	StringBuilder sql = new StringBuilder();
	    	sql.append("select cqrn.id_status id_status,\n");
			sql.append("bu.name status_name,\n");
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
				//sql.append("           and cqf.id_rfm_user = '"+ Context.get().getUserId() + "'\n"); 
				//sql.append("           and cqf.id_rfm_dept = '"+Context.get().getDeptId()+ "'\n");
				sql.append("           and cqf.sd_flt_sta='"+ICiMrDictCodeConst.SD_REFORM+"'\n"); 
				sql.append("        ) deduct_times,\n"); 
				sql.append("       cqrn.rfm_deadline,\n"); 
				sql.append("       cqrn.dt_deadline,\n"); 
				sql.append("       cqrn.Id_dead_apply_status,\n"); 
				sql.append("       cqrn.sd_dead_apply_status,\n"); 
				sql.append("       cqrn.des\n"); 
				sql.append("  from ci_qa_revision_notice cqrn\n"); 
				sql.append("  left join bd_dep bd\n"); 
				sql.append("    on bd.id_dep = cqrn.id_exec_dept\n"); 
				sql.append("  left join sys_user su\n"); 
				sql.append("    on cqrn.id_exec_doctor = su.id_user \n"); 
				sql.append("  left join bd_udidoc bu\n"); 
				sql.append("    on bu.id_udidoc = cqrn.id_status\n"); 
				sql.append("  left join en_ent ee\n"); 
				sql.append("    on ee.id_ent = cqrn.id_ent\n"); 
				sql.append("  left join sys_user su2\n"); 
		 		sql.append("       on ee.id_emp_phy = su2.id_psn\n");
				sql.append("  left join ci_amr amr\n"); 
				sql.append("    on amr.id_ent = cqrn.id_ent\n"); 
				sql.append(" where "+sqlwhere+"\n"); 
//				sql.append("  and exists (select *\n"); 
//				sql.append("          from ci_qa_flt cqf\n"); 
//				sql.append("         where cqf.id_revision = cqrn.id_revision and amr.fg_seal = 'N' \n"); 
//				sql.append("           and cqf.id_rfm_user = '"+Context.get().getUserId() + "'\n"); 
////				sql.append("           and cqf.id_rfm_dept = '"+id_rfm_dept + "' \n"); 
//				sql.append("           and cqf.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_END+"'\n"); 
//				sql.append("           AND cqf.ds = '0')\n"); 
				if(isFlag){
					sql.append("   and ( cqrn.id_rfm_doctor in ("+userStr+") \n"); 
		 		}else{
		 			sql.append("   and ( cqrn.id_rfm_doctor = '"+Context.get().getUserId()+"' \n"); 
		 		}
				sql.append("     or  su2.id_user='"+Context.get().getUserId()+"' )\n"); 
				sql.append("   and cqrn.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_END+"'\n"); 
				sql.append("   and cqrn.id_rfm_dept = '"+Context.get().getDeptId()+"'\n"); 
//				sql.append("   and (cqrn.id_status = '"+ICiDictCodeConst.ID_TO_REFORM+"' or\n"); 
//				sql.append("       cqrn.id_status = '"+ICiDictCodeConst.ID_RECTIFICATION+"')");
				sql.append("   order by cqrn.sd_status,cqrn.dt_send desc");

		 		String sqlStr=sql.toString();
				PagingRtnData<QaNoticeDTO> pagingRtnData = super.findByPageInfo(new QaNoticeDTO(), paginationInfo, sqlStr, "", null);

				return pagingRtnData;
	}

	@Override
	public PagingRtnData<QaNoticeDTO> getIntermediateQcTraceDtos(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo,String id_revision)
			throws BizException {
			IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
	 		String sqlwhere = "1=1";
	 		if (qryRootNodeDTO!=null){
	 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
	 		}
            
	 		if(!StringUtil.isEmptyWithTrim(id_revision)){
	 			sqlwhere +=" and cqrn.id_revision='"+id_revision+"' ";
	 		}
	 		 		
			StringBuilder sql = new StringBuilder();
			sql.append("select cqrn.id_status as id_status,\n");
			sql.append("       bu.name as status_name,\n"); 
			sql.append("       cqrn.dt_send,\n"); 
			sql.append("       cqrn.id_rfm_doctor,\n"); 
			sql.append("       su.name as rfm_doctor_name,\n"); 
			sql.append("       bd.name as rfm_dept_name,\n"); 
			sql.append("       cqrn.id_revision,\n"); 
			sql.append("       cqrn.rfm_deadline,\n"); 
			sql.append("       (select count(*) from ci_qa_flt cqf where cqrn.id_revision = cqf.id_revision) as deduct_times,\n"); 
			sql.append("       cqrn.dt_deadline,\n"); 
			sql.append("       cqrn.des,\n"); 
			sql.append("       cqrn.id_ent,\n"); 
			sql.append("       cqrn.rfm_time,\n"); 
			sql.append("       ee.name_pat\n"); 
			sql.append("  from  CI_QA_REVISION_NOTICE cqrn\n"); 
			sql.append("  left join bd_udidoc bu\n"); 
			sql.append("  on bu.id_udidoc = cqrn.id_status\n"); 
			sql.append("  left join EN_ENT ee\n"); 
			sql.append("  on cqrn.id_ent = ee.id_ent\n"); 
			sql.append("  left join ci_amr amr\n"); 
			sql.append("  on cqrn.id_ent = amr.id_ent\n"); 
			sql.append("  left join sys_user su\n"); 
			sql.append("  on cqrn.id_rfm_doctor = su.id_user  and su.id_psn<>'~'\n"); 
			sql.append("  left join  bd_dep bd\n"); 
			sql.append("  on  cqrn.id_rfm_dept = bd.id_dep\n"); 
			sql.append("       WHERE "+sqlwhere+" and amr.fg_seal='N' and ");
			sql.append("    cqrn.id_exec_doctor = '"+ Context.get().getUserId() + "'");
			sql.append("   and cqrn.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_SEGMENT+"'\n");
			sql.append("   AND cqrn.ds = '0'\n"); 
			sql.append("   order by cqrn.sd_status,cqrn.dt_send desc");

	 		String sqlStr=sql.toString();
			PagingRtnData<QaNoticeDTO> pagingRtnData = super.findByPageInfo(new QaNoticeDTO(), paginationInfo, sqlStr, "", null);

			return pagingRtnData;
	}

	@Override
	public PagingRtnData<QaNoticeDTO> getDeptQcTraceDtos(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}

			StringBuilder sql = new StringBuilder();
			sql.append("select cqrn.id_status as id_status,\n");
			sql.append("       bu.name as status_name,\n"); 
			sql.append("       cqrn.dt_send,\n"); 
			sql.append("       cqrn.id_rfm_doctor,\n"); 
			sql.append("       su.name as rfm_doctor_name,\n"); 
			sql.append("       bd.name as rfm_dept_name,\n"); 
			sql.append("       cqrn.id_revision,\n"); 
			sql.append("       cqrn.rfm_deadline,\n"); 
			sql.append("       (select count(*) from ci_qa_flt cqf where cqrn.id_revision = cqf.id_revision) as deduct_times,\n"); 
			sql.append("       cqrn.dt_deadline,\n"); 
			sql.append("       cqrn.des,\n"); 
			sql.append("       cqrn.id_ent,\n"); 
			sql.append("       cqrn.rfm_time,\n"); 
			sql.append("       ee.name_pat\n"); 
			sql.append("  from  CI_QA_REVISION_NOTICE cqrn\n"); 
			sql.append("  left join bd_udidoc bu\n"); 
			sql.append("  on bu.id_udidoc = cqrn.id_status\n"); 
			sql.append("  left join EN_ENT ee\n"); 
			sql.append("  on cqrn.id_ent = ee.id_ent\n"); 
			sql.append("  left join ci_amr amr\n"); 
			sql.append("  on cqrn.id_ent = amr.id_ent\n"); 
			sql.append("  left join sys_user su\n"); 
			sql.append("  on cqrn.id_rfm_doctor = su.id_user  and su.id_psn<>'~'\n"); 
			sql.append("  left join  bd_dep bd\n"); 
			sql.append("  on  cqrn.id_rfm_dept = bd.id_dep\n"); 
			sql.append("       WHERE "+sqlwhere+" and amr.fg_seal='N' and ");
			sql.append("    cqrn.id_exec_doctor = '"+ Context.get().getUserId() + "'");
			sql.append("   and cqrn.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_DEPARTMENT+"'\n");
			sql.append("   AND cqrn.ds = '0'\n"); 
			sql.append("   order by cqrn.sd_status,cqrn.dt_send desc");

	 		String sqlStr=sql.toString();
			PagingRtnData<QaNoticeDTO> pagingRtnData = super.findByPageInfo(new QaNoticeDTO(), paginationInfo, sqlStr, "", null);

			return pagingRtnData;
	}

	@Override
	public PagingRtnData<QaNoticeDTO> getTerminalQcTraceDtos(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}

			StringBuilder sql = new StringBuilder();
			sql.append("select cqrn.id_status as id_status,\n");
			sql.append("       bu.name as status_name,\n"); 
			sql.append("       cqrn.dt_send,\n"); 
			sql.append("       cqrn.id_rfm_doctor,\n"); 
			sql.append("       su.name as rfm_doctor_name,\n"); 
			sql.append("       bd.name as rfm_dept_name,\n"); 
			sql.append("       cqrn.id_revision,\n"); 
			sql.append("       cqrn.rfm_deadline,\n"); 
			sql.append("       (select count(*) from ci_qa_flt cqf where cqrn.id_revision = cqf.id_revision) as deduct_times,\n"); 
			sql.append("       cqrn.dt_deadline,\n"); 
			sql.append("       cqrn.des,\n"); 
			sql.append("       cqrn.id_ent,\n"); 
			sql.append("       cqrn.rfm_time,\n"); 
			sql.append("       ee.name_pat\n"); 
			sql.append("  from  CI_QA_REVISION_NOTICE cqrn\n"); 
			sql.append("  left join bd_udidoc bu\n"); 
			sql.append("  on bu.id_udidoc = cqrn.id_status\n"); 
			sql.append("  left join EN_ENT ee\n"); 
			sql.append("  on cqrn.id_ent = ee.id_ent\n"); 
			sql.append("  left join ci_amr amr\n"); 
			sql.append("  on cqrn.id_ent = amr.id_ent\n"); 
			sql.append("  left join sys_user su\n"); 
			sql.append("  on cqrn.id_rfm_doctor = su.id_user  and su.id_psn<>'~'\n"); 
			sql.append("  left join  bd_dep bd\n"); 
			sql.append("  on  cqrn.id_rfm_dept = bd.id_dep\n"); 
			sql.append("       WHERE "+sqlwhere+" and amr.fg_seal = 'N' and ");
			sql.append("    cqrn.id_exec_doctor = '"+ Context.get().getUserId() + "'");
			sql.append("   and cqrn.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_END+"'\n");
			sql.append("   AND cqrn.ds = '0'\n"); 
			sql.append("   order by cqrn.sd_status,cqrn.dt_send desc");

	 		String sqlStr=sql.toString();
			PagingRtnData<QaNoticeDTO> pagingRtnData = super.findByPageInfo(new QaNoticeDTO(), paginationInfo, sqlStr, "", null);

			return pagingRtnData;
	}
/*
 * 环节整改  超时申请 审批列表
 * */
	@Override
	public PagingRtnData<QaNoticeDTO> getDeadApplyQcNoticeDtos(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}

			StringBuilder sql = new StringBuilder();
			sql.append("select cqrn.id_dead_apply_status as id_dead_apply_status,\n");
			sql.append("       bu.name as dead_apply_status_name,\n"); 
			sql.append("       cqrn.dt_send,\n"); 
			sql.append("       cqrn.id_rfm_doctor,\n"); 
			sql.append("       su.name as rfm_doctor_name,\n"); 
			sql.append("       cqrn.id_rfm_dept,\n");
			sql.append("       bd.name as rfm_dept_name,\n"); 
			sql.append("       cqrn.id_revision,\n"); 
			sql.append("       cqrn.rfm_deadline,\n"); 
			sql.append("       cqrn.dt_deadline,\n"); 
			sql.append("       cqrn.des,\n"); 
			sql.append("       cqrn.id_ent,\n"); 
			sql.append("       cqrn.rfm_time,\n"); 
			sql.append("       cqrn.dead_apply_reason,\n"); 
			sql.append("       cqrn.dt_dead_apply,\n"); 
			sql.append("       cqrn.dead_callback_reason,\n"); 
			sql.append("       cqrn.dt_dead_agree\n"); 
			sql.append("  from  CI_QA_REVISION_NOTICE cqrn\n"); 
			sql.append("  left join bd_udidoc bu\n"); 
			sql.append("  on bu.id_udidoc = cqrn.id_dead_apply_status\n"); 
			sql.append("  left join sys_user su\n"); 
			sql.append("  on cqrn.id_rfm_doctor = su.id_user  and su.id_psn<>'~' \n"); 
			sql.append("  left join  bd_dep bd\n"); 
			sql.append("  on  cqrn.id_rfm_dept = bd.id_dep\n"); 
			sql.append("       WHERE "+sqlwhere+"  ");
			sql.append("   AND cqrn.id_dead_apply_status not in('~') \n"); 
			sql.append("   and cqrn.id_qa_ty in ( '"+ICiMrDictCodeConst.ID_EXEC_SEGMENT+"') \n"); 
			sql.append("   AND cqrn.ds = '0'\n"); 
			sql.append("   order by cqrn.sv desc");

	 		String sqlStr=sql.toString();
			PagingRtnData<QaNoticeDTO> pagingRtnData = super.findByPageInfo(new QaNoticeDTO(), paginationInfo, sqlStr, "", null);

			return pagingRtnData;
	}

	/**
	 * 科室整改 超时申请 审批列表
	 */
	@Override
	public PagingRtnData<QaNoticeDTO> getDeptDeadApplyQcNoticeDtos(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}

			StringBuilder sql = new StringBuilder();
			sql.append("select cqrn.id_dead_apply_status as id_dead_apply_status,\n");
			sql.append("       bu.name as dead_apply_status_name,\n"); 
			sql.append("       cqrn.dt_send,\n"); 
			sql.append("       cqrn.id_rfm_doctor,\n"); 
			sql.append("       su.name as rfm_doctor_name,\n"); 
			sql.append("       cqrn.id_rfm_dept,\n");
			sql.append("       bd.name as rfm_dept_name,\n"); 
			sql.append("       cqrn.id_revision,\n"); 
			sql.append("       cqrn.rfm_deadline,\n"); 
			sql.append("       cqrn.dt_deadline,\n"); 
			sql.append("       cqrn.des,\n"); 
			sql.append("       cqrn.id_ent,\n"); 
			sql.append("       cqrn.rfm_time,\n"); 
			sql.append("       cqrn.dead_apply_reason,\n"); 
			sql.append("       cqrn.dt_dead_apply,\n"); 
			sql.append("       cqrn.dead_callback_reason,\n"); 
			sql.append("       cqrn.dt_dead_agree\n"); 
			sql.append("  from  CI_QA_REVISION_NOTICE cqrn\n"); 
			sql.append("  left join bd_udidoc bu\n"); 
			sql.append("  on bu.id_udidoc = cqrn.id_dead_apply_status\n"); 
			sql.append("  left join sys_user su\n"); 
			sql.append("  on cqrn.id_rfm_doctor = su.id_user  and su.id_psn<>'~' \n"); 
			sql.append("  left join  bd_dep bd\n"); 
			sql.append("  on  cqrn.id_rfm_dept = bd.id_dep\n"); 
			sql.append("       WHERE "+sqlwhere+"  ");
			sql.append("   AND cqrn.id_dead_apply_status not in('~') \n"); 
			sql.append("   and cqrn.id_qa_ty in ( '"+ICiMrDictCodeConst.ID_EXEC_DEPARTMENT+"') \n"); 
			sql.append("   AND cqrn.ds = '0'\n"); 
			sql.append("   order by cqrn.sv desc");

	 		String sqlStr=sql.toString();
			PagingRtnData<QaNoticeDTO> pagingRtnData = super.findByPageInfo(new QaNoticeDTO(), paginationInfo, sqlStr, "", null);

			return pagingRtnData;
	}

	@Override
	public PagingRtnData<QaNoticeDTO> getTerminalDeadApplyQcNoticeDtos(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}

			StringBuilder sql = new StringBuilder();
			sql.append("select cqrn.id_dead_apply_status as id_dead_apply_status,\n");
			sql.append("       bu.name as dead_apply_status_name,\n"); 
			sql.append("       cqrn.dt_send,\n"); 
			sql.append("       cqrn.id_rfm_doctor,\n"); 
			sql.append("       su.name as rfm_doctor_name,\n"); 
			sql.append("       cqrn.id_rfm_dept,\n");
			sql.append("       bd.name as rfm_dept_name,\n"); 
			sql.append("       cqrn.id_revision,\n"); 
			sql.append("       cqrn.rfm_deadline,\n"); 
			sql.append("       cqrn.dt_deadline,\n"); 
			sql.append("       cqrn.des,\n"); 
			sql.append("       cqrn.id_ent,\n"); 
			sql.append("       cqrn.rfm_time,\n"); 
			sql.append("       cqrn.dead_apply_reason,\n"); 
			sql.append("       cqrn.dt_dead_apply,\n"); 
			sql.append("       cqrn.dead_callback_reason,\n"); 
			sql.append("       cqrn.dt_dead_agree\n"); 
			sql.append("  from  CI_QA_REVISION_NOTICE cqrn\n"); 
			sql.append("  left join bd_udidoc bu\n"); 
			sql.append("  on bu.id_udidoc = cqrn.id_dead_apply_status\n"); 
			sql.append("  left join sys_user su\n"); 
			sql.append("  on cqrn.id_rfm_doctor = su.id_user  and su.id_psn<>'~' \n"); 
			sql.append("  left join  bd_dep bd\n"); 
			sql.append("  on  cqrn.id_rfm_dept = bd.id_dep\n"); 
			sql.append("       WHERE "+sqlwhere+"  ");
			sql.append("   AND cqrn.id_dead_apply_status not in('~') \n"); 
			sql.append("   and cqrn.id_qa_ty in ( '"+ICiMrDictCodeConst.ID_EXEC_END+"') \n"); 
			sql.append("   AND cqrn.ds = '0'\n"); 
			sql.append("   order by cqrn.sv desc");

	 		String sqlStr=sql.toString();
			PagingRtnData<QaNoticeDTO> pagingRtnData = super.findByPageInfo(new QaNoticeDTO(), paginationInfo, sqlStr, "", null);

			return pagingRtnData;
	}
	
    /**
    *  当开启参数[质控整改消息发送病历创建人诊疗组]时，根据当前登录用户查询当前登录科室的所在医疗组用户
     * @throws BizException 
    */
	public String getGroupUserIdStr(String loginUserId,String loginDeptId) throws BizException{
		String userStr="";
		QcMsgGetPsnBp bp=new QcMsgGetPsnBp();
		List<String> userList=new ArrayList<String>();
		userList.add(loginUserId);
		List<String> list =bp.getUserIdToMsg(userList, loginDeptId);
		if(null!=list && list.size()>0){
			for (String string : list) {
				userStr=userStr+"'"+string+"',";
			}
		}
		userStr=userStr.substring(0, userStr.length()-1);
		return userStr;
	}
}
