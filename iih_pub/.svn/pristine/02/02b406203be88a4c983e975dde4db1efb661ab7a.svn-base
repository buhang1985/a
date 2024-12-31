package iih.mm.st.stockpriceadjust.i.ds;

import iih.bd.bc.udi.pub.IMmDictCodeConst;
import iih.mm.comm.i.IUdiHelperService;
import iih.mm.st.stockpriceadjust.d.StPriceAdjFormAggDO;
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

public class StPriceAdjEndListener implements IExecutionListener {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void notify(WfEventExecution arg0) throws Exception {
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

		setupStatus(billDo, IMmDictCodeConst.SD_SU_STPRI_CONFIRM_PASS);
		
		String title = (String)billDo.getAttributeValue(billDo.getFrmTitileField());
		taskIns.setTitile(title);
		taskIns.asyn();	
	}
	
	private void setupStatus(StPriceAdjFormAggDO billDo, String status) throws BizException {
    	IUdiHelperService udiHelperService = ServiceFinder.find(IUdiHelperService.class);
    	UdidocDO udidocDO = udiHelperService.getUdidocByCode(billDo.getParentDO().getId_org(), IMmDictCodeConst.SD_SU_STPRI, status);
    	
    	billDo.getParentDO().setId_su_stpri(udidocDO.getId_udidoc());
    	billDo.getParentDO().setSd_su_stpri(status);
    	billDo.getParentDO().setSu_stpri_name(udidocDO.getName());
    	billDo.getParentDO().setStatus(DOStatus.UPDATED);
	}
}
