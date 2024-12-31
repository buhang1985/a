package iih.ci.ord.s.bp.cfg.rulecfg.validator.drug.excessive.tl;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ems.d.CiEmsDTO;

/**
 * 超量开单原因 - 无超量情况<br>
 * 门诊默认最大 开药天数 7 天
 * 
 * @author HUMS
 *
 */
public class ExcessiveReasonNormalOpValidator extends AbstractExcessiveDrugValidator {

	@Override
	protected String getExcessiveReasonIdentity() {
		//无超量情况
		return ICiDictCodeConst.ID_EXCESSIVE_REASON_NORMAL;
	}

	@Override
	protected String getExcessiveReasonMsg() {

		return "门诊";
	}

	@Override
	protected int getDefaultUseDays() {
		return 7;
	}
	
	@Override
	protected boolean isConformToTheRules(CiEmsDTO ciEms) {
		
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ciEms.getCode_entp())){
			return true;
		}
		return false;
	}
}
