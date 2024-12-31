package iih.pe.pbd.peinstrument.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pbd.peinstrument.d.desc.PeInstItmRelDefDODesc;
import java.math.BigDecimal;

/**
 * 体检用仪器设备项目对应关系定义 DO数据 
 * 
 */
public class PeInstItmRelDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检设备项目通道主键标识
	public static final String ID_PEINSTRUMENTITM= "Id_peinstrumentitm";
	//设备ID
	public static final String ID_PEINSTRUMENT= "Id_peinstrument";
	//序号
	public static final String SORTNO= "Sortno";
	//设备项目编码
	public static final String CODE= "Code";
	//体检结果主键
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	//体检结果标识
	public static final String FG_SRVITM= "Fg_srvitm";
	//小数位数
	public static final String DECIMAL_PLACE= "Decimal_place";
	//可替换标识
	public static final String FG_REPLACE= "Fg_replace";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String CODE_ITM= "Code_itm";
	//名称
	public static final String NAME_ITM= "Name_itm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检设备项目通道主键标识
	 * @return String
	 */
	public String getId_peinstrumentitm() {
		return ((String) getAttrVal("Id_peinstrumentitm"));
	}	
	/**
	 * 体检设备项目通道主键标识
	 * @param Id_peinstrumentitm
	 */
	public void setId_peinstrumentitm(String Id_peinstrumentitm) {
		setAttrVal("Id_peinstrumentitm", Id_peinstrumentitm);
	}
	/**
	 * 设备ID
	 * @return String
	 */
	public String getId_peinstrument() {
		return ((String) getAttrVal("Id_peinstrument"));
	}	
	/**
	 * 设备ID
	 * @param Id_peinstrument
	 */
	public void setId_peinstrument(String Id_peinstrument) {
		setAttrVal("Id_peinstrument", Id_peinstrument);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 设备项目编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 设备项目编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 体检结果主键
	 * @return String
	 */
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	/**
	 * 体检结果主键
	 * @param Id_pesrvitem
	 */
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	/**
	 * 体检结果标识
	 * @return FBoolean
	 */
	public FBoolean getFg_srvitm() {
		return ((FBoolean) getAttrVal("Fg_srvitm"));
	}	
	/**
	 * 体检结果标识
	 * @param Fg_srvitm
	 */
	public void setFg_srvitm(FBoolean Fg_srvitm) {
		setAttrVal("Fg_srvitm", Fg_srvitm);
	}
	/**
	 * 小数位数
	 * @return Integer
	 */
	public Integer getDecimal_place() {
		return ((Integer) getAttrVal("Decimal_place"));
	}	
	/**
	 * 小数位数
	 * @param Decimal_place
	 */
	public void setDecimal_place(Integer Decimal_place) {
		setAttrVal("Decimal_place", Decimal_place);
	}
	/**
	 * 可替换标识
	 * @return FBoolean
	 */
	public FBoolean getFg_replace() {
		return ((FBoolean) getAttrVal("Fg_replace"));
	}	
	/**
	 * 可替换标识
	 * @param Fg_replace
	 */
	public void setFg_replace(FBoolean Fg_replace) {
		setAttrVal("Fg_replace", Fg_replace);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_itm() {
		return ((String) getAttrVal("Code_itm"));
	}	
	/**
	 * 编码
	 * @param Code_itm
	 */
	public void setCode_itm(String Code_itm) {
		setAttrVal("Code_itm", Code_itm);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_itm() {
		return ((String) getAttrVal("Name_itm"));
	}	
	/**
	 * 名称
	 * @param Name_itm
	 */
	public void setName_itm(String Name_itm) {
		setAttrVal("Name_itm", Name_itm);
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
		return "Id_peinstrumentitm";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_bd_institmrel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeInstItmRelDefDODesc.class);
	}
	
}