package iih.bl.inc.blincip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.inc.blincip.d.desc.BlStIncIpDODesc;
import java.math.BigDecimal;

/**
 * 住院结算与发票关系 DO数据 
 * 
 */
public class BlStIncIpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_STINCIP= "Id_stincip";
	public static final String ID_STIP= "Id_stip";
	public static final String ID_INCIP= "Id_incip";
	public static final String CODE_HP= "Code_hp";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_stincip() {
		return ((String) getAttrVal("Id_stincip"));
	}	
	public void setId_stincip(String Id_stincip) {
		setAttrVal("Id_stincip", Id_stincip);
	}
	public String getId_stip() {
		return ((String) getAttrVal("Id_stip"));
	}	
	public void setId_stip(String Id_stip) {
		setAttrVal("Id_stip", Id_stip);
	}
	public String getId_incip() {
		return ((String) getAttrVal("Id_incip"));
	}	
	public void setId_incip(String Id_incip) {
		setAttrVal("Id_incip", Id_incip);
	}
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
		return "Id_stincip";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_st_inc_ip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlStIncIpDODesc.class);
	}
	
}