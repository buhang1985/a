package iih.mp.nr.api.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 执行状态对照关系 DTO数据 
 * 
 */
public class StatusContrastDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 闭环
	 * @return String
	 */
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}
	/**
	 * 闭环
	 * @param Id_orpltp
	 */
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
	}
	/**
	 * 闭环编码
	 * @return String
	 */
	public String getCode_orpltp() {
		return ((String) getAttrVal("Code_orpltp"));
	}
	/**
	 * 闭环编码
	 * @param Code_orpltp
	 */
	public void setCode_orpltp(String Code_orpltp) {
		setAttrVal("Code_orpltp", Code_orpltp);
	}
	/**
	 * 闭环名称
	 * @return String
	 */
	public String getName_orpltp() {
		return ((String) getAttrVal("Name_orpltp"));
	}
	/**
	 * 闭环名称
	 * @param Name_orpltp
	 */
	public void setName_orpltp(String Name_orpltp) {
		setAttrVal("Name_orpltp", Name_orpltp);
	}
	/**
	 * 闭环状态
	 * @return String
	 */
	public String getId_orpltpsta() {
		return ((String) getAttrVal("Id_orpltpsta"));
	}
	/**
	 * 闭环状态
	 * @param Id_orpltpsta
	 */
	public void setId_orpltpsta(String Id_orpltpsta) {
		setAttrVal("Id_orpltpsta", Id_orpltpsta);
	}
	/**
	 * 闭环状态编码
	 * @return String
	 */
	public String getCode_orpltpsta() {
		return ((String) getAttrVal("Code_orpltpsta"));
	}
	/**
	 * 闭环状态编码
	 * @param Code_orpltpsta
	 */
	public void setCode_orpltpsta(String Code_orpltpsta) {
		setAttrVal("Code_orpltpsta", Code_orpltpsta);
	}
	/**
	 * 闭环状态名称
	 * @return String
	 */
	public String getName_orpltpsta() {
		return ((String) getAttrVal("Name_orpltpsta"));
	}
	/**
	 * 闭环状态名称
	 * @param Name_orpltpsta
	 */
	public void setName_orpltpsta(String Name_orpltpsta) {
		setAttrVal("Name_orpltpsta", Name_orpltpsta);
	}
	/**
	 * 闭环状态序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 闭环状态序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 功能节点
	 * @return String
	 */
	public String getId_fun() {
		return ((String) getAttrVal("Id_fun"));
	}
	/**
	 * 功能节点
	 * @param Id_fun
	 */
	public void setId_fun(String Id_fun) {
		setAttrVal("Id_fun", Id_fun);
	}
	/**
	 * 功能节点编码
	 * @return String
	 */
	public String getFun_code() {
		return ((String) getAttrVal("Fun_code"));
	}
	/**
	 * 功能节点编码
	 * @param Fun_code
	 */
	public void setFun_code(String Fun_code) {
		setAttrVal("Fun_code", Fun_code);
	}
	/**
	 * 功能节点名称
	 * @return String
	 */
	public String getName_func() {
		return ((String) getAttrVal("Name_func"));
	}
	/**
	 * 功能节点名称
	 * @param Name_func
	 */
	public void setName_func(String Name_func) {
		setAttrVal("Name_func", Name_func);
	}
	/**
	 * 操作
	 * @return String
	 */
	public String getId_oper() {
		return ((String) getAttrVal("Id_oper"));
	}
	/**
	 * 操作
	 * @param Id_oper
	 */
	public void setId_oper(String Id_oper) {
		setAttrVal("Id_oper", Id_oper);
	}
	/**
	 * 操作编码
	 * @return String
	 */
	public String getCode_oper() {
		return ((String) getAttrVal("Code_oper"));
	}
	/**
	 * 操作编码
	 * @param Code_oper
	 */
	public void setCode_oper(String Code_oper) {
		setAttrVal("Code_oper", Code_oper);
	}
	/**
	 * 操作名称
	 * @return String
	 */
	public String getName_oper() {
		return ((String) getAttrVal("Name_oper"));
	}
	/**
	 * 操作名称
	 * @param Name_oper
	 */
	public void setName_oper(String Name_oper) {
		setAttrVal("Name_oper", Name_oper);
	}
	/**
	 * 厂商
	 * @return String
	 */
	public String getId_map_org() {
		return ((String) getAttrVal("Id_map_org"));
	}
	/**
	 * 厂商
	 * @param Id_map_org
	 */
	public void setId_map_org(String Id_map_org) {
		setAttrVal("Id_map_org", Id_map_org);
	}
	/**
	 * 厂商编码
	 * @return String
	 */
	public String getCode_map_org() {
		return ((String) getAttrVal("Code_map_org"));
	}
	/**
	 * 厂商编码
	 * @param Code_map_org
	 */
	public void setCode_map_org(String Code_map_org) {
		setAttrVal("Code_map_org", Code_map_org);
	}
	/**
	 * 厂商名称
	 * @return String
	 */
	public String getName_map_org() {
		return ((String) getAttrVal("Name_map_org"));
	}
	/**
	 * 厂商名称
	 * @param Name_map_org
	 */
	public void setName_map_org(String Name_map_org) {
		setAttrVal("Name_map_org", Name_map_org);
	}
	/**
	 * 产品
	 * @return String
	 */
	public String getId_map_product() {
		return ((String) getAttrVal("Id_map_product"));
	}
	/**
	 * 产品
	 * @param Id_map_product
	 */
	public void setId_map_product(String Id_map_product) {
		setAttrVal("Id_map_product", Id_map_product);
	}
	/**
	 * 产品编码
	 * @return String
	 */
	public String getCode_map_product() {
		return ((String) getAttrVal("Code_map_product"));
	}
	/**
	 * 产品编码
	 * @param Code_map_product
	 */
	public void setCode_map_product(String Code_map_product) {
		setAttrVal("Code_map_product", Code_map_product);
	}
	/**
	 * 产品名称
	 * @return String
	 */
	public String getName_map_product() {
		return ((String) getAttrVal("Name_map_product"));
	}
	/**
	 * 产品名称
	 * @param Name_map_product
	 */
	public void setName_map_product(String Name_map_product) {
		setAttrVal("Name_map_product", Name_map_product);
	}
	/**
	 * 状态编码
	 * @return String
	 */
	public String getMap_code_sta() {
		return ((String) getAttrVal("Map_code_sta"));
	}
	/**
	 * 状态编码
	 * @param Map_code_sta
	 */
	public void setMap_code_sta(String Map_code_sta) {
		setAttrVal("Map_code_sta", Map_code_sta);
	}
	/**
	 * 状态编码名称
	 * @return String
	 */
	public String getMap_name_sta() {
		return ((String) getAttrVal("Map_name_sta"));
	}
	/**
	 * 状态编码名称
	 * @param Map_name_sta
	 */
	public void setMap_name_sta(String Map_name_sta) {
		setAttrVal("Map_name_sta", Map_name_sta);
	}
}