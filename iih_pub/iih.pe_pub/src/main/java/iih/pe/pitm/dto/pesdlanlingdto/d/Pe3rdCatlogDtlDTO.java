package iih.pe.pitm.dto.pesdlanlingdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检接口_项目明细 DTO数据 
 * 
 */
public class Pe3rdCatlogDtlDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode_catlog() {
		return ((String) getAttrVal("Code_catlog"));
	}
	/**
	 * 项目编码
	 * @param Code_catlog
	 */
	public void setCode_catlog(String Code_catlog) {
		setAttrVal("Code_catlog", Code_catlog);
	}
	/**
	 * 结果编码
	 * @return String
	 */
	public String getCode_item() {
		return ((String) getAttrVal("Code_item"));
	}
	/**
	 * 结果编码
	 * @param Code_item
	 */
	public void setCode_item(String Code_item) {
		setAttrVal("Code_item", Code_item);
	}
	/**
	 * 体检项目ID
	 * @return String
	 */
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}
	/**
	 * 体检项目ID
	 * @param Id_pesrvbcatlog
	 */
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
	}
	/**
	 * 体检结果ID
	 * @return String
	 */
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}
	/**
	 * 体检结果ID
	 * @param Id_pesrvitem
	 */
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
}