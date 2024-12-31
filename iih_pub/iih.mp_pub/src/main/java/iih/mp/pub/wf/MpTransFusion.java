package iih.mp.pub.wf;

import iih.mp.dg.dto.druginfudto.d.OpInfuCondDTO;
import iih.mp.dg.dto.druginfudto.d.OpInfuPatOrDTO;
import iih.mp.dg.i.IMpDgQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.bpmn.SequenceFlow;
import xap.wf.af.engine.ILogicDecision;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;
import xap.wf.af.context.PwfmContext;

public class MpTransFusion implements ILogicDecision{

	/**
	 * 门诊输液流程
	 * @author sy 2017/06/19
	 *
	 */
	@Override
	public boolean judge(TaskInstance arg0, SequenceFlow arg1,
			WfFormInfoCtx... arg2) {
		IMpDgQryService priService = ServiceFinder.find(IMpDgQryService.class);
		String id_pat = (String)PwfmContext.getContext("id_pat");
		Context.get().setStuffId("0001Z8100000000MPZ32");
		Context.get().setOrgId("0001HY1000000000OH85");
		Context.get().setGroupId("0001HH100000000001OE");
		Context.get().setDeptId("0001Z8100000000MI7T8");
		OpInfuCondDTO condQry = new OpInfuCondDTO();
		condQry.setId_pat(id_pat);
		try {
			OpInfuPatOrDTO[] dtos = priService.getOpInfuPatOrData(condQry,true);
			if(!ArrayUtil.isEmpty(dtos) &&dtos.length > 0){				
				return true;				
			}
		} catch (BizException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return false;
	}

}
