package iih.en.pv.s.bp.op.ws;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueRService;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.OpWaitQueDTO;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.en.que.i.IEnQueQryService;
import iih.sc.scbd.i.IScDaysLotService;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 根据站点信息获取医生候诊队列
 * 
 * @author liubin
 *
 */
public class GetWaitQueBySiteBP {
	/**
	 * 身份
	 */
	private static final String IDENT_VIP = "V";//vip
	private static final String IDENT_OLD = "O";//老人
	private static final String IDENT_NOR = "N";//普通
	/**
	  * 根据站点信息获取医生候诊队列
	  * 
	  * @param siteCode 站点编码
	  * @param oprCode 操作员
	  * @return
	  * @throws BizException
	  */
	public OpWaitQueDTO[] exec(String siteCode, String oprCode) throws BizException {
		if(EnValidator.isEmpty(siteCode))
			return null;
		if(!EnValidator.isEmpty(oprCode))
			new SetPsnDocContextBP().exec(oprCode);
		//获取日期分组信息
		DaysLotDO dayslot = this.getCurDaysLot();
		if(dayslot == null){
			Logger.info("未获取到到当前午别！");
			return null;
		}
		//获取站点信息
		QueSiteDO site = getSite(siteCode);
		if(site == null)
			return null;
		//获取队列信息
		QueDO que = getQue(site.getId_que());
		//获取候诊列表患者
		ReceptionQueDTO[] receptionQues = getReceptionQues(que, site, dayslot);
		//获取正在接着患者
		ReceptionQueDTO acpt = getCurAcpt(site, dayslot.getId_dayslot());
		return wrapOpWaitQues(receptionQues, acpt, site);
	}
	/**
	 * 
	 * 
	 * @param ques
	 * @param site
	 * @param dayslot
	 * @return
	 * @throws BizException 
	 */
	private ReceptionQueDTO[] getReceptionQues(QueDO que, QueSiteDO site, DaysLotDO dayslot) throws BizException{
		IEnQueQryService serv = ServiceFinder.find(IEnQueQryService.class);
		EnTrDocSiteInfoDTO siteInfo = new EnTrDocSiteInfoDTO();	
		siteInfo.setId_quesite(site.getId_quesite());
		siteInfo.setId_dayslot(dayslot.getId_dayslot());
		siteInfo.setId_queben(site.getId_queben());
		siteInfo.setId_dep(site.getId_dep());
		siteInfo.setId_emp(site.getId_emp());
		siteInfo.setDate(new FDate(dayslot.getDef1()));
		siteInfo.setId_ques(EnAppUtils.objArray2List(que != null ? que.getId_que() : null));
		return serv.getDocAcptList(que, site, siteInfo, "Wait");
	}
	
