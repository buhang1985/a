package iih.pi.reg.pat.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.reg.pat.d.desc.PiPatHpDODesc;
import java.math.BigDecimal;

/**
 * 患者医保计划 DO数据 
 * 
 */
public class PiPatHpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者医保计划ID
	public static final String ID_PATHP= "Id_pathp";
	//患者
	public static final String ID_PAT= "Id_pat";
	//序号
	public static final String SORTNO= "Sortno";
	//医保证件号码
	public static final String NO_HP= "No_hp";
	//医保计划
	public static final String ID_HP= "Id_hp";
	//默认标志
	public static final String FG_DEFT= "Fg_deft";
	//医保计划有效方式
	public static final String MODE_HP= "Mode_hp";
	//有效日期开始
	public static final String DT_B= "Dt_b";
	//有效日期结束
	public static final String DT_E= "Dt_e";
	//启用标志
	public static final String FG_ACT= "Fg_act";
	//chis建档使用医保计划
	public static final String FG_CHISUSE= "Fg_chisuse";
	//医保计划编码
	public static final String HP_CODE= "Hp_code";
	//医保计划名称
	public static final String HP_NAME= "Hp_name";
	//医保号码必填标志
	public static final String FG_REQHPCODE= "Fg_reqhpcode";
	//编码
	public static final String MODEHP_CODE= "Modehp_code";
	//名称
	public static final String MODEHP_NAME= "Modehp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者医保计划ID
	 * @return String
	 */
	public String getId_pathp() {
		return ((String) getAttrVal("Id_pathp"));
	}	
	/**
	 * 患者医保计划ID
	 * @param Id_pathp
	 */
	public void setId_pathp(String Id_pathp) {
		setAttrVal("Id_pathp", Id_pathp);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 医保证件号码
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}	
	/**
	 * 医保证件号码
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
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
	 * 默认标志
	 * @return FBoolean
	 */
	public FBoolean getFg_deft() {
		return ((FBoolean) getAttrVal("Fg_deft"));
	}	
	/**
	 * 默认标志
	 * @param Fg_deft
	 */
	public void setFg_deft(FBoolean Fg_deft) {
		setAttrVal("Fg_deft", Fg_deft);
	}
	/**
	 * 医保计划有效方式
	 * @return String
	 */
	public String getMode_hp() {
		return ((String) getAttrVal("Mode_hp"));
	}	
	/**
	 * 医保计划有效方式
	 * @param Mode_hp
	 */
	public void setMode_hp(String Mode_hp) {
		setAttrVal("Mode_hp", Mode_hp);
	}
	/**
	 * 有效日期开始
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	/**
	 * 有效日期开始
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 有效日期结束
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	/**
	 * 有效日期结束
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_act() {
		return ((FBoolean) getAttrVal("Fg_act"));
	}	
	/**
	 * 启用标志
	 * @param Fg_act
	 */
	public void setFg_act(FBoolean Fg_act) {
		setAttrVal("Fg_act", Fg_act);
	}
	/**
	 * chis建档使用医保计划
	 * @return FBoolean
	 */
	public FBoolean getFg_chisuse() {
		return ((FBoolean) getAttrVal("Fg_chisuse"));
	}	
	/**
	 * chis建档使用医保计划
	 * @param Fg_chisuse
	 */
	public void setFg_chisuse(FBoolean Fg_chisuse) {
		setAttrVal("Fg_chisuse", Fg_chisuse);
	}
	/**
	 * 医保计划编码
	 * @return String
	 */
	public String getHp_code() {
		return ((String) getAttrVal("Hp_code"));
	}	
	/**
	 * 医保计划编码
	 * @param Hp_code
	 */
	public void setHp_code(String Hp_code) {
		setAttrVal("Hp_code", Hp_code);
	}
	/**
	 * 医保计划名称
	 * @return String
	 */
	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}	
	/**
	 * 医保计划名称
	 * @param Hp_name
	 */
	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
	}
	/**
	 * 医保号码必填标志
	 * @return FBoolean
	 */
	public FBoolean getFg_reqhpcode() {
		return ((FBoolean) getAttrVal("Fg_reqhpcode"));
	}	
	/**
	 * 医保号码必填标志
	 * @param Fg_reqhpcode
	 */
	public void setFg_reqhpcode(FBoolean Fg_reqhpcode) {
		setAttrVal("Fg_reqhpcode", Fg_reqhpcode);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getModehp_code() {
		return ((String) getAttrVal("Modehp_code"));
	}	
	/**
	 * 编码
	 * @param Modehp_code
	 */
	public void setModehp_code(String Modehp_code) {
		setAttrVal("Modehp_code", Modehp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getModehp_name() {
		return ((String) getAttrVal("Modehp_name"));
	}	
	/**
	 * 名称
	 * @param Modehp_name
	 */
	public void setModehp_name(String Modehp_name) {
		setAttrVal("Modehp_name", Modehp_name);
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
		return "Id_pathp";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_hp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatHpDODesc.class);
	}
	
}