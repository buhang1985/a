package iih.cssd.dpus.dto.dfprev.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 消毒包接收 DTO数据 
 * 
 */
public class DfpRevDTO extends BaseDTO {
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
	 * 请领子项主键
	 * @return String
	 */
	public String getId_dfp_app_item() {
		return ((String) getAttrVal("Id_dfp_app_item"));
	}
	/**
	 * 请领子项主键
	 * @param Id_dfp_app_item
	 */
	public void setId_dfp_app_item(String Id_dfp_app_item) {
		setAttrVal("Id_dfp_app_item", Id_dfp_app_item);
	}
	/**
	 * 识别码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}
	/**
	 * 识别码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 消毒包id
	 * @return String
	 */
	public String getId_dfp() {
		return ((String) getAttrVal("Id_dfp"));
	}
	/**
	 * 消毒包id
	 * @param Id_dfp
	 */
	public void setId_dfp(String Id_dfp) {
		setAttrVal("Id_dfp", Id_dfp);
	}
	/**
	 * 消毒包名称
	 * @return String
	 */
	public String getName_dfp() {
		return ((String) getAttrVal("Name_dfp"));
	}
	/**
	 * 消毒包名称
	 * @param Name_dfp
	 */
	public void setName_dfp(String Name_dfp) {
		setAttrVal("Name_dfp", Name_dfp);
	}
	/**
	 * 消毒包类型
	 * @return String
	 */
	public String getId_pkgtp() {
		return ((String) getAttrVal("Id_pkgtp"));
	}
	/**
	 * 消毒包类型
	 * @param Id_pkgtp
	 */
	public void setId_pkgtp(String Id_pkgtp) {
		setAttrVal("Id_pkgtp", Id_pkgtp);
	}
	/**
	 * 消毒包类型名称
	 * @return String
	 */
	public String getName_pkgtp() {
		return ((String) getAttrVal("Name_pkgtp"));
	}
	/**
	 * 消毒包类型名称
	 * @param Name_pkgtp
	 */
	public void setName_pkgtp(String Name_pkgtp) {
		setAttrVal("Name_pkgtp", Name_pkgtp);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 请领科室id
	 * @return String
	 */
	public String getId_dep_app() {
		return ((String) getAttrVal("Id_dep_app"));
	}
	/**
	 * 请领科室id
	 * @param Id_dep_app
	 */
	public void setId_dep_app(String Id_dep_app) {
		setAttrVal("Id_dep_app", Id_dep_app);
	}
	/**
	 * 请领科室名称
	 * @return String
	 */
	public String getName_dep_app() {
		return ((String) getAttrVal("Name_dep_app"));
	}
	/**
	 * 请领科室名称
	 * @param Name_dep_app
	 */
	public void setName_dep_app(String Name_dep_app) {
		setAttrVal("Name_dep_app", Name_dep_app);
	}
	/**
	 * 请领人id
	 * @return String
	 */
	public String getId_emp_app() {
		return ((String) getAttrVal("Id_emp_app"));
	}
	/**
	 * 请领人id
	 * @param Id_emp_app
	 */
	public void setId_emp_app(String Id_emp_app) {
		setAttrVal("Id_emp_app", Id_emp_app);
	}
	/**
	 * 请领人名称
	 * @return String
	 */
	public String getName_emp_app() {
		return ((String) getAttrVal("Name_emp_app"));
	}
	/**
	 * 请领人名称
	 * @param Name_emp_app
	 */
	public void setName_emp_app(String Name_emp_app) {
		setAttrVal("Name_emp_app", Name_emp_app);
	}
	/**
	 * 请领时间
	 * @return FDateTime
	 */
	public FDateTime getDt_app() {
		return ((FDateTime) getAttrVal("Dt_app"));
	}
	/**
	 * 请领时间
	 * @param Dt_app
	 */
	public void setDt_app(FDateTime Dt_app) {
		setAttrVal("Dt_app", Dt_app);
	}
	/**
	 * 发放科室id
	 * @return String
	 */
	public String getId_dep_send() {
		return ((String) getAttrVal("Id_dep_send"));
	}
	/**
	 * 发放科室id
	 * @param Id_dep_send
	 */
	public void setId_dep_send(String Id_dep_send) {
		setAttrVal("Id_dep_send", Id_dep_send);
	}
	/**
	 * 发放科室名称
	 * @return String
	 */
	public String getName_dep_send() {
		return ((String) getAttrVal("Name_dep_send"));
	}
	/**
	 * 发放科室名称
	 * @param Name_dep_send
	 */
	public void setName_dep_send(String Name_dep_send) {
		setAttrVal("Name_dep_send", Name_dep_send);
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
	 * 发放人名称
	 * @return String
	 */
	public String getName_emp_send() {
		return ((String) getAttrVal("Name_emp_send"));
	}
	/**
	 * 发放人名称
	 * @param Name_emp_send
	 */
	public void setName_emp_send(String Name_emp_send) {
		setAttrVal("Name_emp_send", Name_emp_send);
	}
	/**
	 * 发放时间
	 * @return FDateTime
	 */
	public FDateTime getDt_send() {
		return ((FDateTime) getAttrVal("Dt_send"));
	}
	/**
	 * 发放时间
	 * @param Dt_send
	 */
	public void setDt_send(FDateTime Dt_send) {
		setAttrVal("Dt_send", Dt_send);
	}
	/**
	 * 发放备注
	 * @return String
	 */
	public String getNote_send() {
		return ((String) getAttrVal("Note_send"));
	}
	/**
	 * 发放备注
	 * @param Note_send
	 */
	public void setNote_send(String Note_send) {
		setAttrVal("Note_send", Note_send);
	}
	/**
	 * 接收科室id
	 * @return String
	 */
	public String getId_dep_rev() {
		return ((String) getAttrVal("Id_dep_rev"));
	}
	/**
	 * 接收科室id
	 * @param Id_dep_rev
	 */
	public void setId_dep_rev(String Id_dep_rev) {
		setAttrVal("Id_dep_rev", Id_dep_rev);
	}
	/**
	 * 接收科室名称
	 * @return String
	 */
	public String getName_dep_rev() {
		return ((String) getAttrVal("Name_dep_rev"));
	}
	/**
	 * 接收科室名称
	 * @param Name_dep_rev
	 */
	public void setName_dep_rev(String Name_dep_rev) {
		setAttrVal("Name_dep_rev", Name_dep_rev);
	}
	/**
	 * 接收人id
	 * @return String
	 */
	public String getId_emp_rev() {
		return ((String) getAttrVal("Id_emp_rev"));
	}
	/**
	 * 接收人id
	 * @param Id_emp_rev
	 */
	public void setId_emp_rev(String Id_emp_rev) {
		setAttrVal("Id_emp_rev", Id_emp_rev);
	}
	/**
	 * 接收人名称
	 * @return String
	 */
	public String getName_emp_rev() {
		return ((String) getAttrVal("Name_emp_rev"));
	}
	/**
	 * 接收人名称
	 * @param Name_emp_rev
	 */
	public void setName_emp_rev(String Name_emp_rev) {
		setAttrVal("Name_emp_rev", Name_emp_rev);
	}
	/**
	 * 接收时间
	 * @return FDateTime
	 */
	public FDateTime getDt_rev() {
		return ((FDateTime) getAttrVal("Dt_rev"));
	}
	/**
	 * 接收时间
	 * @param Dt_rev
	 */
	public void setDt_rev(FDateTime Dt_rev) {
		setAttrVal("Dt_rev", Dt_rev);
	}
	/**
	 * 高亮显示
	 * @return FBoolean
	 */
	public FBoolean getFg_highlight() {
		return ((FBoolean) getAttrVal("Fg_highlight"));
	}
	/**
	 * 高亮显示
	 * @param Fg_highlight
	 */
	public void setFg_highlight(FBoolean Fg_highlight) {
		setAttrVal("Fg_highlight", Fg_highlight);
	}
	/**
	 * 接收标记
	 * @return FBoolean
	 */
	public FBoolean getFg_rcv() {
		return ((FBoolean) getAttrVal("Fg_rcv"));
	}
	/**
	 * 接收标记
	 * @param Fg_rcv
	 */
	public void setFg_rcv(FBoolean Fg_rcv) {
		setAttrVal("Fg_rcv", Fg_rcv);
	}
	/**
	 * 包状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 包状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 包状态
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}
	/**
	 * 包状态
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
}