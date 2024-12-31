package iih.pe.papt.dto.pecorpdto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PeCorpDTO extends BaseDTO{

	// 单位编码
	@RPCField(id = 1)
	private String code;
	// 联系人3
	@RPCField(id = 10)
	private String linkman3;
	// 联系人电话
	@RPCField(id = 11)
	private String linkman_tel;
	// 联系人电话2
	@RPCField(id = 12)
	private String linkman_tel2;
	// 联系人电话3
	@RPCField(id = 13)
	private String linkman_tel3;
	// 邮编
	@RPCField(id = 14)
	private String zip;
	// 地址
	@RPCField(id = 15)
	private String addr;
	// 备注
	@RPCField(id = 16)
	private String note;
	// 序号
	@RPCField(id = 17)
	private String sortno;
	// 经济类型
	@RPCField(id = 18)
	private String id_econ;
	// 是否启用
	@RPCField(id = 19)
	private Boolean fg_active;
	// 单位名称
	@RPCField(id = 2)
	private String name;
	// 门诊就诊ID
	@RPCField(id = 20)
	private String id_pat;
	// 团体识别号
	@RPCField(id = 21)
	private String idcode;
	// 五笔
	@RPCField(id = 22)
	private String wbcode;
	// 拼音
	@RPCField(id = 23)
	private String pycode;
	// 助记码
	@RPCField(id = 24)
	private String mnecode;
	// 门诊ID
	@RPCField(id = 25)
	private String id_cust;
	// 创建人
	@RPCField(id = 26)
	private String createdby;
	// 创建时间
	@RPCField(id = 27)
	private String createdtime;
	// 集团
	@RPCField(id = 28)
	private String id_grp;
	// 组织
	@RPCField(id = 29)
	private String id_org;
	// 体检团体主键标识
	@RPCField(id = 3)
	private String id_pecorpbinfo;
	// 网页密码
	@RPCField(id = 30)
	private String pwweb;
	// 预约单id
	@RPCField(id = 31)
	private String id_pecorpappt;
	// 合同号
	@RPCField(id = 32)
	private String contract_no;
	// 机构代码
	@RPCField(id = 33)
	private String org_code;
	// 经济类型编码
	@RPCField(id = 34)
	private String sd_econ;
	// 体检团体父ID
	@RPCField(id = 4)
	private String id_pecorpbinfo_par;
	// 邮箱
	@RPCField(id = 5)
	private String email;
	// 电话
	@RPCField(id = 6)
	private String tel;
	// 开户账号
	@RPCField(id = 7)
	private String bank_code;
	// 联系人
	@RPCField(id = 8)
	private String linkman;
	// 联系人2
	@RPCField(id = 9)
	private String linkman2;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLinkman3() {
		return linkman3;
	}

	public void setLinkman3(String linkman3) {
		this.linkman3 = linkman3;
	}

	public String getLinkman_tel() {
		return linkman_tel;
	}

	public void setLinkman_tel(String linkman_tel) {
		this.linkman_tel = linkman_tel;
	}

	public String getLinkman_tel2() {
		return linkman_tel2;
	}

	public void setLinkman_tel2(String linkman_tel2) {
		this.linkman_tel2 = linkman_tel2;
	}

	public String getLinkman_tel3() {
		return linkman_tel3;
	}

	public void setLinkman_tel3(String linkman_tel3) {
		this.linkman_tel3 = linkman_tel3;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getSortno() {
		return sortno;
	}

	public void setSortno(String sortno) {
		this.sortno = sortno;
	}

	public String getId_econ() {
		return id_econ;
	}

	public void setId_econ(String id_econ) {
		this.id_econ = id_econ;
	}

	public Boolean getFg_active() {
		return fg_active;
	}

	public void setFg_active(Boolean fg_active) {
		this.fg_active = fg_active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId_pat() {
		return id_pat;
	}

	public void setId_pat(String id_pat) {
		this.id_pat = id_pat;
	}

	public String getIdcode() {
		return idcode;
	}

	public void setIdcode(String idcode) {
		this.idcode = idcode;
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

	public String getId_cust() {
		return id_cust;
	}

	public void setId_cust(String id_cust) {
		this.id_cust = id_cust;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
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

	public String getId_pecorpbinfo() {
		return id_pecorpbinfo;
	}

	public void setId_pecorpbinfo(String id_pecorpbinfo) {
		this.id_pecorpbinfo = id_pecorpbinfo;
	}

	public String getPwweb() {
		return pwweb;
	}

	public void setPwweb(String pwweb) {
		this.pwweb = pwweb;
	}

	public String getId_pecorpappt() {
		return id_pecorpappt;
	}

	public void setId_pecorpappt(String id_pecorpappt) {
		this.id_pecorpappt = id_pecorpappt;
	}

	public String getContract_no() {
		return contract_no;
	}

	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}

	public String getOrg_code() {
		return org_code;
	}

	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}

	public String getSd_econ() {
		return sd_econ;
	}

	public void setSd_econ(String sd_econ) {
		this.sd_econ = sd_econ;
	}

	public String getId_pecorpbinfo_par() {
		return id_pecorpbinfo_par;
	}

	public void setId_pecorpbinfo_par(String id_pecorpbinfo_par) {
		this.id_pecorpbinfo_par = id_pecorpbinfo_par;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkman2() {
		return linkman2;
	}

	public void setLinkman2(String linkman2) {
		this.linkman2 = linkman2;
	}

}
