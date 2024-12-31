package iih.ci.mb.s;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import iih.ci.mb.i.*;
import iih.ci.mb.utils.LogUtils;
import iih.mp.mb.IMpMbQueryService;

import iih.mp.mb.i.GetAllInHosDepartmentResponse;
import iih.mp.mb.i.GetDCMbUdidocResponse;
import iih.mp.mb.i.GetDCVisTimePointResponse;
import iih.mp.mb.i.GetNotificationOfUserRequest;
import iih.mp.mb.i.GetNotificationOfUserResponse;
import iih.mp.mb.i.GetPatientHROfDepartmentResponse;
import iih.mp.mb.i.GetVitalSignOfPatientHRAtTimePointResponse;

import iih.mp.mb.sysconfig.i.SysConfigService;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.mb.i.GetValidDepartmentOfUserRequest;
import xap.sys.mb.i.GetValidDepartmentOfUserResponse;

@Path("/dc")
public class MobileHISService {
	/**
	 * 获取用户的科室访问权限
	 * 
	 * @param request
	 * @return
	 */
	@POST
	@Path("/GetValidDepartmentOfUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetValidDepartmentOfUserResponse getValidDepartmentOfUser(GetValidDepartmentOfUserRequest request) {
		try {
			return ServiceFinder.find(IMpMbQueryService.class).getValidDepartmentOfUser(request.getOrgID(),
					request.getUserID());
		} catch (Exception e) {
			LogUtils.logStack(e, request);
			return new GetValidDepartmentOfUserResponse();
		}
	}

	@POST
	@Path("/DelDrugPrescriptionOfPatinetHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DelDrugPrescriptionOfPatinetHRResponse delDrugPrescriptionOfPatinetHR(
			DelDrugPrescriptionOfPatinetHRRequest request) {
		return null;
	}

	@POST
	@Path("/InsertOne_YiZhu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public InsertOne_YiZhuResponse insertOne_YiZhu(InsertOne_YiZhuRequest request) {
		return null;
	}

	@POST
	@Path("/GetExecutionRecordOfDoctorAdvice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetExecutionRecordOfDoctorAdviceResponse getExecutionRecordOfDoctorAdvice(
			GetExecutionRecordOfDoctorAdviceRequest request) {
		return null;
	}

	@POST
	@Path("/GetDictionaryByID")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDictionaryByIDResponse getDictionaryByID(GetDictionaryByIDRequest request) {
		return null;
	}

	@POST
	@Path("/GetNotificationOfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetNotificationOfDepartmentResponse getNotificationOfDepartment(GetNotificationOfDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/GetExecutionRecordOfTodayDoctorAdvice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetExecutionRecordOfTodayDoctorAdviceResponse getExecutionRecordOfTodayDoctorAdvice(
			GetExecutionRecordOfTodayDoctorAdviceRequest request) {
		return null;
	}

	@POST
	@Path("/SearchNursingTour")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SearchNursingTourResponse searchNursingTour(SearchNursingTourRequest request) {
		return null;
	}

	@POST
	@Path("/GetDoctorAdviceOfPatientHRByCurrentDate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDoctorAdviceOfPatientHRByCurrentDateResponse getDoctorAdviceOfPatientHRByCurrentDate(
			GetDoctorAdviceOfPatientHRByCurrentDateRequest request) {
		return null;
	}

	@POST
	@Path("/GetNursingRecordFileOfPatientHR_New")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetNursingRecordFileOfPatientHR_NewResponse getNursingRecordFileOfPatientHR_New(
			GetNursingRecordFileOfPatientHR_NewRequest request) {
		return null;
	}

	@POST
	@Path("/StopDoctorAdviceOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public StopDoctorAdviceOfPatientHRResponse StopDoctorAdviceOfPatientHR(StopDoctorAdviceOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetAllPatientInfusionTour")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetAllPatientInfusionTourResponse getAllPatientInfusionTour(GetAllPatientInfusionTourRequest request) {
		return null;
	}

	@POST
	@Path("/SavePatientNursingTour")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SavePatientNursingTourResponse savePatientNursingTour(SavePatientNursingTourRequest request) {
		return null;
	}

	@POST
	@Path("/TSQueryRegisterOfPrescription")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSQueryRegisterOfPrescriptionResponse TSQueryRegisterOfPrescription(
			TSQueryRegisterOfPrescriptionRequest request) {
		return null;
	}

	@POST
	@Path("/TSFinishTransfusionDrugBag")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSFinishTransfusionDrugBagResponse TSFinishTransfusionDrugBag(TSFinishTransfusionDrugBagRequest request) {
		return null;
	}

	@POST
	@Path("/TSGetAllUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSGetAllUserResponse TSGetAllUser(TSGetAllUserRequest request) {
		return null;
	}

	@POST
	@Path("/GetBloodApplyOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetBloodApplyOfPatientHRResponse getBloodApplyOfPatientHR(GetBloodApplyOfPatientHRRequest request) {
		return null;
	}

	/**
	 * 获取患者住院病历
	 * 
	 * @param request
	 * @return
	 */
	@POST
	@Path("/GetMedicalRecordsOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetMedicalRecordsOfPatientHRResponse getMedicalRecordsOfPatientHR(
			GetMedicalRecordsOfPatientHRRequest request) {
		try {
			ICiMbQueryService mbQryService = ServiceFinder.find(ICiMbQueryService.class);
			return mbQryService.getPatIpMrList(request.getPatientHRID(), request.getSubID());
		} catch (Exception e) {
			LogUtils.logStack(e, request);
			return new GetMedicalRecordsOfPatientHRResponse();
		}
	}

	@POST
	@Path("/VerifyVersion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public VerifyVersionResponse verifyVersion(VerifyVersionRequest request) {
		return null;
	}

	@POST
	@Path("/GetContentDefinitionsOfNursingRecordFile")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetContentDefinitionsOfNursingRecordFileResponse getContentDefinitionsOfNursingRecordFile(
			GetContentDefinitionsOfNursingRecordFileRequest request) {
		return null;
	}

	@POST
	@Path("/GetFocusPatient")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetFocusPatientResponse getFocusPatient(GetFocusPatientRequest request) {
		return null;
	}

	@POST
	@Path("/TSGetAllDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSGetAllDepartmentResponse TSGetAllDepartment(TSGetAllDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/GetAllFeedback")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetAllFeedbackResponse getAllFeedback(GetAllFeedbackRequest request) {
		return null;
	}

	@POST
	@Path("/GetZhiXingRen_YiZhu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetZhiXingRen_YiZhuResponse getZhiXingRen_YiZhu(GetZhiXingRen_YiZhuRequest request) {
		return null;
	}

	@POST
	@Path("/DeletePatientNote")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DeletePatientNoteResponse deletePatientNote(DeletePatientNoteRequest request) {
		return null;
	}

	@POST
	@Path("/GetKeyBoardByNameMore")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetKeyBoardByNameMoreResponse getKeyBoardByNameMore(GetKeyBoardByNameMoreRequest request) {
		return null;
	}

	@POST
	@Path("/GetHistoryMessageForDoctorW")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetHistoryMessageForDoctorWResponse getHistoryMessageForDoctorW(GetHistoryMessageForDoctorWRequest request) {
		return null;
	}

