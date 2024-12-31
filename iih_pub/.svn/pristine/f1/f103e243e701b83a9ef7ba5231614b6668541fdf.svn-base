package iih.nm.nhr.nmnhrschedlv.i;

import iih.nm.com.i.flow.IBaseFormInfoCxt;
import iih.nm.nhr.nmnhrschedlv.d.NmNhrSchedLvDO;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class NmnhrschedlvEndListener implements IExecutionListener {

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
		INmnhrschedlvFlowService flow_srv = ServiceFinder.find(INmnhrschedlvFlowService.class);
		IBaseFormInfoCxt baseFormInfoCxt = (IBaseFormInfoCxt) inputBillInfo;
		flow_srv.NmnhrschedlvFlowEndDoAction((NmNhrSchedLvDO) baseFormInfoCxt.getDataInst());
	}
}
