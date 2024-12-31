package iih.bl.cg.blcgzyquerydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院日清单节点报表表头 DTO数据 
 * 
 */
public class BlCgZyQueryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}
	/**
	 * 患者编码
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 住院序号
	 * @return String
	 */
	public String getEnent_code() {
		return ((String) getAttrVal("Enent_code"));
	}
	/**
	 * 住院序号
	 * @param Enent_code
	 */
	public void setEnent_code(String Enent_code) {
		setAttrVal("Enent_code", Enent_code);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getPat_dt_acpt() {
		return ((FDateTime) getAttrVal("Pat_dt_acpt"));
	}
	/**
	 * 入院日期
	 * @param Pat_dt_acpt
	 */
	public void setPat_dt_acpt(FDateTime Pat_dt_acpt) {
		setAttrVal("Pat_dt_acpt", Pat_dt_acpt);
	}
	/**
	 * 价格分类
	 * @return String
	 */
	public String getPat_id_pricca() {
		return ((String) getAttrVal("Pat_id_pricca"));
	}
	/**
	 * 价格分类
	 * @param Pat_id_pricca
	 */
	public void setPat_id_pricca(String Pat_id_pricca) {
		setAttrVal("Pat_id_pricca", Pat_id_pricca);
	}
	/**
	 * 当前科室
	 * @return String
	 */
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}
	/**
	 * 当前科室
	 * @param Id_dep_phyadm
	 */
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	/**
	 * 预交金余额
	 * @return FDouble
	 */
	public FDouble getPrepay_balance() {
		return ((FDouble) getAttrVal("Prepay_balance"));
	}
	/**
	 * 预交金余额
	 * @param Prepay_balance
	 */
	public void setPrepay_balance(FDouble Prepay_balance) {
		setAttrVal("Prepay_balance", Prepay_balance);
	}
	/**
	 * 制表时间
	 * @return String
	 */
	public String getCreatedtime() {
		return ((String) getAttrVal("Createdtime"));
	}
	/**
	 * 制表时间
	 * @param Createdtime
	 */
	public void setCreatedtime(String Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 制表人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}
	/**
	 * 制表人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
}