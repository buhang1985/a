package iih.mbh.nmr.mrtpl.d;

import java.util.List;

public class VtResultMobileDTO {

	// 测量项目id
	private String id_mr_vs_itm;
	// 体征项目
	private String id_mrtpl_vs;
	// 测量项目属性
	private String id_mrtpl_vs_itm;
	// 体征模板
	private String id_mrtpl_vst;
	// 服务ID
	private String id_srv;
	// 测量值id
	private String id_value;
	// 测量项目属性名称
	private String name_mrtpl_vs_itm;
	// 测量值
	private String value;

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

	public String getId_srv() {
		return id_srv;
	}

	public void setId_srv(String id_srv) {
		this.id_srv = id_srv;
	}

	public String getId_value() {
		return id_value;
	}

	public void setId_value(String id_value) {
		this.id_value = id_value;
	}

	public String getName_mrtpl_vs_itm() {
		return name_mrtpl_vs_itm;
	}

	public void setName_mrtpl_vs_itm(String name_mrtpl_vs_itm) {
		this.name_mrtpl_vs_itm = name_mrtpl_vs_itm;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
