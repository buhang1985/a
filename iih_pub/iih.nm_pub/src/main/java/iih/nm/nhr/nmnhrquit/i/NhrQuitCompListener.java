package iih.nm.nhr.nmnhrquit.i;

import iih.nm.nhr.nmnhrquit.d.NmNhrQuitFormDO;
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

public class NhrQuitCompListener implements IExecutionListener{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void notify(WfEventExecution arg0) throws Exception {
		Logger.info("开始更新人员辞职审核状态.");
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
		if (!(inner instanceof NmNhrQuitFormDO)) {
			return;
		}
		NmNhrQuitFormDO billDo = (NmNhrQuitFormDO) inner;

		if (billDo.getTransDo().getSd_applystatus().equals("04")) {
			setupStatus(billDo, "02");
		}else if(billDo.getTransDo().getSd_applystatus().equals("07")){
			setupStatus(billDo, "03");
		}else if(billDo.getTransDo().getSd_applystatus().equals("02")){
			//病区护士长审核通过
			setupStatus(billDo, "03");
		}else if (billDo.getTransDo().getSd_applystatus().equals("03")) {
			//大科室护士长审核通过
			setupStatus(billDo, "06");
		}else if (billDo.getTransDo().getSd_applystatus().equals("06")) {
			//护理部审核通过
			setupStatus(billDo, "08");
		}else if (billDo.getTransDo().getSd_applystatus().equals("04")) {
			setupStatus(billDo, "03");
		}
		else if (billDo.getTransDo().getSd_applystatus().equals("09")) {
			setupStatus(billDo, "06");
		}

		String title = (String) billDo.getAttributeValue(billDo.getFrmTitileField());
		taskIns.setTitile(title);
		taskIns.asyn();
	}
	
	private void setupStatus(NmNhrQuitFormDO billDo, String status) throws BizException {
		IUdidocServiceExt srv = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] udidocDOs = srv.findByUdidoclistCode("NM.NHR.0830");

		if (udidocDOs != null && udidocDOs.length > 0) {

			for (UdidocDO udidocDO : udidocDOs) {

				if (udidocDO.getCode().equals(status)) {
					billDo.getTransDo().setId_applystatus(udidocDO.getId_udidoc());
					billDo.getTransDo().setSd_applystatus(status); 
					billDo.getTransDo().setStatus(DOStatus.UPDATED);
					break;
				}
			}
		}
	}

}