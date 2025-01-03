package iih.en.que.s.event.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.ScripRulConst;
import iih.en.comm.ep.BdQueEP;
import iih.en.comm.ep.BrdCallEP;
import iih.en.comm.ep.EnBrdEP;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.board.d.BrdStatusEnum;
import iih.en.que.board.d.EnBrdCallDO;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.board.i.IEnbrdsitedoRService;
import iih.en.que.dto.d.AllQue4EsDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.s.bp.GetBrdNameRulScripBP;
import iih.en.que.s.listener.bp.SendDrugBrdMsgBP;
import iih.sc.scbd.i.IScDaysLotService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.lock.PKLock;

/***
 * 发送药房综合大屏消息
 * @author fanlq
 * @date: 2019年9月18日 下午2:05:03
 */
public class SendDrugSynthesizeInfoBP {
	/****
	 * @Description:发送药房站点消息
	 * @param allQue4EsDTO
	 * @param eventType
	 * @return
	 * @throws BizException
	 */
	public boolean sendDrugSiteMsg(AllQue4EsDTO allQue4EsDTO,String eventType) throws BizException{
		if (allQue4EsDTO == null)
			return false;
		// 1.获取发送的大屏站点DO数据
		EnBrdSiteDO brdSiteDO = this.getBrdSiteInfo(allQue4EsDTO,eventType);
		// 2.保存大屏站点DO到数据库中
		FDate today = EnAppUtils.getServerDate();
		boolean lock = PKLock.getInstance().addDynamicLock(brdSiteDO.getCode() + today.toStdtString(), 5 * 1000);
		EnBrdSiteDO[] enBrdSiteDOs = new EnBrdEP().save(new EnBrdSiteDO[] { brdSiteDO });
		new SendDrugBrdMsgBP().sendSiteMsg(enBrdSiteDOs);
		return true;
	}
	/***
	 * @Description:发送药房叫号消息
	 * @param allQue4EsDTO
	 * @param eventType
	 * @return
	 * @throws BizException 
	 */
	public boolean sendDrugCallMsg(AllQue4EsDTO allQue4EsDTO,String eventType) throws BizException{
		if (allQue4EsDTO == null)
			return false;
		// 1.获取发送的大屏站点DO数据
		EnBrdCallDO brdCallDO = this.getBrdCallInfo(allQue4EsDTO,eventType);
		// 2.保存大屏站点DO到数据库中
		EnBrdCallDO[] enBrdCallDOs = new BrdCallEP().save(new EnBrdCallDO[] { brdCallDO });
		new SendDrugBrdMsgBP().sendCallMsg(enBrdCallDOs);
		return true;
	}
	/***
	 * @Description:获取要发送的站点数据
	 * @param allQue4EsDTO
	 * @param eventType
	 * @return
	 * @throws BizException
	 */
	private EnBrdSiteDO getBrdSiteInfo(AllQue4EsDTO allQue4EsDTO,String eventType) throws BizException{
		EnBrdSiteDO brdSiteDO = this.getBrdSiteDO(allQue4EsDTO.getCode_quesite());
		DaysLotDO daysLotDO = this.getCurDaysLot();
		QueDO queDO = new BdQueEP().getQueById(allQue4EsDTO.getId_que());
		brdSiteDO.setAddr_brd(queDO.getAddr_board());// 药房队列屏幕地址
		brdSiteDO.setCode(allQue4EsDTO.getCode_quesite()); //窗口编码
		brdSiteDO.setName_dept(allQue4EsDTO.getName_dep());
		brdSiteDO.setName_site(allQue4EsDTO.getName_quesite());
		brdSiteDO.setName_dr(allQue4EsDTO.getName_doc());
		brdSiteDO.setId_grp(EnContextUtils.getGrpId());
		brdSiteDO.setId_org(EnContextUtils.getOrgId());
		brdSiteDO.setNo_curpat(allQue4EsDTO.getTickno());// 就诊号
		brdSiteDO.setDt_lastmdf(EnAppUtils.getServerDateTime());
		brdSiteDO.setCode_pat(allQue4EsDTO.getCode_pat());
		brdSiteDO.setName_curpat(allQue4EsDTO.getName_pat());
		brdSiteDO.setNos_wait(setWaitPat(allQue4EsDTO,daysLotDO,eventType));  //候诊患者
		brdSiteDO.setPat_called(setCalledPat(allQue4EsDTO,daysLotDO,eventType));//过号患者
		if (brdSiteDO.getStatus() == DOStatus.NEW)
			brdSiteDO.setEu_status(BrdStatusEnum.ADD);
		else {
			if (IEnEventConst.EVENT_DRUG_OFFLIN.equals(eventType))
				brdSiteDO.setEu_status(BrdStatusEnum.DEL);
			else
				brdSiteDO.setEu_status(BrdStatusEnum.UPDATE);
		}
		return brdSiteDO;
	}
	/***
	 * @Description:获取要发送的叫号数据
	 * @param allQue4EsDTO
	 * @param eventType
	 * @return
	 * @throws BizException
	 */
	private EnBrdCallDO getBrdCallInfo(AllQue4EsDTO allQue4EsDTO,String eventType) throws BizException{
		EnBrdCallDO callDO = new EnBrdCallDO();
		QueDO queDO = new BdQueEP().getQueById(allQue4EsDTO.getId_que());
		callDO.setAddr_brd(queDO.getAddr_board());
		callDO.setCode_site(allQue4EsDTO.getCode_quesite());//窗口编码
		if(!EnValidator.isEmpty(allQue4EsDTO.getTickno())){
			callDO.setTick_no(Integer.valueOf(allQue4EsDTO.getTickno()));// 就诊号
		}
		GetBrdNameRulScripBP bp = new GetBrdNameRulScripBP();
		String name_callpat = bp.exec(allQue4EsDTO.getName_pat(),ScripRulConst.BRD_DRUG_SHOW_NAME,ScripRulConst.CALLPAT);
		callDO.setName_pat(name_callpat);// 患者姓名
		callDO.setName_call_pat(allQue4EsDTO.getName_pat());
		callDO.setDt_call(EnAppUtils.getServerDateTime());
		callDO.setDt_insert(EnAppUtils.getServerDateTime());
		callDO.setId_grp(EnContextUtils.getGrpId());
		callDO.setId_org(EnContextUtils.getOrgId());
		callDO.setCode_pat(allQue4EsDTO.getCode_pat());
		if (IEnEventConst.EVENT_DRUG_CALLNUM.equals(eventType)) {
			callDO.setStatus(DOStatus.NEW);
		}
		return callDO;
	}
	
