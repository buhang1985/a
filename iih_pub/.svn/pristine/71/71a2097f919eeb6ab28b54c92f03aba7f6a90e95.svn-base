package iih.nm.nqm.nqmimprovkpi.i;

import iih.nm.nom.nommeet.d.NomMeetFormDO;
import iih.nm.nqm.nqmimprovkpi.d.NqmImprovKpiFormDO;
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

public class NqmImprovKpiRejcListener implements IExecutionListener {
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(WfEventExecution arg0) throws Exception {
		Logger.info("开始更新会议记录审核状态.");
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
		if (!(inner instanceof NqmImprovKpiFormDO)) {
			return;
		}
		NqmImprovKpiFormDO billDo = (NqmImprovKpiFormDO) inner;

		//setupStatus(billDo, "04");
		if(billDo.getTransDo().getSd_status().equals("02")){
			setupStatus(billDo, "04");
		}else if(billDo.getTransDo().getSd_status().equals("03")){
			setupStatus(billDo, "07");
		}else if(billDo.getTransDo().getSd_status().equals("06")){
			setupStatus(billDo, "09");
		}
		
		

		String title = (String) billDo.getAttributeValue(billDo.getFrmTitileField());
		taskIns.setTitile(title);
		taskIns.asyn();

		TaskInstance[] taskInsList = PwfmContext.getCurrentBpmnSession().getResponse().getOutPutTaskInstances();
		if (taskInsList == null)
			return;

		String targetTaskId = taskInsList[0].getId_task();
		billDo.getTransDo().setId_task(targetTaskId);

	}

	private void setupStatus(NqmImprovKpiFormDO billDo, String status) throws BizException {
		IUdidocServiceExt srv = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] udidocDOs = srv.findByUdidoclistCode("NM.NQM.0680");

		if (udidocDOs != null && udidocDOs.length > 0) {

			for (UdidocDO udidocDO : udidocDOs) {

				if (udidocDO.getCode().equals(status)) {

					billDo.getTransDo().setId_status(udidocDO.getId_udidoc());  // .setId_applystatus(udidocDO.getId_udidoc());
					billDo.getTransDo().setSd_status(status); //.setSd_applystatus(status);
					billDo.getTransDo().setName_status(udidocDO.getName()); // .setName_apply(udidocDO.getName());
					billDo.getTransDo().setStatus(DOStatus.UPDATED);
					break;
				}
			}
		}
	}
}
