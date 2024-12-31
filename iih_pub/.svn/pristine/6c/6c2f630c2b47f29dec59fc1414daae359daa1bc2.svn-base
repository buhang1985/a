package iih.mp.mb;

import iih.mp.mb.i.ConvertBarcodeRequest;
import iih.mp.mb.i.ConvertBarcodeResponse;
import iih.mp.mb.i.GetAllDayListOfPatientHRResponse;
import iih.mp.mb.i.GetAllInHosDepartmentResponse;
import iih.mp.mb.i.GetAllKeyBoardResponse;
import iih.mp.mb.i.GetAllPrintSplitDoctorAdviceOfPatientHRIDResponse;
import iih.mp.mb.i.GetAllTemplateResponse;
import iih.mp.mb.i.GetAllTourTypesResponse;
import iih.mp.mb.i.GetDCIpCgListByInccaItmResponse;
import iih.mp.mb.i.GetDCIpIncItmDayAmtsResponse;
import iih.mp.mb.i.GetDCIpIncItmInfoResponse;
import iih.mp.mb.i.GetDCMbUdidocResponse;
import iih.mp.mb.i.GetDCVisTimePointResponse;
import iih.mp.mb.i.GetDoctorAdviceOfPatientHRResponse;
import iih.mp.mb.i.GetDoctorAdviceStatusResponse;
import iih.mp.mb.i.GetJCTestOfPatientHRResponse;
import iih.mp.mb.i.GetNurseOfDepartmentResponse;
import iih.mp.mb.i.GetOneDayListOfPatientHRResponse;
import iih.mp.mb.i.GetOneTemplateResponse;
import iih.mp.mb.i.GetOrPlanInfoResponse;
import iih.mp.mb.i.GetOrderOccDetailInfoResponse;
import iih.mp.mb.i.GetPatientHROfDepartmentResponse;
import iih.mp.mb.i.GetPatientInfoByBarcodeResponse;
import iih.mp.mb.i.GetPatientNursingTourResponse;
import iih.mp.mb.i.GetPatientTodayInfusionTourResponse;
import iih.mp.mb.i.GetPeiAuditResponse;
import iih.mp.mb.i.GetPrepaymentDetailOfPatientHRResponse;
import iih.mp.mb.i.GetPrintSplitDoctorAdviceOfPatientHRRequest;
import iih.mp.mb.i.GetPrintSplitDoctorAdviceOfPatientHRResponse;
import iih.mp.mb.i.GetTemplateHistoryResponse;
import iih.mp.mb.i.GetTestInfomatonOfPatientHRResponse;
import iih.mp.mb.i.GetTestOfPatientHRResponse;
import iih.mp.mb.i.GetUnsettledCostDetailOfPatientHRResponse;
import iih.mp.mb.i.GetVitalSignOfPatientHRAtTimePointRequest;
import iih.mp.mb.i.GetVitalSignOfPatientHRAtTimePointResponse;
import iih.mp.mb.i.GetWardPeiAuditResponse;
import iih.mp.mb.i.GetYZOrderTypeResponse;
import iih.mp.mb.i.GetYjjAndFeeOfPatientHRResponse;
import iih.mp.mb.i.GetpdazdResponse;
import iih.mp.mb.i.NisGetOccDetailResponse;
import iih.mp.mb.i.PSMCanTansDeptResponse;
import iih.mp.mb.i.PSMGetDeptWardInfoResponse;
import iih.mp.mb.i.PSMGetDoctorsResponse;
import iih.mp.mb.i.PSMGetEmptyBedsResponse;
import iih.mp.mb.i.PSMGetMedicalGroupsResponse;
import iih.mp.mb.i.PSMGetNursesResponse;
import iih.mp.mb.i.PSMGetPatientsOfGetWaitEnterDeptResponse;
import iih.mp.mb.i.PSMPatientQueryTransDeptApplyResponse;
import iih.mp.mb.i.PSMQueryDischargerDiagnoseResponse;
import iih.mp.mb.i.PSMQueryTransDeptApplyResponse;
import iih.mp.mb.i.PSMQueryTransDeptOrderResponse;
import iih.mp.mb.i.PSMQueryWaitDischargerPatientsResponse;
import iih.mp.mb.i.ProcPdaPatientFeeDetailResponse;
import iih.mp.mb.i.QueryModifyOrderResponse;
import iih.mp.mb.i.TemchartResponse;
import iih.mp.mb.i.getChargeItemResponse;
import iih.mp.mb.i.getPatientChargeResponse;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.mb.i.GetValidDepartmentOfUserResponse;

