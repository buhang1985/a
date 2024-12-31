package iih.pi.reg.dto.patinfosupplement.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者地址 DTO数据 
 * 
 */
public class PatAddDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者地址主键
	 * @return String
	 */
	public String getId_pataddr() {
		return ((String) getAttrVal("Id_pataddr"));
	}
	/**
	 * 患者地址主键
	 * @param Id_pataddr
	 */
	public void setId_pataddr(String Id_pataddr) {
		setAttrVal("Id_pataddr", Id_pataddr);
	}
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 地址类型编码
	 * @return String
	 */
	public String getSd_addrtp() {
		return ((String) getAttrVal("Sd_addrtp"));
	}
	/**
	 * 地址类型编码
	 * @param Sd_addrtp
	 */
	public void setSd_addrtp(String Sd_addrtp) {
		setAttrVal("Sd_addrtp", Sd_addrtp);
	}
	/**
	 * 地址类型
	 * @return String
	 */
	public String getId_addrtp() {
		return ((String) getAttrVal("Id_addrtp"));
	}
	/**
	 * 地址类型
	 * @param Id_addrtp
	 */
	public void setId_addrtp(String Id_addrtp) {
		setAttrVal("Id_addrtp", Id_addrtp);
	}
	/**
	 * 地址区县编码
	 * @return String
	 */
	public String getSd_admdiv() {
		return ((String) getAttrVal("Sd_admdiv"));
	}
	/**
	 * 地址区县编码
	 * @param Sd_admdiv
	 */
	public void setSd_admdiv(String Sd_admdiv) {
		setAttrVal("Sd_admdiv", Sd_admdiv);
	}
	/**
	 * 地址id
	 * @return String
	 */
	public String getId_admdiv() {
		return ((String) getAttrVal("Id_admdiv"));
	}
	/**
	 * 地址id
	 * @param Id_admdiv
	 */
	public void setId_admdiv(String Id_admdiv) {
		setAttrVal("Id_admdiv", Id_admdiv);
	}
	/**
	 * 县镇街道地址
	 * @return String
	 */
	public String getStreet() {
		return ((String) getAttrVal("Street"));
	}
	/**
	 * 县镇街道地址
	 * @param Street
	 */
	public void setStreet(String Street) {
		setAttrVal("Street", Street);
	}
	/**
	 * 邮政编码
	 * @return String
	 */
	public String getZip() {
		return ((String) getAttrVal("Zip"));
	}
	/**
	 * 邮政编码
	 * @param Zip
	 */
	public void setZip(String Zip) {
		setAttrVal("Zip", Zip);
	}
	/**
	 * 地址电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}
	/**
	 * 地址电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
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
	 * 地址区县
	 * @return String
	 */
	public String getName_admdiv() {
		return ((String) getAttrVal("Name_admdiv"));
	}
	/**
	 * 地址区县
	 * @param Name_admdiv
	 */
	public void setName_admdiv(String Name_admdiv) {
		setAttrVal("Name_admdiv", Name_admdiv);
	}
	/**
	 * 地址类型名称
	 * @return String
	 */
	public String getName_addrtp() {
		return ((String) getAttrVal("Name_addrtp"));
	}
	/**
	 * 地址类型名称
	 * @param Name_addrtp
	 */
	public void setName_addrtp(String Name_addrtp) {
		setAttrVal("Name_addrtp", Name_addrtp);
	}
}