package iih.en.doc.pregdoc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.doc.pregdoc.d.desc.PregDocStatDODesc;
import java.math.BigDecimal;

/**
 * 产妇状况 DO数据 
 * 
 */
public class PregDocStatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PREGDOCSTAT= "Id_pregdocstat";
	public static final String ID_PREGDOC= "Id_pregdoc";
	public static final String ID_ENTDOC= "Id_entdoc";
	public static final String ID_ENT_LAST_OP= "Id_ent_last_op";
	public static final String ID_ENT_LAST_IP= "Id_ent_last_ip";
	public static final String ID_APT_LAST= "Id_apt_last";
	public static final String FG_HYPERT= "Fg_hypert";
	public static final String FG_DIAB_PREG= "Fg_diab_preg";
	public static final String FG_PREG_DIAB= "Fg_preg_diab";
	public static final String WEIT_DOC= "Weit_doc";
	public static final String FG_HAVE_BORN= "Fg_have_born";
	public static final String WEIT_BORN= "Weit_born";
	public static final String MINS_BORN= "Mins_born";
	public static final String VOL_OUT_BLOOD= "Vol_out_blood";
	public static final String FG_PREMATURE= "Fg_premature";
	public static final String TIMES_PREG= "Times_preg";
	public static final String TIMES_BORN= "Times_born";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pregdocstat() {
		return ((String) getAttrVal("Id_pregdocstat"));
	}	
	public void setId_pregdocstat(String Id_pregdocstat) {
		setAttrVal("Id_pregdocstat", Id_pregdocstat);
	}
	public String getId_pregdoc() {
		return ((String) getAttrVal("Id_pregdoc"));
	}	
	public void setId_pregdoc(String Id_pregdoc) {
		setAttrVal("Id_pregdoc", Id_pregdoc);
	}
	public String getId_entdoc() {
		return ((String) getAttrVal("Id_entdoc"));
	}	
	public void setId_entdoc(String Id_entdoc) {
		setAttrVal("Id_entdoc", Id_entdoc);
	}
	public String getId_ent_last_op() {
		return ((String) getAttrVal("Id_ent_last_op"));
	}	
	public void setId_ent_last_op(String Id_ent_last_op) {
		setAttrVal("Id_ent_last_op", Id_ent_last_op);
	}
	public String getId_ent_last_ip() {
		return ((String) getAttrVal("Id_ent_last_ip"));
	}	
	public void setId_ent_last_ip(String Id_ent_last_ip) {
		setAttrVal("Id_ent_last_ip", Id_ent_last_ip);
	}
	public String getId_apt_last() {
		return ((String) getAttrVal("Id_apt_last"));
	}	
	public void setId_apt_last(String Id_apt_last) {
		setAttrVal("Id_apt_last", Id_apt_last);
	}
	public FBoolean getFg_hypert() {
		return ((FBoolean) getAttrVal("Fg_hypert"));
	}	
	public void setFg_hypert(FBoolean Fg_hypert) {
		setAttrVal("Fg_hypert", Fg_hypert);
	}
	public FBoolean getFg_diab_preg() {
		return ((FBoolean) getAttrVal("Fg_diab_preg"));
	}	
	public void setFg_diab_preg(FBoolean Fg_diab_preg) {
		setAttrVal("Fg_diab_preg", Fg_diab_preg);
	}
	public FBoolean getFg_preg_diab() {
		return ((FBoolean) getAttrVal("Fg_preg_diab"));
	}	
	public void setFg_preg_diab(FBoolean Fg_preg_diab) {
		setAttrVal("Fg_preg_diab", Fg_preg_diab);
	}
	public FDouble getWeit_doc() {
		return ((FDouble) getAttrVal("Weit_doc"));
	}	
	public void setWeit_doc(FDouble Weit_doc) {
		setAttrVal("Weit_doc", Weit_doc);
	}
	public FBoolean getFg_have_born() {
		return ((FBoolean) getAttrVal("Fg_have_born"));
	}	
	public void setFg_have_born(FBoolean Fg_have_born) {
		setAttrVal("Fg_have_born", Fg_have_born);
	}
	public FDouble getWeit_born() {
		return ((FDouble) getAttrVal("Weit_born"));
	}	
	public void setWeit_born(FDouble Weit_born) {
		setAttrVal("Weit_born", Weit_born);
	}
	public Integer getMins_born() {
		return ((Integer) getAttrVal("Mins_born"));
	}	
	public void setMins_born(Integer Mins_born) {
		setAttrVal("Mins_born", Mins_born);
	}
	public Integer getVol_out_blood() {
		return ((Integer) getAttrVal("Vol_out_blood"));
	}	
	public void setVol_out_blood(Integer Vol_out_blood) {
		setAttrVal("Vol_out_blood", Vol_out_blood);
	}
	public FBoolean getFg_premature() {
		return ((FBoolean) getAttrVal("Fg_premature"));
	}	
	public void setFg_premature(FBoolean Fg_premature) {
		setAttrVal("Fg_premature", Fg_premature);
	}
	public Integer getTimes_preg() {
		return ((Integer) getAttrVal("Times_preg"));
	}	
	public void setTimes_preg(Integer Times_preg) {
		setAttrVal("Times_preg", Times_preg);
	}
	public Integer getTimes_born() {
		return ((Integer) getAttrVal("Times_born"));
	}	
	public void setTimes_born(Integer Times_born) {
		setAttrVal("Times_born", Times_born);
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
		return "Id_pregdocstat";
	}
	
	@Override
	public String getTableName() {	  
		return "en_doc_preg_stat";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PregDocStatDODesc.class);
	}
	
}