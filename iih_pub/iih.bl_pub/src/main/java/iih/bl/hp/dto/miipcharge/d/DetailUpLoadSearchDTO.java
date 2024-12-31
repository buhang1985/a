package iih.bl.hp.dto.miipcharge.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 明细上传参数构建查询dto DTO数据 
 * 
 */
public class DetailUpLoadSearchDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 住院结算主键
	 * @return String
	 */
	public String getId_stip() {
		return ((String) getAttrVal("Id_stip"));
	}
	/**
	 * 住院结算主键
	 * @param Id_stip
	 */
	public void setId_stip(String Id_stip) {
		setAttrVal("Id_stip", Id_stip);
	}
}