	@POST
	@Path("/SaveDoctorAdviceOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SaveDoctorAdviceOfPatientHRResponse saveDoctorAdviceOfPatientHR(SaveDoctorAdviceOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/AddDutyDefinition")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AddDutyDefinitionResponse addDutyDefinition(AddDutyDefinitionRequest request) {
		return null;
	}

	@POST
	@Path("/GetPatientTodayInfusionTour")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetPatientTodayInfusionTourResponse getPatientTodayInfusionTour(GetPatientTodayInfusionTourRequest request) {
		return null;
	}

	@POST
	@Path("/GetDoctorAdviceOfPatientHRByDate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDoctorAdviceOfPatientHRByDateResponse getDoctorAdviceOfPatientHRByDate(
			GetDoctorAdviceOfPatientHRByDateRequest request) {
		return null;
	}

	@POST
	@Path("/AddDoctorAdviceDateTop")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AddDoctorAdviceDateTopResponse addDoctorAdviceDateTop(AddDoctorAdviceDateTopRequest request) {
		return null;
	}

	@POST
	@Path("/GetAllDeptFrequencyList")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetAllDeptFrequencyListResponse getAllDeptFrequencyList(GetAllDeptFrequencyListRequest request) {
		return null;
	}

	@POST
	@Path("/TSFindRegisterByDrugBagBarCode")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSFindRegisterByDrugBagBarCodeResponse TSFindRegisterByDrugBagBarCode(
			TSFindRegisterByDrugBagBarCodeRequest request) {
		return null;
	}

	@POST
	@Path("/TSQueryPrescription")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSQueryPrescriptionResponse TSQueryPrescription(TSQueryPrescriptionRequest request) {
		return null;
	}

	@POST
	@Path("/DeleteDutyDefinition")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DeleteDutyDefinitionResponse deleteDutyDefinition(DeleteDutyDefinitionRequest request) {
		return null;
	}

	@POST
	@Path("/GetStatisticsForDoctor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetStatisticsForDoctorResponse getStatisticsForDoctor(GetStatisticsForDoctorRequest request) {
		return null;
	}

	@POST
	@Path("/GetBuWei_YiZhu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetBuWei_YiZhuResponse getBuWei_YiZhu(GetBuWei_YiZhuRequest request) {
		return null;
	}

	@POST
	@Path("/TSQueryPatientCall")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSQueryPatientCallResponse TSQueryPatientCall(TSQueryPatientCallRequest request) {
		return null;
	}



	@POST
	@Path("/DownloadUserCertification")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DownloadUserCertificationResponse downloadUserCertification(DownloadUserCertificationRequest request) {
		return null;
	}

	@POST
	@Path("/UpdateVitalSignOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UpdateVitalSignOfPatientHRResponse updateVitalSignOfPatientHR(UpdateVitalSignOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetFeedbackDetailByFeedbackUID")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetFeedbackDetailByFeedbackUIDResponse getFeedbackDetailByFeedbackUID(
			GetFeedbackDetailByFeedbackUIDRequest request) {
		return null;
	}

	@POST
	@Path("/GetYiZhuLeiXing_YiZhu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetYiZhuLeiXing_YiZhuResponse getYiZhuLeiXing_YiZhu(GetYiZhuLeiXing_YiZhuRequest request) {
		return null;
	}

	@POST
	@Path("/SaveConsultValueStTxt")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SaveConsultValueStTxtResponse saveConsultValueStTxt(SaveConsultValueStTxtRequest request) {
		return null;
	}

	@POST
	@Path("/GetNurseOfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetNurseOfDepartmentResponse getNurseOfDepartment(GetNurseOfDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/GetAllTourTypes")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetAllTourTypesResponse getAllTourTypes(GetAllTourTypesRequest request) {
		return null;
	}

	/**
	 * 获取系统配置
	 * 
	 * @param request
	 * @return
	 */
	@POST
	@Path("/GetSystemConfig")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public iih.mp.mb.i.GetSystemConfigResponse getSystemConfig(GetSystemConfigRequest request) {
		SysConfigService sysConfigService = ServiceFinder.find(SysConfigService.class);
		iih.mp.mb.i.ArrayOfDCSystemConfig arrayOfConfig = sysConfigService.getSysConfig(request.getProduct(),
				request.getPlatform(), request.getDeviceModel());
		iih.mp.mb.i.GetSystemConfigResponse resp = new iih.mp.mb.i.GetSystemConfigResponse();
		resp.setGetSystemConfigResult(arrayOfConfig);
		return resp;
	}

	@POST
	@Path("/UpdateVitalSignControlList")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UpdateVitalSignControlListResponse updateVitalSignControlList(UpdateVitalSignControlListRequest request) {
		return null;
	}

	@POST
	@Path("/GettConsulApplyZD")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GettConsulApplyZDResponse gettConsulApplyZD(GettConsulApplyZDRequest request) {
		return null;
	}

	@POST
	@Path("/UpdateVitalSignOfHuLiJiLu_New")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UpdateVitalSignOfHuLiJiLu_NewResponse updateVitalSignOfHuLiJiLu_New(
			UpdateVitalSignOfHuLiJiLu_NewRequest request) {
		return null;
	}

	@POST
	@Path("/TSFindRegisterByPrescriptionBarCode")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSFindRegisterByPrescriptionBarCodeResponse TSFindRegisterByPrescriptionBarCode(
			TSFindRegisterByPrescriptionBarCodeRequest request) {
		return null;
	}

	@POST
	@Path("/GetFaShaoHighVitalSign")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetFaShaoHighVitalSignResponse getFaShaoHighVitalSign(GetFaShaoHighVitalSignRequest request) {
		return null;
	}

	@POST
	@Path("/GetTestItemsOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetTestItemsOfPatientHRResponse getTestItemsOfPatientHR(GetTestItemsOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetRecentlyVitalSignOverview")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetRecentlyVitalSignOverviewResponse getRecentlyVitalSignOverview(
			GetRecentlyVitalSignOverviewRequest request) {
		return null;
	}

	@POST
	@Path("/GetCheckScheduleOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetCheckScheduleOfPatientHRResponse getCheckScheduleOfPatientHR(GetCheckScheduleOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetNursingRecordType")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetNursingRecordTypeResponse getNursingRecordType(GetNursingRecordTypeRequest request) {
		return null;
	}

	@POST
	@Path("/GetPathologicalRecordOfPatientNoW")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetPathologicalRecordOfPatientNoWResponse getPathologicalRecordOfPatientNoW(
			GetPathologicalRecordOfPatientNoWRequest request) {
		return null;
	}

	@POST
	@Path("/LoginByUserCertification")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoginByUserCertificationResponse loginByUserCertification(LoginByUserCertificationRequest request) {
		return null;
	}

	@POST
	@Path("/GetVitalSignOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetVitalSignOfPatientHRResponse getVitalSignOfPatientHR(GetVitalSignOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/ReplyMessage")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ReplyMessageResponse ReplyMessage(ReplyMessageRequest request) {
		return null;
	}

