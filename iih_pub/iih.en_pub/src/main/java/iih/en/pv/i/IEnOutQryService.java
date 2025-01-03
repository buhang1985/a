package iih.en.pv.i;

import iih.en.pv.dto.d.DeptPsndocDTO;
import iih.en.pv.dto.d.EnDiQrySchmDTO;
import iih.en.pv.dto.d.EnEmrDTO;
import iih.en.pv.dto.d.EnHisQryCondDTO;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.en.pv.dto.d.EntHisDiDTO;
import iih.en.pv.dto.d.GuidePsnInfo;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.dto.d.IpDetailDTO;
import iih.en.pv.dto.d.MedPsnDTO;
import iih.en.pv.dto.d.OpBasicDTO;
import iih.en.pv.dto.d.OpReg4EsDTO;
import iih.en.pv.dto.d.OpTotalInfoDTO;
import iih.en.pv.dto.d.Reg4IpDTO;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.hpdto.d.IpHpRegistDTO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.EntForMedRecDTO;
import iih.en.pv.inpatient.dto.d.IpTotalInfoDTO;
import iih.en.pv.outpatient.dto.d.OpPatAptDTO;
import iih.en.pv.outpatient.dto.d.OpWaitQueDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.outpatient.dto.d.RegRuleDTO;
import iih.en.pv.outpatient.dto.d.SchInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriageEntDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 就诊对外查询服务
 * 
 * @author yank
 *
 */
public interface IEnOutQryService {
	/**
	 * 获取banner信息
	 * 
	 * @param sqlStr
	 *            查询语句
	 * @param whereStr
	 *            查询条件
	 * @param svName
	 *            服务名称，多个逗号隔开
	 * @return
	 * @throws BizException
	 */
	Ent4BannerDTO[] getEntInfo4Banner(String sqlStr, String whereStr,
			String svName) throws BizException;
	
	/**
	 * 获取banner信息
	 * (多了入参：输入的搜索值)
	 * @param sqlStr 查询语句
	 * @param whereStr 查询条件
	 * @param svName 服务名称，多个逗号隔开
	 * @return
	 * @throws BizException
	 */
	Ent4BannerDTO[] getEntInfo4Banner3(String sqlStr, String whereStr,
			String svName, String inputValue) throws BizException;
	/**
	 * 获取banner信息(参数绑定)
	 * 
	 * @param sqlStr
	 *            查询语句
	 * @param whereStr
	 *            查询条件
	 * @param svName
	 *            服务名称，多个逗号隔开
	 * @return
	 * @throws BizException
	 */
	Ent4BannerDTO[] getEntInfo4Banner2(String sqlStr, String whereStr,
			String svName, SqlParamDTO sqlParamDto) throws BizException;
	/**
	 * 获取就诊账户
	 * 
	 * @param entId
	 *            就诊id
	 * @return
	 */
	EnAccountDO getEnAcc(String entId) throws BizException;

	/**
	 * 获取就诊账户信息 信用额度=患者信用分类的信用额度+就诊账户的信用额度
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	BalanceDTO getBalanceDTO(String entId) throws BizException;

	/**
	 * 获取团检账户金额
	 * 
	 * @param peCmpyId
	 *            团检记录id
	 * @return 账户金额信息
	 * @throws BizException
	 * @author ly 2018/06/04
	 */
	BalanceDTO getPeCmpyBalance(String peCmpyId) throws BizException;

	/**
	 * 获取就诊账户信息(批处理) 信用额度=患者信用分类的信用额度+就诊账户的信用额度
	 * 
	 * @param entIds
	 * @return 就诊账户数组
	 * @throws BizException
	 */
	BalanceDTO[] getBalanceDTOs(String[] entIds) throws BizException;

	/**
	 * 获取就诊账户信息(批处理) 信用额度=患者信用分类的信用额度+就诊账户的信用额度 含婴儿处理，婴儿使用母亲账户
	 * 
	 * @author ly 2017/09/21
	 * @param entIds
	 * @return 就诊账户数组
	 * @throws BizException
	 */
	BalanceDTO[] getBalanceDTOsContainBaby(String[] entIds) throws BizException;

