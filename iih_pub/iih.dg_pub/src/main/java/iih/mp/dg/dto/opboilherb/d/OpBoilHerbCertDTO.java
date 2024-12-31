package iih.mp.dg.dto.opboilherb.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊代煎煎药证 DTO数据 
 * 
 */
public class OpBoilHerbCertDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 组织id
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 组织id
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 日期
	 * @return FDate
	 */
	public FDate getDate() {
		return ((FDate) getAttrVal("Date"));
	}
	/**
	 * 日期
	 * @param Date
	 */
	public void setDate(FDate Date) {
		setAttrVal("Date", Date);
	}
	/**
	 * 病人编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 病人编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 病人id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 病人id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 病人名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 病人名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 代煎付数
	 * @return String
	 */
	public String getOrder_boils() {
		return ((String) getAttrVal("Order_boils"));
	}
	/**
	 * 代煎付数
	 * @param Order_boils
	 */
	public void setOrder_boils(String Order_boils) {
		setAttrVal("Order_boils", Order_boils);
	}
	/**
	 * 用法id
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法id
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法名称
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
}