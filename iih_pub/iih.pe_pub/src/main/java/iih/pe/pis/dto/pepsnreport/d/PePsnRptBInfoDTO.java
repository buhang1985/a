package iih.pe.pis.dto.pepsnreport.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PePsnRptBInfoDTO {

	// vip
	@RPCField(id = 1)
	private String fg_vip;
	// 团体名称
	@RPCField(id = 10)
	private String name_corp;
	// 性别
	@RPCField(id = 11)
	private String name_sex;
	// 尊称
	@RPCField(id = 12)
	private String name_call;
	// 体检次数
	@RPCField(id = 13)
	private String pe_times;
	// 体检唯一码
	@RPCField(id = 14)
	private String pe_code;
	// 体检预约单ID
	@RPCField(id = 15)
	private String id_pepsnappt;
	// 体检客户ID
	@RPCField(id = 16)
	private String id_pepsnbinfo;
	// 体检流程卡
	@RPCField(id = 17)
	private String cardno;
	// 体检团体id
	@RPCField(id = 18)
	private String id_pecorpbinfo;
	// 体检登记备注
	@RPCField(id = 2)
	private String rmk_pe;
	// 预约卡
	@RPCField(id = 3)
	private String porder;
	// 体检时间
	@RPCField(id = 4)
	private String dt_pe;
	// 体检者姓名
	@RPCField(id = 5)
	private String name_psn;
	// 出生日期
	@RPCField(id = 6)
	private String dt_birth;
	// 移动电话
	@RPCField(id = 7)
	private String mob;
	// 照片
	@RPCField(id = 8)
	private String pho;
	// 体检套餐名称
	@RPCField(id = 9)
	private String name_set;

	public String getFg_vip() {
		return fg_vip;
	}

	public void setFg_vip(String fg_vip) {
		this.fg_vip = fg_vip;
	}

	public String getName_corp() {
		return name_corp;
	}

	public void setName_corp(String name_corp) {
		this.name_corp = name_corp;
	}

	public String getName_sex() {
		return name_sex;
	}

	public void setName_sex(String name_sex) {
		this.name_sex = name_sex;
	}

	public String getName_call() {
		return name_call;
	}

	public void setName_call(String name_call) {
		this.name_call = name_call;
	}

	public String getPe_times() {
		return pe_times;
	}

	public void setPe_times(String pe_times) {
		this.pe_times = pe_times;
	}

	public String getPe_code() {
		return pe_code;
	}

	public void setPe_code(String pe_code) {
		this.pe_code = pe_code;
	}

	public String getId_pepsnappt() {
		return id_pepsnappt;
	}

	public void setId_pepsnappt(String id_pepsnappt) {
		this.id_pepsnappt = id_pepsnappt;
	}

	public String getId_pepsnbinfo() {
		return id_pepsnbinfo;
	}

	public void setId_pepsnbinfo(String id_pepsnbinfo) {
		this.id_pepsnbinfo = id_pepsnbinfo;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getId_pecorpbinfo() {
		return id_pecorpbinfo;
	}

	public void setId_pecorpbinfo(String id_pecorpbinfo) {
		this.id_pecorpbinfo = id_pecorpbinfo;
	}

	public String getRmk_pe() {
		return rmk_pe;
	}

	public void setRmk_pe(String rmk_pe) {
		this.rmk_pe = rmk_pe;
	}

	public String getPorder() {
		return porder;
	}

	public void setPorder(String porder) {
		this.porder = porder;
	}

	public String getDt_pe() {
		return dt_pe;
	}

	public void setDt_pe(String dt_pe) {
		this.dt_pe = dt_pe;
	}

	public String getName_psn() {
		return name_psn;
	}

	public void setName_psn(String name_psn) {
		this.name_psn = name_psn;
	}

	public String getDt_birth() {
		return dt_birth;
	}

	public void setDt_birth(String dt_birth) {
		this.dt_birth = dt_birth;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getPho() {
		return pho;
	}

	public void setPho(String pho) {
		this.pho = pho;
	}

	public String getName_set() {
		return name_set;
	}

	public void setName_set(String name_set) {
		this.name_set = name_set;
	}

}
