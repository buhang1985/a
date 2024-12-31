package iih.en.que.i;

import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.pv.dto.d.OpRegDTO;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.que.dto.d.EnEmpQueInfoDTO;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriageEntDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 就诊队列查询服务
 * @author yank
 * @author liubin
 *
 */
public interface IEnQueQryService {
	
	/*===============================分诊管理==================================*/
	
	/**
	 * 获取分诊台信息，包括分诊台名称，当前时间分组，当前分诊台所管理的科室
	 * 
	 * @param benId 分诊台ID
	 * @param code_entp 就诊类型
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	TriageBenInfoDTO getTriageBenInfo(String benId, String code_entp) throws BizException;
	
	
	/**
	 * 
	 * 根据status状态获取待分诊的患者列表
	 * 
	 * @param triageInfo	
	 * 		分诊台信息
	 * @param dayslotId
	 * 		时间分诊ID
	 * @param status
	 * 		状态  参照枚举：EntQueStatus
	 * <ul>
	 * <li>[-1] 未到诊状态患者</li>
	 * <li>[0] 到诊状态患者</li>
	 * <li>[1] 分诊状态患者</li>
	 * <li>[2] 通知状态患者</li>
	 * <li>[3] 就诊状态患者</li>
	 * <li>[4] 全部状态患者（不包括未到诊患者）</li>
	 * <li>[5] 回诊状态患者</li>
	 * </ul>
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	TriageEntDTO[] getWaitingByBen(TriageBenInfoDTO triageInfo,String dayslotId,int status) throws BizException ;	
	
	/**
	 * 根据status状态获取分诊台队列或站点的分诊详情
	 * 
	 * @param triageInfo
	 * 		分诊台信息
	 * @param queIds
	 * 		门诊队列ID集合
	 * @param queSiteId
	 * 		医生工作站ID（可以为空）
	 * @param status
	 * 		状态
	 * <ul>
	 * <li>[0] 未分诊状态患者</li>
	 * <li>[1] 候诊状态患者</li>
	 * <li>[3] 就诊状态患者</li>
	 * </ul>
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	TriageEntDTO[] getTriagedWait(TriageBenInfoDTO triageInfo, String[] queIds, String queSiteId,int status) throws BizException ;
	/**
	 * 获取TriageEntDTO
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	TriageEntDTO getTriageEnt(String entId)throws BizException;	
	/**
	 * 得到分诊台的队列和站点信息信息，包括
	 * 队列或站点的分诊数和候诊数
	 * 
	 * @param dayslotId 
	 * 		时间分组ID
	 * @param benId 
	 * 		分诊台ID
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Deprecated
	TriageQueSiteDTO[] getOpTriQueSite(String dayslotId,String benId) throws BizException;
	/**
	 * 得到分诊台的队列和站点信息信息，
	 * 包括队列或站点的分诊数和候诊数
	 * 
	 * @param triageInfo
	 * @param status
	 * @return
	 * @throws BizException
	 */
	FMap getTriageSite(TriageBenInfoDTO triageInfo, int status) throws BizException;
	/**
	 * 获取就诊队列状态
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	Integer getEnQueStatus(String entId) throws BizException;
	
	/**
  	 * 得到科室分诊台在线站点信息
  	 * 
  	 * @param dayslotId 时间分组ID
  	 * @param benId 分诊台ID
  	 * @param depId 科室id
  	 * 
  	 * @return
  	 * @throws BizException
  	 * @author liubin
  	 */
  	TriageQueSiteDTO[] getTriageQueSiteInfos(String dayslotId, String benId, String depId) throws BizException ;
	/*===============================门急诊医生接诊==================================*/
	/***
	 * 获取当前叫号患者信息
	 * @author fanlq 
	 * @param que
	 * @param queSiteDO
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	ReceptionQueDTO getCallPatInfo(QueDO que, QueSiteDO queSite, FDate date, String dayslotId) throws BizException;
	/**
	 * 根据计算机的HostId，获取工作站点
	 * 
	 * @param hostId 
	 * 		计算机注册时唯一标识符
	 * @return 
	 * 		工作站点DO
	 * @throws BizException
	 * @author liubin
	 */
	QueSiteDO getQueSiteByPc(String hostId) throws BizException;	
	/**
	 * 找到医生出诊队列
	 * 
	 * @param siteInfo 站点信息
	 * @return 
	 * 		出诊队列DO
	 * @throws BizException
	 * @author liubin
	 */
	QueDO[] getQue(EnTrDocSiteInfoDTO siteInfo) throws BizException;
	/**
	 * 是否可刷卡接诊该患者
	 * @param entId 
	 * 		就诊ID
	 * @param site 
	 * 		当前出诊站点
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	ResultDTO checkAcptByCard(String entId, QueSiteDO site, EnTrDocSiteInfoDTO siteInfo) throws BizException;
	/**
	 * 是否可以跨科接诊
	 * 
	 * @param regDepId 挂号科室
	 * @param acptDepId 接诊科室
	 * @return
	 * @throws BizException
	 */
	ResultDTO checkCrossDeptAcpt(String regDepId, String acptDepId) throws BizException;
	/**
	 * 获取门诊医生站队列情况
	 * 
	 * @param siteInfo 站点信息
	 * @return key: 挂号REG,已诊ACPT,未诊WAIT；value为相应的数量
	 * @throws BizException
	 */
	FMap getSiteEntStats(EnTrDocSiteInfoDTO siteInfo) throws BizException;
	/**
	 * 门急诊医生站获取历史就诊列表
	 * 
	 * @param pg 分页信息
	 * @param nodeDTO 查询条件
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<ReceptionQueDTO> getEntListByOper(QryRootNodeDTO qryNode, PaginationInfo pg) throws BizException;
	/**
	 * 获取未挂号分诊队列站点信息
	 * 
	 * @param benInfo
	 * @return
	 * @throws BizException
	 */
	TriageQueSiteDTO[] getNoRegTriageQueSite(TriageBenInfoDTO benInfo) throws BizException;
	
