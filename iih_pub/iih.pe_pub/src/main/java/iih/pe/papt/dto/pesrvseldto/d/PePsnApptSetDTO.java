package iih.pe.papt.dto.pesrvseldto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检个人预约套餐DTO DTO数据 
 * 
 */
public class PePsnApptSetDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检预约套餐主键标识
	 * @return String
	 */
	public String getId_pepsnapptset() {
		return ((String) getAttrVal("Id_pepsnapptset"));
	}
	/**
	 * 体检预约套餐主键标识
	 * @param Id_pepsnapptset
	 */
	public void setId_pepsnapptset(String Id_pepsnapptset) {
		setAttrVal("Id_pepsnapptset", Id_pepsnapptset);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 体检团体预约分组ID
	 * @return String
	 */
	public String getId_pecorpapptgrp() {
		return ((String) getAttrVal("Id_pecorpapptgrp"));
	}
	/**
	 * 体检团体预约分组ID
	 * @param Id_pecorpapptgrp
	 */
	public void setId_pecorpapptgrp(String Id_pecorpapptgrp) {
		setAttrVal("Id_pecorpapptgrp", Id_pecorpapptgrp);
	}
	/**
	 * 体检套餐定义ID
	 * @return String
	 */
	public String getId_pesrvsetdef() {
		return ((String) getAttrVal("Id_pesrvsetdef"));
	}
	/**
	 * 体检套餐定义ID
	 * @param Id_pesrvsetdef
	 */
	public void setId_pesrvsetdef(String Id_pesrvsetdef) {
		setAttrVal("Id_pesrvsetdef", Id_pesrvsetdef);
	}
	/**
	 * 体检项目ID
	 * @return String
	 */
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}
	/**
	 * 体检项目ID
	 * @param Id_pesrvbcatlog
	 */
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
	}
	/**
	 * 所属套餐ID
	 * @return String
	 */
	public String getId_pesrvsetdef_owner() {
		return ((String) getAttrVal("Id_pesrvsetdef_owner"));
	}
	/**
	 * 所属套餐ID
	 * @param Id_pesrvsetdef_owner
	 */
	public void setId_pesrvsetdef_owner(String Id_pesrvsetdef_owner) {
		setAttrVal("Id_pesrvsetdef_owner", Id_pesrvsetdef_owner);
	}
	/**
	 * 体检套餐项目区分标识
	 * @return Integer
	 */
	public Integer getFg_setitem() {
		return ((Integer) getAttrVal("Fg_setitem"));
	}
	/**
	 * 体检套餐项目区分标识
	 * @param Fg_setitem
	 */
	public void setFg_setitem(Integer Fg_setitem) {
		setAttrVal("Fg_setitem", Fg_setitem);
	}
	/**
	 * 新增删除标识
	 * @return FBoolean
	 */
	public FBoolean getFg_oper() {
		return ((FBoolean) getAttrVal("Fg_oper"));
	}
	/**
	 * 新增删除标识
	 * @param Fg_oper
	 */
	public void setFg_oper(FBoolean Fg_oper) {
		setAttrVal("Fg_oper", Fg_oper);
	}
	/**
	 * 个人支付标识
	 * @return FBoolean
	 */
	public FBoolean getFg_payself() {
		return ((FBoolean) getAttrVal("Fg_payself"));
	}
	/**
	 * 个人支付标识
	 * @param Fg_payself
	 */
	public void setFg_payself(FBoolean Fg_payself) {
		setAttrVal("Fg_payself", Fg_payself);
	}
	/**
	 * 个人团体标识
	 * @return FBoolean
	 */
	public FBoolean getFg_psn() {
		return ((FBoolean) getAttrVal("Fg_psn"));
	}
	/**
	 * 个人团体标识
	 * @param Fg_psn
	 */
	public void setFg_psn(FBoolean Fg_psn) {
		setAttrVal("Fg_psn", Fg_psn);
	}
	/**
	 * 折扣
	 * @return FDouble
	 */
	public FDouble getDiscount() {
		return ((FDouble) getAttrVal("Discount"));
	}
	/**
	 * 折扣
	 * @param Discount
	 */
	public void setDiscount(FDouble Discount) {
		setAttrVal("Discount", Discount);
	}
	/**
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 套餐或项目名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 套餐或项目名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
}