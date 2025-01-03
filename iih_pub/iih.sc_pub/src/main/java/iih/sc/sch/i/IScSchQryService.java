package iih.sc.sch.i;

import java.util.List;
import java.util.Map;

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
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
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
public interface IScSchQryService {

	/**
	 * 门急诊排班查询
	 * @param qryDTO 排班查询dto
	 * @param pg
	 * @return
	 * @author ltf
	 * @throws BizException 
	 */
	 PagingRtnData<OpSchSelDTO> getOpSchSelByQCondAndPageInfo(OpSchSelDTO qryDTO, PaginationInfo pg) throws BizException;
	/**
	 * 根据排班id 查找预约规则类型编码
	 * 
	 * @param id_sch 排班id
	 * @return
	 * @throws BizException
	 */
	String getSdSchruleByIdSch(String id_sch) throws BizException;

	/**
	 * 根据排班id 判断排班有没有被使用
	 * 
	 * @param id_sch 排班id
	 * @throws BizException
	 */
	void valSchHaveUsed(String id_sch) throws BizException;

	/**
	 * 根据排班分类查询有排班的科室
	 * 
	 * @param sctp 排班类型分类
	 * @return list 有排班科室信息
	 * @throws BizException
	 */
	List<DeptDO> getHaveSchDept(String sctp, FBoolean fg_active) throws BizException;

	/**
	 * 获取号源池数根据排班id和渠道编码
	 * 
	 * @param sd_scchltp 渠道编码
	 * @param id_sch 排班id
	 * @return 号源池数
	 * @throws BizException
	 */
	Integer getScpolcnByIdAndSdBp(String sd_scchltp, String id_sch) throws BizException;

	/**
	 * 获取排班服务价格
	 * 
	 * @param scSrvIds 排班服务id数组
	 * @return 价格Map,Key: 排班服务ID,Value:价格
	 * @throws BizException
	 * @author yank
	 */
	Map<String, FDouble> getScSrvPrice(String[] scSrvIds) throws BizException;

	/**
	 * 获取医技排班树
	 * 
	 * @return SchMtPlDTO arrays
	 * @throws BizException
	 */
	SchMtPlDTO[] getMtSchPlanSchMtPlDTOs() throws BizException;

	/**
	 * 根据类型求对应日历的节点日在对应的日期区间内
	 * 
	 * @param sctp 排班类型
	 * @param begin_date 开始日期
	 * @param end_date 结束日期
	 * @return 节假日arrays
	 * @throws BizException
	 */
	String[] getHolidayArrayByScTp(String sctp, String begin_date, String end_date) throws BizException;

	/**
	 * 判断日历在对应的排班区间内是否存在
	 * 
	 * @param begin_date 开始日期
	 * @param end_date 结束日期
	 * @throws BizException 不存在抛出相应信息
	 */
	void valCalendarExByDateInterval(String begin_date, String end_date,String sd_sctp) throws BizException;

	/**
	 * 获取医技排班树
	 * 
	 * @return
	 * @throws BizException
	 */
	MtSchTreeDTO[] getMtSchTree(String beanType) throws BizException;

	/**
	 * 查找周对应的周计划
	 * 
	 * @param idx_week
	 * @return
	 * @throws BizException
	 */
	MtSchDTO[] getMtSchPlWks(String scplId, Integer idx_week) throws BizException;

	/**
	 * 医技排班管理扼要信息
	 * 
	 * @param dt_b 开始时间
	 * @param dt_e 结束时间
	 * @param depId 部门id
	 * @param scresId 资源id
	 * @param srvId 服务id
	 * @return
	 * @throws BizException
	 */
	MtSchMgrDTO[] getSchMgrBrief(FDate dt_b, FDate dt_e, String depId, String scresId, String srvId,String sd_sctp,String loadType)
			throws BizException;
	/**
	 * 获取单个医技排班所有扼要信息
	 * @param depId
	 * @param scresId
	 * @param srvId
	 * @param sd_sctp
	 * @return
	 * @throws BizException
	 */
	MtSchMgrDTO[] getAllSchMgrBrief4Single(String depId, String scresId, String srvId,String sd_sctp) throws BizException;
	/**
	 * 医技排班管理详细信息
	 * 
	 * @param mtSchMgrDTO
	 * @return
	 * @throws BizException
	 */
	MtSchDetailDTO getSchMgrDetail(MtSchDetailDTO mtSchMgrDTO) throws BizException;
		
