package iih.en.que.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.ArrayListHandler;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.bd.utils.ContextUtils;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCollectionUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import iih.en.que.enqueue.i.IEnqueueCudService;
import iih.en.que.enqueue.i.IEnqueueRService;
import iih.en.que.s.bp.pharm.CheckSiteMatchBP;
import iih.en.que.s.bp.pharm.GetDeptSiteBP;
import iih.en.que.s.bp.pharm.GetPharmQueByDepBP;
import iih.mbh.nm.nhrscheddata.d.StatusEnum;
import iih.mp.dg.i.IMpDgOpMainService;
import iih.mp.dg.oppreswin.d.OpPresWinDO;
import iih.mp.dg.oppreswin.d.desc.OpPresWinDODesc;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 改变发药窗口
 * @author li.wm
 * @date: 20120年01月13日 
 */
public class ChangeDrugSiteBP  {
	/***
	 * 改变发药窗口
	 * 
	 * @param ids_ent_que  就诊队列ID列表
	 * @param id_que_site  站点ID
	 * @throws BizException
	 */
	public void exec(String spletModel,String[] presIds,String id_que_site) throws BizException {
		//1.检查参数
		this.checkParam(spletModel,presIds,id_que_site);
		//2. 获取队列
		GetPharmQueByDepBP getPharamQueBP = new GetPharmQueByDepBP();
		QueDO queDO = getPharamQueBP.exec(ContextUtils.getDeptId());
		if (queDO == null) {
			throw new BizException("科室：" + ContextUtils.getDeptId() + "的队列不存在");
		}
		//3.检验参数
		EnQueueDO[] param = this.examineParam(presIds);
		
		// 4.从新设置就诊队列列表患者的新站点
		IEnqueueCudService service = ServiceFinder.find(IEnqueueCudService.class);
		IMpDgOpMainService mpDgOpMainService = ServiceFinder.find(IMpDgOpMainService.class);
		GetEntInfo4CalPriBP getEntInfo4CalPriBP = new GetEntInfo4CalPriBP();
		// 5.检查患者是否有发药记录 
		List<EnQueueDO> fillterParam = new ArrayList<EnQueueDO>();
		for (EnQueueDO enQueueDO : param) {
			// 计算患者优先级 信息
			PriorityDTO priDTO = getEntInfo4CalPriBP.exec(enQueueDO.getId_ent());
			// 获取站点信息
			EnQueueDO existEnQue = this.getUnAcptEnQue(enQueueDO.getId_ent(), queDO.getId_que());
			if(existEnQue != null){
				//窗口是否在线
				QueSiteDO queSite = new BdSiteEP().getSiteById(existEnQue.getId_que_site());
				if(queSite != null){
					//基数药不需验证是否在线
					if(FBoolean.TRUE.equals(priDTO.getFg_base())
							|| (!FBoolean.TRUE.equals(priDTO.getFg_base()) && PauseEnum.ONLINE.equals(queSite.getEu_pause()))){
						// 符合规则，则直接插入队列
						CheckSiteMatchBP checkMatchBP = new CheckSiteMatchBP();
						if (checkMatchBP.isMeet(existEnQue.getId_que_site(), priDTO)) {
							EnQueueDO enQue = this.addToEntQue(existEnQue,enQueueDO.getId_pres(), enQueueDO.getId_ent());// 加入队列
							String whereStr =  OpPresWinDODesc.TABLE_ALIAS_NAME+"."+OpPresWinDO.ID_PRES+" in ('"+enQue.getId_pres()+"')";
							// MP_DG_Win 里的id_que_site （调药品的方法）
							mpDgOpMainService.updateDispWin(whereStr,queSite.getId_quesite());
						}
					}else{
						fillterParam.add(enQueueDO);
					}
				}else{
					fillterParam.add(enQueueDO);
				}
			}else{
				fillterParam.add(enQueueDO);
			}
		}
		if(EnValidator.isEmpty(fillterParam)){
			return ;
		}
		String site = null;
		// 6 当站点不为空的时候 选自身就行了，当站点为空的时候   当前在线站点中，系统默认时间范围内患者数量最少的站点id;
		if("1".equals(spletModel)){
			site = id_que_site;
			if(EnValidator.isEmpty(site)){
				throw new BizException("没有在线工作的站点");
			}
			// 修改就诊队列 id_que_site   
			String[] presId = new String[fillterParam.size()]; 
			for( int i = 0; i < fillterParam.size() ; i++){
				fillterParam.get(i).setStatus(StatusEnum.UPDATE);
				fillterParam.get(i).setId_que_site(site);
				presId [i] = fillterParam.get(i).getId_pres();
			}
			service.update(param);
			String whereStr =  EnSqlUtils.getInSqlByIds(OpPresWinDODesc.TABLE_ALIAS_NAME+"."+OpPresWinDO.ID_PRES, presId);
			// MP_DG_Win 里的id_que_site （调药品的方法）
			mpDgOpMainService.updateDispWin(whereStr,site);
		}else{
			// 7 多个药房站点开启时，平均分配到每个药房站点
			for (EnQueueDO enQueueDO : fillterParam) {
				// 2、过滤不符合的站点，并计算候诊数
				Map<QueSiteDO, Integer> queSiteMap = this.setFileterAndCalWaiting(enQueueDO);
				site =  this.selectQueSite(queSiteMap).getId_quesite();
				enQueueDO.setStatus(StatusEnum.UPDATE);
				enQueueDO.setId_que_site(site);
				service.update(new EnQueueDO[]{enQueueDO});
				String whereStr =  OpPresWinDODesc.TABLE_ALIAS_NAME+"."+OpPresWinDO.ID_PRES+" in ('"+enQueueDO.getId_pres()+"')";
				//6 MP_DG_Win 里的id_que_site （调药品的方法）
				mpDgOpMainService.updateDispWin(whereStr,site);
			}
			
		}

	}
	/**
	 * 检查参数
	 * @param ids_ent_que 患者就诊队列ID
	 * @throws BizxException 
	 * 
	 */
	protected void checkParam(String spletModel,String[] presIds,String id_que_site) throws BizException {
		IQuesiteRService service = ServiceFinder.find(IQuesiteRService.class);
		if(presIds == null ||presIds.length == 0){
			throw new BizException("处方队列不能为空");
		}
		
		if("1".equals(spletModel)){
			if(!EnValidator.isEmpty(id_que_site)){
				if(!PauseEnum.ONLINE.equals(service.findById(id_que_site).getEu_pause())){
					throw new BizException("当传过来的站点不为空的，站点必须是在线");
				}
			}else{
				throw new BizException("站点ID不能为空");
			}
		}
	}
	/**
	 * 检验参数，如果不为空和个数不等于0 返回 就诊队列列表
	 * @param ids_ent_que 患者就诊队列ID
	 * @throws BizxException 
	 * 
	 */
	protected EnQueueDO[]  examineParam(String[] presIds) throws BizException {
		IEnqueueRService enqueueRService = ServiceFinder.find(IEnqueueRService.class);
		
		String wheretr = EnSqlUtils.getInSqlByIds(EnQueueDODesc.TABLE_ALIAS_NAME+"."+EnQueueDO.ID_PRES, presIds);
		EnQueueDO[] entQueues = enqueueRService.find(wheretr, "", FBoolean.FALSE);

		if(entQueues == null || entQueues.length == 0){
			throw new BizException("就诊队列列表不能为空");			
		}else{
			return entQueues;
		}
	}
	/**
	 * 找到未发药的记录
	 * @param entId
	 * @Param queId
	 * @return
	 * @throws BizEXception
	 * */
	private EnQueueDO getUnAcptEnQue(String entId,String queId) throws BizException {
		IEnqueueRService service = ServiceFinder.find(IEnqueueRService.class);
		PvEP pvEP = new PvEP();
		PatiVisitDO pvByPK = pvEP.getPvByPK(entId);
		if(pvByPK == null){
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST+"entID："+entId);
		}
		String whereStr = String.format("ID_PAT='%s' AND ID_QUE='%s' AND SD_STATUS_ACPT != '%s'  AND DT_REGIST >= '%s'", pvByPK.getId_pat(),queId,
				IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_DISPENSE,EnAppUtils.getServerDate());
		EnQueueDO[] enqueus = service.find(whereStr, null, FBoolean.FALSE);
		if(enqueus != null && enqueus.length > 0){
			return enqueus[0];
		}
		return null;
	}
	/**
	 * 过滤不符合的站点，并获取候诊数据
	 * @param QueueDO 就诊队列数组 
	 * 
	 *
	 **/
	protected Map<QueSiteDO,Integer>  setFileterAndCalWaiting(EnQueueDO queueDOs) throws BizException {
		// 1. 获取药房可是站点信息  
		GetDeptSiteBP getDeptSiteBP = new GetDeptSiteBP();
		String deptId = EnContextUtils.getDeptId();
		QueSiteDO[] queSiteDOs = getDeptSiteBP.exec(deptId);
		if(queSiteDOs == null){
			throw new BizException("对应的科室没有在线工作的站点");
		}

		// 2   获取站点候诊数
		Map<String, Integer> map = this.getQueSiteWaitCount(deptId, queSiteDOs);
		// 3  过滤不可用的站点
		Map<QueSiteDO, Integer> queSiteMap =  new HashMap<QueSiteDO,Integer>();
		for (QueSiteDO queSiteDO : queSiteDOs) {
			if(queSiteDO == null )
				continue;
			
			//判断站点时可用的
			if(!PauseEnum.ONLINE.equals(queSiteDO.getEu_pause())){
				continue;
			}

			int WaitCOunt = 0;
			if(map.containsKey(queSiteDO.getId_quesite())){
				WaitCOunt = map.get(queSiteDO.getId_quesite());
			}
			//判断候诊数 是否大于最大申请量
			if(WaitCOunt > queSiteDO.getApply_max()){
				continue;
			}
			
			queSiteMap.put(queSiteDO, WaitCOunt);
	
		}
		return queSiteMap;
		
	}
	/**
	 *  获科室所有站点的候诊长度
	 *  @param deptId 部门ID
	 *  @Param queSiteDOs 站点数组
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map<String,Integer> getQueSiteWaitCount(String deptId,QueSiteDO[] queSiteDOs) throws BizException {
		List<String> queSiteIds = new ArrayList<String>();
		int length = EnValidator.isEmpty(queSiteDOs)? 0 : queSiteDOs.length;
		
		for (int i = 0; i < length ; i++){
			queSiteIds.add(queSiteDOs[i].getId_quesite());
		}
		
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append("SELECT ID_QUE_SITE,COUNT(DISTINCT SORTNO) AS WAITCOUNT ");
		sqlBuilder.append("FROM EN_ENT_QUE ");
		sqlBuilder.append("WHERE SD_STATUS_ACPT != ? ");
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_DISPENSE);
		
		if(!EnValidator.isEmpty(queSiteIds)){
			sqlBuilder.append(" AND ").append(EnSqlUtils.getInSqlByIds("ID_QUE_SITE", queSiteIds));
		}
		// 最大可发药天数
		int maxDrugDays  = EnParamUtils.getDrugDays(deptId);
		
		if(maxDrugDays > 0 ){
			FDate now  = EnAppUtils.getServerDateTime().getDate().asLocalBegin();
			sqlBuilder.append(" AND DT_IN >= ? ");
			param.addParam(now.getDateBefore(maxDrugDays - 1));
		}
		
		sqlBuilder.append(" GROUP BY ID_QUE_SITE ");
		
		List list = (List)new DAFacade().execQuery(sqlBuilder.toString(), param , new ArrayListHandler());
		int size = EnValidator.isEmpty( list)? 0 : list.size();
		
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		for(int i =0 ; i < size ;i++){
			Object[] object = (Object[])list.get(i);
			map.put((String)object[0], (Integer)object[1]);
		}
		
		return map;
	}
	
	/**
	 * 获取站点 
	 * @Param queSiteMap 站点结合
	 */
	protected QueSiteDO selectQueSite(Map<QueSiteDO, Integer> queSiteMap) {
		QueSiteDO selectedQueSite = null;
		// 候选站点
		ArrayList<QueSiteDO> candidateSiteList = new ArrayList<QueSiteDO>();
		int waitCount = 0;
		
		if(queSiteMap != null && queSiteMap.size() > 0){
			for (QueSiteDO queSiteDO : queSiteMap.keySet()) {
				if(selectedQueSite == null || queSiteMap.get(queSiteDO) < waitCount ){
					selectedQueSite  = queSiteDO;
					waitCount  = queSiteMap.get(queSiteDO);
					candidateSiteList.clear();
					candidateSiteList.add(queSiteDO);
				}else if(waitCount == queSiteMap.get(queSiteDO)){
					candidateSiteList.add(queSiteDO);
				}
			}
		}
		
		if(EnValidator.isEmpty(candidateSiteList)){
			return null;
		}
		
		if(1 == candidateSiteList.size()){
			return candidateSiteList.get(0);
		}
		
		return (QueSiteDO)EnCollectionUtils.getRandomKeyFromCollection(candidateSiteList);
				
	}
	/**
	 * 修改到药房队列
	 * 
	 * @param existEnQue 已存在的就诊队列对象
	 * @param presId 处方id
	 * @return
	 * @throws BizException
	 */
	private EnQueueDO addToEntQue(EnQueueDO existEnQue, String presId,String id_ent) throws BizException {
		if (existEnQue != null) {
			EnQueueDO newEnQue = (EnQueueDO) existEnQue.clone();
			newEnQue.setStatus(DOStatus.UPDATED);
			newEnQue.setId_ent_que(null);
			newEnQue.setId_pres(presId);// 处方id
			newEnQue.setId_ent(id_ent);
			IEnqueueCudService enQueCudService = ServiceFinder.find(IEnqueueCudService.class);
			EnQueueDO[] savedDOs = enQueCudService.update(new EnQueueDO[] { newEnQue });
			if (savedDOs != null && savedDOs.length > 0) {
				return savedDOs[0];
			}
		}

		return null;
	}
	
}
