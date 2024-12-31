package iih.en.que.i;

import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueRuleItmDO;
import xap.mw.core.data.BizException;

/**
 * 计算优先级服务
 * @author yankan
 * @since date 2015-11-20
 *
 */
public interface ICalcPriService {	
	/**
	 * 获取计算优先级的患者信息
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	PriorityDTO getEntInfo4CalPri(String entId) throws BizException;
	/**
	 * 得到门急诊就诊优先级的规则明细
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	QueRuleItmDO getMatchRuleItm(String entId) throws BizException;
	/**
	 * 获取就诊优先级的规则明细
	 * @param entId 就诊id
	 * @param queId 队列id
	 * @return
	 * @throws BizException
	 */
	QueRuleItmDO getRuleItmByEntIdAndQueId(String entId, String queId) throws BizException;
}
