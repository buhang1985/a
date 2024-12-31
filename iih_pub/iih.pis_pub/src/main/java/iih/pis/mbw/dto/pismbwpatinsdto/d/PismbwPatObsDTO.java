package iih.pis.mbw.dto.pismbwpatinsdto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PismbwPatObsDTO {

	// 检查报告ID
	@RPCField(id = 1)
	private String id_rptobs;
	// 检查仪器编码
	@RPCField(id = 10)
	private String id_insmt;
	// 检查仪器
	@RPCField(id = 11)
	private String sd_insmt;
	// 检查报告状态
	@RPCField(id = 12)
	private String id_su;
	// 检查报告状态编码
	@RPCField(id = 13)
	private String sd_su;
	// 报告时间
	@RPCField(id = 14)
	private String dt_rptobs;
	// 报告者编码
	@RPCField(id = 15)
	private String id_emp;
	// 报告科室
	@RPCField(id = 16)
	private String id_dep;
	// 图片地址
	@RPCField(id = 17)
	private String image_url;
	// 报告者姓名
	@RPCField(id = 18)
	private String code_emp;
	// 申请单号
	@RPCField(id = 2)
	private String no_applyform;
	// 检查申请单主键
	@RPCField(id = 3)
	private String id_orobs;
	// 患者就诊
	@RPCField(id = 4)
	private String id_ent;
	// 医嘱
	@RPCField(id = 5)
	private String id_or;
	// 检查申请报告单
	@RPCField(id = 6)
	private String no_rptobs;
	// 检查所见
	@RPCField(id = 7)
	private String des_rptobs;
	// 检查意见
	@RPCField(id = 8)
	private String des_advice;
	// 备注
	@RPCField(id = 9)
	private String des_obs;

	public String getId_rptobs() {
		return id_rptobs;
	}

	public void setId_rptobs(String id_rptobs) {
		this.id_rptobs = id_rptobs;
	}

	public String getId_insmt() {
		return id_insmt;
	}

	public void setId_insmt(String id_insmt) {
		this.id_insmt = id_insmt;
	}

	public String getSd_insmt() {
		return sd_insmt;
	}

	public void setSd_insmt(String sd_insmt) {
		this.sd_insmt = sd_insmt;
	}

	public String getId_su() {
		return id_su;
	}

	public void setId_su(String id_su) {
		this.id_su = id_su;
	}

	public String getSd_su() {
		return sd_su;
	}

	public void setSd_su(String sd_su) {
		this.sd_su = sd_su;
	}

	public String getDt_rptobs() {
		return dt_rptobs;
	}

	public void setDt_rptobs(String dt_rptobs) {
		this.dt_rptobs = dt_rptobs;
	}

	public String getId_emp() {
		return id_emp;
	}

	public void setId_emp(String id_emp) {
		this.id_emp = id_emp;
	}

	public String getId_dep() {
		return id_dep;
	}

	public void setId_dep(String id_dep) {
		this.id_dep = id_dep;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getCode_emp() {
		return code_emp;
	}

	public void setCode_emp(String code_emp) {
		this.code_emp = code_emp;
	}

	public String getNo_applyform() {
		return no_applyform;
	}

	public void setNo_applyform(String no_applyform) {
		this.no_applyform = no_applyform;
	}

	public String getId_orobs() {
		return id_orobs;
	}

	public void setId_orobs(String id_orobs) {
		this.id_orobs = id_orobs;
	}

	public String getId_ent() {
		return id_ent;
	}

	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}

	public String getId_or() {
		return id_or;
	}

	public void setId_or(String id_or) {
		this.id_or = id_or;
	}

	public String getNo_rptobs() {
		return no_rptobs;
	}

	public void setNo_rptobs(String no_rptobs) {
		this.no_rptobs = no_rptobs;
	}

	public String getDes_rptobs() {
		return des_rptobs;
	}

	public void setDes_rptobs(String des_rptobs) {
		this.des_rptobs = des_rptobs;
	}

	public String getDes_advice() {
		return des_advice;
	}

	public void setDes_advice(String des_advice) {
		this.des_advice = des_advice;
	}

	public String getDes_obs() {
		return des_obs;
	}

	public void setDes_obs(String des_obs) {
		this.des_obs = des_obs;
	}

}
