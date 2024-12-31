package iih.bd.srv.qcmraddrule.s.rule;

import iih.bd.srv.qcmraddrule.d.QcmraddpreruleDO;
import iih.bd.srv.qcmraddrule.d.QcmraddruleAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.appfw.bizrule.IRule;

/**
 * 病历新建规则子数据数量检查规则
 * 
 * @author hao_wu
 *
 */
public class QcmraddruleAggDOItemDataCountCheckRule implements IRule<QcmraddruleAggDO> {

	@Override
	public void process(QcmraddruleAggDO... arg0) throws BizException {
		for (QcmraddruleAggDO qcmraddruleAggDO : arg0) {
			CheckItemDataCount(qcmraddruleAggDO);
		}
	}

	/**
	 * 检查子数据数量
	 * 
	 * @param qcmraddruleAggDO
	 * @throws BizException
	 */
	private void CheckItemDataCount(QcmraddruleAggDO qcmraddruleAggDO) throws BizException {
		if (qcmraddruleAggDO == null || qcmraddruleAggDO.getParentDO().getFg_enable().booleanValue() != true) {
			return;
		}

		QcmraddpreruleDO[] itemArray = qcmraddruleAggDO.getQcmraddpreruleDO();
		int count = GetItemDataCount(itemArray);
		if (count <= 0) {
			String msg = String.format("%s+%s规则中，前提条件列表不允许为空。", qcmraddruleAggDO.getParentDO().getName_mrcactm(),
					qcmraddruleAggDO.getParentDO().getName_mrtp());
			throw new BizException(msg);
		}
	}

	/**
	 * 检查子数据数量
	 * 
	 * @param itemArray
	 */
	private int GetItemDataCount(QcmraddpreruleDO[] itemArray) {
		int count = 0;
		if (itemArray != null) {
			for (QcmraddpreruleDO qcmraddpreruleDO : itemArray) {
				if (qcmraddpreruleDO.getStatus() == DOStatus.DELETED) {
					continue;
				}
				count++;
			}
		}
		return count;
	}

}
