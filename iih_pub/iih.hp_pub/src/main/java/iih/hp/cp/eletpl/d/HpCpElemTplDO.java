package iih.hp.cp.eletpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.eletpl.d.desc.HpCpElemTplDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素模板 DO数据 
 * 
 */
public class HpCpElemTplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ELE_TPL= "Id_ele_tpl";
	public static final String ID_CP= "Id_cp";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String ID_PAR= "Id_par";
	public static final String SERIALNO= "Serialno";
	public static final String ID_ELETP= "Id_eletp";
	public static final String FG_PKG= "Fg_pkg";
	public static final String EU_PKGITMSELTP= "Eu_pkgitmseltp";
	public static final String EU_EXPAND_DIR= "Eu_expand_dir";
	public static final String FG_NEEDMAPPING= "Fg_needmapping";
	public static final String FG_NECESSARY= "Fg_necessary";
	public static final String PREALARMHOURS= "Prealarmhours";
	public static final String FG_DEL= "Fg_del";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ele_tpl() {
		return ((String) getAttrVal("Id_ele_tpl"));
	}	
	public void setId_ele_tpl(String Id_ele_tpl) {
		setAttrVal("Id_ele_tpl", Id_ele_tpl);
	}
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}	
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
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
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	public Integer getSerialno() {
		return ((Integer) getAttrVal("Serialno"));
	}	
	public void setSerialno(Integer Serialno) {
		setAttrVal("Serialno", Serialno);
	}
	public String getId_eletp() {
		return ((String) getAttrVal("Id_eletp"));
	}	
	public void setId_eletp(String Id_eletp) {
		setAttrVal("Id_eletp", Id_eletp);
	}
	public FBoolean getFg_pkg() {
		return ((FBoolean) getAttrVal("Fg_pkg"));
	}	
	public void setFg_pkg(FBoolean Fg_pkg) {
		setAttrVal("Fg_pkg", Fg_pkg);
	}
	public Integer getEu_pkgitmseltp() {
		return ((Integer) getAttrVal("Eu_pkgitmseltp"));
	}	
	public void setEu_pkgitmseltp(Integer Eu_pkgitmseltp) {
		setAttrVal("Eu_pkgitmseltp", Eu_pkgitmseltp);
	}
	public Integer getEu_expand_dir() {
		return ((Integer) getAttrVal("Eu_expand_dir"));
	}	
	public void setEu_expand_dir(Integer Eu_expand_dir) {
		setAttrVal("Eu_expand_dir", Eu_expand_dir);
	}
	public FBoolean getFg_needmapping() {
		return ((FBoolean) getAttrVal("Fg_needmapping"));
	}	
	public void setFg_needmapping(FBoolean Fg_needmapping) {
		setAttrVal("Fg_needmapping", Fg_needmapping);
	}
	public FBoolean getFg_necessary() {
		return ((FBoolean) getAttrVal("Fg_necessary"));
	}	
	public void setFg_necessary(FBoolean Fg_necessary) {
		setAttrVal("Fg_necessary", Fg_necessary);
	}
	public Integer getPrealarmhours() {
		return ((Integer) getAttrVal("Prealarmhours"));
	}	
	public void setPrealarmhours(Integer Prealarmhours) {
		setAttrVal("Prealarmhours", Prealarmhours);
	}
	public FDouble getFg_del() {
		return ((FDouble) getAttrVal("Fg_del"));
	}	
	public void setFg_del(FDouble Fg_del) {
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
		return "Id_ele_tpl";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_TPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemTplDODesc.class);
	}
	
}