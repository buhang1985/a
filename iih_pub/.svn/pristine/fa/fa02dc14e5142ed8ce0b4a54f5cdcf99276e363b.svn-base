package iih.pe.pwf.pewfrmswitch.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.pewfrmswitch.d.desc.PeWfRmSwitchDODesc;
import java.math.BigDecimal;

/**
 * 体检流程诊间开关 DO数据 
 * 
 */
public class PeWfRmSwitchDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEWFRMSWITCH= "Id_pewfrmswitch";
	public static final String ID_PEFUNCAREA= "Id_pefuncarea";
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	public static final String ID_PEDIROOM= "Id_pediroom";
	public static final String DT_PEROOM= "Dt_peroom";
	public static final String SEXLIMIT= "Sexlimit";
	public static final String FG_OPEN= "Fg_open";
	public static final String FG_VIP= "Fg_vip";
	public static final String ID_NUR= "Id_nur";
	public static final String ID_DOC= "Id_doc";
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	public static final String WAITINGS= "Waitings";
	public static final String CHECKED= "Checked";
	public static final String UNCHECKED= "Unchecked";
	public static final String GIVEUPS= "Giveups";
	public static final String DU_WAIT= "Du_wait";
	public static final String FG_GUIDESTATION= "Fg_guidestation";
	public static final String DU_CHECK= "Du_check";
	public static final String SORTNO= "Sortno";
	public static final String WAIT1= "Wait1";
	public static final String WAIT2= "Wait2";
	public static final String WAIT3= "Wait3";
	public static final String WAIT4= "Wait4";
	public static final String WAIT5= "Wait5";
	public static final String WAIT6= "Wait6";
	public static final String WAIT7= "Wait7";
	public static final String WAIT8= "Wait8";
	public static final String WAIT9= "Wait9";
	public static final String WAIT10= "Wait10";
	public static final String WAIT11= "Wait11";
	public static final String WAIT12= "Wait12";
	public static final String WAIT13= "Wait13";
	public static final String WAIT14= "Wait14";
	public static final String WAIT15= "Wait15";
	public static final String WAIT16= "Wait16";
	public static final String WAIT17= "Wait17";
	public static final String WAIT18= "Wait18";
	public static final String WAIT19= "Wait19";
	public static final String WAIT20= "Wait20";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_ROOM= "Name_room";
	public static final String CODE_ROOM= "Code_room";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_DOC= "Name_doc";
	public static final String CARD_PE_CUR= "Card_pe_cur";
	public static final String FG_VIP_CUR= "Fg_vip_cur";
	public static final String NAME_PSN_CUR= "Name_psn_cur";
	public static final String SD_SEX_PSN_CUR= "Sd_sex_psn_cur";
	public static final String CARD_PE1= "Card_pe1";
	public static final String NAME_PSN1= "Name_psn1";
	public static final String SD_SEX_PSN1= "Sd_sex_psn1";
	public static final String FG_VIP1= "Fg_vip1";
	public static final String CARD_PE2= "Card_pe2";
	public static final String NAME_PSN2= "Name_psn2";
	public static final String SD_SEX_PSN2= "Sd_sex_psn2";
	public static final String FG_VIP2= "Fg_vip2";
	public static final String NAME_PSN3= "Name_psn3";
	public static final String SD_SEX_PSN3= "Sd_sex_psn3";
	public static final String CARD_PE3= "Card_pe3";
	public static final String FG_VIP3= "Fg_vip3";
	public static final String NAME_PSN4= "Name_psn4";
	public static final String SD_SEX_PSN4= "Sd_sex_psn4";
	public static final String CARD_PE4= "Card_pe4";
	public static final String FG_VIP4= "Fg_vip4";
	public static final String CARD_PE5= "Card_pe5";
	public static final String NAME_PSN5= "Name_psn5";
	public static final String SD_SEX_PSN5= "Sd_sex_psn5";
	public static final String FG_VIP5= "Fg_vip5";
	public static final String NAME_PSN6= "Name_psn6";
	public static final String SD_SEX_PSN6= "Sd_sex_psn6";
	public static final String CARD_PE6= "Card_pe6";
	public static final String FG_VIP6= "Fg_vip6";
	public static final String CARD_PE7= "Card_pe7";
	public static final String NAME_PSN7= "Name_psn7";
	public static final String SD_SEX_PSN7= "Sd_sex_psn7";
	public static final String FG_VIP7= "Fg_vip7";
	public static final String NAME_PSN8= "Name_psn8";
	public static final String SD_SEX_PSN8= "Sd_sex_psn8";
	public static final String CARD_PE8= "Card_pe8";
	public static final String FG_VIP8= "Fg_vip8";
	public static final String NAME_PSN9= "Name_psn9";
	public static final String SD_SEX_PSN9= "Sd_sex_psn9";
	public static final String CARD_PE9= "Card_pe9";
	public static final String FG_VIP9= "Fg_vip9";
	public static final String CARD_PE10= "Card_pe10";
	public static final String NAME_PSN10= "Name_psn10";
	public static final String SD_SEX_PSN10= "Sd_sex_psn10";
	public static final String FG_VIP10= "Fg_vip10";
	public static final String NAME_PSN11= "Name_psn11";
	public static final String SD_SEX_PSN11= "Sd_sex_psn11";
	public static final String CARD_PE11= "Card_pe11";
	public static final String FG_VIP11= "Fg_vip11";
	public static final String CARD_PE12= "Card_pe12";
	public static final String NAME_PSN12= "Name_psn12";
	public static final String SD_SEX_PSN12= "Sd_sex_psn12";
	public static final String FG_VIP12= "Fg_vip12";
	public static final String NAME_PSN13= "Name_psn13";
	public static final String SD_SEX_PSN13= "Sd_sex_psn13";
	public static final String CARD_PE13= "Card_pe13";
	public static final String FG_VIP13= "Fg_vip13";
	public static final String CARD_PE14= "Card_pe14";
	public static final String NAME_PSN14= "Name_psn14";
	public static final String SD_SEX_PSN14= "Sd_sex_psn14";
	public static final String FG_VIP14= "Fg_vip14";
	public static final String NAME_PSN15= "Name_psn15";
	public static final String SD_SEX_PSN15= "Sd_sex_psn15";
	public static final String CARD_PE15= "Card_pe15";
	public static final String FG_VIP15= "Fg_vip15";
	public static final String CARD_PE16= "Card_pe16";
	public static final String NAME_PSN16= "Name_psn16";
	public static final String SD_SEX_PSN16= "Sd_sex_psn16";
	public static final String FG_VIP16= "Fg_vip16";
	public static final String NAME_PSN17= "Name_psn17";
	public static final String SD_SEX_PSN17= "Sd_sex_psn17";
	public static final String CARD_PE17= "Card_pe17";
	public static final String FG_VIP17= "Fg_vip17";
	public static final String CARD_PE18= "Card_pe18";
	public static final String NAME_PSN18= "Name_psn18";
	public static final String SD_SEX_PSN18= "Sd_sex_psn18";
	public static final String FG_VIP18= "Fg_vip18";
	public static final String NAME_PSN19= "Name_psn19";
	public static final String SD_SEX_PSN19= "Sd_sex_psn19";
	public static final String CARD_PE19= "Card_pe19";
	public static final String FG_VIP19= "Fg_vip19";
	public static final String CARD_PE20= "Card_pe20";
	public static final String NAME_PSN20= "Name_psn20";
	public static final String SD_SEX_PSN20= "Sd_sex_psn20";
	public static final String FG_VIP20= "Fg_vip20";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pewfrmswitch() {
		return ((String) getAttrVal("Id_pewfrmswitch"));
	}	
	public void setId_pewfrmswitch(String Id_pewfrmswitch) {
		setAttrVal("Id_pewfrmswitch", Id_pewfrmswitch);
	}
	public String getId_pefuncarea() {
		return ((String) getAttrVal("Id_pefuncarea"));
	}	
	public void setId_pefuncarea(String Id_pefuncarea) {
		setAttrVal("Id_pefuncarea", Id_pefuncarea);
	}
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	public String getId_pediroom() {
		return ((String) getAttrVal("Id_pediroom"));
	}	
	public void setId_pediroom(String Id_pediroom) {
		setAttrVal("Id_pediroom", Id_pediroom);
	}
	public FDate getDt_peroom() {
		return ((FDate) getAttrVal("Dt_peroom"));
	}	
	public void setDt_peroom(FDate Dt_peroom) {
		setAttrVal("Dt_peroom", Dt_peroom);
	}
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	public FBoolean getFg_open() {
		return ((FBoolean) getAttrVal("Fg_open"));
	}	
	public void setFg_open(FBoolean Fg_open) {
		setAttrVal("Fg_open", Fg_open);
	}
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}	
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public String getId_doc() {
		return ((String) getAttrVal("Id_doc"));
	}	
	public void setId_doc(String Id_doc) {
		setAttrVal("Id_doc", Id_doc);
	}
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	public Integer getWaitings() {
		return ((Integer) getAttrVal("Waitings"));
	}	
	public void setWaitings(Integer Waitings) {
		setAttrVal("Waitings", Waitings);
	}
	public Integer getChecked() {
		return ((Integer) getAttrVal("Checked"));
	}	
	public void setChecked(Integer Checked) {
		setAttrVal("Checked", Checked);
	}
	public Integer getUnchecked() {
		return ((Integer) getAttrVal("Unchecked"));
	}	
	public void setUnchecked(Integer Unchecked) {
		setAttrVal("Unchecked", Unchecked);
	}
	public Integer getGiveups() {
		return ((Integer) getAttrVal("Giveups"));
	}	
	public void setGiveups(Integer Giveups) {
		setAttrVal("Giveups", Giveups);
	}
	public Integer getDu_wait() {
		return ((Integer) getAttrVal("Du_wait"));
	}	
	public void setDu_wait(Integer Du_wait) {
		setAttrVal("Du_wait", Du_wait);
	}
	public FBoolean getFg_guidestation() {
		return ((FBoolean) getAttrVal("Fg_guidestation"));
	}	
	public void setFg_guidestation(FBoolean Fg_guidestation) {
		setAttrVal("Fg_guidestation", Fg_guidestation);
	}
	public Integer getDu_check() {
		return ((Integer) getAttrVal("Du_check"));
	}	
	public void setDu_check(Integer Du_check) {
		setAttrVal("Du_check", Du_check);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getWait1() {
		return ((String) getAttrVal("Wait1"));
	}	
	public void setWait1(String Wait1) {
		setAttrVal("Wait1", Wait1);
	}
	public String getWait2() {
		return ((String) getAttrVal("Wait2"));
	}	
	public void setWait2(String Wait2) {
		setAttrVal("Wait2", Wait2);
	}
	public String getWait3() {
		return ((String) getAttrVal("Wait3"));
	}	
	public void setWait3(String Wait3) {
		setAttrVal("Wait3", Wait3);
	}
	public String getWait4() {
		return ((String) getAttrVal("Wait4"));
	}	
	public void setWait4(String Wait4) {
		setAttrVal("Wait4", Wait4);
	}
	public String getWait5() {
		return ((String) getAttrVal("Wait5"));
	}	
	public void setWait5(String Wait5) {
		setAttrVal("Wait5", Wait5);
	}
	public String getWait6() {
		return ((String) getAttrVal("Wait6"));
	}	
	public void setWait6(String Wait6) {
		setAttrVal("Wait6", Wait6);
	}
	public String getWait7() {
		return ((String) getAttrVal("Wait7"));
	}	
	public void setWait7(String Wait7) {
		setAttrVal("Wait7", Wait7);
	}
	public String getWait8() {
		return ((String) getAttrVal("Wait8"));
	}	
	public void setWait8(String Wait8) {
		setAttrVal("Wait8", Wait8);
	}
	public String getWait9() {
		return ((String) getAttrVal("Wait9"));
	}	
	public void setWait9(String Wait9) {
		setAttrVal("Wait9", Wait9);
	}
	public String getWait10() {
		return ((String) getAttrVal("Wait10"));
	}	
	public void setWait10(String Wait10) {
		setAttrVal("Wait10", Wait10);
	}
	public String getWait11() {
		return ((String) getAttrVal("Wait11"));
	}	
	public void setWait11(String Wait11) {
		setAttrVal("Wait11", Wait11);
	}
	public String getWait12() {
		return ((String) getAttrVal("Wait12"));
	}	
	public void setWait12(String Wait12) {
		setAttrVal("Wait12", Wait12);
	}
	public String getWait13() {
		return ((String) getAttrVal("Wait13"));
	}	
	public void setWait13(String Wait13) {
		setAttrVal("Wait13", Wait13);
	}
	public String getWait14() {
		return ((String) getAttrVal("Wait14"));
	}	
	public void setWait14(String Wait14) {
		setAttrVal("Wait14", Wait14);
	}
	public String getWait15() {
		return ((String) getAttrVal("Wait15"));
	}	
	public void setWait15(String Wait15) {
		setAttrVal("Wait15", Wait15);
	}
	public String getWait16() {
		return ((String) getAttrVal("Wait16"));
	}	
	public void setWait16(String Wait16) {
		setAttrVal("Wait16", Wait16);
	}
	public String getWait17() {
		return ((String) getAttrVal("Wait17"));
	}	
	public void setWait17(String Wait17) {
		setAttrVal("Wait17", Wait17);
	}
	public String getWait18() {
		return ((String) getAttrVal("Wait18"));
	}	
	public void setWait18(String Wait18) {
		setAttrVal("Wait18", Wait18);
	}
	public String getWait19() {
		return ((String) getAttrVal("Wait19"));
	}	
	public void setWait19(String Wait19) {
		setAttrVal("Wait19", Wait19);
	}
	public String getWait20() {
		return ((String) getAttrVal("Wait20"));
	}	
	public void setWait20(String Wait20) {
		setAttrVal("Wait20", Wait20);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
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
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getName_doc() {
		return ((String) getAttrVal("Name_doc"));
	}	
	public void setName_doc(String Name_doc) {
		setAttrVal("Name_doc", Name_doc);
	}
	public String getCard_pe_cur() {
		return ((String) getAttrVal("Card_pe_cur"));
	}	
	public void setCard_pe_cur(String Card_pe_cur) {
		setAttrVal("Card_pe_cur", Card_pe_cur);
	}
	public FBoolean getFg_vip_cur() {
		return ((FBoolean) getAttrVal("Fg_vip_cur"));
	}	
	public void setFg_vip_cur(FBoolean Fg_vip_cur) {
		setAttrVal("Fg_vip_cur", Fg_vip_cur);
	}
	public String getName_psn_cur() {
		return ((String) getAttrVal("Name_psn_cur"));
	}	
	public void setName_psn_cur(String Name_psn_cur) {
		setAttrVal("Name_psn_cur", Name_psn_cur);
	}
	public String getSd_sex_psn_cur() {
		return ((String) getAttrVal("Sd_sex_psn_cur"));
	}	
	public void setSd_sex_psn_cur(String Sd_sex_psn_cur) {
		setAttrVal("Sd_sex_psn_cur", Sd_sex_psn_cur);
	}
	public String getCard_pe1() {
		return ((String) getAttrVal("Card_pe1"));
	}	
	public void setCard_pe1(String Card_pe1) {
		setAttrVal("Card_pe1", Card_pe1);
	}
	public String getName_psn1() {
		return ((String) getAttrVal("Name_psn1"));
	}	
	public void setName_psn1(String Name_psn1) {
		setAttrVal("Name_psn1", Name_psn1);
	}
	public String getSd_sex_psn1() {
		return ((String) getAttrVal("Sd_sex_psn1"));
	}	
	public void setSd_sex_psn1(String Sd_sex_psn1) {
		setAttrVal("Sd_sex_psn1", Sd_sex_psn1);
	}
	public FBoolean getFg_vip1() {
		return ((FBoolean) getAttrVal("Fg_vip1"));
	}	
	public void setFg_vip1(FBoolean Fg_vip1) {
		setAttrVal("Fg_vip1", Fg_vip1);
	}
	public String getCard_pe2() {
		return ((String) getAttrVal("Card_pe2"));
	}	
	public void setCard_pe2(String Card_pe2) {
		setAttrVal("Card_pe2", Card_pe2);
	}
	public String getName_psn2() {
		return ((String) getAttrVal("Name_psn2"));
	}	
	public void setName_psn2(String Name_psn2) {
		setAttrVal("Name_psn2", Name_psn2);
	}
	public String getSd_sex_psn2() {
		return ((String) getAttrVal("Sd_sex_psn2"));
	}	
	public void setSd_sex_psn2(String Sd_sex_psn2) {
		setAttrVal("Sd_sex_psn2", Sd_sex_psn2);
	}
	public FBoolean getFg_vip2() {
		return ((FBoolean) getAttrVal("Fg_vip2"));
	}	
	public void setFg_vip2(FBoolean Fg_vip2) {
		setAttrVal("Fg_vip2", Fg_vip2);
	}
	public String getName_psn3() {
		return ((String) getAttrVal("Name_psn3"));
	}	
	public void setName_psn3(String Name_psn3) {
		setAttrVal("Name_psn3", Name_psn3);
	}
	public String getSd_sex_psn3() {
		return ((String) getAttrVal("Sd_sex_psn3"));
	}	
	public void setSd_sex_psn3(String Sd_sex_psn3) {
		setAttrVal("Sd_sex_psn3", Sd_sex_psn3);
	}
	public String getCard_pe3() {
		return ((String) getAttrVal("Card_pe3"));
	}	
	public void setCard_pe3(String Card_pe3) {
		setAttrVal("Card_pe3", Card_pe3);
	}
	public FBoolean getFg_vip3() {
		return ((FBoolean) getAttrVal("Fg_vip3"));
	}	
	public void setFg_vip3(FBoolean Fg_vip3) {
		setAttrVal("Fg_vip3", Fg_vip3);
	}
	public String getName_psn4() {
		return ((String) getAttrVal("Name_psn4"));
	}	
	public void setName_psn4(String Name_psn4) {
		setAttrVal("Name_psn4", Name_psn4);
	}
	public String getSd_sex_psn4() {
		return ((String) getAttrVal("Sd_sex_psn4"));
	}	
	public void setSd_sex_psn4(String Sd_sex_psn4) {
		setAttrVal("Sd_sex_psn4", Sd_sex_psn4);
	}
	public String getCard_pe4() {
		return ((String) getAttrVal("Card_pe4"));
	}	
	public void setCard_pe4(String Card_pe4) {
		setAttrVal("Card_pe4", Card_pe4);
	}
	public FBoolean getFg_vip4() {
		return ((FBoolean) getAttrVal("Fg_vip4"));
	}	
	public void setFg_vip4(FBoolean Fg_vip4) {
		setAttrVal("Fg_vip4", Fg_vip4);
	}
	public String getCard_pe5() {
		return ((String) getAttrVal("Card_pe5"));
	}	
	public void setCard_pe5(String Card_pe5) {
		setAttrVal("Card_pe5", Card_pe5);
	}
	public String getName_psn5() {
		return ((String) getAttrVal("Name_psn5"));
	}	
	public void setName_psn5(String Name_psn5) {
		setAttrVal("Name_psn5", Name_psn5);
	}
	public String getSd_sex_psn5() {
		return ((String) getAttrVal("Sd_sex_psn5"));
	}	
	public void setSd_sex_psn5(String Sd_sex_psn5) {
		setAttrVal("Sd_sex_psn5", Sd_sex_psn5);
	}
	public FBoolean getFg_vip5() {
		return ((FBoolean) getAttrVal("Fg_vip5"));
	}	
	public void setFg_vip5(FBoolean Fg_vip5) {
		setAttrVal("Fg_vip5", Fg_vip5);
	}
	public String getName_psn6() {
		return ((String) getAttrVal("Name_psn6"));
	}	
	public void setName_psn6(String Name_psn6) {
		setAttrVal("Name_psn6", Name_psn6);
	}
	public String getSd_sex_psn6() {
		return ((String) getAttrVal("Sd_sex_psn6"));
	}	
	public void setSd_sex_psn6(String Sd_sex_psn6) {
		setAttrVal("Sd_sex_psn6", Sd_sex_psn6);
	}
	public String getCard_pe6() {
		return ((String) getAttrVal("Card_pe6"));
	}	
	public void setCard_pe6(String Card_pe6) {
		setAttrVal("Card_pe6", Card_pe6);
	}
	public FBoolean getFg_vip6() {
		return ((FBoolean) getAttrVal("Fg_vip6"));
	}	
	public void setFg_vip6(FBoolean Fg_vip6) {
		setAttrVal("Fg_vip6", Fg_vip6);
	}
	public String getCard_pe7() {
		return ((String) getAttrVal("Card_pe7"));
	}	
	public void setCard_pe7(String Card_pe7) {
		setAttrVal("Card_pe7", Card_pe7);
	}
	public String getName_psn7() {
		return ((String) getAttrVal("Name_psn7"));
	}	
	public void setName_psn7(String Name_psn7) {
		setAttrVal("Name_psn7", Name_psn7);
	}
	public String getSd_sex_psn7() {
		return ((String) getAttrVal("Sd_sex_psn7"));
	}	
	public void setSd_sex_psn7(String Sd_sex_psn7) {
		setAttrVal("Sd_sex_psn7", Sd_sex_psn7);
	}
	public FBoolean getFg_vip7() {
		return ((FBoolean) getAttrVal("Fg_vip7"));
	}	
	public void setFg_vip7(FBoolean Fg_vip7) {
		setAttrVal("Fg_vip7", Fg_vip7);
	}
	public String getName_psn8() {
		return ((String) getAttrVal("Name_psn8"));
	}	
	public void setName_psn8(String Name_psn8) {
		setAttrVal("Name_psn8", Name_psn8);
	}
	public String getSd_sex_psn8() {
		return ((String) getAttrVal("Sd_sex_psn8"));
	}	
	public void setSd_sex_psn8(String Sd_sex_psn8) {
		setAttrVal("Sd_sex_psn8", Sd_sex_psn8);
	}
	public String getCard_pe8() {
		return ((String) getAttrVal("Card_pe8"));
	}	
	public void setCard_pe8(String Card_pe8) {
		setAttrVal("Card_pe8", Card_pe8);
	}
	public FBoolean getFg_vip8() {
		return ((FBoolean) getAttrVal("Fg_vip8"));
	}	
	public void setFg_vip8(FBoolean Fg_vip8) {
		setAttrVal("Fg_vip8", Fg_vip8);
	}
	public String getName_psn9() {
		return ((String) getAttrVal("Name_psn9"));
	}	
	public void setName_psn9(String Name_psn9) {
		setAttrVal("Name_psn9", Name_psn9);
	}
	public String getSd_sex_psn9() {
		return ((String) getAttrVal("Sd_sex_psn9"));
	}	
	public void setSd_sex_psn9(String Sd_sex_psn9) {
		setAttrVal("Sd_sex_psn9", Sd_sex_psn9);
	}
	public String getCard_pe9() {
		return ((String) getAttrVal("Card_pe9"));
	}	
	public void setCard_pe9(String Card_pe9) {
		setAttrVal("Card_pe9", Card_pe9);
	}
	public FBoolean getFg_vip9() {
		return ((FBoolean) getAttrVal("Fg_vip9"));
	}	
	public void setFg_vip9(FBoolean Fg_vip9) {
		setAttrVal("Fg_vip9", Fg_vip9);
	}
	public String getCard_pe10() {
		return ((String) getAttrVal("Card_pe10"));
	}	
	public void setCard_pe10(String Card_pe10) {
		setAttrVal("Card_pe10", Card_pe10);
	}
	public String getName_psn10() {
		return ((String) getAttrVal("Name_psn10"));
	}	
	public void setName_psn10(String Name_psn10) {
		setAttrVal("Name_psn10", Name_psn10);
	}
	public String getSd_sex_psn10() {
		return ((String) getAttrVal("Sd_sex_psn10"));
	}	
	public void setSd_sex_psn10(String Sd_sex_psn10) {
		setAttrVal("Sd_sex_psn10", Sd_sex_psn10);
	}
	public FBoolean getFg_vip10() {
		return ((FBoolean) getAttrVal("Fg_vip10"));
	}	
	public void setFg_vip10(FBoolean Fg_vip10) {
		setAttrVal("Fg_vip10", Fg_vip10);
	}
	public String getName_psn11() {
		return ((String) getAttrVal("Name_psn11"));
	}	
	public void setName_psn11(String Name_psn11) {
		setAttrVal("Name_psn11", Name_psn11);
	}
	public String getSd_sex_psn11() {
		return ((String) getAttrVal("Sd_sex_psn11"));
	}	
	public void setSd_sex_psn11(String Sd_sex_psn11) {
		setAttrVal("Sd_sex_psn11", Sd_sex_psn11);
	}
	public String getCard_pe11() {
		return ((String) getAttrVal("Card_pe11"));
	}	
	public void setCard_pe11(String Card_pe11) {
		setAttrVal("Card_pe11", Card_pe11);
	}
	public FBoolean getFg_vip11() {
		return ((FBoolean) getAttrVal("Fg_vip11"));
	}	
	public void setFg_vip11(FBoolean Fg_vip11) {
		setAttrVal("Fg_vip11", Fg_vip11);
	}
	public String getCard_pe12() {
		return ((String) getAttrVal("Card_pe12"));
	}	
	public void setCard_pe12(String Card_pe12) {
		setAttrVal("Card_pe12", Card_pe12);
	}
	public String getName_psn12() {
		return ((String) getAttrVal("Name_psn12"));
	}	
	public void setName_psn12(String Name_psn12) {
		setAttrVal("Name_psn12", Name_psn12);
	}
	public String getSd_sex_psn12() {
		return ((String) getAttrVal("Sd_sex_psn12"));
	}	
	public void setSd_sex_psn12(String Sd_sex_psn12) {
		setAttrVal("Sd_sex_psn12", Sd_sex_psn12);
	}
	public FBoolean getFg_vip12() {
		return ((FBoolean) getAttrVal("Fg_vip12"));
	}	
	public void setFg_vip12(FBoolean Fg_vip12) {
		setAttrVal("Fg_vip12", Fg_vip12);
	}
	public String getName_psn13() {
		return ((String) getAttrVal("Name_psn13"));
	}	
	public void setName_psn13(String Name_psn13) {
		setAttrVal("Name_psn13", Name_psn13);
	}
	public String getSd_sex_psn13() {
		return ((String) getAttrVal("Sd_sex_psn13"));
	}	
	public void setSd_sex_psn13(String Sd_sex_psn13) {
		setAttrVal("Sd_sex_psn13", Sd_sex_psn13);
	}
	public String getCard_pe13() {
		return ((String) getAttrVal("Card_pe13"));
	}	
	public void setCard_pe13(String Card_pe13) {
		setAttrVal("Card_pe13", Card_pe13);
	}
	public FBoolean getFg_vip13() {
		return ((FBoolean) getAttrVal("Fg_vip13"));
	}	
	public void setFg_vip13(FBoolean Fg_vip13) {
		setAttrVal("Fg_vip13", Fg_vip13);
	}
	public String getCard_pe14() {
		return ((String) getAttrVal("Card_pe14"));
	}	
	public void setCard_pe14(String Card_pe14) {
		setAttrVal("Card_pe14", Card_pe14);
	}
	public String getName_psn14() {
		return ((String) getAttrVal("Name_psn14"));
	}	
	public void setName_psn14(String Name_psn14) {
		setAttrVal("Name_psn14", Name_psn14);
	}
	public String getSd_sex_psn14() {
		return ((String) getAttrVal("Sd_sex_psn14"));
	}	
	public void setSd_sex_psn14(String Sd_sex_psn14) {
		setAttrVal("Sd_sex_psn14", Sd_sex_psn14);
	}
	public FBoolean getFg_vip14() {
		return ((FBoolean) getAttrVal("Fg_vip14"));
	}	
	public void setFg_vip14(FBoolean Fg_vip14) {
		setAttrVal("Fg_vip14", Fg_vip14);
	}
	public String getName_psn15() {
		return ((String) getAttrVal("Name_psn15"));
	}	
	public void setName_psn15(String Name_psn15) {
		setAttrVal("Name_psn15", Name_psn15);
	}
	public String getSd_sex_psn15() {
		return ((String) getAttrVal("Sd_sex_psn15"));
	}	
	public void setSd_sex_psn15(String Sd_sex_psn15) {
		setAttrVal("Sd_sex_psn15", Sd_sex_psn15);
	}
	public String getCard_pe15() {
		return ((String) getAttrVal("Card_pe15"));
	}	
	public void setCard_pe15(String Card_pe15) {
		setAttrVal("Card_pe15", Card_pe15);
	}
	public FBoolean getFg_vip15() {
		return ((FBoolean) getAttrVal("Fg_vip15"));
	}	
	public void setFg_vip15(FBoolean Fg_vip15) {
		setAttrVal("Fg_vip15", Fg_vip15);
	}
	public String getCard_pe16() {
		return ((String) getAttrVal("Card_pe16"));
	}	
	public void setCard_pe16(String Card_pe16) {
		setAttrVal("Card_pe16", Card_pe16);
	}
	public String getName_psn16() {
		return ((String) getAttrVal("Name_psn16"));
	}	
	public void setName_psn16(String Name_psn16) {
		setAttrVal("Name_psn16", Name_psn16);
	}
	public String getSd_sex_psn16() {
		return ((String) getAttrVal("Sd_sex_psn16"));
	}	
	public void setSd_sex_psn16(String Sd_sex_psn16) {
		setAttrVal("Sd_sex_psn16", Sd_sex_psn16);
	}
	public FBoolean getFg_vip16() {
		return ((FBoolean) getAttrVal("Fg_vip16"));
	}	
	public void setFg_vip16(FBoolean Fg_vip16) {
		setAttrVal("Fg_vip16", Fg_vip16);
	}
	public String getName_psn17() {
		return ((String) getAttrVal("Name_psn17"));
	}	
	public void setName_psn17(String Name_psn17) {
		setAttrVal("Name_psn17", Name_psn17);
	}
	public String getSd_sex_psn17() {
		return ((String) getAttrVal("Sd_sex_psn17"));
	}	
	public void setSd_sex_psn17(String Sd_sex_psn17) {
		setAttrVal("Sd_sex_psn17", Sd_sex_psn17);
	}
	public String getCard_pe17() {
		return ((String) getAttrVal("Card_pe17"));
	}	
	public void setCard_pe17(String Card_pe17) {
		setAttrVal("Card_pe17", Card_pe17);
	}
	public FBoolean getFg_vip17() {
		return ((FBoolean) getAttrVal("Fg_vip17"));
	}	
	public void setFg_vip17(FBoolean Fg_vip17) {
		setAttrVal("Fg_vip17", Fg_vip17);
	}
	public String getCard_pe18() {
		return ((String) getAttrVal("Card_pe18"));
	}	
	public void setCard_pe18(String Card_pe18) {
		setAttrVal("Card_pe18", Card_pe18);
	}
	public String getName_psn18() {
		return ((String) getAttrVal("Name_psn18"));
	}	
	public void setName_psn18(String Name_psn18) {
		setAttrVal("Name_psn18", Name_psn18);
	}
	public String getSd_sex_psn18() {
		return ((String) getAttrVal("Sd_sex_psn18"));
	}	
	public void setSd_sex_psn18(String Sd_sex_psn18) {
		setAttrVal("Sd_sex_psn18", Sd_sex_psn18);
	}
	public FBoolean getFg_vip18() {
		return ((FBoolean) getAttrVal("Fg_vip18"));
	}	
	public void setFg_vip18(FBoolean Fg_vip18) {
		setAttrVal("Fg_vip18", Fg_vip18);
	}
	public String getName_psn19() {
		return ((String) getAttrVal("Name_psn19"));
	}	
	public void setName_psn19(String Name_psn19) {
		setAttrVal("Name_psn19", Name_psn19);
	}
	public String getSd_sex_psn19() {
		return ((String) getAttrVal("Sd_sex_psn19"));
	}	
	public void setSd_sex_psn19(String Sd_sex_psn19) {
		setAttrVal("Sd_sex_psn19", Sd_sex_psn19);
	}
	public String getCard_pe19() {
		return ((String) getAttrVal("Card_pe19"));
	}	
	public void setCard_pe19(String Card_pe19) {
		setAttrVal("Card_pe19", Card_pe19);
	}
	public FBoolean getFg_vip19() {
		return ((FBoolean) getAttrVal("Fg_vip19"));
	}	
	public void setFg_vip19(FBoolean Fg_vip19) {
		setAttrVal("Fg_vip19", Fg_vip19);
	}
	public String getCard_pe20() {
		return ((String) getAttrVal("Card_pe20"));
	}	
	public void setCard_pe20(String Card_pe20) {
		setAttrVal("Card_pe20", Card_pe20);
	}
	public String getName_psn20() {
		return ((String) getAttrVal("Name_psn20"));
	}	
	public void setName_psn20(String Name_psn20) {
		setAttrVal("Name_psn20", Name_psn20);
	}
	public String getSd_sex_psn20() {
		return ((String) getAttrVal("Sd_sex_psn20"));
	}	
	public void setSd_sex_psn20(String Sd_sex_psn20) {
		setAttrVal("Sd_sex_psn20", Sd_sex_psn20);
	}
	public FBoolean getFg_vip20() {
		return ((FBoolean) getAttrVal("Fg_vip20"));
	}	
	public void setFg_vip20(FBoolean Fg_vip20) {
		setAttrVal("Fg_vip20", Fg_vip20);
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
		return "Id_pewfrmswitch";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_pewfrmswitch";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeWfRmSwitchDODesc.class);
	}
	
}