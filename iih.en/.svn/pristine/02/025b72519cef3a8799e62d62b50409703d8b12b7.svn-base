package iih.en.que.s.bp.op.cmd.benmgr;

import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueRService;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.s.bp.OpCallNextNumBP;
import iih.en.que.s.bp.OpCallingNumBP;
import iih.en.que.s.bp.op.qry.benmgr.GetQue4BenMgrBP;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门急诊叫号处理
 * 
 * @author liubin
 *
 */
public class OpCallNumHandle {
	/**
	 * 站点叫号(分诊台)
	 * 
	 * @param queId 队列ID
	 * @param siteId 工作点ID
	 * @param dayslotId 时间分组ID
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	public EnQueueDO callNum(EnTrDocSiteInfoDTO siteInfo, String entId, Integer callNum) throws BizException {
		if(siteInfo == null 
				|| EnValidator.isEmpty(siteInfo.getId_quesite())
				|| EnValidator.isEmpty(siteInfo.getId_dayslot())
				|| EnValidator.isEmpty(siteInfo.getId_ques()))
			return null;
		if(siteInfo.getDate() == null)
			siteInfo.setDate(EnAppUtils.getServerDate());
		QueDO que = ServiceFinder.find(IQueRService.class).findById((String)siteInfo.getId_ques().get(0));
		QueSiteDO queSite = ServiceFinder.find(IQuesiteRService.class).findById(siteInfo.getId_quesite());
		return acptCallNum(que, queSite, siteInfo, entId, callNum);
	}
	/**
	 * 站点叫下一个(分诊台)
	 * 
	 * @param queId 队列ID
	 * @param siteId 工作点ID
	 * @param dayslotId 时间分组ID
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	public EnQueueDO callNextNum(EnTrDocSiteInfoDTO siteInfo) throws BizException {
		if(siteInfo == null 
				|| EnValidator.isEmpty(siteInfo.getId_quesite())
				|| EnValidator.isEmpty(siteInfo.getId_dayslot())
				|| EnValidator.isEmpty(siteInfo.getId_ques()))
			return null;
		if(siteInfo.getDate() == null)
			siteInfo.setDate(EnAppUtils.getServerDate());
		QueDO que = ServiceFinder.find(IQueRService.class).findById((String)siteInfo.getId_ques().get(0));
		QueSiteDO queSite = ServiceFinder.find(IQuesiteRService.class).findById(siteInfo.getId_quesite());
		return acptCallNextNum(que, queSite, siteInfo);
	}
	/**
	 * 叫号(医生站)
	 * 
	 * @param que 出诊队列
	 * @param queSite 出诊站点
	 * @param date 当前日期
	 * @param siteInfo 站点信息
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	public EnQueueDO acptCallNum(QueDO que, QueSiteDO queSite, EnTrDocSiteInfoDTO siteInfo, String entId, Integer callNum) throws BizException {
		if(siteInfo.getDate() == null)
			siteInfo.setDate(EnAppUtils.getServerDate());
		boolean isBenQueMgr = EnParamUtils.isBenQueMgr();
		if(isBenQueMgr){
			QueDO[] ques = new GetQue4BenMgrBP().getQuesBySiteId(siteInfo);
			OpCallingNum4BenMgrBP bp = new OpCallingNum4BenMgrBP();
			return bp.exec(ques, queSite, siteInfo, entId, callNum);
		}else{
			OpCallingNumBP bp = new OpCallingNumBP();
			return bp.callingNum(que, queSite, siteInfo, entId, callNum);
		}
	}
	/**
	 * 叫下一个(医生站)
	 * 
	 * @param que 出诊队列
	 * @param queSite 出诊站点
	 * @param date 当前日期
	 * @param siteInfo 站点信息
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	public EnQueueDO acptCallNextNum(QueDO que, QueSiteDO queSite, EnTrDocSiteInfoDTO siteInfo) throws BizException {
		if(siteInfo.getDate() == null)
			siteInfo.setDate(EnAppUtils.getServerDate());
		boolean isBenQueMgr = EnParamUtils.isBenQueMgr();
		if(isBenQueMgr){
			QueDO[] ques = new GetQue4BenMgrBP().getQuesBySiteId(siteInfo);
			OpCallNextNum4BenMgrBP bp = new OpCallNextNum4BenMgrBP();
			return bp.exec(ques, queSite, siteInfo);
		}else{
			OpCallNextNumBP bp = new OpCallNextNumBP();
			return bp.callNextNum(que, queSite, siteInfo);
		}
	}
}
