package iih.hp.cp.ele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.ele.d.desc.HpCpElemMedRecordDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_病历 DO数据 
 * 
 */
public class HpCpElemMedRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//元素病历ID
	public static final String ID_ELE_MR= "Id_ele_mr";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//医疗记录类型
	public static final String ID_MRTP= "Id_mrtp";
	//医疗记录类型编码
	public static final String SD_MRTP= "Sd_mrtp";
	//医疗记录类型名称
	public static final String NAME_MRTP= "Name_mrtp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 元素病历ID
	 * @return String
	 */
	public String getId_ele_mr() {
		return ((String) getAttrVal("Id_ele_mr"));
	}	
	/**
	 * 元素病历ID
	 * @param Id_ele_mr
	 */
	public void setId_ele_mr(String Id_ele_mr) {
		setAttrVal("Id_ele_mr", Id_ele_mr);
	}
	/**
	 * 元素ID
	 * @return String
	 */
	public String getId_ele() {
		return ((String) getAttrVal("Id_ele"));
	}	
	/**
	 * 元素ID
	 * @param Id_ele
	 */
	public void setId_ele(String Id_ele) {
		setAttrVal("Id_ele", Id_ele);
	}
	/**
	 * 医疗记录类型
	 * @return String
	 */
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	/**
	 * 医疗记录类型
	 * @param Id_mrtp
	 */
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	/**
	 * 医疗记录类型编码
	 * @return String
	 */
	public String getSd_mrtp() {
		return ((String) getAttrVal("Sd_mrtp"));
	}	
	/**
	 * 医疗记录类型编码
	 * @param Sd_mrtp
	 */
	public void setSd_mrtp(String Sd_mrtp) {
		setAttrVal("Sd_mrtp", Sd_mrtp);
	}
	/**
	 * 医疗记录类型名称
	 * @return String
	 */
	public String getName_mrtp() {
		return ((String) getAttrVal("Name_mrtp"));
	}	
	/**
	 * 医疗记录类型名称
	 * @param Name_mrtp
	 */
	public void setName_mrtp(String Name_mrtp) {
		setAttrVal("Name_mrtp", Name_mrtp);
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
		return "Id_ele_mr";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_MR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemMedRecordDODesc.class);
	}
	
}