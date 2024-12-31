package iih.ci.mr.mraudit.s;

import xap.mw.log.logging.Logger;
import iih.bd.bc.udi.pub.SuMrConst;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.mraudit.i.IMrAuitExt;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.context.BackTaskInfoCtx;
import xap.wf.af.context.CommitInfoCtx;
import xap.wf.af.context.NextTaskInfoCtx;
import xap.wf.af.context.OpenTaskInfoCtx;
import xap.wf.af.context.RejectTaskInfoCtx;
import xap.wf.af.context.StopProInsInfoCtx;
import xap.wf.af.engine.IFlowRequest;
import xap.wf.af.engine.IFlowResponse;
import xap.wf.af.itf.IWfTaskQry;
import xap.wf.af.itfimpl.WfTaskQry;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.BizProcessServer;
import xap.wf.af.server.WfFormInfoCtx;

/**
 * 医疗记录审批操作方法服务实现
 */
@Service(serviceInterfaces = { IMrAuitExt.class }, binding = Binding.JSONRPC)
public class IMrAuitExtImpl implements IMrAuitExt {

	@Override
	public boolean isCanback(String id_task) {
		IWfTaskQry service = ServiceFinder.find(IWfTaskQry.class);
		return service.isCanBack(id_task);
	}

	@Override
	public String getNodeins_code(String id_task) {
		IWfTaskQry service = ServiceFinder.find(IWfTaskQry.class);
		TaskInstance taskInstance = service.getTaskByPk(id_task);
		String code = taskInstance.getNodeInstance().getNodeInsDO()
				.getNodeins_code();
		return code;
	}

	@Override
	public boolean isCanReject(String id_task) {
		IWfTaskQry service = ServiceFinder.find(IWfTaskQry.class);
		return service.isCanReject(id_task);
	}

	@Override
	public void openTask(WfFormInfoCtx formInfo, String taskId) {
		OpenTaskInfoCtx next = new OpenTaskInfoCtx();

		next.setTaskPk(taskId);
		next.builder();

		IFlowRequest request = BizProcessServer.createFlowRequest(next,
				formInfo);
		IFlowResponse response = BizProcessServer.createFlowResponse();
		BizProcessServer.exe(request, response);
	}

	@Override
	public void closeTask(WfFormInfoCtx formInfo) {
		CiMrDO ciMrDo = (CiMrDO) formInfo;

		WfTaskQry wftaskQry = new WfTaskQry();
		String taskInsPk = wftaskQry
				.getArbitrarilyTaskByFrom(ciMrDo.getId_mr());

		StopProInsInfoCtx stop = new StopProInsInfoCtx();
		stop.setTaskPk(taskInsPk);
		stop.builder();
		IFlowRequest request = BizProcessServer.createFlowRequest(stop, ciMrDo);
		IFlowResponse response = BizProcessServer.createFlowResponse();
		BizProcessServer.exe(request, response);
	}

	public CiMrDO startProcess(String id_user, WfFormInfoCtx formInfo)
			throws BizException {
		CommitInfoCtx commit = null;
		CiMrDO ciMrDo = (CiMrDO) formInfo;
    
		Logger.info("startProcess----用户："+id_user+"审签类型:"+ciMrDo.getId_flowtype());
		
		commit = new CommitInfoCtx();
		commit.setCntUserPk(id_user);
		commit.setFlowTypePk(ciMrDo.getId_flowtype());
		commit.setFormInfoCtx(formInfo);
		commit.builder();

		IFlowRequest request = BizProcessServer.createFlowRequest(commit,formInfo);
		boolean flag=request==null;
		if(flag)Logger.info("request==null");
		
		
		IFlowResponse response = BizProcessServer.createFlowResponse();
		boolean flag2=response==null;
		if(flag2)Logger.info("response==null");
		
		BizProcessServer.exe(request, response);
		
		CiMrDO cimrdo=(CiMrDO) formInfo;
		Logger.info("任务ID："+cimrdo.getTask_id());
		
		return (CiMrDO) formInfo;
	}

	@Override
	public CiMrDO stopProcess(String id_user, WfFormInfoCtx formInfo)
			throws BizException {
		CiMrDO ciMrDo = (CiMrDO) formInfo;
		String id_task = ServiceFinder.find(IWfTaskQry.class)
				.getArbitrarilyTaskByFrom(ciMrDo.getId_mr());
		if (id_task == null)
			return null;
		
		StopProInsInfoCtx stopProInsInfoCtx = new StopProInsInfoCtx();
		stopProInsInfoCtx.setCntUserPk(id_user);
		stopProInsInfoCtx.setTaskPk(id_task);
		stopProInsInfoCtx.builder();
		
		IFlowRequest request = BizProcessServer.createFlowRequest(
				stopProInsInfoCtx, formInfo);
		IFlowResponse response = BizProcessServer.createFlowResponse();
		BizProcessServer.exe(request, response);
		
		return (CiMrDO) formInfo;
	}

