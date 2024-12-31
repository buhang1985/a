package iih.bd.srv.qcmraddrule.s.rule;

import iih.bd.srv.qcmraddrule.d.QcmraddruleAggDO;
import iih.bd.srv.qcmraddrule.d.QcmraddruleDO;
import iih.bd.srv.qcmraddrule.i.IQcmraddruleRService;
import iih.bd.srv.qcmraddrule.s.bp.QcmraddruleAggDOItemCountValidateBp;
import iih.bd.srv.qcmraddrule.s.bp.QcmraddruleAggDOItemMrTpValidateBp;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;

/**
 * 病历新建规则子数据数量检查规则
 * 
 * @author hao_wu
 *
 */
public class QcmraddruleDOItemDataValidateRule implements IRule<QcmraddruleDO> {

	@Override
	public void process(QcmraddruleDO... arg0) throws BizException {
		IQcmraddruleRService qcmraddruleRService = ServiceFinder.find(IQcmraddruleRService.class);
		for (QcmraddruleDO qcmraddruleDO : arg0) {
			if (qcmraddruleDO == null || qcmraddruleDO.getId_rule() == null) {
				continue;
			}
			QcmraddruleAggDO qcmraddruleAggDO = qcmraddruleRService.findById(qcmraddruleDO.getId_rule());
			qcmraddruleAggDO.setParentDO(qcmraddruleDO);
			String msg = itemCountValidate(qcmraddruleAggDO);
			if (msg != null) {
				throw new BizException(msg);
			}
			msg = mrTpValidate(qcmraddruleAggDO);
			if (msg != null) {
				throw new BizException(msg);
			}
		}
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
