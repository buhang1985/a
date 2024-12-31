package iih.pis.ivx.dto.peoptioninfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检自测问卷选项 DTO数据 
 * 
 */
public class PeOptionInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检自测问卷选项主键标识
	 * @return String
	 */
	public String getId_option() {
		return ((String) getAttrVal("Id_option"));
	}
	/**
	 * 体检自测问卷选项主键标识
	 * @param Id_option
	 */
	public void setId_option(String Id_option) {
		setAttrVal("Id_option", Id_option);
	}
	/**
	 * 体检自测问卷问题主键标识
	 * @return String
	 */
	public String getId_question() {
		return ((String) getAttrVal("Id_question"));
	}
	/**
	 * 体检自测问卷问题主键标识
	 * @param Id_question
	 */
	public void setId_question(String Id_question) {
		setAttrVal("Id_question", Id_question);
	}
	/**
	 * 选项名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 选项名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 选项编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 选项编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
}