package iih.mi.mc.dto.mimcwholerule.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 诊断信息 DTO数据 
 * 
 */
public class MiMcDiDefDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊断id
	 * @return String
	 */
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}
	/**
	 * 诊断id
	 * @param Id_didef
	 */
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	/**
	 * 诊断code
	 * @return String
	 */
	public String getCode_didef() {
		return ((String) getAttrVal("Code_didef"));
	}
	/**
	 * 诊断code
	 * @param Code_didef
	 */
	public void setCode_didef(String Code_didef) {
		setAttrVal("Code_didef", Code_didef);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_didef() {
		return ((String) getAttrVal("Name_didef"));
	}
	/**
	 * 诊断名称
	 * @param Name_didef
	 */
	public void setName_didef(String Name_didef) {
		setAttrVal("Name_didef", Name_didef);
	}
	/**
	 * 是否慢病诊断
	 * @return FBoolean
	 */
	public FBoolean getFg_haschronic() {
		return ((FBoolean) getAttrVal("Fg_haschronic"));
	}
	/**
	 * 是否慢病诊断
	 * @param Fg_haschronic
	 */
	public void setFg_haschronic(FBoolean Fg_haschronic) {
		setAttrVal("Fg_haschronic", Fg_haschronic);
	}
	/**
	 * 是否行动不便诊断
	 * @return FBoolean
	 */
	public FBoolean getFg_hasmovediff() {
		return ((FBoolean) getAttrVal("Fg_hasmovediff"));
	}
	/**
	 * 是否行动不便诊断
	 * @param Fg_hasmovediff
	 */
	public void setFg_hasmovediff(FBoolean Fg_hasmovediff) {
		setAttrVal("Fg_hasmovediff", Fg_hasmovediff);
	}
}