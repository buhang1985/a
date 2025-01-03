package iih.mi.mc.dto.mimcspecdrug.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 特殊病药品校验出参 DTO数据 
 * 
 */
public class MiMcSpecDrugOutDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 是否为特殊病药品
	 * @return FBoolean
	 */
	public FBoolean getFg_specdrug() {
		return ((FBoolean) getAttrVal("Fg_specdrug"));
	}
	/**
	 * 是否为特殊病药品
	 * @param Fg_specdrug
	 */
	public void setFg_specdrug(FBoolean Fg_specdrug) {
		setAttrVal("Fg_specdrug", Fg_specdrug);
	}
	/**
	 * 是否符合特殊病判断
	 * @return FBoolean
	 */
	public FBoolean getFg_specjudge() {
		return ((FBoolean) getAttrVal("Fg_specjudge"));
	}
	/**
	 * 是否符合特殊病判断
	 * @param Fg_specjudge
	 */
	public void setFg_specjudge(FBoolean Fg_specjudge) {
		setAttrVal("Fg_specjudge", Fg_specjudge);
	}
	/**
	 * 诊断或病种集合
	 * @return FArrayList
	 */
	public FArrayList getDeflist() {
		return ((FArrayList) getAttrVal("Deflist"));
	}
	/**
	 * 诊断或病种集合
	 * @param Deflist
	 */
	public void setDeflist(FArrayList Deflist) {
		setAttrVal("Deflist", Deflist);
	}
}