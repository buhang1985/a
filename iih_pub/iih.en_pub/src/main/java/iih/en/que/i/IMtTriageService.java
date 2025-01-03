package iih.en.que.i;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.que.dto.d.MedTechAppDTO;
import iih.en.que.dto.d.TriagePatInfoDTO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.enqueue.d.EnQueueDO;

/**
 * 医技分诊接口
 * @author yankan
 * @since 2015-09-29
 *
 */
public interface IMtTriageService {
	/**
	 * 登陆站点
	 * @return
	 * @throws BizException
	 */
	QueSiteDO loginQuesite() throws BizException;
	/**
	 * 更新站点状态
	 * @param queSiteId 站点id
	 * @param status 状态，0 离线，1 在线，2 暂停
	 * @return
	 * @throws BizException
	 */
	QueSiteDO changeSiteStatus(String queSiteId,Integer status) throws BizException;

	/**
	 * 签到
	 * @param appDTO 申请单DTO
	 * @return 申请单DTO
	 */
	MedTechAppDTO signIn(MedTechAppDTO appDTO) throws BizException;
	/**
	 * 撤销签到
	 * @param appDTO 申请单DTO
	 * @return 申请单DTO
	 */
	MedTechAppDTO cancelSignIn(MedTechAppDTO appDTO) throws BizException;
	/**
	 * 叫号
	 * @param quesiteId 工作点ID
	 */
	void callNumByQueSite(String quesiteId) throws BizException;
	/**
	 * 叫号
	 * @param quesiteId 工作点ID
	 */
	void callNumByQueSiteAndQue(String quesiteId,String id_que,String id_dayslot) throws BizException;
	/**
	 * 取消叫号
	 * 
	 * @param entId 就诊id
	 */
	void cancelCallNum(String entQueId) throws BizException;
	/**
	 * 检查
	 * @param appDTO 检查申请DTO
	 * @throws BizException
	 */
	void inspect(MedTechAppDTO appDTO) throws BizException;
	/**
	 * 取消检查
	 * @param appDTO 检查申请DTO
	 * @throws BizException
	 */
	void cancelInspect(MedTechAppDTO appDTO) throws BizException;
	/**
	 * 检查完毕
	 * @param appDTO 检查申请DTO
	 * @throws BizException
	 */ 
	void inspectEnd(MedTechAppDTO appDTO) throws BizException;
	/**
	 * 分诊到站点
	 * @param techDTO
	 * @param siteDTO
	 * @throws BizException
	 */
	void triageToSiteMed(MedTechAppDTO techDTO,TriageQueSiteDTO siteDTO)throws BizException;
	/**
	 * 取消分诊
	 * @param appDTO 医技申请DTO
	 * @throws BizException
	 */
	void cancelTriage(MedTechAppDTO appDTO) throws BizException;
	
	/**
	 * 叫号叫下一个
	 * @param quesiteId
	 * @param id_que
	 * @param id_dayslot
	 * @throws BizException
	 */
	void callNumNext(String quesiteId,String id_que,String id_dayslot) throws BizException;
	
	
//////////////////////////////////////////////////////////////////////////////////
///////////////                通用分诊服务                                ////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * 通用分诊--分诊到站点
	 * @param techDTO
	 * @param siteDTO
	 * @throws BizException
	 */
	EnQueueDO triageToSiteAll(MedTechAppDTO techDTO,TriageQueSiteDTO siteDTO)throws BizException;
	/**
	 * 通用分诊--取消分诊
	 * @param techDTO
	 * @throws BizException
	 */
	void celTriageToSiteAll(MedTechAppDTO techDTO) throws BizException;
	
	/**
	 * 通用分诊--取消签到
	 * @param techDTO
	 * @throws BizException
	 */
	void delSignAll(MedTechAppDTO techDTO) throws BizException;
	
	/**
	 * 通用分诊--优先级设置
	 * @param techDTO
	 * @throws BizException
	 */
	void setLevelPri(MedTechAppDTO techDTO) throws BizException;
	
	/**
	 * 通用分诊--叫号
	 * @param techDTO
	 * @throws BizException
	 */
	String callNumber(String enQueId,String oldEntQue) throws BizException;
	
