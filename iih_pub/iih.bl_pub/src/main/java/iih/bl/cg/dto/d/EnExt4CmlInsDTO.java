package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 就诊信息扩展表 DTO数据 
 * 
 */
public class EnExt4CmlInsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPid() {
		return ((String) getAttrVal("Pid"));
	}
	/**
	 * 患者ID
	 * @param Pid
	 */
	public void setPid(String Pid) {
		setAttrVal("Pid", Pid);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getVisit_no() {
		return ((String) getAttrVal("Visit_no"));
	}
	/**
	 * 就诊号
	 * @param Visit_no
	 */
	public void setVisit_no(String Visit_no) {
		setAttrVal("Visit_no", Visit_no);
	}
	/**
	 * 病历信息
	 * @return String
	 */
	public String getIllnesshistory() {
		return ((String) getAttrVal("Illnesshistory"));
	}
	/**
	 * 病历信息
	 * @param Illnesshistory
	 */
	public void setIllnesshistory(String Illnesshistory) {
		setAttrVal("Illnesshistory", Illnesshistory);
	}
	/**
	 * 医师职称
	 * @return String
	 */
	public String getDoctorlevel() {
		return ((String) getAttrVal("Doctorlevel"));
	}
	/**
	 * 医师职称
	 * @param Doctorlevel
	 */
	public void setDoctorlevel(String Doctorlevel) {
		setAttrVal("Doctorlevel", Doctorlevel);
	}
	/**
	 * 代开药标识
	 * @return String
	 */
	public String getPrescribeflag() {
		return ((String) getAttrVal("Prescribeflag"));
	}
	/**
	 * 代开药标识
	 * @param Prescribeflag
	 */
	public void setPrescribeflag(String Prescribeflag) {
		setAttrVal("Prescribeflag", Prescribeflag);
	}
	/**
	 * 手术编码
	 * @return String
	 */
	public String getOperationcode() {
		return ((String) getAttrVal("Operationcode"));
	}
	/**
	 * 手术编码
	 * @param Operationcode
	 */
	public void setOperationcode(String Operationcode) {
		setAttrVal("Operationcode", Operationcode);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getOperation() {
		return ((String) getAttrVal("Operation"));
	}
	/**
	 * 手术名称
	 * @param Operation
	 */
	public void setOperation(String Operation) {
		setAttrVal("Operation", Operation);
	}
	/**
	 * 更新标识
	 * @return String
	 */
	public String getUpflag() {
		return ((String) getAttrVal("Upflag"));
	}
	/**
	 * 更新标识
	 * @param Upflag
	 */
	public void setUpflag(String Upflag) {
		setAttrVal("Upflag", Upflag);
	}
	/**
	 * 既往史
	 * @return String
	 */
	public String getHistory() {
		return ((String) getAttrVal("History"));
	}
	/**
	 * 既往史
	 * @param History
	 */
	public void setHistory(String History) {
		setAttrVal("History", History);
	}
	/**
	 * 主诉
	 * @return String
	 */
	public String getZhushu() {
		return ((String) getAttrVal("Zhushu"));
	}
	/**
	 * 主诉
	 * @param Zhushu
	 */
	public void setZhushu(String Zhushu) {
		setAttrVal("Zhushu", Zhushu);
	}
	/**
	 * 单据类型
	 * @return String
	 */
	public String getInvoicetyepe() {
		return ((String) getAttrVal("Invoicetyepe"));
	}
	/**
	 * 单据类型
	 * @param Invoicetyepe
	 */
	public void setInvoicetyepe(String Invoicetyepe) {
		setAttrVal("Invoicetyepe", Invoicetyepe);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}
	/**
	 * 备注
	 * @param Remark
	 */
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	/**
	 * 创建时间
	 * @return String
	 */
	public String getCreatedate() {
		return ((String) getAttrVal("Createdate"));
	}
	/**
	 * 创建时间
	 * @param Createdate
	 */
	public void setCreatedate(String Createdate) {
		setAttrVal("Createdate", Createdate);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreateuserid() {
		return ((String) getAttrVal("Createuserid"));
	}
	/**
	 * 创建人
	 * @param Createuserid
	 */
	public void setCreateuserid(String Createuserid) {
		setAttrVal("Createuserid", Createuserid);
	}
	/**
	 * 更新时间
	 * @return String
	 */
	public String getUpdatedate() {
		return ((String) getAttrVal("Updatedate"));
	}
	/**
	 * 更新时间
	 * @param Updatedate
	 */
	public void setUpdatedate(String Updatedate) {
		setAttrVal("Updatedate", Updatedate);
	}
	/**
	 * 更新人
	 * @return String
	 */
	public String getUpdateuserid() {
		return ((String) getAttrVal("Updateuserid"));
	}
	/**
	 * 更新人
	 * @param Updateuserid
	 */
	public void setUpdateuserid(String Updateuserid) {
		setAttrVal("Updateuserid", Updateuserid);
	}
	/**
	 * 手术时间
	 * @return String
	 */
	public String getOperationdate() {
		return ((String) getAttrVal("Operationdate"));
	}
	/**
	 * 手术时间
	 * @param Operationdate
	 */
	public void setOperationdate(String Operationdate) {
		setAttrVal("Operationdate", Operationdate);
	}
	/**
	 * 手术医师
	 * @return String
	 */
	public String getOperationdoctor() {
		return ((String) getAttrVal("Operationdoctor"));
	}
	/**
	 * 手术医师
	 * @param Operationdoctor
	 */
	public void setOperationdoctor(String Operationdoctor) {
		setAttrVal("Operationdoctor", Operationdoctor);
	}
	/**
	 * 麻醉方式
	 * @return String
	 */
	public String getAnaesthesiatype() {
		return ((String) getAttrVal("Anaesthesiatype"));
	}
	/**
	 * 麻醉方式
	 * @param Anaesthesiatype
	 */
	public void setAnaesthesiatype(String Anaesthesiatype) {
		setAttrVal("Anaesthesiatype", Anaesthesiatype);
	}
	/**
	 * 麻醉医师
	 * @return String
	 */
	public String getAnaesthesiadoctor() {
		return ((String) getAttrVal("Anaesthesiadoctor"));
	}
	/**
	 * 麻醉医师
	 * @param Anaesthesiadoctor
	 */
	public void setAnaesthesiadoctor(String Anaesthesiadoctor) {
		setAttrVal("Anaesthesiadoctor", Anaesthesiadoctor);
	}
	/**
	 * 手术过程
	 * @return String
	 */
	public String getProcess() {
		return ((String) getAttrVal("Process"));
	}
	/**
	 * 手术过程
	 * @param Process
	 */
	public void setProcess(String Process) {
		setAttrVal("Process", Process);
	}
	/**
	 * 现病史
	 * @return String
	 */
	public String getPresenthistory() {
		return ((String) getAttrVal("Presenthistory"));
	}
	/**
	 * 现病史
	 * @param Presenthistory
	 */
	public void setPresenthistory(String Presenthistory) {
		setAttrVal("Presenthistory", Presenthistory);
	}
	/**
	 * 家族史（遗传病）
	 * @return String
	 */
	public String getGeneticdisease() {
		return ((String) getAttrVal("Geneticdisease"));
	}
	/**
	 * 家族史（遗传病）
	 * @param Geneticdisease
	 */
	public void setGeneticdisease(String Geneticdisease) {
		setAttrVal("Geneticdisease", Geneticdisease);
	}
	/**
	 * 体格检查
	 * @return String
	 */
	public String getExamination() {
		return ((String) getAttrVal("Examination"));
	}
	/**
	 * 体格检查
	 * @param Examination
	 */
	public void setExamination(String Examination) {
		setAttrVal("Examination", Examination);
	}
	/**
	 * 患者就诊扩展ID
	 * @return String
	 */
	public String getPatient_encounter_extsion_id() {
		return ((String) getAttrVal("Patient_encounter_extsion_id"));
	}
	/**
	 * 患者就诊扩展ID
	 * @param Patient_encounter_extsion_id
	 */
	public void setPatient_encounter_extsion_id(String Patient_encounter_extsion_id) {
		setAttrVal("Patient_encounter_extsion_id", Patient_encounter_extsion_id);
	}
	/**
	 * 患者就诊ID
	 * @return String
	 */
	public String getPatientencounterid() {
		return ((String) getAttrVal("Patientencounterid"));
	}
	/**
	 * 患者就诊ID
	 * @param Patientencounterid
	 */
	public void setPatientencounterid(String Patientencounterid) {
		setAttrVal("Patientencounterid", Patientencounterid);
	}
	/**
	 * 发票号
	 * @return String
	 */
	public String getIncno() {
		return ((String) getAttrVal("Incno"));
	}
	/**
	 * 发票号
	 * @param Incno
	 */
	public void setIncno(String Incno) {
		setAttrVal("Incno", Incno);
	}
}