package iih.pe.pitm.dto.pesdlanlingdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检接口_检验合管规则 DTO数据 
 * 
 */
public class Pe3rdLabBarMergerDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 检验项目ID
	 * @return String
	 */
	public String getReq_itemid() {
		return ((String) getAttrVal("Req_itemid"));
	}
	/**
	 * 检验项目ID
	 * @param Req_itemid
	 */
	public void setReq_itemid(String Req_itemid) {
		setAttrVal("Req_itemid", Req_itemid);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getReq_itemcode() {
		return ((String) getAttrVal("Req_itemcode"));
	}
	/**
	 * 项目编码
	 * @param Req_itemcode
	 */
	public void setReq_itemcode(String Req_itemcode) {
		setAttrVal("Req_itemcode", Req_itemcode);
	}
	/**
	 * 姓名名称
	 * @return String
	 */
	public String getReq_itemname() {
		return ((String) getAttrVal("Req_itemname"));
	}
	/**
	 * 姓名名称
	 * @param Req_itemname
	 */
	public void setReq_itemname(String Req_itemname) {
		setAttrVal("Req_itemname", Req_itemname);
	}
	/**
	 * 检验分组ID
	 * @return String
	 */
	public String getId_labgroup() {
		return ((String) getAttrVal("Id_labgroup"));
	}
	/**
	 * 检验分组ID
	 * @param Id_labgroup
	 */
	public void setId_labgroup(String Id_labgroup) {
		setAttrVal("Id_labgroup", Id_labgroup);
	}
	/**
	 * 检验分组编码
	 * @return String
	 */
	public String getSd_labgroup() {
		return ((String) getAttrVal("Sd_labgroup"));
	}
	/**
	 * 检验分组编码
	 * @param Sd_labgroup
	 */
	public void setSd_labgroup(String Sd_labgroup) {
		setAttrVal("Sd_labgroup", Sd_labgroup);
	}
	/**
	 * 标本类型ID
	 * @return String
	 */
	public String getId_samptp() {
		return ((String) getAttrVal("Id_samptp"));
	}
	/**
	 * 标本类型ID
	 * @param Id_samptp
	 */
	public void setId_samptp(String Id_samptp) {
		setAttrVal("Id_samptp", Id_samptp);
	}
	/**
	 * 标本类型编码
	 * @return String
	 */
	public String getSd_samptp() {
		return ((String) getAttrVal("Sd_samptp"));
	}
	/**
	 * 标本类型编码
	 * @param Sd_samptp
	 */
	public void setSd_samptp(String Sd_samptp) {
		setAttrVal("Sd_samptp", Sd_samptp);
	}
	/**
	 * 容器类型ID
	 * @return String
	 */
	public String getId_contp() {
		return ((String) getAttrVal("Id_contp"));
	}
	/**
	 * 容器类型ID
	 * @param Id_contp
	 */
	public void setId_contp(String Id_contp) {
		setAttrVal("Id_contp", Id_contp);
	}
	/**
	 * 容器类型编码
	 * @return String
	 */
	public String getSd_contp() {
		return ((String) getAttrVal("Sd_contp"));
	}
	/**
	 * 容器类型编码
	 * @param Sd_contp
	 */
	public void setSd_contp(String Sd_contp) {
		setAttrVal("Sd_contp", Sd_contp);
	}
	/**
	 * 基本服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 基本服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
}