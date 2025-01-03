package iih.en.que.s.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.en.comm.IEnConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.en.que.dto.d.MedTechAppDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.i.IEnqueueCudService;
import iih.en.que.enqueue.i.IEnqueueRService;
import iih.en.que.s.event.AllQueEvent;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 通用分诊
 * 
 * @author maxy 2018年6月19日10:42:33
 */
public class AllTriageBP {

	/**
	 * 分诊
	 * 
	 * @param techDTO
	 * @param siteDTO
	 * @throws BizException
	 */
	public EnQueueDO triageToSiteAll(MedTechAppDTO techDTO, TriageQueSiteDTO siteDTO) throws BizException {
		// 获取队列顺序号
		int maxSortNO = this.getTickNo(techDTO, siteDTO);

		// 设置队列和站点
		return this.updateQue(siteDTO, maxSortNO, techDTO);
	}

	/**
	 * 获取队列顺序号
	 * 
	 * @param techDTO
	 * @throws BizException
	 */
	private int getTickNo(MedTechAppDTO techDTO, TriageQueSiteDTO siteDTO) throws BizException {

		StringBuilder sqlSB = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlSB.append(" select nvl(max(ticketno),0) + 1");
		sqlSB.append(" from en_ent_que eq");
		sqlSB.append(" where eq.id_que_site = ?");// 站点
		param.addParam(siteDTO.getId_quesite());

		sqlSB.append(" and eq.dt_regist = to_char(sysdate,'yyyy-MM-dd')");// 日期
		sqlSB.append(" and eq.sd_entque_tp = '9'");// 通用
		return (int) new DAFacade().execQuery(sqlSB.toString(), param, new ColumnHandler());
	}

	/**
	 * 设置队列和站点
	 * 
	 * @param siteDTO
	 * @param maxSortNO
	 * @throws BizException
	 */
	public EnQueueDO updateQue(TriageQueSiteDTO siteDTO, int maxSortNO, MedTechAppDTO techDTO) throws BizException {
		IEnqueueRService enQueRService = ServiceFinder.find(IEnqueueRService.class);
		EnQueueDO enQueDO = enQueRService.findById(techDTO.getId_ent_que());
		IEnqueueCudService enQueCudService = ServiceFinder.find(IEnqueueCudService.class);
		if (enQueDO == null) {
			throw new BizException("未找到队列信息！");
		}
		IQuesiteRService quesiteRService = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO queSiteDO = quesiteRService.findById(siteDTO.getId_quesite());
		if (!queSiteDO.getEu_pause().equals("1")) {
			throw new BizException("站点状态已改变,请刷新后重试!");
		}
		enQueDO.setId_que(siteDTO.getId_que());
		enQueDO.setId_que_site(siteDTO.getId_quesite());
		enQueDO.setSortno(maxSortNO);
		enQueDO.setTicketno(maxSortNO);
		enQueDO = enQueCudService.update(new EnQueueDO[] { enQueDO })[0];
		//发送事件
		String ticketno = enQueDO.getTicketno() == null ? null : enQueDO.getTicketno().toString();
		this.invoke(siteDTO.getId_quesite(), siteDTO.getId_que(),enQueDO.getId_ent_que(),ticketno,techDTO.getId_ben(), IEnEventConst.EVENT_EN_ALL_TRIAGE);
		return enQueDO;
	}

