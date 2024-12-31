package iih.bd.srv.mrelement.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrelement.d.desc.MrEleValDODesc;
import java.math.BigDecimal;

/**
 * 病历元素值域 DO数据 
 * 
 */
public class MrEleValDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键ID
	public static final String ID_MRDEVAL= "Id_mrdeval";
	//元素ID
	public static final String ID_MR_DE= "Id_mr_de";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//五笔码
	public static final String WBCOCE= "Wbcoce";
	//拼音码
	public static final String PYCODE= "Pycode";
	//自定义码
	public static final String MNECODE= "Mnecode";
	//描述
	public static final String DES= "Des";
	//序号
	public static final String ORDER_INDEX= "Order_index";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键ID
	 * @return String
	 */
	public String getId_mrdeval() {
		return ((String) getAttrVal("Id_mrdeval"));
	}	
	/**
	 * 主键ID
	 * @param Id_mrdeval
	 */
	public void setId_mrdeval(String Id_mrdeval) {
		setAttrVal("Id_mrdeval", Id_mrdeval);
	}
	/**
	 * 元素ID
	 * @return String
	 */
	public String getId_mr_de() {
		return ((String) getAttrVal("Id_mr_de"));
	}	
	/**
	 * 元素ID
	 * @param Id_mr_de
	 */
	public void setId_mr_de(String Id_mr_de) {
		setAttrVal("Id_mr_de", Id_mr_de);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcoce() {
		return ((String) getAttrVal("Wbcoce"));
	}	
	/**
	 * 五笔码
	 * @param Wbcoce
	 */
	public void setWbcoce(String Wbcoce) {
		setAttrVal("Wbcoce", Wbcoce);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 自定义码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 自定义码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getOrder_index() {
		return ((Integer) getAttrVal("Order_index"));
	}	
	/**
	 * 序号
	 * @param Order_index
	 */
	public void setOrder_index(Integer Order_index) {
		setAttrVal("Order_index", Order_index);
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
		return "Id_mrdeval";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrde_val";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrEleValDODesc.class);
	}
	
}