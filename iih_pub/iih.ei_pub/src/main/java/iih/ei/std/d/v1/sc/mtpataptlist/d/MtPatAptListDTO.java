package iih.ei.std.d.v1.sc.mtpataptlist.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者医技预约记录 DTO数据 
 * 
 */
public class MtPatAptListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约Id
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	/**
	 * 预约Id
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 患者类型
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}	
	/**
	 * 患者类型
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	/**
	 * 科室编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 资源编码
	 * @return String
	 */
	public String getCode_res() {
		return ((String) getAttrVal("Code_res"));
	}	
	/**
	 * 资源编码
	 * @param Code_res
	 */
	public void setCode_res(String Code_res) {
		setAttrVal("Code_res", Code_res);
	}
	/**
	 * 资源名称
	 * @return String
	 */
	public String getName_res() {
		return ((String) getAttrVal("Name_res"));
	}	
	/**
	 * 资源名称
	 * @param Name_res
	 */
	public void setName_res(String Name_res) {
		setAttrVal("Name_res", Name_res);
	}
	/**
	 * 检查日期
	 * @return FDateTime
	 */
	public FDateTime getTime_ent() {
		return ((FDateTime) getAttrVal("Time_ent"));
	}	
	/**
	 * 检查日期
	 * @param Time_ent
	 */
	public void setTime_ent(FDateTime Time_ent) {
		setAttrVal("Time_ent", Time_ent);
	}
	/**
	 * 操作日期
	 * @return FDateTime
	 */
	public FDateTime getTime_opr() {
		return ((FDateTime) getAttrVal("Time_opr"));
	}	
	/**
	 * 操作日期
	 * @param Time_opr
	 */
	public void setTime_opr(FDateTime Time_opr) {
		setAttrVal("Time_opr", Time_opr);
	}
	/**
	 * 午别
	 * @return String
	 */
	public String getDayslottp() {
		return ((String) getAttrVal("Dayslottp"));
	}	
	/**
	 * 午别
	 * @param Dayslottp
	 */
	public void setDayslottp(String Dayslottp) {
		setAttrVal("Dayslottp", Dayslottp);
	}
	/**
	 * 顺序号
	 * @return String
	 */
	public String getSeqno() {
		return ((String) getAttrVal("Seqno"));
	}	
	/**
	 * 顺序号
	 * @param Seqno
	 */
	public void setSeqno(String Seqno) {
		setAttrVal("Seqno", Seqno);
	}
	/**
	 * 费用状态
	 * @return String
	 */
	public String getFee_status() {
		return ((String) getAttrVal("Fee_status"));
	}	
	/**
	 * 费用状态
	 * @param Fee_status
	 */
	public void setFee_status(String Fee_status) {
		setAttrVal("Fee_status", Fee_status);
	}
	/**
	 * 预约状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 预约状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 预约编号
	 * @return String
	 */
	public String getCode_apt() {
		return ((String) getAttrVal("Code_apt"));
	}	
	/**
	 * 预约编号
	 * @param Code_apt
	 */
	public void setCode_apt(String Code_apt) {
		setAttrVal("Code_apt", Code_apt);
	}
	/**
	 * 检查地址
	 * @return String
	 */
	public String getAddress() {
		return ((String) getAttrVal("Address"));
	}	
	/**
	 * 检查地址
	 * @param Address
	 */
	public void setAddress(String Address) {
		setAttrVal("Address", Address);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getMobile() {
		return ((String) getAttrVal("Mobile"));
	}	
	/**
	 * 电话
	 * @param Mobile
	 */
	public void setMobile(String Mobile) {
		setAttrVal("Mobile", Mobile);
	}
	/**
	 * 预约渠道名称
	 * @return String
	 */
	public String getName_chl_type() {
		return ((String) getAttrVal("Name_chl_type"));
	}	
	/**
	 * 预约渠道名称
	 * @param Name_chl_type
	 */
	public void setName_chl_type(String Name_chl_type) {
		setAttrVal("Name_chl_type", Name_chl_type);
	}
	/**
	 * 预约渠道编码
	 * @return String
	 */
	public String getCode_chl_type() {
		return ((String) getAttrVal("Code_chl_type"));
	}	
	/**
	 * 预约渠道编码
	 * @param Code_chl_type
	 */
	public void setCode_chl_type(String Code_chl_type) {
		setAttrVal("Code_chl_type", Code_chl_type);
	}
}