	/**
	 * 刷卡查询患者队列信息
	 * 
	 * @param id_pat
	 *            患者id
	 * @param dateslottp
	 *            午别
	 * @param benid
	 *            分诊台id
	 * @return
	 * @throws BizException
	 */
	public MedTechAppDTO getQueDOByPat(String id_pat, String benid) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" select eq.ticketno as no_applyform,");
		sqlBuilder.append(" pi.name as name_pat,");
		sqlBuilder.append(" eq.dt_in as dt_in,");
		sqlBuilder.append(" pi.dt_birth as age,");
		sqlBuilder.append(" pi.id_sex as name_sex,");
		sqlBuilder.append(" pi.id_pat as id_pat,");
		sqlBuilder.append(" pi.code as code_pat,");
		sqlBuilder.append(" eq.sd_status_acpt as name_triage_status,");
		sqlBuilder.append(" q.name as quesite_name,");
		sqlBuilder.append(" eq.id_que_site as id_que_site,");
		sqlBuilder.append(" eq.level_pri as level_pri,");
		sqlBuilder.append(" eq.level_pri_rsn as level_reason,");
		sqlBuilder.append(" eq.id_ent_que");
		sqlBuilder.append(" from EN_ENT_QUE eq");
		sqlBuilder.append(" left join bd_que q");
		sqlBuilder.append(" on eq.id_que = q.id_que");
		sqlBuilder.append(" inner join pi_pat pi");
		sqlBuilder.append(" on eq.id_pat = pi.id_pat");
		sqlBuilder.append(" where eq.id_queben = ?");
		param.addParam(benid);
		sqlBuilder.append(" and eq.sd_entque_tp = 9");
		sqlBuilder.append(" and eq.dt_regist =to_char(sysdate,'yyyy-MM-dd')");
		sqlBuilder.append(" and pi.id_pat = ?");
		param.addParam(id_pat);
		sqlBuilder.append(" order by eq.dt_in desc,eq.level_pri desc nulls last, sortno");
		MedTechAppDTO dto = (MedTechAppDTO) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanHandler(MedTechAppDTO.class));
		return dto;
	}

	/**
	 * 取消分诊
	 * 
	 * @param techDTO
	 * @throws BizException
	 */
	public void celTriageToSiteAll(MedTechAppDTO techDTO) throws BizException {
		IEnqueueRService enQueRService = ServiceFinder.find(IEnqueueRService.class);
		EnQueueDO enQueDO = enQueRService.findById(techDTO.getId_ent_que());
		if (!enQueDO.getSd_status_acpt().equals("0")) {
			throw new BizException("患者状态已改变,请刷新后重试!");
		}
		String ticketno = enQueDO.getTicketno() == null ? null : enQueDO.getTicketno().toString();
		enQueDO.setId_que_site("");
		enQueDO.setSortno(0);
		enQueDO.setId_tick("");
		enQueDO.setId_que("");
		enQueDO.setTicketno(null);
		enQueDO.setLevel_pri(null);
		enQueDO.setLevel_pri_rsn("");
		enQueDO.setFg_manual(FBoolean.TRUE);//只能手动分诊
		IEnqueueCudService enQueCudService = ServiceFinder.find(IEnqueueCudService.class);
		enQueCudService.update(new EnQueueDO[] { enQueDO });
		//发送事件
		this.invoke(techDTO.getId_que_site(), techDTO.getId_que(),enQueDO.getId_ent_que(),ticketno,techDTO.getId_ben(), IEnEventConst.EVENT_EN_ALL_CANC_TRIAGE);
	}

	/**
	 * 取消签到
	 * 
	 * @param techDTO
	 * @throws BizException
	 */
	public void delSignAll(MedTechAppDTO techDTO) throws BizException {
		IEnqueueRService enQueRService = ServiceFinder.find(IEnqueueRService.class);
		EnQueueDO enQueDO = enQueRService.findById(techDTO.getId_ent_que());
		IEnqueueCudService enQueCudService = ServiceFinder.find(IEnqueueCudService.class);
		enQueCudService.delete(new EnQueueDO[] { enQueDO });
		//发送事件
		String ticketno = enQueDO.getTicketno() == null ? null : enQueDO.getTicketno().toString();
		this.invoke(techDTO.getId_que_site(), techDTO.getId_que(),enQueDO.getId_ent_que(),ticketno,techDTO.getId_ben(), IEnEventConst.EVENT_EN_ALL_CANC_SIGNIN);
	}

	/**
	 * 优先级设置
	 * 
	 * @param techDTO
	 * @throws BizException
	 */
	public void setLevelPri(MedTechAppDTO techDTO) throws BizException {
		IEnqueueRService enQueRService = ServiceFinder.find(IEnqueueRService.class);
		EnQueueDO enQueDO = enQueRService.findById(techDTO.getId_ent_que());
		IEnqueueCudService enQueCudService = ServiceFinder.find(IEnqueueCudService.class);
		enQueDO.setLevel_pri(techDTO.getLevel_pri());
		enQueDO.setLevel_pri_rsn(techDTO.getLevel_reason());
		enQueCudService.update(new EnQueueDO[] { enQueDO });
	}

	/**
	 * 获取通用分诊台的工作站点
	 * 
	 * @param benId
	 *            工作台id
	 * @param status
	 *            状态
	 * @param dayslotsec
	 *            午别 状态，参照枚举：QueSiteStatus
	 * @return 相应的DTO
	 */
	// TODO 考虑是否可以将号源部分移植到SC中
	public TriageQueSiteDTO[] getAllQueSite(String benId, String id_or, String dayslotsec) throws BizException {
		StringBuilder sqlSB = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlSB.append(" select q.name as Name_que,"); // 队列名称
		sqlSB.append(" s.name as Name_quesite,");// 站点名称
		sqlSB.append(" s.eu_pause as Sitestatus,");// 状态
		sqlSB.append(" nvl((select count(1)");
		sqlSB.append(" from en_ent_que eq3");
		sqlSB.append(" where s.id_quesite = eq3.id_que_site");
		if (!dayslotsec.equals("ALL")) {
			sqlSB.append(" and eq3.id_dateslot = ?");// 午别
			param.addParam(dayslotsec);
		}
		sqlSB.append(" and eq3.dt_regist = to_char(sysdate, 'yyyy-MM-dd')");
		sqlSB.append(" and eq3.sd_entque_tp = 9");
		sqlSB.append(" and eq3.sd_status_acpt in ('0', '1')),");
		sqlSB.append(" 0) as waitnum,");// 候诊人数
		//sqlSB.append(" count(eq1.id_ent_que) as waitnum,");// 候诊人数// 已检人数
		sqlSB.append(" nvl((select count(1)");
		sqlSB.append(" from en_ent_que eq2");
		sqlSB.append(" where s.id_quesite = eq2.id_que_site");
		if (!dayslotsec.equals("ALL")) {
			sqlSB.append(" and eq2.id_dateslot = ?");// 午别
			param.addParam(dayslotsec);
		}
		sqlSB.append(" and eq2.dt_regist = to_char(sysdate, 'yyyy-MM-dd')");
		sqlSB.append(" and eq2.sd_entque_tp = 9");
		sqlSB.append(" and eq2.sd_status_acpt in ('7', '8')),");
		sqlSB.append(" 0) as triagenum,");// 已检人数
		sqlSB.append(" q.id_que as id_que,");
		sqlSB.append(" s.id_quesite as id_quesite");
		sqlSB.append(" from bd_que q");
		sqlSB.append(" inner join bd_que_site s");
		sqlSB.append(" on q.id_que = s.id_que");
		sqlSB.append(" left join en_ent_que eq1");
		sqlSB.append(" on s.id_quesite = eq1.id_que_site");
		sqlSB.append(" and eq1.dt_regist = to_char(sysdate, 'yyyy-MM-dd')");
		if (!dayslotsec.equals("ALL")) {
			sqlSB.append(" and eq1.id_dateslot = ?");// 午别
			param.addParam(dayslotsec);
		}
		sqlSB.append(" and eq1.sd_entque_tp = 9");
		sqlSB.append(" and eq1.id_queben = q.id_queben");
		sqlSB.append(" and eq1.sd_status_acpt in ('0', '1', '2')");
		sqlSB.append(" where q.id_queben = ?");// 工作台id
		param.addParam(benId);
		sqlSB.append(" and q.sd_quetp = 9");
		sqlSB.append(" group by q.name, s.name, s.eu_pause, q.id_queben, q.sd_quetp, q.id_que,s.id_quesite,s.code ");
		sqlSB.append("  order by s.code ");
		@SuppressWarnings("unchecked")
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sqlSB.toString(), param,
				new BeanListHandler(TriageQueSiteDTO.class));
		if (!EnValidator.isEmpty(list)) {
			return list.toArray(new TriageQueSiteDTO[0]);
		}

		return null;
	}

	public MedTechAppDTO[] getAllQueuePat(String id_quesite, String dateslot, String[] chbState,String id_ben) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();

		sqlBuilder.append(" select 1 as call,");
		sqlBuilder.append(" eq.sortno as sortno,");
		sqlBuilder.append(" q.name as que_name,");
		sqlBuilder.append(" pi.name as name_pat,");
		sqlBuilder.append(" pi.dt_birth as age,");
		sqlBuilder.append(" pi.Id_Sex as name_sex,");
		sqlBuilder.append(" eq.sd_status_acpt as sd_status_acpt,");
		sqlBuilder.append(" ben.name as quesite_name,");
		sqlBuilder.append(" eq.dt_regist as appointment,");
		sqlBuilder.append(" eq.dt_in as dt_in,");
		sqlBuilder.append(" eq.level_pri as level_pri,");
		sqlBuilder.append(" eq.level_pri_rsn as level_reason,");
		sqlBuilder.append(" eq.id_ent_que as id_ent_que,");
		sqlBuilder.append(" eq.id_pat as id_pat");
		sqlBuilder.append(" from EN_ENT_que eq");
		sqlBuilder.append(" inner join bd_que q");
		sqlBuilder.append(" on eq.id_que = q.id_que");
		sqlBuilder.append(" inner join pi_pat pi");
		sqlBuilder.append(" on eq.id_pat = pi.id_pat");
		sqlBuilder.append(" inner join bd_que_ben ben");
		sqlBuilder.append(" on ben.id_queben = q.id_queben");
		sqlBuilder.append(" where eq.id_que_site = ? ");
		param.addParam(id_quesite);
		sqlBuilder.append(" and eq.dt_regist = to_char(sysdate, 'yyyy-MM-dd')");
		sqlBuilder.append(" and eq.id_queben = ?");
		param.addParam(id_ben);
		if (!EnValidator.isEmpty(dateslot) && !dateslot.equals("ALL")) {
			sqlBuilder.append(" and eq.id_dateslot = ?");
			param.addParam(dateslot);
		}
		if (!EnValidator.isEmpty(chbState) && chbState.length > 0) {
			sqlBuilder.append(" and eq.sd_status_acpt in (");
			for (int i = 0; i < chbState.length; i++) {
				if (i == chbState.length - 1) {
					sqlBuilder.append(" ?)");
				} else {
					sqlBuilder.append(" ?,");
				}
				param.addParam(chbState[i]);
			}
		} else {
			return new MedTechAppDTO[0];
		}
		sqlBuilder.append(" order by eq.level_pri desc nulls last, sortno");
		@SuppressWarnings("unchecked")
		List<MedTechAppDTO> list = (List<MedTechAppDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(MedTechAppDTO.class));
		if (list == null) {
			return new MedTechAppDTO[0];
		}
		for (int i = 0; i < list.size(); i++) {
			MedTechAppDTO mtDTO = (MedTechAppDTO) list.get(i);
			if (mtDTO.getName_sex() == IEnConst.SEX_ID_BOY) {
				mtDTO.setName_sex(IEnConst.SEX_NAME_BOY);
			} else if (mtDTO.getName_sex() == IEnConst.SEX_ID_GIRL) {
				mtDTO.setName_sex(IEnConst.SEX_NAME_GIRL);
			} else {
				mtDTO.setName_sex(IEnConst.SEX_NAME_UNKNOWN);
			}
			if(mtDTO.getAge() != null){
				mtDTO.setAge(EnAppUtils.getAge(FDate.getDate(mtDTO.getAge())) + "岁");
			}
			if (mtDTO.getSd_status_acpt() == "0") {
				mtDTO.setName_triage_status("分诊");
			} else if (mtDTO.getSd_status_acpt() == "1") {
				mtDTO.setName_triage_status("叫号");
			}else if (mtDTO.getSd_status_acpt() == "2") {
				mtDTO.setName_triage_status("过号");
			}else if (mtDTO.getSd_status_acpt() == "7") {
				mtDTO.setName_triage_status("处置");
			} else if (mtDTO.getSd_status_acpt() == "8") {
				mtDTO.setName_triage_status("处毕");
			}
		}
		return list.toArray(new MedTechAppDTO[0]);
	}
	/**
	 * 通用分诊--保存队列信息
	 * @param queueDo 队列TO
	 * @throws BizException
	 */
	public FMap saveQueue(EnQueueDO queueDo,FBoolean isAutoDiagnosis,String id_que_site)throws BizException
	{
		//1.查询pi_pat   获取   id_patca
		PatDO patDO = this.GetPatcaByPatid(queueDo);
		if(patDO!=null)
		{
			queueDo.setId_patca(patDO.getId_paticate());
		}
		
		//2.查询   en_ent 获取   id_ent、id_enttp、code_entp 
		PatiVisitDO patiVisitDO = this.GetPativisityPatid(queueDo);
		if(patiVisitDO != null)
		{
			queueDo.setId_ent(patiVisitDO.getId_ent());
			queueDo.setId_enttp(patiVisitDO.getId_entp());
			queueDo.setCode_entp(patiVisitDO.getCode_entp());
		}
		
		IEnqueueCudService enqueueCudService = ServiceFinder.find(IEnqueueCudService.class);
		EnQueueDO[] newQue = enqueueCudService.insert(new EnQueueDO[]{queueDo});
		//发送事件
		String ticketno = queueDo.getTicketno() == null ? null : queueDo.getTicketno().toString();
		this.invoke(null, queueDo.getId_que(),queueDo.getId_ent_que(),ticketno,null, IEnEventConst.EVENT_EN_ALL_SIGNIN);
		//3.自动分诊
		FMap resultMap = new FMap();
		if(FBoolean.TRUE.equals(isAutoDiagnosis))
		{
			return new SaveAutoDiagnosis().exec(newQue[0], id_que_site);
		}
		resultMap.put("msg", "签到成功!");
		resultMap.put("id_entque", queueDo.getId_ent_que());
		return resultMap;
	}
	
	/**
	 * 1.查询pi_pat   获取   id_patca
	 * @param queueDo
	 * @return
	 * @throws BizException
	 */
	private PatDO GetPatcaByPatid(EnQueueDO queueDo)throws BizException
	{
		IPatiMDORService service = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDO = service.findById(queueDo.getId_pat());
		return patDO;
	}
	
	/**
	 * 2.查询   en_ent 获取   id_ent、id_enttp、code_entp
	 * @param queueDo
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO GetPativisityPatid(EnQueueDO queueDo)throws BizException
	{
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] patiVisitDO = service.find(String.format(" id_pat = '%s'",queueDo.getId_pat())," sv desc",FBoolean.FALSE);
		if(patiVisitDO.length>0)
		{
			return patiVisitDO[0];
		}
		return null;
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
