package iih.ci.ord.s.bp.cfg.rulecfg.validator.drug.excessive;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ems.d.CiEmsDTO;

/**
 * 超量开单原因 - 无超量情况<br>
 * 默认最大 开药天数 7 天
 * 
 * @author HUMS
 *
 */
public class ExcessiveReasonNormalValidator extends AbstractExcessiveDrugValidator {

	protected boolean validate(EmsDrugItemDO t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getExcessiveReasonIdentity() {
		//无超量情况
		return ICiDictCodeConst.ID_EXCESSIVE_REASON_NORMAL;
	}

	@Override
	protected String getExcessiveReasonMsg() {

		return "无超量情况";
	}

	@Override
	protected int getDefaultUseDays() {
		return 7;
	}

	protected boolean isConformToTheRules(EmsDrugItemDO drugItem) {

		return false;
	}

	@Override
	protected boolean isConformToTheRules(CiEmsDTO ciEms) {
		// TODO Auto-generated method stub
		return false;
	}
}
