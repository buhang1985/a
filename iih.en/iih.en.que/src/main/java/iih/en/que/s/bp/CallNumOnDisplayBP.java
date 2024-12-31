package iih.en.que.s.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.validator.EnValidator;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.s.event.bp.EnOpQueEventBP;
import xap.mw.core.data.BizException;
/**
 * 叫号（只上屏，不改状态）
 * @author renying
 *
 */
public class CallNumOnDisplayBP {

	/**
	 * 叫号（只上屏，不改状态）
	 * 
	 * @param que 出诊队列
	 * @param queSite 出诊站点
	 * @param date 当前日期
	 * @param dayslotId 当前时间分组ID
	 * @return
	 * @throws BizException
	 * @author renying
	 */
	public EnQueueDO exec(QueDO que, QueSiteDO queSite,  String entId,String enQueId) throws BizException {
		EnValidator.validateParam("医生出诊队列", que);
		EnValidator.validateParam("医生工作站点", queSite);
		EnValidator.validateParam("当前叫号患者", entId);
		//触发叫号事件
		//站点已经下线就不能叫号
		BdSiteEP siteEp = new BdSiteEP();
		siteEp.siteError(queSite.getId_quesite());
		EnQueEP eqBp = new EnQueEP();
		EnQueueDO enque = eqBp.getEnQueueById(enQueId);
		this.invoke(que.getId_que(), queSite.getId_quesite(), enque.getCode_entp(), entId);
		
		return enque;
	}
	
	
	/**
	 * 触发事件
	 * 
	 * @param queId
	 * @param siteId
	 * @param entId
	 * @throws BizException 
	 */
	public void invoke(String queId, String siteId, String codeEnTp, String entId) throws BizException{
		EnOpQueEventBP event = new EnOpQueEventBP();
		event.invokeEnOpQueEvent(queId, siteId, codeEnTp, entId, IEnEventConst.EVENT_EN_OP_CALLNUM);
	}
}