	/***
	 * 大屏上是否已显示站点，是则更新或删除，否则新增
	 * 
	 * @author fanlq 2018年1月2日
	 * @param brdSiteDO
	 * @return
	 * @throws BizException
	 */
	public EnBrdSiteDO getBrdSiteDO(String siteCode) throws BizException {
		EnBrdSiteDO[] rtns = ServiceFinder.find(IEnbrdsitedoRService.class).findByAttrValString(EnBrdSiteDO.CODE,siteCode);
		if (rtns != null && rtns.length == 1) {
			rtns[0].setStatus(DOStatus.UPDATED);
			return rtns[0];
		}
		EnBrdSiteDO rtn = new EnBrdSiteDO();
		rtn.setStatus(DOStatus.NEW);
		return rtn;
	}
	/***
	 * @Description:获取候诊患者
	 * @param id_que
	 * @return
	 * @throws BizException
	 */
	private String setWaitPat(AllQue4EsDTO allQue4EsDTO,DaysLotDO daysLotDO,String eventType) throws BizException{
		EnQueEP ep = new EnQueEP();
		String where = " SD_STATUS_ACPT IN ('"+IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_UNACCEPT+"','"+IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_PREPARE+"','"+IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_CALL+"')"
				+ " AND ID_QUE_SITE = '"+allQue4EsDTO.getId_quesite()+"' ";
			where += setWhere(allQue4EsDTO,eventType);
		//设置候诊患者信息
		EnQueueDO[] ques = ep.getEnQueueByWhereStr(where,"SORTNO,DT_REGIST ASC ");
		List<String> waitePatList = new ArrayList<String>();
		FMap map = new FMap();
		GetBrdNameRulScripBP bp = new GetBrdNameRulScripBP();
		if(ques != null && ques.length > 0){
			for(EnQueueDO enbrd : ques){
				if(!EnValidator.isEmpty(enbrd.getCode_pat()) && !EnValidator.isEmpty(enbrd.getName_pat()) && !map.containsKey(enbrd.getCode_pat())){
					map.put(enbrd.getCode_pat(), enbrd.getName_pat());
					String name_pat = bp.exec(enbrd.getName_pat(),ScripRulConst.BRD_DRUG_SHOW_NAME,ScripRulConst.WAITPAT);
					waitePatList.add(name_pat);
				}
			}
		}
		if(waitePatList != null && waitePatList.size() > 0){
			String waitPat = waitePatList.toString();
			if(!EnValidator.isEmpty(waitPat)){
				waitPat = waitPat.replace("[", "").replace("]", "");
				return waitPat;
			}
		}
		return null;
	}

