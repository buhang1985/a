package iih.nm.nhr.nmnurlv.i;

import java.util.Map;

import iih.bd.bc.udi.pub.INmNurDictCodeConst;
import iih.bd.bc.udi.pub.INmNurDictCodeTypeConst;
import iih.nm.nhr.nmnurlv.d.NmNurLVFormDO;
import iih.nm.nhr.nmpsnshift.d.NmNurTransFormDO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;
import xap.wf.af.bpmn.ProcessDefinition;
import xap.wf.af.bpmn.TaskActivity;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.context.WfFlowInfoCtx;
import xap.wf.af.engine.IWfBillExtHandler;
import xap.wf.af.engine.TaskProcessUI;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class NmnurlvEndListener implements IExecutionListener{

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
		if (!(inner instanceof NmNurLVFormDO)) {
			return;
		}
		NmNurLVFormDO billDo = (NmNurLVFormDO) inner;
		String targetTaskId = taskIns.getId_task();
		billDo.getTransDo().setId_task(targetTaskId);
		setupStatus(billDo, INmNurDictCodeConst.CODE_NMNURLV_PASS_NUM);	
		
		String title = (String)billDo.getAttributeValue(billDo.getFrmTitileField());
		taskIns.setTitile(title);
		taskIns.asyn();	
		
	}
	
	private void setupStatus(NmNurLVFormDO billDo, String status) throws BizException {
		IUdidocServiceExt srv = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] udidocDOs = srv.findByUdidoclistCode(INmNurDictCodeTypeConst.NMNURLV_STATUS);

		if (udidocDOs != null && udidocDOs.length > 0) {

			for (UdidocDO udidocDO : udidocDOs) {

				if (udidocDO.getCode().equals(status)) {

					billDo.getTransDo().setId_status(udidocDO.getId_udidoc());
					billDo.getTransDo().setSd_status(status);
					billDo.getTransDo().setName_status(udidocDO.getName());
					billDo.getTransDo().setStatus(DOStatus.UPDATED);
					break;
				}
			}
		}
	}
	
}