public interface IMpMbQueryService {

	/**
	 * 获取用户访问科室权限
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract GetValidDepartmentOfUserResponse getValidDepartmentOfUser(String id_org, String code_user) throws BizException;

	/**
	 * 获取打印过的病人医嘱
	 * 
	 * @param patientHRID病人ID
	 * @param date日期
	 * @param flagflag为1
	 *            :输液,2:雾化,3:吸氧,4:血压,5:血糖,6:口服药,7:输血,8:皮试,9:母乳喂养输血暂时不用医嘱
	 * @param Deptid医嘱科室id
	 *            ,pc端
	 * @param times
	 * @return
	 * @throws BizException
	 */
	public abstract GetPrintSplitDoctorAdviceOfPatientHRResponse getPrintOrMpPlan(String patientHRID, String date, String flag, String Deptid, String times) throws BizException;

	/**
	 * 获取医嘱计划信息
	 */
	public abstract GetAllPrintSplitDoctorAdviceOfPatientHRIDResponse getOrderPlanInfo(String patientHRID, String plan_occ_time, String comb_no, String flag) throws BizException;

	/**
	 * 获取模板键盘
	 * 
	 * @param request模板
	 * 
	 * @return键盘实体数组
	 */
	public abstract GetAllKeyBoardResponse getAllKeyBoard(String TemplateID) throws BizException;

	/**
	 * 获取某一时刻患者体征信息--体温单
	 * 
	 * @param request
	 * @return体征记录列表
	 */
	public abstract GetVitalSignOfPatientHRAtTimePointResponse getVsInfoByEntAndVt(GetVitalSignOfPatientHRAtTimePointRequest request) throws BizException;

	/**
	 * 获取科室在院患者记录（单个）
	 * 
	 * @param departmentID科室标识ID
	 * @param HID患者住院号ID
	 * @return
	 * @throws BizException
	 */
	public abstract GetYjjAndFeeOfPatientHRResponse getPatientInquiries(String departmentID, String HID) throws BizException;

	/**
	 * 获取检验采集患者信息
	 * 
	 * @return
	 * @throws BizException
	 */
	public GetPatientInfoByBarcodeResponse getPatInfoBySample(String id_ent) throws BizException;

	/**
	 * 获取科室在院患者记录
	 * 
	 * @param departmentID科室标识ID
	 * @return
	 * @throws BizException
	 */
	public abstract GetPatientHROfDepartmentResponse getPatientRecord(String departmentID) throws BizException;

	/**
	 * 获取患者医嘱列表
	 * 
	 * @param id_pat患者id
	 * @param times_ip在院次数
	 * @return
	 * @throws BizException
	 */
	public abstract GetDoctorAdviceOfPatientHRResponse getDoctorAdviceOfPatient(String id_pat, String times_ip) throws BizException;

	/**
	 * 获取医嘱
	 * 
	 * @param request
	 * @return
	 * @throws BizException
	 */
	public abstract GetPrintSplitDoctorAdviceOfPatientHRResponse getPrintSplitDoctorAdviceOfPatientHR(GetPrintSplitDoctorAdviceOfPatientHRRequest request) throws BizException;

	/**
	 * 获取护理巡房类型
	 * 
	 * @throws BizException
	 */
	public abstract GetAllTourTypesResponse GetPatrolTypes() throws BizException;

	/**
	 * 获取单患者护理巡房记录
	 * 
	 * @param request
	 * @return
	 * @throws BizException
	 */
	public abstract GetPatientNursingTourResponse getPatientNursingTour(String code_amr_ip) throws BizException;

