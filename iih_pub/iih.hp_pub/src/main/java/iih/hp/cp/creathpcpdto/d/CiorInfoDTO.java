package iih.hp.cp.creathpcpdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱信息 DTO数据 
 * 
 */
public class CiorInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 起始
	 * @return Integer
	 */
	public Integer getBegin() {
		return ((Integer) getAttrVal("Begin"));
	}
	/**
	 * 起始
	 * @param Begin
	 */
	public void setBegin(Integer Begin) {
		setAttrVal("Begin", Begin);
	}
	/**
	 * 停止
	 * @return Integer
	 */
	public Integer getEnd() {
		return ((Integer) getAttrVal("End"));
	}
	/**
	 * 停止
	 * @param End
	 */
	public void setEnd(Integer End) {
		setAttrVal("End", End);
	}
	/**
	 * 必选
	 * @return String
	 */
	public String getNecessary() {
		return ((String) getAttrVal("Necessary"));
	}
	/**
	 * 必选
	 * @param Necessary
	 */
	public void setNecessary(String Necessary) {
		setAttrVal("Necessary", Necessary);
	}
	/**
	 * 次数
	 * @return Integer
	 */
	public Integer getNum() {
		return ((Integer) getAttrVal("Num"));
	}
	/**
	 * 次数
	 * @param Num
	 */
	public void setNum(Integer Num) {
		setAttrVal("Num", Num);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getOrcontext() {
		return ((String) getAttrVal("Orcontext"));
	}
	/**
	 * 医嘱内容
	 * @param Orcontext
	 */
	public void setOrcontext(String Orcontext) {
		setAttrVal("Orcontext", Orcontext);
	}
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getOrtype() {
		return ((String) getAttrVal("Ortype"));
	}
	/**
	 * 医嘱类型
	 * @param Ortype
	 */
	public void setOrtype(String Ortype) {
		setAttrVal("Ortype", Ortype);
	}
	/**
	 * 是否选中
	 * @return FBoolean
	 */
	public FBoolean getFg_selected() {
		return ((FBoolean) getAttrVal("Fg_selected"));
	}
	/**
	 * 是否选中
	 * @param Fg_selected
	 */
	public void setFg_selected(FBoolean Fg_selected) {
		setAttrVal("Fg_selected", Fg_selected);
	}
	/**
	 * 关联医嘱
	 * @return String
	 */
	public String getId_or_rel() {
		return ((String) getAttrVal("Id_or_rel"));
	}
	/**
	 * 关联医嘱
	 * @param Id_or_rel
	 */
	public void setId_or_rel(String Id_or_rel) {
		setAttrVal("Id_or_rel", Id_or_rel);
	}
}