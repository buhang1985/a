package iih.hp.cp.hpcp.i;

import xap.wf.af.bpmn.SequenceFlow;
import xap.wf.af.engine.ILogicDecision;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

/**
 * 不执行流程分支
 * @author HUMS
 *
 */
public class HpcpConditionNor implements ILogicDecision{

	@Override
	public boolean judge(TaskInstance arg0, SequenceFlow arg1, WfFormInfoCtx... arg2) {
		
		return false;
	}
}