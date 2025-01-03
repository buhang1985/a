package iih.en.que.s.bp.pharm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueruleAggDO;
import iih.bd.fc.querule.i.IRuleExecService;
import iih.bd.fc.querule.i.IRuleQryService;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pres.i.IPresRService;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCollectionUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.i.IOutpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.i.IEnqueueCudService;
import iih.en.que.enqueue.i.IEnqueueRService;
import iih.en.que.i.ICalcPriService;
import iih.en.que.s.event.DrugQueEvent;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ArrayListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;

/**
 * 加入药房队列BP
 * 
 * @author yankan
 * @since 2015-11-23
 *
 */
public class JoinPhramQueBP {
	private static final String KEY_EN_QUE = "enque"; // 就诊队列
	private static final String KEY_QUE_SITE = "quesite";// 站点
	private static final String KEY_WAIT_NUM = "waitnum";//等侯人数，fanlq-2018-08-25

	public JoinPhramQueBP() {

	}
	
	/**
	 * 加入配药队列
	 * 
	 * @param entId 就诊id
	 * @param presId 处方id
	 * @param pharmDepId 药房科室id
	 * @param questatus_new 加入队列中的状态,默认为20-签到， 20-签到 21-配药 22-叫号 23-叫号未到 24-发药
	 * @return 返回队列DO和站点DO
	 * @throws BizException
	 */
	public FMap addQueDispens(String entId, String presId, String pharmDepId, String questatus_new)
			throws BizException {
		this.validate(entId, presId, pharmDepId, questatus_new);
        return this.addQue(entId, presId, pharmDepId, questatus_new,null);		
	}
	/**
	 * 加入配药队列(第三方分窗口)
	 * 
	 * @param entId 就诊id
	 * @param presId 处方id
	 * @param pharmDepId 药房科室id
	 * @param questatus_new 加入队列中的状态,默认为20-签到， 20-签到 21-配药 22-叫号 23-叫号未到 24-发药
	 * @return 返回队列DO和站点DO
	 * @throws BizException
	 */
	public FMap addQueDispens(String entId, String presId, String pharmDepId, String questatus_new,String name_site)
			throws BizException {
		 return this.addQue(entId, presId, pharmDepId, questatus_new,name_site);	
	}
	/**
	 * 
	 * @param entId
	 * @param presId
	 * @param pharmDepId
	 * @param questatus_new
	 * @return
	 * @throws BizException 
	 */
	private FMap addQue(String entId, String presId, String pharmDepId, String questatus_new,String name_site) throws BizException
	{
		boolean havePrepare = EnParamUtils.havePrepare();
		EnLogUtil log = EnLogUtil.getInstance();
		log.displayInfo("------插入药房队列开始---------");
		FMap map = new FMap();
		// 获取队列
		GetPharmQueByDepBP getPharamQueBP = new GetPharmQueByDepBP();
		QueDO queDO = getPharamQueBP.exec(pharmDepId);
		if (queDO == null) {
			throw new BizException("科室：" + pharmDepId + "的队列不存在");
		}
		// 准备计算优先级的DTO
		ICalcPriService calcPriService = ServiceFinder.find(ICalcPriService.class);
		PriorityDTO priDTO = calcPriService.getEntInfo4CalPri(entId);
		this.setPres(priDTO, presId);// 设置处方数据

		// 查询是否有该患者未发药记录
		EnQueueDO existEnQue = this.getUnAcptEnQue(entId, queDO.getId_que(),havePrepare);
		log.displayInfo("是否存在患者未发药记录："+existEnQue);
		if (existEnQue != null) {
			//窗口是否在线
			QueSiteDO queSite = new BdSiteEP().getSiteById(existEnQue.getId_que_site());
			if(queSite != null){
				//基数药不需验证是否在线
				if(FBoolean.TRUE.equals(priDTO.getFg_base())
						|| (!FBoolean.TRUE.equals(priDTO.getFg_base()) && PauseEnum.ONLINE.equals(queSite.getEu_pause()))){
					// 符合规则，则直接插入队列
					CheckSiteMatchBP checkMatchBP = new CheckSiteMatchBP();
					if (checkMatchBP.isMeet(existEnQue.getId_que_site(), priDTO)) {
						EnQueueDO enQue = this.addToEntQue(existEnQue,presId, entId);// 加入队列
						map.put(KEY_EN_QUE, enQue);
						map.put(KEY_QUE_SITE, queSite);
						String site = EnValidator.isEmpty(queSite) ? null:queSite.getId_quesite() +"-"+queSite.getCode() +"-"+ queSite.getName();
						log.displayInfo("加入的药房队列："+site);
						return map;
					}
				}
			}
		}
		
		// 1、获取药房科室的站点
		GetDeptSiteBP getDeptSite = new GetDeptSiteBP();
		QueSiteDO[] queSites = getDeptSite.exec(pharmDepId);
		if (queSites == null) {
			throw new BizException("对应科室没有在线的工作站点");
		}
		QueSiteDO selectedQueSite = null;
		if (EnValidator.isEmpty(name_site)) {

			// 2、过滤不符合的站点，并计算候诊数
			Map<QueSiteDO, Integer> queSiteMap = this.filterAndCalWaiting(pharmDepId, queSites, priDTO,havePrepare);
			// 3、取候诊数最小的站点，如果候诊数相同，则随机取站点
			selectedQueSite = this.selectQueSite(queSiteMap);
		} else {
			selectedQueSite = this.getSelectSiteFromOther(queSites, name_site);
		}

		if (selectedQueSite == null) {
			throw new BizException("未找到合适窗口！");
		}
		// 4、计算优先级
		IRuleQryService ruleQryService = ServiceFinder.find(IRuleQryService.class);
		QueruleAggDO ruleAggDO = ruleQryService.getSiteRule(selectedQueSite.getId_quesite());
		IRuleExecService ruleExecService = ServiceFinder.find(IRuleExecService.class);
		int priLevel = ruleExecService.calcPri(ruleAggDO, priDTO);

		// 5、插入药房队列
		EnQueueDO enQueDO = this.addToEntQue(entId, presId, selectedQueSite, priLevel);
		log.displayInfo("插入药房队列：就诊id："+entId+";处方id："+presId+";优先级："+priLevel);
		if(enQueDO != null){
			//触发处方分配到窗口事件，fanlq-2018-07-22
			DrugQueEvent e = new DrugQueEvent();
			e.exec(enQueDO.getId_que_site(),enQueDO.getId_ent_que(),presId, IEnEventConst.EVENT_DRUG_SIGNIN);
		}
		// 6、返回
		map.put(KEY_EN_QUE, enQueDO);
		map.put(KEY_QUE_SITE, selectedQueSite);
		//7、获取等候人数，fanlq-2018-08-25，add
		Integer waitnum = this.setWaitNum(enQueDO,havePrepare);
		map.put(KEY_WAIT_NUM, waitnum);
		log.displayInfo("加入的药房队列："+selectedQueSite.getId_quesite() +"-"+selectedQueSite.getCode() +"-"+ selectedQueSite.getName()+";等候人数："+waitnum);
		log.displayInfo("---------插入药房队列结束------");
		return map;
	}

