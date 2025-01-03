package iih.ci.ord.i.external.provide.meta.mr.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 提供给病历的医嘱信息DTO DTO数据 
 * 
 */
public class CiOrdInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱项目类型编码
	 * @return String
	 */
	public String getOrdertypecode() {
		return ((String) getAttrVal("Ordertypecode"));
	}
	/**
	 * 医嘱项目类型编码
	 * @param Ordertypecode
	 */
	public void setOrdertypecode(String Ordertypecode) {
		setAttrVal("Ordertypecode", Ordertypecode);
	}
	/**
	 * 医嘱项目类型名称
	 * @return String
	 */
	public String getOrdertypename() {
		return ((String) getAttrVal("Ordertypename"));
	}
	/**
	 * 医嘱项目类型名称
	 * @param Ordertypename
	 */
	public void setOrdertypename(String Ordertypename) {
		setAttrVal("Ordertypename", Ordertypename);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getOrdercontent() {
		return ((String) getAttrVal("Ordercontent"));
	}
	/**
	 * 医嘱内容
	 * @param Ordercontent
	 */
	public void setOrdercontent(String Ordercontent) {
		setAttrVal("Ordercontent", Ordercontent);
	}
	/**
	 * 医嘱计划开始日期时间
	 * @return FDateTime
	 */
	public FDateTime getOrderplanstartdate() {
		return ((FDateTime) getAttrVal("Orderplanstartdate"));
	}
	/**
	 * 医嘱计划开始日期时间
	 * @param Orderplanstartdate
	 */
	public void setOrderplanstartdate(FDateTime Orderplanstartdate) {
		setAttrVal("Orderplanstartdate", Orderplanstartdate);
	}
	/**
	 * 医嘱计划结束日期时间
	 * @return FDateTime
	 */
	public FDateTime getOrderplanenddate() {
		return ((FDateTime) getAttrVal("Orderplanenddate"));
	}
	/**
	 * 医嘱计划结束日期时间
	 * @param Orderplanenddate
	 */
	public void setOrderplanenddate(FDateTime Orderplanenddate) {
		setAttrVal("Orderplanenddate", Orderplanenddate);
	}
	/**
	 * 医嘱执行日期时间
	 * @return FDateTime
	 */
	public FDateTime getExecutetime() {
		return ((FDateTime) getAttrVal("Executetime"));
	}
	/**
	 * 医嘱执行日期时间
	 * @param Executetime
	 */
	public void setExecutetime(FDateTime Executetime) {
		setAttrVal("Executetime", Executetime);
	}
	/**
	 * 医嘱执行者编码
	 * @return String
	 */
	public String getExecutepersoncode() {
		return ((String) getAttrVal("Executepersoncode"));
	}
	/**
	 * 医嘱执行者编码
	 * @param Executepersoncode
	 */
	public void setExecutepersoncode(String Executepersoncode) {
		setAttrVal("Executepersoncode", Executepersoncode);
	}
	/**
	 * 医嘱执行者名称
	 * @return String
	 */
	public String getExecutepersonname() {
		return ((String) getAttrVal("Executepersonname"));
	}
	/**
	 * 医嘱执行者名称
	 * @param Executepersonname
	 */
	public void setExecutepersonname(String Executepersonname) {
		setAttrVal("Executepersonname", Executepersonname);
	}
	/**
	 * 医嘱执行科室名称
	 * @return String
	 */
	public String getExecutedeptname() {
		return ((String) getAttrVal("Executedeptname"));
	}
	/**
	 * 医嘱执行科室名称
	 * @param Executedeptname
	 */
	public void setExecutedeptname(String Executedeptname) {
		setAttrVal("Executedeptname", Executedeptname);
	}
	/**
	 * 医嘱开立日期时间
	 * @return FDateTime
	 */
	public FDateTime getOrdertime() {
		return ((FDateTime) getAttrVal("Ordertime"));
	}
	/**
	 * 医嘱开立日期时间
	 * @param Ordertime
	 */
	public void setOrdertime(FDateTime Ordertime) {
		setAttrVal("Ordertime", Ordertime);
	}
	/**
	 * 医嘱开立者编码
	 * @return String
	 */
	public String getOrderdoccode() {
		return ((String) getAttrVal("Orderdoccode"));
	}
	/**
	 * 医嘱开立者编码
	 * @param Orderdoccode
	 */
	public void setOrderdoccode(String Orderdoccode) {
		setAttrVal("Orderdoccode", Orderdoccode);
	}
	/**
	 * 医嘱开立者名称
	 * @return String
	 */
	public String getOrderdocname() {
		return ((String) getAttrVal("Orderdocname"));
	}
	/**
	 * 医嘱开立者名称
	 * @param Orderdocname
	 */
	public void setOrderdocname(String Orderdocname) {
		setAttrVal("Orderdocname", Orderdocname);
	}
	/**
	 * 医嘱开立科室
	 * @return String
	 */
	public String getOrderdeptname() {
		return ((String) getAttrVal("Orderdeptname"));
	}
	/**
	 * 医嘱开立科室
	 * @param Orderdeptname
	 */
	public void setOrderdeptname(String Orderdeptname) {
		setAttrVal("Orderdeptname", Orderdeptname);
	}
	/**
	 * 医嘱审核日期时间
	 * @return FDateTime
	 */
	public FDateTime getOrderconfirmdate() {
		return ((FDateTime) getAttrVal("Orderconfirmdate"));
	}
	/**
	 * 医嘱审核日期时间
	 * @param Orderconfirmdate
	 */
	public void setOrderconfirmdate(FDateTime Orderconfirmdate) {
		setAttrVal("Orderconfirmdate", Orderconfirmdate);
	}
	/**
	 * 医嘱审核者编码
	 * @return String
	 */
	public String getConfirmdoccode() {
		return ((String) getAttrVal("Confirmdoccode"));
	}
	/**
	 * 医嘱审核者编码
	 * @param Confirmdoccode
	 */
	public void setConfirmdoccode(String Confirmdoccode) {
		setAttrVal("Confirmdoccode", Confirmdoccode);
	}
	/**
	 * 医嘱审核者名称
	 * @return String
	 */
	public String getConfirmdocname() {
		return ((String) getAttrVal("Confirmdocname"));
	}
	/**
	 * 医嘱审核者名称
	 * @param Confirmdocname
	 */
	public void setConfirmdocname(String Confirmdocname) {
		setAttrVal("Confirmdocname", Confirmdocname);
	}
	/**
	 * 医嘱取消日期时间
	 * @return FDateTime
	 */
	public FDateTime getCanceltime() {
		return ((FDateTime) getAttrVal("Canceltime"));
	}
	/**
	 * 医嘱取消日期时间
	 * @param Canceltime
	 */
	public void setCanceltime(FDateTime Canceltime) {
		setAttrVal("Canceltime", Canceltime);
	}
	/**
	 * 医嘱取消者编码
	 * @return String
	 */
	public String getCancelperson() {
		return ((String) getAttrVal("Cancelperson"));
	}
	/**
	 * 医嘱取消者编码
	 * @param Cancelperson
	 */
	public void setCancelperson(String Cancelperson) {
		setAttrVal("Cancelperson", Cancelperson);
	}
	/**
	 * 医嘱取消者名称
	 * @return String
	 */
	public String getCancelpersonname() {
		return ((String) getAttrVal("Cancelpersonname"));
	}
	/**
	 * 医嘱取消者名称
	 * @param Cancelpersonname
	 */
	public void setCancelpersonname(String Cancelpersonname) {
		setAttrVal("Cancelpersonname", Cancelpersonname);
	}
	/**
	 * 医嘱备注
	 * @return String
	 */
	public String getOrderremarks() {
		return ((String) getAttrVal("Orderremarks"));
	}
	/**
	 * 医嘱备注
	 * @param Orderremarks
	 */
	public void setOrderremarks(String Orderremarks) {
		setAttrVal("Orderremarks", Orderremarks);
	}
	/**
	 * 医嘱执行状态
	 * @return String
	 */
	public String getOrderstatus() {
		return ((String) getAttrVal("Orderstatus"));
	}
	/**
	 * 医嘱执行状态
	 * @param Orderstatus
	 */
	public void setOrderstatus(String Orderstatus) {
		setAttrVal("Orderstatus", Orderstatus);
	}
}