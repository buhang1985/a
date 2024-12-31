package iih.en.que.s.bp.mt;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;

/***
 * 叫号之前对到诊患者进行分诊-站点下无候诊患者时
 * @author fanlq
 * @date: 2020年3月16日 下午2:35:23
 */
public class AutoTriageBeforCallBP {

	/***
	 * @Description:叫号之前对到诊患者进行分诊-站点下无候诊患者时
	 * @param id_que_site
	 */
	public String exec(String id_que_site) throws BizException{
		if(EnValidator.isEmpty(id_que_site))
			return null;
		QueDO queDO = getQueDOBySiteId(id_que_site);
		if(queDO != null && IBdFcDictCodeConst.SD_MODEL_OP_EMP.equals(queDO.getSd_mode())){
			if(isOnline(id_que_site) && !haveTriagedPat(id_que_site)){
				if(!EnValidator.isEmpty(queDO.getId_queben()) && this.haveArrivedPat(queDO.getId_queben())){
					//指定站点分诊
					return this.triage(queDO,id_que_site);
				}
			}
		}
		return null;
	}
	/***
	 * @Description:指定站点分诊
	 * @param queDO
	 * @param id_que_site
	 * @throws BizException
	 */
	private String triage(QueDO queDO,String id_que_site) throws BizException{
		MtTriageToSiteBP bp = new MtTriageToSiteBP();
		EnQueueDO[] enQueueDOs = this.getArrivedPat(queDO.getId_queben());
		TriageQueSiteDTO triageQueSite = new TriageQueSiteDTO();
		triageQueSite.setId_ben(queDO.getId_queben());
		triageQueSite.setId_que(queDO.getId_que());
		triageQueSite.setId_quesite(id_que_site);
		triageQueSite.setId_emp(EnContextUtils.getPsnId());
		FDate today = EnAppUtils.getServerDate();
		boolean lock = PKLock.getInstance().addDynamicLock(queDO.getId_queben() + today.toStdtString(), 5 * 1000);
		if (!lock) {
			throw new BizException("当前数据正在被他人修改，请稍后重新刷卡！");
		}
		Integer sortNo = this.getSortNo(queDO.getId_queben(),id_que_site, today);
		triageQueSite.setTicketno(sortNo);
		if(!EnValidator.isEmpty(enQueueDOs)){
			bp.exec(triageQueSite, enQueueDOs[0].getId_ent_que());
			return enQueueDOs[0].getId_ent_que();
		}
		return null;
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
	private Integer getSortNo(String id_queben,String id_que_site, FDate dt_regist) throws BizException {
		// 如果已经存在该就诊的序号，则直接就用，否则取今天该队列最大号+1
		int sortNo = 1;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT SORTNO FROM EN_ENT_QUE ");
		sql.append("WHERE SD_ENTQUE_TP = ? AND ID_QUEBEN= ? AND (DT_REGIST= ? OR (DT_ACPT >= ? AND DT_ACPT <= ? )) ");
		sql.append("AND SORTNO IS NOT NULL ");
		sql.append("AND ID_QUE_SITE = ? ");// 站点
		sql.append("ORDER BY SORTNO DESC ");
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_QUETP_OTHER);
		param.addParam(id_queben);
		param.addParam(dt_regist);
		param.addParam(dt_regist);
		param.addParam(dt_regist.getDateAfter(1));
		param.addParam(id_que_site);
		List<EnQueueDO> list = (List<EnQueueDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(EnQueueDO.class));
		if(!EnValidator.isEmpty(list) && list.get(0).getSortno() != null){
			sortNo = list.get(0).getSortno() + 1;
		}
		return sortNo;
	}
	/***
	 * @Description:站点是否在线
	 * @param id_que_site
	 * @return
	 * @throws BizException
	 */
	private boolean isOnline(String id_que_site) throws BizException{
		IQuesiteRService rService = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO siteDO = rService.findById(id_que_site);
		if(siteDO != null && PauseEnum.ONLINE.equals(siteDO.getEu_pause())){
			return true;
		}
		return false;
	}
	/***
	 * @Description:该站点下是否存在分诊状态的患者
	 * @param id_que_site
	 * @return
	 * @throws BizException 
	 */
	private boolean haveTriagedPat(String id_que_site) throws BizException{
		EnQueueDO[] enques = this.getWillCallingEnt(id_que_site);
		if(!EnValidator.isEmpty(enques)){
			return true;
		}
		return false;
	}
	/***
	 * @Description:该分诊台下是否存在到诊状态的患者
	 * @param id_que_site
	 * @return
	 * @throws BizException 
	 */
	private boolean haveArrivedPat(String id_que_ben) throws BizException{
		EnQueueDO[] enques = this.getArrivedPat(id_que_ben);
		if(!EnValidator.isEmpty(enques)){
			return true;
		}
		return false;
	}
	/***
	 * @Description:根据站点id获取队列
	 * @param id_que_site
	 * @return
	 * @throws BizException
	 */
	private QueDO getQueDOBySiteId(String id_que_site) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT QUE.SD_MODE,QUE.ID_QUE,QUE.ID_QUEBEN ");
		sql.append("FROM BD_QUE QUE " );
		sql.append("INNER JOIN BD_QUE_SITE QUESITE ON QUESITE.ID_QUE = QUE.ID_QUE " );
		sql.append("WHERE QUESITE.ID_QUESITE = ? ");
		SqlParam param = new SqlParam();
		param.addParam(id_que_site);
		@SuppressWarnings("unchecked")
		List<QueDO> list = (List<QueDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(QueDO.class));
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new QueDO[0])[0];
		}
		return null;
	}

	/**
	 * 获取该分诊台下的到诊患者
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
	public EnQueueDO[] getArrivedPat(String id_que_ben) throws BizException{
		FDate date = EnAppUtils.getServerDate();
		String whereStr = String.format("%s.ID_QUE_SITE IS NULL AND %s.ID_QUEBEN='%s' AND %s.SD_STATUS_ACPT = '%s' AND %s.dt_regist >= '%s' AND %s.sd_entque_tp = '%s' AND %s.FG_ACTIVE = '%s' ",
				EnQueueDODesc.TABLE_ALIAS_NAME,
				EnQueueDODesc.TABLE_ALIAS_NAME, id_que_ben,
				EnQueueDODesc.TABLE_ALIAS_NAME, IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT,
				EnQueueDODesc.TABLE_ALIAS_NAME, date,
				EnQueueDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUETP_OTHER,
				EnQueueDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE);
		String orderStr = String.format(" %s.DT_IN ", EnQueueDODesc.TABLE_ALIAS_NAME);
		EnQueueDO[] enQueues = new EnQueEP().getEnQueueByWhereStr(whereStr, orderStr);
		return enQueues;
	}
	/**
	 * 获取要等候患者
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
	public EnQueueDO[] getWillCallingEnt(String id_que_site) throws BizException{
		FDate date = EnAppUtils.getServerDate();
		String whereStr = String.format("%s.ID_QUE_SITE='%s' AND %s.SD_STATUS_ACPT = '%s' AND %s.dt_regist >= '%s' AND %s.sd_entque_tp = '%s' AND %s.FG_ACTIVE = '%s' ",
				EnQueueDODesc.TABLE_ALIAS_NAME, id_que_site,
				EnQueueDODesc.TABLE_ALIAS_NAME, IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT,
				EnQueueDODesc.TABLE_ALIAS_NAME, date,
				EnQueueDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUETP_OTHER,
				EnQueueDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE);
		String orderStr = String.format(" %s.SORTNO ", EnQueueDODesc.TABLE_ALIAS_NAME);
		EnQueueDO[] enQueues = new EnQueEP().getEnQueueByWhereStr(whereStr, orderStr);
		return enQueues;
	}
}
