package iih.nm.nhr.nmnhrschedlv.i;

import java.util.Map;

import iih.nm.nhr.nmnhrschedlv.d.NmNhrSchedLVFormDO;
import iih.nm.nhr.nmnhrschedlv.d.NmNhrSchedLvDO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.bpmn.ProcessDefinition;
import xap.wf.af.bpmn.TaskActivity;
import xap.wf.af.contanier.ProDefsContainer;
import xap.wf.af.context.WfFlowInfoCtx;
import xap.wf.af.engine.IWfBillExtHandler;
import xap.wf.af.engine.TaskProcessUI;
import xap.wf.af.itf.IWfProDefQry;
import xap.wf.af.server.WfFormInfoCtx;
import xap.wf.af.services.WfServiceFacility;
import xap.wf.af.vos.d.WfProdefDO;

public class NmnhrschedlvListener  implements IWfBillExtHandler{
	@Override
	public WfFormInfoCtx[] write(WfFlowInfoCtx flwInfoCtx, WfFormInfoCtx... frmInfoCtx) {
		WfFormInfoCtx inner = frmInfoCtx[0];
		if (!(inner instanceof NmNhrSchedLVFormDO)) {
			return null;
		}
		NmNhrSchedLVFormDO billDo = (NmNhrSchedLVFormDO) inner;

		INmnhrschedlvCudService psnshiftCudService = ServiceFinder.find(INmnhrschedlvCudService.class);
		try {
			NmNhrSchedLvDO DO= billDo.getTransDo();
			psnshiftCudService.update(new NmNhrSchedLvDO[] { billDo.getTransDo() });
		} catch (BizException e) {

			e.printStackTrace();
		}
		return new WfFormInfoCtx[] { inner };
	}
	
	@Override
	public ProcessDefinition getProDefByFlowType(String flowTypePk, boolean isFormCache) {
		IWfProDefQry proDefQry = WfServiceFacility.getProDefQry();
		WfProdefDO[] proDefVos = proDefQry.getProDefByFlwTypePk(flowTypePk);
		return ProDefsContainer.getProDef(proDefVos[0]);
	}
	
	
	@Override
	public void afterDeleteProDef(ProcessDefinition arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterInsertProDef(ProcessDefinition arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterUpdateProDef(ProcessDefinition arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeShowDesigner(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, String> getFormFields(BaseDO arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskProcessUI getPersonlizationUrl(ProcessDefinition arg0, TaskActivity arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskProcessUI getPersonlizationUrl(ProcessDefinition arg0, TaskActivity arg1, WfFormInfoCtx arg2) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public WfFormInfoCtx getWfmFormInfoCtx(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
