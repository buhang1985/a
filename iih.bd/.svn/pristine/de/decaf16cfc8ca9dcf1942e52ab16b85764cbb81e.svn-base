package iih.bd.pp.modifypriplan.s.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.pp.modifypriplan.d.ModifyPriPlanDO;
import iih.bd.pp.modifypriplan.i.IModifypriplanMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 停用调价计划业务逻辑
 * 
 * @author hao_wu 2019-3-26
 *
 */
public class DisableModifyPriPlanBp {

	public ModifyPriPlanDO[] exec(ModifyPriPlanDO[] modifyPriPlanDos) throws BizException {
		if (ArrayUtils.isEmpty(modifyPriPlanDos)) {
			throw new BizException("调价计划为空");
		}

		validate(modifyPriPlanDos);

		ModifyPriPlanDO[] result = disableModifyPriPlan(modifyPriPlanDos);

		return result;
	}

	/**
	 * 校验调价计划
	 * 
	 * @param modifyPriPlanDos
	 * @throws BizException
	 */
	private void validate(ModifyPriPlanDO[] modifyPriPlanDos) throws BizException {
		for (ModifyPriPlanDO modifyPriPlanDO : modifyPriPlanDos) {
			validate(modifyPriPlanDO);
		}
	}

	/**
	 * 校验调价计划
	 * 
	 * @param modifyPriPlanDO
	 * @throws BizException
	 */
	private void validate(ModifyPriPlanDO modifyPriPlanDO) throws BizException {
		if (FBoolean.TRUE.equals(modifyPriPlanDO.getFg_complete())) {
			String msg = String.format("调价计划\"%s\"已完成调价，不允许停用。", modifyPriPlanDO.getName());
			throw new BizException(msg);
		}
	}

	/**
	 * 停用调价计划
	 * 
	 * @param modifyPriPlanDos
	 * @return
	 * @throws BizException
	 */
	private ModifyPriPlanDO[] disableModifyPriPlan(ModifyPriPlanDO[] modifyPriPlanDos) throws BizException {
		for (ModifyPriPlanDO modifyPriPlanDO : modifyPriPlanDos) {
			modifyPriPlanDO.setFg_active(FBoolean.FALSE);
			modifyPriPlanDO.setStatus(DOStatus.UPDATED);
		}

		IModifypriplanMDOCudService modifypriplanMDOCudService = ServiceFinder.find(IModifypriplanMDOCudService.class);
		ModifyPriPlanDO[] result = modifypriplanMDOCudService.update(modifyPriPlanDos);
		return result;
	}

}
