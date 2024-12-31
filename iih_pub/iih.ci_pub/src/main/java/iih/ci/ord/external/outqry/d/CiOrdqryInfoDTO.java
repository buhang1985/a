package iih.ci.ord.external.outqry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱信息 DTO数据 
 * 
 */
public class CiOrdqryInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 医嘱天数
	 * @return String
	 */
	public String getDays_or() {
		return ((String) getAttrVal("Days_or"));
	}
	/**
	 * 医嘱天数
	 * @param Days_or
	 */
	public void setDays_or(String Days_or) {
		setAttrVal("Days_or", Days_or);
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
	 * 备注（当前使用）
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}
	/**
	 * 备注（当前使用）
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
	 * 记账状态
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}
	/**
	 * 记账状态
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
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
	 * @return String
	 */
	public String getQuan_medu() {
		return ((String) getAttrVal("Quan_medu"));
	}
	/**
	 * 单次医学剂量
	 * @param Quan_medu
	 */
	public void setQuan_medu(String Quan_medu) {
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
	 * @return String
	 */
	public String getQuan_medu_cur() {
		return ((String) getAttrVal("Quan_medu_cur"));
	}
	/**
	 * 界面录入单次用量
	 * @param Quan_medu_cur
	 */
	public void setQuan_medu_cur(String Quan_medu_cur) {
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
	 * @return String
	 */
	public String getFactor_cur() {
		return ((String) getAttrVal("Factor_cur"));
	}
	/**
	 * 界面录入单次用量单位换算系数
	 * @param Factor_cur
	 */
	public void setFactor_cur(String Factor_cur) {
		setAttrVal("Factor_cur", Factor_cur);
	}
	/**
	 * 总量
	 * @return String
	 */
	public String getQuan_cur() {
		return ((String) getAttrVal("Quan_cur"));
	}
	/**
	 * 总量
	 * @param Quan_cur
	 */
	public void setQuan_cur(String Quan_cur) {
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
	 * 处方号
	 * @return String
	 */
	public String getCode_pres() {
		return ((String) getAttrVal("Code_pres"));
	}
	/**
	 * 处方号
	 * @param Code_pres
	 */
	public void setCode_pres(String Code_pres) {
		setAttrVal("Code_pres", Code_pres);
	}
	/**
	 * 需皮试标志
	 * @return String
	 */
	public String getFg_skintest() {
		return ((String) getAttrVal("Fg_skintest"));
	}
	/**
	 * 需皮试标志
	 * @param Fg_skintest
	 */
	public void setFg_skintest(String Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	/**
	 * 皮试结果
	 * @return String
	 */
	public String getSd_rst_skintest() {
		return ((String) getAttrVal("Sd_rst_skintest"));
	}
	/**
	 * 皮试结果
	 * @param Sd_rst_skintest
	 */
	public void setSd_rst_skintest(String Sd_rst_skintest) {
		setAttrVal("Sd_rst_skintest", Sd_rst_skintest);
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
	 * 单价
	 * @return String
	 */
	public String getPri() {
		return ((String) getAttrVal("Pri"));
	}
	/**
	 * 单价
	 * @param Pri
	 */
	public void setPri(String Pri) {
		setAttrVal("Pri", Pri);
	}
	/**
	 * 医保目录类型
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}
	/**
	 * 医保目录类型
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 自费标识
	 * @return String
	 */
	public String getFg_selfpay() {
		return ((String) getAttrVal("Fg_selfpay"));
	}
	/**
	 * 自费标识
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(String Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	/**
	 * 特种病标识
	 * @return String
	 */
	public String getFg_specill() {
		return ((String) getAttrVal("Fg_specill"));
	}
	/**
	 * 特种病标识
	 * @param Fg_specill
	 */
	public void setFg_specill(String Fg_specill) {
		setAttrVal("Fg_specill", Fg_specill);
	}
	/**
	 * 科研标识
	 * @return String
	 */
	public String getFg_research() {
		return ((String) getAttrVal("Fg_research"));
	}
	/**
	 * 科研标识
	 * @param Fg_research
	 */
	public void setFg_research(String Fg_research) {
		setAttrVal("Fg_research", Fg_research);
	}
	/**
	 * 科研项目编码
	 * @return String
	 */
	public String getCode_researchproject() {
		return ((String) getAttrVal("Code_researchproject"));
	}
	/**
	 * 科研项目编码
	 * @param Code_researchproject
	 */
	public void setCode_researchproject(String Code_researchproject) {
		setAttrVal("Code_researchproject", Code_researchproject);
	}
	/**
	 * 标本号
	 * @return String
	 */
	public String getNo_ba() {
		return ((String) getAttrVal("No_ba"));
	}
	/**
	 * 标本号
	 * @param No_ba
	 */
	public void setNo_ba(String No_ba) {
		setAttrVal("No_ba", No_ba);
	}
}