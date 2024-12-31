package iih.ci.test;

import xap.wf.af.bpmn.SequenceFlow;
import xap.wf.af.engine.ILogicDecision;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class LineLogicDecision implements ILogicDecision {

	@Override
	public boolean judge(TaskInstance task, SequenceFlow sf, WfFormInfoCtx... arg2) {
		String line_id = sf.getId();//连线编码
		if(line_id == null || line_id.equals("")) return false;
		if (line_id.equals("13")) {
			return true;
		}else if(line_id.equals("16")){
			return Math.random()<0.5;
		}else if(line_id.equals("17")){
			return Math.random()<0.5;
		}
		return false;
	}

}
