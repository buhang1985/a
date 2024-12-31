package iih.pe.listener;

import iih.en.pv.inpatient.d.InpatientDO;
import iih.pe.listener.bp.GetInpatientDOBp;
import iih.pe.pwf.dto.morphtestreportinfodto.d.MorphTestReportInfoDTO;
import iih.pe.pwf.dto.morphtestreportinfodto.d.RefStdInfoDTO;
import iih.pe.pwf.dto.morphtestreportinfodto.d.RelMedAdviceDTO;
import iih.pe.pwf.dto.morphtestreportinfodto.d.ReportDTO;
import iih.pe.pwf.dto.morphtestreportinfodto.d.ReportDoctorDTO;
import iih.pe.pwf.dto.morphtestreportinfodto.d.SampleDTO;
import iih.pe.pwf.dto.morphtestreportinfodto.d.SubItemInfoDTO;
import iih.pe.pwf.perstmor.d.PeRstMorDO;
import iih.pe.pwf.perstmor.d.PeRstMorItmDO;
import iih.pe.pwf.perstmor.d.PerstmorAggDO;
import iih.pe.pwf.perstmor.i.IPeRstMorItmDOCudService;
import iih.pe.pwf.perstmor.i.IPeRstMorItmDORService;
import iih.pe.pwf.perstmor.i.IPerstmorCudService;
import iih.pe.pwf.perstmor.i.IPerstmorMDOCudService;
import iih.pe.pwf.perstmor.i.IPerstmorMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;

