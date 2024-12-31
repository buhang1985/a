package iih.bd.pp.modifypriplan.s.bp;

import iih.bd.pp.modifypriplan.d.ModifyPriPlanDO;
import iih.bd.pp.modifypriplan.d.ModifyPriPlanItmDO;
import iih.bd.pp.modifypriplan.d.ModifypriplanAggDO;
import iih.bd.pp.modifypriplan.i.IModifypriplanRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class GetModifyplanAggDOBp {

	public ModifypriplanAggDO exec(String id_mdo) throws BizException {
		IModifypriplanRService modifypriplanRService = ServiceFinder.find(IModifypriplanRService.class);
		ModifypriplanAggDO modifypriplanAggDO = modifypriplanRService.findById(id_mdo);
		addPriMaxAndNowPrice(modifypriplanAggDO);
		return modifypriplanAggDO;
	}

	/**
	 * 调价计划明细的服务对应的医保限价字段和当前标准价格字段赋值
	 * 
	 * @param modifypriplanAggDO
	 * @return
	 * @throws BizException
	 */
	private void addPriMaxAndNowPrice(ModifypriplanAggDO modifypriplanAggDO) throws BizException {
		ModifyPriPlanItmDO[] modifyPriPlanItmDOs = modifypriplanAggDO.getModifyPriPlanItmDO();
		ModifyPriPlanDO planDo = modifypriplanAggDO.getParentDO();
		UpdatePriMaxAndNowPriceBp bp = new UpdatePriMaxAndNowPriceBp();
		bp.exec(modifyPriPlanItmDOs, planDo.getId_pripat());
	}
}
