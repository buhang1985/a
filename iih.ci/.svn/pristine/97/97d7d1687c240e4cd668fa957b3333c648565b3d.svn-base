package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 
 * 根据药品类型和注射剂生成处方<br>
 * 中成药处方中的注射剂单独成方（药品类型为中成药）
 * 
 * @author zhangwq
 *
 */
public class PresBySdMmtpDrugChiapZXSolution extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		if (IBdMmDictCodeConst.SD_MMTP_DRUG_CHIPA.equals(orderPresSplit.getSd_mmtp())
				&&IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_ZX.equals(orderPresSplit.getSd_srvtp())) {
			return true;
		}
		return false;
	}

}
