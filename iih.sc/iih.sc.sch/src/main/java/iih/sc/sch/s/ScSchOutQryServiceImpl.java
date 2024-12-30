package iih.sc.sch.s;

import java.util.List;
import java.util.Map;

import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.PeriodResDTO;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.ResQrySchemeDTO;
import iih.sc.sch.reg.dto.d.ResStatsDTO;
import iih.sc.sch.s.bp.AddTickesSchBP;
import iih.sc.sch.s.bp.BatchGetRegResBySchBP;
import iih.sc.sch.s.bp.CheckAfterEndRegTimeBP;
import iih.sc.sch.s.bp.GetAllDoUsedTickBySchAndSrvBp;
import iih.sc.sch.s.bp.GetAllDoUsedTicksBySchAndSrvBp;
import iih.sc.sch.s.bp.GetAptResBP;
import iih.sc.sch.s.bp.GetAvlAptDepListBP;
import iih.sc.sch.s.bp.GetAvlResListBP;
import iih.sc.sch.s.bp.GetChlAptTimeDateBP;
import iih.sc.sch.s.bp.GetChlSchApptAmountBP;
import iih.sc.sch.s.bp.GetDepsResStatsBP;
import iih.sc.sch.s.bp.GetMaxAvlRegDateBP;
import iih.sc.sch.s.bp.GetRegResBySchBP;
import iih.sc.sch.s.bp.GetResByDepBP;
import iih.sc.sch.s.bp.GetResBySchmBP;
import iih.sc.sch.s.bp.GetSch4RegAndAcptBP;
import iih.sc.sch.s.bp.GetSchByResAndDepBP;
import iih.sc.sch.s.bp.GetSchChlBP;
import iih.sc.sch.s.bp.GetSchHis4RegAndAcptBP;
import iih.sc.sch.s.bp.GetSchListBP;
import iih.sc.sch.s.bp.GetSchOtherChlTickBP;
import iih.sc.sch.s.bp.GetScplanBySchBp;
import iih.sc.sch.s.bp.GetSuggestResByPlBP;
import iih.sc.sch.s.bp.GetSuggestResBySrvBP;
import iih.sc.sch.s.bp.GetTickBySchAndTickNoBP;
import iih.sc.sch.s.bp.LoadResPriceBP;
import iih.sc.sch.s.bp.SrvMutexCheck4MtAptBP;
import iih.sc.sch.s.bp.SrvMutexCheckBP;
import iih.sc.sch.s.bp.mt.apt.GetChlSchApptAmount4AptBP;
import iih.sc.sch.s.bp.mt.apt.GetChlSchApptAmount4AutoBP;
import iih.sc.sch.s.bp.mt.apt.SrvMutexCheck4AutoMtAptBP;
import iih.sc.sch.s.bp.mt.apt.SrvMutexCheck4ChangeMtAptBP;
import iih.sc.sch.s.bp.mt.apt.SrvMutexCheck4ManualMtAptBP;
import iih.sc.sch.s.bp.op.GetTickByLockIdBP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.s.ep.TicksEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 排班对外查询服务
 * 
 * @author yank
 * @author liubin
 *
 */
@Service(serviceInterfaces = { IScSchOutQryService.class }, binding = Binding.JSONRPC)
public class ScSchOutQryServiceImpl implements IScSchOutQryService {
	/***
	 * @Description:根据锁号id查询号位信息
	 * @param id_schlock
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO getTickByLockId(String id_schlock) throws BizException{
		return new GetTickByLockIdBP().exec(id_schlock);
	}
	/**
	 * 获取最大可挂号日期
	 * 
	 * @param chlTp
	 *            渠道类型，参考：IScDictCodeConst
	 * @return
	 * @throws BizException
	 */
	@Override
	public FDate getMaxAvlRegDate(String chlTp) throws BizException {
		GetMaxAvlRegDateBP apptBP = new GetMaxAvlRegDateBP();
		return apptBP.exec(chlTp);
	}

