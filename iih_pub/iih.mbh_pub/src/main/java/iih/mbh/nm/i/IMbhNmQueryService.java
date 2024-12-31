package iih.mbh.nm.i;

import iih.mbh.nm.depnur.d.NbdDepCaDTO;
import iih.mbh.nm.nhrexpscheddto.d.NhrExpSchedDTO;
import iih.mbh.nm.nhrflowdata.d.NmTaskInsDTO;
import iih.mbh.nm.nhrflowdata.d.PagingRtnDataDTO;
import iih.mbh.nm.nhroverworkdto.d.NhrOverWorkDTO;
import iih.mbh.nm.nhrscheddata.d.NhrSchedDTO;
import iih.mbh.nm.nhrscheddata.d.NhrWeekSchedDTO;
import iih.mbh.nm.nhrschedlvdto.d.NhrSchedLvDTO;
import iih.mbh.nm.nhrschedrpdto.d.NhrSchedRpDTO;
import iih.mbh.nm.nhrsidto.d.NhrSiBedDTO;
import iih.mbh.nm.nhrsidto.d.NhrSiDTO;
import iih.mbh.nm.nmchkform.d.NmChkFormDTO;
import iih.mbh.nm.nmdepinfo.d.NmDepInfoDTO;
import iih.mbh.nm.nmnurinfo.d.NmNurInfoDTO;
import iih.mbh.nm.nmpatinfo.d.NmPatDTO;
import iih.mbh.nm.nmqctaskinfo.d.NmQcTaskInfoDTO;
import iih.mbh.nm.nmstatis.d.NmPsnStatisDTO;
import iih.mbh.nm.nmstatis.d.NmPsnStatisSiDTO;
import iih.mbh.nm.nmudidoc.d.NmUdiDocDTO;
import iih.mbh.nm.nurgrp.d.NurGrpDTO;
import iih.mbh.nm.nurgrp.d.NurGrpPsnDTO;
import iih.mbh.nm.paginationinfo.d.PaginationInfoDTO;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import xap.mw.core.data.BizException;

/**
 * 护理管理——ipad端服务接口
 * 
 * @author lijm
 *
 */
@WebService
public interface IMbhNmQueryService {

	/**
	 * 获取给定科室住院患者列表
	 * 
	 * @param id_dep_nur
	 * @return
	 * @throws BizException
	 */
	public abstract List<NmPatDTO> getIpPatList(@WebParam(name = "id_dep_nur") String id_dep_nur) throws BizException;

	/**
	 * 根据护理人员获取未完成的检查任务
	 * 
	 * @param id_nur护理人员id
	 * @param is_done是否完成
	 * @return
	 * @throws BizException
	 */
	public abstract List<NmQcTaskInfoDTO> getUnDoneQcTaskList(@WebParam(name = "id_nur") String id_nur) throws BizException;

	/**
	 * 根据护理人员获取已完成的检查任务
	 * 
	 * @param id_nur护理人员id
	 * @param is_done是否完成
	 * @return
	 * @throws BizException
	 */
	public abstract List<NmQcTaskInfoDTO> getDoneQcTaskList(@WebParam(name = "id_nur") String id_nur) throws BizException;

	/**
	 * 获取科室列表信息
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract List<NmDepInfoDTO> getNurDepList() throws BizException;

	/**
	 * 获取检查表单模板结构
	 * 
	 * @param id_nqm_cs
	 * @return
	 * @throws BizException
	 */
	public abstract NmChkFormDTO getCsTmplForm(@WebParam(name = "id_nqm_cs") String id_nqm_cs) throws BizException;

	/**
	 * 获取质量检查记录
	 * 
	 * @param id_nqm_cs
	 * @param id_nqm_chk
	 * @return
	 * @throws BizException
	 */
	public abstract List<NmChkFormDTO> getQchkRec(@WebParam(name = "id_nqm_cs") String id_nqm_cs, @WebParam(name = "id_nqm_chk") String id_nqm_chk) throws BizException;

