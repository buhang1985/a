package iih.ei.std.d.v1.en.paidaptdetail.d;

import xap.mw.core.data.BaseDTO;

/**
 * 获取预约详细信息 DTO数据 
 * 
 */
public class PaidAptDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约ID
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	/**
	 * 预约ID
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}	
	/**
	 * 就诊类型名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 患者分类编码
	 * @return String
	 */
	public String getCode_patca() {
		return ((String) getAttrVal("Code_patca"));
	}	
	/**
	 * 患者分类编码
	 * @param Code_patca
	 */
	public void setCode_patca(String Code_patca) {
		setAttrVal("Code_patca", Code_patca);
	}
	/**
	 * 患者就诊名称
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}	
	/**
	 * 患者就诊名称
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getTimes_op() {
		return ((String) getAttrVal("Times_op"));
	}	
	/**
	 * 就诊次数
	 * @param Times_op
	 */
	public void setTimes_op(String Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}	
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 生日
	 * @return String
	 */
	public String getBirthday() {
		return ((String) getAttrVal("Birthday"));
	}	
	/**
	 * 生日
	 * @param Birthday
	 */
	public void setBirthday(String Birthday) {
		setAttrVal("Birthday", Birthday);
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
	 * 号别编码
	 * @return String
	 */
	public String getCode_srvtp() {
		return ((String) getAttrVal("Code_srvtp"));
	}	
	/**
	 * 号别编码
	 * @param Code_srvtp
	 */
	public void setCode_srvtp(String Code_srvtp) {
		setAttrVal("Code_srvtp", Code_srvtp);
	}
	/**
	 * 好别名称
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	/**
	 * 好别名称
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	/**
	 * 资源编码
	 * @return String
	 */
	public String getCode_res() {
		return ((String) getAttrVal("Code_res"));
	}	
	/**
	 * 资源编码
	 * @param Code_res
	 */
	public void setCode_res(String Code_res) {
		setAttrVal("Code_res", Code_res);
	}
	/**
	 * 资源名称
	 * @return String
	 */
	public String getName_res() {
		return ((String) getAttrVal("Name_res"));
	}	
	/**
	 * 资源名称
	 * @param Name_res
	 */
	public void setName_res(String Name_res) {
		setAttrVal("Name_res", Name_res);
	}
	/**
	 * 顺序好
	 * @return String
	 */
	public String getTicke_no() {
		return ((String) getAttrVal("Ticke_no"));
	}	
	/**
	 * 顺序好
	 * @param Ticke_no
	 */
	public void setTicke_no(String Ticke_no) {
		setAttrVal("Ticke_no", Ticke_no);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	/**
	 * 科室编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 医院编码
	 * @return String
	 */
	public String getCode_hospital() {
		return ((String) getAttrVal("Code_hospital"));
	}	
	/**
	 * 医院编码
	 * @param Code_hospital
	 */
	public void setCode_hospital(String Code_hospital) {
		setAttrVal("Code_hospital", Code_hospital);
	}
	/**
	 * 医院名称
	 * @return String
	 */
	public String getName_hospital() {
		return ((String) getAttrVal("Name_hospital"));
	}	
	/**
	 * 医院名称
	 * @param Name_hospital
	 */
	public void setName_hospital(String Name_hospital) {
		setAttrVal("Name_hospital", Name_hospital);
	}
	/**
	 * 开始时间
	 * @return String
	 */
	public String getDt_b() {
		return ((String) getAttrVal("Dt_b"));
	}	
	/**
	 * 开始时间
	 * @param Dt_b
	 */
	public void setDt_b(String Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 结束时间
	 * @return String
	 */
	public String getDt_e() {
		return ((String) getAttrVal("Dt_e"));
	}	
	/**
	 * 结束时间
	 * @param Dt_e
	 */
	public void setDt_e(String Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 建议就诊时间
	 * @return String
	 */
	public String getSuggest_time() {
		return ((String) getAttrVal("Suggest_time"));
	}	
	/**
	 * 建议就诊时间
	 * @param Suggest_time
	 */
	public void setSuggest_time(String Suggest_time) {
		setAttrVal("Suggest_time", Suggest_time);
	}
	/**
	 * 医保编码
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 医保编码
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 医保名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}	
	/**
	 * 医保名称
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 就诊地址
	 * @return String
	 */
	public String getAddress_ent() {
		return ((String) getAttrVal("Address_ent"));
	}	
	/**
	 * 就诊地址
	 * @param Address_ent
	 */
	public void setAddress_ent(String Address_ent) {
		setAttrVal("Address_ent", Address_ent);
	}
	/**
	 * 总费用
	 * @return String
	 */
	public String getAmt_total() {
		return ((String) getAttrVal("Amt_total"));
	}	
	/**
	 * 总费用
	 * @param Amt_total
	 */
	public void setAmt_total(String Amt_total) {
		setAttrVal("Amt_total", Amt_total);
	}
	/**
	 * 患者自费
	 * @return String
	 */
	public String getAmt_pat() {
		return ((String) getAttrVal("Amt_pat"));
	}	
	/**
	 * 患者自费
	 * @param Amt_pat
	 */
	public void setAmt_pat(String Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 预交金余额
	 * @return String
	 */
	public String getBalance() {
		return ((String) getAttrVal("Balance"));
	}	
	/**
	 * 预交金余额
	 * @param Balance
	 */
	public void setBalance(String Balance) {
		setAttrVal("Balance", Balance);
	}
	/**
	 * 预约人员编码
	 * @return String
	 */
	public String getCode_aptopera() {
		return ((String) getAttrVal("Code_aptopera"));
	}	
	/**
	 * 预约人员编码
	 * @param Code_aptopera
	 */
	public void setCode_aptopera(String Code_aptopera) {
		setAttrVal("Code_aptopera", Code_aptopera);
	}
	/**
	 * 预约人员名称
	 * @return String
	 */
	public String getName_aptopera() {
		return ((String) getAttrVal("Name_aptopera"));
	}	
	/**
	 * 预约人员名称
	 * @param Name_aptopera
	 */
	public void setName_aptopera(String Name_aptopera) {
		setAttrVal("Name_aptopera", Name_aptopera);
	}
	/**
	 * 加号标志
	 * @return String
	 */
	public String getFg_add() {
		return ((String) getAttrVal("Fg_add"));
	}	
	/**
	 * 加号标志
	 * @param Fg_add
	 */
	public void setFg_add(String Fg_add) {
		setAttrVal("Fg_add", Fg_add);
	}
	/**
	 * 预约渠道
	 * @return String
	 */
	public String getApt_chl() {
		return ((String) getAttrVal("Apt_chl"));
	}	
	/**
	 * 预约渠道
	 * @param Apt_chl
	 */
	public void setApt_chl(String Apt_chl) {
		setAttrVal("Apt_chl", Apt_chl);
	}
	/**
	 * 午别编码
	 * @return String
	 */
	public String getCode_dayslottp() {
		return ((String) getAttrVal("Code_dayslottp"));
	}	
	/**
	 * 午别编码
	 * @param Code_dayslottp
	 */
	public void setCode_dayslottp(String Code_dayslottp) {
		setAttrVal("Code_dayslottp", Code_dayslottp);
	}
	/**
	 * 午别名称
	 * @return String
	 */
	public String getName_dayslottp() {
		return ((String) getAttrVal("Name_dayslottp"));
	}	
	/**
	 * 午别名称
	 * @param Name_dayslottp
	 */
	public void setName_dayslottp(String Name_dayslottp) {
		setAttrVal("Name_dayslottp", Name_dayslottp);
	}
}