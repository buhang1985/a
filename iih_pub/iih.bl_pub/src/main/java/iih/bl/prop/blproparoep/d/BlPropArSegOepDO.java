package iih.bl.prop.blproparoep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.prop.blproparoep.d.desc.BlPropArSegOepDODesc;
import java.math.BigDecimal;

/**
 * 应收付款段_门急体 DO数据 
 * 
 */
public class BlPropArSegOepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//应收付款段主键
	public static final String ID_PROPARSEGOEP= "Id_proparsegoep";
	//应收
	public static final String ID_PROPAROEP= "Id_proparoep";
	//分摊
	public static final String ID_PROP= "Id_prop";
	//付款段
	public static final String ID_HPSEG= "Id_hpseg";
	//付款段名称
	public static final String NAME_HPSEG= "Name_hpseg";
	//付款金额
	public static final String AMT_HPSEG= "Amt_hpseg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 应收付款段主键
	 * @return String
	 */
	public String getId_proparsegoep() {
		return ((String) getAttrVal("Id_proparsegoep"));
	}	
	/**
	 * 应收付款段主键
	 * @param Id_proparsegoep
	 */
	public void setId_proparsegoep(String Id_proparsegoep) {
		setAttrVal("Id_proparsegoep", Id_proparsegoep);
	}
	/**
	 * 应收
	 * @return String
	 */
	public String getId_proparoep() {
		return ((String) getAttrVal("Id_proparoep"));
	}	
	/**
	 * 应收
	 * @param Id_proparoep
	 */
	public void setId_proparoep(String Id_proparoep) {
		setAttrVal("Id_proparoep", Id_proparoep);
	}
	/**
	 * 分摊
	 * @return String
	 */
	public String getId_prop() {
		return ((String) getAttrVal("Id_prop"));
	}	
	/**
	 * 分摊
	 * @param Id_prop
	 */
	public void setId_prop(String Id_prop) {
		setAttrVal("Id_prop", Id_prop);
	}
	/**
	 * 付款段
	 * @return String
	 */
	public String getId_hpseg() {
		return ((String) getAttrVal("Id_hpseg"));
	}	
	/**
	 * 付款段
	 * @param Id_hpseg
	 */
	public void setId_hpseg(String Id_hpseg) {
		setAttrVal("Id_hpseg", Id_hpseg);
	}
	/**
	 * 付款段名称
	 * @return String
	 */
	public String getName_hpseg() {
		return ((String) getAttrVal("Name_hpseg"));
	}	
	/**
	 * 付款段名称
	 * @param Name_hpseg
	 */
	public void setName_hpseg(String Name_hpseg) {
		setAttrVal("Name_hpseg", Name_hpseg);
	}
	/**
	 * 付款金额
	 * @return FDouble
	 */
	public FDouble getAmt_hpseg() {
		return ((FDouble) getAttrVal("Amt_hpseg"));
	}	
	/**
	 * 付款金额
	 * @param Amt_hpseg
	 */
	public void setAmt_hpseg(FDouble Amt_hpseg) {
		setAttrVal("Amt_hpseg", Amt_hpseg);
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
		return "Id_proparsegoep";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_prop_ar_seg_oep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPropArSegOepDODesc.class);
	}
	
}