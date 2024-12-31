package iih.mbh.en.i;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import iih.mbh.en.entry.d.BizGrpEmpDTO;
import iih.mbh.en.entry.d.PatWatEntryDTO;
import iih.mbh.en.patinfo.d.DrPatInfoDTO;
import iih.mbh.en.patinfo.d.PatGrpInfoDTO;
import iih.mbh.en.patinfo.d.PatientDTO;
import iih.mbh.en.patinfo.d.PatientVitalSign;
import iih.mbh.en.transin.d.PatTransInApplyDTO;
import iih.mbh.en.transin.d.TransDeptOrderDTO;
import iih.mbh.en.transout.d.PatWatLevHosDTO;
import iih.mbh.sys.appdto.d.AppMenuParamDTO;
import iih.mbh.sys.psnfunc.d.ReferenceQryDTO;
import xap.mw.core.data.BizException;

@WebService
public interface IMbhEnQueryService {

	public abstract List<PatientDTO> getWardPatients(@WebParam(name = "id_dep_nur") String id_dep_nur, @WebParam(name = "params") List<AppMenuParamDTO> params) throws BizException;

	public abstract PatientVitalSign getPatientVitalsign(@WebParam(name = "id_ent") String id_ent) throws BizException;

	public abstract List<PatGrpInfoDTO> getPatBaseInfo(@WebParam(name = "id_ent") String id_ent) throws BizException;

	/**
	 * 获取待入科患者信息
	 * 
	 * @param dept_code
	 * @param ward_code
	 * @return
	 * @throws BizException
	 */
	public abstract List<PatWatEntryDTO> getPatientInfoWaitEnterDept(@WebParam(name = "dept_code") String dept_code, @WebParam(name = "ward_code") String ward_code) throws BizException;

	/**
	 * 转科转入申请
	 * 
	 * @param id_dep_nur
	 * @return
	 * @throws BizException
	 */
	public abstract List<PatTransInApplyDTO> getPatientTransInApply(@WebParam(name = "id_dep_nur") String id_dep_nur) throws BizException;

	/**
	 * 查询待出院患者
	 * 
	 * @param deptCode
	 * @param id_dep_nur
	 * @param transOrOut
	 * @return
	 * @throws BizException
	 */
	public abstract List<PatWatLevHosDTO> getPatWatTranOut(@WebParam(name = "deptCode") String deptCode, @WebParam(name = "id_dep_nur") String id_dep_nur, @WebParam(name = "transOrOut") String transOrOut) throws BizException;

	/**
	 * 获取空闲床位
	 * 
	 * @param id_dep_nur
	 * @param id_ent
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public abstract List<ReferenceQryDTO> getFreeBedInfo(@WebParam(name = "id_dep_nur") String id_dep_nur, @WebParam(name = "id_ent") String id_ent) throws BizException;

	/**
	 * 获取医疗组信息
	 * 
	 * @param id_dep_nur
	 * @param fg_wg
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public abstract List<ReferenceQryDTO> getMedicalGroupInfo(@WebParam(name = "id_dep_nur") String id_dep_nur, @WebParam(name = "fg_wg") boolean fg_wg, @WebParam(name = "id_ent") String id_ent,@WebParam(name = "type") int type) throws BizException;

	/**
	 * 获取人员信息
	 * 
	 * @param id_dep_nur
	 * @param id_wg
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public abstract List<ReferenceQryDTO> getDoctorInfo(@WebParam(name = "id_ent") String id_ent, @WebParam(name = "id_dep_nur") String id_dep_nur, @WebParam(name = "id_wg") String id_wg, @WebParam(name = "fg_doctor") boolean fg_doctor, @WebParam(name = "type") int type) throws BizException;

	/**
	 * 获取转科医嘱信息
	 * 
	 * @param id_dep_nur
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract List<TransDeptOrderDTO> getTransDeptOrderInfo(@WebParam(name = "id_dep_nur") String id_dep_nur, @WebParam(name = "id_ent") String id_ent) throws BizException;

	/**
	 * 获取门诊患者列表
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract List<PatientDTO> getOpPatients() throws BizException;

	/**
	 * 获取患者列表（医生站）
	 * 
	 * @param id_dep_phy
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract List<DrPatInfoDTO> getDrPatnfos(@WebParam(name = "params") List<AppMenuParamDTO> params) throws BizException;

	/**
	 * 获取医疗组成员上下级信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract List<BizGrpEmpDTO> getBizGrpEmps(@WebParam(name = "param") BizGrpEmpDTO param) throws BizException;
}
