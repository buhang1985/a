package iih.bl.st.blhperror.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.st.blhperror.d.desc.BlHpErrorDODesc;
import java.math.BigDecimal;

/**
 * 医保异常交易记录 DO数据 
 * 
 */
public class BlHpErrorDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPERROR= "Id_hperror";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_HP= "Id_hp";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_STOEP= "Id_stoep";
	public static final String ID_RELATION= "Id_relation";
	public static final String CODE_HP= "Code_hp";
	public static final String FG_ROLLBACK= "Fg_rollback";
	public static final String DT_TRADE= "Dt_trade";
	public static final String EU_DIRECT= "Eu_direct";
	public static final String EU_SRCTP= "Eu_srctp";
	public static final String INCNO= "Incno";
	public static final String INPUTINFO= "Inputinfo";
	public static final String OUTINFO= "Outinfo";
	public static final String RECODE_HP= "Recode_hp";
	public static final String REINCNO= "Reincno";
	public static final String REINPUTINFO= "Reinputinfo";
	public static final String REOUTPUTINFO= "Reoutputinfo";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hperror() {
		return ((String) getAttrVal("Id_hperror"));
	}	
	public void setId_hperror(String Id_hperror) {
		setAttrVal("Id_hperror", Id_hperror);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}	
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
	}
	public String getId_relation() {
		return ((String) getAttrVal("Id_relation"));
	}	
	public void setId_relation(String Id_relation) {
		setAttrVal("Id_relation", Id_relation);
	}
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	public FBoolean getFg_rollback() {
		return ((FBoolean) getAttrVal("Fg_rollback"));
	}	
	public void setFg_rollback(FBoolean Fg_rollback) {
		setAttrVal("Fg_rollback", Fg_rollback);
	}
	public FDateTime getDt_trade() {
		return ((FDateTime) getAttrVal("Dt_trade"));
	}	
	public void setDt_trade(FDateTime Dt_trade) {
		setAttrVal("Dt_trade", Dt_trade);
	}
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	public Integer getEu_srctp() {
		return ((Integer) getAttrVal("Eu_srctp"));
	}	
	public void setEu_srctp(Integer Eu_srctp) {
		setAttrVal("Eu_srctp", Eu_srctp);
	}
	public String getIncno() {
		return ((String) getAttrVal("Incno"));
	}	
	public void setIncno(String Incno) {
		setAttrVal("Incno", Incno);
	}
	public String getInputinfo() {
		return ((String) getAttrVal("Inputinfo"));
	}	
	public void setInputinfo(String Inputinfo) {
		setAttrVal("Inputinfo", Inputinfo);
	}
	public String getOutinfo() {
		return ((String) getAttrVal("Outinfo"));
	}	
	public void setOutinfo(String Outinfo) {
		setAttrVal("Outinfo", Outinfo);
	}
	public String getRecode_hp() {
		return ((String) getAttrVal("Recode_hp"));
	}	
	public void setRecode_hp(String Recode_hp) {
		setAttrVal("Recode_hp", Recode_hp);
	}
	public String getReincno() {
		return ((String) getAttrVal("Reincno"));
	}	
	public void setReincno(String Reincno) {
		setAttrVal("Reincno", Reincno);
	}
	public String getReinputinfo() {
		return ((String) getAttrVal("Reinputinfo"));
	}	
	public void setReinputinfo(String Reinputinfo) {
		setAttrVal("Reinputinfo", Reinputinfo);
	}
	public String getReoutputinfo() {
		return ((String) getAttrVal("Reoutputinfo"));
	}	
	public void setReoutputinfo(String Reoutputinfo) {
		setAttrVal("Reoutputinfo", Reoutputinfo);
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
		return "Id_hperror";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_hp_error";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlHpErrorDODesc.class);
	}
	
}