	/**
	 * 获取渠道期间可预约日期段
	 * 
	 * @param chlId 渠道ID
	 * @param sctp 排班类型
	 * @return 预约日期集合 begin:开始日期 end:结束日期
	 * @throws BizException
	 */
	@Override
	public FMap getetChlAptTimeIntervalDate(String chlId) throws BizException {
		GetChlAptTimeDateBP getChlTimeBP = new GetChlAptTimeDateBP();
		return getChlTimeBP.exec(chlId);
	}
	
	/**
	 * 是否已过停止挂号时间
	 * 
	 * @param schId
	 *            排班ID
	 * @return true/false
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public FBoolean isAfterEndRegTime(String schId) throws BizException {
		CheckAfterEndRegTimeBP checkBP = new CheckAfterEndRegTimeBP();
		return checkBP.exec(schId);
	}

	/**
	 * 获取可预约的科室集合 根据计划进行过滤
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public DeptDO[] getAvlAptDepList() throws BizException {
		GetAvlAptDepListBP getBP = new GetAvlAptDepListBP();
		return getBP.exec();
	}

	/**
	 * 获取科室可预约的资源汇总信息
	 * 
	 * @param depId
	 *            科室id
	 * @param beginDate
	 *            开始日期，默认为当天
	 * @return
	 * @throws BizException
	 */
	@Override
	public ResStatsDTO[] getDepsAvlAptResStats(String depId, FDate beginDate) throws BizException {
		GetDepsResStatsBP getBP = new GetDepsResStatsBP();
		return getBP.exec(depId, beginDate);
	}

	/**
	 * 根据科室id查询资源
	 * 
	 * @param depId
	 *            科室id
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegResDTO[] getResByDep(String depId) throws BizException {
		GetResByDepBP getBP = new GetResByDepBP();
		return getBP.exec(depId);
	}

	/**
	 * 获取排班
	 * 
	 * @param date
	 *            日期
	 * @param dayslotId
	 *            日期分组id
	 * @param depId
	 *            科室id
	 * @param empId
	 *            人员id
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScSchDO[] getSchList(FDate date, String dayslotId, String depId, String empId) throws BizException {
		GetSchListBP getBP = new GetSchListBP();
		return getBP.exec(date, dayslotId, depId, empId);
	}

	/**
	 * 诊间加号获取医生排班
	 * 
	 * @param date
	 *            日期
	 * @param depId
	 *            科室id，可空
	 * @param docId
	 *            医生id，可空
	 * @param scchltp
	 *            渠道类型
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegResDTO[] getSchListOfDoc(String depId, String docId, FDate date, String scchltp) throws BizException {
		AddTickesSchBP bp = new AddTickesSchBP();
		return bp.getSchListOfDoc(depId, docId, date, scchltp);
	}

	/**
	 * 接诊挂号获取医生排班
	 * 
	 * @param depId
	 *            科室id
	 * @param empId
	 *            医生id
	 * @param date
	 *            日期
	 * @param dayslotId
	 *            当前时间分组
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public RegResDTO[] getSch4RegAndAcpt(String depId, String empId, FDate date, String dayslotId) throws BizException {
		GetSch4RegAndAcptBP bp = new GetSch4RegAndAcptBP();
		return bp.exec(depId, empId, date, dayslotId);
	}
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
	@Override
	public RegResDTO[] getSchHis4RegAndAcpt(String depId, String empId, FDate date, String dayslotId) throws BizException {
		GetSchHis4RegAndAcptBP bp = new GetSchHis4RegAndAcptBP();
		return bp.exec(depId, empId, date, dayslotId);
	}
	/**
	 * 获取排班
	 * 
	 * @param date
	 *            日期
	 * @param dayslotId
	 *            日期分组id
	 * @param scResId
	 *            排班资源id
	 * @param depId
	 *            科室id
	 * @return 排班DO
	 * @throws BizException
	 */
	@Override
	public ScSchDO getSchByResAndDep(FDate date, String dayslotId, String scResId, String depId) throws BizException {
		GetSchByResAndDepBP geBP = new GetSchByResAndDepBP();
		return geBP.exec(date, dayslotId, scResId, depId);
	}

