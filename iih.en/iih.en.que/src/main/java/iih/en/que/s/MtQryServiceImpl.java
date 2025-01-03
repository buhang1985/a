package iih.en.que.s;

import iih.en.que.dto.d.EntForMTDTO;
import iih.en.que.dto.d.MedTechAppDTO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriagePatInfoDTO;
import iih.en.que.dto.d.TriagePatQryDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.i.IMtQryService;
import iih.en.que.s.bp.AllTriageBP;
import iih.en.que.s.bp.GetAllChappPatinfoBP;
import iih.en.que.s.bp.MedTechTriageBP;
import iih.en.que.s.bp.mt.GetPatInfoByQueSiteIdBP;
import iih.en.que.s.bp.mt.GetTriageQueByBenBP;
import iih.en.que.s.bp.mt.GetTriageQueSiteBP;
import iih.en.que.s.bp.mt.GetTyTriageBenInfoBP;
import iih.en.que.s.bp.op.GetAllQueuePatNewBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAException;

/**
 * 医技分诊查询服务
 * 
 * @author yank
 * @author renying
 *
 */
@Service(serviceInterfaces = { IMtQryService.class }, binding = Binding.JSONRPC)
public class MtQryServiceImpl implements IMtQryService {
	/**
	 * 获取医技检查申请列表
	 * 
	 * @param benId 分诊台id
	 * @param acptStatus 检查状态，见MedTechAcptStatus
	 * @return
	 */
	@Override
	public MedTechAppDTO[] getMedTechApp(String benId, String[] acptStatus) throws BizException {
		MedTechTriageBP mtTriageBP = new MedTechTriageBP();
		return mtTriageBP.getMedTechApp(benId, acptStatus);
	}

	/**
	 * 获取站点的医技检查申请列表
	 * 
	 * @param quesiteId 工作站点id
	 * @param acptStatus 检查状态，见MedTechAcptStatus
	 * @return
	 * @throws DAException
	 */
	@Override
	public MedTechAppDTO[] getMedTechAppBySite(String quesiteId, String[] acptStatus)
			throws BizException {
		MedTechTriageBP mtTriageBP = new MedTechTriageBP();
		return mtTriageBP.getMedTechAppBySite(quesiteId, acptStatus);
	}

	/**
	 * 获取医技检查申请列表 页面加载时
	 * 
	 * @param benId 分诊台id
	 * @param status 检查状态，取值参考：MedTechTriageStatus
	 * @param sdsu 申请单状态
	 * @return
	 */
	@Override
	public MedTechAppDTO[] getMedTechAppAndSts(String benId, int status) throws BizException {
		MedTechTriageBP mtTriageBP = new MedTechTriageBP();
		return mtTriageBP.getMedTechApp(benId, status);
	}

	/**
	 * 查询站点的申请单
	 * 
	 * @param quesiteId 站点
	 * @param status 检查状态，取值参考：MedTechTriageStatus
	 * @return
	 */
	@Override
	public MedTechAppDTO[] getMedTechAppBySiteAndSts(String quesiteId, int status)
			throws BizException {
		MedTechTriageBP mtTriageBP = new MedTechTriageBP();
		return mtTriageBP.getMedTechAppBySite(quesiteId, status);
	}

	/**
	 * 根据申请单号查询申请单
	 * 
	 * @param no 申请单号
	 * @param benId 分诊台id
	 * @return
	 */
	@Override
	public MedTechAppDTO getMedTeckAppByNo(String no, String benId) throws BizException {
		MedTechTriageBP mtTriageBP = new MedTechTriageBP();
		return mtTriageBP.getMedTeckAppByNo(no, benId);
	}

	/**
	 * 获取患者的医技申请单
	 * 
	 * @param patId 患者id
	 * @param benId 分诊台id
	 */
	@Override
	public MedTechAppDTO[] getMedTechAppByPat(String patId, String benId) throws BizException {
		MedTechTriageBP mtTriageBP = new MedTechTriageBP();
		return mtTriageBP.getMedTechAppByPat(patId, benId);
	}

	/**
	 * 根据就诊id查询申请单
	 * 
	 * @param entCode 就诊编号
	 * @param benId 工作台id
	 * @return
	 */
	@Override
	public MedTechAppDTO[] getMedTechAppByEntCode(String entCode, String benId) throws BizException {
		MedTechTriageBP mtTriageBP = new MedTechTriageBP();
		return mtTriageBP.getMedTechAppByEntCode(entCode, benId);
	}

