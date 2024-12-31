package iih.mbh.nmr.doc.d;

import java.util.List;

import iih.mbh.nmr.kb.d.KeyBoardDTO;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class DocDTO {

	// 标题
	@RPCField(id = 1)
	private String title;
	// 数据元类型1-枚举 2-普通
	@RPCField(id = 10)
	private String sd_valtp;
	// 数据类型 s2 枚举 s3 档案
	@RPCField(id = 11)
	private String sd_valtp_national;
	// 是否算分标志
	@RPCField(id = 12)
	private boolean fg_active;
	// 最大值
	@RPCField(id = 13)
	private double minval;
	// 最小值
	@RPCField(id = 14)
	private double maxval;
	// 文书id
	@RPCField(id = 15)
	private String id_doc;
	// 属性名称，动态的进行赋值
	@RPCField(id = 16)
	private String fieldname;
	// 是否在前端显示该条目
	@RPCField(id = 17)
	private boolean fg_show;
	// 是否只读
	@RPCField(id = 18)
	private boolean fg_readlyonly;
	// 是否为必填项
	@RPCField(id = 19)
	private boolean fg_required;
	// 移动文书数据元
	@RPCField(id = 2)
	private String id_nmr_doc_mbde;
	// 默认值标记
	@RPCField(id = 20)
	private boolean fg_default;
	// 默认值
	@RPCField(id = 21)
	private String def_val;
	// 宏标记
	@RPCField(id = 22)
	private boolean fg_marco;
	// 宏类型
	@RPCField(id = 23)
	private String sd_marco;
	// 移动文书数据组id
	@RPCField(id = 3)
	private String id_nmr_doc_mbdg;
	// 数据元
	@RPCField(id = 4)
	private String id_de;
	// 父标题
	@RPCField(id = 5)
	private String documentsettitle;
	// 内容集合
	@RPCField(id = 6)
	private List<DocContentDTO> contents;
	// 键盘
	@RPCField(id = 7)
	private KeyBoardDTO keyboard;
	// 控件类型
	@RPCField(id = 8)
	private String controltype;
	// 档案code
	@RPCField(id = 9)
	private String valdomaincode;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSd_valtp() {
		return sd_valtp;
	}

	public void setSd_valtp(String sd_valtp) {
		this.sd_valtp = sd_valtp;
	}

	public String getSd_valtp_national() {
		return sd_valtp_national;
	}

	public void setSd_valtp_national(String sd_valtp_national) {
		this.sd_valtp_national = sd_valtp_national;
	}

	public boolean getFg_active() {
		return fg_active;
	}

	public void setFg_active(boolean fg_active) {
		this.fg_active = fg_active;
	}

	public double getMinval() {
		return minval;
	}

	public void setMinval(double minval) {
		this.minval = minval;
	}

	public double getMaxval() {
		return maxval;
	}

	public void setMaxval(double maxval) {
		this.maxval = maxval;
	}

	public String getId_doc() {
		return id_doc;
	}

	public void setId_doc(String id_doc) {
		this.id_doc = id_doc;
	}

	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public boolean getFg_show() {
		return fg_show;
	}

	public void setFg_show(boolean fg_show) {
		this.fg_show = fg_show;
	}

	public boolean getFg_readlyonly() {
		return fg_readlyonly;
	}

	public void setFg_readlyonly(boolean fg_readlyonly) {
		this.fg_readlyonly = fg_readlyonly;
	}

	public boolean getFg_required() {
		return fg_required;
	}

	public void setFg_required(boolean fg_required) {
		this.fg_required = fg_required;
	}

	public String getId_nmr_doc_mbde() {
		return id_nmr_doc_mbde;
	}

	public void setId_nmr_doc_mbde(String id_nmr_doc_mbde) {
		this.id_nmr_doc_mbde = id_nmr_doc_mbde;
	}

	public boolean getFg_default() {
		return fg_default;
	}

	public void setFg_default(boolean fg_default) {
		this.fg_default = fg_default;
	}

	public String getDef_val() {
		return def_val;
	}

	public void setDef_val(String def_val) {
		this.def_val = def_val;
	}

	public boolean getFg_marco() {
		return fg_marco;
	}

	public void setFg_marco(boolean fg_marco) {
		this.fg_marco = fg_marco;
	}

	public String getSd_marco() {
		return sd_marco;
	}

	public void setSd_marco(String sd_marco) {
		this.sd_marco = sd_marco;
	}

	public String getId_nmr_doc_mbdg() {
		return id_nmr_doc_mbdg;
	}

	public void setId_nmr_doc_mbdg(String id_nmr_doc_mbdg) {
		this.id_nmr_doc_mbdg = id_nmr_doc_mbdg;
	}

	public String getId_de() {
		return id_de;
	}

	public void setId_de(String id_de) {
		this.id_de = id_de;
	}

	public String getDocumentsettitle() {
		return documentsettitle;
	}

	public void setDocumentsettitle(String documentsettitle) {
		this.documentsettitle = documentsettitle;
	}

	public List<DocContentDTO> getContents() {
		return contents;
	}

	public void setContents(List<DocContentDTO> contents) {
		this.contents = contents;
	}

	public KeyBoardDTO getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(KeyBoardDTO keyboard) {
		this.keyboard = keyboard;
	}

	public String getControltype() {
		return controltype;
	}

	public void setControltype(String controltype) {
		this.controltype = controltype;
	}

	public String getValdomaincode() {
		return valdomaincode;
	}

	public void setValdomaincode(String valdomaincode) {
		this.valdomaincode = valdomaincode;
	}

}
