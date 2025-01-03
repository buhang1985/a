package iih.ci.mrqc.qapatlist.s;

import com.ymer.core.xml.StringUtils;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.s.bp.common.CiMrParamUtils;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import iih.ci.mrqc.qapatlist.i.IQaProcessQryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

@Service(serviceInterfaces = { IQaProcessQryService.class }, binding = Binding.JSONRPC)
public class IQaProcessQryServiceImpl extends PagingServiceImpl<QaPatListDTO> implements IQaProcessQryService {

	@Override
	public PagingRtnData<QaPatListDTO> getQaPatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo,String qaVer) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		//如果重构，需要 注意差异,查询数量
 		String countSelect = "(select count(1) from ci_qa_flt cqf where cqf.id_ent=ci_amr.id_ent "
 	 				+ "and cqf.id_qa_ty='"+ICiMrDictCodeConst.ID_EXEC_SEGMENT+"' and cqf.ds='0'  and cqf.id_revision !='~') as flt_times,\n";
 		String sqlWhere= " where "+sqlwhere+" and "
 		+EnvContextUtil.processEnvContext("",new AMrDO(),false)
 		+" and ci_amr.fg_seal = 'N' and ee.code_entp='"+IEnDictCodeConst.SD_ENTP_INPATIENT+"'";
 		if(qaVer!=null && ICiMrDictCodeConst.QA_VERSION_TWO.equals(qaVer))
 		{
 			//应该过滤在院，暂不做修改
 			sqlWhere +="  and ee.fg_ip = 'Y'";
 		}
 		else
 		{
 			sqlWhere += "  and ci_amr.ID_QA_DOCTOR_PART_STA='"+ICiMrDictCodeConst.ID_MR_WRITING+"'";
 		}
 		String sqlOrder=  "order by  ee.dt_acpt desc" ;
 		StringBuilder sql = getCommonQrySql(countSelect,sqlWhere,sqlOrder);	 			
 		String sqlStr=sql.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(new QaPatListDTO(), paginationInfo, sqlStr, "", null);	
		CiMrParamUtils util = new CiMrParamUtils();
 		String param = util.GetSysParaMrTreeControl(Context.get().getOrgId());
		FArrayList pageData = pagingRtnData.getPageData();
		for(Object data:pageData){
			QaPatListDTO patdto=(QaPatListDTO) data;
			int count=getMrQcCopies(patdto.getId_ent(),param);
			patdto.setQc_copies(count);
		}
		return pagingRtnData;
	}

	/**
	*  待科室质控列表 条件 病案状态 完成书写，2.0版本过滤在院
	*/
	@Override
	public PagingRtnData<QaPatListDTO> getDeptQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo,String qaVer) throws BizException {
		// TODO Auto-generated method stub
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		//如果重构，需要 注意差异,查询数量
        String countSelect = "(select count(1) from ci_qa_flt cqf where cqf.id_ent=ci_amr.id_ent and cqf.id_qa_ty = '"
 		+ICiMrDictCodeConst.ID_EXEC_DEPARTMENT+"' and cqf.ds='0' and cqf.id_revision !='~') as flt_times,\n";
 		String sqlWhere= " where "+sqlwhere+" and "
 		+EnvContextUtil.processEnvContext("",new AMrDO(),false)
 		+" and ci_amr.fg_seal = 'N' and ee.code_entp='"+IEnDictCodeConst.SD_ENTP_INPATIENT+"'";
 		 
 		if(qaVer!=null && ICiMrDictCodeConst.QA_VERSION_TWO.equals(qaVer))
 		{
 			//应该过滤在院，暂不做修改
 			sqlWhere +="  and ee.fg_ip = 'Y' and ee.ID_DEP_PHY = '"+ Context.get().getDeptId()+"'";
 		}
 		else
 		{
 			sqlWhere += "  and ci_amr.ID_QA_DOCTOR_PART_STA='"+ICiMrDictCodeConst.ID_MR_COMWRITE+"'";
 		}
 		String sqlOrder=  "order by  ee.dt_acpt desc" ;
 		StringBuilder sql = getCommonQrySql(countSelect,sqlWhere,sqlOrder);	
 		String sqlStr=sql.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(new QaPatListDTO(), paginationInfo, sqlStr, "", null);
		CiMrParamUtils util = new CiMrParamUtils();
 		String param = util.GetSysParaMrTreeControl(Context.get().getOrgId());
		FArrayList pageData = pagingRtnData.getPageData();
		for(Object data:pageData){
			QaPatListDTO patdto=(QaPatListDTO) data;
			int count=getMrQcCopies(patdto.getId_ent(),param);
			patdto.setQc_copies(count);
		}
		return pagingRtnData;
	}
	/**
	*  待科室评分列表 条件 病案状态 已科室质控
	*/
	@Override
	public PagingRtnData<QaPatListDTO> getDeptQcScorePatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException {
		
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		StringBuilder sql = new StringBuilder();
 		sql.append("       SELECT ee.id_ent,\n");
 		sql.append("       ci_amr.fg_process_qa as fg_process_qa,\n"); 
 		sql.append("       ci_amr.id_enhr as id_amr,\n"); 
 		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA,\n"); 
 		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA,\n"); 
 		sql.append("       ee.id_pat as id_pat,\n");
 		sql.append("       ee.name_pat as pat_name,\n"); 
 		sql.append("       ee.code as ent_code,\n");
 		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
 		sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");
 		sql.append("         THEN  '未知的性别'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '1'\n"); 
 		sql.append("          THEN  '男'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '2'\n"); 
 		sql.append("          THEN  '女'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '9'\n"); 
 		sql.append("         THEN  '未说明性别'\n"); 
 		sql.append("       end) as sex_name,");
 		//sql.append("       ci_amr.pat_age as pat_age,\n");
 		sql.append("       ci_amr.code_amr_ip as hospital_code,\n");
 		sql.append("       ee.code_entp as code_entp,\n"); 
 		sql.append("       eei.id_inpatient,\n"); 
 		sql.append("       eei.name_bed as bed_code,\n"); 
 		sql.append("       ee.id_dep_phy as id_dep_phy,\n"); 
 		sql.append("       bd.name dep_phy_name,\n"); 
 		sql.append("       ee.dt_acpt as dt_acpt,\n"); 
 		sql.append("       ee.dt_end as dt_end,\n"); 
 		sql.append("       eed.id_entdi,\n"); 
 		sql.append("       ci_amr.id_enhr,\n"); 
 		sql.append("       ci_amr.score_dept_qa as score_dept,\n"); 
 		sql.append("       ci_amr.score_terminal_qa as score_terminal,\n"); 
 		sql.append("       eed.name_didef_dis as name_di,\n"); 
 		sql.append("       ee.id_emp_phy as id_emp_phy,\n"); 
 		sql.append("       su.name emp_phy_name,\n"); 
 		sql.append("       ci_amr.id_emp_process_qa as id_emp_qa,\n"); 
 		sql.append("       su2.name emp_qa_name\n"); 
 		sql.append("       FROM ci_amr ci_amr\n"); 
 		sql.append("       INNER JOIN en_ent ee\n"); 
 		sql.append("       ON ci_amr.id_ent = ee.id_ent\n"); 
 		sql.append("       INNER JOIN en_ent_ip eei\n"); 
 		sql.append("       ON ee.id_ent = eei.id_ent\n"); 
 		sql.append("       left join en_ent_di eed\n"); 
 		sql.append("       ON eed.id_ent = ee.id_ent\n"); 
 		sql.append("       AND eed.fg_maj = 'Y'\n"); 
 		sql.append("       INNER JOIN bd_dep bd\n"); 
 		sql.append("       ON ee.id_dep_phy = bd.id_dep\n"); 
 		sql.append("       LEFT JOIN sys_user su\n"); 
 		sql.append("       ON ee.id_emp_phy = su.id_psn and su.id_psn<>'~'\n"); 
 		sql.append("       LEFT JOIN sys_user su2\n"); 
 		sql.append("       ON ci_amr.id_emp_process_qa = su2.id_user"); 
 		sql.append("       WHERE "+sqlwhere+" and "+EnvContextUtil.processEnvContext("",new AMrDO(),false)+" and ci_amr.fg_seal = 'N' and ee.code_entp='"+IEnDictCodeConst.SD_ENTP_INPATIENT+"'  and ci_amr.ID_QA_DOCTOR_PART_STA='"+ICiMrDictCodeConst.ID_MR_COMDEPTQC+"'");
 		sql.append("       order by  ee.dt_acpt desc" );
 		String sqlStr=sql.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(new QaPatListDTO(), paginationInfo, sqlStr, "", null);

		return pagingRtnData;
	}
	/**
	*  终末待签收列表 条件 病案状态 已科室评分
	*/
	@Override
	public PagingRtnData<QaPatListDTO> getTerminalQcSignOffPatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo)throws BizException {
			
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		StringBuilder sql = new StringBuilder();
 		sql.append("      SELECT ee.id_ent,\n");
 		sql.append("       ci_amr.fg_process_qa as fg_process_qa,\n"); 
 		sql.append("       ci_amr.id_enhr as id_amr,\n"); 
 		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA,\n"); 
 		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA,\n"); 
 		sql.append("       ci_amr.reason_deptqc_back,\n"); 
 		sql.append("       ci_amr.reason_terminaltqc_back,\n"); 
 		sql.append("       ee.id_pat as id_pat,\n");
 		sql.append("       ee.name_pat as pat_name,\n"); 
 		sql.append("       ee.code as ent_code,\n");
 		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
 		sql.append("      (CASE WHEN ee.sd_sex_pat= '0'\n");
 		sql.append("         THEN  '未知的性别'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '1'\n"); 
 		sql.append("         THEN  '男'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '2'\n"); 
 		sql.append("         THEN  '女'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '9'\n"); 
 		sql.append("          THEN  '未说明性别'\n"); 
 		sql.append("       end) as sex_name,");
 		//sql.append("       ci_amr.pat_age as pat_age,\n"); 
 		sql.append("       ci_amr.code_amr_ip as hospital_code,\n"); 
 		sql.append("       ee.code_entp as code_entp,\n"); 
 		sql.append("       eei.id_inpatient,\n"); 
 		sql.append("       eei.name_bed as bed_code,\n"); 
 		sql.append("       ee.id_dep_phy as id_dep_phy,\n"); 
 		sql.append("       bd.name dep_phy_name,\n"); 
 		sql.append("       ee.dt_acpt as dt_acpt,\n"); 
 		sql.append("       ee.dt_end as dt_end,\n"); 
 		sql.append("       eed.id_entdi,\n"); 
 		sql.append("       ci_amr.id_enhr,\n"); 
 		sql.append("       ci_amr.score_dept_qa as score_dept,\n"); 
 		sql.append("       ci_amr.score_terminal_qa as score_terminal,\n"); 
 		sql.append("       eed.name_didef_dis as name_di,\n"); 
 		sql.append("       ee.id_emp_phy as id_emp_phy,\n"); 
 		sql.append("       su.name emp_phy_name,\n"); 
 		sql.append("       ci_amr.id_emp_process_qa as id_emp_qa,\n"); 
 		sql.append("       su2.name emp_qa_name\n"); 
 		sql.append("       FROM ci_amr ci_amr\n"); 
 		sql.append("       INNER JOIN en_ent ee\n"); 
 		sql.append("       ON ci_amr.id_ent = ee.id_ent\n"); 
 		sql.append("       INNER JOIN en_ent_ip eei\n"); 
 		sql.append("       ON ee.id_ent = eei.id_ent\n"); 
 		sql.append("       left join en_ent_di eed\n"); 
 		sql.append("       ON eed.id_ent = ee.id_ent\n"); 
 		sql.append("       AND eed.fg_maj = 'Y'\n"); 
 		sql.append("       INNER JOIN bd_dep bd\n"); 
 		sql.append("       ON ee.id_dep_phy = bd.id_dep\n"); 
 		sql.append("       LEFT JOIN sys_user su\n"); 
 		sql.append("       ON ee.id_emp_phy = su.id_psn and su.id_psn<>'~'\n"); 
 		sql.append("       LEFT JOIN sys_user su2\n"); 
 		sql.append("       ON ci_amr.id_emp_process_qa = su2.id_user"); 
 		sql.append("       WHERE "+sqlwhere+" and "+EnvContextUtil.processEnvContext("",new AMrDO(),false)+" and ci_amr.fg_seal = 'N' and ee.code_entp='"+IEnDictCodeConst.SD_ENTP_INPATIENT+"'  and ci_amr.ID_QA_DOCTOR_PART_STA='"+ICiMrDictCodeConst.ID_MR_COMDEPTSCORE+"'"); 
 		sql.append("       order by  ee.dt_acpt desc" );
 		String sqlStr=sql.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(new QaPatListDTO(), paginationInfo, sqlStr, "", null);

		return pagingRtnData;
	}
	/**
	*  待终末质控列表 条件 病案状态 已签收
	*/
	@Override
	public PagingRtnData<QaPatListDTO> getTerminalQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo,String qaVer) throws BizException {
		// TODO Auto-generated method stub
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}		
 		//如果重构，需要 注意差异,查询数量
