package iih.bd.pp.modifypriplan.s.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.pp.modifypriplan.d.ModifyPriPlanDO;
import iih.bd.pp.modifypriplan.i.IModifypriplanMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 启用调价计划业务逻辑
 * 
 * @author hao_wu 2019-3-26
 *
 */
public class EnableModifyPriPlanBp {

	public ModifyPriPlanDO[] exec(ModifyPriPlanDO[] modifyPriPlanDos) throws BizException {
		if (ArrayUtils.isEmpty(modifyPriPlanDos)) {
			throw new BizException("调价计划为空");
		}

		ModifyPriPlanDO[] result = enableModifyPriPlan(modifyPriPlanDos);
		return result;
	}

	/**
	 * 启用调价计划
	 * 
	 * @param modifyPriPlanDos
	 * @return
	 * @throws BizException
	 */
	private ModifyPriPlanDO[] enableModifyPriPlan(ModifyPriPlanDO[] modifyPriPlanDos) throws BizException {
		for (ModifyPriPlanDO modifyPriPlanDO : modifyPriPlanDos) {
			modifyPriPlanDO.setFg_active(FBoolean.TRUE);
			modifyPriPlanDO.setStatus(DOStatus.UPDATED);
		}

		IModifypriplanMDOCudService modifypriplanMDOCudService = ServiceFinder.find(IModifypriplanMDOCudService.class);
		ModifyPriPlanDO[] result = modifypriplanMDOCudService.update(modifyPriPlanDos);
		return result;
	}

}