	/**
	 * 获取站点信息
	 * 
	 * @param siteCode
	 * @return
	 * @throws BizException
	 */
	private QueSiteDO getSite(String siteCode) throws BizException {
		String whereStr = String.format(" Code = '%s' and Sd_quesitetp = '%s' ", siteCode, IBdFcDictCodeConst.SD_QUESITETP_OP);
		IQuesiteRService serv = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO[] sites = serv.find(whereStr, null, FBoolean.FALSE);
		if(EnValidator.isEmpty(sites))
			return null;
		QueSiteDO site = sites[0];
		if(!PauseEnum.ONLINE.equals(site.getEu_pause()))
			return null;
		return site;
	}
	/**
	 * 获取队列
	 * 
	 * @param queId
	 * @return
	 * @throws BizException
	 */
	private QueDO getQue(String queId) throws BizException {
		if(EnValidator.isEmpty(queId))
			return null;
		return ServiceFinder.find(IQueRService.class).findById(queId);
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
	
	/**
	 * 设置当前接诊者序号
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private ReceptionQueDTO getCurAcpt(QueSiteDO site, String dayslotId) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EQ.ID_ENT ");
		sb.append("FROM EN_ENT_QUE EQ  ");
		sb.append("WHERE EQ.SD_STATUS_ACPT = ? ");
		sb.append("AND EQ.DT_REGIST = ? ");
		sb.append("AND EQ.ID_DATESLOT = ? ");
		sb.append("AND EQ.ID_QUE_SITE = ? ");
		sb.append("AND EQ.Sd_entque_tp = ? ");
		sb.append("ORDER BY EQ.DT_ACPT DESC ");
		String sql = sb.toString();
		SqlParam param = new SqlParam();
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED);
		param.addParam(EnAppUtils.getServerDate());
		param.addParam(dayslotId);
		param.addParam(site.getId_quesite());
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if (!EnValidator.isEmpty(list)) {
			return ServiceFinder.find(IEnQueQryService.class).getReceptionQueByEntId(list.get(0));
		}
		return null;
	}
	/**
	 * 组装OpWaitQueDTO
	 * 
	 * @param eqDTOs
	 * @return
	 */
	private OpWaitQueDTO[] wrapOpWaitQues(ReceptionQueDTO[] rects, ReceptionQueDTO acpt, QueSiteDO site) throws BizException{
		if(EnValidator.isEmpty(rects) && acpt == null)
			return null;
		List<OpWaitQueDTO> list = new LinkedList<OpWaitQueDTO>();
		FDateTime curTime = EnAppUtils.getServerDateTime();
		int i=0;
		if(acpt != null){
			i++;
			OpWaitQueDTO opWaitQue = new OpWaitQueDTO();
			opWaitQue.setRowNumber(i);
			opWaitQue.setFg_wait("N");
			assemly(opWaitQue, acpt, site, curTime);
			list.add(opWaitQue);
		}
		int heightLevel = EnParamUtils.getPvOrderAcptLevel();
		if(!EnValidator.isEmpty(rects)){
			for(ReceptionQueDTO rect : rects) {
				if(!EnValidator.isEmpty(rect.getLevel_pri())){
					if(Integer.parseInt(rect.getLevel_pri()) >= heightLevel){
						continue;
					}
				}
				i++;
				OpWaitQueDTO opWaitQue = new OpWaitQueDTO();
				opWaitQue.setRowNumber(i);
				opWaitQue.setFg_wait("Y");
				assemly(opWaitQue, rect, site, curTime);
				if(FBoolean.TRUE.equals(rect.getFg_needrtn()))
					opWaitQue.setFg_rtn("Y");
				else
					opWaitQue.setFg_rtn("N");
				list.add(opWaitQue);
			}
		}
		return list.toArray(new OpWaitQueDTO[0]);
	}
	/**
	 * 组装数据
	 * 
	 * @param opWaitQue
	 * @param rect
	 * @param site
	 * @param curTime
	 * @throws BizException
	 */
	private void assemly(OpWaitQueDTO opWaitQue, ReceptionQueDTO rect, QueSiteDO site, FDateTime curTime)throws BizException{
		GetVisitFlagBP visitBP = new GetVisitFlagBP();
		opWaitQue.setRegSeqNo(Integer.parseInt(rect.getTicketno()));
		opWaitQue.setTicketno(Integer.parseInt(rect.getTicketno()));
		opWaitQue.setPatCode(rect.getCode_pat());
		opWaitQue.setOpTimes(rect.getTimes_op());
		opWaitQue.setEntCode(rect.getCode_ent());
		opWaitQue.setRoom(site.getRoom() + site.getName());
		opWaitQue.setIdenFlag(this.getIdentStatus(curTime, rect.getDt_birth_pat(), rect.getLevel_pri()));
		opWaitQue.setVisitFlag(visitBP.getVisitStatusNew(rect.getSd_status(), rect.getSd_status_acpt(), rect.getId_que_site(), rect.getSortno_called()));
		opWaitQue.setId_ent(rect.getId_ent());
		opWaitQue.setId_ent_que(rect.getId_ent_que());
		opWaitQue.setName_pat(rect.getName_pat());
	}
	
	/**
	 * 获取身份类型
	 * 
	 * @param curTime
	 * @param birth
	 * @param level_pri
	 * @return
	 */
	private String getIdentStatus(FDateTime curTime, FDate birth, String level_pri){
		if(this.isMoreThanYeay(curTime, birth, 75)){
			return IDENT_OLD;
		}else if(level_pri != null && Integer.parseInt(level_pri) > 0){
			return IDENT_VIP;
		}
		return IDENT_NOR;
	}
	
	/**
	 * 是否大于year岁
	 * 
	 * @param birth
	 * @param year
	 * @return
	 */
	private boolean isMoreThanYeay(FDateTime curTime, FDate birth, int year){
		if(birth != null){
			FDate curDate = curTime.getDate().asBegin();
			if (birth.after(curDate)) {
			   return false;
			}    
			int Months = curDate.getLocalMonth() - birth.getLocalMonth() + 12 * (curDate.getLocalYear() - birth.getLocalYear());
			Calendar cal = Calendar.getInstance();
			cal.setTime(birth.toDate());
			cal.add(2, Months);  
			int totalMonth = new FDate(cal.getTime()).after(curDate) ? Months - 1 : Months;    
			int fullYear = totalMonth / 12;
			if(fullYear > year){
				return true;
			}
		}
		return false;
	}
}
