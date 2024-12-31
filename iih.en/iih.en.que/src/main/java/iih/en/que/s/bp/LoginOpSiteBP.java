package iih.en.que.s.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteCudService;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.s.bp.op.qry.benmgr.GetQue4BenMgrBP;
import iih.en.que.s.event.bp.EnOpQueEventBP;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊医生登录站点初始化
 * 
 * @author liubin
 *
 */
public class LoginOpSiteBP {
	/**
	 * 门诊医生登录站点初始化
	 * 
	 * @param queSiteId
	 * 		医生工作站ID
	 * @param que
	 * 		医生出诊队列
	 * @param depId
	 * 		医生出诊科室
	 * @param empId
	 * 		出诊医生
	 * @return
	 * @throws BizException
	 */
	public QueSiteDO exec(EnTrDocSiteInfoDTO siteInfo) throws BizException {
		EnValidator.validateParam("siteInfo", siteInfo);
		if(siteInfo.getDate() == null)
			siteInfo.setDate(EnAppUtils.getServerDate());
		String queId = EnValidator.isEmpty(siteInfo.getId_ques()) ? null : (String)siteInfo.getId_ques().get(0);
		QueSiteDO queSite = this.loginSite(queId, siteInfo);
		boolean isBenQueMgr = EnParamUtils.isBenQueMgr();
		if(isBenQueMgr){
			siteInfo.setId_queben(queSite.getId_queben());
			String[] queIds = new GetQue4BenMgrBP().getQueIdsBySiteId(siteInfo);
			//把分诊到当前医生但站点为离线 患者自动分诊到本站点
			this.changeEnSite(queIds, siteInfo);
		}else{
			//把分诊到当前医生但站点为离线 患者自动分诊到本站点
			this.changeEnSite(queId == null ? null : new String[] {queId}, siteInfo);
		}
		//更改按站点分诊候诊患者的队列为登录医生队列
		this.changeEnque(siteInfo.getId_quesite(), queId, siteInfo.getDate());
		//触发上线事件
		this.invokeOnLine(queId, siteInfo.getId_quesite(), siteInfo.getCode_entp(), null);
		return queSite;
	}
	