	/**
	 * 获取人员信息
	 * 
	 * @param entId
	 *            就诊id
	 * @param empRole
	 *            人员角色
	 * @return
	 * @throws BizException
	 */
	EnPsnDO getEnPsn(String entId, String empRole) throws BizException;

	/**
	 * 加载资源价格信息--为预约
	 * 
	 * @param entId
	 *            就诊id
	 * @param resDTO
	 *            挂号资源
	 * @return
	 * @throws BizException
	 */
	RegResDTO loadResPri4Apt(String entId, RegResDTO resDTO)
			throws BizException;

	/**
	 * 获取患者价格分类
	 * 
	 * @param entId
	 *            就诊id
	 * @return
	 * @throws BizException
	 */
	String getPriPatId(String entId) throws BizException;

	/**
	 * 获取住院未结算的价格分类集合
	 * 
	 * @return 价格分类ID集合
	 * @throws BizException
	 */
	List<String> getIpUnstlPriPatList() throws BizException;

	/**
	 * 获取患者的历史就诊诊断记录
	 * 
	 * @param patId
	 *            患者id
	 * @return
	 * @throws BizException
	 */
	EntHisDiDTO[] getEntHisDiDTO(String patId) throws BizException;

	/**
	 * 获取患者的历史就诊诊断记录
	 * 
	 * @param patCode
	 *            患者编码
	 * @param onlyDiagEnd
	 *            只包含诊毕标志
	 * @param withDetail
	 *            是否包含明细
	 * @param exclEntIds
	 *            排除的就诊ID，可为空
	 * @return
	 * @throws BizException
	 */
	EntHisDiDTO[] getHisEntDiList(String patCode, FBoolean onlyDiagEnd,
			FBoolean withDetail, String[] exclEntIds) throws BizException;

	/**
	 * 获取患者的历史就诊诊断记录
	 * 
	 * @param patCode
	 *            患者编码
	 * @param qrySchms
	 *            查询DTO数组
	 * @return
	 * @throws BizException
	 */
	EntHisDiDTO[] getEntHisDiBySchm(String patCode, EnDiQrySchmDTO[] qrySchms)
			throws BizException;

	/**
	 * 获取历史就诊数据
	 * 
	 * @param cond
	 *            查询条件
	 * @param exclEntIds
	 *            排除的就诊ID，可为空
	 * @return
	 * @throws BizException
	 */
	EntHisDiDTO[] getHistEntListByCond(EnHisQryCondDTO cond, String[] exclEntIds)
			throws BizException;

	/**
	 * 获取就诊信息
	 * 
	 * @param entId
	 *            就诊id
	 * @return
	 * @throws BizException
	 */
	PatiVisitDO getEnInfo(String entId) throws BizException;

	/**
	 * 获取就诊信息
	 * 
	 * @param entId
	 *            就诊id集合
	 * @return
	 * @throws BizException
	 */
	PatiVisitDO[] getEnInfoList(String[] entIds) throws BizException;

	/**
	 * 获取门诊基本信息
	 * 
	 * @param entId
	 *            就诊ID
	 * @return 门诊基本信息DTO
	 * @throws BizException
	 */
	OpBasicDTO getOpBasicInfo(String entId) throws BizException;

	/**
	 * 获取门诊基本信息
	 * 
	 * @param code_ent
	 *            就诊编码
	 * @return 门诊基本信息DTO
	 * @throws BizException
	 */
	OpBasicDTO getOpBasicInfoByEntCode(String code_ent) throws BizException;

	/**
	 * 获取住院基本信息
	 * 
	 * @param entId
	 *            就诊id
	 * @return
	 * @throws BizException
	 */
	IpBasicDTO getIpBasicInfo(String entId) throws BizException;

	/**
	 * 获取住院基本信息 根据团检id查询 团检关联患者
	 * 
	 * @param idpecmpy
	 *            团检单位id
	 * @return
	 * @throws BizException
	 */
	IpBasicDTO[] getIpBasicInfos(String idpecmpy) throws BizException;

	/**
	 * 获取住院详细信息
	 * 
	 * @param entId
	 *            就诊ID
	 * @return
	 * @throws BizException
	 */
	IpDetailDTO getIpDetailInfo(String entId) throws BizException;

	/**
	 * 获取就诊信息
	 * 
	 * @param entId
	 *            就诊id
	 * @return
	 * @throws BizException
	 */
	EntForMedRecDTO getEntInfo4firstPage(String entId) throws BizException;

