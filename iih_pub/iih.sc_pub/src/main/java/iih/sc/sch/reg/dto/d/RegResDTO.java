package iih.sc.sch.reg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 挂号资源DTO DTO数据 
 * 
 */
public class RegResDTO extends BaseDTO {
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
	 * @return Integer
	 */
	public Integer getPolcn() {
		return ((Integer) getAttrVal("Polcn"));
	}
	/**
	 * 号源池
	 * @param Polcn
	 */
	public void setPolcn(Integer Polcn) {
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
	 * @return Integer
	 */
	public Integer getTotal() {
		return ((Integer) getAttrVal("Total"));
	}
	/**
	 * 总票数
	 * @param Total
	 */
	public void setTotal(Integer Total) {
		setAttrVal("Total", Total);
	}
	/**
	 * 已使用
	 * @return Integer
	 */
	public Integer getUsed() {
		return ((Integer) getAttrVal("Used"));
	}
	/**
	 * 已使用
	 * @param Used
	 */
	public void setUsed(Integer Used) {
		setAttrVal("Used", Used);
	}
	/**
	 * 剩余票数
	 * @return Integer
	 */
	public Integer getRemain() {
		return ((Integer) getAttrVal("Remain"));
	}
	/**
	 * 剩余票数
	 * @param Remain
	 */
	public void setRemain(Integer Remain) {
		setAttrVal("Remain", Remain);
	}
	/**
	 * 加号数量
	 * @return Integer
	 */
	public Integer getAddquan() {
		return ((Integer) getAttrVal("Addquan"));
	}
	/**
	 * 加号数量
	 * @param Addquan
	 */
	public void setAddquan(Integer Addquan) {
		setAttrVal("Addquan", Addquan);
	}
	/**
	 * 排班日期
	 * @return FDate
	 */
	public FDate getD_sch() {
		return ((FDate) getAttrVal("D_sch"));
	}
	/**
	 * 排班日期
	 * @param D_sch
	 */
	public void setD_sch(FDate D_sch) {
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
	 * @return FArrayList
	 */
	public FArrayList getSrvarray() {
		return ((FArrayList) getAttrVal("Srvarray"));
	}
	/**
	 * 服务集合
	 * @param Srvarray
	 */
	public void setSrvarray(FArrayList Srvarray) {
		setAttrVal("Srvarray", Srvarray);
	}
	/**
	 * 挂号费
	 * @return FDouble
	 */
	public FDouble getRegfee() {
		return ((FDouble) getAttrVal("Regfee"));
	}
	/**
	 * 挂号费
	 * @param Regfee
	 */
	public void setRegfee(FDouble Regfee) {
		setAttrVal("Regfee", Regfee);
	}
	/**
	 * 诊疗费
	 * @return FDouble
	 */
	public FDouble getDiagfee() {
		return ((FDouble) getAttrVal("Diagfee"));
	}
	/**
	 * 诊疗费
	 * @param Diagfee
	 */
	public void setDiagfee(FDouble Diagfee) {
		setAttrVal("Diagfee", Diagfee);
	}
	/**
	 * 标准金额
	 * @return FDouble
	 */
	public FDouble getAmt_st() {
		return ((FDouble) getAttrVal("Amt_st"));
	}
	/**
	 * 标准金额
	 * @param Amt_st
	 */
	public void setAmt_st(FDouble Amt_st) {
		setAttrVal("Amt_st", Amt_st);
	}
	/**
	 * 医保支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 医保支付金额
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 患者自付金额
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}
	/**
	 * 患者自付金额
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 医保个人账户支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_insuracc() {
		return ((FDouble) getAttrVal("Amt_insuracc"));
	}
	/**
	 * 医保个人账户支付金额
	 * @param Amt_insuracc
	 */
	public void setAmt_insuracc(FDouble Amt_insuracc) {
		setAttrVal("Amt_insuracc", Amt_insuracc);
	}
	/**
	 * 支付金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 支付金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
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
	 * @return FDouble
	 */
	public FDouble getAmt_orig() {
		return ((FDouble) getAttrVal("Amt_orig"));
	}
	/**
	 * 原支付金额
	 * @param Amt_orig
	 */
	public void setAmt_orig(FDouble Amt_orig) {
		setAttrVal("Amt_orig", Amt_orig);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 支付明细
	 * @return FArrayList
	 */
	public FArrayList getDetails_pay() {
		return ((FArrayList) getAttrVal("Details_pay"));
	}
	/**
	 * 支付明细
	 * @param Details_pay
	 */
	public void setDetails_pay(FArrayList Details_pay) {
		setAttrVal("Details_pay", Details_pay);
	}
	/**
	 * 商保支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_hpcmcl() {
		return ((FDouble) getAttrVal("Amt_hpcmcl"));
	}
	/**
	 * 商保支付金额
	 * @param Amt_hpcmcl
	 */
	public void setAmt_hpcmcl(FDouble Amt_hpcmcl) {
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
	 * @return Integer
	 */
	public Integer getMax_num_add() {
		return ((Integer) getAttrVal("Max_num_add"));
	}
	/**
	 * 最大可加号数量
	 * @param Max_num_add
	 */
	public void setMax_num_add(Integer Max_num_add) {
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
	 * 号源类型
	 * @return String
	 */
	public String getEu_regrestp() {
		return ((String) getAttrVal("Eu_regrestp"));
	}
	/**
	 * 号源类型
	 * @param Eu_regrestp
	 */
	public void setEu_regrestp(String Eu_regrestp) {
		setAttrVal("Eu_regrestp", Eu_regrestp);
	}
	/**
	 * 队列id
	 * @return String
	 */
	public String getId_que() {
		return ((String) getAttrVal("Id_que"));
	}
	/**
	 * 队列id
	 * @param Id_que
	 */
	public void setId_que(String Id_que) {
		setAttrVal("Id_que", Id_que);
	}
	/**
	 * 是否打印号条
	 * @return FBoolean
	 */
	public FBoolean getFg_print() {
		return ((FBoolean) getAttrVal("Fg_print"));
	}
	/**
	 * 是否打印号条
	 * @param Fg_print
	 */
	public void setFg_print(FBoolean Fg_print) {
		setAttrVal("Fg_print", Fg_print);
	}
	/**
	 * 停止挂号时间
	 * @return FTime
	 */
	public FTime getT_e_reg() {
		return ((FTime) getAttrVal("T_e_reg"));
	}
	/**
	 * 停止挂号时间
	 * @param T_e_reg
	 */
	public void setT_e_reg(FTime T_e_reg) {
		setAttrVal("T_e_reg", T_e_reg);
	}
	/**
	 * 是否停止挂号
	 * @return FBoolean
	 */
	public FBoolean getFg_stop() {
		return ((FBoolean) getAttrVal("Fg_stop"));
	}
	/**
	 * 是否停止挂号
	 * @param Fg_stop
	 */
	public void setFg_stop(FBoolean Fg_stop) {
		setAttrVal("Fg_stop", Fg_stop);
	}
	/**
	 * 接诊原因
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 接诊原因
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 接诊开始时间
	 * @return String
	 */
	public String getT_b_acpt() {
		return ((String) getAttrVal("T_b_acpt"));
	}
	/**
	 * 接诊开始时间
	 * @param T_b_acpt
	 */
	public void setT_b_acpt(String T_b_acpt) {
		setAttrVal("T_b_acpt", T_b_acpt);
	}
	/**
	 * 接诊结束时间
	 * @return String
	 */
	public String getT_e_acpt() {
		return ((String) getAttrVal("T_e_acpt"));
	}
	/**
	 * 接诊结束时间
	 * @param T_e_acpt
	 */
	public void setT_e_acpt(String T_e_acpt) {
		setAttrVal("T_e_acpt", T_e_acpt);
	}
	/**
	 * 接诊时间
	 * @return String
	 */
	public String getT_acpt() {
		return ((String) getAttrVal("T_acpt"));
	}
	/**
	 * 接诊时间
	 * @param T_acpt
	 */
	public void setT_acpt(String T_acpt) {
		setAttrVal("T_acpt", T_acpt);
	}
	/**
	 * 划价信息
	 * @return FArrayList
	 */
	public FArrayList getPricedinfo() {
		return ((FArrayList) getAttrVal("Pricedinfo"));
	}
	/**
	 * 划价信息
	 * @param Pricedinfo
	 */
	public void setPricedinfo(FArrayList Pricedinfo) {
		setAttrVal("Pricedinfo", Pricedinfo);
	}
}
    
