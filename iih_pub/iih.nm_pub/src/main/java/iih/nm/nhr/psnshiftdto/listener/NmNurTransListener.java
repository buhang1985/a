package iih.nm.nhr.psnshiftdto.listener;

import java.util.Map;

import iih.nm.nhr.nmpsnshift.d.NmNurTransDO;
import iih.nm.nhr.nmpsnshift.i.INmpsnshiftCudService;
import iih.nm.nhr.psnshiftdto.d.NmNurTransFormDO;
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

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年1月4日 下午7:50:26
 * 类说明：
 * Company: Copyright 2016 by PKU healthcare IT Co.Ltd.
 */
public class NmNurTransListener implements IWfBillExtHandler{

	@Override
	public WfFormInfoCtx[] write(WfFlowInfoCtx flwInfoCtx,
			WfFormInfoCtx... frmInfoCtx) {
		WfFormInfoCtx inner = frmInfoCtx[0];
		
		if (!(inner instanceof NmNurTransFormDO)) {
			return null;
		} 
		NmNurTransFormDO formDO = (NmNurTransFormDO) inner;	
		
		INmpsnshiftCudService cudService = ServiceFinder.find(INmpsnshiftCudService.class);
		try {
			cudService.update(new NmNurTransDO[] {formDO});
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