	/**
	 * 获取医嘱类型集合
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract GetYZOrderTypeResponse getOrderSrvtp() throws BizException;

	/**
	 * 条码内容转换
	 * 
	 * @param request
	 * @return
	 */
	public abstract ConvertBarcodeResponse convertBarcode(ConvertBarcodeRequest request) throws BizException;

	/**
	 * 根据条码获取医嘱状态
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract GetDoctorAdviceStatusResponse getOrderStatusByBarCode(String barCode) throws BizException;

	/**
	 * 获取输液巡视列表
	 * 
	 * @param id_ent
	 * @param id_sub
	 * @return
	 * @throws BizException
	 */
	public abstract GetPatientTodayInfusionTourResponse getInfusionPatrolList(String id_ent, String id_sub) throws BizException;

//	/**
//	 * 获取患者预交金明细
//	 * 
//	 * @param patientHRID
//	 *            就诊ID
//	 * @param visit_times
//	 *            就诊次数
//	 * @return
//	 * @throws BizException
//	 */
//	public abstract GetPrepaymentDetailOfPatientHRResponse getPatientPrepaymentDetail(String id_ent) throws BizException;

	/**
	 * 获取待入科的患者信息
	 * 
	 * @param deptCode科室
	 * @param wardCode病区
	 * @return
	 * @throws BizException
	 */
	public abstract PSMGetPatientsOfGetWaitEnterDeptResponse getPSMPatientInfo(String deptCode, String wardCode) throws BizException;

	/**
	 * 获取执行单类型
	 * 
	 * @param request
	 * @return
	 * @throws BizException
	 */
	public abstract GetpdazdResponse getExecListTp() throws BizException;

	/**
	 * 获取执行单明细
	 * 
	 * @param request
	 * @return
	 * @throws BizException
	 */
	public abstract NisGetOccDetailResponse getExecList(String id_ents, String dt_begn, String dt_end, String execTp, String id_emp_nur, String state) throws BizException;

//	/**
//	 * 获取费用信息
//	 * 
//	 * @param id_ent
//	 * @param visit_times
//	 * @return
//	 * @throws BizException
//	 */
//	public abstract GetUnsettledCostDetailOfPatientHRResponse getUnsettledCost(String id_ent, String visit_times) throws BizException;
//
//	/**
//	 * 获取费用明细
//	 * 
//	 * @param feeItemCode
//	 * @param id_ent
//	 * @return
//	 */
//	public abstract ProcPdaPatientFeeDetailResponse getPatientFeeDetail(String id_srv, String id_ent) throws BizException;

	/**
	 * 获取所有 科室
	 * 
	 * @param mode
	 *            :0 所有科室 1 科室 2 病区
	 * @return
	 * @throws BizException
	 */
	public abstract GetAllInHosDepartmentResponse getAlldep(int mode) throws BizException;

	/**
	 * 获取科室下所有用户
	 * 
	 * @param departmentID
	 * @return
	 */
	public abstract GetNurseOfDepartmentResponse getUserOfDep(String departmentID) throws BizException;

//	/**
//	 * 获取一日费用清单
//	 * 
//	 * @param id_ent
//	 * @param date
//	 * @return
//	 * @throws DAException
//	 */
//	public abstract GetOneDayListOfPatientHRResponse getIpdayfeedetail(String id_ent, String date) throws Exception;

	/**
	 * 查询医嘱执行明细
	 * 
	 * @param id_or_pr
	 * @return
	 * @throws BizException
	 */
	public abstract GetOrderOccDetailInfoResponse getOrderExecDeatil(String id_or_pr) throws BizException;

	/**
	 * 转科转入申请查询
	 * 
	 * @param wardCode
	 * @return
	 * @throws BizException
	 */
	public abstract PSMQueryTransDeptApplyResponse getTransferInApply(String wardCode) throws BizException;

