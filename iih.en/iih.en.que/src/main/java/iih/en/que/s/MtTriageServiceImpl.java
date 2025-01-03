package iih.en.que.s;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.MedTechAppDTO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriagePatInfoDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.i.IMtTriageService;
import iih.en.que.s.bp.AllTriageBP;
import iih.en.que.s.bp.BatchTriageToSite;
import iih.en.que.s.bp.CallNumByQueSiteAndQueBP;
import iih.en.que.s.bp.CancMtTriageBP;
import iih.en.que.s.bp.EnQueBP;
import iih.en.que.s.bp.MedTechTriageBP;
import iih.en.que.s.bp.QueSiteBP;
import iih.en.que.s.bp.mt.AutoMtTriageBP;
import iih.en.que.s.bp.mt.AutoTriageBeforCallBP;
import iih.en.que.s.bp.mt.CallNumByQueSiteBP;
import iih.en.que.s.bp.mt.CancArrivedBP;
import iih.en.que.s.bp.mt.CancTriageBP;
import iih.en.que.s.bp.mt.CancelInspectBP;
import iih.en.que.s.bp.mt.InspectBP;
import iih.en.que.s.bp.mt.InspectEndBP;
import iih.en.que.s.bp.mt.MtCallNextNumBP;
import iih.en.que.s.bp.mt.MtCallNumBP;
import iih.en.que.s.bp.mt.SignInBP;
import iih.en.que.s.bp.mt.TriageToSite4MtBP;
import iih.en.que.s.bp.mt.UpdateEntQueStatusBP;
import iih.en.que.s.bp.mt.UpdateSiteStatusBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医技申请分诊服务
 * 
 * @author yankan
 * @since 2015-09-29
 *
 */
@Service(serviceInterfaces = { IMtTriageService.class }, binding = Binding.JSONRPC)
public class MtTriageServiceImpl implements IMtTriageService {
	/**
	 * 构造函数
	 */
	public MtTriageServiceImpl() {
	}
	/**
	 * 登陆站点
	 * @return
	 * @throws BizException
	 */
	@Override
	public QueSiteDO loginQuesite() throws BizException{
		QueSiteBP quesiteBP = new QueSiteBP();
		return quesiteBP.login();		
	}
	/**
	 * 更新站点状态
	 * @param queSiteId
	 * @param status 状态，0 离线，1 在线，2 暂停
	 * @return
	 * @throws BizException
	 */
	@Override
	public QueSiteDO changeSiteStatus(String queSiteId,Integer status) throws BizException{
		QueSiteBP quesiteBP = new QueSiteBP();
		return quesiteBP.changeSiteStatus(queSiteId, status);	
	}
	
	/**
	 * 签到
	 * @param appDTO 申请单DTO
	 */
	@Override
	public MedTechAppDTO signIn(MedTechAppDTO appDTO) throws BizException{
		MedTechTriageBP mtTriageBP = new MedTechTriageBP();
		return mtTriageBP.signIn(appDTO);
	}
	/**
	 * 撤销签到
	 * @param appDTO 申请单DTO
	 */
	@Override
	public MedTechAppDTO cancelSignIn(MedTechAppDTO appDTO)  throws BizException{
		MedTechTriageBP mtTriageBP = new MedTechTriageBP();
		return mtTriageBP.cancelSignIn(appDTO);
	}
	/**
	 * 分诊到站点
	 * @param techDTO 医技DTO
	 * @param siteDTO 工作点DTO
	 */
	@Override
	public void triageToSiteMed(MedTechAppDTO techDTO,TriageQueSiteDTO siteDTO) throws BizException{
		MedTechTriageBP mtTriageBP = new MedTechTriageBP();
		mtTriageBP.triageToSite(techDTO,siteDTO);
	}
	/**
	 * 叫号
	 * @param quesiteId 工作点ID
	 */
	@Override
	public void callNumByQueSite(String quesiteId) throws BizException {
		CallNumByQueSiteBP callNumBP = new CallNumByQueSiteBP();
		callNumBP.exec(quesiteId);
	}
	
	/**
	 * 叫号
	 * @param quesiteId 工作点ID
	 */
	@Override
	public void callNumByQueSiteAndQue(String quesiteId,String id_que,String id_dayslot) throws BizException {
		CallNumByQueSiteAndQueBP callNumBP = new CallNumByQueSiteAndQueBP();
		callNumBP.exec(quesiteId,id_que,id_dayslot);
	}
	/**
	 * 叫号   叫下一个
	 */
	@Override
	public void callNumNext(String quesiteId, String id_que, String id_dayslot) throws BizException {
		CallNumNextBP bp = new CallNumNextBP();
		bp.exec(quesiteId,id_que,id_dayslot);
	}
	/**
	 * 取消叫号
	 * 
	 * @param entId 就诊id
	 */
	@Override
	public void cancelCallNum(String entQueId) throws BizException {			
		EnQueBP enQueBP = new EnQueBP();
		enQueBP.updateStatus(entQueId, IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);//到诊
	}

