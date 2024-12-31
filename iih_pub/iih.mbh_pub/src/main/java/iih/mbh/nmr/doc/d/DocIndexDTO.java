package iih.mbh.nmr.doc.d;

import java.util.List;

public class DocIndexDTO {

	// 主键
	private String id_nmr_doc;
	// 名称
	private String name;
	// 拼音首字母
	private String py;

	public String getId_nmr_doc() {
		return id_nmr_doc;
	}

	public void setId_nmr_doc(String id_nmr_doc) {
		this.id_nmr_doc = id_nmr_doc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPy() {
		return py;
	}

	public void setPy(String py) {
		this.py = py;
	}

}
