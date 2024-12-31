package iih.ei.sc.ws.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

/**
 * 患者未预约申请单结果
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetUnaptApplyBean  extends BaseWsParam implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 申请单id
	 */
	private String id_aptappl;
	/**
	 * 组织id
	 */
	private String id_org;
	/**
	 * 排班类型编码
	 */
	private String sd_sctp;
	/**
	 * 排班分类
	 */
	private String id_scca;
	/**
	 * 预约申请编码
	 */
	private String code;
	/**
	 * 预约申请名称
	 */
	private String name;
	/**
	 * 申请号
	 */
	private String applyno;
	/**
	 * 预约申请描述
	 */
	private String des;
	/**
	 * 患者id
	 */
	private String id_pi;
	/**
	 * 患者名字
	 */
	private String piname;
	/**
	 * 患者性别编码
	 */
	private String sd_sex;
	/**
	 * 患者出生日期
	 */
	private String d_pi;
	/**
	 * 患者手机号
	 */
	private String pimobile;
	/**
	 * 就诊类型
	 */
	private String code_entp;
	/**
	 * 就诊id
	 */
	private String id_ent;
	/**
	 * 医嘱id
	 */
	private String id_or;
	/**
	 * 医嘱内容
	 */
	private String content_or;
	/**
	 * 优先级
	 */
	private String priority;
	/**
	 * 预约申请开始日期
	 */
	private String d_b;
	/**
	 * 预约申请结束日期
	 */
	private String d_e;
	/**
	 * 日期分组id
	 */
	private String id_dateslot;
	/**
	 * 排班服务id
	 */
	private String id_scsrv;
	/**
	 * 排班资源id
	 */
	private String id_scres;
	/**
	 * 预约申请部门id
	 */
	private String id_dep_appl;
	/**
	 * 预约申请人员id
	 */
	private String id_emp_appl;
	/**
	 * 执行科室id
	 */
	private String id_dep_mp;
	/**
	 * 预约申请操作日期
	 */
	private String dt_appl;
	/**
	 * 预约完成标志
	 */
	private String fg_confirm;
	/**
	 * 对应预约记录id
	 */
	private String id_scapt;
	/**
	 * 取消标志
	 */
	private String fg_canc;
	/**
	 * 取消人员
	 */
	private String id_emp_canc;
	/**
	 * 取消时间
	 */
	private String dt_canc;
	/**
	 * 紧急标志
	 */
	private String fg_urgent;
	/**
	 * 预约模式
	 */
	private String eu_aptmd;
	/**
	 * 医嘱开始时间
	 */
	private String dt_effe_or;
	/**
	 * 服务id
	 */
	private String id_srv;
	/**
	 * 服务是否需确认
	 */
	private String fg_needcfm;
	/**
	 * 收费标志
	 */
	private String fg_bl;
	/**
	 * 部位名称
	 */
	private String applSrvName;
	public String getId_aptappl() {
		return id_aptappl;
	}
	public void setId_aptappl(String id_aptappl) {
		this.id_aptappl = id_aptappl;
	}
	public String getId_org() {
		return id_org;
	}
	public void setId_org(String id_org) {
		this.id_org = id_org;
	}
	public String getSd_sctp() {
		return sd_sctp;
	}
	public void setSd_sctp(String sd_sctp) {
		this.sd_sctp = sd_sctp;
	}
	public String getId_scca() {
		return id_scca;
	}
	public void setId_scca(String id_scca) {
		this.id_scca = id_scca;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApplyno() {
		return applyno;
	}
	public void setApplyno(String applyno) {
		this.applyno = applyno;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getId_pi() {
		return id_pi;
	}
	public void setId_pi(String id_pi) {
		this.id_pi = id_pi;
	}
	public String getPiname() {
		return piname;
	}
	public void setPiname(String piname) {
		this.piname = piname;
	}
	public String getSd_sex() {
		return sd_sex;
	}
	public void setSd_sex(String sd_sex) {
		this.sd_sex = sd_sex;
	}
	public String getD_pi() {
		return d_pi;
	}
	public void setD_pi(String d_pi) {
		this.d_pi = d_pi;
	}
	public String getPimobile() {
		return pimobile;
	}
	public void setPimobile(String pimobile) {
		this.pimobile = pimobile;
	}
	public String getCode_entp() {
		return code_entp;
	}
	public void setCode_entp(String code_entp) {
		this.code_entp = code_entp;
	}
	public String getId_ent() {
		return id_ent;
	}
	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}
	public String getId_or() {
		return id_or;
	}
	public void setId_or(String id_or) {
		this.id_or = id_or;
	}
	public String getContent_or() {
		return content_or;
	}
	public void setContent_or(String content_or) {
		this.content_or = content_or;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getD_b() {
		return d_b;
	}
	public void setD_b(String d_b) {
		this.d_b = d_b;
	}
	public String getD_e() {
		return d_e;
	}
	public void setD_e(String d_e) {
		this.d_e = d_e;
	}
	public String getId_dateslot() {
		return id_dateslot;
	}
	public void setId_dateslot(String id_dateslot) {
		this.id_dateslot = id_dateslot;
	}
	public String getId_scsrv() {
		return id_scsrv;
	}
	public void setId_scsrv(String id_scsrv) {
		this.id_scsrv = id_scsrv;
	}
	public String getId_scres() {
		return id_scres;
	}
	public void setId_scres(String id_scres) {
		this.id_scres = id_scres;
	}
	public String getId_dep_appl() {
		return id_dep_appl;
	}
	public void setId_dep_appl(String id_dep_appl) {
		this.id_dep_appl = id_dep_appl;
	}
	public String getId_emp_appl() {
		return id_emp_appl;
	}
	public void setId_emp_appl(String id_emp_appl) {
		this.id_emp_appl = id_emp_appl;
	}
	public String getId_dep_mp() {
		return id_dep_mp;
	}
	public void setId_dep_mp(String id_dep_mp) {
		this.id_dep_mp = id_dep_mp;
	}
	public String getDt_appl() {
		return dt_appl;
	}
	public void setDt_appl(String dt_appl) {
		this.dt_appl = dt_appl;
	}
	public String getFg_confirm() {
		return fg_confirm;
	}
	public void setFg_confirm(String fg_confirm) {
		this.fg_confirm = fg_confirm;
	}
	public String getId_scapt() {
		return id_scapt;
	}
	public void setId_scapt(String id_scapt) {
		this.id_scapt = id_scapt;
	}
	public String getFg_canc() {
		return fg_canc;
	}
	public void setFg_canc(String fg_canc) {
		this.fg_canc = fg_canc;
	}
	public String getId_emp_canc() {
		return id_emp_canc;
	}
	public void setId_emp_canc(String id_emp_canc) {
		this.id_emp_canc = id_emp_canc;
	}
	public String getDt_canc() {
		return dt_canc;
	}
	public void setDt_canc(String dt_canc) {
		this.dt_canc = dt_canc;
	}
	public String getFg_urgent() {
		return fg_urgent;
	}
	public void setFg_urgent(String fg_urgent) {
		this.fg_urgent = fg_urgent;
	}
	public String getEu_aptmd() {
		return eu_aptmd;
	}
	public void setEu_aptmd(String eu_aptmd) {
		this.eu_aptmd = eu_aptmd;
	}
	public String getDt_effe_or() {
		return dt_effe_or;
	}
	public void setDt_effe_or(String dt_effe_or) {
		this.dt_effe_or = dt_effe_or;
	}
	public String getId_srv() {
		return id_srv;
	}
	public void setId_srv(String id_srv) {
		this.id_srv = id_srv;
	}
	public String getFg_needcfm() {
		return fg_needcfm;
	}
	public void setFg_needcfm(String fg_needcfm) {
		this.fg_needcfm = fg_needcfm;
	}
	public String getFg_bl() {
		return fg_bl;
	}
	public void setFg_bl(String fg_bl) {
		this.fg_bl = fg_bl;
	}
	public String getApplSrvName() {
		return applSrvName;
	}
	public void setApplSrvName(String applSrvName) {
		this.applSrvName = applSrvName;
	}
}
