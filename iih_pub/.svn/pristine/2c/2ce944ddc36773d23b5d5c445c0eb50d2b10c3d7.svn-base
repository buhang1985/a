package iih.pe.listener;

import iih.en.pv.inpatient.d.InpatientDO;
import iih.pe.listener.bp.GetInpatientDOBp;
import iih.pe.pwf.dto.checkreportinfodto.d.CheckItemEntryDTO;
import iih.pe.pwf.dto.checkreportinfodto.d.CheckReportInfoDTO;
import iih.pe.pwf.dto.checkreportinfodto.d.RelMedAdviceDTO;
import iih.pe.pwf.dto.checkreportinfodto.d.ReportDoctorDTO;
import iih.pe.pwf.dto.checkreportinfodto.d.ReviewDoctorDTO;
import iih.pe.pwf.perstris.d.PeRstRisDO;
import iih.pe.pwf.perstris.i.IPerstrisCudService;
import iih.pe.pwf.perstris.i.IPerstrisRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 检查报告信息新增监听
 * @author guo.s
 *
 */
public class CriAddAfterListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//1.验证事件,是否匹配
		if(!(event.getSourceID().equals("iih.pe.pwf.dto.checkreportinfodto.d.CheckReportInfoDTO") && event.getEventType().equals(IEventType.TYPE_INSERT_AFTER))){
			return;
		}
		//2.获取平台根据xml转换得到的dto对象
		FArrayList2 checkReportInfoDTOs = (FArrayList2) event.getUserObject();;
		if(checkReportInfoDTOs.isEmpty()){
			return;
		}
		CheckReportInfoDTO cri = (CheckReportInfoDTO) checkReportInfoDTOs.get(0);
		//3.判断是否应该处理该dto(id_ent有值才处理)
		String id_ent = getIdEnt(cri);
		if(id_ent==null){
			return;
		}
		//4.转换dto对象并保存
		doActionCheckReportInfoDTOAdd(cri,id_ent);
	}
	
	private String getIdEnt(CheckReportInfoDTO cri) throws BizException {
		String id_ent = null;
		String patientdomain = cri.getPatientdomain();
		if("02".equals(patientdomain)){
			GetInpatientDOBp bp = new GetInpatientDOBp();
			int visittimes = 1;//若未设置就诊次数,则默认为1
			if(cri.getVisittimes()!=null){
				visittimes = cri.getVisittimes();
			}
			InpatientDO[] inpatientDOs = bp.exec(cri.getMedicalno(),visittimes);
			if(inpatientDOs.length>0){
				id_ent = inpatientDOs[0].getId_ent();
			}
		}
		return id_ent;
	}
	
	private void doActionCheckReportInfoDTOAdd(CheckReportInfoDTO cri,String id_ent) throws BizException{
		IPerstrisRService perstrisRService = ServiceFinder.find(IPerstrisRService.class);
		IPerstrisCudService perstrisCudService = ServiceFinder.find(IPerstrisCudService.class);
		//1.将CheckReportInfoDTO转为PeRstRisDO
		PeRstRisDO peRstRisDO = new PeRstRisDO();
		peRstRisDO.setStatus(DOStatus.NEW);
		peRstRisDO.setId_pepsnappt(id_ent);//体检预约单
		peRstRisDO.setPatient_id(cri.getPatientlid());//患者ID
		peRstRisDO.setIn_patient_no(cri.getMedicalno());//患者住院号
		peRstRisDO.setVisit_times(cri.getVisittimes());//患者住院次数
		peRstRisDO.setPatient_name(cri.getPatientname());//患者姓名
		peRstRisDO.setGender(cri.getGendername());//性别		???
		peRstRisDO.setAge(cri.getPatientage());//年龄
		peRstRisDO.setBed_no(cri.getBedno());//床号
		
		FArrayList relmedadvices = cri.getRelmedadvice();
		StringBuffer id_ors = new StringBuffer();
		if(relmedadvices!=null){
			for (Object object : relmedadvices) {
				RelMedAdviceDTO relMedAdviceDTO = (RelMedAdviceDTO) object;
				id_ors.append(relMedAdviceDTO.getRelmedadviceno()).append(",");
			}
		}
		if(id_ors.length()>0){
			id_ors.deleteCharAt(id_ors.length()-1);
		}
		peRstRisDO.setId_or(id_ors.toString());//医嘱号
		
//		peRstRisDO.setPacs_patient_id(?);//PACS系统中患者标识
		String reportno = cri.getReportno();
		peRstRisDO.setAccession_number(reportno);//PACS系统产生的报告号
		
		//文档的操作版本versionNumber		新增:0	修改:1
		//决定0的时候新增peRstRisDO,1的时候根据报告号删除,然后新增peRstRisDO
		//因文档检查报告信息服务和检验报告信息服务的versionNumber不一致(一个是0,1;一个是0,1,2),
		//暂决定不使用versionNumber,一律根据报告号查询PeRstRisDO,查得到就删,然后new一个;查不到就直接new一个
//		String versionNumber = cri.getVersionnumber();
		PeRstRisDO[] peRstRisDOs = perstrisRService.find(String.format(" accession_number = '%s' ", reportno), "", FBoolean.FALSE);
		if(peRstRisDOs != null && peRstRisDOs.length>0){
			perstrisCudService.delete(peRstRisDOs);
		}
		
//		peRstRisDO.setCheck_no(?);//申请序号
		String cktypename = null;//检查类别
		
		FArrayList ckitementry = cri.getCkitementry();
		StringBuffer positions = new StringBuffer();
		StringBuffer contents = new StringBuffer();
		StringBuffer summarys = new StringBuffer();
		StringBuffer code_checkitems = new StringBuffer();
		StringBuffer name_checkitems = new StringBuffer();
		StringBuffer code_methods = new StringBuffer();
		StringBuffer name_methods = new StringBuffer();
		if(ckitementry!=null){
			for (Object object : ckitementry) {
				CheckItemEntryDTO checkItemEntryDTO = (CheckItemEntryDTO) object;
				cktypename = checkItemEntryDTO.getCktypename();
				positions.append(checkItemEntryDTO.getCkpartname()).append(",");
				contents.append(checkItemEntryDTO.getCkrptobjectivename()).append(",");
				summarys.append(checkItemEntryDTO.getCkrptsubjectivename()).append(",");
				code_checkitems.append(checkItemEntryDTO.getCkitemcode()).append(",");
				name_checkitems.append(checkItemEntryDTO.getCkitemname()).append(",");
				code_methods.append(checkItemEntryDTO.getCkmethodcode()).append(",");
				name_methods.append(checkItemEntryDTO.getCkmethodname()).append(",");
			}
		}
		if(positions.length()>0){
			positions.deleteCharAt(positions.length()-1);
		}
		peRstRisDO.setPosition(positions.toString());//检查部位
		peRstRisDO.setType(cktypename);
		
//		peRstRisDO.setIs_bed_side(?);//是否床旁检查标识
//		peRstRisDO.setIs_emergy(?);//是否紧急标识
//		peRstRisDO.setPurpose(?);//检查目的
//		peRstRisDO.setSymptom(?);//患者症状
//		peRstRisDO.setVital_signs(?);//患者生命体征
		peRstRisDO.setDiagnosis(cri.getDiseasename());//患者临床诊断
//		peRstRisDO.setAssociate_test_result(?);//相关检查结果
		
		if(contents.length()>0){
			contents.deleteCharAt(contents.length()-1);
		}
		if(summarys.length()>0){
			summarys.deleteCharAt(summarys.length()-1);
		}
		peRstRisDO.setContent(contents.toString());//报告内容
		peRstRisDO.setSummary(summarys.toString());//医生说明
		
//		peRstRisDO.setApply_dept_code(?);//申请科室编码
//		peRstRisDO.setApply_dept_name(?);//申请科室名称
		peRstRisDO.setApply_doctor_code(cri.getAppdoccode());//申请医生编码
		peRstRisDO.setApply_doctor_name(cri.getAppdocname());//申请医生姓名
//		peRstRisDO.setApply_date(?);//申请时间
		
		FArrayList rptdoc = cri.getRptdoc();
		StringBuffer report_doctor_codes = new StringBuffer();
		StringBuffer report_doctor_names = new StringBuffer();
		if(rptdoc!=null){
			for (Object object : rptdoc) {
				ReportDoctorDTO reportDoctorDTO = (ReportDoctorDTO) object;
				report_doctor_codes.append(reportDoctorDTO.getRptdoccode()).append(",");
				report_doctor_names.append(reportDoctorDTO.getRptdocname()).append(",");
			}
		}
		if(report_doctor_codes.length()>0){
			report_doctor_codes.deleteCharAt(report_doctor_codes.length()-1);
		}
		if(report_doctor_names.length()>0){
			report_doctor_names.deleteCharAt(report_doctor_names.length()-1);
		}
		peRstRisDO.setReport_doctor_code(report_doctor_codes.toString());//报告医生编码
		peRstRisDO.setReport_doctor_name(report_doctor_names.toString());//报告医生姓名
		peRstRisDO.setReport_date(((ReportDoctorDTO)rptdoc.get(0)).getRptdatetime());//报告时间
		
		FArrayList rvdoc = cri.getRvdoc();
		StringBuffer verify_docotr_codes = new StringBuffer();
		StringBuffer verify_docotr_names = new StringBuffer();
		if(rvdoc!=null){
			for (Object object : rvdoc) {
				ReviewDoctorDTO reviewDoctorDTO = (ReviewDoctorDTO) object;
				verify_docotr_codes.append(reviewDoctorDTO.getRvdoccode()).append(",");
				verify_docotr_names.append(reviewDoctorDTO.getRvdocname()).append(",");
			}
		}
		if(verify_docotr_codes.length()>0){
			verify_docotr_codes.deleteCharAt(verify_docotr_codes.length()-1);
		}
		if(verify_docotr_names.length()>0){
			verify_docotr_names.deleteCharAt(verify_docotr_names.length()-1);
		}
		peRstRisDO.setVerify_docotr_code(verify_docotr_codes.toString());//审核医生编码
		peRstRisDO.setVerify_doctor_name(verify_docotr_names.toString());//审核医生姓名
		peRstRisDO.setVerify_date(((ReviewDoctorDTO)rvdoc.get(0)).getRvdatetime());//审核时间
		
		if(code_checkitems.length()>0){
			code_checkitems.deleteCharAt(code_checkitems.length()-1);
		}
		if(name_checkitems.length()>0){
			name_checkitems.deleteCharAt(name_checkitems.length()-1);
		}
		peRstRisDO.setCode_checkitem(code_checkitems.toString());//检查项目编码
		peRstRisDO.setName_checkitem(name_checkitems.toString());//检查项目名称
		
		peRstRisDO.setFg_received(new FBoolean(true));//接收完成标识
		peRstRisDO.setDt_received(new FDateTime());//接收时间
		
		if(code_methods.length()>0){
			code_methods.deleteCharAt(code_methods.length()-1);
		}
		if(name_methods.length()>0){
			name_methods.deleteCharAt(name_methods.length()-1);
		}
		peRstRisDO.setCode_method(code_methods.toString());//检查方法编码
		peRstRisDO.setName_method(name_methods.toString());//检查方法名称
		
//		peRstRisDO.setState(?);//状态
		//2.保存PeRstRisDO
		perstrisCudService.save(new PeRstRisDO[]{peRstRisDO});
	}

}
