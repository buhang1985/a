package iih.pis.phk.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者管家_挂号资源DTO DTO数据 
 * 
 */
public class PisPhkRegResDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}
	/**
	 * 排班
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 渠道id
	 * @return String
	 */
	public String getId_scchl() {
		return ((String) getAttrVal("Id_scchl"));
	}
	/**
	 * 渠道id
	 * @param Id_scchl
	 */
	public void setId_scchl(String Id_scchl) {
		setAttrVal("Id_scchl", Id_scchl);
	}
	/**
	 * 号源池
	 * @return String
	 */
	public String getPolcn() {
		return ((String) getAttrVal("Polcn"));
	}
	/**
	 * 号源池
	 * @param Polcn
	 */
	public void setPolcn(String Polcn) {
		setAttrVal("Polcn", Polcn);
	}
	/**
	 * 排班计划
	 * @return String
	 */
	public String getId_scpl() {
		return ((String) getAttrVal("Id_scpl"));
	}
	/**
	 * 排班计划
	 * @param Id_scpl
	 */
	public void setId_scpl(String Id_scpl) {
		setAttrVal("Id_scpl", Id_scpl);
	}
	/**
	 * 计划名称
	 * @return String
	 */
	public String getName_scpl() {
		return ((String) getAttrVal("Name_scpl"));
	}
	/**
	 * 计划名称
	 * @param Name_scpl
	 */
	public void setName_scpl(String Name_scpl) {
		setAttrVal("Name_scpl", Name_scpl);
	}
	/**
	 * 号别类型id
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 号别类型id
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 号别类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 号别类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 排班服务
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}
	/**
	 * 排班服务
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 排班服务名称
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}
	/**
	 * 排班服务名称
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
	/**
	 * 排班资源
	 * @return String
	 */
	public String getId_scres() {
		return ((String) getAttrVal("Id_scres"));
	}
	/**
	 * 排班资源
	 * @param Id_scres
	 */
	public void setId_scres(String Id_scres) {
		setAttrVal("Id_scres", Id_scres);
	}
	/**
	 * 排班资源名称
	 * @return String
	 */
	public String getName_scres() {
		return ((String) getAttrVal("Name_scres"));
	}
	/**
	 * 排班资源名称
	 * @param Name_scres
	 */
	public void setName_scres(String Name_scres) {
		setAttrVal("Name_scres", Name_scres);
	}
	/**
	 * 人员id
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 人员id
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
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
	 * 票号模式
	 * @return String
	 */
	public String getId_tickmd() {
		return ((String) getAttrVal("Id_tickmd"));
	}
	/**
	 * 票号模式
	 * @param Id_tickmd
	 */
	public void setId_tickmd(String Id_tickmd) {
		setAttrVal("Id_tickmd", Id_tickmd);
	}
	/**
	 * 票号模式编码
	 * @return String
	 */
	public String getSd_tickmd() {
		return ((String) getAttrVal("Sd_tickmd"));
	}
	/**
	 * 票号模式编码
	 * @param Sd_tickmd
	 */
	public void setSd_tickmd(String Sd_tickmd) {
		setAttrVal("Sd_tickmd", Sd_tickmd);
	}
	/**
	 * 总票数
	 * @return String
	 */
	public String getTotal() {
		return ((String) getAttrVal("Total"));
	}
	/**
	 * 总票数
	 * @param Total
	 */
	public void setTotal(String Total) {
		setAttrVal("Total", Total);
	}
	/**
	 * 已使用
	 * @return String
	 */
	public String getUsed() {
		return ((String) getAttrVal("Used"));
	}
	/**
	 * 已使用
	 * @param Used
	 */
	public void setUsed(String Used) {
		setAttrVal("Used", Used);
	}
	/**
	 * 剩余票数
	 * @return String
	 */
	public String getRemain() {
		return ((String) getAttrVal("Remain"));
	}
	/**
	 * 剩余票数
	 * @param Remain
	 */
	public void setRemain(String Remain) {
		setAttrVal("Remain", Remain);
	}
	/**
	 * 加号数量
	 * @return String
	 */
	public String getAddquan() {
		return ((String) getAttrVal("Addquan"));
	}
	/**
	 * 加号数量
	 * @param Addquan
	 */
	public void setAddquan(String Addquan) {
		setAttrVal("Addquan", Addquan);
	}
	/**
	 * 排班日期
	 * @return String
	 */
	public String getD_sch() {
		return ((String) getAttrVal("D_sch"));
	}
	/**
	 * 排班日期
	 * @param D_sch
	 */
	public void setD_sch(String D_sch) {
		setAttrVal("D_sch", D_sch);
	}
	/**
	 * 午别
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 午别
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 午别名称
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}
	/**
	 * 午别名称
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 输入码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 输入码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 服务集合
	 * @return String
	 */
	public String getSrvarray() {
		return ((String) getAttrVal("Srvarray"));
	}
	/**
	 * 服务集合
	 * @param Srvarray
	 */
	public void setSrvarray(String Srvarray) {
		setAttrVal("Srvarray", Srvarray);
	}
	/**
	 * 挂号费
	 * @return String
	 */
	public String getRegfee() {
		return ((String) getAttrVal("Regfee"));
	}
	/**
	 * 挂号费
	 * @param Regfee
	 */
	public void setRegfee(String Regfee) {
		setAttrVal("Regfee", Regfee);
	}
	/**
	 * 诊疗费
	 * @return String
	 */
	public String getDiagfee() {
		return ((String) getAttrVal("Diagfee"));
	}
	/**
	 * 诊疗费
	 * @param Diagfee
	 */
	public void setDiagfee(String Diagfee) {
		setAttrVal("Diagfee", Diagfee);
	}
	/**
	 * 标准金额
	 * @return String
	 */
	public String getAmt_st() {
		return ((String) getAttrVal("Amt_st"));
	}
	/**
	 * 标准金额
	 * @param Amt_st
	 */
	public void setAmt_st(String Amt_st) {
		setAttrVal("Amt_st", Amt_st);
	}
	/**
	 * 医保支付金额
	 * @return String
	 */
	public String getAmt_hp() {
		return ((String) getAttrVal("Amt_hp"));
	}
	/**
	 * 医保支付金额
	 * @param Amt_hp
	 */
	public void setAmt_hp(String Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 患者自付金额
	 * @return String
	 */
	public String getAmt_pat() {
		return ((String) getAttrVal("Amt_pat"));
	}
	/**
	 * 患者自付金额
	 * @param Amt_pat
	 */
	public void setAmt_pat(String Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 医保个人账户支付金额
	 * @return String
	 */
	public String getAmt_insuracc() {
		return ((String) getAttrVal("Amt_insuracc"));
	}
	/**
	 * 医保个人账户支付金额
	 * @param Amt_insuracc
	 */
	public void setAmt_insuracc(String Amt_insuracc) {
		setAttrVal("Amt_insuracc", Amt_insuracc);
	}
	/**
	 * 支付金额
	 * @return String
	 */
	public String getAmt() {
		return ((String) getAttrVal("Amt"));
	}
	/**
	 * 支付金额
	 * @param Amt
	 */
	public void setAmt(String Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 付款方式id
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}
	/**
	 * 付款方式id
	 * @param Id_pm
	 */
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	/**
	 * 付款方式编码
	 * @return String
	 */
	public String getSd_pm() {
		return ((String) getAttrVal("Sd_pm"));
	}
	/**
	 * 付款方式编码
	 * @param Sd_pm
	 */
	public void setSd_pm(String Sd_pm) {
		setAttrVal("Sd_pm", Sd_pm);
	}
	/**
	 * 支付凭证
	 * @return String
	 */
	public String getPaycred() {
		return ((String) getAttrVal("Paycred"));
	}
	/**
	 * 支付凭证
	 * @param Paycred
	 */
	public void setPaycred(String Paycred) {
		setAttrVal("Paycred", Paycred);
	}
	/**
	 * 付款方式名称
	 * @return String
	 */
	public String getName_pm() {
		return ((String) getAttrVal("Name_pm"));
	}
	/**
	 * 付款方式名称
	 * @param Name_pm
	 */
	public void setName_pm(String Name_pm) {
		setAttrVal("Name_pm", Name_pm);
	}
	/**
	 * 原支付金额
	 * @return String
	 */
	public String getAmt_orig() {
		return ((String) getAttrVal("Amt_orig"));
	}
	/**
	 * 原支付金额
	 * @param Amt_orig
	 */
	public void setAmt_orig(String Amt_orig) {
		setAttrVal("Amt_orig", Amt_orig);
	}
	/**
	 * 启用标识
	 * @return String
	 */
	public String getFg_active() {
		return ((String) getAttrVal("Fg_active"));
	}
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(String Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 支付明细
	 * @return String
	 */
	public String getDetails_pay() {
		return ((String) getAttrVal("Details_pay"));
	}
	/**
	 * 支付明细
	 * @param Details_pay
	 */
	public void setDetails_pay(String Details_pay) {
		setAttrVal("Details_pay", Details_pay);
	}
	/**
	 * 商保支付金额
	 * @return String
	 */
	public String getAmt_hpcmcl() {
		return ((String) getAttrVal("Amt_hpcmcl"));
	}
	/**
	 * 商保支付金额
	 * @param Amt_hpcmcl
	 */
	public void setAmt_hpcmcl(String Amt_hpcmcl) {
		setAttrVal("Amt_hpcmcl", Amt_hpcmcl);
	}
	/**
	 * 商保支付单位id
	 * @return String
	 */
	public String getId_hpcmcl() {
		return ((String) getAttrVal("Id_hpcmcl"));
	}
	/**
	 * 商保支付单位id
	 * @param Id_hpcmcl
	 */
	public void setId_hpcmcl(String Id_hpcmcl) {
		setAttrVal("Id_hpcmcl", Id_hpcmcl);
	}
	/**
	 * 商保支付单位名称
	 * @return String
	 */
	public String getName_hpcmcl() {
		return ((String) getAttrVal("Name_hpcmcl"));
	}
	/**
	 * 商保支付单位名称
	 * @param Name_hpcmcl
	 */
	public void setName_hpcmcl(String Name_hpcmcl) {
		setAttrVal("Name_hpcmcl", Name_hpcmcl);
	}
	/**
	 * 资源描述
	 * @return String
	 */
	public String getScres_des() {
		return ((String) getAttrVal("Scres_des"));
	}
	/**
	 * 资源描述
	 * @param Scres_des
	 */
	public void setScres_des(String Scres_des) {
		setAttrVal("Scres_des", Scres_des);
	}
	/**
	 * 最大可加号数量
	 * @return String
	 */
	public String getMax_num_add() {
		return ((String) getAttrVal("Max_num_add"));
	}
	/**
	 * 最大可加号数量
	 * @param Max_num_add
	 */
	public void setMax_num_add(String Max_num_add) {
		setAttrVal("Max_num_add", Max_num_add);
	}
	/**
	 * 排班类型
	 * @return String
	 */
	public String getSd_sctp() {
		return ((String) getAttrVal("Sd_sctp"));
	}
	/**
	 * 排班类型
	 * @param Sd_sctp
	 */
	public void setSd_sctp(String Sd_sctp) {
		setAttrVal("Sd_sctp", Sd_sctp);
	}
	/**
	 * 是否是历史排班
	 * @return String
	 */
	public String getFg_ishissch() {
		return ((String) getAttrVal("Fg_ishissch"));
	}
	/**
	 * 是否是历史排班
	 * @param Fg_ishissch
	 */
	public void setFg_ishissch(String Fg_ishissch) {
		setAttrVal("Fg_ishissch", Fg_ishissch);
	}
	/**
	 * 医疗服务id
	 * @return String
	 */
	public String getId_mdsrv() {
		return ((String) getAttrVal("Id_mdsrv"));
	}
	/**
	 * 医疗服务id
	 * @param Id_mdsrv
	 */
	public void setId_mdsrv(String Id_mdsrv) {
		setAttrVal("Id_mdsrv", Id_mdsrv);
	}
	/**
	 * 医疗服务code
	 * @return String
	 */
	public String getCode_mdsrv() {
		return ((String) getAttrVal("Code_mdsrv"));
	}
	/**
	 * 医疗服务code
	 * @param Code_mdsrv
	 */
	public void setCode_mdsrv(String Code_mdsrv) {
		setAttrVal("Code_mdsrv", Code_mdsrv);
	}
	/**
	 * 医疗服务名称
	 * @return String
	 */
	public String getName_mdsrv() {
		return ((String) getAttrVal("Name_mdsrv"));
	}
	/**
	 * 医疗服务名称
	 * @param Name_mdsrv
	 */
	public void setName_mdsrv(String Name_mdsrv) {
		setAttrVal("Name_mdsrv", Name_mdsrv);
	}
}