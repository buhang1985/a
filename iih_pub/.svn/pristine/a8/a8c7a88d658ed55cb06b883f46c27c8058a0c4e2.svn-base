package iih.sc.sch.i;

import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.reg.dto.d.PeriodResDTO;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.ResQrySchemeDTO;
import iih.sc.sch.reg.dto.d.ResStatsDTO;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 排班对外查询服务
 * 
 * @author yank
 *
 */
public interface IScSchOutQryService {
	/***
	 * @Description:根据锁号id查询号位信息
	 * @param id_schlock
	 * @return
	 * @throws BizException
	 */
	ScSchTickDO getTickByLockId(String id_schlock) throws BizException;
	/**
	 * 获取最大可挂号日期
	 * 
	 * @param chlTp 渠道类型，参考：IScDictCodeConst
	 * @return
	 * @throws BizException
	 */
	FDate getMaxAvlRegDate(String chlTp) throws BizException;
	
	/**
	 * 获取可预约排班
	 * @param chlTp
	 * @param sctp
	 * @return
	 * @throws BizException
	 */
	FMap getetChlAptTimeIntervalDate(String chlTp) throws BizException;
	
	/**
	 * 是否已过停止挂号时间
	 * 
	 * @param schId 排班ID
	 * @return true/false
	 * @throws BizException
	 * @author yank
	 */
	FBoolean isAfterEndRegTime(String schId) throws BizException;

	/**
	 * 获取可预约的科室集合 根据计划进行过滤
	 * 
	 * @return
	 * @throws BizException
	 */
	DeptDO[] getAvlAptDepList() throws BizException;

	/**
	 * 获取科室可预约的资源汇总信息
	 * 
	 * @param depId 科室id
	 * @param beginDate 开始日期，默认为当天
	 * @return
	 * @throws BizException
	 */
	ResStatsDTO[] getDepsAvlAptResStats(String depId, FDate beginDate) throws BizException;

	/**
	 * 根据科室id查询资源
	 * 
	 * @param depId 科室id
	 * @return
	 * @throws BizException
	 */
	RegResDTO[] getResByDep(String depId) throws BizException;

	/**
	 * 获取排班
	 * 
	 * @param date 日期
	 * @param dayslotId 日期分组id
	 * @param scResId 排班资源id
	 * @param depId 科室id
	 * @return 排班DO
	 * @throws BizException
	 */
	ScSchDO getSchByResAndDep(FDate date, String dayslotId, String scResId, String depId) throws BizException;

	/**
	 * 获取排班
	 * 
	 * @param date 日期
	 * @param dayslotId 日期分组id，可空
	 * @param depId 科室id，可空
	 * @param empId 人员id，可空
	 * @return
	 * @throws BizException
	 */
	ScSchDO[] getSchList(FDate date, String dayslotId, String depId, String empId) throws BizException;

	/**
	 * 获取医生排班
	 * 
	 * @param date 日期
	 * @param depId 科室id，可空
	 * @param docId 医生id，可空
	 * @param scchltp 渠道类型
	 * @return
	 * @throws BizException
	 */
	RegResDTO[] getSchListOfDoc(String depId, String docId, FDate date, String scchltp) throws BizException;

	/**
	 * 接诊挂号获取医生排班
	 * 
	 * @param depId 科室id
	 * @param empId 医生id
	 * @param date 日期
	 * @param dayslotId 当前时间分组
	 * @return
	 * @throws BizException
	 */
	RegResDTO[] getSch4RegAndAcpt(String depId, String empId, FDate date, String dayslotId) throws BizException;
	/**
	 * 接诊挂号获取医生历史排班
	 * 
	 * @param depId 科室id
	 * @param empId 医生id
	 * @param date 日期
	 * @param dayslotId 当前时间分组
	 * @return
	 * @throws BizException
	 */
	RegResDTO[] getSchHis4RegAndAcpt(String depId, String empId, FDate date, String dayslotId) throws BizException;
	/**
	 * 获取可挂号资源
	 * 
	 * @param date 日期
	 * @param dayslotId 午别，为null，则是全部
	 * @param depIds 科室id数组，若 为null则为全部
	 * @param empId 人员id，可为空
	 * @param scchltp 渠道类型，null全部
	 * @return 返回可挂号资源DTO
	 * @throws BizException
	 */
	RegResDTO[] getAvlResList(FDate date, String dayslotId, String[] depIds, String empId, String scchltp) throws BizException;
	/**
	 * 根据查询模板查询资源
	 * 
	 * @param qryScheme 查询模板
	 * @return
	 * @throws BizException
	 */
	RegResDTO[] getResByScheme(ResQrySchemeDTO qryScheme) throws BizException;
	/**
	 * 根据排班id获取挂号资源
	 * 
	 * @param schId 排班id
	 * @param withPri 是否加载服务价格
	 * @return 挂号资源DTO
	 * @throws BizException
	 */
	RegResDTO getRegRes(String schId, FBoolean withPri) throws BizException;
	