	/**
	 * 验证
	 * 
	 * @param entId 就诊id
	 * @param presId 处方id
	 * @param pharmDepId 药房科室id
	 * @param questatus_new 加入队列中的状态,默认为20-签到， 20-签到 21-配药 22-叫号 23-叫号未到 24-发药
	 * @throws BizException
	 */
	private void validate(String entId, String presId, String pharmDepId, String questatus_new) throws BizException {
		if (EnValidator.isEmpty(entId)) {
			throw new BizException("参数：就诊id为空！");
		}
		if (EnValidator.isEmpty(presId)) {
			throw new BizException("参数：处方id为空！");
		}
		if (EnValidator.isEmpty(pharmDepId)) {
			throw new BizException("参数：科室id为空！");
		}
		if (EnValidator.isEmpty(questatus_new)) {
			throw new BizException("参数：状态为空！");
		}
	}

	/**
	 * 设置处方数据
	 * 
	 * @param priDTO
	 * @param presId 处方ID
	 * @throws BizException
	 */
	private void setPres(PriorityDTO priDTO, String presId) throws BizException {
		IPresRService presRService = ServiceFinder.find(IPresRService.class);
		CiPresDO presDO = presRService.findById(presId);
		if (presDO != null) {
			priDTO.setId_prestp(presDO.getId_prestp());// 处方类型
			priDTO.setFg_base(presDO.getFg_base());// 是否基数药
		}
	}

