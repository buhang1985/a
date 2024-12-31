package iih.bd.srv.qcmraddrule.s.bp;

import iih.bd.srv.qcmraddrule.d.QcmraddpreruleDO;
import iih.bd.srv.qcmraddrule.d.QcmraddruleAggDO;
import iih.bd.srv.qcmraddrule.d.QcmraddruleDO;
import xap.mw.core.data.DOStatus;

/**
 * 病历新建规则前提条件医疗记录类型检查逻辑
 * 
 * @author hao_wu
 *
 */
public class QcmraddruleAggDOItemMrTpValidateBp {

	public String exec(QcmraddruleAggDO qcmraddruleAggDO) {
		if (qcmraddruleAggDO == null) {
			return null;
		}

		String msg = itemMrtpValidate(qcmraddruleAggDO);
		return msg;
	}

	/**
	 * 医疗记录类型检查
	 * 
	 * @param qcmraddruleAggDO
	 * @return
	 */
	private String itemMrtpValidate(QcmraddruleAggDO qcmraddruleAggDO) {
		QcmraddruleDO qcmraddruleDO = qcmraddruleAggDO.getParentDO();
		QcmraddpreruleDO[] preRules = qcmraddruleAggDO.getQcmraddpreruleDO();
		for (QcmraddpreruleDO qcmraddpreruleDO : preRules) {
			if (qcmraddpreruleDO.getStatus() != DOStatus.DELETED && qcmraddpreruleDO.getFg_must_exist() != null
					&& qcmraddpreruleDO.getFg_must_exist().booleanValue() == true
					&& qcmraddpreruleDO.getId_mrtp() != null && qcmraddruleDO.getId_mrtp() != null
					&& qcmraddpreruleDO.getId_mrtp().equals(qcmraddruleDO.getId_mrtp())) {
				String msg = String.format("%s+%s规则前提条件列表中医疗记录类型与规则中医疗记录类型重复。", qcmraddruleDO.getName_mrcactm(),
						qcmraddruleDO.getName_mrtp());
				return msg;
			}
		}
		return null;
	}

}
