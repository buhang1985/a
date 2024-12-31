package iih.mp.nr.mpnuhandoverrpt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.mpnuhandoverrpt.d.desc.MpNuHsPatDODesc;
import java.math.BigDecimal;

/**
 * 护理交接班患者信息 DO数据 
 * 
 */
public class MpNuHsPatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NUHSPAT= "Id_nuhspat";
	public static final String ID_NUHS= "Id_nuhs";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_BED= "Id_bed";
	public static final String CODE_BED= "Code_bed";
	public static final String NAME_PAT= "Name_pat";
	public static final String ID_ENTDI= "Id_entdi";
	public static final String NAME_DI= "Name_di";
	public static final String PAT_INFO= "Pat_info";
	public static final String FG_DEL= "Fg_del";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nuhspat() {
		return ((String) getAttrVal("Id_nuhspat"));
	}	
	public void setId_nuhspat(String Id_nuhspat) {
		setAttrVal("Id_nuhspat", Id_nuhspat);
	}
	public String getId_nuhs() {
		return ((String) getAttrVal("Id_nuhs"));
	}	
	public void setId_nuhs(String Id_nuhs) {
		setAttrVal("Id_nuhs", Id_nuhs);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	public String getCode_bed() {
		return ((String) getAttrVal("Code_bed"));
	}	
	public void setCode_bed(String Code_bed) {
		setAttrVal("Code_bed", Code_bed);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getId_entdi() {
		return ((String) getAttrVal("Id_entdi"));
	}	
	public void setId_entdi(String Id_entdi) {
		setAttrVal("Id_entdi", Id_entdi);
	}
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	public String getPat_info() {
		return ((String) getAttrVal("Pat_info"));
	}	
	public void setPat_info(String Pat_info) {
		setAttrVal("Pat_info", Pat_info);
	}
	public FBoolean getFg_del() {
		return ((FBoolean) getAttrVal("Fg_del"));
	}	
	public void setFg_del(FBoolean Fg_del) {
		setAttrVal("Fg_del", Fg_del);
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
		return "Id_nuhspat";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_NU_HS_PAT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpNuHsPatDODesc.class);
	}
	
}