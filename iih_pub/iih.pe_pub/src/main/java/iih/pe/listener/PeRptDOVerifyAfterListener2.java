package iih.pe.listener;

import iih.bd.base.utils.StringCodingUtils;
import iih.ci.mr.middle.cons.d.CiMrMiddleConsDO;
import iih.ci.mr.middle.cons.i.ICimrmiddleconsdoRService;
import iih.ci.mr.middle.d.CiMrVSMiddleDO;
import iih.ci.mr.middle.i.ICimrvsmiddleRService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.pe.comm.utils.PEParamUtils;
import iih.pe.listener.qry.GetNormalInfoQry;
import iih.pe.listener.qry.GetSpecialInfoQry;
import iih.pe.listener.qry.PhysicalExamInfoQry;
import iih.pe.papt.pepsnappt.d.PePsnApptDO;
import iih.pe.papt.pepsnappt.d.desc.PePsnApptDODesc;
import iih.pe.por.pepsnbinfo.d.PePsnBInfoDO;
import iih.pe.por.pepsnbinfo.i.IPepsnbinfoMDORService;
import iih.pe.pwf.dto.pereportinfodto.d.*;
import iih.pe.pwf.perstdiagsugg.d.PeRstDiagSuggDO;
import iih.pe.pwf.perstdiagsugg.i.IPerstdiagsuggMDORService;
import iih.pe.pwf.perstlis.d.PeRstLisItmDO;
import iih.pe.pwf.perstlis.i.IPeRstLisItmDORService;
import iih.pe.pwf.perstris.d.PeRstRisDO;
import iih.pe.pwf.perstris.i.IPerstrisRService;
import iih.pe.pwf.pewfoval.d.PeWfOvalDO;
import iih.pe.pwf.pewfoval.i.IPewfovalRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import java.io.UnsupportedEncodingException;
import java.util.*;
import xap.ip.event.*;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.*;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.*;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;
import xap.sys.util.AgeCalcUtil;

public class PeRptDOVerifyAfterListener2 implements IBusinessListener {

	public PeRptDOVerifyAfterListener2() {
	}

