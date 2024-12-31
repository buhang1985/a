package iih.mi.mibd.drugorginal.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.mibd.drugorginal.d.desc.MiDrugOrginalDODesc;
import java.math.BigDecimal;

/**
 * (新)医保药品原始目录 DO数据 
 * 
 */
public class MiDrugOrginalDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//原始目录主键
	public static final String ID_MIDRUGORGINAL= "Id_midrugorginal";
	//医保计划
	public static final String ID_HP= "Id_hp";
	//药品编码
	public static final String CODE= "Code";
	//药品名称
	public static final String NAME= "Name";
	//药品商品名
	public static final String DRUG_TRADE_NAME= "Drug_trade_name";
	//拼音码
	public static final String PY_CODE= "Py_code";
	//五笔码
	public static final String WB_CODE= "Wb_code";
	//收费类别
	public static final String CODE_CA= "Code_ca";
	//目录等级
	public static final String SD_HPSRVTP= "Sd_hpsrvtp";
	//限价
	public static final String PRICE_FIXED= "Price_fixed";
	//开始时间
	public static final String DT_B= "Dt_b";
	//结束时间
	public static final String DT_E= "Dt_e";
	//门诊自付比例
	public static final String RATE_OEP= "Rate_oep";
	//住院自付比例
	public static final String RATE_IP= "Rate_ip";
	//离休自付比例
	public static final String RATE_RETIRE= "Rate_retire";
	//工伤自付比例
	public static final String RATE_INJURY= "Rate_injury";
	//生育自付比例
	public static final String RATE_BIRTH= "Rate_birth";
	//单位自付比例
	public static final String RATE_UNIT= "Rate_unit";
	//用法
	public static final String USAGE= "Usage";
	//规格
	public static final String SPEC= "Spec";
	//单位
	public static final String UNIT= "Unit";
	//招标价格
	public static final String BIDDING_PRICE= "Bidding_price";
	//参考价
	public static final String REFERENCE_PRICE= "Reference_price";
	//特药标志(处方药标志)
	public static final String FG_SPEC_DRUG= "Fg_spec_drug";
	//药厂名称
	public static final String PHARM_NAME= "Pharm_name";
	//国药准字
	public static final String QUASI_DRUG= "Quasi_drug";
	//产地
	public static final String ORIGIN_PLACE= "Origin_place";
	//有效标志
	public static final String FG_EFFECTIVE= "Fg_effective";
	//备用字段1
	public static final String DEF1= "Def1";
	//备用字段2
	public static final String DEF2= "Def2";
	//备用字段3
	public static final String DEF3= "Def3";
	//备用字段4
	public static final String DEF4= "Def4";
	//备用字段5
	public static final String DEF5= "Def5";
	//备用字段6
	public static final String DEF6= "Def6";
	//备用字段7
	public static final String DEF7= "Def7";
	//备用字段8
	public static final String DEF8= "Def8";
	//备用字段9
	public static final String DEF9= "Def9";
	//备用字段10
	public static final String DEF10= "Def10";
	//备用字段11
	public static final String DEF11= "Def11";
	//备用字段12
	public static final String DEF12= "Def12";
	//备用字段13
	public static final String DEF13= "Def13";
	//备用字段14
	public static final String DEF14= "Def14";
	//备用字段15
	public static final String DEF15= "Def15";
	//备用字段16
	public static final String DEF16= "Def16";
	//备用字段17
	public static final String DEF17= "Def17";
	//备用字段18
	public static final String DEF18= "Def18";
	//备用字段19
	public static final String DEF19= "Def19";
	//备用字段20
	public static final String DEF20= "Def20";
	//备用字段21
	public static final String DEF21= "Def21";
	//备用字段22
	public static final String DEF22= "Def22";
	//备用字段23
	public static final String DEF23= "Def23";
	//备用字段24
	public static final String DEF24= "Def24";
	//备用字段25
	public static final String DEF25= "Def25";
	//备用字段26
	public static final String DEF26= "Def26";
	//备用字段27
	public static final String DEF27= "Def27";
	//备用字段28
	public static final String DEF28= "Def28";
	//备用字段29
	public static final String DEF29= "Def29";
	//备用字段30
	public static final String DEF30= "Def30";
	//备用字段31
	public static final String DEF31= "Def31";
	//备用字段32
	public static final String DEF32= "Def32";
	//备用字段33
	public static final String DEF33= "Def33";
	//备用字段34
	public static final String DEF34= "Def34";
	//备用字段35
	public static final String DEF35= "Def35";
	//备用字段36
	public static final String DEF36= "Def36";
	//备用字段37
	public static final String DEF37= "Def37";
	//备用字段38
	public static final String DEF38= "Def38";
	//备用字段39
	public static final String DEF39= "Def39";
	//备用字段40
	public static final String DEF40= "Def40";
	//备用字段41
	public static final String DEF41= "Def41";
	//备用字段42
	public static final String DEF42= "Def42";
	//备用字段43
	public static final String DEF43= "Def43";
	//备用字段44
	public static final String DEF44= "Def44";
	//备用字段45
	public static final String DEF45= "Def45";
	//备用字段46
	public static final String DEF46= "Def46";
	//备用字段47
	public static final String DEF47= "Def47";
	//备用字段48
	public static final String DEF48= "Def48";
	//备用字段49
	public static final String DEF49= "Def49";
	//备用字段50
	public static final String DEF50= "Def50";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 原始目录主键
	 * @return String
	 */
	public String getId_midrugorginal() {
		return ((String) getAttrVal("Id_midrugorginal"));
	}	
	/**
	 * 原始目录主键
	 * @param Id_midrugorginal
	 */
	public void setId_midrugorginal(String Id_midrugorginal) {
		setAttrVal("Id_midrugorginal", Id_midrugorginal);
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
	 * 药品编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 药品编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 药品名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 药品商品名
	 * @return String
	 */
	public String getDrug_trade_name() {
		return ((String) getAttrVal("Drug_trade_name"));
	}	
	/**
	 * 药品商品名
	 * @param Drug_trade_name
	 */
	public void setDrug_trade_name(String Drug_trade_name) {
		setAttrVal("Drug_trade_name", Drug_trade_name);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPy_code() {
		return ((String) getAttrVal("Py_code"));
	}	
	/**
	 * 拼音码
	 * @param Py_code
	 */
	public void setPy_code(String Py_code) {
		setAttrVal("Py_code", Py_code);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWb_code() {
		return ((String) getAttrVal("Wb_code"));
	}	
	/**
	 * 五笔码
	 * @param Wb_code
	 */
	public void setWb_code(String Wb_code) {
		setAttrVal("Wb_code", Wb_code);
	}
	/**
	 * 收费类别
	 * @return String
	 */
	public String getCode_ca() {
		return ((String) getAttrVal("Code_ca"));
	}	
	/**
	 * 收费类别
	 * @param Code_ca
	 */
	public void setCode_ca(String Code_ca) {
		setAttrVal("Code_ca", Code_ca);
	}
	/**
	 * 目录等级
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}	
	/**
	 * 目录等级
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 限价
	 * @return FDouble
	 */
	public FDouble getPrice_fixed() {
		return ((FDouble) getAttrVal("Price_fixed"));
	}	
	/**
	 * 限价
	 * @param Price_fixed
	 */
	public void setPrice_fixed(FDouble Price_fixed) {
		setAttrVal("Price_fixed", Price_fixed);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	/**
	 * 开始时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	/**
	 * 结束时间
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 门诊自付比例
	 * @return FDouble
	 */
	public FDouble getRate_oep() {
		return ((FDouble) getAttrVal("Rate_oep"));
	}	
	/**
	 * 门诊自付比例
	 * @param Rate_oep
	 */
	public void setRate_oep(FDouble Rate_oep) {
		setAttrVal("Rate_oep", Rate_oep);
	}
	/**
	 * 住院自付比例
	 * @return String
	 */
	public String getRate_ip() {
		return ((String) getAttrVal("Rate_ip"));
	}	
	/**
	 * 住院自付比例
	 * @param Rate_ip
	 */
	public void setRate_ip(String Rate_ip) {
		setAttrVal("Rate_ip", Rate_ip);
	}
	/**
	 * 离休自付比例
	 * @return FDouble
	 */
	public FDouble getRate_retire() {
		return ((FDouble) getAttrVal("Rate_retire"));
	}	
	/**
	 * 离休自付比例
	 * @param Rate_retire
	 */
	public void setRate_retire(FDouble Rate_retire) {
		setAttrVal("Rate_retire", Rate_retire);
	}
	/**
	 * 工伤自付比例
	 * @return FDouble
	 */
	public FDouble getRate_injury() {
		return ((FDouble) getAttrVal("Rate_injury"));
	}	
	/**
	 * 工伤自付比例
	 * @param Rate_injury
	 */
	public void setRate_injury(FDouble Rate_injury) {
		setAttrVal("Rate_injury", Rate_injury);
	}
	/**
	 * 生育自付比例
	 * @return FDouble
	 */
	public FDouble getRate_birth() {
		return ((FDouble) getAttrVal("Rate_birth"));
	}	
	/**
	 * 生育自付比例
	 * @param Rate_birth
	 */
	public void setRate_birth(FDouble Rate_birth) {
		setAttrVal("Rate_birth", Rate_birth);
	}
	/**
	 * 单位自付比例
	 * @return FDouble
	 */
	public FDouble getRate_unit() {
		return ((FDouble) getAttrVal("Rate_unit"));
	}	
	/**
	 * 单位自付比例
	 * @param Rate_unit
	 */
	public void setRate_unit(FDouble Rate_unit) {
		setAttrVal("Rate_unit", Rate_unit);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getUsage() {
		return ((String) getAttrVal("Usage"));
	}	
	/**
	 * 用法
	 * @param Usage
	 */
	public void setUsage(String Usage) {
		setAttrVal("Usage", Usage);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getUnit() {
		return ((String) getAttrVal("Unit"));
	}	
	/**
	 * 单位
	 * @param Unit
	 */
	public void setUnit(String Unit) {
		setAttrVal("Unit", Unit);
	}
	/**
	 * 招标价格
	 * @return FDouble
	 */
	public FDouble getBidding_price() {
		return ((FDouble) getAttrVal("Bidding_price"));
	}	
	/**
	 * 招标价格
	 * @param Bidding_price
	 */
	public void setBidding_price(FDouble Bidding_price) {
		setAttrVal("Bidding_price", Bidding_price);
	}
	/**
	 * 参考价
	 * @return FDouble
	 */
	public FDouble getReference_price() {
		return ((FDouble) getAttrVal("Reference_price"));
	}	
	/**
	 * 参考价
	 * @param Reference_price
	 */
	public void setReference_price(FDouble Reference_price) {
		setAttrVal("Reference_price", Reference_price);
	}
	/**
	 * 特药标志(处方药标志)
	 * @return String
	 */
	public String getFg_spec_drug() {
		return ((String) getAttrVal("Fg_spec_drug"));
	}	
	/**
	 * 特药标志(处方药标志)
	 * @param Fg_spec_drug
	 */
	public void setFg_spec_drug(String Fg_spec_drug) {
		setAttrVal("Fg_spec_drug", Fg_spec_drug);
	}
	/**
	 * 药厂名称
	 * @return String
	 */
	public String getPharm_name() {
		return ((String) getAttrVal("Pharm_name"));
	}	
	/**
	 * 药厂名称
	 * @param Pharm_name
	 */
	public void setPharm_name(String Pharm_name) {
		setAttrVal("Pharm_name", Pharm_name);
	}
	/**
	 * 国药准字
	 * @return String
	 */
	public String getQuasi_drug() {
		return ((String) getAttrVal("Quasi_drug"));
	}	
	/**
	 * 国药准字
	 * @param Quasi_drug
	 */
	public void setQuasi_drug(String Quasi_drug) {
		setAttrVal("Quasi_drug", Quasi_drug);
	}
	/**
	 * 产地
	 * @return String
	 */
	public String getOrigin_place() {
		return ((String) getAttrVal("Origin_place"));
	}	
	/**
	 * 产地
	 * @param Origin_place
	 */
	public void setOrigin_place(String Origin_place) {
		setAttrVal("Origin_place", Origin_place);
	}
	/**
	 * 有效标志
	 * @return String
	 */
	public String getFg_effective() {
		return ((String) getAttrVal("Fg_effective"));
	}	
	/**
	 * 有效标志
	 * @param Fg_effective
	 */
	public void setFg_effective(String Fg_effective) {
		setAttrVal("Fg_effective", Fg_effective);
	}
	/**
	 * 备用字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 备用字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 备用字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 备用字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 备用字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 备用字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 备用字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 备用字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 备用字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 备用字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 备用字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * 备用字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 备用字段7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	/**
	 * 备用字段7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 备用字段8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	/**
	 * 备用字段8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 备用字段9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	/**
	 * 备用字段9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 备用字段10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	/**
	 * 备用字段10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	/**
	 * 备用字段11
	 * @return String
	 */
	public String getDef11() {
		return ((String) getAttrVal("Def11"));
	}	
	/**
	 * 备用字段11
	 * @param Def11
	 */
	public void setDef11(String Def11) {
		setAttrVal("Def11", Def11);
	}
	/**
	 * 备用字段12
	 * @return String
	 */
	public String getDef12() {
		return ((String) getAttrVal("Def12"));
	}	
	/**
	 * 备用字段12
	 * @param Def12
	 */
	public void setDef12(String Def12) {
		setAttrVal("Def12", Def12);
	}
	/**
	 * 备用字段13
	 * @return String
	 */
	public String getDef13() {
		return ((String) getAttrVal("Def13"));
	}	
	/**
	 * 备用字段13
	 * @param Def13
	 */
	public void setDef13(String Def13) {
		setAttrVal("Def13", Def13);
	}
	/**
	 * 备用字段14
	 * @return String
	 */
	public String getDef14() {
		return ((String) getAttrVal("Def14"));
	}	
	/**
	 * 备用字段14
	 * @param Def14
	 */
	public void setDef14(String Def14) {
		setAttrVal("Def14", Def14);
	}
	/**
	 * 备用字段15
	 * @return String
	 */
	public String getDef15() {
		return ((String) getAttrVal("Def15"));
	}	
	/**
	 * 备用字段15
	 * @param Def15
	 */
	public void setDef15(String Def15) {
		setAttrVal("Def15", Def15);
	}
	/**
	 * 备用字段16
	 * @return String
	 */
	public String getDef16() {
		return ((String) getAttrVal("Def16"));
	}	
	/**
	 * 备用字段16
	 * @param Def16
	 */
	public void setDef16(String Def16) {
		setAttrVal("Def16", Def16);
	}
	/**
	 * 备用字段17
	 * @return String
	 */
	public String getDef17() {
		return ((String) getAttrVal("Def17"));
	}	
	/**
	 * 备用字段17
	 * @param Def17
	 */
	public void setDef17(String Def17) {
		setAttrVal("Def17", Def17);
	}
	/**
	 * 备用字段18
	 * @return String
	 */
	public String getDef18() {
		return ((String) getAttrVal("Def18"));
	}	
	/**
	 * 备用字段18
	 * @param Def18
	 */
	public void setDef18(String Def18) {
		setAttrVal("Def18", Def18);
	}
	/**
	 * 备用字段19
	 * @return String
	 */
	public String getDef19() {
		return ((String) getAttrVal("Def19"));
	}	
	/**
	 * 备用字段19
	 * @param Def19
	 */
	public void setDef19(String Def19) {
		setAttrVal("Def19", Def19);
	}
	/**
	 * 备用字段20
	 * @return String
	 */
	public String getDef20() {
		return ((String) getAttrVal("Def20"));
	}	
	/**
	 * 备用字段20
	 * @param Def20
	 */
	public void setDef20(String Def20) {
		setAttrVal("Def20", Def20);
	}
	/**
	 * 备用字段21
	 * @return String
	 */
	public String getDef21() {
		return ((String) getAttrVal("Def21"));
	}	
	/**
	 * 备用字段21
	 * @param Def21
	 */
	public void setDef21(String Def21) {
		setAttrVal("Def21", Def21);
	}
	/**
	 * 备用字段22
	 * @return String
	 */
	public String getDef22() {
		return ((String) getAttrVal("Def22"));
	}	
	/**
	 * 备用字段22
	 * @param Def22
	 */
	public void setDef22(String Def22) {
		setAttrVal("Def22", Def22);
	}
	/**
	 * 备用字段23
	 * @return String
	 */
	public String getDef23() {
		return ((String) getAttrVal("Def23"));
	}	
	/**
	 * 备用字段23
	 * @param Def23
	 */
	public void setDef23(String Def23) {
		setAttrVal("Def23", Def23);
	}
	/**
	 * 备用字段24
	 * @return String
	 */
	public String getDef24() {
		return ((String) getAttrVal("Def24"));
	}	
	/**
	 * 备用字段24
	 * @param Def24
	 */
	public void setDef24(String Def24) {
		setAttrVal("Def24", Def24);
	}
	/**
	 * 备用字段25
	 * @return String
	 */
	public String getDef25() {
		return ((String) getAttrVal("Def25"));
	}	
	/**
	 * 备用字段25
	 * @param Def25
	 */
	public void setDef25(String Def25) {
		setAttrVal("Def25", Def25);
	}
	/**
	 * 备用字段26
	 * @return String
	 */
	public String getDef26() {
		return ((String) getAttrVal("Def26"));
	}	
	/**
	 * 备用字段26
	 * @param Def26
	 */
	public void setDef26(String Def26) {
		setAttrVal("Def26", Def26);
	}
	/**
	 * 备用字段27
	 * @return String
	 */
	public String getDef27() {
		return ((String) getAttrVal("Def27"));
	}	
	/**
	 * 备用字段27
	 * @param Def27
	 */
	public void setDef27(String Def27) {
		setAttrVal("Def27", Def27);
	}
	/**
	 * 备用字段28
	 * @return String
	 */
	public String getDef28() {
		return ((String) getAttrVal("Def28"));
	}	
	/**
	 * 备用字段28
	 * @param Def28
	 */
	public void setDef28(String Def28) {
		setAttrVal("Def28", Def28);
	}
	/**
	 * 备用字段29
	 * @return String
	 */
	public String getDef29() {
		return ((String) getAttrVal("Def29"));
	}	
	/**
	 * 备用字段29
	 * @param Def29
	 */
	public void setDef29(String Def29) {
		setAttrVal("Def29", Def29);
	}
	/**
	 * 备用字段30
	 * @return String
	 */
	public String getDef30() {
		return ((String) getAttrVal("Def30"));
	}	
	/**
	 * 备用字段30
	 * @param Def30
	 */
	public void setDef30(String Def30) {
		setAttrVal("Def30", Def30);
	}
	/**
	 * 备用字段31
	 * @return String
	 */
	public String getDef31() {
		return ((String) getAttrVal("Def31"));
	}	
	/**
	 * 备用字段31
	 * @param Def31
	 */
	public void setDef31(String Def31) {
		setAttrVal("Def31", Def31);
	}
	/**
	 * 备用字段32
	 * @return String
	 */
	public String getDef32() {
		return ((String) getAttrVal("Def32"));
	}	
	/**
	 * 备用字段32
	 * @param Def32
	 */
	public void setDef32(String Def32) {
		setAttrVal("Def32", Def32);
	}
	/**
	 * 备用字段33
	 * @return String
	 */
	public String getDef33() {
		return ((String) getAttrVal("Def33"));
	}	
	/**
	 * 备用字段33
	 * @param Def33
	 */
	public void setDef33(String Def33) {
		setAttrVal("Def33", Def33);
	}
	/**
	 * 备用字段34
	 * @return String
	 */
	public String getDef34() {
		return ((String) getAttrVal("Def34"));
	}	
	/**
	 * 备用字段34
	 * @param Def34
	 */
	public void setDef34(String Def34) {
		setAttrVal("Def34", Def34);
	}
	/**
	 * 备用字段35
	 * @return String
	 */
	public String getDef35() {
		return ((String) getAttrVal("Def35"));
	}	
	/**
	 * 备用字段35
	 * @param Def35
	 */
	public void setDef35(String Def35) {
		setAttrVal("Def35", Def35);
	}
	/**
	 * 备用字段36
	 * @return String
	 */
	public String getDef36() {
		return ((String) getAttrVal("Def36"));
	}	
	/**
	 * 备用字段36
	 * @param Def36
	 */
	public void setDef36(String Def36) {
		setAttrVal("Def36", Def36);
	}
	/**
	 * 备用字段37
	 * @return String
	 */
	public String getDef37() {
		return ((String) getAttrVal("Def37"));
	}	
	/**
	 * 备用字段37
	 * @param Def37
	 */
	public void setDef37(String Def37) {
		setAttrVal("Def37", Def37);
	}
	/**
	 * 备用字段38
	 * @return String
	 */
	public String getDef38() {
		return ((String) getAttrVal("Def38"));
	}	
	/**
	 * 备用字段38
	 * @param Def38
	 */
	public void setDef38(String Def38) {
		setAttrVal("Def38", Def38);
	}
	/**
	 * 备用字段39
	 * @return String
	 */
	public String getDef39() {
		return ((String) getAttrVal("Def39"));
	}	
	/**
	 * 备用字段39
	 * @param Def39
	 */
	public void setDef39(String Def39) {
		setAttrVal("Def39", Def39);
	}
	/**
	 * 备用字段40
	 * @return String
	 */
	public String getDef40() {
		return ((String) getAttrVal("Def40"));
	}	
	/**
	 * 备用字段40
	 * @param Def40
	 */
	public void setDef40(String Def40) {
		setAttrVal("Def40", Def40);
	}
	/**
	 * 备用字段41
	 * @return String
	 */
	public String getDef41() {
		return ((String) getAttrVal("Def41"));
	}	
	/**
	 * 备用字段41
	 * @param Def41
	 */
	public void setDef41(String Def41) {
		setAttrVal("Def41", Def41);
	}
	/**
	 * 备用字段42
	 * @return String
	 */
	public String getDef42() {
		return ((String) getAttrVal("Def42"));
	}	
	/**
	 * 备用字段42
	 * @param Def42
	 */
	public void setDef42(String Def42) {
		setAttrVal("Def42", Def42);
	}
	/**
	 * 备用字段43
	 * @return String
	 */
	public String getDef43() {
		return ((String) getAttrVal("Def43"));
	}	
	/**
	 * 备用字段43
	 * @param Def43
	 */
	public void setDef43(String Def43) {
		setAttrVal("Def43", Def43);
	}
	/**
	 * 备用字段44
	 * @return String
	 */
	public String getDef44() {
		return ((String) getAttrVal("Def44"));
	}	
	/**
	 * 备用字段44
	 * @param Def44
	 */
	public void setDef44(String Def44) {
		setAttrVal("Def44", Def44);
	}
	/**
	 * 备用字段45
	 * @return String
	 */
	public String getDef45() {
		return ((String) getAttrVal("Def45"));
	}	
	/**
	 * 备用字段45
	 * @param Def45
	 */
	public void setDef45(String Def45) {
		setAttrVal("Def45", Def45);
	}
	/**
	 * 备用字段46
	 * @return String
	 */
	public String getDef46() {
		return ((String) getAttrVal("Def46"));
	}	
	/**
	 * 备用字段46
	 * @param Def46
	 */
	public void setDef46(String Def46) {
		setAttrVal("Def46", Def46);
	}
	/**
	 * 备用字段47
	 * @return String
	 */
	public String getDef47() {
		return ((String) getAttrVal("Def47"));
	}	
	/**
	 * 备用字段47
	 * @param Def47
	 */
	public void setDef47(String Def47) {
		setAttrVal("Def47", Def47);
	}
	/**
	 * 备用字段48
	 * @return String
	 */
	public String getDef48() {
		return ((String) getAttrVal("Def48"));
	}	
	/**
	 * 备用字段48
	 * @param Def48
	 */
	public void setDef48(String Def48) {
		setAttrVal("Def48", Def48);
	}
	/**
	 * 备用字段49
	 * @return String
	 */
	public String getDef49() {
		return ((String) getAttrVal("Def49"));
	}	
	/**
	 * 备用字段49
	 * @param Def49
	 */
	public void setDef49(String Def49) {
		setAttrVal("Def49", Def49);
	}
	/**
	 * 备用字段50
	 * @return String
	 */
	public String getDef50() {
		return ((String) getAttrVal("Def50"));
	}	
	/**
	 * 备用字段50
	 * @param Def50
	 */
	public void setDef50(String Def50) {
		setAttrVal("Def50", Def50);
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
		return "Id_midrugorginal";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_drug_orginal";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiDrugOrginalDODesc.class);
	}
	
}