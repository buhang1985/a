package iih.nm.nhr.nmnhrschedrp.i;

import iih.nm.nhr.nmnhrschedrp.d.NhrSchedRpFormDO;
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

public class NhrSchedrpEndListener implements IExecutionListener {
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(WfEventExecution arg0) throws Exception {
		Logger.info("开始更新会议记录审核状态.");//EndEvent
		TaskInstance taskIns = PwfmContext.getCurrentBpmnSession().getTask();
		if(taskIns==null){
			return;
		}
		return ;
//		IPort port = taskIns.getNodeInstance().getPort();
//		
//		WfFormInfoCtx inputBillInfo = PwfmContext.getCurrentBpmnSession()
//				.getInputBillInfo();
//		if (!(port instanceof UserTaskActivity)) {
//			return;
//		} 
//
//		WfFormInfoCtx inner = inputBillInfo;
//		if (!(inner instanceof NhrSchedRpFormDO)) {
//			return;
//		} 
//		NhrSchedRpFormDO billDo = (NhrSchedRpFormDO) inner;
//		String targetTaskId = taskIns.getId_task();
//		billDo.getTransDo().setId_task(targetTaskId);
//		setupStatus(billDo, "05");	
//		
//		String title = (String)billDo.getAttributeValue(billDo.getFrmTitileField());
//		taskIns.setTitile(title);
//		taskIns.asyn();	
	}
	
	private void setupStatus(NhrSchedRpFormDO billDo, String status) throws BizException {
		IUdidocServiceExt srv = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] udidocDOs = srv.findByUdidoclistCode("NM.NHR.0730");

		if (udidocDOs != null && udidocDOs.length > 0) {

			for (UdidocDO udidocDO : udidocDOs) {

				if (udidocDO.getCode().equals(status)) {

					billDo.getTransDo().setId_apy_status(udidocDO.getId_udidoc());  // .setId_applystatus(udidocDO.getId_udidoc());
					billDo.getTransDo().setSd_apy_status(status); //.setSd_applystatus(status);
					//billDo.getTransDo().setName_status(udidocDO.getName()); // .setName_apply(udidocDO.getName());
					billDo.getTransDo().setStatus(DOStatus.UPDATED);
					break;
				}
			}
		}
	}
}
