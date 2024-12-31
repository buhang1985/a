package iih.mm.pl.stockplan.i.ds;

import iih.bd.bc.udi.pub.IMmDictCodeConst;
import iih.mm.pl.stockplan.d.StockPlanFormAggDO;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.constant.WfTaskCreateType;
//import xap.wf.af.constant.WfTaskCreateType;
import xap.wf.af.constant.WfTaskFininshType;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;

public class PurchasePlanCallbackListener implements IExecutionListener {
	private static final long serialVersionUID = 1L;
	private static final String PURCHASE_CREATE_NODE = "2";
	private static final String PURCHASE_CHECK_NODE = "3";

	@Override
	public void notify(WfEventExecution context) throws Exception {
		Logger.info("begin to update the status of purchase plan.");
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
		
		UserTaskActivity userTask = (UserTaskActivity) port;
		String portId = userTask.getId();
		
		if (portId.equalsIgnoreCase(PURCHASE_CHECK_NODE)) {
			WfTaskFininshType finishType = taskIns.getFinishType();
			WfFormInfoCtx inner = inputBillInfo;
			if (!(inner instanceof StockPlanFormAggDO)) {
				return;
			} 
			StockPlanFormAggDO billDo = (StockPlanFormAggDO) inner;
			if (WfTaskFininshType.Normal.equals(finishType)) {
				setupCheckInfo(billDo);
				billDo.getParentDO().setSd_su_pl(IMmDictCodeConst.SD_SU_PL_CONFIRM_PASS);
			} else if (WfTaskFininshType.Reject.equals(finishType)) {
				setupCheckInfo(billDo);
				
				TaskInstance[] targetTaskIns = PwfmContext.getCurrentBpmnSession()
						.getResponse().getOutPutTaskInstances();
				String targetTaskId = targetTaskIns[0].getId_task();
				billDo.getParentDO().setSd_su_pl(IMmDictCodeConst.SD_SU_PL_CONFIRM_REFUSE);
				billDo.getParentDO().setTask_id(targetTaskId);
				
				//TaskInstance[] taskInses=PwfmContext.getCurrentBpmnSession().getResponse().getOutPutTaskInstances();
				String title = (String)billDo.getAttributeValue("test_title");
				targetTaskIns[0].setTitile(title);
				targetTaskIns[0].asyn();
			}
		}
		Logger.info("The status of purchase plan had been updated.");
	}
	
	private void setupCheckInfo(StockPlanFormAggDO billDo) throws Exception {
		String checkUserId = Context.get().getUserId();
		//TODO...获取当前人员信息
//		String id_psndoc=user.getId_psn();
//		PsnDocDO psnDocDO = (PsnDocDO)new DAFacade().findByPK(PsnDocDO.class, id_psndoc);
		billDo.getParentDO().setDt_check(new FDateTime());
	}
}