// 		String countSelect = "(select count(1) from ci_qa_flt cqf where cqf.id_ent=ci_amr.id_ent and cqf.id_qa_ty in ('"
// 		+ICiMrDictCodeConst.ID_EXEC_END+"','"+ICiMrDictCodeConst.ID_EXEC_AUTOMATIC+"' ) and cqf.id_flt_sta in ('"
// 				+ICiMrDictCodeConst.ID_REFORM+"','"+ICiMrDictCodeConst.ID_HAS_REFORM+"') and (cqf.id_revision is not null and cqf.id_revision <>'~')  and cqf.ds='0' ) as flt_times,\n";
 		String sqlWhere= " where "+sqlwhere+" and "
 		+EnvContextUtil.processEnvContext("",new AMrDO(),false)
 		+" and ci_amr.fg_seal = 'N' and ee.code_entp='"+IEnDictCodeConst.SD_ENTP_INPATIENT+"'";
 		if(qaVer!=null && ICiMrDictCodeConst.QA_VERSION_TWO.equals(qaVer))
 		{
 			//应该过滤在院，暂不做修改
 			sqlWhere +="  and ee.fg_ip = 'N'";
 		}
 		else
 		{
 			sqlWhere += " and ci_amr.SD_QA_DOCTOR_PART_STA<>'"+ICiMrDictCodeConst.SD_MR_WRITING+"' and ci_amr.fg_terminal_qa = 'N'";
 		}
 		String sqlOrder=  "order by  ee.dt_acpt desc" ;
 		StringBuilder sql = getCommonQrySql("",sqlWhere,sqlOrder);
 		String sqlStr=sql.toString();
 		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(new QaPatListDTO(), paginationInfo, sqlStr, "", null);

 		FArrayList list = pagingRtnData.getPageData();
		if(list==null || list.size()<=0) return pagingRtnData;
		for(int i=0;i<list.size();i++){
			QaPatListDTO dto=(QaPatListDTO)list.get(i);
			int number=getDefectNum(dto.getId_ent());		
			dto.setFlt_times(number);						
		} 		
		CiMrParamUtils util = new CiMrParamUtils();
		String param = util.GetSysParaMrTreeControl(Context.get().getOrgId());
		for(Object data:list){
			QaPatListDTO patdto=(QaPatListDTO) data;
			int count=getMrQcCopies(patdto.getId_ent(),param);
			patdto.setQc_copies(count);
		}
		return pagingRtnData;
	}
	
	// 获取缺陷数
    public int getDefectNum(String id_ent) throws BizException{
    	DAFacade daf = new DAFacade();
		String strSql ="select count(1) from ci_qa_flt cqf where cqf.id_qa_ty in ('" +ICiMrDictCodeConst.ID_EXEC_END+"','"+ICiMrDictCodeConst.ID_EXEC_AUTOMATIC+"' ) "
				+ "and cqf.id_flt_sta in ('"+ICiMrDictCodeConst.ID_REFORM+"','"+ICiMrDictCodeConst.ID_HAS_REFORM+"') "
				+ "and (cqf.id_revision is not null and cqf.id_revision <>'~')  and cqf.ds='0' "
				+" and cqf.id_ent = ? ";
		SqlParam sp = new SqlParam();
		sp.addParam(id_ent);
		int number =  (int) daf.execQuery(strSql,sp, new ColumnHandler());	
	    return number;
    }

	/**
	*  待终末评分患者列表 条件 病案状态 终末质控
	*/
	@Override
	public PagingRtnData<QaPatListDTO> getTerminalQcScorePatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo)throws BizException {
			
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		StringBuilder sql = new StringBuilder();
 		sql.append("       SELECT ee.id_ent,\n");
 		sql.append("       ci_amr.fg_process_qa as fg_process_qa,\n"); 
 		sql.append("       ci_amr.id_enhr as id_amr,\n"); 
 		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA,\n"); 
 		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA,\n"); 
 		sql.append("       ee.id_pat as id_pat,\n");
 		sql.append("       ee.name_pat as pat_name,\n"); 
 		sql.append("       ee.code as ent_code,\n");
 		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
 		sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");
 		sql.append("          THEN  '未知的性别'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '1'\n"); 
 		sql.append("          THEN  '男'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '2'\n"); 
 		sql.append("          THEN  '女'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '9'\n"); 
 		sql.append("         THEN  '未说明性别'\n"); 
 		sql.append("       end) as sex_name,");
 		//sql.append("       ci_amr.pat_age as pat_age,\n"); 
 		sql.append("       ci_amr.code_amr_ip as hospital_code,\n"); 
 		sql.append("       ee.code_entp as code_entp,\n"); 
 		sql.append("       eei.id_inpatient,\n"); 
 		sql.append("       eei.name_bed as bed_code,\n"); 
 		sql.append("       ee.id_dep_phy as id_dep_phy,\n"); 
 		sql.append("       bd.name dep_phy_name,\n"); 
 		sql.append("       ee.dt_acpt as dt_acpt,\n"); 
 		sql.append("       ee.dt_end as dt_end,\n"); 
 		sql.append("       eed.id_entdi,\n"); 
 		sql.append("       ci_amr.id_enhr,\n");
 		sql.append("       ci_amr.score_dept_qa as score_dept,\n"); 
 		sql.append("       ci_amr.score_terminal_qa as score_terminal,\n"); 
 		sql.append("       eed.name_didef_dis as name_di,\n"); 
 		sql.append("       ee.id_emp_phy as id_emp_phy,\n"); 
 		sql.append("       su.name emp_phy_name,\n"); 
 		sql.append("       ci_amr.id_emp_process_qa as id_emp_qa,\n"); 
 		sql.append("       su2.name emp_qa_name\n"); 
 		sql.append("       FROM ci_amr ci_amr\n"); 
 		sql.append("       INNER JOIN en_ent ee\n"); 
 		sql.append("       ON ci_amr.id_ent = ee.id_ent\n"); 
 		sql.append("       INNER JOIN en_ent_ip eei\n"); 
 		sql.append("       ON ee.id_ent = eei.id_ent\n"); 	
 		sql.append("       left join en_ent_di eed\n"); 
 		sql.append("       ON eed.id_ent = ee.id_ent\n"); 
 		sql.append("       AND eed.fg_maj = 'Y'\n"); 
 		sql.append("       INNER JOIN bd_dep bd\n"); 
 		sql.append("       ON ee.id_dep_phy = bd.id_dep\n"); 
 		sql.append("       LEFT JOIN sys_user su\n"); 
 		sql.append("       ON ee.id_emp_phy = su.id_psn and su.id_psn<>'~'\n"); 
 		sql.append("       LEFT JOIN sys_user su2\n"); 
 		sql.append("       ON ci_amr.id_emp_process_qa = su2.id_user"); 
 		sql.append("       WHERE "+sqlwhere+" and "+EnvContextUtil.processEnvContext("",new AMrDO(),false)+" and ci_amr.fg_seal = 'N' and ee.code_entp='"+IEnDictCodeConst.SD_ENTP_INPATIENT+"'  and ci_amr.ID_QA_DOCTOR_PART_STA='"+ICiMrDictCodeConst.ID_MR_COMTERMINALQC+"'"); 
 		sql.append("       order by  ee.dt_acpt desc" );			
 		String sqlStr=sql.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(new QaPatListDTO(), paginationInfo, sqlStr, "", null);
		
		return pagingRtnData;
	}
	/**
	 * 内涵质控患者列表
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<QaPatListDTO> getConnonationQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		StringBuilder sql = new StringBuilder();
 		sql.append("       SELECT ee.id_ent,\n");
 		sql.append("       ci_amr.fg_process_qa as fg_process_qa,\n"); 
 		sql.append("       ci_amr.id_enhr as id_amr,\n"); 
 		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA,\n"); 
 		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA,\n"); 
 		sql.append("       ci_amr.reason_deptqc_back,\n"); 
 		sql.append("       ci_amr.reason_terminaltqc_back,\n"); 
 		sql.append("       ee.id_pat as id_pat,\n");
 		sql.append("       ee.name_pat as pat_name,\n"); 
 		sql.append("       ee.code as ent_code,\n");
 		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
 		sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");
 		sql.append("          THEN  '未知的性别'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '1'\n"); 
 		sql.append("          THEN  '男'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '2'\n"); 
 		sql.append("          THEN  '女'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '9'\n"); 
 		sql.append("          THEN  '未说明性别'\n"); 
 		sql.append("       end) as sex_name,");
 		sql.append("       ci_amr.code_amr_ip as hospital_code,\n"); 
 		sql.append("       ee.code_entp as code_entp,\n"); 
 		sql.append("       eei.id_inpatient,\n"); 
 		sql.append("       eei.name_bed as bed_code,\n"); 
 		sql.append("       ee.id_dep_phy as id_dep_phy,\n"); 
 		sql.append("       bd.name dep_phy_name,\n"); 
 		sql.append("       ee.dt_acpt as dt_acpt,\n"); 
 		sql.append("       ee.dt_end as dt_end,\n"); 
 		sql.append("       enemp_zy.id_emp as id_emp_zydoc,\n"); 
 		sql.append("       enemp_zz.id_emp as id_emp_zzdoc,\n"); 
 		sql.append("       enemp_zr.id_emp as id_emp_zrdoc,\n"); 
 		sql.append("       ci_amr.score_dept_qa as score_dept,\n"); 
 		sql.append("       ci_amr.score_terminal_qa as score_terminal,\n"); 
 		sql.append("       ee.id_emp_phy as id_emp_phy,\n"); 
 		sql.append("       su.name emp_phy_name\n"); 
 		sql.append("       FROM ci_amr ci_amr\n"); 
 		sql.append("       INNER JOIN en_ent ee\n"); 
 		sql.append("       ON ci_amr.id_ent = ee.id_ent\n"); 
 		sql.append("       INNER JOIN en_ent_ip eei\n"); 
 		sql.append("       ON ee.id_ent = eei.id_ent\n"); 
 		sql.append("       INNER JOIN bd_dep bd\n"); 
 		sql.append("       ON ee.id_dep_phy = bd.id_dep\n"); 
 		sql.append("       LEFT JOIN sys_user su\n"); 
 		sql.append("       ON ee.id_emp_phy = su.id_psn and su.id_psn<>'~'\n"); 
 		sql.append("       LEFT JOIN en_ent_emp enemp_zy\n"); 
 		sql.append("       ON enemp_zy.id_ent = ee.id_ent and enemp_zy.sd_emprole='"+IEnDictCodeConst.SD_EMPROLE_ZYDOC+"'"); 
 		sql.append("       LEFT JOIN en_ent_emp enemp_zz\n"); 
 		sql.append("       ON enemp_zz.id_ent = ee.id_ent and enemp_zz.sd_emprole='"+IEnDictCodeConst.SD_EMPROLE_ZZDOC+"'"); 
 		sql.append("       LEFT JOIN en_ent_emp enemp_zr\n"); 
 		sql.append("       ON enemp_zr.id_ent = ee.id_ent and enemp_zr.sd_emprole='"+IEnDictCodeConst.SD_EMPROLE_ZRDOC+"'"); 
 		sql.append("       WHERE "+sqlwhere+" and "+EnvContextUtil.processEnvContext("",new AMrDO(),false)+" and ci_amr.fg_seal = 'N' and ee.code_entp='"+IEnDictCodeConst.SD_ENTP_INPATIENT+"'  and ci_amr.ID_QA_DOCTOR_PART_STA='"+ICiMrDictCodeConst.ID_MR_COMWRITE+"'"); 
 		sql.append("       order by  ee.dt_acpt desc" );
 		String sqlStr=sql.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(new QaPatListDTO(), paginationInfo, sqlStr, "", null);

		return pagingRtnData;
	}
	@Override
	public PagingRtnData<QaPatListDTO> getInterQaPatListRandomDTOList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo,String qaVer)
			throws BizException {
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		String search = service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		StringBuilder sql = new StringBuilder();//查询方案条件拼接
 		String sqlCountWhere = "";//随机数量
 		if (search != null && search.length() > 0) {
			String[] searchList = search.replace("(", "").replace(")", "").split("AND");
			for (int i = 0; i < searchList.length; i++) {
				if (searchList[i].contains("times_random")) {
					String[] count=searchList[i].split("=");
					if(null!=count && count.length==2){
						sqlCountWhere = " where rownum <= "+count[1]+" ";
					}
				}else if(!searchList[i].contains("fg_random")){
					sql.append(" and " + searchList[i]);
				} 
			}
		}
		
		//如果重构，需要 注意差异,查询数量
		String countSelect = "(select count(1) from ci_qa_flt cqf where cqf.id_ent=ci_amr.id_ent "
	 				+ "and cqf.id_qa_ty='"+ICiMrDictCodeConst.ID_EXEC_SEGMENT+"' and cqf.ds='0'  and cqf.id_revision !='~') as flt_times,\n";
		
 		//随机查询的语句
 		String sqlWhere= " where 1=1  "+sql.toString()+" and "
 		+EnvContextUtil.processEnvContext("",new AMrDO(),false)
 		+" and ci_amr.fg_seal = 'N' and ee.code_entp='"+IEnDictCodeConst.SD_ENTP_INPATIENT+"'";
 		if(qaVer!=null && ICiMrDictCodeConst.QA_VERSION_TWO.equals(qaVer))
 		{
 			//应该过滤在院，暂不做修改
 			sqlWhere +="  and ee.fg_ip = 'Y'";
 		}
 		else
 		{
 			sqlWhere += "  and ci_amr.ID_QA_DOCTOR_PART_STA='"+ICiMrDictCodeConst.ID_MR_WRITING+"'";
 		}
 		StringBuilder sqlSel = getCommonRandomQrySql(countSelect,sqlWhere,sqlCountWhere);
 		String sqlStr=sqlSel.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(new QaPatListDTO(), paginationInfo, sqlStr, "", null);
		CiMrParamUtils util = new CiMrParamUtils();
 		String param = util.GetSysParaMrTreeControl(Context.get().getOrgId());
		FArrayList pageData = pagingRtnData.getPageData();
		for(Object data:pageData){
			QaPatListDTO patdto=(QaPatListDTO) data;
			int count=getMrQcCopies(patdto.getId_ent(),param);
			patdto.setQc_copies(count);
		}
		return pagingRtnData;
	}

	@Override
	public PagingRtnData<QaPatListDTO> getTerminalRandomQcPatListDTOList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo,String qaVer)
			throws BizException {
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		String search = service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		StringBuilder sql = new StringBuilder();//查询方案条件拼接
 		String sqlCountWhere = "";//随机数量
 		if (search != null && search.length() > 0) {
			String[] searchList = search.replace("(", "").replace(")", "").split("AND");
			for (int i = 0; i < searchList.length; i++) {
				if (searchList[i].contains("times_random")) {
					String[] count=searchList[i].split("=");
					if(null!=count && count.length==2){
						sqlCountWhere = " where rownum <= "+count[1]+" ";
					}
				}else if(!searchList[i].contains("fg_random")){
					sql.append(" and " + searchList[i]);
				} 
			}
		}
 		
		//如果重构，需要 注意差异,查询数量
		/*String countSelect = "(select count(1) from ci_qa_flt cqf where cqf.id_ent=ci_amr.id_ent and cqf.id_qa_ty in ('"
 		+ICiMrDictCodeConst.ID_EXEC_END+"','"+ICiMrDictCodeConst.ID_EXEC_AUTOMATIC+"' )  and cqf.id_flt_sta in ('"
 				+ICiMrDictCodeConst.ID_REFORM+"','"+ICiMrDictCodeConst.ID_HAS_REFORM+"')  and (cqf.id_revision is not null and cqf.id_revision <>'~') and cqf.ds='0' ) as flt_times,\n";*/

 		//随机查询的语句
 		String sqlWhere= " where 1=1  "+sql.toString()+" and "
 		+EnvContextUtil.processEnvContext("",new AMrDO(),false)
 		+" and ci_amr.fg_seal = 'N' and ee.code_entp='"+IEnDictCodeConst.SD_ENTP_INPATIENT+"'";
 		if(qaVer!=null && ICiMrDictCodeConst.QA_VERSION_TWO.equals(qaVer))
 		{
 			//应该过滤在院，暂不做修改
 			sqlWhere +="  and ee.fg_ip = 'N' ";
 		}
 		else
 		{
 			sqlWhere += "  and ci_amr.SD_QA_DOCTOR_PART_STA<>'"+ICiMrDictCodeConst.SD_MR_WRITING+"' and ci_amr.fg_terminal_qa = 'N'";
 		}
 		StringBuilder sqlSel = getCommonRandomQrySql("",sqlWhere,sqlCountWhere);
 		String sqlStr=sqlSel.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(new QaPatListDTO(), paginationInfo, sqlStr, "", null);
		FArrayList list = pagingRtnData.getPageData();
		if(list==null || list.size()<=0) return pagingRtnData;
		for(int i=0;i<list.size();i++){
			QaPatListDTO dto=(QaPatListDTO)list.get(i);
			int number=getDefectNum(dto.getId_ent());		
			dto.setFlt_times(number);						
		} 	
		CiMrParamUtils util = new CiMrParamUtils();
		String param = util.GetSysParaMrTreeControl(Context.get().getOrgId());
		for(Object data:list){
			QaPatListDTO patdto=(QaPatListDTO) data;
			int count=getMrQcCopies(patdto.getId_ent(),param);
			patdto.setQc_copies(count);
		}
		return pagingRtnData;
	}
	
	
	public PagingRtnData<QaPatListDTO> getDeptRandomQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo,String qaVer)
			throws BizException {
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		String search = service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		StringBuilder sql = new StringBuilder();//查询方案条件拼接
 		String sqlCountWhere = "";//随机数量
 		if (search != null && search.length() > 0) {
			String[] searchList = search.replace("(", "").replace(")", "").split("AND");
			for (int i = 0; i < searchList.length; i++) {
				if (searchList[i].contains("times_random")) {
					String[] count=searchList[i].split("=");
					if(null!=count && count.length==2){
						sqlCountWhere = " where rownum <= "+count[1]+" ";
					}
				}else if(!searchList[i].contains("fg_random")){
					sql.append(" and " + searchList[i]);
				} 
			}
		}
		
		//如果重构，需要 注意差异,查询数量
		 String countSelect = "(select count(1) from ci_qa_flt cqf where cqf.id_ent=ci_amr.id_ent and cqf.id_qa_ty = '"
			 		+ICiMrDictCodeConst.ID_EXEC_DEPARTMENT+"' and cqf.ds='0' and cqf.id_revision !='~') as flt_times,\n";	
 		
 		//随机查询的语句
 		String sqlWhere= " where 1=1  "+sql.toString()+" and "
 		+EnvContextUtil.processEnvContext("",new AMrDO(),false)
 		+" and ci_amr.fg_seal = 'N' and ee.code_entp='"+IEnDictCodeConst.SD_ENTP_INPATIENT+"'  and ee.ID_DEP_PHY = '"+ Context.get().getDeptId()+"'";
 		if(qaVer!=null && ICiMrDictCodeConst.QA_VERSION_TWO.equals(qaVer))
 		{
 			//应该过滤在院，暂不做修改
 			sqlWhere +="  and ee.fg_ip = 'Y'and ee.ID_DEP_PHY = '"+ Context.get().getDeptId()+"'";
 		}
 		else
 		{
 			sqlWhere += "  and ci_amr.ID_QA_DOCTOR_PART_STA='"+ICiMrDictCodeConst.ID_MR_WRITING+"'";
 		}
 		StringBuilder sqlSel = getCommonRandomQrySql(countSelect,sqlWhere,sqlCountWhere);
 		String sqlStr=sqlSel.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(new QaPatListDTO(), paginationInfo, sqlStr, "", null);
		CiMrParamUtils util = new CiMrParamUtils();
 		String param = util.GetSysParaMrTreeControl(Context.get().getOrgId());
		FArrayList pageData = pagingRtnData.getPageData();
		for(Object data:pageData){
			QaPatListDTO patdto=(QaPatListDTO) data;
			int count=getMrQcCopies(patdto.getId_ent(),param);
			patdto.setQc_copies(count);
		}
		return pagingRtnData;	
	}
	
	
	public PagingRtnData<QaPatListDTO> GetConnonationQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException {
		// TODO Auto-generated method stub
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		StringBuilder sql = new StringBuilder();
 		sql.append("       SELECT ee.id_ent,\n");
 		sql.append("       mrcon.fg_connonationqc as Fg_connonation,\n"); 
 		sql.append("       ci_amr.fg_process_qa as fg_process_qa,\n"); 
 		sql.append("       ci_amr.id_enhr as id_amr,\n"); 
 		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA,\n"); 
 		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA,\n"); 
 		sql.append("       ci_amr.reason_deptqc_back,\n"); 
 		sql.append("       ci_amr.reason_terminaltqc_back,\n"); 
 		sql.append("       ee.id_pat as id_pat,\n");
 		sql.append("       ee.name_pat as pat_name,\n"); 
 		sql.append("       ee.code as ent_code,\n");
 		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
 		sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");
 		sql.append("          THEN  '未知的性别'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '1'\n"); 
 		sql.append("          THEN  '男'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '2'\n"); 
 		sql.append("          THEN  '女'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '9'\n"); 
 		sql.append("          THEN  '未说明性别'\n"); 
 		sql.append("       end) as sex_name,");
 		//sql.append("       ci_amr.pat_age as pat_age,\n"); 
 		sql.append("       ci_amr.code_amr_ip as hospital_code,\n"); 
 		sql.append("       ee.code_entp as code_entp,\n"); 
 		sql.append("       eei.id_inpatient,\n"); 
 		sql.append("       eei.name_bed as bed_code,\n"); 
 		sql.append("       ee.id_dep_phy as id_dep_phy,\n"); 
 		sql.append("       bd.name dep_phy_name,\n"); 
 		sql.append("       ee.dt_acpt as dt_acpt,\n"); 
 		sql.append("       ee.dt_end as dt_end,\n"); 
 		sql.append("       eed.id_entdi,\n"); 
 		sql.append("       ci_amr.id_enhr,\n"); 
 		sql.append("       ci_amr.score_dept_qa as score_dept,\n"); 
 		sql.append("       ci_amr.score_terminal_qa as score_terminal,\n"); 
 		sql.append("       eed.name_didef_dis as name_di,\n"); 
 		sql.append("       ee.id_emp_phy as id_emp_phy,\n"); 
 		sql.append("       su.name emp_phy_name,\n"); 
 		sql.append("       ci_amr.id_emp_process_qa as id_emp_qa,\n"); 
 		sql.append("       su2.name emp_qa_name\n"); 
 		sql.append("       FROM ci_amr ci_amr\n"); 
 		sql.append("       INNER JOIN en_ent ee\n"); 
 		sql.append("       ON ci_amr.id_ent = ee.id_ent\n");                                           
 		sql.append("       INNER JOIN en_ent_ip eei\n"); 
 		sql.append("       ON ee.id_ent = eei.id_ent\n"); 
 		sql.append("       left join en_ent_di eed\n"); 
 		sql.append("       ON eed.id_ent = ee.id_ent\n"); 
 		sql.append("       AND eed.fg_maj = 'Y'\n"); 
 		sql.append("       left JOIN ci_mr_qc_conno mrcon\n"); 
 		sql.append("       ON mrcon.id_amr = ci_amr.id_enhr\n");  
 		sql.append("       INNER JOIN bd_dep bd\n"); 
 		sql.append("       ON ee.id_dep_phy = bd.id_dep\n"); 
 		sql.append("       LEFT JOIN sys_user su \n"); 
 		sql.append("       ON ee.id_emp_phy = su.id_psn and su.id_psn<>'~'\n"); 
 		sql.append("       LEFT JOIN sys_user su2\n"); 
 		sql.append("       ON ci_amr.id_emp_process_qa = su2.id_user"); 
 		sql.append("       WHERE "+sqlwhere+" and "+EnvContextUtil.processEnvContext("",new AMrDO(),false)+" and ci_amr.fg_seal = 'N' and ee.code_entp='"+IEnDictCodeConst.SD_ENTP_INPATIENT+"'  and ci_amr.ID_QA_DOCTOR_PART_STA='"+ICiMrDictCodeConst.ID_MR_COMWRITE+"'"); 
 		sql.append("       order by  ee.dt_acpt desc" );
 		String sqlStr=sql.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(new QaPatListDTO(), paginationInfo, sqlStr, "", null);

		return pagingRtnData;
	}
	/**
	 * 获得质控查询语句
	 * @param sqlWhere
	 * @param sqlOrder
	 * @return
	 */
	private StringBuilder getCommonQrySql(String countSelect,String sqlWhere,String sqlOrder)
	{
		StringBuilder sql = new StringBuilder();
 		sql.append("       SELECT ee.id_ent,\n");
 		sql.append("       ci_amr.fg_process_qa as fg_process_qa,\n"); 
 		sql.append("       ci_amr.fg_dept_qa as fg_dept_qa,\n");
 		sql.append("       ci_amr.fg_terminal_qa as fg_terminal_qa,\n");
 		sql.append("       ci_amr.id_enhr as id_amr,\n"); 
 		sql.append("       ci_amr.score_qa_ty as score_process,\n");
 		sql.append("       ci_amr.name_divide_level as levelnew,\n");
 		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA,\n"); 
 		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA,\n"); 
 		sql.append("       ci_amr.reason_deptqc_back,\n"); 
 		sql.append("       ci_amr.reason_terminaltqc_back,\n"); 
 		sql.append("       ee.id_pat as id_pat,\n");
 		sql.append("       ee.name_pat as pat_name,\n"); 
 		sql.append("       ee.code as ent_code,\n");
 		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
 		sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");
 		sql.append("          THEN  '未知的性别'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '1'\n"); 
 		sql.append("          THEN  '男'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '2'\n"); 
 		sql.append("          THEN  '女'\n"); 
 		sql.append("        WHEN ee.sd_sex_pat= '9'\n"); 
 		sql.append("          THEN  '未说明性别'\n"); 
 		sql.append("       end) as sex_name,");
 		sql.append("       ci_amr.pat_age as pat_age,\n"); 
 		sql.append("       ci_amr.code_amr_ip as hospital_code,\n"); 
 		sql.append("       pp.code as pat_code,\n"); 
 		sql.append("       ee.code_entp as code_entp,\n"); 
 		sql.append("       eei.id_inpatient,\n"); 
 		sql.append("       eei.name_bed as bed_code,\n"); 
 		sql.append("       ee.id_dep_phy as id_dep_phy,\n");  		
 		sql.append("       bd.name dep_phy_name,\n"); 
 		sql.append("       bd2.name dep_pat,\n");
 		sql.append("       ee.dt_acpt as dt_acpt,\n");
 		sql.append("       ee.dt_end as dt_end,\n"); 
 		sql.append("       eed.id_entdi,\n"); 
 		sql.append("       ci_amr.id_enhr,\n"); 
 		sql.append("       ci_amr.score_dept_qa as score_dept,\n"); 
 		sql.append("       ci_amr.score_terminal_qa as score_terminal,\n"); 
 	    //sql.append(countSelect);
 		sql.append("       eed.name_didef_dis as name_di,\n"); 
 		sql.append("       ee.id_emp_phy as id_emp_phy,\n"); 
 		  
 	  	sql.append("       su.id_user as id_emp_submit,\n"); 
 	    sql.append("       su.name as emp_submit_name,\n");
 	    
 		sql.append("       su.name emp_phy_name,\n"); 
 		sql.append("       ci_amr.id_emp_process_qa as id_emp_qa,\n"); 
 		sql.append("       su2.name emp_qa_name\n"); 
 		sql.append("       FROM ci_amr ci_amr\n"); 
 		sql.append("       INNER JOIN en_ent ee\n"); 
 		sql.append("       ON ci_amr.id_ent = ee.id_ent\n"); 
 		sql.append("       INNER JOIN en_ent_ip eei\n"); 
 		sql.append("       ON ee.id_ent = eei.id_ent\n"); 
 		sql.append("       left join en_ent_di eed\n"); 
 		sql.append("       ON eed.id_ent = ee.id_ent\n"); 
 		sql.append("       AND eed.fg_maj = 'Y'\n"); 
 		sql.append("       INNER JOIN bd_dep bd\n"); 
 		sql.append("       ON ee.id_dep_phy = bd.id_dep\n"); 
 		sql.append("       INNER JOIN bd_dep bd2\n" );
 		sql.append("       ON ee.id_dep_nur = bd2.id_dep\n" ); 
 		sql.append("       LEFT JOIN sys_user su\n"); 
 		sql.append("       ON ee.id_emp_phy = su.id_psn and su.id_psn<>'~'\n"); 
 		sql.append("       LEFT JOIN sys_user su2\n"); 
 		sql.append("       ON ci_amr.id_emp_process_qa = su2.id_user ");
 		sql.append("       LEFT JOIN pi_pat pp\n"); 
 		sql.append("       ON pp.id_pat = ee.id_pat ");
 		sql.append(sqlWhere);
 		sql.append(" "+sqlOrder);
 		return sql;
	}
	/**
	 * 获取随机查询sql
	 * @param countSelect
	 * @param sqlRdmWhere 内部随机查询语句
	 * @param sqlOrder
	 * @return
	 */
	private StringBuilder getCommonRandomQrySql(String countSelect,String sqlRdmWhere,String sqlCountWhere)
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append("select *\n");
 		sql.append("  from (  select distinct * from(    SELECT ee.id_ent,\n");
		sql.append("       ci_amr.fg_process_qa as fg_process_qa,\n");
		sql.append("       ci_amr.fg_terminal_qa as fg_terminal_qa,\n");
 		sql.append("       ci_amr.name_divide_level as levelnew,\n");
 		sql.append("       ci_amr.score_qa_ty as score_process,\n");
 		sql.append("       ci_amr.fg_dept_qa as fg_dept_qa,\n"); 
 		sql.append("       ci_amr.id_enhr as id_amr,\n");
 		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA,\n");
 		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA,\n");
 		sql.append("       ee.id_pat as id_pat,\n");
 		sql.append("       ee.name_pat as pat_name,\n");
 		sql.append("       ee.code as ent_code,\n");
 		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
 		sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");
 		sql.append("          THEN  '未知的性别'\n" );
 		sql.append("        WHEN ee.sd_sex_pat= '1'\n" );
 		sql.append("          THEN  '男'\n" );
 		sql.append("        WHEN ee.sd_sex_pat= '2'\n" );
 		sql.append("          THEN  '女'\n" ); 
 		sql.append("        WHEN ee.sd_sex_pat= '9'\n" );
 		sql.append("          THEN  '未说明性别'\n" ); 
 		sql.append("       end) as sex_name,");
 		sql.append("       ci_amr.pat_age as pat_age,\n" );
 		sql.append("       ci_amr.code_amr_ip as hospital_code,\n" );
 		sql.append("       ci_amr.code_amr_ip as code_amr_ip,\n" );
 		sql.append("       ee.code_entp as code_entp,\n" );
 		sql.append("       pp.code as pat_code,\n" );
 		sql.append("       eei.id_inpatient,\n" );
 		sql.append("       eei.name_bed as bed_code,\n" );
 		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
 		sql.append("       bd.name dep_phy_name,\n");
 		sql.append("       bd2.name dep_pat,\n");
 		sql.append("       ee.dt_acpt as dt_acpt,\n" );
 		sql.append("       ee.dt_end as dt_end,\n");
 		//sql.append(countSelect);
 		sql.append("       eed.name_didef_dis as name_di,\n" );
 		sql.append("       ee.id_emp_phy as id_emp_phy,\n" );
		sql.append("       su.id_user as id_emp_submit,\n"); 
 	    sql.append("       su.name as emp_submit_name,\n");	 
 		sql.append("       su.name emp_phy_name,\n" );
 		sql.append("       ci_amr.id_emp_process_qa as id_emp_qa,\n" );
 		sql.append("       su2.name emp_qa_name\n" );
 		sql.append("       FROM ci_amr ci_amr\n" );
 		sql.append("       INNER JOIN en_ent ee\n" );
 		sql.append("       ON ci_amr.id_ent = ee.id_ent\n" );
 		sql.append("       INNER JOIN en_ent_ip eei\n" );
 		sql.append("       ON ee.id_ent = eei.id_ent\n" );
 		sql.append("       left join en_ent_di eed\n" );
 		sql.append("       ON eed.id_ent = ee.id_ent\n" );
 		sql.append("       AND eed.fg_maj = 'Y'\n" );
 		sql.append("       left join ci_mr ci_mr\n" );
 		sql.append("       on ci_mr.id_ent = ci_amr.id_ent and ci_amr.code_entp='"+IEnDictCodeConst.SD_ENTP_INPATIENT+"'\n" );
 		sql.append("       left join bd_mrca_ctm bd_mrca_ctm\n" );
 		sql.append("       on bd_mrca_ctm.id_mrcactm = ci_mr.id_mrcactm\n" );
 		//sql.append("       left join ci_mr_qc_record_itm record_itm\n" );
 		//sql.append("       on record_itm.id_ent=ee.id_ent\n" );
 		sql.append("       INNER JOIN bd_dep bd\n" );
 		sql.append("       ON ee.id_dep_phy = bd.id_dep\n" ); 
 		sql.append("       INNER JOIN bd_dep bd2\n" );
 		sql.append("       ON ee.id_dep_nur = bd2.id_dep\n" ); 
 		sql.append("       LEFT JOIN sys_user su\n" );
 		sql.append("       ON ee.id_emp_phy = su.id_psn and su.id_psn<>'~'\n" );
 		sql.append("       LEFT JOIN sys_user su2\n" );
 		sql.append("       ON ci_amr.id_emp_process_qa = su2.id_user ");
 		sql.append("       LEFT JOIN pi_pat pp\n" );
 		sql.append("       ON pp.id_pat = ee.id_pat ");
 		sql.append(sqlRdmWhere);		
		sql.append("    ) order by dbms_random.value())\n");
	
 		
 		sql.append(" "+sqlCountWhere);
 		return sql;
	}
	
	
	// 可质控病历份数
    public int getMrQcCopies(String id_ent,String param) throws BizException
    {
    	String sqlWhere =" where id_ent='"+id_ent+"' ";
    	if(!StringUtils.isEmptyWithTrim(param)){
    		sqlWhere +=" and id_su_mr in ( ";
        	String[] split = param.split(",");
        	String str="";
        	for(int i=0;i<split.length;i++){
        		if(i==split.length-1){
        			str+="'"+split[i]+"')";
        		}else{
        			str+="'"+split[i]+"',";
        		}
        	}
        	sqlWhere +=str;
    	}
    	
    	DAFacade daf = new DAFacade();  
    	StringBuilder sql = new StringBuilder();
		sql.append("select count(1) from ci_mr  ");
		sql.append(sqlWhere);	
		String sqlStr=sql.toString();
        int count = (int)daf.execQuery(sqlStr, new ColumnHandler());
        return count;
    }
}
	
