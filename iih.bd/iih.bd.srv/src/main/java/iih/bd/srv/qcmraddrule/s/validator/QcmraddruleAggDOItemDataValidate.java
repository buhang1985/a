package iih.bd.srv.qcmraddrule.s.validator;

import iih.bd.srv.qcmraddrule.d.QcmraddruleAggDO;
import iih.bd.srv.qcmraddrule.s.bp.QcmraddruleAggDOItemCountValidateBp;
import iih.bd.srv.qcmraddrule.s.bp.QcmraddruleAggDOItemMrTpValidateBp;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 病历新建规则前提条件数据检查
 * 
 * @author hao_wu
 *
 */
public class QcmraddruleAggDOItemDataValidate implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4418142642054505073L;

	/**
	 * 校验病历新建规则子数据数量
	 */
	@Override
	public ValidationFailure validate(Object... aobj) {

		for (Object obj : aobj) {
			if (obj instanceof QcmraddruleAggDO) {
				String result = itemCountValidate((QcmraddruleAggDO) obj);
				if (result != null) {
					return new ValidationFailure(result);
				}
				result = mrTpValidate((QcmraddruleAggDO) obj);
				if (result != null) {
					return new ValidationFailure(result);
				}
			}
		}
		return null;
	}

	/**
	 * 医疗记录类型检查
	 * 
	 * @param qcmraddruleAggDO
	 * @return
	 */
	private String mrTpValidate(QcmraddruleAggDO qcmraddruleAggDO) {
		QcmraddruleAggDOItemMrTpValidateBp bp = new QcmraddruleAggDOItemMrTpValidateBp();
		String result = bp.exec(qcmraddruleAggDO);
		return result;
	}

	/**
	 * 前提条件个数检查
	 * 
	 * @param obj
	 * @return
	 */
	private String itemCountValidate(QcmraddruleAggDO obj) {
		QcmraddruleAggDOItemCountValidateBp bp = new QcmraddruleAggDOItemCountValidateBp();
		String result = bp.exec((QcmraddruleAggDO) obj);
		return result;
	}
}
