package iih.bd.srv.qcmraddrule.s.rule;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.qcmraddrule.d.QcmraddpreruleDO;
import iih.bd.srv.qcmraddrule.d.QcmraddruleDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 病历新建规则子数据数量检查规则
 * 
 * @author hao_wu
 *
 */
public class QcmraddruleDOItemDataCountCheckRule implements IRule<QcmraddruleDO> {

	@Override
	public void process(QcmraddruleDO... arg0) throws BizException {
		for (QcmraddruleDO qcmraddruleDO : arg0) {
			checkItemCount(qcmraddruleDO);
		}
	}

	/**
	 * 检查子数据数量
	 * 
	 * @param qcmraddruleDO
	 * @throws BizException
	 */
	private void checkItemCount(QcmraddruleDO qcmraddruleDO) throws BizException {
		if (qcmraddruleDO == null || qcmraddruleDO.getFg_enable().booleanValue() != true
				|| qcmraddruleDO.getId_rule() == null || StringUtils.isBlank(qcmraddruleDO.getId_rule().trim())) {
			return;
		}
		int count = getQcmraddpreruleCount(qcmraddruleDO);
		if (count <= 0) {
			String msg = String.format("%s+%s规则中，前提条件列表不允许为空。", qcmraddruleDO.getName_mrcactm(),
					qcmraddruleDO.getName_mrtp());
			throw new BizException(msg);
		}
	}

	/**
	 * 获取子数据数量
	 * 
	 * @param qcmraddruleDO
	 * @return
	 * @throws BizException
	 */
	private int getQcmraddpreruleCount(QcmraddruleDO qcmraddruleDO) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) ");
		sql.append(String.format(" from %s where 1 = 1 ", new QcmraddpreruleDO().getTableName()));
		sql.append(String.format("and id_rule = '%s'", qcmraddruleDO.getId_rule()));
		try {
			@SuppressWarnings("unchecked")
			List<Integer> result = (List<Integer>) new DAFacade().execQuery(sql.toString(), new ColumnListHandler());
			if (result != null && result.size() == 1) {
				return result.get(0);
			}
		} catch (DAException e) {
			e.printStackTrace();
			throw new BizException(e);
		}
		return 0;
	}

}
