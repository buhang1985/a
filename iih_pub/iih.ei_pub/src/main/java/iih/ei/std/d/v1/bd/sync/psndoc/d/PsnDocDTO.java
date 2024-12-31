package iih.ei.std.d.v1.bd.sync.psndoc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 人员档案信息 DTO数据 
 * 
 */
public class PsnDocDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 名族编码
	 * @return String
	 */
	public String getSd_nation() {
		return ((String) getAttrVal("Sd_nation"));
	}	
	/**
	 * 名族编码
	 * @param Sd_nation
	 */
	public void setSd_nation(String Sd_nation) {
		setAttrVal("Sd_nation", Sd_nation);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getBirthday() {
		return ((FDate) getAttrVal("Birthday"));
	}	
	/**
	 * 出生日期
	 * @param Birthday
	 */
	public void setBirthday(FDate Birthday) {
		setAttrVal("Birthday", Birthday);
	}
	/**
	 * 证件类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}	
	/**
	 * 证件类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getNum_id() {
		return ((String) getAttrVal("Num_id"));
	}	
	/**
	 * 证件号码
	 * @param Num_id
	 */
	public void setNum_id(String Num_id) {
		setAttrVal("Num_id", Num_id);
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
	 * 行政所属部门编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 行政所属部门编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 人员类别编码
	 * @return String
	 */
	public String getCode_psntp() {
		return ((String) getAttrVal("Code_psntp"));
	}	
	/**
	 * 人员类别编码
	 * @param Code_psntp
	 */
	public void setCode_psntp(String Code_psntp) {
		setAttrVal("Code_psntp", Code_psntp);
	}
	/**
	 * 人员工作类型编码
	 * @return String
	 */
	public String getSd_empwktp() {
		return ((String) getAttrVal("Sd_empwktp"));
	}	
	/**
	 * 人员工作类型编码
	 * @param Sd_empwktp
	 */
	public void setSd_empwktp(String Sd_empwktp) {
		setAttrVal("Sd_empwktp", Sd_empwktp);
	}
	/**
	 * 人员聘任职称编码
	 * @return String
	 */
	public String getSd_emptitle() {
		return ((String) getAttrVal("Sd_emptitle"));
	}	
	/**
	 * 人员聘任职称编码
	 * @param Sd_emptitle
	 */
	public void setSd_emptitle(String Sd_emptitle) {
		setAttrVal("Sd_emptitle", Sd_emptitle);
	}
	/**
	 * 处方权标志
	 * @return FBoolean
	 */
	public FBoolean getFg_presrt() {
		return ((FBoolean) getAttrVal("Fg_presrt"));
	}	
	/**
	 * 处方权标志
	 * @param Fg_presrt
	 */
	public void setFg_presrt(FBoolean Fg_presrt) {
		setAttrVal("Fg_presrt", Fg_presrt);
	}
	/**
	 * 医师执业证书编码
	 * @return String
	 */
	public String getDrid() {
		return ((String) getAttrVal("Drid"));
	}	
	/**
	 * 医师执业证书编码
	 * @param Drid
	 */
	public void setDrid(String Drid) {
		setAttrVal("Drid", Drid);
	}
	/**
	 * 医生简介
	 * @return String
	 */
	public String getNote_phy() {
		return ((String) getAttrVal("Note_phy"));
	}	
	/**
	 * 医生简介
	 * @param Note_phy
	 */
	public void setNote_phy(String Note_phy) {
		setAttrVal("Note_phy", Note_phy);
	}
	/**
	 * 姓名简称
	 * @return String
	 */
	public String getShrotname() {
		return ((String) getAttrVal("Shrotname"));
	}	
	/**
	 * 姓名简称
	 * @param Shrotname
	 */
	public void setShrotname(String Shrotname) {
		setAttrVal("Shrotname", Shrotname);
	}
	/**
	 * 曾用名
	 * @return String
	 */
	public String getUsedname() {
		return ((String) getAttrVal("Usedname"));
	}	
	/**
	 * 曾用名
	 * @param Usedname
	 */
	public void setUsedname(String Usedname) {
		setAttrVal("Usedname", Usedname);
	}
	/**
	 * 血型编码
	 * @return String
	 */
	public String getSd_bloodtype() {
		return ((String) getAttrVal("Sd_bloodtype"));
	}	
	/**
	 * 血型编码
	 * @param Sd_bloodtype
	 */
	public void setSd_bloodtype(String Sd_bloodtype) {
		setAttrVal("Sd_bloodtype", Sd_bloodtype);
	}
	/**
	 * 办公电话
	 * @return String
	 */
	public String getTel_office() {
		return ((String) getAttrVal("Tel_office"));
	}	
	/**
	 * 办公电话
	 * @param Tel_office
	 */
	public void setTel_office(String Tel_office) {
		setAttrVal("Tel_office", Tel_office);
	}
	/**
	 * 家庭电话
	 * @return String
	 */
	public String getTel_home() {
		return ((String) getAttrVal("Tel_home"));
	}	
	/**
	 * 家庭电话
	 * @param Tel_home
	 */
	public void setTel_home(String Tel_home) {
		setAttrVal("Tel_home", Tel_home);
	}
	/**
	 * 电子邮箱
	 * @return String
	 */
	public String getEmail() {
		return ((String) getAttrVal("Email"));
	}	
	/**
	 * 电子邮箱
	 * @param Email
	 */
	public void setEmail(String Email) {
		setAttrVal("Email", Email);
	}
	/**
	 * 私人邮箱
	 * @return String
	 */
	public String getEmail_secret() {
		return ((String) getAttrVal("Email_secret"));
	}	
	/**
	 * 私人邮箱
	 * @param Email_secret
	 */
	public void setEmail_secret(String Email_secret) {
		setAttrVal("Email_secret", Email_secret);
	}
	/**
	 * 传真
	 * @return String
	 */
	public String getFax() {
		return ((String) getAttrVal("Fax"));
	}	
	/**
	 * 传真
	 * @param Fax
	 */
	public void setFax(String Fax) {
		setAttrVal("Fax", Fax);
	}
	/**
	 * 归属部门职务编码
	 * @return String
	 */
	public String getCode_empduty() {
		return ((String) getAttrVal("Code_empduty"));
	}	
	/**
	 * 归属部门职务编码
	 * @param Code_empduty
	 */
	public void setCode_empduty(String Code_empduty) {
		setAttrVal("Code_empduty", Code_empduty);
	}
	/**
	 * 国家/地区编码
	 * @return String
	 */
	public String getCode_country() {
		return ((String) getAttrVal("Code_country"));
	}	
	/**
	 * 国家/地区编码
	 * @param Code_country
	 */
	public void setCode_country(String Code_country) {
		setAttrVal("Code_country", Code_country);
	}
	/**
	 * 籍贯编码
	 * @return String
	 */
	public String getCode_vativeplace() {
		return ((String) getAttrVal("Code_vativeplace"));
	}	
	/**
	 * 籍贯编码
	 * @param Code_vativeplace
	 */
	public void setCode_vativeplace(String Code_vativeplace) {
		setAttrVal("Code_vativeplace", Code_vativeplace);
	}
	/**
	 * 户籍地址
	 * @return String
	 */
	public String getAddr_census() {
		return ((String) getAttrVal("Addr_census"));
	}	
	/**
	 * 户籍地址
	 * @param Addr_census
	 */
	public void setAddr_census(String Addr_census) {
		setAttrVal("Addr_census", Addr_census);
	}
	/**
	 * 户口性质编码
	 * @return String
	 */
	public String getSd_characterrpr() {
		return ((String) getAttrVal("Sd_characterrpr"));
	}	
	/**
	 * 户口性质编码
	 * @param Sd_characterrpr
	 */
	public void setSd_characterrpr(String Sd_characterrpr) {
		setAttrVal("Sd_characterrpr", Sd_characterrpr);
	}
	/**
	 * 户口所在地
	 * @return String
	 */
	public String getAddr_residence() {
		return ((String) getAttrVal("Addr_residence"));
	}	
	/**
	 * 户口所在地
	 * @param Addr_residence
	 */
	public void setAddr_residence(String Addr_residence) {
		setAttrVal("Addr_residence", Addr_residence);
	}
	/**
	 * 档案所在地
	 * @return String
	 */
	public String getAddr_file() {
		return ((String) getAttrVal("Addr_file"));
	}	
	/**
	 * 档案所在地
	 * @param Addr_file
	 */
	public void setAddr_file(String Addr_file) {
		setAttrVal("Addr_file", Addr_file);
	}
	/**
	 * 健康状况编码
	 * @return String
	 */
	public String getSd_health() {
		return ((String) getAttrVal("Sd_health"));
	}	
	/**
	 * 健康状况编码
	 * @param Sd_health
	 */
	public void setSd_health(String Sd_health) {
		setAttrVal("Sd_health", Sd_health);
	}
	/**
	 * 婚姻状况编码
	 * @return String
	 */
	public String getSd_marital() {
		return ((String) getAttrVal("Sd_marital"));
	}	
	/**
	 * 婚姻状况编码
	 * @param Sd_marital
	 */
	public void setSd_marital(String Sd_marital) {
		setAttrVal("Sd_marital", Sd_marital);
	}
	/**
	 * 结/离婚日期
	 * @return FDate
	 */
	public FDate getDt_marital() {
		return ((FDate) getAttrVal("Dt_marital"));
	}	
	/**
	 * 结/离婚日期
	 * @param Dt_marital
	 */
	public void setDt_marital(FDate Dt_marital) {
		setAttrVal("Dt_marital", Dt_marital);
	}
	/**
	 * 邮政编码
	 * @return String
	 */
	public String getCode_post() {
		return ((String) getAttrVal("Code_post"));
	}	
	/**
	 * 邮政编码
	 * @param Code_post
	 */
	public void setCode_post(String Code_post) {
		setAttrVal("Code_post", Code_post);
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
	 * 家庭地址
	 * @return String
	 */
	public String getAddr_home() {
		return ((String) getAttrVal("Addr_home"));
	}	
	/**
	 * 家庭地址
	 * @param Addr_home
	 */
	public void setAddr_home(String Addr_home) {
		setAttrVal("Addr_home", Addr_home);
	}
	/**
	 * 政治面貌编码
	 * @return String
	 */
	public String getSd_polity() {
		return ((String) getAttrVal("Sd_polity"));
	}	
	/**
	 * 政治面貌编码
	 * @param Sd_polity
	 */
	public void setSd_polity(String Sd_polity) {
		setAttrVal("Sd_polity", Sd_polity);
	}
	/**
	 * 入党(团)日期
	 * @return FDate
	 */
	public FDate getDt_joinpolity() {
		return ((FDate) getAttrVal("Dt_joinpolity"));
	}	
	/**
	 * 入党(团)日期
	 * @param Dt_joinpolity
	 */
	public void setDt_joinpolity(FDate Dt_joinpolity) {
		setAttrVal("Dt_joinpolity", Dt_joinpolity);
	}
	/**
	 * 个人身份
	 * @return String
	 */
	public String getPenelauth() {
		return ((String) getAttrVal("Penelauth"));
	}	
	/**
	 * 个人身份
	 * @param Penelauth
	 */
	public void setPenelauth(String Penelauth) {
		setAttrVal("Penelauth", Penelauth);
	}
	/**
	 * 人员职务编码
	 * @return String
	 */
	public String getCode_psnpost() {
		return ((String) getAttrVal("Code_psnpost"));
	}	
	/**
	 * 人员职务编码
	 * @param Code_psnpost
	 */
	public void setCode_psnpost(String Code_psnpost) {
		setAttrVal("Code_psnpost", Code_psnpost);
	}
	/**
	 * 在岗状态编码
	 * @return String
	 */
	public String getSd_inmark() {
		return ((String) getAttrVal("Sd_inmark"));
	}	
	/**
	 * 在岗状态编码
	 * @param Sd_inmark
	 */
	public void setSd_inmark(String Sd_inmark) {
		setAttrVal("Sd_inmark", Sd_inmark);
	}
	/**
	 * 虚拟人员标识
	 * @return FBoolean
	 */
	public FBoolean getFg_virtual() {
		return ((FBoolean) getAttrVal("Fg_virtual"));
	}	
	/**
	 * 虚拟人员标识
	 * @param Fg_virtual
	 */
	public void setFg_virtual(FBoolean Fg_virtual) {
		setAttrVal("Fg_virtual", Fg_virtual);
	}
	/**
	 * 人员描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 人员描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
}