package iih.mi.mc.dto.mimcdidepend.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保诊断依赖入参 DTO数据 
 * 
 */
public class MiMcDiDependInParamDTO extends BaseDTO {
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
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 删除诊断列表
	 * @return FArrayList
	 */
	public FArrayList getDeldiids() {
		return ((FArrayList) getAttrVal("Deldiids"));
	}
	/**
	 * 删除诊断列表
	 * @param Deldiids
	 */
	public void setDeldiids(FArrayList Deldiids) {
		setAttrVal("Deldiids", Deldiids);
	}
	/**
	 * 全部诊断列表
	 * @return FArrayList
	 */
	public FArrayList getAlldiids() {
		return ((FArrayList) getAttrVal("Alldiids"));
	}
	/**
	 * 全部诊断列表
	 * @param Alldiids
	 */
	public void setAlldiids(FArrayList Alldiids) {
		setAttrVal("Alldiids", Alldiids);
	}
}