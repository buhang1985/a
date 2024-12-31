package iih.nm.com.i.flow;

import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.constant.WfTaskActionType;
import xap.wf.af.constant.WfTaskFininshType;
import xap.wf.af.constant.WfTaskStateType;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;
import xap.wf.af.utils.WfTaskUtil;
import xap.wf.af.vos.d.WfTaskDO;

public class IExecuRejectListener implements IExecutionListener{

	private static final long serialVersionUID = -660404992116859690L;

	@Override
	public void notify(WfEventExecution paramWfEventExecution) throws Exception {
		TaskInstance taskIns = PwfmContext.getCurrentBpmnSession().getTask();
		if (taskIns == null) {
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
		taskIns.setId_executer(Context.get().getUserId());
		taskIns.setExecute(FBoolean.TRUE);
		taskIns.setState(WfTaskStateType.Completed);
		taskIns.setFinishType(WfTaskFininshType.Normal);
		taskIns.setEndDate(new FDateTime());
		taskIns.setIsNotEnded(FBoolean.TRUE);
		taskIns.setOpinion(cxt.getAppropin());
		taskIns.setTitile("已驳回");
		taskIns.setExt1(FlowProdefConst.PROINS_STATUS_REJECT);
		taskIns.asyn();
		
	}

}