	/**
	 * 获取站点候诊长度
	 * 
	 * @param queSiteId
	 * @return
	 * @throws BizException
	 */
	private int getQueSiteWaitCount(String queSiteId, String depId,boolean havePrepare) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append("SELECT COUNT(DISTINCT SORTNO) WAITCOUNT ");
		sqlBuilder.append("FROM EN_ENT_QUE ");
		sqlBuilder.append("WHERE ID_QUE_SITE = ? ");
		param.addParam(queSiteId);
		if(havePrepare){
			sqlBuilder.append("AND SD_STATUS_ACPT in (?,?) ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_UNACCEPT);
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_PREPARE);
		}else{
			sqlBuilder.append("AND SD_STATUS_ACPT = ? ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_UNACCEPT);
		}
		int maxDrugDays = EnParamUtils.getDrugDays(depId);
		if (maxDrugDays > 0) {
			FDate now = EnAppUtils.getServerDateTime().getDate().asLocalBegin();
			sqlBuilder.append("AND DT_IN >= ? ");
			param.addParam(now.getDateBefore(maxDrugDays - 1));
		}
		Object obj = new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnHandler("WAITCOUNT"));
		return Integer.parseInt(obj.toString());
	}

	/**
	 * 获取科室所有站点候诊长度
	 * 
	 * @param depId 科室ID
	 * @param queSites 站点集合
	 * @return
	 * @throws BizException
	 */
	private Map<String, Integer> getQueSiteWaitCount(String depId, QueSiteDO[] queSites,boolean havePrepare) throws BizException {
		List<String> queSiteIds = new ArrayList<String>();
		int length = EnValidator.isEmpty(queSites) ? 0 : queSites.length;
		for (int i = 0; i < length; i++) {
			queSiteIds.add(queSites[i].getId_quesite());
		}

		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append("SELECT ID_QUE_SITE,COUNT(DISTINCT SORTNO) AS WAITCOUNT ");
		sqlBuilder.append("FROM EN_ENT_QUE ");
		if(havePrepare){
			sqlBuilder.append("WHERE SD_STATUS_ACPT in (?,?) ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_UNACCEPT);
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_PREPARE);
		}else{
			sqlBuilder.append("WHERE SD_STATUS_ACPT = ? ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_UNACCEPT);
		}
		if (!EnValidator.isEmpty(queSiteIds)) {
			sqlBuilder.append(" AND ").append(EnSqlUtils.getInSqlByIds("ID_QUE_SITE", queSiteIds));
		}
//		int maxDrugDays = EnParamUtils.getDrugDays(depId);// 最大可发药天数
//		if (maxDrugDays > 0) {
//			FDate now = EnAppUtils.getServerDateTime().getDate().asLocalBegin();
//			sqlBuilder.append(" AND DT_IN >= ? ");
//			param.addParam(now.getDateBefore(maxDrugDays - 1));
//		}
		sqlBuilder.append(" AND DT_IN like '"+EnAppUtils.getServerDateTime().getDate()+"%' ");
		sqlBuilder.append(" GROUP BY ID_QUE_SITE ");
		sqlBuilder.append(" ORDER BY ID_QUE_SITE ");
		List list = (List) new DAFacade().execQuery(sqlBuilder.toString(), param, new ArrayListHandler());
		int size = EnValidator.isEmpty(list) ? 0 : list.size();
		Map<String, Integer> siteMap = new HashMap<String, Integer>();
		for (int i = 0; i < size; i++) {
			Object[] array = (Object[]) list.get(i);
			siteMap.put((String) array[0], (Integer) array[1]);
			EnLogUtil.getInstance().displayInfo("候诊map：站点id："+(String)array[0]+";候诊数："+(Integer) array[1]);
		}
		return siteMap;
	}

	/**
	 * 过滤不可用站点，并计算候诊数
	 * 
	 * @param pharmDepId 科室ID
	 * @param queSites 站点集合
	 * @param priDTO 就诊优先级DTO
	 * @return
	 * @throws BizException
	 */
	private Map<QueSiteDO, Integer> filterAndCalWaiting(String pharmDepId, QueSiteDO[] queSites, PriorityDTO priDTO,boolean havePrepare)
			throws BizException {
		// 1、查询站点候诊数
		Map<String, Integer> queSiteWaitMap = this.getQueSiteWaitCount(pharmDepId, queSites,havePrepare);
		// 2、过滤不可用站点
		Map<QueSiteDO, Integer> queSiteMap = new HashMap<QueSiteDO, Integer>();
		CheckSiteMatchBP checkMatchBP = new CheckSiteMatchBP();
		for (QueSiteDO queSite : queSites) {
			if (queSite == null)
				continue;
			if(!FBoolean.TRUE.equals(priDTO.getFg_base())){
				if (!PauseEnum.ONLINE.equals(queSite.getEu_pause())) {
					continue;// 如果暂停，则过滤
				}
			}
			// 是否符合准入规则
			if (!checkMatchBP.isMeet(queSite.getId_quesite(), priDTO)) {
				queSite = null;
				continue;
			}
			// 查询就诊数
			// int waitCount = this.getQueSiteWaitCount(queSite.getId_quesite(),
			// pharmDepId);
			int waitCount = 0;
			if (queSiteWaitMap.containsKey(queSite.getId_quesite())) {
				waitCount = queSiteWaitMap.get(queSite.getId_quesite());
			}
			// 候诊已满，则过滤
			if (waitCount >= queSite.getApply_max()) {
				continue;
			}

			queSiteMap.put(queSite, waitCount);
		}
		return queSiteMap;
	}

	/**
	 * 选择站点
	 * 
	 * @param queSiteMap 站点集合
	 * @return 站点DO
	 */
	private QueSiteDO selectQueSite(Map<QueSiteDO, Integer> queSiteMap) {
		QueSiteDO selectedQueSite = null;
		List<QueSiteDO> candidateSiteList = new ArrayList<QueSiteDO>();// 候选站点
		int waitCount = 0;
		if (queSiteMap != null && queSiteMap.size() > 0) {
			for (QueSiteDO queSite : queSiteMap.keySet()) {
				if (selectedQueSite == null || queSiteMap.get(queSite) < waitCount) {
					selectedQueSite = queSite;
					waitCount = queSiteMap.get(queSite);
					candidateSiteList.clear();// 清空,重新累积
					candidateSiteList.add(queSite);
				} else if (waitCount == queSiteMap.get(queSite)) {
					candidateSiteList.add(queSite);// 如果候诊相同则加入候选
				}
			}
		}

		if (EnValidator.isEmpty(candidateSiteList)) {
			return null;
		}
		// 只有一个，直接返回
		if (1 == candidateSiteList.size()) {
			return candidateSiteList.get(0);
		}

		// 如果存在多个则随机取一个
		return (QueSiteDO) EnCollectionUtils.getRandomKeyFromCollection(candidateSiteList);
	}

	/**
	 * 第三方指定窗口的时候，根据名称返回指定窗口
	 * @param queSiteDOs
	 * @param name_site
	 * @return
	 */
	private QueSiteDO getSelectSiteFromOther(QueSiteDO[] queSiteDOs,String name_site){
		for(QueSiteDO quesite :queSiteDOs){
			if(name_site.equals(quesite.getName())){
				return quesite;
			}
		}
		return null;
		
	}
	/**
	 * 放入就诊队列，并计算优先级
	 * 
	 * @param entId 就诊ID
	 * @param presId 处方id
	 * @param siteDO 站点
	 * @return
	 * @throws BizException
	 */
	private EnQueueDO addToEntQue(String entId, String presId, QueSiteDO siteDO, Integer priLevel) throws BizException {
		// 获取就诊信息
		IPativisitRService pvService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO entDO = pvService.findById(entId);
		// 获取门诊信息
		IOutpatientRService opService = ServiceFinder.find(IOutpatientRService.class);
		String whereStr = String.format("id_ent='%s'", entId);
		OutpatientDO[] opDOArray = opService.find(whereStr, null, FBoolean.FALSE);
		OutpatientDO opDO = opDOArray[0];
		// 创建就诊队列
		EnQueueDO enQueDO = new EnQueueDO();
		enQueDO.setStatus(DOStatus.NEW);
		enQueDO.setId_grp(EnContextUtils.getGrpId());// 集团ID
		enQueDO.setId_org(EnContextUtils.getOrgId());// 组织ID
		enQueDO.setId_ent(entDO.getId_ent());// 就诊id
		enQueDO.setId_enttp(entDO.getId_entp());// 就诊类型id
		enQueDO.setCode_entp(entDO.getCode_entp());
		enQueDO.setId_pat(entDO.getId_pat());
		enQueDO.setName_pat(entDO.getName_pat());
		enQueDO.setDt_regist(entDO.getDt_entry().getDate());
		enQueDO.setId_dateslot(opDO.getId_dateslot());
		enQueDO.setSd_entque_tp(IBdFcDictCodeConst.SD_QUETP_PHARMACY);// 药房
		enQueDO.setId_entque_tp(IBdFcDictCodeConst.ID_QUETP_PHARMACY);// 药房
		enQueDO.setFg_active(FBoolean.TRUE);
		FDateTime curTime = EnAppUtils.getServerDateTime();
		enQueDO.setDt_in(curTime);
		enQueDO.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_UNACCEPT);
		enQueDO.setDt_acpt(curTime);
		enQueDO.setId_emp_acpt(entDO.getId_emp_phy());
		enQueDO.setName_emp_acpt(entDO.getName_emp_phy());
		enQueDO.setId_patca(entDO.getId_patca());
		enQueDO.setId_pres(presId);// 处方id

		enQueDO.setId_que(siteDO.getId_que());// 队列id
		enQueDO.setId_que_site(siteDO.getId_quesite());// 工作站点
		// 优先级
		enQueDO.setLevel_pri(priLevel);

		// 获取序号
		FDate today = EnAppUtils.getServerDate();
		boolean lock = PKLock.getInstance().addDynamicLock(siteDO.getId_que() + today.toStdtString(), 5 * 1000);
		if(!lock){
			throw new BizException("当前数据正在被他人修改，请稍后重新刷卡！");
		}
		
		Integer sortNo = this.getSortNo(siteDO.getId_que(), entDO.getId_ent(), today);
		enQueDO.setSortno(sortNo);

		IEnqueueCudService enQueCudService = ServiceFinder.find(IEnqueueCudService.class);
		EnQueueDO[] savedDOs = enQueCudService.save(new EnQueueDO[] { enQueDO });
		if (savedDOs != null && savedDOs.length > 0) {
			return savedDOs[0];
		}

		return null;
	}

	/**
	 * 添加到药房队列
	 * 
	 * @param existEnQue 已存在的就诊队列对象
	 * @param presId 处方id
	 * @return
	 * @throws BizException
	 */
	private EnQueueDO addToEntQue(EnQueueDO existEnQue, String presId,String id_ent) throws BizException {
		if (existEnQue != null) {
			EnQueueDO newEnQue = (EnQueueDO) existEnQue.clone();
			newEnQue.setStatus(DOStatus.NEW);
			newEnQue.setId_ent_que(null);
			newEnQue.setId_pres(presId);// 处方id
			newEnQue.setId_ent(id_ent);
			IEnqueueCudService enQueCudService = ServiceFinder.find(IEnqueueCudService.class);
			EnQueueDO[] savedDOs = enQueCudService.save(new EnQueueDO[] { newEnQue });
			if (savedDOs != null && savedDOs.length > 0) {
				return savedDOs[0];
			}
		}

		return null;
	}

	/**
	 * 获取顺序号
	 * 
	 * @param queId 队列id
	 * @param entId 就诊id
	 * @param dt_regist 注册时间
	 * @return
	 * @throws BizException
	 */
	private Integer getSortNo(String queId, String entId, FDate dt_regist) throws BizException {
		// 如果已经存在该就诊的序号，则直接就用，否则取今天该队列最大号+1
		int sortNo = 1;
		IEnqueueRService enqueRService = ServiceFinder.find(IEnqueueRService.class);
		//String whereStr = String.format("id_ent='%s'", entId);
		//String orderStr = null;
		//EnQueueDO[] enQueDOArray = enqueRService.find(whereStr, orderStr, FBoolean.FALSE);
		//if (enQueDOArray != null && enQueDOArray.length > 0 && enQueDOArray[0].getSortno() != 0) {
		//	sortNo = enQueDOArray[0].getSortno();
		//} else {
		String whereStr = String.format("id_que='%s' and (dt_regist='%s' or (dt_acpt >= '%s' and dt_acpt <= '%s'))", queId, dt_regist,dt_regist,dt_regist.getDateAfter(1));
		String orderStr = "sortno desc";
		EnQueueDO[] enQueDOArray = enqueRService.find(whereStr, orderStr, FBoolean.FALSE);
		if (enQueDOArray != null && enQueDOArray.length > 0) {
			sortNo = enQueDOArray[0].getSortno() + 1;
		}
		
		//}
		return sortNo;
	}

	/**
	 * 找到未发药的记录
	 * 
	 * @param entId 就诊id
	 * @param queId 队列id
	 * @return
	 * @throws BizException
	 */
	private EnQueueDO getUnAcptEnQue(String entId, String queId,boolean havePrepare) throws BizException {
		IEnqueueRService queRService = ServiceFinder.find(IEnqueueRService.class);
		PvEP bp = new PvEP();
		PatiVisitDO patiVisit = bp.getPvByPK(entId);
		if(patiVisit ==null)
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST+"entID："+entId);
		String whereStr = null;
		if(havePrepare){
			whereStr= String.format("ID_PAT='%s' AND ID_QUE='%s' AND SD_STATUS_ACPT in ('%s','%s')  AND DT_REGIST >= '%s'", patiVisit.getId_pat(), queId,
				IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_UNACCEPT,IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_PREPARE,EnAppUtils.getServerDate());
		}else{
			whereStr= String.format("ID_PAT='%s' AND ID_QUE='%s' AND SD_STATUS_ACPT = '%s'  AND DT_REGIST >= '%s'", patiVisit.getId_pat(), queId,
					IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_UNACCEPT,EnAppUtils.getServerDate());
		}
		EnQueueDO[] enQueDOArray = queRService.find(whereStr, null, FBoolean.FALSE);
		if (enQueDOArray != null && enQueDOArray.length > 0) {
			return enQueDOArray[0];
		}
		return null;
	}
	
	/**
	 * 设置候诊人数
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private Integer setWaitNum(EnQueueDO enQueDO,boolean havePrepare) throws BizException {
		if(enQueDO == null){
			return 0;
		}
		FDate date = EnAppUtils.getServerDate();
		SqlParam param = new SqlParam();
		StringBuilder sb = new StringBuilder();
		sb.append(getBaseSQL());//候诊
		sb.append("AND EQ.DT_in like '"+date+"%' ");
		param.addParam(IBdFcDictCodeConst.SD_QUETP_PHARMACY);
		param.addParam(FBoolean.TRUE);
		sb.append("AND EQ.ID_QUE_SITE = ? ");
		param.addParam(enQueDO.getId_que_site());
		if(havePrepare){
			sb.append("AND EQ.SD_STATUS_ACPT IN (?,?) ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_UNACCEPT);
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_PREPARE);
		}else{
			sb.append("AND EQ.SD_STATUS_ACPT = ? ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_UNACCEPT);
		}
		sb.append("GROUP BY EQ.ID_PAT) ");
		Integer res = (Integer) new DAFacade().execQuery(sb.toString(), param, new ColumnHandler());
		if(res>=1){
			res = res-1;
		}
		return res;
	}
	private String getBaseSQL(){
		return "SELECT COUNT(*) FROM (SELECT COUNT(EQ.ID_ENT_QUE) FROM EN_ENT_QUE EQ WHERE EQ.SD_ENTQUE_TP = ? AND EQ.FG_ACTIVE = ? "; 
	}
}