	/**
	 * 获取指定时间段内个人排班数据
	 * 
	 * @param id_psndoc
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract List<NhrWeekSchedDTO> getPersonSchedInDate(@WebParam(name = "id_dep") String id_dep, @WebParam(name = "id_nur") String id_nur, @WebParam(name = "dt_begin") String dt_begin, @WebParam(name = "dt_end") String dt_end) throws BizException;

	/**
	 * 获取指定科室指定周排班数据
	 * 
	 * @param id_dep_nur
	 * @param dt_begin
	 * @return
	 * @throws BizException
	 */
	public abstract NhrWeekSchedDTO getDepPsnSched(@WebParam(name = "id_dep") String id_dep, @WebParam(name = "dt_begin") String dt_begin) throws BizException;

	/**
	 * 获取护理单元分类及分类下护理单元
	 * 
	 * @author guo.xiao
	 * @return
	 * @throws BizException
	 */
	public abstract List<NbdDepCaDTO> getDepCaAndNur() throws BizException;

	/**
	 * 获取指定日期下的排班数据(id_nur不为空指定人）
	 * 
	 * @param id_nur
	 * @param dt_day
	 * @return
	 * @throws BizException
	 */
	public abstract List<NhrSchedDTO> getPersonDaySched(@WebParam(name = "id_dep") String id_dep, @WebParam(name = "id_nur") String id_nur, @WebParam(name = "dt_day") String dt_day) throws BizException;

	/**
	 * 获取指定科室指定周排班分组人员数据
	 * 
	 * @param id_dep_nur
	 * @param dt_monday
	 * @return
	 * @throws BizException
	 */
	public abstract List<NurGrpDTO> getSchedNurGrp(@WebParam(name = "id_dep") String id_dep, @WebParam(name = "dt_monday") String dt_monday) throws BizException;

	/**
	 * 获取当前科室下班次集合（包含全院班次）
	 * 
	 * @author guo.xiao
	 * @param id_dep_nur
	 * @return
	 * @throws BizException
	 */
	public abstract List<NhrSiDTO> getCurrDepSiList(@WebParam(name = "id_dep") String id_dep, @WebParam(name = "is_define") boolean is_define) throws BizException;

	/**
	 * 获取给定护理单元请假类型(假别类班次)
	 * 
	 * @param id_dep_nur
	 * @return
	 * @throws BizException
	 */
	public abstract List<NhrSiDTO> getSchedLvSiList(@WebParam(name="id_dep") String id_dep) throws BizException;

	/**
	 * 获取护理替班申请列表
	 * 
	 * @author guo.xiao
	 * @param id_psndoc
	 * @return
	 * @throws BizException
	 */
	public abstract List<NhrSchedRpDTO> getNmSchedRpList(@WebParam(name = "id_nur_apy") String id_nur_apy) throws BizException;

	/**
	 * 获取护士请假列表
	 * 
	 * @param id_nur_apy
	 * @return
	 * @throws BizException
	 */
	public abstract List<NhrSchedLvDTO> GetPsnSchedLvList(@WebParam(name = "id_nur_apy") String id_nur_apy) throws BizException;

	/**
	 * 获取护士期望排班
	 * 
	 * @param id_nur
	 * @param id_dep_nur
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract List<NhrExpSchedDTO> getPsnExpSchedList(@WebParam(name="id_nur") String id_nur, @WebParam(name="id_dep") String id_dep, @WebParam(name="dt_begin") String dt_begin, @WebParam(name="dt_end") String dt_end) throws BizException;


	/**
	 * 获取护理加班申请列表
	 * 
	 * @author guo.xiao
	 * @param id_nur
	 * @return
	 * @throws BizException
	 */
	public abstract List<NhrOverWorkDTO> getOverWorkList(@WebParam(name = "id_nur") String id_nur) throws BizException;

	/**
	 * 获取当前科室下所有床位
	 * 
	 * @author guo.xiao
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public abstract List<NhrSiBedDTO> getCurrDepBedList(@WebParam(name = "id_dep") String id_dep) throws BizException;

	/**
	 * 获取班次分类
	 * 
	 * @author guo.xiao
	 * @return
	 * @throws BizException
	 */
	public abstract List<NmUdiDocDTO> getNhrSiCaList() throws BizException;

	/**
	 * 获取用户护理属性信息
	 * 
	 * @param id_psndoc
	 * @return
	 * @throws BizException
	 */
	public abstract NmNurInfoDTO getUserNurInfo(@WebParam(name = "id_psndoc") String id_psndoc) throws BizException;

