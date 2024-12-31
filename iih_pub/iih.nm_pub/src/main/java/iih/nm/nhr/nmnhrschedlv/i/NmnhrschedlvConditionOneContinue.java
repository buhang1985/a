package iih.nm.nhr.nmnhrschedlv.i;

import iih.nm.nbd.nmnbdadtlvl.d.NmNbdAdtLvlDO;
import iih.nm.nbd.nmnbdadtlvl.i.INmnbdadtlvlRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.bpmn.SequenceFlow;
import xap.wf.af.engine.ILogicDecision;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class NmnhrschedlvConditionOneContinue implements ILogicDecision{

	public boolean judge(TaskInstance arg0, SequenceFlow arg1, WfFormInfoCtx... arg2) {
		INmnbdadtlvlRService rs = ServiceFinder.find(INmnbdadtlvlRService.class);
		NmNbdAdtLvlDO[] arr = null;
		try {
			arr = rs.find("code='20180424'", "", FBoolean.TRUE);
		} catch (BizException e) {
			e.printStackTrace();
		}

		if (arr.length > 0) {
			if (arr[0].getSd_aduit_lvl().equals("01")) {
				return false;
			}
		}
		return true;
	}

}
