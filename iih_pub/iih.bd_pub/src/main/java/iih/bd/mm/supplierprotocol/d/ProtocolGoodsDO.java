package iih.bd.mm.supplierprotocol.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.supplierprotocol.d.desc.ProtocolGoodsDODesc;
import java.math.BigDecimal;

/**
 * 医疗物品_与供应商关系及协议 DO数据 
 * 
 */
public class ProtocolGoodsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗物品供应商主键
	public static final String ID_MMSUP= "Id_mmsup";
	//供应商协议
	public static final String ID_SUP_PROT= "Id_sup_prot";
	//医疗物品
	public static final String ID_MM= "Id_mm";
	//协议价
	public static final String PRICE= "Price";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗物品供应商主键
	 * @return String
	 */
	public String getId_mmsup() {
		return ((String) getAttrVal("Id_mmsup"));
	}	
	/**
	 * 医疗物品供应商主键
	 * @param Id_mmsup
	 */
	public void setId_mmsup(String Id_mmsup) {
		setAttrVal("Id_mmsup", Id_mmsup);
	}
	/**
	 * 供应商协议
	 * @return String
	 */
	public String getId_sup_prot() {
		return ((String) getAttrVal("Id_sup_prot"));
	}	
	/**
	 * 供应商协议
	 * @param Id_sup_prot
	 */
	public void setId_sup_prot(String Id_sup_prot) {
		setAttrVal("Id_sup_prot", Id_sup_prot);
	}
	/**
	 * 医疗物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 医疗物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 协议价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	/**
	 * 协议价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	/**
	 * 物品编码
	 * @param Mm_code
	 */
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	/**
	 * 物品规格
	 * @return String
	 */
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}	
	/**
	 * 物品规格
	 * @param Mm_spec
	 */
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	/**
	 * 物品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
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
		return "Id_mmsup";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_MM_SUP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ProtocolGoodsDODesc.class);
	}
	
}