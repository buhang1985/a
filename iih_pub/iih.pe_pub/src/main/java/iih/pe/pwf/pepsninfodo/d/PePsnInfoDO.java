package iih.pe.pwf.pepsninfodo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.pepsninfodo.d.desc.PePsnInfoDODesc;
import java.math.BigDecimal;

/**
 * 体检分检个人基本资料显示 DO数据 
 * 
 */
public class PePsnInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	public static final String CODE= "Code";
	public static final String NAME_PSN= "Name_psn";
	public static final String ID_SEX= "Id_sex";
	public static final String ID_MARRY= "Id_marry";
	public static final String DT_BIRTH= "Dt_birth";
	public static final String AGE= "Age";
	public static final String SEX= "Sex";
	public static final String SD_SEX_PSN= "Sd_sex_psn";
	public static final String MARRIED= "Married";
	public static final String MOBI= "Mobi";
	public static final String IDCODE= "Idcode";
	public static final String PHO= "Pho";
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	public static final String NAME_SET= "Name_set";
	public static final String PE_TIMES= "Pe_times";
	public static final String CARD_PE= "Card_pe";
	public static final String DT_PE= "Dt_pe";
	public static final String PESTATUS= "Pestatus";
	public static final String ID_PECORPAPPT= "Id_pecorpappt";
	public static final String PE_CORP_STATUS= "Pe_corp_status";
	public static final String ID_PECORPBINFO= "Id_pecorpbinfo";
	public static final String NAME_CORP= "Name_corp";
	public static final String RMK_PE= "Rmk_pe";
	public static final String PE_CODE= "Pe_code";
	public static final String ID_PEDIROOM= "Id_pediroom";
	public static final String ROOM_CUR= "Room_cur";
	public static final String NAME_ROOM= "Name_room";
	public static final String CODE_ROOM= "Code_room";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}	
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	public Integer getAge() {
		return ((Integer) getAttrVal("Age"));
	}	
	public void setAge(Integer Age) {
		setAttrVal("Age", Age);
	}
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}	
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	public String getSd_sex_psn() {
		return ((String) getAttrVal("Sd_sex_psn"));
	}	
	public void setSd_sex_psn(String Sd_sex_psn) {
		setAttrVal("Sd_sex_psn", Sd_sex_psn);
	}
	public String getMarried() {
		return ((String) getAttrVal("Married"));
	}	
	public void setMarried(String Married) {
		setAttrVal("Married", Married);
	}
	public String getMobi() {
		return ((String) getAttrVal("Mobi"));
	}	
	public void setMobi(String Mobi) {
		setAttrVal("Mobi", Mobi);
	}
	public String getIdcode() {
		return ((String) getAttrVal("Idcode"));
	}	
	public void setIdcode(String Idcode) {
		setAttrVal("Idcode", Idcode);
	}
	public byte[] getPho() {
		return ((byte[]) getAttrVal("Pho"));
	}	
	public void setPho(byte[] Pho) {
		setAttrVal("Pho", Pho);
	}
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	public String getName_set() {
		return ((String) getAttrVal("Name_set"));
	}	
	public void setName_set(String Name_set) {
		setAttrVal("Name_set", Name_set);
	}
	public String getPe_times() {
		return ((String) getAttrVal("Pe_times"));
	}	
	public void setPe_times(String Pe_times) {
		setAttrVal("Pe_times", Pe_times);
	}
	public String getCard_pe() {
		return ((String) getAttrVal("Card_pe"));
	}	
	public void setCard_pe(String Card_pe) {
		setAttrVal("Card_pe", Card_pe);
	}
	public FDate getDt_pe() {
		return ((FDate) getAttrVal("Dt_pe"));
	}	
	public void setDt_pe(FDate Dt_pe) {
		setAttrVal("Dt_pe", Dt_pe);
	}
	public Integer getPestatus() {
		return ((Integer) getAttrVal("Pestatus"));
	}	
	public void setPestatus(Integer Pestatus) {
		setAttrVal("Pestatus", Pestatus);
	}
	public String getId_pecorpappt() {
		return ((String) getAttrVal("Id_pecorpappt"));
	}	
	public void setId_pecorpappt(String Id_pecorpappt) {
		setAttrVal("Id_pecorpappt", Id_pecorpappt);
	}
	public String getPe_corp_status() {
		return ((String) getAttrVal("Pe_corp_status"));
	}	
	public void setPe_corp_status(String Pe_corp_status) {
		setAttrVal("Pe_corp_status", Pe_corp_status);
	}
	public String getId_pecorpbinfo() {
		return ((String) getAttrVal("Id_pecorpbinfo"));
	}	
	public void setId_pecorpbinfo(String Id_pecorpbinfo) {
		setAttrVal("Id_pecorpbinfo", Id_pecorpbinfo);
	}
	public String getName_corp() {
		return ((String) getAttrVal("Name_corp"));
	}	
	public void setName_corp(String Name_corp) {
		setAttrVal("Name_corp", Name_corp);
	}
	public String getRmk_pe() {
		return ((String) getAttrVal("Rmk_pe"));
	}	
	public void setRmk_pe(String Rmk_pe) {
		setAttrVal("Rmk_pe", Rmk_pe);
	}
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}	
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	public String getId_pediroom() {
		return ((String) getAttrVal("Id_pediroom"));
	}	
	public void setId_pediroom(String Id_pediroom) {
		setAttrVal("Id_pediroom", Id_pediroom);
	}
	public String getRoom_cur() {
		return ((String) getAttrVal("Room_cur"));
	}	
	public void setRoom_cur(String Room_cur) {
		setAttrVal("Room_cur", Room_cur);
	}
	public String getName_room() {
		return ((String) getAttrVal("Name_room"));
	}	
	public void setName_room(String Name_room) {
		setAttrVal("Name_room", Name_room);
	}
	public String getCode_room() {
		return ((String) getAttrVal("Code_room"));
	}	
	public void setCode_room(String Code_room) {
		setAttrVal("Code_room", Code_room);
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
		return "Id_pepsnbinfo";
	}
	
	@Override
	public String getTableName() {	  
		return "";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePsnInfoDODesc.class);
	}
	
}