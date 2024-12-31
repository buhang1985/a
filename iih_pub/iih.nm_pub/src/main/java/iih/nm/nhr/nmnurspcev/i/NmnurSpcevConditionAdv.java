package iih.nm.nhr.nmnurspcev.i;

import xap.wf.af.bpmn.SequenceFlow;
import xap.wf.af.engine.ILogicDecision;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

/**
 * 直接转到结束
 * @author jimz
 *
 */
public class NmnurSpcevConditionAdv implements ILogicDecision{

	@Override
	public boolean judge(TaskInstance arg0, SequenceFlow arg1, WfFormInfoCtx... arg2) {
		return false;
	}

}
