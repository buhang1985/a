package iih.bd.pp.modifypriplan.s;

import iih.bd.base.utils.AppUtils;
import iih.bd.pp.modifypriplan.d.ModifyPriPlanDO;
import iih.bd.pp.modifypriplan.d.ModifyPriPlanItmDO;
import iih.bd.pp.modifypriplan.d.ModifypriplanAggDO;
import iih.bd.pp.modifypriplan.i.IModifyPriPlanExtCudService;
import iih.bd.pp.modifypriplan.i.IModifyPriPlanExtRService;
import iih.bd.pp.modifypriplan.s.bp.DisableModifyPriPlanBp;
import iih.bd.pp.modifypriplan.s.bp.EnableModifyPriPlanBp;
import iih.bd.pp.modifypriplan.s.bp.GetModifyplanAggDOBp;
import iih.bd.pp.modifypriplan.s.bp.ModifyPriceByPlanIdsBp;
import iih.bd.pp.modifypriplan.s.bp.UpdatePriMaxAndNowPriceBp;
import xap.mw.core.data.BizException;

/**
 * 调价计划节点调价服务实现
 * 
 * @author guoyang
 * 
 */
public class ModifyPriPlanExtServiceImpl implements IModifyPriPlanExtCudService, IModifyPriPlanExtRService {

	@Override
	public ModifypriplanAggDO findModifypriplanAggDo(String id_mdo) throws BizException {
		GetModifyplanAggDOBp aggDOBp = new GetModifyplanAggDOBp();
		return aggDOBp.exec(id_mdo);
	}

	@Override
	public ModifyPriPlanItmDO updatePlanItmDORefInfo(ModifyPriPlanItmDO planItmDo, String id_pripat)
			throws BizException {
		UpdatePriMaxAndNowPriceBp bp = new UpdatePriMaxAndNowPriceBp();
		bp.exec(new ModifyPriPlanItmDO[] { planItmDo }, id_pripat);
		return planItmDo;
	}

	@Override
	public ModifyPriPlanDO[] enable(ModifyPriPlanDO[] modifyPriPlanDos) throws BizException {
		EnableModifyPriPlanBp bp = new EnableModifyPriPlanBp();
		ModifyPriPlanDO[] result = bp.exec(modifyPriPlanDos);
		return result;
	}

	@Override
	public ModifyPriPlanDO[] disable(ModifyPriPlanDO[] modifyPriPlanDos) throws BizException {
		DisableModifyPriPlanBp bp = new DisableModifyPriPlanBp();
		ModifyPriPlanDO[] result = bp.exec(modifyPriPlanDos);
		return result;
	}

	@Override
	public void modifyPriceByIds(String[] planIds) throws BizException {
		ModifyPriceByPlanIdsBp bp = new ModifyPriceByPlanIdsBp();
		bp.exec(planIds, AppUtils.getServerDateTime());
	}
}
