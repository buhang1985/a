package iih.ci.mb.i;

import xap.mw.core.data.BizException;

/**
 * 移动医生站查询服务
 * @author yankan
 * @since 2018-03-12
 *
 */
public interface ICiMbQueryService {
	/**
	 * 获取科室医生列表
	 * @param deptId 科室ID
	 * @return 医生信息集合
	 * @throws BizException
	 * @author yankan
	 */
	public abstract GetDoctorOfDepartmentResponse getDeptDoctors(String deptId) throws BizException;
	/**
	 * 获取病区科室
	 * @param deptId 科室ID
	 * @return 科室
	 * @throws BizException
	 * @author yankan
	 */
	public abstract GetDepartmentCareLevelCountOfDeptResponse getWardOrDept(String deptID) throws BizException;
	/**
	 * 获取科室在院患者
	 * @param deptId 科室ID
	 * @return
	 * @throws BizException
	 * @author yankan
	 */
	public abstract GetPatientHROfDepartmentResponse getDeptIpPatList(String deptId) throws BizException;
	/**
	 * 获取患者历史住院记录
	 * @param patId 患者ID
	 * @return 住院记录集合
	 * @throws BizException
	 * @author yankan
	 */
	public abstract GetPatientHistoryHRByIDResponse getPatIpHistory(String patId) throws BizException;	 
	/**
	 * 获取患者医嘱列表
	 * 
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 * @author yankan
	 */
	public abstract GetDoctorAdviceOfPatientHRResponse getPatIpOrdList(String entId) throws BizException;
	/**
	 * 获取患者住院检查列表
	 * @param patId 患者ID
	 * @param ipTimes 住院次数
	 * @return 检查集合
	 * @throws BizException
	 * @author yankan
	 */
	public abstract GetCheckUrlOfPatientHRResponse getPatIpObsList(String patId,String ipTimes) throws BizException;

	/**
	 * 获取患者住院检验列表
	 * @param entID 就诊ID
	 * @return 住院检验集合
	 * @throws BizException
	 * @author yankan
	 */
	public abstract GetTestOfPatientHRResponse getPatIpLabList(String entId) throws BizException;	
	/**
	 * 获取患者住院病历列表
	 * @param patId 患者ID
	 * @param ipTimes 住院次数
	 * @return 住院病历集合
	 * @throws BizException
	 * @author yankan
	 */
	public abstract GetMedicalRecordsOfPatientHRResponse getPatIpMrList(String patId,String ipTimes) throws BizException;
	
	/**
	 * 获取体温单数据集
	 * @param request 请求参数
	 * @return 体温单数据集
	 * @throws BizException
	 * @author wangwei
	 */
	public abstract GetNursingRecordOfPatientHRResponse getNursingRecordOfPatientHR(GetNursingRecordOfPatientHRRequest request) throws BizException;
	/**
	 * 获取备忘录列表
	 * @param request 请求参数
	 * @return 备忘录列表
	 * @throws BizException
	 * @author wangwei
	 */
	public abstract GetDoctorMemorandumListResponse getDoctorMemorandumList(GetDoctorMemorandumListRequest request) throws BizException;
	/**
	 * 保存备忘录
	 * @param request 请求参数
	 * @return 保存状态
	 * @throws BizException
	 * @author wangwei
	 */
	public abstract SaveDoctorMemorandumResponse saveDoctorMemorandum(SaveDoctorMemorandumRequest request) throws BizException;
	/**
	 * 删除一个备忘录
	 * @param request 请求参数
	 * @return 执行状态
	 * @throws BizException
	 * @author wangwei
	 */
	public abstract DelDoctorMemorandumResponse delDoctorMemorandum(DelDoctorMemorandumRequest request) throws BizException;

	public abstract GetNursingDocumentsOfPatientHRResponse getNurNmrList(String patientHRID, String subID)
			throws BizException;
	
	/**
	 * 获取患者体温单自定义项目列表
	 * 
	 * @param p_id患者id
	 * @param visit_id在院次数
	 * @return
	 * @throws BizException
	 */
	public abstract GetZdTemperatureDisplayColumnResponse getZDTemperatureDisplayColumn(String p_id, String visit_id) throws BizException;
}
