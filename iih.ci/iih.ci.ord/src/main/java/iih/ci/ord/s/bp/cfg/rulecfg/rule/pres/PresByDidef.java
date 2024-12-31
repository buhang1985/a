package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import xap.sie.common.utils.StringUtils;

/**
 * 根据医嘱关联诊断分方
 * 
 * @author zhangwq
 *
 */
public class PresByDidef extends AbstractSinglePresRuleExecutor {

	/**
	 *  根据医嘱关联诊断分方
	 */
	@Override
	protected String getPresIdentification(OrderPresSplitDTO orderPresSplit) {
		if(StringUtils.isEmpty(orderPresSplit.getId_didef())){
			return PresByDidef.class.getSimpleName();
		}
		return orderPresSplit.getId_didef();
	}
	/**
	 * 如果超量开单原因是慢病时，才根据医嘱关联诊断分方
	 */
	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {
		String excessive_reason = orderPresSplit.getSd_excessive_reason();
		if (ICiDictCodeConst.SD_EXCESSIVE_REASON_CHRONIC.equals(excessive_reason)) {
			return true;
		}
		return false;
	}

}
