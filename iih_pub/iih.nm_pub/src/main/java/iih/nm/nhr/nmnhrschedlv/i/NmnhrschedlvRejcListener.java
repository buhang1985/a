package iih.nm.nhr.nmnhrschedlv.i;

import iih.bd.bc.udi.pub.INmNurDictCodeConst;
import iih.bd.bc.udi.pub.INmNurDictCodeTypeConst;
import iih.nm.nhr.nmnhrschedlv.d.NmNhrSchedLVFormDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class NmnhrschedlvRejcListener implements IExecutionListener{

	@Override
	public void notify(WfEventExecution arg0) throws Exception {
		Logger.info("开始更新人员调动审核状态.");
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
		if (!(inner instanceof NmNhrSchedLVFormDO)) {
			return;
		}
		
		NmNhrSchedLVFormDO lvdo = (NmNhrSchedLVFormDO)inner;
		if ("02".equals(lvdo.getTransDo().getSd_apy_status())) {
			setupStatus(lvdo, "04");
		} else if ("03".equals(lvdo.getTransDo().getSd_apy_status())) {
			setupStatus(lvdo, "07");
		} 
		
		String title = (String) lvdo.getAttributeValue(lvdo.getFrmTitileField());
		taskIns.setTitile(title);
		taskIns.asyn();

		TaskInstance[] taskInsList = PwfmContext.getCurrentBpmnSession().getResponse().getOutPutTaskInstances();
		if (taskInsList == null)
			return;

		String targetTaskId = taskInsList[0].getId_task();
		lvdo.getTransDo().setId_task(targetTaskId);
	}
	
	private void setupStatus(NmNhrSchedLVFormDO billDo, String status) throws BizException {
		IUdidocServiceExt srv = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] udidocDOs = srv.findByUdidoclistCode(INmNurDictCodeTypeConst.NMNHRSCHEDLV_STATUS);
		if (udidocDOs != null && udidocDOs.length > 0) {
			for (UdidocDO udidocDO : udidocDOs) {
				if (udidocDO.getCode().equals(status)) {
					billDo.getTransDo().setId_apy_status(udidocDO.getId_udidoc());
					billDo.getTransDo().setSd_apy_status(status);
					billDo.getTransDo().setName_apy_status(udidocDO.getName());
					billDo.getTransDo().setStatus(DOStatus.UPDATED);
					break;
				}
			}
		}
	}

}
