package iih.mp.nr.api.pathgy.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 千屏病理DTO DTO数据 
 * 
 */
public class PayhgyInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 申请单号
	 * @return String
	 */
	public String getExam_no() {
		return ((String) getAttrVal("Exam_no"));
	}
	/**
	 * 申请单号
	 * @param Exam_no
	 */
	public void setExam_no(String Exam_no) {
		setAttrVal("Exam_no", Exam_no);
	}
	/**
	 * displaynam2
	 * @return String
	 */
	public String getPatient_id() {
		return ((String) getAttrVal("Patient_id"));
	}
	/**
	 * displaynam2
	 * @param Patient_id
	 */
	public void setPatient_id(String Patient_id) {
		setAttrVal("Patient_id", Patient_id);
	}
	/**
	 * displaynam3
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * displaynam3
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * displaynam4
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * displaynam4
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * displaynam5
	 * @return String
	 */
	public String getNl() {
		return ((String) getAttrVal("Nl"));
	}
	/**
	 * displaynam5
	 * @param Nl
	 */
	public void setNl(String Nl) {
		setAttrVal("Nl", Nl);
	}
	/**
	 * displaynam6
	 * @return String
	 */
	public String getNation() {
		return ((String) getAttrVal("Nation"));
	}
	/**
	 * displaynam6
	 * @param Nation
	 */
	public void setNation(String Nation) {
		setAttrVal("Nation", Nation);
	}
	/**
	 * displaynam7
	 * @return String
	 */
	public String getMarital_status() {
		return ((String) getAttrVal("Marital_status"));
	}
	/**
	 * displaynam7
	 * @param Marital_status
	 */
	public void setMarital_status(String Marital_status) {
		setAttrVal("Marital_status", Marital_status);
	}
	/**
	 * displaynam8
	 * @return String
	 */
	public String getOccupation_name() {
		return ((String) getAttrVal("Occupation_name"));
	}
	/**
	 * displaynam8
	 * @param Occupation_name
	 */
	public void setOccupation_name(String Occupation_name) {
		setAttrVal("Occupation_name", Occupation_name);
	}
	/**
	 * displaynam9
	 * @return String
	 */
	public String getArea_name() {
		return ((String) getAttrVal("Area_name"));
	}
	/**
	 * displaynam9
	 * @param Area_name
	 */
	public void setArea_name(String Area_name) {
		setAttrVal("Area_name", Area_name);
	}
	/**
	 * displaynam10
	 * @return String
	 */
	public String getId_no() {
		return ((String) getAttrVal("Id_no"));
	}
	/**
	 * displaynam10
	 * @param Id_no
	 */
	public void setId_no(String Id_no) {
		setAttrVal("Id_no", Id_no);
	}
	/**
	 * displaynam11
	 * @return String
	 */
	public String getMailing_address() {
		return ((String) getAttrVal("Mailing_address"));
	}
	/**
	 * displaynam11
	 * @param Mailing_address
	 */
	public void setMailing_address(String Mailing_address) {
		setAttrVal("Mailing_address", Mailing_address);
	}
	/**
	 * displaynam12
	 * @return String
	 */
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}
	/**
	 * displaynam12
	 * @param Dept_name
	 */
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	/**
	 * displaynam13
	 * @return String
	 */
	public String getReq_physician() {
		return ((String) getAttrVal("Req_physician"));
	}
	/**
	 * displaynam13
	 * @param Req_physician
	 */
	public void setReq_physician(String Req_physician) {
		setAttrVal("Req_physician", Req_physician);
	}
	/**
	 * displaynam14
	 * @return String
	 */
	public String getReq_date_time() {
		return ((String) getAttrVal("Req_date_time"));
	}
	/**
	 * displaynam14
	 * @param Req_date_time
	 */
	public void setReq_date_time(String Req_date_time) {
		setAttrVal("Req_date_time", Req_date_time);
	}
	/**
	 * displaynam15
	 * @return String
	 */
	public String getBblx() {
		return ((String) getAttrVal("Bblx"));
	}
	/**
	 * displaynam15
	 * @param Bblx
	 */
	public void setBblx(String Bblx) {
		setAttrVal("Bblx", Bblx);
	}
	/**
	 * displaynam16
	 * @return String
	 */
	public String getMzh() {
		return ((String) getAttrVal("Mzh"));
	}
	/**
	 * displaynam16
	 * @param Mzh
	 */
	public void setMzh(String Mzh) {
		setAttrVal("Mzh", Mzh);
	}
	/**
	 * displaynam17
	 * @return String
	 */
	public String getInp_no() {
		return ((String) getAttrVal("Inp_no"));
	}
	/**
	 * displaynam17
	 * @param Inp_no
	 */
	public void setInp_no(String Inp_no) {
		setAttrVal("Inp_no", Inp_no);
	}
	/**
	 * displaynam18
	 * @return String
	 */
	public String getWard_name() {
		return ((String) getAttrVal("Ward_name"));
	}
	/**
	 * displaynam18
	 * @param Ward_name
	 */
	public void setWard_name(String Ward_name) {
		setAttrVal("Ward_name", Ward_name);
	}
	/**
	 * displaynam19
	 * @return String
	 */
	public String getBed_no() {
		return ((String) getAttrVal("Bed_no"));
	}
	/**
	 * displaynam19
	 * @param Bed_no
	 */
	public void setBed_no(String Bed_no) {
		setAttrVal("Bed_no", Bed_no);
	}
	/**
	 * displaynam20
	 * @return String
	 */
	public String getFb() {
		return ((String) getAttrVal("Fb"));
	}
	/**
	 * displaynam20
	 * @param Fb
	 */
	public void setFb(String Fb) {
		setAttrVal("Fb", Fb);
	}
	/**
	 * displaynam21
	 * @return String
	 */
	public String getClin_diag() {
		return ((String) getAttrVal("Clin_diag"));
	}
	/**
	 * displaynam21
	 * @param Clin_diag
	 */
	public void setClin_diag(String Clin_diag) {
		setAttrVal("Clin_diag", Clin_diag);
	}
	/**
	 * displaynam22
	 * @return String
	 */
	public String getPhys_sign() {
		return ((String) getAttrVal("Phys_sign"));
	}
	/**
	 * displaynam22
	 * @param Phys_sign
	 */
	public void setPhys_sign(String Phys_sign) {
		setAttrVal("Phys_sign", Phys_sign);
	}
	/**
	 * displaynam23
	 * @return String
	 */
	public String getZlxx() {
		return ((String) getAttrVal("Zlxx"));
	}
	/**
	 * displaynam23
	 * @param Zlxx
	 */
	public void setZlxx(String Zlxx) {
		setAttrVal("Zlxx", Zlxx);
	}
	/**
	 * displaynam25
	 * @return String
	 */
	public String getFkxx() {
		return ((String) getAttrVal("Fkxx"));
	}
	/**
	 * displaynam25
	 * @param Fkxx
	 */
	public void setFkxx(String Fkxx) {
		setAttrVal("Fkxx", Fkxx);
	}
	/**
	 * 标本名称
	 * @return String
	 */
	public String getBbmc() {
		return ((String) getAttrVal("Bbmc"));
	}
	/**
	 * 标本名称
	 * @param Bbmc
	 */
	public void setBbmc(String Bbmc) {
		setAttrVal("Bbmc", Bbmc);
	}
}