package iih.ci.mrqc.qarecorddto.s;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.qarecorddto.d.QaRecordDTO;
import iih.ci.mrqc.qarecorddto.i.IQaProcessRecordQryService;
import iih.ci.mrqc.qared.d.QaRecordDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.permfw.pub.EnvContextUtil;

@Service(serviceInterfaces={IQaProcessRecordQryService.class}, binding=Binding.JSONRPC)
public class IQaProcessRecordQryServiceImpl extends PagingServiceImpl<QaRecordDTO> implements IQaProcessRecordQryService{

	@Override
	public PagingRtnData<QaRecordDTO> getIntermediateqcQryRecordList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException {
		// TODO Auto-generated method stub
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		StringBuilder sql = new StringBuilder();
		
				sql.append("       select ci_qa_record.dt_plan as dt_plan,\n" );
				sql.append("       ci_amr.code_amr_ip as code_hospital,\n" );
				sql.append("       ee.name_pat as name_pat,\n" );
				sql.append("       ee.id_ent as id_ent,\n" );
				sql.append("       eed.name_didef_dis as name_di,\n");
				sql.append("       cqrn.id_revision as id_revision,\n");
				sql.append("       cqrn.id_status as id_status,\n" );
				sql.append("       cqrn.des as res,\n"); 
				sql.append("       bu.name as status_name,\n" );
				sql.append("       (select count(*) from ci_qa_flt cqt where cqt.id_revision = cqrn.id_revision ) as deduct_times,\n" );
				sql.append("       ci_qa_record.id_exec_user as id_exec_user,\n" );
				sql.append("       su.name as exec_user_name,\n");
				sql.append("       ci_qa_record.id_exec_dept as id_exec_dept,\n" );
				sql.append("       bd.name as exec_dept_name\n" ); 
				sql.append("       from ci_qa_record ci_qa_record\n");
				sql.append("       inner join ci_amr ci_amr\n" );
				sql.append("       on ci_qa_record.id_ent=ci_amr.id_ent\n");
				sql.append("       left join ci_qa_revision_notice cqrn\n" );
				sql.append("       on ci_qa_record.id_qa=cqrn.id_qa_record ");
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
				sql.append("        where "+sqlwhere+" and "+EnvContextUtil.processEnvContext("",new QaRecordDO(),false)+" and  ee.code_entp='10'  and ee.fg_canc = 'N'  and ci_qa_record.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_SEGMENT+"'");
				String sqlStr=sql.toString();
		PagingRtnData<QaRecordDTO> pagingRtnData = super.findByPageInfo(new QaRecordDTO(), paginationInfo, sqlStr, "order by ci_qa_record.dt_plan desc", null);

		return pagingRtnData;
	}

	@Override
	public PagingRtnData<QaRecordDTO> getDeptqcQryRecordList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		// TODO Auto-generated method stub
				IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		 		String sqlwhere = "1=1";
		 		if (qryRootNodeDTO!=null){
		 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
		 		}
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
						sql.append("       ci_qa_record.id_exec_dept as id_exec_dept,\n" );
						sql.append("       bd.name as exec_dept_name,\n" ); 
						sql.append("       ci_qa_record.id_ent as id_ent\n" ); 
						sql.append("       from ci_qa_record ci_qa_record\n");
						sql.append("       inner join ci_amr ci_amr\n" );
						sql.append("       on ci_qa_record.id_ent=ci_amr.id_ent\n");
						sql.append("       left join ci_qa_revision_notice cqrn\n" );
						sql.append("       on ci_qa_record.id_qa=cqrn.id_qa_record ");
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
						sql.append("        where "+sqlwhere+" and  "+EnvContextUtil.processEnvContext("",new QaRecordDO(),false)+" and ee.code_entp='10'  and ee.fg_canc = 'N'  and ci_qa_record.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_DEPARTMENT+"'");
						String sqlStr=sql.toString();
				PagingRtnData<QaRecordDTO> pagingRtnData = super.findByPageInfo(new QaRecordDTO(), paginationInfo, sqlStr, "order by ci_qa_record.dt_plan desc", null);

				return pagingRtnData;
	}

	@Override
	public PagingRtnData<QaRecordDTO> getTerminalqcQryRecordList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		// TODO Auto-generated method stub
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
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
				sql.append("       ci_qa_record.id_exec_dept as id_exec_dept,\n" );
                sql.append("       ee.code_entp as code_entp,\n" );
				sql.append("       bd.name as exec_dept_name,\n" ); 
				sql.append("       ci_qa_record.id_ent as id_ent\n" ); 
				sql.append("       from ci_qa_record ci_qa_record\n");
				sql.append("       inner join ci_amr ci_amr\n" );
				sql.append("       on ci_qa_record.id_ent=ci_amr.id_ent\n");
				sql.append("       left join ci_qa_revision_notice cqrn\n" );
				sql.append("       on ci_qa_record.id_qa=cqrn.id_qa_record ");
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
				sql.append("        where "+sqlwhere+" and  "+EnvContextUtil.processEnvContext("",new QaRecordDO(),false)+" and ee.code_entp='10'  and ee.fg_canc = 'N' and ci_qa_record.fg_score ='N' and ci_qa_record.id_qa_ty = '"+ICiMrDictCodeConst.ID_EXEC_END+"'");
				String sqlStr=sql.toString();
		PagingRtnData<QaRecordDTO> pagingRtnData = super.findByPageInfo(new QaRecordDTO(), paginationInfo, sqlStr, "order by ci_qa_record.dt_plan desc", null);

		return pagingRtnData;
	}
//门诊质控记录查询
	@Override
	public PagingRtnData<QaRecordDTO> getOutqcQryRecordList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		// TODO Auto-generated method stub
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		StringBuilder sql = new StringBuilder();
		