	/**
	 * 批量处理：获取查询条件下的排班
	 * @param schQryDTO
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<SchInfoDTO> getSchInfo(SchQryDTO schQryDTO, PaginationInfo pageInfo) throws BizException;
	
	// =====================口腔=============================//
	/**
	 * 获取医技卡片显示服务
	 * 
	 * @param sd_md 票号模式
	 * @param id_sch 排班id
	 * @param srvName 排班服务名称
	 * @return
	 * @throws BizException
	 */
	String getMtSchCardSrv(String sd_md, String id_sch, String srvName) throws BizException;

	/**
	 * 根据当前科室查询科室下所有病区的人员（护士），包括人员部门关系中符合的人员
	 * 
	 * @param id_dep 当前科室
	 * @return 人员（护士）的In查询条件
	 * @throws BizException
	 * @author zhengcm
	 */
	String getPsnInCondByDep(String id_dep) throws BizException;

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
	FArrayList getOralSch(String id_dep, String dt_begin, String dt_end, String name_room) throws BizException;

	/**
	 * 根据排班计划获取口腔科周计划的号位和渠道数据
	 * 
	 * @param id_scpl 排班计划id
	 * @return 口腔科排班信息DTO的Map,Key为日期分组id
	 * @throws BizException
	 * @author zhengcm
	 */
	FMap getOralSelectedSchPlan(String id_scpl) throws BizException;

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
	boolean isOralSchQuecnCanSub(String depId, String schId, String dayslotId) throws BizException;

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
	SchOralInfoDTO[] getOralSchList(String id_dep, String dt_begin, String dt_end, String name_room)
			throws BizException;

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
	SchOralInfoDTO[] getOralSchListWithVer(String id_dep, String dt_begin, String dt_end, String name_room,
			String paramId) throws BizException;

	/**
	 * 获取口腔排班信息，含号位、渠道信息
	 * 
	 * @param schId 排班ID
	 * @return
	 * @throws BizException
	 */
	SchOralInfoDTO getOralSchDetail(String schId) throws BizException;
	/**
	 * 批量获取口腔排班信息，含号位、渠道信息
	 * 
	 * @param schId 排班ID
	 * @return
	 * @throws BizException
	 */
	 SchOralInfoDTO[] getOralSchsDetail(SchOralInfoDTO[] orals) throws BizException;
		
	/**
	 * 检查在同一天同一午别是否已经排班
	 * 
	 * @param schId 排班ID
	 * @param date 日期
	 * @param dayslotId 午别ID
	 * @return
	 * @throws BizException
	 */
	boolean checkHasSch(String schId, FDate date, String dayslotId) throws BizException;

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
	boolean canCopyConver(String deptId, FMap siteSchMap, FDate beginDate, FDate endDate) throws BizException;

	/**
	 * 获取符合条件的科室参数id，供参照使用
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @param name_room
	 * @return
	 * @throws BizException
	 */
	FArrayList getDepParamIdList(String dt_begin, String dt_end, String name_room) throws BizException;

	/**
	 * 获取门诊排班停诊排班信息
	 * 
	 * @author zhengcm
	 * @date 2017-11-16 19:33:43
	 *
	 * @param id_sch 排班ID
	 * @return
	 * @throws BizException
	 */
	public SchCancDTO getOpSchCancInfo(String id_sch) throws BizException;

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
	public SchCancDTO[] getOpSchCancAptInfo(String id_sch, FBoolean isShowCancel) throws BizException;

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
	public SchCancDTO[] getOpSchCancDeptSchInfo(String id_dept, String id_sch, FDate d_sch, FBoolean fg_origin_scres,
			FBoolean fg_origin_scsrv) throws BizException;
	/**
	 * 校验号位状态
	 * @throws BizException 
	 */
    boolean validateTickIsUsed(String tickId) throws BizException;
    
    /**
	 * 排班是否被使用
	 * @param schId
	 * @return
	 * @throws BizException
	 */
	 boolean validateIsSchUsed(String schId) throws BizException;
	 
	 /**
	  * 查询计划名称
	  * @return
	  * @throws BizException
	  */
	 MtSchDTO[]  getMtSchPlName( MtSchDTO[] mtschDTOs) throws BizException;
	 
	 /**
	  * 获取停诊排班下需要取消预约的记录
	  * @param schId
	  * @return
	  * @throws BizException
	  */
	 OpAptDTO[] getCancAptByStopSch(String schId) throws BizException;
}