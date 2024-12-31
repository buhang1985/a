package iih.bl.hp.hporshare.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.hp.hporshare.d.desc.BlHpOrShareLogDODesc;
import java.math.BigDecimal;

/**
 * 医嘱信息共享消息 DO数据 
 * 
 */
public class BlHpOrShareLogDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPORSHARELOG= "Id_hporsharelog";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_HP= "Code_hp";
	public static final String DT_MESSAGE= "Dt_message";
	public static final String INPUTINFO= "Inputinfo";
	public static final String OUTPUTINFO= "Outputinfo";
	public static final String NAME_PAT= "Name_pat";
	public static final String CODE_PAT= "Code_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hporsharelog() {
		return ((String) getAttrVal("Id_hporsharelog"));
	}	
	public void setId_hporsharelog(String Id_hporsharelog) {
		setAttrVal("Id_hporsharelog", Id_hporsharelog);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	public FDateTime getDt_message() {
		return ((FDateTime) getAttrVal("Dt_message"));
	}	
	public void setDt_message(FDateTime Dt_message) {
		setAttrVal("Dt_message", Dt_message);
	}
	public String getInputinfo() {
		return ((String) getAttrVal("Inputinfo"));
	}	
	public void setInputinfo(String Inputinfo) {
		setAttrVal("Inputinfo", Inputinfo);
	}
	public String getOutputinfo() {
		return ((String) getAttrVal("Outputinfo"));
	}	
	public void setOutputinfo(String Outputinfo) {
		setAttrVal("Outputinfo", Outputinfo);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
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
		return "Id_hporsharelog";
	}
	
	@Override
	public String getTableName() {	  
		return "BL_HP_OR_SHARE_LOG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlHpOrShareLogDODesc.class);
	}
	
}