	/**
	 * 获取个人考勤数据
	 * 
	 * @author guo.xiao
	 * @param id_nur
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract NmPsnStatisDTO getPsnAttendData(@WebParam(name = "id_nur") String id_nur, @WebParam(name = "dt_begin") String dt_begin, @WebParam(name = "dt_end") String dt_end) throws BizException;

	/**
	 * 获取指定护理单元，时间段内护理人员工时数
	 * 
	 * @param id_dep
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract List<NmPsnStatisDTO> getNurDepLaborHours(@WebParam(name = "id_dep") String id_dep, @WebParam(name = "dt_begin") String dt_begin, @WebParam(name = "dt_end") String dt_end) throws BizException;

	/**
	 * 获取指定护理单元，时间段内护理人员排班数据
	 * 
	 * @param id_dep
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract List<NmPsnStatisSiDTO> getNurDepSiData(@WebParam(name = "id_dep") String id_dep, @WebParam(name = "dt_begin") String dt_begin, @WebParam(name = "dt_end") String dt_end) throws BizException;

	/**
	 * 获取指定护理单元，时间段内护理人员加班数据
	 * 
	 * @author guo.xiao
	 * @param id_dep
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract List<NmPsnStatisDTO> getNurDepOverHours(@WebParam(name="id_dep") String id_dep, @WebParam(name="dt_begin") String dt_begin, @WebParam(name="dt_end") String dt_end) throws BizException;

	/**
	 * 获取当前科室护理人员
	 * 
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public abstract List<NurGrpPsnDTO> getDepNur(@WebParam(name = "id_dep") String id_dep) throws BizException;

	/**
	 * 查询管床信息
	 * 
	 * @param id_dep
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract List<NhrSchedDTO> getTubeBedInfo(@WebParam(name = "id_dep") String id_dep, @WebParam(name = "dt_begin") String dt_begin, @WebParam(name = "dt_end") String dt_end) throws BizException;

	/**
	 * 分页获取指定人员加班申请数据（待提交(ToDo),、审核中(Run)、已审核(End)）
	 * 
	 * @param id_psndoc
	 * @param status_proins
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnDataDTO getOverWorkBillByPsndocId(@WebParam(name = "id_psndoc") String id_psndoc, @WebParam(name = "status_proins") String status_proins, @WebParam(name = "pg") PaginationInfoDTO pg) throws BizException;

	/**
	 * 分页获取指定人员调班申请数据（待提交(ToDo),、审核中(Run)、已审核(End)）
	 * 
	 * @param id_psndoc
	 * @param status_proins
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnDataDTO getSchedRpBillByPsndocId(@WebParam(name = "id_psndoc") String id_psndoc, @WebParam(name = "status_proins") String status_proins, @WebParam(name = "pg") PaginationInfoDTO pg) throws BizException;

	/**
	 * 分页获取指定人员加班请假数据（待提交(ToDo),、审核中(Run)、已审核(End)）
	 * 
	 * @param id_psndoc
	 * @param status_proins
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnDataDTO getSchedLvBillByPsndocId(@WebParam(name = "id_psndoc") String id_psndoc, @WebParam(name = "status_proins") String status_proins, @WebParam(name = "pg") PaginationInfoDTO pg) throws BizException;

	/**
	 * 获取给定用户审批任务数据
	 * @param id_user
	 * @param fg_done
	 * @param pg
	 * @param applicatype 申请单据类型（全部 0，加班 1，替班 2，请假 3）
	 * @param dt_begin （每月第一天）
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnDataDTO getTasksByUserId(@WebParam(name="id_user") String id_user, @WebParam(name="fg_done") boolean fg_done, @WebParam(name="pg") PaginationInfoDTO pg, @WebParam(name="applicatype") int applicatype, @WebParam(name="dt_begin") String dt_begin) throws BizException;

	/**
	 * 获取单据审核进度（任务）
	 * 
	 * @param id_pk(申请单据主键)
	 * @return
	 * @throws BizException
	 */
	public abstract List<NmTaskInsDTO> getProInsProgressByTaskId(@WebParam(name="id_pk") String id_pk) throws BizException;

}
