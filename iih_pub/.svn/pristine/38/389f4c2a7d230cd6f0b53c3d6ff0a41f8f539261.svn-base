package iih.pe.phm.pechrodise.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pechrodise.d.desc.PeChroDiseRiskListDODesc;
import java.math.BigDecimal;

/**
 * 体检慢性病风险评估结果危险因素 DO数据 
 * 
 */
public class PeChroDiseRiskListDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检慢性病评估危险因素主键标识
	public static final String ID_PECHRODISERISKS= "Id_pechrodiserisks";
	//体检慢性病评估ID
	public static final String ID_PECHRODISE= "Id_pechrodise";
	//风险因素ID
	public static final String ID_PECHRORISK= "Id_pechrorisk";
	//结果
	public static final String VALUE= "Value";
	//标识
	public static final String MARK= "Mark";
	//风险因素编码
	public static final String CODE= "Code";
	//风险因素名称
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检慢性病评估危险因素主键标识
	 * @return String
	 */
	public String getId_pechrodiserisks() {
		return ((String) getAttrVal("Id_pechrodiserisks"));
	}	
	/**
	 * 体检慢性病评估危险因素主键标识
	 * @param Id_pechrodiserisks
	 */
	public void setId_pechrodiserisks(String Id_pechrodiserisks) {
		setAttrVal("Id_pechrodiserisks", Id_pechrodiserisks);
	}
	/**
	 * 体检慢性病评估ID
	 * @return String
	 */
	public String getId_pechrodise() {
		return ((String) getAttrVal("Id_pechrodise"));
	}	
	/**
	 * 体检慢性病评估ID
	 * @param Id_pechrodise
	 */
	public void setId_pechrodise(String Id_pechrodise) {
		setAttrVal("Id_pechrodise", Id_pechrodise);
	}
	/**
	 * 风险因素ID
	 * @return String
	 */
	public String getId_pechrorisk() {
		return ((String) getAttrVal("Id_pechrorisk"));
	}	
	/**
	 * 风险因素ID
	 * @param Id_pechrorisk
	 */
	public void setId_pechrorisk(String Id_pechrorisk) {
		setAttrVal("Id_pechrorisk", Id_pechrorisk);
	}
	/**
	 * 结果
	 * @return String
	 */
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}	
	/**
	 * 结果
	 * @param Value
	 */
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 标识
	 * @return String
	 */
	public String getMark() {
		return ((String) getAttrVal("Mark"));
	}	
	/**
	 * 标识
	 * @param Mark
	 */
	public void setMark(String Mark) {
		setAttrVal("Mark", Mark);
	}
	/**
	 * 风险因素编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 风险因素编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 风险因素名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 风险因素名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
		return "Id_pechrodiserisks";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pechrodiserisklist";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChroDiseRiskListDODesc.class);
	}
	
}