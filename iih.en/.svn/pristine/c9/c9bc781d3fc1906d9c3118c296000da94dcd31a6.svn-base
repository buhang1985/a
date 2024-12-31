package iih.en.que.s.event.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.ep.BdQueEP;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.AllQue4EsDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import iih.en.que.enqueue.i.IEnqueueRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.sc.scbd.i.IScDaysLotService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class WrapObj2AllQue4EsBP {
	
	/****
	 * 组装数据源
	 * @param allQue4EsDTO
	 * @return
	 * @throws BizException
	 */
	public AllQue4EsDTO warp(String quesiteId,String queId,String entqueId,String ticketno,String id_queben) throws BizException{
		AllQue4EsDTO allQue4EsDTO = new AllQue4EsDTO();
		allQue4EsDTO.setId_entque(entqueId);
		allQue4EsDTO.setId_ben(id_queben);
		EnLogUtil.getInstance().logInfo("通用分诊传入站点id:"+ quesiteId +"，队列id："+queId);
		// 设置站点信息
		QueSiteDO site = this.setSiteInfo(quesiteId, allQue4EsDTO);
		if(site == null) return allQue4EsDTO;
		// 设置队列信息
		QueDO que = null;
		if(EnValidator.isEmpty(queId)){
		    que = this.setQueInfo(site.getId_que(),allQue4EsDTO);
		}else
			que = this.setQueInfo(queId,allQue4EsDTO);
		EnLogUtil.getInstance().logInfo("通用分诊站点:"+ site +"，队列："+que);
		FDateTime curTime = EnAppUtils.getServerDateTime();
		String dayslotId = this.getNowDayslotId();
		// 设置候诊人数
		this.setWaitNum(allQue4EsDTO, que, site, dayslotId, curTime);
		// 设置等待号
		this.setWaitQuenos(allQue4EsDTO, que, site, dayslotId, curTime);
		// 设置当前接诊患者信息
		allQue4EsDTO = this.setCurAcpt(allQue4EsDTO, que, site,entqueId, dayslotId, curTime);
		EnQueueDO enQueueDO = this.setPatInfo(entqueId);
		EnLogUtil.getInstance().logInfo("通用分诊allQue4EsDTO:"+ allQue4EsDTO +"，EnQueueDO："+enQueueDO);
		if(enQueueDO != null ){
			allQue4EsDTO.setName_pat(enQueueDO.getName_pat());
			if(!EnValidator.isEmpty(ticketno)){
				allQue4EsDTO.setTickno(ticketno);
			}else{
				if(enQueueDO.getTicketno() != null){
					allQue4EsDTO.setTickno(enQueueDO.getTicketno().toString());
				}
			}
			this.setCodePat(allQue4EsDTO,enQueueDO);
		}
		return allQue4EsDTO;
	}
	/***
	 * 设置患者编码
	 * @param allQue4EsDTO
	 * @param enQueueDO
	 * @return
	 * @throws BizException 
	 */
	private AllQue4EsDTO setCodePat(AllQue4EsDTO allQue4EsDTO,EnQueueDO enQueueDO) throws BizException{
		IPatiMDORService service = ServiceFinder.find(IPatiMDORService.class);
		PatDO pat = service.findById(enQueueDO.getId_pat());
		if(pat != null){
			allQue4EsDTO.setCode_pat(pat.getCode());
		}
		return allQue4EsDTO;
	}
	private EnQueueDO setPatInfo(String entqueId) throws BizException{
		if(EnValidator.isEmpty(entqueId)){
			return null;
		}
		EnQueEP ep = new EnQueEP();
		EnQueueDO enQueueDO = ep.getEnQueueById(entqueId);
		return enQueueDO;
	}
	/**
	 * 设置队列信息
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private QueDO setQueInfo(String queId,AllQue4EsDTO allQue4EsDTO) throws BizException {
		if (EnValidator.isEmpty(queId))
			return null;
		BdQueEP ep = new BdQueEP();
		QueDO que = ep.getQueById(queId);
		if (que == null)
			return null;
		allQue4EsDTO.setId_que(queId);
		allQue4EsDTO.setCode_que(que.getCode());
		allQue4EsDTO.setName_que(que.getName());
		allQue4EsDTO.setAddr_board_que(que.getAddr_board());
		allQue4EsDTO.setAddr_board_ben(que.getAddr_board_ben());
		allQue4EsDTO.setId_dep(que.getId_dep());
		allQue4EsDTO.setCode_dep(que.getCode_dep());
		allQue4EsDTO.setName_dep(que.getName_dep());
		return (QueDO) que.clone();
	}

	/**
	 * 设置站点信息
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private QueSiteDO setSiteInfo(String quesiteId,AllQue4EsDTO allQue4EsDTO) throws BizException {
		if (EnValidator.isEmpty(quesiteId))
			return null;
		BdSiteEP ep = new BdSiteEP();
		QueSiteDO site = ep.getSiteById(quesiteId);
		if (site == null)
			return null;
		if (site.getShortname() == null) {
			allQue4EsDTO.setCode_room(site.getName());
		} else {
			allQue4EsDTO.setCode_room(site.getShortname());
		}
		allQue4EsDTO.setName_room(site.getName());
		allQue4EsDTO.setAddr_board_site(site.getAddr_board());
		allQue4EsDTO.setId_quesite(quesiteId);
		allQue4EsDTO.setCode_quesite(site.getCode());
		allQue4EsDTO.setName_quesite(site.getName());
		if (site.getId_emp() != null) {
			allQue4EsDTO.setId_doc(site.getId_emp());
			allQue4EsDTO.setCode_doc(site.getEmp_code());
			allQue4EsDTO.setName_doc(site.getEmp_name());
		} else {
			allQue4EsDTO.setId_doc(allQue4EsDTO.getId_doc());
			allQue4EsDTO.setCode_doc(allQue4EsDTO.getCode_doc());
			allQue4EsDTO.setName_doc(allQue4EsDTO.getName_doc());
		}
		return (QueSiteDO) site.clone();
	}
	/**
	 * 获取日期分组Id
	 * 
	 * @return
	 * @throws BizException
	 */
	private String getNowDayslotId() throws BizException {
		IScDaysLotService serv = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO dayslot = serv.getNowDaysLot(IScDictCodeConst.SD_SCTP_MT,
				FBoolean.TRUE);
		if (dayslot != null)
			return dayslot.getId_dayslot();
		return null;
	}
	/**
	 * 设置当前接诊者序号
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private AllQue4EsDTO setCurAcpt(AllQue4EsDTO allQue4EsDTO,QueDO que,QueSiteDO site,String entqueId,String dayslotId, FDateTime curTime) throws BizException {
		if (que == null || site == null
				|| EnValidator.isEmpty(dayslotId) || curTime == null)
			return allQue4EsDTO;
		StringBuilder sb = new StringBuilder();
		sb.append("select que.id_ent as Id_ent,que.name_pat as Name_pat, ");
		sb.append("que.ticketno as Tickno,");
		sb.append("sex.name as Name_sex,pat.dt_birth as D_birthday ");
		sb.append("from en_ent_que que ");
		sb.append("left join en_ent ent on ent.id_ent = que.id_ent ");
		sb.append("left join pi_pat pat on pat.id_pat = ent.id_pat ");
		sb.append("left join bd_udidoc sex on sex.id_udidoc = pat.id_sex ");
		sb.append("WHERE 1=1 ");
		sb.append("AND que.DT_REGIST = ? ");
		//sb.append("AND que.ID_DATESLOT = ? ");
		sb.append("AND que.ID_QUE_SITE = ? ");
		sb.append("and que.sd_entque_tp = ? ");
		SqlParam param = new SqlParam();
		param.addParam(curTime.getDate());
		//param.addParam(dayslotId);
		param.addParam(site.getId_quesite());
		param.addParam(IBdFcDictCodeConst.SD_QUETP_OTHER);
		if(!EnValidator.isEmpty(entqueId)){
			sb.append("and que.id_ent_que = ? ");
			param.addParam(entqueId);
		}
		String sql = sb.toString();
		sb.append("ORDER BY que.DT_ACPT,que.level_pri DESC ");
		@SuppressWarnings("unchecked")
		List<AllQue4EsDTO> list = (List<AllQue4EsDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(AllQue4EsDTO.class));
		if (!EnValidator.isEmpty(list)) {
			allQue4EsDTO.setTickno(list.get(0).getTickno());
			allQue4EsDTO.setName_pat(list.get(0).getName_pat());
			allQue4EsDTO.setD_birthday(list.get(0).getD_birthday());
			allQue4EsDTO.setName_sex(list.get(0).getName_sex());
		}
		return allQue4EsDTO;
	}
	/**
	 * 设置候诊人数
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private void setWaitNum(AllQue4EsDTO allQue4EsDTO, QueDO que, QueSiteDO site,String dayslotId, FDateTime curTime) throws BizException {
		if (que == null || site ==null || EnValidator.isEmpty(dayslotId) || curTime == null)
			return;
		SqlParam param = new SqlParam();
		StringBuilder sb = new StringBuilder();
		sb.append(getBaseSQL());//候诊
		sb.append("AND EQ.DT_REGIST = ? ");
		sb.append("AND EQ.ID_DATESLOT = ? ");
		param.addParam(IBdFcDictCodeConst.SD_QUETP_OTHER);
		param.addParam(FBoolean.TRUE);
		param.addParam(curTime.getDate());
		param.addParam(dayslotId);
		/* 工作站叫号分诊 */
		if (IBdFcDictCodeConst.SD_MODEL_OP_EMP.equals(que.getSd_mode())) {
			sb.append("AND EQ.ID_QUE = ? ");
			sb.append("AND ((EQ.SD_STATUS_ACPT IN (?,?) AND EQ.ID_QUE_SITE = ? ) ");
			sb.append("OR (EQ.SD_STATUS_ACPT=? AND (EQ.ID_QUE_SITE = ? OR NVL(EQ.ID_QUE_SITE,'~')='~'))) ");
			param.addParam(que.getId_que());
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
			param.addParam(site.getId_quesite());
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
			param.addParam(site.getId_quesite());
		}
		/* 分诊台分诊 */
		else {
			sb.append("AND EQ.ID_QUE=? ");
			sb.append("AND EQ.ID_QUE_SITE=? ");
			sb.append("AND EQ.SD_STATUS_ACPT IN (?,?,?) ");
			param.addParam(que.getId_que());
			param.addParam(site.getId_quesite());
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		}
		Integer res = (Integer) new DAFacade().execQuery(sb.toString(), param, new ColumnHandler());
		allQue4EsDTO.setWaitnum(res);
	}
	private String getBaseSQL(){
		return "SELECT COUNT(EQ.ID_ENT_QUE) FROM EN_ENT_QUE EQ WHERE EQ.SD_ENTQUE_TP = ? AND EQ.FG_ACTIVE = ? "; 
	}

	/**
	 * 设置候诊号
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private void setWaitQuenos(AllQue4EsDTO allQue4EsDTO, QueDO que, QueSiteDO site,
			String dayslotId, FDateTime curTime) throws BizException {
		AllQue4EsDTO[] queues = this.getCallEntQues(que, site, curTime.getDate(),
				dayslotId);
		if (EnValidator.isEmpty(queues))
			return;
		boolean isFirst = true;
		String waitQuenos = "";
		FArrayList waitList = new FArrayList();
		for (AllQue4EsDTO queue : queues) {
			if (IEnDictCodeConst.SD_STATUS_ACPT_CALL.equals(queue.getSd_status_acpt())) {
				// 如果有叫号患者，把当前号设为叫号患者
				allQue4EsDTO.setName_pat(queue.getName_pat());
				allQue4EsDTO.setD_birthday(queue.getD_birthday());
				allQue4EsDTO.setName_sex(queue.getName_sex());
				if(queue.getTickno() != null){
					allQue4EsDTO.setTickno(queue.getTickno().toString());
				}
				continue;
			}
				if (isFirst) {
					waitQuenos += queue.getTickno();
					isFirst = false;
				} else {
					waitQuenos = waitQuenos + "、" + queue.getTickno();
				}
				waitList.add(queue);
		}
		allQue4EsDTO.setWait_list(waitList);
		allQue4EsDTO.setWaitquenos(waitQuenos);
	}
	/**
	 * 取出要叫号和上屏的记录
	 * 
	 * @param que
	 * @param queSite
	 * @param date
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	public AllQue4EsDTO[] getCallEntQues(QueDO que, QueSiteDO queSite, FDate date, String dayslotId) throws BizException{	
		//获取候诊队列
		List<AllQue4EsDTO> waitList = this.getWaitingEntQues(que, queSite, date, dayslotId);
		if(!EnValidator.isEmpty(waitList))
			return waitList.toArray(new AllQue4EsDTO[]{});
		else return null;
	}

	/**
	 * 获取叫号患者
	 * 
	 * @param que
	 * 		出诊队列
	 * @param queSite
	 * 		出诊站点
	 * @param date
	 * 		当前日期
	 * @param dayslotId
	 * 		当前时间分组ID
	 * @return
	 * @throws BizException 
	 */
	public EnQueueDO[] getCallEnt(QueDO que, QueSiteDO queSite, FDate date, String dayslotId) throws BizException{
		String whereStr = String.format("%s.ID_QUE = '%s' AND %s.ID_QUE_SITE='%s' AND %s.SD_STATUS_ACPT = '%s' AND %s.DT_REGIST = '%s'"
				//+ " AND %s.ID_DATESLOT = '%s'"
				+ " AND %s.FG_ACTIVE = '%s' ",
				EnQueueDODesc.TABLE_ALIAS_NAME, que.getId_que(),
				EnQueueDODesc.TABLE_ALIAS_NAME, queSite.getId_quesite(),
				EnQueueDODesc.TABLE_ALIAS_NAME, IEnDictCodeConst.SD_STATUS_ACPT_CALL,
				EnQueueDODesc.TABLE_ALIAS_NAME, date,
				//EnQueueDODesc.TABLE_ALIAS_NAME, dayslotId,
				EnQueueDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE);
		String orderStr = String.format(" %s.SORTNO_CALLED ", EnQueueDODesc.TABLE_ALIAS_NAME);
		IEnqueueRService service = ServiceFinder.find(IEnqueueRService.class);
		EnQueueDO[] enQueues = service.find(whereStr, orderStr,FBoolean.FALSE);
		return enQueues;
	}

	/**
	 * 获取候诊患者
	 * 
	 * @param que
	 * @param queSiteDO
	 * @param date
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	private List<AllQue4EsDTO> getWaitingEntQues(QueDO que, QueSiteDO queSiteDO, FDate date, String dayslotId) throws BizException{
		if(que == null || queSiteDO == null){
			return null;
		}
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT DISTINCT EQ.*,EQ.sd_status_acpt as Sd_status_acpt,EQ.TICKETNO AS Tickno, PAT.BARCODE_CHIS, PAT.CODE AS CODE_PAT, ");
		builder.append("sex.name as Name_sex,pat.dt_birth as D_birthday ");
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("left JOIN PI_PAT PAT ON EQ.ID_PAT = PAT.ID_PAT ");
		builder.append("left join bd_udidoc sex on sex.id_udidoc = pat.id_sex ");
		/* 工作站叫号分诊 */
		if (IBdFcDictCodeConst.SD_MODEL_OP_EMP.equals(que.getSd_mode())) {
			
			builder.append("WHERE EQ.ID_QUE = ? ");
			builder.append("AND ( EQ.ID_QUE_SITE = ?) ");
			builder.append("AND EQ.SD_STATUS_ACPT in (?,?) ");
		}
		/* 分诊台分诊 */
		else if (IBdFcDictCodeConst.SD_MODEL_OP_TRIAGE.equals(que.getSd_mode())) {
			builder.append("WHERE EQ.ID_QUE=? ");
			builder.append("AND EQ.ID_QUE_SITE = ? ");
			builder.append("AND EQ.SD_STATUS_ACPT in (?,?) ");
		}else{
			return null;
		}
		builder.append("AND EQ.DT_REGIST = ? ");
		//builder.append("AND EQ.ID_DATESLOT = ? ");
		builder.append("AND EQ.FG_ACTIVE = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		builder.append("ORDER BY EQ.SORTNO_CALLED, EQ.LEVEL_PRI DESC, EQ.SORTNO, EQ.DT_IN   ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(que.getId_que());
		param.addParam(queSiteDO.getId_quesite());
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
		param.addParam(date);
		//param.addParam(dayslotId);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_OTHER);
		@SuppressWarnings("unchecked")
		List<AllQue4EsDTO> list = (List<AllQue4EsDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(AllQue4EsDTO.class));
		return list;
	}
}
