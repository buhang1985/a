package iih.ci.mrqc.cimrrecallrecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.cimrrecallrecord.d.desc.CiMrRecallRecordDODesc;
import java.math.BigDecimal;

/**
 * 病历召回记录 DO数据 
 * 
 */
public class CiMrRecallRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MR_RCRE= "Id_mr_rcre";
	public static final String ID_MR_RECALL= "Id_mr_recall";
	public static final String ID_MR= "Id_mr";
	public static final String NAME_MR= "Name_mr";
	public static final String FG_UP= "Fg_up";
	public static final String FG_DE= "Fg_de";
	public static final String FG_OP= "Fg_op";
	public static final String DT_SUBMIT= "Dt_submit";
	public static final String NAME_DOC= "Name_doc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mr_rcre() {
		return ((String) getAttrVal("Id_mr_rcre"));
	}	
	public void setId_mr_rcre(String Id_mr_rcre) {
		setAttrVal("Id_mr_rcre", Id_mr_rcre);
	}
	public String getId_mr_recall() {
		return ((String) getAttrVal("Id_mr_recall"));
	}	
	public void setId_mr_recall(String Id_mr_recall) {
		setAttrVal("Id_mr_recall", Id_mr_recall);
	}
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	public String getName_mr() {
		return ((String) getAttrVal("Name_mr"));
	}	
	public void setName_mr(String Name_mr) {
		setAttrVal("Name_mr", Name_mr);
	}
	public FBoolean getFg_up() {
		return ((FBoolean) getAttrVal("Fg_up"));
	}	
	public void setFg_up(FBoolean Fg_up) {
		setAttrVal("Fg_up", Fg_up);
	}
	public FBoolean getFg_de() {
		return ((FBoolean) getAttrVal("Fg_de"));
	}	
	public void setFg_de(FBoolean Fg_de) {
		setAttrVal("Fg_de", Fg_de);
	}
	public FBoolean getFg_op() {
		return ((FBoolean) getAttrVal("Fg_op"));
	}	
	public void setFg_op(FBoolean Fg_op) {
		setAttrVal("Fg_op", Fg_op);
	}
	public FDateTime getDt_submit() {
		return ((FDateTime) getAttrVal("Dt_submit"));
	}	
	public void setDt_submit(FDateTime Dt_submit) {
		setAttrVal("Dt_submit", Dt_submit);
	}
	public String getName_doc() {
		return ((String) getAttrVal("Name_doc"));
	}	
	public void setName_doc(String Name_doc) {
		setAttrVal("Name_doc", Name_doc);
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
		return "Id_mr_rcre";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_rcre";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrRecallRecordDODesc.class);
	}
	
}