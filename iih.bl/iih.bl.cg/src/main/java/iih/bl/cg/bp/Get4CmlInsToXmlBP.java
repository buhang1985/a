package iih.bl.cg.bp;

import java.util.ArrayList;

import com.sun.org.apache.xpath.internal.FoundIndex;
import com.thoughtworks.xstream.alias.ClassMapper.Null;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.vo.pub.formulaset.function.Time;
import iih.bl.cg.bp.qry.GetBlCc4CmlInsDTOQry;
import iih.bl.cg.bp.qry.GetBlPropArOepDOQry;
import iih.bl.cg.bp.qry.GetBusSt4CmlInsDTOQry;
import iih.bl.cg.bp.qry.GetCgOrItm4CmlInsDTOQry;
import iih.bl.cg.bp.qry.GetCiOr4CmlInsDTOQry;
import iih.bl.cg.bp.qry.GetCodePatQry;
import iih.bl.cg.bp.qry.GetEn4CmlInsDTOQry;
import iih.bl.cg.bp.qry.GetEnDiag4CmlInsDTOQry;
import iih.bl.cg.bp.qry.GetEnExt4CmlInsDTOQry;
import iih.bl.cg.bp.qry.GetHisBlOrEn4CmlInsDTOQry;
import iih.bl.cg.bp.qry.GetHisBlSt4CmlInsDTOQry;
import iih.bl.cg.bp.qry.GetIncItem4CmlIncDTOQry;
import iih.bl.cg.bp.qry.GetMedUp4CmlInsDTOQry;
import iih.bl.cg.bp.qry.GetPi4CmlInsDTOQry;
import iih.bl.cg.bp.qry.GetSupplementEnExt4CmlInsDTOQry;
import iih.bl.cg.bp.self.DivideResultByXmlBp;
import iih.bl.cg.dto.d.BlCc4CmlInsDTO;
import iih.bl.cg.dto.d.BusSt4CmlInsDTO;
import iih.bl.cg.dto.d.CgOrItm4CmlInsDTO;
import iih.bl.cg.dto.d.CiOr4CmlInsDTO;
import iih.bl.cg.dto.d.En4CmlInsDTO;
import iih.bl.cg.dto.d.EnDiag4CmlInsDTO;
import iih.bl.cg.dto.d.EnExt4CmlInsDTO;
import iih.bl.cg.dto.d.HisBlOrEn4CmlInsDTO;
import iih.bl.cg.dto.d.HisBlSt4CmlInsDTO;
import iih.bl.cg.dto.d.MedUp4CmlInsDTO;
import iih.bl.cg.dto.d.Pi4CmlInsDTO;
import iih.bl.hp.divideresult.d.DivideResultDTO;
import iih.bl.hp.divideresult.d.FeeBreakDTO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blproparoep.i.IBlproparoepCudService;
import iih.bl.prop.blproparoep.i.IBlproparoepMDORService;
import iih.bl.prop.blproparoep.i.IBlproparoepRService;
import iih.ci.mr.cimr.d.desc.grtThreeThirdDoctor;
import iih.pi.overview.overview.d.PiPatDO;

/**
 * 获取高端商保 接口入参方法
 * 
 * @author yang.lu
 * @serial 2017年7月26日
 */
public class Get4CmlInsToXmlBP {

	String sysHospCode;
	/**
	 * 通过发票号集合 返回解析后的xml对象
	 * @param billNos 发票号
	 * @param codePat IIH患者CODE
	 * @param code 接口获取CODE
	 * @param firmCode 保险类型
	 * @param sysHospCode 医院编码
	 * @return
	 * @throws BizException
	 */
	public String exec(String[] billNos,String codePat,String code, String firmCode,String sysHospCode) throws BizException {
		
		this.sysHospCode=sysHospCode;
		
		StringBuilder retXML = new StringBuilder();
		// 门诊处方信息表
		CiOr4CmlInsDTO[] dtos = GetCiOr(billNos, codePat);
		// 就诊信息扩展表(无值)
		EnExt4CmlInsDTO[] enExts = this.GetEnExt(billNos, codePat);
		// 就诊信息表（无值）
		En4CmlInsDTO[] ens = this.GetEn(billNos, codePat);
		// 诊断信息
		EnDiag4CmlInsDTO[] Dtos = this.GetEnDiag(billNos, codePat);
		// 医疗费用明细信息表
		CgOrItm4CmlInsDTO[] CgOrdtos = GetCgOrItm(billNos, codePat);
		// HIS结算信息表
		HisBlSt4CmlInsDTO[] Hisdos = this.GetHisBlSt(billNos, codePat);
		// HIS结算与就诊信息关系表
		HisBlOrEn4CmlInsDTO[] HisBlOrEndTOs = this.GetHisBlOrEn(billNos, codePat);
		// 保险结算信息表（无值）
		BusSt4CmlInsDTO[] busSts = this.GetBusSt(billNos, codePat);
		// 结算账单信息表
		BlCc4CmlInsDTO[] blccs = this.GetBlCc(billNos, codePat);

		// 医疗费用上传信息
		MedUp4CmlInsDTO[] medUps = this.GetMedUp(billNos, codePat);

		
		retXML.append("<root>");
		// S----设置 头
		retXML.append("<head>");
		retXML.append(GetAttriVal("pid", code));
		retXML.append("<billsNo>");
		for (String str : billNos) {
			retXML.append(GetAttriVal("string", str));
		}
		retXML.append("</billsNo>");
		retXML.append("<sysHospCode>"+sysHospCode+"</sysHospCode>");
		retXML.append(GetAttriVal("sysBxFirmCode", firmCode));
		if(Hisdos!=null &&Hisdos.length!=0){
			if (Hisdos[0].getAccounts_type().equals("mz_yb")||Hisdos[0].getAccounts_type().equals("gh_yb"))
				retXML.append("<status>1</status>");
			if (Hisdos[0].getAccounts_type().equals("mz_zf")||Hisdos[0].getAccounts_type().equals("gh_zf"))
				retXML.append("<status>4</status>");
			
		}
	
		retXML.append("</head>");
		// E----设置头

		retXML.append("<body>");
		retXML.append("<input_param>");
		// 险种类型
		retXML.append(GetAttriVal("fundtype", firmCode));
		// 患者信息
		retXML.append(GetPi4CmlInsDTOTOXML(codePat));

		// bills <!-- HIS结算信息表 -->
		retXML.append("<bills>");

		retXML.append(GetHisBlStXML(Hisdos, HisBlOrEndTOs, blccs, busSts, medUps));

		retXML.append("</bills>");
		// <!-- 就诊信息 -->
		retXML.append("<visits>");
		// 就诊信息表(无值)
		retXML.append(GetEnXML(ens, enExts, dtos, Dtos, CgOrdtos));

		retXML.append("</visits>");

		retXML.append("</input_param>");

		retXML.append("</body>");

		retXML.append("</root>");

//		throw new BizException("---------------" + retXML.toString());
		// 结束
		 return retXML.toString();
	}

	private String GetAttriVal(String code, Object obj) {
		if (obj != null)
			return "<" + code + ">" + obj.toString() + "</" + code + ">";
		return "";
	}

