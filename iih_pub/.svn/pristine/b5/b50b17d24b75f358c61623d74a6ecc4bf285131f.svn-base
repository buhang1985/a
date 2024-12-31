package iih.nm.nhr.nmnhrschedrp.i;

import iih.nm.com.i.flow.IBaseFormInfoCxt;
import iih.nm.nhr.nmnhrschedrp.d.NhrSchedRpDO;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class NmnhrschedrpEndListener implements IExecutionListener {

	@Override
	public void notify(WfEventExecution arg0) throws Exception {
		TaskInstance taskIns = PwfmContext.getCurrentBpmnSession().getTask();
		if (taskIns == null) {
			return;
		}
		IPort port = taskIns.getNodeInstance().getPort();
		WfFormInfoCtx inputBillInfo = PwfmContext.getCurrentBpmnSession().getInputBillInfo();
		if (!(port instanceof UserTaskActivity)) {
			return;
		}
		INmnhrschedrpFlowService flow_srv = ServiceFinder.find(INmnhrschedrpFlowService.class);
		IBaseFormInfoCxt baseFormInfoCxt = (IBaseFormInfoCxt) inputBillInfo;
		flow_srv.NhrSchedRpFlowEndDoAction((NhrSchedRpDO) baseFormInfoCxt.getDataInst());
	}
}