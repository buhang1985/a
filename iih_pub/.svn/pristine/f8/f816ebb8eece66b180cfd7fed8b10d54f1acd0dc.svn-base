package iih.nm.com.i.flow;

import xap.wf.af.constant.WfTaskCreateType;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.runtime.TaskInstance;

public class ExecuHandleListener implements IExecutionListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void notify(WfEventExecution arg0) throws Exception {
		TaskInstance taskIns = PwfmContext.getCurrentBpmnSession().getTask();
		if (taskIns == null) {
			return;
		}
		if (WfTaskCreateType.Reject.toString().equals(taskIns.getFinishType().name())) {
			taskIns.setExt2("审核驳回");
		} else if (WfTaskCreateType.Normal.toString().equals(taskIns.getFinishType().name())) {
			taskIns.setExt2("审批通过");
		}
		//
		// IPort port = taskIns.getNodeInstance().getPort();
		// if (!(port instanceof UserTaskActivity)) {
		// return;
		// }
		// IBaseFormInfoCxt baseFormInfo = (IBaseFormInfoCxt)
		// PwfmContext.getCurrentBpmnSession().getInputBillInfo();
		// Object DataInst = baseFormInfo.getDataInst();
		// handle(DataInst, taskIns.getId_task());
	}
	// public void handle(Object obj, String id_task) throws BizException;
}
