package iih.pe.listener;

import iih.en.pv.inpatient.d.InpatientDO;
import iih.pe.listener.bp.GetInpatientDOBp;
import iih.pe.pwf.perstlis.d.PeRstLisDO;
import iih.pe.pwf.perstlis.d.PeRstLisItmDO;
import iih.pe.pwf.perstlis.d.PerstlisAggDO;
import iih.pe.pwf.perstlis.i.IPeRstLisItmDOCudService;
import iih.pe.pwf.perstlis.i.IPeRstLisItmDORService;
import iih.pe.pwf.perstlis.i.IPerstlisCudService;
import iih.pe.pwf.perstlis.i.IPerstlisMDOCudService;
import iih.pe.pwf.perstlis.i.IPerstlisMDORService;
import iih.pe.pwf.testrptinfo.d.RelMedAdviceDTO;
import iih.pe.pwf.testrptinfo.d.ReportDTO;
import iih.pe.pwf.testrptinfo.d.ReportDoctorInfoDTO;
import iih.pe.pwf.testrptinfo.d.ReviewDoctorInfoDTO;
import iih.pe.pwf.testrptinfo.d.SampleDTO;
import iih.pe.pwf.testrptinfo.d.SubItemInfoDTO;
import iih.pe.pwf.testrptinfo.d.TestRptInfoDTO;
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

/**
 * 检验报告信息新增监听
 * @author guo.s
 *
 */
