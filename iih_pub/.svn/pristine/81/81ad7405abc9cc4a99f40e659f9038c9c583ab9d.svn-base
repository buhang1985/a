package iih.mp.mb;

import iih.mp.mb.dto.bcvalparam.d.BcValParamDTO;
import iih.mp.mb.i.AddChargeItemRequest;
import iih.mp.mb.i.AddChargeItemResponse;
import iih.mp.mb.i.ArrayOfDocNode;
import iih.mp.mb.i.DCNursingTour;
import iih.mp.mb.i.DelChargeItemResponse;
import iih.mp.mb.i.DeleteTemplateHistoryResponse;
import iih.mp.mb.i.NurseExcutePatientDoctorAdviceRequest;
import iih.mp.mb.i.NurseExcutePatientDoctorAdviceResponse;
import iih.mp.mb.i.PSMPatientDischargerResponse;
import iih.mp.mb.i.PSMPatientEnterDeptRequest;
import iih.mp.mb.i.PSMPatientEnterDeptResponse;
import iih.mp.mb.i.PSMReplyTansDeptApplyResponse;
import iih.mp.mb.i.PSMSaveTransDeptApplyResponse;
import iih.mp.mb.i.PiShiResultInsertRequest;
import iih.mp.mb.i.PrintPatientTestInformationResponse;
import iih.mp.mb.i.SaveNurseDispensationRequest;
import iih.mp.mb.i.SaveNurseDispensationResponse;
import iih.mp.mb.i.SavePatientInfusionTourRequest;
import iih.mp.mb.i.SavePatientInfusionTourResponse;
import iih.mp.mb.i.SavePatientNursingTourCommentResponse;
import iih.mp.mb.i.SavePatientNursingTourResponse;
import iih.mp.mb.i.UpdateDutyNurseResponse;
import iih.mp.mb.i.UpdateVitalSignOfPatientHRRequest;
import iih.mp.mb.i.UpdateVitalSignOfPatientHRResponse;
import iih.mp.mb.i.UpdateVitalSignOfPatientWSResponse;
import iih.mp.mb.keyboard.d.KeyboardAggDO;

import java.util.List;

import org.json.JSONException;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

public interface IMpMbMaintanceService {

	/**
	 * 修复条码对照
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract List<String> repariedBarCode(FDateTime dt_begin,FDateTime dt_end)  throws BizException;
	
	/**
	 * 条码对照
	 * 
	 * @param sd_bctp
	 * @param params
	 * @throws BizException
	 */
	public abstract void barCodeContrast(String sd_bctp, BcValParamDTO[] params) throws BizException;

	/**
	 * 护士执行医嘱
	 * 
	 * @param request
	 * @return
	 * @throws BizException
	 */
	public abstract NurseExcutePatientDoctorAdviceResponse nurExcOrder(NurseExcutePatientDoctorAdviceRequest request) throws BizException;

	/**
	 * 录皮试结果
	 * 
	 * @param request
	 * @throws BizException
	 */
	public abstract void saveSkinResult(PiShiResultInsertRequest request) throws BizException;

	/**
	 * 更新患者体征信息
	 * 
	 * @param request
	 * @return
	 * @throws BizException
	 */
	public abstract UpdateVitalSignOfPatientHRResponse saveVitalSign(UpdateVitalSignOfPatientHRRequest request) throws BizException;

	/**
	 * 
	 * 护理巡房保存
	 * 
	 * @param UDID
	 * @param comment
	 * @param date
	 * @return
	 * @throws BizException
	 */
	public SavePatientNursingTourResponse savePrtrolInfo(DCNursingTour request) throws BizException;

	/**
	 * 巡房备注保存
	 * 
	 * @param id_patrol
	 * @param note
	 * @return
	 * @throws BizException
	 */
	public abstract SavePatientNursingTourCommentResponse savePatrolNote(String id_patrol, String note, String date) throws BizException;

	/**
	 * 设置我的患者
	 * 
	 * @param id_ents
	 * @return
	 * @throws BizException
	 */
	public abstract UpdateDutyNurseResponse setMyPatient(String id_ents, String nurseSn) throws BizException;

