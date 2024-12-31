package iih.mi.mc.dto.mimcspecdrug.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 特殊病药品校验入参 DTO数据 
 * 
 */
public class MiMcSpecDrugInDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 医保id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 诊断id集合
	 * @return FArrayList
	 */
	public FArrayList getId_didefs() {
		return ((FArrayList) getAttrVal("Id_didefs"));
	}
	/**
	 * 诊断id集合
	 * @param Id_didefs
	 */
	public void setId_didefs(FArrayList Id_didefs) {
		setAttrVal("Id_didefs", Id_didefs);
	}
	/**
	 * 物品id集合
	 * @return FArrayList
	 */
	public FArrayList getId_mms() {
		return ((FArrayList) getAttrVal("Id_mms"));
	}
	/**
	 * 物品id集合
	 * @param Id_mms
	 */
	public void setId_mms(FArrayList Id_mms) {
		setAttrVal("Id_mms", Id_mms);
	}
	/**
	 * 物品病种Map
	 * @return FMap
	 */
	public FMap getMmdsdefs() {
		return ((FMap) getAttrVal("Mmdsdefs"));
	}
	/**
	 * 物品病种Map
	 * @param Mmdsdefs
	 */
	public void setMmdsdefs(FMap Mmdsdefs) {
		setAttrVal("Mmdsdefs", Mmdsdefs);
	}
}