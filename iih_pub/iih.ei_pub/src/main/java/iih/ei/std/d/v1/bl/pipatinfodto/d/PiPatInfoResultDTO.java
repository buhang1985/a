package iih.ei.std.d.v1.bl.pipatinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者信息查询出参 DTO数据 
 * 
 */
public class PiPatInfoResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 证件类型
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}	
	/**
	 * 证件类型
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getCode_idnum() {
		return ((String) getAttrVal("Code_idnum"));
	}	
	/**
	 * 证件号码
	 * @param Code_idnum
	 */
	public void setCode_idnum(String Code_idnum) {
		setAttrVal("Code_idnum", Code_idnum);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	/**
	 * 电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}	
	/**
	 * 就诊类型
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	 * 就诊卡号
	 * @return String
	 */
	public String getCode_card() {
		return ((String) getAttrVal("Code_card"));
	}	
	/**
	 * 就诊卡号
	 * @param Code_card
	 */
	public void setCode_card(String Code_card) {
		setAttrVal("Code_card", Code_card);
	}
	/**
	 * 就诊卡状态 0空白1在用2挂失3注销
	 * @return String
	 */
	public String getEu_card() {
		return ((String) getAttrVal("Eu_card"));
	}	
	/**
	 * 就诊卡状态 0空白1在用2挂失3注销
	 * @param Eu_card
	 */
	public void setEu_card(String Eu_card) {
		setAttrVal("Eu_card", Eu_card);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 门诊就诊次数
	 * @return String
	 */
	public String getTimes_op() {
		return ((String) getAttrVal("Times_op"));
	}	
	/**
	 * 门诊就诊次数
	 * @param Times_op
	 */
	public void setTimes_op(String Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 门诊最后就诊日期
	 * @return String
	 */
	public String getDt_op_end() {
		return ((String) getAttrVal("Dt_op_end"));
	}	
	/**
	 * 门诊最后就诊日期
	 * @param Dt_op_end
	 */
	public void setDt_op_end(String Dt_op_end) {
		setAttrVal("Dt_op_end", Dt_op_end);
	}
	/**
	 * 门诊病案编号
	 * @return String
	 */
	public String getCode_amr_op() {
		return ((String) getAttrVal("Code_amr_op"));
	}	
	/**
	 * 门诊病案编号
	 * @param Code_amr_op
	 */
	public void setCode_amr_op(String Code_amr_op) {
		setAttrVal("Code_amr_op", Code_amr_op);
	}
	/**
	 * 住院就诊次数
	 * @return String
	 */
	public String getTimes_ip() {
		return ((String) getAttrVal("Times_ip"));
	}	
	/**
	 * 住院就诊次数
	 * @param Times_ip
	 */
	public void setTimes_ip(String Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 患者性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
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
	 * @return String
	 */
	public String getDt_birth() {
		return ((String) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(String Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 病人年龄字符串
	 * @return String
	 */
	public String getPat_agestr() {
		return ((String) getAttrVal("Pat_agestr"));
	}	
	/**
	 * 病人年龄字符串
	 * @param Pat_agestr
	 */
	public void setPat_agestr(String Pat_agestr) {
		setAttrVal("Pat_agestr", Pat_agestr);
	}
	/**
	 * 出生地
	 * @return String
	 */
	public String getAddr_birth() {
		return ((String) getAttrVal("Addr_birth"));
	}	
	/**
	 * 出生地
	 * @param Addr_birth
	 */
	public void setAddr_birth(String Addr_birth) {
		setAttrVal("Addr_birth", Addr_birth);
	}
	/**
	 * 家庭住址
	 * @return String
	 */
	public String getAddr_family() {
		return ((String) getAttrVal("Addr_family"));
	}	
	/**
	 * 家庭住址
	 * @param Addr_family
	 */
	public void setAddr_family(String Addr_family) {
		setAttrVal("Addr_family", Addr_family);
	}
	/**
	 * 民族编码
	 * @return String
	 */
	public String getCode_nation() {
		return ((String) getAttrVal("Code_nation"));
	}	
	/**
	 * 民族编码
	 * @param Code_nation
	 */
	public void setCode_nation(String Code_nation) {
		setAttrVal("Code_nation", Code_nation);
	}
	/**
	 * 婚姻状况
	 * @return String
	 */
	public String getCode_marry() {
		return ((String) getAttrVal("Code_marry"));
	}	
	/**
	 * 婚姻状况
	 * @param Code_marry
	 */
	public void setCode_marry(String Code_marry) {
		setAttrVal("Code_marry", Code_marry);
	}
	/**
	 * 保险公司
	 * @return String
	 */
	public String getCode_insur() {
		return ((String) getAttrVal("Code_insur"));
	}	
	/**
	 * 保险公司
	 * @param Code_insur
	 */
	public void setCode_insur(String Code_insur) {
		setAttrVal("Code_insur", Code_insur);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getCode_occu() {
		return ((String) getAttrVal("Code_occu"));
	}	
	/**
	 * 职业
	 * @param Code_occu
	 */
	public void setCode_occu(String Code_occu) {
		setAttrVal("Code_occu", Code_occu);
	}
	/**
	 * 家庭住址的街道
	 * @return String
	 */
	public String getHomestreet() {
		return ((String) getAttrVal("Homestreet"));
	}	
	/**
	 * 家庭住址的街道
	 * @param Homestreet
	 */
	public void setHomestreet(String Homestreet) {
		setAttrVal("Homestreet", Homestreet);
	}
	/**
	 * 家庭电话
	 * @return String
	 */
	public String getHometel() {
		return ((String) getAttrVal("Hometel"));
	}	
	/**
	 * 家庭电话
	 * @param Hometel
	 */
	public void setHometel(String Hometel) {
		setAttrVal("Hometel", Hometel);
	}
	/**
	 * 邮编
	 * @return String
	 */
	public String getHomezip() {
		return ((String) getAttrVal("Homezip"));
	}	
	/**
	 * 邮编
	 * @param Homezip
	 */
	public void setHomezip(String Homezip) {
		setAttrVal("Homezip", Homezip);
	}
	/**
	 * 现住址地区
	 * @return String
	 */
	public String getNowhomedistrict() {
		return ((String) getAttrVal("Nowhomedistrict"));
	}	
	/**
	 * 现住址地区
	 * @param Nowhomedistrict
	 */
	public void setNowhomedistrict(String Nowhomedistrict) {
		setAttrVal("Nowhomedistrict", Nowhomedistrict);
	}
	/**
	 * 现居住地地址
	 * @return String
	 */
	public String getAddr_nowhome() {
		return ((String) getAttrVal("Addr_nowhome"));
	}	
	/**
	 * 现居住地地址
	 * @param Addr_nowhome
	 */
	public void setAddr_nowhome(String Addr_nowhome) {
		setAttrVal("Addr_nowhome", Addr_nowhome);
	}
	/**
	 * 现居住地电话
	 * @return String
	 */
	public String getTel_nowhome() {
		return ((String) getAttrVal("Tel_nowhome"));
	}	
	/**
	 * 现居住地电话
	 * @param Tel_nowhome
	 */
	public void setTel_nowhome(String Tel_nowhome) {
		setAttrVal("Tel_nowhome", Tel_nowhome);
	}
	/**
	 * 现居住地邮编
	 * @return String
	 */
	public String getZip_nowhome() {
		return ((String) getAttrVal("Zip_nowhome"));
	}	
	/**
	 * 现居住地邮编
	 * @param Zip_nowhome
	 */
	public void setZip_nowhome(String Zip_nowhome) {
		setAttrVal("Zip_nowhome", Zip_nowhome);
	}
	/**
	 * 应通知家属名称
	 * @return String
	 */
	public String getName_relation() {
		return ((String) getAttrVal("Name_relation"));
	}	
	/**
	 * 应通知家属名称
	 * @param Name_relation
	 */
	public void setName_relation(String Name_relation) {
		setAttrVal("Name_relation", Name_relation);
	}
	/**
	 * 应通知家属关系编码
	 * @return String
	 */
	public String getCode_relation() {
		return ((String) getAttrVal("Code_relation"));
	}	
	/**
	 * 应通知家属关系编码
	 * @param Code_relation
	 */
	public void setCode_relation(String Code_relation) {
		setAttrVal("Code_relation", Code_relation);
	}
	/**
	 * 应通知家属地址
	 * @return String
	 */
	public String getAddr_relation() {
		return ((String) getAttrVal("Addr_relation"));
	}	
	/**
	 * 应通知家属地址
	 * @param Addr_relation
	 */
	public void setAddr_relation(String Addr_relation) {
		setAttrVal("Addr_relation", Addr_relation);
	}
	/**
	 * 应通知家属电话
	 * @return String
	 */
	public String getTel_relation() {
		return ((String) getAttrVal("Tel_relation"));
	}	
	/**
	 * 应通知家属电话
	 * @param Tel_relation
	 */
	public void setTel_relation(String Tel_relation) {
		setAttrVal("Tel_relation", Tel_relation);
	}
	/**
	 * 户口地区
	 * @return String
	 */
	public String getRegdistrict() {
		return ((String) getAttrVal("Regdistrict"));
	}	
	/**
	 * 户口地区
	 * @param Regdistrict
	 */
	public void setRegdistrict(String Regdistrict) {
		setAttrVal("Regdistrict", Regdistrict);
	}
	/**
	 * 联系人地区
	 * @return String
	 */
	public String getRelationdistrict() {
		return ((String) getAttrVal("Relationdistrict"));
	}	
	/**
	 * 联系人地区
	 * @param Relationdistrict
	 */
	public void setRelationdistrict(String Relationdistrict) {
		setAttrVal("Relationdistrict", Relationdistrict);
	}
	/**
	 * 单位电话
	 * @return String
	 */
	public String getUnittel() {
		return ((String) getAttrVal("Unittel"));
	}	
	/**
	 * 单位电话
	 * @param Unittel
	 */
	public void setUnittel(String Unittel) {
		setAttrVal("Unittel", Unittel);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getWorkunit() {
		return ((String) getAttrVal("Workunit"));
	}	
	/**
	 * 单位名称
	 * @param Workunit
	 */
	public void setWorkunit(String Workunit) {
		setAttrVal("Workunit", Workunit);
	}
	/**
	 * 单位地区
	 * @return String
	 */
	public String getUnitdistrict() {
		return ((String) getAttrVal("Unitdistrict"));
	}	
	/**
	 * 单位地区
	 * @param Unitdistrict
	 */
	public void setUnitdistrict(String Unitdistrict) {
		setAttrVal("Unitdistrict", Unitdistrict);
	}
	/**
	 * 单位街道地址
	 * @return String
	 */
	public String getAddr_unitstreet() {
		return ((String) getAttrVal("Addr_unitstreet"));
	}	
	/**
	 * 单位街道地址
	 * @param Addr_unitstreet
	 */
	public void setAddr_unitstreet(String Addr_unitstreet) {
		setAttrVal("Addr_unitstreet", Addr_unitstreet);
	}
	/**
	 * 单位邮编
	 * @return String
	 */
	public String getUnitzip() {
		return ((String) getAttrVal("Unitzip"));
	}	
	/**
	 * 单位邮编
	 * @param Unitzip
	 */
	public void setUnitzip(String Unitzip) {
		setAttrVal("Unitzip", Unitzip);
	}
	/**
	 * 病区编码
	 * @return String
	 */
	public String getCode_nur() {
		return ((String) getAttrVal("Code_nur"));
	}	
	/**
	 * 病区编码
	 * @param Code_nur
	 */
	public void setCode_nur(String Code_nur) {
		setAttrVal("Code_nur", Code_nur);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 病区名称
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 患者类型
	 * @return String
	 */
	public String getCode_paticate() {
		return ((String) getAttrVal("Code_paticate"));
	}	
	/**
	 * 患者类型
	 * @param Code_paticate
	 */
	public void setCode_paticate(String Code_paticate) {
		setAttrVal("Code_paticate", Code_paticate);
	}
	/**
	 * 患者类型名称
	 * @return String
	 */
	public String getName_paticate() {
		return ((String) getAttrVal("Name_paticate"));
	}	
	/**
	 * 患者类型名称
	 * @param Name_paticate
	 */
	public void setName_paticate(String Name_paticate) {
		setAttrVal("Name_paticate", Name_paticate);
	}
	/**
	 * 当前住院预交金总额
	 * @return String
	 */
	public String getAmt_ipprepay() {
		return ((String) getAttrVal("Amt_ipprepay"));
	}	
	/**
	 * 当前住院预交金总额
	 * @param Amt_ipprepay
	 */
	public void setAmt_ipprepay(String Amt_ipprepay) {
		setAttrVal("Amt_ipprepay", Amt_ipprepay);
	}
	/**
	 * 当前住院预交金余额
	 * @return String
	 */
	public String getAmt_ipbalance() {
		return ((String) getAttrVal("Amt_ipbalance"));
	}	
	/**
	 * 当前住院预交金余额
	 * @param Amt_ipbalance
	 */
	public void setAmt_ipbalance(String Amt_ipbalance) {
		setAttrVal("Amt_ipbalance", Amt_ipbalance);
	}
	/**
	 * 门诊账户余额
	 * @return String
	 */
	public String getAmt_opbalance() {
		return ((String) getAttrVal("Amt_opbalance"));
	}	
	/**
	 * 门诊账户余额
	 * @param Amt_opbalance
	 */
	public void setAmt_opbalance(String Amt_opbalance) {
		setAttrVal("Amt_opbalance", Amt_opbalance);
	}
	/**
	 * 血型
	 * @return String
	 */
	public String getName_abo() {
		return ((String) getAttrVal("Name_abo"));
	}	
	/**
	 * 血型
	 * @param Name_abo
	 */
	public void setName_abo(String Name_abo) {
		setAttrVal("Name_abo", Name_abo);
	}
	/**
	 * RH血型 +,- 表示阴性、阳性
	 * @return String
	 */
	public String getName_rh() {
		return ((String) getAttrVal("Name_rh"));
	}	
	/**
	 * RH血型 +,- 表示阴性、阳性
	 * @param Name_rh
	 */
	public void setName_rh(String Name_rh) {
		setAttrVal("Name_rh", Name_rh);
	}
	/**
	 * 西医诊断编码
	 * @return String
	 */
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}	
	/**
	 * 西医诊断编码
	 * @param Code_di
	 */
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
	}
	/**
	 * 西医诊断名称
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	/**
	 * 西医诊断名称
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 手术诊断编码
	 * @return String
	 */
	public String getCode_operatedi() {
		return ((String) getAttrVal("Code_operatedi"));
	}	
	/**
	 * 手术诊断编码
	 * @param Code_operatedi
	 */
	public void setCode_operatedi(String Code_operatedi) {
		setAttrVal("Code_operatedi", Code_operatedi);
	}
	/**
	 * 手术诊断名称
	 * @return String
	 */
	public String getName_operatedi() {
		return ((String) getAttrVal("Name_operatedi"));
	}	
	/**
	 * 手术诊断名称
	 * @param Name_operatedi
	 */
	public void setName_operatedi(String Name_operatedi) {
		setAttrVal("Name_operatedi", Name_operatedi);
	}
	/**
	 * 既往有输血史
	 * @return String
	 */
	public String getPatbtinfo() {
		return ((String) getAttrVal("Patbtinfo"));
	}	
	/**
	 * 既往有输血史
	 * @param Patbtinfo
	 */
	public void setPatbtinfo(String Patbtinfo) {
		setAttrVal("Patbtinfo", Patbtinfo);
	}
	/**
	 * 既往有妊娠史 
	 * @return String
	 */
	public String getPatcbhinfo() {
		return ((String) getAttrVal("Patcbhinfo"));
	}	
	/**
	 * 既往有妊娠史 
	 * @param Patcbhinfo
	 */
	public void setPatcbhinfo(String Patcbhinfo) {
		setAttrVal("Patcbhinfo", Patcbhinfo);
	}
	/**
	 * 育次数 数量表示
	 * @return String
	 */
	public String getCount_patcbh() {
		return ((String) getAttrVal("Count_patcbh"));
	}	
	/**
	 * 育次数 数量表示
	 * @param Count_patcbh
	 */
	public void setCount_patcbh(String Count_patcbh) {
		setAttrVal("Count_patcbh", Count_patcbh);
	}
	/**
	 * 生产次数 数量表示
	 * @return String
	 */
	public String getCount_givebirth() {
		return ((String) getAttrVal("Count_givebirth"));
	}	
	/**
	 * 生产次数 数量表示
	 * @param Count_givebirth
	 */
	public void setCount_givebirth(String Count_givebirth) {
		setAttrVal("Count_givebirth", Count_givebirth);
	}
	/**
	 * 入科时间
	 * @return String
	 */
	public String getDt_acpt() {
		return ((String) getAttrVal("Dt_acpt"));
	}	
	/**
	 * 入科时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(String Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 住院状态1:在院 2:出院
	 * @return String
	 */
	public String getStatus_ip() {
		return ((String) getAttrVal("Status_ip"));
	}	
	/**
	 * 住院状态1:在院 2:出院
	 * @param Status_ip
	 */
	public void setStatus_ip(String Status_ip) {
		setAttrVal("Status_ip", Status_ip);
	}
}