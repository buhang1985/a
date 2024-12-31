package iih.mp.nr.dto;

import java.util.List;

import xap.mw.coreitf.d.FDate;

/**
 * 治疗单DTO
 * 
 * @author hjh
 *
 */
public class CureListDTO {
	/**
	 * 分组编码
	 */
	private String code;
	/** 患者信息 */
	private String name_grp;
	/** 就诊ID */
	private String id_ent;
	/** 床号 */
	private String name_bed;
	/** 住院号 */
	private String code_amr_ip;
	/** 姓名 */
	private String name_pat;
	/** 性别 */
	private String name_sex;
	/** 医嘱ID */
	private String id_or;
	/** 执行计划ID */
	private String id_or_pr;
	/** 医嘱内容 */
	private String content_or;
	/** 项目名称 */
	private String name;
	/** 规格 */
	private String spec;
	/** 嘱托 */
	private String des_or;
	/** 剂量 */
	private String quan_medu;
	/** 剂量单位 */
	private String name_medu;
	/** 用量显示 */
	private String name_quan;
	/** 用量分子 */
	private String quan_num_base;
	/** 用量分母 */
	private String quan_den_base;
	/** 包装单位 */
	private String name_mm_medu;
	/** 服务类型 */
	private String sd_srvtp;
	/** 用法 */
	private String id_route;
	/** 给药途径 */
	private String name_route;
	/** 用法编码 */
	private String code_route;
	/** 频次 */
	private String name_freq;
	/** 执行时间 */
	private String dt_mp_plan;
	/** 医嘱序号 **/
	private String ord_sortno;
	/** 出生日期 **/
	private FDate dt_birth;
	/** 年龄 **/
	private String Age;
	/** 医嘱开立时间 **/
	private String dt_effe;
	/** 医嘱分类顺序 **/
	private String seqno;

	/**
	 * 信息子集合
	 */
	private List<CureListDTO> childList;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId_ent() {
		return id_ent;
	}

	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}

	public String getName_bed() {
		return name_bed;
	}

	public void setName_bed(String name_bed) {
		this.name_bed = name_bed;
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

	public String getDt_effe() {
		return this.dt_effe;
	}

	public void setDt_effe(String dt_effe) {
		this.dt_effe = dt_effe;
	}

	public String getSeqno() {
		return this.seqno;
	}

	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}

	public String getCode_route() {
		return code_route;
	}

	public void setCode_route(String code_route) {
		this.code_route = code_route;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public FDate getDt_birth() {
		return dt_birth;
	}

	public void setDt_birth(FDate dt_birth) {
		this.dt_birth = dt_birth;
	}

	public String getOrd_sortno() {
		return ord_sortno;
	}

	public void setOrd_sortno(String ord_sortno) {
		this.ord_sortno = ord_sortno;
	}

	/** getter and setter */

	public String getName_grp() {
		return this.name_grp;
	}

	public void setName_grp(String name_grp) {
		this.name_grp = name_grp;
	}

	public String getId_or() {
		return this.id_or;
	}

	public void setId_or(String id_or) {
		this.id_or = id_or;
	}

	public String getId_or_pr() {
		return this.id_or_pr;
	}

	public void setId_or_pr(String id_or_pr) {
		this.id_or_pr = id_or_pr;
	}

	public String getContent_or() {
		return this.content_or;
	}

	public void setContent_or(String content_or) {
		this.content_or = content_or;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpec() {
		return this.spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getDes_or() {
		return this.des_or;
	}

	public void setDes_or(String des_or) {
		this.des_or = des_or;
	}

	public String getQuan_medu() {
		return this.quan_medu;
	}

	public void setQuan_medu(String quan_medu) {
		this.quan_medu = quan_medu;
	}

	public String getName_medu() {
		return this.name_medu;
	}

	public void setName_medu(String name_medu) {
		this.name_medu = name_medu;
	}

	public String getName_quan() {
		return this.name_quan;
	}

	public void setName_quan(String name_quan) {
		this.name_quan = name_quan;
	}

	public String getQuan_num_base() {
		return this.quan_num_base;
	}

	public void setQuan_num_base(String quan_num_base) {
		this.quan_num_base = quan_num_base;
	}

	public String getQuan_den_base() {
		return this.quan_den_base;
	}

	public void setQuan_den_base(String quan_den_base) {
		this.quan_den_base = quan_den_base;
	}

	public String getName_mm_medu() {
		return this.name_mm_medu;
	}

	public void setName_mm_medu(String name_mm_medu) {
		this.name_mm_medu = name_mm_medu;
	}

	public String getSd_srvtp() {
		return sd_srvtp;
	}

	public void setSd_srvtp(String sd_srvtp) {
		this.sd_srvtp = sd_srvtp;
	}

	public String getId_route() {
		return id_route;
	}

	public void setId_route(String id_route) {
		this.id_route = id_route;
	}

	public String getName_route() {
		return this.name_route;
	}

	public void setName_route(String name_route) {
		this.name_route = name_route;
	}

	public String getName_freq() {
		return this.name_freq;
	}

	public void setName_freq(String name_freq) {
		this.name_freq = name_freq;
	}

	public String getDt_mp_plan() {
		return this.dt_mp_plan;
	}

	public void setDt_mp_plan(String dt_mp_plan) {
		this.dt_mp_plan = dt_mp_plan;
	}

	public List<CureListDTO> getChildList() {
		return childList;
	}

	public void setChildList(List<CureListDTO> childList) {
		this.childList = childList;
	}

}
