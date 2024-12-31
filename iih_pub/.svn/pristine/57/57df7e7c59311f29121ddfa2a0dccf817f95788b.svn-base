package iih.nm.nit.nitlv.i;

import iih.bd.bc.udi.pub.INmNurDictCodeConst;
import iih.bd.bc.udi.pub.INmNurDictCodeTypeConst;
import iih.nm.nhr.nmnurlv.d.NmNurLVFormDO;
import iih.nm.nit.nitlv.d.NitLVFormDO;
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

public class NitlvCompListener implements IExecutionListener{

	@Override
	public void notify(WfEventExecution arg0) throws Exception {
		// TODO Auto-generated method stub
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
		
		NitLVFormDO lvdo = (NitLVFormDO)inner;
		
		if (lvdo.getTransDo().getSd_status().equals(INmNurDictCodeConst.CODE_NMNURLV_BACK_NUM)) {
			setupStatus(lvdo, INmNurDictCodeConst.CODE_NMNURLV_SUBMIT_NUM);
			//一级审核，下级节点变成二级审核
		}else if(lvdo.getTransDo().getSd_status().equals(INmNurDictCodeConst.CODE_NMNURLV_ONE_NUM)){
			setupStatus(lvdo, INmNurDictCodeConst.CODE_NMNURLV_SECOND_NUM);
			//提交，下级变成一级审核
		}else if(lvdo.getTransDo().getSd_status().equals(INmNurDictCodeConst.CODE_NMNURLV_SUBMIT_NUM)){
			setupStatus(lvdo, INmNurDictCodeConst.CODE_NMNURLV_ONE_NUM);
		} else {
			setupStatus(lvdo, INmNurDictCodeConst.CODE_NMNURLV_PASS_NUM);
		}
	}
	
	private void setupStatus(NitLVFormDO lvdo, String status) throws BizException {
		IUdidocServiceExt srv = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] udidocDOs = srv.findByUdidoclistCode(INmNurDictCodeTypeConst.NMNURLV_STATUS);

		if (udidocDOs != null && udidocDOs.length > 0) {

			for (UdidocDO udidocDO : udidocDOs) {

				if (udidocDO.getCode().equals(status)) {
					lvdo.getTransDo().setId_status(udidocDO.getId_udidoc());
					lvdo.getTransDo().setSd_status(status);
					lvdo.getTransDo().setName_status(udidocDO.getName());
					lvdo.getTransDo().setStatus(DOStatus.UPDATED);
					break;
				}
			}
		}
	}

}
