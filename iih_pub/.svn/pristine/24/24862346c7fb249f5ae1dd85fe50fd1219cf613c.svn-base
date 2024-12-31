package iih.nm.nom.nommeet.i;

import iih.nm.nbd.nmnbdadtlvl.d.NmNbdAdtLvlDO;
import iih.nm.nbd.nmnbdadtlvl.i.INmnbdadtlvlRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.bpmn.SequenceFlow;
import xap.wf.af.engine.ILogicDecision;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class NommeetConditionTwoFinish  implements ILogicDecision{

	public boolean judge(TaskInstance arg0, SequenceFlow arg1, WfFormInfoCtx... arg2) {
		// TODO Auto-generated method stub
		
		INmnbdadtlvlRService rs = ServiceFinder.find(INmnbdadtlvlRService.class);
		NmNbdAdtLvlDO[] arr = null;
		try {
			arr = rs.find("code='52502001'", "", FBoolean.TRUE);
		} catch (BizException e) {
			e.printStackTrace();
		}

		if (arr.length > 0) {
			if (arr[0].getSd_aduit_lvl().equals("02")) {
				//System.out.println("kk");
				return true;
			}
		}
		
		return false;
	}

}