	/**
	 * 获取可挂号资源
	 * 
	 * @param date
	 *            日期
	 * @param dayslotId
	 *            午别，为null，则是全部
	 * @param depIds
	 *            科室id数组，若 为null则为全部
	 * @param empId
	 *            人员id，可为空
	 * @return 返回可挂号资源DTO
	 * @throws BizException
	 */
	@Override
	public RegResDTO[] getAvlResList(FDate date, String dayslotId, String[] depIds, String empId, String scchltp) throws BizException {
		GetAvlResListBP getResBP = new GetAvlResListBP();
		return getResBP.exec(date, dayslotId, depIds, empId, scchltp);
	}

	/**
	 * 根据查询模板查询资源
	 * 
	 * @param qryScheme
	 *            查询模板
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegResDTO[] getResByScheme(ResQrySchemeDTO qryScheme) throws BizException {
		GetResBySchmBP getBP = new GetResBySchmBP();
		RegResDTO[] resArray = getBP.exec(qryScheme);
		// 加载价格
		LoadResPriceBP loadPriceBP = new LoadResPriceBP();
		return loadPriceBP.exec(resArray);
	}

	/**
	 * 根据排班id获取挂号资源
	 * 
	 * @param schId
	 *            排班id
	 * @param withPri
	 *            是否加载服务价格
	 * @return 挂号资源DTO
	 * @throws BizException
	 */
	@Override
	public RegResDTO getRegRes(String schId, FBoolean withPri) throws BizException {
		GetRegResBySchBP getResBP = new GetRegResBySchBP();
		return getResBP.exec(schId, withPri);
	}

	/**
	 * 根据排班ID获取挂号资源，取预约表中服务，fanlq-2017-09-25
	 * 
	 * @param aptId
	 *            预约id
	 * @param withPri
	 *            是否加载服务价格
	 * @return 挂号资源DTO
	 * @throws BizException
	 */
	@Override
	public RegResDTO getRegRes4Apt(String aptId, FBoolean withPri) throws BizException {
		GetRegResBySchBP getResBP = new GetRegResBySchBP();
		return getResBP.exec4Apt(aptId, withPri);
	}

