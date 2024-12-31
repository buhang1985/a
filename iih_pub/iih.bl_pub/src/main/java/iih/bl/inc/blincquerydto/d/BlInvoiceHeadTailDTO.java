package iih.bl.inc.blincquerydto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 门诊结算使用的票据头尾DTO DTO数据 
 * 
 */
public class BlInvoiceHeadTailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者主键ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者主键ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}
	/**
	 * 患者编码
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPatname() {
		return ((String) getAttrVal("Patname"));
	}
	/**
	 * 患者姓名
	 * @param Patname
	 */
	public void setPatname(String Patname) {
		setAttrVal("Patname", Patname);
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
	 * 价格分类名称
	 * @return String
	 */
	public String getPripat_name() {
		return ((String) getAttrVal("Pripat_name"));
	}
	/**
	 * 价格分类名称
	 * @param Pripat_name
	 */
	public void setPripat_name(String Pripat_name) {
		setAttrVal("Pripat_name", Pripat_name);
	}
	/**
	 * 结算主键
	 * @return String
	 */
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}
	/**
	 * 结算主键
	 * @param Id_stoep
	 */
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
	}
	/**
	 * 业务流水号
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}
	/**
	 * 业务流水号
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}
	/**
	 * 医疗机构类型
	 * @return String
	 */
	public String getHospital_type() {
		return ((String) getAttrVal("Hospital_type"));
	}
	/**
	 * 医疗机构类型
	 * @param Hospital_type
	 */
	public void setHospital_type(String Hospital_type) {
		setAttrVal("Hospital_type", Hospital_type);
	}
	/**
	 * 标准金额
	 * @return FDouble
	 */
	public FDouble getAmt_std() {
		return ((FDouble) getAttrVal("Amt_std"));
	}
	/**
	 * 标准金额
	 * @param Amt_std
	 */
	public void setAmt_std(FDouble Amt_std) {
		setAttrVal("Amt_std", Amt_std);
	}
	/**
	 * 折扣系数金额
	 * @return FDouble
	 */
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}
	/**
	 * 折扣系数金额
	 * @param Amt_ratio
	 */
	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
	/**
	 * 患者支付金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 患者支付金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 患者自付
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}
	/**
	 * 患者自付
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 减免金额
	 * @return FDouble
	 */
	public FDouble getAmt_free() {
		return ((FDouble) getAttrVal("Amt_free"));
	}
	/**
	 * 减免金额
	 * @param Amt_free
	 */
	public void setAmt_free(FDouble Amt_free) {
		setAttrVal("Amt_free", Amt_free);
	}
	/**
	 * 医保基金支付
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 医保基金支付
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 个人账户支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_grzhzf() {
		return ((FDouble) getAttrVal("Amt_grzhzf"));
	}
	/**
	 * 个人账户支付金额
	 * @param Amt_grzhzf
	 */
	public void setAmt_grzhzf(FDouble Amt_grzhzf) {
		setAttrVal("Amt_grzhzf", Amt_grzhzf);
	}
	/**
	 * 方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}
	/**
	 * 方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 结算时间
	 * @return FDateTime
	 */
	public FDateTime getDatetime_st() {
		return ((FDateTime) getAttrVal("Datetime_st"));
	}
	/**
	 * 结算时间
	 * @param Datetime_st
	 */
	public void setDatetime_st(FDateTime Datetime_st) {
		setAttrVal("Datetime_st", Datetime_st);
	}
	/**
	 * 打印时间
	 * @return FDateTime
	 */
	public FDateTime getDatetime_print() {
		return ((FDateTime) getAttrVal("Datetime_print"));
	}
	/**
	 * 打印时间
	 * @param Datetime_print
	 */
	public void setDatetime_print(FDateTime Datetime_print) {
		setAttrVal("Datetime_print", Datetime_print);
	}
	/**
	 * 收款人
	 * @return String
	 */
	public String getPayee_emp_name() {
		return ((String) getAttrVal("Payee_emp_name"));
	}
	/**
	 * 收款人
	 * @param Payee_emp_name
	 */
	public void setPayee_emp_name(String Payee_emp_name) {
		setAttrVal("Payee_emp_name", Payee_emp_name);
	}
	/**
	 * 开票人
	 * @return String
	 */
	public String getInc_emp_name() {
		return ((String) getAttrVal("Inc_emp_name"));
	}
	/**
	 * 开票人
	 * @param Inc_emp_name
	 */
	public void setInc_emp_name(String Inc_emp_name) {
		setAttrVal("Inc_emp_name", Inc_emp_name);
	}
	/**
	 * 医保交易流水号
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}
	/**
	 * 医保交易流水号
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 医保信息
	 * @return String
	 */
	public String getEnthpdo() {
		return ((String) getAttrVal("Enthpdo"));
	}
	/**
	 * 医保信息
	 * @param Enthpdo
	 */
	public void setEnthpdo(String Enthpdo) {
		setAttrVal("Enthpdo", Enthpdo);
	}
	/**
	 * 发票号
	 * @return String
	 */
	public String getIncno() {
		return ((String) getAttrVal("Incno"));
	}
	/**
	 * 发票号
	 * @param Incno
	 */
	public void setIncno(String Incno) {
		setAttrVal("Incno", Incno);
	}
	/**
	 * 付款方式
	 * @return String
	 */
	public String getPay_tp() {
		return ((String) getAttrVal("Pay_tp"));
	}
	/**
	 * 付款方式
	 * @param Pay_tp
	 */
	public void setPay_tp(String Pay_tp) {
		setAttrVal("Pay_tp", Pay_tp);
	}
	/**
	 * 是否医保发票
	 * @return FBoolean
	 */
	public FBoolean getFg_hp() {
		return ((FBoolean) getAttrVal("Fg_hp"));
	}
	/**
	 * 是否医保发票
	 * @param Fg_hp
	 */
	public void setFg_hp(FBoolean Fg_hp) {
		setAttrVal("Fg_hp", Fg_hp);
	}
	/**
	 * 减免方式
	 * @return Integer
	 */
	public Integer getEu_freemd() {
		return ((Integer) getAttrVal("Eu_freemd"));
	}
	/**
	 * 减免方式
	 * @param Eu_freemd
	 */
	public void setEu_freemd(Integer Eu_freemd) {
		setAttrVal("Eu_freemd", Eu_freemd);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}
	/**
	 * 就诊科室
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 结算类型
	 * @return String
	 */
	public String getEu_sttp() {
		return ((String) getAttrVal("Eu_sttp"));
	}
	/**
	 * 结算类型
	 * @param Eu_sttp
	 */
	public void setEu_sttp(String Eu_sttp) {
		setAttrVal("Eu_sttp", Eu_sttp);
	}
	/**
	 * 商保支付金额（文字+金额）
	 * @return String
	 */
	public String getAmt_hpcg() {
		return ((String) getAttrVal("Amt_hpcg"));
	}
	/**
	 * 商保支付金额（文字+金额）
	 * @param Amt_hpcg
	 */
	public void setAmt_hpcg(String Amt_hpcg) {
		setAttrVal("Amt_hpcg", Amt_hpcg);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getCode_medkind() {
		return ((String) getAttrVal("Code_medkind"));
	}
	/**
	 * 医疗类别
	 * @param Code_medkind
	 */
	public void setCode_medkind(String Code_medkind) {
		setAttrVal("Code_medkind", Code_medkind);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 卡余额
	 * @return FDouble
	 */
	public FDouble getAcc_balance() {
		return ((FDouble) getAttrVal("Acc_balance"));
	}
	/**
	 * 卡余额
	 * @param Acc_balance
	 */
	public void setAcc_balance(FDouble Acc_balance) {
		setAttrVal("Acc_balance", Acc_balance);
	}
	/**
	 * 医保其他基金支付
	 * @return FDouble
	 */
	public FDouble getAmt_otherhp() {
		return ((FDouble) getAttrVal("Amt_otherhp"));
	}
	/**
	 * 医保其他基金支付
	 * @param Amt_otherhp
	 */
	public void setAmt_otherhp(FDouble Amt_otherhp) {
		setAttrVal("Amt_otherhp", Amt_otherhp);
	}
	/**
	 * 上传号
	 * @return String
	 */
	public String getUpload_no() {
		return ((String) getAttrVal("Upload_no"));
	}
	/**
	 * 上传号
	 * @param Upload_no
	 */
	public void setUpload_no(String Upload_no) {
		setAttrVal("Upload_no", Upload_no);
	}
	/**
	 * 手册号
	 * @return String
	 */
	public String getHandbook_no() {
		return ((String) getAttrVal("Handbook_no"));
	}
	/**
	 * 手册号
	 * @param Handbook_no
	 */
	public void setHandbook_no(String Handbook_no) {
		setAttrVal("Handbook_no", Handbook_no);
	}
	/**
	 * 是否补打
	 * @return FBoolean
	 */
	public FBoolean getFg_add() {
		return ((FBoolean) getAttrVal("Fg_add"));
	}
	/**
	 * 是否补打
	 * @param Fg_add
	 */
	public void setFg_add(FBoolean Fg_add) {
		setAttrVal("Fg_add", Fg_add);
	}
	/**
	 * 当前票数
	 * @return Integer
	 */
	public Integer getCurnum() {
		return ((Integer) getAttrVal("Curnum"));
	}
	/**
	 * 当前票数
	 * @param Curnum
	 */
	public void setCurnum(Integer Curnum) {
		setAttrVal("Curnum", Curnum);
	}
	/**
	 * 总票数
	 * @return Integer
	 */
	public Integer getTotalnum() {
		return ((Integer) getAttrVal("Totalnum"));
	}
	/**
	 * 总票数
	 * @param Totalnum
	 */
	public void setTotalnum(Integer Totalnum) {
		setAttrVal("Totalnum", Totalnum);
	}
	/**
	 * 是否挂号发票
	 * @return FBoolean
	 */
	public FBoolean getFg_reg() {
		return ((FBoolean) getAttrVal("Fg_reg"));
	}
	/**
	 * 是否挂号发票
	 * @param Fg_reg
	 */
	public void setFg_reg(FBoolean Fg_reg) {
		setAttrVal("Fg_reg", Fg_reg);
	}/**
	 * 门诊发票主键
	 * @return String
	 */
	public String getId_incoep() {
		return ((String) getAttrVal("Id_incoep"));
	}
	/**
	 * 门诊发票主键
	 * @param Id_incoep
	 */
	public void setId_incoep(String Id_incoep) {
		setAttrVal("Id_incoep", Id_incoep);
	}
	/**
	 * 结算金额
	 * @return FDouble
	 */
	public FDouble getAmt_st() {
		return ((FDouble) getAttrVal("Amt_st"));
	}
	/**
	 * 结算金额
	 * @param Amt_st
	 */
	public void setAmt_st(FDouble Amt_st) {
		setAttrVal("Amt_st", Amt_st);
	}
}