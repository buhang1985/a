package iih.bl.pay.blrtnreasondto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 退款原因 DTO数据 
 * 
 */
public class BlRtnReasonDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 原因主键
	 * @return String
	 */
	public String getId_udidoc() {
		return ((String) getAttrVal("Id_udidoc"));
	}
	/**
	 * 原因主键
	 * @param Id_udidoc
	 */
	public void setId_udidoc(String Id_udidoc) {
		setAttrVal("Id_udidoc", Id_udidoc);
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
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
}