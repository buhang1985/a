package iih.hp.cp.ele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.ele.d.desc.HpCpElemTextDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_文本元素 DO数据 
 * 
 */
public class HpCpElemTextDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//文本元素ID
	public static final String ID_ELE_TXT= "Id_ele_txt";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//内容
	public static final String CONTENT= "Content";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 文本元素ID
	 * @return String
	 */
	public String getId_ele_txt() {
		return ((String) getAttrVal("Id_ele_txt"));
	}	
	/**
	 * 文本元素ID
	 * @param Id_ele_txt
	 */
	public void setId_ele_txt(String Id_ele_txt) {
		setAttrVal("Id_ele_txt", Id_ele_txt);
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
	 * 内容
	 * @return byte[]
	 */
	public byte[] getContent() {
		return ((byte[]) getAttrVal("Content"));
	}	
	/**
	 * 内容
	 * @param Content
	 */
	public void setContent(byte[] Content) {
		setAttrVal("Content", Content);
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
		return "Id_ele_txt";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_TXT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemTextDODesc.class);
	}
	
}