	/**
	 * 根据就诊id查找医护人员
	 * 
	 * @param entId
	 *            就诊id
	 * @return
	 * @throws BizException
	 */
	MedPsnDTO getMedPsn4Mr(String entId) throws BizException;

	/**
	 * 获取病历就诊信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	EnEmrDTO getEntInfo4Mr(String entId) throws BizException;

	/**
	 * 获取病人就诊信息
	 * 
	 * @param id_pat
	 * @param code_entp
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	EnEmrDTO[] getEntInfoList4Mr(String patId, String codeEntp, String entId)
			throws BizException;

	/**
	 * 获取就诊患者所属类别
	 * 
	 * @param entId
	 *            就诊id
	 * @param depId
	 *            科室id
	 * @param empId
	 *            医生id
	 * @return 返回枚举值EntPatListTp
	 * @throws BizException
	 */
	String getEntPatTp(String entId, String depId, String empId)
			throws BizException;

	/**
	 * 根据业务线，查询病区的科室集合 业务线暂时没有，临时放在这里，后续迁移
	 * 
	 * @param depId
	 *            科室或病区id
	 * @return
	 * @throws BizException
	 */
	DeptDO[] getDepListByDepl(String depId, String deplrole)
			throws BizException;

	/**
	 * 获取诊毕患者列表
	 * 
	 * @param pageInfo
	 *            分页信息
	 * @param deptId
	 *            科室ID
	 * @param beginDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<OpBasicDTO> getOpDignosed(PaginationInfo pageInfo,
			String deptId, FDate beginDate, FDate endDate) throws BizException;

	/**
	 * 获取集成平台挂号DTO
	 * 
	 * @param reg4EsDTO
	 * @return
	 * @throws BizException
	 */
	Reg4IpDTO getReg4Ip(OpReg4EsDTO reg4EsDTO) throws BizException;

	/**
	 * 挂号规则验证，是否可以挂号
	 * 
	 * @author liubin
	 * 
	 * @param regRuleDto
	 * @return
	 * @throws BizException
	 */
	ResultDTO isPermitRegByMvel(RegRuleDTO regRuleDto) throws BizException;

	/**
	 * 获取就诊状态
	 * 
	 * @param entId
	 *            就诊ID
	 * @return
	 * @throws BizException
	 * @author yank
	 */
	String getEnStatus(String entId) throws BizException;

	/**
	 * 判定就诊是否已经结算
	 * 
	 * @param entId
	 *            就诊ID
	 * @return
	 * @throws BizException
	 * @author yank
	 */
	FBoolean hasSettled(String entId) throws BizException;

	/**
	 * 判定就诊是否已经结算(批量)
	 * 
	 * @param entIds
	 *            就诊ID数组
	 * @return 判断结果map
	 * @throws BizException
	 * @author ly 2018/02/25
	 */
	FMap hasSettledMulti(String[] entIds) throws BizException;

	/**
	 * 是否绿色通道VIP
	 * 
	 * @param entId
	 *            就诊ID
	 * @return true或 false
	 * @throws BizException
	 * @author zcm
	 */
	FBoolean isGcVip(String entId) throws BizException;

	/**
	 * 批量判定是否绿色通道VIP
	 * 
	 * @param entIds
	 *            就诊ID集合
	 * @return map，key:就诊ID, value: true或 false
	 * @throws BizException
	 * @author zcm
	 */
	FMap batchChkIsGcVip(String[] entIds) throws BizException;

	/**
	 * 获取就诊的VIP类型
	 * 
	 * @param entId
	 *            就诊ID
	 * @return String 0-非gcVip，1-价格分类VIP； 2-号别VIP； 3-价格与号别同时为VIP ；4 -患者标签VIP
	 * @throws BizException
	 * @author zcm
	 */
	String getGcVipTp(String entId) throws BizException;

	/**
	 * 批量获取就诊的VIP类型
	 * 
	 * @param entIds
	 *            就诊ID集合
	 * @return map: key(就诊ID)，value(字符串类型，0-非gcVip，1-价格分类VIP； 2-号别VIP；
	 *         3-价格与号别同时为VIP ；4-患者标签VIP)
	 * @throws BizException
	 * @author zcm
	 */
	FMap batchGetGcVipTp(String[] entIds) throws BizException;

