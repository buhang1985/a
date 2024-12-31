package iih.mp.pub.wf;

import iih.mp.ot.dto.confirm.d.MpOtCondDTO;
import iih.mp.ot.dto.confirm.d.MpOtOrderInfoDTO;
import iih.mp.ot.i.IMpOtQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.bpmn.SequenceFlow;
import xap.wf.af.engine.ILogicDecision;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;
import xap.wf.af.context.PwfmContext;

public class MpExecConfirm implements ILogicDecision{

	/**
	 * 门诊医技执行流程
	 * @author sy 2017/06/19
	 *
	 */
	@Override
	public boolean judge(TaskInstance arg0, SequenceFlow arg1,
			WfFormInfoCtx... arg2) {
		
		IMpOtQryService priService = ServiceFinder.find(IMpOtQryService.class);
		MpOtCondDTO cond = new MpOtCondDTO();
		String id_pat = (String)PwfmContext.getContext("id_pat");
		String id_risdep = (String)PwfmContext.getContext("RisDep");
		String id_lisdep = (String)PwfmContext.getContext("LisDep");
		cond.setId_pat(id_pat);
		if(!StringUtil.isEmpty(id_risdep)){
			Context.get().setDeptId(id_risdep);
		}else if(!StringUtil.isEmpty(id_lisdep)){
			Context.get().setDeptId(id_lisdep);
		}		
		try {
			MpOtOrderInfoDTO[] dtolist = priService.getOpConfirmOrd(cond);
			
			if(!ArrayUtil.isEmpty(dtolist) && dtolist.length > 0){				
				return true;				
			}
		} catch (BizException e) {
			// TODO Auto-generated catch block		
			return false;
		}
		
		return false;
	}

}
