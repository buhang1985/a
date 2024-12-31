package iih.pe.pwf.dto.pewfqcheckedovaldto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检总检已检队列 DTO数据 
 * 
 */
public class PeWfQcheckedOvalDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 体检总检ID
	 * @return String
	 */
	public String getId_pewfoval() {
		return ((String) getAttrVal("Id_pewfoval"));
	}
	/**
	 * 体检总检ID
	 * @param Id_pewfoval
	 */
	public void setId_pewfoval(String Id_pewfoval) {
		setAttrVal("Id_pewfoval", Id_pewfoval);
	}
	/**
	 * 体检流程诊间主键标识
	 * @return String
	 */
	public String getId_pewfroom() {
		return ((String) getAttrVal("Id_pewfroom"));
	}
	/**
	 * 体检流程诊间主键标识
	 * @param Id_pewfroom
	 */
	public void setId_pewfroom(String Id_pewfroom) {
		setAttrVal("Id_pewfroom", Id_pewfroom);
	}
	/**
	 * 所属体检科室ID
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}
	/**
	 * 所属体检科室ID
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 体检科室诊间ID
	 * @return String
	 */
	public String getId_pediroom() {
		return ((String) getAttrVal("Id_pediroom"));
	}
	/**
	 * 体检科室诊间ID
	 * @param Id_pediroom
	 */
	public void setId_pediroom(String Id_pediroom) {
		setAttrVal("Id_pediroom", Id_pediroom);
	}
	/**
	 * 体检客户ID
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}
	/**
	 * 体检客户ID
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 体检套餐ID
	 * @return String
	 */
	public String getId_pesrvsetdef() {
		return ((String) getAttrVal("Id_pesrvsetdef"));
	}
	/**
	 * 体检套餐ID
	 * @param Id_pesrvsetdef
	 */
	public void setId_pesrvsetdef(String Id_pesrvsetdef) {
		setAttrVal("Id_pesrvsetdef", Id_pesrvsetdef);
	}
	/**
	 * 会员卡ID
	 * @return String
	 */
	public String getId_pepsncard() {
		return ((String) getAttrVal("Id_pepsncard"));
	}
	/**
	 * 会员卡ID
	 * @param Id_pepsncard
	 */
	public void setId_pepsncard(String Id_pepsncard) {
		setAttrVal("Id_pepsncard", Id_pepsncard);
	}
	/**
	 * 排入等候时间
	 * @return FDateTime
	 */
	public FDateTime getDt_wait() {
		return ((FDateTime) getAttrVal("Dt_wait"));
	}
	/**
	 * 排入等候时间
	 * @param Dt_wait
	 */
	public void setDt_wait(FDateTime Dt_wait) {
		setAttrVal("Dt_wait", Dt_wait);
	}
	/**
	 * 检查开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_check() {
		return ((FDateTime) getAttrVal("Dt_check"));
	}
	/**
	 * 检查开始时间
	 * @param Dt_check
	 */
	public void setDt_check(FDateTime Dt_check) {
		setAttrVal("Dt_check", Dt_check);
	}
	/**
	 * 检查结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_leave() {
		return ((FDateTime) getAttrVal("Dt_leave"));
	}
	/**
	 * 检查结束时间
	 * @param Dt_leave
	 */
	public void setDt_leave(FDateTime Dt_leave) {
		setAttrVal("Dt_leave", Dt_leave);
	}
	/**
	 * 会员卡
	 * @return String
	 */
	public String getNo_card() {
		return ((String) getAttrVal("No_card"));
	}
	/**
	 * 会员卡
	 * @param No_card
	 */
	public void setNo_card(String No_card) {
		setAttrVal("No_card", No_card);
	}
	/**
	 * VIP标识
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}
	/**
	 * VIP标识
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 体检状态
	 * @return Integer
	 */
	public Integer getPestatus() {
		return ((Integer) getAttrVal("Pestatus"));
	}
	/**
	 * 体检状态
	 * @param Pestatus
	 */
	public void setPestatus(Integer Pestatus) {
		setAttrVal("Pestatus", Pestatus);
	}
	/**
	 * 体检流程卡
	 * @return String
	 */
	public String getCard_pe() {
		return ((String) getAttrVal("Card_pe"));
	}
	/**
	 * 体检流程卡
	 * @param Card_pe
	 */
	public void setCard_pe(String Card_pe) {
		setAttrVal("Card_pe", Card_pe);
	}
	/**
	 * 客户姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}
	/**
	 * 客户姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 客户性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 客户性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 性别标识
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别标识
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 体检套餐名称
	 * @return String
	 */
	public String getName_set() {
		return ((String) getAttrVal("Name_set"));
	}
	/**
	 * 体检套餐名称
	 * @param Name_set
	 */
	public void setName_set(String Name_set) {
		setAttrVal("Name_set", Name_set);
	}
	/**
	 * 团体名称
	 * @return String
	 */
	public String getName_corp() {
		return ((String) getAttrVal("Name_corp"));
	}
	/**
	 * 团体名称
	 * @param Name_corp
	 */
	public void setName_corp(String Name_corp) {
		setAttrVal("Name_corp", Name_corp);
	}
	/**
	 * 预约时间
	 * @return FDateTime
	 */
	public FDateTime getDt_appt() {
		return ((FDateTime) getAttrVal("Dt_appt"));
	}
	/**
	 * 预约时间
	 * @param Dt_appt
	 */
	public void setDt_appt(FDateTime Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 体检次数
	 * @return Integer
	 */
	public Integer getPe_times() {
		return ((Integer) getAttrVal("Pe_times"));
	}
	/**
	 * 体检次数
	 * @param Pe_times
	 */
	public void setPe_times(Integer Pe_times) {
		setAttrVal("Pe_times", Pe_times);
	}
	/**
	 * 出生日期
	 * @return String
	 */
	public String getDt_birth() {
		return ((String) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(String Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getIdcode() {
		return ((String) getAttrVal("Idcode"));
	}
	/**
	 * 证件号码
	 * @param Idcode
	 */
	public void setIdcode(String Idcode) {
		setAttrVal("Idcode", Idcode);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 体检日期
	 * @return FDate
	 */
	public FDate getDt_pe() {
		return ((FDate) getAttrVal("Dt_pe"));
	}
	/**
	 * 体检日期
	 * @param Dt_pe
	 */
	public void setDt_pe(FDate Dt_pe) {
		setAttrVal("Dt_pe", Dt_pe);
	}
	/**
	 * 登记日期
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}
	/**
	 * 登记日期
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 总检标识
	 * @return FBoolean
	 */
	public FBoolean getFg_oval() {
		return ((FBoolean) getAttrVal("Fg_oval"));
	}
	/**
	 * 总检标识
	 * @param Fg_oval
	 */
	public void setFg_oval(FBoolean Fg_oval) {
		setAttrVal("Fg_oval", Fg_oval);
	}
	/**
	 * 总检时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oval() {
		return ((FDateTime) getAttrVal("Dt_oval"));
	}
	/**
	 * 总检时间
	 * @param Dt_oval
	 */
	public void setDt_oval(FDateTime Dt_oval) {
		setAttrVal("Dt_oval", Dt_oval);
	}
	/**
	 * 总检医生
	 * @return String
	 */
	public String getDoc_oval() {
		return ((String) getAttrVal("Doc_oval"));
	}
	/**
	 * 总检医生
	 * @param Doc_oval
	 */
	public void setDoc_oval(String Doc_oval) {
		setAttrVal("Doc_oval", Doc_oval);
	}
	/**
	 * 审核标识
	 * @return FBoolean
	 */
	public FBoolean getFg_aduit() {
		return ((FBoolean) getAttrVal("Fg_aduit"));
	}
	/**
	 * 审核标识
	 * @param Fg_aduit
	 */
	public void setFg_aduit(FBoolean Fg_aduit) {
		setAttrVal("Fg_aduit", Fg_aduit);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_audit() {
		return ((FDateTime) getAttrVal("Dt_audit"));
	}
	/**
	 * 审核时间
	 * @param Dt_audit
	 */
	public void setDt_audit(FDateTime Dt_audit) {
		setAttrVal("Dt_audit", Dt_audit);
	}
	/**
	 * 审核医生
	 * @return String
	 */
	public String getDoc_audit() {
		return ((String) getAttrVal("Doc_audit"));
	}
	/**
	 * 审核医生
	 * @param Doc_audit
	 */
	public void setDoc_audit(String Doc_audit) {
		setAttrVal("Doc_audit", Doc_audit);
	}
	/**
	 * 报告核对标识
	 * @return FBoolean
	 */
	public FBoolean getFg_confirm() {
		return ((FBoolean) getAttrVal("Fg_confirm"));
	}
	/**
	 * 报告核对标识
	 * @param Fg_confirm
	 */
	public void setFg_confirm(FBoolean Fg_confirm) {
		setAttrVal("Fg_confirm", Fg_confirm);
	}
	/**
	 * 体检唯一码
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}
	/**
	 * 体检唯一码
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	/**
	 * 体检客户编号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 体检客户编号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 行号
	 * @return Integer
	 */
	public Integer getRowno() {
		return ((Integer) getAttrVal("Rowno"));
	}
	/**
	 * 行号
	 * @param Rowno
	 */
	public void setRowno(Integer Rowno) {
		setAttrVal("Rowno", Rowno);
	}
	/**
	 * 心电图完成标识
	 * @return Integer
	 */
	public Integer getEnum_ecg() {
		return ((Integer) getAttrVal("Enum_ecg"));
	}
	/**
	 * 心电图完成标识
	 * @param Enum_ecg
	 */
	public void setEnum_ecg(Integer Enum_ecg) {
		setAttrVal("Enum_ecg", Enum_ecg);
	}
	/**
	 * 检验完成标识
	 * @return Integer
	 */
	public Integer getEnum_lis() {
		return ((Integer) getAttrVal("Enum_lis"));
	}
	/**
	 * 检验完成标识
	 * @param Enum_lis
	 */
	public void setEnum_lis(Integer Enum_lis) {
		setAttrVal("Enum_lis", Enum_lis);
	}
	/**
	 * 放射完成标识
	 * @return Integer
	 */
	public Integer getEnum_x() {
		return ((Integer) getAttrVal("Enum_x"));
	}
	/**
	 * 放射完成标识
	 * @param Enum_x
	 */
	public void setEnum_x(Integer Enum_x) {
		setAttrVal("Enum_x", Enum_x);
	}
	/**
	 * CT完成标识
	 * @return Integer
	 */
	public Integer getEnum_ct() {
		return ((Integer) getAttrVal("Enum_ct"));
	}
	/**
	 * CT完成标识
	 * @param Enum_ct
	 */
	public void setEnum_ct(Integer Enum_ct) {
		setAttrVal("Enum_ct", Enum_ct);
	}
	/**
	 * 报告打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_print() {
		return ((FBoolean) getAttrVal("Fg_print"));
	}
	/**
	 * 报告打印标识
	 * @param Fg_print
	 */
	public void setFg_print(FBoolean Fg_print) {
		setAttrVal("Fg_print", Fg_print);
	}
	/**
	 * 报告打印时间
	 * @return FDateTime
	 */
	public FDateTime getDt_print() {
		return ((FDateTime) getAttrVal("Dt_print"));
	}
	/**
	 * 报告打印时间
	 * @param Dt_print
	 */
	public void setDt_print(FDateTime Dt_print) {
		setAttrVal("Dt_print", Dt_print);
	}
	/**
	 * 团体预约ID
	 * @return String
	 */
	public String getId_pecorpappt() {
		return ((String) getAttrVal("Id_pecorpappt"));
	}
	/**
	 * 团体预约ID
	 * @param Id_pecorpappt
	 */
	public void setId_pecorpappt(String Id_pecorpappt) {
		setAttrVal("Id_pecorpappt", Id_pecorpappt);
	}
	/**
	 * 总检锁定标识
	 * @return FBoolean
	 */
	public FBoolean getFg_locking() {
		return ((FBoolean) getAttrVal("Fg_locking"));
	}
	/**
	 * 总检锁定标识
	 * @param Fg_locking
	 */
	public void setFg_locking(FBoolean Fg_locking) {
		setAttrVal("Fg_locking", Fg_locking);
	}
	/**
	 * 总检锁定医生
	 * @return String
	 */
	public String getDoc_locking() {
		return ((String) getAttrVal("Doc_locking"));
	}
	/**
	 * 总检锁定医生
	 * @param Doc_locking
	 */
	public void setDoc_locking(String Doc_locking) {
		setAttrVal("Doc_locking", Doc_locking);
	}
}