	/**
	 * 判断就诊是否为高端商保
	 * 
	 * @param entId
	 *            就诊ID
	 * @return FBoolean
	 * @throws BizException
	 * @author yankan
	 */
	FBoolean isHpcg(String entId) throws BizException;

	/**
	 * 判断医保是否为高端商保
	 * 
	 * @param hpId
	 *            医保计划ID
	 * @return FBoolean
	 * @throws BizException
	 * @author yankan
	 */
	FBoolean isHpCmCl(String hpId) throws BizException;

	/**
	 * 获取新生儿信息
	 * 
	 * @param entId
	 *            就诊id
	 * @return
	 * @throws BizException
	 */
	NewbornDO getNewbornDO(String entId) throws BizException;

	/**
	 * 获取患者住院登记医保信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	IpHpRegistDTO getIpHpRegist(String entId) throws BizException;

	/**
	 * 通过母亲就诊id获取婴儿信息
	 * 
	 * @param entId
	 *            就诊id
	 * @return
	 * @throws BizException
	 */
	NewbornDO[] getNewbornsByMomEntId(String entId) throws BizException;

	/**
	 * 通过科室id或病区id获取就诊账户
	 * 
	 * @param depId
	 *            科室id或病区id
	 * @return
	 * @throws BizException
	 */
	EnAccountDO[] getEnIpAccsByDepId(String depId) throws BizException;

	/**
	 * 获取门诊工作量
	 * 
	 * @param depId
	 *            科室id
	 * @param beginDate
	 *            开始时间
	 * @param enDate
	 *            结束时间
	 * @return
	 * @throws BizException
	 * @author jizb
	 */
	OpTotalInfoDTO[] getOpTotalInfo(String depId, FDate beginDate, FDate endDate)
			throws BizException;

	/**
	 * 获取住院工作量
	 * 
	 * @param depId
	 *            科室id
	 * @param beginDate
	 *            开始时间
	 * @param enDate
	 *            结束时间
	 * @return
	 * @throws BizException
	 */
	IpTotalInfoDTO[] getIpTotalInfo(String sdDepTp, String depId,
			FDate beginDate, FDate endDate) throws BizException;

	/**
	 * 根据就诊编码获取挂号信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public RegInfoDTO getRegInfoByEntId(String entId) throws BizException;

	/**
	 * 检查就诊是否持卡社保
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 09:22:37
	 *
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public FBoolean isHpCardst(String id_ent) throws BizException;

	/**
	 * 获取默认的患者医保分类
	 * 
	 * @return
	 */
	/**
	 * 获取默认的患者医保分类
	 * 
	 * @return
	 */
	String getDefaultHpCard();

	/**
	 * 根据就诊id判断此次就诊是否是持卡
	 * 
	 * @author fanlq
	 * @param entId
	 *            就诊id
	 * @return
	 * @throws BizException
	 */
	public FBoolean isHpCardEnt(String entId) throws BizException;

	/**
	 * 获取住院患者转出科室时间
	 * 
	 * @param id_ent
	 *            就诊id
	 * @param id_dep
	 *            科室id
	 * @return
	 * @throws BizException
	 */
	FDateTime getIPTransOutDate(String id_ent, String id_dep)
			throws BizException;

	/**
	 * 获取补号类型
	 * 
	 * @param entId
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	public String getSupplyTicketType(String entId, String aptId)
			throws BizException;

	/**
	 * 为ci提供判定是否是特需(国际专用)
	 * 
	 * @param entId
	 *            就诊id
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	public FBoolean GetSrvtpforCI(String entId) throws BizException;

	/**
	 * 获取医保患者参合地编码
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public String getHpPatChareaCode(String entId) throws BizException;

	/**
	 * 
	 * @param deptCode
	 * @param resName
	 * @param beginDate
	 * @param endDate
	 * @param srvType
	 * @param chlType
	 * @return
	 * @throws BizException
	 */
	SchInfoDTO[] getSchList(String deptCode, String resName, String beginDate,
			String endDate, String srvType, String chlType) throws BizException;

