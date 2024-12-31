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

public class MpHerbDisp implements ILogicDecision {

	@Override
	public boolean judge(TaskInstance paramTaskInstance,
			SequenceFlow paramSequenceFlow,
			WfFormInfoCtx... paramArrayOfWfFormInfoCtx) {
		
		Context.get().setOrgId("0001HY1000000000OH85");
		Context.get().setGroupId("0001HH100000000001OE");
		Context.get().setDeptId("0001Z8100000000LPBZC");
		Context.get().setClientHost("c2e057be-51e8-48aa-aef2-ac3a1cd32631");
		
		OpDrugDispenseCondDTO cond = new OpDrugDispenseCondDTO();
		String id_pat = (String)PwfmContext.getContext("id_pat");
		cond.setId_pat(id_pat);
		cond.setFg_herb(FBoolean.TRUE);
		cond.setFg_dispensed(FBoolean.FALSE);
		
		IMpDgQryService service = ServiceFinder.find(IMpDgQryService.class);
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
