package iih.hp.cp.ele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.ele.d.desc.HpCpElemMatchDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素对照 DO数据 
 * 
 */
public class HpCpElemMatchDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//对照ID
	public static final String ID_MATCH= "Id_match";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//元素类型ID
	public static final String ID_ELETP= "Id_eletp";
	//对照状态
	public static final String EU_STATUS= "Eu_status";
	//对照目标位置
	public static final String TARGET_POS= "Target_pos";
	//对照目标ID
	public static final String ID_TARGET= "Id_target";
	//对照关系类型
	public static final String EU_MATCH_HP= "Eu_match_hp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 对照ID
	 * @return String
	 */
	public String getId_match() {
		return ((String) getAttrVal("Id_match"));
	}	
	/**
	 * 对照ID
	 * @param Id_match
	 */
	public void setId_match(String Id_match) {
		setAttrVal("Id_match", Id_match);
	}
	/**
	 * 元素ID
	 * @return String
	 */
	public String getId_ele() {
		return ((String) getAttrVal("Id_ele"));
	}	
	/**
	 * 元素ID
	 * @param Id_ele
	 */
	public void setId_ele(String Id_ele) {
		setAttrVal("Id_ele", Id_ele);
	}
	/**
	 * 元素类型ID
	 * @return String
	 */
	public String getId_eletp() {
		return ((String) getAttrVal("Id_eletp"));
	}	
	/**
	 * 元素类型ID
	 * @param Id_eletp
	 */
	public void setId_eletp(String Id_eletp) {
		setAttrVal("Id_eletp", Id_eletp);
	}
	/**
	 * 对照状态
	 * @return Integer
	 */
	public Integer getEu_status() {
		return ((Integer) getAttrVal("Eu_status"));
	}	
	/**
	 * 对照状态
	 * @param Eu_status
	 */
	public void setEu_status(Integer Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	/**
	 * 对照目标位置
	 * @return String
	 */
	public String getTarget_pos() {
		return ((String) getAttrVal("Target_pos"));
	}	
	/**
	 * 对照目标位置
	 * @param Target_pos
	 */
	public void setTarget_pos(String Target_pos) {
		setAttrVal("Target_pos", Target_pos);
	}
	/**
	 * 对照目标ID
	 * @return String
	 */
	public String getId_target() {
		return ((String) getAttrVal("Id_target"));
	}	
	/**
	 * 对照目标ID
	 * @param Id_target
	 */
	public void setId_target(String Id_target) {
		setAttrVal("Id_target", Id_target);
	}
	/**
	 * 对照关系类型
	 * @return Integer
	 */
	public Integer getEu_match_hp() {
		return ((Integer) getAttrVal("Eu_match_hp"));
	}	
	/**
	 * 对照关系类型
	 * @param Eu_match_hp
	 */
	public void setEu_match_hp(Integer Eu_match_hp) {
		setAttrVal("Eu_match_hp", Eu_match_hp);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_match";
	}
	
	@Override
	public String getTableName() {	  
		return "hp_cp_ele_match";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemMatchDODesc.class);
	}
	
}