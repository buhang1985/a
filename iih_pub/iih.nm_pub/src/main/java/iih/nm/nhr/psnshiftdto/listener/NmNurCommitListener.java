package iih.nm.nhr.psnshiftdto.listener;

import iih.bd.bc.udi.pub.INmNurDictCodeConst;
import iih.nm.nhr.psnshiftdto.d.NmNurTransFormDO;
import xap.mw.core.data.BizException;
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
 * @version 创建时间：2017年1月5日 上午11:20:50
 * 类说明：
 * Company: Copyright 2016 by PKU healthcare IT Co.Ltd.
 */
public class NmNurCommitListener implements IExecutionListener{

	/**
	 * 
	 */
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

		setupStatus(transFormDO, INmNurDictCodeConst.SD_APPLY_STATUS_COMMIT);
		
		
		String title = (String)transFormDO.getAttributeValue(transFormDO.getFrmTitileField());
		taskIns.setTitile(title);
		taskIns.asyn();	
		
	}

	/**
	 * 设置审核状态
	 * @param transFormDO
	 * @param status
	 * @throws BizException
	 */
	private void setupStatus(NmNurTransFormDO transFormDO, String status) throws BizException {
    
		transFormDO.setId_applystatus(INmNurDictCodeConst.ID_APPLY_STATUS_COMMIT);
		transFormDO.setSd_applystatus(status);
//    	billDo.getParentDO().setName_status(udidocDO.getName());
    	transFormDO.setStatus(DOStatus.UPDATED);
	}
}
