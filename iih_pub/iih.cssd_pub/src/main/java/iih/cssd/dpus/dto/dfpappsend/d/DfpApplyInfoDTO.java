package iih.cssd.dpus.dto.dfpappsend.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 请领单明细 DTO数据 
 * 
 */
public class DfpApplyInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 请领主键
	 * @return String
	 */
	public String getId_dfp_app() {
		return ((String) getAttrVal("Id_dfp_app"));
	}
	/**
	 * 请领主键
	 * @param Id_dfp_app
	 */
	public void setId_dfp_app(String Id_dfp_app) {
		setAttrVal("Id_dfp_app", Id_dfp_app);
	}
	/**
	 * 请领子项主键
	 * @return String
	 */
	public String getId_dfp_app_itm() {
		return ((String) getAttrVal("Id_dfp_app_itm"));
	}
	/**
	 * 请领子项主键
	 * @param Id_dfp_app_itm
	 */
	public void setId_dfp_app_itm(String Id_dfp_app_itm) {
		setAttrVal("Id_dfp_app_itm", Id_dfp_app_itm);
	}
	/**
	 * 消毒包主键
	 * @return String
	 */
	public String getId_dfp() {
		return ((String) getAttrVal("Id_dfp"));
	}
	/**
	 * 消毒包主键
	 * @param Id_dfp
	 */
	public void setId_dfp(String Id_dfp) {
		setAttrVal("Id_dfp", Id_dfp);
	}
	/**
	 * 发放主键
	 * @return String
	 */
	public String getId_dfp_send() {
		return ((String) getAttrVal("Id_dfp_send"));
	}
	/**
	 * 发放主键
	 * @param Id_dfp_send
	 */
	public void setId_dfp_send(String Id_dfp_send) {
		setAttrVal("Id_dfp_send", Id_dfp_send);
	}
	/**
	 * 包定义主键
	 * @return String
	 */
	public String getId_pkg() {
		return ((String) getAttrVal("Id_pkg"));
	}
	/**
	 * 包定义主键
	 * @param Id_pkg
	 */
	public void setId_pkg(String Id_pkg) {
		setAttrVal("Id_pkg", Id_pkg);
	}
	/**
	 * 请领单号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}
	/**
	 * 请领单号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 请领科室id
	 * @return String
	 */
	public String getId_dep_apply() {
		return ((String) getAttrVal("Id_dep_apply"));
	}
	/**
	 * 请领科室id
	 * @param Id_dep_apply
	 */
	public void setId_dep_apply(String Id_dep_apply) {
		setAttrVal("Id_dep_apply", Id_dep_apply);
	}
	/**
	 * 请领科室
	 * @return String
	 */
	public String getName_dep_apply() {
		return ((String) getAttrVal("Name_dep_apply"));
	}
	/**
	 * 请领科室
	 * @param Name_dep_apply
	 */
	public void setName_dep_apply(String Name_dep_apply) {
		setAttrVal("Name_dep_apply", Name_dep_apply);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 请领包类型id
	 * @return String
	 */
	public String getId_app_type() {
		return ((String) getAttrVal("Id_app_type"));
	}
	/**
	 * 请领包类型id
	 * @param Id_app_type
	 */
	public void setId_app_type(String Id_app_type) {
		setAttrVal("Id_app_type", Id_app_type);
	}
	/**
	 * 请领包类型编码
	 * @return String
	 */
	public String getSd_app_type() {
		return ((String) getAttrVal("Sd_app_type"));
	}
	/**
	 * 请领包类型编码
	 * @param Sd_app_type
	 */
	public void setSd_app_type(String Sd_app_type) {
		setAttrVal("Sd_app_type", Sd_app_type);
	}
	/**
	 * 请领包类型
	 * @return String
	 */
	public String getName_app_type() {
		return ((String) getAttrVal("Name_app_type"));
	}
	/**
	 * 请领包类型
	 * @param Name_app_type
	 */
	public void setName_app_type(String Name_app_type) {
		setAttrVal("Name_app_type", Name_app_type);
	}
	/**
	 * 数量
	 * @return String
	 */
	public String getCount() {
		return ((String) getAttrVal("Count"));
	}
	/**
	 * 数量
	 * @param Count
	 */
	public void setCount(String Count) {
		setAttrVal("Count", Count);
	}
	/**
	 * 请领时间
	 * @return String
	 */
	public String getDt_apply() {
		return ((String) getAttrVal("Dt_apply"));
	}
	/**
	 * 请领时间
	 * @param Dt_apply
	 */
	public void setDt_apply(String Dt_apply) {
		setAttrVal("Dt_apply", Dt_apply);
	}
	/**
	 * 请领人id
	 * @return String
	 */
	public String getId_emp_apply() {
		return ((String) getAttrVal("Id_emp_apply"));
	}
	/**
	 * 请领人id
	 * @param Id_emp_apply
	 */
	public void setId_emp_apply(String Id_emp_apply) {
		setAttrVal("Id_emp_apply", Id_emp_apply);
	}
	/**
	 * 请领人
	 * @return String
	 */
	public String getName_emp_apply() {
		return ((String) getAttrVal("Name_emp_apply"));
	}
	/**
	 * 请领人
	 * @param Name_emp_apply
	 */
	public void setName_emp_apply(String Name_emp_apply) {
		setAttrVal("Name_emp_apply", Name_emp_apply);
	}
	/**
	 * 发放时间
	 * @return String
	 */
	public String getDt_send() {
		return ((String) getAttrVal("Dt_send"));
	}
	/**
	 * 发放时间
	 * @param Dt_send
	 */
	public void setDt_send(String Dt_send) {
		setAttrVal("Dt_send", Dt_send);
	}
	/**
	 * 发放人id
	 * @return String
	 */
	public String getId_emp_send() {
		return ((String) getAttrVal("Id_emp_send"));
	}
	/**
	 * 发放人id
	 * @param Id_emp_send
	 */
	public void setId_emp_send(String Id_emp_send) {
		setAttrVal("Id_emp_send", Id_emp_send);
	}
	/**
	 * 发放人
	 * @return String
	 */
	public String getName_emp_send() {
		return ((String) getAttrVal("Name_emp_send"));
	}
	/**
	 * 发放人
	 * @param Name_emp_send
	 */
	public void setName_emp_send(String Name_emp_send) {
		setAttrVal("Name_emp_send", Name_emp_send);
	}
	/**
	 * 发放备注
	 * @return String
	 */
	public String getDes_send() {
		return ((String) getAttrVal("Des_send"));
	}
	/**
	 * 发放备注
	 * @param Des_send
	 */
	public void setDes_send(String Des_send) {
		setAttrVal("Des_send", Des_send);
	}
	/**
	 * 发送单号
	 * @return String
	 */
	public String getSendno() {
		return ((String) getAttrVal("Sendno"));
	}
	/**
	 * 发送单号
	 * @param Sendno
	 */
	public void setSendno(String Sendno) {
		setAttrVal("Sendno", Sendno);
	}
	/**
	 * 识别码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 识别码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 消毒包类型id
	 * @return String
	 */
	public String getId_pkgtp() {
		return ((String) getAttrVal("Id_pkgtp"));
	}
	/**
	 * 消毒包类型id
	 * @param Id_pkgtp
	 */
	public void setId_pkgtp(String Id_pkgtp) {
		setAttrVal("Id_pkgtp", Id_pkgtp);
	}
	/**
	 * 消毒包类型编码
	 * @return String
	 */
	public String getSd_pkgtp() {
		return ((String) getAttrVal("Sd_pkgtp"));
	}
	/**
	 * 消毒包类型编码
	 * @param Sd_pkgtp
	 */
	public void setSd_pkgtp(String Sd_pkgtp) {
		setAttrVal("Sd_pkgtp", Sd_pkgtp);
	}
	/**
	 * 消毒包类型
	 * @return String
	 */
	public String getName_pkgtp() {
		return ((String) getAttrVal("Name_pkgtp"));
	}
	/**
	 * 消毒包类型
	 * @param Name_pkgtp
	 */
	public void setName_pkgtp(String Name_pkgtp) {
		setAttrVal("Name_pkgtp", Name_pkgtp);
	}
	/**
	 * 包装材料id
	 * @return String
	 */
	public String getId_pkgmtr() {
		return ((String) getAttrVal("Id_pkgmtr"));
	}
	/**
	 * 包装材料id
	 * @param Id_pkgmtr
	 */
	public void setId_pkgmtr(String Id_pkgmtr) {
		setAttrVal("Id_pkgmtr", Id_pkgmtr);
	}
	/**
	 * 包装材料编码
	 * @return String
	 */
	public String getSd_pkgmtr() {
		return ((String) getAttrVal("Sd_pkgmtr"));
	}
	/**
	 * 包装材料编码
	 * @param Sd_pkgmtr
	 */
	public void setSd_pkgmtr(String Sd_pkgmtr) {
		setAttrVal("Sd_pkgmtr", Sd_pkgmtr);
	}
	/**
	 * 包装材料
	 * @return String
	 */
	public String getName_pkgmtr() {
		return ((String) getAttrVal("Name_pkgmtr"));
	}
	/**
	 * 包装材料
	 * @param Name_pkgmtr
	 */
	public void setName_pkgmtr(String Name_pkgmtr) {
		setAttrVal("Name_pkgmtr", Name_pkgmtr);
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
	 * 接收人id
	 * @return String
	 */
	public String getId_emp_rcv() {
		return ((String) getAttrVal("Id_emp_rcv"));
	}
	/**
	 * 接收人id
	 * @param Id_emp_rcv
	 */
	public void setId_emp_rcv(String Id_emp_rcv) {
		setAttrVal("Id_emp_rcv", Id_emp_rcv);
	}
	/**
	 * 接收人
	 * @return String
	 */
	public String getName_emp_rcv() {
		return ((String) getAttrVal("Name_emp_rcv"));
	}
	/**
	 * 接收人
	 * @param Name_emp_rcv
	 */
	public void setName_emp_rcv(String Name_emp_rcv) {
		setAttrVal("Name_emp_rcv", Name_emp_rcv);
	}
	/**
	 * 接收时间
	 * @return String
	 */
	public String getDt_rcv() {
		return ((String) getAttrVal("Dt_rcv"));
	}
	/**
	 * 接收时间
	 * @param Dt_rcv
	 */
	public void setDt_rcv(String Dt_rcv) {
		setAttrVal("Dt_rcv", Dt_rcv);
	}
	/**
	 * 校验码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}
	/**
	 * 校验码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 消毒包状态
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}
	/**
	 * 消毒包状态
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 是否已绑定
	 * @return FBoolean
	 */
	public FBoolean getFg_bind() {
		return ((FBoolean) getAttrVal("Fg_bind"));
	}
	/**
	 * 是否已绑定
	 * @param Fg_bind
	 */
	public void setFg_bind(FBoolean Fg_bind) {
		setAttrVal("Fg_bind", Fg_bind);
	}
}