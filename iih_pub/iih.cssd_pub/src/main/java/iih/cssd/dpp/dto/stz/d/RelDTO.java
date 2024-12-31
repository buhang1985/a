package iih.cssd.dpp.dto.stz.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 关系dto DTO数据 
 * 
 */
public class RelDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 消毒包关系主键
	 * @return String
	 */
	public String getId_dfp_rel() {
		return ((String) getAttrVal("Id_dfp_rel"));
	}
	/**
	 * 消毒包关系主键
	 * @param Id_dfp_rel
	 */
	public void setId_dfp_rel(String Id_dfp_rel) {
		setAttrVal("Id_dfp_rel", Id_dfp_rel);
	}
	/**
	 * 唯一编码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}
	/**
	 * 唯一编码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 消毒器械主键
	 * @return String
	 */
	public String getId_instr() {
		return ((String) getAttrVal("Id_instr"));
	}
	/**
	 * 消毒器械主键
	 * @param Id_instr
	 */
	public void setId_instr(String Id_instr) {
		setAttrVal("Id_instr", Id_instr);
	}
	/**
	 * 消毒器械名称
	 * @return String
	 */
	public String getName_instr() {
		return ((String) getAttrVal("Name_instr"));
	}
	/**
	 * 消毒器械名称
	 * @param Name_instr
	 */
	public void setName_instr(String Name_instr) {
		setAttrVal("Name_instr", Name_instr);
	}
	/**
	 * 父id
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}
	/**
	 * 父id
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	/**
	 * 包主键
	 * @return String
	 */
	public String getId_pkg() {
		return ((String) getAttrVal("Id_pkg"));
	}
	/**
	 * 包主键
	 * @param Id_pkg
	 */
	public void setId_pkg(String Id_pkg) {
		setAttrVal("Id_pkg", Id_pkg);
	}
	/**
	 * 包名称
	 * @return String
	 */
	public String getName_pkg() {
		return ((String) getAttrVal("Name_pkg"));
	}
	/**
	 * 包名称
	 * @param Name_pkg
	 */
	public void setName_pkg(String Name_pkg) {
		setAttrVal("Name_pkg", Name_pkg);
	}
	/**
	 * 消毒包标记
	 * @return FBoolean
	 */
	public FBoolean getFg_pkg() {
		return ((FBoolean) getAttrVal("Fg_pkg"));
	}
	/**
	 * 消毒包标记
	 * @param Fg_pkg
	 */
	public void setFg_pkg(FBoolean Fg_pkg) {
		setAttrVal("Fg_pkg", Fg_pkg);
	}
	/**
	 * 生效标记
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 生效标记
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 子类集合
	 * @return FArrayList
	 */
	public FArrayList getChilds() {
		return ((FArrayList) getAttrVal("Childs"));
	}
	/**
	 * 子类集合
	 * @param Childs
	 */
	public void setChilds(FArrayList Childs) {
		setAttrVal("Childs", Childs);
	}
	/**
	 * 灭菌包类型id
	 * @return String
	 */
	public String getId_tp() {
		return ((String) getAttrVal("Id_tp"));
	}
	/**
	 * 灭菌包类型id
	 * @param Id_tp
	 */
	public void setId_tp(String Id_tp) {
		setAttrVal("Id_tp", Id_tp);
	}
	/**
	 * 灭菌包类型sd
	 * @return String
	 */
	public String getSd_tp() {
		return ((String) getAttrVal("Sd_tp"));
	}
	/**
	 * 灭菌包类型sd
	 * @param Sd_tp
	 */
	public void setSd_tp(String Sd_tp) {
		setAttrVal("Sd_tp", Sd_tp);
	}
	/**
	 * 灭菌包类型名称
	 * @return String
	 */
	public String getName_tp() {
		return ((String) getAttrVal("Name_tp"));
	}
	/**
	 * 灭菌包类型名称
	 * @param Name_tp
	 */
	public void setName_tp(String Name_tp) {
		setAttrVal("Name_tp", Name_tp);
	}
	/**
	 * 最大装载量
	 * @return Integer
	 */
	public Integer getMaxnum() {
		return ((Integer) getAttrVal("Maxnum"));
	}
	/**
	 * 最大装载量
	 * @param Maxnum
	 */
	public void setMaxnum(Integer Maxnum) {
		setAttrVal("Maxnum", Maxnum);
	}
}