	/**
	 * 获取分诊台的工作站点
	 * 
	 * @param benId 分诊台id
	 * @param depId 科室id
	 * @param status 状态，参照枚举：QueSiteStatus OffLine = 0,Online = 1,Left = 2,All =
	 *            3,
	 * @return 相应的DTO
	 */
	@Override
	public TriageQueSiteDTO[] getQueSite(String benId, String depId, int status, boolean isFilter,
			String id_or) throws BizException {
		MedTechTriageBP mtTriageBP = new MedTechTriageBP();
		return mtTriageBP.getQueSite(benId, depId, status, isFilter, id_or);
	}

	/**
	 * 获取就诊信息
	 * 
	 * @param entId 就诊ID
	 * @param entp 就诊类型
	 * @return
	 * @throws BizException
	 */
	@Override
	public EntForMTDTO getEnt(String entId, String entp) throws BizException {
		MedTechTriageBP mtTriageBP = new MedTechTriageBP();
		return mtTriageBP.getEnt(entId, entp);
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////
	///////////////                通用分诊查询服务                          ////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 根据分诊台，状态，午别查询患者列表
	 * 
	 * @param benId
	 *            工作台id
	 * @param acptStatus
	 *            状态
	 * @param dateslot
	 *            午别
	 * @return
	 */
	@Override
	public MedTechAppDTO[] getAllChapp(String benId, String acptStatus, String dateslot,String queID) throws BizException {
		GetAllChappPatinfoBP bp = new GetAllChappPatinfoBP();
		return bp.exec(benId, acptStatus, dateslot, queID,null);
	}
	
	/**
	 * 获取通用分诊台的工作站点
	 * 
	 * @param benId
	 *            分诊台id
	 * @param status
	 *            状态，参照枚举：QueSiteStatus
	 * @return 相应的DTO
	 */
	@Override
	public TriageQueSiteDTO[] getAllQueSite(String benId, String id_or, String dayslotsec)
			throws BizException {
		AllTriageBP bp = new AllTriageBP();
		return bp.getAllQueSite(benId, id_or, dayslotsec);
	}

	/**
	 * 通过患者id获取当前午别下的队列信息
	 * 
	 * @param id_pat
	 *            患者编码
	 * @param dateslottp
	 *            午别
	 * @param benid
	 *            分诊台id
	 * @return 患者就诊_队列
	 * @throws BizException
	 */
	@Override
	public MedTechAppDTO getQueDOByPat(String id_pat, String benid) throws BizException {
		AllTriageBP bp = new AllTriageBP();
		return bp.getQueDOByPat(id_pat,benid);
	}

	/**
	 * 通用队列管理患者列表
	 * @param benId 分诊台id
	 * @param dateslot 午别
	 * @return
	 * @throws BizException
	 */
	@Override
	public MedTechAppDTO[] getAllQueuePat(String id_quesite, String dateslot,String[] chbState,String id_ben) throws BizException {
		AllTriageBP bp = new AllTriageBP();
		return bp.getAllQueuePat(id_quesite,dateslot,chbState,id_ben);
	}
	
	/**
	 * 获取分诊台信息，包括分诊台名称，当前时间分组，当前分诊台所管理的科室
	 * 
	 * @param benId 分诊台ID
	 * @param code_entp 就诊类型
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public TriageBenInfoDTO getTriageBenInfo(String benId) throws BizException {
		GetTyTriageBenInfoBP bp = new GetTyTriageBenInfoBP();
		return bp.exec(benId);
	}
	/***
	 * @Description:获取通用分诊站点列表数据
	 * @param benId
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	@Override
	public TriageQueSiteDTO[] getTriageQueSite(String benId,String dayslotId)throws BizException{
		return new GetTriageQueSiteBP().exec(benId,dayslotId);
	}
	/***
	 * @Description:根据status获取待分诊的患者列表
	 * @param triageInfo
	 * @param dayslotId
	 * @param status
	 * @return
	 * @throws BizException
	 */
	@Override
	public TriagePatInfoDTO[] getTriageQueByBen(TriageBenInfoDTO triageInfo, String dayslotId, int status) throws BizException{
		return new GetTriageQueByBenBP().exec(triageInfo, dayslotId, status);
	}
	/**
	 * 通用队列管理(新)，获取列表患者信息
	 */
	@Override
	public TriagePatInfoDTO[] getAllQueuePatNew(TriagePatQryDTO triagePat) throws BizException {
		return new GetAllQueuePatNewBP().exec(triagePat);
	}
	
	/***
	 * @Description:根据站点id和午别id获取通用队列患者信息
	 * @param id_quesite
	 * @param id_dayslot
	 * @return
	 * @throws BizException
	 */
	@Override
	public TriagePatInfoDTO[] getPatInfoByQueSiteId(String id_quesite,String id_que,String id_dayslot) throws BizException{
		return new GetPatInfoByQueSiteIdBP().exec(id_quesite,id_que,null,id_dayslot);
	}
}
