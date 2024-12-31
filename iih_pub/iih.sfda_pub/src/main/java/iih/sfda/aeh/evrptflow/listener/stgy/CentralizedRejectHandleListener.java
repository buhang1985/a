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
import xap.wf.af.itf.IWfTaskQry;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class CentralizedRejectHandleListener implements IExecutionListener {
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(WfEventExecution nodeInstance) throws Exception {
		TaskInstance taskIns = PwfmContext.getCurrentBpmnSession().getTask();
		if (taskIns == null) {
			return;
		}
		SfdaAerEvDO aerEvDo = null;
		WfFormInfoCtx inputBillInfo = PwfmContext.getCurrentBpmnSession().getInputBillInfo();
		if (inputBillInfo != null) {
			aerEvDo = (SfdaAerEvDO) ((AerEvFormDO) inputBillInfo).getDataInst();
		}
		aerEvDo.setCurr_node(FlowProdefConst.NODEINS_STATUS_SECOND);
		IWfTaskQry task_srv = ServiceFinder.find(IWfTaskQry.class);
		String id_user_prenode = task_srv.getPreTasksUser(taskIns.getId_task());// 获取任务上游任务处理者
		aerEvDo.setId_currhdl_user(id_user_prenode);
		saveAfterFlow(aerEvDo);
	}

	private SfdaAerEvDO saveAfterFlow(SfdaAerEvDO sfdaAerEvDO) throws BizException {
		if (sfdaAerEvDO == null) {
			return null;
		}
		sfdaAerEvDO.setStatus(DOStatus.UPDATED);
		ISfdaaerevCudService service = ServiceFinder.find(ISfdaaerevCudService.class);
		SfdaAerEvDO[] dos = service.update(new SfdaAerEvDO[] { sfdaAerEvDO });
		return dos[0];
	}
}
