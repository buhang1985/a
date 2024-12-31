package iih.hp.cp.hpcp.i;

import iih.bd.bc.udi.pub.IHPDictCodeConst;
import iih.hp.cp.comm.i.IUdiHelperService;
import iih.hp.cp.hpcp.d.HpcpFormAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class HpcpCompListener implements IExecutionListener {
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
		
		if(billDo.getParentDO().getSd_status().equals(IHPDictCodeConst.SD_HPCP_STATUS_REJECT)
				|| billDo.getParentDO().getSd_status().equals(IHPDictCodeConst.SD_HPCP_STATUS_NEW)) {
			setupStatus(billDo, IHPDictCodeConst.SD_HPCP_STATUS_SUBMIT);
		} else {
			setupStatus(billDo, IHPDictCodeConst.SD_HPCP_STATUS_EXAMING);
		}
		
		String title = (String)billDo.getAttributeValue(billDo.getFrmTitileField());
		taskIns.setTitile(title);
		taskIns.asyn();	
		
		//审核驳回再提交后，删除其余的提交待办提交任务。(如果不删除，提交后将无法生成审核待办任务)
		new HpCpListenerCommon().deleteCurrentPortUselessTask(billDo.getParentDO().getId_task());
	}

	private void setupStatus(HpcpFormAggDO billDo, String status) throws BizException {
    	IUdiHelperService udiHelperService = ServiceFinder.find(IUdiHelperService.class);
    	UdidocDO udidocDO = udiHelperService.getUdidocByCode(billDo.getParentDO().getId_org(), IHPDictCodeConst.SD_HPCP_STATUS, status);
    	
    	billDo.getParentDO().setId_status(udidocDO.getId_udidoc());
    	billDo.getParentDO().setSd_status(status);
    	billDo.getParentDO().setName_status(udidocDO.getName());
    	billDo.getParentDO().setStatus(DOStatus.UPDATED);
	}
}
