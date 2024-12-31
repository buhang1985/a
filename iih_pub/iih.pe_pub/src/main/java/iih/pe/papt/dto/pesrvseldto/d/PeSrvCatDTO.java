package iih.pe.papt.dto.pesrvseldto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检项目基本目录 DTO数据 
 * 
 */
public class PeSrvCatDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 项目编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 项目编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 姓名名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 姓名名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 基础价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 基础价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 最大折扣
	 * @return FDouble
	 */
	public FDouble getMax_discount() {
		return ((FDouble) getAttrVal("Max_discount"));
	}
	/**
	 * 最大折扣
	 * @param Max_discount
	 */
	public void setMax_discount(FDouble Max_discount) {
		setAttrVal("Max_discount", Max_discount);
	}
	/**
	 * 性别适用
	 * @return String
	 */
	public String getSexlimit() {
		return ((String) getAttrVal("Sexlimit"));
	}
	/**
	 * 性别适用
	 * @param Sexlimit
	 */
	public void setSexlimit(String Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	/**
	 * 婴儿适用
	 * @return FBoolean
	 */
	public FBoolean getFg_enfant() {
		return ((FBoolean) getAttrVal("Fg_enfant"));
	}
	/**
	 * 婴儿适用
	 * @param Fg_enfant
	 */
	public void setFg_enfant(FBoolean Fg_enfant) {
		setAttrVal("Fg_enfant", Fg_enfant);
	}
	/**
	 * 孕妇适用
	 * @return FBoolean
	 */
	public FBoolean getFg_pregnent() {
		return ((FBoolean) getAttrVal("Fg_pregnent"));
	}
	/**
	 * 孕妇适用
	 * @param Fg_pregnent
	 */
	public void setFg_pregnent(FBoolean Fg_pregnent) {
		setAttrVal("Fg_pregnent", Fg_pregnent);
	}
	/**
	 * 预约人数限制
	 * @return Integer
	 */
	public Integer getMax_limit() {
		return ((Integer) getAttrVal("Max_limit"));
	}
	/**
	 * 预约人数限制
	 * @param Max_limit
	 */
	public void setMax_limit(Integer Max_limit) {
		setAttrVal("Max_limit", Max_limit);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
}