	/**
	 * 根据排班id和渠道，获取预约资源
	 * 
	 * @param schId
	 *            排班id
	 * @param withPri
	 *            是否加载服务价格
	 * @param chlId
	 *            渠道ID
	 * @return 挂号资源DTO
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public RegResDTO getAptRes(String schId, FBoolean withPri, String chlId) throws BizException {
		GetAptResBP getAptResBP = new GetAptResBP();
		return getAptResBP.exec(schId, withPri, chlId);
	}

	/**
	 * 根据排班获取挂号资源
	 * 
	 * @param schIds
	 *            排班ID数组
	 * @param withPri
	 *            是否加载服务价格
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegResDTO[] getRegResBySch(String[] schIds, FBoolean withPri) throws BizException {
		BatchGetRegResBySchBP batchGetBP = new BatchGetRegResBySchBP();
		return batchGetBP.exec(schIds, withPri);
	}

	/**
	 * 根据排班获取挂号资源 fanlq-2017-09-25
	 * 
	 * @param schIds
	 *            排班ID数组
	 * @param withPri
	 *            是否加载服务价格
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegResDTO[] getRegResBySch4CanaReg(String patId,String[] schIds, FBoolean withPri) throws BizException {
		BatchGetRegResBySchBP batchGetBP = new BatchGetRegResBySchBP();
		return batchGetBP.exec4CancReg(patId,schIds, withPri);
	}
	/**
	 * 加载挂号资源价格
	 * 
	 * @param resDTOs
	 *            挂号资源DTO集合
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegResDTO[] loadResPri(RegResDTO[] resDTOs) throws BizException {
		LoadResPriceBP loadPriceBP = new LoadResPriceBP();
		return loadPriceBP.exec(resDTOs);
	}
	/**
	 * 加载患者挂号资源价格
	 * 
	 * @param resDTOs 挂号资源DTO集合
	 * @param priPatId 患者价格分类
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegResDTO[] loadPatResPri(RegResDTO[] resDTOs, String priPatId) throws BizException {
		LoadResPriceBP loadPriceBP = new LoadResPriceBP();
		return loadPriceBP.exec(resDTOs, priPatId);
	}
	/**
	 * 取得票号
	 * 
	 * @param schId
	 *            排班id
	 * @param tickNo
	 *            票号
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScSchTickDO getTick(String schId, Integer tickNo) throws BizException {
		GetTickBySchAndTickNoBP qryBP = new GetTickBySchAndTickNoBP();
		return qryBP.exec(schId, tickNo);
	}

	/**
	 * 根据排班获取最近可用号段 4点可挂1点的号，取当前可用的第一个排班即可，当天和预约同样处理
	 * 
	 * @param schId
	 *            排班id
	 * @return
	 * @throws BizException
	 */
	@Override
	public PeriodResDTO getRecentAvlTicks(String schId, String chlTp) throws BizException {
		TicksEP ticksBP = new TicksEP();
		return ticksBP.getRecentAvlTicks(schId, chlTp);
	}

	/**
	 * 排班获取计划根据排班
	 * 
	 * @param schDO
	 *            排班do
	 * @return 计划do
	 * @throws BizException
	 * @author ccj
	 */
	@Override
	public ScPlanDO getScplanBySchBp(ScSchDO schDO) throws BizException {
		GetScplanBySchBp bySchBp = new GetScplanBySchBp();
		ScPlanDO planDO = bySchBp.exec(schDO);
		return planDO;
	}

	/**
	 * 根据排班计划获取推荐号源
	 * 
	 * @param plId
	 *            排班计划ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegResDTO[] getSuggestResByPl(String plId) throws BizException {
		GetSuggestResByPlBP getBP = new GetSuggestResByPlBP();
		LoadResPriceBP loadPriceBP = new LoadResPriceBP();
		return loadPriceBP.exec(getBP.exec(plId));
	}

	/**
	 * 根据号别获取推荐号源
	 * 
	 * @param scsrvId
	 *            排班服务ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegResDTO[] getSuggestResBySrv(String scsrvId, String deptId) throws BizException {
		GetSuggestResBySrvBP getResBP = new GetSuggestResBySrvBP();
		LoadResPriceBP loadPriceBP = new LoadResPriceBP();
		return loadPriceBP.exec(getResBP.exec(scsrvId, deptId));
	}

	/**
	 * 获取排班渠道
	 * 
	 * @param schId
	 *            排班ID
	 * @param chlTp
	 *            渠道类型
	 * @return
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public ScSchChlDO getSchChl(String schId, String chlTp) throws BizException {
		GetSchChlBP getBP = new GetSchChlBP();
		return getBP.exec(schId, chlTp);
	}

	/**
	 * 项目互斥检查
	 */
	@Override
	public void mutexCheck(String patId, String srvId) throws BizException {
		new SrvMutexCheckBP().exec(patId, srvId);
	}

	/**
	 * 医技预约项目互斥检查
	 */
	@Override
	public void mutexCheck4MtApt(String patId, String srvId, FDateTime aptTime) throws BizException {
		new SrvMutexCheck4MtAptBP().exec(patId, srvId, aptTime);
	}
	/**
	 * 医技预约项目互斥检查--手动预约
	 */
	@Override
	public void mutexCheck4ManualMtApt(String patId, String srvId,String idEnt, FDateTime aptTime,MtResDTO resDTO,FDate d_sch,FBoolean fg_hp) throws BizException {
		new SrvMutexCheck4ManualMtAptBP().exec(patId, srvId,idEnt, aptTime,resDTO,d_sch,fg_hp);
	}
	
