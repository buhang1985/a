package iih.bd.fc.querule.i;

import iih.bd.fc.querule.d.QueruleAggDO;
import xap.mw.core.data.BizException;

/**
 * 规则查询服务
 * @author yankan
 * @since date 2015-11-18
 *
 */
public interface IRuleQryService {
	/**
	 * 查询分诊台的规则
	 * @param benId 分诊台id
	 * @return
	 * @throws BizException
	 */
	QueruleAggDO getBenRule(String benId) throws BizException;
	/**
	 * 查询队列规则
	 * @param queId 队列id
	 * @return
	 * @throws BizException
	 */
	QueruleAggDO getQueRule(String queId) throws BizException;
	/**
	 * 查询工作点规则
	 * @param siteId 工作点id
	 * @return
	 * @throws BizException
	 */
	QueruleAggDO getSiteRule(String siteId) throws BizException;
}
