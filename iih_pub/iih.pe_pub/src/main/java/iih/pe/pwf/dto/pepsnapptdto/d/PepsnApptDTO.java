package iih.pe.pwf.dto.pepsnapptdto.d;

import java.util.List;

import xap.mw.core.data.BaseDTO;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PepsnApptDTO extends BaseDTO{

	// 体检预约单主键标识
	@RPCField(id = 1)
	private String id_pepsnappt;
	// 体检时间
	@RPCField(id = 2)
	private String dt_pe;
	// 体检状态
	@RPCField(id = 3)
	private String pestatus;
	// 客户姓名
	@RPCField(id = 4)
	private String name_psn;
	// 性别编码
	@RPCField(id = 5)
	private String sd_sex_psn;
	// 年龄
	@RPCField(id = 6)
	private Integer age_psn;
	// 体检唯一码
	@RPCField(id = 7)
	private String pe_code;

	public String getId_pepsnappt() {
		return id_pepsnappt;
	}

	public void setId_pepsnappt(String id_pepsnappt) {
		this.id_pepsnappt = id_pepsnappt;
	}

	public String getDt_pe() {
		return dt_pe;
	}

	public void setDt_pe(String dt_pe) {
		this.dt_pe = dt_pe;
	}

	public String getPestatus() {
		return pestatus;
	}

	public void setPestatus(String pestatus) {
		this.pestatus = pestatus;
	}

	public String getName_psn() {
		return name_psn;
	}

	public void setName_psn(String name_psn) {
		this.name_psn = name_psn;
	}

	public String getSd_sex_psn() {
		return sd_sex_psn;
	}

	public void setSd_sex_psn(String sd_sex_psn) {
		this.sd_sex_psn = sd_sex_psn;
	}

	public Integer getAge_psn() {
		return age_psn;
	}

	public void setAge_psn(Integer age_psn) {
		this.age_psn = age_psn;
	}

	public String getPe_code() {
		return pe_code;
	}

	public void setPe_code(String pe_code) {
		this.pe_code = pe_code;
	}

}
