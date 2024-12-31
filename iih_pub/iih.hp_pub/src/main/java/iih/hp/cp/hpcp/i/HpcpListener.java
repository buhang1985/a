package iih.hp.cp.hpcp.i;

import iih.hp.cp.hpcp.d.HpcpAggDO;
import iih.hp.cp.hpcp.d.HpcpFormAggDO;

import java.util.Map;

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

public class HpcpListener implements IWfBillExtHandler {

	@Override
	public WfFormInfoCtx getWfmFormInfoCtx(String pk_frmins, String pk_flwtype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WfFormInfoCtx[] write(WfFlowInfoCtx flwInfoCtx,
			WfFormInfoCtx... frmInfoCtx) {
		WfFormInfoCtx inner = frmInfoCtx[0];
		
		if (!(inner instanceof HpcpFormAggDO)) {
			return null;
		} 
		HpcpFormAggDO billDo = (HpcpFormAggDO) inner;	
		
		IHpcpCudService iHpcpCudService = ServiceFinder.find(IHpcpCudService.class);
		try {
			iHpcpCudService.update(new HpcpAggDO[] {billDo});
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new WfFormInfoCtx[]{inner};
	}

	@Override
	public ProcessDefinition getProDefByFlowType(String flowTypePk,
			 boolean isFormCache) {
		IWfProDefQry proDefQry = WfServiceFacility.getProDefQry();
		WfProdefDO[] proDefVos = proDefQry.getProDefByFlwTypePk(flowTypePk);
		return ProDefsContainer.getProDef(proDefVos[0]);
	}

	@Override
	public void afterInsertProDef(ProcessDefinition proDef, boolean newversion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterUpdateProDef(ProcessDefinition proDef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeShowDesigner(String pk_prodef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterDeleteProDef(ProcessDefinition proDef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, String> getFormFields(BaseDO formvo, String id_prodef) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskProcessUI getPersonlizationUrl(ProcessDefinition proDef,
			TaskActivity task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskProcessUI getPersonlizationUrl(ProcessDefinition proDef,
			TaskActivity task, WfFormInfoCtx infoCtx) {
		// TODO Auto-generated method stub
		return null;
	}

}
