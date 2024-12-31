package iih.bd.srv.mrelement.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrelement.d.desc.MrElementDODesc;
import java.math.BigDecimal;

/**
 * 病历元素 DO数据 
 * 
 */
public class MrElementDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_MR_DE= "Id_mr_de";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//元素编码
	public static final String CODE= "Code";
	//元素名称
	public static final String NAME= "Name";
	//元素描述
	public static final String DES= "Des";
	//元素类型编码
	public static final String SD_MRDETP= "Sd_mrdetp";
	//元素类型主键
	public static final String ID_MRDETP= "Id_mrdetp";
	//关键字
	public static final String KEYWORDS= "Keywords";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//数据元ID
	public static final String ID_DE= "Id_de";
	//数据组ID
	public static final String ID_DG= "Id_dg";
	//排序序号
	public static final String ORDER_INDEX= "Order_index";
	//事件id
	public static final String ID_MRAET= "Id_mraet";
	//分组id
	public static final String ID_MRATERMGRP= "Id_mratermgrp";
	//提示文本
	public static final String TEXT_TIP= "Text_tip";
	//标签文本
	public static final String TEXT_LABEL= "Text_label";
	//背景文本
	public static final String TEXT_BACKGROUND= "Text_background";
	//简单级联值
	public static final String TEXT_CASCADE= "Text_cascade";
	//可见表达式
	public static final String TEXT_VISIBLE= "Text_visible";
	//是否可编辑
	public static final String FG_EDIT= "Fg_edit";
	//是否加密
	public static final String FG_ENCRYPT= "Fg_encrypt";
	//是否可删除
	public static final String FG_DELETE= "Fg_delete";
	//是否显示边框
	public static final String FG_BORDER= "Fg_border";
	//是否可隐藏
	public static final String FG_HIDE= "Fg_hide";
	//最大长度
	public static final String LG_MAX= "Lg_max";
	//最小长度
	public static final String LG_MIN= "Lg_min";
	//单位文本
	public static final String TEXT_UNIT= "Text_unit";
	//小数位数
	public static final String NU_DIGIT= "Nu_digit";
	//最大值
	public static final String NU_MAX= "Nu_max";
	//最小值
	public static final String NU_MIN= "Nu_min";
	//值域是否为sql
	public static final String FG_SQL= "Fg_sql";
	//值域SQL语句
	public static final String TEXT_SQL= "Text_sql";
	//肯定前缀
	public static final String SU_DES= "Su_des";
	//否定前缀
	public static final String NE_DES= "Ne_des";
	//时间格式
	public static final String DT_FORMAT= "Dt_format";
	//输出类型
	public static final String OUT_STYLE= "Out_style";
	//输出格式
	public static final String OUT_FORMAT= "Out_format";
	//是否为源
	public static final String FG_QS= "Fg_qs";
	//源名称
	public static final String NAME_SOURCE= "Name_source";
	//属性名称
	public static final String NAME_PROPERTY= "Name_property";
	//是否为引用
	public static final String FG_QUOTE= "Fg_quote";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//参照名称
	public static final String REF_NAME= "Ref_name";
	//参照编码
	public static final String REF_CODE= "Ref_code";
	//激活方式
	public static final String ACTIVEMETHOD= "Activemethod";
	//是否多选
	public static final String IS_MANY_SELECT= "Is_many_select";
	//纵向布局
	public static final String IS_VERTICAL_LAYOUT= "Is_vertical_layout";
	//格式字符串
	public static final String FORMAT_STR= "Format_str";
	//占位符个数
	public static final String NU_PLACEHOLDER= "Nu_placeholder";
	//下划线
	public static final String FG_UNDERLINE= "Fg_underline";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//组织编码
	public static final String CODE_ORG= "Code_org";
	//编码
	public static final String CODE_GRP= "Code_grp";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//元素类型编码
	public static final String CODE_MRDETP= "Code_mrdetp";
	//类型名称
	public static final String NAME_MRDETP= "Name_mrdetp";
	//编码
	public static final String CODE_DE= "Code_de";
	//名称
	public static final String NAME_DE= "Name_de";
	//数据组编码
	public static final String CODE_DG= "Code_dg";
	//数据组名称
	public static final String NAME_DG= "Name_dg";
	//事件编码
	public static final String CODE_MRAET= "Code_mraet";
	//事件名称
	public static final String NAME_MRAET= "Name_mraet";
	//编码
	public static final String CODE_MRATERMGRP= "Code_mratermgrp";
	//名称
	public static final String NAME_MRATERMGRP= "Name_mratermgrp";
	//编码
	public static final String CODE_OUT_STYLE= "Code_out_style";
	//名称
	public static final String NAME_OUT_STYLE= "Name_out_style";
	//编码
	public static final String CODE_OUT_FORMAT= "Code_out_format";
	//名称
	public static final String NAME_OUT_FORMAT= "Name_out_format";
	//用户编码
	public static final String CODE_CREATE= "Code_create";
	//用户名称
	public static final String NAME_CREATE= "Name_create";
	//用户名称
	public static final String NAME_MODIFY= "Name_modify";
	//用户编码
	public static final String CODE_MODIFY= "Code_modify";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_mr_de() {
		return ((String) getAttrVal("Id_mr_de"));
	}	
	/**
	 * 主键
	 * @param Id_mr_de
	 */
	public void setId_mr_de(String Id_mr_de) {
		setAttrVal("Id_mr_de", Id_mr_de);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 元素编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 元素编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 元素名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 元素名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 元素描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 元素描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 元素类型编码
	 * @return String
	 */
	public String getSd_mrdetp() {
		return ((String) getAttrVal("Sd_mrdetp"));
	}	
	/**
	 * 元素类型编码
	 * @param Sd_mrdetp
	 */
	public void setSd_mrdetp(String Sd_mrdetp) {
		setAttrVal("Sd_mrdetp", Sd_mrdetp);
	}
	/**
	 * 元素类型主键
	 * @return String
	 */
	public String getId_mrdetp() {
		return ((String) getAttrVal("Id_mrdetp"));
	}	
	/**
	 * 元素类型主键
	 * @param Id_mrdetp
	 */
	public void setId_mrdetp(String Id_mrdetp) {
		setAttrVal("Id_mrdetp", Id_mrdetp);
	}
	/**
	 * 关键字
	 * @return String
	 */
	public String getKeywords() {
		return ((String) getAttrVal("Keywords"));
	}	
	/**
	 * 关键字
	 * @param Keywords
	 */
	public void setKeywords(String Keywords) {
		setAttrVal("Keywords", Keywords);
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
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 数据元ID
	 * @return String
	 */
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	/**
	 * 数据元ID
	 * @param Id_de
	 */
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	/**
	 * 数据组ID
	 * @return String
	 */
	public String getId_dg() {
		return ((String) getAttrVal("Id_dg"));
	}	
	/**
	 * 数据组ID
	 * @param Id_dg
	 */
	public void setId_dg(String Id_dg) {
		setAttrVal("Id_dg", Id_dg);
	}
	/**
	 * 排序序号
	 * @return Integer
	 */
	public Integer getOrder_index() {
		return ((Integer) getAttrVal("Order_index"));
	}	
	/**
	 * 排序序号
	 * @param Order_index
	 */
	public void setOrder_index(Integer Order_index) {
		setAttrVal("Order_index", Order_index);
	}
	/**
	 * 事件id
	 * @return String
	 */
	public String getId_mraet() {
		return ((String) getAttrVal("Id_mraet"));
	}	
	/**
	 * 事件id
	 * @param Id_mraet
	 */
	public void setId_mraet(String Id_mraet) {
		setAttrVal("Id_mraet", Id_mraet);
	}
	/**
	 * 分组id
	 * @return String
	 */
	public String getId_mratermgrp() {
		return ((String) getAttrVal("Id_mratermgrp"));
	}	
	/**
	 * 分组id
	 * @param Id_mratermgrp
	 */
	public void setId_mratermgrp(String Id_mratermgrp) {
		setAttrVal("Id_mratermgrp", Id_mratermgrp);
	}
	/**
	 * 提示文本
	 * @return String
	 */
	public String getText_tip() {
		return ((String) getAttrVal("Text_tip"));
	}	
	/**
	 * 提示文本
	 * @param Text_tip
	 */
	public void setText_tip(String Text_tip) {
		setAttrVal("Text_tip", Text_tip);
	}
	/**
	 * 标签文本
	 * @return String
	 */
	public String getText_label() {
		return ((String) getAttrVal("Text_label"));
	}	
	/**
	 * 标签文本
	 * @param Text_label
	 */
	public void setText_label(String Text_label) {
		setAttrVal("Text_label", Text_label);
	}
	/**
	 * 背景文本
	 * @return String
	 */
	public String getText_background() {
		return ((String) getAttrVal("Text_background"));
	}	
	/**
	 * 背景文本
	 * @param Text_background
	 */
	public void setText_background(String Text_background) {
		setAttrVal("Text_background", Text_background);
	}
	/**
	 * 简单级联值
	 * @return String
	 */
	public String getText_cascade() {
		return ((String) getAttrVal("Text_cascade"));
	}	
	/**
	 * 简单级联值
	 * @param Text_cascade
	 */
	public void setText_cascade(String Text_cascade) {
		setAttrVal("Text_cascade", Text_cascade);
	}
	/**
	 * 可见表达式
	 * @return String
	 */
	public String getText_visible() {
		return ((String) getAttrVal("Text_visible"));
	}	
	/**
	 * 可见表达式
	 * @param Text_visible
	 */
	public void setText_visible(String Text_visible) {
		setAttrVal("Text_visible", Text_visible);
	}
	/**
	 * 是否可编辑
	 * @return FBoolean
	 */
	public FBoolean getFg_edit() {
		return ((FBoolean) getAttrVal("Fg_edit"));
	}	
	/**
	 * 是否可编辑
	 * @param Fg_edit
	 */
	public void setFg_edit(FBoolean Fg_edit) {
		setAttrVal("Fg_edit", Fg_edit);
	}
	/**
	 * 是否加密
	 * @return FBoolean
	 */
	public FBoolean getFg_encrypt() {
		return ((FBoolean) getAttrVal("Fg_encrypt"));
	}	
	/**
	 * 是否加密
	 * @param Fg_encrypt
	 */
	public void setFg_encrypt(FBoolean Fg_encrypt) {
		setAttrVal("Fg_encrypt", Fg_encrypt);
	}
	/**
	 * 是否可删除
	 * @return FBoolean
	 */
	public FBoolean getFg_delete() {
		return ((FBoolean) getAttrVal("Fg_delete"));
	}	
	/**
	 * 是否可删除
	 * @param Fg_delete
	 */
	public void setFg_delete(FBoolean Fg_delete) {
		setAttrVal("Fg_delete", Fg_delete);
	}
	/**
	 * 是否显示边框
	 * @return FBoolean
	 */
	public FBoolean getFg_border() {
		return ((FBoolean) getAttrVal("Fg_border"));
	}	
	/**
	 * 是否显示边框
	 * @param Fg_border
	 */
	public void setFg_border(FBoolean Fg_border) {
		setAttrVal("Fg_border", Fg_border);
	}
	/**
	 * 是否可隐藏
	 * @return FBoolean
	 */
	public FBoolean getFg_hide() {
		return ((FBoolean) getAttrVal("Fg_hide"));
	}	
	/**
	 * 是否可隐藏
	 * @param Fg_hide
	 */
	public void setFg_hide(FBoolean Fg_hide) {
		setAttrVal("Fg_hide", Fg_hide);
	}
	/**
	 * 最大长度
	 * @return Integer
	 */
	public Integer getLg_max() {
		return ((Integer) getAttrVal("Lg_max"));
	}	
	/**
	 * 最大长度
	 * @param Lg_max
	 */
	public void setLg_max(Integer Lg_max) {
		setAttrVal("Lg_max", Lg_max);
	}
	/**
	 * 最小长度
	 * @return Integer
	 */
	public Integer getLg_min() {
		return ((Integer) getAttrVal("Lg_min"));
	}	
	/**
	 * 最小长度
	 * @param Lg_min
	 */
	public void setLg_min(Integer Lg_min) {
		setAttrVal("Lg_min", Lg_min);
	}
	/**
	 * 单位文本
	 * @return String
	 */
	public String getText_unit() {
		return ((String) getAttrVal("Text_unit"));
	}	
	/**
	 * 单位文本
	 * @param Text_unit
	 */
	public void setText_unit(String Text_unit) {
		setAttrVal("Text_unit", Text_unit);
	}
	/**
	 * 小数位数
	 * @return Integer
	 */
	public Integer getNu_digit() {
		return ((Integer) getAttrVal("Nu_digit"));
	}	
	/**
	 * 小数位数
	 * @param Nu_digit
	 */
	public void setNu_digit(Integer Nu_digit) {
		setAttrVal("Nu_digit", Nu_digit);
	}
	/**
	 * 最大值
	 * @return FDouble
	 */
	public FDouble getNu_max() {
		return ((FDouble) getAttrVal("Nu_max"));
	}	
	/**
	 * 最大值
	 * @param Nu_max
	 */
	public void setNu_max(FDouble Nu_max) {
		setAttrVal("Nu_max", Nu_max);
	}
	/**
	 * 最小值
	 * @return FDouble
	 */
	public FDouble getNu_min() {
		return ((FDouble) getAttrVal("Nu_min"));
	}	
	/**
	 * 最小值
	 * @param Nu_min
	 */
	public void setNu_min(FDouble Nu_min) {
		setAttrVal("Nu_min", Nu_min);
	}
	/**
	 * 值域是否为sql
	 * @return FBoolean
	 */
	public FBoolean getFg_sql() {
		return ((FBoolean) getAttrVal("Fg_sql"));
	}	
	/**
	 * 值域是否为sql
	 * @param Fg_sql
	 */
	public void setFg_sql(FBoolean Fg_sql) {
		setAttrVal("Fg_sql", Fg_sql);
	}
	/**
	 * 值域SQL语句
	 * @return String
	 */
	public String getText_sql() {
		return ((String) getAttrVal("Text_sql"));
	}	
	/**
	 * 值域SQL语句
	 * @param Text_sql
	 */
	public void setText_sql(String Text_sql) {
		setAttrVal("Text_sql", Text_sql);
	}
	/**
	 * 肯定前缀
	 * @return String
	 */
	public String getSu_des() {
		return ((String) getAttrVal("Su_des"));
	}	
	/**
	 * 肯定前缀
	 * @param Su_des
	 */
	public void setSu_des(String Su_des) {
		setAttrVal("Su_des", Su_des);
	}
	/**
	 * 否定前缀
	 * @return String
	 */
	public String getNe_des() {
		return ((String) getAttrVal("Ne_des"));
	}	
	/**
	 * 否定前缀
	 * @param Ne_des
	 */
	public void setNe_des(String Ne_des) {
		setAttrVal("Ne_des", Ne_des);
	}
	/**
	 * 时间格式
	 * @return String
	 */
	public String getDt_format() {
		return ((String) getAttrVal("Dt_format"));
	}	
	/**
	 * 时间格式
	 * @param Dt_format
	 */
	public void setDt_format(String Dt_format) {
		setAttrVal("Dt_format", Dt_format);
	}
	/**
	 * 输出类型
	 * @return String
	 */
	public String getOut_style() {
		return ((String) getAttrVal("Out_style"));
	}	
	/**
	 * 输出类型
	 * @param Out_style
	 */
	public void setOut_style(String Out_style) {
		setAttrVal("Out_style", Out_style);
	}
	/**
	 * 输出格式
	 * @return String
	 */
	public String getOut_format() {
		return ((String) getAttrVal("Out_format"));
	}	
	/**
	 * 输出格式
	 * @param Out_format
	 */
	public void setOut_format(String Out_format) {
		setAttrVal("Out_format", Out_format);
	}
	/**
	 * 是否为源
	 * @return FBoolean
	 */
	public FBoolean getFg_qs() {
		return ((FBoolean) getAttrVal("Fg_qs"));
	}	
	/**
	 * 是否为源
	 * @param Fg_qs
	 */
	public void setFg_qs(FBoolean Fg_qs) {
		setAttrVal("Fg_qs", Fg_qs);
	}
	/**
	 * 源名称
	 * @return String
	 */
	public String getName_source() {
		return ((String) getAttrVal("Name_source"));
	}	
	/**
	 * 源名称
	 * @param Name_source
	 */
	public void setName_source(String Name_source) {
		setAttrVal("Name_source", Name_source);
	}
	/**
	 * 属性名称
	 * @return String
	 */
	public String getName_property() {
		return ((String) getAttrVal("Name_property"));
	}	
	/**
	 * 属性名称
	 * @param Name_property
	 */
	public void setName_property(String Name_property) {
		setAttrVal("Name_property", Name_property);
	}
	/**
	 * 是否为引用
	 * @return FBoolean
	 */
	public FBoolean getFg_quote() {
		return ((FBoolean) getAttrVal("Fg_quote"));
	}	
	/**
	 * 是否为引用
	 * @param Fg_quote
	 */
	public void setFg_quote(FBoolean Fg_quote) {
		setAttrVal("Fg_quote", Fg_quote);
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
	 * 参照名称
	 * @return String
	 */
	public String getRef_name() {
		return ((String) getAttrVal("Ref_name"));
	}	
	/**
	 * 参照名称
	 * @param Ref_name
	 */
	public void setRef_name(String Ref_name) {
		setAttrVal("Ref_name", Ref_name);
	}
	/**
	 * 参照编码
	 * @return String
	 */
	public String getRef_code() {
		return ((String) getAttrVal("Ref_code"));
	}	
	/**
	 * 参照编码
	 * @param Ref_code
	 */
	public void setRef_code(String Ref_code) {
		setAttrVal("Ref_code", Ref_code);
	}
	/**
	 * 激活方式
	 * @return Integer
	 */
	public Integer getActivemethod() {
		return ((Integer) getAttrVal("Activemethod"));
	}	
	/**
	 * 激活方式
	 * @param Activemethod
	 */
	public void setActivemethod(Integer Activemethod) {
		setAttrVal("Activemethod", Activemethod);
	}
	/**
	 * 是否多选
	 * @return FBoolean
	 */
	public FBoolean getIs_many_select() {
		return ((FBoolean) getAttrVal("Is_many_select"));
	}	
	/**
	 * 是否多选
	 * @param Is_many_select
	 */
	public void setIs_many_select(FBoolean Is_many_select) {
		setAttrVal("Is_many_select", Is_many_select);
	}
	/**
	 * 纵向布局
	 * @return FBoolean
	 */
	public FBoolean getIs_vertical_layout() {
		return ((FBoolean) getAttrVal("Is_vertical_layout"));
	}	
	/**
	 * 纵向布局
	 * @param Is_vertical_layout
	 */
	public void setIs_vertical_layout(FBoolean Is_vertical_layout) {
		setAttrVal("Is_vertical_layout", Is_vertical_layout);
	}
	/**
	 * 格式字符串
	 * @return String
	 */
	public String getFormat_str() {
		return ((String) getAttrVal("Format_str"));
	}	
	/**
	 * 格式字符串
	 * @param Format_str
	 */
	public void setFormat_str(String Format_str) {
		setAttrVal("Format_str", Format_str);
	}
	/**
	 * 占位符个数
	 * @return Integer
	 */
	public Integer getNu_placeholder() {
		return ((Integer) getAttrVal("Nu_placeholder"));
	}	
	/**
	 * 占位符个数
	 * @param Nu_placeholder
	 */
	public void setNu_placeholder(Integer Nu_placeholder) {
		setAttrVal("Nu_placeholder", Nu_placeholder);
	}
	/**
	 * 下划线
	 * @return FBoolean
	 */
	public FBoolean getFg_underline() {
		return ((FBoolean) getAttrVal("Fg_underline"));
	}	
	/**
	 * 下划线
	 * @param Fg_underline
	 */
	public void setFg_underline(FBoolean Fg_underline) {
		setAttrVal("Fg_underline", Fg_underline);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	/**
	 * 组织编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	/**
	 * 编码
	 * @param Code_grp
	 */
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 元素类型编码
	 * @return String
	 */
	public String getCode_mrdetp() {
		return ((String) getAttrVal("Code_mrdetp"));
	}	
	/**
	 * 元素类型编码
	 * @param Code_mrdetp
	 */
	public void setCode_mrdetp(String Code_mrdetp) {
		setAttrVal("Code_mrdetp", Code_mrdetp);
	}
	/**
	 * 类型名称
	 * @return String
	 */
	public String getName_mrdetp() {
		return ((String) getAttrVal("Name_mrdetp"));
	}	
	/**
	 * 类型名称
	 * @param Name_mrdetp
	 */
	public void setName_mrdetp(String Name_mrdetp) {
		setAttrVal("Name_mrdetp", Name_mrdetp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_de() {
		return ((String) getAttrVal("Code_de"));
	}	
	/**
	 * 编码
	 * @param Code_de
	 */
	public void setCode_de(String Code_de) {
		setAttrVal("Code_de", Code_de);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_de() {
		return ((String) getAttrVal("Name_de"));
	}	
	/**
	 * 名称
	 * @param Name_de
	 */
	public void setName_de(String Name_de) {
		setAttrVal("Name_de", Name_de);
	}
	/**
	 * 数据组编码
	 * @return String
	 */
	public String getCode_dg() {
		return ((String) getAttrVal("Code_dg"));
	}	
	/**
	 * 数据组编码
	 * @param Code_dg
	 */
	public void setCode_dg(String Code_dg) {
		setAttrVal("Code_dg", Code_dg);
	}
	/**
	 * 数据组名称
	 * @return String
	 */
	public String getName_dg() {
		return ((String) getAttrVal("Name_dg"));
	}	
	/**
	 * 数据组名称
	 * @param Name_dg
	 */
	public void setName_dg(String Name_dg) {
		setAttrVal("Name_dg", Name_dg);
	}
	/**
	 * 事件编码
	 * @return String
	 */
	public String getCode_mraet() {
		return ((String) getAttrVal("Code_mraet"));
	}	
	/**
	 * 事件编码
	 * @param Code_mraet
	 */
	public void setCode_mraet(String Code_mraet) {
		setAttrVal("Code_mraet", Code_mraet);
	}
	/**
	 * 事件名称
	 * @return String
	 */
	public String getName_mraet() {
		return ((String) getAttrVal("Name_mraet"));
	}	
	/**
	 * 事件名称
	 * @param Name_mraet
	 */
	public void setName_mraet(String Name_mraet) {
		setAttrVal("Name_mraet", Name_mraet);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_mratermgrp() {
		return ((String) getAttrVal("Code_mratermgrp"));
	}	
	/**
	 * 编码
	 * @param Code_mratermgrp
	 */
	public void setCode_mratermgrp(String Code_mratermgrp) {
		setAttrVal("Code_mratermgrp", Code_mratermgrp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_mratermgrp() {
		return ((String) getAttrVal("Name_mratermgrp"));
	}	
	/**
	 * 名称
	 * @param Name_mratermgrp
	 */
	public void setName_mratermgrp(String Name_mratermgrp) {
		setAttrVal("Name_mratermgrp", Name_mratermgrp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_out_style() {
		return ((String) getAttrVal("Code_out_style"));
	}	
	/**
	 * 编码
	 * @param Code_out_style
	 */
	public void setCode_out_style(String Code_out_style) {
		setAttrVal("Code_out_style", Code_out_style);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_out_style() {
		return ((String) getAttrVal("Name_out_style"));
	}	
	/**
	 * 名称
	 * @param Name_out_style
	 */
	public void setName_out_style(String Name_out_style) {
		setAttrVal("Name_out_style", Name_out_style);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_out_format() {
		return ((String) getAttrVal("Code_out_format"));
	}	
	/**
	 * 编码
	 * @param Code_out_format
	 */
	public void setCode_out_format(String Code_out_format) {
		setAttrVal("Code_out_format", Code_out_format);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_out_format() {
		return ((String) getAttrVal("Name_out_format"));
	}	
	/**
	 * 名称
	 * @param Name_out_format
	 */
	public void setName_out_format(String Name_out_format) {
		setAttrVal("Name_out_format", Name_out_format);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_create() {
		return ((String) getAttrVal("Code_create"));
	}	
	/**
	 * 用户编码
	 * @param Code_create
	 */
	public void setCode_create(String Code_create) {
		setAttrVal("Code_create", Code_create);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_create() {
		return ((String) getAttrVal("Name_create"));
	}	
	/**
	 * 用户名称
	 * @param Name_create
	 */
	public void setName_create(String Name_create) {
		setAttrVal("Name_create", Name_create);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_modify() {
		return ((String) getAttrVal("Name_modify"));
	}	
	/**
	 * 用户名称
	 * @param Name_modify
	 */
	public void setName_modify(String Name_modify) {
		setAttrVal("Name_modify", Name_modify);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_modify() {
		return ((String) getAttrVal("Code_modify"));
	}	
	/**
	 * 用户编码
	 * @param Code_modify
	 */
	public void setCode_modify(String Code_modify) {
		setAttrVal("Code_modify", Code_modify);
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
		return "Id_mr_de";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mr_de";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrElementDODesc.class);
	}
	
}