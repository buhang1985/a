package iih.mp.nr.mpwardprint.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 单据树表示DTO DTO数据 
 * 
 */
public class MpOrPrncaTreeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 单据分类id
	 * @return String
	 */
	public String getId_or_prnca() {
		return ((String) getAttrVal("Id_or_prnca"));
	}
	/**
	 * 单据分类id
	 * @param Id_or_prnca
	 */
	public void setId_or_prnca(String Id_or_prnca) {
		setAttrVal("Id_or_prnca", Id_or_prnca);
	}
	/**
	 * 单据名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 单据名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 父级ID
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}
	/**
	 * 父级ID
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	/**
	 * 父级SD
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 父级SD
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 允许多选
	 * @return FBoolean
	 */
	public FBoolean getFg_multi() {
		return ((FBoolean) getAttrVal("Fg_multi"));
	}
	/**
	 * 允许多选
	 * @param Fg_multi
	 */
	public void setFg_multi(FBoolean Fg_multi) {
		setAttrVal("Fg_multi", Fg_multi);
	}
}