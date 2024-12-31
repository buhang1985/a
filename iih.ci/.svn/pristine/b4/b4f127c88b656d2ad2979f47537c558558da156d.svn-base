package iih.ci.mrqc.cimroverapplydto.s;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.cimroverapply.d.CiMrOverApplyDO;
import iih.ci.mrqc.cimroverapply.i.ICimroverapplyCudService;
import iih.ci.mrqc.cimroverapply.i.ICimroverapplyRService;
import iih.ci.mrqc.cimroverapplydto.d.CiMrOverApplyDTO;
import iih.ci.mrqc.cimroverapplydto.i.ICiMrOverApplyService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces={ICiMrOverApplyService.class}, binding=Binding.JSONRPC)
public class ICiMrOverApplyServiceImpl extends PagingServiceImpl<CiMrOverApplyDTO> implements ICiMrOverApplyService {
	
	/**
	 * 病历超时申请查询
	 */
	public PagingRtnData<CiMrOverApplyDTO> getCiMrOverApplyDTOResult(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		// 查询方案解析
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		
		StringBuilder sqlWhere = new StringBuilder();
		sqlWhere.append(" where nvl(ci_mr_oa.sd_status, 'isnull') != 'isnull' ");
		// 拼接查询方案的sql条件
 		if (qryRootNodeDTO != null){
 			sqlWhere.append(" and ");
 			sqlWhere.append(service.getQueryStringWithoutDesc(qryRootNodeDTO));
 		}
 		// 根据申请时间倒序排序
 		sqlWhere.append(" order by ci_mr_oa.dt_oa desc "); 		
 		// 调用sql方法
 		StringBuilder sql = getCiMrOverApplyDTOSql(sqlWhere.toString());
 		String sqlStr = sql.toString();
 		
		PagingRtnData<CiMrOverApplyDTO> pagingRtnData = 
				super.findByPageInfo(new CiMrOverApplyDTO(), paginationInfo, sqlStr, "", null);		
		return pagingRtnData;
	}
	/**
	 * 
	 * @param sqlWhere
	 * @return
	 */
	private StringBuilder getCiMrOverApplyDTOSql(String sqlWhere) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ci_mr_oa.id_ci_mr_oa as id_ci_mr_oa, ");// 病历超时申请id
		sql.append(" ci_qa_mrtask.id_ent as id_ent, ");// 就诊id
		sql.append(" ci_qa_mrtask.id_mrtask as id_mrtask, ");// 病历任务id
		sql.append(" en_ent_ip.code_amr_ip as code_ent, ");// 住院号
		sql.append(" ci_qa_mrtask.id_pat as id_pat, ");// 患者id
		sql.append(" pi_pat.name as name_pat, ");// 患者姓名
		sql.append(" ci_mr_oa.id_emp_oa as id_emp_oa, ");// 申请人id
		sql.append(" bd_psndoc2.name as name_emp_oa, ");// 申请人姓名
		sql.append(" ci_qa_mrtask.mrtask_name as mrtask_name, ");// 申请记录名称
		sql.append(" ci_mr_oa.overtime as overtime, ");// 超过时长
		sql.append(" ci_mr_oa.normaltime as normaltime, ");// 正常书写时间区间
		sql.append(" ci_mr_oa.reason as reason_oa, ");// 申请原因
		sql.append(" ci_mr_oa.dt_oa as dt_oa, ");// 申请时间
		sql.append(" ci_mr_oa.id_emp_sub as id_emp_sub, ");// 审核人id
		sql.append(" bd_psndoc3.name as name_emp_sub, ");// 审核人姓名
		sql.append(" ci_mr_oa.dt_sub as dt_sub, ");// 审核时间
		sql.append(" ci_mr_oa.id_status as id_status, ");// 申请状态id
		sql.append(" ci_mr_oa.sd_status as sd_status ");// 申请状态sd
		sql.append(" from ci_qa_mrtask ci_qa_mrtask ");
		sql.append(" left join en_ent en_ent ");
		sql.append(" on ci_qa_mrtask.id_ent = en_ent.id_ent ");
		sql.append(" left join pi_pat pi_pat ");
		sql.append(" on ci_qa_mrtask.id_pat = pi_pat.id_pat ");
		sql.append(" left join ci_mr_oa ci_mr_oa ");
		sql.append(" on ci_qa_mrtask.id_mrtask = ci_mr_oa.id_mrtask ");
		sql.append(" left join bd_psndoc bd_psndoc2 ");
		sql.append(" on ci_mr_oa.id_emp_oa = bd_psndoc2.id_psndoc ");
		sql.append(" left join bd_psndoc bd_psndoc3 ");
		sql.append(" on ci_mr_oa.id_emp_sub = bd_psndoc3.id_psndoc ");
		sql.append(" left join en_ent_ip en_ent_ip ");
		sql.append(" on en_ent.id_ent = en_ent_ip.id_ent ");
		sql.append(sqlWhere);
		
