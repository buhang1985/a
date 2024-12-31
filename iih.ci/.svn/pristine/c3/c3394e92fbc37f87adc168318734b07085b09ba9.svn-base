package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdSrvTpDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据服务类型分方 010103注射类药品、010104溶媒、010105皮试液
 * @author HUMS
 *
 */
public class PresBySdSrvtpInjection extends AbstractSinglePresRuleExecutor{

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		if(IBdSrvTpDictCodeConst.SD_SRVTP_WESTDRUG_ZX.equals(orderPresSplit.getSd_srvtp()) || 
				IBdSrvTpDictCodeConst.SD_SRVTP_WESTDRUG_DSY.equals(orderPresSplit.getSd_srvtp()) || 
				IBdSrvTpDictCodeConst.SD_SRVTP_WESTDRUG_PSY.equals(orderPresSplit.getSd_srvtp())){
			return true;
		}
		
		return false;
		
	}

}
