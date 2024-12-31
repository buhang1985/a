package iih.bd.srv.emrtpl.s;

import iih.bd.srv.emrtpl.d.EmrtplAggDO;
import iih.bd.utils.log.BdSrvLogUtils;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class OneLastListener implements IExecutionListener {
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(WfEventExecution context) throws Exception {
		BdSrvLogUtils.info("任务创建后,更新单据状态");
		TaskInstance taskIns = PwfmContext.getCurrentBpmnSession().getTask();
		if (taskIns == null) {
			return;
		}
		IPort port = taskIns.getNodeInstance().getPort();

		WfFormInfoCtx inputBillInfo = PwfmContext.getCurrentBpmnSession().getInputBillInfo();
		if (!(port instanceof UserTaskActivity)) {
			return;
		}
		String taskPk = taskIns.getId_task();
		String proDefPk = taskIns.getProcessDefinition().getId_prodef();
		String proInsPk = taskIns.getProcessInstance().getId_proins();

//		UserTaskActivity userTask = (UserTaskActivity) port;
//		String portId = userTask.getId();

		WfFormInfoCtx inner = inputBillInfo;

		if (!(inner instanceof EmrtplAggDO)) {
			return;
		}
		EmrtplAggDO billDo = (EmrtplAggDO) inner;
		// 写上三个流程相关的东西
		billDo.getParentDO().setTask_id(taskPk);
		billDo.getParentDO().setWf_prodef(proDefPk);
		billDo.getParentDO().setId_wf_type(proInsPk);
		billDo.getParentDO().setSd_su_mrptl("5");

	}

	@SuppressWarnings("unused")
	private void setupCheckInfo(EmrtplAggDO billDo) throws Exception {
//		String checkUserId = Context.get().getUserId();
		// TODO...获取当前人员信息
//		String id_psndoc=user.getId_psn();
//		PsnDocDO psnDocDO = (PsnDocDO)new DAFacade().findByPK(PsnDocDO.class, id_psndoc);
//		billDo.getParentDO().setDt_check(new FDateTime());
	}
}
