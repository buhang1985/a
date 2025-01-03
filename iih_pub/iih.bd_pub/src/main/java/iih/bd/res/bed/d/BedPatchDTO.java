package iih.bd.res.bed.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 床位批量操作DTO DTO数据 
 * 
 */
public class BedPatchDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 主键
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 床位类型
	 * @return String
	 */
	public String getId_bedtp() {
		return ((String) getAttrVal("Id_bedtp"));
	}
	/**
	 * 床位类型
	 * @param Id_bedtp
	 */
	public void setId_bedtp(String Id_bedtp) {
		setAttrVal("Id_bedtp", Id_bedtp);
	}
	/**
	 * 床位类型编码
	 * @return String
	 */
	public String getSd_bedtp() {
		return ((String) getAttrVal("Sd_bedtp"));
	}
	/**
	 * 床位类型编码
	 * @param Sd_bedtp
	 */
	public void setSd_bedtp(String Sd_bedtp) {
		setAttrVal("Sd_bedtp", Sd_bedtp);
	}
	/**
	 * 床位类型名称
	 * @return String
	 */
	public String getBedtp_name() {
		return ((String) getAttrVal("Bedtp_name"));
	}
	/**
	 * 床位类型名称
	 * @param Bedtp_name
	 */
	public void setBedtp_name(String Bedtp_name) {
		setAttrVal("Bedtp_name", Bedtp_name);
	}
	/**
	 * 床号前缀符
	 * @return String
	 */
	public String getBednopre() {
		return ((String) getAttrVal("Bednopre"));
	}
	/**
	 * 床号前缀符
	 * @param Bednopre
	 */
	public void setBednopre(String Bednopre) {
		setAttrVal("Bednopre", Bednopre);
	}
	/**
	 * 起始床位号
	 * @return Integer
	 */
	public Integer getBedpreno() {
		return ((Integer) getAttrVal("Bedpreno"));
	}
	/**
	 * 起始床位号
	 * @param Bedpreno
	 */
	public void setBedpreno(Integer Bedpreno) {
		setAttrVal("Bedpreno", Bedpreno);
	}
	/**
	 * 结束床位号
	 * @return Integer
	 */
	public Integer getBedendno() {
		return ((Integer) getAttrVal("Bedendno"));
	}
	/**
	 * 结束床位号
	 * @param Bedendno
	 */
	public void setBedendno(Integer Bedendno) {
		setAttrVal("Bedendno", Bedendno);
	}
	/**
	 * 床位费用模板
	 * @return String
	 */
	public String getId_bltpl() {
		return ((String) getAttrVal("Id_bltpl"));
	}
	/**
	 * 床位费用模板
	 * @param Id_bltpl
	 */
	public void setId_bltpl(String Id_bltpl) {
		setAttrVal("Id_bltpl", Id_bltpl);
	}
	/**
	 * 床位费用模板名称
	 * @return String
	 */
	public String getBltpl_name() {
		return ((String) getAttrVal("Bltpl_name"));
	}
	/**
	 * 床位费用模板名称
	 * @param Bltpl_name
	 */
	public void setBltpl_name(String Bltpl_name) {
		setAttrVal("Bltpl_name", Bltpl_name);
	}
	/**
	 * 包床费用模板
	 * @return String
	 */
	public String getId_bltpl_rent() {
		return ((String) getAttrVal("Id_bltpl_rent"));
	}
	/**
	 * 包床费用模板
	 * @param Id_bltpl_rent
	 */
	public void setId_bltpl_rent(String Id_bltpl_rent) {
		setAttrVal("Id_bltpl_rent", Id_bltpl_rent);
	}
	/**
	 * 包床费用模板名称
	 * @return String
	 */
	public String getBltpl_rent_name() {
		return ((String) getAttrVal("Bltpl_rent_name"));
	}
	/**
	 * 包床费用模板名称
	 * @param Bltpl_rent_name
	 */
	public void setBltpl_rent_name(String Bltpl_rent_name) {
		setAttrVal("Bltpl_rent_name", Bltpl_rent_name);
	}
	/**
	 * 不付费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_nofee() {
		return ((FBoolean) getAttrVal("Fg_nofee"));
	}
	/**
	 * 不付费标志
	 * @param Fg_nofee
	 */
	public void setFg_nofee(FBoolean Fg_nofee) {
		setAttrVal("Fg_nofee", Fg_nofee);
	}
}