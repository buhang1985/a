package iih.bl.hp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 上传医院审批信息 DTO数据 
 * 
 */
public class ApprovalInfoUpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 个人编号
	 * @return String
	 */
	public String getPsncode() {
		return ((String) getAttrVal("Psncode"));
	}
	/**
	 * 个人编号
	 * @param Psncode
	 */
	public void setPsncode(String Psncode) {
		setAttrVal("Psncode", Psncode);
	}
	/**
	 * 审批类别
	 * @return String
	 */
	public String getApprovalca() {
		return ((String) getAttrVal("Approvalca"));
	}
	/**
	 * 审批类别
	 * @param Approvalca
	 */
	public void setApprovalca(String Approvalca) {
		setAttrVal("Approvalca", Approvalca);
	}
	/**
	 * 住院流水号
	 * @return String
	 */
	public String getIpserialno() {
		return ((String) getAttrVal("Ipserialno"));
	}
	/**
	 * 住院流水号
	 * @param Ipserialno
	 */
	public void setIpserialno(String Ipserialno) {
		setAttrVal("Ipserialno", Ipserialno);
	}
	/**
	 * 转外就诊医院
	 * @return String
	 */
	public String getTurnouthospital() {
		return ((String) getAttrVal("Turnouthospital"));
	}
	/**
	 * 转外就诊医院
	 * @param Turnouthospital
	 */
	public void setTurnouthospital(String Turnouthospital) {
		setAttrVal("Turnouthospital", Turnouthospital);
	}
	/**
	 * 医院等级
	 * @return String
	 */
	public String getHospitalgrade() {
		return ((String) getAttrVal("Hospitalgrade"));
	}
	/**
	 * 医院等级
	 * @param Hospitalgrade
	 */
	public void setHospitalgrade(String Hospitalgrade) {
		setAttrVal("Hospitalgrade", Hospitalgrade);
	}
	/**
	 * 病种编码
	 * @return String
	 */
	public String getDiseasecode() {
		return ((String) getAttrVal("Diseasecode"));
	}
	/**
	 * 病种编码
	 * @param Diseasecode
	 */
	public void setDiseasecode(String Diseasecode) {
		setAttrVal("Diseasecode", Diseasecode);
	}
	/**
	 * 病种名称
	 * @return String
	 */
	public String getDiseasename() {
		return ((String) getAttrVal("Diseasename"));
	}
	/**
	 * 病种名称
	 * @param Diseasename
	 */
	public void setDiseasename(String Diseasename) {
		setAttrVal("Diseasename", Diseasename);
	}
	/**
	 * 医院意见
	 * @return String
	 */
	public String getOpinions() {
		return ((String) getAttrVal("Opinions"));
	}
	/**
	 * 医院意见
	 * @param Opinions
	 */
	public void setOpinions(String Opinions) {
		setAttrVal("Opinions", Opinions);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getSrvcode() {
		return ((String) getAttrVal("Srvcode"));
	}
	/**
	 * 项目编码
	 * @param Srvcode
	 */
	public void setSrvcode(String Srvcode) {
		setAttrVal("Srvcode", Srvcode);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getSrvname() {
		return ((String) getAttrVal("Srvname"));
	}
	/**
	 * 项目名称
	 * @param Srvname
	 */
	public void setSrvname(String Srvname) {
		setAttrVal("Srvname", Srvname);
	}
	/**
	 * 审批数量
	 * @return String
	 */
	public String getApprovalquan() {
		return ((String) getAttrVal("Approvalquan"));
	}
	/**
	 * 审批数量
	 * @param Approvalquan
	 */
	public void setApprovalquan(String Approvalquan) {
		setAttrVal("Approvalquan", Approvalquan);
	}
	/**
	 * 医院审批日期
	 * @return String
	 */
	public String getApprovaldate() {
		return ((String) getAttrVal("Approvaldate"));
	}
	/**
	 * 医院审批日期
	 * @param Approvaldate
	 */
	public void setApprovaldate(String Approvaldate) {
		setAttrVal("Approvaldate", Approvaldate);
	}
	/**
	 * 审批标志
	 * @return String
	 */
	public String getApprovalflag() {
		return ((String) getAttrVal("Approvalflag"));
	}
	/**
	 * 审批标志
	 * @param Approvalflag
	 */
	public void setApprovalflag(String Approvalflag) {
		setAttrVal("Approvalflag", Approvalflag);
	}
	/**
	 * 开始时间
	 * @return String
	 */
	public String getStarttime() {
		return ((String) getAttrVal("Starttime"));
	}
	/**
	 * 开始时间
	 * @param Starttime
	 */
	public void setStarttime(String Starttime) {
		setAttrVal("Starttime", Starttime);
	}
	/**
	 * 终止时间
	 * @return String
	 */
	public String getEndtime() {
		return ((String) getAttrVal("Endtime"));
	}
	/**
	 * 终止时间
	 * @param Endtime
	 */
	public void setEndtime(String Endtime) {
		setAttrVal("Endtime", Endtime);
	}
	/**
	 * 经办人
	 * @return String
	 */
	public String getOpera() {
		return ((String) getAttrVal("Opera"));
	}
	/**
	 * 经办人
	 * @param Opera
	 */
	public void setOpera(String Opera) {
		setAttrVal("Opera", Opera);
	}
	/**
	 * 转外类别
	 * @return String
	 */
	public String getTurnoutca() {
		return ((String) getAttrVal("Turnoutca"));
	}
	/**
	 * 转外类别
	 * @param Turnoutca
	 */
	public void setTurnoutca(String Turnoutca) {
		setAttrVal("Turnoutca", Turnoutca);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 妊娠时间
	 * @return String
	 */
	public String getGestationtime() {
		return ((String) getAttrVal("Gestationtime"));
	}
	/**
	 * 妊娠时间
	 * @param Gestationtime
	 */
	public void setGestationtime(String Gestationtime) {
		setAttrVal("Gestationtime", Gestationtime);
	}
	/**
	 * 预产期
	 * @return String
	 */
	public String getDuedate() {
		return ((String) getAttrVal("Duedate"));
	}
	/**
	 * 预产期
	 * @param Duedate
	 */
	public void setDuedate(String Duedate) {
		setAttrVal("Duedate", Duedate);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getPhone() {
		return ((String) getAttrVal("Phone"));
	}
	/**
	 * 联系电话
	 * @param Phone
	 */
	public void setPhone(String Phone) {
		setAttrVal("Phone", Phone);
	}
	/**
	 * 生殖服务证号
	 * @return String
	 */
	public String getBirthsrvno() {
		return ((String) getAttrVal("Birthsrvno"));
	}
	/**
	 * 生殖服务证号
	 * @param Birthsrvno
	 */
	public void setBirthsrvno(String Birthsrvno) {
		setAttrVal("Birthsrvno", Birthsrvno);
	}
	/**
	 * 工伤发生时间
	 * @return String
	 */
	public String getInjurydatetime() {
		return ((String) getAttrVal("Injurydatetime"));
	}
	/**
	 * 工伤发生时间
	 * @param Injurydatetime
	 */
	public void setInjurydatetime(String Injurydatetime) {
		setAttrVal("Injurydatetime", Injurydatetime);
	}
	/**
	 * 是否二胎标志
	 * @return String
	 */
	public String getSecondchildflag() {
		return ((String) getAttrVal("Secondchildflag"));
	}
	/**
	 * 是否二胎标志
	 * @param Secondchildflag
	 */
	public void setSecondchildflag(String Secondchildflag) {
		setAttrVal("Secondchildflag", Secondchildflag);
	}
}