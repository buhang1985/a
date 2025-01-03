package iih.sc.sch.s;

import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.sch.d.SchMtPlDTO;
import iih.sc.sch.dto.d.MtSchDTO;
import iih.sc.sch.dto.d.MtSchDetailDTO;
import iih.sc.sch.dto.d.MtSchMgrDTO;
import iih.sc.sch.dto.d.MtSchTreeDTO;
import iih.sc.sch.dto.d.OpSchSelDTO;
import iih.sc.sch.dto.d.SchCancDTO;
import iih.sc.sch.dto.d.SchInfoDTO;
import iih.sc.sch.dto.d.SchOralInfoDTO;
import iih.sc.sch.dto.d.SchQryDTO;
import iih.sc.sch.i.IScSchQryService;
import iih.sc.sch.opschsel.s.bp.GetOpSchSelByQCondAndPageInfoBP;
import iih.sc.sch.s.bp.BatchGetScSrvPriceBP;
import iih.sc.sch.s.bp.CheckHasSchBP;
import iih.sc.sch.s.bp.GetAllSchMgrBrief4SingleBP;
import iih.sc.sch.s.bp.GetDepParamIdListBP;
import iih.sc.sch.s.bp.GetHaveSchDeptBp;
import iih.sc.sch.s.bp.GetHolidayArrayByScTpBp;
import iih.sc.sch.s.bp.GetMtSchCardSrvBp;
import iih.sc.sch.s.bp.GetMtSchPlanSchMtPlDTOsBp;
import iih.sc.sch.s.bp.GetMtSchTreeBP;
import iih.sc.sch.s.bp.GetMtSchWkPlsBP;
import iih.sc.sch.s.bp.GetOralSchArrayBP;
import iih.sc.sch.s.bp.GetOralSchBP;
import iih.sc.sch.s.bp.GetOralSelectedSchPlanBP;
import iih.sc.sch.s.bp.GetPsnInCondBP;
import iih.sc.sch.s.bp.GetSchMgrBriefBP;
import iih.sc.sch.s.bp.GetSchMgrDetailBP;
import iih.sc.sch.s.bp.GetScpolcnByIdAndSdBp;
import iih.sc.sch.s.bp.GetSdSchruleByIdSchBp;
import iih.sc.sch.s.bp.OralSubQuecnCheckBP;
import iih.sc.sch.s.bp.ValCalendarExByDateIntervalBp;
import iih.sc.sch.s.bp.ValSchHaveUsedBp;
import iih.sc.sch.s.bp.op.GetOpSchCancAptInfoBP;
import iih.sc.sch.s.bp.op.GetOpSchCancDeptSchInfoBP;
import iih.sc.sch.s.bp.op.GetOpSchCancInfoBP;
import iih.sc.sch.s.bp.oral.CanCopyConverBP;
import iih.sc.sch.s.bp.oral.GetOralSchDetailBP;
import iih.sc.sch.s.bp.oral.GetOralSchsDetailsBP;
import iih.sc.sch.s.bp.qry.GetCancAptByStopSchBP;
import iih.sc.sch.s.bp.qry.GetMtSchPlNameBP;
import iih.sc.sch.s.bp.qry.GetSchInfoBP;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickEP;

import java.util.List;
import java.util.Map;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 排班查询服务
 * 
 * @author yank
 * 
 */
@Service(serviceInterfaces = { IScSchQryService.class }, binding = Binding.JSONRPC)
public class ScSchQryServiceImpl implements IScSchQryService {
	/**
	 * 门急诊排班查询
	 * OpSchSelDTO： 门急诊排班信息
	 * PaginationInfo：
	 * @throws BizException 
	 */
	@Override
	public PagingRtnData<OpSchSelDTO> getOpSchSelByQCondAndPageInfo(OpSchSelDTO qryDTO, PaginationInfo pg) throws BizException {
		GetOpSchSelByQCondAndPageInfoBP getInfoBP = new GetOpSchSelByQCondAndPageInfoBP();
		return getInfoBP.exec(qryDTO, pg);
	}
	/**
	 * 根据排班id 查找预约规则类型编码
	 * 
	 * @param id_sch 排班id
	 * @return
	 * @throws BizException
	 * @author ccj
	 */
	@Override
	public String getSdSchruleByIdSch(String id_sch) throws BizException {
		GetSdSchruleByIdSchBp byIdSch = new GetSdSchruleByIdSchBp();
		return byIdSch.exec(id_sch);
	}

	/**
	 * 根据排班id 判断排班有没有被使用
	 * 
	 * @param id_sch 排班id
	 * @throws BizException
	 * @author ccj
	 */
	@Override
	public void valSchHaveUsed(String id_sch) throws BizException {
		ValSchHaveUsedBp schHaveUsedBp = new ValSchHaveUsedBp();
		schHaveUsedBp.exec(id_sch);
	}

