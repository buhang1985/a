package iih.hp.cp.eletpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.eletpl.d.desc.HpCpElemStageTplDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_计划阶段_模板 DO数据 
 * 
 */
public class HpCpElemStageTplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ELE_STAGE_TPL= "Id_ele_stage_tpl";
	public static final String ID_ELE_TPL= "Id_ele_tpl";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String SERIALNO= "Serialno";
	public static final String FG_SUGERY_DAY= "Fg_sugery_day";
	public static final String EU_RELATIVETP= "Eu_relativetp";
	public static final String RELATIVEMIN= "Relativemin";
	public static final String RELATIVEMAX= "Relativemax";
	public static final String ID_TRANSCRITERION= "Id_transcriterion";
	public static final String EU_NORMTRANSTGTTP= "Eu_normtranstgttp";
	public static final String NORMTRANSTGT= "Normtranstgt";
	public static final String EU_ABERTRANSTGTTP= "Eu_abertranstgttp";
	public static final String ABERTRANSTGT= "Abertranstgt";
	public static final String FG_NEEDNURSIGN= "Fg_neednursign";
	public static final String FG_NEEDDOCTSIGN= "Fg_needdoctsign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ele_stage_tpl() {
		return ((String) getAttrVal("Id_ele_stage_tpl"));
	}	
	public void setId_ele_stage_tpl(String Id_ele_stage_tpl) {
		setAttrVal("Id_ele_stage_tpl", Id_ele_stage_tpl);
	}
	public String getId_ele_tpl() {
		return ((String) getAttrVal("Id_ele_tpl"));
	}	
	public void setId_ele_tpl(String Id_ele_tpl) {
		setAttrVal("Id_ele_tpl", Id_ele_tpl);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public Integer getSerialno() {
		return ((Integer) getAttrVal("Serialno"));
	}	
	public void setSerialno(Integer Serialno) {
		setAttrVal("Serialno", Serialno);
	}
	public FBoolean getFg_sugery_day() {
		return ((FBoolean) getAttrVal("Fg_sugery_day"));
	}	
	public void setFg_sugery_day(FBoolean Fg_sugery_day) {
		setAttrVal("Fg_sugery_day", Fg_sugery_day);
	}
	public Integer getEu_relativetp() {
		return ((Integer) getAttrVal("Eu_relativetp"));
	}	
	public void setEu_relativetp(Integer Eu_relativetp) {
		setAttrVal("Eu_relativetp", Eu_relativetp);
	}
	public Integer getRelativemin() {
		return ((Integer) getAttrVal("Relativemin"));
	}	
	public void setRelativemin(Integer Relativemin) {
		setAttrVal("Relativemin", Relativemin);
	}
	public Integer getRelativemax() {
		return ((Integer) getAttrVal("Relativemax"));
	}	
	public void setRelativemax(Integer Relativemax) {
		setAttrVal("Relativemax", Relativemax);
	}
	public String getId_transcriterion() {
		return ((String) getAttrVal("Id_transcriterion"));
	}	
	public void setId_transcriterion(String Id_transcriterion) {
		setAttrVal("Id_transcriterion", Id_transcriterion);
	}
	public Integer getEu_normtranstgttp() {
		return ((Integer) getAttrVal("Eu_normtranstgttp"));
	}	
	public void setEu_normtranstgttp(Integer Eu_normtranstgttp) {
		setAttrVal("Eu_normtranstgttp", Eu_normtranstgttp);
	}
	public String getNormtranstgt() {
		return ((String) getAttrVal("Normtranstgt"));
	}	
	public void setNormtranstgt(String Normtranstgt) {
		setAttrVal("Normtranstgt", Normtranstgt);
	}
	public Integer getEu_abertranstgttp() {
		return ((Integer) getAttrVal("Eu_abertranstgttp"));
	}	
	public void setEu_abertranstgttp(Integer Eu_abertranstgttp) {
		setAttrVal("Eu_abertranstgttp", Eu_abertranstgttp);
	}
	public String getAbertranstgt() {
		return ((String) getAttrVal("Abertranstgt"));
	}	
	public void setAbertranstgt(String Abertranstgt) {
		setAttrVal("Abertranstgt", Abertranstgt);
	}
	public FBoolean getFg_neednursign() {
		return ((FBoolean) getAttrVal("Fg_neednursign"));
	}	
	public void setFg_neednursign(FBoolean Fg_neednursign) {
		setAttrVal("Fg_neednursign", Fg_neednursign);
	}
	public FBoolean getFg_needdoctsign() {
		return ((FBoolean) getAttrVal("Fg_needdoctsign"));
	}	
	public void setFg_needdoctsign(FBoolean Fg_needdoctsign) {
		setAttrVal("Fg_needdoctsign", Fg_needdoctsign);
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
		return "Id_ele_stage_tpl";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_STAGE_TPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemStageTplDODesc.class);
	}
	
}