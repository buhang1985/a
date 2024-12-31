package iih.ci.mrqc.cimrtaskdto.s;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.cimrtaskdto.d.CiMrTaskDTO;
import iih.ci.mrqc.cimrtaskdto.i.ICiMrTaskService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces={ICiMrTaskService.class}, binding=Binding.JSONRPC)
public class ICiMrTaskServiceImpl implements ICiMrTaskService {
	
	/**
	 * 病历任务查询
	 */
	@SuppressWarnings("unchecked")
	public CiMrTaskDTO[] getCiMrTaskDTOResult(String sqlWhere) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append(" where ");
		sb.append(sqlWhere);
		// 查询
        String sql = getCiMrTaskDTOSql(sb.toString()).toString();
		DAFacade daf1 = new DAFacade();
		List<CiMrTaskDTO> CiMrTaskDTOList = 
				(List<CiMrTaskDTO>) daf1.execQuery(sql, new BeanListHandler(CiMrTaskDTO.class));
		// 创建List集合，二次封装数据
		List<CiMrTaskDTO> TaskDTOList = new ArrayList<CiMrTaskDTO>();
		
		for (CiMrTaskDTO ciMrTaskDTO : CiMrTaskDTOList) {
			if (ciMrTaskDTO.getId_status() == null || ciMrTaskDTO.getId_status().equals("")) {
				ciMrTaskDTO.setId_status(ICiMrDictCodeConst.ID_OVERAPPLY_UNAPPLY);
				ciMrTaskDTO.setSd_status(ICiMrDictCodeConst.SD_OVERAPPLY_UNAPPLY);
				ciMrTaskDTO.setName_status(ICiMrDictCodeConst.NAME_OVERAPPLY_UNAPPLY);
			}
			/*
			FDateTime dtBegin = ciMrTaskDTO.getDt_begin();
			FDateTime dtEnd = ciMrTaskDTO.getDt_end();
			FDateTime nowTime = new FDateTime();
			
			String timeHas;
			int cr = dtEnd.compareTo(nowTime);
			
			if (cr < 0) {// 已超时
				timeHas = "已超时！";
			}else {// 未超时
				long timeMillis = dtEnd.getMillis() - nowTime.getMillis();
				double timeHours = (double) timeMillis / (1000.0 * 60.0 * 60.0);
				
				if (timeHours <= 24) {
					int timeResult = (int) Math.floor(timeHours);
					timeHas = timeResult + "";
				}else {
					int timeDays = (int) (timeHours / 24);
					int timeDayHours = (int) (timeHours - (double) (timeDays * 24));
					timeHas = timeDays + "天" + timeDayHours + "小时";
				}
			}
			
			ciMrTaskDTO.setTime_has(timeHas);*/
			TaskDTOList.add(ciMrTaskDTO);
		}
		
		CiMrTaskDTO[] array = 
				(CiMrTaskDTO[])TaskDTOList.toArray(new CiMrTaskDTO[TaskDTOList.size()]);
		return array;
	}
	/**
	 * getCiMrTaskDTOResult方法查询sql
	 * @param sqlWhere
	 * @return
	 */
	private StringBuilder getCiMrTaskDTOSql(String sqlWhere) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ci_qa_mrtask.id_mrtask as id_mrtask, ");// 病历任务主键标识
		sql.append(" ci_qa_mrtask.id_grp as id_grp, ");// 所属集团
		sql.append(" ci_qa_mrtask.id_org as id_org, ");// 所属组织
		sql.append(" ci_qa_mrtask.id_qa_itm_config as id_qa_itm_config, ");// 自动质控项id		
		sql.append(" ci_qa_mrtask.id_pat as id_pat, ");// 患者
		sql.append(" ci_qa_mrtask.id_ent as id_ent, ");// 就诊
		sql.append(" ci_qa_mrtask.id_exec_dept as id_exec_dept, ");// 事件部门
		sql.append(" ci_qa_mrtask.id_exec_doctor as id_exec_doctor, ");// 事件人员	
		sql.append(" ci_qa_mrtask.id_mrcactm as id_mrcactm, ");// 医疗记录自定义分类
		sql.append(" ci_qa_mrtask.id_mrtp as id_mrtp, ");// 医疗记录类型
		sql.append(" ci_qa_mrtask.id_source as id_source, ");// 来源id
		sql.append(" ci_qa_mrtask.source_type as source_type, ");// 来源类型
		sql.append(" ci_qa_mrtask.source_name as source_name, ");// 来源名称		
		sql.append(" ci_qa_mrtask.dt_complete as dt_complete, ");// 完成时间
		sql.append(" ci_qa_mrtask.reason_cancel as reason_cancel, ");// 取消任务原因
		sql.append(" ci_qa_mrtask.israte as israte, ");// 是否频次
		sql.append(" ci_qa_mrtask.rate as rate, ");// 频次
		sql.append(" ci_qa_mrtask.id_or as id_or, ");// 医嘱		
		sql.append(" ci_qa_mrtask.createdby as createdby, ");// 创建人
		sql.append(" ci_qa_mrtask.createdtime as createdtime, ");// 创建时间
		sql.append(" ci_qa_mrtask.modifiedby as modifiedby, ");// 最后修改人
		sql.append(" ci_qa_mrtask.modifiedtime as modifiedtime, ");// 最后修改时间
		sql.append(" ci_qa_mrtask.id_mrtask_sta as id_mrtask_sta, ");// 病历任务主键		
		sql.append(" ci_qa_mrtask.sd_mrtask_sta as sd_mrtask_sta, ");// 任务状态sd
		sql.append(" bd_udidoc1.name as name_mrtask_sta, ");// 任务状态name
		sql.append(" ci_qa_mrtask.mrtask_name as mrtask_name, ");// 任务名称
		sql.append(" ci_qa_mrtask.dt_begin as dt_begin, ");// 开始时间
		sql.append(" ci_qa_mrtask.dt_end as dt_end, ");// 结束时间
		sql.append(" ci_qa_mrtask.time_has as time_has, ");// 剩余时间
		sql.append(" ci_mr_oa.id_status as id_status, ");// 申请状态id
		sql.append(" ci_mr_oa.sd_status as sd_status, ");// 申请状态sd
		sql.append(" bd_udidoc2.name as name_status, ");// 申请状态name
		sql.append(" ci_mr_oa.id_ci_mr_oa as id_ci_mr_oa, ");// 病历超时申请主键
		sql.append(" rule.timeout_reminder as timeout_reminder,");// 超时提醒
		sql.append(" rule.reminder_time_limit as reminder_time_limit, ");// 超时提醒时限
		sql.append(" rule.timeout_color as timeout_color  ");// 超时任务前景色
		sql.append(" from ci_qa_mrtask ci_qa_mrtask ");
		sql.append(" left join ci_mr_oa ci_mr_oa ");
		sql.append(" on ci_qa_mrtask.id_mrtask = ci_mr_oa.id_mrtask ");
		sql.append(" left join bd_udidoc bd_udidoc1 ");
		sql.append(" on ci_qa_mrtask.id_mrtask_sta = bd_udidoc1.id_udidoc ");
		sql.append(" left join bd_udidoc bd_udidoc2 ");
		sql.append(" on ci_mr_oa.id_status = bd_udidoc2.id_udidoc ");
		sql.append(" left join bd_mr_task_rule rule ");
		sql.append(" on rule.id_mr_task_rule = ci_qa_mrtask.id_mr_task_rule ");
		sql.append(sqlWhere);
		
		return sql;
	}

}