	/**
	 * 根据排班分类查询有排班的科室
	 * 
	 * @param sctp 排班类型分类
	 * @return list 有排班科室信息
	 * @throws BizException
	 * @author ccj
	 */
	@Override
	public List<DeptDO> getHaveSchDept(String sctp, FBoolean fg_active) throws BizException {
		GetHaveSchDeptBp getHaveSchDept = new GetHaveSchDeptBp();
		return getHaveSchDept.exec(sctp, fg_active);
	}

	/**
	 * 获取号源池数根据排班id和渠道编码
	 * 
	 * @param sd_scchltp 渠道编码
	 * @param id_sch 排班id
	 * @return 号源池数
	 * @throws BizException
	 * @author ccj
	 */
	@Override
	public Integer getScpolcnByIdAndSdBp(String sd_scchltp, String id_sch) throws BizException {
		GetScpolcnByIdAndSdBp byIdAndSdBp = new GetScpolcnByIdAndSdBp();
		return byIdAndSdBp.exec(sd_scchltp, id_sch);
	}

	/**
	 * 获取排班服务价格
	 * 
	 * @param scSrvIds 排班服务id数组
	 * @return 价格Map,Key: 排班服务ID,Value:价格
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public Map<String, FDouble> getScSrvPrice(String[] scSrvIds) throws BizException {
		BatchGetScSrvPriceBP getPriceBP = new BatchGetScSrvPriceBP();
		return getPriceBP.exec(scSrvIds);
	}

	/**
	 * 获取医技排班树
	 * 
	 * @return SchMtPlDTO arrays
	 * @throws BizException
	 * @author ccj
	 */
	@Override
	public SchMtPlDTO[] getMtSchPlanSchMtPlDTOs() throws BizException {
		GetMtSchPlanSchMtPlDTOsBp planSchMtPlDTOsBp = new GetMtSchPlanSchMtPlDTOsBp();
		return planSchMtPlDTOsBp.exec();
	}

	/**
	 * 获取医技排班树
	 * 
	 * @return SchMtPlDTO arrays
	 * @throws BizException
	 */
	@Override
	public MtSchTreeDTO[] getMtSchTree(String beanType) throws BizException {
		GetMtSchTreeBP getBP = new GetMtSchTreeBP();
		return getBP.exec(beanType);
	}

	/**
	 * 根据类型求对应日历的节点日在对应的日期区间内
	 * 
	 * @param sctp 排班类型
	 * @param begin_date 开始日期
	 * @param end_date 结束日期
	 * @return 节假日arrays
	 * @throws BizException
	 */
	@Override
	public String[] getHolidayArrayByScTp(String sctp, String begin_date, String end_date) throws BizException {
		GetHolidayArrayByScTpBp arrayByScTpBp = new GetHolidayArrayByScTpBp();
		return arrayByScTpBp.exec(sctp, begin_date, end_date);
	}

	/**
	 * 判断日历在对应的排班区间内是否存在
	 * 
	 * @param begin_date 开始日期
	 * @param end_date 结束日期
	 * @throws BizException 不存在抛出相应信息
	 * @author ccj
	 */
	@Override
	public void valCalendarExByDateInterval(String begin_date, String end_date,String sd_sctp) throws BizException {
		ValCalendarExByDateIntervalBp byDateIntervalBp = new ValCalendarExByDateIntervalBp();
		byDateIntervalBp.exec(begin_date, end_date,sd_sctp);
	}

