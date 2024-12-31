package iih.pe.pitm.pesrvitem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvitem.d.desc.PeSrvitmDiagDODesc;
import java.math.BigDecimal;

/**
 * 体检结果与诊断关联 DO数据 
 * 
 */
public class PeSrvitmDiagDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检结果关联诊断主键标识
	public static final String ID_PESRVITMDIAG= "Id_pesrvitmdiag";
	//体检结果ID
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	//体检诊断目录ID
	public static final String ID_PERSTDITP= "Id_perstditp";
	//结果编码
	public static final String SD_ITEM= "Sd_item";
	//结果分类
	public static final String SD_CLASS= "Sd_class";
	//诊断目录编码
	public static final String CODE_DITP= "Code_ditp";
	//诊断目录名称
	public static final String NAME_DITP= "Name_ditp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检结果关联诊断主键标识
	 * @return String
	 */
	public String getId_pesrvitmdiag() {
		return ((String) getAttrVal("Id_pesrvitmdiag"));
	}	
	/**
	 * 体检结果关联诊断主键标识
	 * @param Id_pesrvitmdiag
	 */
	public void setId_pesrvitmdiag(String Id_pesrvitmdiag) {
		setAttrVal("Id_pesrvitmdiag", Id_pesrvitmdiag);
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
	 * 体检诊断目录ID
	 * @return String
	 */
	public String getId_perstditp() {
		return ((String) getAttrVal("Id_perstditp"));
	}	
	/**
	 * 体检诊断目录ID
	 * @param Id_perstditp
	 */
	public void setId_perstditp(String Id_perstditp) {
		setAttrVal("Id_perstditp", Id_perstditp);
	}
	/**
	 * 结果编码
	 * @return String
	 */
	public String getSd_item() {
		return ((String) getAttrVal("Sd_item"));
	}	
	/**
	 * 结果编码
	 * @param Sd_item
	 */
	public void setSd_item(String Sd_item) {
		setAttrVal("Sd_item", Sd_item);
	}
	/**
	 * 结果分类
	 * @return String
	 */
	public String getSd_class() {
		return ((String) getAttrVal("Sd_class"));
	}	
	/**
	 * 结果分类
	 * @param Sd_class
	 */
	public void setSd_class(String Sd_class) {
		setAttrVal("Sd_class", Sd_class);
	}
	/**
	 * 诊断目录编码
	 * @return String
	 */
	public String getCode_ditp() {
		return ((String) getAttrVal("Code_ditp"));
	}	
	/**
	 * 诊断目录编码
	 * @param Code_ditp
	 */
	public void setCode_ditp(String Code_ditp) {
		setAttrVal("Code_ditp", Code_ditp);
	}
	/**
	 * 诊断目录名称
	 * @return String
	 */
	public String getName_ditp() {
		return ((String) getAttrVal("Name_ditp"));
	}	
	/**
	 * 诊断目录名称
	 * @param Name_ditp
	 */
	public void setName_ditp(String Name_ditp) {
		setAttrVal("Name_ditp", Name_ditp);
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
		return "Id_pesrvitmdiag";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_peitmdiag";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvitmDiagDODesc.class);
	}
	
}