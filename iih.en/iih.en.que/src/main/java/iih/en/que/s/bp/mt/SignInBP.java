package iih.en.que.s.bp.mt;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.ep.PiPatEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.i.IEnqueueRService;
import iih.en.que.s.event.AllQueEvent;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.scbd.i.IScDaysLotService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.lock.PKLock;

/***
 * 通用分诊-签到
 * 
 * @author fanlq
 * @date: 2020年1月2日 下午5:20:14
 */
public class SignInBP {

	/***
	 * @Description:签到
	 * @param id_pat
	 * @param id_queben
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO exec(String id_pat, TriageBenInfoDTO triageInfo) throws BizException {
		// 1.校验数据
		this.validator(id_pat, triageInfo);
		DaysLotDO dayslot = this.getNowDayslot();
		if (dayslot == null) {
			throw new BizException(IEnMsgConst.ERROR_NO_NOW_DAYSLOT);
		}
		if (!dayslot.getId_dayslot().equals(triageInfo.getId_dayslot())) {
			throw new BizException(IEnMsgConst.ERROR_NOT_CORRENT_DAYSLOT);
		}
		FDate date = EnAppUtils.getServerDate();
		// 2.获取患者信息
		PatDO PatDO = getPatInfo(id_pat);
		// 是否已经存在当前午别的队列，存在则不再加入队列
		EnQueueDO[] enQueDOArray = getPatEnQueueDO(PatDO, triageInfo.getId_queben(), dayslot, date);
		if(!EnValidator.isEmpty(enQueDOArray)){
			return null;
		}
		// 3.往队列表里插数据 en_ent_que
		EnQueueDO enQueueDO = this.insertQue(PatDO, triageInfo.getId_queben(), dayslot, date);
		//4.发送事件
		this.invoke(enQueueDO.getId_que_site(),enQueueDO.getId_que(),enQueueDO.getId_ent_que(),enQueueDO.getSortno().toString(),enQueueDO.getId_queben(), IEnEventConst.EVENT_EN_ALL_SIGNIN);
		return enQueueDO;
	}

	/***
	 * @Description:队列里插入签到数据
	 * @param id_pat
	 * @param id_queben
	 * @throws BizException
	 */
	private EnQueueDO insertQue(PatDO patDO, String id_queben, DaysLotDO dayslot, FDate date) throws BizException {
		FDateTime curtdate = EnAppUtils.getServerDateTime();
		EnQueueDO enQueueDO = new EnQueueDO();
		enQueueDO.setId_grp(EnContextUtils.getGrpId());
		enQueueDO.setId_org(EnContextUtils.getOrgId());
		enQueueDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		enQueueDO.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		enQueueDO.setId_pat(patDO.getId_pat());
		enQueueDO.setId_ent("~");
		enQueueDO.setName_pat(patDO.getName());
		enQueueDO.setId_que("~");
		enQueueDO.setId_dateslot(dayslot.getId_dayslot());
		enQueueDO.setId_entque_tp(IBdFcDictCodeConst.ID_QUETP_OTHER);
		enQueueDO.setSd_entque_tp(IBdFcDictCodeConst.SD_QUETP_OTHER);
		enQueueDO.setFg_active(FBoolean.TRUE);
		enQueueDO.setDt_in(curtdate);
		enQueueDO.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		// enQueueDO.setDt_acpt(curtdate);
		// enQueueDO.setId_emp_acpt(EnContextUtils.getPsnId());
		// enQueueDO.setName_emp_acpt(EnContextUtils.getPsnDoc().getName());
		enQueueDO.setId_que_site("~");
		enQueueDO.setId_patca(patDO.getId_paticate());
		enQueueDO.setDt_regist(date);
		enQueueDO.setId_queben(id_queben);
		enQueueDO.setLevel_pri(0);
		enQueueDO.setFg_apt(FBoolean.FALSE);
		enQueueDO.setFg_manual(FBoolean.FALSE);
		enQueueDO.setSortno_called(0);
		enQueueDO.setFg_rtn(FBoolean.FALSE);

		FDate today = EnAppUtils.getServerDate();
		boolean lock = PKLock.getInstance().addDynamicLock(id_queben + today.toStdtString(), 5 * 1000);
		if (!lock) {
			throw new BizException("当前数据正在被他人修改，请稍后重新刷卡！");
		}
		Integer sortNo = this.getSortNo(id_queben, today);
		enQueueDO.setSortno(sortNo);
		enQueueDO.setTicketno(sortNo);
		enQueueDO.setStatus(DOStatus.NEW);
		new EnQueEP().save(new EnQueueDO[] { enQueueDO });
		return enQueueDO;
	}
	/***
	 * @Description:获取患者当天存在的通用队列
	 * @param PatDO
	 * @param id_queben
	 * @param dayslot
	 * @param date
	 * @return
	 * @throws BizException
	 */
	private EnQueueDO[] getPatEnQueueDO(PatDO PatDO, String id_queben, DaysLotDO dayslot, FDate date) throws BizException {
		IEnqueueRService enqueRService = ServiceFinder.find(IEnqueueRService.class);
		String whereStr = String.format(
				"ID_QUEBEN='%S' AND (DT_REGIST='%S' OR (DT_ACPT >= '%S' AND DT_ACPT <= '%S')) AND SD_ENTQUE_TP = '%S' AND ID_PAT = '%S' AND SD_STATUS_ACPT NOT IN ('%S') ",
				id_queben, date, date, date.getDateAfter(1), IBdFcDictCodeConst.SD_QUETP_OTHER, PatDO.getId_pat(),
				IEnDictCodeConst.SD_STATUS_ACPT_FINCHECKED);
		String orderStr = "SORTNO DESC";
		EnQueueDO[] enQueDOArray = enqueRService.find(whereStr, orderStr, FBoolean.FALSE);
		return enQueDOArray;
	}
	/**
	 * 获取顺序号
	 * 
	 * @param queId
	 *            队列id
	 * @param entId
	 *            就诊id
	 * @param dt_regist
	 *            注册时间
	 * @return
	 * @throws BizException
	 */
	private Integer getSortNo(String id_queben, FDate dt_regist) throws BizException {
		// 如果已经存在该就诊的序号，则直接就用，否则取今天该队列最大号+1
		int sortNo = 1;
		IEnqueueRService enqueRService = ServiceFinder.find(IEnqueueRService.class);
		String whereStr = String.format("SD_ENTQUE_TP = '%S' AND ID_QUEBEN='%S' AND (DT_REGIST='%S' OR (DT_ACPT >= '%S' AND DT_ACPT <= '%S'))",
				IBdFcDictCodeConst.SD_QUETP_OTHER,id_queben, dt_regist, dt_regist, dt_regist.getDateAfter(1));
		String orderStr = "SORTNO DESC";
		EnQueueDO[] enQueDOArray = enqueRService.find(whereStr, orderStr, FBoolean.FALSE);
		if (enQueDOArray != null && enQueDOArray.length > 0 && enQueDOArray[0].getSortno() != null) {
			sortNo = enQueDOArray[0].getSortno() + 1;
		}
		return sortNo;
	}

