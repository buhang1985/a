package iih.pe.pitm.pesrvsetdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvsetdef.d.desc.PeSrvSetItmDefDODesc;
import java.math.BigDecimal;

/**
 * 体检套餐项目明细 DO数据 
 * 
 */
public class PeSrvSetItmDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检套餐项目主键标识
	public static final String ID_PESRVSETITMDEF= "Id_pesrvsetitmdef";
	//体检套餐主键标识
	public static final String ID_PESRVSETDEF= "Id_pesrvsetdef";
	//体检项目主键标识
	public static final String ID_PESRVBCATLOG= "Id_pesrvbcatlog";
	//数量
	public static final String QTY= "Qty";
	//显示序号
	public static final String SORTNO= "Sortno";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//体检套餐编码
	public static final String SD_SET= "Sd_set";
	//体检项目编码
	public static final String SD_CATLOG= "Sd_catlog";
	//体检项目套餐内价格
	public static final String PRI_ITEMINSET= "Pri_iteminset";
	//必选标识
	public static final String FG_REQUIRED= "Fg_required";
	//体检套餐名称
	public static final String NAME_SRVSET= "Name_srvset";
	//名称
	public static final String NAME_SRVITM= "Name_srvitm";
	//编码
	public static final String CODE_SRVITM= "Code_srvitm";
	//基础价格
	public static final String PRICE_SRVITM= "Price_srvitm";
	//婴儿禁用
	public static final String FG_ENFANT_SRVITM= "Fg_enfant_srvitm";
	//孕妇禁用
	public static final String FG_PREGNENT_SRVITM= "Fg_pregnent_srvitm";
	//性别适用
	public static final String SEXLIMIT_SRVITM= "Sexlimit_srvitm";
	//未婚禁用
	public static final String FG_MARRIED= "Fg_married";
	//所属科室
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	//所属目录
	public static final String CATLOG_SRVITM= "Catlog_srvitm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检套餐项目主键标识
	 * @return String
	 */
	public String getId_pesrvsetitmdef() {
		return ((String) getAttrVal("Id_pesrvsetitmdef"));
	}	
	/**
	 * 体检套餐项目主键标识
	 * @param Id_pesrvsetitmdef
	 */
	public void setId_pesrvsetitmdef(String Id_pesrvsetitmdef) {
		setAttrVal("Id_pesrvsetitmdef", Id_pesrvsetitmdef);
	}
	/**
	 * 体检套餐主键标识
	 * @return String
	 */
	public String getId_pesrvsetdef() {
		return ((String) getAttrVal("Id_pesrvsetdef"));
	}	
	/**
	 * 体检套餐主键标识
	 * @param Id_pesrvsetdef
	 */
	public void setId_pesrvsetdef(String Id_pesrvsetdef) {
		setAttrVal("Id_pesrvsetdef", Id_pesrvsetdef);
	}
	/**
	 * 体检项目主键标识
	 * @return String
	 */
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}	
	/**
	 * 体检项目主键标识
	 * @param Id_pesrvbcatlog
	 */
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
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
	 * 显示序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	/**
	 * 显示序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 体检套餐编码
	 * @return String
	 */
	public String getSd_set() {
		return ((String) getAttrVal("Sd_set"));
	}	
	/**
	 * 体检套餐编码
	 * @param Sd_set
	 */
	public void setSd_set(String Sd_set) {
		setAttrVal("Sd_set", Sd_set);
	}
	/**
	 * 体检项目编码
	 * @return String
	 */
	public String getSd_catlog() {
		return ((String) getAttrVal("Sd_catlog"));
	}	
	/**
	 * 体检项目编码
	 * @param Sd_catlog
	 */
	public void setSd_catlog(String Sd_catlog) {
		setAttrVal("Sd_catlog", Sd_catlog);
	}
	/**
	 * 体检项目套餐内价格
	 * @return FDouble
	 */
	public FDouble getPri_iteminset() {
		return ((FDouble) getAttrVal("Pri_iteminset"));
	}	
	/**
	 * 体检项目套餐内价格
	 * @param Pri_iteminset
	 */
	public void setPri_iteminset(FDouble Pri_iteminset) {
		setAttrVal("Pri_iteminset", Pri_iteminset);
	}
	/**
	 * 必选标识
	 * @return FBoolean
	 */
	public FBoolean getFg_required() {
		return ((FBoolean) getAttrVal("Fg_required"));
	}	
	/**
	 * 必选标识
	 * @param Fg_required
	 */
	public void setFg_required(FBoolean Fg_required) {
		setAttrVal("Fg_required", Fg_required);
	}
	/**
	 * 体检套餐名称
	 * @return String
	 */
	public String getName_srvset() {
		return ((String) getAttrVal("Name_srvset"));
	}	
	/**
	 * 体检套餐名称
	 * @param Name_srvset
	 */
	public void setName_srvset(String Name_srvset) {
		setAttrVal("Name_srvset", Name_srvset);
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
	 * 基础价格
	 * @return FDouble
	 */
	public FDouble getPrice_srvitm() {
		return ((FDouble) getAttrVal("Price_srvitm"));
	}	
	/**
	 * 基础价格
	 * @param Price_srvitm
	 */
	public void setPrice_srvitm(FDouble Price_srvitm) {
		setAttrVal("Price_srvitm", Price_srvitm);
	}
	/**
	 * 婴儿禁用
	 * @return FBoolean
	 */
	public FBoolean getFg_enfant_srvitm() {
		return ((FBoolean) getAttrVal("Fg_enfant_srvitm"));
	}	
	/**
	 * 婴儿禁用
	 * @param Fg_enfant_srvitm
	 */
	public void setFg_enfant_srvitm(FBoolean Fg_enfant_srvitm) {
		setAttrVal("Fg_enfant_srvitm", Fg_enfant_srvitm);
	}
	/**
	 * 孕妇禁用
	 * @return FBoolean
	 */
	public FBoolean getFg_pregnent_srvitm() {
		return ((FBoolean) getAttrVal("Fg_pregnent_srvitm"));
	}	
	/**
	 * 孕妇禁用
	 * @param Fg_pregnent_srvitm
	 */
	public void setFg_pregnent_srvitm(FBoolean Fg_pregnent_srvitm) {
		setAttrVal("Fg_pregnent_srvitm", Fg_pregnent_srvitm);
	}
	/**
	 * 性别适用
	 * @return Integer
	 */
	public Integer getSexlimit_srvitm() {
		return ((Integer) getAttrVal("Sexlimit_srvitm"));
	}	
	/**
	 * 性别适用
	 * @param Sexlimit_srvitm
	 */
	public void setSexlimit_srvitm(Integer Sexlimit_srvitm) {
		setAttrVal("Sexlimit_srvitm", Sexlimit_srvitm);
	}
	/**
	 * 未婚禁用
	 * @return FBoolean
	 */
	public FBoolean getFg_married() {
		return ((FBoolean) getAttrVal("Fg_married"));
	}	
	/**
	 * 未婚禁用
	 * @param Fg_married
	 */
	public void setFg_married(FBoolean Fg_married) {
		setAttrVal("Fg_married", Fg_married);
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
	 * 所属目录
	 * @return Integer
	 */
	public Integer getCatlog_srvitm() {
		return ((Integer) getAttrVal("Catlog_srvitm"));
	}	
	/**
	 * 所属目录
	 * @param Catlog_srvitm
	 */
	public void setCatlog_srvitm(Integer Catlog_srvitm) {
		setAttrVal("Catlog_srvitm", Catlog_srvitm);
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
		return "Id_pesrvsetitmdef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvsetitmdef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvSetItmDefDODesc.class);
	}
	
}