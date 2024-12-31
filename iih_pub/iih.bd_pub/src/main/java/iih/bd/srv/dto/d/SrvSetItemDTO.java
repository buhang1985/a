package iih.bd.srv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 服务套成员信息DTO DTO数据 
 * 
 */
public class SrvSetItemDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务套
	 * @return String
	 */
	public String getId_srv_set() {
		return ((String) getAttrVal("Id_srv_set"));
	}
	/**
	 * 服务套
	 * @param Id_srv_set
	 */
	public void setId_srv_set(String Id_srv_set) {
		setAttrVal("Id_srv_set", Id_srv_set);
	}
	/**
	 * 服务套成员对应服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务套成员对应服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 服务编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 服务名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}
	/**
	 * 医学单位
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 医学单位编码
	 * @return String
	 */
	public String getCode_unit_med() {
		return ((String) getAttrVal("Code_unit_med"));
	}
	/**
	 * 医学单位编码
	 * @param Code_unit_med
	 */
	public void setCode_unit_med(String Code_unit_med) {
		setAttrVal("Code_unit_med", Code_unit_med);
	}
	/**
	 * 医学单位名称
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}
	/**
	 * 医学单位名称
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 医学数值
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}
	/**
	 * 医学数值
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	/**
	 * 角色
	 * @return String
	 */
	public String getId_servsetrole() {
		return ((String) getAttrVal("Id_servsetrole"));
	}
	/**
	 * 角色
	 * @param Id_servsetrole
	 */
	public void setId_servsetrole(String Id_servsetrole) {
		setAttrVal("Id_servsetrole", Id_servsetrole);
	}
	/**
	 * 角色编码
	 * @return String
	 */
	public String getSd_srvsetrole() {
		return ((String) getAttrVal("Sd_srvsetrole"));
	}
	/**
	 * 角色编码
	 * @param Sd_srvsetrole
	 */
	public void setSd_srvsetrole(String Sd_srvsetrole) {
		setAttrVal("Sd_srvsetrole", Sd_srvsetrole);
	}
	/**
	 * 角色名称
	 * @return String
	 */
	public String getName_srvsetrole() {
		return ((String) getAttrVal("Name_srvsetrole"));
	}
	/**
	 * 角色名称
	 * @param Name_srvsetrole
	 */
	public void setName_srvsetrole(String Name_srvsetrole) {
		setAttrVal("Name_srvsetrole", Name_srvsetrole);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 临床标识
	 * @return FBoolean
	 */
	public FBoolean getFg_clinical() {
		return ((FBoolean) getAttrVal("Fg_clinical"));
	}
	/**
	 * 临床标识
	 * @param Fg_clinical
	 */
	public void setFg_clinical(FBoolean Fg_clinical) {
		setAttrVal("Fg_clinical", Fg_clinical);
	}
	/**
	 * 可选标识
	 * @return FBoolean
	 */
	public FBoolean getFg_edit() {
		return ((FBoolean) getAttrVal("Fg_edit"));
	}
	/**
	 * 可选标识
	 * @param Fg_edit
	 */
	public void setFg_edit(FBoolean Fg_edit) {
		setAttrVal("Fg_edit", Fg_edit);
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
	 * 定价模式
	 * @return String
	 */
	public String getId_primd() {
		return ((String) getAttrVal("Id_primd"));
	}
	/**
	 * 定价模式
	 * @param Id_primd
	 */
	public void setId_primd(String Id_primd) {
		setAttrVal("Id_primd", Id_primd);
	}
	/**
	 * 定价模式编码
	 * @return String
	 */
	public String getSd_primd() {
		return ((String) getAttrVal("Sd_primd"));
	}
	/**
	 * 定价模式编码
	 * @param Sd_primd
	 */
	public void setSd_primd(String Sd_primd) {
		setAttrVal("Sd_primd", Sd_primd);
	}
	/**
	 * 定价模式名称
	 * @return String
	 */
	public String getPrimd_name() {
		return ((String) getAttrVal("Primd_name"));
	}
	/**
	 * 定价模式名称
	 * @param Primd_name
	 */
	public void setPrimd_name(String Primd_name) {
		setAttrVal("Primd_name", Primd_name);
	}
}