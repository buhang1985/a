package iih.cssd.dpus.dto.dfpappdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 消毒包请领明细信息 DTO数据 
 * 
 */
public class DfpAppDetilDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 请领子项主键ID
	 * @return String
	 */
	public String getId_dfp_app_item() {
		return ((String) getAttrVal("Id_dfp_app_item"));
	}
	/**
	 * 请领子项主键ID
	 * @param Id_dfp_app_item
	 */
	public void setId_dfp_app_item(String Id_dfp_app_item) {
		setAttrVal("Id_dfp_app_item", Id_dfp_app_item);
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
	 * 请领单状态
	 * @return String
	 */
	public String getName_app_status() {
		return ((String) getAttrVal("Name_app_status"));
	}
	/**
	 * 请领单状态
	 * @param Name_app_status
	 */
	public void setName_app_status(String Name_app_status) {
		setAttrVal("Name_app_status", Name_app_status);
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
	 * 请领人
	 * @return String
	 */
	public String getName_emp_app() {
		return ((String) getAttrVal("Name_emp_app"));
	}
	/**
	 * 请领人
	 * @param Name_emp_app
	 */
	public void setName_emp_app(String Name_emp_app) {
		setAttrVal("Name_emp_app", Name_emp_app);
	}
	/**
	 * 请领包类型
	 * @return String
	 */
	public String getPkg_tp() {
		return ((String) getAttrVal("Pkg_tp"));
	}
	/**
	 * 请领包类型
	 * @param Pkg_tp
	 */
	public void setPkg_tp(String Pkg_tp) {
		setAttrVal("Pkg_tp", Pkg_tp);
	}
	/**
	 * 包识别码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}
	/**
	 * 包识别码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
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
	 * 接收时间
	 * @return FDateTime
	 */
	public FDateTime getDt_rcv() {
		return ((FDateTime) getAttrVal("Dt_rcv"));
	}
	/**
	 * 接收时间
	 * @param Dt_rcv
	 */
	public void setDt_rcv(FDateTime Dt_rcv) {
		setAttrVal("Dt_rcv", Dt_rcv);
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
	 * 接收科室
	 * @return String
	 */
	public String getName_dep_rcv() {
		return ((String) getAttrVal("Name_dep_rcv"));
	}
	/**
	 * 接收科室
	 * @param Name_dep_rcv
	 */
	public void setName_dep_rcv(String Name_dep_rcv) {
		setAttrVal("Name_dep_rcv", Name_dep_rcv);
	}
	/**
	 * 驳回/拒发原因
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 驳回/拒发原因
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 消毒包id
	 * @return String
	 */
	public String getId_pkg() {
		return ((String) getAttrVal("Id_pkg"));
	}
	/**
	 * 消毒包id
	 * @param Id_pkg
	 */
	public void setId_pkg(String Id_pkg) {
		setAttrVal("Id_pkg", Id_pkg);
	}
	/**
	 * 消毒包名称
	 * @return String
	 */
	public String getName_pkg() {
		return ((String) getAttrVal("Name_pkg"));
	}
	/**
	 * 消毒包名称
	 * @param Name_pkg
	 */
	public void setName_pkg(String Name_pkg) {
		setAttrVal("Name_pkg", Name_pkg);
	}
}