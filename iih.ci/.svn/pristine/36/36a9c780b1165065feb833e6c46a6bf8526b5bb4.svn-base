package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.ISysDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据临床专业类型编码是否为儿科进行分方
 * @author HUMS
 *
 */
public class PresByClinicalProfessionTp extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		if (ISysDictCodeConst.SD_CLINICALPROFESSIONTP_EK.equals(orderPresSplit.getSd_clinicalprofessiontp())){
			return true;
		}	
		
		return false;
	}

}
