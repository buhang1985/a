package iih.ci.mr.s.bp.task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleDO;
import iih.bd.srv.mrtaskrule.i.IMrtaskruleMDORService;
import iih.ci.mr.s.bp.task.bp.mrovertimeremind.MrOvertimeRemindBp;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.mrtask.i.IMrtaskCudService;
import iih.ci.mrqc.mrtask.i.IMrtaskRService;
import iih.ci.mrqc.qcremindmsgdto.d.QcRemindMsgDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class MrOvertimeRemindTask implements IBackgroundWorkPlugin{

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {
		Map<String,Object> variableValueMap = arg0.getKeyMap();
		String param = (String) variableValueMap.get("complete_judge");
		List<QcRemindMsgDTO> list = getMrWrittenTaskData(param);
		IMrtaskruleMDORService service=ServiceFinder.find(IMrtaskruleMDORService.class);
		IMrtaskRService taskRService=ServiceFinder.find(IMrtaskRService.class);
		IMrtaskCudService taskCudService=ServiceFinder.find(IMrtaskCudService.class);
		for(QcRemindMsgDTO remind:list){		
				MrTaskRuleDO taskRuleDO = service.findById(remind.getId_mr_task_rule());
				if(taskRuleDO==null) continue;
				//结束时间
				FDateTime dt_end = remind.getDt_end();
				//超时提醒
				String timeout_reminder = taskRuleDO.getTimeout_reminder();
				//超时提醒时限
				Integer reminder_time_limit = taskRuleDO.getReminder_time_limit();
				if(timeout_reminder ==null || reminder_time_limit==null) continue;
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				long tmp=0;
				try {
					if("01".equals(timeout_reminder)){
						// 超时前提醒，结束时间-当前时间  大于0，<=期限时间 
					    tmp=format.parse(dt_end.toString()).getTime()-format.parse(new FDateTime().toString()).getTime();
					}else if("02".equals(timeout_reminder)){
						// 超时后提醒，当前时间-结束时间 大于0，<=期限时间
						tmp=format.parse(new FDateTime().toString()).getTime()-format.parse(dt_end.toString()).getTime();
					}
				}catch (ParseException e) {
						e.printStackTrace();
					}
				if(0<tmp && tmp<=reminder_time_limit*60*1000){
					//设置任务提醒属性为Y
					MrTaskDO taskDo = taskRService.findById(remind.getId_mrtask());
					taskDo.setIsreminded(FBoolean.TRUE);
					taskDo.setStatus(DOStatus.UPDATED);
					taskCudService.save(new MrTaskDO[]{taskDo});
					MrOvertimeRemindBp bp=new MrOvertimeRemindBp();
					bp.sendQcReminderMsg(remind);	
				}
		}
		return null;
	}
	
    @SuppressWarnings("unchecked")
	public List<QcRemindMsgDTO> getMrWrittenTaskData(String param) throws BizException{
     	DAFacade daf = new DAFacade();  	
    	StringBuilder sql = new StringBuilder();
    	
    	if(ICiMrDictCodeConst.ID_MR_TASK_CREATE.equals(param)){
    		sql.append(" select task.id_mrtask,task.id_mr_task_rule, ent.id_ent, ent.code as code_ent,");
    		sql.append(" ent.name_pat as pat_name,dep.id_dep as id_dep_phy, dep.name as dep_phy_name,");	
    		sql.append(" us.id_user as id_psn,us.name as emp_phy_name, ");	
    		sql.append(" rule.name_tmpl_remind as name_tmpl_remind, ");
    		sql.append(" task.mrtask_name as mr_name ,task.dt_end ");	
    		sql.append(" from ci_qa_mrtask task ");	
    		sql.append(" left join en_ent ent ");	
    		sql.append(" on ent.id_ent=task.id_ent "); 		
    		sql.append(" left join sys_user us ");
    		sql.append(" on ent.id_emp_phy=us.id_psn ");
    		sql.append(" left join bd_dep dep ");
    		sql.append(" on dep.id_dep=task.id_exec_dept ");
    		sql.append(" left join bd_mr_task_rule rule ");
    		sql.append(" on task.id_mr_task_rule=rule.id_mr_task_rule ");
    		sql.append(" where task.id_mr_task_rule is not null and task.sd_mrtask_sta='00' ");
    		sql.append(" and (task.isreminded is null or task.isreminded='N') ");
    		sql.append(" and rule.timeout_reminder<>'00' ");	
    	}else if(ICiMrDictCodeConst.ID_MR_TASK_SIGN.equals(param)){
    		sql.append(" select task.id_mrtask,task.id_mr_task_rule, ent.id_ent, ent.code as code_ent,");
    		sql.append(" ent.name_pat as pat_name,dep.name as dep_phy_name,");	
    		sql.append(" us.id_user as id_psn,us.name as emp_phy_name, ");	
    		sql.append(" mr.createdby as createdby,mr.modifiedby as modifiedby, ");	
    		sql.append(" rule.name_tmpl_remind as name_tmpl_remind, ");
    		sql.append(" task.mrtask_name as mr_name ,task.dt_end ");
    		sql.append(" from ci_qa_mrtask task ");	
    		sql.append(" inner join ci_mr mr  ");
    		sql.append(" on task.id_mrtask=mr.task_id "); 	
    		sql.append(" left join en_ent ent ");	
    		sql.append(" on ent.id_ent=task.id_ent ");  
    		sql.append(" left join sys_user us ");
    		sql.append(" on ent.id_emp_phy=us.id_psn ");
    		sql.append(" left join bd_dep dep ");
    		sql.append(" on dep.id_dep=mr.id_dep_pat ");
    		sql.append(" left join bd_mr_task_rule rule\n ");
    		sql.append(" on task.id_mr_task_rule=rule.id_mr_task_rule "); 	
    		sql.append(" where mr.fg_submit='N' and mr.ds=0 ");
    		sql.append(" and  task.id_mr_task_rule is not null ");	
    		sql.append(" and  (task.isreminded is null or task.isreminded='N') ");
    		sql.append(" and rule.timeout_reminder<>'00' ");	
    	}
		String sqlStr=sql.toString();
		List<QcRemindMsgDTO> mrtasklist = (List<QcRemindMsgDTO>) daf.execQuery(sqlStr,new BeanListHandler(QcRemindMsgDTO.class));
		return mrtasklist;
    }
}