	/**
	 * 获取空床位信息
	 * 
	 * @param deptCode科室ID
	 * @param wardCode病区ID
	 * @return
	 */
	public abstract PSMGetEmptyBedsResponse getPSMGetEmptyBeds(String Id_dept, String Id_ward, String Id_ent) throws BizException;

	/**
	 * 获取医生信息
	 * 
	 * @param deptCode科室ID
	 * @param wardCode病区ID
	 * @return
	 */
	public abstract PSMGetDoctorsResponse getPSMGetDoctors(String deptCode, String wardCode) throws BizException;

	/**
	 * 获取护士信息
	 * 
	 * @param deptCode
	 * @param wardCode
	 * @return
	 * @throws BizException
	 */
	public abstract PSMGetNursesResponse getPSMGetNurses(String deptCode, String wardCode) throws BizException;

	/**
	 * 获取医疗组
	 * 
	 * @param deptCode
	 * @param wardCode
	 * @return
	 */
	public abstract PSMGetMedicalGroupsResponse getPSMGetMedicalGroups(String deptCode, String wardCode, String Fg_pri) throws BizException;

	/**
	 * 根据医疗组获取医生
	 * 
	 * @param id_wg医疗组id
	 * @return
	 */
	public abstract PSMGetDoctorsResponse getPSMGetDoctorsByMedicalGroups(String id_wg) throws BizException;

	/**
	 * 医嘱变更
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract QueryModifyOrderResponse getQueryModifyOrder(String id_ent) throws BizException;

	/**
	 * 转科医嘱
	 * 
	 * @param code_dep_nur
	 * @param id_dep_nur
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract PSMQueryTransDeptOrderResponse getTransDeptOrder(String id_dep_phy, String id_dep_nur, String id_ent) throws BizException;

	/**
	 * 转科申请查询
	 * 
	 * @param code_dep_nur
	 * @param id_dep_nur
	 * @param id_ent
	 * @Param times_ip
	 * @return
	 * @throws BizException
	 */
	public abstract PSMPatientQueryTransDeptApplyResponse getTransDeptApply(String code_dep_nur, String id_dep_nur, String id_ent, Integer times_ip) throws BizException;

	/**
	 * 目标病区参照
	 * 
	 * @param code_dep_nur
	 * @param id_dep_nur
	 * @param executil
	 * @return
	 * @throws BizException
	 */
	public abstract PSMGetDeptWardInfoResponse getDeptWardInfo(String code_dep_nur, String id_dep_nur, String executil) throws BizException;

	/**
	 * 转科校验
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract PSMCanTansDeptResponse getCanTransOutPats(String id_ent) throws BizException;

	/**
	 * 
	 * 查询等待出科患者
	 * 
	 * @param deptCode
	 * @param string
	 * @param wardCode
	 * @return
	 * @throws BizException
	 */
	public abstract PSMQueryWaitDischargerPatientsResponse PSMQueryWaitDischargerPatients(String deptCode, String id_dep_nur, String transOrOut) throws BizException;

	/**
	 * 
	 * 查询出院患者诊断
	 * 
	 * @param encId
	 * @return
	 * @throws BizException
	 */
	public abstract PSMQueryDischargerDiagnoseResponse PSMQueryDischargerDiagnose(String id_ent) throws BizException;

	/**
	 * 获取移动护理医嘱状态字典
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract GetDCMbUdidocResponse getOrderStatusDic() throws BizException;

	/**
	 * 获取移动护理体征采集时间点(走参数计算)
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract GetDCVisTimePointResponse getTimeOfSign() throws BizException;

	/**
	 * 获取移动护理执行状态字典
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract GetDCMbUdidocResponse getExecStatusDic() throws BizException;

	/**
	 * 患者配药登记数据查询
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract GetPeiAuditResponse getPeiAuditInfo(String id_ent, String flag) throws BizException;

	/**
	 * 获取患者的文书列表
	 * 
	 * @param id_ent
	 * @return
	 */
	public abstract GetAllTemplateResponse getAllNurDocTmpl(String id_ent) throws BizException;

