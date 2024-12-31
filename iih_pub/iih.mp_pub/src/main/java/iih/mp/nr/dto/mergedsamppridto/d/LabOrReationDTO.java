package iih.mp.nr.dto.mergedsamppridto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 标本医嘱关系 DTO数据 
 * 
 */
public class LabOrReationDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标本ID
	 * @return String
	 */
	public String getId_labsamp() {
		return ((String) getAttrVal("Id_labsamp"));
	}
	/**
	 * 标本ID
	 * @param Id_labsamp
	 */
	public void setId_labsamp(String Id_labsamp) {
		setAttrVal("Id_labsamp", Id_labsamp);
	}
	/**
	 * 标本号
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}
	/**
	 * 标本号
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 服务标本费用id
	 * @return String
	 */
	public String getId_samppri_srv() {
		return ((String) getAttrVal("Id_samppri_srv"));
	}
	/**
	 * 服务标本费用id
	 * @param Id_samppri_srv
	 */
	public void setId_samppri_srv(String Id_samppri_srv) {
		setAttrVal("Id_samppri_srv", Id_samppri_srv);
	}
	/**
	 * 标本费用id
	 * @return String
	 */
	public String getId_samppri_samp() {
		return ((String) getAttrVal("Id_samppri_samp"));
	}
	/**
	 * 标本费用id
	 * @param Id_samppri_samp
	 */
	public void setId_samppri_samp(String Id_samppri_samp) {
		setAttrVal("Id_samppri_samp", Id_samppri_samp);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者价格分类
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}
	/**
	 * 患者价格分类
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 是否儿童
	 * @return FBoolean
	 */
	public FBoolean getFg_child() {
		return ((FBoolean) getAttrVal("Fg_child"));
	}
	/**
	 * 是否儿童
	 * @param Fg_child
	 */
	public void setFg_child(FBoolean Fg_child) {
		setAttrVal("Fg_child", Fg_child);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 费用类型
	 * @return Integer
	 */
	public Integer getEu_pritp() {
		return ((Integer) getAttrVal("Eu_pritp"));
	}
	/**
	 * 费用类型
	 * @param Eu_pritp
	 */
	public void setEu_pritp(Integer Eu_pritp) {
		setAttrVal("Eu_pritp", Eu_pritp);
	}
	/**
	 * 服务单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}
	/**
	 * 服务单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}
	/**
	 * 单价
	 * @param Pri
	 */
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}
	/**
	 * 数量
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 对照服务
	 * @return String
	 */
	public String getId_srv_const() {
		return ((String) getAttrVal("Id_srv_const"));
	}
	/**
	 * 对照服务
	 * @param Id_srv_const
	 */
	public void setId_srv_const(String Id_srv_const) {
		setAttrVal("Id_srv_const", Id_srv_const);
	}
	/**
	 * 对照服务单位
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}
	/**
	 * 对照服务单位
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 对照服务价格
	 * @return FDouble
	 */
	public FDouble getPri_const() {
		return ((FDouble) getAttrVal("Pri_const"));
	}
	/**
	 * 对照服务价格
	 * @param Pri_const
	 */
	public void setPri_const(FDouble Pri_const) {
		setAttrVal("Pri_const", Pri_const);
	}
	/**
	 * 服务启用状态
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 服务启用状态
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
}