	/**
	 * 检查
	 * @param appDTO 检查申请DTO
	 * @throws BizException
	 */
	@Override
	public void inspect(MedTechAppDTO appDTO) throws BizException {
		InspectBP inspectBP = new InspectBP();
		inspectBP.exec(appDTO);
	}

	/**
	 * 取消检查 
	 * @param appDTO 检查申请DTO
	 * @throws BizException
	 */
	@Override
	public void cancelInspect(MedTechAppDTO appDTO) throws BizException {
		CancelInspectBP cancInspectBP = new CancelInspectBP();
		cancInspectBP.exec(appDTO);
	}

	/**
	 * 检查完毕
	 * @param appDTO 检查申请DTO
	 * @throws BizException
	 */
	@Override
	public void inspectEnd(MedTechAppDTO appDTO) throws BizException {
		InspectEndBP inspectEndBP = new InspectEndBP();
		inspectEndBP.exec(appDTO);
	}
	/**
	 * 取消分诊
	 * @param appDTO 医技申请DTO
	 * @throws BizException
	 */
	@Override
	public void cancelTriage(MedTechAppDTO appDTO) throws BizException {	
		CancMtTriageBP cancTriageBP = new CancMtTriageBP();
		cancTriageBP.cancelTriage(appDTO);
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	///////////////                通用分诊服务                                ////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////

	
	/**
	 *  通用分诊--分诊到站点
	 * @param techDTO
	 * @param siteDTO
	 * @throws BizException
	 */
	@Override
	public EnQueueDO triageToSiteAll(MedTechAppDTO techDTO, TriageQueSiteDTO siteDTO) throws BizException {
		AllTriageBP bp = new AllTriageBP();
		return bp.triageToSiteAll(techDTO, siteDTO);
	}
	
	/**
	 * 通用分诊--取消分诊
	 * @param techDTO
	 * @throws BizException
	 */
	public void celTriageToSiteAll(MedTechAppDTO techDTO) throws BizException {
		AllTriageBP bp = new AllTriageBP();
		bp.celTriageToSiteAll(techDTO);
	}

	/**
	 * 通用分诊--取消签到
	 * @param techDTO
	 * @throws BizException
	 */
	@Override
	public void delSignAll(MedTechAppDTO techDTO) throws BizException {
		AllTriageBP bp = new AllTriageBP();
		bp.delSignAll(techDTO);
	}

	/**
	 * 通用分诊--优先级设置
	 * @param techDTO
	 * @throws BizException
	 */
	@Override
	public void setLevelPri(MedTechAppDTO techDTO) throws BizException {
		AllTriageBP bp = new AllTriageBP();
		bp.setLevelPri(techDTO);
	}
	
	/**
	 * 通用分诊--叫号
	 * @param techDTO
	 * @throws BizException
	 */
	@Override
	public String callNumber(String enQueId,String oldEntQue) throws BizException {
		EnQueBP enQueBP = new EnQueBP();
		return enQueBP.updateStatusForAll(enQueId, oldEntQue);//叫号
	}
	
	/**
	 * 通用分诊--取消叫号
	 * 
	 * @param entId 就诊id
	 */
	@Override
	public void cancelCallNumAll(MedTechAppDTO techDTO) throws BizException {			
		EnQueBP enQueBP = new EnQueBP();
		enQueBP.updateStatus(techDTO.getId_ent_que(), IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);//到诊
	}
	
	/**
	 * 通用分诊--处置
	 * @param appDTO 处置申请DTO
	 * @throws BizException
	 */
	@Override
	public void inspectAll(MedTechAppDTO appDTO) throws BizException {
		InspectBP inspectBP = new InspectBP();
		inspectBP.exec(appDTO);
	}

	/**
	 * 通用分诊--取消处置 
	 * @param appDTO 处置申请DTO
	 * @throws BizException
	 */
	@Override
	public void cancelInspectAll(MedTechAppDTO appDTO) throws BizException {
		CancelInspectBP cancInspectBP = new CancelInspectBP();
		cancInspectBP.exec(appDTO);
	}

	/**
	 * 通用分诊--处置完毕
	 * @param appDTO 处置申请DTO
	 * @throws BizException
	 */
	@Override
	public void inspectEndAll(MedTechAppDTO appDTO) throws BizException {
		InspectEndBP inspectEndBP = new InspectEndBP();
		inspectEndBP.execAllQueue(appDTO);
	}
	
	/**
	 * 通用分诊--保存队列信息
	 * @param queueDo 队列TO
	 * @throws BizException
	 */
	@Override
	public FMap saveQueue(EnQueueDO queueDo,FBoolean isAutoDiagnosis,String id_que_site) throws BizException {
		AllTriageBP bp = new AllTriageBP();
		return bp.saveQueue(queueDo, isAutoDiagnosis, id_que_site);
	}
	
	/**
	 * 通用分诊--选择叫号
	 * @param techDTO
	 * @throws BizException
	 */
	@Override
	public void selectedCallNumber(String enQueId) throws BizException {
		EnQueBP enQueBP = new EnQueBP();
		enQueBP.selectedCallNum(enQueId);//叫号
	}
	
	/**
	 * 通用分诊--批量分诊
	 */
	@Override
	public FMap batchTriageToSite(String id_ben,String id_que_site) throws BizException {
		return new BatchTriageToSite().exec(id_ben,id_que_site);
	}
	
	/**
	 * 通用分诊管理(新)处置服务，包含处置，取消，完成
	 */
	@Override
	public void inspectAllNew(TriagePatInfoDTO triagePat, String acptStatus) throws BizException{
		if(EnValidator.isEmpty(triagePat.getId_ent_que())){
			throw new BizException("就诊队列id不能为空!");
		}		
		new EnQueBP().updateStatus(triagePat.getId_ent_que(), acptStatus);
	}
	
	/******************************通用分诊新************************************/
	
	/***
	 * @Description:通用分诊（新）-签到
	 * @param id_pat 患者id
	 * @param id_queben 分诊台id
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnQueueDO signInNew(String id_pat,TriageBenInfoDTO triageInfo) throws BizException{
		return new SignInBP().exec(id_pat, triageInfo);
	}
	/***
	 * @Description:通用分诊（新）-自动分诊
	 * @param id_pat 患者id
	 * @param id_queben 分诊台id
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnQueueDO[] autoMtTriageNew(TriageBenInfoDTO triageInfo) throws BizException{
		return new AutoMtTriageBP().exec(triageInfo);
	}
	/***
	 * @Description:分诊到指定站点
	 * @param triageQueSite
	 * @param entQueId
	 * @param triageInfo
	 * @throws BizException
	 */
	@Override
	public EnQueueDO[] triageToSite4Mt(TriageQueSiteDTO triageQueSiteDTO,TriageBenInfoDTO triageInfo) throws BizException{
		return new TriageToSite4MtBP().exec(triageQueSiteDTO, triageInfo);
	}
	/***
	 * @Description:按照站点id叫号
	 * @param id_siteId
	 * @throws BizException
	 */
	@Override
	public String mtCallBySiteId(String id_quesite,Integer callNum) throws BizException{
		return new MtCallNumBP().exec(id_quesite, callNum);
	}
	/***
	 * @Description:通用分诊叫下一个
	 * @param id_siteId
	 * @throws BizException
	 */
	@Override
	public String mtCallNextNumBySiteId(String id_quesite,String id_dayslot) throws BizException{
		return new MtCallNextNumBP().exec(id_quesite,id_dayslot);
	}
	/**
	 * @Description:叫号之前对到诊患者进行分诊-站点下无候诊患者时
	 * @param id_que_site
	 * @param id_que
	 * @throws BizException
	 */
	@Override
	public String autoTriageBeforCall(String id_que_site) throws BizException{
		return new AutoTriageBeforCallBP().exec(id_que_site);
	}
	/***
	 * @Description:修改站点状态
	 * @param id_que_site
	 * @param status
	 * @throws BizException
	 */
	@Override
	public void updateSiteStatus(String id_que_site,String status) throws BizException{
		new UpdateSiteStatusBP().exec(id_que_site, status);
	}
	/***
	 * @Description:修改就诊队列状态
	 * @param id_que_site
	 * @param status
	 * @throws BizException
	 */
	@Override
	public void updateEntQueStatus(String id_ent_que,String status) throws BizException{
		new UpdateEntQueStatusBP().exec(id_ent_que, status);
	}
	/***
	 * @Description:取消到诊
	 * @param id_ent_que
	 * @throws BizException
	 */
	@Override
	public void cancArrivedNew(String id_ent_que) throws BizException{
		new CancArrivedBP().exec(id_ent_que);
	}
	/***
	 * @Description:取消分诊
	 * @param id_ent_que
	 * @throws BizException
	 */
	@Override
	public void cancTriageNew(String id_ent_que) throws BizException{
		new CancTriageBP().exec(id_ent_que);
	}
}
