package iih.nm.nhr.psnshiftdto.listener;

import iih.nm.nhr.psnshiftdto.d.NmNurTransFormDO;
import xap.mw.core.data.DOStatus;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年1月5日 上午11:09:12
 * 类说明：
 * Company: Copyright 2016 by PKU healthcare IT Co.Ltd.
 */
public class NmNurTaskCreateListener implements IExecutionListener{

	private static final long serialVersionUID = 1L;

	@Override
	public void notify(WfEventExecution arg0) throws Exception {
	
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
		if (!(inner instanceof NmNurTransFormDO)) {
			return;
		} 
		NmNurTransFormDO transFormDO = (NmNurTransFormDO) inner;
		
		String targetTaskId = taskIns.getId_task();
		transFormDO.setId_task(targetTaskId);
		transFormDO.setStatus(DOStatus.UPDATED);
		
	}

}
