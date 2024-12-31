package iih.pi.reg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者基本信息DTO DTO数据 
 * 
 */
public class PiPatBasicInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者信息主键标识
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者信息主键标识
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 所属机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	 * 患者编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 患者编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 患者姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 主身份标志类型
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}
	/**
	 * 主身份标志类型
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 主身份标志类型名称
	 * @return String
	 */
	public String getIdtp_name() {
		return ((String) getAttrVal("Idtp_name"));
	}
	/**
	 * 主身份标志类型名称
	 * @param Idtp_name
	 */
	public void setIdtp_name(String Idtp_name) {
		setAttrVal("Idtp_name", Idtp_name);
	}
	/**
	 * 主身份标志类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}
	/**
	 * 主身份标志类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 主身份标识号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 主身份标识号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getId_paticate() {
		return ((String) getAttrVal("Id_paticate"));
	}
	/**
	 * 患者分类
	 * @param Id_paticate
	 */
	public void setId_paticate(String Id_paticate) {
		setAttrVal("Id_paticate", Id_paticate);
	}
	/**
	 * 患者分类名称
	 * @return String
	 */
	public String getPaticate_anme() {
		return ((String) getAttrVal("Paticate_anme"));
	}
	/**
	 * 患者分类名称
	 * @param Paticate_anme
	 */
	public void setPaticate_anme(String Paticate_anme) {
		setAttrVal("Paticate_anme", Paticate_anme);
	}
	/**
	 * 价格分类
	 * @return String
	 */
	public String getId_patpritp() {
		return ((String) getAttrVal("Id_patpritp"));
	}
	/**
	 * 价格分类
	 * @param Id_patpritp
	 */
	public void setId_patpritp(String Id_patpritp) {
		setAttrVal("Id_patpritp", Id_patpritp);
	}
	/**
	 * 价格分类名称
	 * @return String
	 */
	public String getPatpritp_name() {
		return ((String) getAttrVal("Patpritp_name"));
	}
	/**
	 * 价格分类名称
	 * @param Patpritp_name
	 */
	public void setPatpritp_name(String Patpritp_name) {
		setAttrVal("Patpritp_name", Patpritp_name);
	}
	/**
	 * 信用分类
	 * @return String
	 */
	public String getId_patcrettp() {
		return ((String) getAttrVal("Id_patcrettp"));
	}
	/**
	 * 信用分类
	 * @param Id_patcrettp
	 */
	public void setId_patcrettp(String Id_patcrettp) {
		setAttrVal("Id_patcrettp", Id_patcrettp);
	}
	/**
	 * 信用分类名称
	 * @return String
	 */
	public String getPatcrettp_name() {
		return ((String) getAttrVal("Patcrettp_name"));
	}
	/**
	 * 信用分类名称
	 * @param Patcrettp_name
	 */
	public void setPatcrettp_name(String Patcrettp_name) {
		setAttrVal("Patcrettp_name", Patcrettp_name);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getSex_name() {
		return ((String) getAttrVal("Sex_name"));
	}
	/**
	 * 性别名称
	 * @param Sex_name
	 */
	public void setSex_name(String Sex_name) {
		setAttrVal("Sex_name", Sex_name);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 固定电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}
	/**
	 * 固定电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}
	/**
	 * 移动电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 民族
	 * @return String
	 */
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}
	/**
	 * 民族
	 * @param Id_nation
	 */
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
	}
	/**
	 * 民族名称
	 * @return String
	 */
	public String getNation_name() {
		return ((String) getAttrVal("Nation_name"));
	}
	/**
	 * 民族名称
	 * @param Nation_name
	 */
	public void setNation_name(String Nation_name) {
		setAttrVal("Nation_name", Nation_name);
	}
	/**
	 * 民族编码
	 * @return String
	 */
	public String getSd_nation() {
		return ((String) getAttrVal("Sd_nation"));
	}
	/**
	 * 民族编码
	 * @param Sd_nation
	 */
	public void setSd_nation(String Sd_nation) {
		setAttrVal("Sd_nation", Sd_nation);
	}
	/**
	 * 国家
	 * @return String
	 */
	public String getId_country() {
		return ((String) getAttrVal("Id_country"));
	}
	/**
	 * 国家
	 * @param Id_country
	 */
	public void setId_country(String Id_country) {
		setAttrVal("Id_country", Id_country);
	}
	/**
	 * 国家名称
	 * @return String
	 */
	public String getCountry_name() {
		return ((String) getAttrVal("Country_name"));
	}
	/**
	 * 国家名称
	 * @param Country_name
	 */
	public void setCountry_name(String Country_name) {
		setAttrVal("Country_name", Country_name);
	}
	/**
	 * 国家编码
	 * @return String
	 */
	public String getSd_country() {
		return ((String) getAttrVal("Sd_country"));
	}
	/**
	 * 国家编码
	 * @param Sd_country
	 */
	public void setSd_country(String Sd_country) {
		setAttrVal("Sd_country", Sd_country);
	}
	/**
	 * 患者来源地类型
	 * @return String
	 */
	public String getId_srcregiontp() {
		return ((String) getAttrVal("Id_srcregiontp"));
	}
	/**
	 * 患者来源地类型
	 * @param Id_srcregiontp
	 */
	public void setId_srcregiontp(String Id_srcregiontp) {
		setAttrVal("Id_srcregiontp", Id_srcregiontp);
	}
	/**
	 * 患者来源地类型名称
	 * @return String
	 */
	public String getSrcregiontp_name() {
		return ((String) getAttrVal("Srcregiontp_name"));
	}
	/**
	 * 患者来源地类型名称
	 * @param Srcregiontp_name
	 */
	public void setSrcregiontp_name(String Srcregiontp_name) {
		setAttrVal("Srcregiontp_name", Srcregiontp_name);
	}
	/**
	 * 患者来源地类型编码
	 * @return String
	 */
	public String getSd_srcregiontp() {
		return ((String) getAttrVal("Sd_srcregiontp"));
	}
	/**
	 * 患者来源地类型编码
	 * @param Sd_srcregiontp
	 */
	public void setSd_srcregiontp(String Sd_srcregiontp) {
		setAttrVal("Sd_srcregiontp", Sd_srcregiontp);
	}
	/**
	 * 婚姻
	 * @return String
	 */
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}
	/**
	 * 婚姻
	 * @param Id_marry
	 */
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	/**
	 * 婚姻名称
	 * @return String
	 */
	public String getMarry_name() {
		return ((String) getAttrVal("Marry_name"));
	}
	/**
	 * 婚姻名称
	 * @param Marry_name
	 */
	public void setMarry_name(String Marry_name) {
		setAttrVal("Marry_name", Marry_name);
	}
	/**
	 * 婚姻编码
	 * @return String
	 */
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}
	/**
	 * 婚姻编码
	 * @param Sd_marry
	 */
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getId_occu() {
		return ((String) getAttrVal("Id_occu"));
	}
	/**
	 * 职业
	 * @param Id_occu
	 */
	public void setId_occu(String Id_occu) {
		setAttrVal("Id_occu", Id_occu);
	}
	/**
	 * 职业名称
	 * @return String
	 */
	public String getOccu_name() {
		return ((String) getAttrVal("Occu_name"));
	}
	/**
	 * 职业名称
	 * @param Occu_name
	 */
	public void setOccu_name(String Occu_name) {
		setAttrVal("Occu_name", Occu_name);
	}
	/**
	 * 职业编码
	 * @return String
	 */
	public String getSd_occu() {
		return ((String) getAttrVal("Sd_occu"));
	}
	/**
	 * 职业编码
	 * @param Sd_occu
	 */
	public void setSd_occu(String Sd_occu) {
		setAttrVal("Sd_occu", Sd_occu);
	}
	/**
	 * 工作单位
	 * @return String
	 */
	public String getWorkunit() {
		return ((String) getAttrVal("Workunit"));
	}
	/**
	 * 工作单位
	 * @param Workunit
	 */
	public void setWorkunit(String Workunit) {
		setAttrVal("Workunit", Workunit);
	}
	/**
	 * 门诊病案编号
	 * @return String
	 */
	public String getCode_amr_oep() {
		return ((String) getAttrVal("Code_amr_oep"));
	}
	/**
	 * 门诊病案编号
	 * @param Code_amr_oep
	 */
	public void setCode_amr_oep(String Code_amr_oep) {
		setAttrVal("Code_amr_oep", Code_amr_oep);
	}
	/**
	 * 住院病案编号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院病案编号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 患者登录用户
	 * @return String
	 */
	public String getId_log() {
		return ((String) getAttrVal("Id_log"));
	}
	/**
	 * 患者登录用户
	 * @param Id_log
	 */
	public void setId_log(String Id_log) {
		setAttrVal("Id_log", Id_log);
	}
	/**
	 * 失效类型
	 * @return String
	 */
	public String getId_piinvdmd() {
		return ((String) getAttrVal("Id_piinvdmd"));
	}
	/**
	 * 失效类型
	 * @param Id_piinvdmd
	 */
	public void setId_piinvdmd(String Id_piinvdmd) {
		setAttrVal("Id_piinvdmd", Id_piinvdmd);
	}
	/**
	 * 失效类型名称
	 * @return String
	 */
	public String getPiinvdmd_name() {
		return ((String) getAttrVal("Piinvdmd_name"));
	}
	/**
	 * 失效类型名称
	 * @param Piinvdmd_name
	 */
	public void setPiinvdmd_name(String Piinvdmd_name) {
		setAttrVal("Piinvdmd_name", Piinvdmd_name);
	}
	/**
	 * 失效类型编码
	 * @return String
	 */
	public String getSd_piinvdmd() {
		return ((String) getAttrVal("Sd_piinvdmd"));
	}
	/**
	 * 失效类型编码
	 * @param Sd_piinvdmd
	 */
	public void setSd_piinvdmd(String Sd_piinvdmd) {
		setAttrVal("Sd_piinvdmd", Sd_piinvdmd);
	}
	/**
	 * 失效描述
	 * @return String
	 */
	public String getPriinvddes() {
		return ((String) getAttrVal("Priinvddes"));
	}
	/**
	 * 失效描述
	 * @param Priinvddes
	 */
	public void setPriinvddes(String Priinvddes) {
		setAttrVal("Priinvddes", Priinvddes);
	}
	/**
	 * 失效标志
	 * @return FBoolean
	 */
	public FBoolean getFg_invd() {
		return ((FBoolean) getAttrVal("Fg_invd"));
	}
	/**
	 * 失效标志
	 * @param Fg_invd
	 */
	public void setFg_invd(FBoolean Fg_invd) {
		setAttrVal("Fg_invd", Fg_invd);
	}
	/**
	 * 实名认证
	 * @return FBoolean
	 */
	public FBoolean getFg_realname() {
		return ((FBoolean) getAttrVal("Fg_realname"));
	}
	/**
	 * 实名认证
	 * @param Fg_realname
	 */
	public void setFg_realname(FBoolean Fg_realname) {
		setAttrVal("Fg_realname", Fg_realname);
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
	 * 文化程度
	 * @return String
	 */
	public String getId_educ() {
		return ((String) getAttrVal("Id_educ"));
	}
	/**
	 * 文化程度
	 * @param Id_educ
	 */
	public void setId_educ(String Id_educ) {
		setAttrVal("Id_educ", Id_educ);
	}
	/**
	 * 文化程度名称
	 * @return String
	 */
	public String getEduc_name() {
		return ((String) getAttrVal("Educ_name"));
	}
	/**
	 * 文化程度名称
	 * @param Educ_name
	 */
	public void setEduc_name(String Educ_name) {
		setAttrVal("Educ_name", Educ_name);
	}
	/**
	 * 文化程度编码
	 * @return String
	 */
	public String getSd_educ() {
		return ((String) getAttrVal("Sd_educ"));
	}
	/**
	 * 文化程度编码
	 * @param Sd_educ
	 */
	public void setSd_educ(String Sd_educ) {
		setAttrVal("Sd_educ", Sd_educ);
	}
	/**
	 * 建档来源类型
	 * @return String
	 */
	public String getId_patsrctp() {
		return ((String) getAttrVal("Id_patsrctp"));
	}
	/**
	 * 建档来源类型
	 * @param Id_patsrctp
	 */
	public void setId_patsrctp(String Id_patsrctp) {
		setAttrVal("Id_patsrctp", Id_patsrctp);
	}
	/**
	 * 建档来源类型名称
	 * @return String
	 */
	public String getPatsrctp_name() {
		return ((String) getAttrVal("Patsrctp_name"));
	}
	/**
	 * 建档来源类型名称
	 * @param Patsrctp_name
	 */
	public void setPatsrctp_name(String Patsrctp_name) {
		setAttrVal("Patsrctp_name", Patsrctp_name);
	}
	/**
	 * 建档来源类型编码
	 * @return String
	 */
	public String getSd_patsrctp() {
		return ((String) getAttrVal("Sd_patsrctp"));
	}
	/**
	 * 建档来源类型编码
	 * @param Sd_patsrctp
	 */
	public void setSd_patsrctp(String Sd_patsrctp) {
		setAttrVal("Sd_patsrctp", Sd_patsrctp);
	}
	/**
	 * CHIS条码号
	 * @return String
	 */
	public String getBarcode_chis() {
		return ((String) getAttrVal("Barcode_chis"));
	}
	/**
	 * CHIS条码号
	 * @param Barcode_chis
	 */
	public void setBarcode_chis(String Barcode_chis) {
		setAttrVal("Barcode_chis", Barcode_chis);
	}
}