package iih.sfda.aeh.evrptflow.listener.stgy;

import iih.sfda.aeh.evrptflow.d.AerEvFormDO;
import iih.sfda.aer.aerevcpytuser.d.AerEvCopyUserDO;
import iih.sfda.aer.aerevcpytuser.i.IAerevcpytuserCudService;
import iih.sfda.aer.sfdaaerev.d.SfdaAerEvDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.itf.IWfTaskQry;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class CmptBeforeHandleListener implements IExecutionListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void notify(WfEventExecution nodeInstance) throws Exception {
		TaskInstance taskIns = PwfmContext.getCurrentBpmnSession().getTask();
		if (taskIns == null) {
			return;
		}
		SfdaAerEvDO aerEvDo = null;
		WfFormInfoCtx inputBillInfo = PwfmContext.getCurrentBpmnSession().getInputBillInfo();
		if (inputBillInfo != null) {
			aerEvDo = (SfdaAerEvDO) ((AerEvFormDO) inputBillInfo).getDataInst();
			dowork(taskIns.getNodeInstance().getId_nodeins(), taskIns.getId_task(), taskIns.getId_owner(), aerEvDo.getId_aer_ev());
		}

	}

	private void dowork(String nodeInsPk, String curr_taskpk, String id_curr_taskowner, String id_aer_ev) throws Exception {
		IWfTaskQry wfqry = ServiceFinder.find(IWfTaskQry.class);
		Set<TaskInstance> taskSet = wfqry.getTasksByNodeInsPk(nodeInsPk);
		if (taskSet == null || taskSet.size() < 2)
			return;
		IAerevcpytuserCudService curd_srv = ServiceFinder.find(IAerevcpytuserCudService.class);
		List<AerEvCopyUserDO> copyUsers = new ArrayList<AerEvCopyUserDO>();
		FDateTime dt_oper = new FDateTime();
		for (TaskInstance taskIns : taskSet) {
			if (!taskIns.getId_task().equals(curr_taskpk)) {
				AerEvCopyUserDO copyUser = new AerEvCopyUserDO();
				copyUser.setStatus(DOStatus.NEW);
				copyUser.setId_grp(Context.get().getGroupId());
				copyUser.setId_org(Context.get().getOrgId());
				copyUser.setId_aer_ev(id_aer_ev);
				copyUser.setId_user(taskIns.getId_owner());
				copyUser.setDt_oper(dt_oper);
				copyUser.setId_oper_user(id_curr_taskowner);
				copyUser.setDes("他人办理");
				copyUsers.add(copyUser);
			}
		}
		curd_srv.save(copyUsers.toArray(new AerEvCopyUserDO[copyUsers.size()]));
	}
}
