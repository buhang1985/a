package iih.en.que.i;

import iih.en.que.dto.d.EntForMTDTO;
import iih.en.que.dto.d.MedTechAppDTO;
import iih.en.que.dto.d.TriagePatInfoDTO;
import iih.en.que.dto.d.TriagePatQryDTO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;

/**
 * 医技查询服务
 * 
 * @author yank,renying
 *
 */
public interface IMtQryService {
	/**
	 * 获取医技检查申请列表
	 * 
	 * @param benId 分诊台id
	 * @param acptStatus 检查状态
	 * @return
	 */
	MedTechAppDTO[] getMedTechApp(String benId, String[] acptStatus) throws BizException;

	/**
	 * 获取站点的医技检查申请列表
	 * 
	 * @param quesiteId 工作站点id
	 * @param acptStatus 检查状态
	 * @return
	 * @throws DAException
	 */
	MedTechAppDTO[] getMedTechAppBySite(String quesiteId, String[] acptStatus) throws BizException;

	/**
	 * 获取医技检查申请列表
	 * 
	 * @param benId 分诊台id
	 * @param status 检查状态，取值参考：MedTechTriageStatus
	 * @return
	 */
	MedTechAppDTO[] getMedTechAppAndSts(String benId, int status) throws BizException;

	/**
	 * 查询站点的申请单
	 * 
	 * @param quesiteId 站点
	 * @param status 检查状态，取值参考：MedTechTriageStatus
	 * @return
	 */
	MedTechAppDTO[] getMedTechAppBySiteAndSts(String quesiteId, int status) throws BizException;

	/**
	 * 根据申请单号查询申请单
	 * 
	 * @param no 申请单号
	 * @param benId 分诊台id
	 * @return
	 */
	MedTechAppDTO getMedTeckAppByNo(String no, String benId) throws BizException;

	/**
	 * 根据患者id查询申请单
	 * 
	 * @param patId 患者id
	 * @param benId 工作台id
	 * @return
	 */
	MedTechAppDTO[] getMedTechAppByPat(String patId, String benId) throws BizException;

	/**
	 * 根据就诊编号查询申请单
	 * 
	 * @param entCode 就诊编号
	 * @param benId 工作台id
	 * @return
	 */
	MedTechAppDTO[] getMedTechAppByEntCode(String entCode, String benId) throws BizException;

	/**
	 * 获取分诊台的工作站点
	 * 
	 * @param benId 分诊台id
	 * @param depId 科室id
	 * @param status 状态，参照枚举：QueSiteStatus
	 * @return 相应的DTO
	 */
	TriageQueSiteDTO[] getQueSite(String benId, String depId, int status, boolean isFilter,
			String id_or) throws BizException;

	/**
	 * 获取就诊信息
	 * 
	 * @param entId 就诊ID
	 * @param entp 就诊类型
	 * @return
	 * @throws BizException
	 */
	EntForMTDTO getEnt(String entId, String entp) throws BizException;
	
	//////////////////////////////////////////////////////////////////////////////////
	///////////////                通用分诊查询服务                          ////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * 通用分诊-- 根据分诊台，状态，午别查询患者列表
	 * 
	 * @param benId      工作台id
	 * @param acptStatus 状态
	 * @param dateslot   午别
	 * @return
	 */
	MedTechAppDTO[] getAllChapp(String benId,String acptStatus,String dateslot,String queID) throws BizException;
	
	/**
	 * 获取通用分诊台的工作站点
	 * 
	 * @param benId 分诊台id
	 * @param status 状态，参照枚举：QueSiteStatus
	 * @return 相应的DTO
	 */
	TriageQueSiteDTO[] getAllQueSite(String benId, String id_or,String dayslotsec) throws BizException;
	

	/**
	 * 通过患者id获取当前午别下的队列信息
	 * @param id_pat 患者编码
	 * @param dateslottp 午别
	 * @param benid 分诊台id
	 * @return  患者就诊_队列
	 * @throws BizException
	 */
	MedTechAppDTO getQueDOByPat(String id_pat,String benid) throws BizException;
	
	/**
	 * 通用队列管理患者列表
	 * @param benId 分诊台id
	 * @param dateslot 午别
	 * @return
	 * @throws BizException
	 */
	MedTechAppDTO[] getAllQueuePat(String benId,String dateslot,String[] chbState,String id_ben) throws BizException;
	/**
	 * 获取分诊台信息，包括分诊台名称，当前时间分组，当前分诊台所管理的科室
	 * 
	 * @param benId 分诊台ID
	 * @param code_entp 就诊类型
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	TriageBenInfoDTO getTriageBenInfo(String benId) throws BizException;
	/***
	 * @Description:获取通用分诊站点列表数据
	 * @param benId
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	TriageQueSiteDTO[] getTriageQueSite(String benId,String dayslotId)throws BizException;
	/***
	 * @Description:根据status获取待分诊的患者列表
	 * @param triageInfo
	 * @param dayslotId
	 * @param status
	 * @return
	 * @throws BizException
	 */
	TriagePatInfoDTO[] getTriageQueByBen(TriageBenInfoDTO triageInfo, String dayslotId, int status) throws BizException;

	/**
	 * 通用队列管理(新)，获取列表患者信息 zhangpp 2020.1.6
	 * @param triagePat
	 * @return
	 * @throws BizException
	 */
	TriagePatInfoDTO[] getAllQueuePatNew(TriagePatQryDTO triagePat) throws BizException;
	
	/***
	 * @Description:根据站点id和午别id获取通用队列患者信息
	 * @param id_quesite
	 * @param id_dayslot
	 * @return
	 * @throws BizException
	 */
	TriagePatInfoDTO[] getPatInfoByQueSiteId(String id_quesite,String id_que,String id_dayslot) throws BizException;
}
