package iih.pe.pitm.pesrvitem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvitem.d.desc.PeSrvitmRisDODesc;
import java.math.BigDecimal;

/**
 * 体检结果RIS对应 DO数据 
 * 
 */
public class PeSrvitmRisDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检结果放射对应主键标识
	public static final String ID_PEITMRIS= "Id_peitmris";
	//体检结果ID
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	//放射系统项目ID
	public static final String ID_RISITM= "Id_risitm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检结果放射对应主键标识
	 * @return String
	 */
	public String getId_peitmris() {
		return ((String) getAttrVal("Id_peitmris"));
	}	
	/**
	 * 体检结果放射对应主键标识
	 * @param Id_peitmris
	 */
	public void setId_peitmris(String Id_peitmris) {
		setAttrVal("Id_peitmris", Id_peitmris);
	}
	/**
	 * 体检结果ID
	 * @return String
	 */
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	/**
	 * 体检结果ID
	 * @param Id_pesrvitem
	 */
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	/**
	 * 放射系统项目ID
	 * @return String
	 */
	public String getId_risitm() {
		return ((String) getAttrVal("Id_risitm"));
	}	
	/**
	 * 放射系统项目ID
	 * @param Id_risitm
	 */
	public void setId_risitm(String Id_risitm) {
		setAttrVal("Id_risitm", Id_risitm);
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
		return "Id_peitmris";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_peitmris";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvitmRisDODesc.class);
	}
	
}