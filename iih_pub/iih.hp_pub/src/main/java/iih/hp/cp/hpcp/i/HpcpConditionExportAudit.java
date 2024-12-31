package iih.hp.cp.hpcp.i;

import java.util.List;

import iih.hp.cp.hpcp.d.HpcpFormAggDO;
import iih.hp.cp.hpcp.d.Owtp;
import iih.hp.cp.i.IHpCpFlowSysParamConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.permfw.role.d.RoleDO;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
import xap.wf.af.bpmn.SequenceFlow;
import xap.wf.af.engine.ILogicDecision;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

/**
 * 
 * @author chenxiang
 *
 * @date 2019年9月18日下午5:20:51
 *
 * @classpath iih.hp.cp.hpcp.i.HpcpConditionOrgAudit
 *
 * 医务部审核条件<br/> 
 * 匹配临床路径参数模板中对应科室审核角色
 */
public class HpcpConditionExportAudit implements ILogicDecision {

	@Override
	public boolean judge(TaskInstance taskInstance, SequenceFlow sequenceFlow, WfFormInfoCtx... wfFormInfoCtx) {
		
		if(!(wfFormInfoCtx[0] instanceof HpcpFormAggDO)) {
			return false;
		}
		HpcpFormAggDO billDo = (HpcpFormAggDO) wfFormInfoCtx[0];
		//如果当前临床路径信息的计划所属类型是全院，则不走科主任审核流程，直接走医务部审核。
		if (Owtp.GLOBAL.equals(billDo.getParentDO().getEu_owtp())) {
			return true;
		}
		
		// 科室审批角色编码
		String deptApproveRoleCode = "";
		try {
			deptApproveRoleCode = ParamsetQryUtil.getParaString(Context.get().getOrgId(), IHpCpFlowSysParamConst.SYS_PARAM_FLOW_DEPT_APPROVE);
		} catch (BizException e) {
			e.printStackTrace();
		}
		
		List<RoleDO> roleList = new HpcpConditionCommons().getRoleListByUserId(Context.get().getUserId());
		for (RoleDO role : roleList) {
			if (deptApproveRoleCode.equals(role.getCode())) {
				return true;
			}
		}
		return false;
	}
}
