package iih.nmr.pkuf.nmrdocmobdg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.nmrdocmobdg.d.desc.NmrDocMobdeDODesc;
import java.math.BigDecimal;

/**
 * 移动数据元新版 DO数据 
 * 
 */
public class NmrDocMobdeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//移动数据集主键
	public static final String ID_NMR_DOC_MOBDE= "Id_nmr_doc_mobde";
	//移动数据集合
	public static final String ID_NMR_DOC_MOBDG= "Id_nmr_doc_mobdg";
	//组件类属性
	public static final String ID_PROPERTY= "Id_property";
	//名称
	public static final String NAME= "Name";
	//编码
	public static final String CODE= "Code";
	//属性名称
	public static final String NAME_ATTR= "Name_attr";
	//控件类型id
	public static final String ID_CONTROLTP= "Id_controltp";
	//控件类型sd
	public static final String SD_CONTROLTP= "Sd_controltp";
	//排序字段
	public static final String SORTNO= "Sortno";
	//键盘
	public static final String ID_MB_KB= "Id_mb_kb";
	//算分标记
	public static final String FG_SCORE= "Fg_score";
	//移动端展示标记
	public static final String FG_SHOW= "Fg_show";
	//必填项标记
	public static final String FG_REQUIRED= "Fg_required";
	//可编辑标记
	public static final String FG_EDIT= "Fg_edit";
	//默认值标记
	public static final String FG_DEFAULT= "Fg_default";
	//默认值
	public static final String DEF_VAL= "Def_val";
	//宏标志
	public static final String FG_MARCO= "Fg_marco";
	//宏值id
	public static final String ID_MARCO= "Id_marco";
	//宏值sd
	public static final String SD_MARCO= "Sd_marco";
	//最小值
	public static final String VALMIN= "Valmin";
	//最大值
	public static final String VALMAX= "Valmax";
	//分数存储的
	public static final String ID_SORCEFIELD= "Id_sorcefield";
	//分值存储属性字段
	public static final String NAME_SORCE= "Name_sorce";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//显示名称
	public static final String NAME_DISPLAY= "Name_display";
	//名称
	public static final String NAME_PROPERTY= "Name_property";
	//名称
	public static final String NAME_CONTROLTP= "Name_controltp";
	//名称
	public static final String NAME_KB= "Name_kb";
	//名称
	public static final String NAME_MARCO= "Name_marco";
	//名称
	public static final String NAME_SORCEFIELD= "Name_sorcefield";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 移动数据集主键
	 * @return String
	 */
	public String getId_nmr_doc_mobde() {
		return ((String) getAttrVal("Id_nmr_doc_mobde"));
	}	
	/**
	 * 移动数据集主键
	 * @param Id_nmr_doc_mobde
	 */
	public void setId_nmr_doc_mobde(String Id_nmr_doc_mobde) {
		setAttrVal("Id_nmr_doc_mobde", Id_nmr_doc_mobde);
	}
	/**
	 * 移动数据集合
	 * @return String
	 */
	public String getId_nmr_doc_mobdg() {
		return ((String) getAttrVal("Id_nmr_doc_mobdg"));
	}	
	/**
	 * 移动数据集合
	 * @param Id_nmr_doc_mobdg
	 */
	public void setId_nmr_doc_mobdg(String Id_nmr_doc_mobdg) {
		setAttrVal("Id_nmr_doc_mobdg", Id_nmr_doc_mobdg);
	}
	/**
	 * 组件类属性
	 * @return String
	 */
	public String getId_property() {
		return ((String) getAttrVal("Id_property"));
	}	
	/**
	 * 组件类属性
	 * @param Id_property
	 */
	public void setId_property(String Id_property) {
		setAttrVal("Id_property", Id_property);
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
	 * 属性名称
	 * @return String
	 */
	public String getName_attr() {
		return ((String) getAttrVal("Name_attr"));
	}	
	/**
	 * 属性名称
	 * @param Name_attr
	 */
	public void setName_attr(String Name_attr) {
		setAttrVal("Name_attr", Name_attr);
	}
	/**
	 * 控件类型id
	 * @return String
	 */
	public String getId_controltp() {
		return ((String) getAttrVal("Id_controltp"));
	}	
	/**
	 * 控件类型id
	 * @param Id_controltp
	 */
	public void setId_controltp(String Id_controltp) {
		setAttrVal("Id_controltp", Id_controltp);
	}
	/**
	 * 控件类型sd
	 * @return String
	 */
	public String getSd_controltp() {
		return ((String) getAttrVal("Sd_controltp"));
	}	
	/**
	 * 控件类型sd
	 * @param Sd_controltp
	 */
	public void setSd_controltp(String Sd_controltp) {
		setAttrVal("Sd_controltp", Sd_controltp);
	}
	/**
	 * 排序字段
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 排序字段
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 键盘
	 * @return String
	 */
	public String getId_mb_kb() {
		return ((String) getAttrVal("Id_mb_kb"));
	}	
	/**
	 * 键盘
	 * @param Id_mb_kb
	 */
	public void setId_mb_kb(String Id_mb_kb) {
		setAttrVal("Id_mb_kb", Id_mb_kb);
	}
	/**
	 * 算分标记
	 * @return FBoolean
	 */
	public FBoolean getFg_score() {
		return ((FBoolean) getAttrVal("Fg_score"));
	}	
	/**
	 * 算分标记
	 * @param Fg_score
	 */
	public void setFg_score(FBoolean Fg_score) {
		setAttrVal("Fg_score", Fg_score);
	}
	/**
	 * 移动端展示标记
	 * @return FBoolean
	 */
	public FBoolean getFg_show() {
		return ((FBoolean) getAttrVal("Fg_show"));
	}	
	/**
	 * 移动端展示标记
	 * @param Fg_show
	 */
	public void setFg_show(FBoolean Fg_show) {
		setAttrVal("Fg_show", Fg_show);
	}
	/**
	 * 必填项标记
	 * @return FBoolean
	 */
	public FBoolean getFg_required() {
		return ((FBoolean) getAttrVal("Fg_required"));
	}	
	/**
	 * 必填项标记
	 * @param Fg_required
	 */
	public void setFg_required(FBoolean Fg_required) {
		setAttrVal("Fg_required", Fg_required);
	}
	/**
	 * 可编辑标记
	 * @return FBoolean
	 */
	public FBoolean getFg_edit() {
		return ((FBoolean) getAttrVal("Fg_edit"));
	}	
	/**
	 * 可编辑标记
	 * @param Fg_edit
	 */
	public void setFg_edit(FBoolean Fg_edit) {
		setAttrVal("Fg_edit", Fg_edit);
	}
	/**
	 * 默认值标记
	 * @return FBoolean
	 */
	public FBoolean getFg_default() {
		return ((FBoolean) getAttrVal("Fg_default"));
	}	
	/**
	 * 默认值标记
	 * @param Fg_default
	 */
	public void setFg_default(FBoolean Fg_default) {
		setAttrVal("Fg_default", Fg_default);
	}
	/**
	 * 默认值
	 * @return String
	 */
	public String getDef_val() {
		return ((String) getAttrVal("Def_val"));
	}	
	/**
	 * 默认值
	 * @param Def_val
	 */
	public void setDef_val(String Def_val) {
		setAttrVal("Def_val", Def_val);
	}
	/**
	 * 宏标志
	 * @return FBoolean
	 */
	public FBoolean getFg_marco() {
		return ((FBoolean) getAttrVal("Fg_marco"));
	}	
	/**
	 * 宏标志
	 * @param Fg_marco
	 */
	public void setFg_marco(FBoolean Fg_marco) {
		setAttrVal("Fg_marco", Fg_marco);
	}
	/**
	 * 宏值id
	 * @return String
	 */
	public String getId_marco() {
		return ((String) getAttrVal("Id_marco"));
	}	
	/**
	 * 宏值id
	 * @param Id_marco
	 */
	public void setId_marco(String Id_marco) {
		setAttrVal("Id_marco", Id_marco);
	}
	/**
	 * 宏值sd
	 * @return String
	 */
	public String getSd_marco() {
		return ((String) getAttrVal("Sd_marco"));
	}	
	/**
	 * 宏值sd
	 * @param Sd_marco
	 */
	public void setSd_marco(String Sd_marco) {
		setAttrVal("Sd_marco", Sd_marco);
	}
	/**
	 * 最小值
	 * @return FDouble
	 */
	public FDouble getValmin() {
		return ((FDouble) getAttrVal("Valmin"));
	}	
	/**
	 * 最小值
	 * @param Valmin
	 */
	public void setValmin(FDouble Valmin) {
		setAttrVal("Valmin", Valmin);
	}
	/**
	 * 最大值
	 * @return FDouble
	 */
	public FDouble getValmax() {
		return ((FDouble) getAttrVal("Valmax"));
	}	
	/**
	 * 最大值
	 * @param Valmax
	 */
	public void setValmax(FDouble Valmax) {
		setAttrVal("Valmax", Valmax);
	}
	/**
	 * 分数存储的
	 * @return String
	 */
	public String getId_sorcefield() {
		return ((String) getAttrVal("Id_sorcefield"));
	}	
	/**
	 * 分数存储的
	 * @param Id_sorcefield
	 */
	public void setId_sorcefield(String Id_sorcefield) {
		setAttrVal("Id_sorcefield", Id_sorcefield);
	}
	/**
	 * 分值存储属性字段
	 * @return String
	 */
	public String getName_sorce() {
		return ((String) getAttrVal("Name_sorce"));
	}	
	/**
	 * 分值存储属性字段
	 * @param Name_sorce
	 */
	public void setName_sorce(String Name_sorce) {
		setAttrVal("Name_sorce", Name_sorce);
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
	 * 显示名称
	 * @return String
	 */
	public String getName_display() {
		return ((String) getAttrVal("Name_display"));
	}	
	/**
	 * 显示名称
	 * @param Name_display
	 */
	public void setName_display(String Name_display) {
		setAttrVal("Name_display", Name_display);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_property() {
		return ((String) getAttrVal("Name_property"));
	}	
	/**
	 * 名称
	 * @param Name_property
	 */
	public void setName_property(String Name_property) {
		setAttrVal("Name_property", Name_property);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_controltp() {
		return ((String) getAttrVal("Name_controltp"));
	}	
	/**
	 * 名称
	 * @param Name_controltp
	 */
	public void setName_controltp(String Name_controltp) {
		setAttrVal("Name_controltp", Name_controltp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_kb() {
		return ((String) getAttrVal("Name_kb"));
	}	
	/**
	 * 名称
	 * @param Name_kb
	 */
	public void setName_kb(String Name_kb) {
		setAttrVal("Name_kb", Name_kb);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_marco() {
		return ((String) getAttrVal("Name_marco"));
	}	
	/**
	 * 名称
	 * @param Name_marco
	 */
	public void setName_marco(String Name_marco) {
		setAttrVal("Name_marco", Name_marco);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sorcefield() {
		return ((String) getAttrVal("Name_sorcefield"));
	}	
	/**
	 * 名称
	 * @param Name_sorcefield
	 */
	public void setName_sorcefield(String Name_sorcefield) {
		setAttrVal("Name_sorcefield", Name_sorcefield);
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
		return "Id_nmr_doc_mobde";
	}
	
	@Override
	public String getTableName() {	  
		return "nmr_doc_mobde";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmrDocMobdeDODesc.class);
	}
	
}