public class TriAddAfterListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//1.验证事件,是否匹配
		if(!(event.getSourceID().equals("iih.pe.pwf.testrptinfo.d.TestRptInfoDTO") && event.getEventType().equals(IEventType.TYPE_INSERT_AFTER))){
			return;
		}
		//2.获取平台根据xml转换得到的dto对象
		FArrayList2 testRptInfoDTOs = (FArrayList2) event.getUserObject();;
		if(testRptInfoDTOs.isEmpty()){
			return;
		}
		TestRptInfoDTO tri = (TestRptInfoDTO) testRptInfoDTOs.get(0);
		//3.判断是否应该处理该dto(id_ent有值才处理)
		String id_ent = getIdEnt(tri);
		if(id_ent==null){
			return;
		}
		//4.转换dto对象并保存
		doActionTestRptInfoDTOAdd(tri,id_ent);
	}
	
	private String getIdEnt(TestRptInfoDTO tri) throws BizException {
		String id_ent = null;
		String patientdomain = tri.getPatientdomain();
		if("02".equals(patientdomain)){
			GetInpatientDOBp bp = new GetInpatientDOBp();
			int visittimes = 1;//若未设置就诊次数,则默认为1
			if(tri.getVisittimes()!=null){
				visittimes = tri.getVisittimes();
			}
			InpatientDO[] inpatientDOs = bp.exec(tri.getMedicalno(),visittimes);
			if(inpatientDOs.length>0){
				id_ent = inpatientDOs[0].getId_ent();
			}
		}
		return id_ent;
	}
	
	private void doActionTestRptInfoDTOAdd(TestRptInfoDTO tri,String id_ent) throws BizException{
		IPerstlisMDORService perstlisMDORService = ServiceFinder.find(IPerstlisMDORService.class);
		IPerstlisMDOCudService perstlisMDOCudService = ServiceFinder.find(IPerstlisMDOCudService.class);
		IPeRstLisItmDOCudService peRstLisItmDOCudService = ServiceFinder.find(IPeRstLisItmDOCudService.class);
		IPeRstLisItmDORService peRstLisItmDORService = ServiceFinder.find(IPeRstLisItmDORService.class);
		//文档的操作版本versionNumber		新增:0	修改:1
		//决定0的时候新增peRstRisDO,1的时候根据报告号删除,然后新增peRstRisDO
		//因文档检查报告信息服务和检验报告信息服务的versionNumber不一致(一个是0,1;一个是0,1,2),
		//暂决定不使用versionNumber,一律根据报告号查询PeRstRisDO,查得到就删(PeRstRisDO及相关的PeRstLisItmDO[]),然后new一个;查不到就直接new一个
//		String versionNumber = cri.getVersionnumber();
		String reportno = tri.getReportno();
		PeRstLisDO[] peRstLisDOs = perstlisMDORService.find(String.format(" no_rptlab = '%s' ", reportno), "", FBoolean.FALSE);
		if(peRstLisDOs != null && peRstLisDOs.length>0){
			for (PeRstLisDO peRstLisDO : peRstLisDOs) {
				String id_rptlab = peRstLisDO.getId_rptlab();
				PeRstLisItmDO[] peRstLisItmDOs = peRstLisItmDORService.find(String.format(" id_rptlab = '%s' ", id_rptlab), "", FBoolean.FALSE);
				peRstLisItmDOCudService.delete(peRstLisItmDOs);
			}
			perstlisMDOCudService.delete(peRstLisDOs);
		}
		
		PeRstLisDO peRstLisDo = new PeRstLisDO();
		peRstLisDo.setStatus(DOStatus.NEW);
//		peRstLisDo.setId_rptlab(?);//体检报告单主键
		peRstLisDo.setId_pepsnappt(id_ent);//体检预约单ID
		peRstLisDo.setId_ent(tri.getMedicalno());//患者就诊		就诊号???
		
		FArrayList relmedadvices = tri.getRelmedadvice();
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
		peRstLisDo.setId_or(id_ors.toString());//医嘱主键
		
		peRstLisDo.setNo_rptlab(reportno);//检验报告			报告号
//		peRstLisDo.setId_rpttp(?);//报告类型编码
//		peRstLisDo.setSd_rpttp(?);//报告类型
//		peRstLisDo.setId_su_lab(?);//报告状态
//		peRstLisDo.setSd_su_lab(?);//报告状态编码
//		peRstLisDo.setId_insmt(?);//仪器
//		peRstLisDo.setSd_insmt(?);//仪器编码
//		peRstLisDo.setId_dep(?);//报告科室
		
		FArrayList reportdoctorinfos = tri.getReportdoctorinfo();
		peRstLisDo.setDt_rptlab(((ReportDoctorInfoDTO)reportdoctorinfos.get(0)).getReportdate());//报告时间
		
		StringBuffer id_emps = new StringBuffer();
		StringBuffer name_rpts = new StringBuffer();
		FDateTime reportdate = null;
		if(reportdoctorinfos!=null && reportdoctorinfos.size()>0){
			reportdate = ((ReportDoctorInfoDTO) reportdoctorinfos.get(0)).getReportdate();
			for (Object object : reportdoctorinfos) {
				ReportDoctorInfoDTO reportDoctorInfoDTO = (ReportDoctorInfoDTO) object;
				id_emps.append(reportDoctorInfoDTO.getReporterid()).append(",");
				name_rpts.append(reportDoctorInfoDTO.getReportername()).append(",");
			}
		}
		if(id_emps.length()>0){
			id_emps.deleteCharAt(id_emps.length()-1);
		}
		if(name_rpts.length()>0){
			name_rpts.deleteCharAt(name_rpts.length()-1);
		}
		peRstLisDo.setId_emp_verify(id_emps.toString());//检验医生		报告医生
		peRstLisDo.setId_emp(id_emps.toString());//报告人员			报告医生编码???
		peRstLisDo.setName_rpt(name_rpts.toString());//报告名称			报告医生名称???
		
		peRstLisDo.setCode_pat(tri.getPatientlid());//客户编码
		peRstLisDo.setFg_received(new FBoolean(true));//接收完成标识
		peRstLisDo.setDt_received(new FDateTime());//接收时间
		
		FArrayList reviewdoctorinfos = tri.getReviewdoctorinfo();
		StringBuffer reviewernames = new StringBuffer();
		StringBuffer Reviewerids = new StringBuffer();
		FDateTime Reviewdate = null;
		if(reviewdoctorinfos!=null && reviewdoctorinfos.size()>0){
			Reviewdate = ((ReviewDoctorInfoDTO) reviewdoctorinfos.get(0)).getReviewdate();
			for (Object object : reviewdoctorinfos) {
				ReviewDoctorInfoDTO reviewDoctorInfoDTO = (ReviewDoctorInfoDTO) object;
				reviewernames.append(reviewDoctorInfoDTO.getReviewername()).append(",");
				Reviewerids.append(reviewDoctorInfoDTO.getReviewerid()).append(",");
			}
		}
		if(reviewernames.length()>0){
			reviewernames.deleteCharAt(reviewernames.length()-1);
		}
		if(Reviewerids.length()>0){
			Reviewerids.deleteCharAt(Reviewerids.length()-1);
		}
		
		String visittype = tri.getVisittype();
		
		FArrayList samples = tri.getSample();
		SampleDTO sampleDTO = (SampleDTO) samples.get(0);//样本有且只有一个
		String sampleno = sampleDTO.getSampleno();
		String sampletypename = sampleDTO.getSampletypename();
		
		PeRstLisItmDO[] peRstLisItmDOs = null;
		FArrayList reports = tri.getReport();
		if(reports!=null && reports.size()>0){
			//若检验项有值,则reports的长度只可能为1且subiteminfos必有值
			ReportDTO reportDTO = (ReportDTO) reports.get(0);
			String labitemname = reportDTO.getLabitemname();
			String labitemcode = reportDTO.getLabitemcode();
			
			FArrayList subiteminfos = reportDTO.getSubiteminfo();
			int size = subiteminfos.size();
			peRstLisItmDOs = new PeRstLisItmDO[size];
			for(int i=0;i<size;i++){
				SubItemInfoDTO subItemInfoDTO = (SubItemInfoDTO) subiteminfos.get(i);
				PeRstLisItmDO peRstLisItmDO = new PeRstLisItmDO();
//				peRstLisItmDO.setId_rptlisitm(?);//检验报告单明细主键
//				peRstLisItmDO.setId_rptlab(?);//检验报告单主键
				peRstLisItmDO.setId_pepsnappt(id_ent);//体检预约单ID
				peRstLisItmDO.setVal_reference(subItemInfoDTO.getReferrangetext());//参考值
				peRstLisItmDO.setVal_max(subItemInfoDTO.getReferrangehighvalue());//最大值
				peRstLisItmDO.setVal_min(subItemInfoDTO.getReferrangelowvalue());//最小值
				peRstLisItmDO.setVal_rstrptlab(subItemInfoDTO.getItemvaluepq());//结果值
				peRstLisItmDO.setName_unit(subItemInfoDTO.getItemunitpq());//单位名称
				peRstLisItmDO.setFg_crisis(new FBoolean("危险".equals(subItemInfoDTO.getWarnflagname())));//危急值标识		不危险或null都为false
				peRstLisItmDO.setCode_pat(tri.getPatientlid());//客户编码
				peRstLisItmDO.setNo_applyform(id_ors.toString());//申请单		和医嘱号重复
				peRstLisItmDO.setExaminaim(labitemname);//检查分组
				peRstLisItmDO.setSampleno(sampleno);//标本号
				peRstLisItmDO.setSampletype(sampletypename);//标本类型
				peRstLisItmDO.setCode_emp(id_emps.toString());//检验员编码		报告医生信息的报告医生编码
//				peRstLisItmDO.setName_insmt(?);//检验设备
				peRstLisItmDO.setDt_rptlab(reportdate.toString());//报告日期			报告医生信息的报告日期
//				peRstLisItmDO.setSd_insmt(?);//设备编码
				peRstLisItmDO.setCode_dep(tri.getLabdept());//科室编码			检验科室编码
				peRstLisItmDO.setCode_srv(subItemInfoDTO.getItemcode());//项目编码
				peRstLisItmDO.setName_srv(subItemInfoDTO.getItemnamecn());//项目名称			检验子项全称
//				peRstLisItmDO.setPrintord(?);//打印序号
//				peRstLisItmDO.setCode_deviate(?);//原始异常标识
				peRstLisItmDO.setName_deviate(subItemInfoDTO.getNormalflagname());//异常标识名称
//				peRstLisItmDO.setMark_deviate(?);//异常标识
				peRstLisItmDO.setMark_arrow(subItemInfoDTO.getMarkarrow());//箭头标识
				peRstLisItmDO.setReportor(id_emps.toString());//检验人			报告医生名称
				peRstLisItmDO.setCode_reportor(name_rpts.toString());//检验人编码	报告医生编码
				peRstLisItmDO.setVerifier(reviewernames.toString());//审核人
				peRstLisItmDO.setCode_verifier(Reviewerids.toString());//审核人编码
				peRstLisItmDO.setDt_rptver(Reviewdate.toString());//审核日期
				peRstLisItmDO.setCode_examgroup(labitemcode);//检查分组编码
				peRstLisItmDO.setName_examgroup(labitemname);//检查分组名称
				peRstLisItmDO.setCode_entp(visittype);//就诊类型编码
//				peRstLisItmDO.setName_entp(?);//就诊类型名称
				peRstLisItmDOs[i] = peRstLisItmDO;
			}
		}else{
			peRstLisItmDOs = new PeRstLisItmDO[0];
		}
		
		PerstlisAggDO aggDo = new PerstlisAggDO();
		aggDo.setParentDO(peRstLisDo);
		aggDo.setPeRstLisItmDO(peRstLisItmDOs);
		IPerstlisCudService perstlisCudService = ServiceFinder.find(IPerstlisCudService.class);
		perstlisCudService.save(new PerstlisAggDO[]{aggDo});
	}

}