	/**
	 * 接诊的时候判定价格
	 * @param patId
	 * @param regRes
	 * @return
	 * @throws BizException
	 */
	RegResDTO getPriceForReg(OpRegPatDTO opRegPat, RegResDTO regRes,String endId)throws BizException;
    
    /**
     * 接诊时判断是否可以顺序接诊（刷卡模式）
     * 
     * @param entId
     * @param que
     * @param queSiteDO
     * @param siteInfo
     * @return
     * @throws BizException
     */
    ResultDTO checkPvOrderAcptFg(OpRegDTO opReg, QueDO que, QueSiteDO queSiteDO, EnTrDocSiteInfoDTO siteInfo) throws BizException;

    /**
     * 接诊时判断是否可以顺序接诊(列表模式)
     * 
     * @param entId
     * @param benId
     * @param type
     * @return
     * @throws BizException
     */
    ResultDTO checkListPvOrderAcptFg(String entId, String benId, String type) throws BizException;
	
	/**********************************分诊台管理队列************************************/
	
	/**
     * 获取科室队列信息(队列管理)
     * 
     * @param depId
     * @param quebenId
     * @param date
     * @return
     */
    EnEmpQueInfoDTO[] getQueInfos(String depId, String quebenId, FDate date) throws BizException;
	/**
	 * 得到分诊台的队列和站点信息信息，(队列管理)
	 * 包括队列或站点的分诊数和候诊数
	 * 
	 * @param triageInfo
	 * @param status
	 * @return
	 * @throws BizException
	 */
	FMap getTriageSite4BenMgr(TriageBenInfoDTO triageInfo, int status) throws BizException;
	/**
	 * 找到医生出诊队列(队列管理)
	 * 
	 * @param siteInfo 
	 * 		站点信息
	 * @return 
	 * 		出诊队列DO
	 * @throws BizException
	 * @author liubin
	 */
	QueDO[] getQue4QueMgr(EnTrDocSiteInfoDTO siteInfo) throws BizException;
	/**
	 * 获取医生站患者列表
	 * 
	 * @param ques
	 * @param queSiteDO
	 * @param siteInfo
	 * @param type 列表类型
	 * @return
	 * @throws BizException
	 */
	ReceptionQueDTO[] getDocAcptList(QueDO que, QueSiteDO queSiteDO, EnTrDocSiteInfoDTO siteInfo, String type) throws BizException;
	
	/**********************************分诊台管理队列************************************/
	/**
	 * 根据id_ent获取ReceptionQueDTO
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	ReceptionQueDTO getReceptionQueByEntId(String entId)  throws BizException;
}