	/**
	 * 获取单个文书内容
	 * 
	 * @param patientID
	 * @param datetime
	 * @param nid
	 * @param nuserID
	 * @param templateID
	 * @param times
	 * @return
	 * @throws BizException
	 */
	public abstract GetOneTemplateResponse getNurDocContent(String patientID, String datetime, String nid, String nuserID, String templateID, String times) throws DAException, BizException;

	/**
	 * 查询文书的历史记录
	 * 
	 * @param patientID
	 * @param templateID
	 * @param reloadFlag
	 * @param times
	 * @return
	 * @throws BizException
	 */
	public abstract GetTemplateHistoryResponse getNmrHistory(String patientID, String templateID, Integer reloadFlag, String times) throws BizException;

	/**
	 * 获取检验列表
	 * 
	 * @param patientHRID
	 * @param subID
	 * @return
	 */
	public abstract GetTestOfPatientHRResponse getCirptlab(String patientHRID, String subID) throws BizException;

	/**
	 * 获取不执行原因字典
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract GetDCMbUdidocResponse getUnExecReason() throws BizException;

	/**
	 * 获取过敏严重程度字典
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract GetDCMbUdidocResponse getPatAldegDic() throws BizException;

	/**
	 * 获取检查列表
	 * 
	 * @param patientHRID
	 * @return
	 */
	public abstract GetJCTestOfPatientHRResponse getCiObslab(String id_ent) throws BizException;

	/**
	 * 获取检验标本信息
	 */
	public GetTestInfomatonOfPatientHRResponse getTestSampleList(String id_ent) throws BizException;

	/**
	 * 获取键盘自定义项目
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract GetVitalSignOfPatientHRAtTimePointResponse getCustomVsInfo() throws BizException;

//	/**
//	 * 获取住院每日记账金额之和
//	 * 
//	 * @param patientid
//	 * @return
//	 * @throws BizException
//	 */
//	public abstract GetAllDayListOfPatientHRResponse getIpDayAmtCgs(String patientid) throws BizException;
//
//	/**
//	 * 获取患者住院账单项汇总信息
//	 * 
//	 * @param patientid
//	 * @return
//	 */
//	public abstract GetDCIpIncItmInfoResponse getDCIpIncItmInfo(String patientid) throws BizException;
//
//	/**
//	 * 获取患者住院账单某项的每日记账金额
//	 * @param patientid
//	 * @param code_inccaitm
//	 * @return
//	 * @throws BizException 
//	 */
//	public abstract GetDCIpIncItmDayAmtsResponse getDCIpIncDayAmts(String id_ent, String code_inccaitm) throws BizException;
//
//	/**
//	 * 获取患者某账单项某日记账信息
//	 * @param patientid
//	 * @param code_inccaitm
//	 * @param dt_cg
//	 * @return
//	 * @throws BizException 
//	 */
//	public abstract GetDCIpCgListByInccaItmResponse getDCIpCgListByInccaItm(String patientid, String code_inccaitm, String dt_cg) throws BizException;
//
//	/**
//	 * 获取患者补费记录
//	 * @param patientHRID
//	 * @return
//	 */
//	public abstract getPatientChargeResponse getSubsidyInfo(String id_ent) throws BizException;
//
//	/**
//	 * 获取补录项目信息
//	 * @param 科室编码 
//	 * @param 病区编码 
//	 * @param 补费项目过滤条件 
//	 * @return
//	 */
//	public abstract getChargeItemResponse getChargeItem(String depcode, String wardcode, String condition) throws BizException;

	/**
	 * 返回体温单url
	 * @param patientID
	 * @return
	 */
	public abstract TemchartResponse temchart(String patientID) throws BizException;

	/**
	 * 获取病区配药信息
	 * @param id_dep_nur
	 * @param flag 
	 * @return
	 */
	public abstract GetWardPeiAuditResponse getWardPeiAuditInfo(String id_dep_nur, String flag) throws BizException;

	/**
	 * @param barcode
	 * @return
	 */
	public abstract GetOrPlanInfoResponse getOrPlanByBarCode(String barcode) throws BizException;
}
