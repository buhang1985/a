package iih.pe.listener;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;
import iih.pe.listener.PeRptConst.PeExamRptConst;
import iih.pe.listener.qry.ExamInfoQry;
import iih.pe.listener.qry.PhyExamInfoQry;
import iih.pe.listener.qry.PhysicalExamInfoQry;
import iih.pe.listener.qry.SubItemQry;
import iih.pe.papt.pepsnappt.d.PePsnApptDO;
import iih.pe.papt.pepsnappt.d.PeStatusEnum;
import iih.pe.papt.pepsnappt.d.desc.PePsnApptDODesc;
import iih.pe.por.pepsnbinfo.d.PePsnBInfoDO;
import iih.pe.por.pepsnbinfo.i.IPepsnbinfoMDORService;
import iih.pe.pwf.pereportbi.d.PeReportBiDO;
import iih.pe.pwf.pereportbi.i.IPereportbiRService;
import iih.pe.pwf.perstdiagsugg.d.PeRstDiagSuggDO;
import iih.pe.pwf.perstdiagsugg.i.IPerstdiagsuggMDORService;
import iih.pe.pwf.pewfoval.d.PeWfOvalDO;
import iih.pe.pwf.pewfoval.i.IPewfovalRService;
import iih.pe.pwf.phyexamrptdto.d.ExamInfo;
import iih.pe.pwf.phyexamrptdto.d.LabInfo;
import iih.pe.pwf.phyexamrptdto.d.LabSubItemInfo;
import iih.pe.pwf.phyexamrptdto.d.PhyExamInfo;
import iih.pe.pwf.phyexamrptdto.d.PhyExamRptDto;
import iih.pe.pwf.phyexamrptdto.d.PhysicalExamInfo;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.util.AgeCalcUtil;

	
	/**
	 * 总检医生站点击确认后触发上传事件
	 * 执行
	 * @param event 事件
	 **/

public class PeRptDOVerifyAfterListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//修改时候触发
		if(!(event.getSourceID().equals(PePsnApptDODesc.CLASS_FULLNAME) && event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER))) {
			return;
		}
		
		//体检个人预约单
		PePsnApptDO[] apptPsnDosNew = (PePsnApptDO[])((BDCommonEvent)event).getNewObjs();
		PePsnApptDO[] apptPsnDosOld = (PePsnApptDO[])((BDCommonEvent)event).getOldObjs();
		
		//非总检审核的时候不触发
		if(!apptPsnDosNew[0].getPestatus().equals(PeStatusEnum.PEOVALAUDI)) {
			return;
		}
		
		if(ArrayUtil.isEmpty(apptPsnDosNew)||ArrayUtil.isEmpty(apptPsnDosOld)) {
			return;
		}
		
		//执行状态修改后体检报告信息上传操作
		this.doActionPeRptDOChange(apptPsnDosNew,apptPsnDosOld);
	}
	
	/**
	 * 总检确认后执行其他业务处理
	 * @param apptPsnDosNew
	 * @param apptPsnDosOld
	 * @throws BizException 
	 */
	protected  void doActionPeRptDOChange(PePsnApptDO[] apptPsnDosNew, PePsnApptDO[] apptPsnDosOld) throws BizException{		
		if(ArrayUtil.isEmpty(apptPsnDosOld) || ArrayUtil.isEmpty(apptPsnDosNew)){
			return;
		}
		//获取当前总检确认的体检者
		PePsnApptDO apptDo = apptPsnDosNew[0];
		
		//组装体检报告信息DTO
		PhyExamRptDto examRptDto = setValueForPhyExamRptDto(apptDo);
		
		//发送到集成平台
		firePeRpt(examRptDto, apptDo);
	}
	
	@SuppressWarnings("unchecked")
	private PhyExamRptDto setValueForPhyExamRptDto(PePsnApptDO apptDo) throws BizException {
		PhyExamRptDto rptDto = new PhyExamRptDto();
		
		IPepsnbinfoMDORService pepsnbinfoMDORService = ServiceFinder.find(IPepsnbinfoMDORService.class);
		String whereStr = "id_pepsnbinfo = ?";
		SqlParamDTO sqlParam = new SqlParamDTO();
		sqlParam.addParam(apptDo.getId_pepsnbinfo());
		PePsnBInfoDO psnDos = pepsnbinfoMDORService.findById(apptDo.getId_pepsnbinfo());
		if(psnDos == null) {
			return null;
		}
		IPewfovalRService pewfovalRService = ServiceFinder.find(IPewfovalRService.class);
		PeWfOvalDO[] ovalDos = pewfovalRService.find("id_pepsnappt = '" + apptDo.getId_pepsnappt() + "'", "", FBoolean.FALSE);
		
		IPerstdiagsuggMDORService perstdiagsuggMDORService = ServiceFinder.find(IPerstdiagsuggMDORService.class);
		PeRstDiagSuggDO[] rstDiagSuggs = perstdiagsuggMDORService.find("id_pepsnappt = '" + apptDo.getId_pepsnappt() + "' and fg_oval = 'Y'", "", FBoolean.FALSE);
		
		//体检报告相关服务
		IPereportbiRService pereportbiRService = ServiceFinder.find(IPereportbiRService.class);
		PeReportBiDO[] reportBiDos = pereportbiRService.find("id_pepsnappt = '" + apptDo.getId_pepsnappt() + "'", "", FBoolean.FALSE);
		
		rptDto.setVersion_number(PeExamRptConst.VERSION_NUMBER_UPDATE);//文档操作版本
		rptDto.setSignature_id("");//电子签章号
		rptDto.setReport_id(apptDo.getPe_code());//报告号，体检系统使用check_id唯一标识报告
		if(!ArrayUtil.isEmpty(ovalDos)){
			rptDto.setEffective_time(ovalDos[0].getDt_print() == null ? new FDateTime() : ovalDos[0].getDt_print());//文档生效日期,总检确认后，认为文档生效
			rptDto.setReport_date(ovalDos[0].getDt_audit() == null ? new FDate() : ovalDos[0].getDt_audit().getDate());//报告日期
			rptDto.setReporter_id(ovalDos[0].getId_doc_audit() == null ? "doc" : ovalDos[0].getCode_aduit());//报告医生编码
			rptDto.setReporter_name(ovalDos[0].getName_aduit() == null ? "doc" : ovalDos[0].getName_aduit());//报告医生名称
		}
		rptDto.setDocument_name(PeExamRptConst.DOCUMENT_NAME);//文档标题
		//rptDto.setPatient_domain(PeExamRptConst.PATIENT_DOMAIN_PE);//域id
		rptDto.setPatient_domain(PeExamRptConst.PATIENT_DOMAIN_HIS);//域id
		rptDto.setPatient_lid(psnDos.getCode() == null ? "code" : psnDos.getCode());//患者id
		rptDto.setMedical_no(psnDos.getCode() == null ? "code" : psnDos.getCode());//就诊号

		rptDto.setPhysical_exa_no(apptDo.getPe_code());//体检号码
		rptDto.setVisit_times(apptDo.getPe_times());//就诊次数
		rptDto.setVisit_ord_no(apptDo.getPe_code());//就诊流水号
		rptDto.setVisit_type(PeExamRptConst.VISIT_TYPE);//就诊类别编码
		rptDto.setVisit_type_name(PeExamRptConst.VISIT_TYPE_NAME);
		rptDto.setPhysical_exa_date(apptDo.getDt_reg() == null ? new FDateTime() : apptDo.getDt_reg());//体检日期
		rptDto.setPatient_name(psnDos.getName());//患者姓名
		rptDto.setIdentity_card(psnDos.getIdcode());//身份证号
		rptDto.setGender_code(psnDos.getCode_sex());//性别编码
		if(psnDos.getCode_sex() != null){
			if(psnDos.getCode_sex().equalsIgnoreCase("1")){
				rptDto.setGender_name("男");
			}else if(psnDos.getCode_sex().equalsIgnoreCase("2")){
				rptDto.setGender_name("女");
			}else{
				rptDto.setGender_name("未知");
			}
		}else{
			rptDto.setGender_name("未知");
		}
		rptDto.setMaritalstatuscode("90");//性别编码
		rptDto.setMaritalstatusname("未说明婚姻状况");
		rptDto.setBirth_date(psnDos.getDt_birth() == null ? new FDate() : psnDos.getDt_birth());//出生日期
		rptDto.setAge(psnDos.getAge() != null ? String.valueOf(psnDos.getAge()) : AgeCalcUtil.getAge(psnDos.getDt_birth()));//年龄
		rptDto.setTelephone_no(psnDos.getMob() == null ? "" : psnDos.getMob());//电话
		rptDto.setCompany(psnDos.getWorkunit() == null ? "" : psnDos.getWorkunit());
		OrgDO orgDO = ServiceFinder.find(IOrgRService.class).findById(apptDo.getId_org());
		rptDto.setOrg_code(orgDO.getCode());
		rptDto.setOrg_name(orgDO.getName());
		if(!ArrayUtil.isEmpty(reportBiDos)){
			rptDto.setDoc_image_format("application/pdf");//PDF格式：application/pdf
			rptDto.setDoc_image_content(reportBiDos[0].getFmt_pdf_base64());//图像编码
		}else {
			rptDto.setDoc_image_format("application/founder.url");//PDF格式：application/pdf
			rptDto.setDoc_image_content("http://localhost/");//图像编码
		}
		
		rptDto.setType_message("04");//集成平台消息类型 --未分类
		StringBuffer diags = new StringBuffer();
		StringBuffer suggs = new StringBuffer();
		for (PeRstDiagSuggDO peRstDiagSuggDO : rstDiagSuggs) {
			if(peRstDiagSuggDO.getDiag() != null && peRstDiagSuggDO.getSugg() != null){
				diags.append(peRstDiagSuggDO.getDiag() + ";");
				suggs.append(peRstDiagSuggDO.getDiag() + ":" + peRstDiagSuggDO.getSugg() + ";");
			}
		}
		String summarys = "";
		if(diags != null) {
			summarys = "【体检综述】" + diags.toString() + "【体检建议】" + suggs.toString();
		}
		rptDto.setSummary(diags == null ? "" : summarys);//总检结论和建议
		rptDto.setSummary_date(ovalDos[0].getDt_oval() == null ? new FDateTime().toString() : ovalDos[0].getDt_oval().toString());//总检日期
		rptDto.setSummary_doc_id(ovalDos[0].getCode_oval());//主检医生编码
		rptDto.setSummary_doc_name(ovalDos[0].getName_oval());//主检医生编码
		
		//处理子DTO--体格检查信息
		PhysicalExamInfo[] physicalExamInfo = setValueForPhysicalExamInfo(apptDo);
		FArrayList2 physicalExamInfoList = new FArrayList2();
		physicalExamInfoList.addAll(Arrays.asList(physicalExamInfo));
		rptDto.setPhysical_exam_info(physicalExamInfoList);
		
		//处理子DTO--医技检查信息
		ExamInfo[] examInfo = setValueForExamInfo(apptDo);
		FArrayList2 examInfoList = new FArrayList2();
		examInfoList.addAll(Arrays.asList(examInfo));
		rptDto.setExam_info(examInfoList);
		
		//处理子DTO--实验室检查信息
		LabInfo[] labInfo = setValueForLabInfo(apptDo);
		FArrayList2 labInfoList = new FArrayList2();
		labInfoList.addAll(Arrays.asList(labInfo));
		rptDto.setLab_info(labInfoList);
		
		return rptDto;
	}


	/**
	 * 体格检查信息整合
	 * @param apptDo
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private PhysicalExamInfo[] setValueForPhysicalExamInfo(PePsnApptDO apptDo) throws BizException {
		//返回体格检查项目
		PhysicalExamInfo[] physicalExamInfos = 
				(PhysicalExamInfo[]) AppFwUtil.getDORstWithDao(new PhysicalExamInfoQry(apptDo.getId_pepsnappt()), PhysicalExamInfo.class);
		
		//查询子项信息
		for(PhysicalExamInfo physicalExamInfo : physicalExamInfos){
			PhyExamInfo[] phyExamInfos = (PhyExamInfo[]) AppFwUtil.getDORstWithDao(new PhyExamInfoQry(apptDo.getId_pepsnappt(),physicalExamInfo.getItem_code()), PhyExamInfo.class);
			
			PhyExamInfo[] phyExamInfosNew = new PhyExamInfo[phyExamInfos.length];
			for(int i = 0; i < phyExamInfos.length; i++){
				PhyExamInfo phyExam = new PhyExamInfo();
				phyExam.setPhy_exam_code(phyExamInfos[i].getPhy_exam_code());
				phyExam.setPhy_exam_name(phyExamInfos[i].getPhy_exam_name());
				phyExam.setPhy_exam_que_value_unit(phyExamInfos[i].getPhy_exam_que_value_unit());
				phyExam.setPhy_exam_text_value(phyExamInfos[i].getPhy_exam_text_value());
				phyExam.setPhy_exam_value_pq(phyExamInfos[i].getPhy_exam_value_pq());
				phyExam.setPhy_exam_xsitype(phyExamInfos[i].getPhy_exam_xsitype());
				//phyExam.setPhyexaminfo(node);
				phyExamInfosNew[i] = phyExam;
			}
			FArrayList2 phyFList = new FArrayList2();
			phyFList.addAll(Arrays.asList(phyExamInfosNew));
			physicalExamInfo.setPhy_exam_info(phyFList);
		}
		return physicalExamInfos;
	}

	/**
	 * 完善医技检查信息
	 * @param apptDo
	 * @return
	 * @throws BizException 
	 */
	private ExamInfo[] setValueForExamInfo(PePsnApptDO apptDo) throws BizException {
		ExamInfo[] examInfos = (ExamInfo[]) AppFwUtil.getDORstWithDao(new ExamInfoQry(apptDo.getId_pepsnappt()), ExamInfo.class);
		return examInfos;
	}
	
	/**
	 * 整合实验室检查信息
	 * @param apptDo
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private LabInfo[] setValueForLabInfo(PePsnApptDO apptDo) throws BizException {
		//获取实验室检验项目信息
		StringBuffer sql = new StringBuffer();
		sql.append("select catlog.code as Item_code,");
		sql.append("       catlog.name as Item_name,");
		sql.append("       dep.dep_rst as Brief_summary,");
		sql.append("       room.id_doc as Lab_doc_code,");
		sql.append("       s.name      as Lab_doc_name");
		sql.append("  from pe_apt_pepsnapptcat cat");
		sql.append(" inner join pe_itm_pesrvbcatlog catlog");
		sql.append("    on catlog.id_pesrvbcatlog = cat.id_pesrvcatlog");
		sql.append(" inner join pe_bd_deptset depset");
		sql.append("    on depset.id_pedeptset = catlog.id_pedeptset");
		sql.append(" left join pe_wf_pewfdep dep");
		sql.append("    on cat.id_pedeptset = dep.id_pedeptset");
		sql.append("   and cat.id_pepsnappt = dep.id_pepsnappt");
		sql.append(" left join pe_wf_pewfroom room");
		sql.append("    on room.id_pedeptset = dep.id_pedeptset");
		sql.append("   and room.id_pepsnappt = dep.id_pepsnappt");
		sql.append(" left join sys_user s");
		sql.append("    on s.id_user = room.id_doc");
		sql.append(" where cat.id_pepsnappt = '" + apptDo.getId_pepsnappt() + "' and catlog.catlog = 3");

		List<LabInfo> labInfoList = (List<LabInfo>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(LabInfo.class));
		//获取检验子项的信息
		for (LabInfo labInfo : labInfoList) {
			LabSubItemInfo[] subItemList = 
					(LabSubItemInfo[]) AppFwUtil.getDORstWithDao(new SubItemQry(apptDo.getId_pepsnappt(),labInfo.getItem_code()),LabSubItemInfo.class);
			LabSubItemInfo[] subItemListNew = new LabSubItemInfo[subItemList.length];
			for(int i = 0; i <subItemList.length; i++){
				LabSubItemInfo item = new LabSubItemInfo();
				item.setLab_sub_item_code(subItemList[i].getLab_sub_item_code());
				item.setLab_sub_item_name(subItemList[i].getLab_sub_item_name());
				item.setDisplay_order(subItemList[i].getDisplay_order());
				item.setLab_sub_text_value(subItemList[i].getLab_sub_text_value());
				item.setLab_sub_value_pq(subItemList[i].getLab_sub_value_pq());
				item.setLab_sub_que_value_unit(subItemList[i].getLab_sub_que_value_unit());
				item.setLab_sub_item_xsitype(subItemList[i].getLab_sub_item_xsitype());
				item.setReference_range(subItemList[i].getReference_range());
				item.setUnusual_desc(subItemList[i].getUnusual_desc());
				subItemListNew[i] = item;
			}
			
			FArrayList2 subItemFList = new FArrayList2();
			subItemFList.addAll(Arrays.asList(subItemListNew));
			labInfo.setLab_sub_item_info(subItemFList);
		}
		return labInfoList.toArray(new LabInfo[0]);
	}
	
	private Boolean isAllNum(String value) {
		Pattern pattern = Pattern.compile("[0-9]{1,}");  
        Matcher matcher = pattern.matcher((CharSequence) value);  
        return matcher.matches();  
	}

	/**
	 * 发送数据至集成平台
	 * @param phyExamRptDto
	 * @param psnApptDO
	 * @throws BizException
	 */
	private void firePeRpt(PhyExamRptDto phyExamRptDto, PePsnApptDO psnApptDO) throws BizException {
		phyExamRptDto.setId_server("BS347");
		MsgObj msgobj = new MsgObj();
		msgobj.setPatientCode(phyExamRptDto.getPatient_lid());
		msgobj.setInteractionCode(phyExamRptDto.getType_message());
		
		DomainBusinessUserObj buo = new DomainBusinessUserObj(phyExamRptDto, "04", Context.ATTRIBUTE_DEPT_ID, "0");
		buo.setMsgObj(msgobj);
		
		BusinessEvent event = new BusinessEvent(PeExamRptConst.SOURCE_ID_PERPT, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
	}
	
}
