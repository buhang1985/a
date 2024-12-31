package iih.hp.cp.ele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.ele.d.desc.HpCpElemStageDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_计划阶段 DO数据 
 * 
 */
public class HpCpElemStageDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//计划阶段ID
	public static final String ID_ELE_STAGE= "Id_ele_stage";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//序号
	public static final String SERIALNO= "Serialno";
	//是否手术日
	public static final String FG_SUGERY_DAY= "Fg_sugery_day";
	//相对时间类型
	public static final String EU_RELATIVETP= "Eu_relativetp";
	//相对时间数值下限
	public static final String RELATIVEMIN= "Relativemin";
	//相对时间数值上限
	public static final String RELATIVEMAX= "Relativemax";
	//相对时间单位
	public static final String EU_RELATIVE_UNITS= "Eu_relative_units";
	//转移逻辑ID
	public static final String ID_ELE_TRANSCRITERION= "Id_ele_transcriterion";
	//正常转移目标类型
	public static final String EU_NORMTRANSTGTTP= "Eu_normtranstgttp";
	//正常转移目标
	public static final String NORMTRANSTGT= "Normtranstgt";
	//变异转移目标类型
	public static final String EU_ABERTRANSTGTTP= "Eu_abertranstgttp";
	//变异转移目标
	public static final String ABERTRANSTGT= "Abertranstgt";
	//是否需要护士签名
	public static final String FG_NEEDNURSIGN= "Fg_neednursign";
	//是否需要医师签名
	public static final String FG_NEEDDOCTSIGN= "Fg_needdoctsign";
	//计划阶段名称
	public static final String STAGE_NAME= "Stage_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 计划阶段ID
	 * @return String
	 */
	public String getId_ele_stage() {
		return ((String) getAttrVal("Id_ele_stage"));
	}	
	/**
	 * 计划阶段ID
	 * @param Id_ele_stage
	 */
	public void setId_ele_stage(String Id_ele_stage) {
		setAttrVal("Id_ele_stage", Id_ele_stage);
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
	 * 序号
	 * @return Integer
	 */
	public Integer getSerialno() {
		return ((Integer) getAttrVal("Serialno"));
	}	
	/**
	 * 序号
	 * @param Serialno
	 */
	public void setSerialno(Integer Serialno) {
		setAttrVal("Serialno", Serialno);
	}
	/**
	 * 是否手术日
	 * @return FBoolean
	 */
	public FBoolean getFg_sugery_day() {
		return ((FBoolean) getAttrVal("Fg_sugery_day"));
	}	
	/**
	 * 是否手术日
	 * @param Fg_sugery_day
	 */
	public void setFg_sugery_day(FBoolean Fg_sugery_day) {
		setAttrVal("Fg_sugery_day", Fg_sugery_day);
	}
	/**
	 * 相对时间类型
	 * @return Integer
	 */
	public Integer getEu_relativetp() {
		return ((Integer) getAttrVal("Eu_relativetp"));
	}	
	/**
	 * 相对时间类型
	 * @param Eu_relativetp
	 */
	public void setEu_relativetp(Integer Eu_relativetp) {
		setAttrVal("Eu_relativetp", Eu_relativetp);
	}
	/**
	 * 相对时间数值下限
	 * @return Integer
	 */
	public Integer getRelativemin() {
		return ((Integer) getAttrVal("Relativemin"));
	}	
	/**
	 * 相对时间数值下限
	 * @param Relativemin
	 */
	public void setRelativemin(Integer Relativemin) {
		setAttrVal("Relativemin", Relativemin);
	}
	/**
	 * 相对时间数值上限
	 * @return Integer
	 */
	public Integer getRelativemax() {
		return ((Integer) getAttrVal("Relativemax"));
	}	
	/**
	 * 相对时间数值上限
	 * @param Relativemax
	 */
	public void setRelativemax(Integer Relativemax) {
		setAttrVal("Relativemax", Relativemax);
	}
	/**
	 * 相对时间单位
	 * @return Integer
	 */
	public Integer getEu_relative_units() {
		return ((Integer) getAttrVal("Eu_relative_units"));
	}	
	/**
	 * 相对时间单位
	 * @param Eu_relative_units
	 */
	public void setEu_relative_units(Integer Eu_relative_units) {
		setAttrVal("Eu_relative_units", Eu_relative_units);
	}
	/**
	 * 转移逻辑ID
	 * @return String
	 */
	public String getId_ele_transcriterion() {
		return ((String) getAttrVal("Id_ele_transcriterion"));
	}	
	/**
	 * 转移逻辑ID
	 * @param Id_ele_transcriterion
	 */
	public void setId_ele_transcriterion(String Id_ele_transcriterion) {
		setAttrVal("Id_ele_transcriterion", Id_ele_transcriterion);
	}
	/**
	 * 正常转移目标类型
	 * @return Integer
	 */
	public Integer getEu_normtranstgttp() {
		return ((Integer) getAttrVal("Eu_normtranstgttp"));
	}	
	/**
	 * 正常转移目标类型
	 * @param Eu_normtranstgttp
	 */
	public void setEu_normtranstgttp(Integer Eu_normtranstgttp) {
		setAttrVal("Eu_normtranstgttp", Eu_normtranstgttp);
	}
	/**
	 * 正常转移目标
	 * @return String
	 */
	public String getNormtranstgt() {
		return ((String) getAttrVal("Normtranstgt"));
	}	
	/**
	 * 正常转移目标
	 * @param Normtranstgt
	 */
	public void setNormtranstgt(String Normtranstgt) {
		setAttrVal("Normtranstgt", Normtranstgt);
	}
	/**
	 * 变异转移目标类型
	 * @return Integer
	 */
	public Integer getEu_abertranstgttp() {
		return ((Integer) getAttrVal("Eu_abertranstgttp"));
	}	
	/**
	 * 变异转移目标类型
	 * @param Eu_abertranstgttp
	 */
	public void setEu_abertranstgttp(Integer Eu_abertranstgttp) {
		setAttrVal("Eu_abertranstgttp", Eu_abertranstgttp);
	}
	/**
	 * 变异转移目标
	 * @return String
	 */
	public String getAbertranstgt() {
		return ((String) getAttrVal("Abertranstgt"));
	}	
	/**
	 * 变异转移目标
	 * @param Abertranstgt
	 */
	public void setAbertranstgt(String Abertranstgt) {
		setAttrVal("Abertranstgt", Abertranstgt);
	}
	/**
	 * 是否需要护士签名
	 * @return FBoolean
	 */
	public FBoolean getFg_neednursign() {
		return ((FBoolean) getAttrVal("Fg_neednursign"));
	}	
	/**
	 * 是否需要护士签名
	 * @param Fg_neednursign
	 */
	public void setFg_neednursign(FBoolean Fg_neednursign) {
		setAttrVal("Fg_neednursign", Fg_neednursign);
	}
	/**
	 * 是否需要医师签名
	 * @return FBoolean
	 */
	public FBoolean getFg_needdoctsign() {
		return ((FBoolean) getAttrVal("Fg_needdoctsign"));
	}	
	/**
	 * 是否需要医师签名
	 * @param Fg_needdoctsign
	 */
	public void setFg_needdoctsign(FBoolean Fg_needdoctsign) {
		setAttrVal("Fg_needdoctsign", Fg_needdoctsign);
	}
	/**
	 * 计划阶段名称
	 * @return String
	 */
	public String getStage_name() {
		return ((String) getAttrVal("Stage_name"));
	}	
	/**
	 * 计划阶段名称
	 * @param Stage_name
	 */
	public void setStage_name(String Stage_name) {
		setAttrVal("Stage_name", Stage_name);
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
		return "Id_ele_stage";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_STAGE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemStageDODesc.class);
	}
	
}