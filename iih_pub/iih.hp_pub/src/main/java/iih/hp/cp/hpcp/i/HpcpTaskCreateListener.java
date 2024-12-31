package iih.hp.cp.hpcp.i;

import iih.hp.cp.hpcp.d.HpcpFormAggDO;
import xap.mw.core.data.DOStatus;
import xap.mw.log.logging.Logger;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class HpcpTaskCreateListener implements IExecutionListener {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void notify(WfEventExecution arg0) throws Exception {
		Logger.info("开始更新临床路径审核状态.");
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
		if (!(inner instanceof HpcpFormAggDO)) {
			return;
		} 
		HpcpFormAggDO billDo = (HpcpFormAggDO) inner;
		
		String targetTaskId = taskIns.getId_task();
		billDo.getParentDO().setId_task(targetTaskId);
		billDo.getParentDO().setStatus(DOStatus.UPDATED);
	}
}
