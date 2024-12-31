package iih.nm.com.i.flow;

import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class IExecuAcceptListener implements IExecutionListener{

	private static final long serialVersionUID = -3167813219424204344L;

	@Override
	public void notify(WfEventExecution paramWfEventExecution) throws Exception {
		TaskInstance taskIns = PwfmContext.getCurrentBpmnSession().getTask();
		if(taskIns==null){
			return;
		}
		IPort port = taskIns.getNodeInstance().getPort();
		WfFormInfoCtx inputBillInfo = PwfmContext.getCurrentBpmnSession()
				.getInputBillInfo();
		if (!(port instanceof UserTaskActivity)) {
			return;
		} 
		WfFormInfoCtx inner = inputBillInfo;
		if (!(inner instanceof IBaseFormInfoCxt)) {
			return;
		} 
		IBaseFormInfoCxt cxt = (IBaseFormInfoCxt)inputBillInfo;
		taskIns.setOpinion(cxt.getAppropin());
		taskIns.setTitile("审批通过");
		taskIns.setExt1(FlowProdefConst.PROINS_STATUS_END);
		taskIns.asyn();		
	}

}