	public CiMrDO nextStep(String id_user, WfFormInfoCtx formInfo, String taskId)
			throws BizException {
		NextTaskInfoCtx next = new NextTaskInfoCtx();
		
		Logger.info("nextStep----用户："+id_user+"任务ID:"+taskId);
		
		next.setCntUserPk(id_user);
		next.setTaskPk(taskId);
		next.setFormInfoCtx(formInfo);
		next.builder();

		IFlowRequest request = BizProcessServer.createFlowRequest(next,formInfo);
		boolean flag=request==null;
		if(flag)Logger.info("request==null");
		
		IFlowResponse response = BizProcessServer.createFlowResponse();
		boolean flag2=response==null;
		if(flag2)Logger.info("response==null");
		
		BizProcessServer.exe(request, response);
		
		CiMrDO cimrdo=(CiMrDO) formInfo;
		Logger.info("任务ID："+cimrdo.getTask_id());
		
		return (CiMrDO) formInfo;
	}

	public CiMrDO rejectTask(String id_user, WfFormInfoCtx formInfo, String taskId, String opinion)
			throws BizException {
		// CiMrDO ciMrDo = (CiMrDO)formInfo;
		RejectTaskInfoCtx rejectTaskInfo = new RejectTaskInfoCtx();

		rejectTaskInfo.setCntUserPk(id_user);
		rejectTaskInfo.setTaskPk(taskId);
		rejectTaskInfo.setFormInfoCtx(formInfo);
		rejectTaskInfo.setOpinion(opinion);
		rejectTaskInfo.builder();

		IFlowRequest request = BizProcessServer.createFlowRequest(
				rejectTaskInfo, formInfo);
		IFlowResponse response = BizProcessServer.createFlowResponse();
		BizProcessServer.exe(request, response);
		
		return (CiMrDO) formInfo;
	}

	/**
	 * 已办取回
	 * @param id_user
	 * @param formInfo
	 * @param taskId
	 * @throws BizException
	 */
	public CiMrDO backTask(String id_user, WfFormInfoCtx formInfo, String taskId)
			throws BizException {
		BackTaskInfoCtx backTaksInfo = new BackTaskInfoCtx();
		backTaksInfo.setCntUserPk(id_user);
		backTaksInfo.setTaskPk(taskId);
		backTaksInfo.builder();

		IFlowRequest request = BizProcessServer.createFlowRequest(backTaksInfo,
				formInfo);
		IFlowResponse response = BizProcessServer.createFlowResponse();
		BizProcessServer.exe(request, response);

		return (CiMrDO) formInfo;
	}
	
	/**
	 * 已发取回，流程插件实现
	 * @param id_user
	 * @param formInfo
	 * @param taskId
	 * @deprecated
	 */
	public CiMrDO backTask2(String id_user, WfFormInfoCtx formInfo, String taskId)
			throws BizException {
		CiMrDO ciMrDo = (CiMrDO) formInfo;
		ciMrDo.setId_emp_submit(null);
		ciMrDo.setId_su_mr(SuMrConst.ID_SUMR_NEW);
		ciMrDo.setSd_su_mr(SuMrConst.SD_SUMR_NEW);
		// 删除提交人，状态改为新建
		backTask(id_user, formInfo, taskId);
		
		return ciMrDo;
	}

	/**
	 * 获取当前用户查看的病历在审批流里的待办任务，用于控制界面按钮
	 * 有可能存在多条，如何处理由业务决定，在审签过程中一般不会出现
	 * 
	 * 待发->新建，已保存未提交，流程里没有任务，创建人
	 * 已发->已提交，有已完成的任务，发起人=创建人，取回可用
	 * 待办->有未完成的任务，驳回、提交可用
	 * 已办->只有已完成的任务，非发起人
	 */
	@Override
	public String[] getTodoTasks(String id_user, String id_mr) {
		IWfTaskQry service = ServiceFinder.find(IWfTaskQry.class);
		TaskInstance[] tasks = service.getTodoTasksByBillAndUserId(id_mr,
				id_user);
		String[] taskIds = new String[tasks.length];
		for (int i = 0; i < tasks.length; i++) {
			taskIds[i] = tasks[i].getId_task();
		}

		return taskIds;
	}

	@Override
	public String getCompletedTask(String id_user, String id_mr) {
		IWfTaskQry service = ServiceFinder.find(IWfTaskQry.class);
		TaskInstance task = service.getLasterCmpltTaskByBillId(id_mr, id_user);
		return task != null ? task.getId_task() : null;
	}

	@Override
	public String getPreTasksUser(String idTask) {
		IWfTaskQry service = ServiceFinder.find(IWfTaskQry.class);
		return service.getPreTasksUser(idTask);

	}
}