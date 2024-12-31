package iih.bd.fc.tagtp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.tagtp.d.desc.BdTagTpDODesc;
import java.math.BigDecimal;

/**
 * 标签 DO数据 
 * 
 */
public class BdTagTpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//标签id
	public static final String ID_TAGTP= "Id_tagtp";
	//集团id
	public static final String ID_GRP= "Id_grp";
	//组织id
	public static final String ID_ORG= "Id_org";
	//标签类型id
	public static final String ID_TP= "Id_tp";
	//标签类型sd
	public static final String SD_TP= "Sd_tp";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//简称
	public static final String SHORTNAME= "Shortname";
	//管理范围
	public static final String EU_RANG_DEP= "Eu_rang_dep";
	//可见范围
	public static final String EU_RANG_VIS= "Eu_rang_vis";
	//科室
	public static final String ID_DEP= "Id_dep";
	//有效天数
	public static final String MAX_NUM_DAY= "Max_num_day";
	//门诊标志
	public static final String FG_OP= "Fg_op";
	//住院标志
	public static final String FG_IP= "Fg_ip";
	//急诊标志
	public static final String FG_ER= "Fg_er";
	//体检标志
	public static final String FG_PE= "Fg_pe";
	//家庭病床
	public static final String FG_FM= "Fg_fm";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//背景颜色
	public static final String COLOR_BACK= "Color_back";
	//字体颜色
	public static final String COLOR_FONT= "Color_font";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_TP= "Name_tp";
	//科室编码
	public static final String CODE_DEP= "Code_dep";
	//科室名称
	public static final String NAME_DEP= "Name_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 标签id
	 * @return String
	 */
	public String getId_tagtp() {
		return ((String) getAttrVal("Id_tagtp"));
	}	
	/**
	 * 标签id
	 * @param Id_tagtp
	 */
	public void setId_tagtp(String Id_tagtp) {
		setAttrVal("Id_tagtp", Id_tagtp);
	}
	/**
	 * 集团id
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团id
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织id
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织id
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 标签类型id
	 * @return String
	 */
	public String getId_tp() {
		return ((String) getAttrVal("Id_tp"));
	}	
	/**
	 * 标签类型id
	 * @param Id_tp
	 */
	public void setId_tp(String Id_tp) {
		setAttrVal("Id_tp", Id_tp);
	}
	/**
	 * 标签类型sd
	 * @return String
	 */
	public String getSd_tp() {
		return ((String) getAttrVal("Sd_tp"));
	}	
	/**
	 * 标签类型sd
	 * @param Sd_tp
	 */
	public void setSd_tp(String Sd_tp) {
		setAttrVal("Sd_tp", Sd_tp);
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
	 * 简称
	 * @return String
	 */
	public String getShortname() {
		return ((String) getAttrVal("Shortname"));
	}	
	/**
	 * 简称
	 * @param Shortname
	 */
	public void setShortname(String Shortname) {
		setAttrVal("Shortname", Shortname);
	}
	/**
	 * 管理范围
	 * @return Integer
	 */
	public Integer getEu_rang_dep() {
		return ((Integer) getAttrVal("Eu_rang_dep"));
	}	
	/**
	 * 管理范围
	 * @param Eu_rang_dep
	 */
	public void setEu_rang_dep(Integer Eu_rang_dep) {
		setAttrVal("Eu_rang_dep", Eu_rang_dep);
	}
	/**
	 * 可见范围
	 * @return Integer
	 */
	public Integer getEu_rang_vis() {
		return ((Integer) getAttrVal("Eu_rang_vis"));
	}	
	/**
	 * 可见范围
	 * @param Eu_rang_vis
	 */
	public void setEu_rang_vis(Integer Eu_rang_vis) {
		setAttrVal("Eu_rang_vis", Eu_rang_vis);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 有效天数
	 * @return Integer
	 */
	public Integer getMax_num_day() {
		return ((Integer) getAttrVal("Max_num_day"));
	}	
	/**
	 * 有效天数
	 * @param Max_num_day
	 */
	public void setMax_num_day(Integer Max_num_day) {
		setAttrVal("Max_num_day", Max_num_day);
	}
	/**
	 * 门诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_op() {
		return ((FBoolean) getAttrVal("Fg_op"));
	}	
	/**
	 * 门诊标志
	 * @param Fg_op
	 */
	public void setFg_op(FBoolean Fg_op) {
		setAttrVal("Fg_op", Fg_op);
	}
	/**
	 * 住院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}	
	/**
	 * 住院标志
	 * @param Fg_ip
	 */
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 急诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_er() {
		return ((FBoolean) getAttrVal("Fg_er"));
	}	
	/**
	 * 急诊标志
	 * @param Fg_er
	 */
	public void setFg_er(FBoolean Fg_er) {
		setAttrVal("Fg_er", Fg_er);
	}
	/**
	 * 体检标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pe() {
		return ((FBoolean) getAttrVal("Fg_pe"));
	}	
	/**
	 * 体检标志
	 * @param Fg_pe
	 */
	public void setFg_pe(FBoolean Fg_pe) {
		setAttrVal("Fg_pe", Fg_pe);
	}
	/**
	 * 家庭病床
	 * @return FBoolean
	 */
	public FBoolean getFg_fm() {
		return ((FBoolean) getAttrVal("Fg_fm"));
	}	
	/**
	 * 家庭病床
	 * @param Fg_fm
	 */
	public void setFg_fm(FBoolean Fg_fm) {
		setAttrVal("Fg_fm", Fg_fm);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	 * 背景颜色
	 * @return String
	 */
	public String getColor_back() {
		return ((String) getAttrVal("Color_back"));
	}	
	/**
	 * 背景颜色
	 * @param Color_back
	 */
	public void setColor_back(String Color_back) {
		setAttrVal("Color_back", Color_back);
	}
	/**
	 * 字体颜色
	 * @return String
	 */
	public String getColor_font() {
		return ((String) getAttrVal("Color_font"));
	}	
	/**
	 * 字体颜色
	 * @param Color_font
	 */
	public void setColor_font(String Color_font) {
		setAttrVal("Color_font", Color_font);
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
	 * 名称
	 * @return String
	 */
	public String getName_tp() {
		return ((String) getAttrVal("Name_tp"));
	}	
	/**
	 * 名称
	 * @param Name_tp
	 */
	public void setName_tp(String Name_tp) {
		setAttrVal("Name_tp", Name_tp);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
		return "Id_tagtp";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_TAG_TP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdTagTpDODesc.class);
	}
	
}