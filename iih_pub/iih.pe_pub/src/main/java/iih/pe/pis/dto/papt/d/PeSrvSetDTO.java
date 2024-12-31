package iih.pe.pis.dto.papt.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PeSrvSetDTO {

	// 体检套餐主键标识
	@RPCField(id = 1)
	private String id_pesrvsetdef;
	// 打印名称
	@RPCField(id = 10)
	private String name_prt;
	// 体检套餐级别编码
	@RPCField(id = 11)
	private String sd_level;
	// 基础价格
	@RPCField(id = 12)
	private double pri_srvset;
	// VIP标识
	@RPCField(id = 13)
	private boolean fg_vip;
	// 体检套餐类别ID
	@RPCField(id = 14)
	private String id_pesrvsetca;
	// 默认体检报告
	@RPCField(id = 15)
	private String no_report;
	// 默认问卷
	@RPCField(id = 16)
	private String no_inq;
	// 名单导入标签
	@RPCField(id = 17)
	private String label_set;
	// 组合类别
	@RPCField(id = 18)
	private String groupca;
	// 启用标识
	@RPCField(id = 19)
	private boolean fg_active;
	// 所属集团
	@RPCField(id = 2)
	private String id_grp;
	// 序号
	@RPCField(id = 20)
	private int sortno;
	// 体检套餐项目明细
	@RPCField(id = 21)
	private List<PeSrvSetItemDTO> pesrvsetitmdef;
	// 选择标识
	@RPCField(id = 22)
	private boolean fg_select;
	// 拼音码
	@RPCField(id = 23)
	private String pycode;
	// 五笔码
	@RPCField(id = 24)
	private String wbcode;
	// 助记码
	@RPCField(id = 25)
	private String mnecode;
	// 创建人
	@RPCField(id = 26)
	private String createdby;
	// 创建时间
	@RPCField(id = 27)
	private String createdtime;
	// 最后修改人
	@RPCField(id = 28)
	private String modifiedby;
	// 最后修改时间
	@RPCField(id = 29)
	private String modifiedtime;
	// 所属组织
	@RPCField(id = 3)
	private String id_org;
	// 编码
	@RPCField(id = 4)
	private String code;
	// 体检套餐名称
	@RPCField(id = 5)
	private String name;
	// 体检套餐介绍
	@RPCField(id = 6)
	private String introduction;
	// 体检套餐级别ID
	@RPCField(id = 7)
	private String id_level;
	// 性别限制
	@RPCField(id = 8)
	private int sexlimit;
	// 原始价格
	@RPCField(id = 9)
	private double pri_original;

	public String getId_pesrvsetdef() {
		return id_pesrvsetdef;
	}

	public void setId_pesrvsetdef(String id_pesrvsetdef) {
		this.id_pesrvsetdef = id_pesrvsetdef;
	}

	public String getName_prt() {
		return name_prt;
	}

	public void setName_prt(String name_prt) {
		this.name_prt = name_prt;
	}

	public String getSd_level() {
		return sd_level;
	}

	public void setSd_level(String sd_level) {
		this.sd_level = sd_level;
	}

	public double getPri_srvset() {
		return pri_srvset;
	}

	public void setPri_srvset(double pri_srvset) {
		this.pri_srvset = pri_srvset;
	}

	public boolean getFg_vip() {
		return fg_vip;
	}

	public void setFg_vip(boolean fg_vip) {
		this.fg_vip = fg_vip;
	}

	public String getId_pesrvsetca() {
		return id_pesrvsetca;
	}

	public void setId_pesrvsetca(String id_pesrvsetca) {
		this.id_pesrvsetca = id_pesrvsetca;
	}

	public String getNo_report() {
		return no_report;
	}

	public void setNo_report(String no_report) {
		this.no_report = no_report;
	}

	public String getNo_inq() {
		return no_inq;
	}

	public void setNo_inq(String no_inq) {
		this.no_inq = no_inq;
	}

	public String getLabel_set() {
		return label_set;
	}

	public void setLabel_set(String label_set) {
		this.label_set = label_set;
	}

	public String getGroupca() {
		return groupca;
	}

	public void setGroupca(String groupca) {
		this.groupca = groupca;
	}

	public boolean getFg_active() {
		return fg_active;
	}

	public void setFg_active(boolean fg_active) {
		this.fg_active = fg_active;
	}

	public String getId_grp() {
		return id_grp;
	}

	public void setId_grp(String id_grp) {
		this.id_grp = id_grp;
	}

	public int getSortno() {
		return sortno;
	}

	public void setSortno(int sortno) {
		this.sortno = sortno;
	}

	public List<PeSrvSetItemDTO> getPesrvsetitmdef() {
		return pesrvsetitmdef;
	}

	public void setPesrvsetitmdef(List<PeSrvSetItemDTO> pesrvsetitmdef) {
		this.pesrvsetitmdef = pesrvsetitmdef;
	}

	public boolean getFg_select() {
		return fg_select;
	}

	public void setFg_select(boolean fg_select) {
		this.fg_select = fg_select;
	}

	public String getPycode() {
		return pycode;
	}

	public void setPycode(String pycode) {
		this.pycode = pycode;
	}

	public String getWbcode() {
		return wbcode;
	}

	public void setWbcode(String wbcode) {
		this.wbcode = wbcode;
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

	public String getId_org() {
		return id_org;
	}

	public void setId_org(String id_org) {
		this.id_org = id_org;
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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getId_level() {
		return id_level;
	}

	public void setId_level(String id_level) {
		this.id_level = id_level;
	}

	public int getSexlimit() {
		return sexlimit;
	}

	public void setSexlimit(int sexlimit) {
		this.sexlimit = sexlimit;
	}

	public double getPri_original() {
		return pri_original;
	}

	public void setPri_original(double pri_original) {
		this.pri_original = pri_original;
	}

}
