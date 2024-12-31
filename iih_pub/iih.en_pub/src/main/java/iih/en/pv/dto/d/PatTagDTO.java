package iih.en.pv.dto.d;

import xap.mw.core.data.BaseDTO;

public class PatTagDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	/**
	 * 就诊id
	 * 
	 * @return
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}

	public void setId_ent(String id_ent) {
		setAttrVal("Id_ent", id_ent);
	}

	/**
	 * 标签类型编码
	 * 
	 * @return
	 */
	public String getSd_tagtp() {
		return ((String) getAttrVal("Sd_tagtp"));
	}

	public void setSd_tagtp(String sd_tagtp) {
		setAttrVal("Sd_tagtp", sd_tagtp);
	}

	/**
	 * 标签类型名称
	 * 
	 * @return
	 */
	public String getName_tagtp() {
		return ((String) getAttrVal("Name_tagtp"));
	}

	public void setName_tagtp(String name_tagtp) {
		setAttrVal("Name_tagtp", name_tagtp);
	}

	/**
	 * 标签类型名称简称
	 * 
	 * @return
	 */
	public String getShortname_tagtp() {
		return ((String) getAttrVal("Shortname_tagtp"));
	}

	public void setShortname_tagtp(String shortname_tagtp) {
		setAttrVal("Shortname_tagtp", shortname_tagtp);
	}
	
	/**
	 * 背景色
	 * 
	 * @return
	 */
	public String getColor_back() {
		return ((String) getAttrVal("Color_back"));
	}

	public void setColor_back(String color_back) {
		setAttrVal("Color_back", color_back);
	}
	
	/**
	 * 字体颜色
	 * 
	 * @return
	 */
	public String getColor_font() {
		return ((String) getAttrVal("Color_font"));
	}

	public void setColor_font(String color_font) {
		setAttrVal("Color_font", color_font);
	}
}
