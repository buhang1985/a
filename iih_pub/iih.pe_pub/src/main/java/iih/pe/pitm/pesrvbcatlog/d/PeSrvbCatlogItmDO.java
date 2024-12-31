package iih.pe.pitm.pesrvbcatlog.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvbcatlog.d.desc.PeSrvbCatlogItmDODesc;
import java.math.BigDecimal;

/**
 * 体检项目-体检结果关联 DO数据 
 * 
 */
public class PeSrvbCatlogItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检项目小项包含主键标识
	public static final String ID_PESRVBCATLOGITM= "Id_pesrvbcatlogitm";
	//体检项目ID
	public static final String ID_PESRVBCATLOG= "Id_pesrvbcatlog";
	//体检结果ID
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	//数量
	public static final String QTY= "Qty";
	//项目编码
	public static final String SD_CATLOG= "Sd_catlog";
	//结果编码
	public static final String SD_ITEM= "Sd_item";
	//名称
	public static final String NAME_SRVCATLOG= "Name_srvcatlog";
	//编码
	public static final String CODE_SRVCATLOG= "Code_srvcatlog";
	//所属科室
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	//名称
	public static final String NAME_SRVITM= "Name_srvitm";
	//编码
	public static final String CODE_SRVITM= "Code_srvitm";
	//计量单位
	public static final String UNIT= "Unit";
	//参考范围
	public static final String REFERENCE= "Reference";
	//缺省值
	public static final String DEFAULT_VALUE= "Default_value";
	//缺省状态
	public static final String DEFAULT_STATUS= "Default_status";
	//序号
	public static final String SORTNO= "Sortno";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检项目小项包含主键标识
	 * @return String
	 */
	public String getId_pesrvbcatlogitm() {
		return ((String) getAttrVal("Id_pesrvbcatlogitm"));
	}	
	/**
	 * 体检项目小项包含主键标识
	 * @param Id_pesrvbcatlogitm
	 */
	public void setId_pesrvbcatlogitm(String Id_pesrvbcatlogitm) {
		setAttrVal("Id_pesrvbcatlogitm", Id_pesrvbcatlogitm);
	}
	/**
	 * 体检项目ID
	 * @return String
	 */
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}	
	/**
	 * 体检项目ID
	 * @param Id_pesrvbcatlog
	 */
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
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
	 * 数量
	 * @return Integer
	 */
	public Integer getQty() {
		return ((Integer) getAttrVal("Qty"));
	}	
	/**
	 * 数量
	 * @param Qty
	 */
	public void setQty(Integer Qty) {
		setAttrVal("Qty", Qty);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getSd_catlog() {
		return ((String) getAttrVal("Sd_catlog"));
	}	
	/**
	 * 项目编码
	 * @param Sd_catlog
	 */
	public void setSd_catlog(String Sd_catlog) {
		setAttrVal("Sd_catlog", Sd_catlog);
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
	 * 名称
	 * @return String
	 */
	public String getName_srvcatlog() {
		return ((String) getAttrVal("Name_srvcatlog"));
	}	
	/**
	 * 名称
	 * @param Name_srvcatlog
	 */
	public void setName_srvcatlog(String Name_srvcatlog) {
		setAttrVal("Name_srvcatlog", Name_srvcatlog);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_srvcatlog() {
		return ((String) getAttrVal("Code_srvcatlog"));
	}	
	/**
	 * 编码
	 * @param Code_srvcatlog
	 */
	public void setCode_srvcatlog(String Code_srvcatlog) {
		setAttrVal("Code_srvcatlog", Code_srvcatlog);
	}
	/**
	 * 所属科室
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	/**
	 * 所属科室
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_srvitm() {
		return ((String) getAttrVal("Name_srvitm"));
	}	
	/**
	 * 名称
	 * @param Name_srvitm
	 */
	public void setName_srvitm(String Name_srvitm) {
		setAttrVal("Name_srvitm", Name_srvitm);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_srvitm() {
		return ((String) getAttrVal("Code_srvitm"));
	}	
	/**
	 * 编码
	 * @param Code_srvitm
	 */
	public void setCode_srvitm(String Code_srvitm) {
		setAttrVal("Code_srvitm", Code_srvitm);
	}
	/**
	 * 计量单位
	 * @return String
	 */
	public String getUnit() {
		return ((String) getAttrVal("Unit"));
	}	
	/**
	 * 计量单位
	 * @param Unit
	 */
	public void setUnit(String Unit) {
		setAttrVal("Unit", Unit);
	}
	/**
	 * 参考范围
	 * @return String
	 */
	public String getReference() {
		return ((String) getAttrVal("Reference"));
	}	
	/**
	 * 参考范围
	 * @param Reference
	 */
	public void setReference(String Reference) {
		setAttrVal("Reference", Reference);
	}
	/**
	 * 缺省值
	 * @return String
	 */
	public String getDefault_value() {
		return ((String) getAttrVal("Default_value"));
	}	
	/**
	 * 缺省值
	 * @param Default_value
	 */
	public void setDefault_value(String Default_value) {
		setAttrVal("Default_value", Default_value);
	}
	/**
	 * 缺省状态
	 * @return Integer
	 */
	public Integer getDefault_status() {
		return ((Integer) getAttrVal("Default_status"));
	}	
	/**
	 * 缺省状态
	 * @param Default_status
	 */
	public void setDefault_status(Integer Default_status) {
		setAttrVal("Default_status", Default_status);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
		return "Id_pesrvbcatlogitm";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvbcatlogitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvbCatlogItmDODesc.class);
	}
	
}