package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 根据是否为草药院内制剂进行分方<br/>
 * 院内制剂一个处方，非院内制剂一个处方
 * 
 * @author HUMS
 *
 */
public class PresByHospitalHerb extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		if (FBoolean.TRUE.equals(orderPresSplit.getFg_hospital_herbpres())) {
			return true;
		}
		return false;
	}
}
