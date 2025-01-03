package iih.ci.mrqc.cimrrecallapplydto.s;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mr.i.ICiMrParamService;
import iih.ci.mrqc.cimrrecallapplydto.d.CiMrReCallApplyDTO;
import iih.ci.mrqc.cimrrecallapplydto.i.ICiMrReCallApplyService;
import iih.ci.mrqc.recallapply.d.ReCallApplyDO;
import iih.ci.mrqc.recallapply.i.IRecallapplyCudService;
import iih.ci.mrqc.recallapply.i.IRecallapplyRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces={ICiMrReCallApplyService.class}, binding=Binding.JSONRPC)
public class ICiMrReCallApplyServiceImpl extends PagingServiceImpl<CiMrReCallApplyDTO> implements ICiMrReCallApplyService {
	
	/**
	 * 病历科室召回申请查询
	 */
	public PagingRtnData<CiMrReCallApplyDTO> getCiMrDepReCallApplyDTOResult(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		// 查询方案解析
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		ICiMrParamService paramService = ServiceFinder.find(ICiMrParamService.class);
		// 获取当前组织id，查询参数，判断医务审核节点查询列表内容
		String orgId = Context.get().getOrgId();
		Boolean depParam = paramService.getSysParamDepReCall(orgId);
		Boolean medParam = paramService.getSysParamMedReCall(orgId);

		StringBuilder sqlWhere = new StringBuilder();
		
		if (medParam && !depParam) {
			sqlWhere.append(" where ci_recall_apply.sd_apply_status in ( ");
			sqlWhere.append(ICiMrDictCodeConst.SD_RECALL_APPLY_DEPSUBMIT);
			sqlWhere.append(" , ");
			sqlWhere.append(ICiMrDictCodeConst.SD_RECALL_APPLY_DEPREJECT);
			sqlWhere.append(" ) ");
		} else {
			sqlWhere.append(" where 1=1 ");
		}
		// 拼接查询方案的sql条件
 		if (qryRootNodeDTO != null){
 			sqlWhere.append(" and ");
 			sqlWhere.append(service.getQueryStringWithoutDesc(qryRootNodeDTO));
 		}
 		sqlWhere.append(" and ci_recall_apply.id_org='"+Context.get().getOrgId()+"' ");
 		// 根据申请时间倒序排序
 		sqlWhere.append(" order by ci_recall_apply.dt_apply desc "); 		
 		// 调用sql方法
 		StringBuilder sql = getCiMrDepReCallApplyDTOSql(sqlWhere.toString());
 		String sqlStr = sql.toString();
 		
		PagingRtnData<CiMrReCallApplyDTO> pagingRtnData = 
				super.findByPageInfo(new CiMrReCallApplyDTO(), paginationInfo, sqlStr, "", null);		
		return pagingRtnData;
	}
	/**
	 * 
	 * @param sqlWhere
	 * @return
	 */
	private StringBuilder getCiMrDepReCallApplyDTOSql(String sqlWhere) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ci_recall_apply.id_ent as id_ent, ");// 
		sql.append(" en_ent_ip.code_amr_ip as code_ent_ip, ");// 住院号
		sql.append(" ci_recall_apply.id_pat as id_pat, ");// 
		sql.append(" en_ent.name_pat as name_pat, ");// 
		sql.append(" en_ent.dt_acpt as dt_in, ");// 入院日期
		sql.append(" en_ent.dt_end as dt_out, ");// 出院日期
		sql.append(" ci_recall_apply.id_apply_status as id_apply_status, ");// 申请状态id
		sql.append(" ci_recall_apply.sd_apply_status as sd_apply_status, ");// 
		sql.append(" bd_udidoc.name as name_apply_status, ");// 
		sql.append(" ci_recall_apply.id_apply_user as id_apply_user, ");// 申请人id
		sql.append(" sys_user1.name as name_apply_user, ");// 
		sql.append(" ci_recall_apply.apply_reason as apply_reason, ");// 申请原因
		sql.append(" ci_recall_apply.dt_apply as dt_apply, ");// 申请日期
		sql.append(" ci_recall_apply.id_dep_agree_user as id_dep_agree_user, ");// 科室审核人id
		sql.append(" sys_user2.name as name_dep_agree_user, ");// 
		sql.append(" ci_recall_apply.dt_dep_agree as dt_dep_agree, ");// 
		sql.append(" ci_recall_apply.iscompleted as iscompleted, ");// 完成标志
		sql.append(" ci_recall_apply.id_recall_apply as id_recall_apply ");// 申请表主键
		sql.append(" from ci_recall_apply ci_recall_apply ");
		sql.append(" left join en_ent en_ent ");
		sql.append(" on ci_recall_apply.id_ent = en_ent.id_ent ");
		sql.append(" left join sys_user sys_user1 ");
		sql.append(" on ci_recall_apply.id_apply_user = sys_user1.id_user ");
		sql.append(" left join sys_user sys_user2 ");
		sql.append(" on ci_recall_apply.id_dep_agree_user = sys_user2.id_user ");
		sql.append(" left join bd_udidoc bd_udidoc ");
		sql.append(" on ci_recall_apply.id_apply_status = bd_udidoc.id_udidoc ");
		sql.append(" left join en_ent_ip en_ent_ip ");
		sql.append(" on en_ent.id_ent = en_ent_ip.id_ent ");
		sql.append(sqlWhere);
		
