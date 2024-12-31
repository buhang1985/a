package iih.pe.pqn.dto.peqadto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PeQaDefDTO {

	// 体检问卷问题库主键标识
	@RPCField(id = 1)
	private String id_peqacontentdef;
	// 重要标识
	@RPCField(id = 10)
	private Boolean fg_imp;
	// 复制标识
	@RPCField(id = 11)
	private Boolean fg_copy;
	// 体检问题答案选项
	@RPCField(id = 12)
	private List<PeQaOptionDTO> peqakeys;
	// 五笔
	@RPCField(id = 13)
	private String wbcode;
	// 拼音
	@RPCField(id = 14)
	private String pycode;
	// 助记码
	@RPCField(id = 15)
	private String mnecode;
	// 创建时间
	@RPCField(id = 16)
	private String createdtime;
	// 最后修改时间
	@RPCField(id = 17)
	private String modifiedtime;
	// 已选中的选项id
	@RPCField(id = 18)
	private String checkedid;
	// 排序
	@RPCField(id = 19)
	private Integer sortno;
	// 所属集团
	@RPCField(id = 2)
	private String id_grp;
	// 所属组织
	@RPCField(id = 3)
	private String id_org;
	// 体检问卷问题分组ID
	@RPCField(id = 4)
	private String id_peqacatlog;
	// 体检问卷问题编码
	@RPCField(id = 5)
	private String code;
	// 体检问卷问题
	@RPCField(id = 6)
	private String name;
	// 体检问卷问题英文名
	@RPCField(id = 7)
	private String ename;
	// 性别限制
	@RPCField(id = 8)
	private Integer sexlimit;
	// 界面控件类型
	@RPCField(id = 9)
	private Integer comptp;

	public String getId_peqacontentdef() {
		return id_peqacontentdef;
	}

	public void setId_peqacontentdef(String id_peqacontentdef) {
		this.id_peqacontentdef = id_peqacontentdef;
	}

	public Boolean getFg_imp() {
		return fg_imp;
	}

	public void setFg_imp(Boolean fg_imp) {
		this.fg_imp = fg_imp;
	}

	public Boolean getFg_copy() {
		return fg_copy;
	}

	public void setFg_copy(Boolean fg_copy) {
		this.fg_copy = fg_copy;
	}

	public List<PeQaOptionDTO> getPeqakeys() {
		return peqakeys;
	}

	public void setPeqakeys(List<PeQaOptionDTO> peqakeys) {
		this.peqakeys = peqakeys;
	}

	public String getWbcode() {
		return wbcode;
	}

	public void setWbcode(String wbcode) {
		this.wbcode = wbcode;
	}

	public String getPycode() {
		return pycode;
	}

	public void setPycode(String pycode) {
		this.pycode = pycode;
	}

	public String getMnecode() {
		return mnecode;
	}

	public void setMnecode(String mnecode) {
		this.mnecode = mnecode;
	}

	public String getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}

	public String getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	public String getCheckedid() {
		return checkedid;
	}

	public void setCheckedid(String checkedid) {
		this.checkedid = checkedid;
	}

	public Integer getSortno() {
		return sortno;
	}

	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}

	public String getId_grp() {
		return id_grp;
	}

	public void setId_grp(String id_grp) {
		this.id_grp = id_grp;
	}

	public String getId_org() {
		return id_org;
	}

	public void setId_org(String id_org) {
		this.id_org = id_org;
	}

	public String getId_peqacatlog() {
		return id_peqacatlog;
	}

	public void setId_peqacatlog(String id_peqacatlog) {
		this.id_peqacatlog = id_peqacatlog;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getSexlimit() {
		return sexlimit;
	}

	public void setSexlimit(Integer sexlimit) {
		this.sexlimit = sexlimit;
	}

	public Integer getComptp() {
		return comptp;
	}

	public void setComptp(Integer comptp) {
		this.comptp = comptp;
	}

}
