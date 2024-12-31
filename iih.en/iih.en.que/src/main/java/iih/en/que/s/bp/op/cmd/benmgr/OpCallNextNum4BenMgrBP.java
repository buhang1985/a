package iih.en.que.s.bp.op.cmd.benmgr;

import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.s.bp.PassNumBP;
import xap.mw.core.data.BizException;

/**
 * 叫下一个（分诊台管理队列模式）
 * 
 * @author liubin
 *
 */
public class OpCallNextNum4BenMgrBP {
	/**
	 * 叫下一个（分诊台管理队列模式）
	 * 
	 * @param ques
	 * @param queSite
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO exec(QueDO[] ques, QueSiteDO queSite, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		EnValidator.validateParam("医生出诊队列", ques);
		EnValidator.validateParam("医生工作站点", queSite);
		EnValidator.validateParam("当前时间分组", siteInfo.getId_dayslot());
		//站点已经下线就不能叫号
		BdSiteEP siteEp = new BdSiteEP();
		siteEp.siteError(queSite.getId_quesite());
		OpCallingNum4BenMgrBP bp = new OpCallingNum4BenMgrBP();
		//取出[候诊队列]的第一个就诊记录,如果其为叫号状态, 则把它设置为过号
		EnQueueDO[] queues = bp.getCallEnt(ques, queSite, siteInfo);
		if(!EnValidator.isEmpty(queues)){
			//1.2 把在叫号的就诊患者改为过号处理
			PassNumBP passNumBP = new PassNumBP();
			passNumBP.exec(new EnQueueDO[]{queues[0]});
		}
		//按[叫号]的处理方法对下一个患者进行叫号
		return bp.exec(ques, queSite, siteInfo, null, null);
	}
}
