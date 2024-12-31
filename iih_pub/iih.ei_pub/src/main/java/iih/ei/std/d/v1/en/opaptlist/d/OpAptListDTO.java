package iih.ei.std.d.v1.en.opaptlist.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊预约记录 DTO数据 
 * 
 */
public class OpAptListDTO extends BaseDTO {
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
	 * 手机号
	 * @return String
	 */
	public String getMobile() {
		return ((String) getAttrVal("Mobile"));
	}	
	/**
	 * 手机号
	 * @param Mobile
	 */
	public void setMobile(String Mobile) {
		setAttrVal("Mobile", Mobile);
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
	 * 就诊时间
	 * @return String
	 */
	public String getEnt_time() {
		return ((String) getAttrVal("Ent_time"));
	}	
	/**
	 * 就诊时间
	 * @param Ent_time
	 */
	public void setEnt_time(String Ent_time) {
		setAttrVal("Ent_time", Ent_time);
	}
	/**
	 * 操作时间
	 * @return String
	 */
	public String getOpr_time() {
		return ((String) getAttrVal("Opr_time"));
	}	
	/**
	 * 操作时间
	 * @param Opr_time
	 */
	public void setOpr_time(String Opr_time) {
		setAttrVal("Opr_time", Opr_time);
	}
	/**
	 * 午别编码
	 * @return String
	 */
	public String getCode_dayslottp() {
		return ((String) getAttrVal("Code_dayslottp"));
	}	
	/**
	 * 午别编码
	 * @param Code_dayslottp
	 */
	public void setCode_dayslottp(String Code_dayslottp) {
		setAttrVal("Code_dayslottp", Code_dayslottp);
	}
	/**
	 * 午别名称
	 * @return String
	 */
	public String getName_dayslottp() {
		return ((String) getAttrVal("Name_dayslottp"));
	}	
	/**
	 * 午别名称
	 * @param Name_dayslottp
	 */
	public void setName_dayslottp(String Name_dayslottp) {
		setAttrVal("Name_dayslottp", Name_dayslottp);
	}
	/**
	 * 预计候诊时间
	 * @return String
	 */
	public String getExpected_waittime() {
		return ((String) getAttrVal("Expected_waittime"));
	}	
	/**
	 * 预计候诊时间
	 * @param Expected_waittime
	 */
	public void setExpected_waittime(String Expected_waittime) {
		setAttrVal("Expected_waittime", Expected_waittime);
	}
	/**
	 * 就诊顺序号
	 * @return String
	 */
	public String getCode_ticket() {
		return ((String) getAttrVal("Code_ticket"));
	}	
	/**
	 * 就诊顺序号
	 * @param Code_ticket
	 */
	public void setCode_ticket(String Code_ticket) {
		setAttrVal("Code_ticket", Code_ticket);
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
	 * 就诊状态
	 * @return String
	 */
	public String getCode_entstatus() {
		return ((String) getAttrVal("Code_entstatus"));
	}	
	/**
	 * 就诊状态
	 * @param Code_entstatus
	 */
	public void setCode_entstatus(String Code_entstatus) {
		setAttrVal("Code_entstatus", Code_entstatus);
	}
	/**
	 * 支付标志
	 * @return String
	 */
	public String getFg_payment() {
		return ((String) getAttrVal("Fg_payment"));
	}	
	/**
	 * 支付标志
	 * @param Fg_payment
	 */
	public void setFg_payment(String Fg_payment) {
		setAttrVal("Fg_payment", Fg_payment);
	}
}