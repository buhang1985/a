package iih.ci.rcm.contagion.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.contagion.d.desc.HepatitisBDODesc;
import java.math.BigDecimal;

/**
 * 乙肝附卡 DO数据 
 * 
 */
public class HepatitisBDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//乙肝附卡ID
	public static final String ID_CONTAGION_HB= "Id_contagion_hb";
	//父id
	public static final String ID_CONTAGION= "Id_contagion";
	//表单
	public static final String ID_FORM= "Id_form";
	//HBsAg阳性时间
	public static final String ID_HBSAG_DT= "Id_hbsag_dt";
	//HBsAg阳性时间编码
	public static final String CODE_HBSAG_DT= "Code_hbsag_dt";
	//HBsAg阳性时间name
	public static final String NAME_HBSAG_DT= "Name_hbsag_dt";
	//首次乙肝发病时间
	public static final String DT_FIRST= "Dt_first";
	//本次ALT
	public static final String ALT= "Alt";
	//抗-HBc IgM1:1000检测结果
	public static final String ID_HBC_IGM1= "Id_hbc_igm1";
	//抗-HBc IgM1:1000检测结果code
	public static final String CODE_HBC_IGM1= "Code_hbc_igm1";
	//抗-HBc IgM1:1000检测结果name
	public static final String NAME_HBC_IGM1= "Name_hbc_igm1";
	//肝穿刺检测结果
	public static final String ID_LIVER_PUNCTURE_RESULTS= "Id_liver_puncture_results";
	//肝穿刺检测结果code
	public static final String CODE_LIVER_PUNCTURE_RESULTS= "Code_liver_puncture_results";
	//肝穿刺检测结果name
	public static final String NAME_LIVER_PUNCTURE_RESULTS= "Name_liver_puncture_results";
	//恢复期血清HBsAg阴转
	public static final String ID_HBSAG_HUIFU= "Id_hbsag_huifu";
	//恢复期血清HBsAg阴转code
	public static final String CODE_HBSAG_HUIFU= "Code_hbsag_huifu";
	//恢复期血清HBsAg阴转name
	public static final String NAME_HBSAG_HUIFU= "Name_hbsag_huifu";
	//是否知道首次发病时间
	public static final String IS_KNOW= "Is_know";
	//卡片编号
	public static final String CARD_NO= "Card_no";
	//患者姓名
	public static final String PAT_NAME= "Pat_name";
	//家长姓名
	public static final String PARENT_NAME= "Parent_name";
	//户籍地址
	public static final String HJDZ= "Hjdz";
	//户籍地址编码
	public static final String CODE_HJDZ= "Code_hjdz";
	//户籍地址名称
	public static final String NAME_HJDZ= "Name_hjdz";
	//乡镇
	public static final String TOWN= "Town";
	//村
	public static final String VALLEGE= "Vallege";
	//门牌号
	public static final String HOUSE_NO= "House_no";
	//报卡医生
	public static final String REPT_DOCTOR= "Rept_doctor";
	//联系电话
	public static final String RELATION_WAY= "Relation_way";
	//报卡医生编码
	public static final String CODE_REPT_DOCTOR= "Code_rept_doctor";
	//报卡医生名字
	public static final String NAME_REPT_DOCTOR= "Name_rept_doctor";
	//编码
	public static final String HBSAG_DT_CODE= "Hbsag_dt_code";
	//名称
	public static final String HBSAG_DT_NAME= "Hbsag_dt_name";
	//编码
	public static final String HBC_IGM_CODE= "Hbc_igm_code";
	//名称
	public static final String HBC_IGM_NAME= "Hbc_igm_name";
	//编码
	public static final String LIVER_PUNCTURE_RESULTS_CODE= "Liver_puncture_results_code";
	//名称
	public static final String LIVER_PUNCTURE_RESULTS_NAME= "Liver_puncture_results_name";
	//编码
	public static final String HBSAG_HUIFU_CODE= "Hbsag_huifu_code";
	//名称
	public static final String HBSAG_HUIFU_NAME= "Hbsag_huifu_name";
	//编码
	public static final String AREACODE= "Areacode";
	//名称
	public static final String AREANAME= "Areaname";
	//人员编码
	public static final String DOCTORCODE= "Doctorcode";
	//姓名
	public static final String DOCTORNAME= "Doctorname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 乙肝附卡ID
	 * @return String
	 */
	public String getId_contagion_hb() {
		return ((String) getAttrVal("Id_contagion_hb"));
	}	
	/**
	 * 乙肝附卡ID
	 * @param Id_contagion_hb
	 */
	public void setId_contagion_hb(String Id_contagion_hb) {
		setAttrVal("Id_contagion_hb", Id_contagion_hb);
	}
	/**
	 * 父id
	 * @return String
	 */
	public String getId_contagion() {
		return ((String) getAttrVal("Id_contagion"));
	}	
	/**
	 * 父id
	 * @param Id_contagion
	 */
	public void setId_contagion(String Id_contagion) {
		setAttrVal("Id_contagion", Id_contagion);
	}
	/**
	 * 表单
	 * @return String
	 */
	public String getId_form() {
		return ((String) getAttrVal("Id_form"));
	}	
	/**
	 * 表单
	 * @param Id_form
	 */
	public void setId_form(String Id_form) {
		setAttrVal("Id_form", Id_form);
	}
	/**
	 * HBsAg阳性时间
	 * @return String
	 */
	public String getId_hbsag_dt() {
		return ((String) getAttrVal("Id_hbsag_dt"));
	}	
	/**
	 * HBsAg阳性时间
	 * @param Id_hbsag_dt
	 */
	public void setId_hbsag_dt(String Id_hbsag_dt) {
		setAttrVal("Id_hbsag_dt", Id_hbsag_dt);
	}
	/**
	 * HBsAg阳性时间编码
	 * @return String
	 */
	public String getCode_hbsag_dt() {
		return ((String) getAttrVal("Code_hbsag_dt"));
	}	
	/**
	 * HBsAg阳性时间编码
	 * @param Code_hbsag_dt
	 */
	public void setCode_hbsag_dt(String Code_hbsag_dt) {
		setAttrVal("Code_hbsag_dt", Code_hbsag_dt);
	}
	/**
	 * HBsAg阳性时间name
	 * @return String
	 */
	public String getName_hbsag_dt() {
		return ((String) getAttrVal("Name_hbsag_dt"));
	}	
	/**
	 * HBsAg阳性时间name
	 * @param Name_hbsag_dt
	 */
	public void setName_hbsag_dt(String Name_hbsag_dt) {
		setAttrVal("Name_hbsag_dt", Name_hbsag_dt);
	}
	/**
	 * 首次乙肝发病时间
	 * @return FDate
	 */
	public FDate getDt_first() {
		return ((FDate) getAttrVal("Dt_first"));
	}	
	/**
	 * 首次乙肝发病时间
	 * @param Dt_first
	 */
	public void setDt_first(FDate Dt_first) {
		setAttrVal("Dt_first", Dt_first);
	}
	/**
	 * 本次ALT
	 * @return String
	 */
	public String getAlt() {
		return ((String) getAttrVal("Alt"));
	}	
	/**
	 * 本次ALT
	 * @param Alt
	 */
	public void setAlt(String Alt) {
		setAttrVal("Alt", Alt);
	}
	/**
	 * 抗-HBc IgM1:1000检测结果
	 * @return String
	 */
	public String getId_hbc_igm1() {
		return ((String) getAttrVal("Id_hbc_igm1"));
	}	
	/**
	 * 抗-HBc IgM1:1000检测结果
	 * @param Id_hbc_igm1
	 */
	public void setId_hbc_igm1(String Id_hbc_igm1) {
		setAttrVal("Id_hbc_igm1", Id_hbc_igm1);
	}
	/**
	 * 抗-HBc IgM1:1000检测结果code
	 * @return String
	 */
	public String getCode_hbc_igm1() {
		return ((String) getAttrVal("Code_hbc_igm1"));
	}	
	/**
	 * 抗-HBc IgM1:1000检测结果code
	 * @param Code_hbc_igm1
	 */
	public void setCode_hbc_igm1(String Code_hbc_igm1) {
		setAttrVal("Code_hbc_igm1", Code_hbc_igm1);
	}
	/**
	 * 抗-HBc IgM1:1000检测结果name
	 * @return String
	 */
	public String getName_hbc_igm1() {
		return ((String) getAttrVal("Name_hbc_igm1"));
	}	
	/**
	 * 抗-HBc IgM1:1000检测结果name
	 * @param Name_hbc_igm1
	 */
	public void setName_hbc_igm1(String Name_hbc_igm1) {
		setAttrVal("Name_hbc_igm1", Name_hbc_igm1);
	}
	/**
	 * 肝穿刺检测结果
	 * @return String
	 */
	public String getId_liver_puncture_results() {
		return ((String) getAttrVal("Id_liver_puncture_results"));
	}	
	/**
	 * 肝穿刺检测结果
	 * @param Id_liver_puncture_results
	 */
	public void setId_liver_puncture_results(String Id_liver_puncture_results) {
		setAttrVal("Id_liver_puncture_results", Id_liver_puncture_results);
	}
	/**
	 * 肝穿刺检测结果code
	 * @return String
	 */
	public String getCode_liver_puncture_results() {
		return ((String) getAttrVal("Code_liver_puncture_results"));
	}	
	/**
	 * 肝穿刺检测结果code
	 * @param Code_liver_puncture_results
	 */
	public void setCode_liver_puncture_results(String Code_liver_puncture_results) {
		setAttrVal("Code_liver_puncture_results", Code_liver_puncture_results);
	}
	/**
	 * 肝穿刺检测结果name
	 * @return String
	 */
	public String getName_liver_puncture_results() {
		return ((String) getAttrVal("Name_liver_puncture_results"));
	}	
	/**
	 * 肝穿刺检测结果name
	 * @param Name_liver_puncture_results
	 */
	public void setName_liver_puncture_results(String Name_liver_puncture_results) {
		setAttrVal("Name_liver_puncture_results", Name_liver_puncture_results);
	}
	/**
	 * 恢复期血清HBsAg阴转
	 * @return String
	 */
	public String getId_hbsag_huifu() {
		return ((String) getAttrVal("Id_hbsag_huifu"));
	}	
	/**
	 * 恢复期血清HBsAg阴转
	 * @param Id_hbsag_huifu
	 */
	public void setId_hbsag_huifu(String Id_hbsag_huifu) {
		setAttrVal("Id_hbsag_huifu", Id_hbsag_huifu);
	}
	/**
	 * 恢复期血清HBsAg阴转code
	 * @return String
	 */
	public String getCode_hbsag_huifu() {
		return ((String) getAttrVal("Code_hbsag_huifu"));
	}	
	/**
	 * 恢复期血清HBsAg阴转code
	 * @param Code_hbsag_huifu
	 */
	public void setCode_hbsag_huifu(String Code_hbsag_huifu) {
		setAttrVal("Code_hbsag_huifu", Code_hbsag_huifu);
	}
	/**
	 * 恢复期血清HBsAg阴转name
	 * @return String
	 */
	public String getName_hbsag_huifu() {
		return ((String) getAttrVal("Name_hbsag_huifu"));
	}	
	/**
	 * 恢复期血清HBsAg阴转name
	 * @param Name_hbsag_huifu
	 */
	public void setName_hbsag_huifu(String Name_hbsag_huifu) {
		setAttrVal("Name_hbsag_huifu", Name_hbsag_huifu);
	}
	/**
	 * 是否知道首次发病时间
	 * @return FBoolean
	 */
	public FBoolean getIs_know() {
		return ((FBoolean) getAttrVal("Is_know"));
	}	
	/**
	 * 是否知道首次发病时间
	 * @param Is_know
	 */
	public void setIs_know(FBoolean Is_know) {
		setAttrVal("Is_know", Is_know);
	}
	/**
	 * 卡片编号
	 * @return String
	 */
	public String getCard_no() {
		return ((String) getAttrVal("Card_no"));
	}	
	/**
	 * 卡片编号
	 * @param Card_no
	 */
	public void setCard_no(String Card_no) {
		setAttrVal("Card_no", Card_no);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 家长姓名
	 * @return String
	 */
	public String getParent_name() {
		return ((String) getAttrVal("Parent_name"));
	}	
	/**
	 * 家长姓名
	 * @param Parent_name
	 */
	public void setParent_name(String Parent_name) {
		setAttrVal("Parent_name", Parent_name);
	}
	/**
	 * 户籍地址
	 * @return String
	 */
	public String getHjdz() {
		return ((String) getAttrVal("Hjdz"));
	}	
	/**
	 * 户籍地址
	 * @param Hjdz
	 */
	public void setHjdz(String Hjdz) {
		setAttrVal("Hjdz", Hjdz);
	}
	/**
	 * 户籍地址编码
	 * @return String
	 */
	public String getCode_hjdz() {
		return ((String) getAttrVal("Code_hjdz"));
	}	
	/**
	 * 户籍地址编码
	 * @param Code_hjdz
	 */
	public void setCode_hjdz(String Code_hjdz) {
		setAttrVal("Code_hjdz", Code_hjdz);
	}
	/**
	 * 户籍地址名称
	 * @return String
	 */
	public String getName_hjdz() {
		return ((String) getAttrVal("Name_hjdz"));
	}	
	/**
	 * 户籍地址名称
	 * @param Name_hjdz
	 */
	public void setName_hjdz(String Name_hjdz) {
		setAttrVal("Name_hjdz", Name_hjdz);
	}
	/**
	 * 乡镇
	 * @return String
	 */
	public String getTown() {
		return ((String) getAttrVal("Town"));
	}	
	/**
	 * 乡镇
	 * @param Town
	 */
	public void setTown(String Town) {
		setAttrVal("Town", Town);
	}
	/**
	 * 村
	 * @return String
	 */
	public String getVallege() {
		return ((String) getAttrVal("Vallege"));
	}	
	/**
	 * 村
	 * @param Vallege
	 */
	public void setVallege(String Vallege) {
		setAttrVal("Vallege", Vallege);
	}
	/**
	 * 门牌号
	 * @return String
	 */
	public String getHouse_no() {
		return ((String) getAttrVal("House_no"));
	}	
	/**
	 * 门牌号
	 * @param House_no
	 */
	public void setHouse_no(String House_no) {
		setAttrVal("House_no", House_no);
	}
	/**
	 * 报卡医生
	 * @return String
	 */
	public String getRept_doctor() {
		return ((String) getAttrVal("Rept_doctor"));
	}	
	/**
	 * 报卡医生
	 * @param Rept_doctor
	 */
	public void setRept_doctor(String Rept_doctor) {
		setAttrVal("Rept_doctor", Rept_doctor);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getRelation_way() {
		return ((String) getAttrVal("Relation_way"));
	}	
	/**
	 * 联系电话
	 * @param Relation_way
	 */
	public void setRelation_way(String Relation_way) {
		setAttrVal("Relation_way", Relation_way);
	}
	/**
	 * 报卡医生编码
	 * @return String
	 */
	public String getCode_rept_doctor() {
		return ((String) getAttrVal("Code_rept_doctor"));
	}	
	/**
	 * 报卡医生编码
	 * @param Code_rept_doctor
	 */
	public void setCode_rept_doctor(String Code_rept_doctor) {
		setAttrVal("Code_rept_doctor", Code_rept_doctor);
	}
	/**
	 * 报卡医生名字
	 * @return String
	 */
	public String getName_rept_doctor() {
		return ((String) getAttrVal("Name_rept_doctor"));
	}	
	/**
	 * 报卡医生名字
	 * @param Name_rept_doctor
	 */
	public void setName_rept_doctor(String Name_rept_doctor) {
		setAttrVal("Name_rept_doctor", Name_rept_doctor);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHbsag_dt_code() {
		return ((String) getAttrVal("Hbsag_dt_code"));
	}	
	/**
	 * 编码
	 * @param Hbsag_dt_code
	 */
	public void setHbsag_dt_code(String Hbsag_dt_code) {
		setAttrVal("Hbsag_dt_code", Hbsag_dt_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHbsag_dt_name() {
		return ((String) getAttrVal("Hbsag_dt_name"));
	}	
	/**
	 * 名称
	 * @param Hbsag_dt_name
	 */
	public void setHbsag_dt_name(String Hbsag_dt_name) {
		setAttrVal("Hbsag_dt_name", Hbsag_dt_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHbc_igm_code() {
		return ((String) getAttrVal("Hbc_igm_code"));
	}	
	/**
	 * 编码
	 * @param Hbc_igm_code
	 */
	public void setHbc_igm_code(String Hbc_igm_code) {
		setAttrVal("Hbc_igm_code", Hbc_igm_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHbc_igm_name() {
		return ((String) getAttrVal("Hbc_igm_name"));
	}	
	/**
	 * 名称
	 * @param Hbc_igm_name
	 */
	public void setHbc_igm_name(String Hbc_igm_name) {
		setAttrVal("Hbc_igm_name", Hbc_igm_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getLiver_puncture_results_code() {
		return ((String) getAttrVal("Liver_puncture_results_code"));
	}	
	/**
	 * 编码
	 * @param Liver_puncture_results_code
	 */
	public void setLiver_puncture_results_code(String Liver_puncture_results_code) {
		setAttrVal("Liver_puncture_results_code", Liver_puncture_results_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getLiver_puncture_results_name() {
		return ((String) getAttrVal("Liver_puncture_results_name"));
	}	
	/**
	 * 名称
	 * @param Liver_puncture_results_name
	 */
	public void setLiver_puncture_results_name(String Liver_puncture_results_name) {
		setAttrVal("Liver_puncture_results_name", Liver_puncture_results_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHbsag_huifu_code() {
		return ((String) getAttrVal("Hbsag_huifu_code"));
	}	
	/**
	 * 编码
	 * @param Hbsag_huifu_code
	 */
	public void setHbsag_huifu_code(String Hbsag_huifu_code) {
		setAttrVal("Hbsag_huifu_code", Hbsag_huifu_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHbsag_huifu_name() {
		return ((String) getAttrVal("Hbsag_huifu_name"));
	}	
	/**
	 * 名称
	 * @param Hbsag_huifu_name
	 */
	public void setHbsag_huifu_name(String Hbsag_huifu_name) {
		setAttrVal("Hbsag_huifu_name", Hbsag_huifu_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getAreacode() {
		return ((String) getAttrVal("Areacode"));
	}	
	/**
	 * 编码
	 * @param Areacode
	 */
	public void setAreacode(String Areacode) {
		setAttrVal("Areacode", Areacode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAreaname() {
		return ((String) getAttrVal("Areaname"));
	}	
	/**
	 * 名称
	 * @param Areaname
	 */
	public void setAreaname(String Areaname) {
		setAttrVal("Areaname", Areaname);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getDoctorcode() {
		return ((String) getAttrVal("Doctorcode"));
	}	
	/**
	 * 人员编码
	 * @param Doctorcode
	 */
	public void setDoctorcode(String Doctorcode) {
		setAttrVal("Doctorcode", Doctorcode);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getDoctorname() {
		return ((String) getAttrVal("Doctorname"));
	}	
	/**
	 * 姓名
	 * @param Doctorname
	 */
	public void setDoctorname(String Doctorname) {
		setAttrVal("Doctorname", Doctorname);
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
		return "Id_contagion_hb";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_CARD_HB";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HepatitisBDODesc.class);
	}
	
}