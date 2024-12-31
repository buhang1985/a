package iih.bd.pp.incca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.incca.d.desc.IncCaDODesc;
import java.math.BigDecimal;

/**
 * 票据分类 DO数据 
 * 
 */
public class IncCaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//票据分类主键
	public static final String ID_INCCA= "Id_incca";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//票据分类编码
	public static final String CODE= "Code";
	//票据分类名称
	public static final String NAME= "Name";
	//描述
	public static final String DES= "Des";
	//票据分类使用规则
	public static final String RULES_USE= "Rules_use";
	//对应票据打印格式模板
	public static final String TEMP_INC= "Temp_inc";
	//是否拆票
	public static final String FG_SPLIT= "Fg_split";
	//拆票规则
	public static final String RULES_SPLIT= "Rules_split";
	//票据项目类型主键
	public static final String ID_INCITMTP= "Id_incitmtp";
	//票据项目类型
	public static final String SD_INCITMTP= "Sd_incitmtp";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//系统标志
	public static final String FG_SYS= "Fg_sys";
	//名称
	public static final String INCTY_NAME= "Incty_name";
	//编码
	public static final String INCTP_CODE= "Inctp_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 票据分类主键
	 * @return String
	 */
	public String getId_incca() {
		return ((String) getAttrVal("Id_incca"));
	}	
	/**
	 * 票据分类主键
	 * @param Id_incca
	 */
	public void setId_incca(String Id_incca) {
		setAttrVal("Id_incca", Id_incca);
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
	 * 票据分类编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 票据分类编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 票据分类名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 票据分类名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 票据分类使用规则
	 * @return String
	 */
	public String getRules_use() {
		return ((String) getAttrVal("Rules_use"));
	}	
	/**
	 * 票据分类使用规则
	 * @param Rules_use
	 */
	public void setRules_use(String Rules_use) {
		setAttrVal("Rules_use", Rules_use);
	}
	/**
	 * 对应票据打印格式模板
	 * @return String
	 */
	public String getTemp_inc() {
		return ((String) getAttrVal("Temp_inc"));
	}	
	/**
	 * 对应票据打印格式模板
	 * @param Temp_inc
	 */
	public void setTemp_inc(String Temp_inc) {
		setAttrVal("Temp_inc", Temp_inc);
	}
	/**
	 * 是否拆票
	 * @return FBoolean
	 */
	public FBoolean getFg_split() {
		return ((FBoolean) getAttrVal("Fg_split"));
	}	
	/**
	 * 是否拆票
	 * @param Fg_split
	 */
	public void setFg_split(FBoolean Fg_split) {
		setAttrVal("Fg_split", Fg_split);
	}
	/**
	 * 拆票规则
	 * @return String
	 */
	public String getRules_split() {
		return ((String) getAttrVal("Rules_split"));
	}	
	/**
	 * 拆票规则
	 * @param Rules_split
	 */
	public void setRules_split(String Rules_split) {
		setAttrVal("Rules_split", Rules_split);
	}
	/**
	 * 票据项目类型主键
	 * @return String
	 */
	public String getId_incitmtp() {
		return ((String) getAttrVal("Id_incitmtp"));
	}	
	/**
	 * 票据项目类型主键
	 * @param Id_incitmtp
	 */
	public void setId_incitmtp(String Id_incitmtp) {
		setAttrVal("Id_incitmtp", Id_incitmtp);
	}
	/**
	 * 票据项目类型
	 * @return String
	 */
	public String getSd_incitmtp() {
		return ((String) getAttrVal("Sd_incitmtp"));
	}	
	/**
	 * 票据项目类型
	 * @param Sd_incitmtp
	 */
	public void setSd_incitmtp(String Sd_incitmtp) {
		setAttrVal("Sd_incitmtp", Sd_incitmtp);
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
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
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
	 * 系统标志
	 * @return FBoolean
	 */
	public FBoolean getFg_sys() {
		return ((FBoolean) getAttrVal("Fg_sys"));
	}	
	/**
	 * 系统标志
	 * @param Fg_sys
	 */
	public void setFg_sys(FBoolean Fg_sys) {
		setAttrVal("Fg_sys", Fg_sys);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getIncty_name() {
		return ((String) getAttrVal("Incty_name"));
	}	
	/**
	 * 名称
	 * @param Incty_name
	 */
	public void setIncty_name(String Incty_name) {
		setAttrVal("Incty_name", Incty_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getInctp_code() {
		return ((String) getAttrVal("Inctp_code"));
	}	
	/**
	 * 编码
	 * @param Inctp_code
	 */
	public void setInctp_code(String Inctp_code) {
		setAttrVal("Inctp_code", Inctp_code);
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
		return "Id_incca";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_incca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(IncCaDODesc.class);
	}
	
}