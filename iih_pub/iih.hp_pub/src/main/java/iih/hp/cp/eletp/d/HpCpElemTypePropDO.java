package iih.hp.cp.eletp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.eletp.d.desc.HpCpElemTypePropDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素类型属性面板配置 DO数据 
 * 
 */
public class HpCpElemTypePropDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//元素类型属性ID
	public static final String ID_ELETPPPE= "Id_eletpppe";
	//元素类型ID
	public static final String ID_ELETP= "Id_eletp";
	//属性名称
	public static final String NAME= "Name";
	//属性编码
	public static final String CODE= "Code";
	//属性分组ID
	public static final String ID_PPE_GRP= "Id_ppe_grp";
	//属性分组编码
	public static final String SD_PPE_GRP= "Sd_ppe_grp";
	//属性组内序号
	public static final String SERIALNO= "Serialno";
	//属性编辑类型
	public static final String EU_CTRL_TP= "Eu_ctrl_tp";
	//属性默认值
	public static final String DEFAULT_VAL= "Default_val";
	//参照编码
	public static final String REFCODE= "Refcode";
	//参照过滤器
	public static final String REFFILTER= "Reffilter";
	//参照储存列名
	public static final String REF_SAVE_COL= "Ref_save_col";
	//参照是否支持多选
	public static final String FG_REF_MULTI= "Fg_ref_multi";
	//是否可编辑
	public static final String FG_EDITABLE= "Fg_editable";
	//是否必填
	public static final String FG_REQUIRED= "Fg_required";
	//DO路径
	public static final String DATAOBJ= "Dataobj";
	//DO属性
	public static final String DOPPE= "Doppe";
	//属性值检查类型
	public static final String ID_VALCHK_TP= "Id_valchk_tp";
	//属性值检查类型编码
	public static final String SD_VALCHK_TP= "Sd_valchk_tp";
	//描述
	public static final String DES= "Des";
	//名称
	public static final String NAME_PPE_GRP= "Name_ppe_grp";
	//排序字段
	public static final String SEQNO= "Seqno";
	//值检查类型
	public static final String NAME_VALCHK_TP= "Name_valchk_tp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 元素类型属性ID
	 * @return String
	 */
	public String getId_eletpppe() {
		return ((String) getAttrVal("Id_eletpppe"));
	}	
	/**
	 * 元素类型属性ID
	 * @param Id_eletpppe
	 */
	public void setId_eletpppe(String Id_eletpppe) {
		setAttrVal("Id_eletpppe", Id_eletpppe);
	}
	/**
	 * 元素类型ID
	 * @return String
	 */
	public String getId_eletp() {
		return ((String) getAttrVal("Id_eletp"));
	}	
	/**
	 * 元素类型ID
	 * @param Id_eletp
	 */
	public void setId_eletp(String Id_eletp) {
		setAttrVal("Id_eletp", Id_eletp);
	}
	/**
	 * 属性名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 属性名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 属性编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 属性编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 属性分组ID
	 * @return String
	 */
	public String getId_ppe_grp() {
		return ((String) getAttrVal("Id_ppe_grp"));
	}	
	/**
	 * 属性分组ID
	 * @param Id_ppe_grp
	 */
	public void setId_ppe_grp(String Id_ppe_grp) {
		setAttrVal("Id_ppe_grp", Id_ppe_grp);
	}
	/**
	 * 属性分组编码
	 * @return String
	 */
	public String getSd_ppe_grp() {
		return ((String) getAttrVal("Sd_ppe_grp"));
	}	
	/**
	 * 属性分组编码
	 * @param Sd_ppe_grp
	 */
	public void setSd_ppe_grp(String Sd_ppe_grp) {
		setAttrVal("Sd_ppe_grp", Sd_ppe_grp);
	}
	/**
	 * 属性组内序号
	 * @return Integer
	 */
	public Integer getSerialno() {
		return ((Integer) getAttrVal("Serialno"));
	}	
	/**
	 * 属性组内序号
	 * @param Serialno
	 */
	public void setSerialno(Integer Serialno) {
		setAttrVal("Serialno", Serialno);
	}
	/**
	 * 属性编辑类型
	 * @return Integer
	 */
	public Integer getEu_ctrl_tp() {
		return ((Integer) getAttrVal("Eu_ctrl_tp"));
	}	
	/**
	 * 属性编辑类型
	 * @param Eu_ctrl_tp
	 */
	public void setEu_ctrl_tp(Integer Eu_ctrl_tp) {
		setAttrVal("Eu_ctrl_tp", Eu_ctrl_tp);
	}
	/**
	 * 属性默认值
	 * @return String
	 */
	public String getDefault_val() {
		return ((String) getAttrVal("Default_val"));
	}	
	/**
	 * 属性默认值
	 * @param Default_val
	 */
	public void setDefault_val(String Default_val) {
		setAttrVal("Default_val", Default_val);
	}
	/**
	 * 参照编码
	 * @return String
	 */
	public String getRefcode() {
		return ((String) getAttrVal("Refcode"));
	}	
	/**
	 * 参照编码
	 * @param Refcode
	 */
	public void setRefcode(String Refcode) {
		setAttrVal("Refcode", Refcode);
	}
	/**
	 * 参照过滤器
	 * @return String
	 */
	public String getReffilter() {
		return ((String) getAttrVal("Reffilter"));
	}	
	/**
	 * 参照过滤器
	 * @param Reffilter
	 */
	public void setReffilter(String Reffilter) {
		setAttrVal("Reffilter", Reffilter);
	}
	/**
	 * 参照储存列名
	 * @return String
	 */
	public String getRef_save_col() {
		return ((String) getAttrVal("Ref_save_col"));
	}	
	/**
	 * 参照储存列名
	 * @param Ref_save_col
	 */
	public void setRef_save_col(String Ref_save_col) {
		setAttrVal("Ref_save_col", Ref_save_col);
	}
	/**
	 * 参照是否支持多选
	 * @return FBoolean
	 */
	public FBoolean getFg_ref_multi() {
		return ((FBoolean) getAttrVal("Fg_ref_multi"));
	}	
	/**
	 * 参照是否支持多选
	 * @param Fg_ref_multi
	 */
	public void setFg_ref_multi(FBoolean Fg_ref_multi) {
		setAttrVal("Fg_ref_multi", Fg_ref_multi);
	}
	/**
	 * 是否可编辑
	 * @return FBoolean
	 */
	public FBoolean getFg_editable() {
		return ((FBoolean) getAttrVal("Fg_editable"));
	}	
	/**
	 * 是否可编辑
	 * @param Fg_editable
	 */
	public void setFg_editable(FBoolean Fg_editable) {
		setAttrVal("Fg_editable", Fg_editable);
	}
	/**
	 * 是否必填
	 * @return FBoolean
	 */
	public FBoolean getFg_required() {
		return ((FBoolean) getAttrVal("Fg_required"));
	}	
	/**
	 * 是否必填
	 * @param Fg_required
	 */
	public void setFg_required(FBoolean Fg_required) {
		setAttrVal("Fg_required", Fg_required);
	}
	/**
	 * DO路径
	 * @return String
	 */
	public String getDataobj() {
		return ((String) getAttrVal("Dataobj"));
	}	
	/**
	 * DO路径
	 * @param Dataobj
	 */
	public void setDataobj(String Dataobj) {
		setAttrVal("Dataobj", Dataobj);
	}
	/**
	 * DO属性
	 * @return String
	 */
	public String getDoppe() {
		return ((String) getAttrVal("Doppe"));
	}	
	/**
	 * DO属性
	 * @param Doppe
	 */
	public void setDoppe(String Doppe) {
		setAttrVal("Doppe", Doppe);
	}
	/**
	 * 属性值检查类型
	 * @return String
	 */
	public String getId_valchk_tp() {
		return ((String) getAttrVal("Id_valchk_tp"));
	}	
	/**
	 * 属性值检查类型
	 * @param Id_valchk_tp
	 */
	public void setId_valchk_tp(String Id_valchk_tp) {
		setAttrVal("Id_valchk_tp", Id_valchk_tp);
	}
	/**
	 * 属性值检查类型编码
	 * @return String
	 */
	public String getSd_valchk_tp() {
		return ((String) getAttrVal("Sd_valchk_tp"));
	}	
	/**
	 * 属性值检查类型编码
	 * @param Sd_valchk_tp
	 */
	public void setSd_valchk_tp(String Sd_valchk_tp) {
		setAttrVal("Sd_valchk_tp", Sd_valchk_tp);
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
	 * 名称
	 * @return String
	 */
	public String getName_ppe_grp() {
		return ((String) getAttrVal("Name_ppe_grp"));
	}	
	/**
	 * 名称
	 * @param Name_ppe_grp
	 */
	public void setName_ppe_grp(String Name_ppe_grp) {
		setAttrVal("Name_ppe_grp", Name_ppe_grp);
	}
	/**
	 * 排序字段
	 * @return Integer
	 */
	public Integer getSeqno() {
		return ((Integer) getAttrVal("Seqno"));
	}	
	/**
	 * 排序字段
	 * @param Seqno
	 */
	public void setSeqno(Integer Seqno) {
		setAttrVal("Seqno", Seqno);
	}
	/**
	 * 值检查类型
	 * @return String
	 */
	public String getName_valchk_tp() {
		return ((String) getAttrVal("Name_valchk_tp"));
	}	
	/**
	 * 值检查类型
	 * @param Name_valchk_tp
	 */
	public void setName_valchk_tp(String Name_valchk_tp) {
		setAttrVal("Name_valchk_tp", Name_valchk_tp);
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
		return "Id_eletpppe";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELETP_PPE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemTypePropDODesc.class);
	}
	
}