public class MriAddAfterListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//1.验证事件,是否匹配
		if(!(event.getSourceID().equals("iih.pe.pwf.dto.morphtestreportinfodto.d.MorphTestReportInfoDTO") && event.getEventType().equals(IEventType.TYPE_INSERT_AFTER))){
			return;
		}
		//2.获取平台根据xml转换得到的dto对象
		FArrayList2 morphTestReportInfoDTO = (FArrayList2) event.getUserObject();
		if(morphTestReportInfoDTO.isEmpty()){
			return;
		}
		MorphTestReportInfoDTO mri = (MorphTestReportInfoDTO) morphTestReportInfoDTO.get(0);
		//3.判断是否应该处理该dto(id_ent有值才处理)
		String id_ent = getIdEnt(mri);
		if(id_ent==null){
			return;
		}
		//4.转换dto对象并保存
		doActionMorphTestReportInfoDTOAdd(mri,id_ent);
	}
	
	private String getIdEnt(MorphTestReportInfoDTO mri) throws BizException{
		String id_ent = null;
		String patientdomain = mri.getPatientdomain();
		if("02".equals(patientdomain)){
			GetInpatientDOBp bp = new GetInpatientDOBp();
			int visittimes = 1;//若未设置就诊次数,则默认为1
			if(mri.getVisittimes()!=null && !mri.getVisittimes().trim().equals("")){
				visittimes = Integer.parseInt(mri.getVisittimes());
			}
			InpatientDO[] inpatientDOs = bp.exec(mri.getMedicalno(),visittimes);
			if(inpatientDOs.length>0){
				id_ent = inpatientDOs[0].getId_ent();
			}
		}
		return id_ent;
	}
	
	private void doActionMorphTestReportInfoDTOAdd(MorphTestReportInfoDTO mri,String id_ent) throws BizException{
		IPerstmorMDORService perstmorMDORService = ServiceFinder.find(IPerstmorMDORService.class);
		IPerstmorMDOCudService perstmorMDOCudService = ServiceFinder.find(IPerstmorMDOCudService.class);
		IPeRstMorItmDOCudService peRstMorItmDOCudService = ServiceFinder.find(IPeRstMorItmDOCudService.class);
		IPeRstMorItmDORService peRstMorItmDORService = ServiceFinder.find(IPeRstMorItmDORService.class);
		//文档的操作版本versionNumber		新增:0	修改:1
		//决定0的时候新增peRstRisDO,1的时候根据报告号删除,然后新增peRstRisDO
		//因文档检查报告信息服务和检验报告信息服务的versionNumber不一致(一个是0,1;一个是0,1,2),
		//暂决定不使用versionNumber,一律根据报告号查询PeRstRisDO,查得到就删(PeRstMorDO及相关的PeRstMorItmDO[]),然后new一个;查不到就直接new一个
//		String versionNumber = cri.getVersionnumber();
		String reportno = mri.getReportno();
		PeRstMorDO[] peRstLisDOs = perstmorMDORService.find(String.format(" no_rptlab = '%s' ", reportno), "", FBoolean.FALSE);
		if(peRstLisDOs != null && peRstLisDOs.length>0){
			for (PeRstMorDO peRstMorDO : peRstLisDOs) {
				String id_perstmor = peRstMorDO.getId_perstmor();
				PeRstMorItmDO[] peRstMorItmDOs = peRstMorItmDORService.find(String.format(" id_perstmor = '%s' ", id_perstmor), "", FBoolean.FALSE);
				peRstMorItmDOCudService.delete(peRstMorItmDOs);
			}
			perstmorMDOCudService.delete(peRstLisDOs);
		}
		
		PeRstMorDO peRstMorDO = new PeRstMorDO();
		peRstMorDO.setStatus(DOStatus.NEW);
		
		peRstMorDO.setId_pepsnappt(id_ent);//体检预约单ID
		peRstMorDO.setId_ent(id_ent);//患者就诊
		
		FArrayList relmedadvices = mri.getRelmedadvice();
		StringBuffer id_ors = new StringBuffer();
		if(relmedadvices!=null && relmedadvices.size()>0){
			for (Object object : relmedadvices) {
				RelMedAdviceDTO relMedAdviceDTO = (RelMedAdviceDTO) object;
				id_ors.append(relMedAdviceDTO.getRelmedadviceno()).append(",");
			}
		}
		if(id_ors.length()>0){
			id_ors.deleteCharAt(id_ors.length()-1);
		}
		peRstMorDO.setId_or(id_ors.toString());//医嘱主键
		
		peRstMorDO.setNo_rptlab(reportno);//检验报告
		
		peRstMorDO.setId_rpttp(mri.getMprpttypecode());//报告类型编码				形态学报告类型标识编码
		peRstMorDO.setSd_rpttp(mri.getMprpttypename());//报告类型					形态学报告类型标识名称
//		peRstMorDO.setId_su_lab(?);//报告状态
//		peRstMorDO.setSd_su_lab(?);//报告状态编码
//		peRstMorDO.setId_dep(?);//报告科室
		
		FArrayList rptdocs = mri.getRptdoc();
		FDateTime dt_rptlab = null;
		StringBuffer id_emps = new StringBuffer();
		StringBuffer name_emps = new StringBuffer();
		if(rptdocs!=null && rptdocs.size()>0){
			dt_rptlab = ((ReportDoctorDTO)rptdocs.get(0)).getRptdatetime();
			for (Object object : rptdocs) {
				ReportDoctorDTO reportDoctorDTO = (ReportDoctorDTO) object;
				id_emps.append(reportDoctorDTO.getRptdoccode()).append(",");
				name_emps.append(reportDoctorDTO.getRptdocname()).append(",");
			}
		}
		if(id_emps.length()>0){
			id_emps.deleteCharAt(id_emps.length()-1);
		}
		if(name_emps.length()>0){
			name_emps.deleteCharAt(name_emps.length()-1);
		}
		peRstMorDO.setDt_rptlab(dt_rptlab);//报告时间
		peRstMorDO.setId_emp(id_emps.toString());//报告人员ID
		peRstMorDO.setName_emp(name_emps.toString());//报告人员姓名
		peRstMorDO.setId_emp_verify(id_emps.toString());//检验医生			报告医生编码
		
		peRstMorDO.setCode_rpt(mri.getMprpttypecode());//报告编码				形态学报告类型标识编码
		peRstMorDO.setName_rpt(mri.getMprpttypename());//报告名称				形态学报告类型标识名称
		peRstMorDO.setCode_pat(mri.getPatientlid());//客户编码
		peRstMorDO.setFg_received(new FBoolean(true));//接收完成标识
		peRstMorDO.setDt_received(new FDateTime());//接收时间
		
		FArrayList sample = mri.getSample();
		SampleDTO sampleDTO = (SampleDTO) sample.get(0);
		String sampleno = sampleDTO.getSampleno();//标本条码号
		String sampletype = sampleDTO.getSampletype();//标本类型编码(标本来源编码)
		
		FArrayList reports = mri.getReport();
		StringBuffer observations = new StringBuffer();
		StringBuffer diagnosises = new StringBuffer();
		PeRstMorItmDO[] peRstMorItmDOs = null;
		if(reports!=null && reports.size()>0){
			for (Object object : reports) {
				ReportDTO reportDTO = (ReportDTO) object;
				observations.append(reportDTO.getMpobjective()).append(",");
				diagnosises.append(reportDTO.getMpsubjective()).append(",");
				
				String crisiscode = reportDTO.getCrisiscode();//危机编码
				
				FArrayList subiteminfos = reportDTO.getSubiteminfo();
				int size = subiteminfos.size();
				peRstMorItmDOs = new PeRstMorItmDO[size];
				for(int i=0;i<size;i++){
					SubItemInfoDTO subItemInfoDTO = (SubItemInfoDTO) subiteminfos.get(i);
					PeRstMorItmDO peRstMorItmDO = new PeRstMorItmDO();
//					peRstMorItmDO.setId_perstmor(?);//形态学报告ID
					peRstMorItmDO.setId_pepsnappt(id_ent);//体检预约单ID
					peRstMorItmDO.setVal_rstrptlab(subItemInfoDTO.getItemvaluepq());//结果值
//					peRstMorItmDO.setCode_unit(?);//单位编码
					peRstMorItmDO.setName_unit(subItemInfoDTO.getItemunitpq());//单位名称
					peRstMorItmDO.setFg_crisis(new FBoolean("1".equals(crisiscode)));//危急值标志
					peRstMorItmDO.setCode_pat(mri.getPatientlid());//客户编码
					peRstMorItmDO.setNo_applyform(id_ors.toString());//申请单		和医嘱号重复
//					peRstMorItmDO.setExaminaim(?);//检查分组
					peRstMorItmDO.setSampleno(sampleno);//标本号
					peRstMorItmDO.setSampletype(sampletype);//标本类型
					peRstMorItmDO.setCode_emp(id_emps.toString());//检验员编码		同报告人员ID
//					peRstMorItmDO.setName_insmt(?);//检验设备
					peRstMorItmDO.setDt_rptlab(dt_rptlab.toString());//报告日期
//					peRstMorItmDO.setSd_insmt(?);//设备编码
					peRstMorItmDO.setCode_dep(mri.getLabdeptcode());//科室编码			检验科室编码
					peRstMorItmDO.setCode_srv(subItemInfoDTO.getItemcode());//项目编码
					peRstMorItmDO.setName_srv(subItemInfoDTO.getItemname());//项目名称
					peRstMorItmDO.setPrintord(Integer.parseInt(subItemInfoDTO.getDisplayorder()));//打印序号
//					peRstMorItmDO.setCode_deviate(?);//原始异常标识
//					peRstMorItmDO.setName_deviate(?);//异常标识名称
//					peRstMorItmDO.setMark_deviate(?);//异常标识
//					peRstMorItmDO.setMark_arrow(?);//箭头标识
					peRstMorItmDO.setReportor(name_emps.toString());//检验人					报告医生名称
					peRstMorItmDO.setCode_reportor(id_emps.toString());//检验人编码			报告医生编码
					peRstMorItmDO.setVerifier(mri.getRvdocname());//审核人
					peRstMorItmDO.setCode_verifier(mri.getRvdoccode());//审核人编码
					peRstMorItmDO.setDt_rptlab(mri.getRvdatetime().toString());//审核日期
//					peRstMorItmDO.setCode_examgroup(?);//检查分组编码
//					peRstMorItmDO.setName_examgroup(?);//检查分组名称
					peRstMorItmDO.setCode_entp(mri.getVisittype());//就诊类型编码
//					peRstMorItmDO.setName_entp(?);//就诊类型名称
					
					FArrayList refstdinfos = subItemInfoDTO.getRefstdinfo();
					if(refstdinfos!=null && refstdinfos.size()>0){
						for (Object obj : refstdinfos) {
							RefStdInfoDTO refStdInfoDTO = (RefStdInfoDTO) obj;
							String refcode = refStdInfoDTO.getRefcode();
							String refvalue = refStdInfoDTO.getRefvalue();
							String refunit = refStdInfoDTO.getRefunit();
							if(refcode.equals("A21")){
								peRstMorItmDO.setAvg_value(refvalue);//骨髓片平均值
								peRstMorItmDO.setAvg_unit(refunit);//骨髓片平均值单位
							}else if(refcode.equals("A22")){
								peRstMorItmDO.setSd_value(refvalue);//骨髓片+/-SD
								peRstMorItmDO.setSd_unit(refunit);//骨髓片+/-SD单位
							}else if(refcode.equals("A4")){
								peRstMorItmDO.setNormal_value(refvalue);//正常参考范围值
								peRstMorItmDO.setNormal_unit(refunit);//正常参考范围值单位
							}else if(refcode.equals("A5")){
								peRstMorItmDO.setRisk_value(refvalue);//风险值
								peRstMorItmDO.setRisk_unit(refunit);//风险值单位
							}else if(refcode.equals("A6")){
								peRstMorItmDO.setAgerisk_value(refvalue);//年龄风险值
								peRstMorItmDO.setAvg_unit(refunit);//年龄风险值单位
							}else if(refcode.equals("A7")){
								peRstMorItmDO.setRisktruncation_value(refvalue);//风险截断值
								peRstMorItmDO.setRisktruncation_unit(refunit);//风险截断值单位
							}else if(refcode.equals("419736007")){
								peRstMorItmDO.setCorrection_value(refvalue);//校正值
								peRstMorItmDO.setCorrection_unit(refunit);//校正值单位
							}
						}
					}
					peRstMorItmDO.setMemo(subItemInfoDTO.getMemo());//备注
					peRstMorItmDOs[i] = peRstMorItmDO;
				}
			}
		}
		if(observations.length()>0){
			observations.deleteCharAt(observations.length()-1);
		}
		if(diagnosises.length()>0){
			diagnosises.deleteCharAt(diagnosises.length()-1);
		}
		peRstMorDO.setObservation(observations.toString());//客观所见
		peRstMorDO.setDiagnosis(diagnosises.toString());//主观诊断
		peRstMorDO.setImage_rpt(mri.getWholerptimgcontent());//图文报告			整张报告图片信息
		
		PerstmorAggDO aggDo = new PerstmorAggDO();
		aggDo.setParent(peRstMorDO);
		aggDo.setPeRstMorItmDO(peRstMorItmDOs);
		IPerstmorCudService perstmorCudService = ServiceFinder.find(IPerstmorCudService.class);
		perstmorCudService.save(new PerstmorAggDO[]{aggDo});
	}

}