	@POST
	@Path("/DeleteExecutionRecordOfDoctorAdvice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DeleteExecutionRecordOfDoctorAdviceResponse deleteExecutionRecordOfDoctorAdvice(
			DeleteExecutionRecordOfDoctorAdviceRequest request) {
		return null;
	}

	@POST
	@Path("/GetPatientEventGroup")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetPatientEventGroupResponse getPatientEventGroup(GetPatientEventGroupRequest request) {
		return null;
	}

	@POST
	@Path("/TSRegisterPrescription")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSRegisterPrescriptionResponse TSRegisterPrescription(TSRegisterPrescriptionRequest request) {
		return null;
	}

	@POST
	@Path("/GetDoctorMemorandumList")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDoctorMemorandumListResponse getDoctorMemorandumList(GetDoctorMemorandumListRequest request) {
		try {
			return ServiceFinder.find(ICiMbQueryService.class).getDoctorMemorandumList(request);
		} catch (Exception e) {
			LogUtils.logStack(e, request);
			return new GetDoctorMemorandumListResponse();
		}
	}

	@POST
	@Path("/GetStatisticForDoctorAdviceGroupByState")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetStatisticForDoctorAdviceGroupByStateResponse getStatisticForDoctorAdviceGroupByState(
			GetStatisticForDoctorAdviceGroupByStateRequest request) {
		return null;
	}

	@POST
	@Path("/GetPriceDetailOfDoctorAdvice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetPriceDetailOfDoctorAdviceResponse getPriceDetailOfDoctorAdvice(
			GetPriceDetailOfDoctorAdviceRequest request) {
		return null;
	}

	/**
	 * 获取科室医生信息
	 * 
	 * @param request
	 * @return
	 */
	@POST
	@Path("/GetDoctorOfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDoctorOfDepartmentResponse getDoctorOfDepartment(GetDoctorOfDepartmentRequest request) {
		try {
			ICiMbQueryService mbQryService = ServiceFinder.find(ICiMbQueryService.class);
			return mbQryService.getDeptDoctors(request.getDepartmentID());
		} catch (Exception e) {
			LogUtils.logStack(e, request);
			return new GetDoctorOfDepartmentResponse();
		}
	}

	@POST
	@Path("/VerifyCertifications")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public VerifyCertificationsResponse verifyCertifications(VerifyCertificationsRequest request) {
		return null;
	}

	@POST
	@Path("/GetKeyBoard")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetKeyBoardResponse getKeyBoard(GetKeyBoardRequest request) {
		return null;
	}

	@POST
	@Path("/GetExitPatientHROfDepartmentByDuration")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetExitPatientHROfDepartmentByDurationResponse getExitPatientHROfDepartmentByDuration(
			GetExitPatientHROfDepartmentByDurationRequest request) {
		return null;
	}

	@POST
	@Path("/GetStatisticForDoctorAdviceGroupByCureType")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetStatisticForDoctorAdviceGroupByCureTypeResponse getStatisticForDoctorAdviceGroupByCureType(
			GetStatisticForDoctorAdviceGroupByCureTypeRequest request) {
		return null;
	}

	@POST
	@Path("/GetMulKeyBoard")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetMulKeyBoardResponse getMulKeyBoard(GetMulKeyBoardRequest request) {
		return null;
	}

