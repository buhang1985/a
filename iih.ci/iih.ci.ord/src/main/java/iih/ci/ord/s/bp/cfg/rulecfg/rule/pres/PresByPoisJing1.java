package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

public class PresByPoisJing1  extends AbstractSinglePresRuleExecutor{

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {
		// TODO Auto-generated method stub
		if (IBdMmDictCodeConst.SD_POIS_JINGSHEN_1.equals(orderPresSplit.getSd_pois())) {

			return true;
		}
		return false;
	}
	
	@Override
	protected String getPresIdentification(OrderPresSplitDTO orderPresSplit) {

		if (IBdMmDictCodeConst.SD_POIS_JINGSHEN_1.equals(orderPresSplit.getSd_pois())) {

			return orderPresSplit.getId_or();
		}
		
		return this.getClass().getName();
	}

}
