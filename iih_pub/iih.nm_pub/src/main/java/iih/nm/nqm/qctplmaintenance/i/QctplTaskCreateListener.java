package iih.nm.nqm.qctplmaintenance.i;

import iih.nm.nqm.qctplmaintenance.d.NmQctplFormDO;
import xap.mw.core.data.DOStatus;
import xap.mw.log.logging.Logger;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class QctplTaskCreateListener implements IExecutionListener {
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(WfEventExecution arg0) throws Exception {

		Logger.info("开始更新质量模板审核状态.");
		TaskInstance taskIns = PwfmContext.getCurrentBpmnSession().getTask();
		if (taskIns == null) {
			return;
		}
		IPort port = taskIns.getNodeInstance().getPort();

		WfFormInfoCtx inputBillInfo = PwfmContext.getCurrentBpmnSession().getInputBillInfo();
		if (!(port instanceof UserTaskActivity)) {
			return;
		}

		WfFormInfoCtx inner = inputBillInfo;
		if (!(inner instanceof NmQctplFormDO)) {
			return;
		}
		NmQctplFormDO tplDo = (NmQctplFormDO) inner;

		String targetTaskId = taskIns.getId_task();
		tplDo.gettplDo().setId_task(targetTaskId);
		tplDo.gettplDo().setStatus(DOStatus.UPDATED);

	}

}
