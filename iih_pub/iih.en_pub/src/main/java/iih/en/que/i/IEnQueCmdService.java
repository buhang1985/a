package iih.en.que.i;

import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.pv.dto.d.OpRegDTO;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.PayPmItemDTO;
import iih.en.pv.outpatient.dto.d.RegRuleDTO;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriageEntDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 就诊队列命令服务
 * 
 * @author yank
 * @author liubin
 *
 */
public interface IEnQueCmdService {

	/**
	 * 分诊到诊
	 * 
	 * @param opReg 患者挂号信息
	 * @param triageInfo 分诊台信息
	 * @throws BizException
	 * @author liubin
	 */
	void arrive(OpRegDTO opReg, TriageBenInfoDTO triageInfo) throws BizException;

	/**
	 * 撤销到诊
	 * 
	 * @param entQueId 就诊队列id
	 * @throws BizException
	 * @author liubin
	 */
	void cancelSignIn(String entQueId) throws BizException;

	/**
	 * 分诊到站点
	 * 
	 * @param triageQueSite 分诊台队列或工作站点DTO
	 * @param entQueId 就诊队列ID
	 * @param isForceTriage 是否是强制分诊
	 * @author liubin
	 */
	void triageToSite(TriageQueSiteDTO triageQueSite, String entQueId, FBoolean isForceTriage, TriageBenInfoDTO triageInfo) throws BizException;

	/**
	 * 自动分诊
	 * 
	 * @param triageInfo 分诊台
	 * @throws BizException
	 * @author liubin
	 */
	void autoTriage(TriageBenInfoDTO triageInfo) throws BizException;
	/**
	 * 取消分诊
	 * 
	 * @param entQueId 就诊队列ID
	 * @param manual 自动分诊下设为true
	 * @author liubin
	 */
	void cancelTriage(String entQueId, FBoolean manual) throws BizException;
	/**
	 * 叫号（只上屏，不改状态）
	 * 
	 * @param que 出诊队列
	 * @param queSite 出诊站点
	 * @param date 当前日期
	 * @param dayslotId 当前时间分组ID
	 * @return
	 * @throws BizException
	 * @author renying
	 */
	EnQueueDO callNumOnDisplay(QueDO que, QueSiteDO queSite, String entId,String enQueId) throws BizException;
	/**
	 * 站点叫号
	 * 
	 * @param siteInfo 站点信息
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	EnQueueDO callNum(EnTrDocSiteInfoDTO siteInfo, String entId, Integer callNum) throws BizException;

	/**
	 * 站点叫下一个
	 * 
	 * @param siteInfo 站点信息
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	EnQueueDO callNextNum(EnTrDocSiteInfoDTO siteInfo) throws BizException;

	/**
	 * 取消叫号
	 * 
	 * @param entQueId 患者就诊队列id
	 * @author liubin
	 */
	void cancelCallNum(String entQueId) throws BizException;

	/**
	 * 改变优先级
	 * 
	 * @param entDTO
	 * @throws BizException
	 * @author liubin
	 */
	void changeLevelPri(TriageEntDTO entDTO) throws BizException;

	/**
	 * 门诊医生登录站点初始化
	 * 
	 * @param siteInfo 医生工作站信息
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	QueSiteDO loginOpSite(EnTrDocSiteInfoDTO siteInfo) throws BizException;

	/**
	 * 把在线的医生站点设置为离线
	 * 
	 * @param queSiteId
	 * @return
	 * @throws BizException
	 */
	QueSiteDO siteOffLine(String queSiteId, String codeEnTp) throws BizException;

	/**
	 * 医生退出工作站时，修改工作点信息
	 * 
	 * @param queSiteId 医生工作站ID
	 * @throws BizException
	 * @author liubin
	 */
	void logoutOpSite(String queSiteId, String codeEnTp) throws BizException;

