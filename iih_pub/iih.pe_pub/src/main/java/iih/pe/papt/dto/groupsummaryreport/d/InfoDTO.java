package iih.pe.papt.dto.groupsummaryreport.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class InfoDTO extends BaseDTO {

	// 性别
	@RPCField(id = 1)
	private String gender;
	// 身份证号
	@RPCField(id = 10)
	private String idcode_psn;
	// 手机号
	@RPCField(id = 11)
	private String mob_psn;
	// 出生日期
	@RPCField(id = 12)
	private String birth_psn;
	// 年龄
	@RPCField(id = 13)
	private String age;
	// 体检流水号
	@RPCField(id = 2)
	private String code_pe;
	// 体检日期
	@RPCField(id = 3)
	private String dt_pe;
	// 体检卡号
	@RPCField(id = 4)
	private String card_pe;
	// 体检状态
	@RPCField(id = 5)
	private String status_pe;
	// 总检日期
	@RPCField(id = 6)
	private String dt_oval;
	// 是否总总检
	@RPCField(id = 7)
	private String fg_oval;
	// 体检唯一码
	@RPCField(id = 8)
	private String code_psn;
	// 姓名
	@RPCField(id = 9)
	private String name_psn;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdcode_psn() {
		return idcode_psn;
	}

	public void setIdcode_psn(String idcode_psn) {
		this.idcode_psn = idcode_psn;
	}

	public String getMob_psn() {
		return mob_psn;
	}

	public void setMob_psn(String mob_psn) {
		this.mob_psn = mob_psn;
	}

	public String getBirth_psn() {
		return birth_psn;
	}

	public void setBirth_psn(String birth_psn) {
		this.birth_psn = birth_psn;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCode_pe() {
		return code_pe;
	}

	public void setCode_pe(String code_pe) {
		this.code_pe = code_pe;
	}

	public String getDt_pe() {
		return dt_pe;
	}

	public void setDt_pe(String dt_pe) {
		this.dt_pe = dt_pe;
	}

	public String getCard_pe() {
		return card_pe;
	}

	public void setCard_pe(String card_pe) {
		this.card_pe = card_pe;
	}

	public String getStatus_pe() {
		return status_pe;
	}

	public void setStatus_pe(String status_pe) {
		this.status_pe = status_pe;
	}

	public String getDt_oval() {
		return dt_oval;
	}

	public void setDt_oval(String dt_oval) {
		this.dt_oval = dt_oval;
	}

	public String getFg_oval() {
		return fg_oval;
	}

	public void setFg_oval(String fg_oval) {
		this.fg_oval = fg_oval;
	}

	public String getCode_psn() {
		return code_psn;
	}

	public void setCode_psn(String code_psn) {
		this.code_psn = code_psn;
	}

	public String getName_psn() {
		return name_psn;
	}

	public void setName_psn(String name_psn) {
		this.name_psn = name_psn;
	}

}
