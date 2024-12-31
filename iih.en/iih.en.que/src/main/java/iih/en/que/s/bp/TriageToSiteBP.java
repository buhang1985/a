package iih.en.que.s.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.s.event.bp.EnOpQueEventBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

/**
 * 分诊
 * 
 * @author Liu Bin
 *
 */
public class TriageToSiteBP {

	/**
	 * 分诊
	 * 
	 * @param triageQueSite
	 * 		目标工作站点DTO 
	 * @param entQueId
	 * @param isAutoTriage 是否是自动分诊
	 * 		就诊队列ID
	 * @throws BizException
	 */
	public void exec(TriageQueSiteDTO triageQueSite, String entQueId, FBoolean isAutoTriage, TriageBenInfoDTO triageInfo, FMap map) throws BizException{
		this.exec(triageQueSite, entQueId, isAutoTriage, FBoolean.FALSE, triageInfo, map);
	}
	/**
	 * 分诊
	 * 
	 * @param triageQueSite
	 * 		目标工作站点DTO 
	 * @param entQueId
	 * @param isAutoTriage 是否是自动分诊
	 * @param isForceTriage 是否是强制分诊
	 * 		就诊队列ID
	 * @throws BizException
	 */
	public void exec(TriageQueSiteDTO triageQueSite, String entQueId, FBoolean isAutoTriage, FBoolean isForceTriage, TriageBenInfoDTO triageInfo, FMap map) throws BizException {
		EnValidator.validateParam("TriageQueSiteDTO", triageQueSite);
		EnValidator.validateParam("entQueId", entQueId);

		EnQueEP queBP = new EnQueEP();
		EnQueueDO enQueue = queBP.getEnQueueById(entQueId);
		if(enQueue == null)
			throw new BizException(IEnMsgConst.ERROR_OP_PVINFO_NOT_EXISTS);
		this.volidate(triageQueSite, enQueue);
		if(FBoolean.FALSE.equals(isAutoTriage)){
			AcptUtilsBP acptUtilsBP = new AcptUtilsBP();
			QueSiteDO site = new QueSiteDO();
			site.setId_quesite(triageQueSite.getId_quesite());
			EnTrDocSiteInfoDTO siteInfo = new EnTrDocSiteInfoDTO();
			siteInfo.setId_dayslot(triageInfo.getId_dayslot());
			siteInfo.setDate(triageInfo.getDate());
			siteInfo.setId_quesite(triageQueSite.getId_quesite());
			siteInfo.setId_queben(triageInfo.getId_queben());
			ResultDTO result = acptUtilsBP.isAcptable(enQueue.getId_ent(), site, FBoolean.TRUE, isForceTriage, siteInfo);
			if(FBoolean.TRUE.equals(result.getFlag()))
				isAutoTriage = result.getFlag();
			else
				throw new BizException(result.getMsg());
		}
		if(FBoolean.TRUE.equals(isAutoTriage)){
			enQueue.setStatus(DOStatus.UPDATED);
			enQueue.setId_que(triageQueSite.getId_que());
			enQueue.setId_que_site(triageQueSite.getId_quesite());
			enQueue.setId_emp_acpt(triageQueSite.getId_emp());
			if(EnParamUtils.isTriageToEmp())
				enQueue.setId_emp_opreg(triageQueSite.getId_emp());
			else
				enQueue.setId_emp_opreg(null);
			if(map!=null)
			  map.put("site", triageQueSite.getName_quesite());
			queBP.save(new EnQueueDO[] {enQueue});
			//触发分诊事件 分诊不再上屏
		//	this.invoke(triageQueSite.getId_que(), triageQueSite.getId_quesite(), enQueue.getId_ent());
		}else {
			throw new BizException(IEnMsgConst.ERROR_TRIAGE_WRONG);
		}
		//记录分诊事件
		new EnEvtHandle().insertTriageEvt(enQueue.getId_ent(), triageQueSite);
	}
	/**
	 * 验证
	 * 
	 * @param triageQueSite
	 * @param enQueue
	 * @throws BizException 
	 */
	private void volidate(TriageQueSiteDTO triageQueSite, EnQueueDO enQueue) throws BizException{
		if(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED.equals(enQueue.getSd_status_acpt()))
			throw new BizException("该患者已经取消到诊！");
	}
	
	/**
	 * 触发事件
	 * 
	 * @param queId
	 * @param siteId
	 * @param entId
	 * @throws BizException 
	 */
	private void invoke(String queId, String siteId, String codeEnTp, String entId) throws BizException{
		EnOpQueEventBP event = new EnOpQueEventBP();
		event.invokeEnOpQueEvent(queId, siteId, codeEnTp, entId, IEnEventConst.EVENT_EN_OP_TRIAGE);
	}
}
