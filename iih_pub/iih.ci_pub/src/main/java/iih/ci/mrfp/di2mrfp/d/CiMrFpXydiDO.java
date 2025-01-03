package iih.ci.mrfp.di2mrfp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrfp.di2mrfp.d.desc.CiMrFpXydiDODesc;
import java.math.BigDecimal;

/**
 * 住院病历首页 西医诊断 DO数据 
 * 
 */
public class CiMrFpXydiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//住院病历首页西医诊断ID
	public static final String ID_MRFPXYDI= "Id_mrfpxydi";
	//序号
	public static final String SORTNO= "Sortno";
	//疾病诊断
	public static final String ID_DI= "Id_di";
	//疾病诊断编码
	public static final String SD_DI= "Sd_di";
	//疾病诊断名称
	public static final String NAME_DI= "Name_di";
	//入院病情
	public static final String ID_DISLVL_INP= "Id_dislvl_inp";
	//入院情况名称
	public static final String NAME_DISLVL_INP= "Name_dislvl_inp";
	//诊断类别
	public static final String ID_DI_TYPE= "Id_di_type";
	//诊断类型编码
	public static final String SD_DI_TYPE= "Sd_di_type";
	//诊断类型名称
	public static final String NAME_DI_TYPE= "Name_di_type";
	//诊断信息
	public static final String ID_MRFPDI= "Id_mrfpdi";
	//主诊断
	public static final String FG_MAINDI= "Fg_maindi";
	//治疗转归
	public static final String ID_TREATMENT_OUTCOME= "Id_treatment_outcome";
	//治疗转归名称
	public static final String NAME_TREATMENT_OUTCOME= "Name_treatment_outcome";
	//治疗转归编码
	public static final String SD_TREATMENT_OUTCOME= "Sd_treatment_outcome";
	//医保诊断对照
	public static final String ID_HPDI= "Id_hpdi";
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
	//诊断补充描述
	public static final String DIAG_SUPP= "Diag_supp";
	//诊断编码
	public static final String SD_DI_CODE= "Sd_di_code";
	//诊断名称
	public static final String DI_NAME= "Di_name";
	//编码
	public static final String DI_TYPE_CODE= "Di_type_code";
	//名称
	public static final String DI_TYPE_NAME= "Di_type_name";
	//疾病名称
	public static final String NAME_HPDI= "Name_hpdi";
	//疾病编码
	public static final String CODE_HPDI= "Code_hpdi";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 住院病历首页西医诊断ID
	 * @return String
	 */
	public String getId_mrfpxydi() {
		return ((String) getAttrVal("Id_mrfpxydi"));
	}	
	/**
	 * 住院病历首页西医诊断ID
	 * @param Id_mrfpxydi
	 */
	public void setId_mrfpxydi(String Id_mrfpxydi) {
		setAttrVal("Id_mrfpxydi", Id_mrfpxydi);
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
	 * 疾病诊断
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	/**
	 * 疾病诊断
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 疾病诊断编码
	 * @return String
	 */
	public String getSd_di() {
		return ((String) getAttrVal("Sd_di"));
	}	
	/**
	 * 疾病诊断编码
	 * @param Sd_di
	 */
	public void setSd_di(String Sd_di) {
		setAttrVal("Sd_di", Sd_di);
	}
	/**
	 * 疾病诊断名称
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	/**
	 * 疾病诊断名称
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 入院病情
	 * @return Integer
	 */
	public Integer getId_dislvl_inp() {
		return ((Integer) getAttrVal("Id_dislvl_inp"));
	}	
	/**
	 * 入院病情
	 * @param Id_dislvl_inp
	 */
	public void setId_dislvl_inp(Integer Id_dislvl_inp) {
		setAttrVal("Id_dislvl_inp", Id_dislvl_inp);
	}
	/**
	 * 入院情况名称
	 * @return String
	 */
	public String getName_dislvl_inp() {
		return ((String) getAttrVal("Name_dislvl_inp"));
	}	
	/**
	 * 入院情况名称
	 * @param Name_dislvl_inp
	 */
	public void setName_dislvl_inp(String Name_dislvl_inp) {
		setAttrVal("Name_dislvl_inp", Name_dislvl_inp);
	}
	/**
	 * 诊断类别
	 * @return String
	 */
	public String getId_di_type() {
		return ((String) getAttrVal("Id_di_type"));
	}	
	/**
	 * 诊断类别
	 * @param Id_di_type
	 */
	public void setId_di_type(String Id_di_type) {
		setAttrVal("Id_di_type", Id_di_type);
	}
	/**
	 * 诊断类型编码
	 * @return String
	 */
	public String getSd_di_type() {
		return ((String) getAttrVal("Sd_di_type"));
	}	
	/**
	 * 诊断类型编码
	 * @param Sd_di_type
	 */
	public void setSd_di_type(String Sd_di_type) {
		setAttrVal("Sd_di_type", Sd_di_type);
	}
	/**
	 * 诊断类型名称
	 * @return String
	 */
	public String getName_di_type() {
		return ((String) getAttrVal("Name_di_type"));
	}	
	/**
	 * 诊断类型名称
	 * @param Name_di_type
	 */
	public void setName_di_type(String Name_di_type) {
		setAttrVal("Name_di_type", Name_di_type);
	}
	/**
	 * 诊断信息
	 * @return String
	 */
	public String getId_mrfpdi() {
		return ((String) getAttrVal("Id_mrfpdi"));
	}	
	/**
	 * 诊断信息
	 * @param Id_mrfpdi
	 */
	public void setId_mrfpdi(String Id_mrfpdi) {
		setAttrVal("Id_mrfpdi", Id_mrfpdi);
	}
	/**
	 * 主诊断
	 * @return FBoolean
	 */
	public FBoolean getFg_maindi() {
		return ((FBoolean) getAttrVal("Fg_maindi"));
	}	
	/**
	 * 主诊断
	 * @param Fg_maindi
	 */
	public void setFg_maindi(FBoolean Fg_maindi) {
		setAttrVal("Fg_maindi", Fg_maindi);
	}
	/**
	 * 治疗转归
	 * @return String
	 */
	public String getId_treatment_outcome() {
		return ((String) getAttrVal("Id_treatment_outcome"));
	}	
	/**
	 * 治疗转归
	 * @param Id_treatment_outcome
	 */
	public void setId_treatment_outcome(String Id_treatment_outcome) {
		setAttrVal("Id_treatment_outcome", Id_treatment_outcome);
	}
	/**
	 * 治疗转归名称
	 * @return String
	 */
	public String getName_treatment_outcome() {
		return ((String) getAttrVal("Name_treatment_outcome"));
	}	
	/**
	 * 治疗转归名称
	 * @param Name_treatment_outcome
	 */
	public void setName_treatment_outcome(String Name_treatment_outcome) {
		setAttrVal("Name_treatment_outcome", Name_treatment_outcome);
	}
	/**
	 * 治疗转归编码
	 * @return String
	 */
	public String getSd_treatment_outcome() {
		return ((String) getAttrVal("Sd_treatment_outcome"));
	}	
	/**
	 * 治疗转归编码
	 * @param Sd_treatment_outcome
	 */
	public void setSd_treatment_outcome(String Sd_treatment_outcome) {
		setAttrVal("Sd_treatment_outcome", Sd_treatment_outcome);
	}
	/**
	 * 医保诊断对照
	 * @return String
	 */
	public String getId_hpdi() {
		return ((String) getAttrVal("Id_hpdi"));
	}	
	/**
	 * 医保诊断对照
	 * @param Id_hpdi
	 */
	public void setId_hpdi(String Id_hpdi) {
		setAttrVal("Id_hpdi", Id_hpdi);
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
	 * 诊断补充描述
	 * @return String
	 */
	public String getDiag_supp() {
		return ((String) getAttrVal("Diag_supp"));
	}	
	/**
	 * 诊断补充描述
	 * @param Diag_supp
	 */
	public void setDiag_supp(String Diag_supp) {
		setAttrVal("Diag_supp", Diag_supp);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getSd_di_code() {
		return ((String) getAttrVal("Sd_di_code"));
	}	
	/**
	 * 诊断编码
	 * @param Sd_di_code
	 */
	public void setSd_di_code(String Sd_di_code) {
		setAttrVal("Sd_di_code", Sd_di_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDi_name() {
		return ((String) getAttrVal("Di_name"));
	}	
	/**
	 * 诊断名称
	 * @param Di_name
	 */
	public void setDi_name(String Di_name) {
		setAttrVal("Di_name", Di_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDi_type_code() {
		return ((String) getAttrVal("Di_type_code"));
	}	
	/**
	 * 编码
	 * @param Di_type_code
	 */
	public void setDi_type_code(String Di_type_code) {
		setAttrVal("Di_type_code", Di_type_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDi_type_name() {
		return ((String) getAttrVal("Di_type_name"));
	}	
	/**
	 * 名称
	 * @param Di_type_name
	 */
	public void setDi_type_name(String Di_type_name) {
		setAttrVal("Di_type_name", Di_type_name);
	}
	/**
	 * 疾病名称
	 * @return String
	 */
	public String getName_hpdi() {
		return ((String) getAttrVal("Name_hpdi"));
	}	
	/**
	 * 疾病名称
	 * @param Name_hpdi
	 */
	public void setName_hpdi(String Name_hpdi) {
		setAttrVal("Name_hpdi", Name_hpdi);
	}
	/**
	 * 疾病编码
	 * @return String
	 */
	public String getCode_hpdi() {
		return ((String) getAttrVal("Code_hpdi"));
	}	
	/**
	 * 疾病编码
	 * @param Code_hpdi
	 */
	public void setCode_hpdi(String Code_hpdi) {
		setAttrVal("Code_hpdi", Code_hpdi);
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
		return "Id_mrfpxydi";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_FP_XYDI";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrFpXydiDODesc.class);
	}
	
}