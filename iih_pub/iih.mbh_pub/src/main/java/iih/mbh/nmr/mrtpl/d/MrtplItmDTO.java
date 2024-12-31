package iih.mbh.nmr.mrtpl.d;

import java.util.List;

import iih.mbh.nmr.kb.d.KeyBoardDTO;

public class MrtplItmDTO {

	// 子集合
	private List<MrtplItmDTO> childs;
	// 内容
	private String content;
	// 父项目标记
	private String fg_parent;
	// 录入值id
	private String id_content;
	// 体征测量主表ID
	private String id_mr_vs;
	// 体征测量项目ID
	private String id_mr_vs_itm;
	// 体征项目ID
	private String id_mrtpl_vs;
	// 体征项属性ID
	private String id_mrtpl_vs_itm;
	// 生命体征模板ID
	private String id_mrtpl_vst;
	// 体征模板项目ID
	private String id_mrtpl_vst_itm;
	// 医疗服务id
	private String id_srv;
	// 键盘
	private KeyBoardDTO keyboard;
	// 标题
	private String title;
	// 单位
	private String unit;
	// 最大值
	private double valmax;
	// 最小值
	private double valmin;

	public List<MrtplItmDTO> getChilds() {
		return childs;
	}

	public void setChilds(List<MrtplItmDTO> childs) {
		this.childs = childs;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFg_parent() {
		return fg_parent;
	}

	public void setFg_parent(String fg_parent) {
		this.fg_parent = fg_parent;
	}

	public String getId_content() {
		return id_content;
	}

	public void setId_content(String id_content) {
		this.id_content = id_content;
	}

	public String getId_mr_vs() {
		return id_mr_vs;
	}

	public void setId_mr_vs(String id_mr_vs) {
		this.id_mr_vs = id_mr_vs;
	}

	public String getId_mr_vs_itm() {
		return id_mr_vs_itm;
	}

	public void setId_mr_vs_itm(String id_mr_vs_itm) {
		this.id_mr_vs_itm = id_mr_vs_itm;
	}

	public String getId_mrtpl_vs() {
		return id_mrtpl_vs;
	}

	public void setId_mrtpl_vs(String id_mrtpl_vs) {
		this.id_mrtpl_vs = id_mrtpl_vs;
	}

	public String getId_mrtpl_vs_itm() {
		return id_mrtpl_vs_itm;
	}

	public void setId_mrtpl_vs_itm(String id_mrtpl_vs_itm) {
		this.id_mrtpl_vs_itm = id_mrtpl_vs_itm;
	}

	public String getId_mrtpl_vst() {
		return id_mrtpl_vst;
	}

	public void setId_mrtpl_vst(String id_mrtpl_vst) {
		this.id_mrtpl_vst = id_mrtpl_vst;
	}

	public String getId_mrtpl_vst_itm() {
		return id_mrtpl_vst_itm;
	}

	public void setId_mrtpl_vst_itm(String id_mrtpl_vst_itm) {
		this.id_mrtpl_vst_itm = id_mrtpl_vst_itm;
	}

	public String getId_srv() {
		return id_srv;
	}

	public void setId_srv(String id_srv) {
		this.id_srv = id_srv;
	}

	public KeyBoardDTO getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(KeyBoardDTO keyboard) {
		this.keyboard = keyboard;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getValmax() {
		return valmax;
	}

	public void setValmax(double valmax) {
		this.valmax = valmax;
	}

	public double getValmin() {
		return valmin;
	}

	public void setValmin(double valmin) {
		this.valmin = valmin;
	}

}
