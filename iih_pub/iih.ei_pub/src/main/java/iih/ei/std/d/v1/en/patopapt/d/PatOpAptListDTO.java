package iih.ei.std.d.v1.en.patopapt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者预约记录 DTO数据 
 * 
 */
public class PatOpAptListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约id
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	/**
	 * 预约id
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 外部预约码
	 * @return String
	 */
	public String getCode_exapt() {
		return ((String) getAttrVal("Code_exapt"));
	}	
	/**
	 * 外部预约码
	 * @param Code_exapt
	 */
	public void setCode_exapt(String Code_exapt) {
		setAttrVal("Code_exapt", Code_exapt);
	}
	/**
	 * 预约编码
	 * @return String
	 */
	public String getCode_apt() {
		return ((String) getAttrVal("Code_apt"));
	}	
	/**
	 * 预约编码
	 * @param Code_apt
	 */
	public void setCode_apt(String Code_apt) {
		setAttrVal("Code_apt", Code_apt);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}	
	/**
	 * 就诊类型名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 患者分类编码
	 * @return String
	 */
	public String getCode_patca() {
		return ((String) getAttrVal("Code_patca"));
	}	
	/**
	 * 患者分类编码
	 * @param Code_patca
	 */
	public void setCode_patca(String Code_patca) {
		setAttrVal("Code_patca", Code_patca);
	}
	/**
	 * 患者分类名称
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}	
	/**
	 * 患者分类名称
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 号别编码
	 * @return String
	 */
	public String getCode_srvtp() {
		return ((String) getAttrVal("Code_srvtp"));
	}	
	/**
	 * 号别编码
	 * @param Code_srvtp
	 */
	public void setCode_srvtp(String Code_srvtp) {
		setAttrVal("Code_srvtp", Code_srvtp);
	}
	/**
	 * 号别名称
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	/**
	 * 号别名称
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
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
	 * 服务编码
	 * @return String
	 */
	public String getCode_scsrv() {
		return ((String) getAttrVal("Code_scsrv"));
	}	
	/**
	 * 服务编码
	 * @param Code_scsrv
	 */
	public void setCode_scsrv(String Code_scsrv) {
		setAttrVal("Code_scsrv", Code_scsrv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}	
	/**
	 * 服务名称
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
	/**
	 * 午别类型编码
	 * @return String
	 */
	public String getCode_dayslottp() {
		return ((String) getAttrVal("Code_dayslottp"));
	}	
	/**
	 * 午别类型编码
	 * @param Code_dayslottp
	 */
	public void setCode_dayslottp(String Code_dayslottp) {
		setAttrVal("Code_dayslottp", Code_dayslottp);
	}
	/**
	 * 午别类型名称
	 * @return String
	 */
	public String getName_dayslottp() {
		return ((String) getAttrVal("Name_dayslottp"));
	}	
	/**
	 * 午别类型名称
	 * @param Name_dayslottp
	 */
	public void setName_dayslottp(String Name_dayslottp) {
		setAttrVal("Name_dayslottp", Name_dayslottp);
	}
	/**
	 * 就诊日期
	 * @return FDate
	 */
	public FDate getDt_entry() {
		return ((FDate) getAttrVal("Dt_entry"));
	}	
	/**
	 * 就诊日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDate Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 预约操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_apt() {
		return ((FDateTime) getAttrVal("Dt_apt"));
	}	
	/**
	 * 预约操作时间
	 * @param Dt_apt
	 */
	public void setDt_apt(FDateTime Dt_apt) {
		setAttrVal("Dt_apt", Dt_apt);
	}
	/**
	 * 挂号顺序号
	 * @return String
	 */
	public String getCode_ticket() {
		return ((String) getAttrVal("Code_ticket"));
	}	
	/**
	 * 挂号顺序号
	 * @param Code_ticket
	 */
	public void setCode_ticket(String Code_ticket) {
		setAttrVal("Code_ticket", Code_ticket);
	}
	/**
	 * 支付订单号
	 * @return String
	 */
	public String getPaymode_no() {
		return ((String) getAttrVal("Paymode_no"));
	}	
	/**
	 * 支付订单号
	 * @param Paymode_no
	 */
	public void setPaymode_no(String Paymode_no) {
		setAttrVal("Paymode_no", Paymode_no);
	}
	/**
	 * 支付账号
	 * @return String
	 */
	public String getBank_no() {
		return ((String) getAttrVal("Bank_no"));
	}	
	/**
	 * 支付账号
	 * @param Bank_no
	 */
	public void setBank_no(String Bank_no) {
		setAttrVal("Bank_no", Bank_no);
	}
	/**
	 * 支付方式编码
	 * @return String
	 */
	public String getCode_pm() {
		return ((String) getAttrVal("Code_pm"));
	}	
	/**
	 * 支付方式编码
	 * @param Code_pm
	 */
	public void setCode_pm(String Code_pm) {
		setAttrVal("Code_pm", Code_pm);
	}
	/**
	 * 支付方式名称
	 * @return String
	 */
	public String getName_pm() {
		return ((String) getAttrVal("Name_pm"));
	}	
	/**
	 * 支付方式名称
	 * @param Name_pm
	 */
	public void setName_pm(String Name_pm) {
		setAttrVal("Name_pm", Name_pm);
	}
	/**
	 * 门诊就诊次数
	 * @return String
	 */
	public String getTimes_op() {
		return ((String) getAttrVal("Times_op"));
	}	
	/**
	 * 门诊就诊次数
	 * @param Times_op
	 */
	public void setTimes_op(String Times_op) {
		setAttrVal("Times_op", Times_op);
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
	public String getCode_aptstatus() {
		return ((String) getAttrVal("Code_aptstatus"));
	}	
	/**
	 * 预约状态
	 * @param Code_aptstatus
	 */
	public void setCode_aptstatus(String Code_aptstatus) {
		setAttrVal("Code_aptstatus", Code_aptstatus);
	}
	/**
	 * 就诊地址
	 * @return String
	 */
	public String getAddress_ent() {
		return ((String) getAttrVal("Address_ent"));
	}	
	/**
	 * 就诊地址
	 * @param Address_ent
	 */
	public void setAddress_ent(String Address_ent) {
		setAttrVal("Address_ent", Address_ent);
	}
	/**
	 * 患者支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}	
	/**
	 * 患者支付金额
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 总费用
	 * @return FDouble
	 */
	public FDouble getAmt_total() {
		return ((FDouble) getAttrVal("Amt_total"));
	}	
	/**
	 * 总费用
	 * @param Amt_total
	 */
	public void setAmt_total(FDouble Amt_total) {
		setAttrVal("Amt_total", Amt_total);
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
	 * 渠道类型编码
	 * @return String
	 */
	public String getCode_chltp() {
		return ((String) getAttrVal("Code_chltp"));
	}	
	/**
	 * 渠道类型编码
	 * @param Code_chltp
	 */
	public void setCode_chltp(String Code_chltp) {
		setAttrVal("Code_chltp", Code_chltp);
	}
	/**
	 * 渠道类型名称
	 * @return String
	 */
	public String getName_chltp() {
		return ((String) getAttrVal("Name_chltp"));
	}	
	/**
	 * 渠道类型名称
	 * @param Name_chltp
	 */
	public void setName_chltp(String Name_chltp) {
		setAttrVal("Name_chltp", Name_chltp);
	}
	/**
	 * 号位开始时间
	 * @return String
	 */
	public String getT_b_ticket() {
		return ((String) getAttrVal("T_b_ticket"));
	}	
	/**
	 * 号位开始时间
	 * @param T_b_ticket
	 */
	public void setT_b_ticket(String T_b_ticket) {
		setAttrVal("T_b_ticket", T_b_ticket);
	}
	/**
	 * 号位结束时间
	 * @return String
	 */
	public String getT_e_ticket() {
		return ((String) getAttrVal("T_e_ticket"));
	}	
	/**
	 * 号位结束时间
	 * @param T_e_ticket
	 */
	public void setT_e_ticket(String T_e_ticket) {
		setAttrVal("T_e_ticket", T_e_ticket);
	}
}