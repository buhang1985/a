package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdSrvTpDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据服务类型分方 010101口服类药品
 * @author HUMS
 *
 */
public class PresBySdSrvtpOral extends AbstractSinglePresRuleExecutor{

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {
		
		if(IBdSrvTpDictCodeConst.SD_SRVTP_WESTDRUG_KF.equals(orderPresSplit.getSd_srvtp())){
			return true;
		}
		
		return false;
	}

}