	/***
	 * @Description:获取患者信息
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private PatDO getPatInfo(String id_pat) throws BizException {
		PiPatEP ep = new PiPatEP();
		PatDO patDO = ep.getPatById(id_pat);
		if (EnValidator.isEmpty(patDO)) {
			throw new BizException("未找到对应患者信息！患者id:" + id_pat);
		}
		return patDO;
	}

	/***
	 * @Description:校验数据
	 * @param id_pat
	 * @param id_queben
	 * @throws BizException
	 */
	private void validator(String id_pat, TriageBenInfoDTO triageInfo) throws BizException {
		EnValidator.validateParam("id_pat", id_pat);
		EnValidator.validateParam("triageInfo", triageInfo);
		EnValidator.validateParam("id_queben", triageInfo.getId_queben());
	}

	/**
	 * 获取通用排班的日期分组
	 * 
	 * @return
	 * @throws BizException
	 */
	private DaysLotDO getNowDayslot() throws BizException {
		IScDaysLotService serv = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO dayslot = serv.getNowDaysLotCross(IScDictCodeConst.SD_SCTP_TY, FBoolean.TRUE);
		return dayslot;
	}
	
	/****
	 * 发送事件-fanlq-2018-07-10
	 * @param quesiteId
	 * @param queId
	 * @param event
	 * @throws BizException
	 */
	private void invoke(String quesiteId,String queId,String entqueId,String ticketno,String id_queben,String event) throws BizException{
		AllQueEvent ev = new AllQueEvent();
		ev.exec(quesiteId, queId,entqueId, ticketno,id_queben,event);
	}
}
