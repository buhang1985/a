package iih.pe.pitm.pesrvchkprecede.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvchkprecede.d.desc.PeSrvChkPrecedeDODesc;
import java.math.BigDecimal;

/**
 * 体检检查前置关系 DO数据 
 * 
 */
public class PeSrvChkPrecedeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PESRVCHKPRECEDE= "Id_pesrvchkprecede";
	public static final String ID_PESRVITEM_PREV= "Id_pesrvitem_prev";
	public static final String ID_PESRVITEM_DEPE= "Id_pesrvitem_depe";
	public static final String CODE_PREV= "Code_prev";
	public static final String NAME_PREV= "Name_prev";
	public static final String CODE_DEPE= "Code_depe";
	public static final String NAME_DEPE= "Name_depe";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pesrvchkprecede() {
		return ((String) getAttrVal("Id_pesrvchkprecede"));
	}	
	public void setId_pesrvchkprecede(String Id_pesrvchkprecede) {
		setAttrVal("Id_pesrvchkprecede", Id_pesrvchkprecede);
	}
	public String getId_pesrvitem_prev() {
		return ((String) getAttrVal("Id_pesrvitem_prev"));
	}	
	public void setId_pesrvitem_prev(String Id_pesrvitem_prev) {
		setAttrVal("Id_pesrvitem_prev", Id_pesrvitem_prev);
	}
	public String getId_pesrvitem_depe() {
		return ((String) getAttrVal("Id_pesrvitem_depe"));
	}	
	public void setId_pesrvitem_depe(String Id_pesrvitem_depe) {
		setAttrVal("Id_pesrvitem_depe", Id_pesrvitem_depe);
	}
	public String getCode_prev() {
		return ((String) getAttrVal("Code_prev"));
	}	
	public void setCode_prev(String Code_prev) {
		setAttrVal("Code_prev", Code_prev);
	}
	public String getName_prev() {
		return ((String) getAttrVal("Name_prev"));
	}	
	public void setName_prev(String Name_prev) {
		setAttrVal("Name_prev", Name_prev);
	}
	public String getCode_depe() {
		return ((String) getAttrVal("Code_depe"));
	}	
	public void setCode_depe(String Code_depe) {
		setAttrVal("Code_depe", Code_depe);
	}
	public String getName_depe() {
		return ((String) getAttrVal("Name_depe"));
	}	
	public void setName_depe(String Name_depe) {
		setAttrVal("Name_depe", Name_depe);
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
		return "Id_pesrvchkprecede";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvchkprecede";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvChkPrecedeDODesc.class);
	}
	
}