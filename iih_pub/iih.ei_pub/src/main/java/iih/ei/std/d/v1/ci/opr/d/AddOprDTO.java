package iih.ei.std.d.v1.ci.opr.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 附加手术DTO DTO数据 
 * 
 */
public class AddOprDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno_sug_add() {
		return ((String) getAttrVal("Sortno_sug_add"));
	}	
	/**
	 * 序号
	 * @param Sortno_sug_add
	 */
	public void setSortno_sug_add(String Sortno_sug_add) {
		setAttrVal("Sortno_sug_add", Sortno_sug_add);
	}
	/**
	 * 手术项目编码
	 * @return String
	 */
	public String getCode_srv_sug_add() {
		return ((String) getAttrVal("Code_srv_sug_add"));
	}	
	/**
	 * 手术项目编码
	 * @param Code_srv_sug_add
	 */
	public void setCode_srv_sug_add(String Code_srv_sug_add) {
		setAttrVal("Code_srv_sug_add", Code_srv_sug_add);
	}
	/**
	 * 手术项目名称
	 * @return String
	 */
	public String getName_or_sug_add() {
		return ((String) getAttrVal("Name_or_sug_add"));
	}	
	/**
	 * 手术项目名称
	 * @param Name_or_sug_add
	 */
	public void setName_or_sug_add(String Name_or_sug_add) {
		setAttrVal("Name_or_sug_add", Name_or_sug_add);
	}
	/**
	 * 附加标识
	 * @return String
	 */
	public String getEu_sugaddtp() {
		return ((String) getAttrVal("Eu_sugaddtp"));
	}	
	/**
	 * 附加标识
	 * @param Eu_sugaddtp
	 */
	public void setEu_sugaddtp(String Eu_sugaddtp) {
		setAttrVal("Eu_sugaddtp", Eu_sugaddtp);
	}
}