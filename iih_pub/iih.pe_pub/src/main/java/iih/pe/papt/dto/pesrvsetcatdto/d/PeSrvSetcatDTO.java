package iih.pe.papt.dto.pesrvsetcatdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检套餐明细 DTO数据 
 * 
 */
public class PeSrvSetcatDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检套餐项目主键标识
	 * @return String
	 */
	public String getId_pesrvsetitmdef() {
		return ((String) getAttrVal("Id_pesrvsetitmdef"));
	}
	/**
	 * 体检套餐项目主键标识
	 * @param Id_pesrvsetitmdef
	 */
	public void setId_pesrvsetitmdef(String Id_pesrvsetitmdef) {
		setAttrVal("Id_pesrvsetitmdef", Id_pesrvsetitmdef);
	}
	/**
	 * 体检套餐主键标识
	 * @return String
	 */
	public String getId_pesrvsetdef() {
		return ((String) getAttrVal("Id_pesrvsetdef"));
	}
	/**
	 * 体检套餐主键标识
	 * @param Id_pesrvsetdef
	 */
	public void setId_pesrvsetdef(String Id_pesrvsetdef) {
		setAttrVal("Id_pesrvsetdef", Id_pesrvsetdef);
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
	 * 数量
	 * @return String
	 */
	public String getQty() {
		return ((String) getAttrVal("Qty"));
	}
	/**
	 * 数量
	 * @param Qty
	 */
	public void setQty(String Qty) {
		setAttrVal("Qty", Qty);
	}
	/**
	 * 显示序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 显示序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode_cat() {
		return ((String) getAttrVal("Code_cat"));
	}
	/**
	 * 项目编码
	 * @param Code_cat
	 */
	public void setCode_cat(String Code_cat) {
		setAttrVal("Code_cat", Code_cat);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName_cat() {
		return ((String) getAttrVal("Name_cat"));
	}
	/**
	 * 项目名称
	 * @param Name_cat
	 */
	public void setName_cat(String Name_cat) {
		setAttrVal("Name_cat", Name_cat);
	}
}