	/**
	 * 叫号
	 * 
	 * @param que 出诊队列
	 * @param queSite 出诊站点
	 * @param siteInfo 站点信息
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	EnQueueDO acptCallNum(QueDO que, QueSiteDO queSite, EnTrDocSiteInfoDTO siteInfo, String entId, Integer callNum) throws BizException;
	/**
	 * 选中患者叫号
	 * 
	 * @param rect 接诊DTO
	 * @param queSite 出诊站点
	 * @return
	 * @throws BizException
	 */
	EnQueueDO selEntToCallNum(ReceptionQueDTO rect, QueDO que, QueSiteDO queSite, EnTrDocSiteInfoDTO siteInfo) throws BizException;
	/**
	 * 叫下一个
	 * 
	 * @param que 出诊队列
	 * @param queSite 出诊站点
	 * @param dayslotId 当前时间分组ID
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	EnQueueDO acptCallNextNum(QueDO que, QueSiteDO queSite, EnTrDocSiteInfoDTO siteInfo) throws BizException;

	/**
	 * 过号
	 * 
	 * @param entQueId 就诊队列ID
	 * @throws BizException
	 * @author liubin
	 */
	void passNum(String entQueId) throws BizException;

	/**
	 * 接诊
	 * 
	 * @param entId 就诊ID
	 * @param queSite 出诊站点
	 * @param date 当前日期
	 * @param dayslotId 当前时间分组ID
	 * @param dayslotId 接诊原因
	 * @throws BizException
	 * @author liubin
	 */
	FBoolean receive(String entId, QueSiteDO queSite, String dayslotId, RegResDTO regRes,String reason) throws BizException;

	/**
	 * 挂号接诊
	 * 
	 * @param opRegPat 患者信息
	 * @param queSite 医生出诊站点
	 * @param regRes 挂号资源
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	ReceptionQueDTO regAndAcpt(OpRegPatDTO opRegPat, QueSiteDO queSite, RegResDTO regRes, String reason,PayPmItemDTO[] payPmItemDTOs) throws BizException;

	/**
	 * 取消接诊
	 * 
	 * @param empId 医生ID
	 * @param depId 科室ID
	 * @param entId 患者就诊ID
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	FBoolean cancRecpt(String empId, String depId, String entId) throws BizException;
	/**
	 * 设置患者为初诊或回诊
	 * 
	 * @param entId
	 * @param isFirst
	 * @throws BizException
	 */
	void setEntFirstOrRtn(String entId, FBoolean isFirst) throws BizException;
	/**
	 * 未挂号分诊
	 * 
	 * @param opRegPat
	 * @param queSiteInfo
	 * @return
	 * @throws BizException
	 */
	String noRegTriage(OpRegPatDTO opRegPat, TriageQueSiteDTO queSiteInfo) throws BizException;
	/**
	 * 未挂号分诊模式预约取号
	 * 
	 * @param patId
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	OpRegDTO noRegTriageTakeNo(String patId, String aptId) throws BizException;
	/**
	 * 批量上线
	 * 
	 * @param sites
	 * @param queId
	 * @return
	 * @throws BizException
	 */
	QueSiteDO[] batchLoginSite(QueSiteDO[] sites, String queId) throws BizException;
	/**
	 * 批量下线
	 * 
	 * @param sites
	 * @return
	 * @throws BizException
	 */
	QueSiteDO[] batchLogoutSite(QueSiteDO[] sites) throws BizException;
	/**
	 * 自动生成队列出诊医生
	 * 
	 * @param benId
	 * @param date
	 * @throws BizException
	 */
	void createQueEmps(String benId, FDate date) throws BizException;
	/**
	 * 取消队列分诊
	 * 
	 * @param benInfo
	 * @param queId
	 */
	void cancelQueTriage(TriageBenInfoDTO benInfo, String queId) throws BizException;
	/***
	 * @Description:挂号规则引擎
	 * @param opRegPat
	 * @param regInfo
	 * @return
	 * @throws BizException
	 */
    ResultDTO validateOpRegRule(String[] code_pkgs,RegRuleDTO regRule) throws BizException;
}
