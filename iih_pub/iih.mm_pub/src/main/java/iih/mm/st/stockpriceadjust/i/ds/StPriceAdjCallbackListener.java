package iih.mm.st.stockpriceadjust.i.ds;

import iih.mm.st.stockpriceadjust.d.StPriceAdjFormAggDO;
import xap.mw.core.data.DOStatus;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;
import xap.wf.af.vos.d.WfTaskDO;
import xap.wf.af.vos.i.IWftaskdoRService;

public class StPriceAdjCallbackListener implements IExecutionListener {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void notify(WfEventExecution nodeInstance) throws Exception {
		Logger.info("begin to update the status of stock price adjust.");
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
		if (!(inner instanceof StPriceAdjFormAggDO)) {
			return;
		} 
		StPriceAdjFormAggDO billDo = (StPriceAdjFormAggDO) inner;
		
		String targetTaskId = taskIns.getId_task();
		billDo.getParentDO().setId_task(targetTaskId);
		
		IWftaskdoRService iWftaskdoRService = ServiceFinder.find(IWftaskdoRService.class);
		WfTaskDO taskDo = iWftaskdoRService.findById(targetTaskId);
		billDo.getParentDO().setId_pro_def(taskDo.getId_prodef());
		billDo.getParentDO().setId_pro_ins(taskDo.getId_proins());
		billDo.getParentDO().setStatus(DOStatus.UPDATED);
	}
}
