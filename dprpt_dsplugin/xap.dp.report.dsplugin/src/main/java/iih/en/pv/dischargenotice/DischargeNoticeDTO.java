package iih.en.pv.dischargenotice;

import xap.mw.coreitf.d.FBoolean;

/**
 * 出院通知单打印DTO
 * 
 * @author zhengcm
 * @date 2017-03-28 11:36:47
 *
 */
public class DischargeNoticeDTO {

	private String name_org;// 组织名称
	private String name_dep_nur;// 病房名称
	private String name_di;// 诊断名称
	private String name_state;// 饮食种类名称
	private FBoolean fg_pres;// 是否处方
	private String name_dep;// 科室名称
	private String name_sex;// 性别

	public String getName_org() {
		return name_org;
	}

	public void setName_org(String name_org) {
		this.name_org = name_org;
	}

	public String getName_dep_nur() {
		return name_dep_nur;
	}

	public void setName_dep_nur(String name_dep_nur) {
		this.name_dep_nur = name_dep_nur;
	}

	public String getName_di() {
		return name_di;
	}

	public void setName_di(String name_di) {
		this.name_di = name_di;
	}

	public String getName_state() {
		return name_state;
	}

	public void setName_state(String name_state) {
		this.name_state = name_state;
	}

	public FBoolean getFg_pres() {
		return fg_pres;
	}

	public void setFg_pres(FBoolean fg_pres) {
		this.fg_pres = fg_pres;
	}

	public String getName_dep() {
		return name_dep;
	}

	public void setName_dep(String name_dep) {
		this.name_dep = name_dep;
	}

	public String getName_sex() {
		return name_sex;
	}

	public void setName_sex(String name_sex) {
		this.name_sex = name_sex;
	}

}
