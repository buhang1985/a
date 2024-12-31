package iih.pi.reg.wsstd.bean.output.patinfo.sub;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 患者信息查询出参明细
 * 
 * @author shaokx 2019/01/09
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultInfoGetPatInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	// 居民身份证
	@XmlElement(name = "name_idtp")
	private String name_idtp;

	// 居民身份证号码
	@XmlElement(name = "id_code")
	private String id_code;

	// 电话
	@XmlElement(name = "tel")
	private String tel;

	// 门诊00 住院10 就诊类型 门诊，急诊，住院，体检
	@XmlElement(name = "code_entp")
	private String code_entp;

	// 病人唯一号 内部的唯一号，病人id
	@XmlElement(name = "code_pat")
	private String code_pat;

	// 健康卡号码（就诊卡号）
	@XmlElement(name = "code_card")
	private String code_card;

	// 就诊卡状态 0空白 1在用 2挂失 3注销
	@XmlElement(name = "eu_card")
	private Integer eu_card;

	// 就诊编码
	@XmlElement(name = "code_ent")
	private String code_ent;

	// 用于区分同一就诊卡号多次门诊 门诊次数
	@XmlElement(name = "oep_times")
	private String oep_times;

	// 门诊最后就诊日期
	@XmlElement(name = "dt_oep_date")
	private String dt_oep_date;

	// 门诊病案编号
	@XmlElement(name = "code_amr_oep")
	private String code_amr_oep;

	// 用于区分同一住院号多次住院 住院次数
	@XmlElement(name = "ip_times")
	private String ip_times;

	// 住院号
	@XmlElement(name = "code_amr_ip")
	private String code_amr_ip;

	// 患者姓名
	@XmlElement(name = "name_pat")
	private String name_pat;

	// 患者性别
	@XmlElement(name = "name_sex")
	private String name_sex;

	// 1男，2女，3未知
	@XmlElement(name = "sd_sex")
	private String sd_sex;

	// 出生日期
	@XmlElement(name = "dt_birth")
	private String dt_birth;

	// 病人年龄字串 如：1岁，12月23天，这样的格式都支持，优先使用该字段
	@XmlElement(name = "pat_agestr")
	private String pat_agestr;

	// 出生地
	@XmlElement(name = "birth_place")
	private String birth_place;

	// 家庭住址的地区
	@XmlElement(name = "region")
	private String region;

	// 民族
	@XmlElement(name = "nationcode")
	private String nationcode;

	// 婚姻状况
	@XmlElement(name = "marrycode")
	private String marrycode;

	// 保险公司1
	@XmlElement(name = "insur1code")
	private String insur1code;

	// 职业
	@XmlElement(name = "occupationcode")
	private String occupationcode;
	
	// 患者标签名称
	@XmlElement(name = "pat_tag")
	private String pat_tag;
	
	// 患者标签编码
	@XmlElement(name = "sd_pat_tag")
	private String sd_pat_tag;

	// 单位名称
	@XmlElement(name = "employername")
	private String employername;

	// 单位的电话
	@XmlElement(name = "employertel")
	private String employertel;

	// 家庭住址的街道
	@XmlElement(name = "homestreet")
	private String homestreet;

	// 家庭电话
	@XmlElement(name = "hometel")
	private String hometel;

	// 邮编
	@XmlElement(name = "homezipcode")
	private String homezipcode;

	// 现居住地地址
	@XmlElement(name = "tempstreet")
	private String tempstreet;

	// 现居住地电话
	@XmlElement(name = "temptel")
	private String temptel;

	// 现居住地邮编
	@XmlElement(name = "tempzipcode")
	private String tempzipcode;

	// 应通知家属名称
	@XmlElement(name = "relationname")
	private String relationname;

	// 应通知家属关系编码
	@XmlElement(name = "relationcode")
	private String relationcode;

	// 应通知家属地址
	@XmlElement(name = "relationstreet")
	private String relationstreet;

	// 应通知家属电话
	@XmlElement(name = "relationtel")
	private String relationtel;

	// 户口地区
	@XmlElement(name = "homedistrict")
	private String homedistrict;

	// 现住址地区
	@XmlElement(name = "tempdistrict")
	private String tempdistrict;

	// 联系人地区
	@XmlElement(name = "relationdistrict")
	private String relationdistrict;

	// 单位地区
	@XmlElement(name = "employerdistrict")
	private String employerdistrict;

	// 单位街道地址
	@XmlElement(name = "employerstreet")
	private String employerstreet;

	// 单位邮编
	@XmlElement(name = "employerzipcode")
	private String employerzipcode;

	// 病区编码
	@XmlElement(name = "code_ward")
	private String code_ward;

	// 病区名称
	@XmlElement(name = "name_ward")
	private String name_ward;

	// 科室编码
	@XmlElement(name = "code_dep")
	private String code_dep;

	// 科室名称
	@XmlElement(name = "name_dep")
	private String name_dep;

	// 床位
	@XmlElement(name = "no_bed")
	private String no_bed;

	// 医保类型
	@XmlElement(name = "sd_patca")
	private String sd_patca;

	// 当前住院预交金总额
	@XmlElement(name = "ip_prepay")
	private String ip_prepay;

	// 当前住院预交金余额
	@XmlElement(name = "ip_balance")
	private String ip_balance;

	// 门诊账户余额
	@XmlElement(name = "oep_balance")
	private String oep_balance;

	// 收费类型（自费、医保等）
	@XmlElement(name = "name_patca")
	private String name_patca;

	// 病人身高
	@XmlElement(name = "pat_height")
	private String pat_height;

	// 病人体重
	@XmlElement(name = "pat_weight")
	private String pat_weight;

	// ABO血型 A/B/AB/O
	@XmlElement(name = "name_abo")
	private String name_abo;

	// RH血型 +,- 表示阴性、阳性
	@XmlElement(name = "name_rh")
	private String name_rh;

	// 西医诊断编码,从临床数据获取
	@XmlElement(name = "code_di")
	private String code_di;

	// 手术诊断编码,从临床数据获取
	@XmlElement(name = "operate")
	private String operate;

	// 手术诊断名称
	@XmlElement(name = "name_op")
	private String name_op;

	// 西医诊断名称
	@XmlElement(name = "name_di")
	private String name_di;

	// 既往有输血史 Y是 N否
	@XmlElement(name = "bld_transfused")
	private String bld_transfused;

	// 既往有妊娠史 Y是 N否
	@XmlElement(name = "bld_pregnancyed")
	private String bld_pregnancyed;

	// 育次数 数量表示
	@XmlElement(name = "bld_pregcount")
	private String bld_pregcount;

	// 生产次数 数量表示
	@XmlElement(name = "bld_birthcount")
	private String bld_birthcount;

	// 入科时间
	@XmlElement(name = "dt_acpt")
	private String dt_acpt;
	
	// 住院状态 1:在院 2:出院
	@XmlElement(name = "status_ip")
	private String status_ip;
	
	//患者标签信息
	@XmlElementWrapper(name="pat_tags")
	@XmlElement(name = "pat_tag")
	private List<WsResultPatTagInfo> patTagList;

	
	public List<WsResultPatTagInfo> getPatTagList() {
		return patTagList;
	}

	public void setPatTagList(List<WsResultPatTagInfo> patTagList) {
		this.patTagList = patTagList;
	}

	public String getPat_tag() {
		return pat_tag;
	}

	public void setPat_tag(String pat_tag) {
		this.pat_tag = pat_tag;
	}

	public String getSd_pat_tag() {
		return sd_pat_tag;
	}

	public void setSd_pat_tag(String sd_pat_tag) {
		this.sd_pat_tag = sd_pat_tag;
	}

	public String getStatus_ip() {
		return status_ip;
	}

	public void setStatus_ip(String status_ip) {
		this.status_ip = status_ip;
	}

	public String getName_idtp() {
		return name_idtp;
	}

	public void setName_idtp(String name_idtp) {
		this.name_idtp = name_idtp;
	}

	public String getId_code() {
		return id_code;
	}

	public void setId_code(String id_code) {
		this.id_code = id_code;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCode_entp() {
		return code_entp;
	}

	public void setCode_entp(String code_entp) {
		this.code_entp = code_entp;
	}

	public String getCode_pat() {
		return code_pat;
	}

	public void setCode_pat(String code_pat) {
		this.code_pat = code_pat;
	}

	public String getCode_card() {
		return code_card;
	}

	public void setCode_card(String code_card) {
		this.code_card = code_card;
	}

	public String getCode_ent() {
		return code_ent;
	}

	public void setCode_ent(String code_ent) {
		this.code_ent = code_ent;
	}

	public String getOep_times() {
		return oep_times;
	}

	public void setOep_times(String oep_times) {
		this.oep_times = oep_times;
	}

	public String getDt_oep_date() {
		return dt_oep_date;
	}

	public void setDt_oep_date(String dt_oep_date) {
		this.dt_oep_date = dt_oep_date;
	}

	public String getCode_amr_oep() {
		return code_amr_oep;
	}

	public void setCode_amr_oep(String code_amr_oep) {
		this.code_amr_oep = code_amr_oep;
	}

	public String getIp_times() {
		return ip_times;
	}

	public void setIp_times(String ip_times) {
		this.ip_times = ip_times;
	}

	public String getCode_amr_ip() {
		return code_amr_ip;
	}

	public void setCode_amr_ip(String code_amr_ip) {
		this.code_amr_ip = code_amr_ip;
	}

	public String getName_pat() {
		return name_pat;
	}

	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}

	public String getName_sex() {
		return name_sex;
	}

	public void setName_sex(String name_sex) {
		this.name_sex = name_sex;
	}

	public String getSd_sex() {
		return sd_sex;
	}

	public void setSd_sex(String sd_sex) {
		this.sd_sex = sd_sex;
	}

	public String getDt_birth() {
		return dt_birth;
	}

	public void setDt_birth(String dt_birth) {
		this.dt_birth = dt_birth;
	}

	public String getPat_agestr() {
		return pat_agestr;
	}

	public void setPat_agestr(String pat_agestr) {
		this.pat_agestr = pat_agestr;
	}

	public String getBirth_place() {
		return birth_place;
	}

	public void setBirth_place(String birth_place) {
		this.birth_place = birth_place;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getNationcode() {
		return nationcode;
	}

	public void setNationcode(String nationcode) {
		this.nationcode = nationcode;
	}

	public String getMarrycode() {
		return marrycode;
	}

	public void setMarrycode(String marrycode) {
		this.marrycode = marrycode;
	}

	public String getInsur1code() {
		return insur1code;
	}

	public void setInsur1code(String insur1code) {
		this.insur1code = insur1code;
	}

	public String getOccupationcode() {
		return occupationcode;
	}

	public void setOccupationcode(String occupationcode) {
		this.occupationcode = occupationcode;
	}

	public String getEmployername() {
		return employername;
	}

	public void setEmployername(String employername) {
		this.employername = employername;
	}

	public String getEmployertel() {
		return employertel;
	}

	public void setEmployertel(String employertel) {
		this.employertel = employertel;
	}

	public String getHomestreet() {
		return homestreet;
	}

	public void setHomestreet(String homestreet) {
		this.homestreet = homestreet;
	}

	public String getHometel() {
		return hometel;
	}

	public void setHometel(String hometel) {
		this.hometel = hometel;
	}

	public String getHomezipcode() {
		return homezipcode;
	}

	public void setHomezipcode(String homezipcode) {
		this.homezipcode = homezipcode;
	}

	public String getTempstreet() {
		return tempstreet;
	}

	public void setTempstreet(String tempstreet) {
		this.tempstreet = tempstreet;
	}

	public String getTemptel() {
		return temptel;
	}

	public void setTemptel(String temptel) {
		this.temptel = temptel;
	}

	public String getTempzipcode() {
		return tempzipcode;
	}

	public void setTempzipcode(String tempzipcode) {
		this.tempzipcode = tempzipcode;
	}

	public String getRelationname() {
		return relationname;
	}

	public void setRelationname(String relationname) {
		this.relationname = relationname;
	}

	public String getRelationcode() {
		return relationcode;
	}

	public void setRelationcode(String relationcode) {
		this.relationcode = relationcode;
	}

	public String getRelationstreet() {
		return relationstreet;
	}

	public void setRelationstreet(String relationstreet) {
		this.relationstreet = relationstreet;
	}

	public String getRelationtel() {
		return relationtel;
	}

	public void setRelationtel(String relationtel) {
		this.relationtel = relationtel;
	}

	public String getHomedistrict() {
		return homedistrict;
	}

	public void setHomedistrict(String homedistrict) {
		this.homedistrict = homedistrict;
	}

	public String getTempdistrict() {
		return tempdistrict;
	}

	public void setTempdistrict(String tempdistrict) {
		this.tempdistrict = tempdistrict;
	}

	public String getRelationdistrict() {
		return relationdistrict;
	}

	public void setRelationdistrict(String relationdistrict) {
		this.relationdistrict = relationdistrict;
	}

	public String getEmployerdistrict() {
		return employerdistrict;
	}

	public void setEmployerdistrict(String employerdistrict) {
		this.employerdistrict = employerdistrict;
	}

	public String getEmployerstreet() {
		return employerstreet;
	}

	public void setEmployerstreet(String employerstreet) {
		this.employerstreet = employerstreet;
	}

	public String getEmployerzipcode() {
		return employerzipcode;
	}

	public void setEmployerzipcode(String employerzipcode) {
		this.employerzipcode = employerzipcode;
	}

	public String getCode_ward() {
		return code_ward;
	}

	public void setCode_ward(String code_ward) {
		this.code_ward = code_ward;
	}

	public String getName_ward() {
		return name_ward;
	}

	public void setName_ward(String name_ward) {
		this.name_ward = name_ward;
	}

	public String getCode_dep() {
		return code_dep;
	}

	public void setCode_dep(String code_dep) {
		this.code_dep = code_dep;
	}

	public String getName_dep() {
		return name_dep;
	}

	public void setName_dep(String name_dep) {
		this.name_dep = name_dep;
	}

	public String getNo_bed() {
		return no_bed;
	}

	public void setNo_bed(String no_bed) {
		this.no_bed = no_bed;
	}

	public String getSd_patca() {
		return sd_patca;
	}

	public void setSd_patca(String sd_patca) {
		this.sd_patca = sd_patca;
	}

	public String getIp_prepay() {
		return ip_prepay;
	}

	public void setIp_prepay(String ip_prepay) {
		this.ip_prepay = ip_prepay;
	}

	public String getIp_balance() {
		return ip_balance;
	}

	public void setIp_balance(String ip_balance) {
		this.ip_balance = ip_balance;
	}

	public String getOep_balance() {
		return oep_balance;
	}

	public void setOep_balance(String oep_balance) {
		this.oep_balance = oep_balance;
	}

	public String getName_patca() {
		return name_patca;
	}

	public void setName_patca(String name_patca) {
		this.name_patca = name_patca;
	}

	public String getPat_height() {
		return pat_height;
	}

	public void setPat_height(String pat_height) {
		this.pat_height = pat_height;
	}

	public String getPat_weight() {
		return pat_weight;
	}

	public void setPat_weight(String pat_weight) {
		this.pat_weight = pat_weight;
	}

	public String getName_abo() {
		return name_abo;
	}

	public void setName_abo(String name_abo) {
		this.name_abo = name_abo;
	}

	public String getName_rh() {
		return name_rh;
	}

	public void setName_rh(String name_rh) {
		this.name_rh = name_rh;
	}

	public String getCode_di() {
		return code_di;
	}

	public void setCode_di(String code_di) {
		this.code_di = code_di;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public String getName_di() {
		return name_di;
	}

	public void setName_di(String name_di) {
		this.name_di = name_di;
	}

	public String getBld_transfused() {
		return bld_transfused;
	}

	public void setBld_transfused(String bld_transfused) {
		this.bld_transfused = bld_transfused;
	}

	public String getBld_pregnancyed() {
		return bld_pregnancyed;
	}

	public void setBld_pregnancyed(String bld_pregnancyed) {
		this.bld_pregnancyed = bld_pregnancyed;
	}

	public String getBld_pregcount() {
		return bld_pregcount;
	}

	public void setBld_pregcount(String bld_pregcount) {
		this.bld_pregcount = bld_pregcount;
	}

	public String getBld_birthcount() {
		return bld_birthcount;
	}

	public void setBld_birthcount(String bld_birthcount) {
		this.bld_birthcount = bld_birthcount;
	}

	public String getDt_acpt() {
		return dt_acpt;
	}

	public void setDt_acpt(String dt_acpt) {
		this.dt_acpt = dt_acpt;
	}

	public String getName_op() {
		return name_op;
	}

	public void setName_op(String name_op) {
		this.name_op = name_op;
	}

	public Integer getEu_card() {
		return eu_card;
	}

	public void setEu_card(Integer eu_card) {
		this.eu_card = eu_card;
	}

}
