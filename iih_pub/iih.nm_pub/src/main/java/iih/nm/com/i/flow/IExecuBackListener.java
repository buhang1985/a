package iih.nm.com.i.flow;

import xap.mw.coreitf.d.FDateTime;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.runtime.TaskInstance;

public class IExecuBackListener implements IExecutionListener{

	private static final long serialVersionUID = 3061281034649302968L;

	@Override
	public void notify(WfEventExecution paramWfEventExecution) throws Exception {
		TaskInstance taskIns = PwfmContext.getCurrentBpmnSession().getTask();
		if (taskIns == null) {
			return;
		}
		taskIns.setTitile("已撤回");
		// 取回时间
		taskIns.setEndDate(new FDateTime());
		taskIns.setExt1(FlowProdefConst.PROINS_STATUS_BACK);
		taskIns.asyn();
	}
}