		return sql;
	}
	
	/**
	 * 病历超时审核操作
	 */
	public boolean updateCiMrOverApplyDOFromSubmit(CiMrOverApplyDO[] ciMrOverApplyDOs) throws BizException {
		ICimroverapplyCudService Cudservice = ServiceFinder.find(ICimroverapplyCudService.class);
		ICimroverapplyRService rService = ServiceFinder.find(ICimroverapplyRService.class);
		
		if (ciMrOverApplyDOs == null || ciMrOverApplyDOs.length <=0) {
			return false;
		}
		
		for (CiMrOverApplyDO ciMrOverApplyDO : ciMrOverApplyDOs) {
			// 获取申请id，查询
			String id_oa = ciMrOverApplyDO.getId_ci_mr_oa();
			CiMrOverApplyDO overApplyDO = rService.findById(id_oa);
			// 赋值
			overApplyDO.setId_emp_sub(ciMrOverApplyDO.getId_emp_sub());
			overApplyDO.setDt_sub(ciMrOverApplyDO.getDt_sub());
			overApplyDO.setId_status(ICiMrDictCodeConst.ID_OVERAPPLY_SUBMIT);// 已审核
			overApplyDO.setSd_status(ICiMrDictCodeConst.SD_OVERAPPLY_SUBMIT);// 已审核
			// 更新
			CiMrOverApplyDO[] result = Cudservice.update(new CiMrOverApplyDO[]{overApplyDO});
			
			if (result == null || result.length < 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 病历超时驳回操作
	 */
	public boolean updateCiMrOverApplyDOFromReject(CiMrOverApplyDO[] ciMrOverApplyDOs) throws BizException {
		ICimroverapplyCudService Cudservice = ServiceFinder.find(ICimroverapplyCudService.class);
		ICimroverapplyRService rService = ServiceFinder.find(ICimroverapplyRService.class);
		
		if (ciMrOverApplyDOs == null || ciMrOverApplyDOs.length <=0) {
			return false;
		}
		
		for (CiMrOverApplyDO ciMrOverApplyDO : ciMrOverApplyDOs) {
			// 获取申请id，查询
			String id_oa = ciMrOverApplyDO.getId_ci_mr_oa();
			CiMrOverApplyDO overApplyDO = rService.findById(id_oa);
			// 赋值
			overApplyDO.setId_emp_sub(ciMrOverApplyDO.getId_emp_sub());
			overApplyDO.setDt_sub(ciMrOverApplyDO.getDt_sub());
			overApplyDO.setId_status(ICiMrDictCodeConst.ID_OVERAPPLY_REJECT);// 已驳回
			overApplyDO.setSd_status(ICiMrDictCodeConst.SD_OVERAPPLY_REJECT);// 已驳回
			// 更新
			CiMrOverApplyDO[] result = Cudservice.update(new CiMrOverApplyDO[]{overApplyDO});
			
			if (result == null || result.length < 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 超时申请信息保存
	 */
	public CiMrOverApplyDO[] saveCiMrOverApplyDO(CiMrOverApplyDO ciMrOverApplyDO) throws BizException {
		ICimroverapplyCudService Cudservice = ServiceFinder.find(ICimroverapplyCudService.class);
		ICimroverapplyRService rService = ServiceFinder.find(ICimroverapplyRService.class);
		
		if (ciMrOverApplyDO == null) {
			return new CiMrOverApplyDO[]{};
		}
		// 查询此id的DO，赋值
		CiMrOverApplyDO overApplyDO = rService.findById(ciMrOverApplyDO.getId_ci_mr_oa());
		
		overApplyDO.setId_emp_oa(ciMrOverApplyDO.getId_emp_oa());
		overApplyDO.setDt_oa(ciMrOverApplyDO.getDt_oa());
		overApplyDO.setId_status(ciMrOverApplyDO.getId_status());
		overApplyDO.setSd_status(ciMrOverApplyDO.getSd_status());
		overApplyDO.setOvertime(ciMrOverApplyDO.getOvertime());
		overApplyDO.setId_emp_sub(ciMrOverApplyDO.getId_emp_sub());
		overApplyDO.setDt_sub(ciMrOverApplyDO.getDt_sub());
		overApplyDO.setReason(ciMrOverApplyDO.getReason());
		// 将更新好的DO保存
		CiMrOverApplyDO[] result = Cudservice.update(new CiMrOverApplyDO[]{overApplyDO});
		return result;
	}
}