	@POST
	@Path("/GetDrugUsageTypeOfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDrugUsageTypeOfDepartmentResponse getDrugUsageTypeOfDepartment(
			GetDrugUsageTypeOfDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/GetWeekNurseStationStatisticsOfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetWeekNurseStationStatisticsOfDepartmentResponse getWeekNurseStationStatisticsOfDepartment(
			GetWeekNurseStationStatisticsOfDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/UpdateConsulApplyList")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UpdateConsulApplyListResponse updateConsulApplyList(UpdateConsulApplyListRequest request) {
		return null;
	}

	@POST
	@Path("/UpadateUserPass")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UpadateUserPassResponse UpadateUserPass(UpadateUserPassRequest request) {
		return null;
	}

	@POST
	@Path("/GetLeiBie_YiZhu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetLeiBie_YiZhuResponse getLeiBie_YiZhu(GetLeiBie_YiZhuRequest request) {
		return null;
	}

	@POST
	@Path("/GetNursingReportContent")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetNursingReportContentResponse getNursingReportContent(GetNursingReportContentRequest request) {
		return null;
	}

	/**
	 * 获取检验报告
	 * 
	 * @param request
	 * @return
	 */
	@POST
	@Path("/GetTestOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetTestOfPatientHRResponse getTestOfPatientHR(GetTestOfPatientHRRequest request) {
		try {
			ICiMbQueryService qryService = ServiceFinder.find(ICiMbQueryService.class);
			return qryService.getPatIpLabList(request.getPatientHRID());
		} catch (Exception ex) {
			LogUtils.logStack(ex, request);
			return new GetTestOfPatientHRResponse();
		}
	}

	@POST
	@Path("/GetSplitDoctorAdviceOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetSplitDoctorAdviceOfPatientHRResponse getSplitDoctorAdviceOfPatientHR(
			GetSplitDoctorAdviceOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/AutoSendMSG")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AutoSendMSGResponse AutoSendMSG(AutoSendMSGRequest request) {
		return null;
	}

	@POST
	@Path("/NursePrintPatientDoctorAdvice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public NursePrintPatientDoctorAdviceResponse NursePrintPatientDoctorAdvice(
			NursePrintPatientDoctorAdviceRequest request) {
		return null;
	}

	@POST
	@Path("/SaveFocusPatient")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SaveFocusPatientResponse saveFocusPatient(SaveFocusPatientRequest request) {
		return null;
	}

	@POST
	@Path("/GetHospitalDailyReport")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetHospitalDailyReportResponse getHospitalDailyReport(GetHospitalDailyReportRequest request) {
		return null;
	}

	@POST
	@Path("/SearchConsultListByBarcode")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SearchConsultListByBarcodeResponse searchConsultListByBarcode(SearchConsultListByBarcodeRequest request) {
		return null;
	}

	@POST
	@Path("/GetAllUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetAllUserResponse getAllUser(GetAllUserRequest request) {
		return null;
	}

	@POST
	@Path("/GetConsulListOfApplyDept")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetConsulListOfApplyDeptResponse getConsulListOfApplyDept(GetConsulListOfApplyDeptRequest request) {
		return null;
	}

	@POST
	@Path("/GetAdviceExcuteStaticsOfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetAdviceExcuteStaticsOfDepartmentResponse getAdviceExcuteStaticsOfDepartment(
			GetAdviceExcuteStaticsOfDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/GetAllYiZhuMingCheng_YiZhu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetAllYiZhuMingCheng_YiZhuResponse getAllYiZhuMingCheng_YiZhu(GetAllYiZhuMingCheng_YiZhuRequest request) {
		return null;
	}

	@POST
	@Path("/TSGetSeatOfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSGetSeatOfDepartmentResponse TSGetSeatOfDepartment(TSGetSeatOfDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/GetContentOfMedicalRecords")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetContentOfMedicalRecordsResponse getContentOfMedicalRecords(GetContentOfMedicalRecordsRequest request) {
		return null;
	}

	@POST
	@Path("/CreateNursingRecordFile_New")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CreateNursingRecordFile_NewResponse createNursingRecordFile_New(CreateNursingRecordFile_NewRequest request) {
		return null;
	}

	/**
	 * 获取检查结果URL
	 * 
	 * @param request
	 * @return
	 */
	@POST
	@Path("/GetCheckUrlOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetCheckUrlOfPatientHRResponse getCheckUrlOfPatientHR(GetCheckUrlOfPatientHRRequest request) {
		try {
			ICiMbQueryService qryService = ServiceFinder.find(ICiMbQueryService.class);
			return qryService.getPatIpObsList(request.getPatientHRID(), request.getSubID());
		} catch (Exception ex) {
			LogUtils.logStack(ex, request);
			return new GetCheckUrlOfPatientHRResponse();
		}
	}

	@POST
	@Path("/TSQueryNurseWorkStatistics")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSQueryNurseWorkStatisticsResponse TSQueryNurseWorkStatistics(TSQueryNurseWorkStatisticsRequest request) {
		return null;
	}

	@POST
	@Path("/GetSMS")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetSMSResponse getSMS(GetSMSRequest request) {
		return null;
	}

	@POST
	@Path("/QueryPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public QueryPatientHRResponse queryPatientHR(QueryPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetNursingRecordOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetNursingRecordOfPatientHRResponse getNursingRecordOfPatientHR(GetNursingRecordOfPatientHRRequest request) {

		try {
			ICiMbQueryService ciQrySrv = ServiceFinder.find(ICiMbQueryService.class);
			return ciQrySrv.getNursingRecordOfPatientHR(request);
		} catch (Exception e) {
			LogUtils.logStack(e, request);
			return new GetNursingRecordOfPatientHRResponse();
		}

	}

	@POST
	@Path("/OperateDoctorAdviceOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public OperateDoctorAdviceOfPatientHRResponse OperateDoctorAdviceOfPatientHR(
			OperateDoctorAdviceOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetDoctorAdviceOfPatientHRLite")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDoctorAdviceOfPatientHRLiteResponse getDoctorAdviceOfPatientHRLite(
			GetDoctorAdviceOfPatientHRLiteRequest request) {
		return null;
	}

	@POST
	@Path("/SubmitTask")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SubmitTaskResponse submitTask(SubmitTaskRequest request) {
		return null;
	}

	@POST
	@Path("/GetTransferPatientHROfDepartmentByDuration")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetTransferPatientHROfDepartmentByDurationResponse getTransferPatientHROfDepartmentByDuration(
			GetTransferPatientHROfDepartmentByDurationRequest request) {
		return null;
	}

	@POST
	@Path("/GetFaShaoLowVitalSign")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetFaShaoLowVitalSignResponse getFaShaoLowVitalSign(GetFaShaoLowVitalSignRequest request) {
		return null;
	}

	@POST
	@Path("/GetKeyBoardTitle")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetKeyBoardTitleResponse getKeyBoardTitle(GetKeyBoardTitleRequest request) {
		return null;
	}

	@POST
	@Path("/AddFeedback")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AddFeedbackResponse addFeedback(AddFeedbackRequest request) {
		return null;
	}

	@POST
	@Path("/GetPatientHistoryHRByID")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetPatientHistoryHRByIDResponse getPatientHistoryHRByID(GetPatientHistoryHRByIDRequest request) {
		try {
			ICiMbQueryService mbQryService = ServiceFinder.find(ICiMbQueryService.class);
			return mbQryService.getPatIpHistory(request.getPatientHRID());
		} catch (Exception e) {
			LogUtils.logStack(e, request);
			return new GetPatientHistoryHRByIDResponse();
		}
	}

	@POST
	@Path("/GetBloodConditionOfPatientNo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetBloodConditionOfPatientNoResponse getBloodConditionOfPatientNo(
			GetBloodConditionOfPatientNoRequest request) {
		return null;
	}

	@POST
	@Path("/SaveDoctorAdivce")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SaveDoctorAdivceResponse saveDoctorAdivce(SaveDoctorAdivceRequest request) {
		return null;
	}

	@POST
	@Path("/GetConsulReplyListOfPatient")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetConsulReplyListOfPatientResponse getConsulReplyListOfPatient(GetConsulReplyListOfPatientRequest request) {
		return null;
	}

	@POST
	@Path("/GetDepartmentCareLevelCountOfDept")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDepartmentCareLevelCountOfDeptResponse getDepartmentCareLevelCountOfDept(
			GetDepartmentCareLevelCountOfDeptRequest request) {
		try {
			ICiMbQueryService qryService = ServiceFinder.find(ICiMbQueryService.class);
			return qryService.getWardOrDept(request.getDeptID());
		} catch (Exception ex) {
			LogUtils.logStack(ex, request);
			return new GetDepartmentCareLevelCountOfDeptResponse();
		}
	}

	@POST
	@Path("/AddBloodApplyOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AddBloodApplyOfPatientHRResponse addBloodApplyOfPatientHR(AddBloodApplyOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/AddCheckScheduleOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AddCheckScheduleOfPatientHRResponse addCheckScheduleOfPatientHR(AddCheckScheduleOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/UpdateVitalSignOfTiWenDan_New")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UpdateVitalSignOfTiWenDan_NewResponse updateVitalSignOfTiWenDan_New(
			UpdateVitalSignOfTiWenDan_NewRequest request) {
		return null;
	}

	@POST
	@Path("/DelDoctorMemorandum")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DelDoctorMemorandumResponse delDoctorMemorandum(DelDoctorMemorandumRequest request) {
		try {
			return ServiceFinder.find(ICiMbQueryService.class).delDoctorMemorandum(request);
		} catch (Exception e) {
			LogUtils.logStack(e, request);
			return new DelDoctorMemorandumResponse();
		}
	}

	@POST
	@Path("/TSGetRegisterByPatient")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSGetRegisterByPatientResponse TSGetRegisterByPatient(TSGetRegisterByPatientRequest request) {
		return null;
	}

	@POST
	@Path("/TSDispenseTransfusionDrugBag")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSDispenseTransfusionDrugBagResponse TSDispenseTransfusionDrugBag(
			TSDispenseTransfusionDrugBagRequest request) {
		return null;
	}

	@POST
	@Path("/DelDoctorAdviceDateTop")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DelDoctorAdviceDateTopResponse delDoctorAdviceDateTop(DelDoctorAdviceDateTopRequest request) {
		return null;
	}

	@POST
	@Path("/TSPauseTransfusion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSPauseTransfusionResponse TSPauseTransfusion(TSPauseTransfusionRequest request) {
		return null;
	}

	@POST
	@Path("/GetDepartmentCareLevelCountOfWard")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDepartmentCareLevelCountOfWardResponse getDepartmentCareLevelCountOfWard(
			GetDepartmentCareLevelCountOfWardRequest request) {
		return null;
	}

	@POST
	@Path("/GetUnExpectedVitalSigns")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetUnExpectedVitalSignsResponse getUnExpectedVitalSigns(GetUnExpectedVitalSignsRequest request) {
		return null;
	}

	/**
	 * 获取科室在院患者记录
	 * 
	 * @param request
	 * @return
	 */
	@POST
	@Path("/GetPatientHROfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetPatientHROfDepartmentResponse getPatientHROfDepartment(GetPatientHROfDepartmentRequest request) {

		try {
			return ServiceFinder.find(IMpMbQueryService.class).getPatientRecord(request.getDepartmentID());
		} catch (Exception e) {
			LogUtils.logStack(e, request);
			return new GetPatientHROfDepartmentResponse();
		}

	}

	@POST
	@Path("/GetAudioRecordsForOrder")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetAudioRecordsForOrderResponse getAudioRecordsForOrder(GetAudioRecordsForOrderRequest request) {
		return null;
	}

	@POST
	@Path("/GetKeyBoardByName")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetKeyBoardByNameResponse getKeyBoardByName(GetKeyBoardByNameRequest request) {
		return null;
	}

	@POST
	@Path("/GetHistoryMessageForDoctor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetHistoryMessageForDoctorResponse getHistoryMessageForDoctor(GetHistoryMessageForDoctorRequest request) {
		return null;
	}

	@POST
	@Path("/GetExecutionRecordOfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetExecutionRecordOfDepartmentResponse getExecutionRecordOfDepartment(
			GetExecutionRecordOfDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/TSUpdateDepmartmentRoomSetting")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSUpdateDepmartmentRoomSettingResponse TSUpdateDepmartmentRoomSetting(
			TSUpdateDepmartmentRoomSettingRequest request) {
		return null;
	}

	@POST
	@Path("/AddOperationScheduleOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AddOperationScheduleOfPatientHRResponse addOperationScheduleOfPatientHR(
			AddOperationScheduleOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/TSGetSeatByID")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSGetSeatByIDResponse TSGetSeatByID(TSGetSeatByIDRequest request) {
		return null;
	}

	@POST
	@Path("/TSQueryPrescriptionWithPatientName")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSQueryPrescriptionWithPatientNameResponse TSQueryPrescriptionWithPatientName(
			TSQueryPrescriptionWithPatientNameRequest request) {
		return null;
	}

	@POST
	@Path("/UpdateFeedbackState")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UpdateFeedbackStateResponse updateFeedbackState(UpdateFeedbackStateRequest request) {
		return null;
	}

	@POST
	@Path("/GetNursingDocumentsOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetNursingDocumentsOfPatientHRResponse getNursingDocumentsOfPatientHR(
			GetNursingDocumentsOfPatientHRRequest request) {
		try {
			ICiMbQueryService qryService = ServiceFinder.find(ICiMbQueryService.class);
			return qryService.getNurNmrList(request.getPatientHRID(), request.getSubID());
		} catch (Exception ex) {
			LogUtils.logStack(ex, request);
			return new GetNursingDocumentsOfPatientHRResponse();
		}
	}

	@POST
	@Path("/GetBedInformationOfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetBedInformationOfDepartmentResponse getBedInformationOfDepartment(
			GetBedInformationOfDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/UnRegisterDevice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UnRegisterDeviceResponse unRegisterDevice(UnRegisterDeviceRequest request) {
		return null;
	}

	@POST
	@Path("/DelCheckScheduleOfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DelCheckScheduleOfDepartmentResponse delCheckScheduleOfDepartment(
			DelCheckScheduleOfDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/DelHivPatient")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DelHivPatientResponse delHivPatient(DelHivPatientRequest request) {
		return null;
	}

	@POST
	@Path("/GetScheduleOfDate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetScheduleOfDateResponse getScheduleOfDate(GetScheduleOfDateRequest request) {
		return null;
	}

	@POST
	@Path("/AddDoctorOrdersTemplete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AddDoctorOrdersTempleteResponse addDoctorOrdersTemplete(AddDoctorOrdersTempleteRequest request) {
		return null;
	}

	@POST
	@Path("/PaitentCall")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PaitentCallResponse PaitentCall(PaitentCallRequest request) {
		return null;
	}

	@POST
	@Path("/GetOralAccountRecordOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetOralAccountRecordOfPatientHRResponse getOralAccountRecordOfPatientHR(
			GetOralAccountRecordOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetAllInHosDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetAllInHosDepartmentResponse getAllInHosDepartment(GetAllInHosDepartmentRequest request) {
		try {
			return ServiceFinder.find(IMpMbQueryService.class).getAlldep(request.getMode());
		} catch (Exception e) {
			LogUtils.logStack(e, request);
			return new GetAllInHosDepartmentResponse();
		}
	}

	@POST
	@Path("/TSQueryCurrentRegister")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSQueryCurrentRegisterResponse TSQueryCurrentRegister(TSQueryCurrentRegisterRequest request) {
		return null;
	}

	@POST
	@Path("/GetPathologicalRecordOfPatientNoNew")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetPathologicalRecordOfPatientNoNewResponse getPathologicalRecordOfPatientNoNew(
			GetPathologicalRecordOfPatientNoNewRequest request) {
		return null;
	}

	@POST
	@Path("/NurseExcutePatientDoctorAdvice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public NurseExcutePatientDoctorAdviceResponse NurseExcutePatientDoctorAdvice(
			NurseExcutePatientDoctorAdviceRequest request) {
		return null;
	}

	@POST
	@Path("/GetPatientNursingTour")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetPatientNursingTourResponse getPatientNursingTour(GetPatientNursingTourRequest request) {
		return null;
	}

	@POST
	@Path("/GetNewMessageForDoctor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetNewMessageForDoctorResponse getNewMessageForDoctor(GetNewMessageForDoctorRequest request) {
		return null;
	}

	@POST
	@Path("/GetChangeDutyInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetChangeDutyInfoResponse getChangeDutyInfo(GetChangeDutyInfoRequest request) {
		return null;
	}

	@POST
	@Path("/AddVitalSignRecordOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AddVitalSignRecordOfPatientHRResponse addVitalSignRecordOfPatientHR(
			AddVitalSignRecordOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/SaveSchedule")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SaveScheduleResponse saveSchedule(SaveScheduleRequest request) {
		return null;
	}

	@POST
	@Path("/GetDutyDefinitionOfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDutyDefinitionOfDepartmentResponse getDutyDefinitionOfDepartment(
			GetDutyDefinitionOfDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/GetDrugPrecriptionOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDrugPrecriptionOfPatientHRResponse getDrugPrecriptionOfPatientHR(
			GetDrugPrecriptionOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetCheckScheduleOfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetCheckScheduleOfDepartmentResponse getCheckScheduleOfDepartment(
			GetCheckScheduleOfDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/GetBeiZhu_YiZhu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetBeiZhu_YiZhuResponse getBeiZhu_YiZhu(GetBeiZhu_YiZhuRequest request) {
		return null;
	}

	@POST
	@Path("/GetTestOfPatientHR_TZ")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetTestOfPatientHR_TZResponse getTestOfPatientHR_TZ(GetTestOfPatientHR_TZRequest request) {
		return null;
	}

	@POST
	@Path("/GetConsultPatientHROfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetConsultPatientHROfDepartmentResponse getConsultPatientHROfDepartment(
			GetConsultPatientHROfDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/TSCancelTransfusion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSCancelTransfusionResponse TSCancelTransfusion(TSCancelTransfusionRequest request) {
		return null;
	}

	@POST
	@Path("/GetAllPatientNotes")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetAllPatientNotesResponse getAllPatientNotes(GetAllPatientNotesRequest request) {
		return null;
	}

	@POST
	@Path("/SaveObsRegister")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SaveObsRegisterResponse saveObsRegister(SaveObsRegisterRequest request) {
		return null;
	}

	@POST
	@Path("/TSAddSeatOfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSAddSeatOfDepartmentResponse TSAddSeatOfDepartment(TSAddSeatOfDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/GetFilterSplitDoctorAdviceOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetFilterSplitDoctorAdviceOfPatientHRResponse getFilterSplitDoctorAdviceOfPatientHR(
			GetFilterSplitDoctorAdviceOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetVitalSignOfPatientHRAtTimePoint_New")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetVitalSignOfPatientHRAtTimePoint_NewResponse getVitalSignOfPatientHRAtTimePoint_New(
			GetVitalSignOfPatientHRAtTimePoint_NewRequest request) {
		return null;
	}

	@POST
	@Path("/VerifyNoteVersion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public VerifyNoteVersionResponse verifyNoteVersion(VerifyNoteVersionRequest request) {
		return null;
	}

	@POST
	@Path("/GetVitalSignControlList")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetVitalSignControlListResponse getVitalSignControlList(GetVitalSignControlListRequest request) {
		return null;
	}

	@POST
	@Path("/GetRequestTestItemsOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetRequestTestItemsOfPatientHRResponse getRequestTestItemsOfPatientHR(
			GetRequestTestItemsOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetPrepaymentDetailOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetPrepaymentDetailOfPatientHRResponse getPrepaymentDetailOfPatientHR(
			GetPrepaymentDetailOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetWristRingInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetWristRingInfoResponse getWristRingInfo(GetWristRingInfoRequest request) {
		return null;
	}

	@POST
	@Path("/TSGetRegisterByID")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSGetRegisterByIDResponse TSGetRegisterByID(TSGetRegisterByIDRequest request) {
		return null;
	}

	@POST
	@Path("/AddExecutionRecordOfDoctorAdvice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AddExecutionRecordOfDoctorAdviceResponse addExecutionRecordOfDoctorAdvice(
			AddExecutionRecordOfDoctorAdviceRequest request) {
		return null;
	}

	@POST
	@Path("/GetDeviceInfoBySerial")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDeviceInfoBySerialResponse getDeviceInfoBySerial(GetDeviceInfoBySerialRequest request) {
		return null;
	}

	@POST
	@Path("/DelOperationScheduleOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DelOperationScheduleOfPatientHRResponse delOperationScheduleOfPatientHR(
			DelOperationScheduleOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetVitalSignChartUrls")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetVitalSignChartUrlsResponse getVitalSignChartUrls(GetVitalSignChartUrlsRequest request) {
		return null;
	}

	@POST
	@Path("/GetMedicalRecordsOfPatientHRW")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetMedicalRecordsOfPatientHRWResponse getMedicalRecordsOfPatientHRW(
			GetMedicalRecordsOfPatientHRWRequest request) {
		return null;
	}

	@POST
	@Path("/AddRequestTestOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AddRequestTestOfPatientHRResponse addRequestTestOfPatientHR(AddRequestTestOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetAllTaskOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetAllTaskOfPatientHRResponse getAllTaskOfPatientHR(GetAllTaskOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetYongFa_YiZhu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetYongFa_YiZhuResponse getYongFa_YiZhu(GetYongFa_YiZhuRequest request) {
		return null;
	}

	@POST
	@Path("/GetOperationScheduleOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetOperationScheduleOfPatientHRResponse getOperationScheduleOfPatientHR(
			GetOperationScheduleOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetPathologicalRecordOfPatientNo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetPathologicalRecordOfPatientNoResponse getPathologicalRecordOfPatientNo(
			GetPathologicalRecordOfPatientNoRequest request) {
		return null;
	}

	@POST
	@Path("/TSPatientCall")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSPatientCallResponse TSPatientCall(TSPatientCallRequest request) {
		return null;
	}

	@POST
	@Path("/CreateChangeDutyInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CreateChangeDutyInfoResponse createChangeDutyInfo(CreateChangeDutyInfoRequest request) {
		return null;
	}

	@POST
	@Path("/UpdateCertification")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UpdateCertificationResponse updateCertification(UpdateCertificationRequest request) {
		return null;
	}

	@POST
	@Path("/GetMulKeyBoard1")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetMulKeyBoard1Response getMulKeyBoard1(GetMulKeyBoard1Request request) {
		return null;
	}

	@POST
	@Path("/GetMulKeyBoard2")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetMulKeyBoard2Response getMulKeyBoard2(GetMulKeyBoard2Request request) {
		return null;
	}

	@POST
	@Path("/GetTestOfPatientHRByDate_TZ")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetTestOfPatientHRByDate_TZResponse getTestOfPatientHRByDate_TZ(GetTestOfPatientHRByDate_TZRequest request) {
		return null;
	}

	@POST
	@Path("/GetSendRecordOfDoctorAdvice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetSendRecordOfDoctorAdviceResponse getSendRecordOfDoctorAdvice(GetSendRecordOfDoctorAdviceRequest request) {
		return null;
	}

	@POST
	@Path("/SaveDoctorMemorandum")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SaveDoctorMemorandumResponse saveDoctorMemorandum(SaveDoctorMemorandumRequest request) {
		try {
			return ServiceFinder.find(ICiMbQueryService.class).saveDoctorMemorandum(request);
		} catch (Exception e) {
			LogUtils.logStack(e, request);
			return new SaveDoctorMemorandumResponse();
		}
	}

	@POST
	@Path("/GetPinCi_YiZhu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetPinCi_YiZhuResponse getPinCi_YiZhu(GetPinCi_YiZhuRequest request) {
		return null;
	}

	@POST
	@Path("/GetUnsettledCostDetailOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetUnsettledCostDetailOfPatientHRResponse getUnsettledCostDetailOfPatientHR(
			GetUnsettledCostDetailOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/SavePatientInfusionTour")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SavePatientInfusionTourResponse savePatientInfusionTour(SavePatientInfusionTourRequest request) {
		return null;
	}

	@POST
	@Path("/GetNotificationOfUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetNotificationOfUserResponse getNotificationOfUser(GetNotificationOfUserRequest request) {
		return null;
	}

	@POST
	@Path("/GetYangBen_YiZhu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetYangBen_YiZhuResponse getYangBen_YiZhu(GetYangBen_YiZhuRequest request) {
		return null;
	}

	@POST
	@Path("/SaveDutyAdjustment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SaveDutyAdjustmentResponse saveDutyAdjustment(SaveDutyAdjustmentRequest request) {
		return null;
	}

	@POST
	@Path("/GetAnesthesiaItemList")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetAnesthesiaItemListResponse getAnesthesiaItemList(GetAnesthesiaItemListRequest request) {
		return null;
	}

	@POST
	@Path("/SaveConsulApplyList")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SaveConsulApplyListResponse saveConsulApplyList(SaveConsulApplyListRequest request) {
		return null;
	}

	@POST
	@Path("/GetDoctorAdviceOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDoctorAdviceOfPatientHRResponse getDoctorAdviceOfPatientHR(GetDoctorAdviceOfPatientHRRequest request) {
		try {
			ICiMbQueryService qryService = ServiceFinder.find(ICiMbQueryService.class);
			GetDoctorAdviceOfPatientHRResponse daphrr = qryService.getPatIpOrdList(request.getPatientHRID());
			return daphrr;
		} catch (Exception e) {
			LogUtils.logStack(e, request);
			return new GetDoctorAdviceOfPatientHRResponse();
		}
	}

	@POST
	@Path("/AddDoctorAdviceOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AddDoctorAdviceOfPatientHRResponse addDoctorAdviceOfPatientHR(AddDoctorAdviceOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/TSQueryNurseWorkDetailOfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSQueryNurseWorkDetailOfDepartmentResponse TSQueryNurseWorkDetailOfDepartment(
			TSQueryNurseWorkDetailOfDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/GetOrderInputDict")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetOrderInputDictResponse getOrderInputDict(GetOrderInputDictRequest request) {
		return null;
	}

	@POST
	@Path("/GetNewMessageForDoctorW")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetNewMessageForDoctorWResponse getNewMessageForDoctorW(GetNewMessageForDoctorWRequest request) {
		return null;
	}

	@POST
	@Path("/GetPatientHRByID")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetPatientHRByIDResponse getPatientHRByID(GetPatientHRByIDRequest request) {
		return null;
	}

	@POST
	@Path("/GetPrintSplitDoctorAdviceOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetPrintSplitDoctorAdviceOfPatientHRResponse getPrintSplitDoctorAdviceOfPatientHR(
			GetPrintSplitDoctorAdviceOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetPatientNoteByID")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetPatientNoteByIDResponse getPatientNoteByID(GetPatientNoteByIDRequest request) {
		return null;
	}

	@POST
	@Path("/UploadOralAccountRecord")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UploadOralAccountRecordResponse UploadOralAccountRecord(UploadOralAccountRecordRequest request) {
		return null;
	}

	@POST
	@Path("/CheckData")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CheckDataResponse CheckData(CheckDataRequest request) {
		return null;
	}

	@POST
	@Path("/AddHivPatient")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AddHivPatientResponse addHivPatient(AddHivPatientRequest request) {
		return null;
	}

	@POST
	@Path("/GetPageDoctorAdviceOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetPageDoctorAdviceOfPatientHRResponse getPageDoctorAdviceOfPatientHR(
			GetPageDoctorAdviceOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetDoctorOrdersTempletList")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDoctorOrdersTempletListResponse getDoctorOrdersTempletList(GetDoctorOrdersTempletListRequest request) {
		return null;
	}

	@POST
	@Path("/GetCheckOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetCheckOfPatientHRResponse getCheckOfPatientHR(GetCheckOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetNursingRecordFileByFileID_New")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetNursingRecordFileByFileID_NewResponse getNursingRecordFileByFileID_New(
			GetNursingRecordFileByFileID_NewRequest request) {
		return null;
	}

	@POST
	@Path("/GetCheckUrlOfPatientHRW")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetCheckUrlOfPatientHRWResponse getCheckUrlOfPatientHRW(GetCheckUrlOfPatientHRWRequest request) {
		return null;
	}

	@POST
	@Path("/TSLogin")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSLoginResponse TSLogin(TSLoginRequest request) {
		return null;
	}

	@POST
	@Path("/GetNursingRecordFile")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetNursingRecordFileResponse getNursingRecordFile(GetNursingRecordFileRequest request) {
		return null;
	}

	@POST
	@Path("/GetNewMessageStatsForDoctor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetNewMessageStatsForDoctorResponse getNewMessageStatsForDoctor(GetNewMessageStatsForDoctorRequest request) {
		return null;
	}

	@POST
	@Path("/TSChangeUserPassword")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSChangeUserPasswordResponse TSChangeUserPassword(TSChangeUserPasswordRequest request) {
		return null;
	}

	@POST
	@Path("/TSGetFuctionModelOfUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSGetFuctionModelOfUserResponse TSGetFuctionModelOfUser(TSGetFuctionModelOfUserRequest request) {
		return null;
	}

	@POST
	@Path("/GetSplitDoctorAdviceForExecute")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetSplitDoctorAdviceForExecuteResponse getSplitDoctorAdviceForExecute(
			GetSplitDoctorAdviceForExecuteRequest request) {
		return null;
	}

	@POST
	@Path("/UpdateNursingRecordItemOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UpdateNursingRecordItemOfPatientHRResponse updateNursingRecordItemOfPatientHR(
			UpdateNursingRecordItemOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/AddFeedbackDetail")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AddFeedbackDetailResponse addFeedbackDetail(AddFeedbackDetailRequest request) {
		return null;
	}

	@POST
	@Path("/TSQueryRegisterByDuration")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSQueryRegisterByDurationResponse TSQueryRegisterByDuration(TSQueryRegisterByDurationRequest request) {
		return null;
	}

	@POST
	@Path("/TSExecuteTransfusionDrugBag")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSExecuteTransfusionDrugBagResponse TSExecuteTransfusionDrugBag(TSExecuteTransfusionDrugBagRequest request) {
		return null;
	}

	@POST
	@Path("/GetTodayNurseStationStatisticsOfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetTodayNurseStationStatisticsOfDepartmentResponse getTodayNurseStationStatisticsOfDepartment(
			GetTodayNurseStationStatisticsOfDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/GetPatientExecutionRecordByDuration")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetPatientExecutionRecordByDurationResponse getPatientExecutionRecordByDuration(
			GetPatientExecutionRecordByDurationRequest request) {
		return null;
	}

	@POST
	@Path("/GetNursingRecordScheduleOfUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetNursingRecordScheduleOfUserResponse getNursingRecordScheduleOfUser(
			GetNursingRecordScheduleOfUserRequest request) {
		return null;
	}

	@POST
	@Path("/TSAddDragBugToTransfusionRegister")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSAddDragBugToTransfusionRegisterResponse TSAddDragBugToTransfusionRegister(
			TSAddDragBugToTransfusionRegisterRequest request) {
		return null;
	}

	@POST
	@Path("/GetNursingRecordType_New")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetNursingRecordType_NewResponse getNursingRecordType_New(GetNursingRecordType_NewRequest request) {
		return null;
	}

	@POST
	@Path("/TSGetNurseOfDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSGetNurseOfDepartmentResponse TSGetNurseOfDepartment(TSGetNurseOfDepartmentRequest request) {
		return null;
	}

	@POST
	@Path("/GetEMRReportContent")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetEMRReportContentResponse getEMRReportContent(GetEMRReportContentRequest request) {
		return null;
	}

	@POST
	@Path("/TSQueryPrescriptionWithInsuranceID")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSQueryPrescriptionWithInsuranceIDResponse TSQueryPrescriptionWithInsuranceID(
			TSQueryPrescriptionWithInsuranceIDRequest request) {
		return null;
	}

	@POST
	@Path("/GetVitalSignOfPatientHRAtTimePoint")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetVitalSignOfPatientHRAtTimePointResponse getVitalSignOfPatientHRAtTimePoint(
			GetVitalSignOfPatientHRAtTimePointRequest request) {
		return null;
	}

	@POST
	@Path("/GetSpecialDoctorOrder")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetSpecialDoctorOrderResponse getSpecialDoctorOrder(GetSpecialDoctorOrderRequest request) {
		return null;
	}

	@POST
	@Path("/TSHandlePatientCall")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSHandlePatientCallResponse TSHandlePatientCall(TSHandlePatientCallRequest request) {
		return null;
	}

	@POST
	@Path("/DeleteOralAccountRecord")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DeleteOralAccountRecordResponse deleteOralAccountRecord(DeleteOralAccountRecordRequest request) {
		return null;
	}

	@POST
	@Path("/GetAnesthesiaRecord")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetAnesthesiaRecordResponse getAnesthesiaRecord(GetAnesthesiaRecordRequest request) {
		return null;
	}

	@POST
	@Path("/GetZhiXingKeShi_YiZhu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetZhiXingKeShi_YiZhuResponse getZhiXingKeShi_YiZhu(GetZhiXingKeShi_YiZhuRequest request) {
		return null;
	}

	@POST
	@Path("/RegisterDevice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RegisterDeviceResponse registerDevice(RegisterDeviceRequest request) {
		return null;
	}

	@POST
	@Path("/UpdatePatientNote")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UpdatePatientNoteResponse updatePatientNote(UpdatePatientNoteRequest request) {
		return null;
	}

	@POST
	@Path("/TSQueryRegisterByInusuranceID")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSQueryRegisterByInusuranceIDResponse TSQueryRegisterByInusuranceID(
			TSQueryRegisterByInusuranceIDRequest request) {
		return null;
	}

	@POST
	@Path("/DelRequestTestItemsOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DelRequestTestItemsOfPatientHRResponse delRequestTestItemsOfPatientHR(
			DelRequestTestItemsOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/ZuoFeiDoctorAdviceOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ZuoFeiDoctorAdviceOfPatientHRResponse ZuoFeiDoctorAdviceOfPatientHR(
			ZuoFeiDoctorAdviceOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/TSQueryNurseWorkDetail")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSQueryNurseWorkDetailResponse TSQueryNurseWorkDetail(TSQueryNurseWorkDetailRequest request) {
		return null;
	}

	@POST
	@Path("/GetDoctorAdviceOfPatientHRForExecute")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDoctorAdviceOfPatientHRForExecuteResponse getDoctorAdviceOfPatientHRForExecute(
			GetDoctorAdviceOfPatientHRForExecuteRequest request) {
		return null;
	}

	@POST
	@Path("/DeleteDoctorOrdersTemplete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DeleteDoctorOrdersTempleteResponse deleteDoctorOrdersTemplete(DeleteDoctorOrdersTempleteRequest request) {
		return null;
	}

	@POST
	@Path("/TSDispenseTransfusionDrugBagWithBarCode")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSDispenseTransfusionDrugBagWithBarCodeResponse TSDispenseTransfusionDrugBagWithBarCode(
			TSDispenseTransfusionDrugBagWithBarCodeRequest request) {
		return null;
	}

	@POST
	@Path("/AddDrugPrecriptionOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AddDrugPrecriptionOfPatientHRResponse addDrugPrecriptionOfPatientHR(
			AddDrugPrecriptionOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetNurseStationStatistics")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetNurseStationStatisticsResponse getNurseStationStatistics(GetNurseStationStatisticsRequest request) {
		return null;
	}

	@POST
	@Path("/VerifyDoctorAdviceLabelID")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public VerifyDoctorAdviceLabelIDResponse verifyDoctorAdviceLabelID(VerifyDoctorAdviceLabelIDRequest request) {
		return null;
	}

	@POST
	@Path("/TSGetRegisterByBarID")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSGetRegisterByBarIDResponse TSGetRegisterByBarID(TSGetRegisterByBarIDRequest request) {
		return null;
	}

	@POST
	@Path("/TSChangeRegisterUseSeatToAnother")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSChangeRegisterUseSeatToAnotherResponse TSChangeRegisterUseSeatToAnother(
			TSChangeRegisterUseSeatToAnotherRequest request) {
		return null;
	}

	@POST
	@Path("/DelBloodApplyOfPatientHR")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DelBloodApplyOfPatientHRResponse delBloodApplyOfPatientHR(DelBloodApplyOfPatientHRRequest request) {
		return null;
	}

	@POST
	@Path("/GetMeasureTemperatureList")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetMeasureTemperatureListResponse getMeasureTemperatureList(GetMeasureTemperatureListRequest request) {
		return null;
	}

	@POST
	@Path("/GetConsulListOfReplyDept")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetConsulListOfReplyDeptResponse getConsulListOfReplyDept(GetConsulListOfReplyDeptRequest request) {
		return null;
	}

	@POST
	@Path("/TSUpdateSeatPosition")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSUpdateSeatPositionResponse TSUpdateSeatPosition(TSUpdateSeatPositionRequest request) {
		return null;
	}

	@POST
	@Path("/TSContinueTransfusion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TSContinueTransfusionResponse TSContinueTransfusion(TSContinueTransfusionRequest request) {
		return null;
	}
	
	/**
	 * 获取医嘱状态字典
	 * 
	 * @return
	 */
	@POST
	@Path("/GetOrderStatusDic")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDCMbUdidocResponse getOrderStatusDic() {
		try {
			return ServiceFinder.find(IMpMbQueryService.class).getOrderStatusDic();
		} catch (Exception e) {
			LogUtils.logStack(e, null);
			return new GetDCMbUdidocResponse();
		}
	}

	/**
	 * 获取体征采集时间字典
	 * 
	 * @return
	 */
	@POST
	@Path("/GetTimeOfSignDic")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetDCVisTimePointResponse getTimeOfSignDic() {
		try {
			return ServiceFinder.find(IMpMbQueryService.class).getTimeOfSign();
		} catch (Exception e) {
			LogUtils.logStack(e, null);
			return new GetDCVisTimePointResponse();
		}
	}
	
	/**
	 * 获取自定义项体温单表格格式
	 * 
	 * @return
	 */
	@POST
	@Path("/GetZdTemperatureDisplayColumn")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetZdTemperatureDisplayColumnResponse GetZdTemperatureDisplayColumn(GetZdTemperatureDisplayColumnRequest request) {
		try {
			return ServiceFinder.find(ICiMbQueryService.class).getZDTemperatureDisplayColumn(request.getP_id(),request.getVisit_id());
		} catch (Exception e) {
			LogUtils.logStack(e, null);
			return new GetZdTemperatureDisplayColumnResponse();
		}
	}
	
	/**
	 * 体温单显示
	 * @param request
	 * @return
	 */
	@POST
	@Path("/Temchart")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public iih.mp.mb.i.TemchartResponse temchart(iih.mp.mb.i.TemchartRequest request) {
		try {
			return ServiceFinder.find(IMpMbQueryService.class).temchart(request.getPatientID());
		} catch (Exception e) {
			LogUtils.logStack(e, request);
			iih.mp.mb.i.TemchartResponse rtn = new iih.mp.mb.i.TemchartResponse();
			return rtn;
		}
	}


}