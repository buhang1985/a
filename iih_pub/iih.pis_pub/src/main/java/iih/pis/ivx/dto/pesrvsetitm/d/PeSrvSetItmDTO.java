package iih.pis.ivx.dto.pesrvsetitm.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检套餐项目-微信 DTO数据 
 * 
 */
public class PeSrvSetItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检套餐项目主键标识
	 * @return String
	 */
	public String getId_pesrvsetitm() {
		return ((String) getAttrVal("Id_pesrvsetitm"));
	}
	/**
	 * 体检套餐项目主键标识
	 * @param Id_pesrvsetitm
	 */
	public void setId_pesrvsetitm(String Id_pesrvsetitm) {
		setAttrVal("Id_pesrvsetitm", Id_pesrvsetitm);
	}
	/**
	 * 体检套餐主键标识
	 * @return String
	 */
	public String getId_pesrvset() {
		return ((String) getAttrVal("Id_pesrvset"));
	}
	/**
	 * 体检套餐主键标识
	 * @param Id_pesrvset
	 */
	public void setId_pesrvset(String Id_pesrvset) {
		setAttrVal("Id_pesrvset", Id_pesrvset);
	}
	/**
	 * 体检项目主键标识
	 * @return String
	 */
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}
	/**
	 * 体检项目主键标识
	 * @param Id_pesrvbcatlog
	 */
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
	}
	/**
	 * displaynam8
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * displaynam8
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
	 * 数量
	 * @return Integer
	 */
	public Integer getQry() {
		return ((Integer) getAttrVal("Qry"));
	}
	/**
	 * 数量
	 * @param Qry
	 */
	public void setQry(Integer Qry) {
		setAttrVal("Qry", Qry);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 体检套餐编码
	 * @return String
	 */
	public String getSd_set() {
		return ((String) getAttrVal("Sd_set"));
	}
	/**
	 * 体检套餐编码
	 * @param Sd_set
	 */
	public void setSd_set(String Sd_set) {
		setAttrVal("Sd_set", Sd_set);
	}
	/**
	 * 体检项目编码
	 * @return String
	 */
	public String getSd_catlog() {
		return ((String) getAttrVal("Sd_catlog"));
	}
	/**
	 * 体检项目编码
	 * @param Sd_catlog
	 */
	public void setSd_catlog(String Sd_catlog) {
		setAttrVal("Sd_catlog", Sd_catlog);
	}
	/**
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
}