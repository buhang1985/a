package iih.ci.ord.dto.ems.uiorderdto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 处方列表 DTO数据 
 * 
 */
public class PresListViewDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 处方id
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方id
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 处方标题
	 * @return String
	 */
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}
	/**
	 * 处方标题
	 * @param Title
	 */
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	/**
	 * 毒麻标志
	 * @return FBoolean
	 */
	public FBoolean getFg_poisonhemp() {
		return ((FBoolean) getAttrVal("Fg_poisonhemp"));
	}
	/**
	 * 毒麻标志
	 * @param Fg_poisonhemp
	 */
	public void setFg_poisonhemp(FBoolean Fg_poisonhemp) {
		setAttrVal("Fg_poisonhemp", Fg_poisonhemp);
	}
	/**
	 * 处方颜色
	 * @return String
	 */
	public String getColor_pres() {
		return ((String) getAttrVal("Color_pres"));
	}
	/**
	 * 处方颜色
	 * @param Color_pres
	 */
	public void setColor_pres(String Color_pres) {
		setAttrVal("Color_pres", Color_pres);
	}
}