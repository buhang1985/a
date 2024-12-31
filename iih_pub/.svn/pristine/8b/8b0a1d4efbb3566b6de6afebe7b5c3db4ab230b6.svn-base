package iih.mbh.nm.i;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import iih.mbh.nm.nhrexpscheddto.d.NhrExpSchedDTO;
import iih.mbh.nm.nhroverworkdto.d.NhrOverWorkDTO;
import iih.mbh.nm.nhrscheddata.d.NhrSchedDTO;
import iih.mbh.nm.nhrscheddata.d.NhrWeekSchedDTO;
import iih.mbh.nm.nhrschedlvdto.d.NhrSchedLvDTO;
import iih.mbh.nm.nhrschedrpdto.d.NhrSchedRpDTO;
import iih.mbh.nm.nhrsidto.d.NhrSiDTO;
import iih.mbh.nm.nurgrp.d.NurGrpDTO;
import iih.mbh.nm.nurgrp.d.NurGrpPsnDTO;
import xap.mw.core.data.BizException;

@WebService
public interface IMbhNmMaintanceService {
	/**
	 * 人员排班保存
	 * 
	 * @param weekSchedDTO
	 * @return
	 * @throws BizException
	 */
	public abstract boolean saveDepPsnSched(@WebParam(name = "weekSchedDTO") NhrWeekSchedDTO weekSchedDTO) throws BizException;

	/**
	 * 护士请假保存
	 * 
	 * @param schedLvDTO
	 * @return
	 * @throws BizException
	 */
	public abstract NhrSchedLvDTO savePsnSchedLv(@WebParam(name = "schedLvDTO") NhrSchedLvDTO schedLvDTO) throws BizException;

	/**
	 * 期望排班保存
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @param expSchedDTO
	 * @return
	 * @throws BizException
	 */
	public abstract boolean savePsnExpSched(@WebParam(name = "dt_begin") String dt_begin, @WebParam(name = "dt_end") String dt_end, @WebParam(name = "expSchedDTO") NhrExpSchedDTO expSchedDTO) throws BizException;

	/**
	 * 班次信息保存
	 * 
	 * @author guo.xiao
	 * @param nhrSiDto
	 * @return
	 * @throws BizException
	 */
	public abstract NhrSiDTO saveNhrSiData(@WebParam(name = "nhrSiDto") NhrSiDTO nhrSiDto) throws BizException;

	/**
	 * 加班申请保存
	 * 
	 * @author guo.xiao
	 * @param nhrOverWorkDTO
	 * @return
	 * @throws BizException
	 */
	public abstract NhrOverWorkDTO saveNhrOverWorkData(@WebParam(name = "nhrOverWorkDTO") NhrOverWorkDTO nhrOverWorkDTO) throws BizException;

	/**
	 * 替班申请保存
	 * 
	 * @author guo.xiao
	 * @param nhrSchedRpDTO
	 * @return
	 * @throws BizException
	 */
	public abstract NhrSchedRpDTO saveNhrSchedRpData(@WebParam(name = "nhrSchedRpDTO") NhrSchedRpDTO nhrSchedRpDTO) throws BizException;

	/**
	 * 保存班次排序
	 * 
	 * @author guo.xiao
	 * @param nhrSiList
	 * @return
	 * @throws BizException
	 */
	public abstract boolean saveNhrSiSort(@WebParam(name = "nhrSiList") List<NhrSiDTO> nhrSiList) throws BizException;

	/**
	 * 保存排班分组
	 * 
	 * @param nurGrpDTO
	 * @return
	 * @throws BizException
	 */
	public abstract boolean saveSiGrp(@WebParam(name = "nurGrpDTO") NurGrpDTO nurGrpDTO) throws BizException;

	/**
	 * 保存排班分组人员
	 * @param grpPsnList
	 * @param id_dep
	 * @param dt_week 周一日期
	 * @return
	 * @throws BizException
	 */
	// 保存排班分组人员
	public abstract boolean saveSiNurGrp(@WebParam(name="grpPsnList") List<NurGrpPsnDTO> grpPsnList, @WebParam(name="id_dep") String id_dep, @WebParam(name="dt_week") String dt_week) throws BizException;


	/**
	 * 保存管床信息
	 * 
	 * @param schedDTO
	 * @return
	 * @throws BizException
	 */
	public abstract boolean saveTubeBedInfo(@WebParam(name = "schedDTO") NhrSchedDTO schedDTO) throws BizException;

	/**
	 * 保存排班分组人员排序
	 * 
	 * @param grpList
	 * @return
	 * @throws BizException
	 */
	public abstract boolean saveGrpPsnSort(@WebParam(name = "grpList") List<NurGrpDTO> grpList) throws BizException;

	/**
	 * 一键清空科室周排班
	 * 
	 * @param id_dep
	 * @param dt_monday
	 * @return
	 * @throws BizException
	 */
	public abstract boolean delDepWeekSched(@WebParam(name = "id_dep") String id_dep, @WebParam(name = "dt_monday") String dt_monday) throws BizException;

	/**
	 * 单据（加班overWork、调班schedRp、请假schedLv）提交
	 * 
	 * @param id_bill
	 * @param flowtype
	 * @throws BizException
	 */
	public abstract boolean billSubmit(@WebParam(name = "id_bill") String id_bill, @WebParam(name = "flowtype") String flowtype) throws BizException;

	/**
	 * 单据（加班overWork、调班schedRp、请假schedLv）撤回
	 * 
	 * @param id_bill
	 * @param flowtype
	 * @throws BizException
	 */
	public abstract boolean billBack(@WebParam(name = "id_bill") String id_bill, @WebParam(name = "flowtype") String flowtype) throws BizException;

	/**
	 * 单据（加班overWork、调班schedRp、请假schedLv）通过
	 * 
	 * @param id_bill
	 * @param flowtype
	 * @throws BizException
	 */
	public abstract boolean billAccept(@WebParam(name = "id_bill") String id_bill, @WebParam(name = "flowtype") String flowtype, @WebParam(name = "opinion") String opinion) throws BizException;

	/**
	 * 单据（加班overWork、调班schedRp、请假schedLv）驳回
	 * 
	 * @param id_bill
	 * @param flowtype
	 * @throws BizException
	 */
	public abstract boolean billReject(@WebParam(name = "id_bill") String id_bill, @WebParam(name = "flowtype") String flowtype, @WebParam(name = "opinion") String opinion) throws BizException;

	/**
	 * 保存登录用户手机设备信息 
	 * @param id_psndoc
	 * @param target 推送设备标识
	 * @param phoneBrand 手机品牌
	 * @throws BizException
	 */
	public abstract void saveUserPhoneInfo(@WebParam(name="id_psndoc") String id_psndoc, @WebParam(name="target") String target, @WebParam(name="phoneBrand") String phoneBrand) throws BizException;

}