	/***
	 * @Description:获取过号患者信息
	 * @param brdSiteDO
	 * @param id_queSite
	 * @return
	 * @throws BizException 
	 */
	private String setCalledPat(AllQue4EsDTO allQue4EsDTO,DaysLotDO daysLotDO,String eventType) throws BizException{
		EnQueEP ep = new EnQueEP();
		String where = " SD_STATUS_ACPT = '"+IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_CALLBUTNOTCOME+"'"
				+ " AND ID_QUE = '"+allQue4EsDTO.getId_que()+"'";
			where += setWhere(allQue4EsDTO,eventType);
		//设置过号患者信息
		EnQueueDO[] ques = ep.getEnQueueByWhereStr(where,"sortno,dt_regist asc ");
		List<String> calledPatList = new ArrayList<String>();
		FMap map = new FMap();
		GetBrdNameRulScripBP bp = new GetBrdNameRulScripBP();
		if(ques != null && ques.length > 0){
			for(EnQueueDO enbrd : ques){
				if(!EnValidator.isEmpty(enbrd.getCode_pat()) && !EnValidator.isEmpty(enbrd.getName_pat()) && !map.containsKey(enbrd.getCode_pat())){
					map.put(enbrd.getCode_pat(), enbrd.getName_pat());
					String name_pat = bp.exec(enbrd.getName_pat(),ScripRulConst.BRD_DRUG_SHOW_NAME,ScripRulConst.CALLEDPAT);
					calledPatList.add(name_pat);
				}
			}
		}
		if(calledPatList != null && calledPatList.size() > 0){
			String calledPat = calledPatList.toString();
			if(!EnValidator.isEmpty(calledPat)){
				calledPat = calledPat.replace("[", "").replace("]", "");
				return calledPat;
			}
		}
		return null;
	}
	/***
	 * @Description:获取公共where条件
	 * @param allQue4EsDTO
	 * @param eventType
	 * @return
	 */
	private String setWhere(AllQue4EsDTO allQue4EsDTO,String eventType){
		String where = " AND SD_ENTQUE_TP = '"+IBdFcDictCodeConst.SD_QUETP_PHARMACY+"' AND DT_REGIST = '"+EnAppUtils.getServerDate()+"' ";
		if(IEnEventConst.EVENT_DRUG_DISPENSING.equals(eventType)){
			if(!EnValidator.isEmpty(allQue4EsDTO.getId_ent())){
				where += " AND ID_ENT <> '"+allQue4EsDTO.getId_ent()+"'";
			}
		}
		return where;
	}
	/**
	 * 获取当前日期分组
	 * 
	 * @return
	 * @throws BizException
	 */
	private DaysLotDO getCurDaysLot() throws BizException{
		IScDaysLotService scDayslotServ = ServiceFinder.find(IScDaysLotService.class);
		return scDayslotServ.getNowDaysLotCross(IScDictCodeConst.SD_SCTP_OP, FBoolean.TRUE);
	}
}
