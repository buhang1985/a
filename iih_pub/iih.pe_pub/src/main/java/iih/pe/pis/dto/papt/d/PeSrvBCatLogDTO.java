package iih.pe.pis.dto.papt.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PeSrvBCatLogDTO extends BaseDTO {

	// 体检项目主键标识
	@RPCField(id = 1)
	private String id_pesrvbcatlog;
	// 简称
	@RPCField(id = 10)
	private String name_short;
	// 英文名
	@RPCField(id = 11)
	private String ename;
	// 序号
	@RPCField(id = 12)
	private Integer sortno;
	// 基础价格
	@RPCField(id = 13)
	private Double price;
	// 最大折扣
	@RPCField(id = 14)
	private Double max_discount;
	// 价表价格
	@RPCField(id = 15)
	private Double pri_original;
	// 成本价格
	@RPCField(id = 16)
	private Double pri_cost;
	// 性别适用
	@RPCField(id = 17)
	private String sexlimit;
	// 儿童禁用
	@RPCField(id = 18)
	private Boolean fg_enfant;
	// 孕妇禁用
	@RPCField(id = 19)
	private Boolean fg_pregnent;
	// 所属集团
	@RPCField(id = 2)
	private String id_grp;
	// 未婚禁用
	@RPCField(id = 20)
	private Boolean fg_married;
	// 人数限制
	@RPCField(id = 21)
	private Integer max_limit;
	// 导引单打印
	@RPCField(id = 22)
	private Boolean fg_guideprint;
	// 外协项目
	@RPCField(id = 23)
	private Boolean fg_assisted;
	// 检查时长
	@RPCField(id = 24)
	private Integer chkduration;
	// 所属目录
	@RPCField(id = 25)
	private String catlog;
	// 服务类型编码
	@RPCField(id = 26)
	private String sd_srvtp;
	// 服务分类
	@RPCField(id = 27)
	private String id_srvca;
	// 五笔
	@RPCField(id = 28)
	private String wbcode;
	// 拼音
	@RPCField(id = 29)
	private String pycode;
	// 所属组织
	@RPCField(id = 3)
	private String id_org;
	// 助记码
	@RPCField(id = 30)
	private String mnecode;
	// 创建人
	@RPCField(id = 31)
	private String createdby;
	// 创建时间
	@RPCField(id = 32)
	private String createdtime;
	// 最后修改人
	@RPCField(id = 33)
	private String modifiedby;
	// 最后修改时间
	@RPCField(id = 34)
	private String modifiedtime;
	// 选择标识
	@RPCField(id = 35)
	private Boolean fg_select;
	// 检查地点（男）
	@RPCField(id = 36)
	private String loc_catman;
	// 检查地点（女）
	@RPCField(id = 37)
	private String loc_catwoman;
	// 启用标识
	@RPCField(id = 38)
	private Boolean fg_active;
	// 套餐内项目标识
	@RPCField(id = 39)
	private Boolean fg_setdef;
	// 所属科室
	@RPCField(id = 4)
	private String id_pedeptset;
	// 所属科室编码
	@RPCField(id = 5)
	private String code_dept;
	// 所属科室名称
	@RPCField(id = 6)
	private String name_dept;
	// 体检标本类型主键
	@RPCField(id = 7)
	private String id_pesrvsampleca;
	// 编码
	@RPCField(id = 8)
	private String code;
	// 名称
	@RPCField(id = 9)
	private String name;

	public String getId_pesrvbcatlog() {
		return id_pesrvbcatlog;
	}

	public void setId_pesrvbcatlog(String id_pesrvbcatlog) {
		this.id_pesrvbcatlog = id_pesrvbcatlog;
	}

	public String getName_short() {
		return name_short;
	}

	public void setName_short(String name_short) {
		this.name_short = name_short;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getSortno() {
		return sortno;
	}

	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getMax_discount() {
		return max_discount;
	}

	public void setMax_discount(Double max_discount) {
		this.max_discount = max_discount;
	}

	public Double getPri_original() {
		return pri_original;
	}

	public void setPri_original(Double pri_original) {
		this.pri_original = pri_original;
	}

	public Double getPri_cost() {
		return pri_cost;
	}

	public void setPri_cost(Double pri_cost) {
		this.pri_cost = pri_cost;
	}

	public String getSexlimit() {
		return sexlimit;
	}

	public void setSexlimit(String sexlimit) {
		this.sexlimit = sexlimit;
	}

	public Boolean getFg_enfant() {
		return fg_enfant;
	}

	public void setFg_enfant(Boolean fg_enfant) {
		this.fg_enfant = fg_enfant;
	}

	public Boolean getFg_pregnent() {
		return fg_pregnent;
	}

	public void setFg_pregnent(Boolean fg_pregnent) {
		this.fg_pregnent = fg_pregnent;
	}

	public String getId_grp() {
		return id_grp;
	}

	public void setId_grp(String id_grp) {
		this.id_grp = id_grp;
	}

	public Boolean getFg_married() {
		return fg_married;
	}

	public void setFg_married(Boolean fg_married) {
		this.fg_married = fg_married;
	}

	public Integer getMax_limit() {
		return max_limit;
	}

	public void setMax_limit(Integer max_limit) {
		this.max_limit = max_limit;
	}

	public Boolean getFg_guideprint() {
		return fg_guideprint;
	}

	public void setFg_guideprint(Boolean fg_guideprint) {
		this.fg_guideprint = fg_guideprint;
	}

	public Boolean getFg_assisted() {
		return fg_assisted;
	}

	public void setFg_assisted(Boolean fg_assisted) {
		this.fg_assisted = fg_assisted;
	}

	public Integer getChkduration() {
		return chkduration;
	}

	public void setChkduration(Integer chkduration) {
		this.chkduration = chkduration;
	}

	public String getCatlog() {
		return catlog;
	}

	public void setCatlog(String catlog) {
		this.catlog = catlog;
	}

	public String getSd_srvtp() {
		return sd_srvtp;
	}

	public void setSd_srvtp(String sd_srvtp) {
		this.sd_srvtp = sd_srvtp;
	}

	public String getId_srvca() {
		return id_srvca;
	}

	public void setId_srvca(String id_srvca) {
		this.id_srvca = id_srvca;
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

	public String getId_org() {
		return id_org;
	}

	public void setId_org(String id_org) {
		this.id_org = id_org;
	}

	public String getMnecode() {
		return mnecode;
	}

	public void setMnecode(String mnecode) {
		this.mnecode = mnecode;
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

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	public Boolean getFg_select() {
		return fg_select;
	}

	public void setFg_select(Boolean fg_select) {
		this.fg_select = fg_select;
	}

	public String getLoc_catman() {
		return loc_catman;
	}

	public void setLoc_catman(String loc_catman) {
		this.loc_catman = loc_catman;
	}

	public String getLoc_catwoman() {
		return loc_catwoman;
	}

	public void setLoc_catwoman(String loc_catwoman) {
		this.loc_catwoman = loc_catwoman;
	}

	public Boolean getFg_active() {
		return fg_active;
	}

	public void setFg_active(Boolean fg_active) {
		this.fg_active = fg_active;
	}

	public Boolean getFg_setdef() {
		return fg_setdef;
	}

	public void setFg_setdef(Boolean fg_setdef) {
		this.fg_setdef = fg_setdef;
	}

	public String getId_pedeptset() {
		return id_pedeptset;
	}

	public void setId_pedeptset(String id_pedeptset) {
		this.id_pedeptset = id_pedeptset;
	}

	public String getCode_dept() {
		return code_dept;
	}

	public void setCode_dept(String code_dept) {
		this.code_dept = code_dept;
	}

	public String getName_dept() {
		return name_dept;
	}

	public void setName_dept(String name_dept) {
		this.name_dept = name_dept;
	}

	public String getId_pesrvsampleca() {
		return id_pesrvsampleca;
	}

	public void setId_pesrvsampleca(String id_pesrvsampleca) {
		this.id_pesrvsampleca = id_pesrvsampleca;
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

}
