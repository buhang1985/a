package iih.bl.st.dto.bloepcharge.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊调入互斥计算信息 DTO数据 
 * 
 */
public class BlOepMutexCalDTO extends BaseDTO {
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
	 * 医保产品id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保产品id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * displaynam3
	 * @return String
	 */
	public String getName3() {
		return ((String) getAttrVal("Name3"));
	}
	/**
	 * displaynam3
	 * @param Name3
	 */
	public void setName3(String Name3) {
		setAttrVal("Name3", Name3);
	}
	/**
	 * displaynam4
	 * @return String
	 */
	public String getName4() {
		return ((String) getAttrVal("Name4"));
	}
	/**
	 * displaynam4
	 * @param Name4
	 */
	public void setName4(String Name4) {
		setAttrVal("Name4", Name4);
	}
	/**
	 * displaynam5
	 * @return String
	 */
	public String getName5() {
		return ((String) getAttrVal("Name5"));
	}
	/**
	 * displaynam5
	 * @param Name5
	 */
	public void setName5(String Name5) {
		setAttrVal("Name5", Name5);
	}
	/**
	 * displaynam6
	 * @return String
	 */
	public String getName6() {
		return ((String) getAttrVal("Name6"));
	}
	/**
	 * displaynam6
	 * @param Name6
	 */
	public void setName6(String Name6) {
		setAttrVal("Name6", Name6);
	}
	/**
	 * displaynam7
	 * @return String
	 */
	public String getName7() {
		return ((String) getAttrVal("Name7"));
	}
	/**
	 * displaynam7
	 * @param Name7
	 */
	public void setName7(String Name7) {
		setAttrVal("Name7", Name7);
	}
	/**
	 * 外配处方标识
	 * @return String
	 */
	public String getFg_extdispense() {
		return ((String) getAttrVal("Fg_extdispense"));
	}
	/**
	 * 外配处方标识
	 * @param Fg_extdispense
	 */
	public void setFg_extdispense(String Fg_extdispense) {
		setAttrVal("Fg_extdispense", Fg_extdispense);
	}
	/**
	 * 高端商保标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hpcg() {
		return ((FBoolean) getAttrVal("Fg_hpcg"));
	}
	/**
	 * 高端商保标识
	 * @param Fg_hpcg
	 */
	public void setFg_hpcg(FBoolean Fg_hpcg) {
		setAttrVal("Fg_hpcg", Fg_hpcg);
	}
	/**
	 * 预交金标识
	 * @return FBoolean
	 */
	public FBoolean getFg_acc() {
		return ((FBoolean) getAttrVal("Fg_acc"));
	}
	/**
	 * 预交金标识
	 * @param Fg_acc
	 */
	public void setFg_acc(FBoolean Fg_acc) {
		setAttrVal("Fg_acc", Fg_acc);
	}
}