	/**
	 * 条码对照重新生成
	 * 
	 * @param id_mb_bc_vals
	 * @throws BizException
	 */
	public abstract void reBuildBc(String[] id_mb_bc_vals) throws BizException, JSONException;

	/**
	 * 输液巡视保存
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract SavePatientInfusionTourResponse saveInfusionPatrol(SavePatientInfusionTourRequest param) throws BizException;

	/**
	 * 体温单辅助录入键盘生成逻辑
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract KeyboardAggDO generalTempKeyBoard(KeyboardAggDO keyboardAgg) throws BizException;

	/**
	 * 患者入科
	 * 
	 * @param patientId
	 *            PID
	 * @param times
	 *            次数
	 * @param locationNo
	 *            分配的床号
	 * @param svcLocationId
	 *            分配的资源
	 * @param doctorCode
	 *            主管医生
	 * @param nurseCode
	 *            主管护士
	 * @param operaCode
	 *            操作人
	 * @return
	 */
	public abstract PSMPatientEnterDeptResponse savePSMPatientEnterDept(PSMPatientEnterDeptRequest request) throws BizException;

	/**
	 * 转科转入确认(动作)
	 * 
	 * @param id_pat
	 *            患者ID
	 * @param codeBed
	 *            床位编码
	 * @param id_dep_nur
	 *            病区ID
	 * @param fgPri
	 *            专用医疗组
	 * @param id_wg
	 *            医疗组ID
	 * @param id_zr_doc
	 *            主任医师ID
	 * @param id_zz_doc
	 *            主治医师ID
	 * @param id_zy_doc
	 *            住院医师ID
	 * @param id_emp_phy
	 *            责任医生ID
	 * @param id_emp_nur
	 *            责任护士ID
	 * @return
	 * @throws BizException
	 */
	public abstract PSMReplyTansDeptApplyResponse ReplyTransInApply(String id_pat, String codeBed, String id_dep_nur, boolean fgPri, String id_wg, String id_zr_doc, String id_zz_doc, String id_zy_doc, String id_emp_phy, String id_emp_nur) throws BizException;

	/**
	 * 出科
	 * @param wardCode
	 * @param patientId
	 * @param dischargerTime
	 * @return
	 * @throws BizException
	 */
	public abstract PSMPatientDischargerResponse PSMPatientDischarger(String id_ent, String id_dep_nur, String dt_effe) throws BizException;

//	/**
//	 * 转科转出确认
//	 * 
//	 * @param id_ent
//	 * @return
//	 * @throws BizException
//	 */
//	public abstract PSMSaveTransDeptApplyResponse applyTransDep(String id_ent) throws BizException;

	/**
	 * 配药登记保存
	 * 
	 * @param request
	 * @return
	 * @throws BizException
	 */
	public abstract SaveNurseDispensationResponse saveNurseDispensation(SaveNurseDispensationRequest request) throws BizException;

	/**
	 * 文书保存
	 * 
	 * @param docnode
	 * @param nid
	 * @return
	 */
	public abstract UpdateVitalSignOfPatientWSResponse saveNmrDocData(ArrayOfDocNode docnode, String nid) throws BizException;

	/**
	 * 检验采集保存
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract PrintPatientTestInformationResponse sampleCollSave(String no_bars, String dt_mp) throws BizException;

	/**
	 * 文书删除
	 * @param templateId
	 * @param nid
	 * @return
	 */
	public abstract DeleteTemplateHistoryResponse deleteNmrDocData(String templateId, String nid) throws BizException;

//	/**
//	 * 删除补费项目（即退费）
//	 * @param detailSn
//	 * @param id_ent 
//	 * @param num 
//	 * @return
//	 * @throws BizException 
//	 */
//	public abstract DelChargeItemResponse DelChargeItem(String detailSn, String id_ent, String num) throws BizException;
//
//	/**
//	 * 费用补录
//	 * @param request
//	 * @return
//	 * @throws BizException 
//	 */
//	public abstract AddChargeItemResponse AddChargeItem(AddChargeItemRequest request) throws BizException;
		
	}
