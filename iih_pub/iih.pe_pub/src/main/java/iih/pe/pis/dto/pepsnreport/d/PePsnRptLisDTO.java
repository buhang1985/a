package iih.pe.pis.dto.pepsnreport.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PePsnRptLisDTO {

	// 个人预约单ID
	@RPCField(id = 1)
	private String id_pepsnappt;
	// 项目英文名称
	@RPCField(id = 10)
	private String pename;
	// 缩写
	@RPCField(id = 11)
	private String shortname;
	// 检查分组
	@RPCField(id = 12)
	private String namegroup;
	// 患者编码
	@RPCField(id = 2)
	private String code_pat;
	// 结果
	@RPCField(id = 3)
	private String rst;
	// 计量单位
	@RPCField(id = 4)
	private String unit;
	// 参考范围
	@RPCField(id = 5)
	private String pref;
	// 异常标识符号
	@RPCField(id = 6)
	private String mark;
	// 异常标识
	@RPCField(id = 7)
	private String fgabn;
	// 阳性标识
	@RPCField(id = 8)
	private String fgposi;
	// 项目名称
	@RPCField(id = 9)
	private String pname;

	public String getId_pepsnappt() {
		return id_pepsnappt;
	}

	public void setId_pepsnappt(String id_pepsnappt) {
		this.id_pepsnappt = id_pepsnappt;
	}

	public String getPename() {
		return pename;
	}

	public void setPename(String pename) {
		this.pename = pename;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getNamegroup() {
		return namegroup;
	}

	public void setNamegroup(String namegroup) {
		this.namegroup = namegroup;
	}

	public String getCode_pat() {
		return code_pat;
	}

	public void setCode_pat(String code_pat) {
		this.code_pat = code_pat;
	}

	public String getRst() {
		return rst;
	}

	public void setRst(String rst) {
		this.rst = rst;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPref() {
		return pref;
	}

	public void setPref(String pref) {
		this.pref = pref;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getFgabn() {
		return fgabn;
	}

	public void setFgabn(String fgabn) {
		this.fgabn = fgabn;
	}

	public String getFgposi() {
		return fgposi;
	}

	public void setFgposi(String fgposi) {
		this.fgposi = fgposi;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

}
