package iih.nm.nhr.nmnhrschedlv.i;

import iih.bd.bc.udi.pub.INmNurDictCodeTypeConst;
import xap.mw.core.data.Context;
import xap.wf.af.bpmn.ProcessDefinition;
import xap.wf.af.bpmn.SequenceFlow;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.contanier.ProDefsContainer;
import xap.wf.af.engine.ILogicDecision;
import xap.wf.af.model.WfUser;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

/**
 * 直接转到结束
 * @author jimz
 *
 */
public class NmnhrschedlvConditionAdv implements ILogicDecision{

	@Override
	public boolean judge(TaskInstance arg0, SequenceFlow arg1, WfFormInfoCtx... arg2) {
		/*//当前登录user
		String userId = Context.get().getUserId();
		
	    ProcessDefinition proDef = ProDefsContainer.getProDefByFlowTypePk(INmNurDictCodeTypeConst.NMNURLV_FLOW_TYPE_PK);
	    UserTaskActivity taskActivity = proDef.getHumActs().get("9");
	    //获取分配的user
	    WfUser[] user = taskActivity.getAllotSgy().getActorSgy().getMainActor().getActors(arg2[0]);
		if(userId.equals(user[0].getUserPk())) {
			
			return true;
		}*/
		
		return false;
	}

}
