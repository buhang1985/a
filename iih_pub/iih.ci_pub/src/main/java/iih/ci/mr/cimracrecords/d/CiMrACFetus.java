package iih.ci.mr.cimracrecords.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.cimracrecords.d.desc.CiMrACFetusDesc;
import java.math.BigDecimal;

/**
 * 产程胎儿 DO数据 
 * 
 */
public class CiMrACFetus extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRACFETUS= "Id_mracfetus";
	public static final String ID_MRACBASE= "Id_mracbase";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_DIRECTION= "Id_direction";
	public static final String SD_DIRECTION= "Sd_direction";
	public static final String NAME_DIRECTION= "Name_direction";
	public static final String CARDIAC= "Cardiac";
	public static final String WEIGHT= "Weight";
	public static final String ID_POSTION= "Id_postion";
	public static final String SD_POSTION= "Sd_postion";
	public static final String NAME_POSTION= "Name_postion";
	public static final String ID_APPEARHL= "Id_appearhl";
	public static final String SD_APPEARHL= "Sd_appearhl";
	public static final String NAME_APPEARHL= "Name_appearhl";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String DEF6= "Def6";
	public static final String DEF7= "Def7";
	public static final String DEF8= "Def8";
	public static final String DEF9= "Def9";
	public static final String DEF10= "Def10";
	public static final String DIRECTION_CODE= "Direction_code";
	public static final String DIRECTION_NAME= "Direction_name";
	public static final String POSTION_NAME= "Postion_name";
	public static final String POSTION_CODE= "Postion_code";
	public static final String APPEARHL_CODE= "Appearhl_code";
	public static final String APPEARHL_NAME= "Appearhl_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mracfetus() {
		return ((String) getAttrVal("Id_mracfetus"));
	}	
	public void setId_mracfetus(String Id_mracfetus) {
		setAttrVal("Id_mracfetus", Id_mracfetus);
	}
	public String getId_mracbase() {
		return ((String) getAttrVal("Id_mracbase"));
	}	
	public void setId_mracbase(String Id_mracbase) {
		setAttrVal("Id_mracbase", Id_mracbase);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_direction() {
		return ((String) getAttrVal("Id_direction"));
	}	
	public void setId_direction(String Id_direction) {
		setAttrVal("Id_direction", Id_direction);
	}
	public String getSd_direction() {
		return ((String) getAttrVal("Sd_direction"));
	}	
	public void setSd_direction(String Sd_direction) {
		setAttrVal("Sd_direction", Sd_direction);
	}
	public String getName_direction() {
		return ((String) getAttrVal("Name_direction"));
	}	
	public void setName_direction(String Name_direction) {
		setAttrVal("Name_direction", Name_direction);
	}
	public Integer getCardiac() {
		return ((Integer) getAttrVal("Cardiac"));
	}	
	public void setCardiac(Integer Cardiac) {
		setAttrVal("Cardiac", Cardiac);
	}
	public Integer getWeight() {
		return ((Integer) getAttrVal("Weight"));
	}	
	public void setWeight(Integer Weight) {
		setAttrVal("Weight", Weight);
	}
	public String getId_postion() {
		return ((String) getAttrVal("Id_postion"));
	}	
	public void setId_postion(String Id_postion) {
		setAttrVal("Id_postion", Id_postion);
	}
	public String getSd_postion() {
		return ((String) getAttrVal("Sd_postion"));
	}	
	public void setSd_postion(String Sd_postion) {
		setAttrVal("Sd_postion", Sd_postion);
	}
	public String getName_postion() {
		return ((String) getAttrVal("Name_postion"));
	}	
	public void setName_postion(String Name_postion) {
		setAttrVal("Name_postion", Name_postion);
	}
	public String getId_appearhl() {
		return ((String) getAttrVal("Id_appearhl"));
	}	
	public void setId_appearhl(String Id_appearhl) {
		setAttrVal("Id_appearhl", Id_appearhl);
	}
	public String getSd_appearhl() {
		return ((String) getAttrVal("Sd_appearhl"));
	}	
	public void setSd_appearhl(String Sd_appearhl) {
		setAttrVal("Sd_appearhl", Sd_appearhl);
	}
	public String getName_appearhl() {
		return ((String) getAttrVal("Name_appearhl"));
	}	
	public void setName_appearhl(String Name_appearhl) {
		setAttrVal("Name_appearhl", Name_appearhl);
	}
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	public String getDirection_code() {
		return ((String) getAttrVal("Direction_code"));
	}	
	public void setDirection_code(String Direction_code) {
		setAttrVal("Direction_code", Direction_code);
	}
	public String getDirection_name() {
		return ((String) getAttrVal("Direction_name"));
	}	
	public void setDirection_name(String Direction_name) {
		setAttrVal("Direction_name", Direction_name);
	}
	public String getPostion_name() {
		return ((String) getAttrVal("Postion_name"));
	}	
	public void setPostion_name(String Postion_name) {
		setAttrVal("Postion_name", Postion_name);
	}
	public String getPostion_code() {
		return ((String) getAttrVal("Postion_code"));
	}	
	public void setPostion_code(String Postion_code) {
		setAttrVal("Postion_code", Postion_code);
	}
	public String getAppearhl_code() {
		return ((String) getAttrVal("Appearhl_code"));
	}	
	public void setAppearhl_code(String Appearhl_code) {
		setAttrVal("Appearhl_code", Appearhl_code);
	}
	public String getAppearhl_name() {
		return ((String) getAttrVal("Appearhl_name"));
	}	
	public void setAppearhl_name(String Appearhl_name) {
		setAttrVal("Appearhl_name", Appearhl_name);
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
		return "Id_mracfetus";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_ac_fetus";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrACFetusDesc.class);
	}
	
}