package iih.ei.itf.eiitfcateitm.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 接口分类项目DTO DTO数据 
 * 
 */
public class ItfCateItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 接口分类项目
	 * @return String
	 */
	public String getId_itfcate_itm() {
		return ((String) getAttrVal("Id_itfcate_itm"));
	}
	/**
	 * 接口分类项目
	 * @param Id_itfcate_itm
	 */
	public void setId_itfcate_itm(String Id_itfcate_itm) {
		setAttrVal("Id_itfcate_itm", Id_itfcate_itm);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 接口分类
	 * @return String
	 */
	public String getId_itfcate() {
		return ((String) getAttrVal("Id_itfcate"));
	}
	/**
	 * 接口分类
	 * @param Id_itfcate
	 */
	public void setId_itfcate(String Id_itfcate) {
		setAttrVal("Id_itfcate", Id_itfcate);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 接口
	 * @return String
	 */
	public String getId_itf() {
		return ((String) getAttrVal("Id_itf"));
	}
	/**
	 * 接口
	 * @param Id_itf
	 */
	public void setId_itf(String Id_itf) {
		setAttrVal("Id_itf", Id_itf);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 服务名
	 * @return String
	 */
	public String getServicename() {
		return ((String) getAttrVal("Servicename"));
	}
	/**
	 * 服务名
	 * @param Servicename
	 */
	public void setServicename(String Servicename) {
		setAttrVal("Servicename", Servicename);
	}
	/**
	 * 方法名
	 * @return String
	 */
	public String getMethodname() {
		return ((String) getAttrVal("Methodname"));
	}
	/**
	 * 方法名
	 * @param Methodname
	 */
	public void setMethodname(String Methodname) {
		setAttrVal("Methodname", Methodname);
	}
	/**
	 * 系统标识
	 * @return FBoolean
	 */
	public FBoolean getFg_sys() {
		return ((FBoolean) getAttrVal("Fg_sys"));
	}
	/**
	 * 系统标识
	 * @param Fg_sys
	 */
	public void setFg_sys(FBoolean Fg_sys) {
		setAttrVal("Fg_sys", Fg_sys);
	}
	/**
	 * 序列化类型
	 * @return String
	 */
	public String getEu_serialize() {
		return ((String) getAttrVal("Eu_serialize"));
	}
	/**
	 * 序列化类型
	 * @param Eu_serialize
	 */
	public void setEu_serialize(String Eu_serialize) {
		setAttrVal("Eu_serialize", Eu_serialize);
	}
	/**
	 * 序列化标识
	 * @return FBoolean
	 */
	public FBoolean getFg_serialize() {
		return ((FBoolean) getAttrVal("Fg_serialize"));
	}
	/**
	 * 序列化标识
	 * @param Fg_serialize
	 */
	public void setFg_serialize(FBoolean Fg_serialize) {
		setAttrVal("Fg_serialize", Fg_serialize);
	}
	/**
	 * 调用频率
	 * @return String
	 */
	public String getCall_rate() {
		return ((String) getAttrVal("Call_rate"));
	}
	/**
	 * 调用频率
	 * @param Call_rate
	 */
	public void setCall_rate(String Call_rate) {
		setAttrVal("Call_rate", Call_rate);
	}
	/**
	 * 详细说明
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 详细说明
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 服务全路径
	 * @return String
	 */
	public String getFullname() {
		return ((String) getAttrVal("Fullname"));
	}
	/**
	 * 服务全路径
	 * @param Fullname
	 */
	public void setFullname(String Fullname) {
		setAttrVal("Fullname", Fullname);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 是否打印日志
	 * @return FBoolean
	 */
	public FBoolean getFg_printlog() {
		return ((FBoolean) getAttrVal("Fg_printlog"));
	}
	/**
	 * 是否打印日志
	 * @param Fg_printlog
	 */
	public void setFg_printlog(FBoolean Fg_printlog) {
		setAttrVal("Fg_printlog", Fg_printlog);
	}
	/**
	 * 是否启用事务
	 * @return FBoolean
	 */
	public FBoolean getFg_affairs() {
		return ((FBoolean) getAttrVal("Fg_affairs"));
	}
	/**
	 * 是否启用事务
	 * @param Fg_affairs
	 */
	public void setFg_affairs(FBoolean Fg_affairs) {
		setAttrVal("Fg_affairs", Fg_affairs);
	}
	/**
	 * 版本号
	 * @return Integer
	 */
	public Integer getVersion() {
		return ((Integer) getAttrVal("Version"));
	}
	/**
	 * 版本号
	 * @param Version
	 */
	public void setVersion(Integer Version) {
		setAttrVal("Version", Version);
	}
	/**
	 * 分页标志
	 * @return FBoolean
	 */
	public FBoolean getFg_paging() {
		return ((FBoolean) getAttrVal("Fg_paging"));
	}
	/**
	 * 分页标志
	 * @param Fg_paging
	 */
	public void setFg_paging(FBoolean Fg_paging) {
		setAttrVal("Fg_paging", Fg_paging);
	}
}