	/**
	 * 9获取就诊信息表6XML
	 * 
	 * @param billNos
	 * @return
	 */
	private String GetEnXML(En4CmlInsDTO[] ens, EnExt4CmlInsDTO[] enExts, CiOr4CmlInsDTO[] dtos, EnDiag4CmlInsDTO[] Dtos, CgOrItm4CmlInsDTO[] CgOrdtos) throws BizException {
		StringBuilder retXML = new StringBuilder();

		if (ens == null || ens.length == 0)
			return "";
		for (En4CmlInsDTO en : ens) {
			retXML.append("<visit>");
			// 就诊号
			retXML.append(GetAttriVal("visitNo", en.getVisit_no()));
			// 就诊扩展信息
			retXML.append("<patientEncounterExtensionEntity>");
			for (EnExt4CmlInsDTO enext : enExts) {
				if (enext.getVisit_no().equals(en.getVisit_no())) {
					retXML.append(GetEnExtXML(enext));
					break;
				}
			}

			retXML.append("</patientEncounterExtensionEntity>");
			// 诊断信息
			retXML.append("<diagnosiss>");
			// 诊断信息
			retXML.append(GetEnDiagXML(Dtos));
			retXML.append("</diagnosiss>");
			// 处方信息
			retXML.append("<prescriptions>");
			// 获取 门诊处方信息表11XML
			retXML.append(GetCiOrXML(dtos, CgOrdtos));
			retXML.append("</prescriptions>");

			retXML.append("<!--就诊地区代码-->");
			retXML.append(GetAttriVal("regionCode", en.getRegion_code()));
			retXML.append("<!--就诊医疗集团-->");
			retXML.append(GetAttriVal("organizationGroup", en.getOrganization_group()));
			retXML.append("<!--医疗机构代码-->");
			retXML.append(GetAttriVal("organizationId", sysHospCode));
			retXML.append("<!--病人类别-->");
			retXML.append(GetAttriVal("code", en.getCode()));
			retXML.append("<!--患者ID-->");
			retXML.append(GetAttriVal("pid", en.getPid()));
			retXML.append("<!--患者姓名-->");
			retXML.append(GetAttriVal("patientname", en.getPatientname()));
			retXML.append("<!--病人身份-->");
			retXML.append(GetAttriVal("responseType", en.getResponse_type()));
			retXML.append("<!--病人费别-->");
			retXML.append(GetAttriVal("chargeType", en.getCharge_type()));
			retXML.append("<!--门诊就诊次数-->");
			retXML.append(GetAttriVal("outVisitTimes", en.getOut_visit_times()));
			retXML.append("<!--挂号号别-->");
			// TODO 无字段,DTO修改
			retXML.append(GetAttriVal("visitTypeCode", en.getVisit_type_code()));
			retXML.append("<!--挂号科室-->");
			retXML.append(GetAttriVal("ghDept", en.getGh_dept()));
			retXML.append("<!--挂号医生-->");
			retXML.append(GetAttriVal("ghDoctor", en.getGh_doctor()));
			retXML.append("<!--门诊就诊科室-->");
			retXML.append(GetAttriVal("visitDept", en.getVisit_dept()));
			retXML.append("<!--门诊就诊科室名称-->");
			retXML.append(GetAttriVal("visitDeptNm", en.getVisit_dept_nm()));
			retXML.append("<!--门诊就诊医生-->");
			retXML.append(GetAttriVal("visitDoctor", en.getVisit_doctor()));
			retXML.append("<!--门诊就诊医生姓名-->");
			retXML.append(GetAttriVal("visitDoctorNm", en.getVisit_doctor_nm()));
			retXML.append("<!--就诊开始时间-->");
			retXML.append(GetAttriVal("effectiveB", en.getEffective_b()));
			retXML.append("<!--就诊结束时间-->");
			retXML.append(GetAttriVal("effectiveE", en.getEffective_e()));
			retXML.append("<!--入院方式-->");
			retXML.append(GetAttriVal("admitterMode", en.getAdmitter_mode()));
			retXML.append("<!--就诊原因-->");
			retXML.append(GetAttriVal("reasonCode", en.getReason_code()));
			retXML.append("<!--病人来源-->");
			retXML.append(GetAttriVal("admitterSource", en.getAdmitter_source()));
			retXML.append("<!--住院次数-->");
			retXML.append(GetAttriVal("", en.getIn_visit_times()));
			retXML.append("<!--入院科室-->");
			retXML.append(GetAttriVal("admissDept", en.getAdmiss_dept()));
			retXML.append("<!--入院科室名称-->");
			retXML.append(GetAttriVal("admissDeptNm", en.getAdmiss_dept_nm()));
			retXML.append("<!--入院病区-->");
			retXML.append(GetAttriVal("admissWard", en.getAdmiss_ward()));
			retXML.append("<!--入院医生-->");
			retXML.append(GetAttriVal("admitter", en.getAdmitter()));
			retXML.append("<!--主管医生-->");
			retXML.append(GetAttriVal("attender", en.getAttender()));
			retXML.append("<!--主管护士-->");
			retXML.append(GetAttriVal("nurser", en.getNurser()));
			retXML.append("<!--出院科室-->");
			retXML.append(GetAttriVal("dischargerDept", en.getDischarger_dept()));
			retXML.append("<!--出院科室名称-->");
			retXML.append(GetAttriVal("dischargerDeptNm", en.getDischarger_dept_nm()));
			retXML.append("<!--出院病区-->");
			retXML.append(GetAttriVal("disWard", en.getDis_ward()));
			retXML.append("<!--床号-->");
			retXML.append(GetAttriVal("bedNo", en.getBed_no()));
			retXML.append("<!--出院医生-->");
			retXML.append(GetAttriVal("discharger", en.getDischarger()));
			retXML.append("<!--出院状态-->");
			retXML.append(GetAttriVal("disStatus", en.getDis_status()));
			retXML.append("<!--科室主任-->");
			retXML.append(GetAttriVal("deptDirector", en.getDept_director()));
			retXML.append("<!--病情状态-->");
			retXML.append(GetAttriVal("patientStatus", en.getPatient_status()));
			retXML.append("<!--录入者-->");
			retXML.append(GetAttriVal("typer", en.getTyper()));
			retXML.append("<!--录入时间-->");
			retXML.append(GetAttriVal("typerTime", en.getTyper_time()));
			retXML.append("<!--标志-->");
			retXML.append(GetAttriVal("statusCode", en.getStatus_code()));
			retXML.append("<!--挂号交易流水号-->");
			retXML.append(GetAttriVal("visitOrderNumber", en.getVisit_order_number()));

			retXML.append("</visit>");
		}

		return retXML.toString();
	}

