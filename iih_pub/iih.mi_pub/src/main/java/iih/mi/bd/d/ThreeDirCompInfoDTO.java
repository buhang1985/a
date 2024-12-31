package iih.mi.bd.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 三大目录对照DTO DTO数据 
 * 
 */
public class ThreeDirCompInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 对照主键
	 * @return String
	 */
	public String getId_dircomp() {
		return ((String) getAttrVal("Id_dircomp"));
	}
	/**
	 * 对照主键
	 * @param Id_dircomp
	 */
	public void setId_dircomp(String Id_dircomp) {
		setAttrVal("Id_dircomp", Id_dircomp);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 医保系统
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保系统
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * HIS医疗服务主键
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * HIS医疗服务主键
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * HIS药品主键
	 * @return String
	 */
	public String getId_drug() {
		return ((String) getAttrVal("Id_drug"));
	}
	/**
	 * HIS药品主键
	 * @param Id_drug
	 */
	public void setId_drug(String Id_drug) {
		setAttrVal("Id_drug", Id_drug);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * his编码
	 * @return String
	 */
	public String getHiscode() {
		return ((String) getAttrVal("Hiscode"));
	}
	/**
	 * his编码
	 * @param Hiscode
	 */
	public void setHiscode(String Hiscode) {
		setAttrVal("Hiscode", Hiscode);
	}
	/**
	 * his名称
	 * @return String
	 */
	public String getHisname() {
		return ((String) getAttrVal("Hisname"));
	}
	/**
	 * his名称
	 * @param Hisname
	 */
	public void setHisname(String Hisname) {
		setAttrVal("Hisname", Hisname);
	}
	/**
	 * 医保项目类别
	 * @return Integer
	 */
	public Integer getEu_hpsrvtp() {
		return ((Integer) getAttrVal("Eu_hpsrvtp"));
	}
	/**
	 * 医保项目类别
	 * @param Eu_hpsrvtp
	 */
	public void setEu_hpsrvtp(Integer Eu_hpsrvtp) {
		setAttrVal("Eu_hpsrvtp", Eu_hpsrvtp);
	}
	/**
	 * 费用账单
	 * @return String
	 */
	public String getCode_ca() {
		return ((String) getAttrVal("Code_ca"));
	}
	/**
	 * 费用账单
	 * @param Code_ca
	 */
	public void setCode_ca(String Code_ca) {
		setAttrVal("Code_ca", Code_ca);
	}
	/**
	 * 医保等级
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}
	/**
	 * 医保等级
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getEu_status() {
		return ((String) getAttrVal("Eu_status"));
	}
	/**
	 * 状态
	 * @param Eu_status
	 */
	public void setEu_status(String Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	/**
	 * 对照描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 对照描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice_max() {
		return ((FDouble) getAttrVal("Price_max"));
	}
	/**
	 * 单价
	 * @param Price_max
	 */
	public void setPrice_max(FDouble Price_max) {
		setAttrVal("Price_max", Price_max);
	}
	/**
	 * 门诊自付比例
	 * @return String
	 */
	public String getRatio_self_oep() {
		return ((String) getAttrVal("Ratio_self_oep"));
	}
	/**
	 * 门诊自付比例
	 * @param Ratio_self_oep
	 */
	public void setRatio_self_oep(String Ratio_self_oep) {
		setAttrVal("Ratio_self_oep", Ratio_self_oep);
	}
	/**
	 * 住院自付比例
	 * @return String
	 */
	public String getRatio_self_ip() {
		return ((String) getAttrVal("Ratio_self_ip"));
	}
	/**
	 * 住院自付比例
	 * @param Ratio_self_ip
	 */
	public void setRatio_self_ip(String Ratio_self_ip) {
		setAttrVal("Ratio_self_ip", Ratio_self_ip);
	}
}