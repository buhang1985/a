package iih.ci.ord.s.bp.cfg.rulecfg.validator.drug.excessive.tl;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ems.d.CiEmsDTO;

/**
 * 超量开单原因 - 无超量情况<br>
 * 急诊默认最大 开药天数 3 天
 * 
 * @author HUMS
 *
 */
public class ExcessiveReasonNormalIpValidator extends AbstractExcessiveDrugValidator {

	@Override
	protected String getExcessiveReasonIdentity() {
		// 无超量情况
		return ICiDictCodeConst.ID_EXCESSIVE_REASON_NORMAL;
	}

	@Override
	protected String getExcessiveReasonMsg() {

		return "急诊";
	}

	@Override
	protected int getDefaultUseDays() {
		return 3;
	}

	@Override
	protected boolean isConformToTheRules(CiEmsDTO ciEms) {
		
		if(ciEms.getCode_entp().startsWith(IBdFcDictCodeConst.SD_CODE_ENTP_ET)){
			return true;
		}
		return false;
	}
}