		return sql;
	}
	
	/**
	 * 病历医务召回申请查询
	 */
	public PagingRtnData<CiMrReCallApplyDTO> getCiMrMedReCallApplyDTOResult(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		// 查询方案解析
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		ICiMrParamService paramService = ServiceFinder.find(ICiMrParamService.class);
		// 获取当前组织id，查询参数，判断医务审核节点查询列表内容
		String orgId = Context.get().getOrgId();
		Boolean depParam = paramService.getSysParamDepReCall(orgId);
		Boolean medParam = paramService.getSysParamMedReCall(orgId);
		// 拼接查询sql条件
		StringBuilder sqlWhere = new StringBuilder();
		sqlWhere.append(" where ci_recall_apply.sd_apply_status in ( ");
		
		if (medParam && !depParam) {
			sqlWhere.append(ICiMrDictCodeConst.SD_RECALL_APPLY_UNSUBMIT);
			sqlWhere.append(" , ");
			sqlWhere.append(ICiMrDictCodeConst.SD_RECALL_APPLY_MEDSUBMIT);
			sqlWhere.append(" , ");
			sqlWhere.append(ICiMrDictCodeConst.SD_RECALL_APPLY_MEDREJECT);
			sqlWhere.append(" ) ");
		} else {
			sqlWhere.append(ICiMrDictCodeConst.SD_RECALL_APPLY_DEPSUBMIT);
			sqlWhere.append(" , ");
			sqlWhere.append(ICiMrDictCodeConst.SD_RECALL_APPLY_MEDSUBMIT);
			sqlWhere.append(" , ");
			sqlWhere.append(ICiMrDictCodeConst.SD_RECALL_APPLY_MEDREJECT);
			sqlWhere.append(" ) ");
		}
		// 拼接查询方案的sql条件
 		if (qryRootNodeDTO != null){
 			sqlWhere.append(" and ");
 			sqlWhere.append(service.getQueryStringWithoutDesc(qryRootNodeDTO));
 		}
 		sqlWhere.append(" and ci_recall_apply.id_org='"+Context.get().getOrgId()+"' ");
 		// 根据申请时间倒序排序
 		sqlWhere.append(" order by ci_recall_apply.dt_apply desc ");
 		// 调用sql方法
 		StringBuilder sql = getCiMrMedReCallApplyDTOSql(sqlWhere.toString());
 		String sqlStr = sql.toString();
 		
		PagingRtnData<CiMrReCallApplyDTO> pagingRtnData = 
				super.findByPageInfo(new CiMrReCallApplyDTO(), paginationInfo, sqlStr, "", null);		
		return pagingRtnData;
	}
	/**
	 * 
	 * @param sqlWhere
	 * @return
	 */
	private StringBuilder getCiMrMedReCallApplyDTOSql(String sqlWhere) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ci_recall_apply.id_ent as id_ent, ");// 
		sql.append(" en_ent_ip.code_amr_ip as code_ent_ip, ");// 
		sql.append(" ci_recall_apply.id_pat as id_pat, ");// 
		sql.append(" en_ent.name_pat as name_pat, ");// 
		sql.append(" en_ent.dt_acpt as dt_in, ");// 
		sql.append(" en_ent.dt_end as dt_out, ");// 
		sql.append(" ci_recall_apply.id_apply_status as id_apply_status, ");// 
		sql.append(" ci_recall_apply.sd_apply_status as sd_apply_status, ");// 
		sql.append(" bd_udidoc.name as name_apply_status, ");// 
		sql.append(" ci_recall_apply.id_apply_user as id_apply_user, ");// 
		sql.append(" sys_user1.name as name_apply_user, ");// 
		sql.append(" ci_recall_apply.apply_reason as apply_reason, ");// 
		sql.append(" ci_recall_apply.dt_apply as dt_apply, ");// 
		sql.append(" ci_recall_apply.id_med_agree_user as id_med_agree_user, ");// 医务审核人id
		sql.append(" sys_user2.name as name_med_agree_user, ");// 
		sql.append(" ci_recall_apply.dt_med_agree as dt_med_agree, ");// 
		sql.append(" ci_recall_apply.iscompleted as iscompleted, ");// 
		sql.append(" ci_recall_apply.adopt_opinion, ");// 
		sql.append(" ci_recall_apply.reject_reason, ");// 
		sql.append(" ci_recall_apply.id_recall_apply as id_recall_apply ");// 
		sql.append(" from ci_recall_apply ci_recall_apply ");
		sql.append(" left join en_ent en_ent ");
		sql.append(" on ci_recall_apply.id_ent = en_ent.id_ent ");
		sql.append(" left join sys_user sys_user1 ");
		sql.append(" on ci_recall_apply.id_apply_user = sys_user1.id_user ");
		sql.append(" left join sys_user sys_user2 ");
		sql.append(" on ci_recall_apply.id_med_agree_user = sys_user2.id_user ");
		sql.append(" left join bd_udidoc bd_udidoc ");
		sql.append(" on ci_recall_apply.id_apply_status = bd_udidoc.id_udidoc ");
		sql.append(" left join en_ent_ip en_ent_ip ");
		sql.append(" on en_ent.id_ent = en_ent_ip.id_ent ");
		sql.append(sqlWhere);
		
		return sql;
	}
	
	/**
	 * 病历召回申请结果查询
	 */
	public PagingRtnData<CiMrReCallApplyDTO> getCiMrReCallApplyQueryResult(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		// 查询方案解析
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		String userId = Context.get().getUserId();// 获取当前登录用户id
		
		StringBuilder sqlWhere = new StringBuilder();
		sqlWhere.append(" where ci_recall_apply.id_apply_user = '");
		sqlWhere.append(userId);
		sqlWhere.append("' ");
		// 拼接查询方案的sql条件
 		if (qryRootNodeDTO != null){
 			sqlWhere.append(" and ");
 			sqlWhere.append(service.getQueryStringWithoutDesc(qryRootNodeDTO));
 		}
 		// 根据申请时间倒序排序
 		sqlWhere.append(" order by ci_recall_apply.dt_apply desc ");
 		// 调用sql方法
 		StringBuilder sql = getCiMrReCallApplyQuerySql(sqlWhere.toString());
 		String sqlStr = sql.toString();
 		
		PagingRtnData<CiMrReCallApplyDTO> pagingRtnData = 
				super.findByPageInfo(new CiMrReCallApplyDTO(), paginationInfo, sqlStr, "", null);		
		return pagingRtnData;
	}
	/**
	 * 
	 * @param sqlWhere
	 * @return
	 */
	private StringBuilder getCiMrReCallApplyQuerySql(String sqlWhere) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ci_recall_apply.id_ent as id_ent, ");// 
		sql.append(" en_ent_ip.code_amr_ip as code_ent_ip, ");// 
		sql.append(" ci_recall_apply.id_pat as id_pat, ");// 
		sql.append(" en_ent.name_pat as name_pat, ");// 
		sql.append(" en_ent.dt_acpt as dt_in, ");// 
		sql.append(" en_ent.dt_end as dt_out, ");// 
		sql.append(" ci_recall_apply.id_apply_status as id_apply_status, ");// 
		sql.append(" ci_recall_apply.sd_apply_status as sd_apply_status, ");// 
		sql.append(" bd_udidoc.name as name_apply_status, ");// 
		sql.append(" ci_recall_apply.id_apply_user as id_apply_user, ");// 
		sql.append(" sys_user1.name as name_apply_user, ");// 
		sql.append(" ci_recall_apply.apply_reason as apply_reason, ");// 
		sql.append(" ci_recall_apply.dt_apply as dt_apply, ");// 
		sql.append(" ci_recall_apply.id_dep_agree_user as id_dep_agree_user, ");// 科室审核人
		sql.append(" ci_recall_apply.id_med_agree_user as id_med_agree_user, ");// 医务审核人
		sql.append(" sys_user2.name as name_dep_agree_user, ");// 
		sql.append(" sys_user3.name as name_med_agree_user, ");// 
		sql.append(" ci_recall_apply.dt_dep_agree as dt_dep_agree, ");// 科室审核时间
		sql.append(" ci_recall_apply.dt_med_agree as dt_med_agree, ");// 医务审核时间
		sql.append(" ci_recall_apply.iscompleted as iscompleted, ");// 
		sql.append(" ci_recall_apply.id_recall_apply as id_recall_apply ");// 
		sql.append(" from ci_recall_apply ci_recall_apply ");
		sql.append(" left join en_ent en_ent ");
		sql.append(" on ci_recall_apply.id_ent = en_ent.id_ent ");
		sql.append(" left join sys_user sys_user1 ");
		sql.append(" on ci_recall_apply.id_apply_user = sys_user1.id_user ");
		sql.append(" left join sys_user sys_user2 ");
		sql.append(" on ci_recall_apply.id_dep_agree_user = sys_user2.id_user ");
		sql.append(" left join sys_user sys_user3 ");
		sql.append(" on ci_recall_apply.id_med_agree_user = sys_user3.id_user ");
		sql.append(" left join bd_udidoc bd_udidoc ");
		sql.append(" on ci_recall_apply.id_apply_status = bd_udidoc.id_udidoc ");
		sql.append(" left join en_ent_ip en_ent_ip ");
		sql.append(" on en_ent.id_ent = en_ent_ip.id_ent ");
		sql.append(sqlWhere);
		
		return sql;
	}
	
	/**
	 * 召回申请-审核方法
	 */
	public boolean toSubmitReCallApply(ReCallApplyDO[] reCallApplyDOs) throws BizException {
		IRecallapplyCudService Cudservice = ServiceFinder.find(IRecallapplyCudService.class);
		IRecallapplyRService rService = ServiceFinder.find(IRecallapplyRService.class);
		
		if (reCallApplyDOs == null || reCallApplyDOs.length <=0) {
			return false;
		}
		
		for (ReCallApplyDO reCallApplyDO : reCallApplyDOs) {
			String id_ra = reCallApplyDO.getId_recall_apply();
			ReCallApplyDO rcaDO = rService.findById(id_ra);
			// 审核状态赋值
			rcaDO.setId_apply_status(reCallApplyDO.getId_apply_status());// 
			rcaDO.setSd_apply_status(reCallApplyDO.getSd_apply_status());
			rcaDO.setAdopt_opinion(reCallApplyDO.getAdopt_opinion());
			rcaDO.setReject_reason(reCallApplyDO.getReject_reason());
			// 科室审核人/医务审核人赋值
			if (reCallApplyDO.getId_dep_agree_user() != null && reCallApplyDO.getDt_dep_agree() != null) {
				rcaDO.setId_dep_agree_user(reCallApplyDO.getId_dep_agree_user());
				rcaDO.setDt_dep_agree(reCallApplyDO.getDt_dep_agree());
			}
			if (reCallApplyDO.getId_med_agree_user() != null && reCallApplyDO.getDt_med_agree() != null) {
				rcaDO.setId_med_agree_user(reCallApplyDO.getId_med_agree_user());
				rcaDO.setDt_med_agree(reCallApplyDO.getDt_med_agree());
			}
			// 判断是否标识为完成
			if (reCallApplyDO.getIscompleted() != null) {
				rcaDO.setIscompleted(reCallApplyDO.getIscompleted());
			}
			// 更新
			ReCallApplyDO[] result = Cudservice.update(new ReCallApplyDO[]{ rcaDO });
			
			if (result == null || result.length < 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 更新就诊病案表中完成标志
	 */
	public boolean toUpdateAMrDO(AMrDO[] amrDos) throws BizException {
		ICiamrCudService Cudservice = ServiceFinder.find(ICiamrCudService.class);
		ICiamrRService rService = ServiceFinder.find(ICiamrRService.class);
		
		if (amrDos == null || amrDos.length <=0) {
			return false;
		}
		
		for (AMrDO aMrDO : amrDos) {
			String id_ent = aMrDO.getId_ent();
			AMrDO[] amd = rService.find(" a0.id_ent = '" + id_ent + "' ", "", FBoolean.FALSE);
			// 查询赋值
			if (amd.length != 1) {
				return false;
			}
			amd[0].setFg_complete(aMrDO.getFg_complete());
			amd[0].setId_qa_doctor_part_sta(aMrDO.getId_qa_doctor_part_sta());
			amd[0].setSd_qa_doctor_part_sta(aMrDO.getSd_qa_doctor_part_sta());
			// 更新
			AMrDO[] result = Cudservice.update(new AMrDO[]{ amd[0] });
			
			if (result == null || result.length < 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 召回申请-驳回方法
	 */
	public boolean toRejecrReCallApply(ReCallApplyDO[] reCallApplyDOs) throws BizException {
		IRecallapplyCudService Cudservice = ServiceFinder.find(IRecallapplyCudService.class);
		IRecallapplyRService rService = ServiceFinder.find(IRecallapplyRService.class);
		
		if (reCallApplyDOs == null || reCallApplyDOs.length <=0) {
			return false;
		}
		
		for (ReCallApplyDO reCallApplyDO : reCallApplyDOs) {
			String id_ra = reCallApplyDO.getId_recall_apply();
			ReCallApplyDO rcaDO = rService.findById(id_ra);
			// 审核状态赋值
			rcaDO.setId_apply_status(reCallApplyDO.getId_apply_status());// 
			rcaDO.setSd_apply_status(reCallApplyDO.getSd_apply_status());
			rcaDO.setAdopt_opinion(reCallApplyDO.getAdopt_opinion());
			rcaDO.setReject_reason(reCallApplyDO.getReject_reason());
			// 科室审核人/医务审核人赋值
			if (reCallApplyDO.getId_dep_agree_user() != null && reCallApplyDO.getDt_dep_agree() != null) {
				rcaDO.setId_dep_agree_user(reCallApplyDO.getId_dep_agree_user());
				rcaDO.setDt_dep_agree(reCallApplyDO.getDt_dep_agree());
			}
			if (reCallApplyDO.getId_med_agree_user() != null && reCallApplyDO.getDt_med_agree() != null) {
				rcaDO.setId_med_agree_user(reCallApplyDO.getId_med_agree_user());
				rcaDO.setDt_med_agree(reCallApplyDO.getDt_med_agree());
			}
			// 更新
			ReCallApplyDO[] result = Cudservice.update(new ReCallApplyDO[]{ rcaDO });
			
			if (result == null || result.length < 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 召回申请信息保存
	 */
	public ReCallApplyDO[] saveReCallApplyDO(ReCallApplyDO reCallApplyDO) throws BizException {
		IRecallapplyCudService Cudservice = ServiceFinder.find(IRecallapplyCudService.class);
		IRecallapplyRService rService = ServiceFinder.find(IRecallapplyRService.class);
		ReCallApplyDO[] result = null;
		
		if (reCallApplyDO == null) {
			return new ReCallApplyDO[]{};
		}
		String raID = reCallApplyDO.getId_recall_apply();
		// 判断DO数据是用于新建还是更新
		if (raID == null) {
			result = Cudservice.save(new ReCallApplyDO[]{ reCallApplyDO });
		} else {
			ReCallApplyDO raDO = rService.findById(raID);
			
			raDO.setId_grp(reCallApplyDO.getId_grp());
			raDO.setId_org(reCallApplyDO.getId_org());
			raDO.setId_apply_user(reCallApplyDO.getId_apply_user());
			raDO.setId_apply_dep(reCallApplyDO.getId_apply_dep());
			raDO.setApply_reason(reCallApplyDO.getApply_reason());
			raDO.setDt_apply(reCallApplyDO.getDt_apply());
			raDO.setId_apply_status(reCallApplyDO.getId_apply_status());
			raDO.setSd_apply_status(reCallApplyDO.getSd_apply_status());
			raDO.setIscompleted(reCallApplyDO.getIscompleted());
			
			result = Cudservice.update(new ReCallApplyDO[]{ raDO });
		}
		return result;
	}
	
}