	/***
	 * 根据排班ID获取挂号资源，取预约表中服务，fanlq-2017-09-25
	 * 
	 * @param schId
	 * @param withPri
	 * @return
	 * @throws BizException
	 */
	public RegResDTO getRegRes4Apt(String schId, FBoolean withPri) throws BizException;

	/**
	 * 根据排班id和渠道，获取预约资源
	 * 
	 * @param schId 排班id
	 * @param withPri 是否加载服务价格
	 * @param chlId 渠道ID
	 * @return 挂号资源DTO
	 * @throws BizException
	 * @author yank
	 */
	RegResDTO getAptRes(String schId, FBoolean withPri, String chlId) throws BizException;
	/**
	 * 根据排班获取挂号资源
	 * 
	 * @param schIds 排班ID数组
	 * @param withPri 是否加载服务价格
	 * @return
	 * @throws BizException
	 */
	RegResDTO[] getRegResBySch(String[] schIds, FBoolean withPri) throws BizException;
	
	/**
	 * 根据排班id和渠道，获取预约资源,fanlq-2017-09-25 ，退号，号源是口腔科的备用服务
	 * 
	 * @param schIds
	 * @param withPri
	 * @return
	 * @throws BizException
	 */
	 RegResDTO[] getRegResBySch4CanaReg(String patId,String[] schIds, FBoolean withPri) throws BizException;

	/**
	 * 加载挂号资源价格
	 * 
	 * @param resDTOs 挂号资源DTO集合
	 * @return
	 * @throws BizException
	 */
	RegResDTO[] loadResPri(RegResDTO[] resDTOs) throws BizException;
	
	/**
	 * 加载患者挂号资源价格
	 * 
	 * @param resDTOs 挂号资源DTO集合
	 * @param priPatId 患者价格分类
	 * 
	 * @return
	 * @throws BizException
	 */
	RegResDTO[] loadPatResPri(RegResDTO[] resDTOs, String priPatId) throws BizException;

	/**
	 * 取得票号
	 * 
	 * @param schId 排班id
	 * @param tickNo　票号
	 * @return
	 * @throws BizException
	 */
	ScSchTickDO getTick(String schId, Integer tickNo) throws BizException;

	/**
	 * 根据排班获取最近可用号段 4点可挂1点的号，取当前可用的第一个排班即可，当天和预约同样处理
	 * 
	 * @param schId
	 *            排班id
	 * @return
	 * @throws BizException
	 */
	PeriodResDTO getRecentAvlTicks(String schId, String chlTp) throws BizException;


	/**
	 * 排班获取计划根据排班
	 * 
	 * @param schDO 排班do
	 * @return 计划do
	 * @throws BizException\
	 * @author ccj
	 */
	ScPlanDO getScplanBySchBp(ScSchDO schDO) throws BizException;

	/**
	 * 根据排班计划获取推荐号源
	 * 
	 * @param plId 排班计划ID
	 * @return
	 * @throws BizException
	 * @author wjy
	 */
	RegResDTO[] getSuggestResByPl(String plId) throws BizException;

	/**
	 * 根据号别获取推荐号源
	 * 
	 * @param scsrvId 排班服务ID
	 * @return
	 * @throws BizException
	 * @author wjy
	 */
	RegResDTO[] getSuggestResBySrv(String scsrvId, String deptId) throws BizException;

	/**
	 * 获取排班渠道
	 * 
	 * @param schId 排班ID
	 * @param chlTp 渠道类型
	 * @return
	 * @throws BizException
	 * @author yank
	 */
	ScSchChlDO getSchChl(String schId, String chlTp) throws BizException;

	/**
	 * 项目互斥检查
	 *
	 * @param patId 患者id
	 * @param srvId 服务id
	 * @throws BizException
	 * @author zhengcm
	 */
	void mutexCheck(String patId, String srvId) throws BizException;

