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

/**
 * 
 * @author chenxiang
 *
 * @date 2019年8月20日下午1:24:26
 *
 * @classpath iih.hp.cp.hpcp.i.HpcpRetrieveListener
 *
 * description: 取回策略监听器
 *
 */
public class HpcpRetrieveListener implements IExecutionListener {
	
	private static final long serialVersionUID = 84504387469618625L;

	@Override
	public void notify(WfEventExecution arg0) throws Exception {
		Logger.info("开始更新临床路径取回状态.");
		//获取当前任务实例
		TaskInstance taskIns = PwfmContext.getCurrentBpmnSession().getTask();
		if(taskIns==null){
			return;
		}
		IPort port = taskIns.getNodeInstance().getPort();
		if (!(port instanceof UserTaskActivity)) {
			return;
		} 
		//获取当前单据信息（即当前业务实体信息）
		WfFormInfoCtx inner = PwfmContext.getCurrentBpmnSession().getInputBillInfo();
		if (!(inner instanceof HpcpFormAggDO)) {
			return;
		} 
		HpcpFormAggDO billDo = (HpcpFormAggDO) inner;
		//查询前驱任务id
		IHpcpFlowService hpcpFlowService = ServiceFinder.find(IHpcpFlowService.class);
		String preTaskId = hpcpFlowService.getAllowRetrieveTaskID(billDo.getParentDO());
		if (preTaskId == null) {
			return;
		}
		//提交取回后，在hpcpDO中保存前驱任务id
		billDo.getParentDO().setId_task(preTaskId);
		//如果当前审核状态是提交，则取回后状态是新建；如果当前状态是审核中，则取回后状态是提交
		if (IHPDictCodeConst.SD_HPCP_STATUS_SUBMIT.equals(billDo.getParentDO().getSd_status())) {
			setupStatus(billDo, IHPDictCodeConst.SD_HPCP_STATUS_NEW);
		} else if (IHPDictCodeConst.SD_HPCP_STATUS_EXAMING.equals(billDo.getParentDO().getSd_status())) {
			setupStatus(billDo, IHPDictCodeConst.SD_HPCP_STATUS_SUBMIT);
		}
		
		String title = (String)billDo.getAttributeValue(billDo.getFrmTitileField());
		taskIns.setTitile(title);
		taskIns.asyn();
	}

	/**
	 * 
	
	 * <p>Title: setupStatus</p>  
	
	 * <p>Description: 修改单据信息的流程状态</p>  
	
	 * @param billDo	单据对象
	 * @param status	状态码
	 * @throws BizException
	 */
	private void setupStatus(HpcpFormAggDO billDo, String status) throws BizException {
    	IUdiHelperService udiHelperService = ServiceFinder.find(IUdiHelperService.class);
    	UdidocDO udidocDO = udiHelperService.getUdidocByCode(billDo.getParentDO().getId_org(), IHPDictCodeConst.SD_HPCP_STATUS, status);
    	
    	billDo.getParentDO().setId_status(udidocDO.getId_udidoc());
    	billDo.getParentDO().setSd_status(status);
    	billDo.getParentDO().setName_status(udidocDO.getName());
    	billDo.getParentDO().setStatus(DOStatus.UPDATED);
	}
}