	/**
	 * 10获取就诊信息扩展表5XML
	 * 
	 * @param billNos
	 * @return
	 */
	private String GetEnExtXML(EnExt4CmlInsDTO dto) throws BizException {
		StringBuilder retXML = new StringBuilder();

		retXML.append("<!--患者就诊ID-->");

		// TODO DTO修改
		retXML.append(GetAttriVal("patientEncounterId", dto.getPatientencounterid()));
		retXML.append("<!--病历信息-->");
		retXML.append(GetAttriVal("illnesshistory", dto.getIllnesshistory()).replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "").replaceAll("'", ""));
		retXML.append("<!--医师职称-->");
		retXML.append(GetAttriVal("doctorlevel", dto.getDoctorlevel()));
		retXML.append("<!--代开药标识-->");
		retXML.append(GetAttriVal("prescribeflag", dto.getPrescribeflag()));
		retXML.append("<!--手术编码-->");
		retXML.append(GetAttriVal("operationcode", dto.getOperationcode()));
		retXML.append("<!--手术名称-->");
		retXML.append(GetAttriVal("operation", dto.getOperation()));
		retXML.append("<!--更新标识-->");
		retXML.append(GetAttriVal("upflag", dto.getUpflag()));
		retXML.append("<!--既往史-->");
		retXML.append(GetAttriVal("history", dto.getHistory()).replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "").replaceAll("'", ""));
		retXML.append("<!--主诉-->");
		retXML.append(GetAttriVal("zhushu", dto.getZhushu()).replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "").replaceAll("'", ""));
		retXML.append("<!--单据类型-->");
		retXML.append(GetAttriVal("invoicetyepe", dto.getInvoicetyepe()));
		retXML.append("<!--备注-->");
		retXML.append(GetAttriVal("remark", dto.getRemark()));
		retXML.append("<!--创建时间-->");
		retXML.append(GetAttriVal("createdate", dto.getCreatedate()));
		retXML.append("<!--创建人-->");
		retXML.append(GetAttriVal("createuserid", dto.getCreateuserid()));
		retXML.append("<!--更新时间-->");
		retXML.append(GetAttriVal("updatedate", dto.getUpdatedate()));
		retXML.append("<!--更新人-->");
		retXML.append(GetAttriVal("updateuserid", dto.getUpdateuserid()));
		retXML.append("<!--患者就诊扩展ID-->");
		// TODO 无字段
		retXML.append(GetAttriVal("patientEncounterExtsionId", dto.getPatient_encounter_extsion_id()));
		retXML.append("<!--患者ID-->");
		retXML.append(GetAttriVal("pid", dto.getPid()));
		retXML.append("<!--手术时间-->");
		retXML.append(GetAttriVal("operationdate", dto.getOperationdate()));
		retXML.append("<!--手术医师-->");
		retXML.append(GetAttriVal("operationdoctor", dto.getOperationdoctor()));
		retXML.append("<!--麻醉方式-->");
		retXML.append(GetAttriVal("anaesthesiatype", dto.getAnaesthesiatype()));
		retXML.append("<!--麻醉医师-->");
		retXML.append(GetAttriVal("anaesthesiadoctor", dto.getAnaesthesiadoctor()));
		retXML.append("<!--手术过程-->");
		retXML.append(GetAttriVal("process", dto.getProcess()));
		retXML.append("<!--现病史-->");
		retXML.append(GetAttriVal("presenthistory", dto.getPresenthistory()));
		retXML.append("<!--家族史（遗传病）-->");
		retXML.append(GetAttriVal("geneticdisease", dto.getGeneticdisease()));
		retXML.append("<!--体格检查-->");
		retXML.append(GetAttriVal("examination", dto.getExamination()));

		return retXML.toString();

	}

	/**
	 * 8获取 门诊处方信息表11XML
	 * 
	 * @param billNos
	 * @return
	 */

	private String GetCiOrXML(CiOr4CmlInsDTO[] dtos, CgOrItm4CmlInsDTO[] CgOrdtos) throws BizException {
		StringBuilder retXML = new StringBuilder();
		if (dtos == null || dtos.length == 0)
			return "";

		for (CiOr4CmlInsDTO dto : dtos) {
			retXML.append("<!-- 处方信息 -->");
			retXML.append("<prescription>");
			retXML.append(" <!-- 处方号 -->");
			retXML.append(GetAttriVal("recipeno", dto.getRecipeno()));
			retXML.append("<!-- 处方类别 -->");
			retXML.append(GetAttriVal("recipeCat", dto.getRecipe_cat()));
			retXML.append("<!-- 费用信息 -->");
			// 费用信息
			retXML.append("<costs>");
			if(CgOrdtos!=null && CgOrdtos.length!=0){
				for(CgOrItm4CmlInsDTO Cgordto : CgOrdtos){
					if(Cgordto.getRecipeno()==null || Cgordto.getRecipeno().equals(dto.getRecipeno())){

						retXML.append(GetCgOrItmXML(Cgordto));
					}
					
				}
				
				
			}
			
			
			retXML.append("</costs>");

			retXML.append("<!--就诊号-->");
			retXML.append(GetAttriVal("visitNo", dto.getVisit_no()));
			retXML.append("<!--患者ID-->");
			retXML.append(GetAttriVal("pid", dto.getPid()));
			retXML.append("<!--处方类型-->");
			retXML.append(GetAttriVal("recipetype", dto.getRecipetype()));
			retXML.append("<!--开方医生-->");
			retXML.append(GetAttriVal("doctorcode", dto.getDoctorcode()));
			retXML.append("<!--开方医生姓名-->");
			retXML.append(GetAttriVal("doctorname", dto.getDoctorname()));
			retXML.append("<!--处方时间-->");
			retXML.append(GetAttriVal("recipedate", dto.getRecipedate()));
			retXML.append("<!--his交易流水号-->");
			retXML.append(GetAttriVal("histradeno", dto.getHistradeno()));
			retXML.append("</prescription>");

		}

		return retXML.toString();
	}

	/**
	 * 6 获取医疗费用明细信息表 4
	 * 
	 * @param billNos
	 * @return
	 */
	private String GetCgOrItmXML(CgOrItm4CmlInsDTO dto) throws BizException {
		StringBuilder retXML = new StringBuilder();
		if (dto == null )
			return "";

		
			retXML.append("<!-- 医疗费用明细信息 -->");
			retXML.append("<cost>");
			retXML.append("<!-- 费用金额 -->");
			retXML.append(GetAttriVal("toatlamount", dto.getToatlamount()));
			retXML.append("<!-- 就诊号 -->");
			retXML.append(GetAttriVal("visitNo", dto.getVisit_no()));
			retXML.append("<!-- 患者ID -->");
			retXML.append(GetAttriVal("pid", dto.getPid()));
			retXML.append("<!-- 处方号 -->");
			retXML.append(GetAttriVal("recipeno", dto.getRecipeno()));
			retXML.append("<!--项目号-->");
			retXML.append(GetAttriVal("orderno", dto.getOrderno()));
			retXML.append("<!--HIS项目编码-->");
			retXML.append(GetAttriVal("hiscode", dto.getHiscode()));
			retXML.append("<!--HIS项目名称-->");
			retXML.append(GetAttriVal("hisname", dto.getHisname()));
			retXML.append("<!--规格-->");
			retXML.append(GetAttriVal("drugSpecification", dto.getDrug_specification()));
			retXML.append("<!--剂型-->");
			retXML.append(GetAttriVal("dose", dto.getDose()));
			retXML.append("<!--剂量-->");
			retXML.append(GetAttriVal("dosege", dto.getDosege()));
			retXML.append("<!--剂量单位-->");
			retXML.append(GetAttriVal("doseUnit", dto.getDose_unit()));
			retXML.append("<!--用量单位-->");
			retXML.append(GetAttriVal("miniUnit", dto.getMini_unit()));
			retXML.append("<!--用法-->");
			retXML.append(GetAttriVal("supplyCode", dto.getSupply_code()));
			retXML.append("<!--频率-->");
			retXML.append(GetAttriVal("frequCode", dto.getFrequ_code()));
			retXML.append("<!--执行天数-->");
			retXML.append(GetAttriVal("persisDays", dto.getPersis_days()));
			retXML.append("<!--实际用药天数-->");
			retXML.append(GetAttriVal("persisDaysReal", dto.getPersis_days_real()));
			retXML.append("<!--单价-->");
			retXML.append(GetAttriVal("price", dto.getPrice()));
			retXML.append("<!--数量-->");
			retXML.append(GetAttriVal("amount", dto.getAmount()));
			retXML.append("<!--数量单位-->");
			retXML.append(GetAttriVal("pickUnit", dto.getPick_unit()));
			retXML.append("<!--HIS账单码-->");
			retXML.append(GetAttriVal("hisbillcode", dto.getHisbillcode()));
			retXML.append("<!--适应症标志-->");
			retXML.append(GetAttriVal("fittingFlag", dto.getFitting_flag()));
			retXML.append("<!--自费标志-->");
			retXML.append(GetAttriVal("selfFlag", dto.getSelf_flag()));
			retXML.append("<!--皮试标志-->");
			retXML.append(GetAttriVal("skinTestFlag", dto.getSkin_test_flag()));
			retXML.append("<!--药品批准文号-->");
			retXML.append(GetAttriVal("drugApprovalNumber", dto.getDrug_approval_number()));
			retXML.append("<!--执行科室-->");
			retXML.append(GetAttriVal("execDept", dto.getExec_dept()));
			retXML.append("<!--药房编码-->");
			retXML.append(GetAttriVal("pharmacyCode", dto.getPharmacy_code()));
			retXML.append("<!--收费员-->");
			retXML.append(GetAttriVal("chargeOpera", dto.getCharge_opera()));
			retXML.append("<!--收费时间-->");
			retXML.append(GetAttriVal("chargedate", dto.getChargedate()));
			retXML.append("<!--HIS交易流水号-->");
			retXML.append(GetAttriVal("tradeno", dto.getHistradeno()));
			retXML.append("</cost>");
		

		return retXML.toString();

	}

	/**
	 * HIS结算信息表XML
	 * 
	 * @param billNos
	 * @param codePat
	 * @return
	 * @throws BizException
	 */

	private String GetHisBlStXML(HisBlSt4CmlInsDTO[] stdos, HisBlOrEn4CmlInsDTO[] HisBlOrEndTOs, BlCc4CmlInsDTO[] blccs, BusSt4CmlInsDTO[] busSts, MedUp4CmlInsDTO[] medUps) throws BizException {
		StringBuilder retXML = new StringBuilder();

		//

		if (stdos == null || stdos.length == 0)
			return "";

		for (HisBlSt4CmlInsDTO stdo : stdos) {
			retXML.append("<bill>");
			// 总费用
			retXML.append(GetAttriVal("cost", stdo.getCost()));
			// <!-- 结算类型 -->
			retXML.append(GetAttriVal("accountsType", stdo.getAccounts_type()));
			retXML.append("<jzjsxxs>");
			// <!-- HIS结算与就诊信息关系表 -->
			retXML.append(GetHisBlOrEnXML(HisBlOrEndTOs));

			retXML.append("</jzjsxxs>");
			// 保险结算信息表
			retXML.append("<bxjsxxs>");
			retXML.append(GetBusStXML(busSts, medUps));
			retXML.append("</bxjsxxs>");

			// 结算账单信息表
			retXML.append("<billDetails>");

			retXML.append(GetBlCcXML(blccs));

			retXML.append("</billDetails>");

			// HIS交易流水号
			retXML.append(GetAttriVal("histradeno", stdo.getHistradeno()));
			// 医保交易流水号
			retXML.append(GetAttriVal("ybtradeno", stdo.getYbtradeno()));
			// 结算地区代码/
			retXML.append(GetAttriVal("regionCode", stdo.getRegion_code()));
			// 结算医疗集团
			retXML.append(GetAttriVal("organizationGroup", stdo.getOrganization_group()));
			// 医疗机构代码
			retXML.append(GetAttriVal("organizationId", sysHospCode));
			// TODO 医疗机构名称 (无字段)
			retXML.append(GetAttriVal("organizationName", "北大国际医院"));
			// 患者ID
			retXML.append(GetAttriVal("pid", stdo.getPid()));
			// 患者姓名
			retXML.append(GetAttriVal("patientname", stdo.getPatientname()));
			// 社保承担
			retXML.append(GetAttriVal("socialSecurity", stdo.getSocial_security()));
			// 商保承担
			retXML.append(GetAttriVal("commercialInsurance", stdo.getCommercial_insurance()));
			// 医院减免
			retXML.append(GetAttriVal("hospital", stdo.getHospital()));
			// 第三方承担
			retXML.append(GetAttriVal("others", stdo.getOthers()));
			// 个人支付
			retXML.append(GetAttriVal("personalPayment", stdo.getPersonal_payment()));
			// HIS收费单据号
			retXML.append(GetAttriVal("hisfeeno", stdo.getHisfeeno()));
			// 收费员
			retXML.append(GetAttriVal("chargeOpera", stdo.getCharge_opera()));
			// 收费员姓名
			retXML.append(GetAttriVal("chargeOperaNm", stdo.getCharge_opera_nm()));
			// 收费时间
			retXML.append(GetAttriVal("chargedate", stdo.getChargedate()));

			retXML.append("</bill>");
		}

		return retXML.toString();
	}

	/**
	 * 3获取结算账单信息表10XML
	 * 
	 * @param billNos
	 * @return
	 */
	private String GetBlCcXML(BlCc4CmlInsDTO[] blccs) throws BizException {
		StringBuffer retXML = new StringBuffer();

		if (blccs == null || blccs.length == 0)
			return "";

		for (BlCc4CmlInsDTO blcc : blccs) {
			retXML.append("<billDetail>");
			// his交易流水号
			retXML.append(GetAttriVal("histradeno", blcc.getHistradeno()));
			// 患者ID
			retXML.append(GetAttriVal("pid", blcc.getPid()));
			// 保险结算ID
			retXML.append(GetAttriVal("bxjsid", blcc.getBxjsid()));
			// TODO 账单码标准(无字段)
			retXML.append(GetAttriVal("jzstartdatebz", blcc.getJs_bill_code_bz()));
			// 账单码
			retXML.append(GetAttriVal("jsbillcode", blcc.getJs_bill_code()));
			// 账单值
			retXML.append(GetAttriVal("jsbillvalue", blcc.getJs_bill_value()));

			retXML.append("</billDetail>");

		}

		return retXML.toString();

	}

	/*
	 * 4获取社商结算信息表 9XML
	 * 
	 * @param billNos
	 * 
	 * @return
	 */
	private String GetBusStXML(BusSt4CmlInsDTO[] busSts, MedUp4CmlInsDTO[] medUps) throws BizException {
		StringBuffer retXML = new StringBuffer();

		if (busSts == null || busSts.length == 0)
			return "";
		for (BusSt4CmlInsDTO busSt : busSts) {
			// 社商结算信息子表
			retXML.append("<bxjsxx>");

			// TODO
			// 保险结算ID(表中无该字段)
			retXML.append("<bxjsid></bxjsid>");
			// 医疗费用上传信息
			retXML.append("<ylfysends>");

			retXML.append(GetMedUpXML(medUps));

			retXML.append("</ylfysends>");
			// 保险交易流水号
			retXML.append(GetAttriVal("tradeno", busSt.getTradeno()));
			// 社保卡卡号
			retXML.append(GetAttriVal("sscardno", busSt.getSscardno()));
			// 医保应用号
			retXML.append(GetAttriVal("healthcardno", busSt.getHealthcardno()));
			// 医保是否已结算
			retXML.append(GetAttriVal("hascalculated", busSt.getHascalculated()));
			// 患者姓名
			retXML.append(GetAttriVal("patientname", busSt.getPatientname()));
			// 性别
			retXML.append(GetAttriVal("sex", busSt.getSex()));
			// 证件类型
			retXML.append(GetAttriVal("cardtype", busSt.getCardtype()));
			// 证件号码
			retXML.append(GetAttriVal("cardno", busSt.getCardno()));
			// 出生日期
			FDateTime birthdate=null;
			if ( busSt.getBirthdate()!=null) {
				 birthdate=new FDateTime(busSt.getBirthdate(), new FTime("00:00:01"));	
			}
			retXML.append(GetAttriVal("birthdate", birthdate));
			// 医疗机构编码
			retXML.append(GetAttriVal("yydm", sysHospCode));
			// 医院名称
			retXML.append(GetAttriVal("yymc", "北京大学国际医院"));
			// 医疗类别
			retXML.append(GetAttriVal("medicaltype", busSt.getMedicaltype()));
			// 就诊方式
			retXML.append(GetAttriVal("jzfs", busSt.getJzfs()));
			// 收费单据号
			retXML.append(GetAttriVal("invoiceno", busSt.getInvoiceno()));
			// TODO
			// 收费员(未发现字段)
			retXML.append(GetAttriVal("invoiceuser", busSt.getCollector()));

			// 收费日期(未发现字段)
			retXML.append(GetAttriVal("invoicedate", busSt.getCharge_time()));

			// 就诊/住院开始日期
			retXML.append(GetAttriVal("jzstartdate", busSt.getJzstartdate()));
			// 就诊/住院结束日期
			retXML.append(GetAttriVal("jzenddate", busSt.getJzenddate()));
			// 批次号
			retXML.append(GetAttriVal("batchno", busSt.getBatchno()));
			// 费用总金额
			retXML.append(GetAttriVal("totalpayamount", busSt.getTotalpayamount()));
			// 基金支付金额
			retXML.append(GetAttriVal("fundpayamount", busSt.getFundpayamount()));
			// 责任代码
			retXML.append(GetAttriVal("dutycode", busSt.getDutycode()));
			// 个人支付金额
			retXML.append(GetAttriVal("cashpayamount", busSt.getCashpayamount()));
			// 个人账户支付金额
			retXML.append(GetAttriVal("personalpayamount", busSt.getPersonalpayamount()));
			// 个人帐户余额
			retXML.append(GetAttriVal("remainamount", busSt.getRemainamount()));
			// 医保内总金额
			retXML.append(GetAttriVal("insuranceamount", busSt.getInsuranceamount()));
			// 医保外总金额
			retXML.append(GetAttriVal("outinsuranceamount", busSt.getOutinsuranceamount()));
			// 本次付起付线金额
			retXML.append(GetAttriVal("beginpayamount", busSt.getBeginpayamount()));
			// 门诊大额支付金额
			retXML.append(GetAttriVal("opbigpaymount", busSt.getOpbigpaymount()));
			// 门诊大额自付金额（自付一）
			retXML.append(GetAttriVal("opselfpayamount", busSt.getOpselfpayamount()));
			// 超大额自付金额
			retXML.append(GetAttriVal("bigselfpayamount", busSt.getBigselfpayamount()));
			// 补充保险支付金额
			retXML.append(GetAttriVal("addinsurancepayayamount", busSt.getAddinsurancepayayamount()));
			// 军残补助保险金额
			retXML.append(GetAttriVal("residualpayamount", busSt.getResidualpayamount()));
			// 个人自付二
			retXML.append(GetAttriVal("selfpayamount2", busSt.getSelfpayamount2()));
			// 自费
			retXML.append(GetAttriVal("selfpay", busSt.getSelfpay()));
			// 医院减免
			retXML.append(GetAttriVal("hospitalbreaks", busSt.getHospitalbreaks()));
			// 西药
			retXML.append(GetAttriVal("xyao", busSt.getXyao()));
			// 中成药
			retXML.append(GetAttriVal("zchyao", busSt.getZchyao()));
			// 中草药
			retXML.append(GetAttriVal("zcyao", busSt.getZcyao()));
			// 检查费
			retXML.append(GetAttriVal("examinecost", busSt.getExaminecost()));
			// 放射
			retXML.append(GetAttriVal("radiate", busSt.getRadiate()));
			// B超
			retXML.append(GetAttriVal("bultrasonic", busSt.getBultrasonic()));
			// 核磁
			retXML.append(GetAttriVal("nmr", busSt.getNmr()));
			// 治疗费
			retXML.append(GetAttriVal("testcost", busSt.getTestcost()));
			// 材料费
			retXML.append(GetAttriVal("materialscost", busSt.getMaterialscost()));
			// 手术费
			retXML.append(GetAttriVal("operationcost", busSt.getOperationcost()));
			// 输氧费
			retXML.append(GetAttriVal("oxygencost", busSt.getOxygencost()));
			// 输血费
			retXML.append(GetAttriVal("bloodcost", busSt.getBloodcost()));
			// 正畸费
			retXML.append(GetAttriVal("orthodonticcost", busSt.getOrthodonticcost()));
			// 镶牙费
			retXML.append(GetAttriVal("inserttoothcost", busSt.getInserttoothcost()));
			// 司法鉴定
			retXML.append(GetAttriVal("sfjdcost", busSt.getSfjdcost()));
			// 其他项目
			retXML.append(GetAttriVal("othercost", busSt.getOthercost()));
			// 诊察费
			retXML.append(GetAttriVal("diagnosticcost", busSt.getDiagnosticcost()));
			// 化验费
			retXML.append(GetAttriVal("treatcost", busSt.getTreatcost()));
			// 医事服务费
			retXML.append(GetAttriVal("medicalservcost", busSt.getMedicalservcost()));
			// 一般诊疗费
			retXML.append(GetAttriVal("consultationcost", busSt.getConsultationcost()));
			// 挂号费
			retXML.append(GetAttriVal("registrationcost", busSt.getRegistrationcost()));
			// 其他门诊收费
			retXML.append(GetAttriVal("othermzcost", busSt.getOthermzcost()));
			// 是否退费
			retXML.append(GetAttriVal("ISBACKCOST", busSt.getIsbackcost()));
			// 创建人
			retXML.append(GetAttriVal("createuserid", busSt.getCreateuserid()));
			// 创建时间
			retXML.append(GetAttriVal("createdate", busSt.getCreatedate()));
			// 更新人
			retXML.append(GetAttriVal("updateuserid", busSt.getUpdateuserid()));
			// 更新时间
			retXML.append(GetAttriVal("updatedate", busSt.getUpdatedate()));
			// 更新标示
			retXML.append(GetAttriVal("upflag", busSt.getUpflag()));
			// 是否按照单病种结算
			retXML.append(GetAttriVal("issingleill", busSt.getIssingleill()));
			// //结算账单信息表
			// retXML.append("<billDetails>");
			// BlCc4CmlInsDTO[] blccs=this.GetBlCc(billNos, codePat);
			// for (BlCc4CmlInsDTO blcc : blccs) {
			// retXML.append("<billDetail>");
			// //his交易流水号
			// retXML.append("<histradeno>"+blcc.getHistradeno()+"</histradeno>");
			// //患者ID
			// retXML.append("<pid>"+blcc.getPid()+"</pid>");
			// //保险结算ID
			// retXML.append("<bxjsid>"+blcc.getBxjsid()+"</bxjsid>");
			// //TODO 账单码标准(无字段)
			// //retXML.append("<jzstartdatebz>"+blcc.getjz+"</jzstartdatebz>");
			// //账单码
			// retXML.append("<jsbillcode>"+blcc.getJs_bill_code()+"</jsbillcode>");
			// //账单值
			// retXML.append("<jsbillvalue>"+blcc.getJs_bill_value()+"</jsbillvalue>");
			//
			// retXML.append("</billDetail>");
			//
			// }

			// retXML.append("</billDetails>");

			retXML.append("</bxjsxx>");

		}
		return retXML.toString();
	}

	/**
	 * 5获取医疗费用上传信息表3XML
	 * 
	 * @param billNos
	 * @return
	 */
	private String GetMedUpXML(MedUp4CmlInsDTO[] medUps) throws BizException {
		StringBuilder retXML = new StringBuilder();

		if (medUps == null || medUps.length == 0)
			return "";

		for (MedUp4CmlInsDTO medUp : medUps) {
			// 医疗费用信息上传
			retXML.append("<ylfysend>");
			// his交易流水号
			retXML.append(GetAttriVal("HISTRADENO", medUp.getHistradeno()));
			// HIS费用明细ID
			retXML.append(GetAttriVal("HISFYMXID", medUp.getHisfymxid()));
			// 就诊号
			retXML.append(GetAttriVal("VISIT_NO", medUp.getVisit_no()));
			// 付款方类别：医保、商保、第三方
			retXML.append(GetAttriVal("PAY_TYPE", medUp.getPay_type()));
			// 保险地区代码
			retXML.append(GetAttriVal("REGION_CODE", medUp.getRegion_code()));
			// 保险机构代码
			retXML.append(GetAttriVal("ORGANIZATION_ID", medUp.getOrganization_id()));
			// 保险交易流水号
			retXML.append(GetAttriVal("BXTRADENO", medUp.getBxtradeno()));
			// 患者ID
			retXML.append(GetAttriVal("PID", medUp.getPid()));
			// HIS项目编码
			retXML.append(GetAttriVal("HISCODE", medUp.getHiscode()));
			// HIS项目名称
			retXML.append(GetAttriVal("HISNAME", medUp.getHiscode()));
			// 项目类别（0药品 1诊疗项目 2服务设施）
			retXML.append(GetAttriVal("ITEMTYPE", medUp.getItemtype()));
			// 医保收费类别
			retXML.append(GetAttriVal("CHARGETYPE", medUp.getChargetype()));
			// 医保项目编码
			retXML.append(GetAttriVal("YBITEMCODE", medUp.getYbitemcode()));
			// 医保项目名称
			retXML.append(GetAttriVal("YBITEMNAME", medUp.getYbitemname()));
			// 费用分组:甲乙丙
			retXML.append(GetAttriVal("CHARGE_GROUP", medUp.getCharge_group()));
			// 单价
			retXML.append(GetAttriVal("PRICE", medUp.getPrice()));
			// 数量
			retXML.append(GetAttriVal("AMOUNT", medUp.getAmount()));
			// 金额
			retXML.append(GetAttriVal("TOATLAMOUNT", medUp.getToatlamount()));
			// 上传人
			retXML.append(GetAttriVal("SEND_OPERA", medUp.getSend_opera()));
			// 上传时间
			retXML.append(GetAttriVal("SENDDATE", medUp.getSenddate()));
			// 保险内金额
			retXML.append(GetAttriVal("INSURANCE_AMOUNT", medUp.getInsurance_amount()));
			// 保险外金额
			retXML.append(GetAttriVal("OUT_INSURANCE_AMOUNT", medUp.getOut_insurance_amount()));
			// 个人自付二
			retXML.append(GetAttriVal("PERSONAL_PAY_TWO", medUp.getPersonal_pay_two()));
			// 分解状态
			retXML.append(GetAttriVal("ANALYZE_STUTE", medUp.getAnalyze_stute()));
			// 项目号
			retXML.append(GetAttriVal("ORDERNO", medUp.getOrderno()));
			// 处方号
			retXML.append(GetAttriVal("RECIPENO", medUp.getRecipeno()));
			retXML.append("</ylfysend>");

		}
		return retXML.toString();

	}

	private String GetPi4CmlInsDTOTOXML(String codePat) throws BizException {
		StringBuilder retXML = new StringBuilder();
		Pi4CmlInsDTO[] pis = GetPi(codePat);
		if (pis == null || pis.length == 0)
			return "";

		// retXML.append("<!-- 患者id -->");
		retXML.append(GetAttriVal("pid", pis[0].getPid()));
		// retXML.append("<!-- 患者姓名 -->");
		retXML.append(GetAttriVal("patientname", pis[0].getPatientname()));
		// retXML.append("<!-- 就诊医保计划id -->");
		retXML.append("<visitInsurancePlanId>" + "</visitInsurancePlanId>");
		// retXML.append("<!-- 性别 -->");
		retXML.append(GetAttriVal("sex", pis[0].getSex()));
		// retXML.append("<!-- 生日 -->");
		FDateTime birthdate=null;
		if ( pis[0].getBirthdate()!=null) {
			 birthdate=new FDateTime(pis[0].getBirthdate(), new FTime("00:00:00"));	
		}
		retXML.append(GetAttriVal("birthdate",birthdate ));
		// retXML.append("<!-- 民族 -->");
		retXML.append(GetAttriVal("race", pis[0].getRace()));
		// retXML.append("<!-- 婚姻 -->");
		retXML.append(GetAttriVal("marital", pis[0].getMarital()));
		// retXML.append("<!-- 国籍 -->");
		retXML.append(GetAttriVal("nationalityCode", pis[0].getNationality_code()));
		// retXML.append("<!-- 出生地 -->");
		retXML.append(GetAttriVal("birthPlace", pis[0].getBirth_place()));
		// retXML.append("<!-- 职业 -->");
		retXML.append(GetAttriVal("occupationCode", pis[0].getOccupation_code()));
		// retXML.append("<!-- 身份证号 -->");
		retXML.append(GetAttriVal("socialNo", pis[0].getSocial_no()));
		// retXML.append("<!-- 证件类型 -->");
		retXML.append(GetAttriVal("credentialtype", pis[0].getCredentialtype()));
		// retXML.append("<!-- 证件号码 -->");
		retXML.append(GetAttriVal("credentialno", pis[0].getCredentialno()));
		// retXML.append("<!-- 社保地区代码 -->");
		retXML.append(GetAttriVal("regionCode", pis[0].getRegion_code()));
		// retXML.append("<!-- 社保机构代码 -->");
		retXML.append(GetAttriVal("organizationId", pis[0].getOrganization_id()));
		// retXML.append("<!-- 社保卡卡号 -->");
		retXML.append(GetAttriVal("sscardno", pis[0].getSscardno()));
		// retXML.append("<!-- 医保应用号 -->");
		retXML.append(GetAttriVal("healthcardno", pis[0].getHealthcardno()));
		// retXML.append("<!-- 住院号 -->");
		retXML.append(GetAttriVal("inPatientNo", pis[0].getIn_patient_no()));
		// retXML.append("<!-- 门诊号 -->");
		retXML.append(GetAttriVal("outPatientNo", pis[0].getOut_patient_no()));
		// retXML.append("<!-- 医疗证号 -->");
		retXML.append(GetAttriVal("hicNo", pis[0].getHic_no()));
		// retXML.append("<!-- 现住址地区编码 -->");
		retXML.append(GetAttriVal("homeAddrCode", pis[0].getHome_pcode()));
		// retXML.append("<!-- 现住址 -->");
		retXML.append(GetAttriVal("homeAdd", pis[0].getHome_add()));
		// retXML.append("<!-- 现住址邮编 -->");
		retXML.append(GetAttriVal("homePcode", pis[0].getHome_pcode()));
		// retXML.append("<!-- 单位 -->");
		retXML.append(GetAttriVal("company", pis[0].getCompany()));
		// retXML.append("<!-- 单位地址 -->");
		retXML.append(GetAttriVal("companyAdd", pis[0].getCompany_add()));
		// retXML.append("<!-- 单位住址邮编 -->");
		retXML.append(GetAttriVal("companyPcode", pis[0].getCompany_pcode()));
		// retXML.append("<!-- 联系人 -->");
		retXML.append(GetAttriVal("linkmanNm", pis[0].getLinkman_nm()));
		// retXML.append("<!-- 联系人关系 -->");
		retXML.append(GetAttriVal("linkmanRel", pis[0].getLinkman_rel()));
		// retXML.append("<!-- 联系人地址 -->");
		retXML.append(GetAttriVal("linkmanAddr", pis[0].getLinkman_addr()));
		// retXML.append("<!-- 联系电话 -->");
		retXML.append(GetAttriVal("linkmanTel", pis[0].getLinkman_tel()));
		// retXML.append("<!-- 户籍地址 -->");
		retXML.append(GetAttriVal("nativeplaceCode", pis[0].getNativeplace_code()));
		// retXML.append("<!-- 监护人姓名 -->");
		retXML.append(GetAttriVal("guardianNm", pis[0].getGuardian_nm()));
		// retXML.append("<!-- 监护人证件类型 -->");
		retXML.append(GetAttriVal("guardianIdtype", pis[0].getGuardian_idtype()));
		// retXML.append("<!-- 监护人证件号码 -->");
		retXML.append(GetAttriVal("guardianIdno", pis[0].getGuardian_idno()));
		return retXML.toString();
	}

	/**
	 * 诊断信息XML
	 * 
	 * @param billNos
	 * @param codePat
	 * @return
	 * @throws BizException
	 */

	private String GetEnDiagXML(EnDiag4CmlInsDTO[] Dtos) throws BizException {
		StringBuffer XmlStr = new StringBuffer();

		if (Dtos == null || Dtos.length == 0)
			return "";
		for (EnDiag4CmlInsDTO dto : Dtos) {
			XmlStr.append("<diagnosis>");
			XmlStr.append("<!--诊断编码-->");
			XmlStr.append(GetAttriVal("diagnosisId", dto.getDiagnosisid()));
			XmlStr.append("<!--诊断名称-->");
			// TODO没有响应字段
			XmlStr.append(GetAttriVal("diagnosisName",dto.getDiagnosisname()));
			XmlStr.append("<!--就诊号-->");
			XmlStr.append(GetAttriVal("visitNo", dto.getVisit_no()));
			XmlStr.append("<!--患者ID-->");
			XmlStr.append(GetAttriVal("pid", dto.getPid()));
			XmlStr.append("<!--诊断序号-->");
			XmlStr.append(GetAttriVal("diagSortno", dto.getDiag_sortno()));
			XmlStr.append("<!--诊断分类-->");
			XmlStr.append(GetAttriVal("diagCat", dto.getDiag_cat()));
			XmlStr.append("<!--诊断类型-->");
			XmlStr.append(GetAttriVal("diagType", dto.getDiag_type()));
			XmlStr.append("<!--诊断icd-->");
			XmlStr.append(GetAttriVal("diagCode", dto.getDiag_code()));
			XmlStr.append("<!--自定义code-->");
			XmlStr.append(GetAttriVal("customCode", dto.getCustom_code()));
			XmlStr.append("<!--诊断文本-->");
			XmlStr.append(GetAttriVal("valueStTxt", dto.getDiagnosisname()));
			XmlStr.append("<!--是否主诊断-->");
			XmlStr.append(GetAttriVal("ismain", dto.getIsmain()));
			XmlStr.append("<!--是否传染病-->");
			XmlStr.append(GetAttriVal("isinfectious", dto.getIsinfectious()));
			XmlStr.append("<!--是否慢性病-->");
			XmlStr.append(GetAttriVal("ischronic", dto.getIschronic()));
			XmlStr.append("<!--是否特种病-->");
			XmlStr.append(GetAttriVal("isspecial", dto.getIsspecial()));
			XmlStr.append("<!--诊断医生-->");
			XmlStr.append(GetAttriVal("doctorcode", dto.getDoctorcode()));
			XmlStr.append("<!--诊断医生姓名-->");
			XmlStr.append(GetAttriVal("doctorname", dto.getDoctorname()));
			XmlStr.append("<!--诊断时间-->");
			XmlStr.append(GetAttriVal("diagDate", dto.getDiag_date()));
			XmlStr.append("</diagnosis>");
		}

		return XmlStr.toString();

	}

	/**
	 * 1获取HIS结算与就诊信息关系表XML
	 * 
	 * @param billNos
	 * @return
	 * @throws BizException
	 */
	private String GetHisBlOrEnXML(HisBlOrEn4CmlInsDTO[] dTOs) throws BizException {
		StringBuffer retXML = new StringBuffer();

		if (dTOs == null || dTOs.length == 0)
			return "";

		for (HisBlOrEn4CmlInsDTO dTo : dTOs) {
			retXML.append("<jzjsxx>");
			// <!-- 就诊号 -->
			retXML.append(GetAttriVal("visitNo", dTo.getVisit_no()));
			// 患者ID
			retXML.append(GetAttriVal("pid", dTo.getPid()));
			// 患者名称
			retXML.append(GetAttriVal("patientname", dTo.getPatientname()));
			// HIS交易流水号
			retXML.append(GetAttriVal("histradeno", dTo.getHistradeno()));
			retXML.append("</jzjsxx>");
		}

		return retXML.toString();
	}

	/**
	 * 1获取HIS结算与就诊信息关系表
	 * 
	 * @param billNos
	 * @return
	 * @throws BizException
	 */
	private HisBlOrEn4CmlInsDTO[] GetHisBlOrEn(String[] billNos, String codePat) throws BizException {
		HisBlOrEn4CmlInsDTO[] dTOs = (HisBlOrEn4CmlInsDTO[]) AppFwUtil.getDORstWithDao(new GetHisBlSt4CmlInsDTOQry(billNos, codePat), HisBlOrEn4CmlInsDTO.class);
		return dTOs;
	}

	/**
	 * 2获取HIS结算信息表
	 * 
	 * @param billNos
	 * @return
	 * @throws BizException
	 */
	private HisBlSt4CmlInsDTO[] GetHisBlSt(String[] billNos, String codePat) throws BizException {
		HisBlSt4CmlInsDTO[] stdos = (HisBlSt4CmlInsDTO[]) AppFwUtil.getDORstWithDao(new GetHisBlOrEn4CmlInsDTOQry(billNos, codePat), HisBlSt4CmlInsDTO.class);

		return stdos;
	}

	/**
	 * 3获取结算账单信息表10
	 * 
	 * @param billNos
	 * @return
	 */
	private BlCc4CmlInsDTO[] GetBlCc(String[] billNos, String codePat) throws BizException {
		BlCc4CmlInsDTO[] dTOs = (BlCc4CmlInsDTO[]) AppFwUtil.getDORstWithDao(new GetBlCc4CmlInsDTOQry(billNos, codePat), BlCc4CmlInsDTO.class);
		return dTOs;
	}

	/**
	 * 4获取社商结算信息表 9
	 * 
	 * @param billNos
	 * @return
	 */
	private BusSt4CmlInsDTO[] GetBusSt(String[] billNos, String codePat) throws BizException {

		// return new BusSt4CmlInsDTO[0];
		// TODO 未实现
		BusSt4CmlInsDTO[] dTOs = (BusSt4CmlInsDTO[]) AppFwUtil.getDORstWithDao(new GetBusSt4CmlInsDTOQry(billNos, codePat), BusSt4CmlInsDTO.class);

		for (BusSt4CmlInsDTO busSt4CmlInsDTO : dTOs) {
			
			BlPropArOepDO[] blPropArOepDOs = (BlPropArOepDO[]) AppFwUtil.getDORstWithDao(new GetBlPropArOepDOQry(busSt4CmlInsDTO.getIncno(), codePat), BlPropArOepDO.class);

			if (blPropArOepDOs != null && blPropArOepDOs.length == 1) {
				BlPropArOepDO blPropArOepDO = blPropArOepDOs[0];
				String outXMl = blPropArOepDO.getOutputinfo();
				DivideResultByXmlBp bp = new DivideResultByXmlBp();
				DivideResultDTO resultDto = bp.exec(outXMl);
				// 把DivideResultDTO的值添加到BusSt4CmlInsDTO
				// TRADENO --保险交易流水号

				busSt4CmlInsDTO.setTradeno(resultDto.getTradeno());

				// PERSONALPAYAMOUNT --个人账户支付金额
				busSt4CmlInsDTO.setPersonalpayamount(new FDouble(GetCostString(resultDto.getPersoncountpay())));
				// REMAINAMOUNT --个人账户余额
				busSt4CmlInsDTO.setRemainamount(new FDouble(GetCostString(resultDto.getBalance())));

				// OPBIGPAYMOUNT --门诊大额支付金额
				busSt4CmlInsDTO.setOpbigpaymount(new FDouble(GetCostString(resultDto.getMzbigpay())));
				// OPSELFPAYAMOUNT --门诊大额自付金额（自付一）
				busSt4CmlInsDTO.setOpselfpayamount(new FDouble(GetCostString(resultDto.getMzbigselfpay())));
				// BIGSELFPAYAMOUNT --超大额自付金额
				busSt4CmlInsDTO.setBigselfpayamount(new FDouble(GetCostString(resultDto.getMzoutofbig())));
				// INSURANCEAMOUNT --医保内总金额
				busSt4CmlInsDTO.setInsuranceamount(new FDouble(GetCostString(resultDto.getMzfeein())));
				// OUTINSURANCEAMOUNT --医保外总金额
				busSt4CmlInsDTO.setOutinsuranceamount(new FDouble(GetCostString(resultDto.getMzfeeout())));
				// ADDINSURANCEPAYAYAMOUNT --补充保险支付金额
				busSt4CmlInsDTO.setAddinsurancepayayamount(new FDouble(GetCostString(resultDto.getBcpay())));
				// RESIDUALPAYAMOUNT --军残补助保险金额
				busSt4CmlInsDTO.setResidualpayamount(new FDouble(GetCostString(resultDto.getJcbz())));
				// SELFPAYAMOUNT2 --个人自付二
				busSt4CmlInsDTO.setSelfpayamount2(new FDouble(GetCostString(resultDto.getMzselfpay2())));
				// BEGINPAYAMOUNT --本次付起付线金额
				busSt4CmlInsDTO.setBeginpayamount(new FDouble(GetCostString(resultDto.getMzpayfirst())));
				// ISSINGLEILL --是否按照单病种结算
				// busSt4CmlInsDTO.setIssingleill(resultDto.get)
				// fundpayamount --基金支付金额
				busSt4CmlInsDTO.setFundpayamount(GetCostString(resultDto.getFund().toString()));
				// cashpayamount --个人支付金额
				 busSt4CmlInsDTO.setCashpayamount(GetCostString(resultDto.getCash()));

			}
			BusSt4CmlInsDTO[] busSt4CmlInsDTOs = (BusSt4CmlInsDTO[]) AppFwUtil.getDORstWithDao(new GetIncItem4CmlIncDTOQry(busSt4CmlInsDTO.getIncno(), codePat), BusSt4CmlInsDTO.class);
			if (busSt4CmlInsDTOs != null && busSt4CmlInsDTOs.length == 1) {
				BusSt4CmlInsDTO bussDto = busSt4CmlInsDTOs[0];
				// selfpay --自费
				busSt4CmlInsDTO.setSelfpay(GetCostString(bussDto.getSelfpay()));
				// hospitalbreaks --医院减免--
				busSt4CmlInsDTO.setHospitalbreaks(GetCostString(bussDto.getHospitalbreaks()));
				// xyao --西药
				busSt4CmlInsDTO.setXyao(GetCostString(bussDto.getXyao()));
				// zchyao --中成药
				busSt4CmlInsDTO.setZchyao(GetCostString(bussDto.getZchyao()));
				// zcyao --中草药
				busSt4CmlInsDTO.setZcyao(GetCostString(bussDto.getZcyao()));
				// examinecost --检查费
				busSt4CmlInsDTO.setExaminecost(GetCostString(bussDto.getExaminecost()));
				// radiate --放射
				busSt4CmlInsDTO.setRadiate(GetCostString(bussDto.getRadiate()));
				// bultrasonic --B超
				busSt4CmlInsDTO.setBultrasonic(GetCostString(bussDto.getBultrasonic()));
				// nmr --核磁
				busSt4CmlInsDTO.setNmr(GetCostString(bussDto.getNmr()));
				// testcost --治疗费
				busSt4CmlInsDTO.setTestcost(GetCostString(bussDto.getTestcost()));
				// materialscost --材料费
				busSt4CmlInsDTO.setMaterialscost(GetCostString(bussDto.getMaterialscost()));
				// operationcost --手术费
				busSt4CmlInsDTO.setOperationcost(GetCostString(bussDto.getOperationcost()));
				// oxygencost --输氧费
				busSt4CmlInsDTO.setOxygencost(GetCostString(bussDto.getOxygencost()));
				// bloodcost --输血费
				busSt4CmlInsDTO.setBloodcost(GetCostString(bussDto.getBloodcost()));
				// orthodonticcost --正畸费--
				busSt4CmlInsDTO.setOrthodonticcost(GetCostString(bussDto.getOrthodonticcost()));
				// inserttoothcost --镶牙费--
				busSt4CmlInsDTO.setInserttoothcost(GetCostString(bussDto.getInserttoothcost()));
				// sfjdcost --司法鉴定--
				busSt4CmlInsDTO.setSfjdcost(GetCostString(bussDto.getSfjdcost()));
				// othercost --其他项目
				busSt4CmlInsDTO.setOthercost(GetCostString(bussDto.getOthercost()));
				// diagnosticcost --诊察费--
				busSt4CmlInsDTO.setDiagnosticcost(GetCostString(bussDto.getDiagnosticcost()));
				// treatcost --化验费
				busSt4CmlInsDTO.setTreatcost(GetCostString(bussDto.getTreatcost()));
				// medicalservcost --医事服务费
				busSt4CmlInsDTO.setMedicalservcost(GetCostString(bussDto.getMedicalservcost()));
				// consultationcost --一般诊疗费
				busSt4CmlInsDTO.setConsultationcost(GetCostString(bussDto.getConsultationcost()));
				// registrationcost --挂号费
				busSt4CmlInsDTO.setRegistrationcost(GetCostString(bussDto.getRegistrationcost()));
				// othermzcost --其他门诊收费--
				busSt4CmlInsDTO.setOthermzcost(GetCostString(bussDto.getOthermzcost()));
			}
		}

		return dTOs;
	}

	/**
	 * 给费用默认值
	 */

	private String GetCostString(Object obj) {
		String costStr = new String();
		if (obj != null) {
			costStr = obj.toString();
		} else {
			costStr = "0";
		}

		return costStr;

	}

	/**
	 * 5获取医疗费用上传信息表3
	 * 
	 * @param billNos
	 * @return
	 */
	private MedUp4CmlInsDTO[] GetMedUp(String[] billNos, String codePat) throws BizException {

		MedUp4CmlInsDTO[] dTOs = (MedUp4CmlInsDTO[]) AppFwUtil.getDORstWithDao(new GetMedUp4CmlInsDTOQry(billNos, codePat), MedUp4CmlInsDTO.class);
		
		
		for (String incno : billNos) {
			
			BlPropArOepDO[] blPropArOepDOs = (BlPropArOepDO[]) AppFwUtil.getDORstWithDao(new GetBlPropArOepDOQry(incno, codePat), BlPropArOepDO.class);

			if (blPropArOepDOs != null && blPropArOepDOs.length == 1) {
				BlPropArOepDO blPropArOepDO = blPropArOepDOs[0];
				String outXMl = blPropArOepDO.getOutputinfo();
				DivideResultByXmlBp bp = new DivideResultByXmlBp();
				DivideResultDTO resultDto = bp.exec(outXMl);
				ArrayList<String> noInItemNo=new ArrayList<String>();
				for (MedUp4CmlInsDTO medUp4CmlInsDTO : dTOs) {
					if(incno.equals(medUp4CmlInsDTO.getIncno())){
						for (Object obj : resultDto.getFeebreaks()) {
							FeeBreakDTO feedto=(FeeBreakDTO)obj;
							if(feedto.getHisitemcode().equals(medUp4CmlInsDTO.getHiscode())&&noInItemNo.indexOf(feedto.getItemno())==-1){
								medUp4CmlInsDTO.setOrderno(feedto.getItemno());
								//赋值 将XML明细数据赋给DTO
								medUp4CmlInsDTO.setInsurance_amount(feedto.getFeein());
								medUp4CmlInsDTO.setOut_insurance_amount(feedto.getFeeout());
								medUp4CmlInsDTO.setPersonal_pay_two(feedto.getSelfpay2());
								medUp4CmlInsDTO.setAnalyze_stute(feedto.getState());
								medUp4CmlInsDTO.setItemtype(feedto.getItemtype());
								medUp4CmlInsDTO.setChargetype(feedto.getFee_type());
								medUp4CmlInsDTO.setYbitemcode(feedto.getItemcode());
								medUp4CmlInsDTO.setYbitemname(feedto.getItemname());
								medUp4CmlInsDTO.setPrice(feedto.getUnitprice());
								medUp4CmlInsDTO.setAmount(feedto.getCount());
								medUp4CmlInsDTO.setToatlamount(feedto.getFee());
								noInItemNo.add(feedto.getItemno());
							}
						}
					}
				}
			}
		}
		return dTOs;
	}

	/**
	 * 6 获取医疗费用明细信息表 4
	 * 
	 * @param billNos
	 * @return
	 */
	private CgOrItm4CmlInsDTO[] GetCgOrItm(String[] billNos, String codePat) throws BizException {
		CgOrItm4CmlInsDTO[] dTOs = (CgOrItm4CmlInsDTO[]) AppFwUtil.getDORstWithDao(new GetCgOrItm4CmlInsDTOQry(billNos, codePat), CgOrItm4CmlInsDTO.class);
		return dTOs;
	}

	/**
	 * 7 获取患者基本信息8
	 * 
	 * @param billNos
	 * @return
	 */
	private Pi4CmlInsDTO[] GetPi(String codePat) throws BizException {
		Pi4CmlInsDTO[] dTOs = (Pi4CmlInsDTO[]) AppFwUtil.getDORstWithDao(new GetPi4CmlInsDTOQry(codePat), Pi4CmlInsDTO.class);
		return dTOs;
	}

	/**
	 * 8获取 门诊处方信息表11
	 * 
	 * @param billNos
	 * @return
	 */
	private CiOr4CmlInsDTO[] GetCiOr(String[] billNos, String codePat) throws BizException {
		CiOr4CmlInsDTO[] dTOs = (CiOr4CmlInsDTO[]) AppFwUtil.getDORstWithDao(new GetCiOr4CmlInsDTOQry(billNos, codePat), CiOr4CmlInsDTO.class);
		return dTOs;
	}

	/**
	 * 9获取就诊信息表6
	 * 
	 * @param billNos
	 * @return
	 */
	private En4CmlInsDTO[] GetEn(String[] billNos, String codePat) throws BizException {
		En4CmlInsDTO[] dTOs = (En4CmlInsDTO[]) AppFwUtil.getDORstWithDao(new GetEn4CmlInsDTOQry(billNos, codePat), En4CmlInsDTO.class);
		return dTOs;
	}

	/**
	 * 10获取就诊信息扩展表5
	 * 
	 * @param billNos
	 * @return
	 */
	private EnExt4CmlInsDTO[] GetEnExt(String[] billNos, String codePat) throws BizException {
	
		EnExt4CmlInsDTO[] supplementDTOs = (EnExt4CmlInsDTO[]) AppFwUtil.getDORstWithDao(new GetSupplementEnExt4CmlInsDTOQry(billNos, codePat), EnExt4CmlInsDTO.class);
//		if(supplementDTOs==null||supplementDTOs.length==0){
//			EnExt4CmlInsDTO enExt4CmlInsDTO=new EnExt4CmlInsDTO();
//			enExt4CmlInsDTO.setPid();
//		}
		
		
		for (EnExt4CmlInsDTO enExt4CmlInsDTO : supplementDTOs) {
			//手术信息
			EnExt4CmlInsDTO[] dTOs = (EnExt4CmlInsDTO[]) AppFwUtil.getDORstWithDao(new GetEnExt4CmlInsDTOQry(enExt4CmlInsDTO.getIncno(), codePat), EnExt4CmlInsDTO.class);
			if (dTOs != null && dTOs.length == 1) {
				EnExt4CmlInsDTO dto = dTOs[0];

				//	bd_udidoc.name DOCTORLEVEL , --医师职称
				enExt4CmlInsDTO.setDoctorlevel(dto.getDoctorlevel());
				
//				--PRESCRIBEFLAG  --代开药标识
				enExt4CmlInsDTO.setPrescribeflag(dto.getPrescribeflag());
//				ci_ap_sug.id_srv_code OPERATIONCODE,  --手术编码
				enExt4CmlInsDTO.setOperationcode(dto.getOperationcode());
				
//				ci_order.name_or nOPERATION,  --手术名称
				enExt4CmlInsDTO.setOperation(dto.getOperation());
				
			//
//				ci_order.des_or REMARK,  --备注
				enExt4CmlInsDTO.setRemark(dto.getRemark());
//				ci_order.createdtime CREATEDATE,  --创建时间
				enExt4CmlInsDTO.setCreatedate(dto.getCreatedate());
//				ci_order.createdby CREATEUSERID , --创建人
				enExt4CmlInsDTO.setCreateuserid(dto.getCreateuserid());
//				ci_order.modifiedtime  UPDATEDATE,  --更新时间
				enExt4CmlInsDTO.setUpdatedate(dto.getUpdatedate());
//				 ci_order.modifiedby UPDATEUSERID,  --更新人
				enExt4CmlInsDTO.setUpdateuserid(dto.getUpdateuserid());
//				 ci_order.dt_effe OPERATIONDATE,  --手术时间
				enExt4CmlInsDTO.setOperationdate(dto.getOperationcode());
//				 ci_ap_sug_emp.id_emp OPERATIONDOCTOR,  --手术医师
				enExt4CmlInsDTO.setOperationdoctor(dto.getOperationdoctor());
//				 ci_ap_sug.sd_anestp ANAESTHESIATYPE,  --麻醉方式
				enExt4CmlInsDTO.setAnaesthesiatype(dto.getAnaesthesiatype());
//				 bd_udidoc2.name ANAESTHESIADOCTOR  --麻醉医师
				enExt4CmlInsDTO.setAnaesthesiadoctor(dto.getAnaesthesiadoctor());
//				--PROCESS  --手术过程 
				enExt4CmlInsDTO.setProcess(dto.getProcess());
				
			}

		}
		return supplementDTOs;
	}

	/**
	 * 11获取就诊诊断信息表7
	 * 
	 * @param billNos
	 * @return
	 */
	private EnDiag4CmlInsDTO[] GetEnDiag(String[] billNos, String codePat) throws BizException {
		EnDiag4CmlInsDTO[] dTOs = (EnDiag4CmlInsDTO[]) AppFwUtil.getDORstWithDao(new GetEnDiag4CmlInsDTOQry(billNos, codePat), EnDiag4CmlInsDTO.class);
		return dTOs;
	}
}