	/**
	 * 医技预约项目互斥检查
	 *
	 * @param patId
	 * @param srvId
	 * @param aptTime
	 * @param MtResDTO resDTO
	 * @throws BizException
	 * @author zhengcm
	 */
	void mutexCheck4MtApt(String patId, String srvId, FDateTime aptTime) throws BizException;

	/**
	 * 医技预约项目互斥检查
	 *
	 * @param id_pat
	 * @param id_srv
	 * @param aptTime
	 * @param exclDateList 需要排斥掉的日期
	 * @param firstDateList 优先需要选择的日期
	 * @param d_sch 排班日期
	 * @param fg_hp 医保支付标识
	 * @throws BizException
	 * @author zhengcm
	 */
	void mutexCheck4ManualMtApt(String patId, String srvId,String idEnt, FDateTime aptTime,MtResDTO resDTO,FDate d_sch,FBoolean fg_hp) throws BizException;
	
	/**
	 * 医技预约项目互斥检查
	 *
	 * @param patId
	 * @param srvId
	 * @param aptTime
	 * @param MtResDTO resDTO
	 * @throws BizException
	 * @author zhengcm
	 */
	void mutexCheck4ManualChangeMtApt(String patId, String srvId, FDateTime aptTime,MtResDTO resDTO,FDate d_sch,String id_apt_appl) throws BizException;
	
	
	/**
	 * 自动预约:医技预约项目互斥检查
	 * @param patId 患者id
	 * @param srvId 诊疗项目id
	 * @param idEnt 就诊id
	 * @param aptTime 预约时间
	 * @param resDTO 排班数据
	 * @param fg_hp 医保支付标识
	 * @throws BizException
	 * @author yzh
	 */
	void mutexCheck4AutoMtApt8ExclDate(String patId, String srvId,String idEnt, FDateTime aptTime,MtResDTO resDTO,FBoolean fg_hp) throws BizException;
		/**
	 * 获取所有可用号段
	 * 
	 * @param id_sch
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	ScSchTicksDO[] getAllDoUsedTicksBySchAndSrv(String id_sch, String id_srv) throws BizException;

	/**
	 * 获取所有可用号位
	 * 
	 * @param id_sch 排班id
	 * @param id_srv 服务id
	 * @return
	 */
	ScSchTickDO[] getAllDoUsedTickBySchAndSrv(String id_sch, String id_srv) throws BizException;

	/**
	 * 批量获取占用的号位
	 *
	 * @param tickIds tickIds 号位ID集合
	 * @return 号位对象Map
	 * @throws BizException
	 * @author zhengcm
	 */
	Map<String, ScSchTickDO[]> batchGetOccupiedTickList(String[] tickIds) throws BizException;

	/**
	 * 批量获取指定排班同号源池且不包含指定渠道的号位
	 * 
	 * @author zhengcm
	 *
	 * @param schMap
	 * @param chlDO
	 * @return
	 * @throws BizException
	 */
	public Map<String, List<ScSchTickDO>> batchGetSchOtherChlTick(Map<String, Integer> schMap, SchedulechlDO chlDO)
			throws BizException;

	/**
	 * 批量获取排班指定渠道的剩余可预约数量
	 * 
	 * @author zhengcm
	 *
	 * @param schIdList
	 * @param id_scchl
	 * @param id_enttp
	 * @return
	 * @throws BizException
	 */
	public Map<String, Map<Integer,Integer>> batchGetChlSchRemainAmount(List<String> schIdList,String id_scchl) throws BizException;
	
	/**
	 * 批量获取排班指定渠道的剩余可预约数量
	 * 
	 * @author zhengcm
	 *
	 * @param schIdList
	 * @param id_scchl
	 * @param id_enttp
	 * @return
	 * @throws BizException
	 */
	public Map<String,Map<Integer, Integer>> batchGetChlSchRemainFilterEntpAmount(List<String> schIdList, String id_enttp,String id_scchl) throws BizException;
	
	/**
	 * 批量获取排班指定渠道的剩余可预约数量
	 * 
	 * @author zhengcm
	 *
	 * @param schIdList
	 * @param id_scchl
	 * @param id_enttp
	 * @return
	 * @throws BizException
	 */
	public Map<String,Map<Integer, Integer>> batchGetChlSchRemainFilterEntpAmount4AutoApt(List<String> schIdList, String id_enttp,String id_scchl) throws BizException;
}
