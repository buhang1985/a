package iih.ci.tsip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.tsip.d.desc.CiTsApObsDODesc;
import java.math.BigDecimal;

/**
 * 治疗方案检查申请 DO数据 
 * 
 */
public class CiTsApObsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//治疗方案检查申请ID
	public static final String ID_TSAPOBS= "Id_tsapobs";
	//治疗方案医嘱ID
	public static final String ID_TSOR= "Id_tsor";
	//检查目的ID
	public static final String ID_PPS= "Id_pps";
	//检查目的SD
	public static final String SD_PPS= "Sd_pps";
	//检查目的
	public static final String NAME_PPS= "Name_pps";
	//检查目的描述
	public static final String DES_PPS= "Des_pps";
	//症状和体征
	public static final String DES_SYMPSIGN= "Des_sympsign";
	//注意事项
	public static final String ANNOUNCEMENTS= "Announcements";
	//客户扩展字段1
	public static final String DEF1= "Def1";
	//客户扩展字段2
	public static final String DEF2= "Def2";
	//客户扩展字段3
	public static final String DEF3= "Def3";
	//客户扩展字段4
	public static final String DEF4= "Def4";
	//客户扩展字段5
	public static final String DEF5= "Def5";
	//客户扩展字段6
	public static final String DEF6= "Def6";
	//客户扩展字段7
	public static final String DEF7= "Def7";
	//客户扩展字段8
	public static final String DEF8= "Def8";
	//客户扩展字段9
	public static final String DEF9= "Def9";
	//客户扩展字段10
	public static final String DEF10= "Def10";
	//客户扩展字段11
	public static final String DEF11= "Def11";
	//客户扩展字段12
	public static final String DEF12= "Def12";
	//客户扩展字段13
	public static final String DEF13= "Def13";
	//客户扩展字段14
	public static final String DEF14= "Def14";
	//客户扩展字段15
	public static final String DEF15= "Def15";
	//客户扩展字段16
	public static final String DEF16= "Def16";
	//客户扩展字段17
	public static final String DEF17= "Def17";
	//客户扩展字段18
	public static final String DEF18= "Def18";
	//客户扩展字段19
	public static final String DEF19= "Def19";
	//客户扩展字段20
	public static final String DEF20= "Def20";
	//客户扩展字段21
	public static final String DEF21= "Def21";
	//客户扩展字段22
	public static final String DEF22= "Def22";
	//客户扩展字段23
	public static final String DEF23= "Def23";
	//客户扩展字段24
	public static final String DEF24= "Def24";
	//客户扩展字段25
	public static final String DEF25= "Def25";
	//客户扩展字段26
	public static final String DEF26= "Def26";
	//客户扩展字段27
	public static final String DEF27= "Def27";
	//客户扩展字段28
	public static final String DEF28= "Def28";
	//客户扩展字段29
	public static final String DEF29= "Def29";
	//客户扩展字段30
	public static final String DEF30= "Def30";
	//客户扩展字段31
	public static final String DEF31= "Def31";
	//客户扩展字段32
	public static final String DEF32= "Def32";
	//客户扩展字段33
	public static final String DEF33= "Def33";
	//客户扩展字段34
	public static final String DEF34= "Def34";
	//客户扩展字段35
	public static final String DEF35= "Def35";
	//客户扩展字段36
	public static final String DEF36= "Def36";
	//客户扩展字段37
	public static final String DEF37= "Def37";
	//客户扩展字段38
	public static final String DEF38= "Def38";
	//客户扩展字段39
	public static final String DEF39= "Def39";
	//客户扩展字段40
	public static final String DEF40= "Def40";
	//客户扩展字段41
	public static final String DEF41= "Def41";
	//客户扩展字段42
	public static final String DEF42= "Def42";
	//客户扩展字段43
	public static final String DEF43= "Def43";
	//客户扩展字段44
	public static final String DEF44= "Def44";
	//客户扩展字段45
	public static final String DEF45= "Def45";
	//客户扩展字段46
	public static final String DEF46= "Def46";
	//客户扩展字段47
	public static final String DEF47= "Def47";
	//客户扩展字段48
	public static final String DEF48= "Def48";
	//客户扩展字段49
	public static final String DEF49= "Def49";
	//客户扩展字段50
	public static final String DEF50= "Def50";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 治疗方案检查申请ID
	 * @return String
	 */
	public String getId_tsapobs() {
		return ((String) getAttrVal("Id_tsapobs"));
	}	
	/**
	 * 治疗方案检查申请ID
	 * @param Id_tsapobs
	 */
	public void setId_tsapobs(String Id_tsapobs) {
		setAttrVal("Id_tsapobs", Id_tsapobs);
	}
	/**
	 * 治疗方案医嘱ID
	 * @return String
	 */
	public String getId_tsor() {
		return ((String) getAttrVal("Id_tsor"));
	}	
	/**
	 * 治疗方案医嘱ID
	 * @param Id_tsor
	 */
	public void setId_tsor(String Id_tsor) {
		setAttrVal("Id_tsor", Id_tsor);
	}
	/**
	 * 检查目的ID
	 * @return String
	 */
	public String getId_pps() {
		return ((String) getAttrVal("Id_pps"));
	}	
	/**
	 * 检查目的ID
	 * @param Id_pps
	 */
	public void setId_pps(String Id_pps) {
		setAttrVal("Id_pps", Id_pps);
	}
	/**
	 * 检查目的SD
	 * @return String
	 */
	public String getSd_pps() {
		return ((String) getAttrVal("Sd_pps"));
	}	
	/**
	 * 检查目的SD
	 * @param Sd_pps
	 */
	public void setSd_pps(String Sd_pps) {
		setAttrVal("Sd_pps", Sd_pps);
	}
	/**
	 * 检查目的
	 * @return String
	 */
	public String getName_pps() {
		return ((String) getAttrVal("Name_pps"));
	}	
	/**
	 * 检查目的
	 * @param Name_pps
	 */
	public void setName_pps(String Name_pps) {
		setAttrVal("Name_pps", Name_pps);
	}
	/**
	 * 检查目的描述
	 * @return String
	 */
	public String getDes_pps() {
		return ((String) getAttrVal("Des_pps"));
	}	
	/**
	 * 检查目的描述
	 * @param Des_pps
	 */
	public void setDes_pps(String Des_pps) {
		setAttrVal("Des_pps", Des_pps);
	}
	/**
	 * 症状和体征
	 * @return String
	 */
	public String getDes_sympsign() {
		return ((String) getAttrVal("Des_sympsign"));
	}	
	/**
	 * 症状和体征
	 * @param Des_sympsign
	 */
	public void setDes_sympsign(String Des_sympsign) {
		setAttrVal("Des_sympsign", Des_sympsign);
	}
	/**
	 * 注意事项
	 * @return String
	 */
	public String getAnnouncements() {
		return ((String) getAttrVal("Announcements"));
	}	
	/**
	 * 注意事项
	 * @param Announcements
	 */
	public void setAnnouncements(String Announcements) {
		setAttrVal("Announcements", Announcements);
	}
	/**
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 客户扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * 客户扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 客户扩展字段7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	/**
	 * 客户扩展字段7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 客户扩展字段8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	/**
	 * 客户扩展字段8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 客户扩展字段9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	/**
	 * 客户扩展字段9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 客户扩展字段10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	/**
	 * 客户扩展字段10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	/**
	 * 客户扩展字段11
	 * @return String
	 */
	public String getDef11() {
		return ((String) getAttrVal("Def11"));
	}	
	/**
	 * 客户扩展字段11
	 * @param Def11
	 */
	public void setDef11(String Def11) {
		setAttrVal("Def11", Def11);
	}
	/**
	 * 客户扩展字段12
	 * @return String
	 */
	public String getDef12() {
		return ((String) getAttrVal("Def12"));
	}	
	/**
	 * 客户扩展字段12
	 * @param Def12
	 */
	public void setDef12(String Def12) {
		setAttrVal("Def12", Def12);
	}
	/**
	 * 客户扩展字段13
	 * @return String
	 */
	public String getDef13() {
		return ((String) getAttrVal("Def13"));
	}	
	/**
	 * 客户扩展字段13
	 * @param Def13
	 */
	public void setDef13(String Def13) {
		setAttrVal("Def13", Def13);
	}
	/**
	 * 客户扩展字段14
	 * @return String
	 */
	public String getDef14() {
		return ((String) getAttrVal("Def14"));
	}	
	/**
	 * 客户扩展字段14
	 * @param Def14
	 */
	public void setDef14(String Def14) {
		setAttrVal("Def14", Def14);
	}
	/**
	 * 客户扩展字段15
	 * @return String
	 */
	public String getDef15() {
		return ((String) getAttrVal("Def15"));
	}	
	/**
	 * 客户扩展字段15
	 * @param Def15
	 */
	public void setDef15(String Def15) {
		setAttrVal("Def15", Def15);
	}
	/**
	 * 客户扩展字段16
	 * @return String
	 */
	public String getDef16() {
		return ((String) getAttrVal("Def16"));
	}	
	/**
	 * 客户扩展字段16
	 * @param Def16
	 */
	public void setDef16(String Def16) {
		setAttrVal("Def16", Def16);
	}
	/**
	 * 客户扩展字段17
	 * @return String
	 */
	public String getDef17() {
		return ((String) getAttrVal("Def17"));
	}	
	/**
	 * 客户扩展字段17
	 * @param Def17
	 */
	public void setDef17(String Def17) {
		setAttrVal("Def17", Def17);
	}
	/**
	 * 客户扩展字段18
	 * @return String
	 */
	public String getDef18() {
		return ((String) getAttrVal("Def18"));
	}	
	/**
	 * 客户扩展字段18
	 * @param Def18
	 */
	public void setDef18(String Def18) {
		setAttrVal("Def18", Def18);
	}
	/**
	 * 客户扩展字段19
	 * @return String
	 */
	public String getDef19() {
		return ((String) getAttrVal("Def19"));
	}	
	/**
	 * 客户扩展字段19
	 * @param Def19
	 */
	public void setDef19(String Def19) {
		setAttrVal("Def19", Def19);
	}
	/**
	 * 客户扩展字段20
	 * @return String
	 */
	public String getDef20() {
		return ((String) getAttrVal("Def20"));
	}	
	/**
	 * 客户扩展字段20
	 * @param Def20
	 */
	public void setDef20(String Def20) {
		setAttrVal("Def20", Def20);
	}
	/**
	 * 客户扩展字段21
	 * @return String
	 */
	public String getDef21() {
		return ((String) getAttrVal("Def21"));
	}	
	/**
	 * 客户扩展字段21
	 * @param Def21
	 */
	public void setDef21(String Def21) {
		setAttrVal("Def21", Def21);
	}
	/**
	 * 客户扩展字段22
	 * @return String
	 */
	public String getDef22() {
		return ((String) getAttrVal("Def22"));
	}	
	/**
	 * 客户扩展字段22
	 * @param Def22
	 */
	public void setDef22(String Def22) {
		setAttrVal("Def22", Def22);
	}
	/**
	 * 客户扩展字段23
	 * @return String
	 */
	public String getDef23() {
		return ((String) getAttrVal("Def23"));
	}	
	/**
	 * 客户扩展字段23
	 * @param Def23
	 */
	public void setDef23(String Def23) {
		setAttrVal("Def23", Def23);
	}
	/**
	 * 客户扩展字段24
	 * @return String
	 */
	public String getDef24() {
		return ((String) getAttrVal("Def24"));
	}	
	/**
	 * 客户扩展字段24
	 * @param Def24
	 */
	public void setDef24(String Def24) {
		setAttrVal("Def24", Def24);
	}
	/**
	 * 客户扩展字段25
	 * @return String
	 */
	public String getDef25() {
		return ((String) getAttrVal("Def25"));
	}	
	/**
	 * 客户扩展字段25
	 * @param Def25
	 */
	public void setDef25(String Def25) {
		setAttrVal("Def25", Def25);
	}
	/**
	 * 客户扩展字段26
	 * @return String
	 */
	public String getDef26() {
		return ((String) getAttrVal("Def26"));
	}	
	/**
	 * 客户扩展字段26
	 * @param Def26
	 */
	public void setDef26(String Def26) {
		setAttrVal("Def26", Def26);
	}
	/**
	 * 客户扩展字段27
	 * @return String
	 */
	public String getDef27() {
		return ((String) getAttrVal("Def27"));
	}	
	/**
	 * 客户扩展字段27
	 * @param Def27
	 */
	public void setDef27(String Def27) {
		setAttrVal("Def27", Def27);
	}
	/**
	 * 客户扩展字段28
	 * @return String
	 */
	public String getDef28() {
		return ((String) getAttrVal("Def28"));
	}	
	/**
	 * 客户扩展字段28
	 * @param Def28
	 */
	public void setDef28(String Def28) {
		setAttrVal("Def28", Def28);
	}
	/**
	 * 客户扩展字段29
	 * @return String
	 */
	public String getDef29() {
		return ((String) getAttrVal("Def29"));
	}	
	/**
	 * 客户扩展字段29
	 * @param Def29
	 */
	public void setDef29(String Def29) {
		setAttrVal("Def29", Def29);
	}
	/**
	 * 客户扩展字段30
	 * @return String
	 */
	public String getDef30() {
		return ((String) getAttrVal("Def30"));
	}	
	/**
	 * 客户扩展字段30
	 * @param Def30
	 */
	public void setDef30(String Def30) {
		setAttrVal("Def30", Def30);
	}
	/**
	 * 客户扩展字段31
	 * @return String
	 */
	public String getDef31() {
		return ((String) getAttrVal("Def31"));
	}	
	/**
	 * 客户扩展字段31
	 * @param Def31
	 */
	public void setDef31(String Def31) {
		setAttrVal("Def31", Def31);
	}
	/**
	 * 客户扩展字段32
	 * @return String
	 */
	public String getDef32() {
		return ((String) getAttrVal("Def32"));
	}	
	/**
	 * 客户扩展字段32
	 * @param Def32
	 */
	public void setDef32(String Def32) {
		setAttrVal("Def32", Def32);
	}
	/**
	 * 客户扩展字段33
	 * @return String
	 */
	public String getDef33() {
		return ((String) getAttrVal("Def33"));
	}	
	/**
	 * 客户扩展字段33
	 * @param Def33
	 */
	public void setDef33(String Def33) {
		setAttrVal("Def33", Def33);
	}
	/**
	 * 客户扩展字段34
	 * @return String
	 */
	public String getDef34() {
		return ((String) getAttrVal("Def34"));
	}	
	/**
	 * 客户扩展字段34
	 * @param Def34
	 */
	public void setDef34(String Def34) {
		setAttrVal("Def34", Def34);
	}
	/**
	 * 客户扩展字段35
	 * @return String
	 */
	public String getDef35() {
		return ((String) getAttrVal("Def35"));
	}	
	/**
	 * 客户扩展字段35
	 * @param Def35
	 */
	public void setDef35(String Def35) {
		setAttrVal("Def35", Def35);
	}
	/**
	 * 客户扩展字段36
	 * @return String
	 */
	public String getDef36() {
		return ((String) getAttrVal("Def36"));
	}	
	/**
	 * 客户扩展字段36
	 * @param Def36
	 */
	public void setDef36(String Def36) {
		setAttrVal("Def36", Def36);
	}
	/**
	 * 客户扩展字段37
	 * @return String
	 */
	public String getDef37() {
		return ((String) getAttrVal("Def37"));
	}	
	/**
	 * 客户扩展字段37
	 * @param Def37
	 */
	public void setDef37(String Def37) {
		setAttrVal("Def37", Def37);
	}
	/**
	 * 客户扩展字段38
	 * @return String
	 */
	public String getDef38() {
		return ((String) getAttrVal("Def38"));
	}	
	/**
	 * 客户扩展字段38
	 * @param Def38
	 */
	public void setDef38(String Def38) {
		setAttrVal("Def38", Def38);
	}
	/**
	 * 客户扩展字段39
	 * @return String
	 */
	public String getDef39() {
		return ((String) getAttrVal("Def39"));
	}	
	/**
	 * 客户扩展字段39
	 * @param Def39
	 */
	public void setDef39(String Def39) {
		setAttrVal("Def39", Def39);
	}
	/**
	 * 客户扩展字段40
	 * @return String
	 */
	public String getDef40() {
		return ((String) getAttrVal("Def40"));
	}	
	/**
	 * 客户扩展字段40
	 * @param Def40
	 */
	public void setDef40(String Def40) {
		setAttrVal("Def40", Def40);
	}
	/**
	 * 客户扩展字段41
	 * @return String
	 */
	public String getDef41() {
		return ((String) getAttrVal("Def41"));
	}	
	/**
	 * 客户扩展字段41
	 * @param Def41
	 */
	public void setDef41(String Def41) {
		setAttrVal("Def41", Def41);
	}
	/**
	 * 客户扩展字段42
	 * @return String
	 */
	public String getDef42() {
		return ((String) getAttrVal("Def42"));
	}	
	/**
	 * 客户扩展字段42
	 * @param Def42
	 */
	public void setDef42(String Def42) {
		setAttrVal("Def42", Def42);
	}
	/**
	 * 客户扩展字段43
	 * @return String
	 */
	public String getDef43() {
		return ((String) getAttrVal("Def43"));
	}	
	/**
	 * 客户扩展字段43
	 * @param Def43
	 */
	public void setDef43(String Def43) {
		setAttrVal("Def43", Def43);
	}
	/**
	 * 客户扩展字段44
	 * @return String
	 */
	public String getDef44() {
		return ((String) getAttrVal("Def44"));
	}	
	/**
	 * 客户扩展字段44
	 * @param Def44
	 */
	public void setDef44(String Def44) {
		setAttrVal("Def44", Def44);
	}
	/**
	 * 客户扩展字段45
	 * @return String
	 */
	public String getDef45() {
		return ((String) getAttrVal("Def45"));
	}	
	/**
	 * 客户扩展字段45
	 * @param Def45
	 */
	public void setDef45(String Def45) {
		setAttrVal("Def45", Def45);
	}
	/**
	 * 客户扩展字段46
	 * @return String
	 */
	public String getDef46() {
		return ((String) getAttrVal("Def46"));
	}	
	/**
	 * 客户扩展字段46
	 * @param Def46
	 */
	public void setDef46(String Def46) {
		setAttrVal("Def46", Def46);
	}
	/**
	 * 客户扩展字段47
	 * @return String
	 */
	public String getDef47() {
		return ((String) getAttrVal("Def47"));
	}	
	/**
	 * 客户扩展字段47
	 * @param Def47
	 */
	public void setDef47(String Def47) {
		setAttrVal("Def47", Def47);
	}
	/**
	 * 客户扩展字段48
	 * @return String
	 */
	public String getDef48() {
		return ((String) getAttrVal("Def48"));
	}	
	/**
	 * 客户扩展字段48
	 * @param Def48
	 */
	public void setDef48(String Def48) {
		setAttrVal("Def48", Def48);
	}
	/**
	 * 客户扩展字段49
	 * @return String
	 */
	public String getDef49() {
		return ((String) getAttrVal("Def49"));
	}	
	/**
	 * 客户扩展字段49
	 * @param Def49
	 */
	public void setDef49(String Def49) {
		setAttrVal("Def49", Def49);
	}
	/**
	 * 客户扩展字段50
	 * @return String
	 */
	public String getDef50() {
		return ((String) getAttrVal("Def50"));
	}	
	/**
	 * 客户扩展字段50
	 * @param Def50
	 */
	public void setDef50(String Def50) {
		setAttrVal("Def50", Def50);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
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
		return "Id_tsapobs";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ts_ap_bos";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiTsApObsDODesc.class);
	}
	
}