	/**
	 * 医技预约项目互斥检查--改约
	 */
	@Override
	public void mutexCheck4ManualChangeMtApt(String patId, String srvId, FDateTime aptTime,MtResDTO resDTO,FDate d_sch,String id_apt_appl) throws BizException {
		new SrvMutexCheck4ChangeMtAptBP().exec(patId, srvId, aptTime,resDTO,d_sch,id_apt_appl);
	}
	/**
	 * 自动预约:医技预约项目互斥检查--自动预约
	 */
	@Override
	public void mutexCheck4AutoMtApt8ExclDate(String patId, String srvId,String idEnt,FDateTime aptTime, MtResDTO resDTO,FBoolean fg_hp) throws BizException {
		new SrvMutexCheck4AutoMtAptBP().exec(patId, srvId,idEnt,aptTime,resDTO,fg_hp);
	}
	/**
	 * 获取所有可用号段
	 * 
	 * @param id_sch
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScSchTicksDO[] getAllDoUsedTicksBySchAndSrv(String id_sch, String id_srv) throws BizException {
		return new GetAllDoUsedTicksBySchAndSrvBp().exec(id_sch, id_srv);
	}

	/**
	 * 获取所有可用号位
	 * 
	 * @param id_sch
	 *            排班id
	 * @param id_srv
	 *            服务id
	 * @return
	 */
	@Override
	public ScSchTickDO[] getAllDoUsedTickBySchAndSrv(String id_sch, String id_srv) throws BizException {
		return new GetAllDoUsedTickBySchAndSrvBp().exec(id_srv, id_sch);
	}

	/**
	 * 批量获取占用的号位
	 *
	 * @param tickIds
	 *            tickIds 号位ID集合
	 * @return 号位对象Map
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public Map<String, ScSchTickDO[]> batchGetOccupiedTickList(String[] tickIds) throws BizException {
		return new TickEP().batchGetOccupiedTickList(tickIds);
	}

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
	@Override
	public Map<String, List<ScSchTickDO>> batchGetSchOtherChlTick(Map<String, Integer> schMap, SchedulechlDO chlDO)
			throws BizException {
		return new GetSchOtherChlTickBP().exec(schMap, chlDO);
	}

	/**
	 * 批量获取排班指定渠道的剩余可预约数量
	 * 
	 * @author zhengcm
	 *
	 * @param schIdList
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 */
	@Override
	public Map<String, Map<Integer,Integer>> batchGetChlSchRemainAmount(List<String> schIdList,String id_scchl) throws BizException {
		return new GetChlSchApptAmountBP().exec(schIdList,id_scchl);
	}
	
	/**
	 * 手动预约和改约——批量获取排班指定渠道的剩余可预约数量
	 * 
	 * @author zhengcm
	 *
	 * @param schIdList
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 */
	@Override
	public Map<String, Map<Integer,Integer>> batchGetChlSchRemainFilterEntpAmount(List<String> schIdList, String id_enttp,String id_scchl) throws BizException {
		return new GetChlSchApptAmount4AptBP().exec(schIdList, id_enttp,id_scchl);
	}
	
	/**
	 * 自动预约——批量获取排班指定渠道的剩余可预约数量
	 * 
	 * @author zhengcm
	 *
	 * @param schIdList
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 */
	@Override
	public Map<String, Map<Integer,Integer>> batchGetChlSchRemainFilterEntpAmount4AutoApt(List<String> schIdList, String id_enttp,String id_scchl) throws BizException {
		return new GetChlSchApptAmount4AutoBP().exec(schIdList, id_enttp,id_scchl);
	}
}