	/**
	 * 获取患者挂号记录
	 * 
	 * @param patCode
	 *            患者编码
	 * @param beginDate
	 *            开始日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param endDate
	 *            结束日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @return
	 * @throws BizException
	 */
	OpPatAptDTO[] getPatOpAptList(String patCode, String beginDate,
			String endDate) throws BizException;

	/**
	 * 获取候诊队列
	 * 
	 * @param patCode
	 *            患者编码
	 * @param opTimes
	 *            就诊次数
	 * @param deptCode
	 *            科室编码
	 * @return
	 * @throws BizException
	 */
	OpWaitQueDTO[] getWaitQue(String patCode, Integer opTimes, String deptCode)
			throws BizException;

	/**
	 * 获取分诊台信息，包括分诊台名称，当前时间分组，当前分诊台所管理的科室
	 * 
	 * @param benId
	 *            分诊台ID
	 * @param code_entp
	 *            就诊类型
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	TriageBenInfoDTO getTriageBenInfo(String benId, String code_entp)
			throws BizException;

	/**
	 * 得到分诊台的队列和站点信息信息，包括 队列或站点的分诊数和候诊数
	 * 
	 * @param date
	 *            日期
	 * @param dayslotId
	 *            时间分组ID
	 * @param benId
	 *            分诊台ID
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	TriageQueSiteDTO[] getOpTriQueSite(String dayslotId, String benId)
			throws BizException;

	/**
	 * 
	 * 根据status状态获取待分诊的患者列表
	 * 
	 * @param benId
	 *            分诊台ID
	 * @param dayslotId
	 *            时间分诊ID
	 * @param status
	 *            状态 参照枚举：EntQueStatus
	 *            <ul>
	 *            <li>[-1] 未到诊状态患者</li>
	 *            <li>[0] 到诊状态患者</li>
	 *            <li>[1] 分诊状态患者</li>
	 *            <li>[2] 通知状态患者</li>
	 *            <li>[3] 就诊状态患者</li>
	 *            <li>[4] 全部状态患者（不包括未到诊患者）</li>
	 *            <li>[5] 回诊状态患者</li>
	 *            </ul>
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	TriageEntDTO[] getWaitingByBen(String benId, String dayslotId, int status)
			throws BizException;

	/**
	 * 得到分诊台的队列和站点信息信息， 包括队列或站点的分诊数和候诊数
	 * 
	 * @param benId
	 *            分诊台ID
	 * @param date
	 *            日期
	 * @param dayslotId
	 *            日期分组Id
	 * @param depId
	 *            科室ID
	 * @param status
	 * @return
	 * @throws BizException
	 */
	FMap getTriageSite(String benId, String dayslotId, String depId, int status)
			throws BizException;

	/**
	 * 得到科室分诊台在线站点信息
	 * 
	 * @param dayslotId
	 *            时间分组ID
	 * @param benId
	 *            分诊台ID
	 * @param depId
	 *            科室id
	 * 
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	TriageQueSiteDTO[] getTriageQueSiteInfos(String dayslotId, String benId,
			String depId) throws BizException;

	/**
	 * 查询窗口队列
	 * 
	 * @param queSiteId
	 *            窗口id
	 * @param statusList
	 *            查询的状态列表，21-配药 22-叫号 23-叫号未到 24-发药
	 * @param qryDate
	 *            查询日期
	 * @return 就诊队列集合
	 * @throws BizException
	 */
	EnQueueDO[] getEntQueList(String queSiteId, FArrayList statusList,
			FDate qryDate) throws BizException;

	/**
	 * 获取就诊状态
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	String getOpSdStatus(String entId) throws BizException;

	/**
	 * 获取门诊基本信息
	 * 
	 * @param patCode
	 *            就诊患者编码
	 * @return 门诊基本信息DTO
	 * @throws BizException
	 */
	OpBasicDTO[] getOpBasicInfoByPatId(String patCode, String beginDate,
			String endDate) throws BizException;
	
	/***
	 * 患者导医系统--获取就诊科室、人员信息
	 * @return
	 * @throws BizException
	 */
	DeptPsndocDTO[] getHosGuideDeptBase(String pyCode) throws BizException;
	/***
	 * 患者导医系统--获取人员信息
	 * @return
	 * @throws BizException
	 */
	GuidePsnInfo[] getGuidePsnBase(String id_dep) throws BizException;
}
