package iih.nm.nqm.qctplmaintenance.i;

import iih.bd.bc.udi.pub.INmNurDictCodeConst;
import iih.bd.bc.udi.pub.INmNurDictCodeTypeConst;
import iih.nm.nqm.qctplmaintenance.d.NmQctplFormDO;
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

public class QctplEndListener implements IExecutionListener {
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(WfEventExecution arg0) throws Exception {
		Logger.info("开始更新质量模板审核状态.");
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
		if (!(inner instanceof NmQctplFormDO)) {
			return;
		}
		NmQctplFormDO tpldo = (NmQctplFormDO) inner;
		String targetTaskId = taskIns.getId_task();
		tpldo.gettplDo().setId_task(targetTaskId);
		setupStatus(tpldo,INmNurDictCodeConst.SD_QCTPL_STATUS_EXAMCOM);

		String title = (String) tpldo.getAttributeValue(tpldo.getFrmTitileField());
		taskIns.setTitile(title);
		taskIns.asyn();
	}

	private void setupStatus(NmQctplFormDO tplDo, String status) throws BizException {
		IUdidocServiceExt srv = ServiceFinder.find(IUdidocServiceExt.class);

		UdidocDO[] udiDos = srv.findByUdidoclistCode(INmNurDictCodeTypeConst.SD_QCTPL_STATUS);

		for (UdidocDO udidocDO : udiDos) {

			if (status.equals(udidocDO.getCode())) {
				tplDo.gettplDo().setId_status(udidocDO.getId_udidoc());
				tplDo.gettplDo().setSd_status(udidocDO.getCode());
				tplDo.gettplDo().setName_status(udidocDO.getName());
				tplDo.gettplDo().setStatus(DOStatus.UPDATED);
				break;
			}
		}
	}
}
