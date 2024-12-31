package iih.mp.pub.wf;

import iih.mp.dg.dto.opdgdisp.d.OpDrugDispenseCondDTO;
import iih.mp.dg.dto.opdgdisp.d.PresDTO;
import iih.mp.dg.i.IMpDgQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.bpmn.SequenceFlow;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.engine.ILogicDecision;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class MpDrugDisp implements ILogicDecision {

	@Override
	public boolean judge(TaskInstance arg0, SequenceFlow arg1,
			WfFormInfoCtx... arg2) {
		
		Context.get().setOrgId("0001HY1000000000OH85");
		Context.get().setGroupId("0001HH100000000001OE");
		Context.get().setDeptId("0001Z8100000000LPBZ6");
		Context.get().setClientHost("93a324b0-9bb7-4751-9fd6-420e7b3ddb9a");
		
		OpDrugDispenseCondDTO cond = new OpDrugDispenseCondDTO();
		String id_pat = (String)PwfmContext.getContext("id_pat");
		cond.setId_pat(id_pat);
		cond.setFg_herb(FBoolean.FALSE);
		cond.setFg_dispensed(FBoolean.FALSE);
		
//		IMpDgQryService service = ServiceFinder.find(IMpDgQryService.class);
//		try {
//			PresDTO[] dtos = service.getOpPatNoDrugPreses2(cond, false);
//			if(!ArrayUtil.isEmpty(dtos) &&dtos.length > 0) {				
//				return true;				
//			}
//		} catch (BizException e) {
//			return false;
//		}
		return false;
	}

}