				sql.append("       select ci_qa_record.dt_plan as dt_plan,\n" );
				sql.append("       ee.code as code_hospital,\n" );
				sql.append("       ee.name_pat as name_pat,\n" );
				sql.append("       ee.id_ent as id_ent,\n" );
				sql.append("       eed.name_didef_dis as name_di,\n");
				sql.append("       cqrn.id_revision as id_revision,\n");
				sql.append("       cqrn.id_status as id_status,\n" );
				sql.append("       cqrn.des as res,\n"); 
				sql.append("       bu.name as status_name,\n" );
				sql.append("       (select count(*) from ci_qa_flt cqt where cqt.id_revision = cqrn.id_revision ) as deduct_times,\n" );
				sql.append("       ci_qa_record.id_exec_user as id_exec_user,\n" );
				sql.append("       su.name as exec_user_name,\n");
				sql.append("       ci_qa_record.id_exec_dept as id_exec_dept,\n" );
				sql.append("       bd.name as exec_dept_name\n" ); 
				sql.append("       from ci_qa_record ci_qa_record\n");
				sql.append("       inner join ci_amr ci_amr\n" );
				sql.append("       on ci_qa_record.id_ent=ci_amr.id_ent\n");
				sql.append("       left join ci_qa_revision_notice cqrn\n" );
				sql.append("       on ci_qa_record.id_revision=cqrn.id_revision\n");
				sql.append("       left join en_ent ee\n" );
				sql.append("       on ci_qa_record.id_ent = ee.id_ent\n" );
				sql.append("       left join en_ent_di eed\n" );
				sql.append("       on ci_qa_record.id_ent = eed.id_ent\n" );
//				sql.append("       AND eed.fg_maj = 'Y'\n" );
				sql.append("       left join bd_psndoc su\n" );
				sql.append("       on su.id_psndoc=ci_qa_record.id_exec_user\n" );
				sql.append("       left join bd_dep bd\n" );
				sql.append("       on bd.id_dep=ci_qa_record.id_exec_dept\n" );
				sql.append("       left join bd_udidoc bu\n"  );
				sql.append("       on bu.id_udidoc = cqrn.id_status" );
				sql.append("        where "+sqlwhere+" and "+EnvContextUtil.processEnvContext("",new QaRecordDO(),false)+" and  ci_qa_record.sd_qa_ty = '"+ICiMrDictCodeConst.SD_EXEC_OUTQC+"'");
				String sqlStr=sql.toString();
		PagingRtnData<QaRecordDTO> pagingRtnData = super.findByPageInfo(new QaRecordDTO(), paginationInfo, sqlStr, "order by ci_qa_record.dt_plan desc", null);

		return pagingRtnData;
	}
}
