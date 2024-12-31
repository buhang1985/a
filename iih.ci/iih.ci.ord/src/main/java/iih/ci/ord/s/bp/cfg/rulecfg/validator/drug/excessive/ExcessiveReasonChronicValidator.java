package iih.ci.ord.s.bp.cfg.rulecfg.validator.drug.excessive;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ems.d.CiEmsDTO;

/**
 * 超量开单原因 - 慢性病<br>
 * 默认最大 开药天数 30 天
 * 
 * @author HUMS
 *
 */
public class ExcessiveReasonChronicValidator extends AbstractExcessiveDrugValidator {

	@Override
	protected String getExcessiveReasonIdentity() {

		// 慢性病
		return ICiDictCodeConst.ID_EXCESSIVE_REASON_CHRONIC;
	}

	@Override
	protected String getExcessiveReasonMsg() {
		return "慢性病";
	}

	@Override
	protected int getDefaultUseDays() {

		return 30;
	}

	@Override
	protected boolean isConformToTheRules(CiEmsDTO ciEms) {
		// TODO Auto-generated method stub
		return true;
	}

}