	/**
	 * 查找周对应的周计划
	 * 
	 * @param idx_week
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtSchDTO[] getMtSchPlWks(String scplId, Integer idx_week) throws BizException {
		GetMtSchWkPlsBP getMtSchPlWksBp = new GetMtSchWkPlsBP();
		return getMtSchPlWksBp.exec(scplId, idx_week);
	}

	/**
	 * 医技排班管理扼要信息
	 * 
	 * @param dt_b 开始时间
	 * @param dt_e 结束时间
	 * @param navIdtp id类型
	 * @param navId id
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtSchMgrDTO[] getSchMgrBrief(FDate dt_b, FDate dt_e, String depId, String scresId, String srvId,
			String sd_sctp,String loadType) throws BizException {

		GetSchMgrBriefBP getSchMgrBriefBP = new GetSchMgrBriefBP();
		return getSchMgrBriefBP.exec(dt_b, dt_e, depId, scresId, srvId, sd_sctp,loadType);
	}
	/**
	 * 获取单个医技排班所有扼要信息
	 * 
	 * @param navIdtp id类型
	 * @param navId id
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtSchMgrDTO[] getAllSchMgrBrief4Single(String depId, String scresId, String srvId,
			String sd_sctp) throws BizException {

		GetAllSchMgrBrief4SingleBP getAllSchMgrBrief4SingleBP = new GetAllSchMgrBrief4SingleBP();
		return getAllSchMgrBrief4SingleBP.exec(depId, scresId, srvId, sd_sctp);
	}
	/**
	 * 医技排班管理详细信息
	 * 
	 * @param mtSchMgrDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtSchDetailDTO getSchMgrDetail(MtSchDetailDTO mtSchMgrDTO) throws BizException {
		GetSchMgrDetailBP getSchMgrDetailBP = new GetSchMgrDetailBP();
		return getSchMgrDetailBP.exec(mtSchMgrDTO);
	}

	/**
	 * 批量处理：获取查询条件下的排班
	 * 
	 * @param schQryDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<SchInfoDTO> getSchInfo(SchQryDTO schQryDTO, PaginationInfo pageInfo) throws BizException {
		GetSchInfoBP getschinfoBP = new GetSchInfoBP();
		return getschinfoBP.exec(schQryDTO, pageInfo);
	}

	/**
	 * 获取医技卡片显示服务
	 * 
	 * @param sd_md 票号模式
	 * @param id_sch 排班id
	 * @param srvName 排班服务名称
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getMtSchCardSrv(String sd_md, String id_sch, String srvName) throws BizException {
		GetMtSchCardSrvBp cardSrvBp = new GetMtSchCardSrvBp();
		return cardSrvBp.exec(sd_md, id_sch, srvName);
	}

	// =====================口腔=============================//
	/**
	 * 根据当前科室查询科室下所有病区的人员（护士），包括人员部门关系中符合的人员
	 * 
	 * @param id_dep 当前科室
	 * @return 人员（护士）的In查询条件
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public String getPsnInCondByDep(String id_dep) throws BizException {
		return new GetPsnInCondBP().exec(id_dep);
	}

	/**
	 * 获取口腔科已有的排班
	 * 
	 * @param id_dep 当前科室
	 * @param dt_begin 开始日期
	 * @param dt_end 结束日期
	 * @param name_room 诊间名称
	 * @return 口腔科排班信息DTO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public FArrayList getOralSch(String id_dep, String dt_begin, String dt_end, String name_room) throws BizException {
		return new GetOralSchBP().exec(id_dep, dt_begin, dt_end, name_room);
	}

	/**
	 * 根据排班计划获取口腔科周计划的号位和渠道数据
	 * 
	 * @param id_scpl 排班计划id
	 * @return 口腔科排班信息DTO的Map,Key为日期分组id
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public FMap getOralSelectedSchPlan(String id_scpl) throws BizException {
		return new GetOralSelectedSchPlanBP().exec(id_scpl);
	}

	/**
	 * 口腔科排班加号减少是否允许
	 * 
	 * @param depId 科室id
	 * @param schId 排班id
	 * @param dayslotId 日期分组id
	 * @return 布尔值
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public boolean isOralSchQuecnCanSub(String depId, String schId, String dayslotId) throws BizException {
		return new OralSubQuecnCheckBP().exec(depId, schId, dayslotId);
	}

	/**
	 * 获取口腔科已有的排班
	 * 
	 * @param id_dep 当前科室
	 * @param dt_begin 开始日期
	 * @param dt_end 结束日期
	 * @param name_room 诊间名称
	 * @return 口腔科排班信息DTO列表
	 * @throws BizException
	 */
	@Override
	public SchOralInfoDTO[] getOralSchList(String id_dep, String dt_begin, String dt_end, String name_room)
			throws BizException {
		return new GetOralSchArrayBP().exec(id_dep, dt_begin, dt_end, name_room, null);
	}

