package iih.pe.pitm.pesrvitem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvitem.d.desc.PeSrvitmOptsDODesc;
import java.math.BigDecimal;

/**
 * 体检项目可选项关联 DO数据 
 * 
 */
public class PeSrvitmOptsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检结果可选项主键定义
	public static final String ID_PESRVITMOPTS= "Id_pesrvitmopts";
	//体检结果ID
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	//体检结果可选项定义ID
	public static final String ID_PESRVITMOPTDEF= "Id_pesrvitmoptdef";
	//序号
	public static final String SORTNO= "Sortno";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//结果编码
	public static final String CODE= "Code";
	//结果名称
	public static final String NAME= "Name";
	//体检诊断ID
	public static final String ID_PERSTDIDEF= "Id_perstdidef";
	//默认标识
	public static final String FG_DEFAULT= "Fg_default";
	//异常标识
	public static final String FG_ABN= "Fg_abn";
	//阳性标识
	public static final String FG_POSI= "Fg_posi";
	//体检结果编码
	public static final String SD_ITEM= "Sd_item";
	//使用频率
	public static final String FREQ= "Freq";
	//编码
	public static final String CODE_OPT= "Code_opt";
	//名称
	public static final String NAME_OPT= "Name_opt";
	//诊断名称
	public static final String NAME_DI= "Name_di";
	//直连建议
	public static final String ADVICE_DI= "Advice_di";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检结果可选项主键定义
	 * @return String
	 */
	public String getId_pesrvitmopts() {
		return ((String) getAttrVal("Id_pesrvitmopts"));
	}	
	/**
	 * 体检结果可选项主键定义
	 * @param Id_pesrvitmopts
	 */
	public void setId_pesrvitmopts(String Id_pesrvitmopts) {
		setAttrVal("Id_pesrvitmopts", Id_pesrvitmopts);
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
	 * 体检结果可选项定义ID
	 * @return String
	 */
	public String getId_pesrvitmoptdef() {
		return ((String) getAttrVal("Id_pesrvitmoptdef"));
	}	
	/**
	 * 体检结果可选项定义ID
	 * @param Id_pesrvitmoptdef
	 */
	public void setId_pesrvitmoptdef(String Id_pesrvitmoptdef) {
		setAttrVal("Id_pesrvitmoptdef", Id_pesrvitmoptdef);
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
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	 * 结果编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 结果编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 结果名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 结果名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 体检诊断ID
	 * @return String
	 */
	public String getId_perstdidef() {
		return ((String) getAttrVal("Id_perstdidef"));
	}	
	/**
	 * 体检诊断ID
	 * @param Id_perstdidef
	 */
	public void setId_perstdidef(String Id_perstdidef) {
		setAttrVal("Id_perstdidef", Id_perstdidef);
	}
	/**
	 * 默认标识
	 * @return FBoolean
	 */
	public FBoolean getFg_default() {
		return ((FBoolean) getAttrVal("Fg_default"));
	}	
	/**
	 * 默认标识
	 * @param Fg_default
	 */
	public void setFg_default(FBoolean Fg_default) {
		setAttrVal("Fg_default", Fg_default);
	}
	/**
	 * 异常标识
	 * @return FBoolean
	 */
	public FBoolean getFg_abn() {
		return ((FBoolean) getAttrVal("Fg_abn"));
	}	
	/**
	 * 异常标识
	 * @param Fg_abn
	 */
	public void setFg_abn(FBoolean Fg_abn) {
		setAttrVal("Fg_abn", Fg_abn);
	}
	/**
	 * 阳性标识
	 * @return FBoolean
	 */
	public FBoolean getFg_posi() {
		return ((FBoolean) getAttrVal("Fg_posi"));
	}	
	/**
	 * 阳性标识
	 * @param Fg_posi
	 */
	public void setFg_posi(FBoolean Fg_posi) {
		setAttrVal("Fg_posi", Fg_posi);
	}
	/**
	 * 体检结果编码
	 * @return String
	 */
	public String getSd_item() {
		return ((String) getAttrVal("Sd_item"));
	}	
	/**
	 * 体检结果编码
	 * @param Sd_item
	 */
	public void setSd_item(String Sd_item) {
		setAttrVal("Sd_item", Sd_item);
	}
	/**
	 * 使用频率
	 * @return FDouble
	 */
	public FDouble getFreq() {
		return ((FDouble) getAttrVal("Freq"));
	}	
	/**
	 * 使用频率
	 * @param Freq
	 */
	public void setFreq(FDouble Freq) {
		setAttrVal("Freq", Freq);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_opt() {
		return ((String) getAttrVal("Code_opt"));
	}	
	/**
	 * 编码
	 * @param Code_opt
	 */
	public void setCode_opt(String Code_opt) {
		setAttrVal("Code_opt", Code_opt);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_opt() {
		return ((String) getAttrVal("Name_opt"));
	}	
	/**
	 * 名称
	 * @param Name_opt
	 */
	public void setName_opt(String Name_opt) {
		setAttrVal("Name_opt", Name_opt);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	/**
	 * 诊断名称
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 直连建议
	 * @return String
	 */
	public String getAdvice_di() {
		return ((String) getAttrVal("Advice_di"));
	}	
	/**
	 * 直连建议
	 * @param Advice_di
	 */
	public void setAdvice_di(String Advice_di) {
		setAttrVal("Advice_di", Advice_di);
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
		return "Id_pesrvitmopts";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvitmopts";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvitmOptsDODesc.class);
	}
	
}