	/**
	 * 通用分诊--取消叫号
	 * @param entId 就诊id
	 */
	void cancelCallNumAll(MedTechAppDTO entQueId) throws BizException ;
	
	/**
	 * 通用分诊--处置
	 * @param appDTO 处置申请DTO
	 * @throws BizException
	 */
	void inspectAll(MedTechAppDTO appDTO) throws BizException;
	
	/**
	 * 通用分诊--取消处置
	 * @param appDTO 处置申请DTO
	 * @throws BizException
	 */
	void cancelInspectAll(MedTechAppDTO appDTO) throws BizException;
	
	/**
	 * 通用分诊--处置完毕
	 * @param appDTO 处置申请DTO
	 * @throws BizException
	 */
	void inspectEndAll(MedTechAppDTO appDTO) throws BizException;
	
	/**
	 * 通用分诊--保存队列信息
	 * @param queueDo 队列TO
	 * @throws BizException
	 */
	FMap saveQueue(EnQueueDO queueDo,FBoolean isAutoDiagnosis,String id_que_site)throws BizException;
	
	/**
	 * 通用分诊--选择叫号
	 * @param techDTO
	 * @throws BizException
	 */
	void selectedCallNumber(String enQueId) throws BizException;
	
	/**
	 * 通用分诊--批量分诊
	 * @return
	 * @throws BizException
	 */
	FMap batchTriageToSite(String id_ben,String id_que_site) throws BizException;
	
	/**
	 * 通用分诊管理(新)处置服务，包含处置，取消，完成 zhangpp 2020.1.8
	 * @param triagePat
	 * @param acptStatus
	 * @throws BizException
	 */
	void inspectAllNew(TriagePatInfoDTO triagePat, String acptStatus) throws BizException;


	/******************************通用分诊新************************************/
	
	/***
	 * @Description:通用分诊（新）-签到
	 * @param id_pat 患者id
	 * @param id_queben 分诊台id
	 * @return
	 * @throws BizException
	 */
	EnQueueDO signInNew(String id_pat,TriageBenInfoDTO triageInfo) throws BizException;
	/***
	 * @Description:通用分诊（新）-分诊
	 * @param id_pat 患者id
	 * @param id_queben 分诊台id
	 * @return
	 * @throws BizException
	 */
	EnQueueDO[] autoMtTriageNew(TriageBenInfoDTO triageInfo) throws BizException;
	/***
	 * @Description:指定站点分诊
	 * @param triageQueSite
	 * @param entQueId
	 * @param triageInfo
	 * @throws BizException
	 */
	EnQueueDO[] triageToSite4Mt(TriageQueSiteDTO triageQueSiteDTO,TriageBenInfoDTO triageInfo) throws BizException;
	/***
	 * @Description:按照站点id叫号
	 * @param id_siteId
	 * @throws BizException
	 */
	String mtCallBySiteId(String id_quesite,Integer callNum) throws BizException;
	/***
	 * @Description:通用分诊叫下一个
	 * @param id_siteId
	 * @throws BizException
	 */
	String mtCallNextNumBySiteId(String id_quesite,String id_dayslot) throws BizException;
	/**
	 * @Description:叫号之前对到诊患者进行分诊-站点下无候诊患者时
	 * @param id_que_site
	 * @param id_que
	 * @throws BizException
	 */
	String autoTriageBeforCall(String id_que_site) throws BizException;
	/***
	 * @Description:修改站点状态
	 * @param id_que_site
	 * @param status
	 * @throws BizException
	 */
	void updateSiteStatus(String id_que_site,String status) throws BizException;
	/***
	 * @Description:修改就诊队列状态
	 * @param id_que_site
	 * @param status
	 * @throws BizException
	 */
	void updateEntQueStatus(String id_ent_que,String status) throws BizException;
	/***
	 * @Description:取消到诊
	 * @param id_ent_que
	 * @throws BizException
	 */
	void cancArrivedNew(String id_ent_que) throws BizException;
	/***
	 * @Description:取消分诊
	 * @param id_ent_que
	 * @throws BizException
	 */
	void cancTriageNew(String id_ent_que) throws BizException;
}
