package iih.ci.ord.ciordsheet;

import java.io.Serializable;

import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 医嘱单数据DTO
 * @author Young
 *
 */
public class CiOrdSheetDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱单ID
	 * @return String
	 */
	private String id_orprn;
	public String getId_orprn() {
		return this.id_orprn;
	}	
	public void setId_orprn(String id_orprn) {
		this.id_orprn = id_orprn;
	}
	/**
	 * 医嘱单名称
	 * @return String
	 */
	private String name_orprn;
	public String getName_orprn() {
		return name_orprn;
	}	
	public void setName_orprn(String name_orprn) {
		this.name_orprn = name_orprn;
	}
	/**
	 * 机构ID
	 * @return String
	 */
	private String id_org;
	public String getId_org() {
		return this.id_org;
	}	
	public void setId_org(String id_org) {
		this.id_org = id_org;
	}
	/**
	 * 机构名称
	 * @return String
	 */
	private String name_org;
	public String getName_org() {
		return this.name_org;
	}	
	public void setName_org(String name_org) {
		this.name_org = name_org;
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	private String id_en;
	public String getId_en() {
		return this.id_en;
	}	
	public void setId_en(String id_en) {
		this.id_en = id_en;
	}
	/**
	 * 患者
	 * @return String
	 */
	private String name_pat_en;
	public String getName_pat_en() {
		return this.name_pat_en;
	}	
	public void setName_pat_en(String name_pat_en) {
		this.name_pat_en = name_pat_en;
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	private String name_dep_phy;
	public String getName_dep_phy() {
		return this.name_dep_phy;
	}	
	public void setName_dep_phy(String name_dep_phy) {
		this.name_dep_phy = name_dep_phy;
	}
	/**
	 * 就诊病区
	 * @return String
	 */
	private String name_dep_nur;
	public String getName_dep_nur() {
		return this.name_dep_nur;
	}	
	public void setName_dep_nur(String name_dep_nur) {
		this.name_dep_nur = name_dep_nur;
	}
	/**
	 * 床号
	 * @return String
	 */
	private String name_bed;
	public String getName_bed() {
		return this.name_bed;
	}	
	public void setName_bed(String name_bed) {
		this.name_bed = name_bed;
	}
	/**
	 * 住院号
	 * @return String
	 */
	private String code_amr_ip;
	public String getCode_amr_ip() {
		return this.code_amr_ip;
	}	
	public void setCode_amr_ip(String code_amr_ip) {
		this.code_amr_ip = code_amr_ip;
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	private String diag_name;
	public String getDiag_name() {
		return this.diag_name;
	}	
	public void setDiag_name(String diag_name) {
		this.diag_name = diag_name;
	}
	/**
	 * 医嘱ID+服务ID
	 * @return String
	 */
	private String id_orsrv_key;
	public String getId_orsrv_key() {
		return this.id_orsrv_key;
	}	
	public void setId_orsrv_key(String id_orsrv_key) {
		this.id_orsrv_key = id_orsrv_key;
	}
	/**
	 * 医嘱ID
	 * @return String
	 */
	private String id_or;
	public String getId_or() {
		return this.id_or;
	}	
	public void setId_or(String id_or) {
		this.id_or = id_or;
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	private String code_or;
	public String getCode_or() {
		return this.code_or;
	}	
	public void setCode_or(String code_or) {
		this.code_or = code_or;
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	private String sd_srvtp;
	public String getSd_srvtp() {
		return this.sd_srvtp;
	}	
	public void setSd_srvtp(String sd_srvtp) {
		this.sd_srvtp = sd_srvtp;
	}
	/**
	 * 医嘱序号
	 * @return String
	 */
	private String sortno;
	public String getSortno() {
		return this.sortno;
	}	
	public void setSortno(String sortno) {
		this.sortno = sortno;
	}
	/**
	 * 医嘱显示内容拼接
	 * @return String
	 */
	private String name_srv;
	public String getName_srv() {
		return this.name_srv;
	}
	public void setName_srv(String name_srv) {
		this.name_srv = name_srv;
	}
	/**
	 * 打印名称
	 * @return String
	 */
	private String name_prn;
	public String getName_prn() {
		return this.name_prn;
	}
	public void setName_prn(String name_prn) {
		this.name_prn = name_prn;
	}
	/**
	 * 药品名
	 * @return String
	 */
	private String name_mm;
	public String getName_mm() {
		return this.name_mm;
	}
	public void setName_mm(String name_mm) {
		this.name_mm = name_mm;
	}
	/**
	 * 规格
	 * @return String
	 */
	private String spec;
	public String getSpec() {
		return this.spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	/**
	 * 医嘱成组信息
	 * @return String
	 */
	private String content_or_prn;
	public String getContent_or_prn() {
		return this.content_or_prn;
	}	
	public void setContent_or_prn(String content_or_prn) {
		this.content_or_prn = content_or_prn;
	}
	/**
	 * 医嘱生效时间
	 * @return String
	 */
	private String dt_effe;
	public String getDt_effe() {
		return this.dt_effe;
	}	
	public void setDt_effe(String dt_effe) {
		this.dt_effe = dt_effe;
	}
	/**
	 * 医嘱结束时间
	 * @return String
	 */
	private String dt_end;
	public String getDt_end() {
		return this.dt_end;
	}	
	public void setDt_end(String dt_end) {
		this.dt_end = dt_end;
	}
	/**
	 * 医嘱执行时间
	 * @return String
	 */
	private String dt_mp;
	public String getDt_mp() {
		return this.dt_mp;
	}	
	public void setDt_mp(String dt_mp) {
		this.dt_mp = dt_mp;
	}
	/**
	 * 医嘱签署时间
	 * @return String
	 */
	private String dt_sign;
	public String getDt_sign() {
		return this.dt_sign;
	}	
	public void setDt_sign(String dt_sign) {
		this.dt_sign = dt_sign;
	}
	/**
	 * 医嘱作废时间
	 */
	private String dt_canc;
	public String getDt_canc() {
		return this.dt_canc;
	}
	public void setDt_canc(String dt_canc) {
		this.dt_canc = dt_canc;
	}
	/**
	 * 签署医生id
	 */
	private String id_emp_sign;
	public String getId_emp_sign() {
		return this.id_emp_sign;
	}
	public void setId_emp_sign(String id_emp_sign) {
		this.id_emp_sign = id_emp_sign;
	}
	/**
	 * 签署医生
	 * @return String
	 */
	private String name_emp_sign;
	public String getName_emp_sign() {
		return this.name_emp_sign;
	}	
	public void setName_emp_sign(String name_emp_sign) {
		this.name_emp_sign = name_emp_sign;
	}
	/**
	 * 停止医生id
	 */
	private String id_emp_stop;
	public String getId_emp_stop() {
		return this.id_emp_stop;
	}
	public void setId_emp_stop(String id_emp_stop) {
		this.id_emp_stop = id_emp_stop;
	}
	/**
	 * 停止医生
	 * @return String
	 */
	private String name_emp_stop;
	public String getName_emp_stop() {
		return this.name_emp_stop;
	}	
	public void setName_emp_stop(String name_emp_stop) {
		this.name_emp_stop = name_emp_stop;
	}
	/**
	 * 作废医生id
	 */
	private String id_emp_canc;
	public String getId_emp_canc() {
		return this.id_emp_canc;
	}
	public void setId_emp_canc(String id_emp_canc) {
		this.id_emp_canc = id_emp_canc;
	}
	/**
	 * 作废医生
	 * @return String
	 */
	private String name_emp_canc;
	public String getName_emp_canc() {
		return this.name_emp_canc;
	}	
	public void setName_emp_canc(String name_emp_canc) {
		this.name_emp_canc = name_emp_canc;
	}
	/**
	 * 执行人员
	 * @return String
	 */
	private String name_emp_exe;
	public String getName_emp_exe() {
		return this.name_emp_exe;
	}	
	public void setName_emp_exe(String name_emp_exe) {
		this.name_emp_exe = name_emp_exe;
	}
	/**
	 * 剂量
	 * @return String
	 */
	private String quan_medu;
	public String getQuan_medu() {
		return this.quan_medu;
	}
	public void setQuan_medu(String quan_medu) {
		this.quan_medu = quan_medu;
	}
	/**
	 * 剂量单位
	 * @return String
	 */
	private String medu_name;
	public String getMedu_name() {
		return this.medu_name;
	}
	public void setMedu_name(String medu_name) {
		this.medu_name = medu_name;
	}
	/**
	 * 用法
	 * @return String
	 */
	private String route_name;
	public String getRoute_name() {
		return this.route_name;
	}
	public void setRoute_name(String route_name) {
		this.route_name = route_name;
	}
	/**
	 * 用法要求
	 * @return String
	 */
	private String routedes_name;
	public String getRoutedes_name() {
		return this.routedes_name;
	}
	public void setRoutedes_name(String routedes_name) {
		this.routedes_name = routedes_name;
	}
	/**
	 * 频次
	 * @return String
	 */
	private String freq_name;
	public String getFreq_name() {
		return this.freq_name;
	}
	public void setFreq_name(String freq_name) {
		this.freq_name = freq_name;
	}
	/**
	 * 长临标识
	 * @return String
	 */
	private String fg_long;
	public String getFg_long() {
		return this.fg_long;
	}	
	public void setFg_long(String fg_long) {
		this.fg_long = fg_long;
	}
	/**
	 * 服务套标识
	 * @return String
	 */
	private String fg_set;
	public String getFg_set() {
		return this.fg_set;
	}	
	public void setFg_set(String fg_set) {
		this.fg_set = fg_set;
	}
	/**
	 * 自备药标识
	 * @return String
	 */
	private String fg_self;
	public String getFg_self() {
		return this.fg_self;
	}
	public void setFg_self(String fg_self) {
		this.fg_self = fg_self;
	}
	/**
	 * 自定义服务标识
	 * @return String
	 */
	private String fg_selfsrv;
	public String getFg_selfsrv() {
		return this.fg_selfsrv;
	}
	public void setFg_selfsrv(String fg_selfsrv) {
		this.fg_selfsrv = fg_selfsrv;
	}
	/**
	 * 停止确认标识
	 * @return String
	 */
	private String fg_chk_stop;
	public String getFg_chk_stop() {
		return this.fg_chk_stop;
	}
	public void setFg_chk_stop(String fg_chk_stop) {
		this.fg_chk_stop = fg_chk_stop;
	}
	/**
	 * 停止打印标识
	 * @return String
	 */
	private String fg_stop_prn;
	public String getFg_stop_prn() {
		return this.fg_stop_prn;
	}
	public void setFg_stop_prn(String fg_stop_prn) {
		this.fg_stop_prn = fg_stop_prn;
	}
	/**
	 * 作废确认标识
	 * @return String
	 */
	private String fg_chk_canc;
	public String getFg_chk_canc() {
		return this.fg_chk_canc;
	}
	public void setFg_chk_canc(String fg_chk_canc) {
		this.fg_chk_canc = fg_chk_canc;
	}
	/**
	 * 作废打印标识
	 * @return String
	 */
	private String fg_canc_prn;
	public String getFg_canc_prn() {
		return this.fg_canc_prn;
	}
	public void setFg_canc_prn(String fg_canc_prn) {
		this.fg_canc_prn = fg_canc_prn;
	}
	/**
	 * 草药付数
	 * @return String
	 */
	private String orders;
	public String getOrders() {
		return this.orders;
	}
	public void setOrders(String orders) {
		this.orders = orders;
	}
	/**
	 * 备注
	 * @return String
	 */
	private String des_or;
	public String getDes_or() {
		return this.des_or;
	}
	public void setDes_or(String des_or) {
		this.des_or = des_or;
	}
	/**
	 * 重整标记行标识
	 * @return FBoolean
	 */
	private FBoolean fg_reformrow;
	public FBoolean getFg_reformrow() {
		return this.fg_reformrow;
	}
	public void setFg_reformrow(FBoolean fg_reformrow) {
		this.fg_reformrow = fg_reformrow;
	}
	/**
	 * 性别
	 * @return String
	 */
	private String sex_pat;
	public String getSex_pat() {
		return this.sex_pat;
	}
	public void setSex_pat(String sex_pat) {
		this.sex_pat = sex_pat;
	}
	/**
	 * 年龄
	 * @return String
	 */
	private String age;
	public String getAge() {
		return this.age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * 核对护士id
	 */
	private String id_emp_chk;
	public String getId_emp_chk() {
		return this.id_emp_chk;
	}
	public void setId_emp_chk(String id_emp_chk) {
		this.id_emp_chk = id_emp_chk;
	}
	/**
	 * 核对护士
	 * @return String
	 */
	private String name_emp_chk;
	public String getName_emp_chk() {
		return this.name_emp_chk;
	}	
	public void setName_emp_chk(String name_emp_chk) {
		this.name_emp_chk = name_emp_chk;
	}
	/**
	 * 停止核对护士id
	 */
	private String id_emp_chk_stop;
	public String getId_emp_chk_stop() {
		return this.id_emp_chk_stop;
	}
	public void setId_emp_chk_stop(String id_emp_chk_stop) {
		this.id_emp_chk_stop = id_emp_chk_stop;
	}
	/**
	 * 停止核对护士
	 * @return String
	 */
	private String name_emp_chk_stop;
	public String getName_emp_chk_stop() {
		return this.name_emp_chk_stop;
	}	
	public void setName_emp_chk_stop(String name_emp_chk_stop) {
		this.name_emp_chk_stop = name_emp_chk_stop;
	}
	/**
	 * 在院标识
	 * @return FBoolean
	 */
	private FBoolean fg_ip;
	public FBoolean getFg_ip() {
		return this.fg_ip;
	}
	public void setFg_ip(FBoolean fg_ip) {
		this.fg_ip = fg_ip;
	}
	/**
	 * 新生儿标识
	 * @return FBoolean
	 */
	private FBoolean fg_newborn;
	public FBoolean getFg_newborn() {
		return this.fg_newborn;
	}
	public void setFg_newborn(FBoolean fg_newborn) {
		this.fg_newborn = fg_newborn;
	}
	/**
	 * 入院时间
	 * @return
	 */
	private FDateTime dt_acpt;
	public FDateTime getDt_acpt() {
		return this.dt_acpt;
	}	
	public void setDt_acpt(FDateTime dt_acpt) {
		this.dt_acpt = dt_acpt;
	}
	
	/**
	 * 出院带药标识
	 */
	private FBoolean fg_pres_outp;
	public FBoolean getFg_pres_outp() {
		return this.fg_pres_outp;
	}
	public void setFg_pres_outp(FBoolean fg_pres_outp) {
		this.fg_pres_outp = fg_pres_outp;
	}
	
	/**
	 * 在院整领标识
	 */
	private FBoolean fg_wholepack;
	public FBoolean getFg_wholepack() {
		return this.fg_wholepack;
	}
	public void setFg_wholepack(FBoolean fg_wholepack) {
		this.fg_wholepack = fg_wholepack;
	}
	
	/**
	 * 总量
	 */
	private String quan_cur;
	public String getQuan_cur() {
		return this.quan_cur;
	}
	public void setQuan_cur(String quan_cur) {
		this.quan_cur = quan_cur;
	}
	
	/**
	 * 总量单位
	 * @return String
	 */
	private String name_unit_sale;
	public String getName_unit_sale() {
		return this.name_unit_sale;
	}
	public void setName_unit_sale(String name_unit_sale) {
		this.name_unit_sale = name_unit_sale;
	}
	
	/**
	 * 医嘱内容拼接中的频次用法
	 */
	private String content_or_prn_sub;
	public String getContent_or_prn_sub() {
		return this.content_or_prn_sub;
	}
	public void setContent_or_prn_sub(String content_or_prn_sub) {
		this.content_or_prn_sub = content_or_prn_sub;
	}

	/**
	 * 皮试结果
	 * @return String
	 */
	private String rst_skintest;
	public String getRst_skintest() {
		return this.rst_skintest;
	}
	public void setRst_skintest(String rst_skintest) {
		this.rst_skintest = rst_skintest;
	}
	
	/**
	 * 皮试结果打印标识
	 * @return String
	 */
	private String fg_skin_prn;
	public String getFg_skin_prn() {
		return this.fg_skin_prn;
	}
	public void setFg_skin_prn(String fg_skin_prn) {
		this.fg_skin_prn = fg_skin_prn;
	}
	
	/**
	 * 皮试结果
	 * @param Content_or_prn_skintest
	 */
	private String content_or_prn_skintest;
	public String getContent_or_prn_skintest() {
		return this.content_or_prn_skintest;
	}
	public void setContent_or_prn_skintest(String content_or_prn_skintest) {
		this.content_or_prn_skintest = content_or_prn_skintest;
	}
	 
	/**
	 * 医嘱内容
	 * @return String
	 */
	private String content_or;
	public String getContent_or() {
		return this.content_or;
	}
	public void setContent_or(String content_or) {
		this.content_or = content_or;
	}
	
	/**
	 * 加急标识
	 * @return
	 */
	private FBoolean fg_urgent;
	public FBoolean getFg_urgent() {
		return this.fg_urgent;
	}	
	public void setFg_urgent(FBoolean fg_urgent) {
		this.fg_urgent = fg_urgent;
	}
	
	/**
	 * 皮试标识
	 * @return FBoolean
	 */
	private FBoolean fg_skintest;
	public FBoolean getFg_skintest() {
		return this.fg_skintest;
	}
	public void setFg_skintest(FBoolean fg_skintest) {
		this.fg_skintest = fg_skintest;
	}
	
	/**
	 * 取消
	 */
	private String cancelName;
	public String getCancelName() {
		return this.cancelName;
	}
	public void setCancelName(String cancelName) {
		this.cancelName = cancelName;
	}
	
	/**
	 * 责任医生
	 */
	private String str_name_emp_sign;
	public String getStr_name_emp_sign() {
		return this.str_name_emp_sign;
	}
	public void setStr_name_emp_sign(String str_name_emp_sign) {
		this.str_name_emp_sign = str_name_emp_sign;
	}
	
	/**
	 * 责任护士
	 */
	private String str_name_emp_check;
	public String getStr_name_emp_check() {
		return this.str_name_emp_check;
	}
	public void setStr_name_emp_check(String str_name_emp_check) {
		this.str_name_emp_check = str_name_emp_check;
	}
	
	
	private String ord_sortno;
	public String getOrd_sortno() {
		return this.ord_sortno;
	}
	public void setOrd_sortno(String ord_sortno) {
		this.ord_sortno = ord_sortno;
	}
	
	/**
	 * 预住院标识
	 */
	private FBoolean fg_pip;
	public FBoolean getFg_pip() {
		return this.fg_pip;
	}
	public void setFg_pip(FBoolean fg_pip) {
		this.fg_pip = fg_pip;
	}
}
