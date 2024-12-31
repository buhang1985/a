package iih.ei.std.d.v1.ci.order.ip.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 就诊和医嘱信息DTO DTO数据 
 * 
 */
public class EntAndOrderInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 所属集团
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	/**
	 * 所属集团
	 * @param Code_grp
	 */
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	/**
	 * 医疗机构组织
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	/**
	 * 医疗机构组织
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getTimes_en() {
		return ((String) getAttrVal("Times_en"));
	}	
	/**
	 * 就诊次数
	 * @param Times_en
	 */
	public void setTimes_en(String Times_en) {
		setAttrVal("Times_en", Times_en);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getCode_en() {
		return ((String) getAttrVal("Code_en"));
	}	
	/**
	 * 就诊
	 * @param Code_en
	 */
	public void setCode_en(String Code_en) {
		setAttrVal("Code_en", Code_en);
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
	 * 当前就诊科室
	 * @return String
	 */
	public String getCode_dep_phy() {
		return ((String) getAttrVal("Code_dep_phy"));
	}	
	/**
	 * 当前就诊科室
	 * @param Code_dep_phy
	 */
	public void setCode_dep_phy(String Code_dep_phy) {
		setAttrVal("Code_dep_phy", Code_dep_phy);
	}
	/**
	 * 当前主管医生
	 * @return String
	 */
	public String getCode_emp_phy() {
		return ((String) getAttrVal("Code_emp_phy"));
	}	
	/**
	 * 当前主管医生
	 * @param Code_emp_phy
	 */
	public void setCode_emp_phy(String Code_emp_phy) {
		setAttrVal("Code_emp_phy", Code_emp_phy);
	}
	/**
	 * 当前责任护士
	 * @return String
	 */
	public String getCode_emp_nur() {
		return ((String) getAttrVal("Code_emp_nur"));
	}	
	/**
	 * 当前责任护士
	 * @param Code_emp_nur
	 */
	public void setCode_emp_nur(String Code_emp_nur) {
		setAttrVal("Code_emp_nur", Code_emp_nur);
	}
	/**
	 * 当前所在病区
	 * @return String
	 */
	public String getCode_dep_nur() {
		return ((String) getAttrVal("Code_dep_nur"));
	}	
	/**
	 * 当前所在病区
	 * @param Code_dep_nur
	 */
	public void setCode_dep_nur(String Code_dep_nur) {
		setAttrVal("Code_dep_nur", Code_dep_nur);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getCode_bed() {
		return ((String) getAttrVal("Code_bed"));
	}	
	/**
	 * 床位号
	 * @param Code_bed
	 */
	public void setCode_bed(String Code_bed) {
		setAttrVal("Code_bed", Code_bed);
	}
	/**
	 * VIP标识
	 * @return String
	 */
	public String getFg_vip() {
		return ((String) getAttrVal("Fg_vip"));
	}	
	/**
	 * VIP标识
	 * @param Fg_vip
	 */
	public void setFg_vip(String Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 高端商保标识
	 * @return String
	 */
	public String getFg_hecominsur() {
		return ((String) getAttrVal("Fg_hecominsur"));
	}	
	/**
	 * 高端商保标识
	 * @param Fg_hecominsur
	 */
	public void setFg_hecominsur(String Fg_hecominsur) {
		setAttrVal("Fg_hecominsur", Fg_hecominsur);
	}
	/**
	 * 婴儿标识
	 * @return String
	 */
	public String getFg_bb() {
		return ((String) getAttrVal("Fg_bb"));
	}	
	/**
	 * 婴儿标识
	 * @param Fg_bb
	 */
	public void setFg_bb(String Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	/**
	 * 是否在院患者
	 * @return String
	 */
	public String getFg_ip() {
		return ((String) getAttrVal("Fg_ip"));
	}	
	/**
	 * 是否在院患者
	 * @param Fg_ip
	 */
	public void setFg_ip(String Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 住院病案编号（住院号）
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院病案编号（住院号）
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 价格分类编码
	 * @return String
	 */
	public String getPri_pat_code() {
		return ((String) getAttrVal("Pri_pat_code"));
	}	
	/**
	 * 价格分类编码
	 * @param Pri_pat_code
	 */
	public void setPri_pat_code(String Pri_pat_code) {
		setAttrVal("Pri_pat_code", Pri_pat_code);
	}
	/**
	 * 价格分类名称
	 * @return String
	 */
	public String getPri_pat_name() {
		return ((String) getAttrVal("Pri_pat_name"));
	}	
	/**
	 * 价格分类名称
	 * @param Pri_pat_name
	 */
	public void setPri_pat_name(String Pri_pat_name) {
		setAttrVal("Pri_pat_name", Pri_pat_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex_pat() {
		return ((String) getAttrVal("Sd_sex_pat"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex_pat
	 */
	public void setSd_sex_pat(String Sd_sex_pat) {
		setAttrVal("Sd_sex_pat", Sd_sex_pat);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getName_sex_pat() {
		return ((String) getAttrVal("Name_sex_pat"));
	}	
	/**
	 * 性别名称
	 * @param Name_sex_pat
	 */
	public void setName_sex_pat(String Name_sex_pat) {
		setAttrVal("Name_sex_pat", Name_sex_pat);
	}
	/**
	 * 出生日期
	 * @return String
	 */
	public String getDt_birth_pat() {
		return ((String) getAttrVal("Dt_birth_pat"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(String Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	/**
	 * 身份证件类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}	
	/**
	 * 身份证件类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 身份证件类型名称
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}	
	/**
	 * 身份证件类型名称
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
	}
	/**
	 * 身份证件类号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}	
	/**
	 * 身份证件类号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * 联系电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 入院登记时间
	 * @return String
	 */
	public String getDt_entry_en() {
		return ((String) getAttrVal("Dt_entry_en"));
	}	
	/**
	 * 入院登记时间
	 * @param Dt_entry_en
	 */
	public void setDt_entry_en(String Dt_entry_en) {
		setAttrVal("Dt_entry_en", Dt_entry_en);
	}
	/**
	 * 入院时间
	 * @return String
	 */
	public String getDt_enacpt() {
		return ((String) getAttrVal("Dt_enacpt"));
	}	
	/**
	 * 入院时间
	 * @param Dt_enacpt
	 */
	public void setDt_enacpt(String Dt_enacpt) {
		setAttrVal("Dt_enacpt", Dt_enacpt);
	}
	/**
	 * 出院日期
	 * @return String
	 */
	public String getDt_enend() {
		return ((String) getAttrVal("Dt_enend"));
	}	
	/**
	 * 出院日期
	 * @param Dt_enend
	 */
	public void setDt_enend(String Dt_enend) {
		setAttrVal("Dt_enend", Dt_enend);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱下服务号
	 * @return String
	 */
	public String getCode_or_itm() {
		return ((String) getAttrVal("Code_or_itm"));
	}	
	/**
	 * 医嘱下服务号
	 * @param Code_or_itm
	 */
	public void setCode_or_itm(String Code_or_itm) {
		setAttrVal("Code_or_itm", Code_or_itm);
	}
	/**
	 * 长期临时标志
	 * @return String
	 */
	public String getFg_long() {
		return ((String) getAttrVal("Fg_long"));
	}	
	/**
	 * 长期临时标志
	 * @param Fg_long
	 */
	public void setFg_long(String Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 医嘱开始时间
	 * @return String
	 */
	public String getDt_effe() {
		return ((String) getAttrVal("Dt_effe"));
	}	
	/**
	 * 医嘱开始时间
	 * @param Dt_effe
	 */
	public void setDt_effe(String Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 医嘱结束时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}	
	/**
	 * 医嘱结束时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 加急标志
	 * @return String
	 */
	public String getFg_urgent() {
		return ((String) getAttrVal("Fg_urgent"));
	}	
	/**
	 * 加急标志
	 * @param Fg_urgent
	 */
	public void setFg_urgent(String Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 备注(当前使用)
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	/**
	 * 备注(当前使用)
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 服务基本分类编码
	 * @return String
	 */
	public String getCode_srvca() {
		return ((String) getAttrVal("Code_srvca"));
	}	
	/**
	 * 服务基本分类编码
	 * @param Code_srvca
	 */
	public void setCode_srvca(String Code_srvca) {
		setAttrVal("Code_srvca", Code_srvca);
	}
	/**
	 * 服务基本分类名称
	 * @return String
	 */
	public String getName_srvca() {
		return ((String) getAttrVal("Name_srvca"));
	}	
	/**
	 * 服务基本分类名称
	 * @param Name_srvca
	 */
	public void setName_srvca(String Name_srvca) {
		setAttrVal("Name_srvca", Name_srvca);
	}
	/**
	 * 医嘱类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 医嘱类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 医嘱类型名称
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	/**
	 * 医嘱类型名称
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getCode_dep_mp() {
		return ((String) getAttrVal("Code_dep_mp"));
	}	
	/**
	 * 执行科室编码
	 * @param Code_dep_mp
	 */
	public void setCode_dep_mp(String Code_dep_mp) {
		setAttrVal("Code_dep_mp", Code_dep_mp);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}	
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 开单时间
	 * @return String
	 */
	public String getDt_entry() {
		return ((String) getAttrVal("Dt_entry"));
	}	
	/**
	 * 开单时间
	 * @param Dt_entry
	 */
	public void setDt_entry(String Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 开单医生编码
	 * @return String
	 */
	public String getCode_emp_or() {
		return ((String) getAttrVal("Code_emp_or"));
	}	
	/**
	 * 开单医生编码
	 * @param Code_emp_or
	 */
	public void setCode_emp_or(String Code_emp_or) {
		setAttrVal("Code_emp_or", Code_emp_or);
	}
	/**
	 * 开单医生名称
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}	
	/**
	 * 开单医生名称
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 开单科室编码
	 * @return String
	 */
	public String getCode_dep_or() {
		return ((String) getAttrVal("Code_dep_or"));
	}	
	/**
	 * 开单科室编码
	 * @param Code_dep_or
	 */
	public void setCode_dep_or(String Code_dep_or) {
		setAttrVal("Code_dep_or", Code_dep_or);
	}
	/**
	 * 开单科室名称
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}	
	/**
	 * 开单科室名称
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 开单所在病区编码
	 * @return String
	 */
	public String getCode_dep_nur_or() {
		return ((String) getAttrVal("Code_dep_nur_or"));
	}	
	/**
	 * 开单所在病区编码
	 * @param Code_dep_nur_or
	 */
	public void setCode_dep_nur_or(String Code_dep_nur_or) {
		setAttrVal("Code_dep_nur_or", Code_dep_nur_or);
	}
	/**
	 * 开单所在病区名称
	 * @return String
	 */
	public String getName_dep_nur_or() {
		return ((String) getAttrVal("Name_dep_nur_or"));
	}	
	/**
	 * 开单所在病区名称
	 * @param Name_dep_nur_or
	 */
	public void setName_dep_nur_or(String Name_dep_nur_or) {
		setAttrVal("Name_dep_nur_or", Name_dep_nur_or);
	}
	/**
	 * 签署标识
	 * @return String
	 */
	public String getFg_sign() {
		return ((String) getAttrVal("Fg_sign"));
	}	
	/**
	 * 签署标识
	 * @param Fg_sign
	 */
	public void setFg_sign(String Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
	}
	/**
	 * 签署医生编码
	 * @return String
	 */
	public String getCode_emp_sign() {
		return ((String) getAttrVal("Code_emp_sign"));
	}	
	/**
	 * 签署医生编码
	 * @param Code_emp_sign
	 */
	public void setCode_emp_sign(String Code_emp_sign) {
		setAttrVal("Code_emp_sign", Code_emp_sign);
	}
	/**
	 * 签署医生姓名
	 * @return String
	 */
	public String getName_emp_sign() {
		return ((String) getAttrVal("Name_emp_sign"));
	}	
	/**
	 * 签署医生姓名
	 * @param Name_emp_sign
	 */
	public void setName_emp_sign(String Name_emp_sign) {
		setAttrVal("Name_emp_sign", Name_emp_sign);
	}
	/**
	 * 签署科室编码
	 * @return String
	 */
	public String getCode_dep_sign() {
		return ((String) getAttrVal("Code_dep_sign"));
	}	
	/**
	 * 签署科室编码
	 * @param Code_dep_sign
	 */
	public void setCode_dep_sign(String Code_dep_sign) {
		setAttrVal("Code_dep_sign", Code_dep_sign);
	}
	/**
	 * 签署科室名称
	 * @return String
	 */
	public String getName_dep_sign() {
		return ((String) getAttrVal("Name_dep_sign"));
	}	
	/**
	 * 签署科室名称
	 * @param Name_dep_sign
	 */
	public void setName_dep_sign(String Name_dep_sign) {
		setAttrVal("Name_dep_sign", Name_dep_sign);
	}
	/**
	 * 签署核对标识
	 * @return String
	 */
	public String getFg_chk() {
		return ((String) getAttrVal("Fg_chk"));
	}	
	/**
	 * 签署核对标识
	 * @param Fg_chk
	 */
	public void setFg_chk(String Fg_chk) {
		setAttrVal("Fg_chk", Fg_chk);
	}
	/**
	 * 签署确认护士编码
	 * @return String
	 */
	public String getCode_emp_chk() {
		return ((String) getAttrVal("Code_emp_chk"));
	}	
	/**
	 * 签署确认护士编码
	 * @param Code_emp_chk
	 */
	public void setCode_emp_chk(String Code_emp_chk) {
		setAttrVal("Code_emp_chk", Code_emp_chk);
	}
	/**
	 * 签署确认护士名称
	 * @return String
	 */
	public String getName_emp_chk() {
		return ((String) getAttrVal("Name_emp_chk"));
	}	
	/**
	 * 签署确认护士名称
	 * @param Name_emp_chk
	 */
	public void setName_emp_chk(String Name_emp_chk) {
		setAttrVal("Name_emp_chk", Name_emp_chk);
	}
	/**
	 * 停止标识
	 * @return String
	 */
	public String getFg_stop() {
		return ((String) getAttrVal("Fg_stop"));
	}	
	/**
	 * 停止标识
	 * @param Fg_stop
	 */
	public void setFg_stop(String Fg_stop) {
		setAttrVal("Fg_stop", Fg_stop);
	}
	/**
	 * 停止医生编码
	 * @return String
	 */
	public String getCode_emp_stop() {
		return ((String) getAttrVal("Code_emp_stop"));
	}	
	/**
	 * 停止医生编码
	 * @param Code_emp_stop
	 */
	public void setCode_emp_stop(String Code_emp_stop) {
		setAttrVal("Code_emp_stop", Code_emp_stop);
	}
	/**
	 * 停止医生名称
	 * @return String
	 */
	public String getName_emp_stop() {
		return ((String) getAttrVal("Name_emp_stop"));
	}	
	/**
	 * 停止医生名称
	 * @param Name_emp_stop
	 */
	public void setName_emp_stop(String Name_emp_stop) {
		setAttrVal("Name_emp_stop", Name_emp_stop);
	}
	/**
	 * 停止核对标识
	 * @return String
	 */
	public String getFg_chk_stop() {
		return ((String) getAttrVal("Fg_chk_stop"));
	}	
	/**
	 * 停止核对标识
	 * @param Fg_chk_stop
	 */
	public void setFg_chk_stop(String Fg_chk_stop) {
		setAttrVal("Fg_chk_stop", Fg_chk_stop);
	}
	/**
	 * 停止确认护士编码
	 * @return String
	 */
	public String getCode_emp_chk_stop() {
		return ((String) getAttrVal("Code_emp_chk_stop"));
	}	
	/**
	 * 停止确认护士编码
	 * @param Code_emp_chk_stop
	 */
	public void setCode_emp_chk_stop(String Code_emp_chk_stop) {
		setAttrVal("Code_emp_chk_stop", Code_emp_chk_stop);
	}
	/**
	 * 停止确认护士名称
	 * @return String
	 */
	public String getName_emp_chk_stop() {
		return ((String) getAttrVal("Name_emp_chk_stop"));
	}	
	/**
	 * 停止确认护士名称
	 * @param Name_emp_chk_stop
	 */
	public void setName_emp_chk_stop(String Name_emp_chk_stop) {
		setAttrVal("Name_emp_chk_stop", Name_emp_chk_stop);
	}
	/**
	 * 作废标志
	 * @return String
	 */
	public String getFg_canc() {
		return ((String) getAttrVal("Fg_canc"));
	}	
	/**
	 * 作废标志
	 * @param Fg_canc
	 */
	public void setFg_canc(String Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 作废医生编码
	 * @return String
	 */
	public String getCode_emp_canc() {
		return ((String) getAttrVal("Code_emp_canc"));
	}	
	/**
	 * 作废医生编码
	 * @param Code_emp_canc
	 */
	public void setCode_emp_canc(String Code_emp_canc) {
		setAttrVal("Code_emp_canc", Code_emp_canc);
	}
	/**
	 * 作废医生姓名
	 * @return String
	 */
	public String getName_emp_canc() {
		return ((String) getAttrVal("Name_emp_canc"));
	}	
	/**
	 * 作废医生姓名
	 * @param Name_emp_canc
	 */
	public void setName_emp_canc(String Name_emp_canc) {
		setAttrVal("Name_emp_canc", Name_emp_canc);
	}
	/**
	 * 作废确认标志
	 * @return String
	 */
	public String getFg_chk_canc() {
		return ((String) getAttrVal("Fg_chk_canc"));
	}	
	/**
	 * 作废确认标志
	 * @param Fg_chk_canc
	 */
	public void setFg_chk_canc(String Fg_chk_canc) {
		setAttrVal("Fg_chk_canc", Fg_chk_canc);
	}
	/**
	 * 作废确认护士编码
	 * @return String
	 */
	public String getCode_emp_chk_canc() {
		return ((String) getAttrVal("Code_emp_chk_canc"));
	}	
	/**
	 * 作废确认护士编码
	 * @param Code_emp_chk_canc
	 */
	public void setCode_emp_chk_canc(String Code_emp_chk_canc) {
		setAttrVal("Code_emp_chk_canc", Code_emp_chk_canc);
	}
	/**
	 * 作废确认护士姓名
	 * @return String
	 */
	public String getName_emp_chk_canc() {
		return ((String) getAttrVal("Name_emp_chk_canc"));
	}	
	/**
	 * 作废确认护士姓名
	 * @param Name_emp_chk_canc
	 */
	public void setName_emp_chk_canc(String Name_emp_chk_canc) {
		setAttrVal("Name_emp_chk_canc", Name_emp_chk_canc);
	}
	/**
	 * 医嘱状态编码
	 * @return String
	 */
	public String getSd_su_or() {
		return ((String) getAttrVal("Sd_su_or"));
	}	
	/**
	 * 医嘱状态编码
	 * @param Sd_su_or
	 */
	public void setSd_su_or(String Sd_su_or) {
		setAttrVal("Sd_su_or", Sd_su_or);
	}
	/**
	 * 医嘱状态名称
	 * @return String
	 */
	public String getName_su_or() {
		return ((String) getAttrVal("Name_su_or"));
	}	
	/**
	 * 医嘱状态名称
	 * @param Name_su_or
	 */
	public void setName_su_or(String Name_su_or) {
		setAttrVal("Name_su_or", Name_su_or);
	}
	/**
	 * 医嘱项目编码
	 * @return String
	 */
	public String getCode_or_srv() {
		return ((String) getAttrVal("Code_or_srv"));
	}	
	/**
	 * 医嘱项目编码
	 * @param Code_or_srv
	 */
	public void setCode_or_srv(String Code_or_srv) {
		setAttrVal("Code_or_srv", Code_or_srv);
	}
	/**
	 * 医嘱项目名称
	 * @return String
	 */
	public String getName_or_srv() {
		return ((String) getAttrVal("Name_or_srv"));
	}	
	/**
	 * 医嘱项目名称
	 * @param Name_or_srv
	 */
	public void setName_or_srv(String Name_or_srv) {
		setAttrVal("Name_or_srv", Name_or_srv);
	}
	/**
	 * 医嘱简称
	 * @return String
	 */
	public String getShortname() {
		return ((String) getAttrVal("Shortname"));
	}	
	/**
	 * 医嘱简称
	 * @param Shortname
	 */
	public void setShortname(String Shortname) {
		setAttrVal("Shortname", Shortname);
	}
	/**
	 * 药品打印名称
	 * @return String
	 */
	public String getPrintname() {
		return ((String) getAttrVal("Printname"));
	}	
	/**
	 * 药品打印名称
	 * @param Printname
	 */
	public void setPrintname(String Printname) {
		setAttrVal("Printname", Printname);
	}
	/**
	 * 药品生产厂家
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	/**
	 * 药品生产厂家
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 频次编码
	 * @return String
	 */
	public String getCode_freq() {
		return ((String) getAttrVal("Code_freq"));
	}	
	/**
	 * 频次编码
	 * @param Code_freq
	 */
	public void setCode_freq(String Code_freq) {
		setAttrVal("Code_freq", Code_freq);
	}
	/**
	 * 给药方式编码
	 * @return String
	 */
	public String getCode_route() {
		return ((String) getAttrVal("Code_route"));
	}	
	/**
	 * 给药方式编码
	 * @param Code_route
	 */
	public void setCode_route(String Code_route) {
		setAttrVal("Code_route", Code_route);
	}
	/**
	 * 给药方式名称
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}	
	/**
	 * 给药方式名称
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 发药药房编码
	 * @return String
	 */
	public String getCode_wh() {
		return ((String) getAttrVal("Code_wh"));
	}	
	/**
	 * 发药药房编码
	 * @param Code_wh
	 */
	public void setCode_wh(String Code_wh) {
		setAttrVal("Code_wh", Code_wh);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 是否预防用药
	 * @return String
	 */
	public String getFg_propc() {
		return ((String) getAttrVal("Fg_propc"));
	}	
	/**
	 * 是否预防用药
	 * @param Fg_propc
	 */
	public void setFg_propc(String Fg_propc) {
		setAttrVal("Fg_propc", Fg_propc);
	}
	/**
	 * 单次医学剂量
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	/**
	 * 单次医学剂量
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getCode_medu() {
		return ((String) getAttrVal("Code_medu"));
	}	
	/**
	 * 医学单位
	 * @param Code_medu
	 */
	public void setCode_medu(String Code_medu) {
		setAttrVal("Code_medu", Code_medu);
	}
	/**
	 * 界面录入单次用量
	 * @return FDouble
	 */
	public FDouble getQuan_medu_cur() {
		return ((FDouble) getAttrVal("Quan_medu_cur"));
	}	
	/**
	 * 界面录入单次用量
	 * @param Quan_medu_cur
	 */
	public void setQuan_medu_cur(FDouble Quan_medu_cur) {
		setAttrVal("Quan_medu_cur", Quan_medu_cur);
	}
	/**
	 * 界面录入单次用量单位
	 * @return String
	 */
	public String getCode_medu_cur() {
		return ((String) getAttrVal("Code_medu_cur"));
	}	
	/**
	 * 界面录入单次用量单位
	 * @param Code_medu_cur
	 */
	public void setCode_medu_cur(String Code_medu_cur) {
		setAttrVal("Code_medu_cur", Code_medu_cur);
	}
	/**
	 * 界面录入单次用量单位换算系数
	 * @return FDouble
	 */
	public FDouble getFactor_cur() {
		return ((FDouble) getAttrVal("Factor_cur"));
	}	
	/**
	 * 界面录入单次用量单位换算系数
	 * @param Factor_cur
	 */
	public void setFactor_cur(FDouble Factor_cur) {
		setAttrVal("Factor_cur", Factor_cur);
	}
	/**
	 * 单次基本单位数量_分子
	 * @return String
	 */
	public String getQuan_num_base() {
		return ((String) getAttrVal("Quan_num_base"));
	}	
	/**
	 * 单次基本单位数量_分子
	 * @param Quan_num_base
	 */
	public void setQuan_num_base(String Quan_num_base) {
		setAttrVal("Quan_num_base", Quan_num_base);
	}
	/**
	 * 单次基本单位数量_分母
	 * @return String
	 */
	public String getQuan_den_base() {
		return ((String) getAttrVal("Quan_den_base"));
	}	
	/**
	 * 单次基本单位数量_分母
	 * @param Quan_den_base
	 */
	public void setQuan_den_base(String Quan_den_base) {
		setAttrVal("Quan_den_base", Quan_den_base);
	}
	/**
	 * 基本包转单位名称
	 * @return String
	 */
	public String getCode_pgku_base() {
		return ((String) getAttrVal("Code_pgku_base"));
	}	
	/**
	 * 基本包转单位名称
	 * @param Code_pgku_base
	 */
	public void setCode_pgku_base(String Code_pgku_base) {
		setAttrVal("Code_pgku_base", Code_pgku_base);
	}
	/**
	 * 医基换算系数
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}	
	/**
	 * 医基换算系数
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	/**
	 * 总量
	 * @return FDouble
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}	
	/**
	 * 总量
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	/**
	 * 总量包装单位
	 * @return String
	 */
	public String getCode_pgku_cur() {
		return ((String) getAttrVal("Code_pgku_cur"));
	}	
	/**
	 * 总量包装单位
	 * @param Code_pgku_cur
	 */
	public void setCode_pgku_cur(String Code_pgku_cur) {
		setAttrVal("Code_pgku_cur", Code_pgku_cur);
	}
	/**
	 * 总量单位换算系数
	 * @return String
	 */
	public String getFactor_pgku_cur() {
		return ((String) getAttrVal("Factor_pgku_cur"));
	}	
	/**
	 * 总量单位换算系数
	 * @param Factor_pgku_cur
	 */
	public void setFactor_pgku_cur(String Factor_pgku_cur) {
		setAttrVal("Factor_pgku_cur", Factor_pgku_cur);
	}
	/**
	 * 不计费类型
	 * @return String
	 */
	public String getSd_nodispense() {
		return ((String) getAttrVal("Sd_nodispense"));
	}	
	/**
	 * 不计费类型
	 * @param Sd_nodispense
	 */
	public void setSd_nodispense(String Sd_nodispense) {
		setAttrVal("Sd_nodispense", Sd_nodispense);
	}
	/**
	 * 医嘱付数
	 * @return String
	 */
	public String getOrders() {
		return ((String) getAttrVal("Orders"));
	}	
	/**
	 * 医嘱付数
	 * @param Orders
	 */
	public void setOrders(String Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 领药方式
	 * @return String
	 */
	public String getSd_dispensemd() {
		return ((String) getAttrVal("Sd_dispensemd"));
	}	
	/**
	 * 领药方式
	 * @param Sd_dispensemd
	 */
	public void setSd_dispensemd(String Sd_dispensemd) {
		setAttrVal("Sd_dispensemd", Sd_dispensemd);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}	
	/**
	 * 单价
	 * @param Pri
	 */
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	/**
	 * 医保目录类型
	 * @return String
	 *//*
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}	
	*//**
	 * 医保目录类型
	 * @param Sd_hpsrvtp
	 *//*
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	*//**
	 * 自费标识
	 * @return String
	 *//*
	public String getFg_selfpay() {
		return ((String) getAttrVal("Fg_selfpay"));
	}	
	*//**
	 * 自费标识
	 * @param Fg_selfpay
	 *//*
	public void setFg_selfpay(String Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	*//**
	 * 特种病标识
	 * @return String
	 *//*
	public String getFg_specill() {
		return ((String) getAttrVal("Fg_specill"));
	}	
	*//**
	 * 特种病标识
	 * @param Fg_specill
	 *//*
	public void setFg_specill(String Fg_specill) {
		setAttrVal("Fg_specill", Fg_specill);
	}
	*//**
	 * 科研标识
	 * @return String
	 *//*
	public String getFg_research() {
		return ((String) getAttrVal("Fg_research"));
	}	
	*//**
	 * 科研标识
	 * @param Fg_research
	 *//*
	public void setFg_research(String Fg_research) {
		setAttrVal("Fg_research", Fg_research);
	}
	*//**
	 * 科研项目编码
	 * @return String
	 *//*
	public String getCode_researchproject() {
		return ((String) getAttrVal("Code_researchproject"));
	}	
	*//**
	 * 科研项目编码
	 * @param Code_researchproject
	 *//*
	public void setCode_researchproject(String Code_researchproject) {
		setAttrVal("Code_researchproject", Code_researchproject);
	}
	*//**
	 * 标本号
	 * @return String
	 *//*
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}	
	*//**
	 * 标本号
	 * @param No_bar
	 *//*
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}*/
}