package iih.bd.srv.qcmraddrule.s.bp;

import iih.bd.srv.qcmraddrule.d.QcmraddpreruleDO;
import iih.bd.srv.qcmraddrule.d.QcmraddruleAggDO;
import xap.mw.core.data.DOStatus;

/**
 * 病历新建规则前提条件数量检查逻辑
 * 
 * @author hao_wu
 *
 */
public class QcmraddruleAggDOItemCountValidateBp {

	public String exec(QcmraddruleAggDO qcmraddruleAggDO) {
		if (qcmraddruleAggDO == null || qcmraddruleAggDO.getParentDO().getFg_enable().booleanValue() != true) {
			return null;
		}

		QcmraddpreruleDO[] itemArray = qcmraddruleAggDO.getQcmraddpreruleDO();
		int count = GetItemDataCount(itemArray);
		if (count <= 0) {
			String msg = String.format("%s+%s规则中，前提条件列表不允许为空。", qcmraddruleAggDO.getParentDO().getName_mrcactm(),
					qcmraddruleAggDO.getParentDO().getName_mrtp());
			return msg;
		}
		return null;
	}

	/**
	 * 获取子数据数量
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
