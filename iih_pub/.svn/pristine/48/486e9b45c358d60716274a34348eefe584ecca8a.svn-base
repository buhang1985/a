package iih.sfda.aeh.evrptflow.listener.stgy;

import iih.sfda.aeh.evrptflow.FlowProdefConst;
import iih.sfda.aeh.evrptflow.d.AerEvFormDO;
import iih.sfda.aer.sfdaaerev.d.SfdaAerEvDO;
import iih.sfda.aer.sfdaaerev.i.ISfdaaerevCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class SubmmitCmptHandleListener implements IExecutionListener {
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(WfEventExecution arg0) throws Exception {
		TaskInstance taskIns = PwfmContext.getCurrentBpmnSession().getTask();
		if (taskIns == null) {
			return;
		}
		taskIns.setOpinion("提交报告！");
		taskIns.asyn();
		// if
		// (WfTaskCreateType.Reject.toString().equals(taskIns.getFinishType().name()))
		// {
		// taskIns.setExt2("审核驳回");
		// } else if
		// (WfTaskCreateType.Normal.toString().equals(taskIns.getFinishType().name()))
		// {
		// taskIns.setExt2("审批通过");
		// }
		IPort port = taskIns.getNodeInstance().getPort();
		WfFormInfoCtx inputBillInfo = PwfmContext.getCurrentBpmnSession().getInputBillInfo();
		if (inputBillInfo != null) {
			SfdaAerEvDO aerEvDo = (SfdaAerEvDO) ((AerEvFormDO) inputBillInfo).getDataInst();
			saveAfterFlow(aerEvDo);
		}
	}

	private SfdaAerEvDO saveAfterFlow(SfdaAerEvDO sfdaAerEvDO) throws BizException {
		if (sfdaAerEvDO == null) {
			return null;
		}
		sfdaAerEvDO.setCurr_node(FlowProdefConst.NODEINS_STATUS_SECOND);
		sfdaAerEvDO.setEv_status(FlowProdefConst.PROINS_STATUS_RUN);
		sfdaAerEvDO.setStatus(DOStatus.UPDATED);
		ISfdaaerevCudService service = ServiceFinder.find(ISfdaaerevCudService.class);
		SfdaAerEvDO[] dos = service.update(new SfdaAerEvDO[] { sfdaAerEvDO });
		return dos[0];
	}
}