	/**
	 * 把分诊到当前医生但站点为离线 患者自动分诊到本站点
	 * 
	 * @param siteId
	 * @param queIds
	 * @param empId
	 * @param date
	 * @throws BizException 
	 */
	private void changeEnSite(String[] queIds, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		if(EnValidator.isEmpty(siteInfo.getId_quesite()) 
				|| EnValidator.isEmpty(siteInfo.getId_emp())
				|| EnValidator.isEmpty(queIds))
			return;
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" SELECT EQ.* FROM EN_ENT_QUE EQ ");
		sqlBuilder.append(" LEFT JOIN BD_QUE_SITE BS ON EQ.ID_QUE_SITE = BS.ID_QUESITE ");
		sqlBuilder.append(" WHERE EQ.SD_ENTQUE_TP = ? ");
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		sqlBuilder.append(" AND EQ.ID_EMP_OPREG = ? ");
		param.addParam(siteInfo.getId_emp());
		sqlBuilder.append(" AND EQ.DT_REGIST = ? ");
		param.addParam(siteInfo.getDate());
		sqlBuilder.append(" AND EQ.FG_ACTIVE = ? ");
		param.addParam(FBoolean.TRUE);
		sqlBuilder.append(" AND EQ.ID_QUE_SITE <> ? ");
		param.addParam(siteInfo.getId_quesite());
		sqlBuilder.append(" AND BS.EU_PAUSE = ? ");
		param.addParam(PauseEnum.OFFLINE);
		sqlBuilder.append(" AND EQ.SD_STATUS_ACPT IN (?,?,?,?) ");
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
		sqlBuilder.append(" AND ").append(EnSqlUtils.getInSqlByIds(" EQ.ID_QUE ", queIds));
		String sql = sqlBuilder.toString();
		List<EnQueueDO> list = (List<EnQueueDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(EnQueueDO.class));
		if(EnValidator.isEmpty(list))
			return;
		for(EnQueueDO queueDO : list){
			queueDO.setStatus(DOStatus.UPDATED);
			queueDO.setId_que_site(siteInfo.getId_quesite());
		}
		new EnQueEP().save(list.toArray(new EnQueueDO[0]));
	}
	
	/**
	 * 更改按站点分诊候诊患者的队列为登录医生队列
	 * 
	 * @param siteId
	 * @param queIds
	 * @param date
	 * @throws BizException
	 */
	private void changeEnque(String siteId, String queId, FDate date) throws BizException{
		if(EnValidator.isEmpty(siteId) 
				|| EnValidator.isEmpty(queId))
			return;
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT EQ.* FROM EN_ENT_QUE EQ ");
		sqlBuilder.append(" WHERE EQ.SD_ENTQUE_TP = ? ");
		sqlBuilder.append(" AND NVL(EQ.ID_EMP_OPREG,'~') = '~' ");
		sqlBuilder.append(" AND EQ.ID_QUE_SITE = ? ");
		sqlBuilder.append(" AND EQ.ID_QUE <> ? ");
		sqlBuilder.append(" AND EQ.DT_REGIST = ? ");
		sqlBuilder.append(" AND EQ.FG_ACTIVE = ? ");
		sqlBuilder.append(" AND EQ.SD_STATUS_ACPT IN (?,?,?,?) ");
		String sql = sqlBuilder.toString();
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(siteId);
		param.addParam(queId);
		param.addParam(date);
		param.addParam(FBoolean.TRUE);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
		List<EnQueueDO> list = (List<EnQueueDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(EnQueueDO.class));
		if(EnValidator.isEmpty(list))
			return;
		for(EnQueueDO queueDO : list){
			queueDO.setStatus(DOStatus.UPDATED);
			queueDO.setId_que(queId);
		}
		new EnQueEP().save(list.toArray(new EnQueueDO[0]));
	}
	
	/**
	 * 门诊医生登录站点初始化
	 * 
	 * @param queSiteId
	 * @param queId
	 * @param depId
	 * @param empId
	 * @param curTime
	 * @return
	 * @throws BizException
	 */
	private QueSiteDO loginSite(String queId, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		IQuesiteRService serv = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO queSite = serv.findById(siteInfo.getId_quesite());
		if(queSite!=null){
			queSite.setStatus(DOStatus.UPDATED);
			queSite.setId_que(queId);
			queSite.setId_dep(siteInfo.getId_dep());
			queSite.setId_emp(siteInfo.getId_emp());
			queSite.setFg_active(FBoolean.TRUE);
			queSite.setEu_pause(PauseEnum.ONLINE);
			QueSiteDO[] queSites = this.saveQueSite(new QueSiteDO[]{queSite});
			if(!EnValidator.isEmpty(queSites)){
				return serv.findById(siteInfo.getId_quesite());
			}
		}
		return null;
	}
	
	/**
	 * 保存站点信息
	 * 
	 * @param queSites
	 * @return
	 * @throws BizException
	 */
	private QueSiteDO[] saveQueSite(QueSiteDO[] queSites) throws BizException{
		if(!EnValidator.isEmpty(queSites)){
			return ServiceFinder.find(IQuesiteCudService.class).save(queSites);
		}
		return null;
	}
	/**
	 * 触发上线事件
	 * 
	 * @param queId
	 * @param siteId
	 * @param entId
	 * @throws BizException 
	 */
	private void invokeOnLine(String queId, String siteId, String codeEnTp, String entId) throws BizException{
		EnOpQueEventBP event = new EnOpQueEventBP();
		event.invokeEnOpQueEvent(queId, siteId, codeEnTp, entId, IEnEventConst.EVENT_EN_OP_DOC_ONLINE);
	}
	/**
	 * 触发下线事件
	 * 
	 * @param queId
	 * @param siteId
	 * @param entId
	 * @throws BizException 
	 */
	private void invokeOffLine(String queId, String siteId, String codeEnTp, String entId) throws BizException{
		EnOpQueEventBP event = new EnOpQueEventBP();
		event.invokeEnOpQueEvent(queId, siteId, codeEnTp, entId, IEnEventConst.EVENT_EN_OP_DOC_OFFLINE);
	}
}
