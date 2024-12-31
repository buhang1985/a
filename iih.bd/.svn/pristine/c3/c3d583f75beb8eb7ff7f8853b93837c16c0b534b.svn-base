package iih.bd.srv.emrtpl.s;
import java.util.Map;

import iih.bd.srv.emrtpl.d.EmrtplAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.DOStatus;
import xap.wf.af.bpmn.ProcessDefinition;
import xap.wf.af.bpmn.TaskActivity;
import xap.wf.af.contanier.ProDefsContainer;
import xap.wf.af.context.WfFlowInfoCtx;
import xap.wf.af.engine.IWfBillExtHandler;
import xap.wf.af.engine.TaskProcessUI;
import xap.wf.af.exception.WfRuntimeException;
import xap.wf.af.itf.IWfProDefQry;
import xap.wf.af.server.WfFormInfoCtx;
import xap.wf.af.services.WfServiceFacility;
import xap.wf.af.vos.d.WfProdefDO;
/**
 * 业务流,默认扩展实现类，
 * 
 * @author Bai_He
 *
 */
public class SeeDoctorFormOperator implements IWfBillExtHandler {
	@Override
	public void afterDeleteProDef(ProcessDefinition proDef) {
		// TODO Auto-generated method stub
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
	public Map<String, String> getFormFields(BaseDO formvo, String id_prodef) {
		return null;
	}
	@Override
	public TaskProcessUI getPersonlizationUrl(ProcessDefinition proDef, TaskActivity task) {
		return null;
	}
	@Override
	public ProcessDefinition getProDefByFlowType(String flowTypePk,  boolean isFormCache) {
		IWfProDefQry proDefQry = WfServiceFacility.getProDefQry();
		WfProdefDO[] proDefVos = proDefQry.getProDefByFlwTypePk(flowTypePk);
		return ProDefsContainer.getProDef(proDefVos[0]);
	}
	@Override
	public WfFormInfoCtx getWfmFormInfoCtx(String pk_frmins, String pk_flwtype) {
		return null;
	}
	@Override
	public WfFormInfoCtx[] write(WfFlowInfoCtx flwInfoCtx, WfFormInfoCtx... frmInfoCtx) {
		if (frmInfoCtx.length == 1) { 
			WfFormInfoCtx billInfo = frmInfoCtx[0];
			if (billInfo instanceof EmrtplAggDO) {
				//这里应该根据单据的状态   判断这个单据是不是审核通过或者驳回或者有其他正常的操作状态  再回写更新到数据库中
				EmrtplAggDO aggDo = (EmrtplAggDO) billInfo;
				EmrtplCrudServiceImpl service = new EmrtplCrudServiceImpl();
				if (aggDo.getParent().getPkVal() == null) {
					try {
						service.insert(new EmrtplAggDO[] { aggDo });
					} catch (Throwable e) {
						throw new WfRuntimeException(e.getMessage());
					}
				} else {
					try {
						aggDo.getParentDO().setStatus(DOStatus.UPDATED);
						service.update(new EmrtplAggDO[] { aggDo });
					} catch (Throwable e) {
						throw new WfRuntimeException(e.getMessage());
					}
				}
			}
		}
		return frmInfoCtx;
	}
	@Override
	public TaskProcessUI getPersonlizationUrl(ProcessDefinition proDef, TaskActivity task, WfFormInfoCtx infoCtx) {
		// TODO Auto-generated method stub
		return null;
	}
}