	/**
	 * 获取口腔科已有的排班(带版本)
	 *
	 * @param id_dep 当前科室
	 * @param dt_begin 开始日期
	 * @param dt_end 结束日期
	 * @param name_room 诊间名称
	 * @return 口腔科排班信息DTO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public SchOralInfoDTO[] getOralSchListWithVer(String id_dep, String dt_begin, String dt_end, String name_room,
			String paramId) throws BizException {
		return new GetOralSchArrayBP().exec(id_dep, dt_begin, dt_end, name_room, paramId);
	}

	/**
	 * 获取口腔排班信息，含号位、渠道信息
	 * 
	 * @param schId 排班ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public SchOralInfoDTO getOralSchDetail(String schId) throws BizException {
		GetOralSchDetailBP getOralSchBP = new GetOralSchDetailBP();
		return getOralSchBP.exec(schId);
	}

	/**
	 * 批量获取口腔排班信息，含号位、渠道信息
	 * 
	 * @param schId 排班ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public SchOralInfoDTO[] getOralSchsDetail(SchOralInfoDTO[] orals) throws BizException {
		GetOralSchsDetailsBP getOralSchBP = new GetOralSchsDetailsBP();
		return getOralSchBP.exec(orals);
	}

	/**
	 * 检查在同一天同一午别是否已经排班
	 * 
	 * @param schId 排班ID
	 * @param date 日期
	 * @param dayslotId 午别ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean checkHasSch(String schId, FDate date, String dayslotId) throws BizException {
		CheckHasSchBP checkBP = new CheckHasSchBP();
		return checkBP.exec(schId, date, dayslotId);
	}

	/**
	 * 是否可粘贴覆盖
	 * 
	 * @param deptId 科室ID
	 * @param siteSchMap 拷贝的站点排班集合
	 * @param beginDate 预粘贴的开始日期
	 * @param endDate 预粘贴的结束日期
	 * @return
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public boolean canCopyConver(String deptId, FMap siteSchMap, FDate beginDate, FDate endDate) throws BizException {
		CanCopyConverBP checkBP = new CanCopyConverBP();
		return checkBP.exec(deptId, siteSchMap, beginDate, endDate);
	}

	/**
	 * 获取符合条件的科室参数id，供参照使用
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @param name_room
	 * @return
	 * @throws BizException
	 */
	@Override
	public FArrayList getDepParamIdList(String dt_begin, String dt_end, String name_room) throws BizException {
		GetDepParamIdListBP getParam = new GetDepParamIdListBP();
		return getParam.exec(dt_begin, dt_end, name_room);
	}

	/**
	 * 获取门诊排班停诊排班信息
	 * 
	 * @author zhengcm
	 * @date 2017-11-16 19:33:43
	 *
	 * @param id_sch
	 * @return
	 * @throws BizException
	 */
	@Override
	public SchCancDTO getOpSchCancInfo(String id_sch) throws BizException {
		return new GetOpSchCancInfoBP().exec(id_sch);
	}

	/**
	 * 获取门诊排班停诊排班预约信息
	 * 
	 * @author zhengcm
	 * @date 2017-11-17 09:03:22
	 *
	 * @param id_sch 排班ID
	 * @param isShowCancel 是否显示取消预约
	 * @return
	 * @throws BizException
	 */
	@Override
	public SchCancDTO[] getOpSchCancAptInfo(String id_sch, FBoolean isShowCancel) throws BizException {
		return new GetOpSchCancAptInfoBP().exec(id_sch, isShowCancel);
	}

	/**
	 * 获取门诊科室除本排班外的其他排班信息
	 * 
	 * @author zhengcm
	 * @date 2017-11-17 09:07:37
	 *
	 * @param id_dept 科室ID
	 * @param id_sch 排班ID
	 * @param d_sch 排班日期
	 * @param fg_origin_scres 是否当前排班资源
	 * @param fg_origin_scsrv 是否当前排班服务
	 * @return
	 * @throws BizException
	 */
	@Override
	public SchCancDTO[] getOpSchCancDeptSchInfo(String id_dept, String id_sch, FDate d_sch, FBoolean fg_origin_scres,
			FBoolean fg_origin_scsrv) throws BizException {
		return new GetOpSchCancDeptSchInfoBP().exec(id_dept, id_sch, d_sch, fg_origin_scres, fg_origin_scsrv);
	}
	/**
	 * 校验号位状态
	 * @throws BizException 
	 */
	@Override
	public boolean validateTickIsUsed(String tickId) throws BizException{
		TickEP tickEP = new TickEP();
		return tickEP.validateTickDataIsUsed(tickId);
	}
	/**
	 * 排班是否被使用
	 * @param schId
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean validateIsSchUsed(String schId) throws BizException{
		SchEP schEP = new SchEP();
		return schEP.isSchUsed(schId);
	}
	
	 /**
	  * 查询计划名称
	  * @return
	  * @throws BizException
	  */
	public MtSchDTO[]  getMtSchPlName(MtSchDTO[] mtschDTOs) throws BizException{
		GetMtSchPlNameBP  getMtSchPl = new GetMtSchPlNameBP();
		return getMtSchPl.exec(mtschDTOs);
	}
	/**
	  * 获取停诊排班下需要取消预约的记录
	  * @param schId
	  * @return
	  * @throws BizException
	  */
	@Override
	public OpAptDTO[] getCancAptByStopSch(String schId) throws BizException {
		GetCancAptByStopSchBP bp = new GetCancAptByStopSchBP();
		return bp.exec(schId);
	}

}