	public void doAction(IBusinessEvent event) throws BizException {
		if (!event.getSourceID().equals(PePsnApptDODesc.CLASS_FULLNAME) || !event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER))
			return;
		PePsnApptDO apptPsnDosNew[] = (PePsnApptDO[]) (PePsnApptDO[]) ((BDCommonEvent) event).getNewObjs();
		PePsnApptDO apptPsnDosOld[] = (PePsnApptDO[]) (PePsnApptDO[]) ((BDCommonEvent) event).getOldObjs();
		if (apptPsnDosNew[0].getPestatus().intValue() != 6 && apptPsnDosOld[0].getPestatus().intValue() != 6)
			return;
		if (ArrayUtil.isEmpty(apptPsnDosNew) || ArrayUtil.isEmpty(apptPsnDosOld)) {
			return;
		} else {
			doActionPeRptDOChange(apptPsnDosNew, apptPsnDosOld);
			return;
		}
	}

	protected void doActionPeRptDOChange(PePsnApptDO apptPsnDosNew[], PePsnApptDO apptPsnDosOld[]) throws BizException {
		if (ArrayUtil.isEmpty(apptPsnDosOld) || ArrayUtil.isEmpty(apptPsnDosNew)) {
			return;
		} else {
			PePsnApptDO apptDo = apptPsnDosNew[0];
			PeReportInfoDTO peReportInfoDTO = setValueForPeReportInfoDTO(apptDo);
			firePeRpt(peReportInfoDTO, apptDo);
			return;
		}
	}

	@SuppressWarnings("unchecked")
	private PeReportInfoDTO setValueForPeReportInfoDTO(PePsnApptDO apptDo) throws BizException {
		PeReportInfoDTO peReportInfoDTO = new PeReportInfoDTO();
		String id_pepsnappt = apptDo.getId_pepsnappt();
		IPatiMDORService patiMDORService = (IPatiMDORService) ServiceFinder
				.find(iih.pi.reg.pat.i.IPatiMDORService.class);
		PePsnBInfoDO pePsnBInfoDO = ServiceFinder.find(IPepsnbinfoMDORService.class).findById(apptDo.getId_pepsnbinfo());
		PatDO patDOs[] = patiMDORService
				.find(String.format(" id_pat = '%s' ", new Object[] { pePsnBInfoDO.getId_pat() }), "", FBoolean.FALSE);
		IPewfovalRService pewfovalRService = (IPewfovalRService) ServiceFinder
				.find(iih.pe.pwf.pewfoval.i.IPewfovalRService.class);
		PeWfOvalDO ovalDos[] = pewfovalRService.find(
				(new StringBuilder()).append("id_pepsnappt = '").append(id_pepsnappt).append("'").toString(), "",
				FBoolean.FALSE);
		IPerstdiagsuggMDORService perstdiagsuggMDORService = (IPerstdiagsuggMDORService) ServiceFinder
				.find(iih.pe.pwf.perstdiagsugg.i.IPerstdiagsuggMDORService.class);
		PeRstDiagSuggDO rstDiagSuggs[] = perstdiagsuggMDORService.find(
				(new StringBuilder()).append("id_pepsnappt = '").append(id_pepsnappt).append("'").toString(), "",
				FBoolean.FALSE);
		peReportInfoDTO.setVersionnumber("0");
		peReportInfoDTO.setSignatureid("");
		peReportInfoDTO.setReportno(apptDo.getPe_code());
		if (!ArrayUtil.isEmpty(ovalDos)) {
			peReportInfoDTO.setSummarydate(ovalDos[0].getDt_oval() != null ? ovalDos[0].getDt_oval() : new FDateTime());
			peReportInfoDTO
					.setSummarydoccode(ovalDos[0].getId_doc_audit() != null ? ovalDos[0].getId_doc_audit() : "doc");
			peReportInfoDTO.setSummarydocname(ovalDos[0].getName_aduit() != null ? ovalDos[0].getName_aduit() : "doc");
		}
		peReportInfoDTO.setDocumentname("体检报告");
		peReportInfoDTO.setPatientdomain("0401");
		if (!ArrayUtil.isEmpty(patDOs)) {
			PatDO patDO = patDOs[0];
			peReportInfoDTO.setPatientlid(patDO.getCode() != null ? patDO.getCode() : "code");
			peReportInfoDTO.setMedicalno(patDO.getCode_amr_ip() != null ? patDO.getCode_amr_ip() : apptDo.getPe_code());
			peReportInfoDTO.setPatientname(patDO.getName());
			String sd_sex = patDO.getSd_sex();
			peReportInfoDTO.setGendercode(sd_sex);
			if (sd_sex != null) {
				if (sd_sex.equalsIgnoreCase("1"))
					peReportInfoDTO.setGendername("男");
				else if (sd_sex.equalsIgnoreCase("2"))
					peReportInfoDTO.setGendername("女");
				else
					peReportInfoDTO.setGendername("不限");
			} else {
				peReportInfoDTO.setGendername("未知");
			}
			peReportInfoDTO.setBirthdate(patDO.getDt_birth() != null ? patDO.getDt_birth() : new FDate());
			peReportInfoDTO.setPatientage(AgeCalcUtil.getAge(patDO.getDt_birth()));
			peReportInfoDTO.setImageformat("application/pdf");
			try {
				peReportInfoDTO.setImagecontent(StringCodingUtils.Utf8_Base64_Encode(new String(pePsnBInfoDO.getPho(), "UTF-8")));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		peReportInfoDTO.setVisittimes(apptDo.getPe_times());
		peReportInfoDTO.setVisitdate(apptDo.getDt_reg() != null ? apptDo.getDt_reg() : new FDateTime());
		OrgDO orgDO = ServiceFinder.find(IOrgRService.class).findById(apptDo.getId_org());
		peReportInfoDTO.setOrgcode(orgDO.getCode());
		peReportInfoDTO.setOrgname(orgDO.getName());
		StringBuffer diagAndSugg = new StringBuffer();
		PeRstDiagSuggDO arr$[] = rstDiagSuggs;
		int len$ = arr$.length;
		for (int i$ = 0; i$ < len$; i$++) {
			PeRstDiagSuggDO peRstDiagSuggDO = arr$[i$];
			if (peRstDiagSuggDO.getDiag() != null && peRstDiagSuggDO.getSugg() != null)
				diagAndSugg.append((new StringBuilder()).append(peRstDiagSuggDO.getDiag())
						.append(peRstDiagSuggDO.getSugg()).toString());
		}

		String peNormalDepCode = PEParamUtils.getPeNormalDepCode();
		NormalInfoDTO normalInfoDTOs[] = setValueForNormalInfo(id_pepsnappt,peNormalDepCode);
		FArrayList2 normalInfoDTOList = new FArrayList2();
		normalInfoDTOList.addAll(Arrays.asList(normalInfoDTOs));
		peReportInfoDTO.setNormalinfo(normalInfoDTOList);
		SpecialInfoDTO specialInfoDTOs[] = setValueForSpecialInfo(id_pepsnappt,peNormalDepCode);
		FArrayList2 specialInfoDTOList = new FArrayList2();
		specialInfoDTOList.addAll(Arrays.asList(specialInfoDTOs));
		peReportInfoDTO.setSpecialinfo(specialInfoDTOList);
		PeInfoDTO peInfoDTOs[] = setValueForPeInfo(id_pepsnappt);
		FArrayList2 peInfoDTOList = new FArrayList2();
		peInfoDTOList.addAll(Arrays.asList(peInfoDTOs));
		peReportInfoDTO.setPeinfo(peInfoDTOList);
		LaboratoryItemDTO laboratoryItemDTOs[] = setValueForLaboratoryItem(id_pepsnappt);
		FArrayList2 laboratoryItemDTOList = new FArrayList2();
		laboratoryItemDTOList.addAll(Arrays.asList(laboratoryItemDTOs));
		peReportInfoDTO.setLaboratoryitem(laboratoryItemDTOList);
		SummaryDTO summaryDTOs[] = setValueForSummary(id_pepsnappt);
		FArrayList2 summaryDTOList = new FArrayList2();
		summaryDTOList.addAll(Arrays.asList(summaryDTOs));
		peReportInfoDTO.setSummary(summaryDTOList);
		return peReportInfoDTO;
	}

	private NormalInfoDTO[] setValueForNormalInfo(String id_pepsnappt, String peNormalDepCode) throws BizException {
		
		NormalInfoDTO normalInfoDTOs[] = (NormalInfoDTO[]) AppFwUtil.getDORstWithDao(new GetNormalInfoQry(id_pepsnappt,peNormalDepCode), NormalInfoDTO.class);
		if(normalInfoDTOs.length>0){
			NormalInfoDTO normalInfoDtos[] = new NormalInfoDTO[normalInfoDTOs.length];
			for (int i = 0; i < normalInfoDTOs.length; i++) {
				NormalInfoDTO normalInfoDto = new NormalInfoDTO();
				normalInfoDto.setSeqno(Integer.valueOf(i + 1));
				normalInfoDto.setFlagname(normalInfoDTOs[i].getFlagname());
				normalInfoDto.setCode(normalInfoDTOs[i].getCode());
				normalInfoDto.setName(normalInfoDTOs[i].getName());
				normalInfoDto.setReferrangestext(normalInfoDTOs[i].getReferrangestext());
				normalInfoDto.setValue(normalInfoDTOs[i].getValue());
				normalInfoDto.setUnit(normalInfoDTOs[i].getUnit());
				normalInfoDtos[i] = normalInfoDto;
			}
			return normalInfoDtos;
		} else {
			return new NormalInfoDTO[0];
		}	
	}

	@SuppressWarnings("unchecked")
	private SpecialInfoDTO[] setValueForSpecialInfo(String id_pepsnappt, String peNormalDepCode) throws BizException {
		SpecialInfoDTO[] SpecialInfoDTOs = (SpecialInfoDTO[]) AppFwUtil.getDORstWithDao(new GetSpecialInfoQry(id_pepsnappt, peNormalDepCode), SpecialInfoDTO.class);
		if(SpecialInfoDTOs.length>0){
			SpecialInfoDTO[] specialInfoDtos = new SpecialInfoDTO[SpecialInfoDTOs.length];
			for (int i = 0; i < SpecialInfoDTOs.length; i++) {
				SpecialInfoDTO specialInfoDTO = new SpecialInfoDTO();
				specialInfoDTO.setSeqno(Integer.valueOf(i + 1));
				String value_text = SpecialInfoDTOs[i].getFullcontent();
				specialInfoDTO.setFullcontent(value_text);
				specialInfoDTO.setRptdoccode(SpecialInfoDTOs[i].getRptdoccode());
				specialInfoDTO.setRptdocname(SpecialInfoDTOs[i].getRptdocname());
				specialInfoDTO.setRvdoccode(SpecialInfoDTOs[i].getRvdoccode());
				specialInfoDTO.setRvdocname(SpecialInfoDTOs[i].getRvdocname());
				FArrayList2 ckItemList = new FArrayList2();
				SpecialCheckItemDTO specialCheckItemDTO = new SpecialCheckItemDTO();
				specialCheckItemDTO.setSeqno(Integer.valueOf(1));
				specialCheckItemDTO.setFullcontent(value_text);
				ckItemList.add(specialCheckItemDTO);
				specialInfoDTO.setCkitem(ckItemList);
				FArrayList2 briSummaryList = new FArrayList2();
				SpecialBriSummaryDTO specialBriSummaryDTO = new SpecialBriSummaryDTO();
				specialBriSummaryDTO.setName(value_text);
				briSummaryList.add(specialBriSummaryDTO);
				specialInfoDTO.setBrisummary(briSummaryList);
				
				specialInfoDtos[i] = specialInfoDTO;
			}
			return specialInfoDtos;
		} else {
			return new SpecialInfoDTO[0];
		}
	}

	@SuppressWarnings("unchecked")
	private PeInfoDTO[] setValueForPeInfo(String id_pepsnappt) throws BizException {
		IPerstrisRService perstrisRService = (IPerstrisRService) ServiceFinder
				.find(iih.pe.pwf.perstris.i.IPerstrisRService.class);
		PeRstRisDO peRstRisDOs[] = perstrisRService.find(
				String.format(" id_pepsnappt = '%s' and fg_received = 'Y' ", new Object[] { id_pepsnappt }), "",
				FBoolean.FALSE);
		int length = peRstRisDOs.length;
		if (length > 0) {
			PeInfoDTO peInfoDTOs[] = new PeInfoDTO[length];
			for (int i = 0; i < length; i++) {
				PeRstRisDO peRstRisDO = peRstRisDOs[i];
				PeInfoDTO peInfoDTO = new PeInfoDTO();
				peInfoDTO.setSeqno(Integer.valueOf(i + 1));
				peInfoDTO.setPeinfocode(peRstRisDO.getCode_method());
				peInfoDTO.setName(peRstRisDO.getName_method());
				String summary = peRstRisDO.getSummary();
				peInfoDTO.setFullcontent(summary);
				peInfoDTO.setRptdoccode(peRstRisDO.getReport_doctor_code());
				peInfoDTO.setRptdocname(peRstRisDO.getReport_doctor_name());
				peInfoDTO.setRvdoccode(peRstRisDO.getVerify_docotr_code());
				peInfoDTO.setRvdocname(peRstRisDO.getVerify_doctor_name());
				FArrayList2 ckItemList = new FArrayList2();
				PeCheckItemDTO peCheckItemDTO = new PeCheckItemDTO();
				peCheckItemDTO.setSeqno(Integer.valueOf(1));
				peCheckItemDTO.setFullcontent(summary);
				ckItemList.add(peCheckItemDTO);
				peInfoDTO.setCkitem(ckItemList);
				FArrayList2 briSummaryList = new FArrayList2();
				PeBriSummaryDTO peBriSummaryDTO = new PeBriSummaryDTO();
				peBriSummaryDTO.setName(summary);
				briSummaryList.add(peBriSummaryDTO);
				peInfoDTO.setBrisummary(briSummaryList);
				peInfoDTOs[i] = peInfoDTO;
			}

			return peInfoDTOs;
		} else {
			return new PeInfoDTO[0];
		}
	}

	@SuppressWarnings("unchecked")
	private LaboratoryItemDTO[] setValueForLaboratoryItem(String id_pepsnappt) throws BizException {
		IPeRstLisItmDORService peRstLisItmDORService = (IPeRstLisItmDORService) ServiceFinder
				.find(iih.pe.pwf.perstlis.i.IPeRstLisItmDORService.class);
		PeRstLisItmDO peRstLisItmDOs[] = peRstLisItmDORService.find(
				String.format(" id_pepsnappt = '%s' ", new Object[] { id_pepsnappt }), " examinaim, printord ",
				FBoolean.FALSE);
		int length = peRstLisItmDOs.length;
		Map<String, PeRstLisItmDO> lisCatlog = new HashMap<String, PeRstLisItmDO>();
		for(PeRstLisItmDO lis : peRstLisItmDOs){
			if(!lisCatlog.containsKey(lis.getExaminaim())) {
				lisCatlog.put(lis.getExaminaim(), lis);
			}
		}
		List<LaboratoryItemDTO> laboratoryItemDTOs = new ArrayList<LaboratoryItemDTO>();
		String pre_name_examgroup = null;
		int groupNum = 0;
		for(PeRstLisItmDO liscat: lisCatlog.values()) {
			groupNum++;
			
			String cur_name_examgroup = liscat.getExaminaim();
			LaboratoryItemDTO laboratoryItemDTO = new LaboratoryItemDTO();
			laboratoryItemDTO.setSeqno(Integer.valueOf(groupNum));
			laboratoryItemDTO.setCode(liscat.getCode_examgroup());
			laboratoryItemDTO.setName(cur_name_examgroup);
			FArrayList2 rptdocList = new FArrayList2();
			ReportDoctorDTO reportDoctorDTO = new ReportDoctorDTO();
			reportDoctorDTO.setRptdoccode(liscat.getCode_reportor());
			reportDoctorDTO.setRptdocname(liscat.getReportor());
			rptdocList.add(reportDoctorDTO);
			laboratoryItemDTO.setRptdoc(rptdocList);
			FArrayList2 rvdocList = new FArrayList2();
			ReviewDoctorDTO reviewDoctorDTO = new ReviewDoctorDTO();
			reviewDoctorDTO.setRvdoccode(liscat.getCode_verifier());
			reviewDoctorDTO.setRvdocname(liscat.getVerifier());
			rvdocList.add(reviewDoctorDTO);
			laboratoryItemDTO.setRvdoc(rvdocList);
			FArrayList2 subitemList = new FArrayList2();
			boolean isCurGroup = true;
			int subItemSeqno = 1;
			for(PeRstLisItmDO subitem : peRstLisItmDOs) {
				if(liscat.getExaminaim() == subitem.getExaminaim()) {
					SubItemDTO subItemDTO = new SubItemDTO();
					subItemDTO.setSeqno(Integer.valueOf(subItemSeqno));
					subItemDTO.setCode(subitem.getCode_srv());
					subItemDTO.setName(subitem.getName_srv());
					subItemDTO.setValue(subitem.getVal_rstrptlab());
					subItemDTO.setUnit(subitem.getName_unit());
					subItemDTO.setFlagname(subitem.getMark_arrow());
					subItemDTO.setReferrangestext(subitem.getVal_reference());
					subitemList.add(subItemDTO);
					subItemSeqno++;
					laboratoryItemDTO.setSubitem(subitemList);
					laboratoryItemDTOs.add(laboratoryItemDTO);
				}
			}
		}
		
		if (lisCatlog.size() > 0) {
			return (LaboratoryItemDTO[]) laboratoryItemDTOs.toArray(new LaboratoryItemDTO[groupNum]);
		} else {
			return new LaboratoryItemDTO[0];
		}
	}

	@SuppressWarnings("unchecked")
	private SummaryDTO[] setValueForSummary(String id_pepsnappt) throws BizException {
		IPerstdiagsuggMDORService perstdiagsuggMDORService = (IPerstdiagsuggMDORService) ServiceFinder
				.find(iih.pe.pwf.perstdiagsugg.i.IPerstdiagsuggMDORService.class);
		PeRstDiagSuggDO peRstDiagSuggDOs[] = perstdiagsuggMDORService.find(
				String.format(" id_pepsnappt = '%s' and fg_oval = 'Y' ", new Object[] { id_pepsnappt }), " sortno ",
				FBoolean.FALSE);
		int length = peRstDiagSuggDOs.length;
		if (length > 0) {
			SummaryDTO summaryDTOs[] = new SummaryDTO[1];
			SummaryDTO summaryDTO = new SummaryDTO();
			summaryDTO.setSeqno(Integer.valueOf(1));
			summaryDTO.setCode("99999");
			FArrayList2 sumdiagnosisList = new FArrayList2();
			FArrayList2 sumadviceList = new FArrayList2();
			for (int i = 0; i < length; i++) {
				PeRstDiagSuggDO peRstDiagSuggDO = peRstDiagSuggDOs[i];
				SumDiagnosisDTO sumDiagnosisDTO = new SumDiagnosisDTO();
				sumDiagnosisDTO.setSeqno(Integer.valueOf(i + 1));
				sumDiagnosisDTO.setName(peRstDiagSuggDO.getDiag());
				sumdiagnosisList.add(sumDiagnosisDTO);
				SumAdviceDTO sumAdviceDTO = new SumAdviceDTO();
				sumAdviceDTO.setSeqno(Integer.valueOf(i + 1));
				sumAdviceDTO.setName(peRstDiagSuggDO.getSugg());
				sumadviceList.add(sumAdviceDTO);
			}

			summaryDTO.setSumdiagnosis(sumdiagnosisList);
			summaryDTO.setSumadvice(sumadviceList);
			summaryDTOs[0] = summaryDTO;
			return summaryDTOs;
		} else {
			return new SummaryDTO[0];
		}
	}

	private void firePeRpt(PeReportInfoDTO peReportInfoDTO, PePsnApptDO psnApptDO) throws BizException {
		peReportInfoDTO.setServerid("BS347");
		MsgObj msgobj = new MsgObj();
		msgobj.setPatientCode(peReportInfoDTO.getPatientlid());
		msgobj.setEntimes(psnApptDO.getPe_times());
		msgobj.setEnNO(psnApptDO.getPe_code());
		msgobj.setInteractionCode("04");
		//msgobj.setInteractionCode("02");
		//DomainBusinessUserObj buo = new DomainBusinessUserObj(peReportInfoDTO, BusiType.ZY, "deptId", "0");
		DomainBusinessUserObj buo = new DomainBusinessUserObj(peReportInfoDTO, "04", "deptId", "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(PePsnApptDODesc.CLASS_FULLNAME, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = (BusinessEventListener) ServiceFinder
				.find(xap.ip.event.BusinessEventListener.class);
		beListener.doAction(event);
	}
}