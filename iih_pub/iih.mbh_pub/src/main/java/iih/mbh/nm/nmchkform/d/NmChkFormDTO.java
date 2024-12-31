package iih.mbh.nm.nmchkform.d;

import java.util.List;

public class NmChkFormDTO {

	// 列集合
	private List<NmChkFormColumnDTO> formcolumnlist;
	// 行集合
	private List<NmChkFormRowDTO> formrowlist;
	// 表格id
	private String id;
	// 质量检查记录
	private String id_nqm_chk;
	// 质量标准id
	private String id_nqm_cs;
	// 质量标准名称
	private String name_nqm_cs;

	public List<NmChkFormColumnDTO> getFormcolumnlist() {
		return formcolumnlist;
	}

	public void setFormcolumnlist(List<NmChkFormColumnDTO> formcolumnlist) {
		this.formcolumnlist = formcolumnlist;
	}

	public List<NmChkFormRowDTO> getFormrowlist() {
		return formrowlist;
	}

	public void setFormrowlist(List<NmChkFormRowDTO> formrowlist) {
		this.formrowlist = formrowlist;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_nqm_chk() {
		return id_nqm_chk;
	}

	public void setId_nqm_chk(String id_nqm_chk) {
		this.id_nqm_chk = id_nqm_chk;
	}

	public String getId_nqm_cs() {
		return id_nqm_cs;
	}

	public void setId_nqm_cs(String id_nqm_cs) {
		this.id_nqm_cs = id_nqm_cs;
	}

	public String getName_nqm_cs() {
		return name_nqm_cs;
	}

	public void setName_nqm_cs(String name_nqm_cs) {
		this.name_nqm_cs = name_nqm_cs;
	}

}
