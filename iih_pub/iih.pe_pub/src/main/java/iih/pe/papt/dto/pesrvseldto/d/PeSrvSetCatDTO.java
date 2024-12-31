package iih.pe.papt.dto.pesrvseldto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检套餐项目 DTO数据 
 * 
 */
public class PeSrvSetCatDTO extends BaseDTO {
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
	 * 体检套餐主键
	 * @return String
	 */
	public String getId_pesrvsetdef() {
		return ((String) getAttrVal("Id_pesrvsetdef"));
	}
	/**
	 * 体检套餐主键
	 * @param Id_pesrvsetdef
	 */
	public void setId_pesrvsetdef(String Id_pesrvsetdef) {
		setAttrVal("Id_pesrvsetdef", Id_pesrvsetdef);
	}
	/**
	 * 体检项目主键
	 * @return String
	 */
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}
	/**
	 * 体检项目主键
	 * @param Id_pesrvbcatlog
	 */
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQty() {
		return ((FDouble) getAttrVal("Qty"));
	}
	/**
	 * 数量
	 * @param Qty
	 */
	public void setQty(FDouble Qty) {
		setAttrVal("Qty", Qty);
	}
}